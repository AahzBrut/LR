package com.mypackage.Maps;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.mypackage.Maps.Tiles.RoomFloor;

public class Map {

    public Tile[][] mapTiles;
    TextureAtlas atlas;
    private int tileSize;
    BitmapFont f;

    public Map(TextureAtlas atlas) {
        f = new BitmapFont(Gdx.files.internal("Font/RogueFont.fnt"));
        f.getData().setScale(0.25f);
        this.atlas = atlas;
        mapTiles = new Tile[5][10];
        this.tileSize = 16;

        for(int x = 0; x < mapTiles.length; x++) {
            for(int y = 0; y < mapTiles[x].length; y++) {
                mapTiles[x][y] = new RoomFloor();
            }
        }
    }

    public void draw(SpriteBatch batch) {
        for(int y = 0; y < mapTiles.length; y++) {
            for(int x = 0; x < mapTiles[y].length; x++) {
                batch.draw(atlas.findRegion(mapTiles[y][x].Macro_texture), (x * tileSize) - (tileSize/2), (y * tileSize) - (tileSize/2));
                f.draw(batch, x + " " + y, (x * tileSize) - (tileSize/2), (y * tileSize) - (tileSize/2));
            }
        }
    }

    public boolean IsTileSolid(Vector2 pos) {
        System.out.println(pos);
        if(pos.x < 0 || pos.y < 0) {
            return false;
        }
        else{
            return true;
        }
    }
}
