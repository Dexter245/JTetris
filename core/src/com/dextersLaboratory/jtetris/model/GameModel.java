package com.dextersLaboratory.jtetris.model;

import com.badlogic.gdx.graphics.Color;
import com.dextersLaboratory.jtetris.model.block.Block;

public class GameModel {
	
	public static final int SCORE_PER_LINE = 100;
	private static final int GRID_WIDTH = 10;
	private static final int GRID_HEIGHT = 20;

	private boolean[][] grid = new boolean[10][20];
	private Color[][] gridColors = new Color[10][20];
	private GameState gameState = GameState.gameOver;
	private float timePlayed = 0f;
	private int score = 0;
	private int speed = 1;
	private int linesCleared = 0;
	private int currentBlockPosX = 0;
	private int currentBlockPosY = 0;
	private Block currentBlock;
	private float steptime = 0.5f;
	
	public void reset(){
		for(int x = 0; x < GRID_WIDTH; x++){
			for(int y = 0; y < GRID_HEIGHT; y++){
				grid[x][y] = false;
			}
		}
		gameState = GameState.gameOver;
		timePlayed = 0f;
		score = 0;
		speed = 1;
		currentBlockPosX = 0;
		currentBlockPosY = 0;
		currentBlock = null;
		steptime = 0.5f;
		linesCleared = 0;
	}
	
	/** Sets the cell at the given coordinates x and y occupied or not occupied depending
	 * on the givenvalue.
	 * @param x the x coordinate of the cell to set
	 * @param y the y coordinate of the cell to set
	 * @param value the value to set to the cell
	 * @throws IllegalArgumentException if x or y are out of the gameArea bounds */
	public void setGridCell(int x, int y, boolean value) throws IllegalArgumentException{
		if(x < 0 || x >= GRID_WIDTH)
			throw new IllegalArgumentException("x may not be " + x);
		if(y < 0 || y >= GRID_HEIGHT)
			throw new IllegalArgumentException("y may not be " + y);
		grid[x][y] = value;
	}
	
	public void setGridCellColor(int x, int y, Color color) throws IllegalArgumentException{
		if(x < 0 || x >= GRID_WIDTH)
			throw new IllegalArgumentException("x may not be " + x);
		if(y < 0 || y >= GRID_HEIGHT)
			throw new IllegalArgumentException("y may not be " + y);
		gridColors[x][y] = color;
	}
	
	public void setTimePlayed(float timePlayed){
		this.timePlayed = timePlayed;
	}
	
	public void increaseTimePlayed(float amount){
		this.timePlayed += amount;
	}
	
	public void increaseScore(int amount){
		score += amount;
	}
	
	public void increaseLinesCleared(int amount){
		linesCleared += amount;
	}

	public void setGameState(GameState gameState) {
		this.gameState = gameState;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public void setCurrentBlockPosX(int x){
		currentBlockPosX = x;
	}
	
	public void setCurrentBlockPosY(int y){
		currentBlockPosY = y;
	}
	
	public void setCurrentBlockPos(int x, int y){
		currentBlockPosX = x;
		currentBlockPosY = y;
	}

	public void setCurrentBlock(Block currentBlock) {
		this.currentBlock = currentBlock;
	}

	public void setSteptime(float steptime) {
		this.steptime = steptime;
	}
	
	public boolean getGridCell(int x, int y){
		if(x < 0 || x >= GRID_WIDTH)
			return true;
		if(y < 0 || y >= GRID_HEIGHT)
			return true;
		return grid[x][y];
	}
	
	public Color getGridCellColor(int x, int y){
		if(x < 0 || x >= GRID_WIDTH)
			throw new IllegalArgumentException("x may not be " + x);
		if(y < 0 || y >= GRID_HEIGHT)
			throw new IllegalArgumentException("y may not be " + y);
		return gridColors[x][y];
	}
	
	public int getLinesCleared(){
		return linesCleared;
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
	
	public int getCurrentBlockPosX(){
		return currentBlockPosX;
	}
	
	public int getCurrentBlockPosY(){
		return currentBlockPosY;
	}

	public Block getCurrentBlock() {
		return currentBlock;
	}

	public float getSteptime() {
		return steptime;
	}

	
	
	
	
	
	
	
}
