/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

 /*
 * TestClient.java
 *
 * Created on Oct 13, 2014, 4:23:12 PM
 */
package distributed_treeclient;

import static distributed_treeclient.Distributed_Data.Dodec;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author sai
 */
public class TestClient extends javax.swing.JInternalFrame {

    /**
     * Creates new form TestClient
     */
    public TestClient() {
        initComponents();
        this.getContentPane().setBackground(new Color(153,51,0));
    }
    JLabel[] JL = null;
    JTextField[] JT = null;
    public static boolean sent_data = false;
    public static String clientkey;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();

        setBackground(new java.awt.Color(153, 51, 0));
        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximizable(true);
        setResizable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Server IP :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, -1, -1));

        jTextField2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jTextField2.setText("localhost");
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 70, 20));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Key :");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 272, 30));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Port :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, -1, -1));

        jTextField3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jTextField3.setText("2222");
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 70, 20));

        jButton2.setBackground(new java.awt.Color(19, 21, 7));
        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton2.setText("Show Rules");
        jButton2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 110, 20));

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane1.setViewportView(jTextArea2);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 160, 390, 330));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
//jTextArea1.setText(sendString(jTextField2.getText(), Integer.parseInt(jTextField3.getText()),jTextField1.getText()));
        clientkey=jTextField1.getText().trim();
        if(!clientkey.equals("")&&Distributed_Data.mapKeyData.containsKey(clientkey))
        {
        MultiThreadedClient.PortNo = Integer.parseInt(jTextField3.getText());
        MultiThreadedClient.host = jTextField2.getText();
        MultiThreadedClient.KEY = "TREE" + jTextField1.getText();
        String[] s = new String[1];
        MultiThreadedClient.main(s);
        int dec_key = Distributed_Data.key_data.get(jTextField1.getText());
        jTextArea2.setText(getoriginalData(MultiThreadedClient.sb, dec_key).toString());
        }
        else
        {
            JOptionPane.showMessageDialog(this,"Please Enter Correct Key...!");
        }
    }//GEN-LAST:event_jButton2ActionPerformed
    public StringBuffer getoriginalData(StringBuffer data, int key) {
        StringBuffer sbuild = new StringBuffer();
        String[] str = data.toString().split("\n");
        for (int i = 1; i < str.length; i++) {

            String temp = str[i].replace("----->", " ");
            //String[] st = temp.split(",");
            StringBuffer sb = new StringBuffer();
            //for (int j = 0; j < st.length; j++) {
                //String[] ss = st[j].split(" ");
                String []ss=temp.split(" ");
                for (int k = 0; k < ss.length; k++) {
                    ArrayList<String>al=Distributed_Data.mapKeyData.get(clientkey);
                    if(al.contains(ss[k].trim()))
                    {
                    if(CsvFileWriter.mapItemWithVal.containsValue(ss[k].trim()))
                    {
                        for(String s:CsvFileWriter.mapItemWithVal.keySet())
                        {
                            if(CsvFileWriter.mapItemWithVal.get(s).equals(ss[k]))
                            {
                                 //String dta=CsvFileWriter.mapItemWithVal.get(s);
                                 sb.append(s+ " ");
                                 break;
                            }
                        }
                      
                    }
                    else
                    {
                        sb.append(ss[k].trim()+ " ");
                    }
                    
                    }
                    else
                    {
                        sb.append(ss[k].trim()+ " ");
                    }
                    sb.append(",");
                }
            //}

            String decrypted = sb.substring(0, sb.length() - 1);
            decrypted = decrypted.replace(",", "----->");
            sbuild.append(decrypted + "\n");
        }
        return sbuild;
    }
    /**
     * @param args the command line arguments
     */
    /*public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TestClient().setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables

}
