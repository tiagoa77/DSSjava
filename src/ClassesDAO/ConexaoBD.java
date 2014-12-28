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
 * sql server
 * @author Tiago
 */
public class ConexaoBD {
    public static final String url = "jdbc:sqlserver://diguest-pc:3306;" + "databaseName=MySQL56;user=tiago;password=tiago;";;
	
    public static Connection conexao;
	
    public static void iniciarConexao() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
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