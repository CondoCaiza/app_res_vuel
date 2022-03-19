package com.example.app_res_vuel.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Persona {
    private int ID;
    private String NOMBRE;
    private String APELLIDO;
    private String DNI;
    private int EDAD;
    private String TELEFONO;
    private String CIUDAD;
    private String DIRECCION;
    private String EST_CIVIL;
    private Date FECHA_REGISTRO;
    private List<Reserva> lstReservas;

    public Persona() {
    }

    public Persona(int ID, String NOMBRE, String APELLIDO, String DNI, int EDAD, String TELEFONO,
                   String CIUDAD, String DIRECCION, String EST_CIVIL, Date FECHA_REGISTRO) {
        this.ID = ID;
        this.NOMBRE = NOMBRE;
        this.APELLIDO = APELLIDO;
        this.DNI = DNI;
        this.EDAD = EDAD;
        this.TELEFONO = TELEFONO;
        this.CIUDAD = CIUDAD;
        this.DIRECCION = DIRECCION;
        this.EST_CIVIL = EST_CIVIL;
        this.FECHA_REGISTRO = FECHA_REGISTRO;
        this.lstReservas = new ArrayList<Reserva>();
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public String getAPELLIDO() {
        return APELLIDO;
    }

    public void setAPELLIDO(String APELLIDO) {
        this.APELLIDO = APELLIDO;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public int getEDAD() {
        return EDAD;
    }

    public void setEDAD(int EDAD) {
        this.EDAD = EDAD;
    }

    public String getTELEFONO() {
        return TELEFONO;
    }

    public void setTELEFONO(String TELEFONO) {
        this.TELEFONO = TELEFONO;
    }

    public String getCIUDAD() {
        return CIUDAD;
    }

    public void setCIUDAD(String CIUDAD) {
        this.CIUDAD = CIUDAD;
    }

    public String getDIRECCION() {
        return DIRECCION;
    }

    public void setDIRECCION(String DIRECCION) {
        this.DIRECCION = DIRECCION;
    }

    public String getEST_CIVIL() {
        return EST_CIVIL;
    }

    public void setEST_CIVIL(String EST_CIVIL) {
        this.EST_CIVIL = EST_CIVIL;
    }

    public Date getFECHA_REGISTRO() {
        return FECHA_REGISTRO;
    }

    public void setFECHA_REGISTRO(Date FECHA_REGISTRO) {
        this.FECHA_REGISTRO = FECHA_REGISTRO;
    }

    public List<Reserva> getLstReservas() {
        return lstReservas;
    }

    public void setLstReservas(List<Reserva> lstReservas) {
        this.lstReservas = lstReservas;
    }
}
