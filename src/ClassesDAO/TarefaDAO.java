/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesDAO;

import Classes.Tarefa;
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
public class TarefaDAO implements Map<Integer,Tarefa>{

    @Override
    public int size() {
        int res = 0;
        try {
            Statement stm = ConexaoBD.getConexao().createStatement();
            String sql = "SELECT * FROM tarefa";
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
            String sql = "SELECT * FROM test.Material";
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
            String sql = "SELECT * FROM test.Material WHERE idMaterial="+ id;
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
    public Tarefa get(Object key) {
        Tarefa t = null;
        try {
            int id = (Integer) key;
            Statement stm = ConexaoBD.getConexao().createStatement();
            String sql = "SELECT * FROM Tarefa where idTarefa=" +id;
            ResultSet rs = stm.executeQuery(sql);
            
            if(rs.next()) {
                int i = rs.getInt(1);
                Double Custo = rs.getDouble(2);
                Date DataLimite = rs.getDate(3);
                String Descricao = rs.getString(4);
                                
                t = new Tarefa(i,Custo,DataLimite,Descricao);
            }            
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) { 
        }
        return t;
    }

    @Override
    public Tarefa put(Integer key, Tarefa value) {
        Tarefa t = null;
        PreparedStatement pst = null;
        
        try{
            int id_tarefa=0;
            id_tarefa=this.size()+1;
            String sql;
            sql = "INSERT INTO `test.tarefa`(`idTarefa`,`Custo`,`DataLimiteRealizacao`,`Descricao`) VALUES (?,'?',?,'?')";
            pst = ConexaoBD.getConexao().prepareCall(sql);
            pst.setInt(1,id_tarefa);
            pst.setDouble(2, value.getCusto());
            //pst.setDate(3, value.getDataLimite());
            pst.setString(4, value.getDescricao());
     
            
            pst.executeUpdate(sql);
            
            
            
        }catch(SQLException e){ }
        t=value;    
        return t;    
    }

    @Override
    public Tarefa remove(Object key) {
        Tarefa t = null;
        try {
            int id = (Integer) key;
            String sql = "delete from test.Tarefa where idTarefa="+id;
            Statement stm = ConexaoBD.getConexao().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return t;
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Tarefa> m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Integer> keySet() {
        Set<Integer> res = new TreeSet<>();
        try {
            String sql = "SELECT idTarefa FROM Tarefa";
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
    public Collection<Tarefa> values() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Entry<Integer, Tarefa>> entrySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
