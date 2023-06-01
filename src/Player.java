import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player { // заготовка под игрока
   private String name;
   private Map<String, Integer> inventory = new HashMap<>();


    public Player(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addToInventory(String item){
        if(inventory.containsKey(item)){
            int num = inventory.get(item) + 1;
            inventory.remove(item);
            inventory.put(item, num);
        } else {
            inventory.put(item, 1);
        }

    }

    public void printInventory(){
        System.out.println("В вашем инвентаре: ");
        System.out.println(inventory);
    }

    public Map<String, Integer> getInventory() {
        return inventory;
    }

    public void removeItemFromInventory(String item) {
        if (inventory.containsKey(item)) {
            inventory.remove(item);
        }
    }

    public boolean checkInventory(String item) {
        if (inventory.containsKey(item)) {
            return true;
        } else {
            return false;
        }
    }
}
