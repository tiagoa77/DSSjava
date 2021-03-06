/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesDAO;

import Classes.Donativo;
import Classes.Evento;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Tiago
 */
public class EventoDAO implements Map<Integer,Evento> {
    private int id;

    public EventoDAO() {
    }
    
            
    @Override
    public int size() {
        int res = 0;
        try {
            Statement stm = ConexaoBD.getConexao().createStatement();
            String sql = "SELECT * FROM test.Evento";// where donativo="+this.id;
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
            String sql = "SELECT * FROM Evento";// where donativo=" + this.id;
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
            String sql = "SELECT * FROM Evento WHERE idEvento='"+ id+"'";
            Statement stm = ConexaoBD.getConexao().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            res = rs.next();
            
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return res;
    }


    @Override
    public Evento get(Object key) {
        Evento v = null;
        try {
            int id = (Integer) key;
            Statement stm = ConexaoBD.getConexao().createStatement();
            String sql = "SELECT * FROM test.Evento WHERE idEvento=" +id;
            ResultSet rs = stm.executeQuery(sql);
            
            if(rs.next()) {
                int i = rs.getInt(1);
                String Descricao = rs.getString(2);
                String Local = rs.getString(3);
                Date DataReal = rs.getDate(4);
                                
                v = new Evento(i,DataReal,Local,Descricao);
            }            
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return v;
    }

    @Override
    public Evento put(Integer key, Evento value) {
        Evento evt = null;
        PreparedStatement pst = null;
        
        try{
            int id_evento=0;
            id_evento=this.size()+1;
            String sql;
            sql = "INSERT INTO evento(idEvento,Descricao,Local,DataRealizacao) VALUES (?,?,?,?)";
            pst = ConexaoBD.getConexao().prepareCall(sql);
            pst.setInt(1,id_evento);
            pst.setString(2, value.getDescricao());
            pst.setString(3, value.getLocal());
            pst.setDate(4, (java.sql.Date) value.getData());
            pst.executeUpdate();
            
        }catch(SQLException e){ }
        evt=value;
        return evt;   
    }

    @Override
    public Evento remove(Object key) {
        Evento evt = null;
        try {
            int id = (Integer) key;
            String sql = "update donativo set Evento=null where Evento="+id;
            String sql2 = "delete from Evento where idEvento=" + id;
            PreparedStatement stm = ConexaoBD.getConexao().prepareStatement(sql);
            PreparedStatement stm2 = ConexaoBD.getConexao().prepareStatement(sql2);
            stm.executeUpdate();
            stm2.executeUpdate();
            stm.close();
            stm2.close();
        } catch (SQLException e) {
        }
        return evt;
    }
    
    @Override
    public Set<Integer> keySet() {
        Set<Integer> res = new TreeSet<>();
        try {
            String sql = "SELECT idEvento from test.Evento";
            Statement stm = ConexaoBD.getConexao().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()){
                res.add(rs.getInt(1));
            //System.out.println("keysetEventos: "+rs.getInt(1));
            }
            
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return res;
    }

    @Override
    public Collection<Evento> values() {
        Collection<Evento> res = new HashSet<>();
        try {
            String sql = "SELECT idEvento FROM test.Donativo";
            Statement stm = ConexaoBD.getConexao().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next())
                res.add(this.get(rs.getInt(1)));
            
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return res;
    }

    @Override
    public Set<Entry<Integer, Evento>> entrySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean containsValue(Object value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void putAll(Map<? extends Integer, ? extends Evento> m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
