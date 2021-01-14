package com.magnalleexample.myweather;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    public static final int requestCodeChooseCity = 1;
    // Recycler View object
    RecyclerView recyclerView;
    // Array list for recycler view data source
    ArrayList<DaysData> source;
    TextView cityView;
    TextView currentTemperature;
    TextView browseInternetView;
    int number = (int)(Math.random() * 100);
    final int DAY_LENGTH_MILLI = 24 * 3600 * 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FindViews();

        currentTemperature.setText(Integer.toString(-25));
        cityView.setOnClickListener(v ->{
            Intent intent = new Intent(MainActivity.this, CitiesListActivity.class);
            startActivityForResult(intent, requestCodeChooseCity);
        });
        browseInternetView.setOnClickListener(v ->{
            Uri address = Uri.parse("https://yandex.ru/pogoda/");
            Intent intent = new Intent(Intent.ACTION_VIEW, address);
            startActivity(intent);
        });

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

    private void FindViews() {
        recyclerView = (RecyclerView)findViewById(R.id.daysRecycleView);
        currentTemperature = (TextView)findViewById(R.id.temperatureView);
        cityView = (TextView) findViewById(R.id.cityView);
        browseInternetView =  (TextView) findViewById(R.id.browseInternet);
    }

    public void AddItemsToRecyclerViewArrayList()
    {
        source = new ArrayList<>();
        source.add(new DaysData(-25, Calendar.getInstance().getTimeInMillis()));
        source.add(new DaysData(-20, Calendar.getInstance().getTimeInMillis() + 1 * DAY_LENGTH_MILLI));
        source.add(new DaysData(-18, Calendar.getInstance().getTimeInMillis() + 2 * DAY_LENGTH_MILLI));
        source.add(new DaysData(-26, Calendar.getInstance().getTimeInMillis() + 3 * DAY_LENGTH_MILLI));
        source.add(new DaysData(-30, Calendar.getInstance().getTimeInMillis() + 4 * DAY_LENGTH_MILLI));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == requestCodeChooseCity && resultCode == RESULT_OK){
            cityView.setText(data.getStringExtra(CitiesListActivity.cityNameKey));
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putString(CitiesListActivity.cityNameKey, cityView.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        cityView.setText(savedInstanceState.getString(CitiesListActivity.cityNameKey));
    }
}