package shooter2d;

import javax.swing.JLabel;

public class CrearBala extends JLabel{
    Principal p;
    Bala bala;
    Personaje personaje;

    CrearBala(Principal p){
        this.p = p;
    }

    public void crearBala() {
        bala = new Bala(p);
        bala.setSize(14, 4);
        // bala.setLocation(300,300);
        p.add(bala,1);
        bala.setVisible(false);
        bala.setVisible(true);
        // System.err.println("creo");
        bala.flagDisparoBala = true;
        p.personaje.flagDisparo = true;
    }

}
