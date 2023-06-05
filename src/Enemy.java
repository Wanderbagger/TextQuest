import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Enemy extends Person {
    private String name;
    private int health;
    private List<Attack> attackList;

    public Enemy(String name, int health, List<Attack> attackList) {
        this.name = name;
        this.health = health;
        attackList = generateStandartattackList();
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
