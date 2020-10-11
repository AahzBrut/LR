package com.mypackage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

public class TestScreen implements Screen {

    private MyGame game;
    private Stage stage;
    private BitmapFont font_orange, font_blue;
    private TextureAtlas textures;

    private TextureAtlas.AtlasRegion[] texts;

    public TestScreen(MyGame game) {
        this.game = game;
        stage = new Stage(new ExtendViewport(240, 256));
        font_orange = new BitmapFont(Gdx.files.internal("Font/RogueFont.fnt"), Gdx.files.internal("Font/RogueFont_O.png"), false);
        font_blue = new BitmapFont(Gdx.files.internal("Font/RogueFont.fnt"), Gdx.files.internal("Font/RogueFont_B.png"), false);
        font_orange.getData().setScale(4f);
        font_blue.getData().setScale(1f);
        textures = new TextureAtlas(Gdx.files.internal("textures.atlas"));
        stage.getCamera().position.x = 0;
        stage.getCamera().position.y = 0;
        ((OrthographicCamera)(stage.getCamera())).zoom = 1f;

        texts = new TextureAtlas.AtlasRegion[] {
                textures.findRegion("Tiles/sword"),
                textures.findRegion("Monster/dragon"),
                textures.findRegion("Tiles/potion"),
                textures.findRegion("Monster/bat"),
                textures.findRegion("Tiles/ring"),
                textures.findRegion("Monster/centaur"),
                textures.findRegion("Tiles/scroll_written")
        };
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act(delta);

        game.batch.setProjectionMatrix(stage.getCamera().combined);

        //stage.draw();

        game.batch.begin();

        for(int y = 0; y < 16; y++) {
            for(int x = 0; x < 15; x++) {
                int i = ((15 * y) + x) % texts.length;
                game.batch.draw(texts[i], x * 16, y * 16);
            }
        }

        font_orange.draw(game.batch, "Drugs\nare\nyour\nfriends!", 15, 230);

        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
