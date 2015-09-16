package com.dextersLaboratory.jtetris.model.block;

import com.badlogic.gdx.graphics.Color;

public class BlockJ extends Block {
	
	public BlockJ(){
		
		color = Color.BLUE;
		
		setShapeGridFromRotatedIntArray(new int[][]{
			{0, 0, 0, 0},
			{1, 0, 0, 0},
			{1, 1, 1, 0},
			{0, 0, 0, 0}
		}, 0);

		setShapeGridFromRotatedIntArray(new int[][]{
			{0, 1, 1, 0},
			{0, 1, 0, 0},
			{0, 1, 0, 0},
			{0, 0, 0, 0}
		}, 1);

		setShapeGridFromRotatedIntArray(new int[][]{
			{0, 0, 0, 0},
			{1, 1, 1, 0},
			{0, 0, 1, 0},
			{0, 0, 0, 0}
		}, 2);

		setShapeGridFromRotatedIntArray(new int[][]{
			{0, 1, 0, 0},
			{0, 1, 0, 0},
			{1, 1, 0, 0},
			{0, 0, 0, 0}
		}, 3);
		
		
		
		
	}

}
