//STORY EVENTS

public class Event {
    GameManager gameManager;
    public Event(GameManager gameManager){
        this.gameManager = gameManager;
    }

    //GET ITEMS
    public void getPurse(){
        if(gameManager.inventory.hasPurse == 0){
            gameManager.ui.dialog.setText("I got my purse");
            gameManager.inventory.hasPurse = 1; //TODO: TAKE MONEY NOT PURSE TO AVOID PROBLEMS
            gameManager.inventory.updateItems();
        }
        else {
            gameManager.ui.dialog.setText("There is nothing inside");
        }
    }
    public void buyFood(){
        if(gameManager.inventory.hasPurse == 0){
            gameManager.ui.dialog.setText("I will need some money to buy the cat food.");
        }
        else{
            gameManager.inventory.hasPurse = 0;
            gameManager.ui.dialog.setText("Got the food.");
            gameManager.inventory.hasCatFood = 1;
        }
        gameManager.inventory.updateItems();
    }

    //CHANGE SCREEN

    //STORE
    public void enterStoreWithPurse(){

    }
    public void enterStoreWithoutPurse(){

    }

    //HOME
    public void enterHomeToGetPurse(){

    }
    public void enterHomeWithFood(){
        gameManager.ui.dialog.setText("I filled the bowl.");
        gameManager.inventory.hasCatFood = 0;
        gameManager.inventory.updateItems();
    }

    //STREET
    public void enterStreet(){
    }
    public void enterStreetEnd(){
        //todo: food -1, purse -1, then trigger this event
    }



}
