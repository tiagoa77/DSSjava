/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.GregorianCalendar;

/**
 *
 * @author Sandra
 */
public class Voluntario {
private String nome;
private int id;
private boolean disponibilidade = true;
private GregorianCalendar dataNascimento;
private String telemovel;
private String localidade;
private String codPostal;
private String eMail;
private String login;
private String password;
private String rua;   

Voluntario (String c,GregorianCalendar d,String e,String l,String lg, String n, String p, String r, String t){
    this.codPostal = c;
    this.dataNascimento = d;
    this.eMail = e;
    this.localidade = l;
    this.login = lg;
    this.nome = n;
    this.password =p;
    this.rua = r;
    this.telemovel = t;
    this.id = this.id+1;
    this.disponibilidade = true;
    }
    
Voluntario (){
    this.disponibilidade=true;
    this.codPostal = "";
    this.dataNascimento = new GregorianCalendar();
    this.eMail = "";
    this.id = this.id + 1;
    this.localidade = "";
    this.login = "";
    this.nome = "";
    this.password ="";
    this.rua = "";
    this.telemovel = "";
    }
Voluntario (Voluntario v){
    this.disponibilidade=v.getDisponibildade();
    this.codPostal = v.getcodPostal();
    this.dataNascimento = v.getDataNascimento();
    this.eMail = v.getEmail();
    this.id = v. getId();
    this.localidade = v.getLocalidade();
    this.login = v.getLogin();
    this.nome = v.getNomeVoluntario();
    this.password =v.getPassword();
    this.rua = v.getRua();
    this.telemovel = v.getTelemovel();
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
    public String getLogin(){
        return this.login;
    }
    public String getNomeVoluntario(){
        return this.nome;
    }
    public String getPassword(){
        return this.password;
    }
    public String getRua(){
        return this.rua;
    }
    public String getTelemovel(){
        return this.telemovel;
    }
    public GregorianCalendar getDataNascimento(){
        return this.dataNascimento;
    }
    public int getId(){
        return this.id;
    }
    
    public void setDisponilididade (Boolean b){
        this.disponibilidade=b;
    }
    public void setCodPostal(String c){
        this.codPostal = c;
    }
    public void setDataNascimento(GregorianCalendar d){
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
   public void setLogin(String l){
        this.login = l;
    }
    public void setNome(String n){
        this.nome = n;
    }
    public void setPassword(String p){
        this.password = p;
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
        s.append("Data de Nascimento: ").append(dataNascimento).append("\n");
        s.append("Telemovel: ").append(telemovel).append("\n");
        s.append("Email: ").append(eMail).append("\n");
        s.append("Localidade: ").append(localidade).append("\n");
        s.append("Rua: ").append(rua).append("\n");
        s.append("Código Postal: ").append(codPostal).append("\n");
        
        return s.toString();
    }
    
}


