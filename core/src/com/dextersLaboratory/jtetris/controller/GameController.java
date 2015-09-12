package com.dextersLaboratory.jtetris.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
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
		model.setCurrentBlockPosY(model.getCurrentBlockPosY() - 1);
	}
	
	private void moveBlockLeft(){
		
	}
	
	private void moveBlockRight(){
		
	}
	
	private void dropBlockDown(){
		
	}
	
	private void rotateBlock(){
		model.getCurrentBlock().rotate();
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

	}
	
	private void checkCollision(){
		
	}
	
	private void spawnNewBlock(){
		int rand = (int) (Math.random() * 7);
//		int rand = 6;
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
