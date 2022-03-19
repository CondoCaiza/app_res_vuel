package com.example.app_res_vuel.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Usuario {
    private int id ;
    private String e_mail;
    private String pass;
    private String rol;
    private String estado;
    private String fecha_registro;
    private List<Reserva> reservas;

    public Usuario() {
    }

    public Usuario(String e_mail, String pass, String rol,
                   String estado, String fecha_registro) {
        this.id = id;
        this.e_mail = e_mail;
        this.pass = pass;
        this.rol = rol;
        this.estado = estado;
        this.fecha_registro = fecha_registro;
        this.reservas = new ArrayList<Reserva>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
}
