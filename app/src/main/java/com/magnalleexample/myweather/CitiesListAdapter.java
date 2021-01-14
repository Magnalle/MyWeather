package com.magnalleexample.myweather;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.ListAdapter;

import java.util.List;

public class CitiesListAdapter
        extends ListAdapter<String, CitiesListAdapter.MyView> {

    MutableLiveData<String>  chosenCityName = new MutableLiveData<>();
    public class MyView
            extends RecyclerView.ViewHolder {

        TextView cityNameView;

        public MyView(View view)
        {
            super(view);
            cityNameView = (TextView)view
                    .findViewById(R.id.cityNameView);
        }
    }

    static public class DiffCallback extends DiffUtil.ItemCallback<String>{
        @Override
        public boolean areItemsTheSame(@NonNull String oldItem, @NonNull String newItem) {
            return oldItem.equals(newItem);
        }

        @Override
        public boolean areContentsTheSame(@NonNull String oldItem, @NonNull String newItem) {
            return oldItem.equals(newItem);
        }
    }

    protected CitiesListAdapter(@NonNull DiffUtil.ItemCallback<String> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public MyView onCreateViewHolder(ViewGroup parent,
                                     int viewType)
    {

        View itemView
                = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_cities_list,
                        parent,
                        false);

        return new MyView(itemView);
    }

    @Override
    public void onBindViewHolder(final MyView holder,
                                 final int position)
    {
        holder.cityNameView.setText(getItem(position));
        holder.cityNameView.setOnClickListener(v -> {
            chosenCityName.setValue(holder.cityNameView.getText().toString());
        });
    }

}
