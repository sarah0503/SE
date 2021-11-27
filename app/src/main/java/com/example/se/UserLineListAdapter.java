package com.example.se;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserLineListAdapter extends RecyclerView.Adapter<UserLineListAdapter.ViewHolder> {

    private ArrayList<Bus> busArrayList = new ArrayList<>();

    @NonNull
    @Override
    public UserLineListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.user_line, parent, false);
        return new UserLineListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserLineListAdapter.ViewHolder holder, int position) {
        holder.onBind(busArrayList.get(position));

        int pos = position;

        holder.bookmarkButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) { //버튼을 눌렀을 때
                    if(holder.bookmarkButton.isSelected()) {
                        //선택된 상태 -> 선택 해제
                        holder.bookmarkButton.setSelected(false);
                        holder.bookmarkButton.setBackgroundResource(R.drawable.ic_star_border);
                        
                        //즐겨찾기에서 삭제
                    }
                    else {
                        //선택 해제된 상태 -> 선택
                        holder.bookmarkButton.setSelected(true);
                        holder.bookmarkButton.setBackgroundResource(R.drawable.ic_star);
                        
                        //즐겨찾기에 추가
                    }
                }
                return false;
            }
        });
    }

    void addItem(Bus bus) {
        busArrayList.add(bus);
    }

    @Override
    public int getItemCount() {
        return busArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView userDeparture;
        private TextView userStop1;
        private TextView userStop2;
        private TextView userStop3;
        private TextView userArrival;
        private TextView userTime;
        private TextView userSeat;
        private Button bookmarkButton;

        ViewHolder(@NonNull View itemView){
            super(itemView);

            userDeparture = itemView.findViewById(R.id.userDeparture);
            userStop1 = itemView.findViewById(R.id.userStop1);
            userStop2 = itemView.findViewById(R.id.userStop2);
            userStop3 = itemView.findViewById(R.id.userStop3);
            userArrival = itemView.findViewById(R.id.userArrival);
            userTime = itemView.findViewById(R.id.userTime);
            userSeat = itemView.findViewById(R.id.userSeat);
            bookmarkButton = itemView.findViewById(R.id.bookmarkButton);
        }

        void onBind(Bus bus) {
            userDeparture.setText(bus.getDeparture());
            userStop1.setText(bus.getStop1());
            userStop2.setText(bus.getStop2());
            userStop3.setText(bus.getStop3());
            userArrival.setText(bus.getArrival());
            userTime.setText("출발 시각: " + bus.getDepartureTime() + "시");
            userSeat.setText("잔여좌석: " + bus.getCapacity() + "석");
        }

    }
}
