public class Game {
    Player player;
    private boolean isGameStopped = false;

    public static void main(String[] args) {
        Player player = new Player("Отважный Гога");
        Game game = new Game(player);
        game.play(game);
    }

    public void play(Game game){
        while (completeQuest(0) <= 0){
            isGameStopped = false;
        }
        isGameStopped = true;
    }

    public int completeQuest (int questId){
        return null;
    }

    public Game(Player player) {
        this.player = player;
    }
}
