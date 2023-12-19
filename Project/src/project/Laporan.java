/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;
import com.toedter.calendar.JDateChooser;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ACER
 */
public class Laporan extends javax.swing.JFrame {
   Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    Statement st = null;

    /**
     * Creates new form Laporann
     */
    public Laporan() {
        initComponents();
        koneksimysql();
        selectlaporan();
        
    }
    private void koneksimysql(){
        try{
        String url="jdbc:mysql://localhost/koswijayanti";
        String user="root";
        String pass="";
        Class.forName("com.mysql.jdbc.Driver");
        conn = (com.mysql.jdbc.Connection) DriverManager.getConnection(url, user, pass);
        st = (com.mysql.jdbc.Statement) conn.createStatement();
      
    }catch (Exception e){
        System.err.println("koneksi Gagal"+e.getMessage());
    }
    }    
    
    private void selectlaporan () {
    koneksimysql();
    String filter = cbFilter.getSelectedItem().toString();
        if("Pemasukan".equals(filter)){
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("No");
            model.addColumn("Jumlah");
            model.addColumn("Tanggal");
            table.setModel(model);
            try{
                int no = 1;
                koneksimysql();
                String sql = "SELECT * FROM pemasukan";
                st = conn.createStatement();
                rs = st.executeQuery(sql);
                while(rs.next()){
                    model.addRow(new Object[]{
                        no++,
                        rs.getString("Total_Harga"),
                        rs.getString("Tanggal_Pembayaran")
                    });
                }
                table.setModel(model);
            } catch(Exception e){
                JOptionPane.showMessageDialog(this, e);
            }
            
            try{
                koneksimysql();
                String sql = "SELECT SUM(Total_Harga) AS total FROM pemasukan";
                st = conn.createStatement();
                rs = st.executeQuery(sql);
                while(rs.next()){
                    txtTotal.setText(rs.getString("total"));
                }
            } catch(Exception e){
                JOptionPane.showMessageDialog(this, e);
            }
        } else {
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("No");
            model.addColumn("Jumlah");
            model.addColumn("Tanggal");
            table.setModel(model);
            try{
                int no = 1;
                koneksimysql();
                String sql = "SELECT * FROM pengeluaran";
                st = conn.createStatement();
                rs = st.executeQuery(sql);
                while(rs.next()){
                    model.addRow(new Object[]{
                        no++,
                        rs.getString("Total"),
                        rs.getString("Tanggal_Pengeluaran")
                    });
                }
                table.setModel(model);
            } catch(Exception e){
                JOptionPane.showMessageDialog(this, e);
            }

            try{
                koneksimysql();
                String sql = "SELECT SUM(Total) AS total FROM pengeluaran";
                st = conn.createStatement();
                rs = st.executeQuery(sql);
                while(rs.next()){
                    txtTotal.setText(rs.getString("total"));
                }
            } catch(Exception e){
                JOptionPane.showMessageDialog(this, e);
            }
        }
    }
  public  void caripemasukan(){
       DefaultTableModel tb = new DefaultTableModel();
DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
String from = formatter.format(tanggalMulai.getDate());
String to = formatter.format(tanggalSelesai.getDate());

// Judul kolom
tb.addColumn("NO");
tb.addColumn("Jumlah");
tb.addColumn("Tanggal");
table.setModel(tb);

try {
    String sql = "SELECT * FROM pemasukan WHERE DATE_FORMAT(Tanggal_Pembayaran, '%Y-%m-%d') BETWEEN DATE_FORMAT('" + from + "', '%Y-%m-%d') AND DATE_FORMAT('" + to + "', '%Y-%m-%d')";
    rs = st.executeQuery(sql);
    while (rs.next()) {
        tb.addRow(new Object[]{
            rs.getString("ID_Transaksi"),
            rs.getString("Total_Harga"),
            rs.getString("Tanggal_Pembayaran")
        });
    }
    
    String totalSql = "SELECT SUM(Total_Harga) AS total FROM pemasukan WHERE DATE_FORMAT(Tanggal_Pembayaran, '%Y-%m-%d') BETWEEN DATE_FORMAT('" + from + "', '%Y-%m-%d') AND DATE_FORMAT('" + to + "', '%Y-%m-%d')";
    rs = st.executeQuery(totalSql);
    if (rs.next()) {
        txtTotal.setText(rs.getString("total"));
    }
} catch (Exception e) {
    e.printStackTrace();
}

        
    }
    
