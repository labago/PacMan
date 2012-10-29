import java.awt.Color;

import java.util.ArrayList;
import idraw.*;
import geometry.*;

public class Gameworld extends World {
	ArrayList<Numbers> scores = new ArrayList<Numbers>(0);
	PacMan pacman = new PacMan(false, "Right", new Posn(200, 370));
	ArrayList<Wall> walls = new ArrayList<Wall>(0);
	ArrayList<Food> food = new ArrayList<Food>(0);
	ArrayList<BigFood> bigFood = new ArrayList<BigFood>(0);
	ArrayList<Fruit> fruits = new ArrayList<Fruit>(0);
	boolean pause = true;
	boolean endGame = false;
	boolean flash = false;
	Color background = Color.darkGray;
	Color background2 = Color.lightGray;
	Color wallColor = Color.blue;
	String nextDir;
	int score = 0;
	int lives = 3;
	int level = 1;
	int tickCount = 0;
	int menuTickCount = 0;
	String lastVertDir = "None";
	String lastHorDir = "None";
	boolean chomp = true;
	int chompCounter = 0;
	boolean edible = false;
	int mult = 0;
	Ghost inky = new Ghost("inky", Color.cyan, "Up", new Posn(170, 300), true,
			600, this.inkySpeed);
	Ghost blinky = new Ghost("blinky", Color.red, "Up", new Posn(200, 300),
			true, 200, this.blinkySpeed);
	Ghost pinky = new Ghost("pinky", Color.pink, "Up", new Posn(200, 250),
			false, 0, this.pinkySpeed);
	Ghost clyde = new Ghost("clyde", Color.orange, "Up", new Posn(230, 300),
			true, 1000, this.clydeSpeed);
	String nextWanderDirFruit = "Up";
	String nextWanderDirPinky = "Up";
	String nextWanderDirInky = "Up";
	String nextWanderDirBlinky = "Down";
	String nextWanderDirClyde = "Down";
	String nextFindDirBlinky = "None";
	String nextFindDirClyde = "None";
	boolean blinkySearchHor = false;
	boolean blinkySearchVert = false;
	boolean clydeSearchHor = false;
	boolean clydeSearchVert = false;
	int searchTimerBlinky = 800;
	int searchTimerClyde = 800;
	int immuneTime = 0;
	int pauseTime = 0;
	boolean reset = false;
	boolean bonusLevelOne = true;
	int bonusTimeLeft = 9000;
	int blinkySpeed = 1;
	int inkySpeed = 1;
	int pinkySpeed = 1;
	int clydeSpeed = 1;
	boolean extraLifeOne = false;
	boolean extraLifeTwo = false;
	boolean extraLifeThree = false;
	boolean extraLifeFour = false;
	boolean extraLifeFive = false;
	boolean extraLifeSix = false;
	boolean gameOver = false;
	boolean infoScreen = false;
	boolean menuScreen = true;
	boolean menuGhostsPlaced = false;
	boolean beginning = true;
	boolean fruitForLevel = false;
	Fruit fruit = new Fruit("Cherry", 100, new Posn(200, 370), 100000, false);
	int fruitCounter = 0;
	int dotCounter = 0;
	int ghostCounter = 0;
	int gameOverTickCount = 0;

	public Gameworld() {
		this.nextDir = this.pacman.dir;
	}

	public static int WALL_WIDTH = 20;
	
	public void resetLife() {   
		this.pause = true;
		this.endGame = false;
		this.flash = false;
		this.lives = this.lives - 1;
		if(this.lives == -1){
			//this.food.clear();
			//this.bigFood.clear();
			this.walls.clear();
			this.pause = false;
			this.gameOver = true;
			this.initFruits();
		}
		this.tickCount = 0;
		this.chomp = true;
		this.edible = false;
		this.mult = 0;
		this.inky = new Ghost("inky", Color.cyan, "Up", new Posn(170, 300),
				true, 600, this.inkySpeed);
		this.blinky = new Ghost("blinky", Color.red, "Up", new Posn(200, 300),
				true, 200, this.blinkySpeed);
		this.pinky = new Ghost("pinky", Color.pink, "Up", new Posn(200, 250),
				false, 0, this.pinkySpeed);
		this.clyde = new Ghost("clyde", Color.orange, "Up", new Posn(230, 300),
				true, 1000, this.clydeSpeed);
		this.pacman = new PacMan(this.pacman.gender, "Right",
				new Posn(200, 370));
		this.nextWanderDirPinky = "Up";
		this.nextWanderDirInky = "Up";
		this.blinkySearchHor = false;
		this.blinkySearchVert = false;
		this.clydeSearchHor = false;
		this.clydeSearchVert = false;
		this.searchTimerBlinky = 800;
		this.searchTimerClyde = 800;
		this.immuneTime = 0;
		this.pauseTime = 0;
	}

	public void resetGame() { 
		
		this.pause = true;
		this.level = 1;
		this.endGame = false;
		this.flash = false;
		this.lives = 3;
		this.score = 0;
		this.tickCount = 0;
		this.chomp = true;
		this.edible = false;
		this.mult = 0;
		this.inky = new Ghost("inky", Color.cyan, "Up", new Posn(170, 300),
				true, 600, this.inkySpeed);
		this.blinky = new Ghost("blinky", Color.red, "Up", new Posn(200, 300),
				true, 200, this.blinkySpeed);
		this.pinky = new Ghost("pinky", Color.pink, "Up", new Posn(200, 250),
				false, 0, this.pinkySpeed);
		this.clyde = new Ghost("clyde", Color.orange, "Up", new Posn(230, 300),
				true, 1000, this.clydeSpeed);
		this.pacman = new PacMan(this.pacman.gender, "Right",
				new Posn(200, 370));
		this.nextWanderDirPinky = "Up";
		this.nextWanderDirInky = "Up";
		this.blinkySearchHor = false;
		this.blinkySearchVert = false;
		this.clydeSearchHor = false;
		this.clydeSearchVert = false;
		this.searchTimerBlinky = 800;
		this.searchTimerClyde = 800;
		this.immuneTime = 0;
		this.pauseTime = 0;
		this.walls.clear();
		this.food.clear();
		this.bigFood.clear();
		this.fruits.clear();
		this.menuScreen = true;
		this.menuGhostsPlaced = false;
		this.beginning = true;
		this.blinkySpeed = 3;
		this.inkySpeed = 3;
		this.pinkySpeed = 3;
		this.clydeSpeed = 3;
		this.gameOver = false;
		this.dotCounter = 0;
		this.ghostCounter = 0;
		this.fruitCounter = 0;
	}

	public void resetWin() {
		this.pause = true;
		this.endGame = false;
		this.flash = false;
		this.tickCount = 0;
		this.chomp = true;
		this.edible = false;
		this.mult = 0;
		this.inky = new Ghost("inky", Color.cyan, "Up", new Posn(170, 300),
				true, 600, this.inkySpeed);
		this.blinky = new Ghost("blinky", Color.red, "Up", new Posn(200, 300),
				true, 200, this.blinkySpeed);
		this.pinky = new Ghost("pinky", Color.pink, "Up", new Posn(200, 250),
				false, 0, this.pinkySpeed);
		this.clyde = new Ghost("clyde", Color.orange, "Up", new Posn(230, 300),
				true, 1000, this.clydeSpeed);
		this.pacman = new PacMan(this.pacman.gender, "Right",
				new Posn(200, 370));
		this.nextWanderDirPinky = "Up";
		this.nextWanderDirInky = "Up";
		this.blinkySearchHor = false;
		this.blinkySearchVert = false;
		this.clydeSearchHor = false;
		this.clydeSearchVert = false;
		this.searchTimerBlinky = 800;
		this.searchTimerClyde = 800;
		this.immuneTime = 0;
		this.pauseTime = 0;
		this.initFoodOne();
		this.initBigFoodOne();
	}
	
	public void updateDisplayNumbersTimers(){
		for(int i = 0; i < this.scores.size(); i ++){
			if(!(this.scores.get(i).displayTime == 0)){
				this.scores.get(i).displayTime = this.scores.get(i).displayTime - 1;
			}
		}
	}
	
	public void removeNumbers(){
		for(int i = 0; i < this.scores.size(); i ++){
			if(this.scores.get(i).displayTime == 0){
				this.scores.remove(i);
			}
		}
	}

	public void updateSpeed() {
		if (this.level == 2) {
			this.clydeSpeed = 2;
		}
		if (this.level == 3) {
			this.inkySpeed = 2;
		}
		if (this.level == 5) {
			this.inkySpeed = 2;
		}
		if (this.level == 6) {
			this.blinkySpeed = 2;
		}
		if (this.level == 7) {
			this.clydeSpeed = 1;
		}
		if (this.level == 9) {
			this.clydeSpeed = 1;
		}
		if (this.level == 10) {
			this.blinkySpeed = 1;
		}
		if (this.level == 11) {
			this.clydeSpeed = 1;
			this.blinkySpeed = 1;
			this.inkySpeed = 1;
			this.pinkySpeed = 1;
		}
	}
	
	public void updateFruit() {
		if (this.level == 2 || this.level == 11) {
			this.fruit = new Fruit("Strawberry", 300, new Posn(200, 370), 3000, false); 
		}
		if (this.level == 3 || this.level == 13) {
			this.fruit = new Fruit("Peach", 500, new Posn(200, 370), 2000, false);
		}
		if (this.level == 4 || this.level == 15) {
			this.fruit = new Fruit("Apple", 700, new Posn(200, 370), 1500, false);
		}
		if (this.level == 5 || this.level == 6 || this.level == 17) {
			this.fruit = new Fruit("Grapes", 1000, new Posn(200, 370), 1000, false);
		}
		if (this.level == 7 ||  this.level == 8 || this.level == 9 || this.level == 19) {
			this.fruit = new Fruit("Galaxian Boss", 2000, new Posn(200, 370), 500, false);
		}
		if (this.level == 10 ||  this.level == 11 || this.level == 12 || this.level == 20) {
			this.fruit = new Fruit("Bell", 4000, new Posn(200, 370), 0, false);
		}
	}

	public void updateLives() {
		if (this.score >= 10000 && !(this.extraLifeOne)) {
			this.lives = this.lives + 1;
			this.extraLifeOne = true;
		}
		if (this.score >= 17500 && !(this.extraLifeTwo)) {
			this.lives = this.lives + 1;
			this.extraLifeTwo = true;
		}
		if (this.score >= 25000 && !(this.extraLifeThree)) {
			this.lives = this.lives + 1;
			this.extraLifeThree = true;
		}
		if (this.score >= 45000 && !(this.extraLifeFour)) {
			this.lives = this.lives + 1;
			this.extraLifeFour = true;
		}
		if (this.score >= 75000 && !(this.extraLifeFive)) {
			this.lives = this.lives + 1;
			this.extraLifeFive = true;
		}
		if (this.score >= 100000 && !(this.extraLifeSix)) {
			this.lives = this.lives + 1;
			this.extraLifeSix = true;
		}
	}

	public void updateLevel() {
		if(!(this.gameOver)){
		if(this.beginning){
			this.wallColor = Color.blue;
			this.initMainLevel();
			this.beginning = false;
		}
		if (!(this.pauseTime == 0)) {
			this.pauseTime = this.pauseTime - 1;
			if (this.reset && this.pauseTime == 1) {
				this.resetLife();
				this.reset = false;
			}
		}
		if (this.food.size() == 0 && this.bigFood.size() == 0 && !(this.beginning)) {
			if (this.level == 3 || this.level == 6 || this.level == 9 || this.level == 12 || this.level == 15) {
				this.bonusLevelOne = true;
				this.bonusTimeLeft = 9000;
				this.initBonuslevel();
			} else {
				this.level = this.level + 1;
				this.updateSpeed();
				this.updateFruit();
				this.updateWallColor();
				this.bonusLevelOne = false;
				this.fruitForLevel = false;
				this.initMainLevel();
				this.resetWin();
			}
		}
		if (this.bonusLevelOne && this.bonusTimeLeft == 0) {
			this.level = this.level + 1;
			this.updateSpeed();
			this.updateFruit();
			this.updateWallColor();
			this.bonusLevelOne = false;
			this.fruitForLevel = false;
			this.initMainLevel();
			this.resetWin();
		}
		}
	}

	public void updateWallColor() {
		if (this.level == 2 || this.level == 9 || this.level == 16) {
			this.wallColor = Color.green;
		}
		if (this.level == 3 || this.level == 10 || this.level == 17) {
			this.wallColor = Color.yellow;
		}
		if (this.level == 4 || this.level == 11 || this.level == 18) {
			this.wallColor = Color.orange;
		}
		if (this.level == 5 || this.level == 12 || this.level == 19) {
			this.wallColor = Color.pink;
		}
		if (this.level == 6 || this.level == 13 || this.level == 20) {
			this.wallColor = Color.red;
		}
		if (this.level == 7 || this.level == 14 || this.level == 21) {
			this.wallColor = Color.cyan;
		}
		if (this.level == 8 || this.level == 15 || this.level == 22) {
			this.wallColor = Color.lightGray;
		}
	}

