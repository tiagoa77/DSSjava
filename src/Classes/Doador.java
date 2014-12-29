package Classes;

import ClassesDAO.DonativoDAO;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Patrícia
 */
public class Doador {
    private int id = 0;
    private String tipo;
    private String nome;
    private String nif;
    private String bi;
    private Map<Integer,Donativo> donativos;
    
    public Doador(Doador d){
        this.id = d.getId();
        this.tipo = d.getTipo();
        this.nome = d.getNome();
        this.nif= d.getNif();
        this.bi = d.getBi();
        this.donativos=new DonativoDAO(this.id);
    }
    public Doador(){
        this.id = this.id +1;
        this.tipo = "";
        this.nome = "";
        this.nif= "";
        this.bi = "";
        this.donativos=new DonativoDAO(this.id);
    }
    public Doador(String t, String n, String nif, String b){
        this.id = this.id +1;
        this.tipo = t;
        this.nome = n;
        this.nif= nif;
        this.bi = b;
        this.donativos=new DonativoDAO(this.id);
    }
    
    public void setId(int i){
        this.id = i;
    }
    public void setTipo(String t){
        this.tipo = t;
    }
    public void setNome(String n){
        this.nome = n;
    }
    public void setNif(String n){
        this.nif = n;
    }
    public void setBi(String b){
        this.bi = b;
    }
    public int getId(){
        return this.id;
    }
    public String getNome(){
        return this.nome;
    }
    public String getTipo(){
        return this.tipo;
    }
    public String getNif(){
        return this.nif;
    }
    public String getBi(){
        return this.bi;
    }
    
    public boolean Equals(Object o){
        if (this == o)
            return true;
        if ((o!=null) || (o.getClass()!=this.getClass()))
            return false;
        Doador d = (Doador) o;
        return this.nif.equals(d.getNif());
    }
    
    public Doador clone() { 
        return new Doador(this); 
    }
    public String toString() {
        StringBuilder s = new StringBuilder("------ Doador ---------\n");
        s.append("Id: ").append(id).append("\n");
        s.append("Nome: ").append(nome).append("\n");
        s.append("Tipo : ").append(tipo).append("\n");
        s.append("Bi :").append(bi).append("\n");
        s.append("Nif :").append(nif).append("\n");
        return s.toString();
    }
    
}
