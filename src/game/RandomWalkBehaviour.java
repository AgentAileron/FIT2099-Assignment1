package game;

import edu.monash.fit2099.engine.*;

public class RandomWalkBehaviour implements ActionFactory{

    public RandomWalkBehaviour(){}

    @Override
	public Action getAction(Actor actor, GameMap map) {
        Location here = map.locationOf(actor);
        
        if (Math.random() < 0.6){   // 60% chance that Q will move 
            for (Exit exit : here.getExits()){
                Location destination = exit.getDestination();
                if (destination.canActorEnter(actor)){
                    return new MoveActorAction(destination, exit.getName());           
                }
            }
        }
		return null;
	}
}