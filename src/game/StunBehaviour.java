package game;

import edu.monash.fit2099.engine.*;

public class StunBehaviour implements ActionFactory {
    private Actor attacker;
    private Actor subject;
    
    public StunBehaviour(Actor actor, Actor subject) {
        this.attacker = actor;
        this.subject = subject;
    }
    
    @Override
	public Action getAction(Actor actor, GameMap map) {
        Integer range = distance(map.locationOf(attacker), map.locationOf(subject));
        if (range <= 5){
            return new StunAction(actor, subject);
        }else{
            return null;
        }
    }

    // Manhattan distance.
	private int distance(Location a, Location b) {
		return Math.abs(a.x() - b.x()) + Math.abs(a.y() - b.y());
	}
}