	public void initMazeOne() {
		this.walls.clear();
		this.walls.add(new Wall(this.wallColor, new Posn(0, 0), 300,
				Gameworld.WALL_WIDTH));
		// left side portal
		this.walls.add(new Wall(this.wallColor, new Posn(0, 320), 280,
				Gameworld.WALL_WIDTH));

		this.walls.add(new Wall(this.wallColor, new Posn(380, 0), 300,
				Gameworld.WALL_WIDTH));
		// right side portal
		this.walls.add(new Wall(this.wallColor, new Posn(380, 320), 280,
				Gameworld.WALL_WIDTH));

		this.walls.add(new Wall(this.wallColor, new Posn(20, 0),
				Gameworld.WALL_WIDTH, 360));
		this.walls.add(new Wall(this.wallColor, new Posn(20, 580),
				Gameworld.WALL_WIDTH, 360));

		this.walls.add(new Wall(this.wallColor, new Posn(40, 40),
				Gameworld.WALL_WIDTH, 100));
		this.walls.add(new Wall(this.wallColor, new Posn(40, 60), 80,
				Gameworld.WALL_WIDTH));

		this.walls.add(new Wall(this.wallColor, new Posn(260, 40),
				Gameworld.WALL_WIDTH, 100));
		this.walls.add(new Wall(this.wallColor, new Posn(340, 60), 80,
				Gameworld.WALL_WIDTH));

		this.walls.add(new Wall(this.wallColor, new Posn(260, 540),
				Gameworld.WALL_WIDTH, 100));
		this.walls.add(new Wall(this.wallColor, new Posn(340, 460), 80,
				Gameworld.WALL_WIDTH));

		this.walls.add(new Wall(this.wallColor, new Posn(40, 540),
				Gameworld.WALL_WIDTH, 100));
		this.walls.add(new Wall(this.wallColor, new Posn(40, 460), 80,
				Gameworld.WALL_WIDTH));

		// ghost box

		this.walls.add(new Wall(this.wallColor, new Posn(160, 340),
				Gameworld.WALL_WIDTH, 80));
		this.walls.add(new Wall(this.wallColor, new Posn(160, 320),
				Gameworld.WALL_WIDTH, 80));
		this.walls.add(new Wall(this.wallColor, new Posn(140, 260), 100,
				Gameworld.WALL_WIDTH));
		this.walls.add(new Wall(this.wallColor, new Posn(240, 260), 100,
				Gameworld.WALL_WIDTH));
		this.walls.add(new Wall(this.wallColor, new Posn(220, 260), 20,
				Gameworld.WALL_WIDTH));
		this.walls.add(new Wall(this.wallColor, new Posn(160, 260), 20,
				Gameworld.WALL_WIDTH));

		// 4 corner squares
		this.walls.add(new Wall(this.wallColor, new Posn(80, 80), 60, 60));
		this.walls.add(new Wall(this.wallColor, new Posn(260, 80), 60, 60));
		this.walls.add(new Wall(this.wallColor, new Posn(260, 460), 60, 60));
		this.walls.add(new Wall(this.wallColor, new Posn(80, 460), 60, 60));

		this.walls.add(new Wall(this.wallColor, new Posn(300, 340), 80,
				Gameworld.WALL_WIDTH));
		this.walls.add(new Wall(this.wallColor, new Posn(320, 340), 80,
				Gameworld.WALL_WIDTH));
		this.walls.add(new Wall(this.wallColor, new Posn(280, 340), 80,
				Gameworld.WALL_WIDTH));
		this.walls.add(new Wall(this.wallColor, new Posn(280, 320),
				Gameworld.WALL_WIDTH, 80));
		this.walls.add(new Wall(this.wallColor, new Posn(280, 420),
				Gameworld.WALL_WIDTH, 80));
		this.walls.add(new Wall(this.wallColor, new Posn(360, 360), 40,
				Gameworld.WALL_WIDTH));

		this.walls.add(new Wall(this.wallColor, new Posn(60, 340), 80,
				Gameworld.WALL_WIDTH));
		this.walls.add(new Wall(this.wallColor, new Posn(80, 340), 80,
				Gameworld.WALL_WIDTH));
		this.walls.add(new Wall(this.wallColor, new Posn(100, 340), 80,
				Gameworld.WALL_WIDTH));
		this.walls.add(new Wall(this.wallColor, new Posn(40, 320),
				Gameworld.WALL_WIDTH, 80));
		this.walls.add(new Wall(this.wallColor, new Posn(40, 420),
				Gameworld.WALL_WIDTH, 80));
		this.walls.add(new Wall(this.wallColor, new Posn(20, 360), 40,
				Gameworld.WALL_WIDTH));

		this.walls.add(new Wall(this.wallColor, new Posn(40, 220),
				Gameworld.WALL_WIDTH, 150));
		this.walls.add(new Wall(this.wallColor, new Posn(210, 220),
				Gameworld.WALL_WIDTH, 150));

		this.walls.add(new Wall(this.wallColor, new Posn(300, 260), 40,
				Gameworld.WALL_WIDTH));
		this.walls.add(new Wall(this.wallColor, new Posn(320, 260), 40,
				Gameworld.WALL_WIDTH));
		this.walls.add(new Wall(this.wallColor, new Posn(280, 260), 40,
				Gameworld.WALL_WIDTH));
		this.walls.add(new Wall(this.wallColor, new Posn(360, 260), 40,
				Gameworld.WALL_WIDTH));

		this.walls.add(new Wall(this.wallColor, new Posn(60, 260), 40,
				Gameworld.WALL_WIDTH));
		this.walls.add(new Wall(this.wallColor, new Posn(80, 260), 40,
				Gameworld.WALL_WIDTH));
		this.walls.add(new Wall(this.wallColor, new Posn(100, 260), 40,
				Gameworld.WALL_WIDTH));
		this.walls.add(new Wall(this.wallColor, new Posn(20, 260), 40,
				Gameworld.WALL_WIDTH));

		this.walls.add(new Wall(this.wallColor, new Posn(160, 460), 100,
				Gameworld.WALL_WIDTH));
		this.walls.add(new Wall(this.wallColor, new Posn(180, 460), 100,
				Gameworld.WALL_WIDTH));
		this.walls.add(new Wall(this.wallColor, new Posn(200, 460), 100,
				Gameworld.WALL_WIDTH));
		this.walls.add(new Wall(this.wallColor, new Posn(220, 460), 100,
				Gameworld.WALL_WIDTH));

		this.walls.add(new Wall(this.wallColor, new Posn(160, 40), 100,
				Gameworld.WALL_WIDTH));
		this.walls.add(new Wall(this.wallColor, new Posn(180, 40), 100,
				Gameworld.WALL_WIDTH));
		this.walls.add(new Wall(this.wallColor, new Posn(200, 40), 100,
				Gameworld.WALL_WIDTH));
		this.walls.add(new Wall(this.wallColor, new Posn(220, 40), 100,
				Gameworld.WALL_WIDTH));

		this.walls.add(new Wall(this.wallColor, new Posn(160, 380), 60,
				Gameworld.WALL_WIDTH));
		this.walls.add(new Wall(this.wallColor, new Posn(180, 380), 60,
				Gameworld.WALL_WIDTH));
		this.walls.add(new Wall(this.wallColor, new Posn(200, 380), 60,
				Gameworld.WALL_WIDTH));
		this.walls.add(new Wall(this.wallColor, new Posn(220, 380), 60,
				Gameworld.WALL_WIDTH));

		this.walls.add(new Wall(this.wallColor, new Posn(140, 380), 60,
				Gameworld.WALL_WIDTH));
		this.walls.add(new Wall(this.wallColor, new Posn(240, 380), 60,
				Gameworld.WALL_WIDTH));

		this.walls.add(new Wall(this.wallColor, new Posn(40, 180),
				Gameworld.WALL_WIDTH, 320));
		this.walls.add(new Wall(this.wallColor, new Posn(40, 160),
				Gameworld.WALL_WIDTH, 320));
	}

	public void initBonusMaze() {
		this.walls.clear();
		this.walls.add(new Wall(this.wallColor, new Posn(0, 0), 300,
				Gameworld.WALL_WIDTH));
		// left side portal
		this.walls.add(new Wall(this.wallColor, new Posn(0, 320), 280,
				Gameworld.WALL_WIDTH));

		this.walls.add(new Wall(this.wallColor, new Posn(380, 0), 300,
				Gameworld.WALL_WIDTH));
		// right side portal
		this.walls.add(new Wall(this.wallColor, new Posn(380, 320), 280,
				Gameworld.WALL_WIDTH));

		this.walls.add(new Wall(this.wallColor, new Posn(20, 0),
				Gameworld.WALL_WIDTH, 360));
		this.walls.add(new Wall(this.wallColor, new Posn(20, 580),
				Gameworld.WALL_WIDTH, 360));

		for (int j = 0; j < 9; j++) {
			for (int i = 0; i < 14; i++) {
				this.walls.add(new Wall(this.wallColor, new Posn(40 + (j * 40),
						40 + (i * 40)), Gameworld.WALL_WIDTH, 20));
			}
		}
	}
	
	public void initFruits(){
		this.fruits.add(new Fruit("Cherry", 300, new Posn(200, 370), 150, false));
		this.fruits.add(new Fruit("Strawberry", 300, new Posn(200, 370), 300, false));
		this.fruits.add(new Fruit("Peach", 300, new Posn(200, 370), 450, false));
		this.fruits.add(new Fruit("Apple", 300, new Posn(200, 370), 600, false));
		this.fruits.add(new Fruit("Grapes", 300, new Posn(200, 370), 750, false));
		this.fruits.add(new Fruit("Galaxian Boss", 300, new Posn(200, 370), 900, false));
		this.fruits.add(new Fruit("Bell", 300, new Posn(200, 370), 1050, false));
	}
	
	public void initMenuMaze(){
		this.wallColor = Color.LIGHT_GRAY;
		
		this.walls.add(new Wall(this.wallColor, new Posn(40, 340), 260, Gameworld.WALL_WIDTH));
		this.walls.add(new Wall(this.wallColor, new Posn(440, 340), 260, Gameworld.WALL_WIDTH));
		
		this.walls.add(new Wall(this.wallColor, new Posn(80, 380), 180, Gameworld.WALL_WIDTH));
		this.walls.add(new Wall(this.wallColor, new Posn(400, 380), 180, Gameworld.WALL_WIDTH));
		this.walls.add(new Wall(this.wallColor, new Posn(100, 380), Gameworld.WALL_WIDTH, 300));
		this.walls.add(new Wall(this.wallColor, new Posn(100, 540), Gameworld.WALL_WIDTH, 300));
		this.walls.add(new Wall(this.wallColor, new Posn(100, 520), Gameworld.WALL_WIDTH, 300));
		this.walls.add(new Wall(this.wallColor, new Posn(100, 500), Gameworld.WALL_WIDTH, 300));
		this.walls.add(new Wall(this.wallColor, new Posn(100, 480), Gameworld.WALL_WIDTH, 300));
		this.walls.add(new Wall(this.wallColor, new Posn(100, 460), Gameworld.WALL_WIDTH, 300));
		this.walls.add(new Wall(this.wallColor, new Posn(100, 440), Gameworld.WALL_WIDTH, 300));
		this.walls.add(new Wall(this.wallColor, new Posn(100, 420), Gameworld.WALL_WIDTH, 300));
		this.walls.add(new Wall(this.wallColor, new Posn(100, 400), Gameworld.WALL_WIDTH, 300));
		this.walls.add(new Wall(this.wallColor, new Posn(100, 380), Gameworld.WALL_WIDTH, 300));
		
		this.walls.add(new Wall(this.wallColor, new Posn(60, 340), Gameworld.WALL_WIDTH, 380));
		this.walls.add(new Wall(this.wallColor, new Posn(60, 580), Gameworld.WALL_WIDTH, 380));
		
		for(int i = 0; i < 11; i++){
			this.food.add(new Food(new Posn(70, 370 + (i * 20))));
		}
		for(int i = 0; i < 11; i++){
			this.food.add(new Food(new Posn(430, 370 + (i * 20))));
		}
		for(int i = 0; i < 17; i++){
			this.food.add(new Food(new Posn(90 + (i * 20), 370)));
		}
		for(int i = 0; i < 17; i++){
			this.food.add(new Food(new Posn(90 + (i * 20), 570)));
		}
		
	}

	public void initBonusFood() {
		this.food.clear();

		for (int j = 0; j < 9; j++) {
			for (int i = 0; i < 28; i++) {
				this.food.add(new Food(new Posn(30 + (j * 40), 30 + (i * 20))));
			}
		}

		for (int j = 0; j < 14; j++) {
			for (int i = 0; i < 18; i++) {
				this.food.add(new Food(new Posn(30 + (i * 20), 30 + (j * 40))));
			}
		}
	}

	public void initBonuslevel() {
		this.initBonusFood();
		this.initBonusMaze();
		this.bigFood.clear();
		this.pacman.loc = new Posn(190, 370);
		this.inky = new Ghost("inky", Color.cyan, "Up", new Posn(-100, 300),
				true, 600, this.inkySpeed);
		this.blinky = new Ghost("blinky", Color.red, "Up", new Posn(-200, 300),
				true, 200, this.blinkySpeed);
		this.pinky = new Ghost("pinky", Color.pink, "Up", new Posn(-200, 250),
				false, 0, this.pinkySpeed);
		this.clyde = new Ghost("clyde", Color.orange, "Up",
				new Posn(-230, 300), true, 1000, this.clydeSpeed);

	}

	public void initMainLevel() {
		if(this.level == 1){
			this.blinkySpeed = 3;
			this.inkySpeed = 2;
			this.pinkySpeed = 2;
			this.clydeSpeed = 3;
		}
		this.initFoodOne();
		this.initMazeOne();
		this.initBigFoodOne();
		this.resetWin();
		this.bonusLevelOne = false;
	}

	public void initFoodOne() {
		this.food.clear();

		for (int i = 0; i < 16; i++) {
			this.food.add(new Food(new Posn(50 + (i * 20), 30)));
		}

		for (int i = 0; i < 11; i++) {
			this.food.add(new Food(new Posn(30, 50 + (i * 20))));
		}

		for (int i = 0; i < 17; i++) {
			this.food.add(new Food(new Posn(50 + (i * 20), 250)));
		}

		for (int i = 0; i < 16; i++) {
			this.food.add(new Food(new Posn(50 + (i * 20), 210)));
		}

		for (int i = 0; i < 16; i++) {
			this.food.add(new Food(new Posn(50 + (i * 20), 150)));
		}

		for (int i = 0; i < 10; i++) {
			this.food.add(new Food(new Posn(370, 50 + (i * 20))));
		}

		for (int i = 0; i < 3; i++) {
			this.food.add(new Food(new Posn(70, 130 - (i * 20))));
		}

		for (int i = 0; i < 3; i++) {
			this.food.add(new Food(new Posn(90 + (i * 20), 70)));
		}

		for (int i = 0; i < 5; i++) {
			this.food.add(new Food(new Posn(150, 130 - (i * 20))));
		}

		for (int i = 0; i < 5; i++) {
			this.food.add(new Food(new Posn(250, 130 - (i * 20))));
		}

		for (int i = 0; i < 3; i++) {
			this.food.add(new Food(new Posn(270 + (i * 20), 70)));
		}

		for (int i = 0; i < 3; i++) {
			this.food.add(new Food(new Posn(330, 130 - (i * 20))));
		}

		for (int i = 0; i < 16; i++) {
			this.food.add(new Food(new Posn(50 + (i * 20), 570)));
		}

		for (int i = 0; i < 18; i++) {
			this.food.add(new Food(new Posn(30 + (i * 20), 450)));
		}

		for (int i = 0; i < 5; i++) {
			this.food.add(new Food(new Posn(30, 550 - (i * 20))));
		}

		for (int i = 0; i < 5; i++) {
			this.food.add(new Food(new Posn(370, 550 - (i * 20))));
		}

		for (int i = 0; i < 5; i++) {
			this.food.add(new Food(new Posn(250, 550 - (i * 20))));
		}

		for (int i = 0; i < 5; i++) {
			this.food.add(new Food(new Posn(150, 550 - (i * 20))));
		}

		for (int i = 0; i < 3; i++) {
			this.food.add(new Food(new Posn(70, 510 - (i * 20))));
		}

		for (int i = 0; i < 3; i++) {
			this.food.add(new Food(new Posn(330, 510 - (i * 20))));
		}

		for (int i = 0; i < 3; i++) {
			this.food.add(new Food(new Posn(90 + (i * 20), 530)));
		}

		for (int i = 0; i < 3; i++) {
			this.food.add(new Food(new Posn(270 + (i * 20), 530)));
		}

		for (int i = 0; i < 9; i++) {
			this.food.add(new Food(new Posn(130, 430 - (i * 20))));
		}

		for (int i = 0; i < 9; i++) {
			this.food.add(new Food(new Posn(270, 430 - (i * 20))));
		}

		for (int i = 0; i < 4; i++) {
			this.food.add(new Food(new Posn(350, 410 - (i * 20))));
		}

		for (int i = 0; i < 4; i++) {
			this.food.add(new Food(new Posn(50, 410 - (i * 20))));
		}

		for (int i = 0; i < 2; i++) {
			this.food.add(new Food(new Posn(370, 430 - (i * 20))));
		}

		for (int i = 0; i < 2; i++) {
			this.food.add(new Food(new Posn(30, 430 - (i * 20))));
		}

		for (int i = 0; i < 2; i++) {
			this.food.add(new Food(new Posn(30, 350 - (i * 20))));
		}

		for (int i = 0; i < 2; i++) {
			this.food.add(new Food(new Posn(370, 350 - (i * 20))));
		}

		for (int i = 0; i < 2; i++) {
			this.food.add(new Food(new Posn(350, 290 - (i * 20))));
		}

		for (int i = 0; i < 2; i++) {
			this.food.add(new Food(new Posn(50, 290 - (i * 20))));
		}

		for (int i = 0; i < 6; i++) {
			this.food.add(new Food(new Posn(10 + (i * 20), 310)));
		}

		for (int i = 0; i < 6; i++) {
			this.food.add(new Food(new Posn(290 + (i * 20), 310)));
		}

		for (int i = 0; i < 6; i++) {
			this.food.add(new Food(new Posn(150 + (i * 20), 370)));
		}

		this.food.add(new Food(new Posn(70, 530)));
		this.food.add(new Food(new Posn(330, 530)));
		this.food.add(new Food(new Posn(70, 70)));
		this.food.add(new Food(new Posn(330, 70)));

	}

