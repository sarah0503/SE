package com.example.se;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

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

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView departureTextView;
        private TextView arrivalTextView;

        ViewHolder(@NonNull View itemView){
            super(itemView);

            departureTextView = itemView.findViewById(R.id.departureTextView);
            arrivalTextView = itemView.findViewById(R.id.arrivalTextView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v){
                    AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                    builder.setTitle("Confirm");
                    builder.setMessage("노선을 추가하시겠습니까?");
                    builder.setPositiveButton("추가", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int i) {
                            Toast.makeText(builder.getContext(), "노선이 추가되었습니다.", Toast.LENGTH_LONG).show();


                            // 노선 추가하는 동작


                        }
                    });
                    builder.setNeutralButton("취소", null);
                    builder.create().show();
                }
            });
        }

        void onBind(Bus bus) {
            departureTextView.setText(bus.getDeparture());
            arrivalTextView.setText(bus.getArrival());
        }
    }
}