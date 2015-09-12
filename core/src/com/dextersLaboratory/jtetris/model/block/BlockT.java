package com.dextersLaboratory.jtetris.model.block;

import com.badlogic.gdx.graphics.Color;

public class BlockT extends Block {
	
	public BlockT(){
		
		color = Color.PURPLE;
		
		shapeGrid[0] = new boolean[][]{
				{false, true, false, false}, 
				{true, true, true, false}, 
				{false, false, false, false}, 
				{false, false, false, false}};

		shapeGrid[1] = new boolean[][]{
				{false, true, false, false}, 
				{false, true, true, false}, 
				{false, true, false, false}, 
				{false, false, false, false}};

		shapeGrid[2] = new boolean[][]{
				{false, false, false, false}, 
				{true, true, true, false}, 
				{false, true, false, false}, 
				{false, false, false, false}};

		shapeGrid[3] = new boolean[][]{
				{false, true, false, false}, 
				{true, true, false, false}, 
				{false, true, false, false}, 
				{false, false, false, false}};

		
		
		
		
	}

}
