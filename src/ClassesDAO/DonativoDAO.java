/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesDAO;

import Classes.Donativo;
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
public class DonativoDAO implements Map<Integer,Donativo> {
    private int idDoador;

    public DonativoDAO() {
    }
    
    
    public DonativoDAO(int id) {
        this.idDoador=id;
    }
    
    @Override
    public int size() {
        int res = 0;
        try {
            Statement stm = ConexaoBD.getConexao().createStatement();
            String sql = "SELECT * FROM DONATIVO where doador="+this.idDoador;
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
            String sql = "SELECT * FROM Donativo where doador=" + this.idDoador;
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
            String sql = "SELECT * FROM Donativo WHERE doador="+ this.idDoador;
            Statement stm = ConexaoBD.getConexao().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            res = rs.next();
            
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return res;
    }

    @Override
    public Donativo get(Object key) {
        Donativo v = null;
        try {
            int id = (Integer) key;
            Statement stm = ConexaoBD.getConexao().createStatement();
            String sql = "SELECT * FROM test.Donativo WHERE idDonativo=" +id;
            ResultSet rs = stm.executeQuery(sql);
            
            if(rs.next()) {
                String Descricao = rs.getString(2);
                double Quantidade = rs.getInt(3);
                float Valor = rs.getInt(4);
                String Tipo = rs.getString(5);
                int Doador = rs.getInt(6);
                int Evento = rs.getInt(7);
                                
                v = new Donativo(id,Tipo,Descricao,Valor,Quantidade,Doador,Evento);
            }            
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return v;
    }

    @Override
    public Donativo put(Integer key, Donativo value) {
        Donativo d = null;
        PreparedStatement pst = null;
        
        try{
            int id_donativo=0;
            id_donativo=this.size()+1;
            String sql;
            sql = "INSERT INTO donativo(idDonativo,Descricao,Quantidade,Valor,Tipo,Doador) VALUES (?,?,?,?,?,?)";
            pst = ConexaoBD.getConexao().prepareCall(sql);
            pst.setInt(1,id_donativo);
            pst.setString(2, value.getDescricao());
            pst.setDouble(3, value.getQuantidade());
            pst.setFloat(4, value.getValor());
            pst.setString(5, value.getTipo());
            pst.setInt(6, value.getId_doador());
            pst.execute();
            
        }catch(SQLException e){ }
        d=value;
        return d;       
    }

    @Override
    public Donativo remove(Object key) {
        Donativo don = null;
        try {
            int id = (Integer) key;
            String sql = "delete from donativo where idDonativo="+id+" and Doador= "+this.idDoador;
            Statement stm = ConexaoBD.getConexao().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return don;
    }

    
    @Override
    public Set<Integer> keySet() {
        Set<Integer> res = new TreeSet<>();
        try {
            String sql = "SELECT idDonativo from test.Donativo";
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
    public Collection<Donativo> values() {
        Collection<Donativo> res = new HashSet<>();
        try {
            String sql = "SELECT idDonativo FROM Donativo";
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
    public Set<Entry<Integer, Donativo>> entrySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean containsValue(Object value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void putAll(Map<? extends Integer, ? extends Donativo> m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
