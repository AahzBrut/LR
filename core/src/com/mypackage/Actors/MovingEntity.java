package com.mypackage.Actors;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

//This is a subclass of ActorEntity, and super class of Player and Monsters(anything that moves)
public abstract class MovingEntity extends ActorEntity{

    public MovingEntity(TextureAtlas atlas) {

        super(atlas);

    }

}
