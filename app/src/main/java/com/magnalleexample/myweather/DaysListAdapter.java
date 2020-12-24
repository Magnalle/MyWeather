package com.magnalleexample.myweather;

import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.view.LayoutInflater;
import java.util.List;

public class DaysListAdapter
        extends RecyclerView.Adapter<DaysListAdapter.MyView> {

    private List<DaysData> list;

    public class MyView
            extends RecyclerView.ViewHolder {

        TextView temperature;
        TextView weekday;

        public MyView(View view)
        {
            super(view);
            temperature = (TextView)view
                    .findViewById(R.id.temperatureView);
            weekday = (TextView)view
                    .findViewById(R.id.weekdayView);
        }
    }

    public DaysListAdapter(List<DaysData> list)
    {
        this.list = list;
    }

    @Override
    public MyView onCreateViewHolder(ViewGroup parent,
                                     int viewType)
    {

        View itemView
                = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_days_list,
                        parent,
                        false);

        return new MyView(itemView);
    }

    @Override
    public void onBindViewHolder(final MyView holder,
                                 final int position)
    {
        holder.temperature.setText(Integer.toString(list.get(position).getTemperature()));
        holder.weekday.setText(list.get(position).getWeekday());
    }

    @Override
    public int getItemCount()
    {
        return list.size();
    }
}
