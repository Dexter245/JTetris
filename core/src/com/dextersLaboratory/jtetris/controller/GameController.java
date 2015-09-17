package com.dextersLaboratory.jtetris.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
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
	private Music bgm;
	private Sound soundMove;
	private Sound soundRotate;
	private Sound soundLine;
	private Sound soundLand;
	private Sound soundGameOver;
	private Sound soundPause;
	private float steptimeAccum = 0f;

	public GameController(){
		model = new GameModel();
		bgm = Gdx.audio.newMusic(Gdx.files.internal("bgm.mp3"));
		bgm.setLooping(true);
		soundMove = Gdx.audio.newSound(Gdx.files.internal("move.wav"));
		soundRotate = Gdx.audio.newSound(Gdx.files.internal("rotate.wav"));
		soundLine = Gdx.audio.newSound(Gdx.files.internal("line.wav"));
		soundLand = Gdx.audio.newSound(Gdx.files.internal("land.wav"));
		soundGameOver = Gdx.audio.newSound(Gdx.files.internal("gameOver.wav"));
		soundPause = Gdx.audio.newSound(Gdx.files.internal("pause.wav"));
	}
	
	//TODO: remove later
//	private void debugLineBottom(){
//		for(int x = 0; x < 10; x++){
//			model.setGridCell(x, 0, true);
//			model.setGridCellColor(x, 0, Color.RED);
//		}
//	}
	
	//TODO: remove later
//	private void debugLineSides(){
//		int numLinesAtEachSide = 1;
//		for(int x = 0; x < numLinesAtEachSide; x++){
//			for(int y = 0; y < 20; y++){
//				model.setGridCell(x, y, true);
//				model.setGridCell(9-x, y, true);
//				model.setGridCellColor(x, y, Color.RED);
//				model.setGridCellColor(9-x, y, Color.RED);
//			}
//			
//		}
//		
//	}
	
	//TODO: remove later
