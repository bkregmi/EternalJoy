package com.example.eternaljoy;

import java.util.ArrayList;

public class SlokaCollection {

    private String collectionTitle;
    private ArrayList<SlokaData> slokaCollection;

    public String getCollectionTitle() {
        return collectionTitle;
    }

    public void setCollectionTitle(String collectionTitle) {
        this.collectionTitle = collectionTitle;
    }

    public ArrayList<SlokaData> getSlokaCollection() {
        return slokaCollection;
    }

    public void setSlokaCollection(ArrayList<SlokaData> slokaCollection) {
        this.slokaCollection = slokaCollection;
    }
}
