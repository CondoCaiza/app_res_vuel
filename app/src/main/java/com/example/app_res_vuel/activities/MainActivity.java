package com.example.app_res_vuel.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.app_res_vuel.R;
import com.example.app_res_vuel.adapter.PersonaAdapter;
import com.example.app_res_vuel.model.Persona;
import com.example.app_res_vuel.service.APIClient;
import com.example.app_res_vuel.service.IPersonaService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private List<Persona> personaS;
    private PersonaAdapter perAdapter;
    private RecyclerView recView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.recView=(RecyclerView) findViewById(R.id.recvPersonas);
        this.recView.setLayoutManager(new LinearLayoutManager(this));
        perAdapter=new PersonaAdapter(null, this);
        //perAdapter.setClickListener(this);
        recView.setAdapter(perAdapter);
        //Call<List<Persona>> lstPer = APIClient.getPersonas().getPersonas();
    }

    private void getPersonas() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://172.30.2.155:8060/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        IPersonaService iperServ = retrofit.create(IPersonaService.class);
        Call<List<Persona>> call = iperServ.getPersonas(1);
        call.enqueue(new Callback<List<Persona>>() {
            @Override
            public void onResponse(Call<List<Persona>> call, Response<List<Persona>> response) {
                if(!response.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "" + response.code(), Toast.LENGTH_SHORT).show();
                }
                personaS=response.body();
            }

            @Override
            public void onFailure(Call<List<Persona>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}