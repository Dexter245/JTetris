package com.dextersLaboratory.jtetris;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dextersLaboratory.jtetris.controller.GameController;
import com.dextersLaboratory.jtetris.view.IGameView;
import com.dextersLaboratory.jtetris.view.SimpleGameView;

public class Game extends ApplicationAdapter {
	
	private GameController controller;
	private IGameView view;
	
	@Override
	public void create () {
		controller = new GameController();
		view = new SimpleGameView(controller.getGameModel());
	}

	@Override
	public void render () {
		controller.update(Gdx.graphics.getDeltaTime());
		view.render();
	}
}
