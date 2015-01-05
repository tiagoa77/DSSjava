/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * mysql server
 * @author Tiago
 */
public class ConexaoBD {
<<<<<<< HEAD
    public static final String url = "jdbc:mysql://diguest-pc/MySQL?" + "user=root&password=root" ;
=======
    public static final String url = "jdbc:mysql://localhost/test?" + "user=root&password=root" ;
>>>>>>> origin/master
    public static Connection conexao;
	
    public static void iniciarConexao() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conexao = DriverManager.getConnection(url);
            conexao.setAutoCommit(true);
	} catch (Exception e) {
            throw new NullPointerException(e.getMessage());
	}
    }
	
    public static Connection getConexao() {
	return ConexaoBD.conexao;
    }
	
    public static void terminarConexao() {
	try {
            conexao.close();
	} catch (SQLException e) {
	}
    }

     public static void fecharCursor(ResultSet rs, Statement stm) {
        try {
            if(rs != null)
                rs.close() ;
            if(stm != null)
                stm.close() ;
            } catch(Exception e) {throw new NullPointerException(e.getMessage());}
     }
}