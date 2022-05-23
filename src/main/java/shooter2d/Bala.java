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

    // int xZombie = zombie.getLocation().x;

    Timer temporizadorDisparoBala;
    boolean flagDisparoBala;

    // balaImagen
    ImageIcon imagenBala = new ImageIcon(Bala.class.getResource("/shooter2d/img/bala.png"));
    Image conversionBala = imagenBala.getImage();
    Image pasadoBala = conversionBala.getScaledInstance(14, 4, Image.SCALE_REPLICATE);
    ImageIcon iconoBala = new ImageIcon(pasadoBala);

    public Bala(Principal p) {
        this.p = p;
        this.setIcon(iconoBala);
        this.setVisible(false);

        temporizadorDisparoBala = new Timer(15, this);
        temporizadorDisparoBala.start();

        flagDisparoBala = false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == temporizadorDisparoBala && flagDisparoBala) {
            this.setVisible(true);
            x = this.getX();
            y = this.getY();

            x += 5;

            this.setLocation(x, y);
        }
    }
}
