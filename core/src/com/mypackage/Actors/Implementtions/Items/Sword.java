package com.mypackage.Actors.Implementtions.Items;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.mypackage.Actors.ItemEntity;

public class Sword extends ItemEntity {
    public Sword(TextureAtlas atlas) {
        super(atlas);

        this.position = new Vector2(2, 1);
        this.renderOffset = new Vector2(-8, -8);
        this.texture = "Tiles/sword";
    }
}
