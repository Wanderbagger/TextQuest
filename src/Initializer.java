import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Initializer {
    int id = 0;
    Quest quest = new Quest();
    Decision decision = new Decision();
    List<Decision> decisions = new ArrayList<>();
    Map <Integer, Quest> quests = new HashMap<>();
    String playerName;

    public Map <Integer, Quest> read(String name) { // построчное считывание квестов из файла

        BufferedReader reader;
        try {
            File f = new File("src/quests.txt");
            reader = new BufferedReader(new FileReader(f));
            String line = reader.readLine();
            while (line != null) {
                Initializer initializer = new Initializer();
                quest = initializer.recognize(line, name); // построчное распознавание квестов
                quests.put(quest.getId(), quest); // распознали - вставили в массив

                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return quests;
    }

    private Quest recognize(String line, String name) { // распознавание
        StringBuilder word = new StringBuilder();
        String keyword = "";
        StringBuilder object = new StringBuilder();
        for (int i = 0; i < line.length(); i++) { //перебираем строчку по символу
            char c = line.charAt(i);
            if (c == '<') { //  нашли открытие треугольной скобки
                while (c != '>'){ //считываем пока не встретим закрытие
                    i++;
                    if(i==line.length()){
                        break;
                    }
                    c = line.charAt(i);
                    if(c != '>') {
                            word.append(c); // добавление символов к слову
                    }else {
                        --i;
                        word = deletespaces(word);
                        keyword = word.toString(); // внесли знаение слова в значение ключа
                        word = new StringBuilder();
                    }
                }
            } else if (c == '>') { // после закрытия скобки считываем значение объекта
                i++;
                while (c != '<'){
                    i++;
                    if(i >= line.length() ){
                        break;
                    }
                    c = line.charAt(i);
                    if(c != '<'){
                        if (c == '@' && object.isEmpty()) {
                            playerName =  name;
                            object.append(playerName);
                        } else {
                            object.append(c);
                        }
                    } else {
                        --i;
                        object = new StringBuilder(object.substring(0, object.length() - 1));
                        deletespaces(object);
                        dataentry(keyword, object.toString()); // активировали ввод данных в переменные
                        object = new StringBuilder();
                    }
                }
            }
        }
        quest.setDecisions(decisions);
        id = quest.getId();
        return quest;
    }

    private StringBuilder deletespaces(StringBuilder word){
        if(word.charAt(0) == ' '){
            word.deleteCharAt(0);
        } else if(word.charAt(word.length() - 1) == ' '){
            word.deleteCharAt(word.length() - 1);
        }
    return word;
    }

    private void dataentry(String keyword, String object){
        switch (keyword) {
            case "ID" -> quest.setId(Integer.parseInt(object));
            case "DESCRIPTION" -> quest.setDescription(object);
            case "ACTION" -> decision.setAction(object);
            case "RESULT" -> decision.setResult(object);
            case "FOUND_ITEM" -> {
                decision.setGetItem(true);
                decision.setItem(object);
            }
            case "LOST_ITEM" -> {
                decision.setLostItem(true);
                decision.setItem(object);
            }
            case "CHECK_ITEM" -> {
                decision.setCheckItem(true);
                decision.setItem(object);
            }
            case "NEXT_QUEST_ID" -> {
                decision.setNextQuestId(Integer.parseInt(object));
                decisions.add(decision);
                decision = new Decision();
            }
        }
    }
}



