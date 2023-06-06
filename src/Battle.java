import java.util.Random;

public class Battle {
    Player player;
    Enemy enemy;

    public Battle(Player player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
    }

    public void fight() {
        System.out.println("Да начнется битва!");
        int i = 0;
        boolean fightContinues = true;
        while (fightContinues){
            ++i;
            System.out.println("ROUND " + i);

            enemy.setHealth(enemy.getHealth() - calculateDamage(player));
            player.setHealth(player.getHealth() - calculateDamage(enemy));
            System.out.println("Здоровье " + player.getName() + "  " + player.getHealth());
            System.out.println("Здоровье " + enemy.getName() + "  " + enemy.getHealth());
            if(player.getHealth() <= 0 && enemy.getHealth() <= 0){
                System.out.println("Ничья, оба противника потеряли сознание!");
                fightContinues = false;
            } else if(player.getHealth() <= 0){
                System.out.println("Поражение! Победил " + enemy.getName());
                fightContinues = false;
            } else if(enemy.getHealth() <= 0){
                System.out.println("Победа! Победил " + player.getName());
                fightContinues = false;
            }
        }

    }

    private int calculateDamage(Person person){
        Random random = new Random();
        int attackNum = random.nextInt(person.getAttackList().size());
        Attack attack = person.getAttackList().get(attackNum);
        int x = attack.getMAX_DAMAGE() - attack.getMIN_DAMAGE();
        int damage = attack.getMIN_DAMAGE() + random.nextInt(x);
        if(random.nextInt(100) > attack.getPROBABILITY()){

            System.out.println(person.getName() + " пытался нанести " + attack.getNAME() + ". Удар не достиг цели.");
            return 0;
        } else {
            System.out.println(person.getName() + " " + attack.getMESSAGE() + " на " + damage);
            return damage;
        }
    }
}
