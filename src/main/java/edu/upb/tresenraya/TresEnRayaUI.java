/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package edu.upb.tresenraya;

import edu.upb.tresenraya.backend.SoundPlayer;
import edu.upb.tresenraya.comandos.AceptacionConexion;
import edu.upb.tresenraya.comandos.AceptacionJuego;
import edu.upb.tresenraya.comandos.Comando;
import edu.upb.tresenraya.comandos.Contacto;
import edu.upb.tresenraya.comandos.Contactos;
import edu.upb.tresenraya.comandos.IniciarJuego;
import edu.upb.tresenraya.comandos.Marcar;
import edu.upb.tresenraya.comandos.MovimientoAdicional;
import edu.upb.tresenraya.comandos.RechazoConexion;
import edu.upb.tresenraya.comandos.RechazoJuego;
import edu.upb.tresenraya.comandos.SolicitudConexion;
import edu.upb.tresenraya.db.ConexionDB;
import edu.upb.tresenraya.db.ContactosDB;
import edu.upb.tresenraya.mediador.Mediador;
import edu.upb.tresenraya.mediador.MediadorCliente;
import edu.upb.tresenraya.mediador.OnMessageListener;
import edu.upb.tresenraya.server.ServidorJuego;
import edu.upb.tresenraya.server.SocketClient;
import javax.swing.JTextArea;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.io.IOException;
import java.net.Socket;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

/**
 *
 * @author rlaredo
 */
public class TresEnRayaUI extends javax.swing.JFrame implements OnMessageListener, ActionListener, MouseListener {

    private ServidorJuego servidorJuego;
    private String jugador = "";
    private String posActual = "";
    String ip = "";
    SocketClient socketClientNew;
    DefaultListModel<Contacto> modeloLista = new DefaultListModel<>();
    private boolean juegoIniciado = false;
    private Contacto contacto = null;
    private boolean juegoHabilitado = false;
    private boolean movimientoExtra = false;

    public JTextArea getjTextArea1() {
        return jTextArea1;
    }
    

