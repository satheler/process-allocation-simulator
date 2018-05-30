/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import algoritmo.BestFit;
import algoritmo.FirstFit;
import algoritmo.Fit;
import algoritmo.WorstFit;
import gerais.LeitorArquivo;
import java.io.File;

/**
 *
 * @author Lucas
 */
public class Interface extends javax.swing.JFrame {

    private File arquivo;
    private Fit fit;

    int contadorProcessosTotal = 0;
    int contadorProcessos = 0;
    int tamanhoMemoria;
    long tempoExecucao;
    float fragmentacao = 0;

    /**
     * Creates new form view
     */
    public Interface() {
        initComponents();

        tamanhoMemoria = Integer.valueOf(String.valueOf(jComboBoxTamanhoMemoria.getSelectedItem()));;
//        tamanhoMemoria = 10;
        jButtonStart.setEnabled(false);
        jButtonStep.setEnabled(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPanePlot = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jButtonImportar = new javax.swing.JButton();
        jLabelTamanhoMemoria = new javax.swing.JLabel();
        jComboBoxTamanhoMemoria = new javax.swing.JComboBox<>();
        jComboBoxEscalonadores = new javax.swing.JComboBox<>();
        jButtonStart = new javax.swing.JButton();
        jButtonStep = new javax.swing.JButton();
        jLabelHeuristica = new javax.swing.JLabel();
        jPanelInformacoes = new javax.swing.JPanel();
        jPanelTempoClock = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabelTempoClock = new javax.swing.JLabel();
        jPanelFragmentacao = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabelFragmentacao = new javax.swing.JLabel();
        jPanelFragmentacao1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabelTempoExecucao = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabelTentativasFalhas = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabelProcessosMemoria = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Simulador de Alocação de Processos");
        setResizable(false);

        jScrollPanePlot.setToolTipText("");
        jScrollPanePlot.setMaximumSize(new java.awt.Dimension(1064, 242));
        jScrollPanePlot.setMinimumSize(new java.awt.Dimension(1064, 242));
        jScrollPanePlot.setName(""); // NOI18N
        jScrollPanePlot.setPreferredSize(new java.awt.Dimension(1640, 242));
        jScrollPanePlot.setVerifyInputWhenFocusTarget(false);

        jButtonImportar.setText("Importar");
        jButtonImportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonImportarActionPerformed(evt);
            }
        });

        jLabelTamanhoMemoria.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTamanhoMemoria.setText("Tamanho da mémoria");

        jComboBoxTamanhoMemoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1024", "2048", "4096", "8192" }));
        jComboBoxTamanhoMemoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxTamanhoMemoriaItemStateChanged(evt);
            }
        });

        jComboBoxEscalonadores.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "FirstFit", "BestFit", "WorstFit" }));
        jComboBoxEscalonadores.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxEscalonadoresItemStateChanged(evt);
            }
        });

        jButtonStart.setText("Executar tudo");
        jButtonStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStartActionPerformed(evt);
            }
        });

        jButtonStep.setText("Executar Evento");
        jButtonStep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStepActionPerformed(evt);
            }
        });

        jLabelHeuristica.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelHeuristica.setText("Solução");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButtonImportar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonStep, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                    .addComponent(jComboBoxTamanhoMemoria, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelHeuristica, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxEscalonadores, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonStart, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                    .addComponent(jLabelTamanhoMemoria, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonImportar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabelTamanhoMemoria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBoxTamanhoMemoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabelHeuristica)
                .addGap(10, 10, 10)
                .addComponent(jComboBoxEscalonadores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jButtonStart)
                .addGap(18, 18, 18)
                .addComponent(jButtonStep)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButtonImportar, jButtonStart, jButtonStep, jComboBoxEscalonadores, jComboBoxTamanhoMemoria});

        jLabel1.setText("TempoClock Atual");

        jLabelTempoClock.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabelTempoClock.setText("   ");

        javax.swing.GroupLayout jPanelTempoClockLayout = new javax.swing.GroupLayout(jPanelTempoClock);
        jPanelTempoClock.setLayout(jPanelTempoClockLayout);
        jPanelTempoClockLayout.setHorizontalGroup(
            jPanelTempoClockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTempoClockLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanelTempoClockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelTempoClock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        jPanelTempoClockLayout.setVerticalGroup(
            jPanelTempoClockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTempoClockLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabelTempoClock)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setText("Fragmentacao");

        jLabelFragmentacao.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabelFragmentacao.setText("     ");

        javax.swing.GroupLayout jPanelFragmentacaoLayout = new javax.swing.GroupLayout(jPanelFragmentacao);
        jPanelFragmentacao.setLayout(jPanelFragmentacaoLayout);
        jPanelFragmentacaoLayout.setHorizontalGroup(
            jPanelFragmentacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFragmentacaoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanelFragmentacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelFragmentacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanelFragmentacaoLayout.setVerticalGroup(
            jPanelFragmentacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFragmentacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabelFragmentacao)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setText("Tempo de Execução");

        jLabelTempoExecucao.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabelTempoExecucao.setText("     ");

        javax.swing.GroupLayout jPanelFragmentacao1Layout = new javax.swing.GroupLayout(jPanelFragmentacao1);
        jPanelFragmentacao1.setLayout(jPanelFragmentacao1Layout);
        jPanelFragmentacao1Layout.setHorizontalGroup(
            jPanelFragmentacao1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFragmentacao1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanelFragmentacao1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelTempoExecucao, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(20, 20, 20))
        );
        jPanelFragmentacao1Layout.setVerticalGroup(
            jPanelFragmentacao1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFragmentacao1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabelTempoExecucao, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setText("Tentativas Falhas");

        jLabelTentativasFalhas.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabelTentativasFalhas.setText("     ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelTentativasFalhas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabelTentativasFalhas)
                .addContainerGap(118, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Legenda"));

        jPanel4.setBackground(new java.awt.Color(0, 200, 0));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 19, Short.MAX_VALUE)
        );

        jLabel5.setText("Processos");

        jPanel5.setBackground(java.awt.Color.gray);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 19, Short.MAX_VALUE)
        );

        jLabel6.setText("Espaco Livre");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(20, 20, 20))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jPanel4, jPanel5});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jPanel4, jPanel5});

        jLabel7.setText("Processos na Memoria");

        jLabelProcessosMemoria.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabelProcessosMemoria.setText("     ");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelProcessosMemoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jLabelProcessosMemoria)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelInformacoesLayout = new javax.swing.GroupLayout(jPanelInformacoes);
        jPanelInformacoes.setLayout(jPanelInformacoesLayout);
        jPanelInformacoesLayout.setHorizontalGroup(
            jPanelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInformacoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelTempoClock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jPanelFragmentacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jPanelFragmentacao1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelInformacoesLayout.setVerticalGroup(
            jPanelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelInformacoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelFragmentacao1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelFragmentacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelTempoClock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanelInformacoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPanePlot, javax.swing.GroupLayout.PREFERRED_SIZE, 1064, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPanePlot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanelInformacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStartActionPerformed

        this.executar();

        jButtonStep.setEnabled(false);

    }//GEN-LAST:event_jButtonStartActionPerformed

    private void jButtonStepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStepActionPerformed

        this.executarEvento();


    }//GEN-LAST:event_jButtonStepActionPerformed

    private void jButtonImportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImportarActionPerformed
        arquivo = LeitorArquivo.carregarArquivo();
        if (arquivo != null) {
            jButtonStart.setEnabled(true);
            jButtonStep.setEnabled(true);
        }

        fit = null;

    }//GEN-LAST:event_jButtonImportarActionPerformed

    private void jComboBoxEscalonadoresItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxEscalonadoresItemStateChanged

        if (arquivo != null) {
            jButtonStep.setEnabled(true);
            jButtonStart.setEnabled(true);
        }

        fit = null;


    }//GEN-LAST:event_jComboBoxEscalonadoresItemStateChanged

    private void jComboBoxTamanhoMemoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxTamanhoMemoriaItemStateChanged

        tamanhoMemoria = Integer.valueOf(String.valueOf(jComboBoxTamanhoMemoria.getSelectedItem()));

    }//GEN-LAST:event_jComboBoxTamanhoMemoriaItemStateChanged

    private void executar() {

        if (fit == null) {
            switch ((String) jComboBoxEscalonadores.getSelectedItem()) {
                case "FirstFit":
                    fit = new FirstFit(LeitorArquivo.montarLista(arquivo), tamanhoMemoria);
                    break;
                case "BestFit":
                    fit = new BestFit(LeitorArquivo.montarLista(arquivo), tamanhoMemoria);
                    break;
                case "WorstFit":
                    fit = new WorstFit(LeitorArquivo.montarLista(arquivo), tamanhoMemoria);
                    break;
            }
        }

        PlotMemoria plot;
        plot = new PlotMemoria(fit.getMemoria());
        jScrollPanePlot.getViewport().add(plot);
        jScrollPanePlot.repaint();

        fragmentacao = 0;
        long inicio = System.nanoTime();

        while (!fit.getGerenciadorProcessos().finalizou()) {
            fit.executar();
            fragmentacao+= fit.contarEspacos();
        }

        fragmentacao = fragmentacao/(float)fit.getTempoClock();
        
        tempoExecucao = System.nanoTime() - inicio;

        preencherInformacoes();

        jButtonStart.setEnabled(false);

    }

    private void executarEvento() {

        if (fit == null) {
            switch ((String) jComboBoxEscalonadores.getSelectedItem()) {
                case "FirstFit":
                    fit = new FirstFit(LeitorArquivo.montarLista(arquivo), tamanhoMemoria);
                    break;
                case "BestFit":
                    fit = new BestFit(LeitorArquivo.montarLista(arquivo), tamanhoMemoria);
                    break;
                case "WorstFit":
                    fit = new WorstFit(LeitorArquivo.montarLista(arquivo), tamanhoMemoria);
                    break;
            }
        }

        PlotMemoria plot;
        
        long inicio = System.nanoTime();

        while (!fit.executar()) {

        }
        
        fragmentacao+= fit.contarEspacos()/fit.getTempoClock();
        
        tempoExecucao = System.nanoTime() - inicio;
        
        plot = new PlotMemoria(fit.getMemoria());
        jScrollPanePlot.getViewport().add(plot);
        jScrollPanePlot.repaint();

        if (fit.getGerenciadorProcessos().finalizou()) {
            jButtonStep.setEnabled(false);
        }

        preencherInformacoes();

    }

    private void preencherInformacoes() {
        jLabelTempoClock.setText(String.valueOf(fit.getTempoClock()));
        System.out.println("Tempo Clock");
        System.out.println(String.valueOf(fit.getTempoClock()));
        
        jLabelTempoExecucao.setText(String.valueOf(tempoExecucao));
        System.out.println("Tempo Execucao");
        System.out.println(String.valueOf(tempoExecucao));
        
        jLabelTentativasFalhas.setText(String.valueOf(fit.getTentativasFalhas()));
        System.out.println("Tentativas Falhas");
        System.out.println(String.valueOf(fit.getTentativasFalhas()));
        
        jLabelFragmentacao.setText(String.valueOf(fragmentacao));
        System.out.println("Quantidade Buracos");
        System.out.println(String.valueOf(fragmentacao));        
        
        jLabelProcessosMemoria.setText(String.valueOf(fit.getMemoria().getQuantidadeProcessos()));
        System.out.println("Quantidade de Processos na Memoria");
        System.out.println(String.valueOf(fit.getMemoria().getQuantidadeProcessos()));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Interface frame1 = new Interface();
                frame1.setVisible(true);
                frame1.setLocationRelativeTo(null);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonImportar;
    private javax.swing.JButton jButtonStart;
    private javax.swing.JButton jButtonStep;
    private javax.swing.JComboBox<String> jComboBoxEscalonadores;
    private javax.swing.JComboBox<String> jComboBoxTamanhoMemoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelFragmentacao;
    private javax.swing.JLabel jLabelHeuristica;
    private javax.swing.JLabel jLabelProcessosMemoria;
    private javax.swing.JLabel jLabelTamanhoMemoria;
    private javax.swing.JLabel jLabelTempoClock;
    private javax.swing.JLabel jLabelTempoExecucao;
    private javax.swing.JLabel jLabelTentativasFalhas;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanelFragmentacao;
    private javax.swing.JPanel jPanelFragmentacao1;
    private javax.swing.JPanel jPanelInformacoes;
    private javax.swing.JPanel jPanelTempoClock;
    private javax.swing.JScrollPane jScrollPanePlot;
    // End of variables declaration//GEN-END:variables

}
