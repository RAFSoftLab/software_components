package gui;


import java.util.List;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;

public class WordListPopup extends ContextMenu{
	
	private ACTextArea area;
	
	public WordListPopup(ACTextArea area)
	{
		this.area = area;
	}
	
	public void showList(Node node, double x, double y, List<String> words)
	{
		show(node, x, y);
		ObservableList<MenuItem> items = getItems();
		items.clear();
		if (words.size() == 0)
		{
			MenuItem item = new MenuItem("No results");
			item.setDisable(true);
			items.add(item);
		}
		
		for (String word : words)
		{
			String desc = area.getModel().getWordDescriptions().get(word);
			String item = desc.trim().equals("") ? word : word + " -- \"" + desc + "\"";
			
			MenuItem newItem = new MenuItem(item);
			newItem.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent e) {
					
					area.swapWord(word);
				}
			});
			items.add(newItem);
		}
	}

}
