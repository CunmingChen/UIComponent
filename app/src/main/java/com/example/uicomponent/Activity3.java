package com.example.uicomponent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Activity3 extends AppCompatActivity {
    private String[] text={"One","Two","Three","Four","Five"};
    private int image=R.drawable.android;
    private String[] from={"mage","txt"};
    private int[] to={R.id.mage,R.id.txt};
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actionmode);
        List<Map<String,Object>> l=new ArrayList<Map<String,Object>>();
        for(int i=0;i<text.length;i++){
            Map<String,Object> m=new HashMap<String,Object>();
            m.put("mage",image);
            m.put("txt",text[i]);
            l.add(m);
        }
        SimpleAdapter adapter=new SimpleAdapter(this,l,R.layout.actionmode_layout,from,to);
        list=findViewById(R.id.modelist);
        list.setAdapter(adapter);
        registerForContextMenu(list);
        list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        list.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            private int count=0;

            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
                if(checked){
                    list.getChildAt(position).setBackgroundColor(getResources().getColor(R.color.colorBule));
                    count++;
                }else{
                    list.getChildAt(position).setBackgroundColor(0);
                    count--;
                }mode.setTitle(count+"selected");
            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                getMenuInflater().inflate(R.menu.actionmenu,menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                return false;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {

            }
        });

    }
}
