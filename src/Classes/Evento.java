package Classes;


import ClassesDAO.DonativoDAO;
import ClassesDAO.FuncionarioDAO;
import java.util.Date;
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
public class Evento {
    private int id;
    Date data;
    String local;
    String descricao;
    //private int id_donativo;
    private Map<Integer,Donativo> donativos;
    private Map<Integer,Funcionario> funcionarios;
    
    
    public Evento(Evento e){
        this.data = e.getData();
        this.descricao=e.getDescricao();
        this.id=e.getId();
        this.local=e.getLocal();
        //this.id_donativo=e.getId_donativo();
        this.donativos=new DonativoDAO(this.id);
        this.funcionarios=new FuncionarioDAO(this.id);
    }
    public Evento(){
        this.data = new Date();
        this.descricao="";
        this.local="";
        this.id=0;
        this.donativos=new DonativoDAO(this.id);
        this.funcionarios=new FuncionarioDAO(this.id);
    }
    public Evento(int i,Date d, String l, String de){
        this.data = d;
        this.descricao=de;
        this.id=i;
        this.local=l;
        //this.id_donativo=id_donativo;
        this.donativos=new DonativoDAO(this.id);
        this.funcionarios=new FuncionarioDAO(this.id);
    }

  
    public void setId(int id){
        this.id = id;
    }
    public void setData(Date d){
        this.data = d;
    }
    public void setLocal(String l){
        this.local = l;
    }
    public void setDescricao(String d){
        this.descricao = d;
    }
    public int getId(){
        return this.id;
    }
    public String getLocal(){
        return this.local;
    }
    public String getDescricao(){
        return this.descricao;
    }
    public Date getData(){
        return this.data;
    }
    
     public boolean Equals(Object o){
        if (this == o)
            return true;
        if ((o!=null) || (o.getClass()!=this.getClass()))
            return false;
        Evento e = (Evento) o;
        return this.descricao.equals(e.getDescricao())&&this.id==e.getId()&&this.local.equals(e.getLocal());
    }
    
    public Evento clone() { 
        return new Evento(this); 
    }
    public String toString() {
        StringBuilder s = new StringBuilder("------ Evento ---------\n");
        s.append("Id: ").append(id).append("\n");
        s.append("Descrição: ").append(descricao).append("\n");
        s.append("Local: ").append(local).append("\n");
        
        return s.toString();
    }
    
}
