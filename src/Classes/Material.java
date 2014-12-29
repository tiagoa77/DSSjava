package Classes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Sandra
 */
public class Material {
int id = 0;
private String desc;
private double stock;
private int id_projecto;
private int id_donativo;



public Material() {
    this.desc = "";
    this.stock = 0.0;
    this.id = id +1;
    this.id_projecto=0;
    this.id_donativo=0;
}

public Material(String desc, Double quant,int id_donativo,int id_projecto) {
    this.desc = desc;
    this.stock = quant;
    this.id = id+1;
    this.id_donativo=id_donativo;
    this.id_projecto=id_projecto;
}


public Material (Material m){
    this.desc = m.getDescricao();
    this.stock = m.getStock();
    this.id = m.getId();
    this.id_donativo=m.getId_donativo();
    this.id_projecto=m.getId_projecto();
}

    public String getDesc() {
        return desc;
    }

    public double getStock() {
        return stock;
    }

    public int getId_projecto() {
        return id_projecto;
    }

    public int getId_donativo() {
        return id_donativo;
    }



public String getDescricao(){
    return this.desc;
}

public int getId(){
    return this.id;
}

public void setDesc(String desc){
    this.desc = desc;
}
public void setStock(Double quant){
    this.stock = quant;
}
public void setId(int id){
    this.id = id;
}




public Material clone() {
    return new Material(this);
}

public String toString () {
StringBuilder sb = new StringBuilder();
        sb.append("Descrição: ").append(desc).append("Stock :").append(stock).append ("\n");
    
    return sb.toString();
}

public boolean equals(Object obj) {
    if(this == obj) return true; 
    if((obj == null) || (this.getClass() != obj.getClass())) return false;
    Material t = (Material) obj;
    return this.desc.equals(t.getDescricao()) ; 
}


}
