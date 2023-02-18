//Handels transitioning

public class ChangeScene {

    GameManager gameManager;

    public ChangeScene(GameManager gameManager){
        this.gameManager = gameManager;
    }

    public void showHome(){
        gameManager.ui.backgroundPanel[1].setVisible(true);
        gameManager.ui.backgroundPanel[2].setVisible(false);
        gameManager.ui.backgroundPanel[3].setVisible(false);

        gameManager.ui.dialog.setText("Kitty doesn't seem to be here... lets look somewhere else.");
    }
    public void showStreet(){
        gameManager.ui.backgroundPanel[1].setVisible(false);
        gameManager.ui.backgroundPanel[2].setVisible(true);
        gameManager.ui.backgroundPanel[3].setVisible(false);
        gameManager.ui.dialog.setText("I wonder where Kitty went...");
        if(gameManager.inventory.hasCatFood == -1){
            gameManager.ui.dialog.setText("I guess this cat must be yours... Take better care next time.\n\nTHE END");
            gameManager.ui.createObject(2,"boy with cat.png");
        }
    }
    public void showStore(){
        //I put it here and not in UI because there is a bug, if you are at Home and want to get the purse, you could interact with the object in the store
        gameManager.ui.createInteractionObject(410,20,80,80,3,"FishIcon.png", "buyFood");

        gameManager.ui.backgroundPanel[1].setVisible(false);
        gameManager.ui.backgroundPanel[2].setVisible(false);
        gameManager.ui.backgroundPanel[3].setVisible(true);
        gameManager.ui.dialog.setText("I should buy some cat food.");
    }
}
