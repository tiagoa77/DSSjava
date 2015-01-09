package Classes;

import ClassesDAO.DoadorDAO;
import ClassesDAO.EventoDAO;
import ClassesDAO.MaterialDAO;
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
public class Donativo {
    private String tipo;
    private int id = 0;
    private String descricao;
    private double quantidade;
    private float valor;
    private int id_doador;
    private int id_evento;
    private Map<Integer,Material> materiais;
    private Map<Integer,Evento> eventos;
    
    
    public Donativo(Donativo d){
        this.tipo = d.getTipo();
        this.id = d.getId();
        this.descricao = d.getDescricao();
        this.valor = d.getValor();
        this.quantidade = d.getQuantidade();
        this.id_doador=d.getId_doador();
        this.id_evento=d.getId_evento();
        this.materiais= new MaterialDAO(this.id,this.id); //verifar o construtor
    }


    public Donativo(){
       this.tipo = "";
       this.id = 0;
       this.descricao = "";
       this.valor = 0;
       this.quantidade = 0.00; 
       this.id_doador=0;
       this.id_evento=0;
       this.materiais= new MaterialDAO();//verifar o construtor
       
    }
    
    public Donativo(int i,String t, String d, float v, double q,int id_doador){
       this.tipo = t;
       this.id = i;
       this.descricao = d;
       this.valor = v;
       this.quantidade = q; 
       this.id_doador=id_doador;
       //this.id_evento=id_evento;
       this.materiais= new MaterialDAO();
    }
    
    public Donativo(int i, String d, float v, double q,int id_doador){
       this.id = i;
       this.descricao = d;
       this.valor = v;
       this.quantidade = q; 
       this.id_doador=id_doador;
    }
    
    public Donativo(int i, String d, float v, double q){
       this.id = i;
       this.descricao = d;
       this.valor = v;
       this.quantidade = q; 
    }       


    public int getId_evento() {
        return id_evento;
    }

    public void setId_evento(int id_evento) {
        this.id_evento = id_evento;
    }
    
    public int getId_doador() {
        return id_doador;
    }

    public void setId_doador(int id_doador) {
        this.id_doador = id_doador;
    }
    
    
    public void setTipo(String t){
        this.tipo = t;
    }
    public void setId(int i){
        this.id = i;
    }
    public void setDescricao(String d){
        this.descricao = d;
    }
    public void setValor(float v){
        this.valor = v;
    }
    public void setQuantidade(double q){
        this.quantidade = q;
    }
    public int getId(){
        return this.id;
    }
    public String getTipo(){
        return this.tipo;
    }
    public String getDescricao(){
        return this.descricao;
    }
    public float getValor(){
        return this.valor;
    }
    public double getQuantidade(){
        return this.quantidade;
    }
    
    
    
    public boolean Equals(Object o){
        if (this == o)
            return true;
        if ((o!=null) || (o.getClass()!=this.getClass()))
            return false;
        Donativo d = (Donativo) o;
        return this.tipo.equals(d.getTipo())&&(this.id==d.getId());
    }
    
    public Donativo clone() { 
        return new Donativo(this); 
    }
    public String toString() {
        StringBuilder s = new StringBuilder("------ Donativo ---------\n");
        s.append("Id: ").append(id).append("\n");
        s.append("Tipo : ").append(tipo).append("\n");
        s.append("Quantidade :").append(quantidade).append("\n");
        s.append("Valor :").append(valor).append("\n");
        s.append("Descricao :").append(descricao).append("\n");
        return s.toString();
    }
}
