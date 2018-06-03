/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.swing.JButton;

/**
 *
 * @author Jhon
 */
public class ControllerButtonsDown {
    public JButton []botones;
    public int indice;
    int maximo;
    
    public ControllerButtonsDown()
    {
        this.indice = 0;
        this.maximo = 35;
        this.botones = new JButton[this.maximo];
    }

    public void AgregarBotones(JButton boton){
        this.botones[this.indice] = boton;
        this.indice++;
    }
}