    /**
     * Creates new form TresEnRayaUI
     */
    public TresEnRayaUI() {
        initComponents();
        Mediador.addListener(this);
        MediadorCliente.addListenerCliente(this);
        
        jList1.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    jList1.setSelectedIndex(jList1.locationToIndex(e.getPoint()));
                    jMenuContactos.show(jList1, e.getPoint().x, e.getPoint().y);
                }
            }
        });
        
        jList1.setCellRenderer(new ContactRenderer());
        for(ContactosDB contactoDB : ContactosDB.getContactos()) {
            Contacto contact = new Contacto(contactoDB.getNombre(), contactoDB.getIp(), false); 
            modeloLista.addElement(contact);
        }
        jList1.setModel(modeloLista);
        
        ConexionDB.onstance().getConection();
                
        GridLayout gridLayout = new GridLayout(3, 3);
        jPanel3.setLayout(gridLayout);
        
        gridLayout.setColumns(3);
        gridLayout.setRows(3);
        for (int i = 0; i < gridLayout.getRows(); i++) {
            for (int j = 0; j < gridLayout.getColumns(); j++) {
                JLabel label= new JLabel();
                label.setName(String.format("%s%s", String.valueOf(i), String.valueOf(j)));
                label.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
                label.addMouseListener(this);
                jPanel3.add("Label "+i+"-"+j, label);
            }
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

        jMenuContactos = new javax.swing.JPopupMenu();
        retar = new javax.swing.JMenuItem();
        eliminar = new javax.swing.JMenuItem();
        jToolBar1 = new javax.swing.JToolBar();
        btnServer = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        ipSender = new javax.swing.JTextField(20);
        jButton3 = new javax.swing.JButton();
        sendIp = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jSplitPane2 = new javax.swing.JSplitPane();
        jPanel2 = new javax.swing.JPanel();
        chatPrueba = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        btnSendMessage = new javax.swing.JButton();
        textField1 = new java.awt.TextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();

        retar.setText("Retar");
        retar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retarActionPerformed(evt);
            }
        });
        jMenuContactos.add(retar);

        eliminar.setText("Eliminar");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });
        jMenuContactos.add(eliminar);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setRollover(true);

        btnServer.setBackground(new java.awt.Color(234, 234, 234));
        btnServer.setText("Iniciar Servidor");
        btnServer.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnServer.setFocusable(false);
        btnServer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnServer.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnServerActionPerformed(evt);
            }
        });
        jToolBar1.add(btnServer);

        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton1);

        jButton2.setBackground(new java.awt.Color(234, 234, 234));
        jButton2.setText("Nueva partida");
        jButton2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton5);

        jButton6.setBackground(new java.awt.Color(234, 234, 234));
        jButton6.setText("Solicitar movida");
        jButton6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton6.setFocusable(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton6);

        jButton7.setFocusable(false);
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton7);

        ipSender.setBackground(new java.awt.Color(234, 234, 234));
        ipSender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ipSenderActionPerformed(evt);
            }
        });
        jToolBar1.add(ipSender);

        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton3);

        sendIp.setBackground(new java.awt.Color(234, 234, 234));
        sendIp.setText("Send to play");
        sendIp.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        sendIp.setFocusable(false);
        sendIp.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sendIp.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        sendIp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendIpActionPerformed(evt);
            }
        });
        jToolBar1.add(sendIp);

        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton4);

        jSplitPane1.setDividerLocation(500);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        jSplitPane2.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        chatPrueba.setViewportView(jTextArea1);

        btnSendMessage.setText("Send");
        btnSendMessage.setToolTipText("");
        btnSendMessage.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSendMessage.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSendMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendMessageActionPerformed(evt);
            }
        });

        textField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(chatPrueba)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(textField1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSendMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(171, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(291, Short.MAX_VALUE)
                .addComponent(chatPrueba, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSendMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jSplitPane2.setBottomComponent(jPanel2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jSplitPane2.setLeftComponent(jPanel3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane2)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jSplitPane1.setLeftComponent(jPanel1);

        jScrollPane1.setViewportView(jList1);

        jSplitPane1.setRightComponent(jScrollPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 651, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSplitPane1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnServerActionPerformed
        // TODO add your handling code here:
        if (servidorJuego == null) {
            try {
                servidorJuego = new ServidorJuego(this);
                servidorJuego.start();
                btnServer.setText("Servidor Iniciado");
                jTextArea1.setEditable(false);
                jTextArea1.append("Chat iniciado!\n");
            } catch (IOException e) {
            }
        }
    }//GEN-LAST:event_btnServerActionPerformed

    private void btnSendMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendMessageActionPerformed
        String message = textField1.getText();
        
        if(message != null) {
            if (message.split(" ")[0].equals("colour") || message.split(" ")[0].equals("color")) {
                sendColour(message.split(" ")[1]);
                jTextArea1.append("Servidor: "+message+"\n");
                MediadorCliente.sendMessageCliente(message+"\n");
                textField1.setText("");
            } else {
                MediadorCliente.sendMessageCliente(message);
                textField1.setText("");
            }
        }
    }//GEN-LAST:event_btnSendMessageActionPerformed

    private void textField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField1ActionPerformed

    private void ipSenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ipSenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ipSenderActionPerformed

    private void sendIpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendIpActionPerformed
        String ip = ipSender.getText();
        System.out.println("IP: " + ip);
        onSend001(ip);
    }//GEN-LAST:event_sendIpActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        vaciarCuadricula();
        MediadorCliente.sendMessageCliente("0007");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void retarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retarActionPerformed
        String[] simbolos = {"X", "O"};
        int respuesta = JOptionPane.showOptionDialog(null,
                        "Selecciona el símbolo con el que deseas solicitar.",
                   "Símbolo",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                simbolos,
                simbolos[0]
        );
               
        if (respuesta == 0) {
            IniciarJuego inc = new IniciarJuego(simbolos[0]);
            MediadorCliente.sendMessageCliente(inc.getComando());
            jugador = simbolos[0];
        } else if (respuesta == 1) {
            IniciarJuego inc = new IniciarJuego(simbolos[1]);
            MediadorCliente.sendMessageCliente(inc.getComando());
            jugador = simbolos[1];
        }
    }//GEN-LAST:event_retarActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        contacto = jList1.getSelectedValue();
        if (contacto != null) {
            String ipContacto = contacto.getIp();
            System.out.println(ipContacto);
            SocketClient client = Contactos.getInstance().getContactoByIp(ipContacto);
            if (client != null) {
                client.closeConnection();
                modeloLista.removeElement(contacto);
                ContactosDB.deleteContacto(contacto.getIp());
            } else {
                JOptionPane.showMessageDialog(this, "No se ha podido eliminar, contacto nulo.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_eliminarActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        movimientoExtra = true;
    }//GEN-LAST:event_jButton6ActionPerformed


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
            java.util.logging.Logger.getLogger(TresEnRayaUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TresEnRayaUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TresEnRayaUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TresEnRayaUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TresEnRayaUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSendMessage;
    private javax.swing.JButton btnServer;
    private javax.swing.JScrollPane chatPrueba;
    private javax.swing.JMenuItem eliminar;
    private javax.swing.JTextField ipSender;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JList<Contacto> jList1;
    private javax.swing.JPopupMenu jMenuContactos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenuItem retar;
    private javax.swing.JButton sendIp;
    private java.awt.TextField textField1;
    // End of variables declaration//GEN-END:variables

    
    @Override
    public void onMessage(String message) {
        this.jTextArea1.append(message);   
      
    }

    @Override
    public void onClose() {
        this.jTextArea1.append("IU: Se ha cerrado la conexión\n");
        System.out.println("IU: Se ha cerrado la conexión");
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("a: "+e.getActionCommand());
    }

    

    public void sendColour(String colour) {
       switch (colour) {
        case "1" -> jTextArea1.setBackground(Color.RED);
        case "2" -> jTextArea1.setBackground(Color.BLUE);
        case "3" -> jTextArea1.setBackground(Color.GREEN);
        default -> jTextArea1.setBackground(Color.WHITE);        
       }
    }
   

    @Override
    public void onChangeColour(String colour) {
        sendColour(colour);
    }


    @Override
    public void onMessageCliente(String message) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    public void onSend001(String ip) {
        jTextArea1.append("Solicitud enviada a " + ip + "\n");
        String msg = "0001|Ariana";
        
        
        try {
                Socket socket = new Socket(ip, 1825);
                socketClientNew = new SocketClient(socket);
                socketClientNew.start();        
                
                Contactos.getInstance().onNewClient(socketClientNew);
                ContactosDB.addContacto(socketClientNew.getIp(), msg.split("\\|")[1]);
                System.out.println(socketClientNew.getIp());
                Contactos.getInstance().send(socketClientNew.getIp(), msg + System.lineSeparator());
            
                SwingUtilities.invokeLater(() -> {
                    JOptionPane.showMessageDialog(null, "Mensaje enviado a IP: " + ip,
                            "OK", JOptionPane.INFORMATION_MESSAGE);
                });   
                this.ip = ip;
                             
            } catch (IOException e) {
                System.err.println("I/O error: " + e.getMessage());
                JOptionPane.showMessageDialog(null, "Error al conectar con el cliente", "Error", JOptionPane.ERROR_MESSAGE);
            }
    }

    public void onSendDatos(String simbolo, int posX, int posY) {
        String nombreCelda = posX + "" + posY;
        for (Component comp : jPanel3.getComponents()) {
            if (comp instanceof JLabel label) {
                if (nombreCelda.equals(label.getName())) {
                    if (!label.getText().isEmpty()) {
                        System.err.println("Error: celda ya ocupada -> " + nombreCelda);
                        return;
                    }
                    label.setText(simbolo);
                    label.setFont(new Font("Arial", Font.BOLD, 60));
                    label.setHorizontalAlignment(SwingConstants.CENTER);
                    label.setVerticalAlignment(SwingConstants.CENTER);
                    System.out.println("Movimiento realizado en " + nombreCelda + " con " + simbolo);
                    return;
                }
            }
        }

        System.err.println("Error: No se encontró la celda con nombre -> " + nombreCelda);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if (juegoHabilitado) {
            JLabel source = (JLabel) e.getSource();
            if (!source.getText().isEmpty()) {
                return;
            }
            source.setText(jugador);
            source.setFont(new Font("Arial", Font.BOLD, 60));
            source.setHorizontalAlignment(SwingConstants.CENTER);
            source.setVerticalAlignment(SwingConstants.CENTER);
            System.out.println("Movimiento realizado en " + source + " con " + jugador);

            String pos = "" + source.getName();
            this.posActual = pos;
            System.out.println(this.posActual);
            //MediadorJuego.sendMessageJuego(this.posActual + " " + this.jugador);
            Marcar marcar = new Marcar(jugador,
                    Integer.parseInt(posActual.split("")[0]),
                    Integer.parseInt(posActual.split("")[1]));
            MovimientoAdicional move = new MovimientoAdicional(jugador,
                    Integer.parseInt(posActual.split("")[0]),
                    Integer.parseInt(posActual.split("")[1]));
            if (!movimientoExtra) {
                Mediador.sendMessage(marcar.getComando());
                MediadorCliente.sendMessageCliente(marcar.getComando() + "\n");
            } else {
                Mediador.sendMessage(move.getComando());
                MediadorCliente.sendMessageCliente(move.getComando() + "\n");
            }
        }
       
        if (verificarEmpate()) {
            JOptionPane.showMessageDialog(null, "Ha habido un empate",
                    "Partida finalizada", JOptionPane.INFORMATION_MESSAGE);
            juegoHabilitado = false;
        } else if (verificarGanador()) {
            SoundPlayer.playSound("WIN.wav");
            JOptionPane.showMessageDialog(null, "El jugador " + jugador + " ha ganado :D",
                    "Partida finalizada", JOptionPane.INFORMATION_MESSAGE);
            juegoHabilitado = false;
        } else {
            if (movimientoExtra) {
                juegoHabilitado = true;
                movimientoExtra = false;
            } else {
                juegoHabilitado = false;
            }
        }
    }

    private boolean verificarGanador() {
    String[][] matriz = new String[3][3];
    for (Component c : jPanel3.getComponents()) {
            if (c instanceof JLabel label) {
                String pos = label.getName();
                matriz[Integer.parseInt(pos.substring(0, 1))][Integer.parseInt(pos.substring(1, 2))] = label.getText();
            }
        }

        for (int i = 0; i < 3; i++) {
            //filas
            if (matriz[i][0] != null && !matriz[i][0].isEmpty()
                    && matriz[i][0].equals(matriz[i][1]) && matriz[i][1].equals(matriz[i][2])) {
                return true;
            }
            //columnas
            if (matriz[0][i] != null && !matriz[0][i].isEmpty()
                    && matriz[0][i].equals(matriz[1][i]) && matriz[1][i].equals(matriz[2][i])) {
                return true;
            }
        }
        //diagonales
        if (matriz[0][0] != null && !matriz[0][0].isEmpty()
                && matriz[0][0].equals(matriz[1][1]) && matriz[1][1].equals(matriz[2][2])) {
            return true;
        }
        return matriz[0][2] != null && !matriz[0][2].isEmpty()
                && matriz[0][2].equals(matriz[1][1]) && matriz[1][1].equals(matriz[2][0]);
    }

    private boolean verificarEmpate() {
        for (Component c : jPanel3.getComponents()) {
            if (c instanceof JLabel jLabel) {
                if (jLabel.getText().isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    public void onInvalidMove() {
            JOptionPane.showMessageDialog(null, "Este jugador ya jugó su turno!!.",
                "Movimiento no válido", JOptionPane.WARNING_MESSAGE);
       
    }
    
    public void vaciarCuadricula() {
        for (Component c : jPanel3.getComponents()) {
            if (c instanceof JLabel jLabel) {
                jLabel.setText("");
            }
        }
        jPanel3.revalidate();
        jPanel3.repaint(); 
        System.out.println("Cuadrícula vaciada correctamente.");
    }

    @Override
    public void onMessage(Comando c) {
        switch (c.getCodigoComando()) {
            case "0001" -> {
                SolicitudConexion sol = (SolicitudConexion) c;
                String nombre = sol.getNombre();
                AceptacionConexion acep = new AceptacionConexion(nombre);
                RechazoConexion rec = new RechazoConexion();
                this.ip = sol.getIp();

                int n = JOptionPane.showConfirmDialog(this, nombre + " te ha solicitado",
                        "Solicitud de conexion",
                        JOptionPane.YES_NO_OPTION);

                if (n == JOptionPane.YES_OPTION) {
                    System.out.println(sol.getIp() + " " + acep.getComando());
                    MediadorCliente.sendMessageCliente(acep.getComando());
                    Contactos.getInstance().send(sol.getIp(), acep.getComando() + System.lineSeparator());
                    
                    Contacto contactu = new Contacto(sol.getNombre(), sol.getIp(), false);          
                    modeloLista.addElement(contactu);
                    
                } else if (n == JOptionPane.NO_OPTION) {
                    MediadorCliente.sendMessageCliente(rec.getComando());
                    Contactos.getInstance().send(sol.getIp(), rec.getComando() + System.lineSeparator());
                }
            }
            case "0002" -> {
                System.out.println("Solicitud rechazada");
                JOptionPane.showMessageDialog(null, "Solicitud rechazada.", "NO", JOptionPane.INFORMATION_MESSAGE);
            }
            case "0003" -> {
                AceptacionConexion ace = (AceptacionConexion) c;
                String name = ace.getNombre();
                System.out.println("0003|" + name);
                JOptionPane.showMessageDialog(null, name + " ha aceptado la solicitud.", "Solicitud Aceptada", JOptionPane.INFORMATION_MESSAGE);
                
                Contacto contact = new Contacto(name, this.ip, false);
                modeloLista.addElement(contact);
            }
            case "0004" -> {
                IniciarJuego inc = (IniciarJuego) c;
                String simb = inc.getSimboloJuego();
                int respuesta = JOptionPane.showConfirmDialog(null,
                        "Jugador solicita partida con símbolo " + simb + ". ¿Aceptar?",
                        "Iniciar Partida",
                        JOptionPane.YES_NO_OPTION);
                
                if (respuesta == JOptionPane.YES_OPTION) {
                    AceptacionJuego acepj = new AceptacionJuego();
                    if(simb.equals("X")) {
                        jugador = "O";
                    } else if (simb.equals("O")) {
                        jugador = "X";
                    }
                    
                    juegoIniciado = true; 
                    movimientoExtra = false;
                    Contactos.getInstance().send(ip, "0006" + System.lineSeparator());
                    MediadorCliente.sendMessageCliente(acepj.getComando());
                    for (int i = 0; i < modeloLista.getSize(); i++) {
                        Contacto contacte = modeloLista.getElementAt(i);
                        if (contacte.getIp().equals(ip)) {
                            contacte.setStateConnect(true);
                            modeloLista.setElementAt(contacte, i); 
                            break;
                        }
                    }
                } else {
                    RechazoJuego rechj = new RechazoJuego();
                    Contactos.getInstance().send(ip, "0005" + System.lineSeparator()); 
                    MediadorCliente.sendMessageCliente(rechj.getComando());
                }
            }
            case "0005" -> JOptionPane.showMessageDialog(null, "Juegador rechazó partida", "Partida Rechazada", JOptionPane.INFORMATION_MESSAGE);
            case "0006" -> {
                juegoIniciado = true;
                juegoHabilitado = true;
                movimientoExtra = false;
                JOptionPane.showMessageDialog(null, "Juegador aceptó la partida", "Partida Aceptada", JOptionPane.INFORMATION_MESSAGE);
                for(int i = 0; i < modeloLista.getSize(); i++) {
                    Contacto contactis = modeloLista.getElementAt(i);
                    if(contactis.getIp().equals(ip)) {
                        contactis.setStateConnect(true);
                        modeloLista.setElementAt(contactis, i);
                        break;
                    }
                }
            }
            case "0007" -> {
                vaciarCuadricula();
                juegoHabilitado = true;
                JOptionPane.showMessageDialog(null, "Juegador inició nueva partida", "Partida Nueva", JOptionPane.INFORMATION_MESSAGE);
            }
            case "0008" -> {
                if (!juegoIniciado) { 
                    System.err.println("⚠ No puedes jugar sin haber aceptado una partida.");
                    JOptionPane.showMessageDialog(null, "Debes aceptar una partida antes de jugar.", "Error", JOptionPane.WARNING_MESSAGE);
                    return; 
                }

                Marcar marca = (Marcar) c;
                String simbol = marca.getSimboloJuego();
                int posX = marca.getPosX();
                int posY = marca.getPosY();
                onSendDatos(simbol, posX, posY);
                System.out.println(simbol + " en casilla " + posX + "" + posY);
                juegoHabilitado = true;
            }
            case "0011" -> {
                if (!juegoIniciado) { 
                    System.err.println("⚠ No puedes jugar sin haber aceptado una partida.");
                    JOptionPane.showMessageDialog(null, "Debes aceptar una partida antes de jugar.", "Error", JOptionPane.WARNING_MESSAGE);
                    return; 
                }

                JOptionPane.showMessageDialog(null, "Se ha solicitado doble movimiento", "Movimientos adicionales", JOptionPane.INFORMATION_MESSAGE);
                MovimientoAdicional move = (MovimientoAdicional) c;
                String simbolo = move.getSimboloJuego();
                int x = move.getPosX();
                int y = move.getPosY();
                System.out.println(simbolo + " en casilla " + x + "" + y);
                juegoHabilitado = false;
            }
        }
    }
}