	public void initBigFoodOne() {

		this.bigFood.add(new BigFood(new Posn(30, 30)));
		this.bigFood.add(new BigFood(new Posn(370, 30)));
		/*
		 * this.bigFood.add(new BigFood(new Posn(70, 70))); this.bigFood.add(new
		 * BigFood(new Posn(330, 70)));
		 */

		this.bigFood.add(new BigFood(new Posn(30, 570)));
		this.bigFood.add(new BigFood(new Posn(370, 570)));

		/*
		 * this.bigFood.add(new BigFood(new Posn(70, 530)));
		 * this.bigFood.add(new BigFood(new Posn(330, 530)));
		 */
	}

	public boolean isCaged(Ghost ghost) {
		if ((ghost.loc.x > 160) && (ghost.loc.x < 260) && (ghost.loc.y > 250)
				&& (ghost.loc.y < 320)) {
			return true;
		} else
			return false;
	}

	public void changeCagedStatus(Ghost ghost) {
		if (ghost.timeLeftCaged == 0) {
			ghost.caged = false;
		}
	}

	public void movePacHelper(String dir) {
		if ((dir.equals("Left")) && this.canMoveLeftPac()) {
			this.pacman.moveLeft();
			this.chompCounter = this.chompCounter + 1;
			this.chompUpdate();
		}

		if ((dir.equals("Right")) && this.canMoveRightPac()) {
			this.pacman.moveRight();
			this.chompCounter = this.chompCounter + 1;
			this.chompUpdate();
		}

		if ((dir.equals("Down")) && this.canMoveDownPac()) {
			this.pacman.moveDown();
			this.chompCounter = this.chompCounter + 1;
			this.chompUpdate();
		}

		if ((dir.equals("Up")) && this.canMoveUpPac()) {
			this.pacman.moveUp();
			this.chompCounter = this.chompCounter + 1;
			this.chompUpdate();
		}

	}

	public void chompUpdate() {
		if (this.chompCounter >= 10) {
			this.chompCounter = 0;
			if (this.chomp) {
				this.chomp = false;
			} else
				this.chomp = true;
		}
	}

	
	public void moveFruit(Fruit fruit, String dir) {
		if ((dir.equals("Left")) && this.canMoveLeftFruit(fruit)) {
			fruit.moveLeft();
		}

		if ((dir.equals("Right")) && this.canMoveRightFruit(fruit)) {
			fruit.moveRight();
		}

		if ((dir.equals("Down")) && this.canMoveDownFruit(fruit)) {
			fruit.moveDown();
		}

		if ((dir.equals("Up")) && this.canMoveUpFruit(fruit)) {
			fruit.moveUp();
		}
	}
	
	
	public void moveGhost(Ghost ghost, String dir) {
		if ((dir.equals("Left")) && this.canMoveLeftGhost(ghost)) {
			ghost.moveLeft();
		}

		if ((dir.equals("Right")) && this.canMoveRightGhost(ghost)) {
			ghost.moveRight();
		}

		if ((dir.equals("Down")) && this.canMoveDownGhost(ghost)) {
			ghost.moveDown();
		}

		if ((dir.equals("Up")) && this.canMoveUpGhost(ghost)) {
			ghost.moveUp();
		}
	}
		
		public void moveGhostMenu(Ghost ghost, String dir) {
			if ((dir.equals("Left"))) {
				ghost.moveLeft();
			}

			if ((dir.equals("Right"))) {
				ghost.moveRight();
			}

			if ((dir.equals("Down"))) {
				ghost.moveDown();
			}

			if ((dir.equals("Up"))) {
				ghost.moveUp();
			}

	}

	public String wanderDir() {
		int rand = (int) (Math.random() * 4);

		if (rand == 1) {
			return "Left";
		}
		if (rand == 2) {
			return "Right";
		}
		if (rand == 3) {
			return "Up";
		}
		if (rand == 4) {
			return "Down";
		} else
			return "Down";
	}

	
	public void fruitWander(Fruit fruit){
		if (this.canMoveInCurrentDirFruit(fruit)){
				if (this.canMoveInNextDirFruit(fruit)){
					fruit.dir = this.nextWanderDirFruit;
					this.nextWanderDirFruit = this.wanderDir();
				}
			}
		else {
			this.nextWanderDirFruit = this.wanderDir();
			fruit.dir = this.nextWanderDirFruit;
		}
	}
	
	public void wander(Ghost ghost) {
		if (this.canMoveInCurrentDir(ghost)) {
			if (this.canMoveInNextDir(ghost)) {
				if (ghost.name.equals("pinky")) {
					ghost.dir = this.nextWanderDirPinky;
					this.nextWanderDirPinky = this.wanderDir();
				}
				if (ghost.name.equals("inky")) {
					ghost.dir = this.nextWanderDirInky;
					this.nextWanderDirInky = this.wanderDir();
				}
				if (ghost.name.equals("blinky")) {
					ghost.dir = this.nextWanderDirBlinky;
					this.nextWanderDirBlinky = this.wanderDir();
				}
				if (ghost.name.equals("clyde")) {
					ghost.dir = this.nextWanderDirClyde;
					this.nextWanderDirClyde = this.wanderDir();
				}
			}
		} else {
			if (ghost.name.equals("pinky")) {
				this.nextWanderDirPinky = this.wanderDir();
				ghost.dir = this.nextWanderDirPinky;
			}
			if (ghost.name.equals("inky")) {
				this.nextWanderDirInky = this.wanderDir();
				ghost.dir = this.nextWanderDirInky;
			}
			if (ghost.name.equals("blinky")) {
				this.nextWanderDirBlinky = this.wanderDir();
				ghost.dir = this.nextWanderDirBlinky;
			}
			if (ghost.name.equals("clyde")) {
				this.nextWanderDirClyde = this.wanderDir();
				ghost.dir = this.nextWanderDirClyde;
			}
		}
	}

	
	public boolean canMoveInCurrentDirFruit(Fruit ghost) {
		if (fruit.dir.equals("Up")) {
			return this.canMoveUpFruit(fruit);
		}
		if (fruit.dir.equals("Down")) {
			return this.canMoveDownFruit(fruit);
		}
		if (fruit.dir.equals("Right")) {
			return this.canMoveRightFruit(fruit);
		} else
			return this.canMoveLeftFruit(fruit);
	}
	
	
	public boolean canMoveInCurrentDir(Ghost ghost) {
		if (ghost.dir.equals("Up")) {
			return this.canMoveUpGhost(ghost);
		}
		if (ghost.dir.equals("Down")) {
			return this.canMoveDownGhost(ghost);
		}
		if (ghost.dir.equals("Right")) {
			return this.canMoveRightGhost(ghost);
		} else
			return this.canMoveLeftGhost(ghost);
	}

	
	public boolean canMoveInNextDirFruit(Fruit fruit){
		if (this.nextWanderDirFruit.equals("Up")) {
			return this.canMoveUpFruit(fruit);
		}
		if (this.nextWanderDirFruit.equals("Down")) {
			return this.canMoveDownFruit(fruit);
		}
		if (this.nextWanderDirFruit.equals("Right")) {
			return this.canMoveRightFruit(fruit);
		} else
			return this.canMoveLeftFruit(fruit);
	}
	
	public boolean canMoveInNextDir(Ghost ghost) {
		if (ghost.name.equals("pinky")) {
			if (this.nextWanderDirPinky.equals("Up")) {
				return this.canMoveUpGhost(ghost);
			}
			if (this.nextWanderDirPinky.equals("Down")) {
				return this.canMoveDownGhost(ghost);
			}
			if (this.nextWanderDirPinky.equals("Right")) {
				return this.canMoveRightGhost(ghost);
			} else
				return this.canMoveLeftGhost(ghost);
		} else if (ghost.name.equals("inky")) {
			if (this.nextWanderDirInky.equals("Up")) {
				return this.canMoveUpGhost(ghost);
			}
			if (this.nextWanderDirInky.equals("Down")) {
				return this.canMoveDownGhost(ghost);
			}
			if (this.nextWanderDirInky.equals("Right")) {
				return this.canMoveRightGhost(ghost);
			} else
				return this.canMoveLeftGhost(ghost);
		} else if (ghost.name.equals("blinky")) {
			if (this.nextWanderDirBlinky.equals("Up")) {
				return this.canMoveUpGhost(ghost);
			}
			if (this.nextWanderDirBlinky.equals("Down")) {
				return this.canMoveDownGhost(ghost);
			}
			if (this.nextWanderDirBlinky.equals("Right")) {
				return this.canMoveRightGhost(ghost);
			} else
				return this.canMoveLeftGhost(ghost);
		} else if (this.nextWanderDirClyde.equals("Up")) {
			return this.canMoveUpGhost(ghost);
		}
		if (this.nextWanderDirClyde.equals("Down")) {
			return this.canMoveDownGhost(ghost);
		}
		if (this.nextWanderDirClyde.equals("Right")) {
			return this.canMoveRightGhost(ghost);
		} else
			return this.canMoveLeftGhost(ghost);
	}

	public void findPacVerticalBlinky(Ghost ghost) {
		if (this.pacman.loc.y >= ghost.loc.y) {
			this.forceGhostDownBlinky(ghost);
		} else if (this.pacman.loc.y < ghost.loc.y) {
			this.forceGhostUpBlinky(ghost);
		} else
			this.findPacHorizantalBlinky(ghost);
	}

	public void findPacVerticalClyde(Ghost ghost) {
		if (this.pacman.loc.y >= ghost.loc.y) {
			this.forceGhostDownClyde(ghost);
		} else if (this.pacman.loc.y < ghost.loc.y) {
			this.forceGhostUpClyde(ghost);
		} else
			this.findPacHorizantalClyde(ghost);
	}

	public void findPacHorizantalClyde(Ghost ghost) {
		if (this.pacman.loc.x >= ghost.loc.x) {
			this.forceGhostRightClyde(ghost);
		} else if (this.pacman.loc.x < ghost.loc.x) {
			this.forceGhostLeftClyde(ghost);
		} else
			this.findPacVerticalClyde(ghost);

	}

	public void findPacHorizantalBlinky(Ghost ghost) {
		if (this.pacman.loc.x >= ghost.loc.x) {
			this.forceGhostRightBlinky(ghost);
		} else if (this.pacman.loc.x < ghost.loc.x) {
			this.forceGhostLeftBlinky(ghost);
		} else
			this.findPacVerticalBlinky(ghost);

	}

	public void blinkyFindPac(Ghost ghost) {
		if (this.blinkySearchHor || this.blinkySearchVert) {
			if (this.blinkySearchHor) {
				this.findPacHorizantalBlinky(ghost);
				if (ghost.loc.x == this.pacman.loc.x) {
					this.choosePathBlinky(ghost);
				}
			} else {
				this.findPacVerticalBlinky(ghost);
				if (ghost.loc.y == this.pacman.loc.y) {
					this.choosePathBlinky(ghost);
				}
			}
		} else if ((Math.abs(this.pacman.loc.y - ghost.loc.y) == Math
				.abs(this.pacman.loc.x - ghost.loc.x))) {
			this.choosePathBlinky(ghost);
		} else if (Math.abs(this.pacman.loc.y - ghost.loc.y) > Math
				.abs(this.pacman.loc.x - ghost.loc.x)) {
			this.findPacVerticalBlinky(ghost);
		} else
			this.findPacHorizantalBlinky(ghost);
	}

	public void clydeFindPac(Ghost ghost) {
		if (this.clydeSearchHor || this.clydeSearchVert) {
			if (this.clydeSearchHor) {
				this.findPacHorizantalClyde(ghost);
				if (ghost.loc.x == this.pacman.loc.x) {
					this.choosePathClyde(ghost);
				}
			} else {
				this.findPacVerticalClyde(ghost);
				if (ghost.loc.y == this.pacman.loc.y) {
					this.choosePathClyde(ghost);
				}
			}
		} else if ((Math.abs(this.pacman.loc.y - ghost.loc.y) == Math
				.abs(this.pacman.loc.x - ghost.loc.x))) {
			this.choosePathClyde(ghost);
		} else if (Math.abs(this.pacman.loc.y - ghost.loc.y) > Math
				.abs(this.pacman.loc.x - ghost.loc.x)) {
			this.findPacVerticalClyde(ghost);
		} else
			this.findPacHorizantalClyde(ghost);
	}

	public void scatterVert(Ghost ghost) {
		if (this.pacman.loc.y >= ghost.loc.y) {
			this.forceGhostUpBlinky(ghost);
		} else if (this.pacman.loc.y < ghost.loc.y) {
			this.forceGhostDownBlinky(ghost);
		} else
			this.scatterHor(ghost);
	}

	public void scatterHor(Ghost ghost) {
		if (this.pacman.loc.x >= ghost.loc.x) {
			this.forceGhostLeftBlinky(ghost);
		} else if (this.pacman.loc.x < ghost.loc.x) {
			this.forceGhostRightBlinky(ghost);
		} else
			this.scatterVert(ghost);

	}

	public void scatter(Ghost ghost) {
		if (Math.abs(this.pacman.loc.y - ghost.loc.y) > Math
				.abs(this.pacman.loc.x - ghost.loc.x)) {
			this.scatterVert(ghost);
		} else
			this.scatterHor(ghost);
	}

	public void choosePathBlinky(Ghost ghost) {
		int rand = (int) (Math.random() * 2);

		if (rand == 1) {
			if (this.blinkySearchVert) {
				this.blinkySearchHor = true;
				this.blinkySearchVert = false;
			} else
				this.blinkySearchVert = true;
		} else if (rand == 2) {
			if (this.blinkySearchHor) {
				this.blinkySearchVert = true;
				this.blinkySearchHor = false;
			} else
				this.blinkySearchHor = true;
		} else
			this.choosePathBlinky(ghost);
	}

	public void choosePathClyde(Ghost ghost) {
		int rand = (int) (Math.random() * 2);

		if (rand == 1) {
			if (this.clydeSearchVert) {
				this.clydeSearchHor = true;
				this.clydeSearchVert = false;
			} else
				this.clydeSearchVert = true;
		} else if (rand == 2) {
			if (this.clydeSearchHor) {
				this.clydeSearchVert = true;
				this.clydeSearchHor = false;
			} else
				this.clydeSearchHor = true;
		} else
			this.choosePathClyde(ghost);
	}

