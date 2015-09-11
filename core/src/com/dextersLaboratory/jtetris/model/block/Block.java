package com.dextersLaboratory.jtetris.model.block;

import com.dextersLaboratory.jtetris.model.ShapeColor;

public abstract class Block {

	protected boolean[][][] shapeGrid = new boolean[4][4][4];
	private ShapeColor color;
	private int currentRotation = 0;
	
	public void rotate(){
		currentRotation++;
		if(currentRotation > 3)
			currentRotation = 0;
	}
	
	public boolean[][] getGrid(){
		return shapeGrid[currentRotation];
	}
	
	public ShapeColor getColor(){
		return color;
	}
	
	

	
	
	
	
	
	
	
	
	
}
