package com.example.listviewsimpleadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    String name[] = {"Man", "Female", "Boy", "Imi"};
    int images[] = {R.drawable.mmmm, R.drawable.ffff, R.drawable.bbbb, R.drawable.iiii};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("SimpleAdapter");
        listView = findViewById(R.id.l1);
        ArrayList<HashMap<String, String>> arrayList = new ArrayList();
        //creating hashmap to store data in Key-Value pair.
        for (int i = 0; i < name.length; i++) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("key1", name[i]);//here converting int images to string
            hashMap.put("key2", images[i] + "");
            arrayList.add(hashMap);//adding hashmap to arraylist.
        }
        String from[] = {"key1", "key2"};
        int to[] = {R.id.t1, R.id.i1};
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, arrayList, R.layout.items, from, to);
        listView.setAdapter(simpleAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), name[position], Toast.LENGTH_SHORT).show();
            }
        });

    }
}
