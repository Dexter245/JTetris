package com.dextersLaboratory.jtetris.model.block;

import com.badlogic.gdx.graphics.Color;

public class BlockS extends Block {
	
	public BlockS(){
		
		color = Color.GREEN;
		
		shapeGrid[0] = new boolean[][]{
				{false, true, true, false}, 
				{true, true, false, false}, 
				{false, false, false, false}, 
				{false, false, false, false}};

		shapeGrid[1] = new boolean[][]{
				{false, true, false, false}, 
				{false, true, true, false}, 
				{false, false, true, false}, 
				{false, false, false, false}};

		shapeGrid[2] = new boolean[][]{
				{false, false, false, false}, 
				{false, true, true, false}, 
				{true, true, false, false}, 
				{false, false, false, false}};

		shapeGrid[3] = new boolean[][]{
				{true, false, false, false}, 
				{true, true, false, false}, 
				{false, true, false, false}, 
				{false, false, false, false}};

		
		
		
		
	}

}
