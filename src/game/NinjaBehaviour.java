package game;

import edu.monash.fit2099.engine.*;

public class NinjaBehaviour extends FollowBehaviour implements ActionFactory{
    
    private Actor target;

    public NinjaBehaviour(Actor subject) {
		this.target = subject;
	}

}