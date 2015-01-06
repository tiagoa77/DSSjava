/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesDAO;

import Classes.Membro;
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
public class MembroDAO implements Map<Integer,Membro>{
    
    private int idFamilia;
    
    public MembroDAO(){
    }
    
    public MembroDAO(int id){
        this.idFamilia = id;
    }

    @Override
    public int size() {
        int res = 0;
        try {
            Statement stm = ConexaoBD.getConexao().createStatement();
            String sql = "SELECT * from test.Membro";
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
            String sql = "SELECT * FROM test.Membro";
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
            String sql = "SELECT * FROM Membro WHERE idMembro='"+id+"'";
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
    public Membro get(Object key) {
       Membro m = null;
        
        try {
            Integer id = (Integer) key;
            Statement stm = ConexaoBD.getConexao().createStatement();
            String sql = "SELECT * FROM Membro WHERE idMembro= '"+id+"'";
            ResultSet rs = stm.executeQuery(sql);
            
            if(rs.next()) {
                int idMembro = rs.getInt(1);
                String nome = rs.getString(2);
                Date DataNascimento = rs.getDate(3);
                String profissao = rs.getString(4);
                String Nif = rs.getString(5);
                String BI = rs.getString(6);
                int idFamilia= rs.getInt(7);
            }           
            
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return m;    
    }

    @Override
    public Membro put(Integer key, Membro value) {
        Membro m = null;
        PreparedStatement pst = null;
        
        try{
            int id_membro=0;
            id_membro=this.size()+1;
            String sql;
            sql = "INSERT INTO Membro(idMembro,Nome, DataNascimento, Profissao, Nif,BI, idFamilia) VALUES ('?','?'.'?','?','?','?'.'?')";                
                                                          
            pst = ConexaoBD.getConexao().prepareCall(sql);
            pst.setInt(1,id_membro);
            pst.setString(2, value.getNome());
            pst.setString(3, value.getDataNascimento());
            pst.setString(4, value.getProfissao());
            pst.setString(5, value.getNif());
            pst.setString(6, value.getBi());
            //pst.setString(8, value.getIdFamilia());
            pst.execute();
            
        }catch(SQLException e){ }
        m=value;
        return m;
    }

    @Override
    public Membro remove(Object key) {
        Membro membro = null;
        try {
            int id = (Integer) key;
            String sql = "delete from test.Membro where idMembro='"+id+"'";
            Statement stm = ConexaoBD.getConexao().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return membro;
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Membro> m) {
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
            String sql = "SELECT idMembro FROM test.Membro";
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
    public Collection<Membro> values() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Entry<Integer, Membro>> entrySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
