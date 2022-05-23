package shooter2d;

import java.awt.Image;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Principal extends JFrame {
    JLabel lblFondo;
    Personaje personaje;
    Zombie zombie;
    Bala bala;

    public Principal() {
        super("Shooter 2D");
        setLayout(null);

        // FondoJuego
        ImageIcon imagenFondo = new ImageIcon(Principal.class.getResource("/shooter2d/img/fondo.jpg"));
        Image conversionFondo = imagenFondo.getImage();
        Image pasadoFondo = conversionFondo.getScaledInstance(1920, 1080, Image.SCALE_REPLICATE);
        ImageIcon iconoFondo = new ImageIcon(pasadoFondo);



        // Zombie
        zombie = new Zombie(this);
        zombie.setSize(130,210);
        zombie.setLocation(1600,670);
        add(zombie);

        
        // Personaje
        personaje = new Personaje(this);
        personaje.setSize(210, 240);
        personaje.setLocation(300, 650);
        // personaje.setIcon(personaje.iconoPersonaje);
        add(personaje);
       
        // Bala
        bala = new Bala(this);
        bala.setSize(14,4);  
        bala.setLocation(personaje.getX()+200,personaje.getY()+75);
        // bala.setLocation(1400,400);
        add(bala);
        
        // lblFondo
        lblFondo = new JLabel();
        lblFondo.setSize(1920, 1080);
        lblFondo.setLocation(0, 0);
        lblFondo.setIcon(iconoFondo);
        add(lblFondo);

        addKeyListener(new ManejadorTeclado());
        addMouseListener(new ManejadorRaton());
    }

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

    private class ManejadorRaton extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            if (e.getButton() == 1) {
                personaje.flagDisparo = true;
                bala.flagDisparoBala = true;
                if (personaje.getIcon() == personaje.iconoPersonaje) {
                    personaje.setIcon(personaje.iconoPersonajeDisparo);
                }

                if (personaje.getIcon() == personaje.iconoPersonajeVuelta) {
                    personaje.setIcon(personaje.iconoPersonajeDisparoVuelta);
                }
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if (e.getButton() == 1) {
                personaje.flagDisparo = false;
                if (personaje.getIcon() == personaje.iconoPersonajeDisparo) {
                    personaje.setIcon(personaje.iconoPersonaje);
                }

                if (personaje.getIcon()==personaje.iconoPersonajeDisparoVuelta) {
                    personaje.setIcon(personaje.iconoPersonajeVuelta);
                }
            }
        }
    }
}
