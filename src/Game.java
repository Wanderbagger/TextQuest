import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Game {


    Map <Integer, Quest> quests = new HashMap<>(); // Хэшмэп для хранения всех квестов.
    Player player;  // заготовка для класса игрока
    boolean isGameStopped = false; // заготовка под остановку игры
    Quest currentQuest; // текущий квест = заготовка для сохранения/загрузки
    int currentQuestId = 1; // инициализировали поле номером текущего квеста

    public Game(Player player) {
        this.player = player;
    }

    public static void main(String[] args) throws IOException {
        Player player = new Player("Отважный Гога");
        Game game = new Game(player);
        Initializer initializer = new Initializer();
        game.setQuests(initializer.read()); // инициализация игры = считывание квестов из текстового файла
        game.play(game);
    }

    public void play(Game game) throws IOException { //игра идет,  пока не вернулся айдишник 0 или меньше
        while (currentQuestId > 0){
            currentQuestId = completeQuets(currentQuestId);
        }
        game.isGameStopped = true;
    }

    public int completeQuets(int currentQuestId){ // непосредственный механизм проигрывания квестов
        currentQuest = quests.get(currentQuestId);
        System.out.println(currentQuest.description);
        for (int i = 0; i < currentQuest.decisions.size(); i++) {
            System.out.println(i + ". " + currentQuest.getDecisions().get(i).action);
        }
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int input = Integer.parseInt(reader.readLine());
            System.out.println(currentQuest.getDecisions().get(input).result);
            if(currentQuest.getDecisions().get(input).getItem != null){
                player.addToInventory(currentQuest.getDecisions().get(input).getItem);
                System.out.println("Найден предмет : " + currentQuest.getDecisions().get(input).getItem);
                player.printInventory();
            }
            if(currentQuest.getDecisions().get(input).lostItem != null){
                player.removeItemFromInventory(currentQuest.getDecisions().get(input).lostItem);

            }
            return currentQuest.getDecisions().get(input).nextQuestId;

        } catch (Exception e) {
            System.out.println("Ошибка");
            return 0;
        }

    }

    public Map<Integer, Quest> getQuests() {
        return quests;
    }

    public void setQuests(Map<Integer, Quest> quests) {
        this.quests = quests;
    }
}