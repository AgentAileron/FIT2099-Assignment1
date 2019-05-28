package game;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.World;

public class FancyWorld extends World {
	
	FancyPlayer user = (FancyPlayer) player;

	public FancyWorld(Display display) {
		super(display);
	}
	
	@Override
	public void run() {
		if ((!player.isConscious()) && (user.getEndStatus() == null))
			user.initiateEnd("lose");
		else if (user.getEndStatus() == null)
			if (player == null)
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


	@Override
	protected String endGameMessage() {
		if (user.getEndStatus() == EndGame.WIN)
			return "Congratulations! You win!";
		else if (user.getEndStatus() == EndGame.LOSE)
			return "You were defeated. Game over.";
		else if (user.getEndStatus() == EndGame.EXIT)
			return "You have exited the game. Thanks for playing!";
		return "";
	}
}