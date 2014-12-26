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
public class Donativo {
    private String tipo;
    private int id = 0;
    private String descricao;
    private double quantidade;
    private float valor;
    
    Donativo(Donativo d){
        this.tipo = d.getTipo();
        this.id = d.getId();
        this.descricao = d.getDescricao();
        this.valor = d.getValor();
        this.quantidade = d.getQuantidade();
    }
    
    Donativo(){
       this.tipo = "";
       this.id = this.id +1;
       this.descricao = "";
       this.valor = 0;
       this.quantidade = 0.00; 
    }
    
    Donativo(String t, int i, String d, float v, double q){
       this.tipo = t;
       this.id = i;
       this.descricao = d;
       this.valor = v;
       this.quantidade = q; 
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
