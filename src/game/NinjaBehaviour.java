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

    Location shiftX = new Location(map, (2*here.x()) - there.x(), here.y());
    Location shiftY = new Location(map, here.x(), (2*here.y()) - there.y());
    
    if (currentDistance <= 5){
      if (isValidLocation(map, actor, shiftX)){
        return new MoveActorAction(shiftX, direction);
      }else if (isValidLocation(map, actor, shiftX)){
        return new MoveActorAction(shiftX, direction);
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