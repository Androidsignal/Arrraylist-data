package com.example.akshar.largejson;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    Mybean myBean;
    ArrayList<Mybean> arrayList;
    MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.mylistView);
        arrayList = new ArrayList<>();


        AsynkLoader asyncLoader = new AsynkLoader(MainActivity.this, "https://api.androidhive.info/contacts/", new OnAsynkLoader() {
            @Override
            public void OnResult(String result) {
                try {
                    JSONObject jsonObject = new JSONObject(result);
                    JSONArray jsonArray = jsonObject.getJSONArray("contacts");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject job = jsonArray.getJSONObject(i);
                        myBean = new Mybean();
                        myBean.setId(job.getString("id"));
                        myBean.setName(job.getString("name"));

                        JSONObject phone = job.getJSONObject("phone");
                        myBean.setMobile(phone.getString("mobile"));
                        myBean.setHome(phone.getString("home"));

                        arrayList.add(myBean);
                        // Log.d("array", "Onresult: "+arrayList);
                        myAdapter=new MyAdapter(getApplicationContext(),arrayList);
                        listView.setAdapter(myAdapter);

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }


        });
        asyncLoader.execute();

    }
}
