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
        switch (object){
            case "getPurse": gameManager.event.getPurse(); break;

            //CHANGE SCENES
            case "goStreet": gameManager.changeScene.showStreet(); break;
            case "goHome": gameManager.changeScene.showHome(); break;
            case "goStore": gameManager.changeScene.showStore(); break;
            default:break;
        }
    }
}
