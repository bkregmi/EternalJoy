package com.example.eternaljoy;

import java.util.List;

public class Sloka {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getSanskrit() {
        return sanskrit;
    }

    public void setSanskrit(List<String> sanskrit) {
        this.sanskrit = sanskrit;
    }

    public List<String> getEnglish() {
        return english;
    }

    public void setEnglish(List<String> english) {
        this.english = english;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    private List<String> sanskrit;
    private List<String> english;
    private String meaning;
    public String toString(){
        return id + "\n"+ sanskrit + "\n" + english + "\n" + meaning;
    }
}
