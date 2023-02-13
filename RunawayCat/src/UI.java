import javax.swing.*;
import java.awt.*;

//USER INTERFACE
public class UI {
    GameManager gameManager;
    JFrame window;

    //constructor
    public UI(GameManager gameManager){
        this.gameManager = gameManager;
        createWindow();
        window.setVisible(true);
    }
    public void createWindow(){ //instantiate Window
        window = new JFrame();
        window.setSize(960,540);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.BLACK);
        window.setLayout(null);
    }
}
