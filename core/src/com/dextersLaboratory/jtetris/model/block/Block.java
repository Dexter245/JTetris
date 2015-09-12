package com.dextersLaboratory.jtetris.model.block;

import com.badlogic.gdx.graphics.Color;
import com.dextersLaboratory.jtetris.model.ShapeColor;

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
	
	

	
	
	
	
	
	
	
	
	
}
