package Classes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Sandra
 */
public class Projeto {

    private String estado;
    private int id = 0;
    private Date dataAprov;
    private int id_familia;
    private Map<Integer,Tarefa> tarefas; // MUDAR PARA MAPS
    private Map<Integer,Voluntario> voluntarios; //MUDAR PARA MAPS

    public Projeto() {
        this.estado = "";
        this.dataAprov=new Date();
        this.tarefas = new HashMap<>();
        this.voluntarios = new HashMap<>();
    }
    
    public Projeto(int id,Map<Integer,Tarefa> tarefas, Map<Integer,Voluntario> voluntarios) {
        this.id = id;
        this.tarefas=tarefas;
        this.voluntarios=voluntarios;
    }
    
    public Projeto(int id, Date d,Map<Integer,Tarefa> tarefas, Map<Integer,Voluntario> voluntarios) {
        this.id = id;
        this.dataAprov=d;
        this.tarefas=tarefas;
        this.voluntarios=voluntarios;
    }
    
    public Projeto(int id,String n, int f, Map<Integer,Tarefa> tarefas, Map<Integer,Voluntario> voluntarios) {
        this.id = id;
        this.estado = n;
        //this.id = id + 1;
        this.id_familia = f;
        this.tarefas=tarefas;
        this.voluntarios=voluntarios;
    }

    public Projeto(Projeto p) {
        this.estado = p.getestado();
        this.id = p.getId();
        this.id_familia = p.getId_Familia();
        this.tarefas = p.getTarefas();
        this.voluntarios = p.getVoluntarios();
    }

    public Date getDataAprov() {
        return dataAprov;
    }

    public String getestado() {
        return this.estado;
    }

    public int getId() {
        return this.id;
    }

    public int getId_Familia() {
        return this.id_familia;
    }

    public Map<Integer, Tarefa> getTarefas() {
        return tarefas;
    }

    public Map<Integer, Voluntario> getVoluntarios() {
        return voluntarios;
    }

    

    public void setestado(String estado) {
        this.estado = estado;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFamilia(int f) {
        this.id_familia = f;
    }

    public void setTarefas(Map<Integer, Tarefa> tarefas) {
        this.tarefas = tarefas;
    }

    public void setVoluntarios(Map<Integer, Voluntario> voluntarios) {
        this.voluntarios = voluntarios;
    }

    
/*
    public int addTarefa(Tarefa tar) {
        for (Tarefa t : this.tarefas) {
            if (tar.getId()==t.getId()) {
                return -1;
            }
        }
        tarefas.add(tar);
        return 1;
    }
*/
    public Projeto clone() {
        return new Projeto(this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("estado").append(estado).append("\n");
        sb.append("Id").append(id).append("\n");
        sb.append("Familia: ").append(id_familia).append("\n");
        sb.append("Tarefas");
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj == null) || (this.getClass() != obj.getClass())) {
            return false;
        }
        Projeto p = (Projeto) obj;
        return this.estado.equals(p.getestado()) && (this.id == p.getId() && (this.id_familia== p.getId_Familia()) && this.voluntarios.equals(p.getVoluntarios()) && this.tarefas.equals(p.getTarefas()));
    }

}
