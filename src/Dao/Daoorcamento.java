
package Dao;

import javax.swing.JOptionPane;
import java.sql.*;
import java.util.ArrayList;
import model.orcamento;

public class Daoorcamento {

    private DataSource dataSource;

    public Daoorcamento(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public ArrayList<orcamento> consulta() {
        PreparedStatement ps = null;

        try {
            String SQL = "SELECT * FROM orcamentos";

            ps = dataSource.getConnection().prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            ArrayList<orcamento> lista = new ArrayList<>();

            while (rs.next()) {
                orcamento prod = new orcamento();

                prod.setIdOrcamento(rs.getInt("idOrcamento"));
                prod.setDtAprovacao(rs.getDate("dtAprovacao"));
                prod.setIdEngenheiroResponsavel(rs.getInt("idEngenheiroResponsavel"));

                lista.add(prod);
            }

            ps.close();
            return lista;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO ao consultar: " + ex.getMessage());
            return null;
        }
    }

    public void incluir(orcamento prod) {
        PreparedStatement ps = null;

        try {
            String SQL = "INSERT INTO orcamentos "
                       + "(idOrcamento, dtAprovacao, idEngenheiroResponsavel) "
                       + "VALUES (?, ?, ?)";

            ps = dataSource.getConnection().prepareStatement(SQL);

            ps.setInt(1, prod.getIdOrcamento());
            ps.setDate(2, prod.getDtAprovacao());
            ps.setInt(3, prod.getIdEngenheiroResponsavel());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex.getMessage());
        }
    }

    public void alterar(orcamento prod) {
        PreparedStatement ps = null;

        try {
            String SQL = "UPDATE orcamentos "
                       + "SET dtAprovacao=?, idEngenheiroResponsavel=? "
                       + "WHERE idOrcamento=?";

            ps = dataSource.getConnection().prepareStatement(SQL);

            ps.setDate(1, prod.getDtAprovacao());
            ps.setInt(2, prod.getIdEngenheiroResponsavel());
            ps.setInt(3, prod.getIdOrcamento());

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
            String SQL = "DELETE FROM orcamentos WHERE idOrcamento=?";

            ps = dataSource.getConnection().prepareStatement(SQL);
            ps.setInt(1, codigo);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex.getMessage());
        }
    }

    public ArrayList<orcamento> seleciona(String descricao) {
        PreparedStatement ps = null;

        try {
            String SQL = "SELECT * FROM orcamentos WHERE dtAprovacao LIKE ?";

            ps = dataSource.getConnection().prepareStatement(SQL);

            ps.setString(1, "%" + descricao + "%");

            ResultSet rs = ps.executeQuery();

            ArrayList<orcamento> lista = new ArrayList<>();

            while (rs.next()) {
                orcamento prod = new orcamento();

                prod.setIdOrcamento(rs.getInt("idOrcamento"));
                prod.setDtAprovacao(rs.getDate("dtAprovacao"));
                prod.setIdEngenheiroResponsavel(rs.getInt("idEngenheiroResponsavel"));

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
