import javax.swing.*;
import java.awt.*;

//USER INTERFACE
public class UI {
    GameManager gameManager;
    JFrame window;
    public JTextArea dialog;
    public JPanel backgroundPanel[] = new JPanel[10]; //chose 10 to have enough space, if expansion needed.
    public JLabel backgroundLabel[] = new JLabel[10];

    //constructor
    public UI(GameManager gameManager){
        this.gameManager = gameManager;
        createWindow();
        generateScreen();
        window.setVisible(true);
    }
    public void createWindow(){ //instantiate Window
        window = new JFrame();
        window.setSize(800,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        window.setResizable(false);
        window.setLocationRelativeTo(null); //to center screen

        dialog = new JTextArea("this is an example dialog");
        dialog.setBounds(50,430,700,150);
        dialog.setBackground(Color.black);
        dialog.setForeground(Color.white);
        dialog.setEditable(false);
        dialog.setLineWrap(true);
        dialog.setWrapStyleWord(true);
        dialog.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        window.add(dialog);
    }

    public void createBackground(int backgroundNumber, String BackgroundFileName){
        backgroundPanel[backgroundNumber] = new JPanel();
        backgroundPanel[backgroundNumber].setBounds(50,50,700,394);
        backgroundPanel[backgroundNumber].setBackground(Color.blue);
        backgroundPanel[backgroundNumber].setLayout(null);
        window.add(backgroundPanel[backgroundNumber]);

        backgroundLabel[backgroundNumber] = new JLabel(); //used to display an image
        backgroundLabel[backgroundNumber].setBounds(0,0,700,394);

        ImageIcon backgroundIcon = new ImageIcon(getClass().getClassLoader().getResource(BackgroundFileName));
        backgroundLabel[backgroundNumber].setIcon(backgroundIcon);
    }

    public void createObject(int backgroundNumber, String objectFileName){

        //To create Button: but, because the object is the same size as the background the button is the whole screen
        /*
         JButton button = new JButton();
        button.setBounds(0,0,700,394);
        ImageIcon objectIcon = new ImageIcon(getClass().getClassLoader().getResource(objectFileName));
        button.setIcon(objectIcon);
         */

        //TODO: need to change size of objects and add parameter for coordinates

        JLabel objectLabel = new JLabel();
        objectLabel.setBounds(0,0,700,394);//same because I drew everything on the same canvas
        ImageIcon objectIcon = new ImageIcon(getClass().getClassLoader().getResource(objectFileName));
        objectLabel.setIcon(objectIcon);

        backgroundPanel[backgroundNumber].add(objectLabel); //to show Object
        backgroundPanel[backgroundNumber].add(backgroundLabel[backgroundNumber]); //this line needs to be after the previous line
    }

    public void generateScreen(){
        //SCREEN1
        createBackground(1, "Background1.PNG");
        createObject(1,"Money.PNG");
        createObject(1,"BowlFull.PNG");
    }

}
