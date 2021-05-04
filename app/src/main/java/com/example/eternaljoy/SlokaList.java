package com.example.eternaljoy;

import android.text.TextUtils;

import org.w3c.dom.Text;

import java.util.List;

public class SlokaList {
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Sloka> getSlokas() {
        return slokas;
    }

    public void setSlokas(List<Sloka> slokas) {
        this.slokas = slokas;
    }

    public String title;
    public List<Sloka> slokas;
    public String toString() {
        String myString = "";
        for(int i=0;i<slokas.size();i++){
            myString = myString + "\n" + TextUtils.join("\n",slokas.get(i).getSanskrit());
            myString = myString + "\n" + TextUtils.join("\n",slokas.get(i).getEnglish());
            myString = myString + "\n" + slokas.get(i).getMeaning();
        }
        return title + "\n" + myString + "\n\n";
    }

}
