package com.example.hweat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class discover extends AppCompatActivity {
    SearchView mysearch;
    ListView mylist;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discover);
        mysearch=(SearchView)findViewById(R.id.search);
        mylist=(ListView)findViewById(R.id.list);

        list=new ArrayList<String>();

        list.add("韓式");
        list.add("日式");
        list.add("中式");
        list.add("素食");
        list.add("義式");
        list.add("辣");
        list.add("飲料");
        list.add("甜點");

        Context context;
        adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,list);
        mylist.setAdapter(adapter);
        mysearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });
    }
}
