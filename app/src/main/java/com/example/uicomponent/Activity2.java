package com.example.uicomponent;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item ){
        TextView text=findViewById(R.id.text);
        switch (item.getItemId()){
            case R.id.item1:
                Toast.makeText(this, "普通项", Toast.LENGTH_SHORT).show();
                break;
            case R.id.font1:
                text.setTextSize(10);
                break;
            case R.id.font2:
                text.setTextSize(16);
                break;
            case R.id.font3:
                text.setTextSize(20);
                break;
            case R.id.color1:
                text.setTextColor(Color.RED);
                break;
            case R.id.color2:
                text.setTextColor(Color.BLACK);
                break;
        }
        return  true;
    }
}
