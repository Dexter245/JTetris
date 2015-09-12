package com.dextersLaboratory.jtetris.model.block;

import com.badlogic.gdx.graphics.Color;

public class BlockO extends Block {
	
	public BlockO(){
		
		color = Color.YELLOW;
		
		shapeGrid[0] = new boolean[][]{
				{false, true, true, false}, 
				{false, true, true, false}, 
				{false, false, false, false}, 
				{false, false, false, false}};

		shapeGrid[1] = new boolean[][]{
				{false, true, true, false}, 
				{false, true, true, false}, 
				{false, false, false, false}, 
				{false, false, false, false}};

		shapeGrid[2] = new boolean[][]{
				{false, true, true, false}, 
				{false, true, true, false}, 
				{false, false, false, false}, 
				{false, false, false, false}};

		shapeGrid[3] = new boolean[][]{
				{false, true, true, false}, 
				{false, true, true, false}, 
				{false, false, false, false}, 
				{false, false, false, false}};

		
		
		
		
		
		
		
		
		
	}

}
