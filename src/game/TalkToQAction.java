package game;

import edu.monash.fit2099.engine.*;

/**
 * Action for player to interact with Q (talking)
 * Talking does not affect game environment - simply hints player when they may trade plans for parts
 * 
 * @author      Rithesh Jayaram <RJAY0006@student.monash.edu> 
 * @author      Sarah Dennis <SDEN0009@student.monash.edu>
 * @version     1.0
 * @since       1.0
 */
public class TalkToQAction extends Action {
	
	private Actor subject;

	public TalkToQAction(Actor subject) {
		this.subject = subject;
	}

	private Item playerHasItem(Actor actor, char itemDisplayChar) {
		for (int i = 0; i < actor.getInventory().size(); i++) {
			if (actor.getInventory().get(i).getDisplayChar() == itemDisplayChar) {
				return actor.getInventory().get(i);
			}
		}
		
		return null;
	}
	
	@Override
	public String execute(Actor actor, GameMap map) {

		Item plan = playerHasItem(actor, 'p');
		
		if (plan != null) {
			return "Hand them over, I don't have all day!";
		}
		else {
			return "I can give you something that will help, but I'm going to need plans.";
		}
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " talks with " + subject;
	}

	@Override
	public String hotKey() {
		return "t";
	}
}
