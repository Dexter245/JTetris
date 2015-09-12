package com.dextersLaboratory.jtetris.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;
import com.dextersLaboratory.jtetris.model.GameModel;

public class SimpleGameView implements IGameView {
	
	private static final int SCREEN_WIDTH = 640;
	private static final int SCREEN_HEIGHT = 480;
	private static final int CELL_WIDTH = 22;
	private static final int CELL_HEIGHT = 22;
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
		
		renderInterface();
		renderGameArea();
		
		
	}
	
	private void renderInterface(){
		
		//game area bounds
		shapeRenderer.begin(ShapeType.Line);
		shapeRenderer.setColor(Color.BLACK);
		shapeRenderer.rect(20, 20, CELL_WIDTH*NUM_CELLS_X, CELL_HEIGHT*NUM_CELLS_Y);
		
		shapeRenderer.end();
		
		//info text
		batch.begin();
		stdFont.draw(batch, "Time played: " + (int) model.getTimePlayed(), 250, SCREEN_HEIGHT - 20);
		stdFont.draw(batch, "Score: " + model.getScore(), 250, SCREEN_HEIGHT - 40);
		stdFont.draw(batch, "Speed: " + model.getSpeed(), 250, SCREEN_HEIGHT - 60);
		
		batch.end();
		
		
		
	}
	
	private void renderGameArea(){
		
		shapeRenderer.begin(ShapeType.Filled);
		//block that have fallen down
		for(int x = 0; x < NUM_CELLS_X; x++){
			for(int y = 0; y < NUM_CELLS_Y; y++){
				if(model.getGridCell(x, y)){
					shapeRenderer.setColor(model.getGridCellColor(x, y));
					shapeRenderer.rect(x*CELL_WIDTH, y*CELL_HEIGHT, CELL_WIDTH, CELL_HEIGHT);
				}
			}
		}
		
		//current block
		if(model.getCurrentBlock() != null){
			boolean[][] blockGrid = model.getCurrentBlock().getGrid();
	//		Vector2 blockPos = model.getCurrentBlockPos();
			int blockPosX = model.getCurrentBlockPosX();
			int blockPosY = model.getCurrentBlockPosY();
			int rectX = 0, rectY = 0;
			shapeRenderer.setColor(model.getCurrentBlock().getColor());
			for(int x = 0; x < blockGrid.length; x++){
				for(int y = 0; y < blockGrid[x].length; y++){
					if(blockGrid[x][y]){
//						rectX = (blockPosX + x) * CELL_WIDTH + 20;
//						rectY = (blockPosY + y) * CELL_HEIGHT + 20;
						rectX = (x) * CELL_WIDTH + 20;
						rectY = (y) * CELL_HEIGHT + 20;
						shapeRenderer.rect(rectX, rectY, CELL_WIDTH, CELL_HEIGHT);
					}
				}
			}

			shapeRenderer.end();
			shapeRenderer.begin(ShapeType.Line);
			shapeRenderer.rect(blockPosX*CELL_WIDTH + 20, blockPosY*CELL_HEIGHT + 20, 
					4*CELL_WIDTH, 4*CELL_HEIGHT);
			
		}
		
		
		
		
		shapeRenderer.end();

		
		
		
		
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
