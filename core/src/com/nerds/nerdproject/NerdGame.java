package com.nerds.nerdproject;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.uwsoft.editor.renderer.SceneLoader;


public class NerdGame extends ApplicationAdapter {
	private FitViewport viewport;
	private SceneLoader sl;

	@Override
	public void create () {
		viewport = new FitViewport(9, 16); // this should be the size of camera in WORLD units. make sure you check that in editor first.
		sl = new SceneLoader(); // default scene loader loads allr esources from default RM as usual.
		sl.loadScene("Game screen", viewport); // loading scene as usual
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        sl.getEngine().update(Gdx.graphics.getDeltaTime());
	}

	@Override
	public void dispose () {

	}
}
