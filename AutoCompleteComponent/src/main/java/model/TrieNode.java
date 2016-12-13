package model;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TrieNode{
	
		private TrieNode parent;
		private char character;
		private HashMap<Character, TrieNode> children = new HashMap<>();
		private boolean wordEndsHere;
		private boolean isLeaf;
		
		public TrieNode()
		{
			wordEndsHere = false;
			isLeaf = true;
		}
		
		public TrieNode(char character)
		{
			this();
			this.character = character;
		}
		
		public List<String> getWords()
		{
			ArrayList<String> result = new ArrayList<>();
			if (wordEndsHere) 
				result.add(this.toString());
			for (Map.Entry<Character, TrieNode> entries : children.entrySet())
				result.addAll(entries.getValue().getWords());
			
			return result;
		}
		
		public void addNewWord(String word)
		{
			char firstChar = word.charAt(0);
			
			TrieNode nextNode;
			if (!children.containsKey(firstChar))
			{
				nextNode = new TrieNode(firstChar);
				children.put(firstChar, nextNode);
				nextNode.setParent(this);
				isLeaf = false;
			}
			else
				nextNode = children.get(firstChar);
			
			if (word.length() > 1) nextNode.addNewWord(word.substring(1));
			else nextNode.setWordEndsHere(true);
		}
		
		@Override
		public String toString() {
			if (parent != null)
				return parent.toString() + character;
			return "";
		}
		
		public HashMap<Character, TrieNode> getChildren() {
			return children;
		}
		
		public void setWordEndsHere(boolean wordEndsHere) {
			this.wordEndsHere = wordEndsHere;
		}
		
		public void setParent(TrieNode parent) {
			this.parent = parent;
		}
		
		
}