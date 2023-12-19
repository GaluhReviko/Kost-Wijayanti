/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;
    import com.mysql.jdbc.Connection;
    import com.mysql.jdbc.Statement;
import java.awt.HeadlessException;
    import java.sql.DriverManager;
    import java.sql.ResultSet;
    import javax.swing.JOptionPane;
    import java.sql.PreparedStatement;
import java.sql.SQLException;
    import javax.swing.table.DefaultTableModel;
import static project.Data_Pemesanan.con;



/**
 *
 * @author ACER
 */
public class Penyewa extends javax.swing.JFrame {
    public static Connection con;
    public static Statement stm;
    public static ResultSet rs;
    public static PreparedStatement psht;   

    /**
     * Creates new form penyewa
     */
    public Penyewa() {
        initComponents();
        koneksimysql();
        tampiltable();
        combokamar();
        id_auto();
        cari();
    }
    
    public void id_auto(){
        try {
            koneksimysql();
            String sql = "select max(ID_Penyewa) as no from penyewa";
            rs = stm.executeQuery(sql);
            while (rs.next()){
                if(rs.first() == false){
                    txtnopenyewa.setText("1");
                }else{
                    rs.last();
                    int set_id = rs.getInt(1) + 1;
                    String no = String.valueOf(set_id);
                    int id_next = no.length();
                    for (int a = 0; a<1-id_next;a++){
                        no=no;
                    }
                    txtnopenyewa.setText(no);
                }
            }
        } catch (SQLException e) {
        }
    }
    
    public void combokamar(){
        koneksimysql();
        try {
                String sql = "select * from kamar";
                rs = stm.executeQuery(sql);
                while(rs.next()){
                    ComboNoKamarPenyewa.addItem(rs.getString("Nomor_Kamar"));
                }
                rs.last();
                int jumlahdata = rs.getRow();
                rs.first();
        } catch (Exception e) {
        }
    }
    
    public void koneksimysql(){
        try{
        String url="jdbc:mysql://localhost/koswijayanti";
        String user="root";
        String pass="";
        Class.forName("com.mysql.jdbc.Driver");
        con = (Connection) DriverManager.getConnection(url, user, pass);
        stm = (Statement) con.createStatement();
        }catch (Exception e){
        System.err.println("koneksi Gagal"+e.getMessage());
        }
    }
    public void hapus(){
        txtAsal.setText("");
        txnama.setText("");
        txtnik.setText("");
        txttelpPenyewa.setText("");
        txtNoOrtu.setText("");
        txtAsal.setText("");
        txtuniv.setText("");
        ComboNoKamarPenyewa.setSelectedIndex(0);
        
    }
    
