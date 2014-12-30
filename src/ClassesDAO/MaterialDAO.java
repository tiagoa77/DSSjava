/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesDAO;

import Classes.Material;
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
public class MaterialDAO implements Map<Integer, Material>{
    private int idprojecto;
    private int iddonativo;
    
    public MaterialDAO(int iddonativo,int idprojecto){
        this.iddonativo=iddonativo;
        this.idprojecto=idprojecto;
    }

    @Override
    public int size() {
        int res = 0;
        try {
            Statement stm = ConexaoBD.getConexao().createStatement();
            String sql = "SELECT * FROM Material where donativo="+this.iddonativo+" and projecto="+this.idprojecto;
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
            String sql = "SELECT * FROM Materal where donativo="+this.iddonativo+" and projecto="+this.idprojecto;
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
            String sql = "SELECT * FROM Material WHERE donativo="+ this.iddonativo+" and projecto="+this.idprojecto;;
            Statement stm = ConexaoBD.getConexao().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            res = rs.next();
            
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return res;
    }

    @Override
    public Material get(Object key) {
        Material v = null;
        try {
            int id = (Integer) key;
            Statement stm = ConexaoBD.getConexao().createStatement();
            String sql = "SELECT * FROM Material WHERE donativo= "+this.iddonativo+" and projecto="+this.idprojecto+" and id_material="+id;
            ResultSet rs = stm.executeQuery(sql);
            
            if(rs.next()) {
                double Quantidade = rs.getInt(2);
                String Descricao = rs.getString(3);
                int projecto = rs.getInt(4);
                int donativo = rs.getInt(5);
                                
                v = new Material(Descricao,Quantidade,projecto,donativo);
            }            
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return v;
    }

    @Override
    public Material put(Integer key, Material value) {
        Material m = null;
        PreparedStatement pst = null;
        
        try{
            int id_material=0;
            id_material=this.size()+1;
            String sql;
            sql = "INSERT INTO Material(idMaterial,Stock,Descricao,Projecto,Donativo) VALUES (?,?,?,?,?)";
            pst = ConexaoBD.getConexao().prepareCall(sql);
            pst.setInt(1,id_material);
            pst.setDouble(2, value.getStock());
            pst.setString(2, value.getDesc());
            pst.setInt(4, value.getId_projecto());
            pst.setInt(5, value.getId_donativo());
            pst.execute();
            
        }catch(SQLException e){ }
        m=value;
        return m;       
    }

    @Override
    public Material remove(Object key) {
        Material m = null;
        try {
            int id = (Integer) key;
            String sql = "delete from Material where idMaterial="+id+" and Donativo= "+this.iddonativo+" and projecto="+this.idprojecto;
            Statement stm = ConexaoBD.getConexao().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return m;
    }

    @Override
    public Set<Integer> keySet() {
        Set<Integer> res = new TreeSet<>();
        try {
            String sql = "SELECT idMaterial from Material";
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
    public Collection<Material> values() {
        Collection<Material> res = new HashSet<>();
        try {
            String sql = "SELECT idMaterial FROM Material";
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
    public Set<Entry<Integer, Material>> entrySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean containsValue(Object value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void putAll(Map<? extends Integer, ? extends Material> m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
