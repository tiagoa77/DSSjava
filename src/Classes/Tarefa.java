package Classes;

import ClassesDAO.ProjetoDAO;
import java.util.Date;
import java.util.Map;

public class Tarefa {
    
    private int id;
    private double custo;
    private Date dataLimite;
    private String descricao;
    
    public Tarefa() {
        this.id=this.id+1;
        this.custo = 0.0;
        this.dataLimite = new Date();
        this.descricao = "";
    }
    
    
    public Tarefa(int id, double c, Date d, String desc) {
        this.id = id;
        this.custo = c;
        this.dataLimite = d;
        this.descricao = desc;
    }

    public Tarefa(Tarefa t) {
        this.custo = t.getCusto();
        this.dataLimite = t.getDataLimite();
        this.descricao = t.getDescricao();
        this.id = t.getId();
    }

    public double getCusto() {
        return this.custo;
    }
    
    public Date getDataLimite() {
        return this.dataLimite;
    }
    
    public String getDescricao() {
        return this.descricao;
    }

    public int getId() {
        return this.id;
    }

    public void setDescricao(String d) {
        this.descricao = d;
    }

    public void setId(int i) {
        this.id = i;
    }

    public Tarefa clone() {
        return new Tarefa(this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
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
        return this.descricao.equals(t.getDescricao()) && (this.id == t.getId());
    }

}
