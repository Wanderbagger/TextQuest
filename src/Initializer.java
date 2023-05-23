import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Initializer {
    List<String> keywords = Arrays.asList("ID", "DESCRIPTION","ACTION", "RESULT", "NEXT_QUEST_ID");
    List<String> descriptionKeywords = Arrays.asList();
    List<String> words;


    public void read() {
        Map<Integer, Quest> quests = new HashMap<>();
        BufferedReader reader;
        DataReader dataReader = new DataReader();
        try {
            reader = new BufferedReader(new FileReader("C:\\SQL\\12.txt"));
            String line = reader.readLine();
            while (line != null) {
                Initializer initializer = new Initializer();
                words = initializer.readWord(line);
                System.out.println(words);
                initializer.recognize(words);
            /*
            int id = 0;
            String description = "";
            String action = "";
            String result = "";
            int nextQuestId = 0;
            Decision decision;


            for (String word : words) {
                if (word.equals("ID")) {
                    id = Integer.parseInt(words.get(words.indexOf(word) + 1));
                } else if (word.equals("DESCRIPTION")) {
                    description = dataReader.readDescription(words, (words.indexOf(word) + 1));
                } else if (word.equals("ACTION")) {
                    action = "";
                } else if (word.equals("RESULT")) {
                    result = "";
                } else if (word.equals("NEXT_QUEST_ID")) {
                    nextQuestId = Integer.parseInt(words.get(words.indexOf(word) + 1));
                    decision = new Decision(action, result, nextQuestId);
                    Quest quest = new Quest(id, description);
                    quest.decisions.add(decision);
                }
            }

             */
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
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

    private void recognize(List<String> words) {
        String key = "";
        String object = "";

        Map<String, String> recognize = new HashMap<>();
        for (int i = 0; i < words.size(); i++) {
            if (keywords.contains(words.get(i))) {
                if(i > 0){
                    recognize.put(key, object);
                    object = "";
                }
                key = words.get(i);


            } else

                {
                    object += words.get(i);
                    }
            }
        System.out.println("!!!" + recognize);
        }
    }




