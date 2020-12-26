package com.example.eternaljoy;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class SlokaData {
    private int slokaId;

   // public SlokaData(int slokaId) {
   //     this.slokaId = slokaId;
    //}
    private JSONArray sanskritSloka;
    private JSONArray romanSlokas;
    private String meaningOfSloka;

    public int getSlokaId() {
        return slokaId;
    }
    public void setSlokaId(int slokaId) {
        this.slokaId = slokaId;
    }

    public JSONArray getSanskritSloka() {
        return sanskritSloka;
    }

    public void setSanskritSloka(JSONArray sanskritSloka) { this.sanskritSloka = sanskritSloka; }

    public List<String> getSanskrit()  {
        List<String> list = new ArrayList<>();
        for(int i=0;i<sanskritSloka.length();i++) {
            try {
                list.add(sanskritSloka.getString(i));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public JSONArray getRomanSlokas() {
        return romanSlokas;
    }
    public List<String> getEnglish() {
        List<String> list = new ArrayList<>();
        for(int i=0;i<romanSlokas.length();i++) {
            try {
                list.add(romanSlokas.getString(i));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public void setRomanSlokas(JSONArray romanSlokas) {
        this.romanSlokas = romanSlokas;
    }

    public String getMeaningOfSloka() {
        return meaningOfSloka;
    }

    public void setMeaningOfSloka(String meaningOfSloka) {
        this.meaningOfSloka = meaningOfSloka;
    }
}
