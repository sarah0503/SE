
        package com.example.se;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AddLineAdapter extends RecyclerView.Adapter<AddLineAdapter.ViewHolder> {

    private ArrayList<Bus> busArrayList = new ArrayList<>();

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
    }

    @Override
    public int getItemCount() {
        return busArrayList.size();
    }

    void addItem(Bus bus) {
        busArrayList.add(bus);
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView departureTextView;
        public TextView arrivalTextView;

        ViewHolder(@NonNull View itemView){
            super(itemView);

            departureTextView = itemView.findViewById(R.id.departureTextView);
            arrivalTextView = itemView.findViewById(R.id.arrivalTextView);
        }

        void onBind(Bus bus) {
            departureTextView.setText(bus.getDeparture());
            arrivalTextView.setText(bus.getArrival());
        }

        @Override
        public void onClick(View view) {
            switch(view.getId()) {
                case R.id.list_item:
                    //추가하시겠습니까?

                    //AlertDialog.Builder builder = new AlertDialog.Builder(AddLineAdapter.ViewHolder.this);
                    //builder.setTitle("Confirm");
                    //builder.setMessage("노선을 추가하시겠습니까?");
                    //builder.setPositiveButton("추가", null);
                    //builder.setNeutralButton("취소", null);
                    //builder.create().show();
                    break;
            }
        }
    }
}