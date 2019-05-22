package game;

import edu.monash.fit2099.engine.*;
import java.util.ArrayList;
import java.util.List;

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
            List<Exit> possibleExits = here.getExits();

            // Get valid exits
            for (int i=0; i < possibleExits.size(); i++){
                if (possibleExits.get(i).getDestination().canActorEnter(actor)){
                   validDirections.add(possibleExits.get(i));
                }
            }
            System.out.println("exitState: " + validDirections.size());

            // Return a random exit of the valid exits available (if any)
            if (validDirections.size() >= 0){
                int randint = (int) Math.floor((Math.random() * (validDirections.size() )));
                System.out.println("randint: " + randint);
                if (randint < validDirections.size()){
                    Exit chosenExit = validDirections.get(randint);
                    return new MoveActorAction(chosenExit.getDestination(), chosenExit.getName());
                }
            }

        }
		return null;
	}
}
