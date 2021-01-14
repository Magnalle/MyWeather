package com.magnalleexample.myweather;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;

import com.magnalleexample.myweather.databinding.ActivityCitiesListBinding;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class CitiesListActivity extends AppCompatActivity {

    public static final String cityNameKey = "cityName";
    ArrayList<String> citiesList;
    public MutableLiveData<String> CityText = new MutableLiveData<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cities_list);
        addCities();
        ActivityCitiesListBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_cities_list);
        binding.setActivity(this);
        binding.setLifecycleOwner(this);

        CitiesListAdapter adapter = new CitiesListAdapter(new CitiesListAdapter.DiffCallback());
        adapter.submitList(citiesList);
        adapter.chosenCityName.observe(this, s ->{
            if(!s.isEmpty()) {
                Intent intent = new Intent();
                intent.putExtra(cityNameKey, s);
                setResult(RESULT_OK, intent);
                s = "";
                finish();
            }
        });

        RecyclerView.LayoutManager layoutManager
                = new LinearLayoutManager(
                CitiesListActivity.this,
                LinearLayoutManager.VERTICAL,
                false);
        binding.citiesRecyleView.setLayoutManager(layoutManager);
        binding.citiesRecyleView.setAdapter(adapter);
        CityText.observe(this, s -> {
            if(s.isEmpty()){
                adapter.submitList(citiesList);
            }
            else{
                ArrayList<String> currentList = new ArrayList<>();
                for(String l : citiesList){
                    if(l.contains(CityText.getValue()))
                        currentList.add(l);
                }
                adapter.submitList(currentList);
            }
        });



    }

    public void addCities()
    {
        citiesList = new ArrayList<>();
        citiesList.add("Москва");
        citiesList.add("Санкт-Петербург");
        citiesList.add("Архангельск");
        citiesList.add("Барнаул");
        citiesList.add("Белгород");
        citiesList.add("Биробиджан");
        citiesList.add("Благовещенск");
        citiesList.add("Брянск");
        citiesList.add("Великий Новгород");
        citiesList.add("Владивосток");
        citiesList.add("Владикавказ");
        citiesList.add("Владимир");
        citiesList.add("Волгоград");
        citiesList.add("Вологда");
        citiesList.add("Воронеж");
        citiesList.add("Горно-Алтайск");
        citiesList.add("Грозный");
        citiesList.add("Екатеринбург");
    }

}