package org.example.models;

public class Item {
    private static  int nextId = 0;
    public  int id;
    public String title;

    public Item(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public Item( String title) {
        this.title = title;
    }

}
