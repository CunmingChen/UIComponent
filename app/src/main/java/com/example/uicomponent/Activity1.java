package com.example.uicomponent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Activity1 extends AppCompatActivity {
    private String[] text={"Lion","Tiger","Monkey","Dog","Cat","Elephant"};
    private int[] image={R.drawable.lion,R.drawable.tiger,R.drawable.monkey,R.drawable.dog,R.drawable.cat,R.drawable.elephant};
    private ListView list;
    private String[] from={"image","text"};
    private int[] to={R.id.image,R.id.text};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_layout);
        List<Map<String,Object>> lists=new ArrayList<Map<String,Object>>();
        for (int i=0;i<text.length;i++){
            Map<String, Object> listem = new HashMap<String,Object>();
            listem.put("image",image[i]);
            listem.put("text",text[i]);
            lists.add(listem);
        }

        final SimpleAdapter adapter=new SimpleAdapter(this,lists,R.layout.listview_item,from,to);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView t=view.findViewById(R.id.text);
                view.setSelected(true);
                int duration= Toast.LENGTH_SHORT;
                Toast toast=Toast .makeText(Activity1.this,t.getText().toString(),duration);
                toast.show();

            }
        });
    }
}
