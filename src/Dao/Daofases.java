package Dao;

import javax.swing.JOptionPane;
import java.sql.*;
import java.util.ArrayList;
import model.fase;

public class Daofases {
    private DataSource dataSource;

    public Daofases(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public ArrayList<fase> consulta() {
        PreparedStatement ps = null;
        try {
            String SQL = "SELECT * FROM fases";
            ps = dataSource.getConnection().prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            ArrayList<fase> lista = new ArrayList<>();
            while (rs.next()) {
                fase prod = new fase();
                prod.setIdFase(rs.getInt("idFase"));
                prod.setDsFase(rs.getString("dsFase"));
                
                lista.add(prod);
            }
            ps.close();
            return lista;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO ao consultar: " + ex.getMessage());
            return null;
        }
    }

    public void incluir(fase prod) {
        PreparedStatement ps = null;
        try {
            String SQL = "INSERT INTO fases "
                       + "(idFase, dsFase) "
                       + "VALUES (?, ?)";
 
            ps = dataSource.getConnection().prepareStatement(SQL);
            ps.setInt(1, prod.getIdFase());
            ps.setString(2, prod.getDsFase()); 
            
            ps.executeUpdate(); 

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex.getMessage());
        } finally {
            dataSource.closeDataSource();
        }
    }

    public void alterar(fase prod) {
        PreparedStatement ps = null;

        try {
            String SQL = "UPDATE fases "
               + "SET dsFase=? "
               + "WHERE idFase=?";

            ps = dataSource.getConnection().prepareStatement(SQL);

            ps.setString(1, prod.getDsFase());
            ps.setInt(2, prod.getIdFase());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar: " + ex.getMessage());
        } finally {
            dataSource.closeDataSource();
        }
    }
    
     public void excluir(int codigo){
        Connection con = dataSource.getConnection();
        PreparedStatement ps = null;

        try{
            String SQL = "DELETE FROM fases WHERE (idFase=?)";

            ps = con.prepareStatement(SQL);
            ps.setInt(1, codigo);

            ps.executeUpdate();
            ps.close();

            JOptionPane.showMessageDialog(null,"Excluido com sucesso!");
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro ao excluir!\n"+ex);
        }
        finally{
            dataSource.closeDataSource();
        }
    }
    
    public ArrayList<fase> seleciona(String descricao) {
        PreparedStatement ps = null;
        try {
            String SQL = "SELECT * FROM fases WHERE dsFase LIKE ?";
            ps = dataSource.getConnection().prepareStatement(SQL);
            ps.setString(1, "%" + descricao + "%");
            
            ResultSet rs = ps.executeQuery();

            ArrayList<fase> lista = new ArrayList<>();
            while (rs.next()) {
                fase prod = new fase();
                prod.setIdFase(rs.getInt("idFase"));
                prod.setDsFase(rs.getString("dsFase"));
         
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