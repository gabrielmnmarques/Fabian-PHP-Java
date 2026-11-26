
package Dao;

import javax.swing.JOptionPane;
import java.sql.*;
import java.util.ArrayList;
import model.usuarios;

public class Daousuario {

    private DataSource dataSource;

    public Daousuario(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public ArrayList<usuarios> consulta() {
        PreparedStatement ps = null;

        try {
            String SQL = "SELECT * FROM usuarios";

            ps = dataSource.getConnection().prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            ArrayList<usuarios> lista = new ArrayList<>();

            while (rs.next()) {
                usuarios prod = new usuarios();

                prod.setIdUsuario(rs.getInt("idUsuario"));
                prod.setNome(rs.getString("Nome"));
                prod.setEmail(rs.getString("Email"));
                prod.setSenha(rs.getString("Senha"));

                lista.add(prod);
            }

            ps.close();
            return lista;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO ao consultar: " + ex.getMessage());
            return null;
        }
    }

    public void incluir(usuarios prod) {
        PreparedStatement ps = null;

        try {
            String SQL = "INSERT INTO usuarios "
                       + "(idUsuario, Nome, Email, Senha) "
                       + "VALUES (?, ?, ?, ?)";

            ps = dataSource.getConnection().prepareStatement(SQL);

            ps.setInt(1, prod.getIdUsuario());
            ps.setString(2, prod.getNome());
            ps.setString(3, prod.getEmail());
            ps.setString(4, prod.getSenha());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex.getMessage());
        }
    }

    public void alterar(usuarios prod) {
        PreparedStatement ps = null;

        try {
            String SQL = "UPDATE usuarios "
                       + "SET Nome=?, Email=?, Senha=? "
                       + "WHERE idUsuario=?";

            ps = dataSource.getConnection().prepareStatement(SQL);

            ps.setString(1, prod.getNome());
            ps.setString(2, prod.getEmail());
            ps.setString(3, prod.getSenha());
            ps.setInt(4, prod.getIdUsuario());

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
            String SQL = "DELETE FROM usuarios WHERE idUsuario=?";

            ps = dataSource.getConnection().prepareStatement(SQL);
            ps.setInt(1, codigo);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex.getMessage());
        }
    }

    public ArrayList<usuarios> seleciona(String descricao) {
        PreparedStatement ps = null;

        try {
            String SQL = "SELECT * FROM usuarios WHERE Nome LIKE ?";

            ps = dataSource.getConnection().prepareStatement(SQL);
            ps.setString(1, "%" + descricao + "%");
            ResultSet rs = ps.executeQuery();

            ArrayList<usuarios> lista = new ArrayList<>();

            while (rs.next()) {
                usuarios prod = new usuarios();

                prod.setIdUsuario(rs.getInt("idUsuario"));
                prod.setNome(rs.getString("Nome"));
                prod.setEmail(rs.getString("Email"));
                prod.setSenha(rs.getString("Senha"));

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
