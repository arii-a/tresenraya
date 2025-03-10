/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.upb.tresenraya;

import edu.upb.tresenraya.comandos.Contacto;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author Ariana
 */
public class ContactRenderer extends JLabel implements ListCellRenderer<Contacto> {
    protected static final Font SELECTED_FONT = new Font("Comic Sans MS", Font.PLAIN, 12);


    @Override
    public Component getListCellRendererComponent(JList<? extends Contacto> list, Contacto contact, int index, boolean isSelected, boolean cellHasFocus) {
        ImageIcon imageIcon;
        if (contact.isStateConnect()) {
            imageIcon = new ImageIcon(getClass().getResource("/images/online.png"));
        } else {
            imageIcon = new ImageIcon(getClass().getResource("/images/offline.png"));
        }

        Image imgScaled = imageIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);

        ImageIcon scaledIcon = new ImageIcon(imgScaled);
        setIcon(scaledIcon);

        setText("<html><p>" + contact.getName() + "</p></html>");
        return this;
    }
}


