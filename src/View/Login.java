
package View;

import java.awt.Color;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static javax.swing.JOptionPane.showMessageDialog;


public class Login extends javax.swing.JPanel {

    public Frame frame;
    int attempt = 0;
    
    public Login() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        usernameFld = new javax.swing.JTextField();
        passwordFld = new javax.swing.JPasswordField();
        registerBtn = new javax.swing.JButton();
        loginBtn = new javax.swing.JButton();
        passwordForgetBtn = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SECURITY Svcs");
        jLabel1.setToolTipText("");

        usernameFld.setBackground(new java.awt.Color(240, 240, 240));
        usernameFld.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        usernameFld.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        usernameFld.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "USERNAME", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        passwordFld.setBackground(new java.awt.Color(240, 240, 240));
        passwordFld.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        passwordFld.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        passwordFld.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "PASSWORD", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        passwordFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFldActionPerformed(evt);
            }
        });

        registerBtn.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        registerBtn.setText("REGISTER");
        registerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerBtnActionPerformed(evt);
            }
        });

        loginBtn.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        loginBtn.setText("LOGIN");
        loginBtn.setBackground(Color.decode("#90EE90"));
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });

        passwordForgetBtn.setText("Forgot Password?");
        passwordForgetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordForgetBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(200, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(usernameFld)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(passwordFld, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(registerBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(loginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(200, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(passwordForgetBtn)
                .addGap(230, 230, 230))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(88, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(usernameFld, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(passwordFld, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordForgetBtn)
                .addContainerGap(97, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed
        if(frame.main.sqlite.authenticateUser(usernameFld.getText().toLowerCase(),passwordFld.getText())&& attempt != 3) {
       
        usernameFld.setText("");
        passwordFld.setText("");
        
        frame.mainNav();
        }
        else if (attempt != 3){
            attempt++;
            showMessageDialog(null, "Incorrect username/password. Please try again");
            if (attempt == 2)
                showMessageDialog(null, "Next incorrect login attempt will initiate lockout");
        }
        else
            showMessageDialog(null, "Maximum attempts reached please try again later");
            
    }//GEN-LAST:event_loginBtnActionPerformed

    private void registerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerBtnActionPerformed
        usernameFld.setText("");
        passwordFld.setText("");
        frame.registerNav();
    }//GEN-LAST:event_registerBtnActionPerformed

    private void passwordFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordFldActionPerformed
private void forgotPass() {
        
        
        javax.swing.JTextField securityQuestion1 = new javax.swing.JTextField("");
        javax.swing.JTextField securityQuestion2 = new javax.swing.JTextField("");
        javax.swing.JTextField securityQuestion3 = new javax.swing.JTextField("");
        javax.swing.JPasswordField newPass = new javax.swing.JPasswordField("");
        javax.swing.JPanel panel = new javax.swing.JPanel(new java.awt.GridLayout(0, 1));
        
        
        panel.add(new javax.swing.JLabel("What city were you born in?"));
        panel.add(securityQuestion1);
        panel.add(new javax.swing.JLabel("What is your oldest sibling's middle name?"));
        panel.add(securityQuestion2);
        panel.add(new javax.swing.JLabel("What is your mother's maiden name?"));
        panel.add(securityQuestion3);
        panel.add(new javax.swing.JLabel("New Password:"));
        panel.add(newPass);
        if(!(usernameFld.getText().equals("")))
        if(!(frame.main.sqlite.userExists(usernameFld.getText().toLowerCase()))){
            showMessageDialog(null, "User does not exist");
        }
        else{
        int result = javax.swing.JOptionPane.showConfirmDialog(null, panel, "Test",
            javax.swing.JOptionPane.OK_CANCEL_OPTION, javax.swing.JOptionPane.PLAIN_MESSAGE);
        
        
        if (result == javax.swing.JOptionPane.OK_OPTION) {
        List<String> answers = frame.main.sqlite.getSecurityQuestionAnswers(usernameFld.getText().toLowerCase());
        if(answers.get(0).equals(frame.main.sqlite.getHash(securityQuestion1.getText(),frame.main.sqlite.getSalt(usernameFld.getText().toLowerCase())))
                && answers.get(1).equals(frame.main.sqlite.getHash(securityQuestion2.getText(),frame.main.sqlite.getSalt(usernameFld.getText().toLowerCase())))
                && answers.get(2).equals(frame.main.sqlite.getHash(securityQuestion3.getText(),frame.main.sqlite.getSalt(usernameFld.getText().toLowerCase())))){
        
        String patterns = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
        Pattern pattern = Pattern.compile(patterns);
        Matcher matcher = pattern.matcher(newPass.getText()); 
        boolean matchFound = matcher.find();
        if(matchFound){
        frame.main.sqlite.forgotPassword(usernameFld.getText().toLowerCase(),newPass.getText());
        showMessageDialog(null, "Password Update Successful");
        }
        else{
            showMessageDialog(null, "Invalid Password! Make sure your password has at least one digit,one upper case letter,one lower case letter, and one symbol. Your password must be 8-20 characters long");
        }
        }
        else{
           showMessageDialog(null, "Incorrect Security Question Answers");
        }
        securityQuestion1.setText("");
        securityQuestion2.setText("");
        securityQuestion3.setText("");
        newPass.setText("");
        }
        }else{
            
            showMessageDialog(null, "Please input your username");
        }
       
    }
    private void passwordForgetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordForgetBtnActionPerformed

        forgotPass();
    }//GEN-LAST:event_passwordForgetBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton loginBtn;
    private javax.swing.JTextField passwordFld;
    private javax.swing.JButton passwordForgetBtn;
    private javax.swing.JButton registerBtn;
    private javax.swing.JTextField usernameFld;
    // End of variables declaration//GEN-END:variables
}
