package com.example.app_res_vuel.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.transition.TransitionInflater;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.app_res_vuel.R;
import com.example.app_res_vuel.Utils;
import com.example.app_res_vuel.activities.MainActivity;
import com.example.app_res_vuel.model.Usuario;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LoginUIFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoginUIFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private TextView btn_Login;
    private EditText txt_email;
    private EditText txt_pass;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public LoginUIFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LoginUIFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LoginUIFragment newInstance(String param1, String param2) {
        LoginUIFragment fragment = new LoginUIFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TransitionInflater inflater = TransitionInflater.from(requireContext());
        setExitTransition(inflater.inflateTransition(R.transition.fade));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login_u_i, container, false);
        this.btn_Login = view.findViewById(R.id.btn_Login);
        this.txt_email = view.findViewById(R.id.txt_username);
        this.txt_pass = (EditText) view.findViewById(R.id.txt_pass);

        this.btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String e_mail = txt_email.getText().toString().trim(), pass = txt_pass.getText().toString().trim();
                Call<Usuario> userAPI = Utils.getAPIUser().login(e_mail, pass);
                userAPI.enqueue(new Callback<Usuario>() {
                    @Override
                    public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                        if(!response.isSuccessful()) {
                            Toast.makeText(getActivity().getApplicationContext(), "ERROR " + response.code(), Toast.LENGTH_LONG).show();
                            return;
                        }
                        Usuario u = response.body();
                        Toast.makeText(getActivity().getApplicationContext(), "LOGIN SATISFACTORIO " + u.getFecha_registro(), Toast.LENGTH_LONG).show();
                        Intent i = new Intent(getActivity().getApplicationContext(), MainActivity.class);
                        i.putExtra("ID", u.getId());
                        startActivity(i);
                    }

                    @Override
                    public void onFailure(Call<Usuario> call, Throwable t) {
                        Toast.makeText(getActivity().getApplicationContext(), "ERROR " + t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
        return view;
    }
}