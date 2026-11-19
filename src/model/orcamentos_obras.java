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
public class orcamentos_obras {
    private int idOrcamento;
    private int idObra;
    private Date dtInicio;
    private Date dtFim;
    private String vlPrevisto;
    private String vlRealizado;

    public int getIdOrcamento() {
        return idOrcamento;
    }

    public void setIdOrcamento(int idOrcamento) {
        this.idOrcamento = idOrcamento;
    }

    public int getIdObra() {
        return idObra;
    }

    public void setIdObra(int idObra) {
        this.idObra = idObra;
    }

    public Date getDtInicio() {
        return dtInicio;
    }

    public void setDtInicio(Date dtInicio) {
        this.dtInicio = dtInicio;
    }

    public Date getDtFim() {
        return dtFim;
    }

    public void setDtFim(Date dtFim) {
        this.dtFim = dtFim;
    }

    public String getVlPrevisto() {
        return vlPrevisto;
    }

    public void setVlPrevisto(String vlPrevisto) {
        this.vlPrevisto = vlPrevisto;
    }

    public String getVlRealizado() {
        return vlRealizado;
    }

    public void setVlRealizado(String vlRealizado) {
        this.vlRealizado = vlRealizado;
    }
    
    
}