    public void caripengeluaran(){
       DefaultTableModel tb = new DefaultTableModel();
DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
String from = formatter.format(tanggalMulai.getDate());
String to = formatter.format(tanggalSelesai.getDate());

// Judul kolom
tb.addColumn("NO");
tb.addColumn("Jumlah");
tb.addColumn("Tanggal");
table.setModel(tb);

try {
    String sql = "SELECT * FROM pengeluaran WHERE DATE_FORMAT(Tanggal_Pengeluaran, '%Y-%m-%d') BETWEEN DATE_FORMAT('" + from + "', '%Y-%m-%d') AND DATE_FORMAT('" + to + "', '%Y-%m-%d')";
    rs = st.executeQuery(sql);
    while (rs.next()) {
        tb.addRow(new Object[]{
            rs.getString("ID_Pengeluaran"),
            rs.getString("Total"),
            rs.getString("Tanggal_Pengeluaran")
        });
    }
    
    String totalSql = "SELECT SUM(Total) AS total FROM pengeluaran WHERE DATE_FORMAT(Tanggal_Pengeluaran, '%Y-%m-%d') BETWEEN DATE_FORMAT('" + from + "', '%Y-%m-%d') AND DATE_FORMAT('" + to + "', '%Y-%m-%d')";
    rs = st.executeQuery(totalSql);
    if (rs.next()) {
        txtTotal.setText(rs.getString("total"));
    }
} catch (Exception e) {
    e.printStackTrace();
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

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jbtncari1 = new javax.swing.JButton();
        jbtncari = new javax.swing.JButton();
        txtTotal = new javax.swing.JTextField();
        tanggalMulai = new com.toedter.calendar.JDateChooser();
        tanggalSelesai = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cbFilter = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/zzzz.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, -100, -1, 300));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Penyewa");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Kamar");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 20, -1, 40));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/ooo.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Transaksi");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 20, -1, 40));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/yyy.png"))); // NOI18N
        jLabel7.setText("Admin");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1167, 10, 160, 60));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 51, 0));
        jLabel8.setText("DATA LAPORAN");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Filter : ");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 200, 60, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel10.setText("Total Rp.");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 659, -1, 50));

        jbtncari1.setBackground(new java.awt.Color(153, 51, 0));
        jbtncari1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jbtncari1.setForeground(new java.awt.Color(255, 255, 255));
        jbtncari1.setText("Cari pkn");
        jbtncari1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtncari1ActionPerformed(evt);
            }
        });
        getContentPane().add(jbtncari1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 190, 110, 40));

        jbtncari.setBackground(new java.awt.Color(153, 51, 0));
        jbtncari.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jbtncari.setForeground(new java.awt.Color(255, 255, 255));
        jbtncari.setText("Cari pln");
        jbtncari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtncariActionPerformed(evt);
            }
        });
        getContentPane().add(jbtncari, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 190, 110, 40));

        txtTotal.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        txtTotal.setText(" ");
        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });
        getContentPane().add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 660, 250, 60));
        getContentPane().add(tanggalMulai, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 220, 40));
        getContentPane().add(tanggalSelesai, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 190, 220, 40));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("Dari :");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, -1, 30));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Sampai :");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 190, -1, 30));

        cbFilter.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cbFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pemasukan", "Pengeluaran" }));
        getContentPane().add(cbFilter, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 190, 200, 50));

        jButton3.setBackground(new java.awt.Color(153, 51, 0));
        jButton3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Data Pemasukan");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 680, 170, 40));

        table.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(table);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 270, 1160, 360));

        jButton2.setBackground(new java.awt.Color(153, 51, 0));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Data Pengeluaran");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 680, 170, 40));

        jLabel1.setBackground(new java.awt.Color(153, 51, 0));
        jLabel1.setForeground(new java.awt.Color(153, 51, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Template 2 (fix).png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtncariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtncariActionPerformed

           caripengeluaran();
           
    }                                        
    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {                                   
        String filter = cbFilter.getSelectedItem().toString();
if ("Pemasukan".equals(filter)) {
    DateFormat formatter = new SimpleDateFormat("yyyy-MM");
    String from = formatter.format(tanggalMulai.getDate());
    String to = formatter.format(tanggalSelesai.getDate());

    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("No");
    model.addColumn("Jumlah");
    model.addColumn("Tanggal");
    table.setModel(model);
    try {
        int no = 1;
        koneksimysql();
        String in = "SELECT * FROM pemasukan WHERE DATE_FORMAT(Tanggal_Pembayaran, '%y-%m-%d') BETWEEN DATE_FORMAT('"+tanggalMulai.getDate()+"', '%y-%m-%d') AND DATE_FORMAT('"+tanggalSelesai.getDate()+"', '%y-%m-%d');";
        st = conn.createStatement();
        rs = st.executeQuery(in);
        while (rs.next()) {
            model.addRow(new Object[]{
                no++,
                rs.getString("Total_Harga"),
                rs.getString("Tanggal_Pembayaran")
            });
        }
        table.setModel(model);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, e);
        e.printStackTrace();
    }

    try {
        koneksimysql();
        String sql = "SELECT SUM(Total_Harga) AS total FROM pemasukan WHERE DATE_FORMAT(Tanggal_Pembayaran, '%Y-%m') BETWEEN '" + from + "' AND '" + to + "'";
        st = conn.createStatement();
        rs = st.executeQuery(sql);
        while (rs.next()) {
            txtTotal.setText(rs.getString("total"));
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, e);
    }
} else {
    DateFormat formatter = new SimpleDateFormat("yyyy-MM");
    String from = formatter.format(tanggalMulai.getDate());
    String to = formatter.format(tanggalSelesai.getDate());

    DefaultTableModel tb_model = new DefaultTableModel();
    tb_model.addColumn("No");
    tb_model.addColumn("Jumlah");
    tb_model.addColumn("Tanggal");
    table.setModel(tb_model);
    try {
        int num = 1;
        koneksimysql();
        String in = "SELECT * FROM pengeluaran WHERE DATE_FORMAT(Tanggal_pengeluaran, '%Y-%m') BETWEEN '" + from + "' AND '" + to + "'";
        st = conn.createStatement();
        rs = st.executeQuery(in);
        while (rs.next()) {
            tb_model.addRow(new Object[]{
                num++,
                rs.getString("Total"),
                rs.getString("Tanggal_Pengeluaran")
            });
        }
        table.setModel(tb_model);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, e);
    }

    try {
        koneksimysql();
        String sql = "SELECT SUM(Total) AS total FROM pengeluaran WHERE DATE_FORMAT(Tanggal_Pengeluaran, '%Y-%m') BETWEEN '" + from + "' AND '" + to + "'";
        st = conn.createStatement();
        rs = st.executeQuery(sql);
        while (rs.next()) {
            txtTotal.setText(rs.getString("total"));
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, e);
    }

}

    }//GEN-LAST:event_jbtncariActionPerformed

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
       this.setVisible(false);
       new Berandaa().setVisible(true);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
       this.setVisible(false);
       new Penyewa().setVisible(true);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
       this.setVisible(false);
       new DataKamar().setVisible(true);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
       this.setVisible(false);
       new Data_Transaksi().setVisible(true);
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
         this.setVisible(false);
       new DataPengeluaran().setVisible(true);
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       this.setVisible(false);
       new Data_Pemasukan().setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jbtncari1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtncari1ActionPerformed
      caripemasukan();  
    }//GEN-LAST:event_jbtncari1ActionPerformed

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
            java.util.logging.Logger.getLogger(Laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Laporan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbFilter;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtncari;
    private javax.swing.JButton jbtncari1;
    private javax.swing.JTable table;
    private com.toedter.calendar.JDateChooser tanggalMulai;
    private com.toedter.calendar.JDateChooser tanggalSelesai;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
