package Classes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.HashMap;

/**
 *
 * @author Sandra
 */
public class Material {
int id = 0;
private String desc;
private double quantidade;

public Material() {
    this.desc = "";
    this.quantidade = 0.0;
    id = id +1;
}

public Material(String desc, Double quant) {
    this.desc = desc;
    this.quantidade = quant;
    this.id = id+1;
}


public Material (Material m){
    this.desc = m.getDescricao();
    this.quantidade = m.getQuantidade();
    this.id = m.getId();
}

public String getDescricao(){
    return this.desc;
}

public Double getQuantidade(){
    return this.quantidade;
}

public int getId(){
    return this.id;
}

public void setDesc(String desc){
    this.desc = desc;
}
public void setQuantidade(Double quant){
    this.quantidade = quant;
}
public void setId(int id){
    this.id = id;
}




public Material clone() {
    return new Material(this);
}

public String toString () {
StringBuilder sb = new StringBuilder();
        sb.append("Descrição: ").append(desc).append("Quantidade :").append(quantidade).append ("\n");
    
    return sb.toString();
}

public boolean equals(Object obj) {
    if(this == obj) return true; 
    if((obj == null) || (this.getClass() != obj.getClass())) return false;
    Material t = (Material) obj;
    return this.desc.equals(t.getDescricao()) ; 
}


}
