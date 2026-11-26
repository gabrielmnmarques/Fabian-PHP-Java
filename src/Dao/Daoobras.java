
package Dao;

import javax.swing.JOptionPane;
import java.sql.*;
import java.util.ArrayList;
import model.obras;

public class Daoobras {

    private DataSource dataSource;

    public Daoobras(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public ArrayList<obras> consulta() {
        PreparedStatement ps = null;

        try {
            String SQL = "SELECT * FROM obras";

            ps = dataSource.getConnection().prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            ArrayList<obras> lista = new ArrayList<>();

            while (rs.next()) {
                obras prod = new obras();

                prod.setIdObra(rs.getInt("idObra"));
                prod.setDescricao(rs.getString("descricao"));
                prod.setDtInicio(rs.getDate("dtInicio"));
                prod.setDtFim(rs.getDate("dtFim"));
                prod.setIdEngenehrio(rs.getInt("idEngenehrio"));

                lista.add(prod);
            }

            ps.close();
            return lista;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO ao consultar: " + ex.getMessage());
            return null;
        }
    }

    public void incluir(obras prod) {
        PreparedStatement ps = null;

        try {
            String SQL = "INSERT INTO obras "
                       + "(idObra, descricao, dtInicio, dtFim, idEngenehrio) "
                       + "VALUES (?, ?, ?, ?, ?)";

            ps = dataSource.getConnection().prepareStatement(SQL);

            ps.setInt(1, prod.getIdObra());
            ps.setString(2, prod.getDescricao());
            ps.setDate(3, prod.getDtInicio());
            ps.setDate(4, prod.getDtFim());
            ps.setInt(5, prod.getIdEngenehrio());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex.getMessage());
        }
    }

    public void alterar(obras prod) {
        PreparedStatement ps = null;

        try {
            String SQL = "UPDATE obras "
                       + "SET descricao=?, dtInicio=?, dtFim=?, idEngenehrio=? "
                       + "WHERE idObra=?";

            ps = dataSource.getConnection().prepareStatement(SQL);

            ps.setString(1, prod.getDescricao());
            ps.setDate(2, prod.getDtInicio());
            ps.setDate(3, prod.getDtFim());
            ps.setInt(4, prod.getIdEngenehrio());
            ps.setInt(5, prod.getIdObra());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar: " + ex.getMessage());
        }
    }

    public void excluir(int codigo) {
        PreparedStatement ps = null;

        try {
            String SQL = "DELETE FROM obras WHERE idObra=?";

            ps = dataSource.getConnection().prepareStatement(SQL);
            ps.setInt(1, codigo);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex.getMessage());
        }
    }

    public ArrayList<obras> seleciona(String descricao) {
        PreparedStatement ps = null;

        try {
            String SQL = "SELECT * FROM obras WHERE descricao LIKE ?";

            ps = dataSource.getConnection().prepareStatement(SQL);

            ps.setString(1, "%" + descricao + "%");

            ResultSet rs = ps.executeQuery();

            ArrayList<obras> lista = new ArrayList<>();

            while (rs.next()) {
                obras prod = new obras();

                prod.setIdObra(rs.getInt("idObra"));
                prod.setDescricao(rs.getString("descricao"));
                prod.setDtInicio(rs.getDate("dtInicio"));
                prod.setDtFim(rs.getDate("dtFim"));
                prod.setIdEngenehrio(rs.getInt("idEngenehrio"));

                lista.add(prod);
            }

            ps.close();
            return lista;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO ao consultar: " + ex.getMessage());
            return null;
        }
    }
}
