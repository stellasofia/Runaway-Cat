//STORY EVENTS

public class Event {
    GameManager gameManager;
    public Event(GameManager gameManager){
        this.gameManager = gameManager;
    }

    //GET ITEMS
    public void getPurse(){
        gameManager.ui.dialog.setText("I got my purse");
    }
    public void buyFood(){
        //todo: usePurse = Purse -1
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
        //todo: useFood = Food -1
    }

    //STREET
    public void enterStreet(){
    }
    public void enterStreetEnd(){
        //todo: food -1, purse -1, then trigger this event
    }



}
