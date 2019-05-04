package game;

import java.util.ArrayList;

public class KeyManager {
	
	private ArrayList<Key> createdKeys = new ArrayList<Key>();
	private int numberOfKeys = 0;

	public KeyManager() {}
	
	public void assignKey(Door targetDoor) {
		String keyID = String.valueOf(numberOfKeys + 1);

		Key newKey = new Key("Door Key", keyID);
		targetDoor.setKey(newKey);
		createdKeys.add(newKey);
	}

}
