package com.mypackage.Actors;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mypackage.GameScreen;
import com.mypackage.Maps.Map;

//Actor entity is the super class of all game entities including:
//Player
//Enemies
//Map tiles
//Interactables (Items, Doors, Stairs)
public abstract class ActorEntity {

    protected TextureAtlas atlas;
    protected String texture;
    protected Vector2 position, renderOffset;
    public static int tileSize = 16;
    protected Map map;

    public ActorEntity(TextureAtlas atlas) {
        this.atlas = atlas;
        position = new Vector2();
        renderOffset = new Vector2();
    }

    public void update(float delta) {

    }

    public void draw(SpriteBatch batch) {
        batch.draw(atlas.findRegion(texture), position.x * tileSize + renderOffset.x, position.y * tileSize + renderOffset.x);
    }

    public Vector2 getWorldPosition() {
        return new Vector2(position.x  * tileSize, position.y * tileSize);
    }
    public Vector2 getTilePosition() {return position;}

    public ActorEntity setMap(Map map) {
        this.map = map;
        return this;
    }
}
