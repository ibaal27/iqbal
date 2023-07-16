
package databasecoffeshop;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;  
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
        
        
public class coffeshopdb extends javax.swing.JFrame {
    private static int nopesanan,MakananId, MinumanId, subtotal,fee,totalbelanja;
    
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/coffeshop";
    private static final String USER = "root";
    private static final String PASS = "";
    
    private static Connection cn;
    private static Statement st;
    private static ResultSet rs;
    private static PreparedStatement pst;
    
    public static void cn(){
        try {
            Class.forName(JDBC_DRIVER);
            DriverManager.registerDriver( new com.mysql.jdbc.Driver() );
            cn = DriverManager.getConnection(DB_URL, USER, PASS);
        }
        catch (Exception e){
           JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
            System.exit(0);
        }
    }
    
    public static boolean addUser (int nopesanan,int MakananId,int MinumanId,int subtotal,int fee,int totalbelanja) {
        cn();
        boolean user = false;
        
        try {
            st = cn.createStatement(); 
            
            String add = "INSERT INTO coffeshopdb VALUES ('" + nopesanan + "','" + MakananId + "','" + MinumanId + "','" + subtotal + "','"
                    + fee + "','" + totalbelanja + "')";
            
            user = st.execute(add);
            
            
            st.close();
            cn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
          }
        return user;
    }
    
    public static boolean updateUser(int nopesanan, int makananId, int minumanId, int subtotal, int fee, int total) {
    cn();
    boolean user = false;
    try {
        st = cn.createStatement();
        
        String update = "SELECT * FROM coffeshopdb WHERE nopesanan = " + nopesanan;
        rs = st.executeQuery(update);
        
        int subtotalx = 0;
        int makananIdX = 0;
        int minumanIdX = 0;
        int feex = 0;
        int totalx = 0;
        
        while (rs.next()) {
            makananIdX = rs.getInt("makanan_Id");
            minumanIdX = rs.getInt("minuman_Id");
            subtotalx = rs.getInt("subtotal");
            feex = rs.getInt("fee");
            totalx = rs.getInt("total");
        }
        
        if (makananId != 0) {
            makananIdX = makananId;
        }
        if (minumanId != 0) {
            minumanIdX = minumanId;
        }
        if (subtotal != 0) {
            subtotalx = subtotal;
        }
        if (fee != 0) {
            feex = fee;
        }
        if (total != 0) {
            totalx = total;
        }
        
        String queryUpdate = "UPDATE coffeshopdb SET makanan_Id = " + makananIdX + ", minuman_Id = " + minumanIdX + ", subtotal = " + subtotalx + ", fee = " + feex + ", total = " + totalx + " WHERE nopesanan = " + nopesanan;
        
        if (st.executeUpdate(queryUpdate) != 0) {
            user = true;
        }
        
        st.close();
        cn.close();
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
    }
    return user;
}
    
    
    
