/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesDAO;

import Classes.Candidatura;
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
public class CandidaturaDAO implements Map<Integer,Candidatura>{
    private int idfamilia;
    private int idprojecto;
    
    public CandidaturaDAO() {
    }   
    
    public CandidaturaDAO(int idfamilia, int idprojecto) {
        this.idfamilia = idfamilia;
        this.idprojecto = idprojecto;
    }   
    
    @Override
    public int size() {
        int res = 0;
        try {
            Statement stm = ConexaoBD.getConexao().createStatement();
            String sql = "SELECT * FROM test.Candidatura where Familia="+this.idfamilia+" and projecto="+this.idprojecto;
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
            String sql = "SELECT * FROM testCandidatura where Familia="+this.idfamilia+" and Projecto="+this.idprojecto;
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
            String sql = "SELECT * FROM test.Candidatura WHERE Familia="+ this.idfamilia+" and Projecto="+this.idprojecto;;
            Statement stm = ConexaoBD.getConexao().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            res = rs.next();
            
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return res;
    }



    @Override
    public Candidatura get(Object key) {
        Candidatura c = null;
        try {
            int id = (Integer) key;
            Statement stm = ConexaoBD.getConexao().createStatement();
            String sql = "SELECT * FROM test.Candidatura WHERE Familia= "+this.idfamilia+" and Projecto="+this.idprojecto+" and id_material="+id;
            ResultSet rs = stm.executeQuery(sql);
            
            if(rs.next()) {
                String Descricao = rs.getString(2);
                String Estado = rs.getString(3);
                int id_familia = rs.getInt(4);
                int id_projecto = rs.getInt(5);
                                
                c.setId(id);
                c.setDescricao(Descricao);
                c.setEstado(Estado);
                c.setIdfamilia(id_familia);
                c.setIdprojecto(id_projecto);
            }            
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return c;
    }

    @Override
    public Candidatura put(Integer key, Candidatura value) {
        Candidatura c = null;
        PreparedStatement pst = null;
        
        try{
            int id_candidatura=0;
            id_candidatura=this.size()+1;
            String sql;
            sql = "INSERT INTO test.Candidatura(idCandidatura,Descricao,Estado,Familia,Projecto) VALUES (?,?,?,?,?)";
            pst = ConexaoBD.getConexao().prepareCall(sql);
            pst.setInt(1,id_candidatura);
            pst.setString(2, value.getDescricao());
            pst.setString(2, value.getEstado());
            pst.setInt(4, value.getIdfamilia());
            pst.setInt(5, value.getIdprojecto());
            pst.execute();
            
        }catch(SQLException e){ }
        c=value;
        return c;    
    }

    @Override
    public Candidatura remove(Object key) {
        Candidatura c = null;
        try {
            int id = (Integer) key;
            String sql = "delete from test.Candidatura where idCandidatura="+id+" and Familia= "+this.idfamilia+" and projecto="+this.idprojecto;
            Statement stm = ConexaoBD.getConexao().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return c;
    }

    
    @Override
    public Set<Integer> keySet() {
        Set<Integer> res = new TreeSet<>();
        try {
            String sql = "SELECT idCandidatura from test.Candidatura";
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
    public Collection<Candidatura> values() {
        Collection<Candidatura> res = new HashSet<>();
        try {
            String sql = "SELECT idCandidatura FROM test.Candidatura";
            Statement stm = ConexaoBD.getConexao().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next())
                res.add(this.get(rs.getString(1)));
            
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return res;
    }

    @Override
    public Set<Entry<Integer, Candidatura>> entrySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean containsValue(Object value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void putAll(Map<? extends Integer, ? extends Candidatura> m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
