package game;

import edu.monash.fit2099.engine.*;

public class AllowableActionsForQ extends Ground {

	public AllowableActionsForQ() {
		super('q');
	}
	
	@Override
	public Actions allowableActions(Actor actor, Location location, String direction){
		Actions actions = new Actions();
		actions.add(new TalkToQ(actor));
		actions.add(new GivePlanAction(actor));
		return actions;
	}
	
	@Override
	public boolean canActorEnter(Actor actor) {
		if (actor.getDisplayChar() == 'Q')
			return true;
		else
			return false;
	}
	
	@Override
	public boolean blocksThrownObjects() {
		return false;
	}

}
