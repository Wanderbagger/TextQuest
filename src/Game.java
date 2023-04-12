import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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

    }



    public void initialize(){
        quests.put(0, new Quest(0,
                "Ваша игра окончена!"
                ));
    }

    public int completeQuets(int currentQuestId) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));



        currentQuest = quests.get(currentQuestId);
        List <Decision> currentDecisions = currentQuest.getDECISIONS();
        int counter = 0;
        System.out.println(currentQuest.getDESCRIPTION());

        for (Decision decision : currentDecisions) {
            System.out.println(counter + " - " + decision.getACTION());
            ++counter;
        }
        int input = Integer.parseInt(reader.readLine());
        Decision currentDecision = currentDecisions.get(input);
        System.out.println(currentDecision.getRESULT());
        reader.close();
        return currentDecision.getNEXT_QUEST_ID();

    }

    public Game(Player player) {
        this.player = player;
    }
}