	public void forceGhostDownBlinky(Ghost ghost) {
		if (this.canMoveDownGhost(ghost)) {
			ghost.dir = "Down";
		} else if (this.canMoveRightGhost(ghost)) {
			ghost.dir = "Right";
		} else if (this.canMoveLeftGhost(ghost)) {
			ghost.dir = "Left";
		} else if (this.canMoveUpGhost(ghost)) {
			ghost.dir = "Up";
		}
	}

	public void forceGhostDownClyde(Ghost ghost) {
		if (this.canMoveDownGhost(ghost)) {
			ghost.dir = "Down";
		} else if (this.canMoveLeftGhost(ghost)) {
			ghost.dir = "Left";
		} else if (this.canMoveRightGhost(ghost)) {
			ghost.dir = "Right";
		} else if (this.canMoveUpGhost(ghost)) {
			ghost.dir = "Up";
		}
	}

	public void forceGhostUpBlinky(Ghost ghost) {
		if (this.canMoveUpGhost(ghost)) {
			ghost.dir = "Up";
		} else if (this.canMoveRightGhost(ghost)) {
			ghost.dir = "Right";
		} else if (this.canMoveLeftGhost(ghost)) {
			ghost.dir = "Left";
		} else if (this.canMoveDownGhost(ghost)) {
			ghost.dir = "Down";
		}
	}

	public void forceGhostUpClyde(Ghost ghost) {
		if (this.canMoveUpGhost(ghost)) {
			ghost.dir = "Up";
		} else if (this.canMoveLeftGhost(ghost)) {
			ghost.dir = "Left";
		} else if (this.canMoveRightGhost(ghost)) {
			ghost.dir = "Right";
		} else if (this.canMoveDownGhost(ghost)) {
			ghost.dir = "Down";
		}
	}

	public void forceGhostRightBlinky(Ghost ghost) {
		if (this.canMoveRightGhost(ghost)) {
			ghost.dir = "Right";
		} else if (this.canMoveUpGhost(ghost)) {
			ghost.dir = "Up";
		} else if (this.canMoveDownGhost(ghost)) {
			ghost.dir = "Down";
		} else if (this.canMoveLeftGhost(ghost)) {
			ghost.dir = "Left";
		}
	}

	public void forceGhostRightClyde(Ghost ghost) {
		if (this.canMoveRightGhost(ghost)) {
			ghost.dir = "Right";
		} else if (this.canMoveDownGhost(ghost)) {
			ghost.dir = "Down";
		} else if (this.canMoveUpGhost(ghost)) {
			ghost.dir = "Up";
		} else if (this.canMoveLeftGhost(ghost)) {
			ghost.dir = "Left";
		}
	}

	public void forceGhostLeftBlinky(Ghost ghost) {
		if (this.canMoveLeftGhost(ghost)) {
			ghost.dir = "Left";
		} else if (this.canMoveUpGhost(ghost)) {
			ghost.dir = "Up";
		} else if (this.canMoveDownGhost(ghost)) {
			ghost.dir = "Down";
		} else if (this.canMoveRightGhost(ghost)) {
			ghost.dir = "Right";
		}
	}

	public void forceGhostLeftClyde(Ghost ghost) {
		if (this.canMoveLeftGhost(ghost)) {
			ghost.dir = "Left";
		} else if (this.canMoveDownGhost(ghost)) {
			ghost.dir = "Down";
		} else if (this.canMoveUpGhost(ghost)) {
			ghost.dir = "Up";
		} else if (this.canMoveRightGhost(ghost)) {
			ghost.dir = "Right";
		}
	}
	
	public boolean foundFruitLeft(Fruit fruit) {
		if ((this.pacman.loc.x - 10 <= fruit.loc.x)
				&& (this.pacman.loc.x - 10 > fruit.loc.x + 10)
				&& (this.pacman.loc.y == fruit.loc.y)) {
			this.scores.add(new Numbers(new Posn(this.pacman.loc.x - 10, this.pacman.loc.y + 8), this.fruit.points, 500));
			this.fruitForLevel = true;
			return true;
			}
		return false;
	}
	
	public boolean foundFruitRight(Fruit fruit) {
		if ((this.pacman.loc.x + 10 >= fruit.loc.x)
				&& (this.pacman.loc.x - 10 < fruit.loc.x - 10)
				&& (this.pacman.loc.y == fruit.loc.y)) {
			this.scores.add(new Numbers(new Posn(this.pacman.loc.x - 10, this.pacman.loc.y + 8), this.fruit.points, 500));
			this.fruitForLevel = true;
			return true;
		}
		return false;
	}
	
	public boolean foundFruitUp(Fruit fruit) {
		if ((this.pacman.loc.y - 10 <= fruit.loc.y)
				&& (this.pacman.loc.y - 10 > fruit.loc.y + 10)
				&& (this.pacman.loc.x == fruit.loc.x)) {
			this.scores.add(new Numbers(new Posn(this.pacman.loc.x - 10, this.pacman.loc.y + 8), this.fruit.points, 500));
			this.fruitForLevel = true;
			return true;
		}
		return false;
	}
	
	public boolean foundFruitDown(Fruit fruit) {
		if ((this.pacman.loc.y + 10 >= fruit.loc.y)
				&& (this.pacman.loc.y - 10 < fruit.loc.y - 10)
				&& (this.pacman.loc.x == fruit.loc.x)) {
			this.scores.add(new Numbers(new Posn(this.pacman.loc.x - 10, this.pacman.loc.y + 8), this.fruit.points, 500));
			this.fruitForLevel = true;
			return true;
		}
		return false;
	}
	
	public boolean foundFruit(Fruit fruit){
		if(this.foundFruitLeft(fruit) || this.foundFruitRight(fruit)
		   || this.foundFruitDown(fruit) || this.foundFruitUp(fruit)){
			this.fruitForLevel = true;
			this.fruitCounter = this.fruitCounter + 1;
			return true;
		}
		else return false;
	}

	public boolean caughtPacLeft(Ghost ghost) {
		if ((this.pacman.loc.x - 10 <= ghost.loc.x)
				&& (this.pacman.loc.x - 10 > ghost.loc.x + 10)
				&& (this.pacman.loc.y == ghost.loc.y)) {
			if (ghost.edible) {
				ghost.loc.x = 210;
				ghost.loc.y = 300;
				if(this.mult == 0){
					this.score = this.score + 200;
					this.scores.add(new Numbers(new Posn(this.pacman.loc.x - 10, this.pacman.loc.y + 8), 200, 500));
				}
				if(this.mult == 1){
					this.score = this.score + 400;
					this.scores.add(new Numbers(new Posn(this.pacman.loc.x - 10, this.pacman.loc.y + 8), 400, 500));
				}
				if(this.mult == 2){
					this.score = this.score + 800;
					this.scores.add(new Numbers(new Posn(this.pacman.loc.x - 10, this.pacman.loc.y + 8), 800, 500));
				}
				if(this.mult == 3){
					this.score = this.score + 1600;
					this.scores.add(new Numbers(new Posn(this.pacman.loc.x - 10, this.pacman.loc.y + 8), 1600, 500));
				}
				this.mult = this.mult + 1;
				if(this.mult == 4){
					this.fruit.activated = true;
				}
				ghost.caged = true;
				ghost.timeLeftCaged = 500;
				ghost.edible = false;
				this.immuneTime = 1;
				this.pauseTime = 50;
				this.ghostCounter = this.ghostCounter + 1;
				return true;
			} else {
				return true;
			}
		}
		return false;
	}

	public boolean caughtPacRight(Ghost ghost) {
		if ((this.pacman.loc.x + 10 >= ghost.loc.x)
				&& (this.pacman.loc.x - 10 < ghost.loc.x - 10)
				&& (this.pacman.loc.y == ghost.loc.y)) {
			if (ghost.edible) {
				ghost.loc.x = 210;
				ghost.loc.y = 300;
				if(this.mult == 0){
					this.score = this.score + 200;
					this.scores.add(new Numbers(new Posn(this.pacman.loc.x - 10, this.pacman.loc.y + 8), 200, 500));
				}
				if(this.mult == 1){
					this.score = this.score + 400;
					this.scores.add(new Numbers(new Posn(this.pacman.loc.x - 10, this.pacman.loc.y + 8), 400, 500));
				}
				if(this.mult == 2){
					this.score = this.score + 800;
					this.scores.add(new Numbers(new Posn(this.pacman.loc.x - 10, this.pacman.loc.y + 8), 800, 500));
				}
				if(this.mult == 3){
					this.score = this.score + 1600;
					this.scores.add(new Numbers(new Posn(this.pacman.loc.x - 10, this.pacman.loc.y + 8), 1600, 500));
				}
				this.mult = this.mult + 1;
				if(this.mult == 4){
					this.fruit.activated = true;
				}
				ghost.caged = true;
				ghost.timeLeftCaged = 500;
				ghost.edible = false;
				this.immuneTime = 1;
				this.pauseTime = 50;
				this.ghostCounter = this.ghostCounter + 1;
				return true;
			} else {
				return true;
			}
		}
		return false;
	}

	public boolean caughtPacUp(Ghost ghost) {
		if ((this.pacman.loc.y - 10 <= ghost.loc.y)
				&& (this.pacman.loc.y - 10 > ghost.loc.y + 10)
				&& (this.pacman.loc.x == ghost.loc.x)) {
			if (ghost.edible) {
				ghost.loc.x = 210;
				ghost.loc.y = 300;
				if(this.mult == 0){
					this.score = this.score + 200;
					this.scores.add(new Numbers(new Posn(this.pacman.loc.x - 10, this.pacman.loc.y + 8), 200, 500));
				}
				if(this.mult == 1){
					this.score = this.score + 400;
					this.scores.add(new Numbers(new Posn(this.pacman.loc.x - 10, this.pacman.loc.y + 8), 400, 500));
				}
				if(this.mult == 2){
					this.score = this.score + 800;
					this.scores.add(new Numbers(new Posn(this.pacman.loc.x - 10, this.pacman.loc.y + 8), 800, 500));
				}
				if(this.mult == 3){
					this.score = this.score + 1600;
					this.scores.add(new Numbers(new Posn(this.pacman.loc.x - 10, this.pacman.loc.y + 8), 1600, 500));
				}
				this.mult = this.mult + 1;
				if(this.mult == 4){
					this.fruit.activated = true;
				}
				ghost.caged = true;
				ghost.timeLeftCaged = 500;
				ghost.edible = false;
				this.immuneTime = 1;
				this.pauseTime = 50;
				this.ghostCounter = this.ghostCounter + 1;
				return true;
			} else {
				return true;
			}
		}
		return false;
	}

	public boolean caughtPacDown(Ghost ghost) {
		if ((this.pacman.loc.y + 10 >= ghost.loc.y)
				&& (this.pacman.loc.y - 10 < ghost.loc.y - 10)
				&& (this.pacman.loc.x == ghost.loc.x)) {
			if (ghost.edible) {
				ghost.loc.x = 210;
				ghost.loc.y = 300;
				if(this.mult == 0){
					this.score = this.score + 200;
					this.scores.add(new Numbers(new Posn(this.pacman.loc.x - 10, this.pacman.loc.y + 8), 200, 500));
				}
				if(this.mult == 1){
					this.score = this.score + 400;
					this.scores.add(new Numbers(new Posn(this.pacman.loc.x - 10, this.pacman.loc.y + 8), 400, 500));
				}
				if(this.mult == 2){
					this.score = this.score + 800;
					this.scores.add(new Numbers(new Posn(this.pacman.loc.x - 10, this.pacman.loc.y + 8), 800, 500));
				}
				if(this.mult == 3){
					this.score = this.score + 1600;
					this.scores.add(new Numbers(new Posn(this.pacman.loc.x - 10, this.pacman.loc.y + 8), 1600, 500));
				}
				this.mult = this.mult + 1;
				if(this.mult == 4){
					this.fruit.activated = true;
				}
				ghost.caged = true;
				ghost.timeLeftCaged = 500;
				ghost.edible = false;
				this.immuneTime = 1;
				this.pauseTime = 50;
				this.ghostCounter = this.ghostCounter + 1;
				return true;
			} else {
				return true;
			}
		}
		return false;
	}

	public boolean caughtPac(Ghost ghost) {
		if (this.caughtPacUp(ghost) || this.caughtPacDown(ghost)
				|| this.caughtPacRight(ghost) || this.caughtPacLeft(ghost)) {
			if (ghost.edible || !(this.immuneTime == 0)) {
				return false;
			} else
				return true;
		}
		if (ghost.loc.x == this.pacman.loc.x
				&& ghost.loc.y == this.pacman.loc.y) {
			if (ghost.edible) {
				return false;
			} else
				return true;
		}
		return false;
	}

	public boolean canMoveLeftFruit(Fruit fruit) {
		for (int i = 0; i < this.walls.size(); i++) {
			if ((fruit.loc.x - 10 == this.walls.get(i).loc.x
					+ Gameworld.WALL_WIDTH)
					&& (fruit.loc.y > this.walls.get(i).loc.y)
					&& (fruit.loc.y < this.walls.get(i).loc.y
							+ this.walls.get(i).height)) {
				return false;
			}

			if ((fruit.loc.x - 10 == this.walls.get(i).loc.x
					+ Gameworld.WALL_WIDTH)
					&& (fruit.loc.y + 10 > this.walls.get(i).loc.y)
					&& (fruit.loc.y + 10 < this.walls.get(i).loc.y
							+ this.walls.get(i).height)) {
				return false;
			}

			if ((fruit.loc.x - 10 == this.walls.get(i).loc.x
					+ Gameworld.WALL_WIDTH)
					&& (fruit.loc.y - 10 > this.walls.get(i).loc.y)
					&& (fruit.loc.y - 10 < this.walls.get(i).loc.y
							+ this.walls.get(i).height)) {
				return false;
			}

			if ((fruit.loc.x - 10 == this.walls.get(i).loc.x
					+ this.walls.get(i).width)
					&& (fruit.loc.y > this.walls.get(i).loc.y)
					&& (fruit.loc.y < this.walls.get(i).loc.y
							+ this.walls.get(i).height)) {
				return false;
			}

			if ((fruit.loc.x - 10 == this.walls.get(i).loc.x
					+ this.walls.get(i).width)
					&& (fruit.loc.y - 10 > this.walls.get(i).loc.y)
					&& (fruit.loc.y - 10 < this.walls.get(i).loc.y
							+ this.walls.get(i).height)) {
				return false;
			}

			if ((fruit.loc.x - 10 == this.walls.get(i).loc.x
					+ this.walls.get(i).width)
					&& (fruit.loc.y + 10 > this.walls.get(i).loc.y)
					&& (fruit.loc.y + 10 < this.walls.get(i).loc.y
							+ this.walls.get(i).height)) {
				return false;
			}

		}
		return true;
	}
	
