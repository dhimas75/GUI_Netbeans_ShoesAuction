/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoesauction.Frame;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import shoesauction.Connection.DBConnection;
import shoesauction.Controller.MainController;
import shoesauction.Helper.Helper;
import shoesauction.Model.MainModel;
import shoesauction.Query.MainQuery;
/**
 *
 * @author Dhimas N A
 */
public class DashboardDeal extends javax.swing.JFrame {

    Connection con;
    Statement st;
    String sql;
    ResultSet rs;
    String name;
 
    
    MainModel model = new MainModel();
    MainController controller = new MainController();
    MainQuery query = new MainQuery();
    Helper helper = new Helper();
    
    /**
     * Creates new form DashboardDeal
     * @param id
     * 
     */
    public DashboardDeal(String id, String bid) {
        initComponents();
        
        DBConnection koneksi = new DBConnection();
        koneksi.open();
        con = koneksi.con;
        st = koneksi.stm;
        
        getAllData();
        clear();
        code();
        cb_product();
        
        tf_idbid.setEnabled(false);
        
        cb_idproduct.setSelectedItem(id);
        tf_startbid.setText(bid);
        tf_startbid.setEnabled(false);
        cb_idproduct.setEnabled(false);
    }

    private DashboardDeal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void code(){
       try {
            String sql = this.query.createIDbid;
            st = con.createStatement();
            rs = st.executeQuery(sql);
            if (rs.next()) {
                String id_bid = rs.getString("id_bid").substring(1);
                String kode = "" + (Integer.parseInt(id_bid) + 1);
                String nol = "";

                if(kode.length()==1)
                {nol = "000";}
                else if(kode.length()==2)
                {nol = "00";}
                else if(kode.length()==3)
                {nol = "0";}
                else if(kode.length()==4)
                {nol = "";}

               tf_idbid.setText("B" + nol + kode);
            } else {
               tf_idbid.setText("B0001");
            }

           }catch(Exception e){
           JOptionPane.showMessageDialog(null, e);
           }
     }
    
    public void cb_product(){
        try {
        
            sql = this.query.cb_product;
            st = con.createStatement();
            rs = st.executeQuery(sql);                                
        
            while(rs.next()){
            Object[] ob = new Object[3];
            ob[0] = rs.getString(1);
            
            cb_idproduct.addItem(ob[0]);        
        }
        rs.close(); st.close();
         
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    private void clear(){
        code();
        tf_idbid.setText("");
        tf_totalbid.setText("");
        cb_idproduct.setEnabled(true);
        cb_idproduct.setSelectedIndex(0);
        tf_username.setText("");
        
        btn_submit.setEnabled(true);
        
    }
    
    public void getAllData(){
        this.rs = controller.getBid();
        loadTable(this.rs);
    }
    
    public void loadTable(ResultSet rs){
        tb_bid.setModel(DbUtils.resultSetToTableModel(rs));
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tb_bid = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tf_idbid = new javax.swing.JTextField();
        cb_idproduct = new javax.swing.JComboBox();
        tf_totalbid = new javax.swing.JTextField();
        btn_submit = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        btn_back = new javax.swing.JButton();
        tf_startbid = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tf_username = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tb_bid.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tb_bid);

        jLabel1.setText("Top Deals");

        jLabel2.setText("Hello!");

        jLabel4.setText("It's your turn to bid");

        jLabel6.setText("ID Bid");

        jLabel7.setText("ID Product");

        jLabel8.setText("Your Bid");

        cb_idproduct.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-Choose-" }));
        cb_idproduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_idproductActionPerformed(evt);
            }
        });

        btn_submit.setText("Submit");
        btn_submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_submitActionPerformed(evt);
            }
        });

        jLabel9.setText("Username");

        btn_back.setText("Back");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });

        jLabel3.setText("Start Bid");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(btn_back)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(tf_totalbid)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(btn_submit)
                                                .addComponent(cb_idproduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(0, 47, Short.MAX_VALUE)))
                                    .addComponent(tf_idbid, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(tf_username, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tf_startbid, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(330, 330, 330))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel2)
                        .addGap(50, 50, 50))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(tf_idbid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(cb_idproduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(tf_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(tf_startbid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_totalbid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addComponent(btn_submit)
                        .addGap(27, 27, 27)
                        .addComponent(btn_back)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_submitActionPerformed
        // TODO add your handling code here:
        try {
            String id_bid = tf_idbid.getText();
            String id_product = cb_idproduct.getSelectedItem().toString();
            String total_bid = tf_totalbid.getText();
            String username = tf_username.getText();
            
            model.setId_bid(id_bid);
            model.setId_product(id_product);
            model.setTotal_bid(total_bid);
            model.setUsername(username);
            
            Boolean result = controller.createBid(model);
            if (result) {
                JOptionPane.showMessageDialog(null, "Berhasil Menambahkan Data");
            }
            else {
                JOptionPane.showMessageDialog(null, "Gagal menambahkan Data");
            }
            clear();
            getAllData();
            code();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_btn_submitActionPerformed

    private void cb_idproductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_idproductActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cb_idproductActionPerformed

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        // TODO add your handling code here:
        try{
            DashboardUser du = new DashboardUser(name);
            du.setVisible(true);
            this.setVisible(false);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btn_backActionPerformed

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
            java.util.logging.Logger.getLogger(DashboardDeal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DashboardDeal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DashboardDeal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashboardDeal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashboardDeal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_submit;
    private javax.swing.JComboBox cb_idproduct;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tb_bid;
    private javax.swing.JTextField tf_idbid;
    private javax.swing.JTextField tf_startbid;
    private javax.swing.JTextField tf_totalbid;
    private javax.swing.JTextField tf_username;
    // End of variables declaration//GEN-END:variables
}
