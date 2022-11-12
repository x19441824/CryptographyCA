
import java.awt.Color;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.swing.JOptionPane; // Importing Java Packages to be used in The application
import java.io.*;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.*;
import static javax.crypto.Cipher.DECRYPT_MODE;
import static javax.crypto.Cipher.ENCRYPT_MODE;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
 // References -----> https://www.youtube.com/watch?v=SRnPZz_vT74 , https://www.youtube.com/watch?v=SIS2EbkT9AM , https://www.youtube.com/watch?v=zn_kg55GRWo
/**
 *
 * @author ztjam
 */
public class LoginPageGUI extends javax.swing.JFrame {

    /**
     * Creates new form LoginPageGUI
     */
    public LoginPageGUI() {
        initComponents(); // Initiailising the components of LogingPageGUI
        
    }
    public static void encryptDecrypt(String key, int cipherMode, File in, File out) // Method we will call for encryption and decryption 
    throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, IOException   { // Declaring the different exceptions that are possible
       
        FileInputStream fis = new FileInputStream(in);
        FileOutputStream fos = new FileOutputStream(out); 
        
        DESKeySpec desKeySpec = new DESKeySpec(key.getBytes());
        
        SecretKeyFactory skf = SecretKeyFactory.getInstance("DES"); // Declaring Instance to be used
        SecretKey secretKey = skf.generateSecret(desKeySpec);  // Creating a Key that will be used later in the cipher
        
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");   // Declaring what kind of cipher is to be used
        
        if (cipherMode == Cipher.ENCRYPT_MODE){
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, SecureRandom.getInstance("SHA1PRNG"));// Intitialising the encrypt mode using the established secret key
            CipherInputStream cis = new CipherInputStream(fis, cipher); // creating Input stream
            write(cis,fos);  //If the Ciphermode is set to encrypt mode, it will use the generated secret key and a random value to encrypt the given data
        }
        else if(cipherMode == Cipher.DECRYPT_MODE  ){
        cipher.init(Cipher.DECRYPT_MODE, secretKey, SecureRandom.getInstance("SHA1PRNG")); // Intitialising the decrypt mode using the established secret key
        CipherOutputStream cos = new CipherOutputStream(fos, cipher); // creating output stream
        write(fis,cos); // If the ciphermode is in Decrypt mode, it will use the same key and value to decrypt the data
    }
        
        
    }
    
    
    private static void write(InputStream in , OutputStream out) throws IOException{
        byte[] buffer = new byte[64]; // Creating a new variable
        int numOfBytesRead;         // Declaring the number of bytes to be read so our cipher that uses padding doesnt encounter an error
        while((numOfBytesRead = in.read(buffer)) != -1 ){ // while there are Bytes in the input stream
            out.write(buffer, 0 , numOfBytesRead);  // writing the variable of bytes into the output stream
    }
        out.close(); // Closing the write method on the output Stream
        in.close();// closing the read method on the Input stream
    }
    
    
    

    private void LoginCheck(){
    
        boolean status = false;
        File myFile = new File("Login.txt");  // Open Login File instance
        try {
            
             
                    File plaintext = new File("Login.txt"); // open a new login file instance
                    File encrypted = new File("Nothing.txt");// open a new Nothing file instance
                    
                    
                    encryptDecrypt("12345678", DECRYPT_MODE , encrypted, plaintext ); // Calling the Decrypt method for the Nothing.txt file and putting that data into the Login.txt file
                    System.out.println("Decryption Complete");  // Informing the user in the command line that the Decryption was completed
                    
            
            Scanner data = new Scanner(myFile);
            while(data.hasNextLine()){  // While there are still lines in the file
                String UN = data.next(); // Set Username as the first word in the line
                String PW = data.next(); // Set Password as the second word in the line
                
                if (UN.equals(UsernameTF.getText()) && PW.equals(PasswordPF.getText())){ // Check to see if The text field inputs match the Username and password values from the file
                    status = true;  // Set status to true for later
                    PrintWriter writer = new PrintWriter("Login.txt");
                        writer.print(""); // Delete the Values from Login file to ensure the Username and Password stay encrypted
                        // other operations
                        writer.close();
                }
                
            }
            if(status) {
                ResultLBL.setText("Login Successful"); // Informs user that their login has been succesful
                ResultLBL.setForeground(Color.green); // sets text to green as a visual indicator drawing the eye
                 java.awt.EventQueue.invokeLater(new Runnable() {
                  public void run() {
                new MainPage().setVisible(true);  // Call the new Class and set it visible
                         }
                    });
                 this.dispose(); //Close the current Class
           
            } else{
                ResultLBL.setText("Login has Failed"); // Informs user that their login has failed
                ResultLBL.setForeground(Color.red); // sets text to red as a visual indicator drawing the eye
            }
        } catch (Exception ex) {
            Logger.getLogger(LoginPageGUI.class.getName()).log(Level.SEVERE, null, ex); // logging any exceptions that were caught
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

        LoginPageLBL = new javax.swing.JLabel();
        UsernameLBL = new javax.swing.JLabel();
        PasswordLBL = new javax.swing.JLabel();
        UsernameTF = new javax.swing.JTextField();
        PasswordPF = new javax.swing.JPasswordField();
        LoginBTN = new javax.swing.JButton();
        ClearBTN = new javax.swing.JButton();
        ResultLBL = new javax.swing.JLabel();
        NewUserBTN = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login Page");

        LoginPageLBL.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        LoginPageLBL.setForeground(new java.awt.Color(153, 0, 51));
        LoginPageLBL.setText("Login Page");

        UsernameLBL.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        UsernameLBL.setText("Username");

        PasswordLBL.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        PasswordLBL.setText("Password");

        LoginBTN.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LoginBTN.setText("Login");
        LoginBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginBTNActionPerformed(evt);
            }
        });

        ClearBTN.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ClearBTN.setText("Clear");
        ClearBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearBTNActionPerformed(evt);
            }
        });

        ResultLBL.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        NewUserBTN.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        NewUserBTN.setText("New User");
        NewUserBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewUserBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LoginPageLBL, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(191, 191, 191))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(UsernameLBL)
                    .addComponent(PasswordLBL))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(ResultLBL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap(336, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(UsernameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PasswordPF, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(LoginBTN)
                .addGap(34, 34, 34)
                .addComponent(ClearBTN)
                .addGap(32, 32, 32)
                .addComponent(NewUserBTN)
                .addContainerGap(95, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(LoginPageLBL)
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UsernameLBL)
                    .addComponent(UsernameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PasswordLBL)
                    .addComponent(PasswordPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LoginBTN)
                    .addComponent(ClearBTN)
                    .addComponent(NewUserBTN))
                .addGap(18, 18, 18)
                .addComponent(ResultLBL, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LoginBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginBTNActionPerformed
        
      LoginCheck(); // Calling login method 
        
        
        
    }//GEN-LAST:event_LoginBTNActionPerformed

    private void ClearBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearBTNActionPerformed
        
        UsernameTF.setText(""); // Set the field to have no text in it
        PasswordPF.setText("");// Set the field to have no text in it
        ResultLBL.setText("");// Set the field to have no text in it
    }//GEN-LAST:event_ClearBTNActionPerformed

    private void NewUserBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewUserBTNActionPerformed
      
      
        try{
          
           
                    FileWriter myWriter = new FileWriter("Login.txt", true); // makes new instance of Login file
                    myWriter.write("\n" + UsernameTF.getText() + " " + PasswordPF.getText());// Write the username and password in login file
                    myWriter.close();   //Closes writer method
                    
                    File plaintext = new File("Login.txt");// makes new instance of Login file
                    File encrypted = new File("Nothing.txt");// makes new instance of Nothing file
                    
                    
                    encryptDecrypt("12345678", ENCRYPT_MODE , plaintext, encrypted ); // calling the encryption method we declared earlier on the 2 files above
                    System.out.println("Login Encrypted"); // Prints in the console
                    
                        PrintWriter writer = new PrintWriter("Login.txt");
                        writer.print(""); // Delete the Values from Login file to ensure the Username and Password stay encrypted
                        // other operations
                        writer.close(); // Closes writer method
                    
                    
                     JOptionPane.showMessageDialog(null,"Successfully created new User"); // Informs user a new user has been created
               }    
               catch (Exception e) {
                        JOptionPane.showMessageDialog(null,"An error occurred."); // Informs user that an error Occured
                         e.printStackTrace();}
    }//GEN-LAST:event_NewUserBTNActionPerformed
   
    
    
    
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
            java.util.logging.Logger.getLogger(LoginPageGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginPageGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginPageGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginPageGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginPageGUI().setVisible(true); // Calling the GUI to be visible
            }
        });
            try {
      File myObj = new File("Login.txt"); // Creating Login File if it doesnt already exist
      if (myObj.createNewFile()) {
        System.out.println("File created: " + myObj.getName());
      } else {
        System.out.println("File already exists."); // Informing user that the file already exists in the Command line
      }
    } catch (IOException e) {
      System.out.println("An error occurred.");// Informing user of an error creating the file in the command line
      e.printStackTrace();
    }
                try {
      File myObj = new File("Nothing.txt");// Creating Nothing File if it doesnt already exist
      if (myObj.createNewFile()) {
        System.out.println("File created: " + myObj.getName());
      } else {
        System.out.println("File already exists."); // Informing user that the file already exists in the Command line
      }
    } catch (IOException e) {
      System.out.println("An error occurred."); // Informing user of an error creating the file in the command line
      e.printStackTrace();
    }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ClearBTN;
    private javax.swing.JButton LoginBTN;
    private javax.swing.JLabel LoginPageLBL;
    private javax.swing.JButton NewUserBTN;
    private javax.swing.JLabel PasswordLBL;
    private javax.swing.JPasswordField PasswordPF;
    private javax.swing.JLabel ResultLBL;
    private javax.swing.JLabel UsernameLBL;
    private javax.swing.JTextField UsernameTF;
    // End of variables declaration//GEN-END:variables
}