	public boolean canMoveRightFruit(Fruit fruit) {
		for (int i = 0; i < this.walls.size(); i++) {
			if ((fruit.loc.x + 10 == this.walls.get(i).loc.x)
					&& (fruit.loc.y > this.walls.get(i).loc.y)
					&& (fruit.loc.y < this.walls.get(i).loc.y
							+ this.walls.get(i).height)) {
				return false;
			}

			if ((fruit.loc.x + 10 == this.walls.get(i).loc.x)
					&& (fruit.loc.y + 10 > this.walls.get(i).loc.y)
					&& (fruit.loc.y + 10 < this.walls.get(i).loc.y
							+ this.walls.get(i).height)) {
				return false;
			}

			if ((fruit.loc.x + 10 == this.walls.get(i).loc.x)
					&& (fruit.loc.y - 10 > this.walls.get(i).loc.y)
					&& (fruit.loc.y - 10 < this.walls.get(i).loc.y
							+ this.walls.get(i).height)) {
				return false;
			}

		}
		return true;
	}
	
	public boolean canMoveDownFruit(Fruit fruit) {
		for (int i = 0; i < this.walls.size(); i++) {
			if ((fruit.loc.y + 10 == this.walls.get(i).loc.y)
					&& (fruit.loc.x > this.walls.get(i).loc.x)
					&& (fruit.loc.x < this.walls.get(i).loc.x
							+ this.walls.get(i).width)) {
				return false;
			}

			if ((fruit.loc.y + 10 == this.walls.get(i).loc.y)
					&& (fruit.loc.x - 10 > this.walls.get(i).loc.x)
					&& (fruit.loc.x - 10 < this.walls.get(i).loc.x
							+ this.walls.get(i).width)) {
				return false;
			}

			if ((fruit.loc.y + 10 == this.walls.get(i).loc.y)
					&& (fruit.loc.x + 10 > this.walls.get(i).loc.x)
					&& (fruit.loc.x + 10 < this.walls.get(i).loc.x
							+ this.walls.get(i).width)) {
				return false;
			}
			
			if ((fruit.loc.y == 250) && (fruit.loc.x >= 180)
					&& (fruit.loc.x <= 220) && !(this.bonusLevelOne)) {
				return false;
			}
		}

		return true;
	}
	
	public boolean canMoveUpFruit(Fruit fruit) {
		for (int i = 0; i < this.walls.size(); i++) {
			if ((fruit.loc.y - 10 == this.walls.get(i).loc.y
					+ Gameworld.WALL_WIDTH)
					&& (fruit.loc.x > this.walls.get(i).loc.x)
					&& (fruit.loc.x < this.walls.get(i).loc.x
							+ this.walls.get(i).width)) {
				return false;
			}

			if ((fruit.loc.y - 10 == this.walls.get(i).loc.y
					+ Gameworld.WALL_WIDTH)
					&& (fruit.loc.x - 10 > this.walls.get(i).loc.x)
					&& (fruit.loc.x - 10 < this.walls.get(i).loc.x
							+ this.walls.get(i).width)) {
				return false;
			}

			if ((fruit.loc.y - 10 == this.walls.get(i).loc.y
					+ Gameworld.WALL_WIDTH)
					&& (fruit.loc.x + 10 > this.walls.get(i).loc.x)
					&& (fruit.loc.x + 10 < this.walls.get(i).loc.x
							+ this.walls.get(i).width)) {
				return false;
			}

			if ((fruit.loc.y - 10 == this.walls.get(i).loc.y
					+ this.walls.get(i).height)
					&& (fruit.loc.x > this.walls.get(i).loc.x)
					&& (fruit.loc.x < this.walls.get(i).loc.x
							+ this.walls.get(i).width)) {
				return false;
			}

			if ((fruit.loc.y - 10 == this.walls.get(i).loc.y
					+ this.walls.get(i).height)
					&& (fruit.loc.x + 10 > this.walls.get(i).loc.x)
					&& (fruit.loc.x + 10 < this.walls.get(i).loc.x
							+ this.walls.get(i).width)) {
				return false;
			}

			if ((fruit.loc.y - 10 == this.walls.get(i).loc.y
					+ this.walls.get(i).height)
					&& (fruit.loc.x - 10 > this.walls.get(i).loc.x)
					&& (fruit.loc.x - 10 < this.walls.get(i).loc.x
							+ this.walls.get(i).width)) {
				return false;
			}

		}
		return true;
	}
	
	public boolean canMoveLeftPac() {
		for (int i = 0; i < this.walls.size(); i++) {
			if ((this.pacman.loc.x - 10 == this.walls.get(i).loc.x
					+ Gameworld.WALL_WIDTH)
					&& (this.pacman.loc.y > this.walls.get(i).loc.y)
					&& (this.pacman.loc.y < this.walls.get(i).loc.y
							+ this.walls.get(i).height)) {
				return false;
			}

			if ((this.pacman.loc.x - 10 == this.walls.get(i).loc.x
					+ Gameworld.WALL_WIDTH)
					&& (this.pacman.loc.y + 10 > this.walls.get(i).loc.y)
					&& (this.pacman.loc.y + 10 < this.walls.get(i).loc.y
							+ this.walls.get(i).height)) {
				return false;
			}

			if ((this.pacman.loc.x - 10 == this.walls.get(i).loc.x
					+ Gameworld.WALL_WIDTH)
					&& (this.pacman.loc.y - 10 > this.walls.get(i).loc.y)
					&& (this.pacman.loc.y - 10 < this.walls.get(i).loc.y
							+ this.walls.get(i).height)) {
				return false;
			}

			if ((this.pacman.loc.x - 10 == this.walls.get(i).loc.x
					+ this.walls.get(i).width)
					&& (this.pacman.loc.y > this.walls.get(i).loc.y)
					&& (this.pacman.loc.y < this.walls.get(i).loc.y
							+ this.walls.get(i).height)) {
				return false;
			}

			if ((this.pacman.loc.x - 10 == this.walls.get(i).loc.x
					+ this.walls.get(i).width)
					&& (this.pacman.loc.y - 10 > this.walls.get(i).loc.y)
					&& (this.pacman.loc.y - 10 < this.walls.get(i).loc.y
							+ this.walls.get(i).height)) {
				return false;
			}

			if ((this.pacman.loc.x - 10 == this.walls.get(i).loc.x
					+ this.walls.get(i).width)
					&& (this.pacman.loc.y + 10 > this.walls.get(i).loc.y)
					&& (this.pacman.loc.y + 10 < this.walls.get(i).loc.y
							+ this.walls.get(i).height)) {
				return false;
			}

		}
		return true;
	}

	public boolean canMoveRightPac() {
		for (int i = 0; i < this.walls.size(); i++) {
			if ((this.pacman.loc.x + 10 == this.walls.get(i).loc.x)
					&& (this.pacman.loc.y > this.walls.get(i).loc.y)
					&& (this.pacman.loc.y < this.walls.get(i).loc.y
							+ this.walls.get(i).height)) {
				return false;
			}

			if ((this.pacman.loc.x + 10 == this.walls.get(i).loc.x)
					&& (this.pacman.loc.y + 10 > this.walls.get(i).loc.y)
					&& (this.pacman.loc.y + 10 < this.walls.get(i).loc.y
							+ this.walls.get(i).height)) {
				return false;
			}

			if ((this.pacman.loc.x + 10 == this.walls.get(i).loc.x)
					&& (this.pacman.loc.y - 10 > this.walls.get(i).loc.y)
					&& (this.pacman.loc.y - 10 < this.walls.get(i).loc.y
							+ this.walls.get(i).height)) {
				return false;
			}

		}
		return true;
	}

	public boolean canMoveDownPac() {
		for (int i = 0; i < this.walls.size(); i++) {
			if ((this.pacman.loc.y + 10 == this.walls.get(i).loc.y)
					&& (this.pacman.loc.x > this.walls.get(i).loc.x)
					&& (this.pacman.loc.x < this.walls.get(i).loc.x
							+ this.walls.get(i).width)) {
				return false;
			}

			if ((this.pacman.loc.y + 10 == this.walls.get(i).loc.y)
					&& (this.pacman.loc.x - 10 > this.walls.get(i).loc.x)
					&& (this.pacman.loc.x - 10 < this.walls.get(i).loc.x
							+ this.walls.get(i).width)) {
				return false;
			}

			if ((this.pacman.loc.y + 10 == this.walls.get(i).loc.y)
					&& (this.pacman.loc.x + 10 > this.walls.get(i).loc.x)
					&& (this.pacman.loc.x + 10 < this.walls.get(i).loc.x
							+ this.walls.get(i).width)) {
				return false;
			}
			/*
			 * if((this.pacman.loc.y + 10 == this.walls.get(i).loc.y) &&
			 * (this.pacman.loc.x + 10 > this.walls.get(i).loc.x) &&
			 * (this.pacman.loc.x + 10 < this.walls.get(i).loc.x +
			 * this.walls.get(i).width)){ return false; }
			 * 
			 * if((this.pacman.loc.y + 10 == this.walls.get(i).loc.y) &&
			 * (this.pacman.loc.x + 10 > this.walls.get(i).loc.x) &&
			 * (this.pacman.loc.x + 10 < this.walls.get(i).loc.x +
			 * this.walls.get(i).width)){ return false; }
			 * 
			 * if((this.pacman.loc.y + 10 == this.walls.get(i).loc.y) &&
			 * (this.pacman.loc.x + 10 > this.walls.get(i).loc.x) &&
			 * (this.pacman.loc.x + 10 < this.walls.get(i).loc.x +
			 * this.walls.get(i).width)){ return false; }
			 */

			if ((this.pacman.loc.y == 250) && (this.pacman.loc.x >= 180)
					&& (this.pacman.loc.x <= 220) && !(this.bonusLevelOne)) {
				return false;
			}
		}

		return true;
	}

	public boolean canMoveUpPac() {
		for (int i = 0; i < this.walls.size(); i++) {
			if ((this.pacman.loc.y - 10 == this.walls.get(i).loc.y
					+ Gameworld.WALL_WIDTH)
					&& (this.pacman.loc.x > this.walls.get(i).loc.x)
					&& (this.pacman.loc.x < this.walls.get(i).loc.x
							+ this.walls.get(i).width)) {
				return false;
			}

			if ((this.pacman.loc.y - 10 == this.walls.get(i).loc.y
					+ Gameworld.WALL_WIDTH)
					&& (this.pacman.loc.x - 10 > this.walls.get(i).loc.x)
					&& (this.pacman.loc.x - 10 < this.walls.get(i).loc.x
							+ this.walls.get(i).width)) {
				return false;
			}

			if ((this.pacman.loc.y - 10 == this.walls.get(i).loc.y
					+ Gameworld.WALL_WIDTH)
					&& (this.pacman.loc.x + 10 > this.walls.get(i).loc.x)
					&& (this.pacman.loc.x + 10 < this.walls.get(i).loc.x
							+ this.walls.get(i).width)) {
				return false;
			}

			if ((this.pacman.loc.y - 10 == this.walls.get(i).loc.y
					+ this.walls.get(i).height)
					&& (this.pacman.loc.x > this.walls.get(i).loc.x)
					&& (this.pacman.loc.x < this.walls.get(i).loc.x
							+ this.walls.get(i).width)) {
				return false;
			}

			if ((this.pacman.loc.y - 10 == this.walls.get(i).loc.y
					+ this.walls.get(i).height)
					&& (this.pacman.loc.x + 10 > this.walls.get(i).loc.x)
					&& (this.pacman.loc.x + 10 < this.walls.get(i).loc.x
							+ this.walls.get(i).width)) {
				return false;
			}

			if ((this.pacman.loc.y - 10 == this.walls.get(i).loc.y
					+ this.walls.get(i).height)
					&& (this.pacman.loc.x - 10 > this.walls.get(i).loc.x)
					&& (this.pacman.loc.x - 10 < this.walls.get(i).loc.x
							+ this.walls.get(i).width)) {
				return false;
			}

		}
		return true;
	}

	public boolean canMoveLeftGhost(Ghost ghost) {
		for (int i = 0; i < this.walls.size(); i++) {
			if ((ghost.loc.x - 10 == this.walls.get(i).loc.x
					+ Gameworld.WALL_WIDTH)
					&& (ghost.loc.y > this.walls.get(i).loc.y)
					&& (ghost.loc.y < this.walls.get(i).loc.y
							+ this.walls.get(i).height)) {
				return false;
			}

			if ((ghost.loc.x - 10 == this.walls.get(i).loc.x
					+ Gameworld.WALL_WIDTH)
					&& (ghost.loc.y + 10 > this.walls.get(i).loc.y)
					&& (ghost.loc.y + 10 < this.walls.get(i).loc.y
							+ this.walls.get(i).height)) {
				return false;
			}

			if ((ghost.loc.x - 10 == this.walls.get(i).loc.x
					+ Gameworld.WALL_WIDTH)
					&& (ghost.loc.y - 10 > this.walls.get(i).loc.y)
					&& (ghost.loc.y - 10 < this.walls.get(i).loc.y
							+ this.walls.get(i).height)) {
				return false;
			}

			if ((ghost.loc.x - 10 == this.walls.get(i).loc.x
					+ this.walls.get(i).width)
					&& (ghost.loc.y > this.walls.get(i).loc.y)
					&& (ghost.loc.y < this.walls.get(i).loc.y
							+ this.walls.get(i).height)) {
				return false;
			}

			if ((ghost.loc.x - 10 == this.walls.get(i).loc.x
					+ this.walls.get(i).width)
					&& (ghost.loc.y - 10 > this.walls.get(i).loc.y)
					&& (ghost.loc.y - 10 < this.walls.get(i).loc.y
							+ this.walls.get(i).height)) {
				return false;
			}

			if ((ghost.loc.x - 10 == this.walls.get(i).loc.x
					+ this.walls.get(i).width)
					&& (ghost.loc.y + 10 > this.walls.get(i).loc.y)
					&& (ghost.loc.y + 10 < this.walls.get(i).loc.y
							+ this.walls.get(i).height)) {
				return false;
			}

		}
		return true;
	}

	public boolean canMoveRightGhost(Ghost ghost) {
		for (int i = 0; i < this.walls.size(); i++) {
			if ((ghost.loc.x + 10 == this.walls.get(i).loc.x)
					&& (ghost.loc.y > this.walls.get(i).loc.y)
					&& (ghost.loc.y < this.walls.get(i).loc.y
							+ this.walls.get(i).height)) {
				return false;
			}

			if ((ghost.loc.x + 10 == this.walls.get(i).loc.x)
					&& (ghost.loc.y + 10 > this.walls.get(i).loc.y)
					&& (ghost.loc.y + 10 < this.walls.get(i).loc.y
							+ this.walls.get(i).height)) {
				return false;
			}

			if ((ghost.loc.x + 10 == this.walls.get(i).loc.x)
					&& (ghost.loc.y - 10 > this.walls.get(i).loc.y)
					&& (ghost.loc.y - 10 < this.walls.get(i).loc.y
							+ this.walls.get(i).height)) {
				return false;
			}

		}
		return true;
	}

