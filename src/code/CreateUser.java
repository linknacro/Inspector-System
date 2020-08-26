/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code;

import javax.swing.*;
import java.sql.*;

/**
 *
 * @author link_nacro
 */
public class CreateUser extends javax.swing.JFrame {

    /**
     * Creates new form CreateUser1
     */
    public CreateUser(String role, Connection connection) {
        this.role = role;
        this.connection = connection;
        initComponents();
        userError1.setVisible(false);
        userError2.setVisible(false);
        passwordError1.setVisible(false);
        passwordError2.setVisible(false);
        adminError.setVisible(false);
        successMsg.setVisible(false);
        if (role.equals("administrator")) {
            adminLbl.setVisible(false);
            adminField.setVisible(false);
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

        background = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        userLbl = new javax.swing.JLabel();
        passwordLbl = new javax.swing.JLabel();
        confirmLbl = new javax.swing.JLabel();
        userfield = new javax.swing.JTextField();
        passwordField1 = new javax.swing.JPasswordField();
        passwordField2 = new javax.swing.JPasswordField();
        doneBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        userError1 = new javax.swing.JLabel();
        passwordError1 = new javax.swing.JLabel();
        passwordError2 = new javax.swing.JLabel();
        userError2 = new javax.swing.JLabel();
        adminLbl = new javax.swing.JLabel();
        adminField = new javax.swing.JTextField();
        adminError = new javax.swing.JLabel();
        successMsg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        background.setBackground(new java.awt.Color(84, 91, 89));

        title.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        title.setForeground(new java.awt.Color(204, 255, 255));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Create Your User");

        userLbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        userLbl.setForeground(new java.awt.Color(240, 240, 240));
        userLbl.setText("Username:");

        passwordLbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        passwordLbl.setForeground(new java.awt.Color(240, 240, 240));
        passwordLbl.setText("Password:");

        confirmLbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        confirmLbl.setForeground(new java.awt.Color(240, 240, 240));
        confirmLbl.setText("Confirm Password:");

        userfield.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        passwordField1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        passwordField2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        doneBtn.setBackground(new java.awt.Color(168, 215, 216));
        doneBtn.setText("Done");
        doneBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doneBtnActionPerformed(evt);
            }
        });

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

        userError1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        userError1.setForeground(new java.awt.Color(255, 0, 51));
        userError1.setText("Username cannot be empty!");

        passwordError1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        passwordError1.setForeground(new java.awt.Color(255, 0, 51));
        passwordError1.setText("Password cannot be empty!");

        passwordError2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        passwordError2.setForeground(new java.awt.Color(255, 0, 51));
        passwordError2.setText("Passwords do not match!");

        userError2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        userError2.setForeground(new java.awt.Color(255, 0, 51));
        userError2.setText("User already exists!");

        adminLbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        adminLbl.setForeground(new java.awt.Color(240, 240, 240));
        adminLbl.setText("Administrator:");

        adminField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        adminError.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        adminError.setForeground(new java.awt.Color(255, 0, 51));
        adminError.setText("Administrator does not exist!");

        successMsg.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        successMsg.setForeground(new java.awt.Color(255, 255, 255));
        successMsg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        successMsg.setText("New User Created Successfully ");

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(confirmLbl)
                            .addComponent(passwordLbl)
                            .addComponent(userLbl)
                            .addComponent(adminLbl))
                        .addGap(18, 18, 18)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addComponent(passwordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(passwordError1))
                            .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addComponent(doneBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(userError2))
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addComponent(userfield, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(userError1))
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addComponent(passwordField2, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(passwordError2))
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addComponent(adminField, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(adminError))))
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backBtn)))
                .addContainerGap(60, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(successMsg)
                .addGap(232, 232, 232))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backBtn)
                .addGap(18, 18, 18)
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userLbl)
                    .addComponent(userfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userError1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordError1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmLbl)
                    .addComponent(passwordField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordError2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adminLbl)
                    .addComponent(adminField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(adminError))
                .addGap(21, 21, 21)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(doneBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userError2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(successMsg)
                .addContainerGap(63, Short.MAX_VALUE))
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
        Login log = new Login(role, connection);
        log.setVisible(true);
        log.pack();
        log.setLocationRelativeTo(null);
        log.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_backBtnActionPerformed

    private void doneBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doneBtnActionPerformed
        // TODO add your handling code here:
        userError1.setVisible(false);
        userError2.setVisible(false);
        passwordError1.setVisible(false);
        passwordError2.setVisible(false);
        adminError.setVisible(false);
        
        String username = userfield.getText().trim();
        String password1 = String.valueOf(passwordField1.getPassword()).trim();
        String password2 = String.valueOf(passwordField2.getPassword()).trim();
        
        if (username.length() <= 0) {
            userError1.setVisible(true);
        }
        else if (password1.length() <= 0) {
            passwordError1.setVisible(true);
        }
        else if (!password2.equals(password1)) {
            passwordError2.setVisible(true);
        }
        else if (username.length() != 0 && password1.equals(password2)) {
            if (role.equals("administrator")) {
                String sql = "INSERT INTO administrators (name, password) VALUES (?, ?)";
                try {
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setString(1, username);
                    statement.setString(2, password1);
                    statement.execute();
                    successMsg.setVisible(true);
                    userError2.setVisible(false);
                } catch (SQLException ex) {
                    userError2.setVisible(true);
                    successMsg.setVisible(false);
                }
            }
            if (role.equals("inspector")) {
                String adminName = adminField.getText().trim();
                String sql = "SELECT * FROM administrators WHERE name = ?";
                try {
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setString(1, adminName);
                    ResultSet result = statement.executeQuery();
                    if (result.next()) {
                        int adminID = result.getInt(1);
                        sql = "INSERT INTO inspectors (name, password, admin_id) VALUES (?, ?, ?)";
                        PreparedStatement command = connection.prepareStatement(sql);
                        command.setString(1, username);
                        command.setString(2, password1);
                        command.setInt(3, adminID);
                        command.execute();
                        successMsg.setVisible(true);
                        adminError.setVisible(false);
                    }
                    else {
                        successMsg.setVisible(false);
                        adminError.setVisible(true);
                    }
                } catch (SQLException ex) {
                    successMsg.setVisible(false);
                    userError2.setVisible(true);
                }
            }
        }
    }//GEN-LAST:event_doneBtnActionPerformed

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
            java.util.logging.Logger.getLogger(CreateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateUser("administrator", null).setVisible(true);
            }
        });
    }

    private String role;
    private Connection connection;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel adminError;
    private javax.swing.JTextField adminField;
    private javax.swing.JLabel adminLbl;
    private javax.swing.JButton backBtn;
    private javax.swing.JPanel background;
    private javax.swing.JLabel confirmLbl;
    private javax.swing.JButton doneBtn;
    private javax.swing.JLabel passwordError1;
    private javax.swing.JLabel passwordError2;
    private javax.swing.JPasswordField passwordField1;
    private javax.swing.JPasswordField passwordField2;
    private javax.swing.JLabel passwordLbl;
    private javax.swing.JLabel successMsg;
    private javax.swing.JLabel title;
    private javax.swing.JLabel userError1;
    private javax.swing.JLabel userError2;
    private javax.swing.JLabel userLbl;
    private javax.swing.JTextField userfield;
    // End of variables declaration//GEN-END:variables
}
