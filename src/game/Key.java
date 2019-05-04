package game;

import edu.monash.fit2099.engine.Item;

public class Key extends Item {
	private String keyId;
	
	public Key(String name, String keyId) {
		super(name, '$');
		this.keyId = keyId;
	}
	
	/**
	 * Checks if given key is the same as this key
	 * @param keyToCheck
	 * @return boolean
	 */
	public boolean isSameKey(Key keyToCheck) {
		if (keyToCheck.keyId == keyId)
			return true;
		else
			return false;
	}
	
	public String getID() {
		return keyId;
	}

}
