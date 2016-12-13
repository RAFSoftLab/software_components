package model;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Core {

	private Trie vocabulary;
	private HashMap<String, Integer> wordPriorities;
	private HashMap<String, String> wordDescriptions;
	
	public Core()
	{
		vocabulary = new Trie();
		wordDescriptions = new HashMap<>();
		wordPriorities = new HashMap<>();
	}

	public void applyVocabulary(List<String> words, HashMap<String, Integer> priorities, HashMap<String, String> descriptions)
	{
		for (String word : words)
		{
			vocabulary.addWord(word);
			int priority = priorities != null && priorities.containsKey(word) ? priorities.get(word) : 0;
			String description = descriptions != null && descriptions.containsKey(word) ? descriptions.get(word) : "";
			wordPriorities.put(word, priority);
			wordDescriptions.put(word, description);
		}
	}
	
	public void parseFile(String filePath, int wordIndex, int priorityIndex, int descriptionIndex, String separator) throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader(new File(filePath)));
		String line;
		while((line = br.readLine()) != null)
		{
			String[] splitLine = line.split(separator);
			String word = splitLine[wordIndex];
			vocabulary.addWord(word);
			
			int priority = priorityIndex != -1 ? Integer.valueOf(splitLine[priorityIndex]) : 0;
			wordPriorities.put(word, priority);
			String description = descriptionIndex != -1 ? splitLine[descriptionIndex] : "";
			wordDescriptions.put(word, description);
		}
	}
	
	
	public List<String> getWordList(String prefix)
	{
		List<String> list = vocabulary.findPrefix(prefix);
		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String s1, String s2) {
				return wordPriorities.get(s1) > wordPriorities.get(s2) ? -1 : wordPriorities.get(s1) < wordPriorities.get(s2) ? 1 : 0;
			}
		});
		return list;
	}
	
	public HashMap<String, Integer> getWordPriorities() {
		return wordPriorities;
	}
	
	public HashMap<String, String> getWordDescriptions() {
		return wordDescriptions;
	}
	
	
}
