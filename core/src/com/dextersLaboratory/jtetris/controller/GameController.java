package com.dextersLaboratory.jtetris.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.dextersLaboratory.jtetris.model.Direction;
import com.dextersLaboratory.jtetris.model.GameModel;
import com.dextersLaboratory.jtetris.model.GameState;
import com.dextersLaboratory.jtetris.model.block.Block;
import com.dextersLaboratory.jtetris.model.block.BlockI;
import com.dextersLaboratory.jtetris.model.block.BlockJ;
import com.dextersLaboratory.jtetris.model.block.BlockL;
import com.dextersLaboratory.jtetris.model.block.BlockO;
import com.dextersLaboratory.jtetris.model.block.BlockS;
import com.dextersLaboratory.jtetris.model.block.BlockT;
import com.dextersLaboratory.jtetris.model.block.BlockZ;

public class GameController {

	private GameModel model;
	private float steptimeAccum = 0f;

	public GameController(){
		model = new GameModel();
	}
	
	//TODO: remove later
	private void debugLineBottom(){
		for(int x = 0; x < 10; x++){
			model.setGridCell(x, 0, true);
			model.setGridCellColor(x, 0, Color.RED);
		}
	}
	
	//TODO: remove later
	private void debugLineSides(){
		int numLinesAtEachSide = 0;
		for(int x = 0; x < numLinesAtEachSide; x++){
			for(int y = 0; y < 20; y++){
				model.setGridCell(x, y, true);
				model.setGridCell(9-x, y, true);
				model.setGridCellColor(x, y, Color.RED);
				model.setGridCellColor(9-x, y, Color.RED);
			}
			
		}
		
	}
	
	public void update(float delta){
		
		handleInput();
		
		steptimeAccum += delta;
		if(steptimeAccum >= model.getSteptime()){
			steptimeAccum = 0;
			step();
		}
		
	}
	
	public GameModel getGameModel(){
		return model;
	}
	
	private void handleInput(){
		
		if(Gdx.input.isKeyJustPressed(Keys.A) || Gdx.input.isKeyJustPressed(Keys.LEFT)){
			moveBlockLeft();
		}
		else if(Gdx.input.isKeyJustPressed(Keys.D) || Gdx.input.isKeyJustPressed(Keys.RIGHT)){
			moveBlockRight();
		}
		if(Gdx.input.isKeyJustPressed(Keys.W) || Gdx.input.isKeyJustPressed(Keys.UP)){
			rotateBlock();
		}
		if(Gdx.input.isKeyJustPressed(Keys.S) || Gdx.input.isKeyJustPressed(Keys.DOWN)){
			dropBlockDown();
		}
		if(Gdx.input.isKeyJustPressed(Keys.P) || Gdx.input.isKeyJustPressed(Keys.ENTER)){
			if(model.getGameState() == GameState.paused || 
					model.getGameState() == GameState.playing){
				togglePause();
			}else{
				newGame();
			}
		}
		
	}
	
	private void step(){
		if(model.getCurrentBlock() != null && !doesCollide(Direction.down)){
			model.setCurrentBlockPosY(model.getCurrentBlockPosY() - 1);
		}else{
			//block to grid
		}
	}
	
	private void moveBlockLeft(){
		if(model.getCurrentBlock() != null && !doesCollide(Direction.left)){
			model.setCurrentBlockPosX(model.getCurrentBlockPosX() - 1);
		}
	}
	
	private void moveBlockRight(){
		if(model.getCurrentBlock() != null && !doesCollide(Direction.right)){
			model.setCurrentBlockPosX(model.getCurrentBlockPosX() + 1);
		}
	}
	
	private void dropBlockDown(){
		
	}
	
	private void rotateBlock(){
		model.getCurrentBlock().rotate();
		if(!handleCollisionAfterRotation()){
			for(int i = 0; i < 3; i++)
				model.getCurrentBlock().rotate();
		}
	}
	
	private void togglePause(){
		if(model.getGameState() == GameState.playing)
			model.setGameState(GameState.paused);
		else if(model.getGameState() == GameState.paused)
			model.setGameState(GameState.playing);
	}
	
	private void newGame(){
		model.reset();
		spawnNewBlock();
		model.setGameState(GameState.playing);
//		debugLineBottom();//TODO: remove later
		debugLineSides();//TODO: remove later

	}
	
	private boolean doesCollide(Direction dir){
		
		for(int y = 0; y < 4; y++){
			for(int x = 0; x < 4; x++){
				if(model.getCurrentBlock().getGrid()[x][y]){

					int x2 = model.getCurrentBlockPosX() + x;
					int y2 = model.getCurrentBlockPosY() + y;

					if(dir == Direction.down){
						y2--;
					}else if(dir == Direction.left){
						x2--;
					}else if(dir == Direction.right){
						x2++;
					}

					if(y2 >= 0 && x2 >= 0 && x2 <= 9){
						if(model.getGridCell(x2, y2)){
							return true;
						}
					}else{
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	private boolean handleCollisionAfterRotation(){
		boolean possible = true;
		boolean correctedLeft = false;
		int newPosX = model.getCurrentBlockPosX();
		int newPosY = model.getCurrentBlockPosY();
		//collision left
		for(int y = 0; y < 4; y++){
			if(model.getCurrentBlock().getGrid()[0][y]){
				if(newPosX < 0){
					newPosX++;
					correctedLeft = true;
					y = -1;
				}
				else if(model.getGridCell(newPosX, y)){
					newPosX++;
					correctedLeft = true;
					y = -1;
				}
			}
		}
		
		//collision right
		for(int y = 0; y < 4; y++){
			if(model.getCurrentBlock().getGrid()[3][y]){
				if(newPosX > 6){
					if(correctedLeft){
						possible = false;
						break;
					}
					newPosX--;
					y = -1;
				}
				else if(model.getGridCell(newPosX+3, y)){
					if(correctedLeft){
						possible = false;
						break;
					}
					newPosX--;
					y = -1;
				}
			}
		}
		
		if(possible){
			model.setCurrentBlockPosX(newPosX);
			model.setCurrentBlockPosY(newPosY);
		}
		
		return possible;
		
	}
	
	private void spawnNewBlock(){
//		int rand = (int) (Math.random() * 7);
		int rand = 0;
		Block newBlock = null;
		switch(rand){
		case 0:
			newBlock = new BlockI();
			break;
		case 1:
			newBlock = new BlockJ();
			break;
		case 2:
			newBlock = new BlockL();
			break;
		case 3:
			newBlock = new BlockO();
			break;
		case 4:
			newBlock = new BlockS();
			break;
		case 5:
			newBlock = new BlockT();
			break;
		case 6:
			newBlock = new BlockZ();
			break;
		default:
			System.out.println("ERROR creating new block. rand is " + rand);
			break;
		}
		
		model.setCurrentBlock(newBlock);
		model.setCurrentBlockPos(3, 16);
//		model.setCurrentBlockPos(0, 0);
		
	}
	
	private void clearLine(){
		
	}
	
	
	
	
	
	
	
	
	
	
}
