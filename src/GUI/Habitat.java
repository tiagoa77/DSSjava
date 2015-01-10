/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Classes.Doador;
import Classes.Donativo;
import Classes.Evento;
import Classes.Familia;
import Classes.HabitatClass;
import Classes.Material;
import Classes.Projeto;
import Classes.Voluntario;
import ClassesDAO.ConexaoBD;
import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tiago
 */
public final class Habitat extends javax.swing.JFrame {

    private final HabitatClass habitat;

    /**
     * Creates new form Projectos
     *
     *
     */
    public Habitat() {
        this.habitat = new HabitatClass();
//        this.setLocationRelativeTo(null);
        initComponents();

        listaVoluntarios();
        listaProjectos();
        listaMateriais();
        listaEventos();
        listaDonativos();
        
        
        //Projetos
        this.jButton20.setVisible(true);
        this.jButton21.setVisible(false);
        this.jButton2.setVisible(false);
        this.jButton3.setVisible(false);
        NomeFamilia.setEditable(false);
        Estado.disable();
        jTextPane2.setEditable(false);
        //Voluntarios
        this.jButtonEditarVoluntario.setVisible(true);
        this.jButtonConfirmarEditar.setVisible(false);
        jTextPaneNome.setEditable(false);
        jTextPaneLocalidade.setEditable(false);
        jTextPaneRua.setEditable(false);
        jTextPaneCod.setEditable(false);
        jTextPaneEquipa.setEditable(false);
        jTextPaneProf.setEditable(false);
        jTextPaneDatNasc.setEditable(false);

        //Eventos
        this.jButton22.setVisible(true);
        this.jButton23.setVisible(false);
        dataEvento.setEditable(false);

        //Donativos
        this.jButton24.setVisible(true);
        this.jButton25.setVisible(false);
        quantidadeDon.setEditable(false);
        valorDon.setEditable(false);
        nomeDoa.setEditable(false);
        biDoa.setEditable(false);
        nifDoa.setEditable(false);
        DescricaoDon.setEditable(false);

    }

    public void listaVoluntarios() {
        DefaultListModel<String> str = new DefaultListModel<>();
        for (int i : this.habitat.getVoluntarios().keySet()) {
            str.addElement(this.habitat.getVoluntarios().get(i).getNomeVoluntario());
        }
        listaVoluntarios.setModel(str);
    }

    public Set<Integer> keysetVoluntariosDisponiveis() {
        Set<Integer> res = new TreeSet<>();
        try {
            String sql = "SELECT * FROM Voluntário WHERE Disponibilidade=1";
            Statement stm = ConexaoBD.getConexao().createStatement();
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                res.add(rs.getInt(1));
            }
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return res;
    }

    public Set<Integer> keysetVoluntariosIndisponiveis() {
        Set<Integer> res = new TreeSet<>();
        try {
            String sql = "SELECT * FROM Voluntário WHERE Disponibilidade=0";
            Statement stm = ConexaoBD.getConexao().createStatement();
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                res.add(rs.getInt(1));
            }
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return res;
    }

    public Set<Integer> keysetEventosRealizados() {
        Set<Integer> res = new TreeSet<>();
        try {
            String sql = "SELECT * FROM Evento WHERE DataRealizacao <  NOW();";
            Statement stm = ConexaoBD.getConexao().createStatement();
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                res.add(rs.getInt(1));
            }
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return res;
    }

    public Set<Integer> keysetEventosARealizar() {
        Set<Integer> res = new TreeSet<>();
        try {
            String sql = "SELECT * FROM Evento WHERE DataRealizacao >  NOW();";
            Statement stm = ConexaoBD.getConexao().createStatement();
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                res.add(rs.getInt(1));
            }
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return res;
    }
    
     
    
    public Set<Integer> keysetDonativoMaterial() {
        Set<Integer> res = new TreeSet<>();
        try {
            String sql = "SELECT * FROM Donativo WHERE Tipo='Material';";
            Statement stm = ConexaoBD.getConexao().createStatement();
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                res.add(rs.getInt(1));
            }
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return res;
    }
    
    public Set<Integer> keysetDonativoEvento(int id) {
        Set<Integer> res = new TreeSet<>();
        try {
            String sql = "SELECT * FROM Donativo WHERE Evento="+id;
            Statement stm = ConexaoBD.getConexao().createStatement();
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                res.add(rs.getInt(1));
            }
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return res;
    }

    public Set<Integer> keysetDonativoMonetario() {
        Set<Integer> res = new TreeSet<>();
        try {
            String sql = "SELECT * FROM Donativo WHERE Tipo='Monetario';";
            Statement stm = ConexaoBD.getConexao().createStatement();
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                res.add(rs.getInt(1));
            }
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return res;
    }

    public Set<Integer> keysetDonativoMaodeObra() {
        Set<Integer> res = new TreeSet<>();
        try {
            String sql = "SELECT * FROM Donativo WHERE Tipo='Mão de Obra';";
            Statement stm = ConexaoBD.getConexao().createStatement();
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                res.add(rs.getInt(1));
            }
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return res;
    }

    public void listaVoluntariosDisponiveis() {
        DefaultListModel<String> str = new DefaultListModel<>();
        for (int i : keysetVoluntariosDisponiveis()) {
            str.addElement(this.habitat.getVoluntarios().get(i).getNomeVoluntario());
        }
        listaVoluntarios.setModel(str);
    }

    public void listaVoluntariosIndisponiveis() {
        DefaultListModel<String> str = new DefaultListModel<>();
        for (int i : keysetVoluntariosIndisponiveis()) {
            str.addElement(this.habitat.getVoluntarios().get(i).getNomeVoluntario());
        }
        listaVoluntarios.setModel(str);
    }

    public void listaDonativosMaterial() {
        DefaultListModel<Integer> str = new DefaultListModel<>();
        for (int i : keysetDonativoMaterial()) {
            str.addElement(this.habitat.getDonativos().get(i).getId());
        }
        listaDonativos.setModel(str);
    }

    public void listaDonativosMonetario() {
        DefaultListModel<Integer> str = new DefaultListModel<>();
        for (int i : keysetDonativoMonetario()) {
            str.addElement(this.habitat.getDonativos().get(i).getId());
        }
        listaDonativos.setModel(str);
    }

