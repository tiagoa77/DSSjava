package Classes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Patrícia
 */
public class Candidatura {
    
    private String descricao;
    private String estado;
    private int id = 0;
    
    Candidatura(Candidatura c){
        this.descricao = c.getDescricao();
        this.estado = c.getEstado();
        this.id = c.getId();
    }
   
    Candidatura(String d, String e, int id){
        this.descricao = d;
        this.estado = e;
        this.id = id;
    }
    
    Candidatura(){
        this.descricao = "";
        this.estado = "";
        this.id = this.id + 1;
    }
    
    Candidatura (String d, String e){
        this.descricao = d;
        this.estado = e;
        this.id = this.id + 1;
    }
    
    public void setDescricao(String d){
        this.descricao = d;
    }
    public void setEstado(String e){
        this.estado = e;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getDescricao(){
        return this.descricao;
    }
    public String getEstado(){
        return this.estado;
    }
    public int getId(){
        return this.id;
    }
   
    public boolean Equals(Object o){
        if (this == o)
            return true;
        if ((o!=null) || (o.getClass()!=this.getClass()))
            return false;
        Candidatura c = (Candidatura) o;
        return this.descricao.equals(c.getDescricao())&&this.estado.equals(c.getEstado())&&this.id==c.getId();
    }
    
    public Candidatura clone() { 
        return new Candidatura(this); 
    }
    public String toString() {
        StringBuilder s = new StringBuilder("------ Candidatura ---------\n");
        s.append("Id: ").append(id).append("\n");
        s.append("Descrição: ").append(descricao).append("\n");
        s.append("Estado: ").append(estado).append("\n");
        
        return s.toString();
    } 
}
