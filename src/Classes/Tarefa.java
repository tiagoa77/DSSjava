package Classes;

import ClassesDAO.ProjetoDAO;
import java.util.Map;

public class Tarefa {
    
    private int id;
    private String nome;
    private Map<Integer,Projeto> projetos;
    
    public Tarefa() {
        this.id=this.id+1;
        this.nome = "";
        this.projetos=new ProjetoDAO(this.id);
    }

    public Tarefa(String n) {
        this.id = id + 1;
        this.nome = n;
    }

    public Tarefa(Tarefa t) {
        this.nome = t.getNomeTarefa();
        this.id = t.getId();
    }

    public String getNomeTarefa() {
        return this.nome;
    }

    public int getId() {
        return this.id;
    }

    public void setNome(String n) {
        this.nome = n;
    }

    public void setId(int i) {
        this.id = i;
    }

    public Tarefa clone() {
        return new Tarefa(this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nome: ").append(this.getNomeTarefa()).append("\n");
        sb.append("Id:").append(this.getId()).append("\n");
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj == null) || (this.getClass() != obj.getClass())) {
            return false;
        }
        Tarefa t = (Tarefa) obj;
        return this.nome.equals(t.getNomeTarefa()) && (this.id == t.getId());
    }

}
