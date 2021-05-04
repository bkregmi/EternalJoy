package com.example.eternaljoy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;



import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public String fileName = "gita-dhayanam.json";
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        Gson gson = new Gson();
        Type colType = new TypeToken<Collection<SlokaList>>(){}.getType();
        List<SlokaList> myPrayers = gson.fr omJson(loadJSONFromAsset("daily-prayers.json"), colType);
        //Log.d("TEST", myPrayers.toString());
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvSlokas);
        SlokaAdapter adapter = new SlokaAdapter(this, myPrayers);
        Log.d("ADAPTER",adapter.toString());
        Log.d("ADAPTER", adapter.getSloka());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

         */
    }

    public void openMainActivity2(View view){
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);


    }
    public void sendMessage(View view) {
        //Intent intent = new Intent(this, DisplayMessageActivity.class);
        //EditText editText = (EditText) findViewById(R.id.textView1);
        //String message = editText.getText().toString();
        //this.fileName = "daily-prayers.json";

        
        switch(view.getId())
        {
            case R.id.dailyPrayers:
                this.fileName = "daily-prayers.json";
                break;
            case R.id.btnDhyanam:
                this.fileName = "gita-dhayanam.json";
                break;
            case R.id.btnInvocation:
                this.fileName = "invocation-slokas.json";
                break;
            case R.id.btnGita:
                this.fileName = "suryastakam.json";
                break;
            default:
                throw new RuntimeException("Unknow button ID");
        }

        String message = "";
        Gson gson = new Gson();
        Type colType = new TypeToken<Collection<SlokaList>>(){}.getType();
        List<SlokaList> myPrayers = gson.fromJson(loadJSONFromAsset(this.fileName), colType);
        for (SlokaList slokaList: myPrayers){
            message = message + "<h3>" + slokaList.getTitle() +"</h3>";
            List <Sloka> slokas = slokaList.getSlokas();
            for(int i=0;i<slokas.size();i++){
                message = message + TextUtils.join("<br>",slokas.get(i).getSanskrit()) +"<br><br>";
                message = message  + TextUtils.join("<br>",slokas.get(i).getEnglish()) +"<br>";
                message = message + "<b>Meaning: </b><i>" + slokas.get(i).getMeaning() +"</i><br>";
            }
        }

        TextView textView = (TextView) findViewById(R.id.textViewMainDisplay);
        textView.setText(Html.fromHtml(message));
        textView.setMovementMethod(new ScrollingMovementMethod());
        // intent.putExtra(EXTRA_MESSAGE, (Serializable) adapter);
        // startActivity(intent);
    }

    public String loadJSONFromAsset(String fileName) {
        String json;
        try {
            InputStream is = getAssets().open(fileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
            return json;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}