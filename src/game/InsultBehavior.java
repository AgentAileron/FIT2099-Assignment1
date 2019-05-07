package game;

import com.sun.corba.se.impl.orbutil.closure.Constant;

import edu.monash.fit2099.engine.*;

public class InsultBehavior extends Action implements ActionFactory{

    @Override
	public String execute(Actor actor, GameMap map) {
        String output = actor + " hurls an insult! :\n";

        return output;
	}

    @Override
	public Action getAction(Actor actor, GameMap map) {
        // TODO
        return null;
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