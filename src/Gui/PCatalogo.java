package Gui;

import conector.Conexion;
import entidades.Libros;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PCatalogo extends javax.swing.JPanel {

    /**
     * Creates new form pHome
     */
    public PCatalogo() {
        initComponents();
        
        try {
            //aviso que se va a cargar la base de datos
            JOptionPane aviso = new JOptionPane();
            aviso.showMessageDialog(null, "Espere unos segundos..cargando Base de datos");
            aviso.setVisible(true);
            
            //Llamo al metodo CargarTabla de la Clase Libros
            this.tablaCatalogo.setModel(Libros.CargarTabla());
            
            //Ajusto tamaño columnas. Se puede dejar tamaño automatico
            tablaCatalogo.getColumnModel().getColumn(0).setPreferredWidth(10);
            tablaCatalogo.getColumnModel().getColumn(1).setPreferredWidth(220);
            tablaCatalogo.getColumnModel().getColumn(2).setPreferredWidth(80);
            tablaCatalogo.getColumnModel().getColumn(3).setPreferredWidth(40);
            tablaCatalogo.getColumnModel().getColumn(4).setPreferredWidth(20);
            tablaCatalogo.getColumnModel().getColumn(5).setPreferredWidth(10);
            tablaCatalogo.getColumnModel().getColumn(6).setPreferredWidth(10);
            tablaCatalogo.getColumnModel().getColumn(7).setPreferredWidth(10);
            tablaCatalogo.getColumnModel().getColumn(8).setPreferredWidth(30);
            //Deshabilito la opcion de edicion de la tabla en tiempo de ejecucion.
            tablaCatalogo.setEnabled(false);
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PHome.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(PHome.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(PHome.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PHome.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
//        try
//        {
//            JOptionPane aviso = new JOptionPane();
//            aviso.showMessageDialog(null, "Espere unos segundos..cargando Base de datos");
//            aviso.setVisible(true);
//            
//            Connection unaConexion = Conexion.obtenerConexion();
//            
//            DefaultTableModel modelo = new DefaultTableModel();
//            //SE PUEDE alterar orden columnas sin importar orden Base de Datos, 
//            //respetando nombres de campos
//            String [] columnas = {"ID","Título","Autor","Género","Páginas","Edición","Stock","Precio"};
//            String [] registro = new String[8];
//            modelo = new DefaultTableModel(null,columnas);
//            
//            String sql = "SELECT libros_id, titulo, autor_id, genero_id, paginas, edicion_id, stock, precio FROM titulo";
//            
//            Statement unaSentencia = unaConexion.createStatement();
//            ResultSet unResultado = unaSentencia.executeQuery(sql);
//            
//            while (unResultado.next()) {
//                registro[0]=unResultado.getString("libros_id");
//                registro[1]=unResultado.getString("titulo");
//                registro[2]=unResultado.getString("autor_id");
//                registro[3]=unResultado.getString("genero_id");
//                registro[4]=unResultado.getString("paginas");
//                registro[5]=unResultado.getString("edicion_id");
//                registro[6]=unResultado.getString("stock");
//                registro[7]=unResultado.getString("precio");
//                
//                modelo.addRow(registro);
//            }
//            tablaCatalogo.setModel(modelo);//setPreferredWidth(10);
//            
//            tablaCatalogo.getColumnModel().getColumn(0).setPreferredWidth(5);
//            tablaCatalogo.getColumnModel().getColumn(1).setPreferredWidth(220);
//            tablaCatalogo.getColumnModel().getColumn(2).setPreferredWidth(20);
//            tablaCatalogo.getColumnModel().getColumn(3).setPreferredWidth(20);
//            tablaCatalogo.getColumnModel().getColumn(4).setPreferredWidth(10);
//            tablaCatalogo.getColumnModel().getColumn(5).setPreferredWidth(10);
//            tablaCatalogo.getColumnModel().getColumn(6).setPreferredWidth(10);
//            tablaCatalogo.getColumnModel().getColumn(7).setPreferredWidth(30);
//            
//            tablaCatalogo.setEnabled(false);
//            //cierro la sentencia y la conexion
////            unResultado.close();
////            unaSentencia.close();
////            unaConexion.close();
//            
//        } catch (ClassNotFoundException classNotFoundException) {
//            System.out.println("No encuentra la Clase");
//        } catch (InstantiationException instantiationException) {
//            System.out.println("error de instanciamiento");
//        } catch (IllegalAccessException illegalAccessException) {
//            System.out.println("acceso ilegal");
//        } catch (SQLException ex) {
//            Logger.getLogger(PHome.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        busqueda = new javax.swing.ButtonGroup();
        bg = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCatalogo = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnEditar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();

        setBackground(new java.awt.Color(220, 220, 220));

        bg.setBackground(new java.awt.Color(220, 220, 220));

        tablaCatalogo.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        tablaCatalogo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Título", "Autor", "Género", "Idioma", "Páginas", "Edición", "Stock", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaCatalogo.setSelectionBackground(new java.awt.Color(225, 225, 225));
        tablaCatalogo.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablaCatalogo);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setText("Catálogo");

        btnEditar.setBackground(new java.awt.Color(0, 102, 204));
        btnEditar.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setText("Editar");

        btnBorrar.setBackground(new java.awt.Color(204, 0, 0));
        btnBorrar.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        btnBorrar.setForeground(new java.awt.Color(255, 255, 255));
        btnBorrar.setText("Borrar");

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 858, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(628, 628, 628)
                        .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 840, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar)
                    .addComponent(btnBorrar))
                .addGap(51, 51, 51))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.ButtonGroup busqueda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaCatalogo;
    // End of variables declaration//GEN-END:variables
}
