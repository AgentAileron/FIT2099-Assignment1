package game;

import edu.monash.fit2099.engine.*;

/**
 * Action for Ninja - stuns player for two turns, disallowing all player actions
 * NB: relies partially on modification to Player class in engine
 * 
 * @author      Rithesh Jayaram <RJAY0006@student.monash.edu> 
 * @author      Sarah Dennis <SDEN0009@student.monash.edu>
 * @version     1.0
 * @since       1.0
 */
public class StunAction extends Action {
	private Player target;

	public StunAction(Actor target) {
        this.target = (FancyPlayer) target;
    }
    
    @Override
	public String execute(Actor actor, GameMap map) {
        String output = actor + " tries to stun " + target + "...";
        if (target instanceof FancyPlayer){
            if (target.stunned()){
                return output + "but " + target + " was already stunned.";
            }
            if (Math.random() < 0.5){
                target.stun();
                return output + target + " was stunned for two turns!";
            }else{
                return output + "but " + actor + " missed.";
            }
        }else{
            return output + "but " + target + " could not be stunned!";
        }
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