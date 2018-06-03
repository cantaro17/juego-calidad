/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import com.mysql.jdbc.PreparedStatement;
import com.placeholder.PlaceHolder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JPopupMenu.Separator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import modelo.ConexionBD;

/**
 *
 * @author Jhon
 */
public class login extends JFrame {

    //contenedores
    JPanel form;

    //componentes
    JTextField txtuser, txtverificar;
    JTextArea txterror, txtvacio;
    JPasswordField password;
    JComboBox<Object> combobox;
    JLabel etiqueta;
    Icon iconcabecera, iconuser, iconpassword, iconingresar, iconvacio, iconerror;
    JLabel lbfondo, lbsistema, lbverificar, lbuniversidad, lbautor;
    JLabel iconUser, iconPass, iconSelect, iconConfirm;
    JButton btningresar;
    Separator separador_superior, separador_inferior;

    //componentes para captcha
    JLabel lbvacio, lberror;
    Random aleatorio = new Random();

    //placeholder
    PlaceHolder phuser, phpass, phver;
    PlaceHolder phuser, phpass, phver;

    //cambio de imagen
    Calendar calendario;
    Thread h1;

    float x_frame, x_form_frame = 1366, width_frame;
    float x_form, width_form;

    String texto_vacio = "";
    int alturaVacio = 195;
       String texto_vacio = "";
    int alturaVacio = 195;

    int validarCaptcha;
    int t1, t2, t3;
    String texto_user, texto_password, texto_verificar;
    String codigo;
    String[] lines;

    int altura_btningresar = 195;
    int altura_lbvacio = 0;

    Connection cn = ConexionBD.conexion();
    Statement st;
    ResultSet rs;

    public login() {

        setSize(370, 370);
        setLayout(null);
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(370, 370));

        lberror = new JLabel();
        lbvacio = new JLabel();
        lbvacio.setBackground(new Color(236, 0, 0, 20));

        lbsistema = new JLabel("Sistema de Gestión Académica");
        lbsistema.setForeground(Color.WHITE);
        lbsistema.setFont(new Font("Calibri", Font.PLAIN, 25));
        lbsistema.setBounds(525, 50, 370, 50);
        form = new JPanel();
        form.setLayout(null);
        form.setBackground(new Color(243, 250, 248));
        form.setBounds(0, 0, 370, 370);

        iconcabecera = new ImageIcon(getClass().getResource("/imagenes/iconcabecera.png"));
        etiqueta = new JLabel("Iniciar Sesión");
        etiqueta.setFont(new Font("Arial", Font.PLAIN, 25));
        etiqueta.setBounds(100, 20, 299, 30);
        etiqueta.setForeground(new Color(61, 131, 203));
        etiqueta.setIcon(iconcabecera);
        form.add(etiqueta);

        separador_superior = new Separator();
        separador_superior.setBounds(0, 70, form.getWidth() + 10, 2);
        separador_superior.setBackground(new Color(221, 216, 219));
        form.add(separador_superior);

        iconuser = new ImageIcon(getClass().getResource("/imagenes/iconUser.png"));
        iconUser = new JLabel();
        iconUser.setBorder(new javax.swing.border.MatteBorder(1, 1, 1, 0, Color.GRAY));
        iconUser.setOpaque(true);
        iconUser.setBounds(27, 85, 50, 39);
        iconUser.setBackground(new Color(231, 236, 233));
        iconUser.setIcon(iconuser);
        iconUser.setHorizontalAlignment(0);
        txtuser = new JTextField();
        txtuser.setBounds(77, 85, 250, 39);
        phuser = new PlaceHolder(txtuser, new Color(161, 154, 155), new Color(101, 102, 99), "Usuario", false, "SansSerif", 17);
        form.add(iconUser);
        form.add(txtuser);

        iconpassword = new ImageIcon(getClass().getResource("/imagenes/iconPass.png"));
        iconPass = new JLabel();
        iconPass.setBorder(new javax.swing.border.MatteBorder(1, 1, 1, 0, Color.GRAY));
        iconPass.setOpaque(true);
        iconPass.setBackground(new Color(231, 236, 233));
        iconPass.setBounds(27, 140, 50, 39);
        iconPass.setIcon(iconpassword);
        iconPass.setHorizontalAlignment(0);
        password = new JPasswordField();
        password.setBounds(77, 140, 250, 39);

