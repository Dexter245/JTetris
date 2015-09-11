package com.dextersLaboratory.jtetris.view;

import com.dextersLaboratory.jtetris.model.GameModel;

public class SimpleGameView implements IGameView {
	
	private GameModel model;
	
	public SimpleGameView(GameModel model){
		this.model = model;
	}

	@Override
	public void render() {
		
	}

}
