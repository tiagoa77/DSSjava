package Classes;


import ClassesDAO.FuncionarioDAO;
import java.util.Date;
import java.util.GregorianCalendar;
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
public class Evento {
    private int id = 0;
    Date data;
    String local;
    String descricao;
    private int id_evento;
    private Map<Integer,Funcionario> funcionarios;
    
    
    public Evento(Evento e){
        this.data = e.getData();
        this.descricao=e.getDescricao();
        this.id=e.getId();
        this.local=e.getLocal();
        this.id_evento=e.getId_evento();
        this.funcionarios=new FuncionarioDAO(this.id);
    }
    public Evento(){
        this.data = new Date();
        this.descricao="";
        this.id=this.id+1;
        this.local="";
        this.id_evento=0;
        this.funcionarios=new FuncionarioDAO(this.id);
    }
    public Evento(Date d, String l, String de,int id_evento){
        this.data = d;
        this.descricao=de;
        this.id=id+1;
        this.local=l;
        this.id_evento=id_evento;
        this.funcionarios=new FuncionarioDAO(this.id);
    }

    public int getId_evento() {
        return id_evento;
    }

    public void setId_evento(int id_evento) {
        this.id_evento = id_evento;
    }
    
    public void setId(int id){
        this.id = id;
    }
    public void setData(Date d){
        this.data = d;
    }
    public void setLocal(String l){
        this.local = l;
    }
    public void setDescricao(String d){
        this.descricao = d;
    }
    public int getId(){
        return this.id;
    }
    public String getLocal(){
        return this.local;
    }
    public String getDescricao(){
        return this.descricao;
    }
    public Date getData(){
        return this.data;
    }
    
     public boolean Equals(Object o){
        if (this == o)
            return true;
        if ((o!=null) || (o.getClass()!=this.getClass()))
            return false;
        Evento e = (Evento) o;
        return this.descricao.equals(e.getDescricao())&&this.id==e.getId()&&this.local.equals(e.getLocal());
    }
    
    public Evento clone() { 
        return new Evento(this); 
    }
    public String toString() {
        StringBuilder s = new StringBuilder("------ Evento ---------\n");
        s.append("Id: ").append(id).append("\n");
        s.append("Descrição: ").append(descricao).append("\n");
        s.append("Local: ").append(local).append("\n");
        
        return s.toString();
    }
    
}
