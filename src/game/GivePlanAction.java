package game;

import edu.monash.fit2099.engine.*;

/**
 * Action for player to give plan to Q (provisions replacement of plans with rocket parts in inventory)
 * 
 * @author      Rithesh Jayaram <RJAY0006@student.monash.edu> 
 * @author      Sarah Dennis <SDEN0009@student.monash.edu>
 * @version     1.0
 * @since       1.0
 */
public class GivePlanAction extends Action {
	
	private Actor subject;

	/**
	 * Instantiate an action instance
	 * @param subject The actor facilitating trades (EG: Q)
	 */
	public GivePlanAction(Actor subject) {
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
	
	private Item qHasItem(Actor actor, char itemDisplayChar) {
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
		Item body = qHasItem(subject, 'h');
		
		if (plan != null) {
			actor.removeItemFromInventory(plan);
			subject.removeItemFromInventory(body);
			actor.addItemToInventory(body);

			Qnpc Q = (Qnpc) subject;
			Q.exileReady = true;	// Marked for exile
			
			return subject + " traded a Rocket Body to " + actor + " for a Rocket Plan";
		}else {
			return subject + " says: Hey! You don't have any rocket plans. Are you trying to swindle me, Bucko?";
		}
	}

	@Override
	public String menuDescription(Actor actor) {
		return "Trade " + subject + " a rocket plan in return for a rocket body part";
	}

	@Override
	public String hotKey() {
		return "p";
	}
}
