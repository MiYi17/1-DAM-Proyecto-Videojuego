
package shooter2d;

import javax.swing.JFrame;

public class Application {
  public static void main(String[] args) {
    Frame frame = new Frame();
  

    frame.setLocationRelativeTo(null);

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    frame.setUndecorated(true);
    frame.setVisible(true);

    // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // frame.setVisible(true);
    // frame.setSize(900,900);
  }
}
