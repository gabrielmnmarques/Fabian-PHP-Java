
package Dao;

import javax.swing.JOptionPane;
import java.sql.*;
import java.util.ArrayList;
import model.engenheiro;


public class Daoengenheiros {

    private DataSource dataSource;

    public Daoengenheiros(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public ArrayList<engenheiro> consulta() {
        PreparedStatement ps = null;

        try {
            String SQL = "SELECT * FROM engenheiros";

            ps = dataSource.getConnection().prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            ArrayList<engenheiro> lista = new ArrayList<>();

            while (rs.next()) {
                engenheiro prod = new engenheiro();

                prod.setIdEngenheiro(rs.getInt("idEngenheiro"));
                prod.setDsNome(rs.getString("dsNome"));
                prod.setNrCREA(rs.getString("nrCREA"));
                prod.setDtAdmissao(rs.getDate("dtAdmissao"));

                lista.add(prod);
            }

            ps.close();
            return lista;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO ao consultar: " + ex.getMessage());
            return null;
        }
    }

    public void incluir(engenheiro prod) {
        PreparedStatement ps = null;

        try {
            String SQL = "INSERT INTO engenheiros "
                       + "(idEngenheiro, dsNome, nrCREA, dtAdmissao) "
                       + "VALUES (?, ?, ?, ?)";

            ps = dataSource.getConnection().prepareStatement(SQL);

            ps.setInt(1, prod.getIdEngenheiro());
            ps.setString(2, prod.getDsNome());
            ps.setString(3, prod.getNrCREA());
            ps.setDate(4, prod.getDtAdmissao());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex.getMessage());
        }
    }

    public void alterar(engenheiro prod) {
        PreparedStatement ps = null;

        try {
            String SQL = "UPDATE engenheiros "
                       + "SET dsNome=?, nrCREA=?, dtAdmissao=? "
                       + "WHERE idEngenheiro=?";

            ps = dataSource.getConnection().prepareStatement(SQL);

            ps.setString(1, prod.getDsNome());
            ps.setString(2, prod.getNrCREA());
            ps.setDate(3, prod.getDtAdmissao());
            ps.setInt(4, prod.getIdEngenheiro());

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
            String SQL = "DELETE FROM engenheiros WHERE idEngenheiro=?";

            ps = dataSource.getConnection().prepareStatement(SQL);

            ps.setInt(1, codigo);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex.getMessage());
        }
    }

    public ArrayList<engenheiro> seleciona(String descricao) {
        PreparedStatement ps = null;

        try {
            String SQL = "SELECT * FROM engenheiros WHERE dsNome LIKE ?";

            ps = dataSource.getConnection().prepareStatement(SQL);

            ps.setString(1, "%" + descricao + "%");

            ResultSet rs = ps.executeQuery();

            ArrayList<engenheiro> lista = new ArrayList<>();

            while (rs.next()) {
                engenheiro prod = new engenheiro();

                prod.setIdEngenheiro(rs.getInt("idEngenheiro"));
                prod.setDsNome(rs.getString("dsNome"));
                prod.setNrCREA(rs.getString("nrCREA"));
                prod.setDtAdmissao(rs.getDate("dtAdmissao"));

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
