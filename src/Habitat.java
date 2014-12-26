/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.HashMap;

/**
 *
 * @author Sandra
 */
public class Habitat {
private HashMap<Integer,Projeto> projetos;
private HashMap<Integer,Voluntario> voluntarios;
private HashMap<Integer,Funcionario> funcionarios;
private static HashMap<Integer,Candidatura> candidaturas;
private HashMap<Integer,Equipa> equipas;
private HashMap<Integer,Familia>familias;
private HashMap<Integer,Donativo> donativos;
private HashMap<Integer,Doador> doadores;
private HashMap<Integer,Evento> eventos;


Habitat () {
this.projetos = new HashMap<Integer,Projeto> () ;
this.voluntarios = new HashMap <Integer,Voluntario> () ;
this.funcionarios= new HashMap <Integer,Funcionario> () ;
this.candidaturas= new HashMap <Integer,Candidatura> () ;
this.equipas= new HashMap <Integer,Equipa> () ;
this.familias= new HashMap <Integer,Familia> () ;
this.donativos= new HashMap <Integer,Donativo> () ;
this.doadores= new HashMap <Integer,Doador> () ;
this.eventos= new HashMap <Integer,Evento> () ;
}

Habitat (HashMap<Integer,Projeto> p ,HashMap<Integer,Voluntario> v, HashMap<Integer,Funcionario> f, HashMap<Integer,Candidatura> c, HashMap<Integer,Equipa> e, HashMap<Integer,Familia> fam, HashMap<Integer,Donativo> dona, HashMap<Integer,Doador> doa, HashMap<Integer,Evento> event ) {
for(Integer i :p.keySet()){
    projetos.put(i,p.get(i).clone());
}
for(Integer i :v.keySet()){
    voluntarios.put(i,v.get(i).clone());
}
for(Integer i :f.keySet()){
    funcionarios.put(i,f.get(i).clone());
}
for(Integer i :c.keySet()){
    candidaturas.put(i,c.get(i).clone());
}
for(Integer i :e.keySet()){
    equipas.put(i,e.get(i).clone());
}

for(Integer i :fam.keySet()){
    familias.put(i,fam.get(i).clone());
}
for(Integer i :dona.keySet()){
    donativos.put(i,dona.get(i).clone());
}
for(Integer i :doa.keySet()){
    doadores.put(i,doa.get(i).clone());
}

for(Integer i :event.keySet()){
    eventos.put(i,event.get(i).clone());
}
}

Habitat (Habitat h) {
this.projetos=h.getProjetos();
this.voluntarios=h.getVoluntarios();
this.funcionarios=h.getFuncionarios();
this.candidaturas=h.getCandidaturas();
this.equipas= h.getEquipas();
this.familias=h.getFamilias();
this.donativos=h.getDonativos();
this.doadores=h.getDoadores();
this.eventos=h.getEventos();
}

public HashMap<Integer,Projeto> getProjetos(){
    return this.projetos;
}

public HashMap<Integer,Voluntario> getVoluntarios(){
    return this.voluntarios;
}

public HashMap<Integer,Funcionario> getFuncionarios() {
    return this.funcionarios;
}

public static HashMap<Integer,Candidatura> getCandidaturas() {
    return candidaturas;
}

public HashMap<Integer,Equipa> getEquipas () {
    return this.equipas;
}

public HashMap<Integer,Familia> getFamilias () {
    return this.familias;
}

public HashMap<Integer,Donativo> getDonativos (){
    return this.donativos;
}

public HashMap<Integer,Doador> getDoadores () {
    return this.doadores;
}

public HashMap<Integer,Evento> getEventos () {
    return this.eventos;
}

public void setProjetos(HashMap<Integer,Projeto> proj) {
    for (Integer i: proj.keySet()){
        projetos.put(i, proj.get(i).clone());
    }
}

public void setVoluntarios(HashMap<Integer,Voluntario> vol) {
    for (Integer i: vol.keySet()){
       voluntarios.put(i, vol.get(i).clone());
    }
}

public void setFuncionarios(HashMap<Integer,Funcionario> func) {
    for (Integer i: func.keySet()){
        funcionarios.put(i, func.get(i).clone());
    }
}

public void setCandidaturas(HashMap<Integer,Candidatura> cand) {
    for (Integer i: cand.keySet()){
        candidaturas.put(i, cand.get(i).clone());
    }
}

public void setEquipas(HashMap<Integer,Equipa> eqp) {
    for (Integer i: eqp.keySet()){
        equipas.put(i, eqp.get(i).clone());
    }
}

public void setFamilias(HashMap<Integer,Familia> fams) {
    for (Integer i:fams.keySet()){
        familias.put(i, fams.get(i).clone());
    }
}

public void setDonativos (HashMap<Integer,Donativo> donats) {
    for (Integer i: donats.keySet()){
        donativos.put(i, donats.get(i).clone());
    }
}

public void setDoadores(HashMap<Integer,Doador> doadors) {
    for (Integer i: doadors.keySet()){
       doadores.put(i, doadors.get(i).clone());
    }
}

public void setEventos(HashMap<Integer,Evento> event) {
    for (Integer i: event.keySet()){
       eventos.put(i, event.get(i).clone());
    }
}

public int addProjeto(Projeto p, int id) {
    for (Integer i: projetos.keySet()){
        if (projetos.get(i).equals(p)){
            return -1;
        }
    }
    projetos.put(id,p.clone());
    return 1;
}

public int remProjeto(Projeto p) {
    for (Integer i: projetos.keySet()){
        if (projetos.get(i).equals(p)){
            projetos.remove(i);
            return 1;
        }
    }
    
    return -1;
}



public int addVoluntario(Voluntario v, int id) {
    for (Integer i: voluntarios.keySet()){
        if (voluntarios.get(i).equals(v)){
            return -1;
        }
    }
    voluntarios.put(id,v.clone());
    return 1;
}

public int remVoluntario(Voluntario v) {
    for (Integer i: voluntarios.keySet()){
        if (voluntarios.get(i).equals(v)){
            voluntarios.remove(i);
            return 1;
        }
    }
    return -1;
}

public int addFuncionario (Funcionario f, int id) {
    for (Integer i: funcionarios.keySet()){
        if (funcionarios.get(i).equals(f)){
            return -1;
        }
    }
    funcionarios.put(id,f.clone());
    return 1;
}

public int remFuncionario (Funcionario f) {
    for (Integer i: funcionarios.keySet()){
        if (funcionarios.get(i).equals(f)){
            funcionarios.remove(i);
            return 1;
        }
    }
    return -1;
}

public int addCandidatura (Candidatura c, int id) {
    for (Integer i: candidaturas.keySet()){
        if (candidaturas.get(i).equals(c)){
            return -1;
        }
    }
    candidaturas.put(id,c.clone());
    return 1;
}

public int remCandidatura (Candidatura c) {
    for (Integer i: candidaturas.keySet()){
        if (candidaturas.get(i).equals(c)){
            candidaturas.remove(i);
            return 1;
        }
    }
    return -1;
}

public int addEquipa (Equipa e, int id) {
    for (Integer i: equipas.keySet()){
        if (equipas.get(i).equals(e)){
            return -1;
        }
    }
    equipas.put(id,e.clone());
    return 1;
}

public int remEquipa (Equipa e) {
    for (Integer i: equipas.keySet()){
        if (equipas.get(i).equals(e)){
            equipas.remove(i);
            return 1;
        }
    }
    return -1;
}

public int addFamilia(Familia f, int id) {
    for (Integer i: familias.keySet()){
        if (familias.get(i).equals(f)){
            return -1;
        }
    }
    familias.put(id,f.clone());
    return 1;
}

public int remFamilia(Familia f) {
    for (Integer i: familias.keySet()){
        if (familias.get(i).equals(f)){
            familias.remove(i);
            return 1;
        }
    }
    return -1;
}

public int addDonativo(Donativo d, int id) {
    for (Integer i: donativos.keySet()){
        if (donativos.get(i).equals(d)){
            return -1;
        }
    }
    donativos.put(id,d.clone());
    return 1;
}

public int remDonativo(Donativo d) {
    for (Integer i: donativos.keySet()){
        if (donativos.get(i).equals(d)){
            donativos.remove(i);
            return 1;
        }
    }
    return -1;
}

public int addDoador(Doador d, int id) {
    for (Integer i: doadores.keySet()){
        if (doadores.get(i).equals(d)){
            return -1;
        }
    }
    doadores.put(id,d.clone());
    return 1;
}

public int remDoador(Doador d) {
    for (Integer i: doadores.keySet()){
        if (doadores.get(i).equals(d)){
            doadores.remove(i);
            return 1;
        }
    }
    return -1;
}

public int addEvento(Evento e, int id) {
    for (Integer i: eventos.keySet()){
        if (eventos.get(i).equals(e)){
            return -1;
        }
    }
    eventos.put(id,e.clone());
    return 1;
}

public int remEvento(Evento e) {
    for (Integer i: eventos.keySet()){
        if (eventos.get(i).equals(e)){
            eventos.remove(i);
            return 1;
        }
    }
    return -1;
}



public Habitat clone () {
    return new Habitat(this);
}

public String toString () {
StringBuilder sb= new StringBuilder ();
sb.append("Projetos: \n");
    for (Integer i: projetos.keySet()){
        sb.append("Id: ").append(i).append("Nome :").append(projetos.get(i).getNome()).append("\n");
    }
    sb.append("Voluntários: \n");
    for (Integer i: voluntarios.keySet()){
        sb.append("Id: ").append(i).append("Nome :").append(voluntarios.get(i).getNomeVoluntario()).append("\n");
    }
    sb.append("Funcionários: \n");
    for (Integer i: funcionarios.keySet()){
        sb.append("Id: ").append(i).append("Nome :").append(funcionarios.get(i).getNome()).append("\n");
    }
    sb.append("Equipas: \n");
    for (Integer i: equipas.keySet()){
        sb.append("Id: ").append(i).append("Nome da equipa :").append(equipas.get(i).getNome()).append("\n");
    }
    sb.append("Famílias: \n");
    for (Integer i: familias.keySet()){
        sb.append("Id: ").append(i).append("Nome da familia :").append(familias.get(i).getNome()).append("\n");
    }
    sb.append("Candidaturas: \n");
    for (Integer i: candidaturas.keySet()){
        sb.append("Id: ").append(i).append("Descricao :").append(candidaturas.get(i).getDescricao()).append("\n");
    }
    sb.append("Donativos: \n");
    for (Integer i: donativos.keySet()){
         sb.append("Id: ").append(i).append("\n");
    }
    sb.append("Doadores: \n");
    for (Integer i: doadores.keySet()){
        sb.append("Id: ").append(i).append("Nome :").append(doadores.get(i).getNome()).append("\n");
    }
    sb.append("Eventos: \n");
    for (Integer i: eventos.keySet()){
        sb.append("Id: ").append(i).append("Descrição :").append(eventos.get(i).getDescricao()).append("\n");
    }

return sb.toString();
}

public boolean equals(Object obj) {
    if(this == obj) return true; 
    if((obj == null) || (this.getClass() != obj.getClass())) return false;
    Habitat h = (Habitat) obj;
    return this.projetos.equals(h.getProjetos()) && (this.voluntarios ==h.getVoluntarios() && this.familias.equals(h.getFamilias()) && this.funcionarios.equals(h.getFuncionarios()) && this.candidaturas.equals(h.getCandidaturas()) && this.equipas.equals(h.getEquipas()) && this.donativos.equals(h.getDonativos()) && this.doadores.equals(h.getDoadores()) && this.eventos.equals(h.getEventos()));
   }



}



