package com.dextersLaboratory.jtetris.model.block;

import com.badlogic.gdx.graphics.Color;

public class BlockI extends Block {
	
	public BlockI(){
		
		color = Color.CYAN;

		setShapeGridFromRotatedIntArray(new int[][]{
			{0, 0, 1, 0},
			{0, 0, 1, 0},
			{0, 0, 1, 0},
			{0, 0, 1, 0}
		}, 0);
		
		setShapeGridFromRotatedIntArray(new int[][]{
			{0, 0, 0, 0},
			{0, 0, 0, 0},
			{0, 0, 0, 0},
			{1, 1, 1, 1}
		}, 1);
		
		setShapeGridFromRotatedIntArray(new int[][]{
			{0, 0, 1, 0},
			{0, 0, 1, 0},
			{0, 0, 1, 0},
			{0, 0, 1, 0}
		}, 2);

		setShapeGridFromRotatedIntArray(new int[][]{
			{0, 0, 0, 0},
			{0, 0, 0, 0},
			{0, 0, 0, 0},
			{1, 1, 1, 1}
		}, 3);


	}

}
