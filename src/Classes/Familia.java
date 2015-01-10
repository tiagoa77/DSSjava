package Classes;


import ClassesDAO.MembroDAO;
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
public class Familia {
    private int idFamilia;
    private String nome;
    private String codPostal;
    private String localidade;
    private String rua;
    private Map<Integer,Membro> membros;
   
    
    public Familia(Familia f){
        this.idFamilia=f.getIdFamilia();
        this.nome = f.getNome();
        this.membros = new MembroDAO();
        this.codPostal = f.getCodPostal();
        this.localidade = f.getLocalidade();
        this.rua = f.getRua();
    }
    public Familia(){
        this.idFamilia=0;
        this.nome = "";
        this.codPostal = "";
        this.localidade = "";
        this.rua = "";
    }
    public Familia(int id, String n, String c, String l, String r){
        this.idFamilia=id;
        this.nome = n;
        this.membros = new MembroDAO();
        this.codPostal = c;
        this.localidade = l;
        this.rua = r;
    }
    public void setCodPostal(String c){
        this.codPostal = c;
    }

    public int getIdFamilia() {
        return idFamilia;
    }

    public void setIdFamilia(int idFamilia) {
        this.idFamilia = idFamilia;
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

    public Map<Integer, Membro> getMembros() {
        return membros;
    }

    public void setMembros(Map<Integer, Membro> membros) {
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
   
    
    public int addMembro(Membro mem,int id){
        for(int i: membros.keySet()){
            if (this.membros.get(i).getNif().equals(mem.getNif()))
                return -1;
        }
            
        membros.put(id,mem);
        return 1;
           
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
      
        s.append("Localidade: ").append(localidade).append("\n");
        s.append("Rua: ").append(rua).append("\n");
        s.append("Código Postal: ").append(codPostal).append("\n");
        s.append("Membros :\n");
        for(int i :this.membros.keySet())
            s.append(this.membros.get(i).getNome());
        
        return s.toString();
    }
}
