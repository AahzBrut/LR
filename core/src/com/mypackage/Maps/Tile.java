package com.mypackage.Maps;

//The tile class doesn't draw itself --> only needs to contain the information to where its texture is stored
public abstract class Tile {

    protected String Macro_texture, Map_texture;
    protected boolean solid;

    public Tile() {

    }

    public boolean isSolid() {
        return solid;
    }
}
