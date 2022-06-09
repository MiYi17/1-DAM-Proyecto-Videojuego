package shooter2d;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MenuEscape extends JPanel implements ActionListener{
    // Frame f;
    Principal p;
    Menu m;

    JButton btnResumir;
    JButton btnExit;

    // BOTON RESUMIR
    ImageIcon iconoResumir = new ImageIcon(Menu.class.getResource("/shooter2d/img/botonResumir.png"));
    Image conversionResumir = iconoResumir.getImage();
    Image tamañoResumir = conversionResumir.getScaledInstance(450, 130, Image.SCALE_SMOOTH);
    ImageIcon imgPreResumir = new ImageIcon(tamañoResumir);
    
    ImageIcon iconoResumirPulsado = new ImageIcon(Menu.class.getResource("/shooter2d/img/botonResumirPulsado.png"));
    Image conversionResumirPulsado = iconoResumirPulsado.getImage();
    Image tamañoResumirPulsado = conversionResumirPulsado.getScaledInstance(450, 130, Image.SCALE_SMOOTH);
    ImageIcon imgPreResumirPulsado = new ImageIcon(tamañoResumirPulsado);
   
    // BOTON RESUMIR
    ImageIcon iconoExit = new ImageIcon(Menu.class.getResource("/shooter2d/img/botonExit.png"));
    Image conversionExit = iconoExit.getImage();
    Image tamañoExit = conversionExit.getScaledInstance(450, 130, Image.SCALE_SMOOTH);
    ImageIcon imgPreExit = new ImageIcon(tamañoExit);
    
    ImageIcon iconoExitPulsado = new ImageIcon(Menu.class.getResource("/shooter2d/img/botonExitPulsado.png"));
    Image conversionExitPulsado = iconoExitPulsado.getImage();
    Image tamañoExitPulsado = conversionExitPulsado.getScaledInstance(450, 130, Image.SCALE_SMOOTH);
    ImageIcon imgPreExitPulsado = new ImageIcon(tamañoExitPulsado);

    public MenuEscape(Principal p){
        this.p = p;
        setLayout(null);
        this.setBackground(Color.black);

        // btnResumir
        btnResumir = new JButton();
        btnResumir.setSize(550, 130);
        btnResumir.setLocation(685, 330);

        btnResumir.setIcon(imgPreResumir);
        btnResumir.setFocusPainted(false);
        btnResumir.setBorderPainted(false);
        btnResumir.setContentAreaFilled(false);
        btnResumir.addMouseListener(new ManejadorRaton());
        btnResumir.addKeyListener(new ManejadorTeclado());
        btnResumir.addActionListener(this);
        add(btnResumir);
        
        // btnResumir
        btnExit = new JButton();
        btnExit.setSize(550, 130);
        btnExit.setLocation(685, 630);

        btnExit.setIcon(imgPreExit);
        btnExit.setFocusPainted(false);
        btnExit.setBorderPainted(false);
        btnExit.setContentAreaFilled(false);
        btnExit.addMouseListener(new ManejadorRaton());
        btnExit.addKeyListener(new ManejadorTeclado());
        btnExit.addActionListener(this);
        add(btnExit);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnResumir) {
            this.setVisible(false);
            p.setVisible(true);
            p.temporizadorAparecerZombie.start();
            p.setFocusable(true);
        }

        if (e.getSource() == btnExit) {
            System.exit(1);
        }
    }

    private class ManejadorRaton extends MouseAdapter{
        @Override
        public void mouseEntered(MouseEvent e) {
            if (e.getSource() == btnResumir) {
                btnResumir.setIcon(imgPreResumirPulsado);
            }

            if (e.getSource() == btnExit) {
                btnExit.setIcon(imgPreExitPulsado);
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (e.getSource() == btnResumir) {
                btnResumir.setIcon(imgPreResumir);
            }
            
            if (e.getSource() == btnExit) {
                btnExit.setIcon(imgPreExit);
            }
        }
    }

    private class ManejadorTeclado extends KeyAdapter{

    }
}