    public void cari(){
        koneksimysql();
        DefaultTableModel tb = new DefaultTableModel();
        tb.addColumn("No Kamar");
        tb.addColumn("No Penyewa");
        tb.addColumn("NIK");
        tb.addColumn("Nama Penyewa");
        tb.addColumn("No Telf Penyewa");
        tb.addColumn("No Telf Ortu Penyewa");
        tb.addColumn("Asal Penyewa");
        tb.addColumn("Nama Kampus");
        
        tblpenyewa.setModel(tb);
        try {
             String sql = "SELECT * FROM penyewa WHERE ID_Penyewa like '%" +txtcari.getText() + "%' ORDER BY ID_Penyewa ASC";
            rs = stm.executeQuery(sql);
            while(rs.next()){
                tb.addRow(new Object[]{
                rs.getString("Nomor_Kamar"),
                rs.getString("ID_Penyewa"),
                rs.getString("NIK"),
                rs.getString("Nama_Penyewa"),
                rs.getString("NoTelp_Penyewa"),
                rs.getString("NoTelp_Ortu_Penyewa"),
                rs.getString("Asal_Penyewa"),
                rs.getString("Universitas_Penyewa")

            }
        );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void tampiltable(){
        koneksimysql();
        DefaultTableModel tb = new DefaultTableModel();
        tb.addColumn("No Kamar");
        tb.addColumn("No Penyewa");
        tb.addColumn("NIK");
        tb.addColumn("Nama Penyewa");
        tb.addColumn("No Telf Penyewa");
        tb.addColumn("No Telf Ortu Penyewa");
        tb.addColumn("Asal Penyewa");
        tb.addColumn("Nama Kampus");
        tblpenyewa.setModel(tb);
        try {
            rs = stm.executeQuery("SELECT * FROM penyewa");
            while(rs.next()){
                tb.addRow(new Object[]{
                rs.getString("Nomor_Kamar"),
                rs.getString("ID_Penyewa"),
                rs.getString("NIK"),
                rs.getString("Nama_Penyewa"),
                rs.getString("NoTelp_Penyewa"),
                rs.getString("NoTelp_Ortu_Penyewa"),
                rs.getString("Asal_Penyewa"),
                rs.getString("Universitas_Penyewa")

            }
        );
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

        jLabel3 = new javax.swing.JLabel();
        txtuniv = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txnama = new javax.swing.JTextField();
        txttelpPenyewa = new javax.swing.JTextField();
        txtNoOrtu = new javax.swing.JTextField();
        txtAsal = new javax.swing.JTextField();
        jbtnTambah = new javax.swing.JButton();
        jbtnEdit = new javax.swing.JButton();
        jbtnHapus = new javax.swing.JButton();
        jbtnKosongkan = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblpenyewa = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtnik = new javax.swing.JTextField();
        ComboNoKamarPenyewa = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtnopenyewa = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtcari = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 40)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 51, 0));
        jLabel3.setText("DATA PENYEWA");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 100, -1, -1));

        txtuniv.setText(" ");
        txtuniv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtunivActionPerformed(evt);
            }
        });
        txtuniv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtunivKeyReleased(evt);
            }
        });
        getContentPane().add(txtuniv, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 290, 360, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 51, 0));
        jLabel5.setText("Nama Penyewa");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 51, 0));
        jLabel6.setText("No Telf  Penyewa");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 170, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 51, 0));
        jLabel7.setText("No Telf Ortu Penyewa");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 210, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 51, 0));
        jLabel8.setText("Asal Penyewa");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 250, -1, -1));

        txnama.setText(" ");
        txnama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txnamaActionPerformed(evt);
            }
        });
        getContentPane().add(txnama, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 290, 360, 30));

        txttelpPenyewa.setText(" ");
        getContentPane().add(txttelpPenyewa, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 170, 360, 30));

        txtNoOrtu.setText(" ");
        txtNoOrtu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNoOrtuActionPerformed(evt);
            }
        });
        getContentPane().add(txtNoOrtu, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 210, 360, 30));

        txtAsal.setText(" ");
        getContentPane().add(txtAsal, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 250, 360, 30));

        jbtnTambah.setBackground(new java.awt.Color(153, 51, 0));
        jbtnTambah.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtnTambah.setForeground(new java.awt.Color(255, 255, 255));
        jbtnTambah.setText("Tambah");
        jbtnTambah.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jbtnTambahComponentShown(evt);
            }
        });
        jbtnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnTambahActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnTambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 360, 100, 30));

        jbtnEdit.setBackground(new java.awt.Color(153, 51, 0));
        jbtnEdit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtnEdit.setForeground(new java.awt.Color(255, 255, 255));
        jbtnEdit.setText("Update");
        jbtnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnEditActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 360, 100, 30));

        jbtnHapus.setBackground(new java.awt.Color(153, 51, 0));
        jbtnHapus.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtnHapus.setForeground(new java.awt.Color(255, 255, 255));
        jbtnHapus.setText("Hapus");
        jbtnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnHapusActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 360, 100, 30));

        jbtnKosongkan.setBackground(new java.awt.Color(153, 51, 0));
        jbtnKosongkan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtnKosongkan.setForeground(new java.awt.Color(255, 255, 255));
        jbtnKosongkan.setText("Clear");
        jbtnKosongkan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnKosongkanActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnKosongkan, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 360, 100, 30));

        tblpenyewa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "No Kamar", "No Penyewa", "NIK", "Nama Penyewa", "No Telf", "No Telf Ortu", "Asal "
            }
        ));
        tblpenyewa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblpenyewaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblpenyewa);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, 1260, 340));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/zzzz.png"))); // NOI18N
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, -60, 300, 210));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/ooo.png"))); // NOI18N
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Penyewa");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Kamar");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 20, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Transaksi");
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 20, -1, 40));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/yyy.png"))); // NOI18N
        jLabel14.setText("Login");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 0, -1, 80));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 51, 0));
        jLabel15.setText("NIK");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 51, 0));
        jLabel4.setText("No Kamar");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, -1, -1));

        txtnik.setText(" ");
        txtnik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnikActionPerformed(evt);
            }
        });
        getContentPane().add(txtnik, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 250, 360, 30));

        ComboNoKamarPenyewa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "== PILIH KAMAR ==" }));
        ComboNoKamarPenyewa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboNoKamarPenyewaActionPerformed(evt);
            }
        });
        getContentPane().add(ComboNoKamarPenyewa, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, 360, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 51, 0));
        jLabel2.setText("No Penyewa");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));

        txtnopenyewa.setEditable(false);
        getContentPane().add(txtnopenyewa, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 170, 360, 30));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(102, 51, 0));
        jLabel16.setText("Nama Kampus");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 290, -1, -1));

        txtcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcariActionPerformed(evt);
            }
        });
        txtcari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcariKeyReleased(evt);
            }
        });
        getContentPane().add(txtcari, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 360, 260, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Template 2 (fix).png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -2, -1, 780));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtunivActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtunivActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtunivActionPerformed

    private void txtNoOrtuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNoOrtuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNoOrtuActionPerformed

    private void txnamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txnamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txnamaActionPerformed

    private void jbtnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnTambahActionPerformed
     koneksimysql();
        try {
            String sql = "insert into penyewa values ('"+txtnopenyewa.getText()+"',"
                    + "'"+ComboNoKamarPenyewa.getSelectedItem()+"',"
                    + "'"+txtnik.getText()+"',"
                    + "'"+txnama.getText()+"',"
                    + "'"+txttelpPenyewa.getText()+"',"
                    + "'"+txtNoOrtu.getText()+"',"
                    + "'"+txtAsal.getText()+"',"
                    + "'"+txtuniv.getText()+"')";
            psht = con.prepareStatement(sql);
            psht.executeUpdate();
            JOptionPane.showMessageDialog(null, "data berhasil disimpan");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Data Gagal Disimpan");
        }
        tampiltable();
        
    }//GEN-LAST:event_jbtnTambahActionPerformed

    private void jbtnTambahComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jbtnTambahComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnTambahComponentShown

    private void jbtnKosongkanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnKosongkanActionPerformed
        // TODO add your handling code here:
        id_auto();
        hapus();
    }//GEN-LAST:event_jbtnKosongkanActionPerformed

    private void txtnikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnikActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnikActionPerformed

    private void jbtnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnEditActionPerformed
       koneksimysql();


