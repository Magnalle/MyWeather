package com.magnalleexample.myweather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    // Recycler View object
    RecyclerView recyclerView;
    // Array list for recycler view data source
    ArrayList<DaysData> source;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView)findViewById(R.id.list_days);
        TextView currentTemperature = (TextView)findViewById(R.id.temperature);
        currentTemperature.setText(Integer.toString(-25));

        AddItemsToRecyclerViewArrayList();

        DaysListAdapter adapter = new DaysListAdapter(source);

        RecyclerView.LayoutManager layoutManager
                = new LinearLayoutManager(
                MainActivity.this,
                LinearLayoutManager.HORIZONTAL,
                false);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);
    }

    public void AddItemsToRecyclerViewArrayList()
    {
        source = new ArrayList<>();
        source.add(new DaysData(-25, Calendar.getInstance().getTimeInMillis()));
        source.add(new DaysData(-20, Calendar.getInstance().getTimeInMillis() + 1 * 24 * 3600 * 1000));
        source.add(new DaysData(-18, Calendar.getInstance().getTimeInMillis() + 2 * 24 * 3600 * 1000));
        source.add(new DaysData(-26, Calendar.getInstance().getTimeInMillis() + 3 * 24 * 3600 * 1000));
        source.add(new DaysData(-30, Calendar.getInstance().getTimeInMillis() + 4 * 24 * 3600 * 1000));
    }
}