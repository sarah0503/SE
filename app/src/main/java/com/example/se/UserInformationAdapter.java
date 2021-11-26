package com.example.se;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
// 여기서 User 클래스를 선언(User 생성자)해서 textView 에 값을 넣은게 아니라
// getView 에서 선언한 UserInformation 의 listItem 의 get 값을 불러옴
public class UserInformationAdapter extends BaseAdapter {
    ArrayList<UserInformation> items = new ArrayList<UserInformation>();
    Context context;
//    UserInformation userinfo = new UserInformation();

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

        idText.setText(listItem.getUserID());
        nameText.setText(listItem.getUserName());
        emailText.setText(listItem.getUserEmail());
        penaltyText.setText(listItem.getPenaltyCount());

        return convertView;
    }

    public void addItem(UserInformation item) {
        items.add(item);
    }
}