package game;

import edu.monash.fit2099.engine.*;
import java.util.ArrayList;

/**
 * Behaviour handler for NPC random walk - 60% chance per turn of movement happening
 * 
 * @author      Rithesh Jayaram <RJAY0006@student.monash.edu> 
 * @author      Sarah Dennis <SDEN0009@student.monash.edu>
 * @version     1.0
 * @since       1.0
 */
public class RandomWalkBehaviour implements ActionFactory{

    public RandomWalkBehaviour() {}

    @Override
	public Action getAction(Actor actor, GameMap map) {
        Location here = map.locationOf(actor);
        
        if (Math.random() < 0.6){   // 60% chance that NPC will move 

            ArrayList<Exit> validDirections = new ArrayList<Exit>();

            // Get valid exits
            for (int i=0; i < 4; i++){
                Exit direction = here.getExits().get(i);
                if (direction.getDestination().canActorEnter(actor)){
                   validDirections.add(direction);
                }
            }

            // Return a random exit of the valid exits available (if any)
            if (validDirections.size() >= 0){
                int randint = (int) (Math.random() * (validDirections.size()));
                Exit chosenExit = validDirections.get(randint);
                return new MoveActorAction(chosenExit.getDestination(), chosenExit.getName());
            }

        }
		return null;
	}
}
