package Classes;


import java.util.GregorianCalendar;

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
    GregorianCalendar data;
    String local;
    String descricao;
    
    Evento(Evento e){
        this.data = e.getData();
        this.descricao=e.getDescricao();
        this.id=e.getId();
        this.local=e.getLocal();
    }
    Evento(){
        this.data = new GregorianCalendar();
        this.descricao="";
        this.id=this.id+1;
        this.local="";
    }
    Evento(int i, GregorianCalendar d, String l, String de){
        this.data = d;
        this.descricao=de;
        this.id=i;
        this.local=l;
    }
    
    public void setId(int id){
        this.id = id;
    }
    public void setData(GregorianCalendar d){
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
    public GregorianCalendar getData(){
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
