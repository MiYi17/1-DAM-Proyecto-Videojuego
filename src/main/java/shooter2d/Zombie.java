package shooter2d;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Zombie extends JLabel{
    Principal p;

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
        this.setIcon(iconoZombieVuelta);
    }
}
