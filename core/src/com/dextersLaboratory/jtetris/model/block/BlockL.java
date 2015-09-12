package com.dextersLaboratory.jtetris.model.block;

import com.badlogic.gdx.graphics.Color;

public class BlockL extends Block {
	
	public BlockL(){
		
		color = Color.ORANGE;

		setShapeGridFromRotatedIntArray(new int[][]{
			{0, 0, 1, 0},
			{1, 1, 1, 0},
			{0, 0, 0, 0},
			{0, 0, 0, 0}
		}, 0);

		setShapeGridFromRotatedIntArray(new int[][]{
			{0, 1, 0, 0},
			{0, 1, 0, 0},
			{0, 1, 1, 0},
			{0, 0, 0, 0}
		}, 1);

		setShapeGridFromRotatedIntArray(new int[][]{
			{0, 0, 0, 0},
			{1, 1, 1, 0},
			{1, 0, 0, 0},
			{0, 0, 0, 0}
		}, 2);

		setShapeGridFromRotatedIntArray(new int[][]{
			{1, 1, 0, 0},
			{0, 1, 0, 0},
			{0, 1, 0, 0},
			{0, 0, 0, 0}
		}, 3);
		
		
		
	}

}
