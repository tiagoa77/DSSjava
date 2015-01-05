package Classes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;

/**
 *
 * @author Sandra
 */
public class Projeto {
private String estado;
private int id=0;
private Familia familia;
private ArrayList <Tarefa> tarefas; // MUDAR PARA MAPS
private ArrayList<Voluntario> voluntarios; //MUDAR PARA MAPS


public Projeto () {
    this.estado="";
    this.tarefas= new ArrayList <Tarefa>();
    this.voluntarios= new ArrayList <Voluntario> ();
}

public Projeto (String n, Familia f,ArrayList <Tarefa> tarefa,ArrayList <Voluntario> v ) {
    this.estado=n;
    this.id=id+1;
    this.familia=f.clone();
    for(Tarefa t :tarefa){
        tarefas.add(t.clone());
        }
    for(Voluntario v1 : v){
        voluntarios.add(v1.clone());
        }
}

public Projeto (Projeto p){
    this.estado= p.getestado();
    this.id=p.getId();
    this.familia=p.getFamilia();
    this.tarefas=p.getTarefas();
    this.voluntarios=p.getVoluntarios();
}

public String getestado() {
    return this.estado;
}

public int getId() {
    return this.id;
}

public Familia getFamilia() {
    return this.familia;
}

public ArrayList <Tarefa> getTarefas(){
    return this.tarefas;
} 


public ArrayList <Voluntario> getVoluntarios() {
    return this.voluntarios;
}
    
public void setestado(String estado){
    this.estado=estado;
}

public void setId(int id){
    this.id =id;
}

public void setFamilia (Familia f){
    this.familia=f;
}

public void setTarefas (ArrayList <Tarefa> f) {
    for(Tarefa t: f){
        tarefas.add(t.clone());
    }
}

public void setVoluntarios(ArrayList <Voluntario> v) {
    for(Voluntario t: v){
        voluntarios.add(t.clone());
}
}
    
public int addTarefa(Tarefa tar){
    for(Tarefa t : this.tarefas){
        if(tar.getNomeTarefa().equals(t.getNomeTarefa())){
           return -1; 
        }
    }
      tarefas.add(tar);
      return 1;
}
    

public Projeto clone() {
   return new Projeto(this); 
}
public String toString() {
StringBuilder sb= new StringBuilder();
    sb.append("estado").append(estado).append("\n");
    sb.append("Id").append(id).append("\n");
    sb.append("Familia: ").append(familia).append("\n");
    sb.append("Tarefas");
    for(Tarefa t1: tarefas){
       sb.append(t1.getNomeTarefa()).append("\n");
    }
    sb.append("Voluntarios");
    for(Voluntario v1: voluntarios){
       sb.append(v1.getNomeVoluntario()).append("\n");
    }
    return sb.toString();
}

public boolean equals(Object obj) {
    if(this == obj) return true; 
    if((obj == null) || (this.getClass() != obj.getClass())) return false;
    Projeto p = (Projeto) obj;
    return this.estado.equals(p.getestado()) && (this.id ==p.getId() && this.familia.equals(p.getFamilia()) && this.voluntarios.equals(p.getVoluntarios()) && this.tarefas.equals(p.getTarefas()));
   }

}