	public boolean canMoveDownGhost(Ghost ghost) {
		for (int i = 0; i < this.walls.size(); i++) {
			if ((ghost.loc.y + 10 == this.walls.get(i).loc.y)
					&& (ghost.loc.x > this.walls.get(i).loc.x)
					&& (ghost.loc.x < this.walls.get(i).loc.x
							+ this.walls.get(i).width)) {
				return false;
			}

			if ((ghost.loc.y + 10 == this.walls.get(i).loc.y)
					&& (ghost.loc.x - 10 > this.walls.get(i).loc.x)
					&& (ghost.loc.x - 10 < this.walls.get(i).loc.x
							+ this.walls.get(i).width)) {
				return false;
			}

			if ((ghost.loc.y + 10 == this.walls.get(i).loc.y)
					&& (ghost.loc.x + 10 > this.walls.get(i).loc.x)
					&& (ghost.loc.x + 10 < this.walls.get(i).loc.x
							+ this.walls.get(i).width)) {
				return false;
			}
			/*
			 * if((ghost.loc.y + 10 == this.walls.get(i).loc.y) && (ghost.loc.x
			 * + 10 > this.walls.get(i).loc.x) && (ghost.loc.x + 10 <
			 * this.walls.get(i).loc.x + this.walls.get(i).width)){ return
			 * false; }
			 * 
			 * if((ghost.loc.y + 10 == this.walls.get(i).loc.y) && (ghost.loc.x
			 * + 10 > this.walls.get(i).loc.x) && (ghost.loc.x + 10 <
			 * this.walls.get(i).loc.x + this.walls.get(i).width)){ return
			 * false; }
			 * 
			 * if((ghost.loc.y + 10 == this.walls.get(i).loc.y) && (ghost.loc.x
			 * + 10 > this.walls.get(i).loc.x) && (ghost.loc.x + 10 <
			 * this.walls.get(i).loc.x + this.walls.get(i).width)){ return
			 * false; }
			 */

			if ((ghost.loc.y == 250) && (ghost.loc.x >= 180)
					&& (ghost.loc.x <= 220)) {
				return false;
			}
		}

		return true;
	}

	public boolean canMoveUpGhost(Ghost ghost) {
		for (int i = 0; i < this.walls.size(); i++) {
			if ((ghost.loc.y - 10 == this.walls.get(i).loc.y
					+ Gameworld.WALL_WIDTH)
					&& (ghost.loc.x > this.walls.get(i).loc.x)
					&& (ghost.loc.x < this.walls.get(i).loc.x
							+ this.walls.get(i).width)) {
				return false;
			}

			if ((ghost.loc.y - 10 == this.walls.get(i).loc.y
					+ Gameworld.WALL_WIDTH)
					&& (ghost.loc.x - 10 > this.walls.get(i).loc.x)
					&& (ghost.loc.x - 10 < this.walls.get(i).loc.x
							+ this.walls.get(i).width)) {
				return false;
			}

			if ((ghost.loc.y - 10 == this.walls.get(i).loc.y
					+ Gameworld.WALL_WIDTH)
					&& (ghost.loc.x + 10 > this.walls.get(i).loc.x)
					&& (ghost.loc.x + 10 < this.walls.get(i).loc.x
							+ this.walls.get(i).width)) {
				return false;
			}

			if ((ghost.loc.y - 10 == this.walls.get(i).loc.y
					+ this.walls.get(i).height)
					&& (ghost.loc.x > this.walls.get(i).loc.x)
					&& (ghost.loc.x < this.walls.get(i).loc.x
							+ this.walls.get(i).width)) {
				return false;
			}

			if ((ghost.loc.y - 10 == this.walls.get(i).loc.y
					+ this.walls.get(i).height)
					&& (ghost.loc.x + 10 > this.walls.get(i).loc.x)
					&& (ghost.loc.x + 10 < this.walls.get(i).loc.x
							+ this.walls.get(i).width)) {
				return false;
			}

			if ((ghost.loc.y - 10 == this.walls.get(i).loc.y
					+ this.walls.get(i).height)
					&& (ghost.loc.x - 10 > this.walls.get(i).loc.x)
					&& (ghost.loc.x - 10 < this.walls.get(i).loc.x
							+ this.walls.get(i).width)) {
				return false;
			}

			if (ghost.caged && ghost.loc.y == 280) {
				return false;
			}

		}
		return true;
	}

	public void movePac() {
		if (this.nextDir.equals(this.pacman.dir)) {
			this.movePacHelper(this.pacman.dir);
		} else {
			if ((this.nextDir.equals("Left")) && this.canMoveLeftPac()) {
				this.pacman.dir = "Left";
				this.movePacHelper("Left");
			} else
				this.movePacHelper(this.pacman.dir);

			if ((this.nextDir.equals("Right")) && this.canMoveRightPac()) {
				this.pacman.dir = "Right";
				this.movePacHelper("Right");
			}

			if ((this.nextDir.equals("Down")) && this.canMoveDownPac()) {
				this.pacman.dir = "Down";
				this.movePacHelper("Down");
			}

			if ((this.nextDir.equals("Up")) && this.canMoveUpPac()) {
				this.pacman.dir = "Up";
				this.movePacHelper("Up");
			}
		}

	}

	public void removeFood() {
		for (int i = 0; i < this.food.size(); i++) {
			if ((this.pacman.loc.x == this.food.get(i).loc.x)
					&& (this.pacman.loc.y == this.food.get(i).loc.y)) {
				this.food.remove(i);
				this.score = this.score + 10;
				this.dotCounter = this.dotCounter + 1;
				break;
			}
			if ((this.pacman.loc.x - 1 == this.food.get(i).loc.x)
					&& (this.pacman.loc.y == this.food.get(i).loc.y)) {
				this.food.remove(i);
				this.score = this.score + 10;
				this.dotCounter = this.dotCounter + 1;
				break;
			}

			if ((this.pacman.loc.x + 1 == this.food.get(i).loc.x)
					&& (this.pacman.loc.y == this.food.get(i).loc.y)) {
				this.food.remove(i);
				this.score = this.score + 10;
				this.dotCounter = this.dotCounter + 1;
				break;
			}

			if ((this.pacman.loc.x == this.food.get(i).loc.x)
					&& (this.pacman.loc.y - 1 == this.food.get(i).loc.y)) {
				this.food.remove(i);
				this.score = this.score + 10;
				this.dotCounter = this.dotCounter + 1;
				break;
			}

			if ((this.pacman.loc.x == this.food.get(i).loc.x)
					&& (this.pacman.loc.y + 1 == this.food.get(i).loc.y)) {
				this.food.remove(i);
				this.score = this.score + 10;
				this.dotCounter = this.dotCounter + 1;
				break;
			}
		}
	}

	public void removeBigFood() {
		for (int i = 0; i < this.bigFood.size(); i++) {
			if ((this.pacman.loc.x == this.bigFood.get(i).loc.x)
					&& (this.pacman.loc.y == this.bigFood.get(i).loc.y)) {
				this.bigFood.remove(i);
				this.score = this.score + 50;
				this.tickCount = 0;
				this.flash = true;
				if(!(this.isCaged(this.blinky))){
				this.blinky.edible = true;
				}
				if(!(this.isCaged(this.inky))){
				this.inky.edible = true;
				}
				if(!(this.isCaged(this.pinky))){
				this.pinky.edible = true;
				}
				if(!(this.isCaged(this.clyde))){
				this.clyde.edible = true;
				}
				if(!(this.isCaged(this.blinky))){
				this.blinky.speed = 4;
				}
				if(!(this.isCaged(this.inky))){
				this.inky.speed = 4;
				}
				if(!(this.isCaged(this.pinky))){
				this.pinky.speed = 4;
				}
				if(!(this.isCaged(this.clyde))){
				this.clyde.speed = 4;
				}
				break;
			}
			if ((this.pacman.loc.x - 1 == this.bigFood.get(i).loc.x)
					&& (this.pacman.loc.y == this.bigFood.get(i).loc.y)) {
				this.bigFood.remove(i);
				this.score = this.score + 50;
				this.tickCount = 0;
				this.flash = true;
				if(!(this.isCaged(this.blinky))){
					this.blinky.edible = true;
					}
					if(!(this.isCaged(this.inky))){
					this.inky.edible = true;
					}
					if(!(this.isCaged(this.pinky))){
					this.pinky.edible = true;
					}
					if(!(this.isCaged(this.clyde))){
					this.clyde.edible = true;
					}
					if(!(this.isCaged(this.blinky))){
					this.blinky.speed = 6;
					}
					if(!(this.isCaged(this.inky))){
					this.inky.speed = 6;
					}
					if(!(this.isCaged(this.pinky))){
					this.pinky.speed = 6;
					}
					if(!(this.isCaged(this.clyde))){
					this.clyde.speed = 6;
					}
				break;
			}

			if ((this.pacman.loc.x + 1 == this.bigFood.get(i).loc.x)
					&& (this.pacman.loc.y == this.bigFood.get(i).loc.y)) {
				this.bigFood.remove(i);
				this.score = this.score + 50;
				this.tickCount = 0;
				this.flash = true;
				if(!(this.isCaged(this.blinky))){
					this.blinky.edible = true;
					}
					if(!(this.isCaged(this.inky))){
					this.inky.edible = true;
					}
					if(!(this.isCaged(this.pinky))){
					this.pinky.edible = true;
					}
					if(!(this.isCaged(this.clyde))){
					this.clyde.edible = true;
					}
					if(!(this.isCaged(this.blinky))){
					this.blinky.speed = 6;
					}
					if(!(this.isCaged(this.inky))){
					this.inky.speed = 6;
					}
					if(!(this.isCaged(this.pinky))){
					this.pinky.speed = 6;
					}
					if(!(this.isCaged(this.clyde))){
					this.clyde.speed = 6;
					}
				break;
			}

			if ((this.pacman.loc.x == this.bigFood.get(i).loc.x)
					&& (this.pacman.loc.y - 1 == this.bigFood.get(i).loc.y)) {
				this.bigFood.remove(i);
				this.score = this.score + 50;
				this.tickCount = 0;
				this.flash = true;
				if(!(this.isCaged(this.blinky))){
					this.blinky.edible = true;
					}
					if(!(this.isCaged(this.inky))){
					this.inky.edible = true;
					}
					if(!(this.isCaged(this.pinky))){
					this.pinky.edible = true;
					}
					if(!(this.isCaged(this.clyde))){
					this.clyde.edible = true;
					}
					if(!(this.isCaged(this.blinky))){
					this.blinky.speed = 6;
					}
					if(!(this.isCaged(this.inky))){
					this.inky.speed = 6;
					}
					if(!(this.isCaged(this.pinky))){
					this.pinky.speed = 6;
					}
					if(!(this.isCaged(this.clyde))){
					this.clyde.speed = 6;
					}
				break;
			}

			if ((this.pacman.loc.x == this.bigFood.get(i).loc.x)
					&& (this.pacman.loc.y + 1 == this.bigFood.get(i).loc.y)) {
				this.bigFood.remove(i);
				this.score = this.score + 50;
				this.tickCount = 0;
				this.flash = true;
				if(!(this.isCaged(this.blinky))){
					this.blinky.edible = true;
					}
					if(!(this.isCaged(this.inky))){
					this.inky.edible = true;
					}
					if(!(this.isCaged(this.pinky))){
					this.pinky.edible = true;
					}
					if(!(this.isCaged(this.clyde))){
					this.clyde.edible = true;
					}
					if(!(this.isCaged(this.blinky))){
					this.blinky.speed = 6;
					}
					if(!(this.isCaged(this.inky))){
					this.inky.speed = 6;
					}
					if(!(this.isCaged(this.pinky))){
					this.pinky.speed = 6;
					}
					if(!(this.isCaged(this.clyde))){
					this.clyde.speed = 6;
					}
				break;
			}
		}
	}

	public void escape(Ghost ghost) {
		if ((!(ghost.check) && ghost.loc.x < 200) || (ghost.goLeft)) {
			if (this.canMoveLeftGhost(ghost) && !(ghost.left)) {
				ghost.dir = "Left";
				ghost.check = true;
				ghost.goLeft = true;
			}
			if (this.canMoveUpGhost(ghost) && !(ghost.up)) {
				ghost.dir = "Up";
				ghost.left = true;
			}
			if (this.canMoveRightGhost(ghost) && !(ghost.right)
					&& !(ghost.loc.x == 200)) {
				ghost.dir = "Right";
				ghost.up = true;
			} else
				ghost.dir = "Up";
		} else if ((!(ghost.check) && ghost.loc.x >= 200) || (ghost.goRight)) {
			if (this.canMoveRightGhost(ghost) && !(ghost.right)) {
				ghost.dir = "Right";
				ghost.check = true;
				ghost.goRight = true;
			}
			if (this.canMoveUpGhost(ghost) && !(ghost.up)) {
				ghost.dir = "Up";
				ghost.right = true;
			}
			if (this.canMoveLeftGhost(ghost) && !(ghost.left)
					&& !(ghost.loc.x <= 200)) {
				ghost.dir = "Left";
				ghost.up = true;
			} else
				ghost.dir = "Up";
		}
	}
	
	public void menuScreenMovement(Ghost ghost){
		if(ghost.loc.x == 70 && ghost.loc.y == 370){
			ghost.dir = "Down";
		}
		if(ghost.loc.x == 70 && ghost.loc.y == 570){
			ghost.dir = "Right";
		}
		if(ghost.loc.x == 430 && ghost.loc.y == 570){
			ghost.dir = "Up";
		}
		if(ghost.loc.x == 430 && ghost.loc.y == 370){
			ghost.dir = "Left";
		}
	}
	
	public void overScreenMovement(Fruit fruit){
		if(fruit.loc.x == 70 && fruit.loc.y == 170){
			fruit.dir = "Down";
		}
		if(fruit.loc.x == 70 && fruit.loc.y == 370){
			fruit.dir = "Right";
		}
		if(fruit.loc.x == 430 && fruit.loc.y == 370){
			fruit.dir = "Up";
		}
		if(fruit.loc.x == 430 && fruit.loc.y == 170){
			fruit.dir = "Left";
		}
	}

	public void moveUpDown(Ghost ghost) {
		if (this.canMoveUpGhost(ghost) && ghost.dir.equals("Up")) {
			ghost.dir = "Up";
		} else if (this.canMoveDownGhost(ghost) && ghost.dir.equals("Down")) {
			ghost.dir = "Down";
		} else if (this.canMoveDownGhost(ghost) && ghost.dir.equals("Up")) {
			ghost.dir = "Down";
		} else if (this.canMoveUpGhost(ghost) && ghost.dir.equals("Down")) {
			ghost.dir = "Up";
		}
	}

	public void onKeyEvent(String ke) {
		if (!(this.infoScreen || this.menuScreen || this.gameOver)) {
			if (ke.equals("left")) {
				this.nextDir = "Left";
			}

			if (ke.equals("right")) {
				this.nextDir = "Right";
			}

			if (ke.equals("up")) {
				this.nextDir = "Up";
			}

			if (ke.equals("down")) {
				this.nextDir = "Down";
			}

			if (ke.equals("p")) {
				if (!this.pause) {
					this.pause = true;
				} else
					this.pause = false;
			}
		}

		if (ke.equals("i") || ke.equals(" ") && !(this.gameOver)) {
			if (this.infoScreen) {
				this.infoScreen = false;
			} else {
				this.infoScreen = true;
				this.pause = true;
			}
		}

		if (ke.equals("m")) {
			if (this.menuScreen) {
				this.pacman.gender = false;
				this.menuScreen = false;
				this.infoScreen = true;
			}
		}

		if (ke.equals("f")) {
			if (this.menuScreen) {
				this.pacman.gender = true;
				this.menuScreen = false;
				this.infoScreen = true;
			}
		}
		if (ke.equals("r")) {
			this.resetGame();
		}

	}

