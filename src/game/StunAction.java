package game;

import edu.monash.fit2099.engine.*;

/**
 * Action for Ninja - stuns player for two turns, disallowing all player actions
 * NB: need to be called on an actor which is an instance of fancy player, else will have no effect
 * 
 * @author      Rithesh Jayaram <RJAY0006@student.monash.edu> 
 * @author      Sarah Dennis <SDEN0009@student.monash.edu>
 * @version     1.0
 * @since       1.0
 */
public class StunAction extends Action {
    private FancyPlayer target;

    /**
     * Instantiates an instance of stun action, 
     * the target (player) is specified
     * @param target target of the attempted stun (only works if called on fancyplayer)
     */
	public StunAction(Actor target) {
        this.target = (FancyPlayer) target;
    }
    
    @Override
	public String execute(Actor actor, GameMap map) {
        String output = actor + " tries to stun " + target + "...";
        boolean success = false;
        if (target instanceof FancyPlayer){
            if (target.stunned()){
                output += "but " + target + " was already stunned. \n" + actor + " tries to hide from his failure...";
            }
            if (Math.random() < 0.5){
                target.stun();
                success = true;
                output += target + " was stunned for two turns!";
            }else{
                output += "but " + actor + " missed. \n" + actor + " tries to run from the shame...";
            }
        }else{
            output += "but " + target + " could not be stunned! \n" + actor + " attempts to retreat...";
        }

        // If stun failed, Ninja retreats
        if (!(success)){
            for (Exit exit : map.locationOf(actor).getExits()) {
                Location destination = exit.getDestination();
                if (destination.canActorEnter(actor)){
                    int oldDist = Gutils.distance(map.locationOf(actor), map.locationOf(target));
                    int newDist = Gutils.distance(destination, map.locationOf(target));

                    if (newDist > oldDist){
                        map.moveActor(actor, destination);
                        break;
                    }
                }
            }
        }

        return output;
    }

    @Override
	public String menuDescription(Actor actor) {
		return "";
	}

	@Override
	public String hotKey() {
		return "";
    }
}