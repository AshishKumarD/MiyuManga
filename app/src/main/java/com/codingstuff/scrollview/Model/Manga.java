package com.codingstuff.scrollview.Model;

public class Manga {

    private int image;
    private String name;

    public Manga(int image , String offer){
        this.image = image;
        this.name = offer;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }
}
