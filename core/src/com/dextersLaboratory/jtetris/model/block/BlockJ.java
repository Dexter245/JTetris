package com.dextersLaboratory.jtetris.model.block;

public class BlockJ extends Block {
	
	public BlockJ(){
		
		shapeGrid[0] = new boolean[][]{
				{true, false, false, false}, 
				{true, true, true, false}, 
				{false, false, false, false}, 
				{false, false, false, false}};

		shapeGrid[1] = new boolean[][]{
				{false, true, true, false}, 
				{false, true, false, false}, 
				{false, true, false, false}, 
				{false, false, false, false}};

		shapeGrid[2] = new boolean[][]{
				{false, false, false, false}, 
				{true, true, true, false}, 
				{false, false, true, false}, 
				{false, false, false, false}};

		shapeGrid[3] = new boolean[][]{
				{false, true, false, false}, 
				{false, true, false, false}, 
				{true, true, false, false}, 
				{false, false, false, false}};

		
		
		
		
		
		
		
		
		
	}

}
