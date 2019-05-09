package game;

import edu.monash.fit2099.engine.*;

public class InsultBehavior extends Action implements ActionFactory{

	// Contains list of possible insults
	private static String[] Insults = {
		"You fool, you will perish at the hands of &&&!",
		"Doom approaches!",
		"I smell your fear!"
		};

	public InsultBehavior(){
	}

    @Override
	public Action getAction(Actor actor, GameMap map) {
		// 10% chance of insult
		if (Math.random() < 0.1){
			return this;
		}else{
			return null;
		}
    }

    @Override
	public String execute(Actor actor, GameMap map) {
			String output = actor + " shouts: " + randInsult();
			output = output.replace("&&&", actor.toString());
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

	private String randInsult(){
		
		// If no insults defined return default insult
		if (Insults.length == 0){
			return "Grr!";
		}

		// Pick random insult from array and return it
		Integer randIndex = (int)(Math.random() * Insults.length);
		return Insults[randIndex];
	}
}