//STORY EVENTS

public class Event {
    GameManager gameManager;
    public Event(GameManager gameManager){
        this.gameManager = gameManager;
    }

    //GET ITEMS
    public void getPurse(){
        gameManager.ui.dialog.setText("I got my purse");
        gameManager.inventory.hasPurse = 1;
        gameManager.inventory.updateItems();
    }
    public void buyFood(){
        if(gameManager.inventory.hasPurse == 0){
            gameManager.ui.dialog.setText("I will need some money to buy the cat food.");
        } else if(gameManager.inventory.hasCatFood == -1){
            gameManager.ui.dialog.setText("I don't need more food.");
        }
        else{
            gameManager.ui.dialog.setText("Got the food.");
            gameManager.inventory.hasCatFood = 1;
        }
        gameManager.inventory.updateItems();
    }

    //INTERACTION WITH FOOD BOWL
    public void foodBowl(){
        if(gameManager.inventory.hasCatFood == 0){
            gameManager.ui.dialog.setText("I need to get some food first.");
        } else if(gameManager.inventory.hasCatFood == 1){
            gameManager.ui.createObject(1,"BowlFull.PNG");
            gameManager.ui.dialog.setText("I filled up the bowl!");
            gameManager.inventory.hasCatFood = -1;
        } else {
            gameManager.ui.dialog.setText("Maybe she will come back now.");
        }
    }
}
