import java.util.*;

public abstract class Person {
    private String name;
    private int health;
    private List<Attack> attackList = generateStandartattackList();

    public List<Attack> getAttackList() {
        return attackList;
    }

    public Attack getRandomAttack(){
        int random =  (int)(Math.random() * attackList.size());
        return attackList.get(random);
    }

    public List<Attack> generateStandartattackList(){
        List<Attack> attackList = new ArrayList<>();
        Attack bump = new Attack("Удар кулаком", 80, 1, 4, "нанес сильный удар кулаком");
        Attack hit = new Attack("Удар ногой", 70, 3, 6, "нанес сильный удар ногой");
        attackList.add(bump);
        attackList.add(hit);
        return attackList;
    }
}
