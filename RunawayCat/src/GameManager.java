public class GameManager {
    ActionHandler aHandler = new ActionHandler(this);//need to instantiate ActionListener before UI
    UI ui = new UI(this); //call user interface
    Inventory inventory = new Inventory(this);
    ChangeScene changeScene = new ChangeScene(this);
    Event event = new Event(this);

    public static void main(String[] args) {
        new GameManager();
    }

    public GameManager(){
        inventory.setDefaultInventory();
    }
}
