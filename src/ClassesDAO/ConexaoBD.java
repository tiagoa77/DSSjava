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
 * É preciso mudar isto para o sql server
 * @author Tiago
 */
public class ConexaoBD {
    public static final String ip = "192.168.1.84";
    public static final String porta = "1521";
    public static final String sid = "orcl";
    public static final String user = "APEF";
    public static final String pw = "APEF";
    public static final String url = "jdbc:oracle:thin:@" + ip + ":" + porta + ":" + sid;
	
    public static Connection conexao;
	
    public static void iniciarConexao() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conexao = DriverManager.getConnection(url, user, pw);
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