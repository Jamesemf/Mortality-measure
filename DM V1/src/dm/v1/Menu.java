
package dm.v1;

public class Menu extends javax.swing.JFrame {


    public Menu() {
        initComponents();
        this.setSize(1500,1100);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jLabel1 = new javax.swing.JLabel();
        LineButton = new javax.swing.JButton();
        BarButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Dialog", 3, 90)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Mortality Measure");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(320, 10, 780, 110);

        LineButton.setBackground(new java.awt.Color(0, 0, 0));
        LineButton.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        LineButton.setForeground(new java.awt.Color(0, 0, 0));
        LineButton.setText("Line Graph");
        LineButton.setToolTipText("");
        LineButton.setOpaque(false);
        LineButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LineButtonActionPerformed(evt);
            }
        });
        getContentPane().add(LineButton);
        LineButton.setBounds(200, 620, 970, 70);

        BarButton.setBackground(new java.awt.Color(0, 0, 0));
        BarButton.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        BarButton.setForeground(new java.awt.Color(0, 0, 0));
        BarButton.setText("Bar Graph");
        BarButton.setOpaque(false);
        BarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BarButtonActionPerformed(evt);
            }
        });
        getContentPane().add(BarButton);
        BarButton.setBounds(200, 490, 970, 70);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/447319-creepy-background-pictures-2560x1600-for-4k.jpg"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(-20, -10, 1560, 1160);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LineButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LineButtonActionPerformed

        this.dispose();
        DMV1.newBar(false); // True = BarChart False = LineChart
    }//GEN-LAST:event_LineButtonActionPerformed

    private void BarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BarButtonActionPerformed
         this.dispose();
        DMV1.newBar(true); // True = BarChart False = LineChart
    }//GEN-LAST:event_BarButtonActionPerformed

 
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BarButton;
    private javax.swing.JButton LineButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    // End of variables declaration//GEN-END:variables
}
