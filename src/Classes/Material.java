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
private HashMap <String,Integer> materiais;

Material() {
this.materiais= new HashMap <String, Integer> ();
}

Material(HashMap <String, Integer> m) {
for (String s : m.keySet()){
    materiais.put(s,m.get(s));
}
}

Material (Material m){
this.materiais=m.getMateriais();
}

public HashMap <String,Integer> getMateriais(){
    return this.materiais;
}

public void setMateriais(HashMap <String,Integer> m){
    this.materiais=m;
}

public int addMaterial (String s, int quant){
    for (String s1: materiais.keySet()){
       if (s1.equals(s)){
           int a=materiais.get(s1);
           a=a+quant;
           materiais.replace(s1,a);
           return 1;
       } 
    }
    materiais.put(s,quant);
    return 1;

}

public int remMaterial (String s, int quant){
    for (String s1: materiais.keySet()){
       if (s1.equals(s)){
           materiais.remove(s1);
       } 
    }
    
    return -1;

}


public Material clone() {
    return new Material(this);
}

public String toString () {
StringBuilder sb = new StringBuilder();
    for(String s : materiais.keySet()){
        sb.append("Nome: ").append(s).append("Quantidade ").append(materiais.get(s)).append ("\n");
    }
    return sb.toString();
}

public boolean equals(Object obj) {
    if(this == obj) return true; 
    if((obj == null) || (this.getClass() != obj.getClass())) return false;
    Material t = (Material) obj;
    return this.materiais.equals(t.getMateriais()) ; 
}


}
