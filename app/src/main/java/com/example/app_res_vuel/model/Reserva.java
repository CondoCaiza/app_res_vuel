package com.example.app_res_vuel.model;

import java.util.Date;

public class Reserva {
    private int ID;
    private int ID_PER;
    private String TIP_EMPL;
    private String OCUPACION;
    private Date FECHA;
    private String HORA;
    private String MIEM_CIE;
    private String TARJ_CRED;
    private String OBSERVACIONES;
    private Date FECHA_REGISTRO;

    public Reserva() {
    }

    public Reserva(int ID, int ID_PER, String TIP_EMPL, String OCUPACION, Date FECHA, String HORA,
                   String MIEM_CIE, String TARJ_CRED, String OBSERVACIONES, Date FECHA_REGISTRO) {
        this.ID = ID;
        this.ID_PER = ID_PER;
        this.TIP_EMPL = TIP_EMPL;
        this.OCUPACION = OCUPACION;
        this.FECHA = FECHA;
        this.HORA = HORA;
        this.MIEM_CIE = MIEM_CIE;
        this.TARJ_CRED = TARJ_CRED;
        this.OBSERVACIONES = OBSERVACIONES;
        this.FECHA_REGISTRO = FECHA_REGISTRO;
    }

    public int getID_PER() {
        return ID_PER;
    }

    public void setID_PER(int ID_PER) {
        this.ID_PER = ID_PER;
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
}
