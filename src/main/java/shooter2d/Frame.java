package shooter2d;

import javax.swing.JFrame;

public class Frame extends JFrame{
    Principal p;

    public Frame(){
        p = new Principal();
        p.setSize(1920,1080);
        p.setVisible(true);
        add(p);
    }
}
