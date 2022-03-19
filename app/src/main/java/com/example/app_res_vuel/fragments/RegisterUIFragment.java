package com.example.app_res_vuel.fragments;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.transition.TransitionInflater;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.app_res_vuel.R;
import com.example.app_res_vuel.Utils;
import com.example.app_res_vuel.viewmodel.PersonaUsuarioModel;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RegisterUIFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegisterUIFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private TextView btn_Registrar;
    private EditText txt_nombre;
    private EditText txt_apellido;
    private EditText txt_dni;
    private EditText txt_edad;
    private EditText txt_telefono;
    private EditText txt_ciudad;
    private EditText txt_direccion;
    private String RESestcivil;
    private EditText txt_fecha_nac;
    private EditText txt_e_mail;
    private EditText txt_pass;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RegisterUIFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RegisterUIFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RegisterUIFragment newInstance(String param1, String param2) {
        RegisterUIFragment fragment = new RegisterUIFragment();
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
        setExitTransition(inflater.inflateTransition(R.transition.slide_right));
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viewRoot = inflater.inflate(R.layout.fragment_register_u_i, container, false);
        Spinner spinner = (Spinner) viewRoot.findViewById(R.id.spinner_estadCivil);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.estado_civil, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        this.btn_Registrar = (TextView) viewRoot.findViewById(R.id.btn_Registrar);
        this.txt_nombre = (EditText) viewRoot.findViewById(R.id.txt_nombre);
        this.txt_apellido = (EditText) viewRoot.findViewById(R.id.txt_apellido);
        this.txt_dni = (EditText) viewRoot.findViewById(R.id.txt_dni);
        this.txt_telefono = (EditText) viewRoot.findViewById(R.id.txt_telefono);
        this.txt_edad = (EditText) viewRoot.findViewById(R.id.txt_edad);
        this.txt_direccion = (EditText) viewRoot.findViewById(R.id.txt_direccion);
        this.txt_ciudad = (EditText) viewRoot.findViewById(R.id.txt_ciudad);
        this.txt_e_mail = (EditText) viewRoot.findViewById(R.id.txt_email);
        this.txt_pass = (EditText) viewRoot.findViewById(R.id.txt_pass);
        this.txt_fecha_nac = (EditText) viewRoot.findViewById(R.id.txt_fecha_nac);
        final Calendar c = Calendar.getInstance();
        int dia = c.get(Calendar.DAY_OF_MONTH), mes = c.get(Calendar.DAY_OF_MONTH),
                anio = c.get(Calendar.YEAR);
        this.txt_fecha_nac.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b) {
                    final Calendar c = Calendar.getInstance();
                    int dia = c.get(Calendar.DAY_OF_MONTH), mes = c.get(Calendar.DAY_OF_MONTH),
                            anio = c.get(Calendar.YEAR);
                    DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),
                            new DatePickerDialog.OnDateSetListener() {
                                @Override
                                public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                                    txt_fecha_nac.setText("" + year + "-" + monthOfYear + "-" + dayOfMonth);
                                }
                            },anio,mes,dia);
                    datePickerDialog.show();
                }
            }
        });
        DateTimeFormatter dtForm = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        LocalDateTime dt = LocalDateTime.now();
        Toast.makeText(getActivity().getApplicationContext(), "" +dt.format(dtForm), Toast.LENGTH_SHORT).show();
        this.btn_Registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PersonaUsuarioModel peruser = new PersonaUsuarioModel();
                String nombre = txt_nombre.getText().toString().trim(), apellido = txt_apellido.getText().toString().trim(),
                        dni = txt_dni.getText().toString().trim(), telefono = txt_telefono.getText().toString().trim(),
                        ciudad = txt_ciudad.getText().toString().trim(), direccion = txt_direccion.getText().toString().trim();
                String e_mail = txt_e_mail.getText().toString().trim(), pass = txt_pass.getText().toString(), rol = "Usuario",
                        estado = "Habilitado";
                int edad = Integer.parseInt(txt_edad.getText().toString());
                DateTimeFormatter dtForm = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
                ZoneId zid = ZoneId.of("America/Guayaquil");
                LocalDateTime dt = LocalDateTime.now(zid);
                //Instant instant = dt.atZone(ZoneId.of("America/Guayaquil")).toInstant();
                String fecha_reg =dt.format(dtForm);
                //String fecha_reg =instant.toString();
                LocalDateTime fecha_registro = LocalDateTime.parse(fecha_reg);
                //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                //ZonedDateTime zonedDateTime = ZonedDateTime.parse("");
                SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                String fecha_n = null;
                try {
                    Date f = df.parse(txt_fecha_nac.getText().toString().trim());
                    fecha_n = df.format(f);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                LocalDate fecha_nac = LocalDate.parse(fecha_n);
                peruser.setNombre(nombre);
                peruser.setApellido(apellido);
                peruser.setDni(dni);
                peruser.setTelefono(telefono);
                peruser.setEst_civil(RESestcivil);
                peruser.setEdad(edad);
                peruser.setCiudad(ciudad);
                peruser.setFecha_nac(fecha_nac);
                peruser.setE_mail(e_mail);
                peruser.setPass(pass);
                peruser.setRol(rol);
                peruser.setEstado(estado);
                peruser.setDireccion(direccion);
                peruser.setFecha_registro(fecha_registro);
                Call<JSONObject> addPers = Utils.getAPIUser().addUser(peruser);
                addPers.enqueue(new Callback<JSONObject>() {
                    @Override
                    public void onResponse(Call<JSONObject> call, Response<JSONObject> response) {
                        if(!response.isSuccessful()) {
                            Toast.makeText(getActivity().getApplicationContext(), "ERROR" + response.message(), Toast.LENGTH_SHORT).show();
                            return;
                        }
                        JSONObject res = response.body();
                        try {
                            Toast.makeText(getActivity().getApplicationContext(), "INSERTADO SATISFACTORIAMENTE" + res.getString("message"), Toast.LENGTH_SHORT).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(Call<JSONObject> call, Throwable t) {
                        Toast.makeText(getActivity().getApplicationContext(), "ERROR" + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        return viewRoot;
    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String text = adapterView.getItemAtPosition(i).toString();
        RESestcivil = text;
        Toast.makeText(adapterView.getContext(), "" + RESestcivil, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}