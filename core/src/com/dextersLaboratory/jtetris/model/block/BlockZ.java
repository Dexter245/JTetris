package com.dextersLaboratory.jtetris.model.block;

import com.badlogic.gdx.graphics.Color;

public class BlockZ extends Block {
	
	public BlockZ(){
		
		color = Color.RED;
		
		shapeGrid[0] = new boolean[][]{
				{true, true, false, false}, 
				{false, true, true, false}, 
				{false, false, false, false}, 
				{false, false, false, false}};

		shapeGrid[1] = new boolean[][]{
				{false, false, true, false}, 
				{false, true, true, false}, 
				{false, true, false, false}, 
				{false, false, false, false}};

		shapeGrid[2] = new boolean[][]{
				{false, false, false, false}, 
				{true, true, false, false}, 
				{false, true, true, false}, 
				{false, false, false, false}};

		shapeGrid[3] = new boolean[][]{
				{false, true, false, false}, 
				{true, true, false, false}, 
				{true, false, false, false}, 
				{false, false, false, false}};
		
		
		
		
	}

}
