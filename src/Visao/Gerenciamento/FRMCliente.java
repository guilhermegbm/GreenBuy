/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao.Gerenciamento;

import Visao.Edicao.FRMEditarCliente;
import Visao.Cadastro.FRMCadastrarCliente;
import Controle.ControleCliente;
import Modelo.BEAN.Cliente;
import java.awt.Color;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Guilherme
 */
public class FRMCliente extends javax.swing.JFrame {

    private DefaultTableModel dTable;
    private List<Cliente> dados;

    /**
     * Creates new form FRMCliente
     */
    public FRMCliente() {
        initComponents();

        try {
            dados = ControleCliente.listarTodosAtivos();
            this.preencheTabela();
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(null, "Deu ruim: " + e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnCadastrarCliente = new javax.swing.JButton();
        btnDelCliente = new javax.swing.JButton();
        btnEdtCliente = new javax.swing.JButton();
        btnLocalizarCliente = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cbOpc = new javax.swing.JComboBox<>();
        tfDado = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCliente = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cliente");

        jPanel2.setBackground(new java.awt.Color(153, 255, 153));

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnCadastrarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Visao.icon/clienteAdd.png"))); // NOI18N
        btnCadastrarCliente.setText("Cadastrar");
        btnCadastrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarClienteActionPerformed(evt);
            }
        });

        btnDelCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Visao.icon/clienteDel.png"))); // NOI18N
        btnDelCliente.setText("Desligar");
        btnDelCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelClienteActionPerformed(evt);
            }
        });

        btnEdtCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Visao.icon/Editar.png"))); // NOI18N
        btnEdtCliente.setText("Editar");
        btnEdtCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEdtClienteActionPerformed(evt);
            }
        });

        btnLocalizarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Visao.icon/CliLoc.png"))); // NOI18N
        btnLocalizarCliente.setText("Localizar");
        btnLocalizarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocalizarClienteActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Visao.icon/logout.png"))); // NOI18N
        btnCancelar.setText("Voltar");

        jLabel1.setText("Localizar cliente por:");

        cbOpc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos os Ativos", "Código", "Nome", "Mostrar Desligados" }));
        cbOpc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbOpcActionPerformed(evt);
            }
        });

        tfDado.setForeground(new java.awt.Color(153, 153, 153));
        tfDado.setText("Insira o dado para pesquisa...");
        tfDado.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfDadoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfDadoFocusLost(evt);
            }
        });
        tfDado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDadoActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(204, 255, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Lista de Clientes:"));

        tableCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tableCliente);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbOpc, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfDado, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnLocalizarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCadastrarCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDelCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEdtCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLocalizarCliente)
                    .addComponent(jLabel1)
                    .addComponent(cbOpc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfDado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(btnCadastrarCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEdtCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDelCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 183, Short.MAX_VALUE)
                        .addComponent(btnCancelar)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbOpcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbOpcActionPerformed
        if (cbOpc.getSelectedIndex() == 0) {
            try {
                dados = ControleCliente.listarTodosAtivos();
                this.preencheTabela();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Deu ruim: " + e);
            }
        } else if (cbOpc.getSelectedIndex() == 3) {
            try {
                dados = ControleCliente.listarTodosDesligados();
                this.preencheTabela();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Deu ruim: " + e);
            }
        }
    }//GEN-LAST:event_cbOpcActionPerformed

    private void tfDadoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfDadoFocusGained
        if (tfDado.getText().equals("Insira o dado para pesquisa...")) {
            tfDado.setText("");
            tfDado.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_tfDadoFocusGained

    private void tfDadoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfDadoFocusLost
        if (tfDado.getText().equals("")) {
            tfDado.setText("Insira o dado para pesquisa...");
            tfDado.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_tfDadoFocusLost

    private void tfDadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDadoActionPerformed
        this.localiza();
    }//GEN-LAST:event_tfDadoActionPerformed

    private void btnLocalizarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocalizarClienteActionPerformed
        this.localiza();
    }//GEN-LAST:event_btnLocalizarClienteActionPerformed

    private void btnCadastrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarClienteActionPerformed
        FRMCadastrarCliente objCadastrar = new FRMCadastrarCliente();
        objCadastrar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCadastrarClienteActionPerformed

    private void btnEdtClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEdtClienteActionPerformed
        FRMEditarCliente edtCliente = new FRMEditarCliente();
        int qtd = tableCliente.getSelectedRowCount();

        if (qtd < 1) {
            JOptionPane.showMessageDialog(null, "Selecione um ítem da lista ao lado para deletar.");
        } else if (qtd > 1) {
            JOptionPane.showMessageDialog(null, "Apenas um ítem da lista deve ser selecionado por vez.");
        } else {
            edtCliente.pegaCliente(dados.get(tableCliente.getSelectedRow()));

            edtCliente.setVisible(true);

            this.dispose();
        }
    }//GEN-LAST:event_btnEdtClienteActionPerformed

    private void btnDelClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelClienteActionPerformed
        int qtd = tableCliente.getSelectedRowCount();

        if (qtd < 1) {
            JOptionPane.showMessageDialog(null, "Selecione um ítem da lista ao lado para deletar.");
        } else if (qtd > 1) {
            JOptionPane.showMessageDialog(null, "Apenas um ítem da lista deve ser selecionado por vez.");
        } else {
            int linha = tableCliente.getSelectedRow();
            int opc = JOptionPane.showConfirmDialog(null, "Deseja realmente desativar o(a) cliente " + dados.get(linha).getNome() + "?");

            if (opc == 0) {
                try {
                    ControleCliente.desativaCliente(dados.get(linha));
                } catch (RuntimeException e) {
                    JOptionPane.showMessageDialog(null, "Deu ruim: " + e);
                }
            }
            dados = ControleCliente.listarTodosAtivos();
            this.preencheTabela();
        }
    }//GEN-LAST:event_btnDelClienteActionPerformed

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
            java.util.logging.Logger.getLogger(FRMCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FRMCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FRMCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FRMCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FRMCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrarCliente;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnDelCliente;
    private javax.swing.JButton btnEdtCliente;
    private javax.swing.JButton btnLocalizarCliente;
    private javax.swing.JComboBox<String> cbOpc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableCliente;
    private javax.swing.JTextField tfDado;
    // End of variables declaration//GEN-END:variables

    private void preencheTabela() {
        dTable = this.criaTabela();

        dTable.addColumn("Código");
        dTable.addColumn("Nome");
        dTable.addColumn("Login");
        dTable.addColumn("Telefone");

        for (Cliente dado : dados) {
            dTable.addRow(new Object[]{dado.getCodigo(), dado.getNome(), dado.getLogin(), dado.getTelefone()});
        }

        tableCliente.setModel(dTable);

    }

    private DefaultTableModel criaTabela() {
        DefaultTableModel dTable = new DefaultTableModel() {
            Class[] types = new Class[]{
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class,
                java.lang.String.class
            };
            boolean[] canEdit = new boolean[]{
                false, false, false, false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        ;

        };
    return dTable;
    }

    private void localiza() {
        if ((tfDado.getText().equals("")) || (tfDado.getText().equals("Insira o dado para pesquisa..."))) {
            JOptionPane.showMessageDialog(null, "Insira algum dado para pesquisa");
        } else {
            if (cbOpc.getSelectedIndex() == 1) {
                try {
                    dados = ControleCliente.listarTudoTodosOuPorCodigo(Integer.parseInt(tfDado.getText()));
                    this.preencheTabela();
                } catch (RuntimeException e) {
                    JOptionPane.showMessageDialog(null, "Deu ruim");
                    throw new RuntimeException(e);
                }

            } else if (cbOpc.getSelectedIndex() == 2) {
                try {
                    dados = ControleCliente.listarPorNome(tfDado.getText());
                    this.preencheTabela();
                } catch (RuntimeException e) {
                    JOptionPane.showMessageDialog(null, "Deu ruim");
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