try {
    String sql = "UPDATE penyewa SET ID_Penyewa = ?, Nomor_Kamar = ?, NIK = ?, Nama_Penyewa = ?, NoTelp_Penyewa = ?, NoTelp_Ortu_Penyewa = ?, Asal_Penyewa = ?, Universitas_Penyewa = ? WHERE ID_Penyewa = ?";
    PreparedStatement psht = con.prepareStatement(sql);
             
    psht.setString(1, txtnopenyewa.getText());
    psht.setString(2, (String) ComboNoKamarPenyewa.getSelectedItem());
    psht.setString(3, txtnik.getText());
    psht.setString(4, txnama.getText());
    psht.setString(5, txttelpPenyewa.getText());
    psht.setString(6, txtNoOrtu.getText());
    psht.setString(7, txtAsal.getText());
    psht.setString(8, txtuniv.getText());
    psht.setString(9, txtnopenyewa.getText());
             
    psht.executeUpdate();
    JOptionPane.showMessageDialog(null, "Data berhasil diupdate");
} catch (Exception e) {
   JOptionPane.showMessageDialog(null, "Data gagal diupdate");
}

    tampiltable();
    id_auto();   

    }//GEN-LAST:event_jbtnEditActionPerformed

    private void txtunivKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtunivKeyReleased
        // TODO add your handling code here
    }//GEN-LAST:event_txtunivKeyReleased

    private void ComboNoKamarPenyewaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboNoKamarPenyewaActionPerformed
 {
        }        // TODO add your handling code here:
    }//GEN-LAST:event_ComboNoKamarPenyewaActionPerformed

    private void txtcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcariActionPerformed
        cari();
    }//GEN-LAST:event_txtcariActionPerformed

    private void jbtnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnHapusActionPerformed
        // TODO add your handling code here:
        try {
            String sql = "DELETE FROM penyewa WHERE ID_Penyewa='"+txtnopenyewa.getText()+"'";
            PreparedStatement psht = con.prepareStatement(sql);
            
            int jawab = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin menghapus?", "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    
    if (jawab == JOptionPane.YES_OPTION) {
        JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
        psht.execute();
        tampiltable();
    }
        } catch (HeadlessException | SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_jbtnHapusActionPerformed

    private void tblpenyewaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblpenyewaMouseClicked
        // TODO add your handling code here:
        int baris =  tblpenyewa.getSelectedRow();
       String kamar = tblpenyewa.getValueAt(baris, 0).toString();
    for (int i = 0; i < ComboNoKamarPenyewa.getItemCount(); i++) {
    if (ComboNoKamarPenyewa.getItemAt(i).toString().equalsIgnoreCase(kamar)) {
        ComboNoKamarPenyewa.setSelectedIndex(i + 0);
        break;  // Optional: Jika ada lebih dari satu item yang sama, berhenti setelah item pertama ditemukan.
    }
}

        
        String no_penyewa = tblpenyewa.getValueAt(baris, 1).toString();
        txtnopenyewa.setText(no_penyewa);
        String nik = tblpenyewa.getValueAt(baris, 2).toString();
        txtnik.setText(nik);
        String nama_penyewa = tblpenyewa.getValueAt(baris, 3).toString();
        txnama.setText(nama_penyewa);
        String telp_penyewa = tblpenyewa.getValueAt(baris, 4).toString();
        txttelpPenyewa.setText(telp_penyewa);
        String telp_ortu = tblpenyewa.getValueAt(baris, 5).toString();
        txtNoOrtu.setText(telp_ortu);
        String asal = tblpenyewa.getValueAt(baris, 6).toString();
        txtAsal.setText(asal);
        String kampus = tblpenyewa.getValueAt(baris, 7).toString();
        txtuniv.setText(kampus);
        
    }//GEN-LAST:event_tblpenyewaMouseClicked

    private void txtcariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcariKeyReleased
        cari();
    }//GEN-LAST:event_txtcariKeyReleased

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
       this.setVisible(false);
       new Berandaa().setVisible(true);
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
       this.setVisible(false);
       new Data_Transaksi().setVisible(true);
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
       this.setVisible(false);
       new DataKamar().setVisible(true);
    }//GEN-LAST:event_jLabel12MouseClicked

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
            java.util.logging.Logger.getLogger(Penyewa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Penyewa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Penyewa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Penyewa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Penyewa().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboNoKamarPenyewa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnEdit;
    private javax.swing.JButton jbtnHapus;
    private javax.swing.JButton jbtnKosongkan;
    private javax.swing.JButton jbtnTambah;
    private javax.swing.JTable tblpenyewa;
    private javax.swing.JTextField txnama;
    private javax.swing.JTextField txtAsal;
    private javax.swing.JTextField txtNoOrtu;
    private javax.swing.JTextField txtcari;
    private javax.swing.JTextField txtnik;
    private javax.swing.JTextField txtnopenyewa;
    private javax.swing.JTextField txttelpPenyewa;
    private javax.swing.JTextField txtuniv;
    // End of variables declaration//GEN-END:variables

}
