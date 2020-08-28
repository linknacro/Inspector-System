/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code;

/**
 *
 * @author link_nacro
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class AddNewTask extends javax.swing.JFrame {

    /**
     * Creates new form AddNewTask
     */
    public AddNewTask(Connection connection, String adminName, String adminID) {
        initComponents();
        this.connection = connection;
        this.adminName = adminName;
        this.adminID = adminID;
        errorMsg.setVisible(false);
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        inspecLbl = new javax.swing.JLabel();
        taskLbl = new javax.swing.JLabel();
        descriptionLbl = new javax.swing.JLabel();
        inspecField = new javax.swing.JTextField();
        taskField = new javax.swing.JTextField();
        backBtn = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();
        errorMsg = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptionArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inspector System");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        background.setBackground(new java.awt.Color(84, 91, 89));

        inspecLbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        inspecLbl.setForeground(new java.awt.Color(153, 255, 255));
        inspecLbl.setText("Insepctor Name:");

        taskLbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        taskLbl.setForeground(new java.awt.Color(153, 255, 255));
        taskLbl.setText("Task Name:");

        descriptionLbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        descriptionLbl.setForeground(new java.awt.Color(153, 255, 255));
        descriptionLbl.setText("Task Description:");

        inspecField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        taskField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        backBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        backBtn.setForeground(new java.awt.Color(240, 240, 240));
        backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/code/back.png"))); // NOI18N
        backBtn.setText(" Go Back");
        backBtn.setBorderPainted(false);
        backBtn.setContentAreaFilled(false);
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        addBtn.setBackground(new java.awt.Color(168, 215, 216));
        addBtn.setText("Add");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        errorMsg.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        errorMsg.setForeground(new java.awt.Color(255, 51, 51));
        errorMsg.setText("jLabel1");

        descriptionArea.setColumns(20);
        descriptionArea.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        descriptionArea.setRows(5);
        jScrollPane1.setViewportView(descriptionArea);

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backBtn))
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addComponent(descriptionLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(inspecLbl)
                                    .addComponent(taskLbl))
                                .addGap(18, 18, 18)
                                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(inspecField)
                                    .addComponent(taskField)))
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(errorMsg)))))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backBtn)
                .addGap(42, 42, 42)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inspecLbl)
                    .addComponent(inspecField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(taskLbl)
                    .addComponent(taskField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descriptionLbl)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(errorMsg))
                .addGap(64, 64, 64))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        TaskPage page = new TaskPage("administrator", adminID, adminName, connection);
        page.setVisible(true);
        page.pack();
        page.setLocationRelativeTo(null);
        page.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_backBtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        // TODO add your handling code here:
        errorMsg.setVisible(false);
        
        String name = inspecField.getText().trim();
        String taskName = taskField.getText().trim();
        String description = descriptionArea.getText().trim();
        
        if (name.length() <= 0) {
            errorMsg.setText("Inspector name cannot be empty!");
            errorMsg.setVisible(true);
        }
        else if (taskName.length() <= 0) {
            errorMsg.setText("Task name cannot be empty!");
            errorMsg.setVisible(true);
        }
        else if (description.length() <= 0) {
            errorMsg.setText("Task description cannot be empty!");
            errorMsg.setVisible(true);
        }
        
        String query = "SELECT * FROM inspectors WHERE name = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, name);
            ResultSet result = statement.executeQuery();
            
            if (result.next()) {
                String sql = "INSERT INTO tasks (name, description, admin, inspector) VALUES (?, ?, ?, ?)";
                statement = connection.prepareStatement(sql);
                statement.setString(1, taskName);
                statement.setString(2, description);
                statement.setString(3, adminName);
                statement.setString(4, name);
                statement.execute();
                
                TaskPage page = new TaskPage("administrator", adminID, adminName, connection);
                page.setVisible(true);
                page.pack();
                page.setLocationRelativeTo(null);
                page.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                this.dispose();
            }
            else {
                errorMsg.setText("This inspector does not exist!");
                errorMsg.setVisible(true);
            }
        } catch (SQLException ex) {
            System.out.println("FUUCKK NOOOO");
            ex.printStackTrace();
        }
    }//GEN-LAST:event_addBtnActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            connection.close();
            System.out.println("System Shut Down");
        } catch (SQLException ex) {
            System.out.println("FUUUCKK NOOOO");
        }
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(AddNewTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddNewTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddNewTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddNewTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddNewTask(null, "admin", "id").setVisible(true);
            }
        });
    }
    
    private Connection connection;
    private String adminName;
    private String adminID;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JButton backBtn;
    private javax.swing.JPanel background;
    private javax.swing.JTextArea descriptionArea;
    private javax.swing.JLabel descriptionLbl;
    private javax.swing.JLabel errorMsg;
    private javax.swing.JTextField inspecField;
    private javax.swing.JLabel inspecLbl;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField taskField;
    private javax.swing.JLabel taskLbl;
    // End of variables declaration//GEN-END:variables
}