	public void onTick() {
		if(this.lives == -1){
			this.gameOver = true;
		}
		if(this.menuScreen){
			if(!(this.menuGhostsPlaced)){
				this.placeMenuGhosts();
				this.menuGhostsPlaced = true;
				}
			this.menuScreenMovement(this.blinky);
			this.menuScreenMovement(this.inky);
			this.menuScreenMovement(this.pinky);
			this.menuScreenMovement(this.clyde);
			
			if (this.menuTickCount % this.blinky.speed == 0) {
				this.moveGhostMenu(this.blinky, this.blinky.dir);

			}
			if (this.menuTickCount % this.inky.speed == 0) {
				this.moveGhostMenu(this.inky, this.inky.dir);
			}

			if (this.menuTickCount % this.pinky.speed == 0) {
				this.moveGhostMenu(this.pinky, this.pinky.dir);
			}

			if (this.menuTickCount % this.clyde.speed == 0) {
				this.moveGhostMenu(this.clyde, this.clyde.dir);
			}
			
			this.menuTickCount = this.menuTickCount + 1;
			
			if(this.menuTickCount == 10000){
				this.menuTickCount = 0;
			}
		}
		else if(this.gameOver){
			
			for(int i = 0; i < this.fruits.size(); i++){
				this.overScreenMovement(this.fruits.get(i));
			}
			
			for(int i = 0; i < this.fruits.size(); i++){
				if(this.fruits.get(i).holdTime == 0){
				this.moveFruit(this.fruits.get(i), this.fruits.get(i).dir);
				}
				else this.fruits.get(i).holdTime = this.fruits.get(i).holdTime - 1; 
			}
			
			this.gameOverTickCount = this.gameOverTickCount + 1;
			if(this.gameOverTickCount == 10000){
				this.gameOverTickCount = 0;
			}
		}
		else if (!this.gameOver || this.infoScreen || this.menuScreen) {
			if (!this.pause && this.pauseTime == 0) {

				if (this.lives == -1) {
					this.lives = 0;
					this.gameOver = true;
				}

				this.updateLives();

				if (this.bonusLevelOne) {
					if (!(this.bonusTimeLeft == 0)) {
						this.bonusTimeLeft = this.bonusTimeLeft - 1;
					} else
						this.updateLevel();
				}

				if (!(immuneTime == 0)) {
					this.immuneTime = this.immuneTime - 1;
				}

				if (this.blinkySearchHor || this.blinkySearchVert) {
					this.searchTimerBlinky = this.searchTimerBlinky - 1;

					if (this.searchTimerBlinky == 0) {
						this.blinkySearchHor = false;
						this.blinkySearchVert = false;
						this.searchTimerBlinky = 800;
					}
				}

				if (this.clydeSearchHor || this.clydeSearchVert) {
					this.searchTimerClyde = this.searchTimerClyde - 1;

					if (this.searchTimerClyde == 0) {
						this.clydeSearchHor = false;
						this.clydeSearchVert = false;
						this.searchTimerClyde = 800;
					}
				}

				
				if (this.food.size() == 0 && this.bigFood.size() == 0) {
					this.updateLevel();
				}
				
				
				this.updateDisplayNumbersTimers();
				this.removeNumbers();
				
				if(this.fruit.activated && !(this.fruitForLevel)){
					if(this.foundFruit(fruit)){
						this.fruit.activated = false;
						this.score = this.score + this.fruit.points;
					}
					if(this.fruit.holdTime == 0){
						this.fruitWander(this.fruit);
						if (this.tickCount % 2 == 0) {
							this.moveFruit(this.fruit, this.fruit.dir);
						}
					}
					else this.fruit.holdTime = this.fruit.holdTime - 1;
				}

				if (!(this.bonusLevelOne)) {
					if (!(this.blinky.caged) && this.isCaged(this.blinky)) {
						this.escape(this.blinky);
					}
					if (!(this.inky.caged) && this.isCaged(this.inky)) {
						this.escape(this.inky);
					}
					if (!(this.pinky.caged) && this.isCaged(this.pinky)) {
						this.escape(this.pinky);
					}
					if (!(this.clyde.caged) && this.isCaged(this.clyde)) {
						this.escape(this.clyde);
					}

					if (!(blinky.timeLeftCaged == 0)) {
						blinky.timeLeftCaged = blinky.timeLeftCaged - 1;
					}

					if (!(inky.timeLeftCaged == 0)) {
						inky.timeLeftCaged = inky.timeLeftCaged - 1;
					}

					if (!(pinky.timeLeftCaged == 0)) {
						pinky.timeLeftCaged = pinky.timeLeftCaged - 1;
					}

					if (!(clyde.timeLeftCaged == 0)) {
						clyde.timeLeftCaged = clyde.timeLeftCaged - 1;
					}

					if (this.caughtPac(this.blinky)) {
						this.pauseTime = 100;
						this.reset = true;
					}
					if (this.caughtPac(this.inky)) {
						this.pauseTime = 100;
						this.reset = true;
					}
					if (this.caughtPac(this.pinky)) {
						this.pauseTime = 100;
						this.reset = true;
					}
					if (this.caughtPac(this.clyde)) {
						this.pauseTime = 100;
						this.reset = true;
					}

					if (this.blinky.caged || this.isCaged(this.blinky)) {
						if (this.blinky.caged) {
							this.blinky.left = false;
							this.blinky.up = false;
							this.blinky.right = false;
							this.blinky.check = false;
							this.blinky.goLeft = false;
							this.blinky.goRight = false;
							this.moveUpDown(blinky);
							this.changeCagedStatus(blinky);
						}
					} else if (this.blinky.edible) {
						this.wander(this.blinky);
					} else
						this.blinkyFindPac(this.blinky);

					if (this.inky.caged || this.isCaged(this.inky)) {
						if (this.inky.caged) {
							this.inky.left = false;
							this.inky.up = false;
							this.inky.right = false;
							this.inky.check = false;
							this.inky.goLeft = false;
							this.inky.goRight = false;
							this.moveUpDown(inky);
							this.changeCagedStatus(inky);
						}
					} else if (this.inky.edible) {
						this.wander(this.inky);
					} else
						this.wander(this.inky);

					if (this.pinky.caged || this.isCaged(this.pinky)) {
						if (this.pinky.caged) {
							this.pinky.left = false;
							this.pinky.up = false;
							this.pinky.right = false;
							this.pinky.check = false;
							this.pinky.goLeft = false;
							this.pinky.goRight = false;
							this.moveUpDown(pinky);
							this.changeCagedStatus(pinky);
						}
					} else if (this.pinky.edible) {
						this.wander(this.pinky);
					} else
						this.wander(this.pinky);

					if (this.clyde.caged || this.isCaged(this.clyde)) {
						if (this.clyde.caged) {
							this.clyde.left = false;
							this.clyde.up = false;
							this.clyde.right = false;
							this.clyde.check = false;
							this.clyde.goLeft = false;
							this.clyde.goRight = false;
							this.moveUpDown(clyde);
							this.changeCagedStatus(clyde);
						}
					} else if (this.clyde.edible) {
						this.wander(this.clyde);
					} else
						this.clydeFindPac(this.clyde);

					if (this.tickCount % this.blinky.speed == 0) {
						this.moveGhost(this.blinky, this.blinky.dir);

					}
					if (this.tickCount % this.inky.speed == 0) {
						this.moveGhost(this.inky, this.inky.dir);
					}

					if (this.tickCount % this.pinky.speed == 0) {
						this.moveGhost(this.pinky, this.pinky.dir);
					}

					if (this.tickCount % this.clyde.speed == 0) {
						this.moveGhost(this.clyde, this.clyde.dir);
					}

					// ghost portal
					if (this.blinky.loc.x < 0) {
						this.blinky.loc = new Posn(390, 310);
						this.blinky.dir = "Left";
					}
					if (this.inky.loc.x < 0) {
						this.inky.loc = new Posn(390, 310);
						this.inky.dir = "Left";
					}
					if (this.clyde.loc.x < 0) {
						this.clyde.loc = new Posn(390, 310);
						this.clyde.dir = "Left";
					}
					if (this.pinky.loc.x < 0) {
						this.pinky.loc = new Posn(390, 310);
						this.pinky.dir = "Left";
					}

					if (this.blinky.loc.x > 400) {
						this.blinky.loc = new Posn(10, 310);
						this.blinky.dir = "Right";
					}
					if (this.inky.loc.x > 400) {
						this.inky.loc = new Posn(10, 310);
						this.inky.dir = "Right";
					}
					if (this.pinky.loc.x > 400) {
						this.pinky.loc = new Posn(10, 310);
						this.pinky.dir = "Right";
					}
					if (this.clyde.loc.x > 400) {
						this.clyde.loc = new Posn(10, 310);
						this.clyde.dir = "Right";
					}
				}
				
				// move pacman
					this.movePac();

				// pacman portal
				if (this.pacman.loc.x < 0) {
					this.pacman.loc = new Posn(390, 310);
					this.pacman.dir = "Left";
				}

				if (this.pacman.loc.x > 400) {
					this.pacman.loc = new Posn(10, 310);
					this.pacman.dir = "Right";
				}
				
				// removes food as pacman goes over it
				this.removeFood();
				this.removeBigFood();
				
				this.tickCount = this.tickCount + 1;
				if (this.tickCount > 900) {
					this.tickCount = 0;
					this.blinky.edible = false;
					this.inky.edible = false;
					this.pinky.edible = false;
					this.clyde.edible = false;
					this.mult = 0;
					this.blinky.speed = this.blinkySpeed;
					this.inky.speed = this.inkySpeed;;
					this.pinky.speed = this.pinkySpeed;;
					this.clyde.speed = this.clydeSpeed;;
				}

				if (this.flash) {
					this.flashBackground();

					if (this.tickCount > 40) {
						this.background = Color.darkGray;
						this.background2 = Color.lightGray;
						this.flash = false;
					}

				}

			} else {
				if(!(this.gameOver)){
				updateLevel();
				}
			}
		}
	}
	
	public void placeMenuGhosts(){
		this.initMenuMaze();
		
		this.inky = new Ghost("inky", Color.cyan, "Up", new Posn(70, 570), true,
				600, this.inkySpeed);
		this.blinky = new Ghost("blinky", Color.red, "Up", new Posn(70, 370),
				true, 200, this.blinkySpeed);
		this.pinky = new Ghost("pinky", Color.pink, "Up", new Posn(430, 370),
				false, 0, this.pinkySpeed);
		this.clyde = new Ghost("clyde", Color.orange, "Up", new Posn(430, 570),
				true, 1000, this.clydeSpeed);
	}

	public void flashBackground() {
		if (!(this.tickCount % 10 < 5)) {
			this.background = Color.lightGray;
			this.background2 = Color.darkGray;
		} else {
			this.background = Color.darkGray;
			this.background2 = Color.lightGray;
		}
	}

