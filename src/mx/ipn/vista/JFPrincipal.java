package mx.ipn.vista;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import mx.ipn.logica.ALexico.ALexer;
import mx.ipn.logica.ALexico.Token;

public class JFPrincipal extends javax.swing.JFrame {
 
    String code="";
    public JFPrincipal() {
        initComponents();
    }
     public void ProbarLexer(String pathFile) throws FileNotFoundException, IOException{
        String rutaLocal=System.getProperty("user.dir");
        File bis = new File(pathFile);
        //BufferedInputStream bis = new BufferedInputStream(new FileInputStream(pathFile));
        Scanner sc= new Scanner(bis);
         StringBuilder sb = new StringBuilder();
         while (sc.hasNext()) {             
                String a = sc.nextLine();
                code += a+"\r\n";
               // a=a.trim(); a=a.replace(" ","");
                sb.append(a.replace(" ","")+"\r\n");
                
         }
         this.txtCode.setText(code);
         BufferedWriter bw = new BufferedWriter(new FileWriter(new File(rutaLocal+"\\fichero.txt")));
         bw.write(sb.toString());
         bw.flush();
         bw.close();
    }
     public void GeneraTokens() throws FileNotFoundException, IOException{
         Reader read = new BufferedReader(new FileReader("fichero.txt"));
        ALexer lex = new ALexer(read);
        String res = "";
        while (true) {            
            Token token = lex.yylex();
            if (token==null) {
                res+="EOF";
                this.jTextArea1.setText(res);
                return;
            }
            else{
                switch(token){
                        case ERROR:
                          res+="Error símbolo "+ lex.lexeme +" no reconocido\n";
                        break;
                   
                        case ENT: case ID: case RISTRA: case GRAF: case NAT:
                            res+="TOKEN "+token+" "+lex.lexeme+"\n";    
                        break;
                        default:
                           res+=token+"\n";
                        break;

                }
                this.jTextArea1.setText(res);
            }
        }
     }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtCode = new javax.swing.JTextArea();
        btnAnalizar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        JMenuFile = new javax.swing.JMenu();

        jMenu1.setText("jMenu1");

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtCode.setColumns(20);
        txtCode.setRows(5);
        jScrollPane1.setViewportView(txtCode);

        btnAnalizar.setText("Analizar");
        btnAnalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizarActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel1.setText("Tokens");

        jMenuBar1.setFont(new java.awt.Font("Century Schoolbook", 1, 18)); // NOI18N
        jMenuBar1.add(jMenu2);

        JMenuFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mx/ipn/vista/imagenes/file.png"))); // NOI18N
        JMenuFile.setText("File");
        JMenuFile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JMenuFileMousePressed(evt);
            }
        });
        JMenuFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMenuFileActionPerformed(evt);
            }
        });
        JMenuFile.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JMenuFileKeyPressed(evt);
            }
        });
        jMenuBar1.add(JMenuFile);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAnalizar)
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnAnalizar)))
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAnalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizarActionPerformed
        try {
            this.GeneraTokens();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JFPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JFPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAnalizarActionPerformed

    private void JMenuFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMenuFileActionPerformed
       
    }//GEN-LAST:event_JMenuFileActionPerformed

    private void JMenuFileKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JMenuFileKeyPressed
  
    }//GEN-LAST:event_JMenuFileKeyPressed

    private void JMenuFileMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JMenuFileMousePressed
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
          File selectedFile = fileChooser.getSelectedFile();
          String pathFile = selectedFile.getAbsolutePath();
            try {
                this.ProbarLexer(pathFile);
            } catch (IOException ex) {
                Logger.getLogger(JFPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_JMenuFileMousePressed

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
            java.util.logging.Logger.getLogger(JFPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu JMenuFile;
    private javax.swing.JButton btnAnalizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea txtCode;
    // End of variables declaration//GEN-END:variables
}
