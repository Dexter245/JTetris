package com.dextersLaboratory.jtetris.model.block;

import com.dextersLaboratory.jtetris.model.ShapeColor;

public abstract class Block {

	private boolean[][][] shapeGrid = new boolean[4][4][4];
	private ShapeColor color;
	private int currentRotation = 0;
	
	public void rotate(){
		
	}
	
	public boolean[][] getGrid(){
		return null;
	}
	
	public ShapeColor getColor(){
		return null;
	}
	
	

	
	
	
	
	
	
	
	
	
}
