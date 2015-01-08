package Classes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ClassesDAO.CandidaturaDAO;
import ClassesDAO.ConexaoBD;
import ClassesDAO.DoadorDAO;
import ClassesDAO.DonativoDAO;
import ClassesDAO.EquipaDAO;
import ClassesDAO.EventoDAO;
import ClassesDAO.FamiliaDAO;
import ClassesDAO.FuncionarioDAO;
import ClassesDAO.MaterialDAO;
import ClassesDAO.ProjetoDAO;
import ClassesDAO.VoluntarioDAO;
import java.util.Map;

/**
 *
 * @author Sandra
 */
public class HabitatClass {
    
    private Map<Integer, Projeto> projetos;
    private Map<Integer, Voluntario> voluntarios;
    private Map<Integer, Funcionario> funcionarios;
    private Map<Integer, Candidatura> candidaturas;
    private Map<Integer, Equipa> equipas;
    private Map<Integer, Familia> familias;
    private Map<Integer, Donativo> donativos;
    private Map<Integer, Doador> doadores;
    private Map<Integer, Evento> eventos;
    private Map<Integer, Material> materiais;
    private Funcionario utilizadorLigado;

    public HabitatClass() {
        this.projetos = new ProjetoDAO();
        this.voluntarios = new VoluntarioDAO();
        this.funcionarios = new FuncionarioDAO();
        this.candidaturas = new CandidaturaDAO();
        this.equipas = new EquipaDAO();
        this.materiais=new MaterialDAO();
        //this.familias = new FamiliaDAO();
        //this.donativos = new DonativoDAO();
        this.doadores = new DoadorDAO();
        //this.eventos = new EventoDAO();
        //this.materiais = new MaterialDAO();
        this.utilizadorLigado = new Funcionario();
        ConexaoBD.iniciarConexao();
    }
/*
    public HabitatClass(HashMap<Integer, Projeto> p, HashMap<Integer, Voluntario> v, HashMap<Integer, Funcionario> f, HashMap<Integer, Candidatura> c, HashMap<Integer, Equipa> e, HashMap<String, Familia> fam, HashMap<Integer, Donativo> dona, HashMap<Integer, Doador> doa, HashMap<Integer, Evento> event, HashMap<Integer, Material> mat, Funcionario fun) {
        for (Integer i : p.keySet()) {
            projetos.put(i, p.get(i).clone());
        }
        for (Integer i : v.keySet()) {
            voluntarios.put(i, v.get(i).clone());
        }
        for (Integer i : f.keySet()) {
            funcionarios.put(i, f.get(i).clone());
        }
        for (Integer i : c.keySet()) {
            candidaturas.put(i, c.get(i).clone());
        }
        for (Integer i : e.keySet()) {
            equipas.put(i, e.get(i).clone());
        }

        for (String i : fam.keySet()) {
            familias.put(i, fam.get(i).clone());
        }
        for (Integer i : dona.keySet()) {
            donativos.put(i, dona.get(i).clone());
        }
        for (Integer i : doa.keySet()) {
            doadores.put(i, doa.get(i).clone());
        }

        for (Integer i : mat.keySet()) {
            materiais.put(i, mat.get(i).clone());
        }

        for (Integer i : event.keySet()) {
            eventos.put(i, event.get(i).clone());
        }

        this.utilizadorLigado = fun;
    }
    
    public HabitatClass(HabitatClass h) {
        //this.projetos = h.getProjetos();
        this.voluntarios = h.getVoluntarios();
        this.funcionarios = h.getFuncionarios();
        this.candidaturas = h.getCandidaturas();
        //this.equipas = h.getEquipas();
        //this.familias = h.getFamilias();
        //this.donativos = h.getDonativos();
        this.doadores = h.getDoadores();
        //this.eventos = h.getEventos();
        //this.materiais = h.getMateriais();
        this.utilizadorLigado = h.getUtilizadorLigado();
    }
*/
    public Funcionario getUtilizadorLigado() {
        return this.utilizadorLigado;
    }

