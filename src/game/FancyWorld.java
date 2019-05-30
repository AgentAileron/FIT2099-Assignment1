package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.Exit;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;
import edu.monash.fit2099.engine.SkipTurnAction;
import edu.monash.fit2099.engine.World;

public class FancyWorld extends World {

	public FancyWorld(Display display) {
		super(display);
	}
	
	@Override
	public void run() {
		FancyPlayer user = (FancyPlayer) player;
		
		if ((!player.isConscious()) && (user.getEndStatus() == EndGame.NONE))
			user.initiateEnd("lose");
		else if (user.getEndStatus() == EndGame.NONE)
			if (player == null)
				throw new IllegalStateException();
			
			while (stillRunning()) {
				GameMap playersMap = actorLocations.locationOf(player).map();
				playersMap.draw(display);
				for (Actor actor : actorLocations) {
					if (actorLocations.locationOf(player) != null) {
						if (actor != null) {
							if (player != null)
								processActorTurn(actor);
							else
								break;
						}
					}
					else if ((!player.isConscious()) && (user.getEndStatus() == EndGame.NONE)) {
						user.initiateEnd("lose");
					}
					else
						break;
				}
			}
		
		display.println(endGameMessage());
	}

	@Override
	protected void processActorTurn(Actor actor) {
		if (actor == null){	// Safety check, in case target despawns
			return;
    	}
		
		if (player != null) {
			Location here = actorLocations.locationOf(actor);
			GameMap map = here.map();
	
			Actions actions = new Actions();
			for (Item item : actor.getInventory()) {
				actions.add(item.getAllowableActions());
			}
	
			for (Exit exit : here.getExits()) {
				Location destination = exit.getDestination();
				if (actorLocations.isAnActorAt(destination)) {
					Actor adjacentActor = actorLocations.actorAt(destination);
					actions.add(adjacentActor.getAllowableActions(actor, exit.getName(), map));
				} else {
					Ground adjacentGround = map.groundAt(destination);
					actions.add(adjacentGround.allowableActions(actor, destination, exit.getName()));
					actions.add(adjacentGround.getMoveAction(actor, destination, exit.getName(), exit.getHotKey()));
				}
			}
	
			for (Item item : here.getItems()) {
				actions.add(item.getAllowableActions());
			}
			actions.add(new SkipTurnAction());
			
			Action action = actor.playTurn(actions, map, display);
			String result = action.execute(actor, map);
			display.println(result);
		}
	}

	@Override
	protected String endGameMessage() {
		FancyPlayer user = (FancyPlayer) player;
		
		if (user.getEndStatus() == EndGame.WIN)
			return "Congratulations! You win! Thanks for playing!";
		else if (user.getEndStatus() == EndGame.LOSE)
			return "You were defeated. Game over.";
		else if (user.getEndStatus() == EndGame.EXIT)
			return "Thanks for playing!";
		return "";
	}
}