package game;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.World;

public class FancyWorld extends World {

	public FancyWorld(Display display) {
		super(display);
	}

	@Override
	public void run() {
		if(player == null)
			throw new IllegalStateException();
		
		while (stillRunning()) {
			GameMap playersMap = actorLocations.locationOf(player).map();
			playersMap.draw(display);
			for (Actor actor : actorLocations) {
				if (actor != null){		// Safety check in case of despawned actors
					processActorTurn(actor);
				}
			}
		}
		display.println(endGameMessage());
	}
}