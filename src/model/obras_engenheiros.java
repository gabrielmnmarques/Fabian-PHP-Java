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
public class obras_engenheiros {
    private int idObra;
    private int idEngenheiro;
    private Date dtAdmissaoEngenheiro;
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

    public Date getDtAdmissaoEngenheiro() {
        return dtAdmissaoEngenheiro;
    }

    public void setDtAdmissaoEngenheiro(Date dtAdmissaoEngenheiro) {
        this.dtAdmissaoEngenheiro = dtAdmissaoEngenheiro;
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
