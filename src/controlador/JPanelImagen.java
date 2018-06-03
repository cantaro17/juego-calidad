/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JPanelImagen extends JPanel {

    int x,y;
    private URL url = getClass().getResource("/imagenes/fondo7.png");
    Image image = new ImageIcon(url).getImage();
 
    public JPanelImagen(JFrame marco){
        System.out.println("jj");
        x=marco.getWidth();
        y=marco.getHeight();
    }
    @Override
    public void paint(Graphics g){
        System.out.println("jnkjj");
        g.drawImage(image, 0, 0, x, y, this);
                super.paint(g);
    }


}
