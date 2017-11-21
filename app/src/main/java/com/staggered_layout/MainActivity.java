package com.staggered_layout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SelectableViewHolder.OnItemSelectedListener {
    SelectableAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        StaggeredGridLayoutManager _sGridLayoutManager;
        _sGridLayoutManager = new StaggeredGridLayoutManager(4,
                StaggeredGridLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(_sGridLayoutManager);
        List<Item> selectableItems = generateItems();
        adapter = new SelectableAdapter(this, selectableItems);
        recyclerView.setAdapter(adapter);
    }

    public List<Item> generateItems(){

        List<Item> selectableItems = new ArrayList<>();
        selectableItems.add(new Item("Dancing"));
        selectableItems.add(new Item("Playback Singer"));
        selectableItems.add(new Item("Adventures"));
        selectableItems.add(new Item("Comedy"));
        selectableItems.add(new Item("Guitarist"));
        selectableItems.add(new Item("Musical Instruments"));
        selectableItems.add(new Item("Acting"));
        selectableItems.add(new Item("Poetry"));
        selectableItems.add(new Item("Handcrafts"));
        selectableItems.add(new Item("Playback Singer"));
        selectableItems.add(new Item("Writing"));
        selectableItems.add(new Item("Adventures"));
        selectableItems.add(new Item("Musical Instruments"));
        selectableItems.add(new Item("Acting"));
        selectableItems.add(new Item("Poetry"));
        selectableItems.add(new Item("Handcrafts"));

        return selectableItems;
    }

    @Override
    public void onItemSelected(SelectableItem item) {
        // List for multiple options select
        List<Item> selectedItems = adapter.getSelectedItems();
        Log.d("Selected List", String.valueOf(selectedItems));

        // To display selected item
        Toast.makeText(this, ""+ item.getName(), Toast.LENGTH_SHORT).show();
    }
}

