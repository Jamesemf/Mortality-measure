package dm.v1;

import java.awt.Color;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HaveEmail extends javax.swing.JFrame {

    public static Boolean OpenStorage = false;

    public HaveEmail() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        EmailLabel = new javax.swing.JLabel();
        PassLabel = new javax.swing.JLabel();
        EmailToSendTo = new javax.swing.JLabel();
        EmailField = new javax.swing.JTextField();
        PassField = new javax.swing.JTextField();
        RecipientField = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        SelectE = new javax.swing.JButton();
        NewE = new javax.swing.JButton();
        BackGround = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(null);

        EmailLabel.setFont(new java.awt.Font("Dialog", 3, 24)); // NOI18N
        EmailLabel.setForeground(new java.awt.Color(0, 0, 0));
        EmailLabel.setText("Sender Password :");
        jPanel1.add(EmailLabel);
        EmailLabel.setBounds(210, 20, 220, 32);

        PassLabel.setFont(new java.awt.Font("Dialog", 3, 24)); // NOI18N
        PassLabel.setForeground(new java.awt.Color(0, 0, 0));
        PassLabel.setText("Sender Email :");
        jPanel1.add(PassLabel);
        PassLabel.setBounds(10, 20, 220, 32);

        EmailToSendTo.setFont(new java.awt.Font("Dialog", 3, 24)); // NOI18N
        EmailToSendTo.setForeground(new java.awt.Color(0, 0, 0));
        EmailToSendTo.setText("Recipient Email :");
        jPanel1.add(EmailToSendTo);
        EmailToSendTo.setBounds(20, 130, 210, 32);

        EmailField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailFieldActionPerformed(evt);
            }
        });
        jPanel1.add(EmailField);
        EmailField.setBounds(0, 60, 200, 24);

        PassField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PassFieldActionPerformed(evt);
            }
        });
        jPanel1.add(PassField);
        PassField.setBounds(220, 60, 200, 24);

        RecipientField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RecipientFieldActionPerformed(evt);
            }
        });
        jPanel1.add(RecipientField);
        RecipientField.setBounds(20, 170, 200, 24);

        jCheckBox1.setText("Save Email");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBox1);
        jCheckBox1.setBounds(20, 210, 100, 24);

        SelectE.setBackground(new java.awt.Color(153, 153, 153));
        SelectE.setForeground(new java.awt.Color(0, 0, 0));
        SelectE.setText("Select Existing  Email");
        SelectE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectEActionPerformed(evt);
            }
        });
        jPanel1.add(SelectE);
        SelectE.setBounds(250, 130, 190, 60);

        NewE.setBackground(new java.awt.Color(153, 153, 153));
        NewE.setForeground(new java.awt.Color(0, 0, 0));
        NewE.setText("Enter");
        NewE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewEActionPerformed(evt);
            }
        });
        jPanel1.add(NewE);
        NewE.setBounds(250, 200, 184, 40);

        BackGround.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mail-darkblue.png"))); // NOI18N
        jPanel1.add(BackGround);
        BackGround.setBounds(40, 0, 660, 280);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setText(String Text) {
        this.RecipientField.setText(Text);
    }


    private void SelectEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectEActionPerformed

        
        
        if (OpenStorage == false) {                     
            String EmailA = this.EmailField.getText();
            String EmailP = this.PassField.getText();
            EmailStorage.displayEmails(this.RecipientField);
            OpenStorage = true;
        }

    }//GEN-LAST:event_SelectEActionPerformed

    private void NewEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewEActionPerformed

        String EmailA = this.EmailField.getText();
        String EmailP = this.PassField.getText();
        String recip = this.RecipientField.getText();

        // Using regular expression to pattern match the email entered 
        Pattern regExPattern = Pattern.compile("^([0-9a-zA-Z]([-.\\w]*[0-9a-zA-Z])*@(([0-9a-zA-Z])+([-\\w]*[0-9a-zA-Z])*\\.)+[a-zA-Z]{2,9})$");
        Matcher matcher = regExPattern.matcher(EmailA);
        Matcher rMatcher = regExPattern.matcher(recip);

        if (matcher.matches() && rMatcher.matches()) {

            System.out.println("Valid emails");//Start emailed chart

            if (EmailA.equals(recip)) {
                this.NewE.setText("Identical email"); //Checks that sender and recipient email are not identical
                NewE.setForeground(Color.red);
            } else {
                EmailStorage.createPNG(ChartFrame.fxPanel);        //Creates a PNG of the chart entered 
                SendEmail.sendMail(recip, EmailA, EmailP);          //Calls the class 'SendEmail' to send email, passing in the recipient email, and sender email and password 
                
                if (this.jCheckBox1.isSelected()) {                     //Checks whether the JcheckBox is ticked; indicating whether to store the recipient email
                    if (EmailStorage.textItems != null) {                               
                        ArrayList<String> Emails = EmailStorage.textItems;
                        Boolean InAr = false;
                        for (int i = 0; i < Emails.size(); i++) {                   //Checks if recipient email is already saved 
                            if (EmailA.equals(EmailStorage.textItems.get(i))) {     
                                InAr = true;
                            }
                        }
                        if (InAr == false) {                                    //If not recipient email is appended to the text file
                            EmailStorage.writeFile(EmailA);
                        }
                    }

                }
            }

        } else {
            this.NewE.setText("Invalid");
            NewE.setForeground(Color.red);
        }
    }//GEN-LAST:event_NewEActionPerformed

    private void EmailFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmailFieldActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void RecipientFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RecipientFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RecipientFieldActionPerformed

    private void PassFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PassFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PassFieldActionPerformed

    public static void main(String args[]) {


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HaveEmail().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BackGround;
    private javax.swing.JTextField EmailField;
    private javax.swing.JLabel EmailLabel;
    private javax.swing.JLabel EmailToSendTo;
    private javax.swing.JButton NewE;
    private javax.swing.JTextField PassField;
    private javax.swing.JLabel PassLabel;
    private javax.swing.JTextField RecipientField;
    private javax.swing.JButton SelectE;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