    public void listaDonativosMaodeObra() {
        DefaultListModel<Integer> str = new DefaultListModel<>();
        for (int i : keysetDonativoMaodeObra()) {
            str.addElement(this.habitat.getDonativos().get(i).getId());
        }
        listaDonativos.setModel(str);
    }

    public void listaDonativosMaodeObraeMonetario() {
        DefaultListModel<Integer> str = new DefaultListModel<>();
        for (int i : keysetDonativoMaodeObra()) {
            str.addElement(this.habitat.getDonativos().get(i).getId());
        }
        for (int i : keysetDonativoMonetario()) {
            str.addElement(this.habitat.getDonativos().get(i).getId());
        }
        listaDonativos.setModel(str);
    }

    public void listaDonativosMaodeObraeMaterial() {
        DefaultListModel<Integer> str = new DefaultListModel<>();
        for (int i : keysetDonativoMaodeObra()) {
            str.addElement(this.habitat.getDonativos().get(i).getId());
        }
        for (int i : keysetDonativoMaterial()) {
            str.addElement(this.habitat.getDonativos().get(i).getId());
        }
        listaDonativos.setModel(str);
    }

    public void listaDonativosMonetarioeMaterial() {
        DefaultListModel<Integer> str = new DefaultListModel<>();
        for (int i : keysetDonativoMonetario()) {
            str.addElement(this.habitat.getDonativos().get(i).getId());
        }
        for (int i : keysetDonativoMaterial()) {
            str.addElement(this.habitat.getDonativos().get(i).getId());
        }
        listaDonativos.setModel(str);
    }

    public void listaEventosRealizados() {
        DefaultListModel<String> str = new DefaultListModel<>();
        for (int i : keysetEventosRealizados()) {
            str.addElement(this.habitat.getEventos().get(i).getDescricao());
        }
        listaEventos.setModel(str);
    }

    public void listaEventosARealizar() {
        DefaultListModel<String> str = new DefaultListModel<>();
        for (int i : keysetEventosARealizar()) {
            str.addElement(this.habitat.getEventos().get(i).getDescricao());
        }
        listaEventos.setModel(str);
    }

    private void updateListaVoluntarios() {
        if (jCheckBoxDisponivel.isSelected() && jCheckBoxIndisponivel.isSelected()) {
            listaVoluntarios();
        } else if (jCheckBoxDisponivel.isSelected()) {
            listaVoluntariosDisponiveis();
        } else if (jCheckBoxIndisponivel.isSelected()) {
            listaVoluntariosIndisponiveis();
        } else {
            listaVoluntarios();
        }

    }

    private void updateListaDonativos() {
        if (jCheckBoxMaterial.isSelected() && jCheckBoxMonetario.isSelected() && jCheckBoxMaodeObra.isSelected()) {
            listaDonativos();
        } else if (jCheckBoxMaterial.isSelected()) {
            listaDonativosMaterial();
        } else if (jCheckBoxMonetario.isSelected()) {
            listaDonativosMonetario();
        } else if (jCheckBoxMaodeObra.isSelected()) {
            listaDonativosMaodeObra();
        } else if (jCheckBoxMaodeObra.isSelected() && jCheckBoxMonetario.isSelected()) {
            listaDonativosMaodeObraeMonetario();
        } else if (jCheckBoxMaodeObra.isSelected() && jCheckBoxMaterial.isSelected()) {
            listaDonativosMaodeObraeMaterial();
        } else if (jCheckBoxMonetario.isSelected() && jCheckBoxMaterial.isSelected()) {
            listaDonativosMonetarioeMaterial();
        } else {
            listaDonativos();
        }

    }

    private void updateListaEventos() {
        if (jCheckBoxRealizados.isSelected() && jCheckBoxARealizar.isSelected()) {
            listaEventos();
        } else if (jCheckBoxRealizados.isSelected()) {
            listaEventosRealizados();
        } else if (jCheckBoxARealizar.isSelected()) {
            listaEventosARealizar();
        } else {
            listaEventos();
        }

    }

    public void listaProjectos() {
        DefaultListModel<Integer> str1 = new DefaultListModel<>();
        for (int i : this.habitat.getProjetos().keySet()) {
            str1.addElement(this.habitat.getProjetos().get(i).getId());
        }
        listaProjectos.setModel(str1);
        //listaProjectos.setSelectedIndex(0);
    }

    public void listaEventos() {
        DefaultListModel<String> str2 = new DefaultListModel<>();
        for (int i : this.habitat.getEventos().keySet()) {
            str2.addElement(this.habitat.getEventos().get(i).getDescricao());
        }
        listaEventos.setModel(str2);
        listaEventos.setSelectedIndex(0);
    }

    public void listaDonativos() {
        DefaultListModel<Integer> str3 = new DefaultListModel<>();
        for (int i : this.habitat.getDonativos().keySet()) {
            str3.addElement(this.habitat.getDonativos().get(i).getId());

        }
        listaDonativos.setModel(str3);
        listaDonativos.setSelectedIndex(0);
    }

    
    public void listaDonativosEventos(int evento) {
        Object[] columnNames = new String[] {"Donativo","Quantidade","Doador"};
        Object[][] data = new Object[][] {};
        DefaultTableModel x  = new DefaultTableModel(data, columnNames);
        for (int i : this.keysetDonativoEvento(evento)) {
            x.addRow(new Object[]{this.habitat.getDonativos().get(i).getId(),this.habitat.getDonativos().get(i).getQuantidade(),this.habitat.getDoadores().get(this.habitat.getDonativos().get(i).getId_doador()).getNome()});
        }
        jTable1.setModel(x);
    }
    
    public void listaMateriais() {
        DefaultListModel<String> str4 = new DefaultListModel<>();
        for (int i : this.habitat.getMateriais().keySet()) {
            str4.addElement(this.habitat.getMateriais().get(i).getId() + " " + this.habitat.getMateriais().get(i).getDescricao());
        }
        listMateriais.setModel(str4);
        listMateriais.setSelectedIndex(0);
    }

    public String seleccionaVoluntario() {
        String s = null;

        if (listaVoluntarios.getSelectedIndex() != -1) {
            s = listaVoluntarios.getSelectedValue().toString();
        }

        //listaVoluntarios.clearSelection();
        return s;
    }

    public String seleccionaEvento() {
        String s = null;

        if (listaEventos.getSelectedIndex() != -1) {
            s = listaEventos.getSelectedValue().toString();
        }
        Evento e = this.habitat.getEvento(s);
        listaDonativosEventos(e.getId());
        return s;
    }

