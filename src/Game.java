import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    Map<Integer, Quest> quests = new HashMap<>();
    Player player;
    private boolean isGameStopped = false;
    Quest currentQuest;
    int currentQuestId = 1;

    public static void main(String[] args) throws IOException {
Initializer initializer = new Initializer();
initializer.read();
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

    public void initialize(){
        Quest quest = new Quest(0, "Игра окончена!");
        quests.put(0, quest);

    }

    public int completeQuets(int currentQuestId){
        currentQuest = quests.get(currentQuestId);
        System.out.println(currentQuest.DESCRIPTION);
        for (int i = 0; i < currentQuest.decisions.size(); i++) {
            System.out.println(i + ". " + currentQuest.getDecisions().get(i).ACTION);
        }
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int input = Integer.parseInt(reader.readLine());
            System.out.println(currentQuest.getDecisions().get(input).RESULT);
            return currentQuest.getDecisions().get(input).NEXT_QUEST_ID;

        } catch (Exception e) {
            System.out.println("Ошибка");
            return 0;
        }

    }

}
