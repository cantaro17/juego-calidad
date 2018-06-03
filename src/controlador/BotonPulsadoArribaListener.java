/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import vista.Interfaz;

/**
 *
 * @author Jhon
 */
public class BotonPulsadoArribaListener implements ActionListener {

    String comando;

    @Override

    public void actionPerformed(ActionEvent e) {
        comando = ((JButton) e.getSource()).getName();
        if (!e.getActionCommand().equals("")) {
            SelecionarBoton();
            for (int i = 0; i < Interfaz.ControladorAbajo.indice; i++) {
                if (Interfaz.ControladorAbajo.botones[i].getText().equals("")) {
                    Interfaz.ControladorAbajo.botones[i].setText(e.getActionCommand());
                    Interfaz.ControladorAbajo.botones[i].setBackground(new Color(227, 228, 230));
                    Interfaz.ControladorAbajo.botones[i].setForeground(new Color(53, 53, 54));

                    break;
                }
            }
            playSound();
        }
    }

    public void SelecionarBoton() {
        switch (comando) {
            case "btn0":
                Interfaz.ControladorArriba.botones[0].setText("");
                Interfaz.ControladorArriba.botones[0].setBackground(new Color(48, 75, 123));
                break;
            case "btn1":
                Interfaz.ControladorArriba.botones[1].setText("");
                Interfaz.ControladorArriba.botones[1].setBackground(new Color(48, 75, 123));
                break;
            case "btn2":
                Interfaz.ControladorArriba.botones[2].setText("");
                Interfaz.ControladorArriba.botones[2].setBackground(new Color(48, 75, 123));
                break;
            case "btn3":
                Interfaz.ControladorArriba.botones[3].setText("");
                Interfaz.ControladorArriba.botones[3].setBackground(new Color(48, 75, 123));
                break;
            case "btn4":
                Interfaz.ControladorArriba.botones[4].setText("");
                Interfaz.ControladorArriba.botones[4].setBackground(new Color(48, 75, 123));
                break;
            case "btn5":
                Interfaz.ControladorArriba.botones[5].setText("");
                Interfaz.ControladorArriba.botones[5].setBackground(new Color(48, 75, 123));
                break;
            case "btn6":
                Interfaz.ControladorArriba.botones[6].setText("");
                Interfaz.ControladorArriba.botones[6].setBackground(new Color(48, 75, 123));
                break;
            case "btn7":
                Interfaz.ControladorArriba.botones[7].setText("");
                Interfaz.ControladorArriba.botones[7].setBackground(new Color(48, 75, 123));
                break;
            case "btn8":
                Interfaz.ControladorArriba.botones[8].setText("");
                Interfaz.ControladorArriba.botones[8].setBackground(new Color(48, 75, 123));
                break;
            case "btn9":
                Interfaz.ControladorArriba.botones[9].setText("");
                Interfaz.ControladorArriba.botones[9].setBackground(new Color(48, 75, 123));
                break;
            case "btn10":
                Interfaz.ControladorArriba.botones[10].setText("");
                Interfaz.ControladorArriba.botones[10].setBackground(new Color(48, 75, 123));
                break;
            case "btn11":
                Interfaz.ControladorArriba.botones[11].setText("");
                Interfaz.ControladorArriba.botones[11].setBackground(new Color(48, 75, 123));
                break;
            case "btn12":
                Interfaz.ControladorArriba.botones[12].setText("");
                Interfaz.ControladorArriba.botones[12].setBackground(new Color(48, 75, 123));
                break;
            case "btn13":
                Interfaz.ControladorArriba.botones[13].setText("");
                Interfaz.ControladorArriba.botones[13].setBackground(new Color(48, 75, 123));
                break;
            case "btn14":
                Interfaz.ControladorArriba.botones[14].setText("");
                Interfaz.ControladorArriba.botones[14].setBackground(new Color(48, 75, 123));
                break;
            case "btn15":
                Interfaz.ControladorArriba.botones[15].setText("");
                Interfaz.ControladorArriba.botones[15].setBackground(new Color(48, 75, 123));
                break;
            case "btn16":
                Interfaz.ControladorArriba.botones[16].setText("");
                Interfaz.ControladorArriba.botones[16].setBackground(new Color(48, 75, 123));
                break;
            case "btn17":
                Interfaz.ControladorArriba.botones[17].setText("");
                Interfaz.ControladorArriba.botones[17].setBackground(new Color(48, 75, 123));
                break;
            case "btn18":
                Interfaz.ControladorArriba.botones[18].setText("");
                Interfaz.ControladorArriba.botones[18].setBackground(new Color(48, 75, 123));
                break;
            case "btn19":
                Interfaz.ControladorArriba.botones[19].setText("");
                Interfaz.ControladorArriba.botones[19].setBackground(new Color(48, 75, 123));
                break;
            case "btn20":
                Interfaz.ControladorArriba.botones[20].setText("");
                Interfaz.ControladorArriba.botones[20].setBackground(new Color(48, 75, 123));
                break;
            case "btn21":
                Interfaz.ControladorArriba.botones[21].setText("");
                Interfaz.ControladorArriba.botones[21].setBackground(new Color(48, 75, 123));
                break;
            case "btn22":
                Interfaz.ControladorArriba.botones[22].setText("");
                Interfaz.ControladorArriba.botones[22].setBackground(new Color(48, 75, 123));
                break;
            case "btn23":
                Interfaz.ControladorArriba.botones[23].setText("");
                Interfaz.ControladorArriba.botones[23].setBackground(new Color(48, 75, 123));
                break;
            case "btn24":
                Interfaz.ControladorArriba.botones[24].setText("");
                Interfaz.ControladorArriba.botones[24].setBackground(new Color(48, 75, 123));
                break;
            case "btn25":
                Interfaz.ControladorArriba.botones[25].setText("");
                Interfaz.ControladorArriba.botones[25].setBackground(new Color(48, 75, 123));
                break;
            case "btn26":
                Interfaz.ControladorArriba.botones[26].setText("");
                Interfaz.ControladorArriba.botones[26].setBackground(new Color(48, 75, 123));
                break;
            case "btn27":
                Interfaz.ControladorArriba.botones[27].setText("");
                Interfaz.ControladorArriba.botones[27].setBackground(new Color(48, 75, 123));
                break;
            case "btn28":
                Interfaz.ControladorArriba.botones[28].setText("");
                Interfaz.ControladorArriba.botones[28].setBackground(new Color(48, 75, 123));
                break;
            case "btn29":
                Interfaz.ControladorArriba.botones[29].setText("");
                Interfaz.ControladorArriba.botones[29].setBackground(new Color(48, 75, 123));
                break;
            case "btn30":
                Interfaz.ControladorArriba.botones[30].setText("");
                Interfaz.ControladorArriba.botones[30].setBackground(new Color(48, 75, 123));
                break;
            case "btn31":
                Interfaz.ControladorArriba.botones[31].setText("");
                Interfaz.ControladorArriba.botones[31].setBackground(new Color(48, 75, 123));
                break;
            case "btn32":
                Interfaz.ControladorArriba.botones[32].setText("");
                Interfaz.ControladorArriba.botones[32].setBackground(new Color(48, 75, 123));
                break;
            case "btn33":
                Interfaz.ControladorArriba.botones[33].setText("");
                Interfaz.ControladorArriba.botones[33].setBackground(new Color(48, 75, 123));
                break;
            case "btn34":
                Interfaz.ControladorArriba.botones[34].setText("");
                Interfaz.ControladorArriba.botones[34].setBackground(new Color(48, 75, 123));
                break;
            case "btn35":
                Interfaz.ControladorArriba.botones[35].setText("");
                Interfaz.ControladorArriba.botones[35].setBackground(new Color(48, 75, 123));
                break;
            default:
                break;
        }
    }

    public static void playSound() {
        try {
            Clip sonido = AudioSystem.getClip();
            File a = new File("C:\\Users\\Jhon\\Documents\\NetBeansProjects\\qualityproductsoftware\\src\\audios\\mouseclick.wav");
            sonido.open(AudioSystem.getAudioInputStream(a));
            sonido.stop();
            sonido.setFramePosition(0);
            sonido.start();

        } catch (Exception tipoerror) {
            System.out.println("" + tipoerror);
        }
    }
}
