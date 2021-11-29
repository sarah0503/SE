package com.example.se;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Bookmark_checkAdapter extends BaseAdapter {

    Context bContext = null;
    LayoutInflater bLayoutInflater = null;
    ArrayList<Bookmark> bookmark;

    public Bookmark_checkAdapter(Context context, ArrayList<Bookmark> data){
        bContext = context;
        bookmark = data;
        bLayoutInflater = LayoutInflater.from(bContext);
    }

    @Override
    public int getCount() {
        return bookmark.size();
    }

    @Override
    public Object getItem(int position) {
        return bookmark.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = bLayoutInflater.inflate(R.layout.bookmark_check_item, null);

        TextView busid = (TextView)view.findViewById(R.id.busid);
        TextView userDeparture = (TextView)view.findViewById(R.id.userDeparture);
        TextView userArrival = (TextView)view.findViewById(R.id.userArrival);
        TextView time = (TextView)view.findViewById(R.id.time);

        busid.setText(Integer.toString(bookmark.get(position).getBusId()));
        userDeparture.setText(bookmark.get(position).getDeparture());
        userArrival.setText(bookmark.get(position).getArrival());
        time.setText(Integer.toString(bookmark.get(position).getTime()));

        return view;
    }
}
