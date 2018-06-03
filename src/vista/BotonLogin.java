/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Jhon
 */
public class BotonLogin implements MouseListener{

    public BotonLogin() {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        login sesion = new login();
        sesion.setAlwaysOnTop(true);
        sesion.setVisible(true);
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
}
