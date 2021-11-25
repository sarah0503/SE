package com.example.se;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class UserInformAdapter extends BaseAdapter {
    ArrayList<UserInformation> items = new ArrayList<UserInformation>();
    Context context;
    UserInformation userinfo = new UserInformation();

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        context = parent.getContext();
        UserInformation listItem = items.get(position);

        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.user_info_listview_item, parent, false);
        }

        TextView idText = convertView.findViewById(R.id.tv_id);
        TextView nameText = convertView.findViewById(R.id.tv_name);
        TextView emailText = convertView.findViewById(R.id.tv_email);
        TextView penaltyText = convertView.findViewById(R.id.tv_penalty);

        idText.setText(userinfo.getUserID());
        nameText.setText(userinfo.getUserName());
        emailText.setText(userinfo.getUserEmail());
        penaltyText.setText(userinfo.getPenaltyCount());

        return convertView;
    }

    public void addItem(UserInformation item) {
        items.add(item);
    }
}
