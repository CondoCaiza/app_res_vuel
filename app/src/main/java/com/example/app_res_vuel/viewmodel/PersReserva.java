package com.example.app_res_vuel.viewmodel;

import java.util.Date;

public class PersReserva {
    private int ID;
    private String NOMBRE;
    private String APELLIDO;
    private String DNI;
    private int EDAD;
    private String TELEFONO;
    private String CIUDAD;
    private String DIRECCION;
    private String EST_CIVIL;
    private String TIP_EMPL;
    private String OCUPACION;
    private Date FECHA;
    private String HORA;
    private String MIEM_CIE;
    private String TARJ_CRED;
    private String OBSERVACIONES;
    private Date FECHA_REGISTRO;

    public PersReserva() {
    }

    public PersReserva(int ID, String NOMBRE, String APELLIDO, String DNI, int EDAD,
                       String TELEFONO, String CIUDAD, String DIRECCION, String EST_CIVIL,
                       String TIP_EMPL, String OCUPACION, Date FECHA, String HORA, String MIEM_CIE,
                       String TARJ_CRED, String OBSERVACIONES, Date FECHA_REGISTRO) {
        this.ID = ID;
        this.NOMBRE = NOMBRE;
        this.APELLIDO = APELLIDO;
        this.DNI = DNI;
        this.EDAD = EDAD;
        this.TELEFONO = TELEFONO;
        this.CIUDAD = CIUDAD;
        this.DIRECCION = DIRECCION;
        this.EST_CIVIL = EST_CIVIL;
        this.TIP_EMPL = TIP_EMPL;
        this.OCUPACION = OCUPACION;
        this.FECHA = FECHA;
        this.HORA = HORA;
        this.MIEM_CIE = MIEM_CIE;
        this.TARJ_CRED = TARJ_CRED;
        this.OBSERVACIONES = OBSERVACIONES;
        this.FECHA_REGISTRO = FECHA_REGISTRO;
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

    public String getTIP_EMPL() {
        return TIP_EMPL;
    }

    public void setTIP_EMPL(String TIP_EMPL) {
        this.TIP_EMPL = TIP_EMPL;
    }

    public String getOCUPACION() {
        return OCUPACION;
    }

    public void setOCUPACION(String OCUPACION) {
        this.OCUPACION = OCUPACION;
    }

    public Date getFECHA() {
        return FECHA;
    }

    public void setFECHA(Date FECHA) {
        this.FECHA = FECHA;
    }

    public String getHORA() {
        return HORA;
    }

    public void setHORA(String HORA) {
        this.HORA = HORA;
    }

    public String getMIEM_CIE() {
        return MIEM_CIE;
    }

    public void setMIEM_CIE(String MIEM_CIE) {
        this.MIEM_CIE = MIEM_CIE;
    }

    public String getTARJ_CRED() {
        return TARJ_CRED;
    }

    public void setTARJ_CRED(String TARJ_CRED) {
        this.TARJ_CRED = TARJ_CRED;
    }

    public String getOBSERVACIONES() {
        return OBSERVACIONES;
    }

    public void setOBSERVACIONES(String OBSERVACIONES) {
        this.OBSERVACIONES = OBSERVACIONES;
    }

    public Date getFECHA_REGISTRO() {
        return FECHA_REGISTRO;
    }

    public void setFECHA_REGISTRO(Date FECHA_REGISTRO) {
        this.FECHA_REGISTRO = FECHA_REGISTRO;
    }
}
