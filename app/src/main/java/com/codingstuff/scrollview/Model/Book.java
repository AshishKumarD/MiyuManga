package com.codingstuff.scrollview.Model;

public class Book {

    private int image, date;
    private String name;

    public Book(int image , String offer){
        this.image = image;
        this.name = offer;
    }

    public Book(int image ,  String offer ,int date){
        this.image = image;
        this.date = date;
        this.name = offer;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public int getDate() {
        return date;
    }
}
