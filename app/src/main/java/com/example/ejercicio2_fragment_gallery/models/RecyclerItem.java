package com.example.ejercicio2_fragment_gallery.models;

public class RecyclerItem {
    private String title;
    private int image;

    public RecyclerItem(String title, int image) {
        this.title = title;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }
    public int getImage() {
        return image;
    }

    @Override
    public String toString() {
        return "RecyclerItem{" +
                "title='" + title + '\'' +
                ", image=" + image +
                '}';
    }
}
