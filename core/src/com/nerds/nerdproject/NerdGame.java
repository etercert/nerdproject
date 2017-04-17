package com.nerds.nerdproject;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;



public class NerdGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		final ServerClient server = new ServerClient();

		server.setListener(new ServerClientListener() {
			@Override
			public void onRegSucces() {
				Gdx.app.log("<DEBUG>", "regSuccess");
			}

			@Override
			public void onRegFail(String reason) {
				Gdx.app.log("<DEBUG>", "regFail " + reason);
                server.getNameSuggestion("johnsmith");
			}

			@Override
			public void onNameSuggestion(String suggestion) {
				Gdx.app.log("<DEBUG>", "name suggestion" + suggestion);
			}

			@Override
			public void onPlayer2Move(PlayerMove move) {
				Gdx.app.log("<DEBUG>", "Player 2 move: " + move.x + " " + move.y + " " + move.duration);
			}

			@Override
			public void onConnectionLost() {
				Gdx.app.log("<DEBUG>", "connection lost");
			}

			@Override
			public void onGameSessionStart(String player2Name) {
				Gdx.app.log("<DEBUG>", "session started with: " + player2Name);
			}

			@Override
			public void onGameSessionStop(String reason) {
				Gdx.app.log("<DEBUG>", "session stopped: " + reason);
			}

			@Override
			public void onPlayer2Unavailable() {
				Gdx.app.log("<DEBUG>", "player 2 unavailable");
			}

			@Override
			public void onConnected() {}

			@Override
			public void onConnectionError() {}
		});

		server.connect();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}

	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
