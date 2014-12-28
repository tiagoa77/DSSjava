/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestePackage;

import ClassesDAO.ConexaoBD;
import ClassesDAO.DoadorDAO;
import java.sql.SQLException;

/**
 *
 * @author Tiago
 */
public class main {
    public static void main(String[] args) throws SQLException {
        
        // Connect to Oracle Database
        ConexaoBD.iniciarConexao();
        
        DoadorDAO d = new DoadorDAO();
        
        //ArmazemDAO teste = new ArmazemDAO();
        //ProdutoDAO teste = new ProdutoDAO();
        //RotaDAO teste = new RotaDAO();
        //EncomendaDAO c1 = new EncomendaDAO(4);
        int size = d.size();
        //boolean emp = teste.isEmpty();
        //boolean tam = teste.isEmpty();
        //boolean tam = teste.containsKey(424);
        //Encomenda e1 = c1.get(4);
        //c1.put(2, e1);
        //Produto p1 = teste.get(1);
        //Produto p2 = teste.get(2);
        
        //System.out.println(p1.toString());
        //System.out.println(p2.toString());
        
        //teste.put(1000, p1);
        //teste.put(1001, p2);
        
        //teste.remove(441);
        //teste.remove(442);
        
            
        //ResultSet rs2 = statement.executeQuery("SELECT count(*) FROM cliente");
        
       // if(rs2.next())
            //System.out.println("Numero de Clientes : "+rs2.getString(1));
        
        //rs2.close();
        
        //System.out.println("Empty : "+emp);
        System.out.println("Size : "+size);
        
        ConexaoBD.terminarConexao();
    }
}
