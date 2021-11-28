package com.example.se;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Reservtion_checkAdapter extends BaseAdapter {

    Context rContext = null;
    LayoutInflater rLayoutInflater = null;
    ArrayList<Reservation> reservation;

    public Reservtion_checkAdapter(Context context, ArrayList<Reservation> data){
        rContext = context;
        reservation = data;
        rLayoutInflater = LayoutInflater.from(rContext);
    }

    @Override
    public int getCount() {
        return reservation.size();
    }

    @Override
    public Object getItem(int position) {
        return reservation.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = rLayoutInflater.inflate(R.layout.reservation_check_item, null);

        TextView busid = (TextView)view.findViewById(R.id.busid);
        TextView userDeparture = (TextView)view.findViewById(R.id.userDeparture);
        TextView userArrival = (TextView)view.findViewById(R.id.userArrival);
        TextView time = (TextView)view.findViewById(R.id.time);

        busid.setText(Integer.toString(reservation.get(position).getBusId()));
        userDeparture.setText(reservation.get(position).getDeparture());
        userArrival.setText(reservation.get(position).getArrival());
        time.setText(Integer.toString(reservation.get(position).getTime()));

        return view;
    }
}
