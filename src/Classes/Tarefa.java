package Classes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Sandra
 */
public class Tarefa {
private String nome;
private int id;

Tarefa(){
    this.nome=null;
}

Tarefa (String n, int i) {
    this.nome=n;
    this.id=i;
}

Tarefa (Tarefa t){
    this.nome=t.getNomeTarefa();
    this.id= t.getId();
}

public String getNomeTarefa(){
    return this.nome;
}
public int getId(){
    return this.id;
} 

public void setNome (String n){
    this.nome=n;
}

public void setId(int i){
    this.id=i;
}

public Tarefa clone() {
    return new Tarefa(this);
}

public String toString () {
StringBuilder sb = new StringBuilder();
    sb.append("Nome: ").append(this.getNomeTarefa()).append("\n");
    sb.append("Id:").append(this.getId()).append("\n");
    return sb.toString();
}

public boolean equals(Object obj) {
    if(this == obj) return true; 
    if((obj == null) || (this.getClass() != obj.getClass())) return false;
    Tarefa t = (Tarefa) obj;
    return this.nome.equals(t.getNomeTarefa()) && (this.id ==t.getId()); 
}

}
