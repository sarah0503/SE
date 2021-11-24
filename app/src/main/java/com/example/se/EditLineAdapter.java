package com.example.se;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class EditLineAdapter extends RecyclerView.Adapter<EditLineAdapter.ViewHolder> {

    private ArrayList<Bus> busArrayList = new ArrayList<>();
    private Intent intent;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.line, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(busArrayList.get(position));

        //노선 선택했을 때 -> 노선 경유지 편집 화면으로
        int pos = position;
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }

    @Override
    public int getItemCount() {
        return busArrayList.size();
    }

    void addItem(Bus bus) {
        busArrayList.add(bus);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView departureTextView;
        private TextView arrivalTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            departureTextView = itemView.findViewById(R.id.departureTextView);
            arrivalTextView = itemView.findViewById(R.id.arrivalTextView);
        }

        public void onBind(Bus bus) {
            departureTextView.setText(bus.getDeparture());
            arrivalTextView.setText(bus.getArrival());
        }
    }
}
