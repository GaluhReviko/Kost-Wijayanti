
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import com.barcodelib.barcode.Linear;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.awt.Image;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import static project.Data_Pemasukan.con;
import static project.Data_Pemasukan.rs;
import static project.Data_Pemasukan.stm;
import static project.Data_Transaksi.con;
import static project.Data_Transaksi.rs;
import static project.Data_Transaksi.stm;

/**
 *
 * @author ASUS
 */
public class Data_Pemesanan extends javax.swing.JFrame {
public static Connection con;
public static Statement stm;
public static ResultSet rs;
public static PreparedStatement psht;
    /**
     * Creates new form Data_Pemesanan
     */
    public Data_Pemesanan() {
        initComponents();
        koneksimysql();
        tampiltable();
        tampil_combobox();
        tampil_combobox1();
        cari();
    }
    
     public void tampil_combobox(){
         try {
                         String sql = "SELECT * FROM kamar";
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()){
                combokamar.addItem(rs.getString("Nomor_Kamar"));
            }
            rs.last();
            int jumlahdata = rs.getRow();
            rs.first();
         } catch (Exception e) {
         }
     }
     
     public void cari(){
      DefaultTableModel tb = new DefaultTableModel();
        tb.addColumn("Nomor Pesanan");
        tb.addColumn("Nama");
        tb.addColumn("Nomor Kamar");
        tb.addColumn("Jenis Kamar");
        tb.addColumn("Tanggal Masuk");
        tb.addColumn("Tanggal Keluar");
        tb.addColumn("Status");
        tb.addColumn("Tanggal Pembayaran");
        
        tblpemesanan.setModel(tb);
        try {
            String sql = "SELECT * FROM pemesanan WHERE ID_Transaksi like '%" +txtcari.getText() + "%' ORDER BY ID_Transaksi ASC";
            rs = stm.executeQuery(sql);
            while(rs.next()){
                tb.addRow(new Object[]{
                rs.getString("ID_Transaksi"),
                rs.getString("Nama_Penyewa"),
                rs.getString("Nomor_Kamar"),
                rs.getString("Jenis_Kamar"),
                rs.getString("Tanggal_Masuk"),
                rs.getString("Tanggal_Keluar"),
                rs.getString("Status"),
                rs.getString("Tanggal_Pembayaran")
            }
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }    
     }
     
     public void tampil_combobox1(){
         try {
                         String sql = "SELECT * FROM penyewa";
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()){
                combopenyewa.addItem(rs.getString("Nama_Penyewa"));
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
    
     public void tampiltable(){
        DefaultTableModel tb = new DefaultTableModel();
        tb.addColumn("Nomor Pesanan");
        tb.addColumn("Nama");
        tb.addColumn("Nomor Kamar");
        tb.addColumn("Jenis Kamar");
        tb.addColumn("Tanggal Masuk");
        tb.addColumn("Tanggal Keluar");
        tb.addColumn("Status");
        tb.addColumn("Tanggal Pembayaran");
        
        tblpemesanan.setModel(tb);
        try {
            rs = stm.executeQuery("SELECT * FROM pemesanan ORDER BY ID_Transaksi ASC");
            while(rs.next()){
                tb.addRow(new Object[]{
                rs.getString("ID_Transaksi"),
                rs.getString("Nama_Penyewa"),
                rs.getString("Nomor_Kamar"),
                rs.getString("Jenis_Kamar"),
                rs.getString("Tanggal_Masuk"),
                rs.getString("Tanggal_Keluar"),
                rs.getString("Status"),
                rs.getString("Tanggal_Pembayaran")

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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtcari = new javax.swing.JTextField();
        txtpemesanan = new javax.swing.JTextField();
        combokamar = new javax.swing.JComboBox<>();
        dtanggalpembayaran = new com.toedter.calendar.JDateChooser();
        dtanggalmasuk = new com.toedter.calendar.JDateChooser();
        dtanggalkeluar = new com.toedter.calendar.JDateChooser();
        combopenyewa = new javax.swing.JComboBox<>();
        chkterbayar = new javax.swing.JCheckBox();
        chkbelumterbayar = new javax.swing.JCheckBox();
        chkstandart = new javax.swing.JCheckBox();
        chkpaviliun = new javax.swing.JCheckBox();
        barcode = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnclear = new javax.swing.JButton();
        btnhapus = new javax.swing.JButton();
        btntransaksi = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        btntambah = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblpemesanan = new javax.swing.JTable();
        BG = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 51, 0));
        jLabel2.setText("No Pemesanan");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 130, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 51, 0));
        jLabel3.setText("Nama Penyewa");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 130, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 51, 0));
        jLabel1.setText("No Kamar");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 130, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 51, 0));
        jLabel4.setText("Jenis Kamar");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 130, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 51, 0));
        jLabel5.setText("Tanggal Masuk");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 170, 180, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 51, 0));
        jLabel6.setText("Tanggal Keluar");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 210, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 51, 0));
        jLabel7.setText("Status");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(439, 250, 180, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 51, 0));
        jLabel8.setText("Tanggal Pembayaran");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 290, -1, -1));

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
        getContentPane().add(txtcari, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 360, 350, 30));

        txtpemesanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpemesananActionPerformed(evt);
            }
        });
        getContentPane().add(txtpemesanan, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 270, 30));

        combokamar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PILIH NOMOR KAMAR" }));
        combokamar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combokamarActionPerformed(evt);
            }
        });
        getContentPane().add(combokamar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 270, 30));

        dtanggalpembayaran.setBackground(new java.awt.Color(254, 240, 235));
        dtanggalpembayaran.setDateFormatString("yyyy-MM-dd");
        getContentPane().add(dtanggalpembayaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 290, 270, 30));

        dtanggalmasuk.setBackground(new java.awt.Color(254, 240, 235));
        dtanggalmasuk.setDateFormatString("yyyy-MM-dd");
        getContentPane().add(dtanggalmasuk, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 170, 270, 30));

        dtanggalkeluar.setBackground(new java.awt.Color(254, 240, 235));
        dtanggalkeluar.setDateFormatString("yyyy-MM-dd");
        getContentPane().add(dtanggalkeluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 210, 270, 30));

        combopenyewa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PILIH NAMA PENYEWA" }));
        getContentPane().add(combopenyewa, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, 270, 30));

        buttonGroup1.add(chkterbayar);
        chkterbayar.setText("Terbayar");
        getContentPane().add(chkterbayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 250, 130, 30));

        buttonGroup1.add(chkbelumterbayar);
        chkbelumterbayar.setText("Belum Terbayar");
        getContentPane().add(chkbelumterbayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(753, 250, 140, 30));

        buttonGroup2.add(chkstandart);
        chkstandart.setText("Standart");
        getContentPane().add(chkstandart, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, 130, 30));

        buttonGroup2.add(chkpaviliun);
        chkpaviliun.setText("Paviliun");
        getContentPane().add(chkpaviliun, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 290, 130, 30));
        getContentPane().add(barcode, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 170, 370, 110));

        jLabel10.setText("Barcode");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 140, -1, -1));

        btnclear.setBackground(new java.awt.Color(153, 51, 0));
        btnclear.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnclear.setForeground(new java.awt.Color(255, 255, 255));
        btnclear.setText("Clear");
        btnclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclearActionPerformed(evt);
            }
        });
        getContentPane().add(btnclear, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 360, 80, 30));

        btnhapus.setBackground(new java.awt.Color(153, 51, 0));
        btnhapus.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnhapus.setForeground(new java.awt.Color(255, 255, 255));
        btnhapus.setText("Hapus");
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });
        getContentPane().add(btnhapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 360, 80, 30));

        btntransaksi.setBackground(new java.awt.Color(153, 51, 0));
        btntransaksi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btntransaksi.setForeground(new java.awt.Color(255, 255, 255));
        btntransaksi.setText("Transaksi");
        btntransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntransaksiActionPerformed(evt);
            }
        });
        getContentPane().add(btntransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, -1, 30));

        btnupdate.setBackground(new java.awt.Color(153, 51, 0));
        btnupdate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnupdate.setForeground(new java.awt.Color(255, 255, 255));
        btnupdate.setText("Update");
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 360, 80, 30));

        btntambah.setBackground(new java.awt.Color(153, 51, 0));
        btntambah.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btntambah.setForeground(new java.awt.Color(255, 255, 255));
        btntambah.setText("Tambah");
        btntambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntambahActionPerformed(evt);
            }
        });
        getContentPane().add(btntambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 360, -1, 30));

        tblpemesanan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblpemesanan.setSelectionBackground(new java.awt.Color(153, 51, 0));
        tblpemesanan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblpemesananMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblpemesanan);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 401, 1330, 350));

        BG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Template 2 (fix).png"))); // NOI18N
        getContentPane().add(BG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel1.setPreferredSize(new java.awt.Dimension(1366, 768));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1366, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 768, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtpemesananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpemesananActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpemesananActionPerformed

    private void txtcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcariActionPerformed
     cari();       
    }//GEN-LAST:event_txtcariActionPerformed

    private void btnclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearActionPerformed
        txtpemesanan.setText("");
        
        dtanggalpembayaran.setDate(null);
        dtanggalkeluar.setDate(null);
        dtanggalmasuk.setDate(null);
        buttonGroup1.clearSelection();
        chkterbayar.setSelected(false);
        chkbelumterbayar.setSelected(false);
        combokamar.setSelectedIndex(0);
        combopenyewa.setSelectedIndex(0);
        buttonGroup2.clearSelection();
        chkstandart.setSelected(false);
        chkpaviliun.setSelected(false);
        
    }//GEN-LAST:event_btnclearActionPerformed

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
        koneksimysql();
        String Tampilan = "yyyy-MM-dd";
        SimpleDateFormat dateFormat = new SimpleDateFormat(Tampilan);
        String tanggalmasuk = String.valueOf(dateFormat.format(dtanggalmasuk.getDate()));
        String tanggalkeluar = String.valueOf(dateFormat.format(dtanggalkeluar.getDate()));
        String tanggalpembayaran = String.valueOf(dateFormat.format(dtanggalpembayaran.getDate()));
        
        String jenisKamar = null;
        String status = null;
        
        if (chkstandart.isSelected()) {
            jenisKamar = "Standart";
        } else if(chkpaviliun.isSelected()) {
            jenisKamar = "Paviliun";
        }
        
         if (chkterbayar.isSelected()) {
            status = "Terbayar";
        } else if(chkbelumterbayar.isSelected()) {
            status = "Belum Terbayar";
        }
        try {
            String sql = "DELETE FROM transaksi WHERE ID_Transaksi = ?";
            PreparedStatement psht = con.prepareStatement(sql);

            psht.setString(1, txtpemesanan.getText());
            psht.executeUpdate();
       
         JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
        } catch (Exception e) {
          JOptionPane.showMessageDialog(null, "Data tidak berhasil dihapus");
        }
        tampiltable();
    }//GEN-LAST:event_btnhapusActionPerformed

    private void btntransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntransaksiActionPerformed

    this.setVisible(false);
    new Data_Transaksi().setVisible(true);        
    }//GEN-LAST:event_btntransaksiActionPerformed

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        koneksimysql();
        String Tampilan = "yyyy-MM-dd";
        SimpleDateFormat dateFormat = new SimpleDateFormat(Tampilan);
        String tanggalmasuk = String.valueOf(dateFormat.format(dtanggalmasuk.getDate()));
        String tanggalkeluar = String.valueOf(dateFormat.format(dtanggalkeluar.getDate()));
        String tanggalpembayaran = String.valueOf(dateFormat.format(dtanggalpembayaran.getDate()));
        
        String jenisKamar = null;
        String status = null;
        
        if (chkstandart.isSelected()) {
            jenisKamar = "Standart";
        } else if(chkpaviliun.isSelected()) {
            jenisKamar = "Paviliun";
        }
        
         if (chkterbayar.isSelected()) {
            status = "Terbayar";
        } else if(chkbelumterbayar.isSelected()) {
            status = "Belum Terbayar";
        }
        try {
        String sql = "UPDATE transaksi SET ID_Transaksi = ?, ID_Penyewa = ? , ID_Kamar = ?, Jenis_Kamar = ?, Tanggal_Masuk = ?, Tanggal_Keluar = ?, Status = ?, Tanggal_Pembayaran = ? where ID_Transaksi = ?" ;
        PreparedStatement psht = con.prepareStatement(sql);

        psht.setString(1, txtpemesanan.getText());
        psht.setInt(2, combokamar.getSelectedIndex());
        psht.setInt(3, combopenyewa.getSelectedIndex());
        psht.setString(4, jenisKamar);
        psht.setString(5, tanggalmasuk);
        psht.setString(6, tanggalkeluar);
        psht.setString(7, status);
        psht.setString(8, tanggalpembayaran);
        psht.setString(9, txtpemesanan.getText());
        
        psht.executeUpdate();
         JOptionPane.showMessageDialog(null, " Data berhasil update");
        } catch (Exception e) {
         JOptionPane.showMessageDialog(null, " Data tidak berhasil update");
        }
        tampiltable();
    }//GEN-LAST:event_btnupdateActionPerformed

    private void btntambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntambahActionPerformed
     koneksimysql();
        String Tampilan = "yyyy-MM-dd";
        SimpleDateFormat dateFormat = new SimpleDateFormat(Tampilan);
        String tanggalmasuk = String.valueOf(dateFormat.format(dtanggalmasuk.getDate()));
        String tanggalkeluar = String.valueOf(dateFormat.format(dtanggalkeluar.getDate()));
        String tanggalpembayaran = String.valueOf(dateFormat.format(dtanggalpembayaran.getDate()));
        
        String jenisKamar = null;
        String status = null;
        
        
        if (chkstandart.isSelected()) {
            jenisKamar = "Standart";
        } else if(chkpaviliun.isSelected()) {
            jenisKamar = "Paviliun";
        }
        
         if (chkterbayar.isSelected()) {
            status = "Terbayar";
        } else if(chkbelumterbayar.isSelected()) {
            status = "Belum Terbayar";
        }
        
        try {
            String sql = "insert into transaksi values("
                        + "'"+txtpemesanan.getText()+"',"
                        + "'"+combopenyewa.getSelectedIndex()+"',"
                        + "'"+combokamar.getSelectedIndex()+"',"
                        + "'"+jenisKamar+"',"
                        + "'"+tanggalmasuk+"',"
                        + "'"+tanggalkeluar+"',"
                        + "'"+status+"',"
                        + "'"+tanggalpembayaran+"')";
            
         psht = con.prepareStatement(sql);
         psht.executeUpdate();
         koneksimysql();
         
            Linear barcode = new Linear();
            barcode.setType(Linear.CODE128B);
            barcode.setData(txtpemesanan.getText());
            barcode.setI(11.0f);
            String pemesan = txtpemesanan.getText();
            barcode.renderBarcode("src/image/" + pemesan + ".png");
         
         JOptionPane.showMessageDialog(null, "Data Telah Tersimpan");
        } catch (Exception e) {
         JOptionPane.showMessageDialog(null, " Data tidak berhasil disimpan"); 
        }
         tampiltable();
    }//GEN-LAST:event_btntambahActionPerformed

    private void tblpemesananMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblpemesananMouseClicked
        int tabel = tblpemesanan.getSelectedRow();
        txtpemesanan.setText((String) tblpemesanan.getValueAt(tabel, 0));
        String penyewa = tblpemesanan.getValueAt(tabel, 1).toString();
        for (int i = 0; i<combopenyewa.getItemCount();i++) {
            if (combopenyewa.getItemAt(i).toString().equalsIgnoreCase(penyewa)) {
                combopenyewa.setSelectedIndex(i);
            }
        }
        String kamar = tblpemesanan.getValueAt(tabel, 2).toString();
        for (int i = 0; i<combokamar.getItemCount();i++) {
            if (combokamar.getItemAt(i).toString().equalsIgnoreCase(kamar)) {
                combokamar.setSelectedIndex(i);
            }
        }
        String Jenis = (String) tblpemesanan.getValueAt (tabel, 3);    
            if (Jenis.equals("Standart")) {
                chkstandart.setSelected(true);
        } else {
                chkpaviliun.setSelected(true);
        }    
        String tanggalMasuk = (String) tblpemesanan.getValueAt(tabel, 4);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date tanggal;
            try {
                tanggal = dateFormat.parse(tanggalMasuk);
                dtanggalmasuk.setDate(tanggal);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String tanggalKeluar = (String) tblpemesanan.getValueAt(tabel, 5);
            SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
            Date tanggal1;
            try {
                tanggal = dateFormat.parse(tanggalKeluar);
            
                dtanggalkeluar.setDate(tanggal);
        } catch (Exception e) {
            e.printStackTrace();
        }         
         String Status = (String) tblpemesanan.getValueAt (tabel, 6);    
            if (Status.equals("Terbayar")) {
                chkterbayar.setSelected(true);
        } else {
                chkbelumterbayar.setSelected(true);
        }    
        String tanggalPembayaran = (String) tblpemesanan.getValueAt(tabel, 7);
            SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
            Date tanggal2;
            try {
                tanggal = dateFormat.parse(tanggalPembayaran);
            
                dtanggalpembayaran.setDate(tanggal);        
        } catch (Exception e) {
            e.printStackTrace();
        }  
        try {
            ImageIcon imgThisImg = new ImageIcon("src/image/" +txtpemesanan.getText() + ".png");
        barcode.setIcon(imgThisImg);
        // Mengatur ukuran gambar barcode
        int width = 220;  // Ukuran lebar yang diinginkan
        int height = 100; // Ukuran tinggi yang diinginkan
        Image image = imgThisImg.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT);
        ImageIcon resizedImage = new ImageIcon(image);

        // Menetapkan gambar barcode yang diubah ukurannya ke komponen barcode
        barcode.setIcon(resizedImage);
        } catch (Exception e) {
        }
    
    }//GEN-LAST:event_tblpemesananMouseClicked

    private void combokamarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combokamarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combokamarActionPerformed

    private void txtcariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcariKeyReleased
     cari(); 
    }//GEN-LAST:event_txtcariKeyReleased

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
            java.util.logging.Logger.getLogger(Data_Pemesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Data_Pemesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Data_Pemesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Data_Pemesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Data_Pemesanan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BG;
    private javax.swing.JLabel barcode;
    private javax.swing.JButton btnclear;
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btntambah;
    private javax.swing.JButton btntransaksi;
    private javax.swing.JButton btnupdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JCheckBox chkbelumterbayar;
    private javax.swing.JCheckBox chkpaviliun;
    private javax.swing.JCheckBox chkstandart;
    private javax.swing.JCheckBox chkterbayar;
    private javax.swing.JComboBox<String> combokamar;
    private javax.swing.JComboBox<String> combopenyewa;
    private com.toedter.calendar.JDateChooser dtanggalkeluar;
    private com.toedter.calendar.JDateChooser dtanggalmasuk;
    private com.toedter.calendar.JDateChooser dtanggalpembayaran;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblpemesanan;
    private javax.swing.JTextField txtcari;
    private javax.swing.JTextField txtpemesanan;
    // End of variables declaration//GEN-END:variables
}
