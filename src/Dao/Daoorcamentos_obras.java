package Dao;

import javax.swing.JOptionPane;
import java.sql.*;
import java.util.ArrayList;
import model.orcamentos_obras;

public class Daoorcamentos_obras {

    private DataSource dataSource;

    public Daoorcamentos_obras(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public ArrayList<orcamentos_obras> consulta() {
        PreparedStatement ps = null;
        try {
            String SQL = "SELECT * FROM orcamentos_obras";
            ps = dataSource.getConnection().prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            ArrayList<orcamentos_obras> lista = new ArrayList<>();
            while (rs.next()) {
                orcamentos_obras prod = new orcamentos_obras();
                prod.setIdOrcamento(rs.getInt("idOrcamento"));
                prod.setIdObra(rs.getInt("idObra"));
                prod.setDtInicio(rs.getDate("dtInicio"));
                prod.setDtFim(rs.getDate("dtFim"));
                prod.setVlPrevisto(rs.getDouble("vlPrevisto"));
                prod.setVlRealizado(rs.getDouble("vlRealizado"));

                lista.add(prod);
            }
            ps.close();
            return lista;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO ao consultar: " + ex.getMessage());
            return null;
        }
    }

    public void incluir(orcamentos_obras prod) {
        PreparedStatement ps = null;
        try {
            String SQL = "INSERT INTO orcamentos_obras "
                       + "(idOrcamento, idObra, dtInicio, dtFim, vlPrevisto, vlRealizado) "
                       + "VALUES (?, ?, ?, ?, ?, ?)";

            ps = dataSource.getConnection().prepareStatement(SQL);
            ps.setInt(1, prod.getIdOrcamento());
            ps.setInt(2, prod.getIdObra());
            ps.setDate(3, prod.getDtInicio());
            ps.setDate(4, prod.getDtFim());
            ps.setDouble(5, prod.getVlPrevisto());
            ps.setDouble(6, prod.getVlRealizado());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex.getMessage());
        }
    }

    public void alterar(orcamentos_obras prod) {
        PreparedStatement ps = null;
        try {
            String SQL = "UPDATE orcamentos_obras "
                       + "SET dtInicio=?, dtFim=?, vlPrevisto=?, vlRealizado=? "
                       + "WHERE idOrcamento=? AND idObra=?";

            ps = dataSource.getConnection().prepareStatement(SQL);
            ps.setDate(1, prod.getDtInicio());
            ps.setDate(2, prod.getDtFim());
            ps.setDouble(3, prod.getVlPrevisto());
            ps.setDouble(4, prod.getVlRealizado());
            ps.setInt(5, prod.getIdOrcamento());
            ps.setInt(6, prod.getIdObra());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar: " + ex.getMessage());
        }
    }

    public void excluir(int idOrcamento, int idObra) {
        PreparedStatement ps = null;
        try {
            String SQL = "DELETE FROM orcamentos_obras WHERE idOrcamento=? AND idObra=?";

            ps = dataSource.getConnection().prepareStatement(SQL);
            ps.setInt(1, idOrcamento);
            ps.setInt(2, idObra);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex.getMessage());
        }
    }
}