    public Map<Integer, Material> getMateriais() {
        return this.materiais;
    }

    public Map<Integer, Projeto> getProjetos() {
        return this.projetos;
    }

    public Map<Integer, Voluntario> getVoluntarios() {
        return this.voluntarios;
    }

    public Map<Integer, Funcionario> getFuncionarios() {
        return this.funcionarios;
    }

    public Map<Integer, Candidatura> getCandidaturas() {
        return candidaturas;
    }

    public Map<Integer, Equipa> getEquipas() {
        return this.equipas;
    }

    public Map<Integer, Familia> getFamilias() {
        return this.familias;
    }

    public Map<Integer, Donativo> getDonativos() {
        return this.donativos;
    }

    public Map<Integer, Doador> getDoadores() {
        return this.doadores;
    }

    public Map<Integer, Evento> getEventos() {
        return this.eventos;
    }


    public void setMateriais(Map<Integer, Material> mat) {
        for (Integer i : mat.keySet()) {
            materiais.put(i, mat.get(i).clone());
        }
    }

    public void setUtilizadorLigado(Funcionario f) {
        this.utilizadorLigado = f;
    }

    public void setProjetos(Map<Integer, Projeto> proj) {
        for (Integer i : proj.keySet()) {
            projetos.put(i, proj.get(i).clone());
        }
    }

    public void setVoluntarios(Map<Integer, Voluntario> vol) {
        for (int i : vol.keySet()) {
            voluntarios.put(i, vol.get(i).clone());
        }
    }

    public void setFuncionarios(Map<Integer, Funcionario> func) {
        for (Integer i : func.keySet()) {
            funcionarios.put(i, func.get(i).clone());
        }
    }

    public void setCandidaturas(Map<Integer, Candidatura> cand) {
        for (Integer i : cand.keySet()) {
            candidaturas.put(i, cand.get(i).clone());
        }
    }

    public void setEquipas(Map<Integer, Equipa> eqp) {
        for (Integer i : eqp.keySet()) {
            equipas.put(i, eqp.get(i).clone());
        }
    }

    public void setFamilias(Map<Integer, Familia> fams) {
        for (int i : fams.keySet()) {
            familias.put(i, fams.get(i).clone());
        }
    }

    public void setDonativos(Map<Integer, Donativo> donats) {
        for (Integer i : donats.keySet()) {
            donativos.put(i, donats.get(i).clone());
        }
    }

    public void setDoadores(Map<Integer, Doador> doadors) {
        for (Integer i : doadors.keySet()) {
            doadores.put(i, doadors.get(i).clone());
        }
    }

    public void setEventos(Map<Integer, Evento> event) {
        for (Integer i : event.keySet()) {
            eventos.put(i, event.get(i).clone());
        }
    }

    public int addProjeto(Projeto p, int id) {
        for (Integer i : projetos.keySet()) {
            if (projetos.get(i).equals(p)) {
                return -1;
            }
        }
        projetos.put(id, p.clone());
        return 1;
    }

    public int remProjeto(Projeto p) {
        for (Integer i : projetos.keySet()) {
            if (projetos.get(i).equals(p)) {
                projetos.remove(i);
                return 1;
            }
        }

        return -1;
    }

    public int addVoluntario(Voluntario v, int id) {
        for (int i : voluntarios.keySet()) {
            if (voluntarios.get(i).equals(v)) {
                return -1;
            }
        }
        voluntarios.put(id, v.clone());
        return 1;
    }

    public int remVoluntario(Voluntario v) {
        for (int i : voluntarios.keySet()) {
            if (voluntarios.get(i).equals(v)) {
                voluntarios.remove(i);
                return 1;
            }
        }
        return -1;
    }

    public int addFuncionario(Funcionario f, int id) {
        for (Integer i : funcionarios.keySet()) {
            if (funcionarios.get(i).equals(f)) {
                return -1;
            }
        }
        funcionarios.put(id, f.clone());
        return 1;
    }

