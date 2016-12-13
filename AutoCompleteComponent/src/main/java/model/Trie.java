package model;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Trie {
	
	private TrieNode root;
	
	public Trie()
	{
		root = new TrieNode(' ');
	}
	
	public boolean addWord(String word)
	{
		if (word == null || word.trim().length() < 1) return false;
		root.addNewWord(word.trim().toLowerCase());
		return true;
	}
	
	public List<String> findPrefix(String prefix)
	{
		TrieNode lastNode = root;
		for (int i = 0; i < prefix.length(); i++)
		{
			if (lastNode.getChildren().containsKey(prefix.charAt(i)))
				lastNode = lastNode.getChildren().get(prefix.charAt(i));
			else 
				return new ArrayList<>();
		}
		return lastNode.getWords();
	}
	
	public void printNodes(TrieNode node)
	{
		for (Map.Entry<Character, TrieNode> entry : node.getChildren().entrySet())
		{
			System.out.println(entry.getValue());
			printNodes(entry.getValue());
		}
	}
	
	public TrieNode getRoot() {
		return root;
	}

}
