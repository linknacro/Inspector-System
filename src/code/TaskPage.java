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
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;

public class TaskPage extends javax.swing.JFrame {

    /**
     * Creates new form AdminPage
     */
    public TaskPage(String role, String id, String name, Connection connection) {
        initComponents();
        this.role = role;
        this.id = id;
        this.name = name;
        this.connection = connection;
        idDisplay.setText(id);
        nameDisplay.setText(name);
        errorMsg.setVisible(false);
       
        taskTable.setModel(new DefaultTableModel(0, 7));
        taskTable.getColumnModel().getColumn(0).setHeaderValue("Task ID");
        taskTable.getColumnModel().getColumn(1).setHeaderValue("Task Name");
        taskTable.getColumnModel().getColumn(2).setHeaderValue("Description");
        taskTable.getColumnModel().getColumn(3).setHeaderValue("Time(hours)");
        taskTable.getColumnModel().getColumn(4).setHeaderValue("Cost");
        taskTable.getColumnModel().getColumn(5).setHeaderValue("Administrator");
        taskTable.getColumnModel().getColumn(6).setHeaderValue("Inspector");
        taskTable.getTableHeader().resizeAndRepaint();
        taskTable.setRowSelectionAllowed(false);
        
        if (role.equals("inspector")) {
            idLbl.setText("Inspector ID:");
            doneBtn.setText("Report Results");
            taskTable.setRowSelectionAllowed(true);
        }
        
        finishedTable.setModel(new DefaultTableModel(0, 7));
        finishedTable.getColumnModel().getColumn(0).setHeaderValue("Task ID");
        finishedTable.getColumnModel().getColumn(1).setHeaderValue("Task Name");
        finishedTable.getColumnModel().getColumn(2).setHeaderValue("Description");
        finishedTable.getColumnModel().getColumn(3).setHeaderValue("Time(hours)");
        finishedTable.getColumnModel().getColumn(4).setHeaderValue("Cost");
        finishedTable.getColumnModel().getColumn(5).setHeaderValue("Administrator");
        finishedTable.getColumnModel().getColumn(6).setHeaderValue("Inspector");
        finishedTable.getTableHeader().resizeAndRepaint();
        
        fillTables();
        
        taskTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        resizeColumnWidth(taskTable);
        taskTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        taskTable.setDefaultEditor(Object.class, null);
        
        finishedTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        resizeColumnWidth(finishedTable);
        finishedTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        finishedTable.setRowSelectionAllowed(false);
        finishedTable.setDefaultEditor(Object.class, null);
        
        taskTable.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent mouseEvent) {
                JTable table = (JTable)mouseEvent.getSource();
                Point point = mouseEvent.getPoint();
                int row = table.rowAtPoint(point);
                if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
                    Object detail = table.getModel().getValueAt(row, 2);
                    String text = detail.toString();
                    
                    FullDescription window = new FullDescription(text);
                    window.setVisible(true);
                    window.pack();
                    window.setLocationRelativeTo(null);
                    window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                }
            }
        });
        
        finishedTable.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent mouseEvent) {
                JTable table = (JTable)mouseEvent.getSource();
                Point point = mouseEvent.getPoint();
                int row = table.rowAtPoint(point);
                if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
                    Object detail = table.getModel().getValueAt(row, 2);
                    String text = detail.toString();
                    
                    FullDescription window = new FullDescription(text);
                    window.setVisible(true);
                    window.pack();
                    window.setLocationRelativeTo(null);
                    window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                }
            }
        });
    }
    
    private void fillTables() {
        DefaultTableModel model = (DefaultTableModel) taskTable.getModel();
        DefaultTableModel finishedModel = (DefaultTableModel) finishedTable.getModel();
        
        String key = "";
        if (role.equals("administrator")) {
            key = "admin";
        }
        if (role.equals("inspector")) {
            key = "inspector";
        }
        String query = "SELECT * FROM tasks WHERE " + key + " = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, name);
            ResultSet result = statement.executeQuery();
            
            while (result.next()) {
                String time = Double.toString(result.getDouble(4));
                String cost = Double.toString(result.getDouble(5));
                if (result.getDouble(4) == 0 && result.getDouble(5) == 0) {
                    time = "_._";
                    cost = "_._";
                    model.addRow(new Object[] {
                        Integer.toString(result.getInt(1)),
                        result.getString(2),
                        result.getString(3),
                        time,
                        cost,
                        result.getString(6),
                        result.getString(7)
                    });
                    continue;
                }
                finishedModel.addRow(new Object[] {
                    Integer.toString(result.getInt(1)),
                    result.getString(2),
                    result.getString(3),
                    time,
                    cost,
                    result.getString(6),
                    result.getString(7)
                });
            }
        } catch (SQLException ex) {
            System.out.println("FUCCKKK NOOO");
            ex.printStackTrace();
        }
    }
    
    private void resizeColumnWidth(JTable table) {
        final TableColumnModel columnModel = table.getColumnModel();
        for (int column = 0; column < table.getColumnCount(); column++) {
            if (column == 2) {
                columnModel.getColumn(column).setPreferredWidth(80);
                continue;
            }
            int width = 90; // Min width
            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                Component comp = table.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width +1 , width);
            }
            if(width > 300)
                width = 300;
            columnModel.getColumn(column).setPreferredWidth(width);
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
        idLbl = new javax.swing.JLabel();
        nameLbl = new javax.swing.JLabel();
        idDisplay = new javax.swing.JLabel();
        nameDisplay = new javax.swing.JLabel();
        taskLbl = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        taskTable = new javax.swing.JTable();
        doneBtn = new javax.swing.JButton();
        logoutBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        finishedTable = new javax.swing.JTable();
        finishedLbl = new javax.swing.JLabel();
        errorMsg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        background.setBackground(new java.awt.Color(84, 91, 89));

        idLbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        idLbl.setForeground(new java.awt.Color(102, 255, 255));
        idLbl.setText("Administrator ID:");

        nameLbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nameLbl.setForeground(new java.awt.Color(102, 255, 255));
        nameLbl.setText("Name:");

        idDisplay.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        idDisplay.setForeground(new java.awt.Color(255, 255, 255));
        idDisplay.setText("jLabel3");

        nameDisplay.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        nameDisplay.setForeground(new java.awt.Color(255, 255, 255));
        nameDisplay.setText("jLabel4");

        taskLbl.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        taskLbl.setForeground(new java.awt.Color(153, 255, 153));
        taskLbl.setText("Current Tasks:");

        taskTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(taskTable);

        doneBtn.setBackground(new java.awt.Color(168, 215, 216));
        doneBtn.setText("Add New Task");
        doneBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doneBtnActionPerformed(evt);
            }
        });

        logoutBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        logoutBtn.setForeground(new java.awt.Color(255, 255, 255));
        logoutBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/code/logout.png"))); // NOI18N
        logoutBtn.setText("Logout");
        logoutBtn.setBorderPainted(false);
        logoutBtn.setContentAreaFilled(false);
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("Double-click on row to view full task description");

        finishedTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(finishedTable);

        finishedLbl.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        finishedLbl.setForeground(new java.awt.Color(153, 255, 153));
        finishedLbl.setText("Finished Tasks:");

        errorMsg.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        errorMsg.setForeground(new java.awt.Color(255, 0, 51));
        errorMsg.setText("jLabel2");

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameLbl))
                        .addGap(40, 40, 40)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idDisplay)
                            .addComponent(nameDisplay))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE)
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addComponent(doneBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(logoutBtn))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE)
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addComponent(taskLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1))
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(errorMsg)
                                    .addComponent(finishedLbl))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(42, 42, 42))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idDisplay))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameDisplay))
                .addGap(18, 18, 18)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(taskLbl)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(finishedLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorMsg)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(doneBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logoutBtn))
                .addGap(41, 41, 41))
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

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            connection.close();
            System.out.println("System Shut Down");
        } catch (SQLException ex) {
            System.out.println("FUUUCKKKK NOOOO");
        }
    }//GEN-LAST:event_formWindowClosing

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        // TODO add your handling code here:
        Login log = new Login(role, connection);
        log.setVisible(true);
        log.pack();
        log.setLocationRelativeTo(null);
        log.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_logoutBtnActionPerformed

    private void doneBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doneBtnActionPerformed
        // TODO add your handling code here:
        errorMsg.setVisible(false);
        if (role.equals("administrator")) {
            AddNewTask newTask = new AddNewTask(connection, name, id);
            newTask.setVisible(true);
            newTask.pack();
            newTask.setLocationRelativeTo(null);
            newTask.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.dispose();
        }
        if (role.equals("inspector")) {
            int row = taskTable.getSelectedRow();
            if (row == -1) {
                errorMsg.setVisible(true);
                errorMsg.setText("You have to select a row before clicking Report Results");
            }
            else {
                String taskID = taskTable.getModel().getValueAt(row, 0).toString();
                String taskName = taskTable.getModel().getValueAt(row, 1).toString();
                ReportTask report = new ReportTask(id, name, taskID, taskName, connection);
                report.setVisible(true);
                report.pack();
                report.setLocationRelativeTo(null);
                report.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                this.dispose();
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
            java.util.logging.Logger.getLogger(TaskPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TaskPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TaskPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TaskPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TaskPage("role", "id", "name", null).setVisible(true);
            }
        });
    }

    private String role;
    private String id;
    private String name;
    private Connection connection;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JButton doneBtn;
    private javax.swing.JLabel errorMsg;
    private javax.swing.JLabel finishedLbl;
    private javax.swing.JTable finishedTable;
    private javax.swing.JLabel idDisplay;
    private javax.swing.JLabel idLbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JLabel nameDisplay;
    private javax.swing.JLabel nameLbl;
    private javax.swing.JLabel taskLbl;
    private javax.swing.JTable taskTable;
    // End of variables declaration//GEN-END:variables
}
