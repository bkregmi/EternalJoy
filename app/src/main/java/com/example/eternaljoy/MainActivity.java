package com.example.eternaljoy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.example.eternaljoy.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        // EditText editText = (EditText) findViewById(R.id.editText);
        // String message = editText.getText().toString();

        ArrayList<SlokaCollection> slokaCollections = loadJSONFromAsset();
        String message= "Test" + slokaCollections.size();
        for(SlokaCollection slokaList: slokaCollections){
            message = message + "\n" + slokaList.getCollectionTitle();
            ArrayList<SlokaData> slokas= slokaList.getSlokaCollection();
            for (SlokaData sloka: slokas ){
                message = message + "\n" + sloka.getSlokaId();
                message = message + "\n" + TextUtils.join("\n",sloka.getSanskrit());
                message = message + "\n" + TextUtils.join("\n",sloka.getEnglish());
            }
        }
        // TextView textView = (TextView) findViewById(R.id.textViewMainDisplay);
        // textView.setText(message);
        // textView.setMovementMethod(new ScrollingMovementMethod());
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public ArrayList<SlokaCollection> loadJSONFromAsset() {
        String json;
        ArrayList<SlokaCollection> slokaCollection = new ArrayList<>();
        try {
            InputStream is = getAssets().open("prayers.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        JSONObject obj = null;
        try {
            obj = new JSONObject(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JSONArray prayers;
        JSONArray jsonSlokas;
        int slokaId;
        String title;
        ArrayList<String> sanskrit;
        ArrayList<String> english;
        String meaning = "";

        try {
            prayers = obj.getJSONArray("prayers");
            for (int i=0;i<prayers.length();i++){
                SlokaCollection collection = new SlokaCollection();
                ArrayList<SlokaData> slokaList = new ArrayList<>();
                title = prayers.getJSONObject(i).getString("title");
                System.out.println(title);
                jsonSlokas = prayers.getJSONObject(i).getJSONArray("slokas");
                for(int j=0;j<jsonSlokas.length();j++){
                    SlokaData slokaData = new SlokaData();
                    slokaData.setSlokaId(Integer.parseInt(jsonSlokas.getJSONObject(j).getString("id")));
                    slokaData.setSanskritSloka(jsonSlokas.getJSONObject(j).getJSONArray("sanskrit"));
                    slokaData.setRomanSlokas(jsonSlokas.getJSONObject(j).getJSONArray("english"));
                    slokaData.setMeaningOfSloka(meaning);
                    slokaList.add(slokaData);
                }
                collection.setCollectionTitle(title);
                collection.setSlokaCollection(slokaList);
                slokaCollection.add(collection);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return slokaCollection;
    }
}