package shooter2d;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Principal extends JPanel implements ActionListener {
    JLabel lblFondo;
    Personaje personaje;
    Zombie zombie;
    Bala bala;
    JButton botonPrueba;
    CrearBala crearbala;
    JLabel lblSangre;

    Frame a;

    // Boolean flagSentidoZombie;

    Timer temporizadorAparecerZombie;

    int localizacionZombie;
    int cantidadZombies;

    public Principal(Frame a) {
        setLayout(null);
        this.a = a;

        // imagenesSangre
        for (int i = 1; i <= 10; i++) {
            ImageIcon imagenSangre = new ImageIcon(Principal.class.getResource("/shooter2d/img/sangre" + i + ".png"));
            Image conversionSangre = imagenSangre.getImage();
            Image pasadoSangre = conversionSangre.getScaledInstance(100, 100, Image.SCALE_REPLICATE);
            ImageIcon iconoSangre = new ImageIcon(pasadoSangre);
        }

        // FondoJuego
        ImageIcon imagenFondo = new ImageIcon(Principal.class.getResource("/shooter2d/img/fondo.jpg"));
        Image conversionFondo = imagenFondo.getImage();
        Image pasadoFondo = conversionFondo.getScaledInstance(1920, 1080, Image.SCALE_REPLICATE);
        ImageIcon iconoFondo = new ImageIcon(pasadoFondo);

        // Personaje
        personaje = new Personaje(this);
        personaje.setSize(210, 240);
        personaje.setLocation(300, 650);
        // System.err.println("Fondo: " + personaje.getComponentCount());
        // personaje.setIcon(personaje.iconoPersonaje);
        add(personaje);

        // lblFondo
        lblFondo = new JLabel();
        lblFondo.setSize(1920, 1080);
        lblFondo.setLocation(0, 0);
        lblFondo.setIcon(iconoFondo);
        // System.err.println("Fondo: " + lblFondo.getComponentCount());
        add(lblFondo);

        a.addKeyListener(new ManejadorTeclado());
        a.addMouseListener(new ManejadorRaton());

        crearbala = new CrearBala(this);
        add(crearbala);

        temporizadorAparecerZombie = new Timer(1500, this);
        temporizadorAparecerZombie.start();
    }

    // ===================================================================
    // INNER CLASS MANEJADOR DE EVENTOS DE TECLADO
    // ===================================================================
    private class ManejadorTeclado extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_D && personaje.flagDisparo) {
                personaje.flagDerecha = true;
            }
            if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_A && personaje.flagDisparo) {
                personaje.flagIzquierda = true;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_D) {
                personaje.flagDerecha = false;
            }
            if (e.getKeyCode() == KeyEvent.VK_A) {
                personaje.flagIzquierda = false;
            }

        }
    }

    // ===================================================================
    // INNER CLASS MANEJADOR DE EVENTOS DE RATON
    // ===================================================================
    private class ManejadorRaton extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            if (personaje.getIcon() == personaje.iconoPersonaje) {
                personaje.setIcon(personaje.iconoPersonajeDisparo);
            }

            if (personaje.getIcon() == personaje.iconoPersonajeVuelta) {
                personaje.setIcon(personaje.iconoPersonajeDisparoVuelta);
            }
            crearbala.crearBala();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if (e.getButton() == 1) {
                personaje.flagDisparo = false;
                if (personaje.getIcon() == personaje.iconoPersonajeDisparo) {
                    personaje.setIcon(personaje.iconoPersonaje);
                }

                if (personaje.getIcon() == personaje.iconoPersonajeDisparoVuelta) {
                    personaje.setIcon(personaje.iconoPersonajeVuelta);
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == temporizadorAparecerZombie) {

            localizacionZombie = (int) (Math.random() * 2);

            zombie = new Zombie(Principal.this);
            zombie.setSize(130, 210);
            if (localizacionZombie == 1) {
                zombie.setLocation(-100, 670);
                zombie.setIcon(zombie.iconoZombie);
                // flagSentidoZombie = false;
            } else if (localizacionZombie == 0) {
                zombie.setLocation(1900, 670);
                zombie.setIcon(zombie.iconoZombieVuelta);
                // flagSentidoZombie = true;
            }
            Principal.this.add(zombie, 1);
        }
    }
}
