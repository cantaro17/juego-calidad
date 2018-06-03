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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import modelo.ConexionBD;
import vista.Interfaz;

/**
 *
 * @author Jhon
 */
public class BotonPulsadoAbajoListener implements ActionListener {

    String comando;
    String unirLetras;
    boolean sigue;
    float nota;

    @Override
    public void actionPerformed(ActionEvent e) {
        unirLetras = "";
        comando = e.getActionCommand();

        comando = ((JButton) e.getSource()).getName();
        Contador();
        if (!e.getActionCommand().equals("") && sigue) {
            SelecionarBoton();
            for (int i = 0; i < Interfaz.ControladorArriba.indice; i++) {
                if (Interfaz.ControladorArriba.botones[i].getText().equals("")) {
                    Interfaz.ControladorArriba.botones[i].setText(e.getActionCommand());

                    Interfaz.ControladorArriba.botones[i].setBackground(new Color(125, 195, 42));
                    Interfaz.ControladorArriba.botones[i].setForeground(new Color(253, 254, 251));

                    break;
                }
            }

            for (int i = 0; i < Interfaz.ControladorArriba.indice; i++) {
                unirLetras = unirLetras.concat(Interfaz.ControladorArriba.botones[i].getText());

            }
            playSound();
        }
        Connection cn = ConexionBD.conexion();
        PreparedStatement ps;
        String sql = "SELECT idcaracteristica FROM caracteristica WHERE nombrecaracteristica ='" + unirLetras + "' AND conceptocaracteristica ='" + Interfaz.txtConcepto.getText() + "'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                String modificar = "INSERT INTO juego (id_usuario,idcaracteristica,puntaje_juego) VALUES ("+Interfaz.id_usuario+","+rs.getInt("idcaracteristica")+",2.5)";
                ps = cn.prepareStatement(modificar);
                ps.executeUpdate();

                Interfaz.PanelPrincipal.removeAll();
                Interfaz.PanelPrincipal.repaint();
                Interfaz.GenerarMostrarBotonesAbajo();
                Interfaz.GenerarMostrarBotonesArriba();
                
                nota += 2.5;
//                principal.puntaje.setText(String.valueOf(nota));

            } else {
                System.out.println("Triste");
            }
        } catch (SQLException ex) {
            Logger.getLogger(BotonPulsadoAbajoListener.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void SelecionarBoton() {
        switch (comando) {
            case "btn0":
                Interfaz.ControladorAbajo.botones[0].setText("");
                Interfaz.ControladorAbajo.botones[0].setBackground(new Color(48, 75, 123));
                break;
            case "btn1":
                Interfaz.ControladorAbajo.botones[1].setText("");
                Interfaz.ControladorAbajo.botones[1].setBackground(new Color(48, 75, 123));
                break;
            case "btn2":
                Interfaz.ControladorAbajo.botones[2].setText("");
                Interfaz.ControladorAbajo.botones[2].setBackground(new Color(48, 75, 123));
                break;
            case "btn3":
                Interfaz.ControladorAbajo.botones[3].setText("");
                Interfaz.ControladorAbajo.botones[3].setBackground(new Color(48, 75, 123));
                break;
            case "btn4":
                Interfaz.ControladorAbajo.botones[4].setText("");
                Interfaz.ControladorAbajo.botones[4].setBackground(new Color(48, 75, 123));
                break;
            case "btn5":
                Interfaz.ControladorAbajo.botones[5].setText("");
                Interfaz.ControladorAbajo.botones[5].setBackground(new Color(48, 75, 123));
                break;
            case "btn6":
                Interfaz.ControladorAbajo.botones[6].setText("");
                Interfaz.ControladorAbajo.botones[6].setBackground(new Color(48, 75, 123));
                break;
            case "btn7":
                Interfaz.ControladorAbajo.botones[7].setText("");
                Interfaz.ControladorAbajo.botones[7].setBackground(new Color(48, 75, 123));
                break;
            case "btn8":
                Interfaz.ControladorAbajo.botones[8].setText("");
                Interfaz.ControladorAbajo.botones[8].setBackground(new Color(48, 75, 123));
                break;
            case "btn9":
                Interfaz.ControladorAbajo.botones[9].setText("");
                Interfaz.ControladorAbajo.botones[9].setBackground(new Color(48, 75, 123));
                break;
            case "btn10":
                Interfaz.ControladorAbajo.botones[10].setText("");
                Interfaz.ControladorAbajo.botones[10].setBackground(new Color(48, 75, 123));
                break;
            case "btn11":
                Interfaz.ControladorAbajo.botones[11].setText("");
                Interfaz.ControladorAbajo.botones[11].setBackground(new Color(48, 75, 123));
                break;
            case "btn12":
                Interfaz.ControladorAbajo.botones[12].setText("");
                Interfaz.ControladorAbajo.botones[12].setBackground(new Color(48, 75, 123));
                break;
            case "btn13":
                Interfaz.ControladorAbajo.botones[13].setText("");
                Interfaz.ControladorAbajo.botones[13].setBackground(new Color(48, 75, 123));
                break;
            case "btn14":
                Interfaz.ControladorAbajo.botones[14].setText("");
                Interfaz.ControladorAbajo.botones[14].setBackground(new Color(48, 75, 123));
                break;
            case "btn15":
                Interfaz.ControladorAbajo.botones[15].setText("");
                Interfaz.ControladorAbajo.botones[15].setBackground(new Color(48, 75, 123));
                break;
            case "btn16":
                Interfaz.ControladorAbajo.botones[16].setText("");
                Interfaz.ControladorAbajo.botones[16].setBackground(new Color(48, 75, 123));
                break;
            case "btn17":
                Interfaz.ControladorAbajo.botones[17].setText("");
                Interfaz.ControladorAbajo.botones[17].setBackground(new Color(48, 75, 123));
                break;
            case "btn18":
                Interfaz.ControladorAbajo.botones[18].setText("");
                Interfaz.ControladorAbajo.botones[18].setBackground(new Color(48, 75, 123));
                break;
            case "btn19":
                Interfaz.ControladorAbajo.botones[19].setText("");
                Interfaz.ControladorAbajo.botones[19].setBackground(new Color(48, 75, 123));
                break;
            case "btn20":
               Interfaz.ControladorAbajo.botones[20].setText("");
                Interfaz.ControladorAbajo.botones[20].setBackground(new Color(48, 75, 123));
                break;
            case "btn21":
                Interfaz.ControladorAbajo.botones[21].setText("");
                Interfaz.ControladorAbajo.botones[21].setBackground(new Color(48, 75, 123));
                break;
            case "btn22":
                Interfaz.ControladorAbajo.botones[22].setText("");
                Interfaz.ControladorAbajo.botones[22].setBackground(new Color(48, 75, 123));
                break;
            case "btn23":
           Interfaz.ControladorAbajo.botones[23].setText("");
                Interfaz.ControladorAbajo.botones[23].setBackground(new Color(48, 75, 123));
                break;
            case "btn24":
                Interfaz.ControladorAbajo.botones[24].setText("");
                Interfaz.ControladorAbajo.botones[24].setBackground(new Color(48, 75, 123));
                break;

            case "btn25":
                Interfaz.ControladorAbajo.botones[25].setText("");
                Interfaz.ControladorAbajo.botones[25].setBackground(new Color(48, 75, 123));
                break;
            case "btn26":
                Interfaz.ControladorAbajo.botones[26].setText("");
                Interfaz.ControladorAbajo.botones[26].setBackground(new Color(48, 75, 123));
                break;
            case "btn27":
                Interfaz.ControladorAbajo.botones[27].setText("");
                Interfaz.ControladorAbajo.botones[27].setBackground(new Color(48, 75, 123));
                break;
            case "btn28":
                Interfaz.ControladorAbajo.botones[28].setText("");
                Interfaz.ControladorAbajo.botones[28].setBackground(new Color(48, 75, 123));
                break;
            case "btn29":
                Interfaz.ControladorAbajo.botones[29].setText("");
                Interfaz.ControladorAbajo.botones[29].setBackground(new Color(48, 75, 123));
                break;
            case "btn30":
                Interfaz.ControladorAbajo.botones[30].setText("");
                Interfaz.ControladorAbajo.botones[30].setBackground(new Color(48, 75, 123));
                break;
            case "btn31":
                Interfaz.ControladorAbajo.botones[31].setText("");
                Interfaz.ControladorAbajo.botones[31].setBackground(new Color(48, 75, 123));
                break;
            case "btn32":
                Interfaz.ControladorAbajo.botones[32].setText("");
                Interfaz.ControladorAbajo.botones[32].setBackground(new Color(48, 75, 123));
                break;
            case "btn33":
                Interfaz.ControladorAbajo.botones[33].setText("");
                Interfaz.ControladorAbajo.botones[33].setBackground(new Color(48, 75, 123));
                break;
            case "btn34":
                Interfaz.ControladorAbajo.botones[34].setText("");
                Interfaz.ControladorAbajo.botones[34].setBackground(new Color(48, 75, 123));
                break;
            case "btn35":
                Interfaz.ControladorAbajo.botones[35].setText("");
                Interfaz.ControladorAbajo.botones[35].setBackground(new Color(48, 75, 123));
                break;
            default:
                break;
        }
    }

    public static void playSound() {
        try {
            Clip sonido = AudioSystem.getClip();
            File a = new File("C:\\Users\\Jhon\\Documents\\NetBeansProjects\\JuegoCalidad\\src\\audios\\mouseclick.wav");
            sonido.open(AudioSystem.getAudioInputStream(a));
            sonido.stop();
            sonido.setFramePosition(0);
            sonido.start();

        } catch (Exception tipoerror) {
            System.out.println("" + tipoerror);
        }
    }

    public void Contador() {
        sigue = true;
        for (int i = 0; i < Interfaz.ControladorArriba.indice; i++) {
            if (Interfaz.ControladorArriba.botones[i].getText().equals("")) {
                sigue = true;
                break;
            } else {
                sigue = false;
            }
        }
    }

}
