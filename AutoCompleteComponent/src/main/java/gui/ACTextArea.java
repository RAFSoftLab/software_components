package gui;

import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import model.Core;

public class ACTextArea extends TextArea{

	private Core model;
	private boolean isAssistActive;
	private WordListPopup popup;
	
	public ACTextArea()
	{
		setWrapText(false);
		model = new Core();
		popup = new WordListPopup(this);
		initHandlers();
	}
	
	public void initHandlers()
	{
		setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent e){
				
				if (e.getCode() == KeyCode.ESCAPE)
					isAssistActive = false;
				if (e.getCode() == KeyCode.SPACE && e.isControlDown())
					isAssistActive = true;
				if (e.getCode() == KeyCode.ENTER)
					swapWord(lastWord());
			}
		});
		
		setOnKeyReleased(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent e) {
				if (isAssistActive && !e.getCode().isArrowKey())
					showWordList();
			}
		});
	}
	
	public void swapWord(String word)
	{
		String text = getText();
		int pos = getCaretPosition();
		if (pos == 0) return;
		
		int begin = wordStart(pos  - 1, text);
		int end = wordEnd(pos, text);
		
		text = text.substring(0, begin) + word + text.substring(end, text.length()) + " ";
		setText(text);
		positionCaret(begin + word.length() + 1);
		isAssistActive = false;
		model.getWordPriorities().replace(word, model.getWordPriorities().get(word) + 1);
	}
	
	public void showWordList()
	{
		Bounds screenBounds = localToScreen(getBoundsInParent());
		int[] array = caretPosToXY();
		double x = array[0] < screenBounds.getWidth() ? screenBounds.getMinX() + array[0] + 20 : screenBounds.getMaxX();
		double y = array[1] < screenBounds.getHeight() ? screenBounds.getMinY() + array[1] + 10 : screenBounds.getMaxY();
		
		popup.showList(this, x, y, model.getWordList(lastWord()));
	}
	
	public int[] caretPosToXY()
	{
		int caretPos = getCaretPosition();
		String[] rows = getText().split("\n");
		int i;
		for (i = 0; i < rows.length; i++)
		{
			if (rows[i].length() + 1 > caretPos) 
				break;
			caretPos -= (rows[i].length() + 1);
		}

		int width = (int) com.sun.javafx.tk.Toolkit.getToolkit().getFontLoader().computeStringWidth(i < rows.length ? rows[i] : "", getFont());
		int height = (int) com.sun.javafx.tk.Toolkit.getToolkit().getFontLoader().getFontMetrics(getFont()).getLineHeight();
		
		int array[] = new int[2];
		array[0] = width;
		array[1] = height * (i + 1);
		return array;
	}
	
	public String lastWord()
	{
		int position = getCaretPosition();
		if (position == 0) return "";
		String text = getText();
		
		int lastWordStart = wordStart(position - 1, text);
		int lastWordEnd = wordEnd(position, text);
		return text.substring(lastWordStart, lastWordEnd);
	}
	
	public int wordStart(int wordStart, String text)
	{
		while(wordStart > 0 && !Character.isWhitespace(text.charAt(wordStart)))
			wordStart--;
		return Character.isWhitespace(text.charAt(wordStart)) ? wordStart + 1 : wordStart;
	}
	
	public int wordEnd(int wordEnd, String text)
	{
		while(wordEnd < text.length() && !Character.isWhitespace(text.charAt(wordEnd)))
			wordEnd++;
		return wordEnd;
	}
	
	
	public Core getModel() {
		return model;
	}
}
