

package airlineresevation;

import static airlineresevation.myvariables.password;
import static airlineresevation.myvariables.path;
import static airlineresevation.myvariables.place;
import static airlineresevation.myvariables.username;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class Cancel_Seat extends javax.swing.JInternalFrame implements myvariables{

   
    public Cancel_Seat() {
        initComponents();
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jTextField4 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Ticket Cancellation");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Ticket_NUMBER");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, -1, -1));

        jLabel2.setText("Flight_ID");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, -1, -1));

        jLabel3.setText("Customer_ID");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, -1, -1));

        jLabel4.setText("Seats");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 290, -1, -1));
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 240, 167, -1));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, 167, -1));

        jButton1.setText("SEARCH");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 90, -1, -1));
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 290, 167, -1));
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, 167, -1));

        jButton2.setText("CANCEL");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 360, 110, 80));

        jLabel5.setText("Customer_Name");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, -1, -1));
        getContentPane().add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, 170, -1));

        jLabel6.setFont(new java.awt.Font("Tempus Sans ITC", 0, 24)); // NOI18N
        jLabel6.setText("TICKET CANCELLATION");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/airlineresevation/images/No title(53).jpg"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 330, 200, 150));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       try
            {
                Connection myconnection;
              
                myconnection=DriverManager.getConnection(path+place, username,password);
                
                try
                {
                    String q="delete from treser where custid1=?";
                    PreparedStatement mystatement=myconnection.prepareStatement(q);
                    mystatement.setString(1,jTextField1.getText());
                 if(!jTextField1.getText().equals(""))
                 {
                        int a=JOptionPane.showConfirmDialog(rootPane, "Do you really want to Cancel your ticket?", "Cancellation", JOptionPane.YES_NO_OPTION);
               
                        if(a==JOptionPane.YES_OPTION)
                        {
                                mystatement.executeUpdate();
                                JOptionPane.showMessageDialog(rootPane, "Cancelled Successfully", "Ticket Cancellation", JOptionPane.INFORMATION_MESSAGE);
                             jTextField1.setText("");  
                             jTextField2.setText("");
                             jTextField3.setText("");
                             jTextField4.setText("");
                             jTextField5.setText("");

                           }
                }
                 else
                 {
                     JOptionPane.showMessageDialog(rootPane, "No Records!!!!!", "Error",JOptionPane.ERROR_MESSAGE);
                 }
                }
                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(rootPane, "Error in query due to"+e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
                }
                finally
                {
                    myconnection.close();
                }
            }
        catch(Exception e)
        {
         e.printStackTrace();
         JOptionPane.showMessageDialog(rootPane, "Error in connection" +e.getMessage());
    }                      
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       try
            {
                Connection myconnection;
            
                myconnection=DriverManager.getConnection(path+place,username, password);
                
                try
                {
                    String q="select * from treser where custid1=?";
                    PreparedStatement mystatement=myconnection.prepareStatement(q);
                    mystatement.setString(1,jTextField1.getText());
                    ResultSet myresult=mystatement.executeQuery();
                     if(myresult.next())
                    {
                     
                       jTextField2.setText(myresult.getString("flid"));
                         jTextField3.setText(myresult.getString("tno"));
                         jTextField4.setText(myresult.getString("seatno"));
                         jTextField5.setText(myresult.getString("custname1"));
                          
                             
                      
                          
                    }
                  else
                     {
                         JOptionPane.showMessageDialog(rootPane, "No Tickets Found for your customerID!!!", "Error",JOptionPane.ERROR_MESSAGE);
                     }
                
                     
                }
                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(rootPane, "Error in query due to"+e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
                }
                finally
                {
                    myconnection.close();
                }
            }
        catch(Exception e)
        {
         e.printStackTrace();
         JOptionPane.showMessageDialog(rootPane, "Error in connection" +e.getMessage());
    }                             
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
