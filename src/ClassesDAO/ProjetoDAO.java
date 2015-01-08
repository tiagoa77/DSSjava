/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesDAO;

import Classes.Projeto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Tiago
 */
public class ProjetoDAO implements Map<Integer,Projeto>{
    private int id;

    public ProjetoDAO() {    
    }
    
    
    public ProjetoDAO(int id) {
        this.id=id;
    }
    
    @Override
    public int size() {
        int res = 0;
        try {
            Statement stm = ConexaoBD.getConexao().createStatement();
            String sql = "SELECT * from test.Projeto";
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
            String sql = "SELECT * FROM test.Projeto";
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
            String sql = "SELECT * FROM Projeto WHERE idProjeto="+id;
            Statement stm = ConexaoBD.getConexao().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            res = rs.next();
            
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return res;
    }

    
    @Override
    public Projeto get(Object key) {
        Projeto p = new Projeto();
        
        try {
            Integer id = (Integer) key;
            Statement stm = ConexaoBD.getConexao().createStatement();
            String sql = "SELECT * FROM Projeto WHERE idProjeto="+id;
            ResultSet rs = stm.executeQuery(sql);
            
            if(rs.next()) {
                int idProjeto = rs.getInt(1);
                p.setId(idProjeto);
            }           
            
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return p;    
    }

    @Override
    public Projeto put(Integer key, Projeto value) {
        Projeto p = null;
        PreparedStatement pst = null;
        
        try{
            int id_projeto=0;
            id_projeto=this.size()+1;
            String sql;
            sql = "INSERT INTO Projeto(idProjeto,DataAprovacao) VALUES ('?','?')";                
                                                          
            pst = ConexaoBD.getConexao().prepareCall(sql);
            pst.setInt(1,id_projeto);
            //pst.setString(2, value.get);
            pst.execute();
            
        }catch(SQLException e){ }
        p=value;
        return p;
    }

    @Override
    public Projeto remove(Object key) {
        Projeto proj = null;
        try {
            int id = (Integer) key;
            String sql = "delete from test.Projeto where idProjeto='"+id+"'";
            Statement stm = ConexaoBD.getConexao().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return proj;
    }

    

    @Override
    public Set<Integer> keySet() {
        Set<Integer> res = new TreeSet<>();
        try {
            String sql = "SELECT idProjeto FROM test.Projeto";
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
    public Collection<Projeto> values() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Entry<Integer, Projeto>> entrySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public boolean containsValue(Object value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void putAll(Map<? extends Integer, ? extends Projeto> m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
