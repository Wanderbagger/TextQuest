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
                System.out.println(line);
                initializer.recognize(line);
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
    private void recognize(String line) {
        String keyword = "";
        String object = "";

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if(c == '<'){
                for (int j = i + 1; j < line.length(); j++) {
                    c = line.charAt(j);
                    if(c != '>'){
                        keyword += c;
                    } else{
                        System.out.println(keyword);
                        i = j;
                        break;
                }

            }

        } else if (c == '>')

    }

    }
}





