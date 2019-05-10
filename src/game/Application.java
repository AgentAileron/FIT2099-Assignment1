package game;

import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.engine.*;

/**
 * Main game driver - initialises world and handles all calls (contains main)
 * 
 * @author      Rithesh Jayaram <RJAY0006@student.monash.edu> 
 * @author      Sarah Dennis <sden0009@student.monash.edu>
 * @version     1.0
 * @since       1.0
 */
public class Application {

	public static void main(String[] args) {
		World world = new World(new Display());

		FancyGroundFactory groundFactory = new FancyGroundFactory(new Floor(), new Wall(), new Door(), new RocketPad(), new Rocket());
		GameMap gameMap;

		List<String> map = Arrays.asList(
			".................................",
			"...#####D#####....###............",
			"...#.........#.....#.............",
			"...#.........#...........#.#.#...",
			"...#......###...........#.....#..",
			"...##D#####..............#...#...",
			"..............#.#....##..#...#...",
			"..............###....#...........",
			".........#.....#.............#...",
			"..#......#.....#.................",
			".........###.........#######.....",
			"....................#.......#....",
			".....#..............D...=...#....",
			"...........#........#.......#....",
			"....................#########....");
		gameMap = new GameMap(groundFactory, map);
		world.addMap(gameMap);
		
		Actor player = new Player("Player", '@', 1, 100);
		world.addPlayer(player, gameMap, 4, 19);
		
		Grunt testGoon = new Goon("Mongo", player);
		gameMap.addActor(testGoon, 0, 0);

		Ninja testNinja = new Ninja("Norbert", player);
		gameMap.addActor(testNinja, 14, 12);

		Grunt testGrunt = new Grunt("Obediah", player);
		gameMap.addActor(testGrunt, 10, 5);
		
		Actor testQ = new Qnpc(player);
		gameMap.addActor(testQ, 27, 4);
		
		// TEMP - DEBUG ONLY
		player.addItemToInventory(new WeaponItem("debug cannon", '>', 999, "kills"));

		
		Item body = new Item("Rocket Body", 'h');
		Item engine = new Item("Rocket Engine", 'e');
		Item plan = new Item("Rocket Plan", 'p');
		
		testGoon.addItemToInventory(Item.newInventoryItem("Key", '$'));
		testGrunt.addItemToInventory(Item.newInventoryItem("Key", '$'));
		
		gameMap.addItem(plan, 6, 3);
		
		Miniboss miniboss = new Miniboss("Dr Maybe", player);
		miniboss.addItemToInventory(Item.newInventoryItem("Rocket Engine", 'e'));
		gameMap.addActor(miniboss, 26, 12);

		gameMap.addItem(body, 2, 1);
			
		world.run();
		
	}
}
