package com.example.app_res_vuel.service;

import com.example.app_res_vuel.model.Persona;

import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface IPersonaService {
    @Headers({
            "Accept: application/json",
            "Content-Type: application/json"
    })
    @GET("persona")
    Call<List<Persona>> getPersonas(@Path("id") int id);
    @Headers({
            "Accept: application/json",
            "Content-Type: application/json"
    })
    @POST("persona/add")
    Call<JSONObject> addPer(@Body Persona per);
}
