package game;

import java.util.ArrayList;
import java.util.HashMap;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.AttackAction;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Player;
import edu.monash.fit2099.engine.SkipTurnAction;

public class FancyPlayer extends Player {
	
	private int stunRemaining = 0;

	public FancyPlayer(String name, char displayChar, int priority, int hitPoints) {
		super(name, displayChar, priority, hitPoints);
	}
	
	private Item getItem(char displayChar) {
		for (int i = 0; i < this.getInventory().size(); i++) {
			if (this.getInventory().get(i).getDisplayChar() == '~')
				return this.getInventory().get(i);
		}
		
		return null;
	}
	
	@Override
	public Action playTurn(Actions actions, GameMap map, Display display) {
		return showMenu(actions, display);
	}

	@Override
	protected Action showMenu(Actions actions, Display display) {
		ArrayList<Character> freeChars = new ArrayList<Character>();
		HashMap<Character, Action> keyToActionMap = new HashMap<Character, Action>();

		// RJ - addition to method (check for stun)
		if (stunRemaining > 0){
			display.println("Player stunned for " + stunRemaining + " turn(s)...\n(Enter any key to continue)");
			stunRemaining--;

			while(true){
				display.readChar();
				break;
			}
			return new SkipTurnAction();	// Do nothing if no actions available
		}
		
		/*
		if (getItem('~') != null) {
			actions.add(new ShootWaterPistolAction())
		}*/

		for (char i = 'a'; i <= 'z'; i++)
			freeChars.add(i);

		for (Action action : actions) {
			String hotKey = action.hotKey();
			if (hotKey != "") {
				if (freeChars.isEmpty())
					break;
				char c = hotKey.charAt(0);
				freeChars.remove(Character.valueOf(c));
				keyToActionMap.put(c, action);
				display.println(hotKey + ": " + action.menuDescription(this));
			}
		}

		for (Action action : actions) {
			if (action.hotKey() == "") {
				if (freeChars.isEmpty())
					break;
				char c = freeChars.get(0);
				freeChars.remove(0);
				keyToActionMap.put(c, action);
				display.println(c + ": " + action.menuDescription(this));
			}
		}

		char key;
		do {
			key = display.readChar();
		} while (!keyToActionMap.containsKey(key));
		
		return keyToActionMap.get(key);
	}
	
	public boolean stunned(){
		if (stunRemaining <= 0){
			return false;
		}else{
			return true;
		}
	}

	public void stun(){
		if (!(stunned())){
			stunRemaining = 2;
		}
	}
	

}
