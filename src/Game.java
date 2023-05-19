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

        Player player = new Player("Отважный Гога");
        Game game = new Game(player);
        game.initialize();
        game.play(game);

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

        Quest quest = new Quest(1, "Вы видите Власову, что вы хотите сделать?");

        Decision decision = new Decision("Кинуть сапогом", "Идеальное попадание!", 2);
        quest.decisions.add(decision);
        decision = new Decision("Ударить кирпичом", "Власова ловко увернулась!", 3);
        quest.decisions.add(decision);
        quests.put(1, quest);

        quest = new Quest(2, "Победа!");
        decision = new Decision("Исполнить победный танец", "Ура!", 0);
        quest.decisions.add(decision);
        quests.put(2, quest);

        quest = new Quest(3, "Поражение!");
        decision = new Decision("Исполнить грустный танец", "Будет и на моей улице праздник!", 0);
        quest.decisions.add(decision);
        quests.put(3, quest);


        quest = new Quest(0, "Игра окончена!");
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
