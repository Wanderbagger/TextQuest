import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Initializer {
    Quest quest = new Quest();
    Decision decision = new Decision();
    List<Decision> decisions = new ArrayList<>();

    public void read() {
        Map<Integer, Quest> quests = new HashMap<>();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("C:\\SQL\\12.txt"));
            String line = reader.readLine();
            while (line != null) {
                Initializer initializer = new Initializer();
                System.out.println(line);
                initializer.recognize(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void recognize(String line) {
        StringBuilder word = new StringBuilder();
        String keyword = "";
        StringBuilder object = new StringBuilder();
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c == '<') {
                while (c != '>'){
                    i++;
                    if(i==line.length()){
                        break;
                    }
                    c = line.charAt(i);
                    if(c != '>'){
                        word.append(c);
                    } else {
                        --i;
                        keyword = word.toString();
                        word = new StringBuilder();
                    }
                }
            } else if (c == '>') {
                i++;
                while (c != '<'){
                    i++;
                    if(i==line.length()){
                        break;
                    }
                    c = line.charAt(i);
                    if(c != '<'){
                        object.append(c);
                    } else {
                        --i;
                        object = new StringBuilder(object.substring(0, object.length() - 1));
                        dataentry(keyword, object.toString());
                        object = new StringBuilder();
                    }
                }
            }
        }
quest.setDecisions(decisions);
        System.out.println(quest);
    }
    private void dataentry(String keyword, String object){
    switch (keyword){
        case "ID":
            quest.setId(Integer.parseInt(object));
            break;
        case "DESCRIPTION":
            quest.setDescription(object);
            break;
        case "ACTION":
            decision.setAction(object);
            break;
        case "RESULT":
            decision.setResult(object);
            break;
        case "NEXT_QUEST_ID":
            decision.setNextQuestId(Integer.parseInt(object));
            decisions.add(decision);
            decision = new Decision();
            break;
    }
    }


    private List<String> readWord(String line) {
        String word = "";
        List<String> words = new ArrayList<>();
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            word += c;
            if (i + 1 == line.length() || line.charAt(i + 1) == ' ') {
                words.add(word);
                word = "";
                ++i;
            }
        }
        return words;
    }
}





