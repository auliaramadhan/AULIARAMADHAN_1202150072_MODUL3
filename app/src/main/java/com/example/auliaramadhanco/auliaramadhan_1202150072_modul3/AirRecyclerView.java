package com.example.auliaramadhanco.auliaramadhan_1202150072_modul3;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class AirRecyclerView extends AppCompatActivity {


    private RecyclerView mRecyclerView;
    private ArrayList<Air> mAirData;
    private AirAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_air_recycler_view);
        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerview);
        //Get the appropriate column count
        int gridColumnCount = getResources().getInteger(R.integer.grid_column_count);
        //Set the Layout Manager
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, gridColumnCount));
        //Initialize the ArrayList that will contain the data
        mAirData = new ArrayList<>();
        //Initialize the adapter and set it ot the RecyclerView
        mAdapter = new AirAdapter(this, mAirData);

        initializeData();
    }

    private void initializeData() {
        String[] namaList = getResources().getStringArray(R.array.nama_label_air);
        TypedArray imageID = getResources().obtainTypedArray(R.array.image_label_air);
        mAirData.clear();

        //Create the ArrayList of Sports objects containing the titles,
        // images and information about each sport
        for(int i=0; i<namaList.length; i++){
            mAirData.add(new Air(namaList[i],
                    imageID.getResourceId(i,0)));
        }

        //Recycle the typed array
        imageID.recycle();

        //Notify the adapter of the change
        mAdapter.notifyDataSetChanged();
        mRecyclerView.setAdapter(mAdapter);
    }
}
