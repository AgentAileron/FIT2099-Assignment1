package game;

import edu.monash.fit2099.engine.*;
import java.util.Random;

/**
 * Miniboss special attack - high damage close range attack on player
 * 
 * @author      Rithesh Jayaram <RJAY0006@student.monash.edu> 
 * @author      Sarah Dennis <sden0009@student.monash.edu>
 * @version     1.0
 * @since       1.0
 */
public class LightSaberAction extends Action implements ActionFactory {

	private Actor target;
	private Random rand = new Random();

	public LightSaberAction(Actor subject) {
		this.target = subject;
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		if (rand.nextBoolean()) {
			target.hurt(15);
			if (!target.isConscious()) {
				map.removeActor(target);
				// Game ends here :(
				return "After taking a critical slash from " + actor + ", " + target + " has been knocked out. Oh no!";
			}
			
			return "Using his light saber, " + actor + " makes a mighty slash against " + target + System.lineSeparator() + target + " takes 15 damage.";
		}
		else {
			return actor + " with great vigor, attempts to slash at " + target + " but lamely misses.";
		}
	}
	
	@Override
	public Action getAction(Actor actor, GameMap map) {
		Location here = map.locationOf(actor);
		Location there = map.locationOf(target);

		int distanceBetweenY = here.y() - there.y();
		int distanceBetweenX = here.x() - there.x();
		Range xs, ys;
		
		// If target is adjacent
		if ((here.x() == there.x()) && (Math.abs(distanceBetweenY) == 1) || ((here.y() == there.y()) && (distanceBetweenX == 1))) {
			xs = new Range(Math.min(here.x(), there.x()), Math.abs(here.x() - there.x()) + 1);
			ys = new Range(Math.min(here.y(), there.y()), Math.abs(here.y() - there.y()) + 1);

			for (int x : xs) {
				for (int y : ys) {
					if(map.at(x, y).getGround().blocksThrownObjects())
						return null;
				}
			}
			
			return this;
		}
		
		return null;
	}

	@Override
	public String menuDescription(Actor actor) {
		return "";
	}

	@Override
	public String hotKey() {
		return "";
	}
}
