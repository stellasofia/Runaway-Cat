import javax.swing.*;
import java.awt.*;
import java.util.Objects;

//USER INTERFACE
public class UI {
    GameManager gameManager;
    JFrame window;
    public JTextArea dialog;
    public JPanel[] backgroundPanel = new JPanel[10]; //chose 10 to have enough space, if expansion needed.
    public JLabel[] backgroundLabel = new JLabel[10];

    //Player UI - Inventory
    JPanel inventoryPanel;
    public JLabel purseLabel,catFoodLabel;


    //CONSTRUCTOR
    public UI(GameManager gameManager){
        this.gameManager = gameManager;
        createWindow();
        createInventory();
        generateScreen();
        window.setVisible(true);
    }

    //WINDOW
    public void createWindow(){ //instantiate window
        window = new JFrame();
        window.setSize(800,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        window.setResizable(false);
        window.setLocationRelativeTo(null); //to center screen

        dialog = new JTextArea("I looked through the whole house, but I couldn't find Kitty anywhere!!\nI think she went through the open door.\nLet's go look for her!");
        dialog.setBounds(50,430,700,150);
        dialog.setBackground(Color.black);
        dialog.setForeground(Color.white);
        dialog.setEditable(false);
        dialog.setLineWrap(true);
        dialog.setWrapStyleWord(true);
        dialog.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        window.add(dialog);
    }

    //BACKGROUND
    public void createBackground(int backgroundNumber, String BackgroundFileName){
        backgroundPanel[backgroundNumber] = new JPanel();
        backgroundPanel[backgroundNumber].setBounds(50,50,700,394);
        backgroundPanel[backgroundNumber].setBackground(Color.blue);
        backgroundPanel[backgroundNumber].setLayout(null);
        window.add(backgroundPanel[backgroundNumber]);

        backgroundLabel[backgroundNumber] = new JLabel(); //used to display an image
        backgroundLabel[backgroundNumber].setBounds(0,0,700,394);

        ImageIcon backgroundIcon = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource(BackgroundFileName)));
        backgroundLabel[backgroundNumber].setIcon(backgroundIcon);
    }

    //ITEM CREATION - interactive
    public void createInteractionObject(int x, int y, int width, int height,int backgroundNumber, String objectFileName, String actionCommand){
        JButton button = new JButton();
        button.setBounds(x,y,width,height);
        ImageIcon objectIcon = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource(objectFileName)));
        button.setBackground(null);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setIcon(objectIcon);
        button.addActionListener(gameManager.aHandler);
        button.setActionCommand(actionCommand);
        button.setBorderPainted(false); //to have a clear background

        backgroundPanel[backgroundNumber].add(button); //to show Object
        backgroundPanel[backgroundNumber].add(backgroundLabel[backgroundNumber]);
    }

    //IMAGE CREATION - without interaction
    public void createObject(int backgroundNumber, String objectFileName){
        JLabel objectLabel = new JLabel();
        objectLabel.setBounds(0,0,700,394);//same because I drew everything on the same canvas
        ImageIcon objectIcon = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource(objectFileName)));
        objectLabel.setIcon(objectIcon);

        backgroundPanel[backgroundNumber].add(objectLabel); //to show Object
        backgroundPanel[backgroundNumber].add(backgroundLabel[backgroundNumber]); //this line needs to be after the previous line
    }

    //INVENTORY
    public void createInventory(){
        inventoryPanel = new JPanel();
        inventoryPanel.setBounds(650,0,100,50);
        inventoryPanel.setBackground(null);
        inventoryPanel.setLayout(new GridLayout(1,5)); //if you want to add more items, change cols >
        window.add(inventoryPanel);

        //CREATE ITEMS FOR PLAYER INVENTORY
        purseLabel = new JLabel();
        ImageIcon purseIcon = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("Purse14x10.png")));
        Image image = purseIcon.getImage().getScaledInstance(35,25,Image.SCALE_DEFAULT);
        purseIcon = new ImageIcon(image);
        purseLabel.setIcon(purseIcon);
        inventoryPanel.add(purseLabel);

        catFoodLabel = new JLabel();
        ImageIcon catFoodIcon = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("FishIcon.png")));
        image = catFoodIcon.getImage().getScaledInstance(35,25,Image.SCALE_DEFAULT);
        catFoodIcon = new ImageIcon(image);
        catFoodLabel.setIcon(catFoodIcon);
        inventoryPanel.add(catFoodLabel);
    }

    //SCENE CREATION
    public void generateScreen(){
        //SCENE1
        createBackground(1, "Home.png");
        createInteractionObject(430,100,20,15,1,"Purse14x10.png", "getPurse");
        //createObject(1,"BowlFull.PNG");
        createInteractionObject(270,280, 30,20,1, "changeLocation.png", "goStreet");
        createInteractionObject(420,300, 80,80,1, "Blank.png", "foodBowl");
        backgroundPanel[1].add(backgroundLabel[1]);

        //SCENE2
        createBackground(2,"Street.png");
        createInteractionObject(310,260, 30,20,2, "changeLocation.png", "goStore");
        createInteractionObject(400,340, 30,20,2, "changeLocation.png", "goHome");
        backgroundPanel[2].add(backgroundLabel[2]);

        //SCENE3
        createBackground(3, "Store.png");
        createInteractionObject(360,330, 30,20,3, "changeLocation.png", "goStreet");
        backgroundPanel[3].add(backgroundLabel[3]);
    }

}
