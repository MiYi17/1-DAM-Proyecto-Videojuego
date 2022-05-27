package shooter2d;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Menu extends JPanel implements ActionListener {
    Frame a;
    Principal p;

    JButton btnFacil;
    JButton btnNormal;
    JButton btnDificil;
    JButton btnSalir;

    JLabel lblFondo;
    JLabel lblTanque;
    JLabel lblZombie;

    Timer temporizadorTanque;

    int xTanque;
    int xZombie;

    // IMAGEN BOTON FACIL
    ImageIcon icono = new ImageIcon(Menu.class.getResource("/shooter2d/img/dificultadFacil.png"));
    Image conversion = icono.getImage();
    Image tamaño = conversion.getScaledInstance(450, 130, Image.SCALE_SMOOTH);
    ImageIcon imgPre = new ImageIcon(tamaño);

    ImageIcon icono2 = new ImageIcon(Menu.class.getResource("/shooter2d/img/dificultadFacilPulsado.png"));
    Image conversion2 = icono2.getImage();
    Image tamaño2 = conversion2.getScaledInstance(450, 130, Image.SCALE_SMOOTH);
    ImageIcon imgPre2 = new ImageIcon(tamaño2);

    // IMAGEN BOTON NORMAL
    ImageIcon iconoNormal = new ImageIcon(Menu.class.getResource("/shooter2d/img/dificultadNormal.png"));
    Image conversionNormal = iconoNormal.getImage();
    Image tamañoNormal = conversionNormal.getScaledInstance(450, 130, Image.SCALE_SMOOTH);
    ImageIcon imgPreNormal = new ImageIcon(tamañoNormal);

    ImageIcon iconoNormal2 = new ImageIcon(Menu.class.getResource("/shooter2d/img/dificultadNormalPulsado.png"));
    Image conversionNormal2 = iconoNormal2.getImage();
    Image tamañoNormal2 = conversionNormal2.getScaledInstance(450, 130, Image.SCALE_SMOOTH);
    ImageIcon imgPreNormal2 = new ImageIcon(tamañoNormal2);

    // IMAGEN BOTON DIFICIL
    ImageIcon iconoDificil = new ImageIcon(Menu.class.getResource("/shooter2d/img/dificultadDificil.png"));
    Image conversionDificil = iconoDificil.getImage();
    Image tamañoDificil = conversionDificil.getScaledInstance(450, 130, Image.SCALE_SMOOTH);
    ImageIcon imgPreDificil = new ImageIcon(tamañoDificil);

    ImageIcon iconoDificil2 = new ImageIcon(Menu.class.getResource("/shooter2d/img/dificultadDificilPulsado.png"));
    Image conversionDificil2 = iconoDificil2.getImage();
    Image tamañoDificil2 = conversionDificil2.getScaledInstance(450, 130, Image.SCALE_SMOOTH);
    ImageIcon imgPreDificil2 = new ImageIcon(tamañoDificil2);

    // IMAGEN TANQUE FONDO
    ImageIcon iconoTanque = new ImageIcon(Menu.class.getResource("/shooter2d/img/tanque.png"));
    Image conversionTanque = iconoTanque.getImage();
    Image tamañoTanque = conversionTanque.getScaledInstance(550, 330, Image.SCALE_SMOOTH);
    ImageIcon imgPreTanque = new ImageIcon(tamañoTanque);

    // GIF ZOMBIE FONDO
    // ImageIcon iconoZombie = new ImageIcon(Menu.class.getResource("/shooter2d/img/zombieMenu.gif"));
    // Image conversionZombie = iconoZombie.getImage();
    // Image tamañoZombie = conversionZombie.getScaledInstance(450, 230, Image.SCALE_SMOOTH);
    ImageIcon imgPreZombie = new ImageIcon(Menu.class.getResource("/shooter2d/img/zombieMenu.gif"));


    // IMAGEN SALIR
    ImageIcon iconoSalir = new ImageIcon(Menu.class.getResource("/shooter2d/img/salir.png"));
    Image conversionSalir = iconoSalir.getImage();
    Image tamañoSalir = conversionSalir.getScaledInstance(120, 100, Image.SCALE_SMOOTH);
    ImageIcon imgPreSalir = new ImageIcon(tamañoSalir);

    public Menu(Frame a) {
        this.a = a;
        setLayout(null);
        this.setBackground(Color.black);

        // btnFacil
        btnFacil = new JButton();
        btnFacil.setSize(550, 130);
        btnFacil.setLocation(685, 330);

        btnFacil.setIcon(imgPre);
        btnFacil.setFocusPainted(false);
        btnFacil.setBorderPainted(false);
        btnFacil.setContentAreaFilled(false);
        btnFacil.addMouseListener(new ManejadorRaton());
        btnFacil.addActionListener(this);
        add(btnFacil);

        // btnNormal
        btnNormal = new JButton();
        btnNormal.setSize(550, 130);
        btnNormal.setLocation(685, 480);

        btnNormal.setIcon(imgPreNormal);
        btnNormal.setFocusPainted(false);
        btnNormal.setBorderPainted(false);
        btnNormal.setContentAreaFilled(false);
        btnNormal.addMouseListener(new ManejadorRaton());
        btnNormal.addActionListener(this);
        add(btnNormal);

        // btnDificil
        btnDificil = new JButton();
        btnDificil.setSize(550, 130);
        btnDificil.setLocation(685, 630);

        btnDificil.setIcon(imgPreDificil);
        btnDificil.setFocusPainted(false);
        btnDificil.setBorderPainted(false);
        btnDificil.setContentAreaFilled(false);
        btnDificil.addMouseListener(new ManejadorRaton());
        btnDificil.addActionListener(this);
        add(btnDificil);

        // btnSalir
        btnSalir = new JButton();
        btnSalir.setSize(120,100);
        btnSalir.setLocation(1790, 15);
        btnSalir.setIcon(imgPreSalir);
        btnSalir.setFocusPainted(false);
        btnSalir.setBorderPainted(false);
        btnSalir.setContentAreaFilled(false);
        btnSalir.addActionListener(this);
        add(btnSalir);

        // lblTanque
        lblTanque = new JLabel();
        lblTanque.setSize(550, 330);
        lblTanque.setLocation(-550, 783);
        lblTanque.setIcon(imgPreTanque);
        add(lblTanque);

        // lblZombie
        lblZombie = new JLabel(imgPreZombie);
        lblZombie.setSize(170, 370);
        lblZombie.setLocation(-830, 725);
        // lblZombie.setIcon(imgPreZombie);
        add(lblZombie);

        // lblFondo
        lblFondo = new JLabel();
        lblFondo.setSize(1920, 1080);
        lblFondo.setVisible(true);

        ImageIcon iconoFondo = new ImageIcon(Menu.class.getResource("/shooter2d/img/fondoMenu.jpg"));
        Image conversionFondo = iconoFondo.getImage();
        Image tamañoFondo = conversionFondo.getScaledInstance(1920, 1080, Image.SCALE_SMOOTH);
        ImageIcon imgPreFondo = new ImageIcon(tamañoFondo);

        lblFondo.setIcon(imgPreFondo);
        add(lblFondo);

        temporizadorTanque = new Timer(30, this);
        temporizadorTanque.start();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == temporizadorTanque) {
            if (xTanque >= 1940) {
                lblTanque.setLocation(-550, lblTanque.getY());
            }

            xTanque = lblTanque.getX();
            xTanque += 2;
            lblTanque.setLocation(xTanque, lblTanque.getY());

            if (xZombie > 1940) {
                lblZombie.setLocation(-550, lblZombie.getY());
            }

            xZombie = lblZombie.getX();
            xZombie += 2;
            lblZombie.setLocation(xZombie, lblZombie.getY());
        }

        if (e.getSource() == btnFacil) {
            p = new Principal(a,0);
            p.setSize(1920, 1080);
            p.setVisible(false);
            a.add(p);
            p.setVisible(true);
            this.setVisible(false);   
        }
        
        if (e.getSource() == btnNormal) {
            p = new Principal(a,1);
            p.setSize(1920, 1080);
            p.setVisible(false);
            a.add(p);
            p.setVisible(true);
            this.setVisible(false);
        }

        if (e.getSource() == btnDificil) {
            p = new Principal(a,2);
            p.setSize(1920, 1080);
            p.setVisible(false);
            a.add(p);
            p.setVisible(true);
            this.setVisible(false);
        }


        // if (e.getSource().getClass() == JButton.class) {
        //     if (e.getSource() != btnSalir) {
        //         p = new Principal(a);
        //         p.setSize(1920, 1080);
        //         p.setVisible(false);
        //         a.add(p);
        //         p.setVisible(true);
        //         this.setVisible(false);

        //         if (e.getSource() == btnFacil) {
        //             p.flagFacil = true;
        //         }
        //     }
        // }

        if (e.getSource() == btnSalir) {
            System.exit(1);
        }

    }

    private class ManejadorRaton extends MouseAdapter {
        @Override
        public void mouseEntered(MouseEvent e) {

            if (e.getSource() == btnFacil) {
                btnFacil.setIcon(imgPre2);
            }

            if (e.getSource() == btnNormal) {
                btnNormal.setIcon(imgPreNormal2);
            }

            if (e.getSource() == btnDificil) {
                btnDificil.setIcon(imgPreDificil2);
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (e.getSource() == btnFacil) {
                btnFacil.setIcon(imgPre);
            }

            if (e.getSource() == btnNormal) {
                btnNormal.setIcon(imgPreNormal);
            }

            if (e.getSource() == btnDificil) {
                btnDificil.setIcon(imgPreDificil);
            }
        }
    }

}
