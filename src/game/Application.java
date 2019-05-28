package game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.engine.*;

/**
 * Main game driver - initialises world and handles all calls (contains main)
 * 
 * @author      Rithesh Jayaram <RJAY0006@student.monash.edu> 
 * @author      Sarah Dennis <SDEN0009@student.monash.edu>
 * @version     1.0
 * @since       1.0
 */
public class Application {

	/**
	 * Main program loop for runtime
	 * Note that all locations, and their placed NPCs, items, and ground panels are initialised here
	 */
	public static void main(String[] args) {
		World world = new World(new Display());
		
		FancyGroundFactory groundFactory = new FancyGroundFactory(new Floor(), new Wall(), new Door(), new RocketPad(), new Rocket(), new WaterPool(), new OxygenDispenser());

		// -- CREATE MAPS -------------------------------------------------------------------- //

		GameMap lairMap;
		List<String> lairMapString = Arrays.asList(
			".................................",
			"...#####D#####....###............",
			"=..#.........#.....#.............",
			"...#.........#...........#.#.#...",
			"...#......###...........#.....#..",
			"...##D#####..............#...#...",
			"..............#.#....##..#...#...",
			"..............###....#...........",
			".........#.....#.............#...",
			"..#......#.....#.................",
			".........###.........#######.....",
			"....................#.......#....",
			".....#..............D.......#....",
			".╬.........#........#.......#....",
			"....................#########....");
		
		lairMap = new GameMap(groundFactory, lairMapString);
		world.addMap(lairMap);
		
		GameMap moonMap;
		List<String> moonMapString = Arrays.asList(
			".......R..",
			"..........",
			".&........",
			".......&..",
			"..........",
			"..........",
			".&........",
			"..........",
			"........&.",
			"..........");
	
		moonMap = new GameMap(groundFactory, moonMapString);
		world.addMap(moonMap);
		
		List<GameMap> maps = new ArrayList<GameMap>();
		maps.add(lairMap);
		maps.add(moonMap);
		

		// -- CREATE ACTORS ------------------------------------------------------------------ //

		Actor player = new FancyPlayer("Player", '@', 1, 100, maps);	// Player instance
		world.addPlayer(player, lairMap, 4, 19);

		Actor yugo = new FinalBoss("Yugo Maxx", player);
		moonMap.addActor(yugo, 0, 0);

		Actor miniboss = new Miniboss("Dr Maybe", player);
		lairMap.addActor(miniboss, 26, 12);
		
		Actor testGoon = new Goon("Mongo", player);
		lairMap.addActor(testGoon, 1, 1);

		Actor testNinja = new Ninja("Norbert", player);
		lairMap.addActor(testNinja, 14, 12);

		Actor testGrunt = new Grunt("Obediah", player);
		lairMap.addActor(testGrunt, 10, 5);
		
		Actor testQ = new Qnpc(player);
		lairMap.addActor(testQ, 27, 4);
		

		// -- CREATE ITEMS ------------------------------------------------------------------- //

		Item wristwatchLazer = new WeaponItem("Wristwatch Lazer", '>', 20, "burns");
		Item body = new Item("Rocket Body", 'h');
		Item engine = new Item("Rocket Engine", 'e');
		Item plan = new Item("Rocket Plan", 'p');
		Item exoskeleton = new Item("Exo-skeleton", 'x');
		Item spacesuit = new Item("Space Suit", '8');
		
		Item waterpistol = new Item("Water Pistol", '~');
		waterpistol.addSkill(WaterPistolCharge.EMPTY);

		/*
		player.addItemToInventory(Item.newInventoryItem("Engine", 'e'));
		player.addItemToInventory(Item.newInventoryItem("Body", 'h'));
		player.addItemToInventory(Item.newInventoryItem("Space Suit", '8'));
		player.addItemToInventory(Item.newInventoryItem("Oxygen Tank", 'o'));
		Item w = Item.newInventoryItem("Water Pistol", '~');
		w.addSkill(WaterPistolCharge.EMPTY);
		player.addItemToInventory(w);
		*/
		
		yugo.addItemToInventory(exoskeleton);

		miniboss.addItemToInventory(engine);
		testGoon.addItemToInventory(Item.newInventoryItem("Key", '$'));
		testGrunt.addItemToInventory(Item.newInventoryItem("Key", '$'));
		
		lairMap.addItem(wristwatchLazer, 8, 2);
		lairMap.addItem(body, 2, 1);
		lairMap.addItem(plan, 7, 4);
		lairMap.addItem(waterpistol, 16, 8);
		

		// -- RUNTIME AND TERMINATION -------------------------------------------------------- //
		world.run();
		System.out.println("\n𝕋𝕙𝕒𝕟𝕜𝕤 𝕗𝕠𝕣 𝕡𝕝𝕒𝕪𝕚𝕟𝕘 !");
	}
}
