package model;

import java.sql.Date;

public class orcamentos_obras {

    private int idOrcamento;
    private int idObra;
    private Date dtInicio;
    private Date dtFim;
    private double vlPrevisto;
    private double vlRealizado;

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

    public double getVlPrevisto() {
        return vlPrevisto;
    }

    public void setVlPrevisto(double vlPrevisto) {
        this.vlPrevisto = vlPrevisto;
    }

    public double getVlRealizado() {
        return vlRealizado;
    }

    public void setVlRealizado(double vlRealizado) {
        this.vlRealizado = vlRealizado;
    }
}
