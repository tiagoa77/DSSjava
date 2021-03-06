package Classes;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.GregorianCalendar;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Patrícia
 */
public class Funcionario {

    private int id = 0;
    private String nome;
    //private String dataNascimento;
    private String telemovel;
    private String localidade;
    private String codPostal;
    private String eMail;
    private String login;
    private String password;
    private String rua;
    private int id_evento;

    public Funcionario(Funcionario f) {
        this.codPostal = f.getcodPostal();
        //this.dataNascimento = f.getDataNascimento();
        this.eMail = f.getEmail();
        this.id = f.getId();
        this.localidade = f.getLocalidade();
        this.login = f.getLogin();
        this.nome = f.getNome();
        this.password = f.getPassword();
        this.rua = f.getRua();
        this.telemovel = f.getTelemovel();
        this.id_evento = f.getId_evento();
    }

    public Funcionario(String c, String e, int i, String l, String lg, String n, String p, String r, String t, int id) {
        this.codPostal = c;
        //this.dataNascimento = d;
        this.eMail = e;
        this.id = i;
        this.localidade = l;
        this.login = lg;
        this.nome = n;
        this.password = p;
        this.rua = r;
        this.telemovel = t;
        this.id_evento = id;
    }

    public Funcionario() {
        this.codPostal = "";
        //this.dataNascimento = "";
        this.eMail = "";
        this.id = this.id + 1;
        this.localidade = "";
        this.login = "";
        this.nome = "";
        this.password = "";
        this.rua = "";
        this.telemovel = "";
        this.id_evento = 0;
    }

    public int getId_evento() {
        return id_evento;
    }

    public void setCodPostal(String c) {
        this.codPostal = c;
    }

    public void setEmail(String e) {
        this.eMail = e;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setLocalidade(String l) {
        this.localidade = l;
    }

    public void setLogin(String l) {
        this.login = l;
    }

    public void setNome(String n) {
        this.nome = n;
    }

    public void setPassword(String p) {
        this.password = p;
    }

    public void setRua(String r) {
        this.rua = r;
    }

    public void setTelemovel(String t) {
        this.telemovel = t;
    }

    public String getcodPostal() {
        return this.codPostal;
    }

    public String getEmail() {
        return this.eMail;
    }

    public String getLocalidade() {
        return this.localidade;
    }

    public String getLogin() {
        return this.login;
    }

    public String getNome() {
        return this.nome;
    }

    public String getPassword() {
        return this.password;
    }

    public String getRua() {
        return this.rua;
    }

    public String getTelemovel() {
        return this.telemovel;
    }

    public int getId() {
        return this.id;
    }

    public void setId_evento(int id_evento) {
        this.id_evento = id_evento;
    }

    /*
     Método para aceitar uma candidatura passada como argumento
     
    public void aceitaCandidatura(Candidatura c) {
        HabitatClass.getCandidaturas().get(c.getId()).setEstado("Aceite");
    }
    
     Método para rejeitar uma candidatura passada como argumento
    

    public void rejeitaCandidatura(Candidatura c) {
        HabitatClass.getCandidaturas().get(c.getId()).setEstado("Rejeitada");
    }

     Método para analisar uma candidatura passada como argumento


    public void analisaCandidatura(Candidatura c) {
        HabitatClass.getCandidaturas().get(c.getId()).setEstado("A analisar");
    } 
*/
    /*
    public static String encriptarPassword (String pw) {
        byte[] pwB = pw.getBytes() ;
        byte[] pwEnc = null ;
        String res = null ;        
        try {
            MessageDigest md = MessageDigest.getInstance("MD5") ;
            pwEnc = md.digest(pwB) ;
            BigInteger big = new BigInteger(1, pwEnc) ;
            res = big.toString(16) ;            
        } catch (NoSuchAlgorithmException e) {throw new NullPointerException(e.getMessage()) ;}
        return res ;
    }

    public boolean passwordCorresponde(String pw) {
        return this.password.equals(encriptarPassword(pw));
    }
    */
    
    
    public boolean Equals(Object o) {
        if (this == o) {
            return true;
        }
        if ((o != null) || (o.getClass() != this.getClass())) {
            return false;
        }
        Funcionario f = (Funcionario) o;
        return this.nome.equals(f.getNome()) && this.id == f.getId();//&&this.dataNascimento.equals(f.getDataNascimento()*/)
    }

    public Funcionario clone() {
        return new Funcionario(this);
    }

    public String toString() {
        StringBuilder s = new StringBuilder("------ Funcionário ---------\n");
        s.append("Id: ").append(id).append("\n");
        s.append("Nome: ").append(nome).append("\n");
        //s.append("Data de Nascimento: ").append(dataNascimento).append("\n");
        s.append("Telemovel: ").append(telemovel).append("\n");
        s.append("Email: ").append(eMail).append("\n");
        s.append("Localidade: ").append(localidade).append("\n");
        s.append("Rua: ").append(rua).append("\n");
        s.append("Código Postal: ").append(codPostal).append("\n");

        return s.toString();
    }

}
