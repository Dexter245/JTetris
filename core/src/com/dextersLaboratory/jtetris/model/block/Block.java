package com.dextersLaboratory.jtetris.model.block;

import com.badlogic.gdx.graphics.Color;

public abstract class Block {

	protected boolean[][][] shapeGrid = new boolean[4][4][4];
//	private ShapeColor color;
	protected Color color;
	private int currentRotation = 0;
	
	public void rotate(){
		currentRotation++;
		if(currentRotation > 3)
			currentRotation = 0;
	}
	
	public boolean[][] getGrid(){
		return shapeGrid[currentRotation];
	}
	
	public Color getColor(){
		return color;
	}
	
	protected void setShapeGridFromRotatedIntArray(int[][] intArray, int rotation){
		for(int x = 0; x < 4; x++){
			for(int y = 0; y < 4; y++){
				if(intArray[y][x] == 1)
					shapeGrid[rotation][x][3-y] = true;
				else
					shapeGrid[rotation][x][3-y] = false;
			}
		}
	}
	
	

	
	
	
	
	
	
	
	
	
}
