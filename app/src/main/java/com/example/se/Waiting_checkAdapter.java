package com.example.se;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Waiting_checkAdapter extends BaseAdapter {

    Context wContext = null;
    LayoutInflater wLayoutInflater = null;
    ArrayList<Waiting> waiting;

    public Waiting_checkAdapter(Context context, ArrayList<Waiting> data){
        wContext = context;
        waiting = data;
        wLayoutInflater = LayoutInflater.from(wContext);
    }

    @Override
    public int getCount() {
        return waiting.size();
    }

    @Override
    public Object getItem(int position) {
        return waiting.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = wLayoutInflater.inflate(R.layout.waiting_check_item, null);

        TextView busid = (TextView)view.findViewById(R.id.busid);
        TextView userDeparture = (TextView)view.findViewById(R.id.userDeparture);
        TextView userArrival = (TextView)view.findViewById(R.id.userArrival);
        TextView time = (TextView)view.findViewById(R.id.time);
        TextView count = (TextView)view.findViewById(R.id.count);

        busid.setText(waiting.get(position).getBusId());
        userDeparture.setText(waiting.get(position).getDeparture());
        userArrival.setText(waiting.get(position).getArrival());
        time.setText(waiting.get(position).getTime());
        count.setText(waiting.get(position).getWaitingCount());

        return view;
    }
}
