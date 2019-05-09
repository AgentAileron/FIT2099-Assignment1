package game;

import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.engine.*;
import game.Door;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Application {

	public static void main(String[] args) {
		World world = new World(new Display());

		FancyGroundFactory groundFactory = new FancyGroundFactory(new Floor(), new Wall(), new Door(), new RocketPad(), new Rocket());
		GameMap gameMap;

		List<String> map = Arrays.asList(
				".......................",
				"....#####....######....",
				"....#...#....#....#....",
				"....#...D....#....#....",
				"....#####....##D###....",
				".......................",
				".......................",
				".......................",
				".......................",
				"...................=...",
				".......................");
		gameMap = new GameMap(groundFactory, map);
		world.addMap(gameMap);
		
		Actor player = new Player("Player", '@', 1, 100);
		world.addPlayer(player, gameMap, 2, 15);
		
		Grunt testGoon = new Goon("Mongo", player);
		gameMap.addActor(testGoon, 0, 0);

		Ninja testNinja = new Ninja("Norbert", player);
		gameMap.addActor(testNinja, 10, 10);

		Grunt testGrunt = new Grunt("Obediah", player);
		gameMap.addActor(testGrunt, 10, 5);
		
		// TEMP - DEBUG ONLY
		player.addItemToInventory(new WeaponItem("debug cannon", '>', 999, "kills"));

		
		Item body = new Item("Rocket Body", 'h');
		Item engine = new Item("Rocket Engine", 'e');
		Item plan = new Item("Rocket Plan", 'p');
		
		testGoon.addItemToInventory(key);
		gameMap.addItem(body, 2, 1);
			
		world.run();
		
		
	}
}
