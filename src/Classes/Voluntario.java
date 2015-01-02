package Classes;

import ClassesDAO.EquipaDAO;
import java.util.Date;


/**
 *
 * @author Sandra
 */
public class Voluntario {
private String nome;
private int id;
private boolean disponibilidade = true;
private Date dataNascimento;
private String telemovel;
private String localidade;
private String codPostal;
private String profissao;
private String eMail;
private String rua;   
private int id_equipa;

public Voluntario (String c,Date d,String e,String p,String l,String n, String r, String t, int id_equipa){
    this.codPostal = c;
    this.dataNascimento = d;
    this.eMail = e;
    this.profissao=p;
    this.localidade = l;
    this.nome = n;
    this.rua = r;
    this.telemovel = t;
    this.id = this.id+1;
    //this.id=id;
    this.disponibilidade = true;
    
    }
    
public Voluntario (){
    this.disponibilidade=true;
    this.codPostal = "";
    this.dataNascimento = new Date();
    this.profissao="";
    this.eMail = "";
    //this.id = this.id + 1;
    this.localidade = "";
    this.nome = "";
    this.rua = "";
    this.telemovel = "";
    this.id_equipa=0;
    }
public Voluntario (Voluntario v){
    this.disponibilidade=v.getDisponibilidade();
    this.codPostal = v.getCodPostal();
    this.dataNascimento = v.getDataNascimento();
    this.profissao=v.getProfissao();
    this.eMail = v.getEmail();
    this.id = v. getId();
    this.localidade = v.getLocalidade();
    this.nome = v.getNomeVoluntario();
    this.rua = v.getRua();
    this.telemovel = v.getTelemovel();
    this.id_equipa=v.getId_equipa();
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }
    
    public Boolean getDisponibilidade(){
         return this.disponibilidade;
    }
        
    public String getCodPostal(){
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

    public int getId_equipa() {
        return id_equipa;
    }
    
    public String getRua(){
        return this.rua;
    }
    public String getTelemovel(){
        return this.telemovel;
    }
    public Date getDataNascimento(){
        return this.dataNascimento;
    }
    public int getId(){
        return this.id;
    }

    public void setId_equipa(int id_equipa) {
        this.id_equipa = id_equipa;
    }
        
    public void setDisponilididade (Boolean b){
        this.disponibilidade=b;
    }
    public void setCodPostal(String c){
        this.codPostal = c;
    }
    public void setDataNascimento(Date d){
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
        s.append("Data de Nascimento: ").append(dataNascimento).append("\n");
        s.append("Telemovel: ").append(telemovel).append("\n");
        s.append("Email: ").append(eMail).append("\n");
        s.append("Localidade: ").append(localidade).append("\n");
        s.append("Rua: ").append(rua).append("\n");
        s.append("Código Postal: ").append(codPostal).append("\n");
        
        return s.toString();
    }
    
}