    public int remFuncionario(Funcionario f) {
        for (Integer i : funcionarios.keySet()) {
            if (funcionarios.get(i).equals(f)) {
                funcionarios.remove(i);
                return 1;
            }
        }
        return -1;
    }

    public int addCandidatura(Candidatura c, int id) {
        for (Integer i : candidaturas.keySet()) {
            if (candidaturas.get(i).equals(c)) {
                return -1;
            }
        }
        candidaturas.put(id, c.clone());
        return 1;
    }

    public int remCandidatura(Candidatura c) {
        for (Integer i : candidaturas.keySet()) {
            if (candidaturas.get(i).equals(c)) {
                candidaturas.remove(i);
                return 1;
            }
        }
        return -1;
    }

    public int addEquipa(Equipa e, int id) {
        for (Integer i : equipas.keySet()) {
            if (equipas.get(i).getNome().equals(e.getNome())) {
                return -1;
            }
        }
        equipas.put(id, e.clone());
        return 1;
    }

    public int remEquipa(Equipa e) {
        for (Integer i : equipas.keySet()) {
            if (equipas.get(i).equals(e)) {
                equipas.remove(i);
                return 1;
            }
        }
        return -1;
    }

    public int addFamilia(Familia f) {
        for (int i : familias.keySet()) {
            if (familias.get(i).equals(f)) {
                return -1;
            }
        }
        familias.put(f.getIdFamilia(), f.clone());
        return 1;
    }

    public int remFamilia(Familia f) {
        for (int i : familias.keySet()) {
            if (familias.get(i).equals(f)) {
                familias.remove(i);
                return 1;
            }
        }
        return -1;
    }

    public int addDonativo(Donativo d, int id) {
        for (Integer i : donativos.keySet()) {
            if (donativos.get(i).equals(d)) {
                return -1;
            }
        }
        donativos.put(id, d.clone());
        return 1;
    }

    public int remDonativo(Donativo d) {
        for (Integer i : donativos.keySet()) {
            if (donativos.get(i).equals(d)) {
                donativos.remove(i);
                return 1;
            }
        }
        return -1;
    }

    public int addDoador(Doador d, int id) {
        for (Integer i : doadores.keySet()) {
            if (doadores.get(i).equals(d)) {
                return -1;
            }
        }
        doadores.put(id, d.clone());
        return 1;
    }

    public int remDoador(Doador d) {
        for (Integer i : doadores.keySet()) {
            if (doadores.get(i).equals(d)) {
                doadores.remove(i);
                return 1;
            }
        }
        return -1;
    }

    public int addEvento(Evento e, int id) {
        for (Integer i : eventos.keySet()) {
            if (eventos.get(i).equals(e)) {
                return -1;
            }
        }
        eventos.put(id, e.clone());
        return 1;
    }

    public int remEvento(Evento e) {
        for (Integer i : eventos.keySet()) {
            if (eventos.get(i).equals(e)) {
                eventos.remove(i);
                return 1;
            }
        }
        return -1;
    }

    public void addMaterial(Material m, int id) {
        for (Integer i : this.materiais.keySet()) {
            if (this.materiais.get(i).getDescricao().equals(m.getDescricao())) {
                this.materiais.get(i).setStock(m.getStock() + this.materiais.get(i).getStock());
            }
        }
        this.materiais.put(id, m);

    }

    public boolean existeLogin(String login) {
        return (this.funcionarios.containsKey(login));
    }
    
    public boolean validaLogin(String login, String password) {
        //System.out.println("PasswordParametro: "+password);
        //System.out.println("PasswordBD: "+this.funcionarios.size());
       // System.out.println(this.funcionarios.get(login).getPassword()==password);
        return (existeLogin(login) && this.funcionarios.get(login).getPassword().equals(password));
    }
    public boolean ligaFuncionario(String login, String pass) {
        boolean lg;
        if (validaLogin(login, pass)) {
           lg=true;
        }
        else{
            lg=false;
        }
        return lg;
    }
    
