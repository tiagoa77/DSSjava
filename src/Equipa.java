
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Sandra
 */
public class Equipa {
private String nome;
private int id;
private ArrayList <Voluntario> voluntarios;

Equipa (){
this.nome=null;
this.voluntarios= new ArrayList <Voluntario> ();
}

Equipa (String n, int i, ArrayList <Voluntario> v){
this.nome=n;
this.id=i;
for (Voluntario v1 : v) {
  voluntarios.add(v1.clone());  
    }
}

Equipa (Equipa e) {
this.nome=e.getNome();
this.id=e.getId();
this.voluntarios=e.getVoluntarios();
}

public String getNome(){
    return this.nome;
}
public int getId(){
    return this.id;
} 

public ArrayList <Voluntario> getVoluntarios(){
    return this.voluntarios;
}

public void setNome (String n){
    this.nome=n;
}

public void setId(int i){
    this.id=i;
}

public void setVoluntarios(ArrayList <Voluntario> v){
    for(Voluntario v1: v){
        voluntarios.add(v1);
    }
}

public int remVoluntario(Voluntario v){
    for (Voluntario v1 : voluntarios){
        if (v1.equals(v)) {
            voluntarios.remove(v);
            return 1;
            }
        }
    return (-1);
}

public int addVoluntario(Voluntario v){
    for (Voluntario v1 : voluntarios){
        if (v1.equals(v.clone())) {
            return -1;
            }
        }
    voluntarios.add(v);
    return (-1);
}

public Equipa clone() {
    return new Equipa(this);
}

public String toString() {
StringBuilder sb= new StringBuilder();
    sb.append("Nome").append(nome).append("\n");
    sb.append("Id").append(id).append("\n");
    sb.append("Voluntarios");
    for(Voluntario v1: voluntarios){
       sb.append(v1.getNomeVoluntario()).append("\n");
    }
    return sb.toString();
}

public boolean equals(Object obj) {
    if(this == obj) return true; 
    if((obj == null) || (this.getClass() != obj.getClass())) return false;
    Equipa e = (Equipa) obj;
    return this.nome.equals(e.getNome()) && (this.id ==e.getId())&& this.voluntarios.equals(e.getVoluntarios()); 
}

}
