package model;

import java.sql.Date;

public class obras_fases {

    private int idObra;
    private int idFase;
    private Date dtInicioFase;
    private Date dtTerminoFase;

    public int getIdObra() {
        return idObra;
    }

    public void setIdObra(int idObra) {
        this.idObra = idObra;
    }

    public int getIdFase() {
        return idFase;
    }

    public void setIdFase(int idFase) {
        this.idFase = idFase;
    }

    public Date getDtInicioFase() {
        return dtInicioFase;
    }

    public void setDtInicioFase(Date dtInicioFase) {
        this.dtInicioFase = dtInicioFase;
    }

    public Date getDtTerminoFase() {
        return dtTerminoFase;
    }

    public void setDtTerminoFase(Date dtTerminoFase) {
        this.dtTerminoFase = dtTerminoFase;
    }
}
