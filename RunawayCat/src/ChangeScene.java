//Handels transitioning

public class ChangeScene {

    GameManager gameManager;

    public ChangeScene(GameManager gameManager){
        this.gameManager = gameManager;
    }

    public void showHome(){
        if(gameManager.inventory.hasCatFood == 0){
            gameManager.ui.backgroundPanel[1].setVisible(true);
            gameManager.ui.backgroundPanel[2].setVisible(false);
            gameManager.ui.backgroundPanel[3].setVisible(false);
            gameManager.ui.dialog.setText("Where is my cat :(");
        }else{
            gameManager.ui.dialog.setText("I filled the bowl.");
            gameManager.inventory.hasCatFood = 0;
            gameManager.inventory.updateItems();
        }
    }
    public void showStreet(){
        gameManager.ui.backgroundPanel[1].setVisible(false);
        gameManager.ui.backgroundPanel[2].setVisible(true);
        gameManager.ui.backgroundPanel[3].setVisible(false);
        gameManager.ui.dialog.setText("lets look for Mimi");
    }
    public void showStore(){
        gameManager.ui.backgroundPanel[1].setVisible(false);
        gameManager.ui.backgroundPanel[2].setVisible(false);
        gameManager.ui.backgroundPanel[3].setVisible(true);
        gameManager.ui.dialog.setText("lets buy some food for her");
    }
}
