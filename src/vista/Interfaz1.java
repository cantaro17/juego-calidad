/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import com.placeholder.PlaceHolder;
import controlador.BotonPulsadoAbajoListener;
import controlador.BotonPulsadoArribaListener;
import controlador.ControllerButtonsDown;
import controlador.ControllerButtonsUp;
import controlador.JPanelImagen;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import modelo.ConexionBD;
import org.pushingpixels.substance.api.SubstanceLookAndFeel;

/**
 *
 * @author Jhon
 */
public class Interfaz1 extends javax.swing.JFrame {

    static JFrame VentaPrincipal;
    public static JPanelImagen PanelPrincipal;

    Icon ImagenFondo;
    JLabel MostrarImagen;

    public static ControllerButtonsDown ControladorAbajo;
    public static ControllerButtonsUp ControladorArriba;

    static JButton btnLetra;
    static JButton btnLogin;
    static JButton btnSalir;
    public static JTextArea txtConcepto;
    public static JTextField txtUser;
    public static JPasswordField txtPass;
    public static JLabel lbCrearCuenta;
    public static JLabel lbIconUser;
    public static JLabel lbIconPass;
    public static JLabel lbError;
    public static JLabel lbUsuario;

    static Random aleatorio;

    static Connection cn;
    static Statement st;
    static ResultSet rs;
    static Statement st_datosJugador;
    static ResultSet rs_datosJugador;

    static String LetrasConfundir = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
    static String letrasAbajo[];
    static String letrasAbajoConfundir[];

    static String consultasql;
    static String respuesta = "";

    public static int id_usuario = 2;
    public static double puntaje;
    public static JLabel lbPuntaje;

    static PlaceHolder phuser, phpass;
    static LinkedList<Integer> codigos;
    static ArrayList<Integer> cod;
    static HashSet hs;

