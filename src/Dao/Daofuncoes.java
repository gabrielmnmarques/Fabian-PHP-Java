
package Dao;

import javax.swing.JOptionPane;
import java.sql.*;
import java.util.ArrayList;
import model.funcoes;

public class Daofuncoes {

    private DataSource dataSource;

    public Daofuncoes(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public ArrayList<funcoes> consulta() {
        PreparedStatement ps = null;

        try {
            String SQL = "SELECT * FROM funcoes";

            ps = dataSource.getConnection().prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            ArrayList<funcoes> lista = new ArrayList<>();

            while (rs.next()) {
                funcoes prod = new funcoes();

                prod.setIdFuncao(rs.getInt("idFuncao"));
                prod.setDsFuncao(rs.getString("dsFuncao"));

                lista.add(prod);
            }

            ps.close();
            return lista;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO ao consultar: " + ex.getMessage());
            return null;
        }
    }

    public void incluir(funcoes prod) {
        PreparedStatement ps = null;

        try {
            String SQL = "INSERT INTO funcoes "
                       + "(idFuncao, dsFuncao) "
                       + "VALUES (?, ?)";

            ps = dataSource.getConnection().prepareStatement(SQL);

            ps.setInt(1, prod.getIdFuncao());
            ps.setString(2, prod.getDsFuncao());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex.getMessage());
        }
    }

    public void alterar(funcoes prod) {
        PreparedStatement ps = null;

        try {
            String SQL = "UPDATE funcoes "
                       + "SET dsFuncao=? "
                       + "WHERE idFuncao=?";

            ps = dataSource.getConnection().prepareStatement(SQL);

            ps.setString(1, prod.getDsFuncao());
            ps.setInt(2, prod.getIdFuncao());

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
            String SQL = "DELETE FROM funcoes WHERE idFuncao=?";

            ps = dataSource.getConnection().prepareStatement(SQL);
            ps.setInt(1, codigo);

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex.getMessage());
        }
    }

    public ArrayList<funcoes> seleciona(String descricao) {
        PreparedStatement ps = null;

        try {
            String SQL = "SELECT * FROM funcoes WHERE dsFuncao LIKE ?";

            ps = dataSource.getConnection().prepareStatement(SQL);
            ps.setString(1, "%" + descricao + "%");

            ResultSet rs = ps.executeQuery();

            ArrayList<funcoes> lista = new ArrayList<>();

            while (rs.next()) {
                funcoes prod = new funcoes();

                prod.setIdFuncao(rs.getInt("idFuncao"));
                prod.setDsFuncao(rs.getString("dsFuncao"));

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
