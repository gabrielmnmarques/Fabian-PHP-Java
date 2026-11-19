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
public class obras {
    private int idObra;
    private String Descricao;
    private Date dtInicio;
    private Date dtFim;
    private int idEngenheiro;
    private Date nrCrea;
    private Date dtDdmissaoEngenheiro;

    public int getIdObra() {
        return idObra;
    }

    public void setIdObra(int idObra) {
        this.idObra = idObra;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
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

    public int getIdEngenheiro() {
        return idEngenheiro;
    }

    public void setIdEngenheiro(int idEngenheiro) {
        this.idEngenheiro = idEngenheiro;
    }

    public Date getNrCrea() {
        return nrCrea;
    }

    public void setNrCrea(Date nrCrea) {
        this.nrCrea = nrCrea;
    }

    public Date getDtDdmissaoEngenheiro() {
        return dtDdmissaoEngenheiro;
    }

    public void setDtDdmissaoEngenheiro(Date dtDdmissaoEngenheiro) {
        this.dtDdmissaoEngenheiro = dtDdmissaoEngenheiro;
    }
    
    
}
