package com.example.app_res_vuel.service;

import com.example.app_res_vuel.model.Usuario;
import com.example.app_res_vuel.viewmodel.PersonaUsuarioModel;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface IUsuarioService {
    @GET("usuario/login?")
    Call<Usuario> login(@Query("e_mail") String e_mail, @Query("pass") String pass);
    @Headers({
            "Accept: application/json",
            "Content-Type: application/json"
    })
    @POST("usuario/add")
    Call<JSONObject> addUser(@Body PersonaUsuarioModel perUserModel);
    @GET("usuario/enviarXLSX")
    Call<JSONObject> sendXLSX(@Path("id") int idUSER);
}
