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
        game.setQuests(initializer.read(player.getName())); // инициализация игры = считывание квестов из текстового файла
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
        System.out.println(currentQuest.getDescription());
        for (int i = 0; i < currentQuest.getDecisions().size(); i++) {
            System.out.println(i + ". " + currentQuest.getDecisions().get(i).getAction());
        }
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int input = Integer.parseInt(reader.readLine());
            Decision currentDecision = currentQuest.getDecisions().get(input);
            if(currentDecision.isGetItem()){
                player.addToInventory(currentDecision.getItem());
                System.out.println("Найден предмет : " + currentDecision.getItem());
                player.printInventory();
            } else if (currentDecision.isLostItem()){
                player.removeItemFromInventory(currentDecision.getItem());
                player.printInventory();
            } else if (currentDecision.isCheckItem()){
                if(player.checkInventory(currentDecision.getItem())){
                    System.out.println("У вас в инвентаре есть " + currentDecision.getItem());
                    System.out.println(currentDecision.getResult());
                    return currentDecision.getNextQuestId();
                } else {
                    System.out.println("У вас в инвентаре нет " + currentDecision.getItem());
                    return currentQuest.getId();
                }
            }
            System.out.println(currentDecision.getResult());
            return currentDecision.getNextQuestId();

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