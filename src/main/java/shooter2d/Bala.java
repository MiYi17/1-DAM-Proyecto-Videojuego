package shooter2d;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

public class Bala extends JLabel implements ActionListener {

    Principal p;
    Personaje personaje;
    Zombie zombie;

    int x;
    int y;

    int cont;

    Timer temporizadorDisparoBala;
    boolean flagDisparoBala;

    boolean flagLadoDisparo;

    boolean flagImpactoZombie;

    // balaImagen
    ImageIcon imagenBala = new ImageIcon(Bala.class.getResource("/shooter2d/img/bala.png"));
    Image conversionBala = imagenBala.getImage();
    Image pasadoBala = conversionBala.getScaledInstance(14, 4, Image.SCALE_REPLICATE);
    ImageIcon iconoBala = new ImageIcon(pasadoBala);

    public Bala(Principal p) {
        this.p = p;
        this.setIcon(iconoBala);
        this.setVisible(false);

        temporizadorDisparoBala = new Timer(10, this);
        temporizadorDisparoBala.start();

        flagDisparoBala = false;

        flagImpactoZombie = false;

        // x = p.personaje.getX()+200;
        // y = p.personaje.getY()+75;
        cont = 0;
    }

    // public void crearBala() {
    // p.bala = new Bala(p);
    // p.bala.setSize(14, 4);
    // p.bala.setLocation(300,300);
    // p.add(p.bala,1);
    // p.bala.setVisible(false);
    // p.bala.setVisible(true);
    // System.err.println("creo");
    // }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == temporizadorDisparoBala && flagDisparoBala) {
            if (cont == 0) {
                if (p.personaje.getIcon() == p.personaje.iconoPersonajeDisparo
                        || p.personaje.getIcon() == p.personaje.iconoPersonaje) {
                    x = p.personaje.getX() + 200;
                    y = p.personaje.getY() + 75;
                    flagLadoDisparo = true;
                }

                if (p.personaje.getIcon() == p.personaje.iconoPersonajeDisparoVuelta
                        || p.personaje.getIcon() == p.personaje.iconoPersonajeVuelta) {
                    x = p.personaje.getX() - 25;
                    y = p.personaje.getY() + 75;
                    flagLadoDisparo = false;
                }

            }

            this.setVisible(true);

            if (flagLadoDisparo) {
                x += 10;
            } else {
                x -= 10;
            }

            this.setLocation(x, y);
            cont++;

            // if (this.getLocation().x >= 1000) {
            // p.remove(this);
            // this.setVisible(false);
            // temporizadorDisparoBala.stop();
            // }    

            if (this.getX() >= p.zombie.getX() + 60 && p.zombie.getX() > p.personaje.getX()) {

                p.zombie.matarZombie();
                this.setVisible(false);

                p.remove(this);
                temporizadorDisparoBala.stop();
            }
        }
    }
}
