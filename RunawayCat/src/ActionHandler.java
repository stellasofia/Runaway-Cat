import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//HANDLE USER INPUT
public class ActionHandler implements ActionListener{
    GameManager gameManager;
    //ObjectHandler handler = new ObjectHandler();
    public ActionHandler(GameManager gameManager){
        this.gameManager = gameManager;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String object = e.getActionCommand();
        switch (object) {
            case "getPurse" -> gameManager.event.getPurse();
            case "buyFood" -> gameManager.event.buyFood();
            case "foodBowl" -> gameManager.event.foodBowl();


            //CHANGE SCENES
            case "goStreet" -> gameManager.changeScene.showStreet();
            case "goHome" -> {
                if (gameManager.inventory.hasCatFood == -1) {
                    gameManager.ui.dialog.setText("YOU FINISHED THE DEMO. :)");
                    break;
                }
                gameManager.changeScene.showHome();
                if (gameManager.inventory.hasCatFood == 1) {
                    gameManager.ui.dialog.setText("Let's put the food in the bowl.");
                }
            }
            case "goStore" -> {
                if (gameManager.inventory.hasCatFood == -1) {
                    gameManager.ui.dialog.setText("YOU FINISHED THE DEMO. :)");
                    break;
                }
                gameManager.changeScene.showStore();
                if (gameManager.inventory.hasCatFood == 1 || gameManager.inventory.hasCatFood == -1) {
                    gameManager.ui.dialog.setText("I already got all I need. ");
                }
            }
            default -> {
            }
        }
    }
}
