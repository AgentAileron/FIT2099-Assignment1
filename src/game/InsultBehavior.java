package game;

import edu.monash.fit2099.engine.*;

/**
 * Behaviour special to Goon - doesn't affect game environment, passes an insult text to the console
 * 
 * @author      Rithesh Jayaram <RJAY0006@student.monash.edu> 
 * @author      Sarah Dennis <SDEN0009@student.monash.edu>
 * @version     1.0
 * @since       1.0
 */
public class InsultBehavior extends Action implements ActionFactory{

	// Contains list of possible insults
	private static String[] GoonInsults = {
		"You fool, you will perish at the hands of &&&!",
		"Doom approaches!",
		"I smell your fear!",
		"You can run, but &&& will find you COWARD!!",
		"You've drawn your final breath, Mr Bond",
		"YOU WILL PERISH BENEATH THE BOOT OF &&&"
		};

	private static String[] YugoInsults = {
		};

	public InsultBehavior(){}

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
			String[] insultSet = {};
			if (actor instanceof Goon){
				insultSet = GoonInsults;
			}else if (actor instanceof FinalBoss){
				insultSet = YugoInsults;
			}

			String output = actor + " shouts: " + randInsult(insultSet);
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

	private String randInsult(String[] insultSet){
		// If no insults defined return default insult
		if (insultSet.length == 0){
			return "Grr!";
		}

		// Pick random insult from array and return it
		Integer randIndex = (int)(Math.random() * insultSet.length);
		return insultSet[randIndex];
	}
}