        phpass = new PlaceHolder(password, new Color(161, 154, 155), new Color(101, 102, 99), "Contraseña", false, "SansSerif", 17);
        password.setEchoChar((char) 0);
        password.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (password.getForeground().equals(new Color(101, 102, 99))) {
                    password.setEchoChar('*');
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (password.getText().length() == 0) {
                    password.setEchoChar((char) 0);
                }
            }
        });
        form.add(iconPass);
        form.add(password);

        iconingresar = new ImageIcon(getClass().getResource("/imagenes/iconingresar.png"));
        btningresar = new JButton("Ingresar");
        btningresar.setFont(new Font("inherit", Font.BOLD, 16));
        btningresar.setBackground(new Color(51, 119, 177));
        btningresar.setForeground(Color.WHITE);
        btningresar.setBounds(27, altura_btningresar, 300, 40);
        btningresar.setHorizontalTextPosition(2);
        btningresar.setIcon(iconingresar);
        form.add(btningresar);

        separador_inferior = new Separator();
        separador_inferior.setBackground(new Color(221, 216, 219));
        form.add(separador_inferior);

        lbuniversidad = new JLabel("Universidad Nacional Agraria de la Selva");
        lbuniversidad.setForeground(new Color(63, 131, 210));
        form.add(lbuniversidad);

        lbautor = new JLabel("Hecho por: programmer");
        lbautor.setForeground(new Color(63, 131, 210));
        form.add(lbautor);

        add(lbsistema);
        add(form);

        btningresar.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                texto_vacio = "";
                if (!(txtuser.getText().equals("Usuario") && txtuser.getForeground().equals(new Color(161, 154, 155)))
                        && !(password.getText().equals("Contraseña") && password.getForeground().equals(new Color(161, 154, 155)))) {

                    try {
                        String sql = "SELECT *FROM usuario WHERE nombre_usuario='" + txtuser.getText() + "' AND password_usuario='" + password.getText() + "'";
                        st = cn.createStatement();
                        rs = st.executeQuery(sql);

                        if (rs.next()) {
                            Interfaz.id_usuario=rs.getInt("id_usuario");
                            Interfaz.PanelPrincipal.removeAll();
                            Interfaz.PanelPrincipal.repaint();
                            Interfaz.GenerarMostrarBotonesAbajo();
                            Interfaz.GenerarMostrarBotonesArriba();
                            
                            dispose();
                        } else {
                            activar_desactivar(false, true);
                            mostrar_error("Usuario y/o contraseña invalidos!");

                            modificar_altura(255, 45);
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else {
                    activar_desactivar(true, false);
                }
                if (txtuser.getText().equals("Usuario") && txtuser.getForeground().equals(new Color(161, 154, 155))) {
                    mostrar_usererror("/imagenes/error_iconuser.png", new Color(230, 205, 206), new Color(170, 84, 79), 0);
                } else {
                    mostrar_usererror("/imagenes/iconUser.png", new Color(231, 236, 233), Color.GRAY, 1);
                }

                if (password.getText().equals("Contraseña") && password.getForeground().equals(new Color(161, 154, 155))) {
                    mostrar_passerror("/imagenes/error_iconpassword.png", new Color(230, 205, 206), new Color(170, 84, 79), 0);
                } else {
                    mostrar_passerror("/imagenes/iconpassword.png", new Color(231, 236, 233), Color.GRAY, 1);
                }

                String sep1, sep2;
                if (t1 == 0) {
                    texto_user = "Debe ingresar su nombre de usuario.";
                    sep1 = "<br>";

                } else {
                    texto_user = "";
                    sep1 = "";
                }
                if (t2 == 0) {
                    texto_password = "Debe ingresar su contraseña.";
                    sep2 = "<br>";
                } else {
                    texto_password = "";
                    sep2 = "";
                }

                if (t1 == 0 && t2 == 0) {
                    modificar_altura(270, 60);
                } else if (t1 == 0 || t2 == 0) {
                    modificar_altura(255, 45);
                }

                texto_vacio = "<html><font size=+0>Campos Vacios:</font><br>" + texto_user + "" + sep1 + "" + texto_password + "</html>";

                form.setBounds(0, 0, 370, 370);
                btningresar.setBounds((int) (27 - x_form), altura_btningresar, 300, 40);

                iconvacio = new ImageIcon(getClass().getResource("/imagenes/iconvacio.png"));
                lbvacio.setBounds(27, alturaVacio, 300, altura_lbvacio);
                lbvacio.setIcon(iconvacio);
                lbvacio.setText(texto_vacio);
                lbvacio.setForeground(new Color(149, 121, 73));
                lbvacio.setBorder(new javax.swing.border.MatteBorder(1, 1, 1, 1, new Color(237, 222, 194)));
                form.add(lbvacio);
            }
        }));

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {

                dispose();

            }
        });

    }

    public void modificar_altura(int alt_btningresar, int alt_lbvacio) {
        altura_btningresar = alt_btningresar;
        altura_lbvacio = alt_lbvacio;
    }

    public void mostrar_usererror(String icon, Color colorfondo, Color colorborder, int valor) {
        iconuser = new ImageIcon(getClass().getResource(icon));
        iconUser.setIcon(iconuser);
        iconUser.setBackground(colorfondo);
        iconUser.setBorder(new javax.swing.border.MatteBorder(1, 1, 1, 0, colorborder));
        txtuser.setBorder(new javax.swing.border.MatteBorder(1, 1, 1, 1, colorborder));
        t1 = valor;
    }

    public void mostrar_passerror(String icon, Color colorfondo, Color colorborder, int valor) {
        iconpassword = new ImageIcon(getClass().getResource(icon));
        iconPass.setIcon(iconpassword);
        iconPass.setBackground(colorfondo);
        iconPass.setBorder(new javax.swing.border.MatteBorder(1, 1, 1, 0, colorborder));
        password.setBorder(new javax.swing.border.MatteBorder(1, 1, 1, 1, colorborder));
        t2 = valor;
    }

    public void mostrar_error(String error) {
        iconerror = new ImageIcon(getClass().getResource("/imagenes/iconerror.png"));

        lberror.setBounds(27, 195, 300, 45);
        lberror.setIcon(iconerror);
        lberror.setForeground(new Color(149, 121, 73));
        lberror.setBackground(new Color(229, 210, 210));
        lberror.setOpaque(true);
        lberror.setBorder(new javax.swing.border.MatteBorder(1, 1, 1, 1, new Color(235, 205, 207)));
        lberror.setText("<html><font size=+0>Error:</font><br>" + error + "</html>");
        form.add(lberror);
    }

    public void activar_desactivar(boolean vacio, boolean error) {
        lbvacio.setVisible(vacio);
        lberror.setVisible(error);
    }

    public static void open_close(boolean opcion) {
        new login().setVisible(opcion);
    }

    public static void main(String[] args) {
        open_close(true);
    }

}
