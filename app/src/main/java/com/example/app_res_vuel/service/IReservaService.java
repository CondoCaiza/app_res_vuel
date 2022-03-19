package com.example.app_res_vuel.service;

import com.example.app_res_vuel.model.Reserva;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface IReservaService {
    @GET("reserva/find/{id}")
    Call<Reserva> getReservas();
    @POST("reserva/add/{id}")
    Call<JSONObject> addReserva(@Path("id") int id, @Body Reserva reser);
}
