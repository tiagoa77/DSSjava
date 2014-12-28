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
public class Voluntario {
private String nome;
private int id;
private boolean disponibilidade = true;
private String dataNascimento;
private String telemovel;
private String localidade;
private String codPostal;
private String eMail;
private String rua;   
private Equipa equipa;

public Voluntario (String c,String d,String e,String l,String n, String r, String t, Equipa eq){
    this.codPostal = c;
    this.dataNascimento = d;
    this.eMail = e;
    this.localidade = l;
    this.nome = n;
    this.rua = r;
    this.telemovel = t;
    this.id = this.id+1;
    this.disponibilidade = true;
    this.equipa = eq;
    
    }
    
public Voluntario (){
    this.disponibilidade=true;
    this.codPostal = "";
    this.dataNascimento = "";
    this.eMail = "";
    this.id = this.id + 1;
    this.localidade = "";
    this.nome = "";
    this.rua = "";
    this.telemovel = "";
    this.equipa = new Equipa();
    }
public Voluntario (Voluntario v){
    this.disponibilidade=v.getDisponibildade();
    this.codPostal = v.getcodPostal();
    this.dataNascimento = v.getDataNascimento();
    this.eMail = v.getEmail();
    this.id = v. getId();
    this.localidade = v.getLocalidade();
    this.nome = v.getNomeVoluntario();
    this.rua = v.getRua();
    this.telemovel = v.getTelemovel();
    this.equipa = v.getEquipa();
    }
    
    public Equipa getEquipa(){
        return this.equipa;
    }
    
    public Boolean getDisponibildade(){
         return this.disponibilidade;
    }
        
    public String getcodPostal(){
        return this.codPostal;
    }
    public String getEmail(){
        return this.eMail;
    }
    public String getLocalidade(){
        return this.localidade;
    }

    public String getNomeVoluntario(){
        return this.nome;
    }

    public String getRua(){
        return this.rua;
    }
    public String getTelemovel(){
        return this.telemovel;
    }
    public String getDataNascimento(){
        return this.dataNascimento;
    }
    public int getId(){
        return this.id;
    }
    
    public void setEquipa(Equipa e){
        this.equipa = e;
    }
    
    public void setDisponilididade (Boolean b){
        this.disponibilidade=b;
    }
    public void setCodPostal(String c){
        this.codPostal = c;
    }
    public void setDataNascimento(String d){
        this.dataNascimento = d;
    }
    public void setEmail(String e){
        this.eMail = e;
    }
    public void setId(int i){
        this.id = i;
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
    public void setTelemovel(String t){
        this.telemovel = t;
    }
    
    public void alteraDisponibilidade(){
        if (this.disponibilidade=true) this.disponibilidade =false;
        else this.disponibilidade= true;
    }
    
    public boolean Equals(Object o){
        if (this == o)
            return true;
        if ((o!=null) || (o.getClass()!=this.getClass()))
            return false;
        Voluntario f = (Voluntario) o;
        return this.nome.equals(f.getNomeVoluntario())&&this.id==f.getId()&&this.dataNascimento.equals(f.getDataNascimento());
    }
    
    public Voluntario clone() { 
        return new Voluntario(this); 
    }
    public String toString() {
        StringBuilder s = new StringBuilder("------ Voluntario ---------\n");
        s.append("Id: ").append(id).append("\n");
        s.append("Disponibilidade:").append(disponibilidade).append("/n");
        s.append("Nome: ").append(nome).append("\n");
        s.append("Equipa : ").append(equipa.getNome()).append("\n");
        s.append("Data de Nascimento: ").append(dataNascimento).append("\n");
        s.append("Telemovel: ").append(telemovel).append("\n");
        s.append("Email: ").append(eMail).append("\n");
        s.append("Localidade: ").append(localidade).append("\n");
        s.append("Rua: ").append(rua).append("\n");
        s.append("Código Postal: ").append(codPostal).append("\n");
        
        return s.toString();
    }
    
}


