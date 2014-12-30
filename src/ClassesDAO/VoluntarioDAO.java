/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesDAO;

import Classes.Voluntario;
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
public class VoluntarioDAO implements Map<Integer,Voluntario>{
    private int id;

    public VoluntarioDAO(int id) {
        this.id = id;
    }

    @Override
    public int size() {
        int res = 0;
        try {
            Statement stm = ConexaoBD.getConexao().createStatement();
            String sql = "SELECT * FROM Voluntario where Equipa="+this.id;
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
            String sql = "SELECT * FROM Voluntario where Equipa=" + this.id;
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
            String sql = "SELECT * FROM Voluntario WHERE Equipa="+ this.id;
            Statement stm = ConexaoBD.getConexao().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            res = rs.next();
            
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return res;
    }

    @Override
    public Voluntario get(Object key) {
        Voluntario v = null;
        try {
            int id = (Integer) key;
            Statement stm = ConexaoBD.getConexao().createStatement();
            String sql = "SELECT * FROM Voluntario WHERE Equipa= "+this.id+" and idVoluntario=" +id;
            ResultSet rs = stm.executeQuery(sql);
            
            if(rs.next()) {
                String Nome = rs.getString(2);
                boolean Disp = rs.getBoolean(3);
                String Tlm = rs.getString(4);
                String Prof = rs.getString(5);
                Date Dtnas = rs.getDate(6);
                String Cod = rs.getString(7);
                String Rua = rs.getString(8);
                String Loc = rs.getString(9);
                int Equipa = rs.getInt(10);
                String Email = rs.getString(11);
                                
                v = new Voluntario(Cod,Dtnas,Email,Prof,Loc,Nome,Rua,Tlm,Equipa);
            }            
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return v;
    }

    @Override
    public Voluntario put(Integer key, Voluntario value) {
        Voluntario d = null;
        PreparedStatement pst = null;
        
        try{
            int id_voluntario=0;
            id_voluntario=this.size()+1;
            String sql;
            sql = "INSERT INTO voluntario(idVoluntario,Nome,Diponibilidade,Telemovel,Profissao,DataNascmento,CodPostal,Rua,Localidade,Equipa,Email) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            pst = ConexaoBD.getConexao().prepareCall(sql);
            pst.setInt(1,id_voluntario);
            pst.setString(2, value.getNomeVoluntario());
            pst.setBoolean(3, value.getDisponibilidade());
            pst.setString(4, value.getTelemovel());
            pst.setString(5, value.getProfissao());
            pst.setDate(6, (java.sql.Date) value.getDataNascimento());
            pst.setString(7, value.getCodPostal());
            pst.setString(8, value.getRua());
            pst.setString(9, value.getLocalidade());
            pst.setInt(10, value.getId_equipa());
            pst.setString(11, value.getEmail());
            pst.execute();
            
        }catch(SQLException e){ }
        d=value;
        return d;    
    }

    @Override
    public Voluntario remove(Object key) {
        Voluntario v = null;
        try {
            int id = (Integer) key;
            String sql = "delete from Voluntario where idVoluntario="+id+" and Equipa= "+this.id;
            Statement stm = ConexaoBD.getConexao().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return v;
    }

    

    @Override
    public Set<Integer> keySet() {
        Set<Integer> res = new TreeSet<>();
        try {
            String sql = "SELECT idVoluntario from Voluntario";
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
    public Collection<Voluntario> values() {
        Collection<Voluntario> res = new HashSet<>();
        try {
            String sql = "SELECT idVoluntario FROM Voluntario";
            Statement stm = ConexaoBD.getConexao().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next())
                res.add(this.get(rs.getString(2)));
            
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return res;
    }

    @Override
    public Set<Entry<Integer, Voluntario>> entrySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean containsValue(Object value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void putAll(Map<? extends Integer, ? extends Voluntario> m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
