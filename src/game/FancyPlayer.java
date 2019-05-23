package game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import edu.monash.fit2099.engine.*;

/**
 * Upgraded version of stock player class in engine, supports certain necessary features
 * Including ninja stuns, water gun operation, oxygen tank renewals
 * 
 * @author      Rithesh Jayaram <RJAY0006@student.monash.edu> 
 * @author      Sarah Dennis <SDEN0009@student.monash.edu>
 * @version     1.0
 * @since       1.0
 */
public class FancyPlayer extends Player {
	
	private int stunRemaining = 0;
	private int oxygenRemaining = 0;
	private boolean onTheMoon = false;
	protected List<GameMap> maps;

	/**
	 * Instantiate a FancyPlayer, an upgraded version of player
	 * Constructor is almost unmodified, but also takes a list of maps during init
	 * @param name Name of player
	 * @param displayChar Char that represents player on map
	 * @param priority Execution priotity of player - should ideally be as high as possible
	 * @param hitPoints Amount of hitpoints player begins with
	 * @param maps List of maps contained in world - used when player needs to teleport to one
	 */
	public FancyPlayer(String name, char displayChar, int priority, int hitPoints, List<GameMap> maps) {
		super(name, displayChar, priority, hitPoints);
		this.maps = maps;
	}
	
	@Override
	protected Action showMenu(Actions actions, Display display) {
		ArrayList<Character> freeChars = new ArrayList<Character>();
		HashMap<Character, Action> keyToActionMap = new HashMap<Character, Action>();
		
		// If player is on the moon, check how much oxygen they have
		if (onTheMoon) {
			if (Gutils.getItem(this, '8') != null) {
				Gutils.getItem(this, '8').getAllowableActions().clear();
			}
			
			// If player has an oxygen tank in their inventory at any point on the moon it will add more oxygen
			if (Gutils.getItem(this, 'o') != null) {
				increaseOxygen();
				this.removeItemFromInventory(Gutils.getItem(this, 'o'));
			}
			
			oxygenRemaining--;
			
			// If player runs out of oxygen, send them back to the lair
			if (oxygenRemaining <= 0) {
				display.println("Player has run out of oxygen! Their safety system ejects them back to earth.");
				maps.get(0).moveActor(this, maps.get(0).at(0, 3));
				onTheMoon = false;
				return new SkipTurnAction();
			}
			else {
				display.println("Player has " + oxygenRemaining + " steps of oxygen left.");
			}
		}

		// If player is stunned
		if (stunRemaining > 0) {
			display.println("Player stunned for " + stunRemaining + " turn(s)...\n(Enter any key to continue)");
			stunRemaining--;

			while(true){
				display.readChar();
				break;
			}
			
			return new SkipTurnAction();	// Do nothing if no actions available
		}

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
	
	/**
	 * Checks if player is currently stunned, returns true if so
	 * @return Boolean
	 */
	public boolean stunned(){
		if (stunRemaining <= 0){
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Stuns player for 2 turns, if not already stunned
	 */
	public void stun(){
		if (!(stunned())){
			stunRemaining = 2;
		}
	}

	/**
	 * Adds 10 points / turns worth of oxygen to player's oxygen counter
	 */
	public void increaseOxygen() {
		oxygenRemaining += 10;
	}
	
	/**
	 * Checks if player is on the bool, returns true if yes
	 * @return boolean
	 */
	public boolean isPlayerOnMoon() {
		return this.onTheMoon;
	}
	
	/**
	 * Moves player from their current map to the map specified
	 * Also sets / unsets the 'isPlayerOnMoon' flag on movement
	 * @param mapName map to move player to
	 */
	public void movePlayerToMap(String mapName) {
		if (mapName == "Moon") {
			onTheMoon = true;
			maps.get(1).moveActor(this, maps.get(1).at(6, 0));
		}
		else if (mapName == "Lair") {
			maps.get(0).moveActor(this, maps.get(0).at(0, 3));
			onTheMoon = false;
		}
	}
}
