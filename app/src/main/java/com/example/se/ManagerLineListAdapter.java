package com.example.se;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ManagerLineListAdapter extends RecyclerView.Adapter<ManagerLineListAdapter.ViewHolder> {

    private ArrayList<Bus> busArrayList = new ArrayList<>();
    private Dialog editDialog;
    private EditText editDeparture, editStop1, editStop2, editStop3, editArrival, editTime;
    private Button cancelButton, addButton;

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

        // 변경 기능
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editDialog = new Dialog(view.getContext());
                editDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                editDialog.setContentView(R.layout.edit_line_screen);
                WindowManager.LayoutParams params = editDialog.getWindow().getAttributes();
                params.width = WindowManager.LayoutParams.MATCH_PARENT;
                params.height = WindowManager.LayoutParams.WRAP_CONTENT;
                editDialog.getWindow().setAttributes((WindowManager.LayoutParams) params);

                // 초기화
                editDeparture = editDialog.findViewById(R.id.editDeparture);
                editStop1 = editDialog.findViewById(R.id.editStop1);
                editStop2 = editDialog.findViewById(R.id.editStop2);
                editStop3 = editDialog.findViewById(R.id.editStop3);
                editArrival = editDialog.findViewById(R.id.editArrival);
                editTime = editDialog.findViewById(R.id.editTime);

                // editText 내용: 선택한 노선의 정보로 설정
                editDeparture.setText(busArrayList.get(pos).getDeparture());
                editStop1.setText(busArrayList.get(pos).getStop1());
                editStop2.setText(busArrayList.get(pos).getStop2());
                editStop3.setText(busArrayList.get(pos).getStop3());
                editArrival.setText(busArrayList.get(pos).getArrival());
                editTime.setText(busArrayList.get(pos).getDepartureTime()+"");

                editDialog.show();

                // 다이얼로그의 추가 버튼
                addButton = editDialog.findViewById(R.id.editAdd);
                addButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        busArrayList.get(pos).setDeparture(editDeparture.getText().toString());
                        busArrayList.get(pos).setStop1(editStop1.getText().toString());
                        busArrayList.get(pos).setStop2(editStop2.getText().toString());
                        busArrayList.get(pos).setStop3(editStop3.getText().toString());
                        busArrayList.get(pos).setArrival(editArrival.getText().toString());
                        busArrayList.get(pos).setDepartureTime(Integer.parseInt(editTime.getText().toString()));

                        notifyItemChanged(pos);

                        editDialog.dismiss();
                    }
                });

                // 다이얼로그의 취소 버튼
                cancelButton = editDialog.findViewById(R.id.editCancel);
                cancelButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        editDialog.dismiss();   // 닫기
                    }
                });
            }
        });

        // 삭제 기능
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

    void addItem(Bus bus) {
        busArrayList.add(bus);
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView departureTextView;
        private TextView arrivalTextView;
        private TextView stop1TextView;
        private TextView stop2TextView;
        private TextView stop3TextView;
        private TextView timeTextView;
        private CheckBox checkBox;

        ViewHolder(@NonNull View itemView){
            super(itemView);

            departureTextView = itemView.findViewById(R.id.departureTextView);
            arrivalTextView = itemView.findViewById(R.id.arrivalTextView);
            stop1TextView = itemView.findViewById(R.id.stop1TextView);
            stop2TextView = itemView.findViewById(R.id.stop2TextView);
            stop3TextView = itemView.findViewById(R.id.stop3TextView);
            timeTextView = itemView.findViewById(R.id.timeTextView);
            checkBox = itemView.findViewById(R.id.checkBox);

        }

        void onBind(Bus bus) { // textView의 text 설정
            departureTextView.setText(bus.getDeparture());
            stop1TextView.setText(bus.getStop1());
            stop2TextView.setText(bus.getStop2());
            stop3TextView.setText(bus.getStop3());
            arrivalTextView.setText(bus.getArrival());
            timeTextView.setText(bus.getDepartureTime()+"");
        }

    }
}