    public String seleccionaProjeto() {

        String aux = "";

        if (listaProjectos.getSelectedIndex() != -1) {
            aux = listaProjectos.getSelectedValue().toString();
        }

        return aux;
    }

    public String seleccionaMaterial() {
        String s = null;

        if (listMateriais.getSelectedIndex() != -1) {
            s = listMateriais.getSelectedValue().toString();
        }

        //listMateriais.clearSelection();
        return s;
    }

    public String seleccionaDonativo() {
        String s = null;

        if (listaDonativos.getSelectedIndex() != -1) {
            s = listaDonativos.getSelectedValue().toString();
        }

        //listaEventos.clearSelection();
        return s;
    }
    
    private void atualizaDonativo(int key,Donativo don){
        try {
            String sql = "UPDATE Donativo SET" +
                         " Descricao = '" +don.getDescricao()+
                         "',Quantidade = " +don.getQuantidade()+
                         ",Valor = " +don.getValor()+
                         " WHERE idDonativo ="+key;
            PreparedStatement stm = ConexaoBD.getConexao().prepareStatement(sql);
            stm.executeUpdate();
            stm.close();
        } catch (SQLException e) { }
    }
    
    private void atualizaVoluntario(int key,Voluntario v){
        try {
            String sql = "UPDATE Voluntário SET" +
                         " CodPostal = '" +v.getCodPostal()+
                         "',Profissao = '" +v.getProfissao()+
                         "',Localidade = '" +v.getLocalidade()+
                         "',Nome = '" +v.getNomeVoluntario()+
                         "',Rua = '" +v.getRua()+
                         "' WHERE idVoluntário ="+key;
            PreparedStatement stm = ConexaoBD.getConexao().prepareStatement(sql);
            stm.executeUpdate();
            stm.close();
        } catch (SQLException e) { }
    }
    
    private void familiaDoProjeto(int idProjeto){
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PainelPrincipal = new javax.swing.JTabbedPane();
        Projectos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaProjectos = new javax.swing.JList();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        NomeFamilia = new javax.swing.JTextPane();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        listaVoluntariosProj = new javax.swing.JList();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        Estado = new javax.swing.JComboBox();
        jButton5 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        jLabel9 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        Voluntarios = new javax.swing.JPanel();
        jLabelImagem = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jCheckBoxDisponivel = new javax.swing.JCheckBox();
        jCheckBoxIndisponivel = new javax.swing.JCheckBox();
        jButtonAdicionar = new javax.swing.JButton();
        jButtonRemover = new javax.swing.JButton();
        jPanelInformacao = new javax.swing.JPanel();
        jLabelInformacao = new javax.swing.JLabel();
        jLabelNome = new javax.swing.JLabel();
        jScrollPaneNome = new javax.swing.JScrollPane();
        jTextPaneNome = new javax.swing.JTextPane();
        jLabelDatNasc = new javax.swing.JLabel();
        jLabelDataLocalidade = new javax.swing.JLabel();
        jScrollPaneLocalidade = new javax.swing.JScrollPane();
        jTextPaneLocalidade = new javax.swing.JTextPane();
        jLabelRua = new javax.swing.JLabel();
        jScrollPaneRua = new javax.swing.JScrollPane();
        jTextPaneRua = new javax.swing.JTextPane();
        jLabelCod = new javax.swing.JLabel();
        jScrollPaneCod = new javax.swing.JScrollPane();
        jTextPaneCod = new javax.swing.JTextPane();
        jLabelEquipa = new javax.swing.JLabel();
        jScrollPaneEquipa = new javax.swing.JScrollPane();
        jTextPaneEquipa = new javax.swing.JTextPane();
        jLabelProf = new javax.swing.JLabel();
        jScrollPaneProf = new javax.swing.JScrollPane();
        jTextPaneProf = new javax.swing.JTextPane();
        jButtonEditarVoluntario = new javax.swing.JButton();
        jButtonConfirmarEditar = new javax.swing.JButton();
        jScrollPaneDatNasc = new javax.swing.JScrollPane();
        jTextPaneDatNasc = new javax.swing.JTextPane();
        jScrollPane14 = new javax.swing.JScrollPane();
        listaVoluntarios = new javax.swing.JList();
        Eventos = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane22 = new javax.swing.JScrollPane();
        listaEventos = new javax.swing.JList();
        jCheckBoxRealizados = new javax.swing.JCheckBox();
        jCheckBoxARealizar = new javax.swing.JCheckBox();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jScrollPane23 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton15 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jScrollPane29 = new javax.swing.JScrollPane();
        dataEvento = new javax.swing.JTextPane();
        Donativos = new javax.swing.JPanel();
        jScrollPane15 = new javax.swing.JScrollPane();
        listaDonativos = new javax.swing.JList();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jCheckBoxMaterial = new javax.swing.JCheckBox();
        jCheckBoxMonetario = new javax.swing.JCheckBox();
        jCheckBoxMaodeObra = new javax.swing.JCheckBox();
        jPanel10 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        quantidadeDon = new javax.swing.JTextPane();
        jScrollPane16 = new javax.swing.JScrollPane();
        valorDon = new javax.swing.JTextPane();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane17 = new javax.swing.JScrollPane();
        DescricaoDon = new javax.swing.JTextArea();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane18 = new javax.swing.JScrollPane();
        nomeDoa = new javax.swing.JTextPane();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jScrollPane20 = new javax.swing.JScrollPane();
        biDoa = new javax.swing.JTextPane();
        jLabel28 = new javax.swing.JLabel();
        jScrollPane21 = new javax.swing.JScrollPane();
        nifDoa = new javax.swing.JTextPane();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jScrollPane26 = new javax.swing.JScrollPane();
        tipoDoa = new javax.swing.JTextPane();
        jLabel29 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        Stock = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jScrollPane24 = new javax.swing.JScrollPane();
        listMateriais = new javax.swing.JList();
        jButton16 = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jScrollPane25 = new javax.swing.JScrollPane();
        txtQuantidade = new javax.swing.JTextPane();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jScrollPane27 = new javax.swing.JScrollPane();
        txtDoador = new javax.swing.JTextPane();
        jLabel37 = new javax.swing.JLabel();
        jScrollPane28 = new javax.swing.JScrollPane();
        txtProjeto = new javax.swing.JTextPane();
        jScrollPane19 = new javax.swing.JScrollPane();
        txtDescricao = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        Projectos.setBackground(new java.awt.Color(255, 255, 255));

        listaProjectos.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        listaProjectos.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaProjectosValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listaProjectos);

