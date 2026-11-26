package model;

import java.sql.Date;

public class obras {
    
    private int idObra;
    private String Descricao;
    private Date dtInicio;
    private Date dtFim;
    private int idEngenehrio;

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

    public int getIdEngenehrio() {
        return idEngenehrio;
    }

    public void setIdEngenehrio(int idEngenehrio) {
        this.idEngenehrio = idEngenehrio;
    }
    
    
    
}
