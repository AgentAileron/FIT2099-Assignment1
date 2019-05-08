package game;

import game.ActionFactory;
import edu.monash.fit2099.engine.*;
import java.util.Random;

public class usesLightSaber extends Action implements ActionFactory {

	private Actor target;
	private Random rand = new Random();

	public usesLightSaber(Actor subject) {
		this.target = subject;
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		if (rand.nextBoolean()) {
			target.hurt(15);
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

		Range xs, ys;
		if (here.x() == there.x() || here.y() == there.y()) {
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
