package view;

import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Job;
import service.JobService;
import service.JobServiceImpl;

/**
 *
 * @author Admin
 */
public class view extends javax.swing.JFrame {

    List<Job> listJob = null;
    DefaultTableModel jobTable = null;
    public JobService jobservice;

    public view() {
        initComponents();
        setLocationRelativeTo(null);
        txt_id.setVisible(false);
        jobservice = new JobServiceImpl();
        jobTable = (DefaultTableModel) table.getModel();
        LoadDataToTable();

        btn_add.addActionListener((ActionEvent e) -> {
            Map<String, String> map = new HashMap<>();
            map.put("job_id", txt_job_id.getText());
            map.put("name", txt_name.getText());
            map.put("kind", txt_kind.getText());
            map.put("status", txt_status.getText());
            map.put("worker_id", txt_worker_id.getText());
            map.put("execution_time", txt_execution_time.getText());
            map.put("start_time", txt_start_time.getText());
            map.put("end_time", txt_end_time.getText());
            map.put("job_output", txt_job_output.getText());
            jobservice.add(map);
            LoadDataToTable();
//        	JOptionPane.showMessageDialog(null, "ADDED!");
        });

        btn_delete.addActionListener((ActionEvent e) -> {
            Integer selectedRow = table.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "PLEASE SELECT A RECORD TO DELETE!");
            } else {
                String job_id = (String) jobTable.getValueAt(selectedRow, 1);
                jobservice.delete(job_id);
                LoadDataToTable();
            }
        });
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                Job job = listJob.get(table.getSelectedRow());
                txt_id.setText(job.getId().toString());
                txt_job_id.setText(job.getJob_id());
                txt_kind.setText(job.getName());
                txt_name.setText(job.getKind());
                txt_status.setText(job.getStatus());
                txt_worker_id.setText(job.getWorker_id());
                txt_execution_time.setText(job.getExecution_time().toString());
                txt_start_time.setText(job.getStart_time());
                txt_end_time.setText(job.getEnd_time());
                txt_job_output.setText(job.getJob_output());
            }
        });

        btn_update.addActionListener((ActionEvent e) -> {
            if (table.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(null, "PLEASE SELECT A RECORD TO UPDATE!");
            } else {
                Map<String, String> map = new HashMap<>();
                map.put("id", txt_id.getText());
                map.put("job_id", txt_job_id.getText());
                map.put("name", txt_name.getText());
                map.put("kind", txt_kind.getText());
                map.put("status", txt_status.getText());
                map.put("worker_id", txt_worker_id.getText());
                map.put("execution_time", txt_execution_time.getText());
                map.put("start_time", txt_start_time.getText());
                map.put("end_time", txt_end_time.getText());
                map.put("job_output", txt_job_output.getText());
                jobservice.update(map);
                LoadDataToTable();
            }
        });

        btn_clear.addActionListener((ActionEvent e) -> {
            txt_search.setText("");
            txt_job_id.setText("");
            txt_kind.setText("");
            txt_name.setText("");
            txt_status.setText("");
            txt_worker_id.setText("");
            txt_execution_time.setText((""));
            txt_start_time.setText((""));
            txt_end_time.setText("");
            txt_job_output.setText("");
        });

        txt_search.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
