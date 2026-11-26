package model;

import java.sql.Date;

public class engenheiro {
    
    private int idEngenheiro;
    private String dsNome;
    private String  nrCREA;
    private Date dtAdmissao;

    public int getIdEngenheiro() {
        return idEngenheiro;
    }

    public void setIdEngenheiro(int idEngenheiro) {
        this.idEngenheiro = idEngenheiro;
    }

    public String getDsNome() {
        return dsNome;
    }

    public void setDsNome(String dsNome) {
        this.dsNome = dsNome;
    }

    public String getNrCREA() {
        return nrCREA;
    }

    public void setNrCREA(String nrCREA) {
        this.nrCREA = nrCREA;
    }

    public Date getDtAdmissao() {
        return dtAdmissao;
    }

    public void setDtAdmissao(Date dtAdmissao) {
        this.dtAdmissao = dtAdmissao;
    }
    
    
    
}
