package game;

import edu.monash.fit2099.engine.*;

public class StunAction extends Action {
    private Actor actor;
	private Player target;

	public StunAction(Actor actor, Actor target) {
        this.actor = actor;
        this.target = (Player) target;
    }
    
    @Override
	public String execute(Actor actor, GameMap map) {
        String output = actor + " tries to stun " + target + "...";
        if (target instanceof Player){
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