import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DataReader {

	public static void main(String[] args) {
		Map<Integer, Quest> quests = new HashMap<>();
		BufferedReader reader;
		DataReader dataReader = new DataReader();
		try {
			reader = new BufferedReader(new FileReader("C:\\SQL\\12.txt"));
			String line = reader.readLine();
			while (line != null) {
				List<String> words;
				int id = 0;
				String description = "";
				String action = "";
				String result = "";
				int nextQuestId = 0;
				Decision decision;
				words = dataReader.readWord(line);
				System.out.println(words);
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



	private String readDescription(List<String> words, int id) {
		String description = "";
		for (int i = id; i < words.size(); i++) {
			if (i + 1 == words.size() || words.get(i + 1).equals("DECISION")) {
				description += words.get(i);
				break;
			}
			description += words.get(i) + " ";
		}
		return description;
	}

	private Decision readDecision(List<String> words, int id) {
		String action = "";
		String result = "";
		int nextQuestId = 0;
		for (int i = id; i < words.size(); i++) {
			if (words.get(i).equals("NEXT_QUEST_ID")) {
				nextQuestId = Integer.parseInt(words.get(i + 1));
				System.out.println(new Decision(action, result, nextQuestId));
				return new Decision(action, result, nextQuestId);
			}
			if (i + 1 == words.size()) {
				break;
			}

			if (words.get(i + 1).equals("RESULT")) {
				action += words.get(i);
			} else if (words.get(i + 1).equals("NEXT_QUEST_ID")) {
				result += words.get(i);

			}
		}
		return null;
	}
}