package shooter2d;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

public class Personaje extends JLabel implements ActionListener {
    Principal p;
    // personajeImagen
    ImageIcon imagenPersonaje = new ImageIcon(Personaje.class.getResource("/shooter2d/img/personaje.png"));
    Image conversionPersonaje = imagenPersonaje.getImage();
    Image pasadoPersonaje = conversionPersonaje.getScaledInstance(210, 240, Image.SCALE_REPLICATE);
    ImageIcon iconoPersonaje = new ImageIcon(pasadoPersonaje);

    // personajeImagen
    ImageIcon imagenPersonajeVuelta = new ImageIcon(Personaje.class.getResource("/shooter2d/img/personajevuelta.png"));
    Image conversionPersonajeVuelta = imagenPersonajeVuelta.getImage();
    Image pasadoPersonajeVuelta = conversionPersonajeVuelta.getScaledInstance(210, 240, Image.SCALE_REPLICATE);
    ImageIcon iconoPersonajeVuelta = new ImageIcon(pasadoPersonajeVuelta);

    // personajeImagen
    ImageIcon imagenPersonajeDisparoVuelta = new ImageIcon(
            Personaje.class.getResource("/shooter2d/img/personajedisparavuelta.png"));
    Image conversionPersonajeDisparoVuelta = imagenPersonajeDisparoVuelta.getImage();
    Image pasadoPersonajeDisparoVuelta = conversionPersonajeDisparoVuelta.getScaledInstance(210, 240,
            Image.SCALE_REPLICATE);
    ImageIcon iconoPersonajeDisparoVuelta = new ImageIcon(pasadoPersonajeDisparoVuelta);

    // personajeImagen
    ImageIcon imagenPersonajeDisparo = new ImageIcon(
            Personaje.class.getResource("/shooter2d/img/personajedispara.png"));
    Image conversionPersonajeDisparo = imagenPersonajeDisparo.getImage();
    Image pasadoPersonajeDisparo = conversionPersonajeDisparo.getScaledInstance(210, 240, Image.SCALE_REPLICATE);
    ImageIcon iconoPersonajeDisparo = new ImageIcon(pasadoPersonajeDisparo);

    
    Timer moverDerecha;
    Timer moverIzquierda;

    boolean flagDerecha;
    boolean flagIzquierda;

    boolean flagDisparo;

    int x;
    int y;

    Personaje(Principal p) {
        this.p = p;
        this.setIcon(iconoPersonaje);
        flagDerecha = false;
        flagIzquierda = false;

        moverDerecha = new Timer(5, this);
        moverDerecha.start();
        moverIzquierda = new Timer(5, this);
        moverIzquierda.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == moverDerecha && flagDerecha) {
            x = this.getX();
            y = this.getY();

            if (flagDisparo) {
                this.setIcon(iconoPersonajeDisparo);
                x += 5;
            } else {
                this.setIcon(iconoPersonaje);
                x += 5;
            }

            this.setLocation(x, y);
        }

        if (e.getSource() == moverIzquierda && flagIzquierda) {
            x = this.getX();
            y = this.getY();

            if (flagDisparo) {
                this.setIcon(iconoPersonajeDisparoVuelta);
                x -= 5;
            } else {
                this.setIcon(iconoPersonajeVuelta);
                x -= 5;
            }

            setLocation(x, y);
        }
    }
}
