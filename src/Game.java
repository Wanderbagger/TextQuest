import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {


    List<Quest> quests = new ArrayList<>();
    Player player;
    private boolean isGameStopped = false;
    Quest currentQuest;
    int currentQuestId = 1;

    public static void main(String[] args) throws IOException {
        Player player = new Player("Отважный Гога");
        Game game = new Game(player);
        Initializer initializer = new Initializer();
game.setQuests(initializer.read());
        System.out.println(game.getQuests());






        /*
        Player player = new Player("Отважный Гога");
        Game game = new Game(player);
        game.initialize();
        game.play(game);
*/
    }

    public void play(Game game) throws IOException {
        while (currentQuestId > 0){
            currentQuestId = completeQuets(currentQuestId);
        }
        game.isGameStopped = true;
    }

    public Game(Player player) {
        this.player = player;

    }


    public int completeQuets(int currentQuestId){
        currentQuest = quests.get(currentQuestId);
        System.out.println(currentQuest.description);
        for (int i = 0; i < currentQuest.decisions.size(); i++) {
            System.out.println(i + ". " + currentQuest.getDecisions().get(i).action);
        }
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int input = Integer.parseInt(reader.readLine());
            System.out.println(currentQuest.getDecisions().get(input).result);
            return currentQuest.getDecisions().get(input).nextQuestId;

        } catch (Exception e) {
            System.out.println("Ошибка");
            return 0;
        }

    }

    public void setQuests(List <Quest> quests) {
        this.quests = quests;
    }

    public List<Quest> getQuests() {
        return quests;
    }
}
