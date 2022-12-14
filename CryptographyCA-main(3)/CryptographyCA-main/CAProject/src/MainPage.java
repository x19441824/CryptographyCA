
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;    // Importing Java Packages to be used in The application
import javax.crypto.spec.SecretKeySpec;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author ztjam
 */
public class MainPage extends javax.swing.JFrame {

    
      byte[] input;
        byte[] keyBytes = "12345678".getBytes();
        byte[] ivBytes = "input123".getBytes();
        SecretKeySpec key = new SecretKeySpec(keyBytes, "DES");
        IvParameterSpec ivSpec = new IvParameterSpec (ivBytes);  // Declaring the variables of MainPage
        Cipher cipher;
        byte[] cipherText;
        int ctLength;
       
       
    /**
     * Creates new form MainPage
     * 
     * 
     * 
     */
    public MainPage() {
        initComponents();
        
         setResizable(false);
        
       Icon icon = new ImageIcon(getClass().getResource("lockie.png"));
     setIconImage(new ImageIcon(getClass().getResource("lockie.png")).getImage());  
     
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        TitleLBL = new javax.swing.JLabel();
        EncryptTF = new javax.swing.JTextField();
        ResultTF = new javax.swing.JTextField();
        DecryptTF = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        EncryptionLBL = new javax.swing.JLabel();
        ResultLBL = new javax.swing.JLabel();
        DecryptionLBL = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        InfoLBL = new javax.swing.JLabel();
        imgencrypt = new javax.swing.JTextField();
        ImgEncryptBTN = new javax.swing.JButton();
        ImgDecryptBTN = new javax.swing.JButton();
        stepsLBL1 = new javax.swing.JLabel();
        stepsLBL2 = new javax.swing.JLabel();
        stepsLBL3 = new javax.swing.JLabel();
        stepsLBL4 = new javax.swing.JLabel();
        stepsLBL5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TitleLBL.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        TitleLBL.setForeground(new java.awt.Color(255, 255, 255));
        TitleLBL.setText("Text Encryption");
        jPanel1.add(TitleLBL, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 33, -1, -1));

        EncryptTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EncryptTFActionPerformed(evt);
            }
        });
        jPanel1.add(EncryptTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 137, 190, 129));

        ResultTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResultTFActionPerformed(evt);
            }
        });
        jPanel1.add(ResultTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 137, 190, 129));
        jPanel1.add(DecryptTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(528, 137, 190, 129));
        DecryptTF.getAccessibleContext().setAccessibleName("");

        jButton1.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        jButton1.setText("Encrypt");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 302, -1, -1));

        jButton2.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        jButton2.setText("Decrypt");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(465, 302, -1, -1));

        EncryptionLBL.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        EncryptionLBL.setForeground(new java.awt.Color(255, 255, 255));
        EncryptionLBL.setText("Normal Text");
        jPanel1.add(EncryptionLBL, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 116, -1, -1));

        ResultLBL.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        ResultLBL.setForeground(new java.awt.Color(255, 255, 255));
        ResultLBL.setText("Encrypted");
        jPanel1.add(ResultLBL, new org.netbeans.lib.awtextra.AbsoluteConstraints(346, 116, -1, -1));

        DecryptionLBL.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        DecryptionLBL.setForeground(new java.awt.Color(255, 255, 255));
        DecryptionLBL.setText("Decrypted");
        jPanel1.add(DecryptionLBL, new org.netbeans.lib.awtextra.AbsoluteConstraints(593, 116, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 380));

        jTabbedPane1.addTab("Text Encryption", jPanel1);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        InfoLBL.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        InfoLBL.setForeground(new java.awt.Color(255, 255, 255));
        InfoLBL.setText("Enter digits to create a key to encrypt or decrypt the chosen image");
        jPanel2.add(InfoLBL, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 253, -1, -1));

        imgencrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imgencryptActionPerformed(evt);
            }
        });
        jPanel2.add(imgencrypt, new org.netbeans.lib.awtextra.AbsoluteConstraints(239, 292, 285, -1));

        ImgEncryptBTN.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        ImgEncryptBTN.setText("Encrypt Image");
        ImgEncryptBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImgEncryptBTNActionPerformed(evt);
            }
        });
        jPanel2.add(ImgEncryptBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(274, 320, -1, -1));

        ImgDecryptBTN.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        ImgDecryptBTN.setText("Decrypt Image");
        ImgDecryptBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImgDecryptBTNActionPerformed(evt);
            }
        });
        jPanel2.add(ImgDecryptBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(398, 320, -1, -1));

        stepsLBL1.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        stepsLBL1.setForeground(new java.awt.Color(255, 255, 255));
        stepsLBL1.setText("1. Move to and open chosen image in source folder");
        jPanel2.add(stepsLBL1, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 24, 370, -1));

        stepsLBL2.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        stepsLBL2.setForeground(new java.awt.Color(255, 255, 255));
        stepsLBL2.setText("2. Enter a key to encrypt the image");
        jPanel2.add(stepsLBL2, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 57, -1, -1));

        stepsLBL3.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        stepsLBL3.setForeground(new java.awt.Color(255, 255, 255));
        stepsLBL3.setText("3, Press Encrypt image and view chosen image again");
        jPanel2.add(stepsLBL3, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 90, -1, -1));

        stepsLBL4.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        stepsLBL4.setForeground(new java.awt.Color(255, 255, 255));
        stepsLBL4.setText("4. Close image and enter key to decrypt image");
        jPanel2.add(stepsLBL4, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 123, -1, -1));

        stepsLBL5.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        stepsLBL5.setForeground(new java.awt.Color(255, 255, 255));
        stepsLBL5.setText("5. Press Decrypt image and view chosen image again");
        jPanel2.add(stepsLBL5, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 156, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 380));

        jTabbedPane1.addTab("Image Encryption", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EncryptTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EncryptTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EncryptTFActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try{
        cipher.init(Cipher.DECRYPT_MODE,key,ivSpec); // Intitialising the Decrypt mode using the established secret key
        
        byte[] plainText = new byte [cipher.getOutputSize(ctLength)]; //  Creating new byte called Plain Text using the length variable
        
        int ptLength = cipher.update (cipherText, 0, ctLength, plainText, 0); // Updating the cipher
        
        ptLength += cipher.doFinal(plainText,ptLength);// 
        DecryptTF.setText(new String(plainText)); //   // Set the Decrypt text field to the plain text cipher text string
        
        } catch(Exception e){ // Catch any exceptions caused
            
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       try{
        input = EncryptTF.getText().getBytes();  // Get the text of the text field EncryptTF
           SecretKeySpec key = new SecretKeySpec(keyBytes, "DES");  // Creating a Key that will be used later in the cipher
           IvParameterSpec ivSpec = new IvParameterSpec(ivBytes);
           cipher = Cipher.getInstance("DES/CTR/NoPadding"); // Declaring what kind of cipher is to be used
           cipher.init(Cipher.ENCRYPT_MODE,key,ivSpec); // Intitialising the encrypt mode using the established secret key
           cipherText = new byte[cipher.getOutputSize(input.length)]; //Declaring the byte for cipher text with how long the input is
           ctLength = cipher.update(input, 0,input.length, cipherText, 0);  // Declaring the ct Lenght
           
           ctLength += cipher.doFinal(cipherText, ctLength); // Calling the cihpher to encrypt CipherText using ctLenth
           ResultTF.setText(new String(cipherText)); // Set the result text field to the encrypted cipher text string
        } catch(Exception e){ // Catch any exceptions caused
            
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void imgencryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imgencryptActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_imgencryptActionPerformed

    private void ImgEncryptBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImgEncryptBTNActionPerformed
       try {
            int key = Integer.parseInt(imgencrypt.getText());
            FileInputStream fis = new FileInputStream("pup.jpg");
            byte data[] = new byte[fis.available()]; //Converting the image into a byte array
            fis.read(data);
            int i = 0;
            for (byte b : data) {
                data[i] = (byte) (b ^ key); //XOR operation on each byte array to the value of the image
                i++;
            }
            FileOutputStream fos = new FileOutputStream("pup.jpg");
            fos.write(data); //New byte array to be encrypted
            fos.close();
            fis.close();
            JOptionPane.showMessageDialog(null, "Encryption Done...");
        } catch (Exception e) {
            e.printStackTrace();
        }                              
    }//GEN-LAST:event_ImgEncryptBTNActionPerformed

    private void ImgDecryptBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImgDecryptBTNActionPerformed
        try {

            int key = Integer.parseInt(imgencrypt.getText());
            FileInputStream fis = new FileInputStream("pup.jpg"); //This is choosing the puppy image to be decryped, free to use whatever image and rename it
            byte data[] = new byte[fis.available()]; //This is the image being converted into a byte array
            fis.read(data); //This is to read the array data
            int i = 0;
            for (byte b : data) {
                data[i] = (byte) (b ^ key); //This is a XOR operation so that each byte can be decrypted
                i++;
            }
            FileOutputStream fos = new FileOutputStream("pup.jpg");
            fos.write(data);        //This is writing to the decrypted image
            fos.close();
            fis.close();
            JOptionPane.showMessageDialog(null, "Decryption Done...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_ImgDecryptBTNActionPerformed

    private void ResultTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResultTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ResultTFActionPerformed

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
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainPage().setVisible(true); // seting the page to be visible if it was run seperatly
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField DecryptTF;
    private javax.swing.JLabel DecryptionLBL;
    private javax.swing.JTextField EncryptTF;
    private javax.swing.JLabel EncryptionLBL;
    private javax.swing.JButton ImgDecryptBTN;
    private javax.swing.JButton ImgEncryptBTN;
    private javax.swing.JLabel InfoLBL;
    private javax.swing.JLabel ResultLBL;
    private javax.swing.JTextField ResultTF;
    private javax.swing.JLabel TitleLBL;
    private javax.swing.JTextField imgencrypt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel stepsLBL1;
    private javax.swing.JLabel stepsLBL2;
    private javax.swing.JLabel stepsLBL3;
    private javax.swing.JLabel stepsLBL4;
    private javax.swing.JLabel stepsLBL5;
    // End of variables declaration//GEN-END:variables
}
