package com.dextersLaboratory.jtetris.model;

import com.badlogic.gdx.math.Vector2;
import com.dextersLaboratory.jtetris.model.block.Block;

public class GameModel {

	private boolean[][] grid = new boolean[10][20];
	private ShapeColor[][] gridColors = new ShapeColor[10][20];
	private GameState gameState = GameState.gameOver;
	private float timePlayed = 0f;
	private int score = 0;
	private int speed = 1;
	private Vector2 currentBlockPos = new Vector2();
	private Block currentBlock;
	private float steptime = 500f;
	
	public void setGridCell(int x, int y, boolean value){
		
	}
	
	public void setGridCellColor(int x, int y, ShapeColor color){
		
	}
	
	public void setTimePlayed(float timePlayed){
		this.timePlayed = timePlayed;
	}
	
	public void increaseScore(int amount){
		
	}

	public void setGameState(GameState gameState) {
		this.gameState = gameState;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public void setCurrentBlockPos(Vector2 currentBlockPos) {
		this.currentBlockPos = currentBlockPos;
	}

	public void setCurrentBlock(Block currentBlock) {
		this.currentBlock = currentBlock;
	}

	public void setSteptime(float steptime) {
		this.steptime = steptime;
	}
	
	
	public boolean[][] getGrid() {
		return grid;
	}

	public ShapeColor[][] getGridColors() {
		return gridColors;
	}

	public GameState getGameState() {
		return gameState;
	}

	public float getTimePlayed() {
		return timePlayed;
	}

	public int getScore() {
		return score;
	}

	public int getSpeed() {
		return speed;
	}

	public Vector2 getCurrentBlockPos() {
		return currentBlockPos;
	}

	public Block getCurrentBlock() {
		return currentBlock;
	}

	public float getSteptime() {
		return steptime;
	}

	
	
	
	
	
	
	
}
