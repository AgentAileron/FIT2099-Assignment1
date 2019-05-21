package game;

import edu.monash.fit2099.engine.*;

/**
 * Behaviour special to certain hostile NPCs
 * Doesn't affect game environment, passes an insult text to the console
 * 
 * @author      Rithesh Jayaram <RJAY0006@student.monash.edu> 
 * @author      Sarah Dennis <SDEN0009@student.monash.edu>
 * @version     1.0
 * @since       1.0
 */
public class InsultBehavior extends Action implements ActionFactory{

	private Actor target;

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
			"This is the end, Mr Bond.",
			"FIGHT ME TOVARISH",
			"Who send all these babby to fight?",
			"My name &&& - I will consume the moon, blin.",
			"My drill shaft is long and hard, and it will penetrate the moon many times, blin",
			"Babushka, your son &&& will bring the moon mayonez...",
			"Put up your feests, cyka",
			"The moon's mayonez is mine, blyat",
			"Hoho, I heff you now Mr Bond. bit.ly/HoiTher",
			"You heff done enough Mr Bond. Goodbye.",
			"I am inevitable"
		};

	public InsultBehavior(Actor subject){
		this.target = subject;
	}

    @Override
	public Action getAction(Actor actor, GameMap map) {
		// 10% chance of insult
		if (Math.random() < 0.1){
			if (map.locationOf(target) != null){
				return this;
			}
		}
		return null;
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
