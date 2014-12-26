package Classes;


import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Patrícia
 */
public class Familia {
    private String nome;
    private ArrayList<Membro> membros;
    private Membro representante;
    private String codPostal;
    private String localidade;
    private String rua;
    
    Familia(Familia f){
        this.nome = f.getNome();
        this.membros = f.getMembros();
        this.representante = f.getRepresentante();
        this.codPostal = f.getCodPostal();
        this.localidade = f.getLocalidade();
        this.rua = f.getRua();
    }
    Familia(){
        this.nome = "";
        this.membros = new ArrayList<Membro>();
        this.representante = new Membro();
        this.codPostal = "";
        this.localidade = "";
        this.rua = "";
    }
    Familia(String n, ArrayList<Membro> ms, Membro m, String c, String l, String r){
        this.nome = n;
        this.membros = ms;
        this.representante = m;
        this.codPostal = c;
        this.localidade = l;
        this.rua = r;
    }
    public void setCodPostal(String c){
        this.codPostal = c;
    }

    public void setLocalidade(String l){
        this.localidade = l;
    }

    public void setNome(String n){
        this.nome = n;
    }

    public void setRua(String r){
        this.rua = r;
    }
    public void setRepresentante(Membro m){
        this.representante = m;
    }
    public void setMembros(ArrayList<Membro> membros){
        this.membros = membros;
    }
    public String getCodPostal(){
        return this.codPostal;
    }
    public String getLocalidade(){
        return this.localidade;
    }
    public String getNome(){
        return this.nome;
    }
    public String getRua(){
        return this.rua;
    }
    public Membro getRepresentante(){
        return this.representante;
    }
    public ArrayList<Membro> getMembros(){
        return this.membros;
    }
    public boolean Equals(Object o){
        if (this == o)
            return true;
        if ((o!=null) || (o.getClass()!=this.getClass()))
            return false;
        Familia f = (Familia) o;
        return this.nome.equals(f.getNome())&&this.membros.equals(f.getMembros());
    }
    
    public Familia clone() { 
        return new Familia(this); 
    }
    public String toString() {
        StringBuilder s = new StringBuilder("------ Família ---------\n");
        s.append("Nome: ").append(nome).append("\n");
        s.append("Representante : ").append(representante).append("\n");
        s.append("Localidade: ").append(localidade).append("\n");
        s.append("Rua: ").append(rua).append("\n");
        s.append("Código Postal: ").append(codPostal).append("\n");
        s.append("Membros :\n");
        for(Membro m :membros)
            s.append(m.getNome());
        
        return s.toString();
    }
}
