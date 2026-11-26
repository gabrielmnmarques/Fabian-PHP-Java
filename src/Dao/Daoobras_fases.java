package Dao;

import javax.swing.JOptionPane;
import java.sql.*;
import java.util.ArrayList;
import model.obras_fases;

public class Daoobras_fases {

    private DataSource dataSource;

    public Daoobras_fases(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public ArrayList<obras_fases> consulta() {
        PreparedStatement ps = null;
        try {
            String SQL = "SELECT * FROM obras_fases";
            ps = dataSource.getConnection().prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            ArrayList<obras_fases> lista = new ArrayList<>();
            while (rs.next()) {
                obras_fases prod = new obras_fases();
                prod.setIdObra(rs.getInt("idObra"));
                prod.setIdFase(rs.getInt("idFase"));
                prod.setDtInicioFase(rs.getDate("dtInicioFase"));
                prod.setDtTerminoFase(rs.getDate("dtTerminoFase"));

                lista.add(prod);
            }
            ps.close();
            return lista;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO ao consultar: " + ex.getMessage());
            return null;
        }
    }

    public void incluir(obras_fases prod) {
        PreparedStatement ps = null;
        try {
            String SQL = "INSERT INTO obras_fases "
                       + "(idObra, idFase, dtInicioFase, dtTerminoFase) "
                       + "VALUES (?, ?, ?, ?)";

            ps = dataSource.getConnection().prepareStatement(SQL);
            ps.setInt(1, prod.getIdObra());
            ps.setInt(2, prod.getIdFase());
            ps.setDate(3, prod.getDtInicioFase());
            ps.setDate(4, prod.getDtTerminoFase());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex.getMessage());
        }
    }

    public void alterar(obras_fases prod) {
        PreparedStatement ps = null;
        try {
            String SQL = "UPDATE obras_fases "
                       + "SET dtInicioFase=?, dtTerminoFase=? "
                       + "WHERE idObra=? AND idFase=?";

            ps = dataSource.getConnection().prepareStatement(SQL);
            ps.setDate(1, prod.getDtInicioFase());
            ps.setDate(2, prod.getDtTerminoFase());
            ps.setInt(3, prod.getIdObra());
            ps.setInt(4, prod.getIdFase());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar: " + ex.getMessage());
        }
    }

    public void excluir(int idObra, int idFase) {
        PreparedStatement ps = null;
        try {
            String SQL = "DELETE FROM obras_fases WHERE idObra=? AND idFase=?";

            ps = dataSource.getConnection().prepareStatement(SQL);
            ps.setInt(1, idObra);
            ps.setInt(2, idFase);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex.getMessage());
        }
    }
}
