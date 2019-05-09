package game;

import edu.monash.fit2099.engine.*;

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

    if (currentDistance <= 5){
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
  
  // Check that a map location is valid to move to 
  private boolean isValidLocation(GameMap map, Actor actor, Location loc){
    if (!(map.isAnActorAt(loc))){
      if (map.groundAt(loc).canActorEnter(actor)){
        return true;
      }
    }
    return false;
  }
}