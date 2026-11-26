package model;

import java.sql.Date;

public class obras_engenheiros {

    private int idObra;
    private int idEngenheiro;
    private Date dtInicioTrabalho;
    private Date dtFimTrabalho;
    private int idFuncao;

    public int getIdObra() {
        return idObra;
    }

    public void setIdObra(int idObra) {
        this.idObra = idObra;
    }

    public int getIdEngenheiro() {
        return idEngenheiro;
    }

    public void setIdEngenheiro(int idEngenheiro) {
        this.idEngenheiro = idEngenheiro;
    }

    public Date getDtInicioTrabalho() {
        return dtInicioTrabalho;
    }

    public void setDtInicioTrabalho(Date dtInicioTrabalho) {
        this.dtInicioTrabalho = dtInicioTrabalho;
    }

    public Date getDtFimTrabalho() {
        return dtFimTrabalho;
    }

    public void setDtFimTrabalho(Date dtFimTrabalho) {
        this.dtFimTrabalho = dtFimTrabalho;
    }

    public int getIdFuncao() {
        return idFuncao;
    }

    public void setIdFuncao(int idFuncao) {
        this.idFuncao = idFuncao;
    }
}
