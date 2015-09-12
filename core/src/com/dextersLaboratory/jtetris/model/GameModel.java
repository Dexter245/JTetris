package com.dextersLaboratory.jtetris.model;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.dextersLaboratory.jtetris.model.block.Block;

public class GameModel {
	
	private static final int GRID_WIDTH = 10;
	private static final int GRID_HEIGHT = 20;

	private boolean[][] grid = new boolean[10][20];
	private Color[][] gridColors = new Color[10][20];
	private GameState gameState = GameState.gameOver;
	private float timePlayed = 0f;
	private int score = 0;
	private int speed = 1;
	private int currentBlockPosX = 0;
	private int currentBlockPosY = 0;
//	private Vector2 currentBlockPos = new Vector2();
	private Block currentBlock;
	private float steptime = 500f;
	
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
	
	/** Sets the cell color at the given coordinates x and y.
	 * @param x the x coordinate of the cell to set
	 * @param y the y coordinate of the cell to set
	 * @param color the color to set
	 * @throws IllegalArgumentException if x or y are out of the gameArea bounds */
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
	
	public void increaseScore(int amount){
		score += amount;
	}

	public void setGameState(GameState gameState) {
		this.gameState = gameState;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public void setCurrentBlockPos(int x, int y){
		currentBlockPosX = x;
		currentBlockPosY = y;
	}

//	public void setCurrentBlockPos(Vector2 currentBlockPos) {
//		this.currentBlockPos = currentBlockPos;
//	}

	public void setCurrentBlock(Block currentBlock) {
		this.currentBlock = currentBlock;
	}

	public void setSteptime(float steptime) {
		this.steptime = steptime;
	}
	
	public boolean getGridCell(int x, int y){
		if(x < 0 || x >= GRID_WIDTH)
			throw new IllegalArgumentException("x may not be " + x);
		if(y < 0 || y >= GRID_HEIGHT)
			throw new IllegalArgumentException("y may not be " + y);
		return grid[x][y];
	}
	
	public Color getGridCellColor(int x, int y){
		if(x < 0 || x >= GRID_WIDTH)
			throw new IllegalArgumentException("x may not be " + x);
		if(y < 0 || y >= GRID_HEIGHT)
			throw new IllegalArgumentException("y may not be " + y);
		return gridColors[x][y];
	}
	
//	public boolean[][] getGrid() {
//		return grid;
//	}
//
//	public ShapeColor[][] getGridColors() {
//		return gridColors;
//	}

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
	
	public int getcurrentBlockPosY(){
		return currentBlockPosY;
	}

//	public Vector2 getCurrentBlockPos() {
//		return currentBlockPos;
//	}

	public Block getCurrentBlock() {
		return currentBlock;
	}

	public float getSteptime() {
		return steptime;
	}

	
	
	
	
	
	
	
}
