package Classes;


import java.util.GregorianCalendar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Patrícia
 */
public class Membro {
    private String nome;
    private GregorianCalendar dataNascimento;
    private String profissao;
    private String nif;
    private String bi;
    
    public Membro(Membro m){
        this.nome = m.getNome();
        this.bi = m.getBi();
        this.dataNascimento = m.getDataNascimento();
        this.nif = m.getNif();
        this.profissao = m.getProfissao();
    }
    public Membro(){
        this.nome = "";
        this.bi = "";
        this.dataNascimento = new GregorianCalendar();
        this.nif = "";
        this.profissao = "";
    }
    public Membro(String n, String b, String nif, String p, GregorianCalendar d){
        this.nome = n;
        this.bi = b;
        this.dataNascimento = d;
        this.nif = nif;
        this.profissao = p;
    }
    public void setNome(String n){
        this.nome = n;
    }
    public void setBi(String b){
        this.bi = b;
    }
    public void setNif(String n){
        this.nif = n;
    }
    public void setProfissao(String p){
        this.profissao = p;
    }
    public void setDataNascimento(GregorianCalendar d){
        this.dataNascimento = d;
    }
    public String getNome(){
        return this.nome;
    }
    public String getBi(){
        return this.bi;
    }
    public String getNif(){
        return this.nif;
    }
    public String getProfissao(){
        return this.nome;
    }
    public GregorianCalendar getDataNascimento(){
        return this.dataNascimento;
    }
    
    public boolean Equals(Object o){
        if (this == o)
            return true;
        if ((o!=null) || (o.getClass()!=this.getClass()))
            return false;
        Membro f = (Membro) o;
        return this.nif.equals(f.getNif());
    }
    
    public Membro clone() { 
        return new Membro(this); 
    }
    public String toString() {
        StringBuilder s = new StringBuilder("------ Membro ---------\n");
        s.append("Nome: ").append(nome).append("\n");
        s.append("Data de Nascimento: ").append(dataNascimento).append("\n");
        s.append("Profissão : ").append(profissao).append("\n");
        s.append("BI: ").append(bi).append("\n");
        s.append("NIF: ").append(nif).append("\n");
        
        return s.toString();
    }
    
}
