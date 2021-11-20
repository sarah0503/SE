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

public class ManagerLineListAdapter extends RecyclerView.Adapter<ManagerLineListAdapter.ViewHolder2> {

    private ArrayList<Bus> busArrayList = new ArrayList<>();

    @NonNull
    @Override
    public ManagerLineListAdapter.ViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.line_checkbox, parent, false);
        return new ManagerLineListAdapter.ViewHolder2(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ManagerLineListAdapter.ViewHolder2 holder, int position) {
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
                builder.setNeutralButton("취소", null);
                builder.create().show();
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

    class ViewHolder2 extends RecyclerView.ViewHolder {
        private TextView departureTextView_cb;
        private TextView arrivalTextView_cb;
        private CheckBox checkBox;

        ViewHolder2(@NonNull View itemView){
            super(itemView);

            departureTextView_cb = itemView.findViewById(R.id.departureTextView_cb);
            arrivalTextView_cb = itemView.findViewById(R.id.arrivalTextView_cb);
            checkBox = itemView.findViewById(R.id.checkBox);

        }

        void onBind(Bus bus) {
            departureTextView_cb.setText(bus.getDeparture());
            arrivalTextView_cb.setText(bus.getArrival());
        }

    }
}
