package Classes;

import ClassesDAO.VoluntarioDAO;
import java.util.ArrayList;
import java.util.Map;

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
    private int id;
    private String nome;
    private String pais;
    private Map<Integer, Voluntario> voluntarios;

    public Equipa() {
        this.id=0;
        this.nome="";
        this.pais="";
        this.voluntarios=new VoluntarioDAO(this.id);
    }

    public Equipa(int id,String nome, String pais) {
        this.id = id;//id + 1;
        this.nome = nome;
        this.pais=pais;
        this.voluntarios=new VoluntarioDAO(this.id);
    }

    public Equipa(Equipa e) {
        this.id = e.getId();
        this.nome = e.getNome();
        this.pais=e.getPais();
        this.voluntarios=new VoluntarioDAO(this.id);
    }

    public String getNome() {
        return this.nome;
    }

    public int getId() {
        return this.id;
    }

    public String getPais() {
        return pais;
    }
    
    public void setNome(String n) {
        this.nome = n;
    }

    public void setId(int i) {
        this.id = i;
    }

    public Equipa clone() {
        return new Equipa(this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nome").append(nome).append("\n");
        sb.append("Id").append(id).append("\n");
        sb.append("Pais: ").append(pais).append("\n");;
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj == null) || (this.getClass() != obj.getClass())) {
            return false;
        }
        Equipa e = (Equipa) obj;
        return this.nome.equals(e.getNome()) && (this.id == e.getId());
    }

}
