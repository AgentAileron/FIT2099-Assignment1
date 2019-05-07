package game;
import edu.monash.fit2099.engine.*;

public class InsultBehavior extends Action implements ActionFactory{

    @Override
	public Action getAction(Actor actor, GameMap map) {
        // TODO
        return null;
    }

    @Override
	public String execute(Actor actor, GameMap map) {
		return menuDescription(actor);
	}

	@Override
	public String menuDescription(Actor actor) {
        String output = actor + " hurls an insult! :\n";
        return output;
	}

	@Override
	public String hotKey() {
		return "";
	}
}