    public coffeshopdb() {
        initComponents();
        cn();
        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NoPesanan", "MakananId", "MinumanId", "Subtotal", "Fee", "Total"
            }
        ));
        tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel);
        tampilkan();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        BtnInsert = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        PemesananTxt = new javax.swing.JTextField();
        BelanjaTxt = new javax.swing.JTextField();
        FeeTxt = new javax.swing.JTextField();
        SubtotalTxt = new javax.swing.JTextField();
        txtMakananId = new javax.swing.JTextField();
        txtMinumanId = new javax.swing.JTextField();
        BtnUpdate = new javax.swing.JButton();
        BtnDelete = new javax.swing.JButton();
        BtnReset = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(615, 548));

        jPanel1.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        jPanel1.setMinimumSize(new java.awt.Dimension(615, 548));

        BtnInsert.setText("Insert");
        BtnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnInsertActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 20)); // NOI18N
        jLabel1.setText("Database Zicha Coffe Shop");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("No pesanan");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel8.setText("Subtotal");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel9.setText("Taxfee");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel10.setText("Total Belanja");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel11.setText("Makanan_Id");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel12.setText("Minuman_Id");

        FeeTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FeeTxtActionPerformed(evt);
            }
        });

        SubtotalTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubtotalTxtActionPerformed(evt);
            }
        });

        BtnUpdate.setText("Update");
        BtnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnUpdateActionPerformed(evt);
            }
        });

        BtnDelete.setText("Delete");
        BtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDeleteActionPerformed(evt);
            }
        });

        BtnReset.setText("Reset");
        BtnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnResetActionPerformed(evt);
            }
        });

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "nopesanan", "MakananId", "MinumanId", "subtotal", "fee", "total"
            }
        ));
        tabel.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        tabel.setMinimumSize(new java.awt.Dimension(615, 548));
        tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel8)
                                    .addComponent(BtnInsert))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(PemesananTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                                        .addComponent(jLabel11))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(BtnUpdate)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(FeeTxt, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(SubtotalTxt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                                .addComponent(BelanjaTxt, javax.swing.GroupLayout.Alignment.LEADING)))
                                        .addGap(39, 39, 39)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel12)
                                            .addComponent(BtnDelete))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtMakananId, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtMinumanId, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(BtnReset)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(jLabel1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel11)
                    .addComponent(PemesananTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMakananId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel12)
                    .addComponent(SubtotalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMinumanId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(FeeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(BelanjaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnReset)
                    .addComponent(BtnDelete)
                    .addComponent(BtnUpdate)
                    .addComponent(BtnInsert))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 513, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
        // TODO add your handling code here:
        tabel_click();
    }//GEN-LAST:event_tabelMouseClicked

    private void BtnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnInsertActionPerformed
        // TODO add your handling code here:
        nopesanan = Integer.parseInt(PemesananTxt.getText());
        MakananId= Integer.parseInt(txtMakananId.getText());
        MinumanId=Integer.parseInt(txtMinumanId.getText());
        subtotal = Integer.parseInt(SubtotalTxt.getText());
        fee = Integer.parseInt(FeeTxt.getText());
        totalbelanja=Integer.parseInt(BelanjaTxt.getText());
        addUser(nopesanan, MakananId, MinumanId, subtotal, fee, totalbelanja);
        tampilkan();
        reset();
        JOptionPane.showMessageDialog(null, "Data Berhasil Di Input!");
    }//GEN-LAST:event_BtnInsertActionPerformed

    private void tabel_click(){
        PemesananTxt.setText(tabel.getValueAt(tabel.getSelectedRow(), 0 ).toString());
        txtMakananId.setText(tabel.getValueAt(tabel.getSelectedRow(), 1).toString());
        txtMinumanId.setText(tabel.getValueAt(tabel.getSelectedRow(), 2).toString());
        SubtotalTxt.setText(tabel.getValueAt(tabel.getSelectedRow(), 3 ).toString());
        FeeTxt.setText(tabel.getValueAt(tabel.getSelectedRow(), 4).toString());
        BelanjaTxt.setText(tabel.getValueAt(tabel.getSelectedRow(), 5 ).toString());
    }
    
    private void BtnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnUpdateActionPerformed
        // TODO add your handling code here:
        nopesanan = Integer.parseInt(PemesananTxt.getText());
        MakananId = Integer.parseInt(txtMakananId.getText());
        MinumanId =Integer.parseInt(txtMinumanId.getText());
        subtotal = Integer.parseInt(SubtotalTxt.getText());
        fee = Integer.parseInt(FeeTxt.getText());
        totalbelanja=Integer.parseInt(BelanjaTxt.getText());
        updateUser(nopesanan, MakananId, MinumanId, subtotal, fee, totalbelanja);
        tampilkan();
        JOptionPane.showMessageDialog(null, "Data Berhasil Di Update!");
    }//GEN-LAST:event_BtnUpdateActionPerformed

    private void BtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDeleteActionPerformed
        // TODO add your handling code here:
        cn();
        if(PemesananTxt.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Pilih Data Yang Akan di DELETE");
        }else{
           int tanya = JOptionPane.showConfirmDialog(null, "Data Ini akan di DELETE?","Konfirmasi", JOptionPane.YES_NO_OPTION);
           if(tanya == 0){
               try {
                   st = cn.createStatement();
                   String sql = "DELETE FROM coffeshopdb WHERE nopesanan = '"+ PemesananTxt.getText() + "'";
                   st.executeUpdate(sql);
                   JOptionPane.showMessageDialog(null, "Data Berhasil di DELETE");
                   reset();
                   tampilkan();
               } catch (Exception e) {
                   JOptionPane.showMessageDialog(null, e);
               }
    }//GEN-LAST:event_BtnDeleteActionPerformed
}
}
    private void BtnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnResetActionPerformed
        // TODO add your handling code here:
       reset();
    }//GEN-LAST:event_BtnResetActionPerformed

    private void SubtotalTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubtotalTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SubtotalTxtActionPerformed

    private void FeeTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FeeTxtActionPerformed
        // TAXFEE
        int a = Integer.parseInt(SubtotalTxt.getText());
        int b = Integer.parseInt(FeeTxt.getText());
            int hsl = a+b;
            BelanjaTxt.setText(String.valueOf(hsl));
    }//GEN-LAST:event_FeeTxtActionPerformed

    private  void reset(){
        PemesananTxt.setText("");
        txtMakananId.setText("");
        txtMinumanId.setText("");
        SubtotalTxt.setText("");
        FeeTxt.setText("");
        BelanjaTxt.setText("");
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new coffeshopdb().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BelanjaTxt;
    private javax.swing.JButton BtnDelete;
    private javax.swing.JButton BtnInsert;
    private javax.swing.JButton BtnReset;
    private javax.swing.JButton BtnUpdate;
    private javax.swing.JTextField FeeTxt;
    private javax.swing.JTextField PemesananTxt;
    private javax.swing.JTextField SubtotalTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabel;
    private javax.swing.JTextField txtMakananId;
    private javax.swing.JTextField txtMinumanId;
    // End of variables declaration//GEN-END:variables

    private void tampilkan() {
        cn();
        
        DefaultTableModel tb_User = new DefaultTableModel();
        tb_User.addColumn("nopesanan");
        tb_User.addColumn("MakananId");
        tb_User.addColumn("MinumanId");
        tb_User.addColumn("subtotal");
        tb_User.addColumn("fee");
        tb_User.addColumn("total");
        
        try {
            st = cn.createStatement();
            rs = st.executeQuery("SELECT * FROM coffeshopdb");
            
            while (rs.next()) {
                tb_User.addRow(new Object[] {
                    rs.getInt("nopesanan"),
                    rs.getInt("makanan_id"),
                    rs.getInt("minuman_id"),
                    rs.getInt("subtotal"),
                    rs.getString("fee"),
                    rs.getString("total"),
                });
                tabel.setModel(tb_User);
              }
            st.close();
        } 
        catch (Exception e) {
            
        }
    }
}
