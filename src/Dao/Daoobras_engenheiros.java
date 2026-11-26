package Dao;

import javax.swing.JOptionPane;
import java.sql.*;
import java.util.ArrayList;
import model.obras_engenheiros;

public class Daoobras_engenheiros {

    private DataSource dataSource;

    public Daoobras_engenheiros(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public ArrayList<obras_engenheiros> consulta() {
        PreparedStatement ps = null;
        try {
            String SQL = "SELECT * FROM obras_engenheiros";
            ps = dataSource.getConnection().prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            ArrayList<obras_engenheiros> lista = new ArrayList<>();
            while (rs.next()) {
                obras_engenheiros prod = new obras_engenheiros();
                prod.setIdObra(rs.getInt("idObra"));
                prod.setIdEngenheiro(rs.getInt("idEngenheiro"));
                prod.setDtInicioTrabalho(rs.getDate("dtInicioTrabalho"));
                prod.setDtFimTrabalho(rs.getDate("dtFimTrabalho"));
                prod.setIdFuncao(rs.getInt("idFuncao"));

                lista.add(prod);
            }
            ps.close();
            return lista;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO ao consultar: " + ex.getMessage());
            return null;
        }
    }

    public void incluir(obras_engenheiros prod) {
        PreparedStatement ps = null;
        try {
            String SQL = "INSERT INTO obras_engenheiros "
                       + "(idObra, idEngenheiro, dtInicioTrabalho, dtFimTrabalho, idFuncao) "
                       + "VALUES (?, ?, ?, ?, ?)";

            ps = dataSource.getConnection().prepareStatement(SQL);
            ps.setInt(1, prod.getIdObra());
            ps.setInt(2, prod.getIdEngenheiro());
            ps.setDate(3, prod.getDtInicioTrabalho());
            ps.setDate(4, prod.getDtFimTrabalho());
            ps.setInt(5, prod.getIdFuncao());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex.getMessage());
        }
    }

    public void alterar(obras_engenheiros prod) {
        PreparedStatement ps = null;
        try {
            String SQL = "UPDATE obras_engenheiros "
                       + "SET dtInicioTrabalho=?, dtFimTrabalho=?, idFuncao=? "
                       + "WHERE idObra=? AND idEngenheiro=?";

            ps = dataSource.getConnection().prepareStatement(SQL);
            ps.setDate(1, prod.getDtInicioTrabalho());
            ps.setDate(2, prod.getDtFimTrabalho());
            ps.setInt(3, prod.getIdFuncao());
            ps.setInt(4, prod.getIdObra());
            ps.setInt(5, prod.getIdEngenheiro());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar: " + ex.getMessage());
        }
    }

    public void excluir(int idObra, int idEngenheiro) {
        PreparedStatement ps = null;
        try {
            String SQL = "DELETE FROM obras_engenheiros WHERE idObra=? AND idEngenheiro=?";

            ps = dataSource.getConnection().prepareStatement(SQL);
            ps.setInt(1, idObra);
            ps.setInt(2, idEngenheiro);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex.getMessage());
        }
    }
}
