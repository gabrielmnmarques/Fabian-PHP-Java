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
public class orcamento {
    private int idOrcamento;
    private Date dtAprovacao;
    private int idEngenheiroResponsavel;

    public int getIdOrcamento() {
        return idOrcamento;
    }

    public void setIdOrcamento(int idOrcamento) {
        this.idOrcamento = idOrcamento;
    }

    public Date getDtAprovacao() {
        return dtAprovacao;
    }

    public void setDtAprovacao(Date dtAprovacao) {
        this.dtAprovacao = dtAprovacao;
    }

    public int getIdEngenheiroResponsavel() {
        return idEngenheiroResponsavel;
    }

    public void setIdEngenheiroResponsavel(int idEngenheiroResponsavel) {
        this.idEngenheiroResponsavel = idEngenheiroResponsavel;
    }
    
}
