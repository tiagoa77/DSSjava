/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesDAO;

import Classes.Evento;
import Classes.Funcionario;
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
public class FuncionarioDAO implements Map<Integer,Funcionario>{
    private int id;
    public FuncionarioDAO(int id) {
        this.id=id;
    }
    
    @Override
    public int size() {
        int res = 0;
        try {
            Statement stm = ConexaoBD.getConexao().createStatement();
            String sql = "SELECT * FROM Funcionario where Evento="+this.id;
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
            String sql = "SELECT * FROM Funcionario where Evento=" + this.id;
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
            String sql = "SELECT * FROM Funcionario WHERE Evento="+ this.id;
            Statement stm = ConexaoBD.getConexao().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            res = rs.next();
            
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return res;
    }

   

    @Override
    public Funcionario get(Object key) {
        Funcionario f = null;
        try {
            int id = (Integer) key;
            Statement stm = ConexaoBD.getConexao().createStatement();
            String sql = "SELECT * FROM Funcionario WHERE Evento= "+this.id+" and idFuncionario=" +id;
            ResultSet rs = stm.executeQuery(sql);
            
            if(rs.next()) {
                String N = rs.getString(2);
                String T = rs.getString(3);
                String E = rs.getString(4);
                String Lg = rs.getString(5);
                String P = rs.getString(6);
                String R = rs.getString(7);
                String L = rs.getString(8);
                String C = rs.getString(9);
                int Evt = rs.getInt(10);
                
                f.setNome(N);
                f.setTelemovel(T);
                f.setEmail(E);
                f.setLogin(Lg);
                f.setPassword(P);
                f.setRua(R);
                f.setLocalidade(L);
                f.setCodPostal(C);
                f.setId_evento(Evt);
                f.setId(id);
                
            }            
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return f;
    }

    @Override
    public Funcionario put(Integer key, Funcionario value) {
        Funcionario f = null;
        PreparedStatement pst = null;
        
        try{
            int id_funcionario=0;
            id_funcionario=this.size()+1;
            String sql;
            sql = "INSERT INTO evento(idFuncionario,Nome,Telemovel,Email,Login,Password,Rua,Localidade,CodPostal,Evento) VALUES (?,?,?,?,?,?,?,?,?,?)";
            pst = ConexaoBD.getConexao().prepareCall(sql);
            pst.setInt(1,id_funcionario);
            pst.setString(2, value.getNome());
            pst.setString(3, value.getTelemovel());
            pst.setString(4, value.getEmail());
            pst.setString(5, value.getLogin());
            pst.setString(6, value.getPassword());
            pst.setString(7, value.getRua());
            pst.setString(8, value.getLocalidade());
            pst.setString(9, value.getcodPostal());
            pst.setInt(10, value.getId_evento());
            
            pst.execute();
            
        }catch(SQLException e){ }
        f=value;
        return f;
    }

    @Override
    public Funcionario remove(Object key) {
        Funcionario f = null;
        try {
            int id = (Integer) key;
            String sql = "delete from Funcionario where idFuncionario="+id+" and Evento = "+this.id;
            Statement stm = ConexaoBD.getConexao().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return f;
    }

    

    @Override
    public Set<Integer> keySet() {
        Set<Integer> res = new TreeSet<>();
        try {
            String sql = "SELECT idFuncionario from Funcionario";
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
    public Collection<Funcionario> values() {
        Collection<Funcionario> res = new HashSet<>();
        try {
            String sql = "SELECT Nome FROM Funcionario";
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
    public Set<Entry<Integer, Funcionario>> entrySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     @Override
    public boolean containsValue(Object value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void putAll(Map<? extends Integer, ? extends Funcionario> m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

