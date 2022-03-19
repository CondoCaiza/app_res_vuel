package com.example.app_res_vuel.viewmodel;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class PersonaUsuarioModel {
    private int id;
    private String nombre;
    private String apellido;
    private String dni;
    private int edad;
    private String telefono;
    private String ciudad;
    private String direccion;
    private String est_civil;
    private LocalDate fecha_nac;
    private String e_mail;
    private String pass;
    private String rol;
    private String estado;
    private LocalDateTime fecha_registro;
    public PersonaUsuarioModel() {
        super();
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public PersonaUsuarioModel(String nombre, String apellido, String dni, int edad, String telefono,
                               String ciudad, String direccion, String est_civil, LocalDate fecha_nac, String e_mail, String pass,
                               String rol, String estado, LocalDateTime fecha_registro) {
        super();
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.edad = edad;
        this.telefono = telefono;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.est_civil = est_civil;
        this.fecha_nac = ZonedDateTime.now(ZoneId.of("America/Guayaquil")).toLocalDate();;
        this.e_mail = e_mail;
        this.pass = pass;
        this.rol = rol;
        this.estado = estado;
        this.fecha_registro = fecha_registro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEst_civil() {
        return est_civil;
    }

    public void setEst_civil(String est_civil) {
        this.est_civil = est_civil;
    }

    public LocalDate getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(LocalDate fecha_nac) {
        this.fecha_nac = fecha_nac;
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

    public LocalDateTime getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(LocalDateTime fecha_registro) {
        this.fecha_registro = fecha_registro;
    }
}
