package shooter2d;

import javax.swing.JFrame;

public class Frame extends JFrame{
    Principal p;
    Menu m;
    public Frame(){
        // p = new Principal(this);
        // p.setSize(1920,1080);
        // p.setVisible(false);
        // add(p);

        m = new Menu(this);
        m.setSize(1920,1080);
        m.setVisible(true);
        add(m);
    }
}
