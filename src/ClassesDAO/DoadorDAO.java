/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesDAO;

import Classes.Doador;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Tiago
 */
public class DoadorDAO implements Map<Integer,Doador>{
    public DoadorDAO() {
    }
        
    @Override
    public int size() {
        int res = 0;
        try {
            Statement stm = ConexaoBD.getConexao().createStatement();
            String sql = "SELECT * from doador";
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
            String sql = "SELECT * FROM Doador";
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
            String sql = "SELECT * FROM Doador WHERE idDoador="+id;
            Statement stm = ConexaoBD.getConexao().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            res = rs.next();
            
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return res;
    }

    

    @Override
    public Doador get(Object key) {
        Doador d = null;
        
        try {
            Integer id = (Integer) key;
            Statement stm = ConexaoBD.getConexao().createStatement();
            String sql = "SELECT * FROM doador WHERE idDador= "+id;
            ResultSet rs = stm.executeQuery(sql);
            
            if(rs.next()) {
                int idDoador = rs.getInt(1);
                String tipo = rs.getString(2);
                String nome = rs.getString(3);
                String bi = rs.getString(4);
                String nif = rs.getString(5);
            }           
            
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return d;    
    }

    @Override
    public Doador put(Integer key, Doador value) {
        Doador d = null;
        PreparedStatement pst = null;
        
        try{
            int id_doador=0;
            id_doador=this.size()+1;
            String sql;
            sql = "INSERT INTO doador(idDoador,Tipo,Nome,BI,NIF) VALUES (?,?,?,?,?)";                
                                                          
            pst = ConexaoBD.getConexao().prepareCall(sql);
            pst.setInt(1,id_doador);
            pst.setString(2, value.getTipo());
            pst.setString(3, value.getNome());
            pst.setString(4, value.getBi());
            pst.setString(4, value.getNif());
            pst.execute();
            
        }catch(SQLException e){ }
        d=value;
        return d;
    }

    @Override
    public Doador remove(Object key) {
        Doador doa = null;
        try {
            int id = (Integer) key;
            String sql = "delete from doador where idDoador="+id;
            Statement stm = ConexaoBD.getConexao().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return doa;
    }

    @Override
    public Set<Integer> keySet() {
        Set<Integer> res = new TreeSet<>();
        try {
            String sql = "SELECT nome FROM doador";
            Statement stm = ConexaoBD.getConexao().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next())
                res.add(rs.getInt(1));
            
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return res;
    }

    @Override
    public Collection<Doador> values() {
        Collection<Doador> res = new HashSet<>();
        try {
            String sql = "SELECT nome FROM doador";
            Statement stm = ConexaoBD.getConexao().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next())
                res.add(this.get(rs.getString(3)));
            
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return res;
    }

    @Override
    public Set<Entry<Integer, Doador>> entrySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean containsValue(Object value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void putAll(Map<? extends Integer, ? extends Doador> m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
