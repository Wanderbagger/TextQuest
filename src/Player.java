import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player extends Person{ // заготовка под игрока
   private String name;
   private int health = 100;
   private Map<String, Integer> inventory = new HashMap<>();
    private List<Attack> attackList = generateStandartattackList();



    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
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
        inventory.remove(item);
    }

    public boolean checkInventory(String item) {
        return inventory.containsKey(item);
    }


}
