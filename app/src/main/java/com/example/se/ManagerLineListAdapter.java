package com.example.se;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ManagerLineListAdapter extends RecyclerView.Adapter<ManagerLineListAdapter.ViewHolder> {

    private ArrayList<Bus> busArrayList = new ArrayList<>();

    @NonNull
    @Override
    public ManagerLineListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.line_checkbox, parent, false);
        return new ManagerLineListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ManagerLineListAdapter.ViewHolder holder, int position) {
        holder.onBind(busArrayList.get(position));

        int pos = position;

        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setTitle("Confirm");
                builder.setMessage("노선을 삭제하시겠습니까?");
                builder.setPositiveButton("삭제", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        busArrayList.remove(pos);       //리스트 항목 삭제됨
                        notifyItemRemoved(pos);
                        notifyItemRangeChanged(pos, busArrayList.size());


                        //노선 삭제하기


                        Toast.makeText(builder.getContext(), "노선이 삭제되었습니다.", Toast.LENGTH_LONG).show();
                    }
                });
                builder.setNeutralButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        holder.checkBox.setChecked(false);
                        Toast.makeText(builder.getContext(), "취소되었습니다.", Toast.LENGTH_LONG).show();
                    }
                });
                builder.create().show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return busArrayList.size();
    }

    public ArrayList getList() {
        return busArrayList;
    }

    void addItem(Bus bus) {
        busArrayList.add(bus);
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView departureTextView;
        private TextView arrivalTextView;
        private TextView stop1TextView;
        private TextView stop2TextView;
        private TextView stop3TextView;
        private CheckBox checkBox;

        ViewHolder(@NonNull View itemView){
            super(itemView);

            departureTextView = itemView.findViewById(R.id.departureTextView);
            arrivalTextView = itemView.findViewById(R.id.arrivalTextView);
            stop1TextView = itemView.findViewById(R.id.stop1TextView);
            stop2TextView = itemView.findViewById(R.id.stop2TextView);
            stop3TextView = itemView.findViewById(R.id.stop3TextView);
            checkBox = itemView.findViewById(R.id.checkBox);

        }

        void onBind(Bus bus) {
            departureTextView.setText(bus.getDeparture());
            stop1TextView.setText(bus.getStop1());
            stop2TextView.setText(bus.getStop2());
            stop3TextView.setText(bus.getStop3());
            arrivalTextView.setText(bus.getArrival());
        }

    }
}
