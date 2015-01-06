/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesDAO;

import Classes.Familia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Tiago
 */
public class FamiliaDAO implements Map<Integer,Familia>{

    public FamiliaDAO() {
    }

    @Override
    public int size() {
        int res = 0;
        try {
            Statement stm = ConexaoBD.getConexao().createStatement();
            String sql = "SELECT * FROM test.Familia";
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                res++;
            }
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {}
        return res;
    }

    @Override
    public boolean isEmpty() {
        boolean res = false;
        try {
            Statement stm = ConexaoBD.getConexao().createStatement();
            String sql = "SELECT * FROM Familia";// where donativo=" + this.id;
            ResultSet rs = stm.executeQuery(sql);
            if(!rs.next())
                res=true;
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return res;
    }

    @Override
    public boolean containsKey(Object key) {
        boolean res = false;
        try {
            int id = (Integer) key;
            String sql = "SELECT * FROM Familia WHERE idFamilia='"+ id+"'";
            Statement stm = ConexaoBD.getConexao().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            res = rs.next();
            
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return res;
    
    }

    @Override
    public boolean containsValue(Object value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Familia get(Object key) {
        Familia f = null;
        try {
            int id = (Integer) key;
            Statement stm = ConexaoBD.getConexao().createStatement();
            String sql = "SELECT * FROM test.Familia WHERE idFamilia=" +id;
            ResultSet rs = stm.executeQuery(sql);
            
            if(rs.next()) {
                int i = rs.getInt(1);
                String Nome = rs.getString(2);
                //String membros = rs.getString(3);??
                String codPostal = rs.getString(4);
                String localidade = rs.getString(5);
                String rua = rs.getString(6);
                                
                //f = new Familia(i,Nome,membros,codPostal,localidade,rua);
            }            
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return f;
    }

    @Override
    public Familia put(Integer key, Familia value) {
        Familia fam = null;
        PreparedStatement pst = null;
        
        try{
            int id_evento=0;
            id_evento=this.size()+1;
            String sql;
            sql = "INSERT INTO Familia(idFamilia,Nome,CodPostal,Localidade,Rua) VALUES ('?','?','?','?','?')";
            pst = ConexaoBD.getConexao().prepareCall(sql);
            pst.setInt(1,id_evento);
            pst.setString(2, value.getNome());
            pst.setString(3, value.getCodPostal());
            pst.setString(4, value.getLocalidade());
            pst.setString(5, value.getRua());
            pst.execute();
            
        }catch(SQLException e){ }
        fam=value;
        return fam; 
    }

    @Override
    public Familia remove(Object key) {
        Familia fam = null;
        try {
            int id = (Integer) key;
            String sql = "delete from test.Familia where idFamilia='"+id+"'";
            Statement stm = ConexaoBD.getConexao().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return fam;
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Familia> m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Integer> keySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Familia> values() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Entry<Integer, Familia>> entrySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
