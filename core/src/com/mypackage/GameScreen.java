package com.mypackage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.mypackage.Actors.ActorEntity;
import com.mypackage.Actors.Implementtions.Items.Sword;
import com.mypackage.Actors.Implementtions.Player;
import com.mypackage.Maps.Map;

import java.util.ArrayList;
import java.util.List;

public class GameScreen implements Screen {

    private MyGame game;
    private Stage stage;
    private BitmapFont font_orange, font_blue;
    private TextureAtlas textures;
    private Map map;
    private Texture uiFrame;
    private SpriteBatch hudBatch;
    private Vector2 cam_offset;

    List<ActorEntity> entities;
    ActorEntity player;

    public GameScreen(MyGame game) {
        this.game = game;
        hudBatch = new SpriteBatch();
        cam_offset = new Vector2(0, 32);
        uiFrame = new Texture(Gdx.files.internal("ui_frame.png"));
        stage = new Stage(new ExtendViewport(240, 256));
        font_orange = new BitmapFont(Gdx.files.internal("Font/RogueFont.fnt"), Gdx.files.internal("Font/RogueFont_O.png"), false);
        font_blue = new BitmapFont(Gdx.files.internal("Font/RogueFont.fnt"), Gdx.files.internal("Font/RogueFont_B.png"), false);
        font_orange.getData().setScale(3f);
        font_blue.getData().setScale(1f);
        textures = new TextureAtlas(Gdx.files.internal("textures.atlas"));
        stage.getCamera().position.x = 0;
        stage.getCamera().position.y = 0;
        ((OrthographicCamera)(stage.getCamera())).zoom = 1f;

        map = new Map(textures);

        entities = new ArrayList<>();
        entities.add(new Sword(textures).setMap(map));
        player = new Player(textures).setMap(map);
    }

    @Override
    public void show() {

    }

    public void update(float delta) {
        stage.act(delta); //Update Actors

        for(ActorEntity ent : entities) {
            ent.update(delta);
        }
    }

    //Centralized Input
    public void PollInput() {
        //Poll for keys that switch the current screen
        if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
            //switch to the Escape menu
        }
        else if(Gdx.input.isKeyJustPressed(Input.Keys.I)) {
            //switch to inventory screen
        }
        else if(Gdx.input.isKeyJustPressed(Input.Keys.M)) {
            //switch to map screen
        }

        //Poll for the current screens input
        //Players Input
        boolean playerMoved = false;
        Vector2 move = null;
        if(Gdx.input.isKeyJustPressed(Input.Keys.W)) {
            move = new Vector2(0, 1);
            playerMoved = true;
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.A)) {
            move = new Vector2(-1, 0);
            playerMoved = true;
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.S)) {
            move = new Vector2(0, -1);
            playerMoved = true;
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.D)) {
            move = new Vector2(1, 0);
            playerMoved = true;
        }
        if(playerMoved) {
            if(map.IsTileSolid(player.getTilePosition().add(move))) {
                ((Player)player).MovePlayer(move);
            }
        }

        stage.getCamera().position.set(player.getWorldPosition().sub(cam_offset), 0);
        stage.getCamera().update();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        update(delta);
        PollInput();

        game.batch.setProjectionMatrix(stage.getCamera().combined);

        //Draw Map, Entities, Player
        game.batch.begin();
        map.draw(game.batch);
        for(ActorEntity ent : entities) {
            ent.draw(game.batch);
        }
        player.draw(game.batch);
        game.batch.end();

        //Draw HUD
        hudBatch.begin();
        hudBatch.draw(uiFrame, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        font_orange.draw(hudBatch, "You will never escape...", 48, 208);
        hudBatch.end();
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
        textures.dispose();
        stage.dispose();
    }
}
