package shooter2d;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Menu extends JPanel implements ActionListener{
    Frame a;
    JButton btnJugar;
    JButton btnSalir;

    public Menu(Frame a){
        this.a = a;
        setLayout(null);
        this.setBackground(Color.black);
        //btnJugar
        btnJugar = new JButton();
        btnJugar.setSize(150,80);
        btnJugar.setLocation(300,300);
        add(btnJugar);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
    
}
