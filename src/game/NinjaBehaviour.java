package game;

import edu.monash.fit2099.engine.*;

/**
 * Behaviour handler for Ninja retreat action (does not provision stuns)
 * 
 * @author      Rithesh Jayaram <RJAY0006@student.monash.edu> 
 * @author      Sarah Dennis <sden0009@student.monash.edu>
 * @version     1.0
 * @since       1.0
 */
public class NinjaBehaviour implements ActionFactory{
  
    private Actor target;

    public NinjaBehaviour(Actor target) {
		  this.target = target;
	}


  @Override
	public Action getAction(Actor actor, GameMap map) {
    Location here = map.locationOf(actor);
		Location there = map.locationOf(target);

    int currentDistance = distance(here, there);

    if (currentDistance < 5){
      for (Exit exit : here.getExits()) {
        Location destination = exit.getDestination();
        if (destination.canActorEnter(actor)) {
          int newDistance = distance(destination, there);
          if (newDistance > currentDistance) { // Simply invert condition from FollowBehaviour
            return new MoveActorAction(destination, exit.getName());
          }
        }
      }
    }
    return new NPCSkipTurnAction(); // Don't move if out of range or cornered
  }

  // Proper distance
	private int distance(Location a, Location b) {
		return (int) Math.sqrt((a.x() - b.x())^2 + (a.y() - b.y())^2);
  }
}