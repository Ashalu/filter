package com.developer.aashish.filter;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private ListView lv;
    private SearchView sv;

    String[] name={"Amit","deepak"};
ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sv = (SearchView) findViewById(R.id.search_view);
        lv = (ListView) findViewById(R.id.lv);
adapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,name);

        lv.setAdapter(adapter);
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String text) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String text) {
                adapter.getFilter().filter(text);

                return false;
            }
        });

    }
}
