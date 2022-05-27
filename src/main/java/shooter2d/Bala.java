package shooter2d;

import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

public class Bala extends JLabel implements ActionListener {

    // VARIABLES
    Principal p;
    Personaje personaje;
    Zombie zombie;
    Timer temporizadorDisparoBala;

    int x;
    int y;
    int cont;

    boolean flagDisparoBala;
    boolean flagLadoDisparo;

    // balaImagen
    ImageIcon imagenBala = new ImageIcon(Bala.class.getResource("/shooter2d/img/bala.png"));
    Image conversionBala = imagenBala.getImage();
    Image pasadoBala = conversionBala.getScaledInstance(14, 4, Image.SCALE_REPLICATE);
    ImageIcon iconoBala = new ImageIcon(pasadoBala);

    // CONSTRUCTOR
    public Bala(Principal p) {
        this.p = p;
        this.setIcon(iconoBala);
        this.setVisible(false);

        temporizadorDisparoBala = new Timer(30, this);
        temporizadorDisparoBala.start();

        flagDisparoBala = false;
        cont = 0;
    }

    // Función para eliminar zombies al impactarle la bala
    public void matarZombies() {
        for (Component component : p.getComponents()) {
            if (component.getClass() == Zombie.class) {

                if (((Zombie) component).getIcon() == ((Zombie) component).iconoZombieVuelta) {

                    if (this.getX() >= component.getX() + 60 && component.getX() > p.personaje.getX()) {

                        temporizadorDisparoBala.stop();
                        p.remove(this);
                        this.setVisible(false);

                        ((Zombie) component).contBalasDadas++;

                        if ((p.flagDisparosFacil && ((Zombie) component).contBalasDadas == 1) || (p.flagDisparosNormal && ((Zombie) component).contBalasDadas == 2) || (p.flagDisparosDificil && ((Zombie) component).contBalasDadas == 3)){
                            ((Zombie) component).matarZombie(component);
                            p.remove(this);
                            this.setVisible(false);

                            temporizadorDisparoBala.stop();
                        }
                    }
                }

                if (((Zombie) component).getIcon() == ((Zombie) component).iconoZombie) {
                    if (this.getX() <= component.getX() + 60 && component.getX() < p.personaje.getX()) {

                        temporizadorDisparoBala.stop();
                        p.remove(this);
                        this.setVisible(false);

                        ((Zombie) component).contBalasDadas++;

                        if ((p.flagDisparosFacil && ((Zombie) component).contBalasDadas == 1) || (p.flagDisparosNormal && ((Zombie) component).contBalasDadas == 2) || (p.flagDisparosDificil && ((Zombie) component).contBalasDadas == 3)){
                            ((Zombie) component).matarZombie(component);
                            p.remove(this);
                            this.setVisible(false);

                            temporizadorDisparoBala.stop();
                        }
                    }
                }
            }
        }
    }

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
                x += 45;
            } else {
                x -= 45;
            }

            this.setLocation(x, y);
            cont++;

            matarZombies();

            if (this.getX() > 1920 || this.getX() < 0) {
                p.remove(this);
                this.setVisible(false);
                temporizadorDisparoBala.stop();
            }
        }
    }
}
