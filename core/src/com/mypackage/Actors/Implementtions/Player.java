package com.mypackage.Actors.Implementtions;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.mypackage.Actors.MovingEntity;
import com.mypackage.GameScreen;

public class Player extends MovingEntity {

    public Player(TextureAtlas atlas) {
        super(atlas);
        this.texture = "Tiles/player";
        this.renderOffset = new Vector2(-8, -8);
        this.position = new Vector2(0, 0);
    }

    public void MovePlayer(Vector2 move) {
        position = position.add(move);
    }
}
