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
    private int idprojecto;
    private int idfamilia;
    
    Candidatura(Candidatura c){
        this.descricao = c.getDescricao();
        this.estado = c.getEstado();
        this.id = c.getId();
        this.idprojecto=c.getIdprojecto();
        this.idfamilia=c.getIdfamilia();
    }
   
    Candidatura(String d, String e, int id, int id_projecto, int id_familia){
        this.descricao = d;
        this.estado = e;
        this.id = id;
        this.idprojecto=id_projecto;
        this.idfamilia=id_familia;
    }
    
    Candidatura(){
        this.descricao = "";
        this.estado = "";
        this.id = this.id + 1;
        this.idprojecto=0;
        this.idfamilia=0;
    }

    public int getIdprojecto() {
        return idprojecto;
    }

    public int getIdfamilia() {
        return idfamilia;
    }

    public void setIdprojecto(int idprojecto) {
        this.idprojecto = idprojecto;
    }

    public void setIdfamilia(int idfamilia) {
        this.idfamilia = idfamilia;
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