    public Interfaz1() throws SQLException {

        VentaPrincipal = new JFrame("Juego");
        VentaPrincipal.setSize(1366, 768);
        VentaPrincipal.setLayout(null);

        PanelPrincipal = new JPanelImagen(VentaPrincipal);
        PanelPrincipal.setSize(1366, 768);
        PanelPrincipal.setOpaque(false);
        PanelPrincipal.setLayout(null);

//        PanelPrincipal.add(MostrarImagen);
        aleatorio = new Random();
        GenerarMostrarBotonesAbajo();
        GenerarMostrarBotonesArriba();
        reiniciar_jugador_libre();

        VentaPrincipal.add(PanelPrincipal);
        VentaPrincipal.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                try {
                    reiniciar_jugador_libre();
                    System.exit(0);
                } catch (SQLException ex) {
                    Logger.getLogger(Interfaz1.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        VentaPrincipal.setVisible(true);
    }

    public void reiniciar_jugador_libre() throws SQLException {
        cn = ConexionBD.conexion();
        String consulta_reniciar = "DELETE FROM juego WHERE id_usuario=" + id_usuario + "";
        PreparedStatement preparedStmt = cn.prepareStatement(consulta_reniciar);
        preparedStmt.execute();
        cn.close();
    }

    public static void txt() {

        txtConcepto = new JTextArea();
        txtConcepto.setFont(new Font("Arial", Font.BOLD, 20));
        txtConcepto.setEditable(false);
        txtConcepto.setLineWrap(true);
        txtConcepto.setWrapStyleWord(true);
        txtConcepto.setBounds(533, 60, 300, 365);
        txtConcepto.setOpaque(true);
        txtConcepto.setBackground(new Color(120, 175, 170, 100));
        txtConcepto.setBorder(new javax.swing.border.MatteBorder(5, 5, 5, 5, Color.DARK_GRAY));
        PanelPrincipal.add(txtConcepto);

        lbPuntaje = new JLabel();
        lbPuntaje.setBounds(820, 25, 100, 35);
        lbPuntaje.setForeground(Color.WHITE);
        lbPuntaje.setText("0");
        PanelPrincipal.add(lbPuntaje);

        lbUsuario = new JLabel();
        lbUsuario.setBounds(980, 2, 270, 35);
        lbUsuario.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        lbUsuario.setForeground(Color.WHITE);
        lbUsuario.setVisible(false);
        PanelPrincipal.add(lbUsuario);

        lbIconUser = new JLabel(new ImageIcon("C:\\Users\\Jhon\\Documents\\NetBeansProjects\\JuegoCalidad\\src\\imagenes\\iconUser.png"));
        lbIconUser.setBounds(920, 25, 35, 30);
        lbIconUser.setBorder(new javax.swing.border.MatteBorder(1, 1, 1, 0, Color.GRAY));
        lbIconUser.setOpaque(true);
        lbIconUser.setBackground(new Color(231, 236, 233));
        txtUser = new JTextField();
        txtUser.setBorder(new javax.swing.border.MatteBorder(1, 1, 1, 1, Color.GRAY));
        txtUser.setBounds(955, 25, 140, 30);
        phuser = new PlaceHolder(txtUser, new Color(161, 154, 155), new Color(101, 102, 99), "Usuario", false, "SansSerif", 15);
        PanelPrincipal.add(lbIconUser);
        PanelPrincipal.add(txtUser);

        lbIconPass = new JLabel(new ImageIcon("C:\\Users\\Jhon\\Documents\\NetBeansProjects\\JuegoCalidad\\src\\imagenes\\iconPass.png"));
        lbIconPass.setBounds(1100, 25, 35, 30);
        lbIconPass.setBorder(new javax.swing.border.MatteBorder(1, 1, 1, 0, Color.GRAY));
        lbIconPass.setOpaque(true);
        lbIconPass.setBackground(new Color(231, 236, 233));
        txtPass = new JPasswordField();
        txtPass.setBorder(new javax.swing.border.MatteBorder(1, 1, 1, 1, Color.GRAY));
        txtPass.setBounds(1135, 25, 140, 30);
        phpass = new PlaceHolder(txtPass, new Color(161, 154, 155), new Color(101, 102, 99), "Clave", false, "SansSerif", 15);
        txtPass.setEchoChar((char) 0);
        txtPass.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (txtPass.getForeground().equals(new Color(101, 102, 99))) {
                    txtPass.setEchoChar('*');
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (txtPass.getText().length() == 0) {
                    txtPass.setEchoChar((char) 0);
                }
            }
        });
        PanelPrincipal.add(lbIconPass);
        PanelPrincipal.add(txtPass);

        lbCrearCuenta = new JLabel();
        lbCrearCuenta.setBounds(1120, 70, 150, 35);
        lbCrearCuenta.setText("REGISTRATE AQUI");
        lbCrearCuenta.setForeground(new Color(125, 195, 42));
        lbCrearCuenta.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        lbCrearCuenta.addMouseListener(new BotonLogin() {
        });
        PanelPrincipal.add(lbCrearCuenta);

        lbError = new JLabel();
        lbError.setBounds(920, 55, 200, 35);
        lbError.setForeground(Color.WHITE);
        PanelPrincipal.add(lbError);

        btnSalir = new JButton();
        btnSalir.setBounds(1260, 2, 85, 35);
        btnSalir.setBackground(Color.BLACK);
        btnSalir.setForeground(Color.WHITE);
        btnSalir.setVisible(false);
        btnSalir.setFont(new Font("Arial", Font.BOLD, 16));
        btnSalir.setText("SALIR");
        btnSalir.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        PanelPrincipal.add(btnSalir);

        btnLogin = new JButton();
        btnLogin.setBounds(1290, 25, 50, 30);
        btnLogin.setBackground(Color.BLACK);
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFont(new Font("Arial", Font.BOLD, 16));
        btnLogin.setText("IR");
        btnLogin.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!(txtUser.getText().equals("Usuario") && txtUser.getForeground().equals(new Color(161, 154, 155)))
                        && !(txtPass.getText().equals("Contraseña") && txtPass.getForeground().equals(new Color(161, 154, 155)))) {

                    try {
                        String sql = "SELECT *FROM usuario WHERE nombre_usuario='" + txtUser.getText() + "' AND password_usuario='" + txtPass.getText() + "'";
                        st = cn.createStatement();
                        rs = st.executeQuery(sql);

                        if (rs.next()) {
                            PanelPrincipal.removeAll();
                            PanelPrincipal.repaint();
                            id_usuario = rs.getInt("id_usuario");

                            GenerarMostrarBotonesAbajo();
                            GenerarMostrarBotonesArriba();
                            sql = "SELECT j.nombre_jugador, j.apellidopaterno_jugador, j.apellidomaterno_jugador FROM usuario u INNER JOIN jugador j ON u.id_jugador=j.id_jugador WHERE u.id_usuario=" + rs.getInt("id_usuario") + "";
                            st_datosJugador = cn.createStatement();
                            rs_datosJugador = st_datosJugador.executeQuery(sql);
                            if (rs_datosJugador.next()) {
                                System.out.println("HOLA");
                                lbUsuario.setText("JUGADOR: " + rs_datosJugador.getString(1) + " " + rs_datosJugador.getString(2) + " " + rs_datosJugador.getString(3));
                                lbUsuario.setVisible(true);
                                btnSalir.setVisible(true);
                                lbIconPass.setVisible(false);
                                lbIconUser.setVisible(false);
                                txtPass.setVisible(false);
                                txtUser.setVisible(false);
                                lbCrearCuenta.setVisible(false);
                                btnLogin.setVisible(false);
                            }

                        } else {
                            lbError.setText("Usuario y/o contraseña inválidos!");
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
                if (txtUser.getText().equals("Usuario") && txtUser.getForeground().equals(new Color(161, 154, 155))) {
                    mostrar_usererror("C:\\Users\\Jhon\\Documents\\NetBeansProjects\\JuegoCalidad\\src\\imagenes\\error_iconuser.png", new Color(230, 205, 206), new Color(170, 84, 79), 0);
                } else {
                    mostrar_usererror("C:\\Users\\Jhon\\Documents\\NetBeansProjects\\JuegoCalidad\\src\\imagenes\\iconUser.png", new Color(231, 236, 233), Color.GRAY, 1);
                }

                if (txtPass.getText().equals("Clave") && txtPass.getForeground().equals(new Color(161, 154, 155))) {
                    mostrar_passerror("C:\\Users\\Jhon\\Documents\\NetBeansProjects\\JuegoCalidad\\src\\imagenes\\error_iconpassword.png", new Color(230, 205, 206), new Color(170, 84, 79), 0);
                } else {
                    mostrar_passerror("C:\\Users\\Jhon\\Documents\\NetBeansProjects\\JuegoCalidad\\src\\imagenes\\iconPass.png", new Color(231, 236, 233), Color.GRAY, 1);
                }
            }
        });
        PanelPrincipal.add(btnLogin);
    }

    public static void GenerarMostrarBotonesAbajo() throws SQLException {
        txt();
        //generando botones
        String consulta;
        puntaje = 0;
        codigos = new LinkedList<>();
        cod = new ArrayList<>();
        consultasql = "SELECT * FROM juego WHERE id_usuario= " + id_usuario + "";
        cn = ConexionBD.conexion();
        Statement st = cn.createStatement();
        Statement stt = cn.createStatement();
        Statement st_codigo = cn.createStatement();
        ResultSet rs = st.executeQuery(consultasql);

        consulta = "SELECT * FROM caracteristica";
        ResultSet rs_caracteristica = stt.executeQuery(consulta);
        while (rs.next()) {
            codigos.add(rs.getInt("idcaracteristica"));
            puntaje += rs.getDouble("puntaje_juego");
        }
        lbPuntaje.setText(String.valueOf(puntaje));
        while (rs_caracteristica.next()) {
            codigos.add(rs_caracteristica.getInt("idcaracteristica"));
        }

        Set<Integer> codigosNoRepetidas = new HashSet<>();
        codigos.stream().filter((o) -> (codigos.indexOf(o) == codigos.lastIndexOf(o))).forEachOrdered((o) -> {
            codigosNoRepetidas.add(o);
        });
        cod.addAll(codigosNoRepetidas);

        consulta = "SELECT *FROM caracteristica WHERE idcaracteristica= " + (cod.get(aleatorio.nextInt(cod.size()))) + "";
        ResultSet rs_codigo = st_codigo.executeQuery(consulta);

        if (rs_codigo.next()) {
            txtConcepto.setText(rs_codigo.getString("conceptocaracteristica"));
            respuesta = rs_codigo.getString("nombrecaracteristica");
        }

        ControladorAbajo = new ControllerButtonsDown();
        letrasAbajo = respuesta.split("");
        letrasAbajoConfundir = LetrasConfundir.split("");
        int s = 0;
        for (int i = 0; i < (letrasAbajo.length + 5); i++) {
            btnLetra = new JButton("");
            ControladorAbajo.AgregarBotones(btnLetra);
        }

        for (int i = 0; i < ControladorAbajo.indice; i++) {

            if (s < letrasAbajo.length) {
                int aleat = aleatorio.nextInt(ControladorAbajo.indice);
                if (ControladorAbajo.botones[aleat].getText().equals("")) {
                    ControladorAbajo.botones[aleat].setText(letrasAbajo[s]);
                    s++;
                } else {
                    i = i - 1;
                }

            } else {
                for (int j = 0; j < ControladorAbajo.indice; j++) {
                    if (ControladorAbajo.botones[j].getText().equals("")) {
                        ControladorAbajo.botones[j].setText(letrasAbajoConfundir[aleatorio.nextInt(letrasAbajoConfundir.length)]);
                    }

                }

            }

        }

        //mostrando botones
        int separar = 0;
        int sepY = 530;
        for (int i = 0; i < ControladorAbajo.indice; i++) {
            if (i == 12) {
                sepY = 580;
                separar = 0;
            }
            if (i == 24) {
                sepY = 630;
                separar = 0;
            }
            ControladorAbajo.botones[i].setBounds(400 + separar, sepY, 45, 40);
            ControladorAbajo.botones[i].setBackground(new Color(227, 228, 230));
            ControladorAbajo.botones[i].setForeground(new Color(53, 53, 54));
            ControladorAbajo.botones[i].setBorder(new javax.swing.border.BevelBorder(1, Color.GRAY, new Color(199, 200, 204)));
            ControladorAbajo.botones[i].setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            ControladorAbajo.botones[i].addActionListener(new BotonPulsadoAbajoListener());
            ControladorAbajo.botones[i].setName("btn" + i);

            PanelPrincipal.add(ControladorAbajo.botones[i]);
            VentaPrincipal.add(PanelPrincipal);
            separar += 48;

        }

    }

    public static void GenerarMostrarBotonesArriba() {
        ControladorArriba = new ControllerButtonsUp();
        for (int i = 0; i < respuesta.length(); i++) {
            btnLetra = new JButton("");
            ControladorArriba.AgregarBotones(btnLetra);

        }

        int separar = 0;
        for (int i = 0; i < ControladorArriba.indice; i++) {
            ControladorArriba.botones[i].setBounds(40 + separar, 445, 45, 40);
            ControladorArriba.botones[i].setBackground(new Color(48, 75, 123));
            ControladorArriba.botones[i].setBorder(new javax.swing.border.BevelBorder(1, Color.GREEN, new Color(87, 137, 88)));
            ControladorArriba.botones[i].setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

            ControladorArriba.botones[i].addActionListener(new BotonPulsadoArribaListener());
            ControladorArriba.botones[i].setName("btn" + i);

            PanelPrincipal.add(ControladorArriba.botones[i]);
            VentaPrincipal.add(PanelPrincipal);

            separar += 48;
        }
    }

    public static void mostrar_usererror(String icon, Color colorfondo, Color colorborder, int valor) {
        lbIconUser.setIcon(new ImageIcon(icon));
        lbIconUser.setBackground(colorfondo);
        lbIconUser.setBorder(new javax.swing.border.MatteBorder(1, 1, 1, 0, colorborder));
        txtUser.setBorder(new javax.swing.border.MatteBorder(1, 1, 1, 1, colorborder));
    }

    public static void mostrar_passerror(String icon, Color colorfondo, Color colorborder, int valor) {
        lbIconPass.setIcon(new ImageIcon(icon));
        lbIconPass.setBackground(colorfondo);
        lbIconPass.setBorder(new javax.swing.border.MatteBorder(1, 1, 1, 0, colorborder));
        txtPass.setBorder(new javax.swing.border.MatteBorder(1, 1, 1, 1, colorborder));
    }

    public static void main(String[] args) throws SQLException {
        Interfaz1 interfaz = new Interfaz1();
    }
}
