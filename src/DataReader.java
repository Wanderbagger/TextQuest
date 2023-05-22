import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataReader {

	public static void main(String[] args) {
		BufferedReader reader;
		DataReader dataReader = new DataReader();
		try {
			reader = new BufferedReader(new FileReader("C:\\SQL\\12.txt"));
			String line = reader.readLine();
			while (line != null) {
				List<String> words = new ArrayList<>();
				int id = 0;
				String description = "";
				words = dataReader.readWord(line);
				System.out.println(words);

				for (String word : words) {
					if (word.equals("ID")){
						id = Integer.parseInt(words.get(words.indexOf(word) + 1));
					} else if(word.equals("DESCRIPTION")){
						description = words.get(words.indexOf(word) + 1);

					}
					Quest quest = new Quest(id, description);


					Decision decision = new Decision("Кинуть сапогом", "Идеальное попадание!", 2);
					quest.decisions.add(decision);
					decision = new Decision("Ударить кирпичом", "Власова ловко увернулась!", 3);
					quest.decisions.add(decision);
					/*quests.put(1, quest);*/
				}
				System.out.println(id + " ");
			line = reader.readLine();
			}

			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private List<String> readWord(String line){
		String word = "";
		List<String> words = new ArrayList<>();
		for (int i = 0; i < line.length(); i++) {
			char c = line.charAt(i);
			word += c;

			if (i + 1 == line.length()){
				words.add(word);
				word = "";
			} else if (line.charAt(i+1) == ' '){
				words.add(word);
				word = "";
				++i;
			}
		}
		return words;
	}
}