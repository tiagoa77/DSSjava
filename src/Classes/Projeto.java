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
private String nome;
private int id;
private Familia familia;
private ArrayList <Tarefa> tarefas;
private ArrayList<Voluntario> voluntarios;

Projeto () {
    this.nome=null;
    this.tarefas= new ArrayList <Tarefa>();
    this.voluntarios= new ArrayList <Voluntario> ();
}

Projeto (String n, int id, Familia f,ArrayList <Tarefa> tarefa,ArrayList <Voluntario> v ) {
    this.nome=n;
    this.id=id;
    this.familia=f.clone();
    for(Tarefa t :tarefa){
        tarefas.add(t.clone());
        }
    for(Voluntario v1 : v){
        voluntarios.add(v1.clone());
        }
}

Projeto (Projeto p){
    this.nome= p.getNome();
    this.id=p.getId();
    this.familia=p.getFamilia();
    this.tarefas=p.getTarefas();
    this.voluntarios=p.getVoluntarios();
}

public String getNome() {
    return this. nome;
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
    
public void setNome(String nome){
    this.nome=nome;
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
public Projeto clone() {
   return new Projeto(this); 
}
public String toString() {
StringBuilder sb= new StringBuilder();
    sb.append("Nome").append(nome).append("\n");
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
    return this.nome.equals(p.getNome()) && (this.id ==p.getId() && this.familia.equals(p.getFamilia()) && this.voluntarios.equals(p.getVoluntarios()) && this.tarefas.equals(p.getTarefas()));
   }

}

