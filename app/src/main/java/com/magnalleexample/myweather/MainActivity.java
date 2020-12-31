package com.magnalleexample.myweather;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    // Recycler View object
    RecyclerView recyclerView;
    // Array list for recycler view data source
    ArrayList<DaysData> source;
    int number = (int)(Math.random() * 100);
    final int DAY_LENGTH_MILLI = 24 * 3600 * 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView)findViewById(R.id.daysRecycleView);
        TextView currentTemperature = (TextView)findViewById(R.id.temperatureView);
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

        number = State.getInstance().getNumber();
        setNumberToView();

        addMessageToLog("OnCreate called.");
    }

    void setNumberToView(){
        TextView test = (TextView)findViewById(R.id.cityView);
        test.setText(Integer.toString(number));
    }

    void addMessageToLog(String message){
        Log.d("MyMessage", message);
        Toast.makeText(this.getApplicationContext(), message, Toast.LENGTH_SHORT).show();
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
    protected void onStart() {
        super.onStart();
        addMessageToLog("OnStart called.");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        addMessageToLog("OnRestart called.");
    }

    @Override
    protected void onResume() {
        super.onResume();
        addMessageToLog("OnResume called.");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        addMessageToLog("OnDestroy called.");
    }

    @Override
    protected void onStop() {
        super.onStop();
        addMessageToLog("OnStop called.");
    }

    @Override
    protected void onPause() {
        super.onPause();
        addMessageToLog("OnPause called.");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        //outState.putInt("Number", number);
        super.onSaveInstanceState(outState);
        addMessageToLog("onSaveInstanceState called.");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        //number = savedInstanceState.getInt("Number");
        //setNumberToView();
        addMessageToLog("onRestoreInstanceState called.");
    }
}