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

public class EditLineAdapter extends RecyclerView.Adapter<EditLineAdapter.ViewHolder3> {

    private ArrayList<Bus> busArrayList = new ArrayList<>();
    private Intent intent;

    @NonNull
    @Override
    public ViewHolder3 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.line, parent, false);
        return new ViewHolder3(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder3 holder, int position) {
        holder.onBind(busArrayList.get(position));

        //노선 선택했을 때 -> 노선 경유지 편집 화면으로 (EditingLine.java)
        int pos = position;
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(view.getContext(), EditingLine.class);
                view.getContext().startActivity(intent);
                Toast.makeText(view.getContext(), "클릭 되었습니다.", Toast.LENGTH_SHORT).show();
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

    public class ViewHolder3 extends RecyclerView.ViewHolder {
        private TextView departureTextView;
        private TextView arrivalTextView;

        public ViewHolder3(@NonNull View itemView) {
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
