public class Battle {
    Player player;
    Enemy enemy;

    public Battle(Player player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
    }

    public boolean fight(){
        int i = 0;
        int playerDamage;
        int enemyDamage;
        Attack currentAttack;
        while (player.getHealth() > 0 || enemy.getHealth() > 0){
            ++i;
            System.out.println("ROUND " + i + " FIGHT!");

            playerDamage =
            enemy.setHealth(enemy.getHealth() - );
        }
        return true;
    }
}
