package com.dextersLaboratory.jtetris.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.dextersLaboratory.jtetris.model.GameModel;
import com.dextersLaboratory.jtetris.model.GameState;

public class SimpleGameView implements IGameView {
	
	@SuppressWarnings("unused")
	private static final int SCREEN_WIDTH = 640;
	private static final int SCREEN_HEIGHT = 480;
	private static final int CELL_WIDTH = 21;
	private static final int CELL_HEIGHT = 21;
	private static final int NUM_CELLS_X = 10;
	private static final int NUM_CELLS_Y = 20;
	
	private ShapeRenderer shapeRenderer = new ShapeRenderer(1000);
	private SpriteBatch batch = new SpriteBatch();
	private BitmapFont stdFont = new BitmapFont();
	
	private GameModel model;
	
	public SimpleGameView(GameModel model){
		this.model = model;
		stdFont.setColor(Color.BLACK);
	}

	@Override
	public void render() {
		
		Gdx.gl.glClearColor(1f, 1f, 1f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		renderGameArea();
		renderInterface();
		
		
	}
	
	private void renderInterface(){
		
		//game area bounds
		shapeRenderer.begin(ShapeType.Line);
		shapeRenderer.setColor(Color.BLACK);
		shapeRenderer.rect(20, 20, (CELL_WIDTH+1)*NUM_CELLS_X, (CELL_HEIGHT+1)*NUM_CELLS_Y);
		
		//seperator lines
		shapeRenderer.setColor(Color.LIGHT_GRAY);
		//horizontal lines
		for(int i = 1; i < 20; i++){
			int y = 20 + i*(CELL_HEIGHT+1);
			shapeRenderer.line(20, y, 10*(CELL_WIDTH+1) + 20 - 1, y);
		}
		//vertical lines
		for(int i = 1; i < 10; i++){
			int x = 20 + i*(CELL_WIDTH+1);
			shapeRenderer.line(x, 21, x, 20*(CELL_HEIGHT+1) + 20);
		}
		
		shapeRenderer.end();
		
		//info text
		batch.begin();
		stdFont.draw(batch, "Time played: " + (int) model.getTimePlayed(), 250, SCREEN_HEIGHT - 20);
		stdFont.draw(batch, "Lines cleared: " + model.getLinesCleared(), 250, SCREEN_HEIGHT - 40);
		stdFont.draw(batch, "Score: " + model.getScore(), 250, SCREEN_HEIGHT - 60);
		stdFont.draw(batch, "Speed: " + model.getSpeed(), 250, SCREEN_HEIGHT - 80);
		stdFont.draw(batch, "Steptime: " + model.getSteptime(), 250, SCREEN_HEIGHT - 100);
		
		//controls
		stdFont.draw(batch, "Controls:", 250, SCREEN_HEIGHT - 140);
		stdFont.draw(batch, "W/Up: Rotate", 250, SCREEN_HEIGHT - 160);
		stdFont.draw(batch, "S/Down: Drop block", 250, SCREEN_HEIGHT - 180);
		stdFont.draw(batch, "A/Left: Move left", 250, SCREEN_HEIGHT - 200);
		stdFont.draw(batch, "D/Right: Move right", 250, SCREEN_HEIGHT - 220);
		stdFont.draw(batch, "P/Enter: Pause, new game", 250, SCREEN_HEIGHT - 240);
		
		if(model.getGameState() == GameState.paused){
			stdFont.draw(batch, "Paused", 100, SCREEN_HEIGHT/2.0f);
		}
		else if(model.getGameState() == GameState.gameOver){
			stdFont.draw(batch, "Press enter to start a new game", 26, SCREEN_HEIGHT/2.0f);
		}
		
		batch.end();
		
		
		
	}
	
	private void renderGameArea(){
		
		shapeRenderer.begin(ShapeType.Filled);
		//blocks that have fallen down
		for(int x = 0; x < NUM_CELLS_X; x++){
			for(int y = 0; y < NUM_CELLS_Y; y++){
				if(model.getGridCell(x, y) && model.getGridCellColor(x, y) != null){
					shapeRenderer.setColor(model.getGridCellColor(x, y));
					shapeRenderer.rect(x*(CELL_WIDTH+1)+20, y*(CELL_HEIGHT+1)+21, 
							CELL_WIDTH, CELL_HEIGHT);
				}
			}
		}
		
		//current block
		if(model.getCurrentBlock() != null){
			boolean[][] blockGrid = model.getCurrentBlock().getGrid();
			int blockPosX = model.getCurrentBlockPosX();
			int blockPosY = model.getCurrentBlockPosY();
			int rectX = 0, rectY = 0;
			shapeRenderer.setColor(model.getCurrentBlock().getColor());
			for(int x = 0; x < blockGrid.length; x++){
				for(int y = 0; y < blockGrid[x].length; y++){
					if(blockGrid[x][y]){
						rectX = (blockPosX + x) * (CELL_WIDTH+1) + 20;
						rectY = (blockPosY + y) * (CELL_HEIGHT+1) + 21;
						shapeRenderer.rect(rectX, rectY, CELL_WIDTH, CELL_HEIGHT);
					}
				}
			}

		}
		
		
		shapeRenderer.end();
		
		
	}
	
	@Override
	public void dispose(){
		batch.dispose();
		shapeRenderer.dispose();
		stdFont.dispose();
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
