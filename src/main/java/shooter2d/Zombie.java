package shooter2d;

import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;


public class Zombie extends JLabel implements ActionListener{
    Principal p;
    Bala bala;
    Personaje personaje;

    int x;
    int y;

    int contBalasDadas;

    Timer temporizadorAndarZombie;

    //zombieImagen
    ImageIcon imagenZombie = new ImageIcon(Zombie.class.getResource("/shooter2d/img/zombie.png"));
    Image conversionZombie = imagenZombie.getImage();
    Image pasadoZombie = conversionZombie.getScaledInstance(130, 210, Image.SCALE_REPLICATE);
    ImageIcon iconoZombie = new ImageIcon(pasadoZombie);
    
    //zombieVueltaImagen
    ImageIcon imagenZombieVuelta = new ImageIcon(Zombie.class.getResource("/shooter2d/img/zombievuelta.png"));
    Image conversionZombieVuelta = imagenZombieVuelta.getImage();
    Image pasadoZombieVuelta = conversionZombieVuelta.getScaledInstance(130, 210, Image.SCALE_REPLICATE);
    ImageIcon iconoZombieVuelta = new ImageIcon(pasadoZombieVuelta);

    public Zombie(Principal p){
        this.p = p;
      
        this.setIcon(iconoZombie);

        temporizadorAndarZombie = new Timer(5, this);
        temporizadorAndarZombie.start();
    }

    public void matarZombie(Component z){
        z.setVisible(true);
        z.setVisible(false);
        p.remove(z);
        temporizadorAndarZombie.stop();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == temporizadorAndarZombie) {
            x = this.getX();
            y = this.getY();

            if (this.getIcon() == iconoZombieVuelta) {
                if (this.getX() <= p.personaje.getX() + 110) {
                    temporizadorAndarZombie.stop();
                } else {
                    if (p.flagVelocidadFacil) {
                        x -= 1;
                    }
                    if (p.flagVelocidadNormal) {
                        x -= 2;
                    }
                    if (p.flagVelocidadDificil) {
                        x -= 3;
                    }
                }
            } else {
                if (this.getX() >= p.personaje.getX() - 60) {
                    temporizadorAndarZombie.stop();
                } else {
                    if (p.flagVelocidadFacil) {
                        x += 1;
                    }
                    if (p.flagVelocidadNormal) {
                        x += 2;
                    }
                    if (p.flagVelocidadDificil) {
                        x += 3;
                    }
                }
            }
            this.setLocation(x,y);
        }
    }
}
