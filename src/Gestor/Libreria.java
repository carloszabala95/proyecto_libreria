
package Gestor;
import java.awt.Color;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



public class Libreria extends javax.swing.JFrame {

    public static final String url = "jdbc:mysql://localhost:3306/libreria";
    public static final String usuario = "root";
    public static final String pass = "1234";
    
    DefaultTableModel modelo;
    
    public Connection getConnection(){
        Connection conexion = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, usuario, pass);
            JOptionPane.showMessageDialog(null, "Conexion exitosa");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de Conexión"+e);
        }
        return conexion;
    }
    
    public Libreria() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        modelo = new DefaultTableModel();
        modelo.addColumn("id");
        modelo.addColumn("titulo");
        modelo.addColumn("autor");
        modelo.addColumn("genero");
        
        mostrarDatos();
    
    }

    public void mostrarDatos(){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        modelo.setRowCount(0); //reset de table
        
        try {
            con = DriverManager.getConnection(url, usuario, pass);
            String sql = "SELECT id, titulo, autor, genero FROM libro";
            
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt("id");
                String titulo = rs.getString("titulo");
                String autor = rs.getString("autor");
                String genero = rs.getString("genero");
                
                modelo.addRow(new Object[]{id, titulo, autor, genero });
                
            }
            jDatos2.setModel(modelo);
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        
        }
        
    
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Contenedor = new javax.swing.JPanel();
        vistaIngreso = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtGenero = new javax.swing.JTextField();
        jtId = new javax.swing.JTextField();
        jtAutor = new javax.swing.JTextField();
        jtTitulo = new javax.swing.JTextField();
        jEnviar = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();
        vistaDatos = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jDatos2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        Contenedor.setBackground(new java.awt.Color(255, 255, 255));

        vistaIngreso.setBackground(new java.awt.Color(255, 255, 255));
        vistaIngreso.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        titulo.setText("Librería - El Buen Lector");
        vistaIngreso.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, -1, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Id:");
        vistaIngreso.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 80, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Autor:");
        vistaIngreso.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 120, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Titulo:");
        vistaIngreso.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 80, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Genero:");
        vistaIngreso.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 120, -1, -1));

        jtGenero.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        vistaIngreso.add(jtGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(564, 120, 110, -1));

        jtId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtId.setEnabled(false);
        vistaIngreso.add(jtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, 100, -1));

        jtAutor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        vistaIngreso.add(jtAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 120, 100, -1));

        jtTitulo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        vistaIngreso.add(jtTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(564, 80, 110, -1));

        jEnviar.setBackground(new java.awt.Color(102, 102, 255));
        jEnviar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jEnviar.setForeground(new java.awt.Color(255, 255, 255));
        jEnviar.setText("Enviar");
        jEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEnviarActionPerformed(evt);
            }
        });
        vistaIngreso.add(jEnviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 160, 70, -1));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo.jpg"))); // NOI18N
        vistaIngreso.add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, 350, 270));

        vistaDatos.setBackground(new java.awt.Color(153, 153, 255));
        vistaDatos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Registro de Datos");
        vistaDatos.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, 26));

        jDatos2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Titulo", "Autor", "Genero"
            }
        ));
        jScrollPane3.setViewportView(jDatos2);

        vistaDatos.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 254, 309));

        javax.swing.GroupLayout ContenedorLayout = new javax.swing.GroupLayout(Contenedor);
        Contenedor.setLayout(ContenedorLayout);
        ContenedorLayout.setHorizontalGroup(
            ContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContenedorLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(vistaDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(vistaIngreso, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 707, Short.MAX_VALUE)
        );
        ContenedorLayout.setVerticalGroup(
            ContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContenedorLayout.createSequentialGroup()
                .addComponent(vistaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ContenedorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(vistaDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Contenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEnviarActionPerformed
        Connection con = getConnection();
        PreparedStatement ps = null;
        
        String sql ="insert into libro (titulo, autor, genero) value(?,?,?);";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, jtTitulo.getText());
            ps.setString(2, jtAutor.getText());
            ps.setString(3, jtGenero.getText());
            ps.executeUpdate();
            
            mostrarDatos();
            con.close();
            JOptionPane.showMessageDialog(null, "Libro guardado");
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jEnviarActionPerformed

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
            java.util.logging.Logger.getLogger(Libreria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Libreria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Libreria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Libreria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Libreria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Contenedor;
    private javax.swing.JLabel fondo;
    private javax.swing.JTable jDatos2;
    private javax.swing.JButton jEnviar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jtAutor;
    private javax.swing.JTextField jtGenero;
    private javax.swing.JTextField jtId;
    private javax.swing.JTextField jtTitulo;
    private javax.swing.JLabel titulo;
    private javax.swing.JPanel vistaDatos;
    private javax.swing.JPanel vistaIngreso;
    // End of variables declaration//GEN-END:variables
}