    public boolean validaPassword(String pw) {
        boolean res = true;
        int i = 0;
        if (pw.length() < 5) {
            return false;
        }
        for (; i < pw.length() && res; i++) {
            char c = pw.charAt(i);
            if (!(Character.isDigit(c) || Character.isLetter(c) || (c == '_') || (c == '.'))) {
                res = false;
            }
        }
        return res;
    }
    
    /*
    public Funcionario ligaFuncionario(String login, String pass) {
        for (Integer i : funcionarios.keySet()) {
            if (funcionarios.get(i).getLogin().equals(login) && funcionarios.get(i).getPassword().equals(pass)) {
                return funcionarios.get(i);
            }
        }
        return null;
    }
*/
    public Doador getDoador(String nome) {
        for (Integer i : doadores.keySet()) {
            if (doadores.get(i).getNome().equals(nome)) {
                return doadores.get(i);
            }
        }
        return null;
    }

    public Voluntario getVoluntario(String nome) {
        for (int i : voluntarios.keySet()) {
            if (voluntarios.get(i).getNomeVoluntario().equals(nome)) {
                return voluntarios.get(i);
            }
        }
        return null;
    }
/*
    public ArrayList<Voluntario> getVoluntariosEstado(Boolean disp) {
        ArrayList<Voluntario> res = new ArrayList<Voluntario>();
        for (Voluntario v : this.voluntarios.values()) {
            if (v.getDisponibilidade().equals(disp)) {
                res.add(v);
            }
        }
        return res;
    }
*/


    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Voluntários: \n");
        for (int i : voluntarios.keySet()) {
            sb.append("Id: ").append(i).append("Nome :").append(voluntarios.get(i).getNomeVoluntario()).append("\n");
        }
        sb.append("Funcionários: \n");
        for (Integer i : funcionarios.keySet()) {
            sb.append("Id: ").append(i).append("Nome :").append(funcionarios.get(i).getNome()).append("\n");
        }
        sb.append("Equipas: \n");
        for (Integer i : equipas.keySet()) {
            sb.append("Id: ").append(i).append("Nome da equipa :").append(equipas.get(i).getNome()).append("\n");
        }
        sb.append("Famílias: \n");
        for (Integer i : familias.keySet()) {
            sb.append("Id: ").append(i).append("Nome da familia :").append(familias.get(i).getNome()).append("\n");
        }
        sb.append("Candidaturas: \n");
        for (Integer i : candidaturas.keySet()) {
            sb.append("Id: ").append(i).append("Descricao :").append(candidaturas.get(i).getDescricao()).append("\n");
        }
        sb.append("Donativos: \n");
        for (Integer i : donativos.keySet()) {
            sb.append("Id: ").append(i).append("\n");
        }
        
        sb.append("Doadores: \n");
        for (Integer i : doadores.keySet()) {
            sb.append("Id: ").append(i).append("Nome :").append(doadores.get(i).getNome()).append("\n");
        }

        sb.append("Eventos: \n");
        for (Integer i : eventos.keySet()) {
            sb.append("Id: ").append(i).append("Descrição :").append(eventos.get(i).getDescricao()).append("\n");
        }

        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj == null) || (this.getClass() != obj.getClass())) {
            return false;
        }
        HabitatClass h = (HabitatClass) obj;
        return (this.voluntarios == h.getVoluntarios() && /*this.familias.equals(h.getFamilias()) &&*/ this.funcionarios.equals(h.getFuncionarios()) && this.candidaturas.equals(h.getCandidaturas()) /*&& this.equipas.equals(h.getEquipas()) && this.donativos.equals(h.getDonativos()) */&& this.doadores.equals(h.getDoadores()) /*&& this.eventos.equals(h.getEventos())*/);
    }

}