//            	JOptionPane.showMessageDialog(null, txt_search.getText());
                    String value = txt_search.getText();
                    List<Job> list = jobservice.search(value);
                    if (!list.isEmpty()) {
                        jobTable.setRowCount(0);
                        for (Job job : list) {
                            jobTable.addRow(job.toObject());
                        }
                    } else {
                        jobTable.setRowCount(0);
                    }
                }
            }
        });

        btn_reload.addActionListener((ActionEvent e) -> {
            LoadDataToTable();
        });

        btn_add_worker_id.addActionListener((ActionEvent e) -> {
            if (txt_add_worker_id.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "PLEASE INSERT A WORKER ID TO ADD!");
            } else {
                String add_worker_id = txt_add_worker_id.getText();
                jobservice.add_worker_id(add_worker_id);
                LoadDataToTable();
            }
        });
    }

    public void LoadDataToTable() {
        listJob = jobservice.findAll();
        jobTable.setRowCount(0);
        for (Job j : listJob) {
            jobTable.addRow(j.toObject());
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        txt_job_id = new javax.swing.JTextField();
        btn_add = new javax.swing.JButton();
        txt_name = new javax.swing.JTextField();
        txt_kind = new javax.swing.JTextField();
        txt_worker_id = new javax.swing.JTextField();
        txt_execution_time = new javax.swing.JTextField();
        txt_status = new javax.swing.JTextField();
        txt_start_time = new javax.swing.JTextField();
        txt_end_time = new javax.swing.JTextField();
        txt_job_output = new javax.swing.JTextField();
        txt_id = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_search = new javax.swing.JTextField();
        btn_update = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_reload = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        btn_add_worker_id = new javax.swing.JButton();
        txt_add_worker_id = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "id", "job_id", "name", "kind", "status", "worker_id", "execution_time", "start_time", "end_time", "job_output"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, true, true, false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(4).setResizable(false);
        }

        txt_job_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_job_idActionPerformed(evt);
            }
        });

        btn_add.setText("ADD");

        txt_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nameActionPerformed(evt);
            }
        });

        txt_kind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_kindActionPerformed(evt);
            }
        });

        txt_worker_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_worker_idActionPerformed(evt);
            }
        });

        txt_execution_time.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_execution_timeActionPerformed(evt);
            }
        });

        txt_status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_statusActionPerformed(evt);
            }
        });

        txt_start_time.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_start_timeActionPerformed(evt);
            }
        });

        txt_end_time.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_end_timeActionPerformed(evt);
            }
        });

        txt_job_output.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_job_outputActionPerformed(evt);
            }
        });

        txt_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idActionPerformed(evt);
            }
        });

        jLabel1.setText("INSERT job_id");

        jLabel2.setText("INSERT name");

        jLabel3.setText("INSERT kind");

        jLabel4.setText("INSERT status");

        jLabel5.setText("INSERT worker_id");

        jLabel6.setText("INSERT execution_time");

        jLabel7.setText("INSERT start_time");

        jLabel8.setText("INSERT end_time");

        jLabel9.setText("INSERT job_output");

        jLabel10.setText("SEARCH as job_id");

        btn_update.setText("UPDATE");

        btn_delete.setText("DELETE");

        btn_reload.setText("RELOAD");

        btn_clear.setText("CLEAR");

        btn_add_worker_id.setText("ADD worker_id");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("JOB QUEUE MANEGEMENT");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(342, 342, 342)
                        .addComponent(btn_add)
                        .addGap(65, 65, 65)
                        .addComponent(btn_update)
                        .addGap(54, 54, 54)
                        .addComponent(btn_delete)
                        .addGap(57, 57, 57)
                        .addComponent(btn_reload)
                        .addGap(57, 57, 57)
                        .addComponent(btn_clear)
                        .addGap(77, 77, 77)
                        .addComponent(btn_add_worker_id)
                        .addGap(18, 18, 18)
                        .addComponent(txt_add_worker_id, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_id)
                                    .addComponent(txt_job_id)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_name)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_kind)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_status)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_worker_id)
                                    .addComponent(txt_execution_time)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_start_time)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_end_time)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_job_output)
                                    .addComponent(jLabel10)
                                    .addComponent(txt_search)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(32, 32, 32)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1225, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_add)
                    .addComponent(btn_update)
                    .addComponent(btn_delete)
                    .addComponent(btn_reload)
                    .addComponent(btn_clear)
                    .addComponent(btn_add_worker_id)
                    .addComponent(txt_add_worker_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_job_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_kind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_worker_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_execution_time, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_start_time, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_end_time, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_job_output, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(93, 93, 93)
                        .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_job_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_job_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_job_idActionPerformed

    private void txt_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nameActionPerformed

    private void txt_kindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_kindActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_kindActionPerformed

    private void txt_worker_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_worker_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_worker_idActionPerformed

    private void txt_execution_timeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_execution_timeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_execution_timeActionPerformed

    private void txt_statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_statusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_statusActionPerformed

    private void txt_start_timeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_start_timeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_start_timeActionPerformed

    private void txt_end_timeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_end_timeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_end_timeActionPerformed

    private void txt_job_outputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_job_outputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_job_outputActionPerformed

    private void txt_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idActionPerformed

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
            java.util.logging.Logger.getLogger(view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new view().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_add_worker_id;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_reload;
    private javax.swing.JButton btn_update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    private javax.swing.JTextField txt_add_worker_id;
    private javax.swing.JTextField txt_end_time;
    private javax.swing.JTextField txt_execution_time;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_job_id;
    private javax.swing.JTextField txt_job_output;
    private javax.swing.JTextField txt_kind;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_search;
    private javax.swing.JTextField txt_start_time;
    private javax.swing.JTextField txt_status;
    private javax.swing.JTextField txt_worker_id;
    // End of variables declaration//GEN-END:variables
}
