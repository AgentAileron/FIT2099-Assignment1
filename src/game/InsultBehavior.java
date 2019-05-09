package game;

import java.io.*;
import java.util.ArrayList;

import edu.monash.fit2099.engine.*;

public class InsultBehavior extends Action implements ActionFactory{

	public InsultBehavior(){
	}

    @Override
	public Action getAction(Actor actor, GameMap map) {
		// 10% chance of insult
		if (Math.random() < 1.0){
			return this;
		}else{
			return null;
		}
    }

    @Override
	public String execute(Actor actor, GameMap map) {
			String output = actor + " hurls an insult: " + randInsult();
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
		final ArrayList<String> Insults = new ArrayList<String>();

		// Read in from file on first call (cache values)
		if (Insults.size() == 0){
			try{
				// Buffered reader kinda overkill, but good practice / future proofing
				FileReader reader = new FileReader("./src/game/Insults.txt");
				BufferedReader br = new BufferedReader(reader);
				
				String line = br.readLine();

				while (line != null) {
					Insults.add(line);
					line = br.readLine();
				}

				br.close();
			} catch (IOException e) {
				// Do nothing - empty / missing files handled below
				System.out.println("Err in reading insult file");	// TEMP
			}
		}

		// If still no insults (empty / missing file) return default insult
		if (Insults.size() == 0){
			return "Grr!";
		}

		// Pick random insult and return
		Integer randIndex = (int)(Math.random() * Insults.size());
		return Insults.get(randIndex);
	}
}