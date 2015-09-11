package com.dextersLaboratory.jtetris.model.block;

public class BlockI extends Block {
	
	public BlockI(){
		shapeGrid[0] = new boolean[][]{
				{false, false, false, false}, 
				{true, true, true, true}, 
				{false, false, false, false}, 
				{false, false, false, false}};

		shapeGrid[1] = new boolean[][]{
				{false, false, true, false}, 
				{false, false, true, false}, 
				{false, false, true, false}, 
				{false, false, true, false}};

		shapeGrid[2] = new boolean[][]{
				{false, false, false, false}, 
				{false, false, false, false}, 
				{true, true, true, true}, 
				{false, false, false, false}};

		shapeGrid[3] = new boolean[][]{
				{false, true, false, false}, 
				{false, true, false, false}, 
				{false, true, false, false}, 
				{false, true, false, false}};
	}

}
