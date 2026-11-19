/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author gabriel.marques
 */
public class obras_fases {
    private int idObra;
    private int idFase;
    private Date dtIniciofase;
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

    public Date getDtIniciofase() {
        return dtIniciofase;
    }

    public void setDtIniciofase(Date dtIniciofase) {
        this.dtIniciofase = dtIniciofase;
    }

    public Date getDtTerminoFase() {
        return dtTerminoFase;
    }

    public void setDtTerminoFase(Date dtTerminoFase) {
        this.dtTerminoFase = dtTerminoFase;
    }

    
}
