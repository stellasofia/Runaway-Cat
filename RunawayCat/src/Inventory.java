public class Inventory {
    GameManager gameManager;

    public int hasPurse;
    public int hasCatFood;

    public Inventory(GameManager gameManager){
        this.gameManager = gameManager;
    }

    public void setDefaultInventory(){
        hasPurse = 0;
        hasCatFood = 0;

        updateItems(); //to check if item is obtained
    }

    //UPDATE INFO
    public void updateItems(){
        //CHECK ITEMS
        if(hasPurse == 0){
            gameManager.ui.purseLabel.setVisible(false);
        }
        else {
            gameManager.ui.purseLabel.setVisible(true);
        }
        if(hasCatFood == 0){
            gameManager.ui.catFoodLabel.setVisible(false);
        }
        else {
            gameManager.ui.catFoodLabel.setVisible(true);
        }

    }

}