        jCheckBox1.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jCheckBox1.setText("Em curso");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jCheckBox2.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jCheckBox2.setText("Pendentes");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        jCheckBox3.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jCheckBox3.setText("Rejeitados");

        jCheckBox4.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox4.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jCheckBox4.setText("Terminados");

        jButton1.setText("Adicionar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(0, 85, 150));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel1.setText("Nome da Família");

        jScrollPane2.setViewportView(NomeFamilia);

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel3.setText("Estado");

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel5.setText("Data de Aprovação");

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel6.setText("Progresso");

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel8.setText("Voluntários");

        jScrollPane6.setViewportView(listaVoluntariosProj);

        jButton2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jButton2.setText("Remover");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jButton3.setText("Adicionar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jButton4.setText("Ver lista de Tarefas");

        jButton20.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jButton20.setText("Editar");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        jButton21.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jButton21.setText("Concluído");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        Estado.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        Estado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Em curso", "Pendente", "Rejeitado", "Terminado" }));

        jButton5.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jButton5.setText("Ver Família");

        jScrollPane3.setViewportView(jTextPane2);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2)
                            .addComponent(Estado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jProgressBar1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel3)
                                                .addComponent(jLabel5))
                                            .addGap(104, 104, 104)))
                                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addContainerGap())))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(246, 246, 246))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4)
                .addGap(26, 26, 26)
                .addComponent(jButton5)
                .addGap(56, 56, 56)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton20)
                    .addComponent(jButton21))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Resources/logo.png.jpg"))); // NOI18N

        jPanel7.setBackground(new java.awt.Color(84, 184, 72));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 631, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout ProjectosLayout = new javax.swing.GroupLayout(Projectos);
        Projectos.setLayout(ProjectosLayout);
        ProjectosLayout.setHorizontalGroup(
            ProjectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProjectosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ProjectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(ProjectosLayout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ProjectosLayout.createSequentialGroup()
                        .addGroup(ProjectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addGroup(ProjectosLayout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(ProjectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBox1)
                                    .addComponent(jCheckBox2)
                                    .addComponent(jCheckBox3)
                                    .addComponent(jCheckBox4))))
                        .addGap(6, 6, 6)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        ProjectosLayout.setVerticalGroup(
            ProjectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProjectosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ProjectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(23, 23, 23)
                .addGroup(ProjectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ProjectosLayout.createSequentialGroup()
                        .addComponent(jCheckBox1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox4))
                    .addGroup(ProjectosLayout.createSequentialGroup()
                        .addGroup(ProjectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addGap(24, 24, 24))
        );

        jButton1.getAccessibleContext().setAccessibleName("b_adiciona_projeto");

        PainelPrincipal.addTab("Projetos", Projectos);

        Voluntarios.setBackground(new java.awt.Color(255, 255, 255));

        jLabelImagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Resources/logo.png.jpg"))); // NOI18N

        jPanel8.setBackground(new java.awt.Color(84, 184, 72));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 625, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jCheckBoxDisponivel.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBoxDisponivel.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jCheckBoxDisponivel.setText("Disponíveis");
        jCheckBoxDisponivel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxDisponivelActionPerformed(evt);
            }
        });

        jCheckBoxIndisponivel.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBoxIndisponivel.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jCheckBoxIndisponivel.setText("Não Disponíveis");
        jCheckBoxIndisponivel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxIndisponivelActionPerformed(evt);
            }
        });

        jButtonAdicionar.setText("Adicionar");
        jButtonAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarActionPerformed(evt);
            }
        });

        jButtonRemover.setText("Remover");
        jButtonRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoverActionPerformed(evt);
            }
        });

        jPanelInformacao.setBackground(new java.awt.Color(0, 85, 150));

        jLabelInformacao.setText("Informação Geral");

        jLabelNome.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabelNome.setText("Nome");

        jScrollPaneNome.setViewportView(jTextPaneNome);

        jLabelDatNasc.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabelDatNasc.setText("Data de Nascimento");

        jLabelDataLocalidade.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabelDataLocalidade.setText("Localidade");

        jScrollPaneLocalidade.setViewportView(jTextPaneLocalidade);

        jLabelRua.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabelRua.setText("Rua");

        jScrollPaneRua.setViewportView(jTextPaneRua);

        jLabelCod.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabelCod.setText("Código Postal");

        jScrollPaneCod.setViewportView(jTextPaneCod);

        jLabelEquipa.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabelEquipa.setText("Equipa");

        jScrollPaneEquipa.setViewportView(jTextPaneEquipa);

        jLabelProf.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabelProf.setText("Profissão");

        jScrollPaneProf.setViewportView(jTextPaneProf);

        jButtonEditarVoluntario.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jButtonEditarVoluntario.setText("Editar");
        jButtonEditarVoluntario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarVoluntarioActionPerformed(evt);
            }
        });

        jButtonConfirmarEditar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jButtonConfirmarEditar.setText("Concluído");
        jButtonConfirmarEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmarEditarActionPerformed(evt);
            }
        });

        jScrollPaneDatNasc.setViewportView(jTextPaneDatNasc);

        javax.swing.GroupLayout jPanelInformacaoLayout = new javax.swing.GroupLayout(jPanelInformacao);
        jPanelInformacao.setLayout(jPanelInformacaoLayout);
        jPanelInformacaoLayout.setHorizontalGroup(
            jPanelInformacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInformacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelInformacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelInformacaoLayout.createSequentialGroup()
                        .addGroup(jPanelInformacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelInformacao)
                            .addComponent(jLabelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelDataLocalidade)
                            .addComponent(jScrollPaneLocalidade, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                            .addComponent(jScrollPaneNome)
                            .addComponent(jLabelRua)
                            .addComponent(jScrollPaneRua)
                            .addComponent(jLabelCod)
                            .addComponent(jScrollPaneCod)
                            .addComponent(jLabelEquipa)
                            .addComponent(jScrollPaneEquipa)
                            .addComponent(jLabelProf)
                            .addComponent(jScrollPaneProf)
                            .addComponent(jScrollPaneDatNasc))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
                        .addComponent(jButtonConfirmarEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonEditarVoluntario, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelInformacaoLayout.createSequentialGroup()
                        .addComponent(jLabelDatNasc)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelInformacaoLayout.setVerticalGroup(
            jPanelInformacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInformacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelInformacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelInformacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonEditarVoluntario)
                        .addComponent(jButtonConfirmarEditar))
                    .addGroup(jPanelInformacaoLayout.createSequentialGroup()
                        .addComponent(jLabelInformacao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelNome)
                        .addGap(7, 7, 7)
                        .addComponent(jScrollPaneNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelDatNasc)
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPaneDatNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelDataLocalidade)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPaneLocalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelRua)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPaneRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelCod)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPaneCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelEquipa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPaneEquipa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelProf)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPaneProf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        listaVoluntarios.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        listaVoluntarios.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaVoluntariosValueChanged(evt);
            }
        });
        jScrollPane14.setViewportView(listaVoluntarios);

        javax.swing.GroupLayout VoluntariosLayout = new javax.swing.GroupLayout(Voluntarios);
        Voluntarios.setLayout(VoluntariosLayout);
        VoluntariosLayout.setHorizontalGroup(
            VoluntariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VoluntariosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(VoluntariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(VoluntariosLayout.createSequentialGroup()
                        .addComponent(jLabelImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, VoluntariosLayout.createSequentialGroup()
                        .addGroup(VoluntariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(VoluntariosLayout.createSequentialGroup()
                                .addComponent(jButtonAdicionar)
                                .addGap(35, 35, 35)
                                .addComponent(jButtonRemover))
                            .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(VoluntariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBoxDisponivel)
                            .addComponent(jCheckBoxIndisponivel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanelInformacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        VoluntariosLayout.setVerticalGroup(
            VoluntariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VoluntariosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(VoluntariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelImagem))
                .addGap(23, 23, 23)
                .addGroup(VoluntariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(VoluntariosLayout.createSequentialGroup()
                        .addComponent(jCheckBoxDisponivel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBoxIndisponivel))
                    .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
                    .addComponent(jPanelInformacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(VoluntariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonAdicionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonRemover, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        PainelPrincipal.addTab("Voluntários", Voluntarios);

        Eventos.setBackground(new java.awt.Color(255, 255, 255));

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Resources/logo.png.jpg"))); // NOI18N

        jPanel12.setBackground(new java.awt.Color(84, 184, 72));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 631, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 103, Short.MAX_VALUE)
        );

        listaEventos.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        listaEventos.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaEventosValueChanged(evt);
            }
        });
        jScrollPane22.setViewportView(listaEventos);

        jCheckBoxRealizados.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBoxRealizados.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jCheckBoxRealizados.setText("Já Realizados");
        jCheckBoxRealizados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxRealizadosActionPerformed(evt);
            }
        });

        jCheckBoxARealizar.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBoxARealizar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jCheckBoxARealizar.setText("A Realizar");
        jCheckBoxARealizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxARealizarActionPerformed(evt);
            }
        });

        jButton13.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jButton13.setText("Adicionar");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jButton14.setText("Remover");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jPanel13.setBackground(new java.awt.Color(0, 85, 150));

        jLabel31.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel31.setText("Data");

        jLabel32.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel32.setText("Donativos");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Donativo", "Quantidade", "Doador"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane23.setViewportView(jTable1);

        jButton15.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jButton15.setText("Adicionar");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton22.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jButton22.setText("Editar");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        jButton23.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jButton23.setText("Concluído");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        jScrollPane29.setViewportView(dataEvento);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane29, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31)
                            .addComponent(jLabel32)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jScrollPane23, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton15)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jLabel32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane23, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton15))
                .addGap(105, 105, 105)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton22)
                    .addComponent(jButton23))
                .addGap(38, 38, 38))
        );

        javax.swing.GroupLayout EventosLayout = new javax.swing.GroupLayout(Eventos);
        Eventos.setLayout(EventosLayout);
        EventosLayout.setHorizontalGroup(
            EventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EventosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(EventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(EventosLayout.createSequentialGroup()
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(EventosLayout.createSequentialGroup()
                        .addGroup(EventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(EventosLayout.createSequentialGroup()
                                .addComponent(jButton13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton14))
                            .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(EventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBoxRealizados)
                            .addComponent(jCheckBoxARealizar))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        EventosLayout.setVerticalGroup(
            EventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EventosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(EventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30))
                .addGap(23, 23, 23)
                .addGroup(EventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EventosLayout.createSequentialGroup()
                        .addComponent(jCheckBoxRealizados)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBoxARealizar))
                    .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(EventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton13)
                    .addComponent(jButton14))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PainelPrincipal.addTab("Eventos", Eventos);

        Donativos.setBackground(new java.awt.Color(255, 255, 255));

        listaDonativos.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        listaDonativos.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaDonativosValueChanged(evt);
            }
        });
        jScrollPane15.setViewportView(listaDonativos);

        jButton10.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jButton10.setText("Adicionar");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jButton11.setText("Remover");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jCheckBoxMaterial.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBoxMaterial.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jCheckBoxMaterial.setText("Material");
        jCheckBoxMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMaterialActionPerformed(evt);
            }
        });

        jCheckBoxMonetario.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBoxMonetario.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jCheckBoxMonetario.setText("Monetário");
        jCheckBoxMonetario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMonetarioActionPerformed(evt);
            }
        });

        jCheckBoxMaodeObra.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBoxMaodeObra.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jCheckBoxMaodeObra.setText("Mão-de-Obra");
        jCheckBoxMaodeObra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMaodeObraActionPerformed(evt);
            }
        });

        jPanel10.setBackground(new java.awt.Color(0, 85, 150));

        jLabel20.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel20.setText("Quantidade");

        jLabel21.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel21.setText("Valor");

        jScrollPane7.setViewportView(quantidadeDon);

        jScrollPane16.setViewportView(valorDon);

        jLabel22.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel22.setText("Descrição");

        DescricaoDon.setColumns(20);
        DescricaoDon.setRows(5);
        jScrollPane17.setViewportView(DescricaoDon);

        jLabel23.setText("Donativo");

        jLabel24.setText("Doador");

        jLabel25.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel25.setText("Nome");

        jScrollPane18.setViewportView(nomeDoa);

        jLabel26.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel26.setText("Tipo");

        jLabel27.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel27.setText("BI");

        jScrollPane20.setViewportView(biDoa);

        jLabel28.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel28.setText("NIF");

        jScrollPane21.setViewportView(nifDoa);

        jButton24.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jButton24.setText("Editar");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });

        jButton25.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jButton25.setText("Concluído");
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });

        jScrollPane26.setViewportView(tipoDoa);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(jLabel22)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel20)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                        .addComponent(jLabel21)
                        .addComponent(jScrollPane16))
                    .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                            .addComponent(jLabel24)
                            .addGap(126, 126, 126))
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel28)
                            .addComponent(jScrollPane20)
                            .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane26, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25)
                    .addComponent(jLabel26)
                    .addComponent(jLabel27))
                .addGap(37, 37, 37))
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(234, 234, 234)
                .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 28, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jLabel24))
                .addGap(19, 19, 19)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addComponent(jLabel26))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jLabel27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton24)
                    .addComponent(jButton25))
                .addGap(39, 39, 39))
        );

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Resources/logo.png.jpg"))); // NOI18N

        jPanel11.setBackground(new java.awt.Color(84, 184, 72));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 625, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 103, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout DonativosLayout = new javax.swing.GroupLayout(Donativos);
        Donativos.setLayout(DonativosLayout);
        DonativosLayout.setHorizontalGroup(
            DonativosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DonativosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DonativosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DonativosLayout.createSequentialGroup()
                        .addGroup(DonativosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(DonativosLayout.createSequentialGroup()
                                .addComponent(jButton10)
                                .addGap(38, 38, 38)
                                .addComponent(jButton11)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(DonativosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBoxMaterial)
                            .addComponent(jCheckBoxMonetario)
                            .addComponent(jCheckBoxMaodeObra, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(66, 66, 66)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(DonativosLayout.createSequentialGroup()
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        DonativosLayout.setVerticalGroup(
            DonativosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DonativosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DonativosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29))
                .addGap(24, 24, 24)
                .addGroup(DonativosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(DonativosLayout.createSequentialGroup()
                        .addComponent(jCheckBoxMaterial)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBoxMonetario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBoxMaodeObra)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DonativosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton10)
                    .addComponent(jButton11))
                .addGap(24, 24, 24))
        );

        PainelPrincipal.addTab("Donativos", Donativos);

        Stock.setBackground(new java.awt.Color(255, 255, 255));

        jPanel14.setBackground(new java.awt.Color(84, 184, 72));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 604, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 103, Short.MAX_VALUE)
        );

        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Resources/logo.png.jpg"))); // NOI18N

        listMateriais.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        listMateriais.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listMateriaisValueChanged(evt);
            }
        });
        jScrollPane24.setViewportView(listMateriais);

        jButton16.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jButton16.setText("Adicionar Material");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jPanel15.setBackground(new java.awt.Color(0, 85, 150));

        jLabel34.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel34.setText("Quantidade Disponível");

        txtQuantidade.setEditable(false);
        jScrollPane25.setViewportView(txtQuantidade);

        jLabel35.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel35.setText("Descrição");

        jLabel36.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel36.setText("Doador");

        txtDoador.setEditable(false);
        jScrollPane27.setViewportView(txtDoador);

        jLabel37.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel37.setText("Projeto");

        txtProjeto.setEditable(false);
        jScrollPane28.setViewportView(txtProjeto);

        txtDescricao.setEditable(false);
        jScrollPane19.setViewportView(txtDescricao);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel34)
                    .addComponent(jLabel35)
                    .addComponent(jLabel36)
                    .addComponent(jLabel37)
                    .addComponent(jScrollPane25, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                    .addComponent(jScrollPane27)
                    .addComponent(jScrollPane28)
                    .addComponent(jScrollPane19))
                .addContainerGap(351, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel36)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel37)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout StockLayout = new javax.swing.GroupLayout(Stock);
        Stock.setLayout(StockLayout);
        StockLayout.setHorizontalGroup(
            StockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StockLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(StockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, StockLayout.createSequentialGroup()
                        .addComponent(jScrollPane24, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(StockLayout.createSequentialGroup()
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton16))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        StockLayout.setVerticalGroup(
            StockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StockLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(StockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33))
                .addGap(23, 23, 23)
                .addGroup(StockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane24, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
                    .addGroup(StockLayout.createSequentialGroup()
                        .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton16)
                .addGap(24, 24, 24))
        );

        PainelPrincipal.addTab("Stock", Stock);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PainelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 911, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PainelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        PainelPrincipal.getAccessibleContext().setAccessibleName("Projetos");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jButtonEditarVoluntarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarVoluntarioActionPerformed
        
        //Voluntarios
        this.jButtonEditarVoluntario.setVisible(false);
        this.jButtonConfirmarEditar.setVisible(true);
        
        this.jTextPaneNome.setEditable(true);
        this.jTextPaneLocalidade.setEditable(true);
        this.jTextPaneRua.setEditable(true);
        this.jTextPaneCod.setEditable(true);
        this.jTextPaneProf.setEditable(true);
        
        //this.jTextPaneNome.setText(this.jTextPaneNome.getText());
        //this.jTextPaneLocalidade.setText(this.jTextPaneLocalidade.getText());
        //this.jTextPaneDatNasc.setText(this.jTextPaneDatNasc.getText());
        //this.jTextPaneProf.setText(this.jTextPaneProf.getText());
        //this.jTextPaneRua.setText(this.jTextPaneRua.getText());
        //this.jTextPaneCod.setText(this.jTextPaneCod.getText());
    }//GEN-LAST:event_jButtonEditarVoluntarioActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jCheckBoxMonetarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMonetarioActionPerformed
        // TODO add your handling code here:
        updateListaDonativos();
    }//GEN-LAST:event_jCheckBoxMonetarioActionPerformed

    private void jCheckBoxMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMaterialActionPerformed
        // TODO add your handling code here:
        updateListaDonativos();
    }//GEN-LAST:event_jCheckBoxMaterialActionPerformed

    private void jButtonConfirmarEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarEditarActionPerformed
        // TODO add your handling code here:
        //Voluntarios
        this.jButtonConfirmarEditar.setVisible(false);
        this.jButtonEditarVoluntario.setVisible(true);
        
        this.jTextPaneNome.setEditable(false);
        this.jTextPaneLocalidade.setEditable(false);
        this.jTextPaneRua.setEditable(false);
        this.jTextPaneCod.setEditable(false);
        this.jTextPaneEquipa.setEditable(false);
        this.jTextPaneProf.setEditable(false);
        this.jTextPaneDatNasc.setEditable(false);
        
        String aux = seleccionaVoluntario();
        int id = this.habitat.getVoluntario(aux).getId();
        
        String cod = this.jTextPaneCod.getText();
        String prof = this.jTextPaneProf.getText();
        String loc = this.jTextPaneLocalidade.getText();
        String nome = this.jTextPaneNome.getText();
        String rua = this.jTextPaneRua.getText();
        
        Voluntario v = new Voluntario(id,cod,prof,loc,nome,rua);
        
        atualizaVoluntario(id, v);

    }//GEN-LAST:event_jButtonConfirmarEditarActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        // TODO add your handling code here:

        //Projetos
        jButton21.setVisible(true);
        jButton20.setVisible(false);
        jButton2.setVisible(true);
        jButton3.setVisible(true);
        NomeFamilia.setEditable(true);
        Estado.enable();
        jTextPane2.setEditable(true);


    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        // TODO add your handling code here:

        //Projetos
        jButton21.setVisible(false);
        jButton20.setVisible(true);
        jButton2.setVisible(false);
        jButton3.setVisible(false);
        NomeFamilia.setEditable(false);
        Estado.disable();
        jTextPane2.setEditable(false);

    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        // TODO add your handling code here:

        //Eventos
        this.jButton22.setVisible(false);
        this.jButton23.setVisible(true);
        dataEvento.setEditable(true);
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        // TODO add your handling code here:
        //Eventos
        this.jButton23.setVisible(false);
        this.jButton22.setVisible(true);
        dataEvento.setEditable(false);
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        AdicionarProjeto a = new AdicionarProjeto(habitat);
        a.setVisible(true);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarActionPerformed
        AdicionarVoluntario d = new AdicionarVoluntario(this.habitat);
        d.setVisible(true);
        listaVoluntarios();
    }//GEN-LAST:event_jButtonAdicionarActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        AdicionarEvento a = new AdicionarEvento(habitat);
        a.setVisible(true);
        listaEventos();
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        AdicionarDonativo a = new AdicionarDonativo(habitat);
        a.setVisible(true);
        listaDonativos();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
        AdicionarMaterial a = new AdicionarMaterial(habitat);
        a.setVisible(true);
        listaMateriais();
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void listaVoluntariosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaVoluntariosValueChanged
        // TODO add your handling code here:
        String aux = seleccionaVoluntario();
        if (aux != null) {
            Voluntario v = this.habitat.getVoluntario(aux);
            this.jTextPaneNome.setText(v.getNomeVoluntario());
            DateFormat df = new SimpleDateFormat("MM/dd/yyy");
            String data = df.format(v.getDataNascimento());
            this.jTextPaneDatNasc.setText(data);
            this.jTextPaneLocalidade.setText(v.getLocalidade());
            this.jTextPaneRua.setText(v.getRua());
            this.jTextPaneProf.setText(v.getProfissao());
            this.jTextPaneCod.setText(v.getCodPostal());
            String equipa = this.habitat.getEquipas().get(v.getId_equipa()).getNome();
            this.jTextPaneEquipa.setText(equipa);
        }
    }//GEN-LAST:event_listaVoluntariosValueChanged


    private void jButtonRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoverActionPerformed
        // TODO add your handling code here:
        String aux = seleccionaVoluntario();
        int key = 0;
        for (int i : this.habitat.getVoluntarios().keySet()) {
            if (this.habitat.getVoluntarios().get(i).getNomeVoluntario().equals(aux)) {
                key = i;
            }
        }
        this.habitat.getVoluntarios().remove(key);
        listaVoluntarios.clearSelection();
        listaVoluntarios();
        this.jTextPaneNome.setText(null);
        this.jTextPaneDatNasc.setText(null);
        this.jTextPaneLocalidade.setText(null);
        this.jTextPaneRua.setText(null);
        this.jTextPaneProf.setText(null);
        this.jTextPaneCod.setText(null);
        this.jTextPaneEquipa.setText(null);


    }//GEN-LAST:event_jButtonRemoverActionPerformed

    private void jCheckBoxDisponivelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxDisponivelActionPerformed
        updateListaVoluntarios();
    }//GEN-LAST:event_jCheckBoxDisponivelActionPerformed

    private void jCheckBoxIndisponivelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxIndisponivelActionPerformed
        updateListaVoluntarios();
    }//GEN-LAST:event_jCheckBoxIndisponivelActionPerformed

    private void listMateriaisValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listMateriaisValueChanged
        String aux = seleccionaMaterial();
        String id = aux.split(" ")[0];
        int i = Integer.parseInt(id);
        Material m = this.habitat.getMateriais().get(i);

        if (aux != null && m != null) {
            String quant = Double.toString(m.getStock());
            this.txtQuantidade.setText(quant);
            this.txtDescricao.setText(m.getDescricao());
            this.txtDoador.setText(Integer.toString(m.getId_donativo()));
            this.txtProjeto.setText(Integer.toString(m.getId_projecto()));
        }
    }//GEN-LAST:event_listMateriaisValueChanged

    private void listaProjectosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaProjectosValueChanged
        // TODO add your handling code here:
        String aux = seleccionaProjeto();
        int id = Integer.parseInt(aux);
        Projeto p = this.habitat.getProjetos().get(id);
        Familia f = this.habitat.getFamilias().get(p.getId_Familia());

        if (aux != null && p != null) {

            //this.NomeFamilia.setText("aaa");
            this.NomeFamilia.setText(f.getNome());
            this.Estado.setSelectedItem(p.getestado());

            DefaultListModel<String> str = new DefaultListModel<>();
            for (Voluntario v : p.getVoluntarios()) {
                str.addElement(v.getNomeVoluntario());
            }
            listaVoluntariosProj.setModel(str);
        }
    }//GEN-LAST:event_listaProjectosValueChanged

    private void listaEventosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaEventosValueChanged
        // TODO add your handling code here:
        String aux = seleccionaEvento();
        Evento e = this.habitat.getEvento(aux);

        if (aux != null && e != null) {
            this.dataEvento.setText(e.getData().toString());
            for (Donativo d : e.getDonativos()) {
            }
        }
    }//GEN-LAST:event_listaEventosValueChanged

    private void listaDonativosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaDonativosValueChanged
        // TODO add your handling code here:
        String aux = seleccionaDonativo();
        
        if (aux != null) {
            Donativo d = this.habitat.getDonativos().get(Integer.parseInt(aux));
            Doador doa = this.habitat.getDoadores().get(d.getId_doador());
            String quant = Double.toString(d.getQuantidade());
            String valor = Float.toString(d.getValor());
            this.quantidadeDon.setText(quant);
            this.valorDon.setText(valor);
            this.DescricaoDon.setText(d.getDescricao());
            this.nomeDoa.setText(doa.getNome());
            this.biDoa.setText(doa.getBi());
            this.tipoDoa.setText(doa.getTipo());
            this.nifDoa.setText(doa.getNif());
        }
    }//GEN-LAST:event_listaDonativosValueChanged

    private void jCheckBoxRealizadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxRealizadosActionPerformed
        // TODO add your handling code here:
        updateListaEventos();
    }//GEN-LAST:event_jCheckBoxRealizadosActionPerformed

    private void jCheckBoxARealizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxARealizarActionPerformed
        // TODO add your handling code here:
        updateListaEventos();
    }//GEN-LAST:event_jCheckBoxARealizarActionPerformed

    private void jCheckBoxMaodeObraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMaodeObraActionPerformed
        // TODO add your handling code here:
        updateListaDonativos();
    }//GEN-LAST:event_jCheckBoxMaodeObraActionPerformed
    
    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        // TODO add your handling code here:
        //Donativos
        this.jButton25.setVisible(false);
        this.jButton24.setVisible(true);
        this.quantidadeDon.setEditable(false);
        this.valorDon.setEditable(false);
        this.DescricaoDon.setEditable(false);
        
        String aux = seleccionaDonativo();
        int id = Integer.parseInt(aux);
        
        Double q = Double.parseDouble(this.quantidadeDon.getText());
        Float f = Float.parseFloat(this.valorDon.getText());

        Donativo don = new Donativo(id,this.DescricaoDon.getText(),f,q);
        
        atualizaDonativo(id, don);
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        // TODO add your handling code here:
        //Donativos
        this.jButton24.setVisible(false);
        this.jButton25.setVisible(true);
        this.quantidadeDon.setEditable(true);
        this.valorDon.setEditable(true);
        this.DescricaoDon.setEditable(true);
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        String aux = seleccionaDonativo();
        int id = Integer.parseInt(aux);

        this.habitat.getDonativos().remove(id);
        listaDonativos.clearSelection();
        listaDonativos();
        this.quantidadeDon.setText(null);
        this.valorDon.setText(null);
        this.nomeDoa.setText(null);
        this.biDoa.setText(null);
        this.nifDoa.setText(null);
        this.tipoDoa.setText(null);
        this.DescricaoDon.setText(null);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        String aux = seleccionaEvento();
        int id = Integer.parseInt(aux);

        this.habitat.getEventos().remove(id);
        listaEventos.clearSelection();
        listaEventos();
    }//GEN-LAST:event_jButton14ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea DescricaoDon;
    private javax.swing.JPanel Donativos;
    private javax.swing.JComboBox Estado;
    private javax.swing.JPanel Eventos;
    private javax.swing.JTextPane NomeFamilia;
    private javax.swing.JTabbedPane PainelPrincipal;
    private javax.swing.JPanel Projectos;
    private javax.swing.JPanel Stock;
    private javax.swing.JPanel Voluntarios;
    private javax.swing.JTextPane biDoa;
    private javax.swing.JTextPane dataEvento;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButtonAdicionar;
    private javax.swing.JButton jButtonConfirmarEditar;
    private javax.swing.JButton jButtonEditarVoluntario;
    private javax.swing.JButton jButtonRemover;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBoxARealizar;
    private javax.swing.JCheckBox jCheckBoxDisponivel;
    private javax.swing.JCheckBox jCheckBoxIndisponivel;
    private javax.swing.JCheckBox jCheckBoxMaodeObra;
    private javax.swing.JCheckBox jCheckBoxMaterial;
    private javax.swing.JCheckBox jCheckBoxMonetario;
    private javax.swing.JCheckBox jCheckBoxRealizados;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelCod;
    private javax.swing.JLabel jLabelDatNasc;
    private javax.swing.JLabel jLabelDataLocalidade;
    private javax.swing.JLabel jLabelEquipa;
    private javax.swing.JLabel jLabelImagem;
    private javax.swing.JLabel jLabelInformacao;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelProf;
    private javax.swing.JLabel jLabelRua;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanelInformacao;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane23;
    private javax.swing.JScrollPane jScrollPane24;
    private javax.swing.JScrollPane jScrollPane25;
    private javax.swing.JScrollPane jScrollPane26;
    private javax.swing.JScrollPane jScrollPane27;
    private javax.swing.JScrollPane jScrollPane28;
    private javax.swing.JScrollPane jScrollPane29;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPaneCod;
    private javax.swing.JScrollPane jScrollPaneDatNasc;
    private javax.swing.JScrollPane jScrollPaneEquipa;
    private javax.swing.JScrollPane jScrollPaneLocalidade;
    private javax.swing.JScrollPane jScrollPaneNome;
    private javax.swing.JScrollPane jScrollPaneProf;
    private javax.swing.JScrollPane jScrollPaneRua;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextPane jTextPane2;
    private javax.swing.JTextPane jTextPaneCod;
    private javax.swing.JTextPane jTextPaneDatNasc;
    private javax.swing.JTextPane jTextPaneEquipa;
    private javax.swing.JTextPane jTextPaneLocalidade;
    private javax.swing.JTextPane jTextPaneNome;
    private javax.swing.JTextPane jTextPaneProf;
    private javax.swing.JTextPane jTextPaneRua;
    private javax.swing.JList listMateriais;
    private javax.swing.JList listaDonativos;
    private javax.swing.JList listaEventos;
    private javax.swing.JList listaProjectos;
    private javax.swing.JList listaVoluntarios;
    private javax.swing.JList listaVoluntariosProj;
    private javax.swing.JTextPane nifDoa;
    private javax.swing.JTextPane nomeDoa;
    private javax.swing.JTextPane quantidadeDon;
    private javax.swing.JTextPane tipoDoa;
    private javax.swing.JTextPane txtDescricao;
    private javax.swing.JTextPane txtDoador;
    private javax.swing.JTextPane txtProjeto;
    private javax.swing.JTextPane txtQuantidade;
    private javax.swing.JTextPane valorDon;
    // End of variables declaration//GEN-END:variables
}
