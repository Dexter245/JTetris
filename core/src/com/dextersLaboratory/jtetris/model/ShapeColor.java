package com.dextersLaboratory.jtetris.model;

import com.badlogic.gdx.graphics.Color;

public enum ShapeColor {
	cyan(Color.CYAN),
	blue(Color.BLUE),
	orange(Color.ORANGE),
	yellow(Color.YELLOW),
	lime(Color.GREEN),
	purple(Color.PURPLE),
	red(Color.RED);
	
	private Color color;
	
	private ShapeColor(Color color){
		this.color = color;
	}
	
	public Color getColor(){
		return color;
	}
}