//	private void debugMulipleClears(){
//		int numClears = 9;
//		for(int y = 0; y < numClears; y++){
//			for(int x = 0; x < 9; x++){
//				model.setGridCell(x, y, true);
//				model.setGridCellColor(x, y, Color.RED);
//			}
//		}
//	}
	
	public void update(float delta){
		
		handleInput();
		
		if(model.getGameState() == GameState.playing){

			model.increaseTimePlayed(delta);
			
			steptimeAccum += delta;
			if(steptimeAccum >= model.getSteptime()){
				steptimeAccum = 0;
				step();
			}
			
		}
		
	}
	
	public GameModel getGameModel(){
		return model;
	}
	
	private void handleInput(){
		
		if(Gdx.input.isKeyJustPressed(Keys.NUM_1)){
			model.increaseLinesCleared(5);
			increaseSpeedIfNecessary();
		}
		
		if(Gdx.input.isKeyJustPressed(Keys.P) || Gdx.input.isKeyJustPressed(Keys.ENTER)){
			if(model.getGameState() == GameState.paused || 
					model.getGameState() == GameState.playing){
				togglePause();
			}else{
				newGame();
			}
		}
		if(model.getGameState() == GameState.playing){

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
			
		}
		
	}
	
	private void step(){
		if(model.getCurrentBlock() == null)
			return;
		if(!doesCollide(Direction.down)){
			model.setCurrentBlockPosY(model.getCurrentBlockPosY() - 1);
		}else{
			//block to grid
			blockToGrid();
			clearLines();
			spawnNewBlock();
			
			model.increaseScore(10);
			
			soundLand.play();
		}
	}
	
	private void moveBlockLeft(){
		if(model.getCurrentBlock() == null)
			return;
		if(!doesCollide(Direction.left)){
			model.setCurrentBlockPosX(model.getCurrentBlockPosX() - 1);
			soundMove.play();
		}
	}
	
	private void moveBlockRight(){
		if(model.getCurrentBlock() == null)
			return;
		if(!doesCollide(Direction.right)){
			model.setCurrentBlockPosX(model.getCurrentBlockPosX() + 1);
			soundMove.play();
		}
	}
	
	private void dropBlockDown(){
		if(model.getCurrentBlock() == null)
			return;
		while(!doesCollide(Direction.down)){
			model.setCurrentBlockPosY(model.getCurrentBlockPosY() - 1);
		}		

		step();
		steptimeAccum = 0f;
	}
	
	private void rotateBlock(){
		model.getCurrentBlock().rotate();
		if(!handleCollisionAfterRotation()){
			for(int i = 0; i < 3; i++)
				model.getCurrentBlock().rotate();
		}else{
			soundRotate.play();
		}
	}
	
	private void togglePause(){
		if(model.getGameState() == GameState.playing){
			model.setGameState(GameState.paused);
			bgm.pause();
			soundPause.play();
		}
		else if(model.getGameState() == GameState.paused){
			model.setGameState(GameState.playing);
			bgm.play();
		}
		
	}
	
	private void newGame(){
		model.reset();
		steptimeAccum = 0f;

		spawnNewBlock();
		model.setGameState(GameState.playing);
		
		if(!bgm.isPlaying()){
			bgm.setPosition(0f);
			bgm.play();
		}
//		debugLineBottom();//TODO: remove later
//		debugLineSides();//TODO: remove later
//		debugMulipleClears();//TODO: remove later

	}
	
	private void blockToGrid(){
		Block block = model.getCurrentBlock();
		int blockX = model.getCurrentBlockPosX();
		int blockY = model.getCurrentBlockPosY();
		for(int x = 0; x < 4; x++){
			for(int y = 0; y < 4; y++){
				if(block.getGrid()[x][y]){
					model.setGridCell(blockX + x, blockY + y, true);
					model.setGridCellColor(blockX + x, blockY + y, block.getColor());
				}
			}
		}
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
		for(int x = 0; x < 2; x++){

			for(int y = 0; y < 4; y++){
				if(model.getCurrentBlock().getGrid()[x][y]){

					if(model.getGridCell(newPosX + x, newPosY + y)){
						newPosX++;
						correctedLeft = true;
						y = -1;
					}

				}
			}

		}
		
		//collision right
		for(int x = 3; x > 1; x--){

			for(int y = 0; y < 4; y++){
				if(model.getCurrentBlock().getGrid()[x][y]){

					if(model.getGridCell(newPosX + x, newPosY + y)){
						if(correctedLeft){
							possible = false;
							x = -1;
							break;
						}
						newPosX--;
						y = -1;
					}

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
		if(doesCollide(null)){
			model.setGameState(GameState.gameOver);
			bgm.pause();
			soundGameOver.play();
		}
		
	}
	
	private void clearLines(){
		boolean playSound = false;
		for(int y = 0; y < 20; y++){
			for(int x = 0; x < 10; x++){
				if(!model.getGridCell(x, y)){
					break;
				}
				else if(x == 9){
					playSound = true;
					clearLine(y);
					y = -1;
					break;
				}
			}
		}
		
		if(playSound)
			soundLine.play();
	}
	
	private void clearLine(int line){
		for(int x = 0; x < 10; x++){
			model.setGridCell(x, line, false);
		}
		
		for(int y = line; y < 19; y++){
			for(int x = 0; x < 10; x++){
				model.setGridCell(x, y, model.getGridCell(x, y+1));
				model.setGridCellColor(x, y, model.getGridCellColor(x, y+1));
			}
		}
		
		model.increaseScore(GameModel.SCORE_PER_LINE);
		
		model.increaseLinesCleared(1);
		increaseSpeedIfNecessary();
		
	}
	
	private void increaseSpeedIfNecessary(){

		if(model.getLinesCleared() % 5 == 0){
			model.setSpeed(model.getLinesCleared()/5 + 1);
			float newSteptime = 0.5f / (float) (Math.pow((model.getLinesCleared()/5) + 1, 0.5));
			model.setSteptime(newSteptime);
		}
		
	}

	public void dispose(){
		bgm.dispose();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