	public void draw() {
		if (!(this.infoScreen || this.menuScreen || this.gameOver)) {
			int time = this.bonusTimeLeft / 300;

			this.theCanvas.drawRect(new Posn(0, 0), 400, 600, this.background);
			this.theCanvas.drawRect(new Posn(400, 0), 100, 600,
					this.background2);

			// white line for ghost box
			if (!(this.bonusLevelOne)) {
				this.theCanvas.drawLine(new Posn(180, 260), new Posn(240, 260),
						Color.white);
				this.theCanvas.drawLine(new Posn(180, 261), new Posn(240, 261),
						Color.white);
				this.theCanvas.drawLine(new Posn(180, 262), new Posn(240, 262),
						Color.white);
				this.theCanvas.drawLine(new Posn(180, 263), new Posn(240, 263),
						Color.white);
				this.theCanvas.drawLine(new Posn(180, 264), new Posn(240, 264),
						Color.white);
			}

			for (int i = 0; i < this.walls.size(); i++) {
				this.walls.get(i).draw(theCanvas);
			}

			for (int i = 0; i < this.food.size(); i++) {
				this.food.get(i).draw(theCanvas);
			}

			// big food blink effect
			if (!(this.tickCount % 90 < 45)) {
				for (int i = 0; i < this.bigFood.size(); i++) {
					this.bigFood.get(i).draw(theCanvas);
				}
			}
			
			//fruit
			if(this.fruit.activated && !(this.fruitForLevel)){
				this.fruit.draw(theCanvas);
			}

			if (this.chomp) {
				this.pacman.drawOpen(theCanvas);
			} else
				this.pacman.drawClosed(theCanvas);

			if (!(this.edible)) {
				this.blinky.drawNormal(theCanvas);
				this.pinky.drawNormal(theCanvas);
				this.inky.drawNormal(theCanvas);
				this.clyde.drawNormal(theCanvas);
			}

			if (this.blinky.edible) {
				if (this.tickCount % 40 < 20 && this.tickCount > 700) {
					this.blinky.drawEdibleWhite(theCanvas);
				} else {
					this.blinky.drawEdibleBlue(theCanvas);
				}
			}
			if (this.inky.edible) {
				if (this.tickCount % 40 < 20 && this.tickCount > 700) {
					this.inky.drawEdibleWhite(theCanvas);
				} else {
					this.inky.drawEdibleBlue(theCanvas);
				}
			}
			if (this.pinky.edible) {
				if (this.tickCount % 40 < 20 && this.tickCount > 700) {
					this.pinky.drawEdibleWhite(theCanvas);
				} else {
					this.pinky.drawEdibleBlue(theCanvas);
				}
			}
			if (this.clyde.edible) {
				if (this.tickCount % 40 < 20 && this.tickCount > 700) {
					this.clyde.drawEdibleWhite(theCanvas);
				} else {
					this.clyde.drawEdibleBlue(theCanvas);
				}
			}

			this.theCanvas.drawString(new Posn(410, 20), "Score: ");
			this.theCanvas.drawString(new Posn(460, 20), new Integer(this.score).toString());
			this.theCanvas.drawString(new Posn(410, 40), "Level: ");
			this.theCanvas.drawString(new Posn(460, 40), new Integer(this.level).toString());
			this.theCanvas.drawString(new Posn(410, 400), "Press I for INFO");
			if (this.bonusLevelOne) {
				this.theCanvas.drawString(new Posn(410, 100), "Time Left: ");
				this.theCanvas.drawString(new Posn(480, 100), new Integer(time)
						.toString());
			}

			// lives
			if (this.lives >= 1 && this.lives < 4) {
				this.theCanvas.drawDisk(new Posn(415, 580), 10, Color.yellow);
				this.theCanvas.drawRect(new Posn(415, 580 - 3), 10, 7,
						Color.BLACK);
			}
			if (this.lives >= 2 && this.lives < 4) {
				this.theCanvas.drawDisk(new Posn(445, 580), 10, Color.yellow);
				this.theCanvas.drawRect(new Posn(445, 580 - 3), 10, 7,
						Color.BLACK);
			}
			if (this.lives == 3) {
				this.theCanvas.drawDisk(new Posn(475, 580), 10, Color.yellow);
				this.theCanvas.drawRect(new Posn(475, 580 - 3), 10, 7,
						Color.BLACK);
			}
			if (this.lives > 3) {
				this.theCanvas.drawDisk(new Posn(440, 580), 10, Color.yellow);
				this.theCanvas.drawRect(new Posn(440, 580 - 3), 10, 7,
						Color.BLACK);
				this.theCanvas.drawString(new Posn(460, 585), "x ");
				this.theCanvas.drawString(new Posn(475, 585), new Integer(
						this.lives).toString());
			}

			if (this.lives == -1) {
			}
			
			for(int i = 0; i < this.scores.size(); i ++){
				if(!(this.scores.get(i).displayTime == 0)){
				this.scores.get(i).draw(theCanvas);
				}
			}
		}

		if (this.infoScreen) {
			this.theCanvas.drawString(new Posn(20, 50), "CONTROLS: ");
			this.theCanvas
					.drawString(new Posn(20, 70), "Movement - Arrow Keys");
			this.theCanvas.drawString(new Posn(20, 90), "Pause/Unpause - P");
			this.theCanvas.drawString(new Posn(20, 110),
					"Info Toggle - I or Spacebar");
			this.theCanvas.drawString(new Posn(20, 130), "Reset Game - R");

			this.theCanvas.drawString(new Posn(20, 150), "BONUS");
			this.theCanvas
					.drawString(
							new Posn(20, 170),
							"Every 3 levels there is a bonus level, it lasts for roughly 35 seconds"
									+ "                                      and a timer will appear on the right. Moves on to next level once time is up.");

			this.theCanvas.drawString(new Posn(20, 210), "Extra Lives");
			this.theCanvas.drawString(new Posn(20, 230),
					"You will receive an extra life after your score reaches:");
			this.theCanvas.drawString(new Posn(20, 250), "10000");
			this.theCanvas.drawString(new Posn(20, 270), "17500");
			this.theCanvas.drawString(new Posn(20, 290), "25000");
			this.theCanvas.drawString(new Posn(20, 310), "45000");
			this.theCanvas.drawString(new Posn(20, 330), "75000");
			this.theCanvas.drawString(new Posn(20, 350), "100000");

			this.theCanvas.drawString(new Posn(20, 370), "WARNING");
			this.theCanvas.drawString(new Posn(20, 390),
					"Game does get more difficult as levels progress");
		}

		if (this.menuScreen) {
			this.theCanvas.drawRect(new Posn(0, 0), 500, 300, Color.green);
			this.theCanvas.drawRect(new Posn(0, 300), 500, 300, Color.blue);

			this.theCanvas.drawString(new Posn(90, 150),
					"Originally created by NAMCO, recreated by Jonathan Lane");
			this.theCanvas.drawString(new Posn(190, 190), "Mr. or Ms. PacMan?");

			this.theCanvas.drawString(new Posn(120, 250), "Hit M for:");
			this.theCanvas.drawString(new Posn(330, 250), "Hit F for:");

			// ms
			this.theCanvas.drawDisk(new Posn(350, 270), 10, Color.yellow);
			this.theCanvas.drawCircle(new Posn(357, 263), 4, Color.red);
			this.theCanvas.drawCircle(new Posn(357, 263), 3, Color.red);
			this.theCanvas.drawCircle(new Posn(357, 263), 2, Color.red);
			this.theCanvas.drawRect(new Posn(340, 267), 10, 7, Color.BLACK);

			// mr
			this.theCanvas.drawDisk(new Posn(140, 270), 10, Color.yellow);
			this.theCanvas.drawRect(new Posn(141, 267), 10, 7, Color.BLACK);
			
			for(int i = 0; i < this.walls.size(); i++){
				this.walls.get(i).draw(theCanvas);
			}
			for(int i = 0; i < this.food.size(); i++){
				this.food.get(i).draw(theCanvas);
			}
			
			this.blinky.drawNormal(theCanvas);
			this.pinky.drawNormal(theCanvas);
			this.inky.drawNormal(theCanvas);
			this.clyde.drawNormal(theCanvas);
		}
		
		if(this.gameOver){
			this.walls.clear();
			
			this.theCanvas.drawRect(new Posn(0, 0), 500, 600, Color.LIGHT_GRAY);
			this.theCanvas.drawRect(new Posn(0, 0), 500, 150, Color.green);
			
			this.theCanvas.drawString(new Posn(200, 220), "GAME OVER");
			this.theCanvas.drawString(new Posn(150, 250), "Score: ");
			this.theCanvas.drawString(new Posn(190, 250), new Integer(this.score).toString());
			this.theCanvas.drawString(new Posn(106, 270), "Highest Level: ");
			this.theCanvas.drawString(new Posn(190, 270), new Integer(this.level).toString());
			this.theCanvas.drawString(new Posn(114, 290), "Fruits Eaten: ");
			this.theCanvas.drawString(new Posn(190, 290), new Integer(this.fruitCounter).toString());
			this.theCanvas.drawString(new Posn(118, 310), "Dots Eaten: ");
			this.theCanvas.drawString(new Posn(190, 310), new Integer(this.dotCounter).toString());
			this.theCanvas.drawString(new Posn(104, 330), "Ghosts Eaten: ");
			this.theCanvas.drawString(new Posn(190, 330), new Integer(this.ghostCounter).toString());
			
			this.theCanvas.drawString(new Posn(170, 430), "HIT R TO PLAY AGAIN!");
			
			this.theCanvas.drawLine(new Posn(83, 350), new Posn(83, 190), Color.black);
			this.theCanvas.drawLine(new Posn(415, 350), new Posn(415, 190), Color.black);
			this.theCanvas.drawLine(new Posn(83, 350), new Posn(415, 350), Color.black);
			this.theCanvas.drawLine(new Posn(83, 190), new Posn(415, 190), Color.black);
			
			for(int i = 0; i < this.fruits.size(); i++){
				if(this.fruits.get(i).holdTime == 0){
				this.fruits.get(i).draw(theCanvas);
				}
			}
		}
		
		if(this.menuScreen || this.gameOver){
			// P
			this.theCanvas.drawString(new Posn(40, 40), "-------");
			this.theCanvas.drawString(new Posn(35, 45), "/");
			this.theCanvas.drawString(new Posn(30, 50), "/");
			this.theCanvas.drawString(new Posn(25, 55), "/");
			this.theCanvas.drawString(new Posn(65, 45), "\\");
			this.theCanvas.drawString(new Posn(70, 50), "\\");
			this.theCanvas.drawString(new Posn(75, 55), "\\");
			this.theCanvas.drawString(new Posn(75, 65), "|");
			this.theCanvas.drawString(new Posn(70, 75), "/");
			this.theCanvas.drawString(new Posn(30, 80), "----------");
			this.theCanvas.drawString(new Posn(25, 65), "|");
			this.theCanvas.drawString(new Posn(25, 70), "|");
			this.theCanvas.drawString(new Posn(25, 75), "|");
			this.theCanvas.drawString(new Posn(25, 80), "|");
			this.theCanvas.drawString(new Posn(25, 85), "|");
			this.theCanvas.drawString(new Posn(25, 90), "|");
			this.theCanvas.drawString(new Posn(25, 95), "|");
			this.theCanvas.drawString(new Posn(25, 100), "|");
			this.theCanvas.drawString(new Posn(25, 105), "|");
			this.theCanvas.drawString(new Posn(25, 110), "|");

			// A
			this.theCanvas.drawString(new Posn(80, 110), "/");
			this.theCanvas.drawString(new Posn(85, 100), "/");
			this.theCanvas.drawString(new Posn(90, 90), "/");
			this.theCanvas.drawString(new Posn(95, 80), "/");
			this.theCanvas.drawString(new Posn(100, 70), "/");
			this.theCanvas.drawString(new Posn(105, 60), "/");
			this.theCanvas.drawString(new Posn(110, 50), "/");
			this.theCanvas.drawString(new Posn(115, 50), "\\");
			this.theCanvas.drawString(new Posn(120, 60), "\\");
			this.theCanvas.drawString(new Posn(125, 70), "\\");
			this.theCanvas.drawString(new Posn(130, 80), "\\");
			this.theCanvas.drawString(new Posn(135, 90), "\\");
			this.theCanvas.drawString(new Posn(140, 100), "\\");
			this.theCanvas.drawString(new Posn(145, 110), "\\");
			this.theCanvas.drawString(new Posn(95, 80), "---------");

			// C
			this.theCanvas.drawString(new Posn(180, 50), "-----------");
			this.theCanvas.drawString(new Posn(175, 55), "/");
			this.theCanvas.drawString(new Posn(170, 60), "/");
			this.theCanvas.drawString(new Posn(165, 65), "/");
			this.theCanvas.drawString(new Posn(160, 70), "/");
			this.theCanvas.drawString(new Posn(160, 75), "|");
			this.theCanvas.drawString(new Posn(160, 80), "|");
			this.theCanvas.drawString(new Posn(160, 85), "|");
			this.theCanvas.drawString(new Posn(160, 90), "\\");
			this.theCanvas.drawString(new Posn(165, 95), "\\");
			this.theCanvas.drawString(new Posn(170, 100), "\\");
			this.theCanvas.drawString(new Posn(175, 105), "\\");
			this.theCanvas.drawString(new Posn(180, 108), "-----------");

			// M
			this.theCanvas.drawString(new Posn(235, 105), "/");
			this.theCanvas.drawString(new Posn(237, 100), "/");
			this.theCanvas.drawString(new Posn(239, 95), "/");
			this.theCanvas.drawString(new Posn(241, 90), "/");
			this.theCanvas.drawString(new Posn(243, 85), "/");
			this.theCanvas.drawString(new Posn(245, 80), "/");
			this.theCanvas.drawString(new Posn(247, 75), "/");
			this.theCanvas.drawString(new Posn(249, 70), "/");
			this.theCanvas.drawString(new Posn(251, 65), "/");
			this.theCanvas.drawString(new Posn(253, 60), "/");
			this.theCanvas.drawString(new Posn(255, 55), "/");
			this.theCanvas.drawString(new Posn(257, 55), "\\");
			this.theCanvas.drawString(new Posn(259, 60), "\\");
			this.theCanvas.drawString(new Posn(261, 65), "\\");
			this.theCanvas.drawString(new Posn(263, 70), "\\");
			this.theCanvas.drawString(new Posn(265, 75), "\\");
			this.theCanvas.drawString(new Posn(267, 80), "\\");
			this.theCanvas.drawString(new Posn(269, 85), "\\");
			this.theCanvas.drawString(new Posn(271, 90), "\\");
			this.theCanvas.drawString(new Posn(273, 95), "\\");
			this.theCanvas.drawString(new Posn(275, 100), "\\");
			this.theCanvas.drawString(new Posn(277, 105), "\\");
			this.theCanvas.drawString(new Posn(279, 105), "/");
			this.theCanvas.drawString(new Posn(281, 100), "/");
			this.theCanvas.drawString(new Posn(283, 95), "/");
			this.theCanvas.drawString(new Posn(285, 90), "/");
			this.theCanvas.drawString(new Posn(287, 85), "/");
			this.theCanvas.drawString(new Posn(289, 80), "/");
			this.theCanvas.drawString(new Posn(291, 75), "/");
			this.theCanvas.drawString(new Posn(293, 70), "/");
			this.theCanvas.drawString(new Posn(295, 65), "/");
			this.theCanvas.drawString(new Posn(297, 60), "/");
			this.theCanvas.drawString(new Posn(299, 55), "/");
			this.theCanvas.drawString(new Posn(301, 55), "\\");
			this.theCanvas.drawString(new Posn(303, 60), "\\");
			this.theCanvas.drawString(new Posn(305, 65), "\\");
			this.theCanvas.drawString(new Posn(307, 70), "\\");
			this.theCanvas.drawString(new Posn(309, 75), "\\");
			this.theCanvas.drawString(new Posn(311, 80), "\\");
			this.theCanvas.drawString(new Posn(313, 85), "\\");
			this.theCanvas.drawString(new Posn(315, 90), "\\");
			this.theCanvas.drawString(new Posn(317, 95), "\\");
			this.theCanvas.drawString(new Posn(319, 100), "\\");
			this.theCanvas.drawString(new Posn(321, 105), "\\");

			// A
			this.theCanvas.drawString(new Posn(340, 110), "/");
			this.theCanvas.drawString(new Posn(345, 100), "/");
			this.theCanvas.drawString(new Posn(350, 90), "/");
			this.theCanvas.drawString(new Posn(355, 80), "/");
			this.theCanvas.drawString(new Posn(360, 70), "/");
			this.theCanvas.drawString(new Posn(365, 60), "/");
			this.theCanvas.drawString(new Posn(370, 50), "/");
			this.theCanvas.drawString(new Posn(375, 50), "\\");
			this.theCanvas.drawString(new Posn(380, 60), "\\");
			this.theCanvas.drawString(new Posn(385, 70), "\\");
			this.theCanvas.drawString(new Posn(390, 80), "\\");
			this.theCanvas.drawString(new Posn(395, 90), "\\");
			this.theCanvas.drawString(new Posn(400, 100), "\\");
			this.theCanvas.drawString(new Posn(405, 110), "\\");
			this.theCanvas.drawString(new Posn(355, 80), "---------");

			// N
			this.theCanvas.drawString(new Posn(420, 105), "|");
			this.theCanvas.drawString(new Posn(420, 100), "|");
			this.theCanvas.drawString(new Posn(420, 95), "|");
			this.theCanvas.drawString(new Posn(420, 90), "|");
			this.theCanvas.drawString(new Posn(420, 85), "|");
			this.theCanvas.drawString(new Posn(420, 80), "|");
			this.theCanvas.drawString(new Posn(420, 75), "|");
			this.theCanvas.drawString(new Posn(420, 70), "|");
			this.theCanvas.drawString(new Posn(420, 65), "|");
			this.theCanvas.drawString(new Posn(420, 60), "|");
			this.theCanvas.drawString(new Posn(420, 55), "|");
			this.theCanvas.drawString(new Posn(420, 50), "|");
			this.theCanvas.drawString(new Posn(423, 55), "\\");
			this.theCanvas.drawString(new Posn(426, 60), "\\");
			this.theCanvas.drawString(new Posn(429, 65), "\\");
			this.theCanvas.drawString(new Posn(432, 70), "\\");
			this.theCanvas.drawString(new Posn(435, 75), "\\");
			this.theCanvas.drawString(new Posn(438, 80), "\\");
			this.theCanvas.drawString(new Posn(441, 85), "\\");
			this.theCanvas.drawString(new Posn(444, 90), "\\");
			this.theCanvas.drawString(new Posn(447, 95), "\\");
			this.theCanvas.drawString(new Posn(450, 100), "\\");
			this.theCanvas.drawString(new Posn(453, 105), "\\");
			this.theCanvas.drawString(new Posn(455, 105), "|");
			this.theCanvas.drawString(new Posn(455, 100), "|");
			this.theCanvas.drawString(new Posn(455, 95), "|");
			this.theCanvas.drawString(new Posn(455, 90), "|");
			this.theCanvas.drawString(new Posn(455, 85), "|");
			this.theCanvas.drawString(new Posn(455, 80), "|");
			this.theCanvas.drawString(new Posn(455, 75), "|");
			this.theCanvas.drawString(new Posn(455, 70), "|");
			this.theCanvas.drawString(new Posn(455, 65), "|");
			this.theCanvas.drawString(new Posn(455, 60), "|");
			this.theCanvas.drawString(new Posn(455, 55), "|");
			this.theCanvas.drawString(new Posn(455, 50), "|");
		}
	}

	public static void main(String args[]) {

		Gameworld world = new Gameworld();

		world.bigBang(500, 600, .001);
	}

}
