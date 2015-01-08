/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesDAO;

import Classes.Equipa;
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
public class EquipaDAO implements Map<Integer,Equipa>{
    public EquipaDAO(){
    
    }
    
    @Override
    public int size() {
        int res = 0;
        try {
            Statement stm = ConexaoBD.getConexao().createStatement();
            String sql = "SELECT * from test.Equipa";
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
            String sql = "SELECT * FROM test.Equipa";
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
            String sql = "SELECT * FROM test.Equipa WHERE idEquipa="+id;
            Statement stm = ConexaoBD.getConexao().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            res = rs.next();
            
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return res;
    }

    @Override
    public Equipa get(Object key) {
        Equipa eq = null;
        
        try {
            Integer id = (Integer) key;
            Statement stm = ConexaoBD.getConexao().createStatement();
            String sql = "SELECT * FROM test.Equipa WHERE idEquipa= "+id;
            ResultSet rs = stm.executeQuery(sql);
            
            if(rs.next()) {
                String nome = rs.getString(1);
                String pais = rs.getString(2);
                int idEquipa = rs.getInt(3);
                eq = new Equipa(idEquipa, nome, pais);
            }           
            
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return eq;    
    }

    @Override
    public Equipa put(Integer key, Equipa value) {
        Equipa d = null;
        PreparedStatement pst = null;
        
        try{
            int id_equipa=0;
            id_equipa=this.size()+1;
            String sql;
            sql = "INSERT INTO test.Equipa(Nome,Pais,idEquipa) VALUES (?,?,?)";                
                                                          
            pst = ConexaoBD.getConexao().prepareCall(sql);
            pst.setString(1, value.getNome());
            pst.setString(2, value.getPais());
            pst.setInt(3,id_equipa);
            pst.executeUpdate(sql);
            
        }catch(SQLException e){ }
        d=value;
        return d;
    }

    @Override
    public Equipa remove(Object key) {
        Equipa eq = null;
        try {
            int id = (Integer) key;
            String sql = "delete from test.equipa where idEquipa="+id;
            Statement stm = ConexaoBD.getConexao().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return eq;
    }

    @Override
    public Set<Integer> keySet() {
        Set<Integer> res = new TreeSet<>();
        try {
            String sql = "SELECT * FROM test.Equipa";
            Statement stm = ConexaoBD.getConexao().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()){
                res.add(rs.getInt(3));
                //System.out.println("keysetEqupa: "+rs.getInt(3));
            }
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return res;
    }

    @Override
    public Collection<Equipa> values() {
        Collection<Equipa> res = new HashSet<>();
        try {
            String sql = "SELECT * FROM test.Equipa";
            Statement stm = ConexaoBD.getConexao().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            int i=0;
            while(rs.next()){
                res.add(this.get(rs.getInt(3)));
                System.out.println(i+1);
            }
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return res;
    }

    @Override
    public Set<Entry<Integer, Equipa>> entrySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean containsValue(Object value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void putAll(Map<? extends Integer, ? extends Equipa> m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
