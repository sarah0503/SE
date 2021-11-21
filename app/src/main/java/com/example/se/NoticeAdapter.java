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

public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.ViewHolder4> {

    private ArrayList<NoticeForm> noticeArrayList = new ArrayList<>();

    @NonNull
    @Override
    public NoticeAdapter.ViewHolder4 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.notice_checkbox, parent, false);
        return new NoticeAdapter.ViewHolder4(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoticeAdapter.ViewHolder4 holder, int position) {
        holder.onBind(noticeArrayList.get(position));

        int pos = position;

        holder.noticeCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setTitle("Confirm");
                builder.setMessage("공지사항을 삭제하시겠습니까?");
                builder.setPositiveButton("삭제", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        noticeArrayList.remove(pos);       //리스트 항목 삭제됨
                        notifyItemRemoved(pos);
                        notifyItemRangeChanged(pos, noticeArrayList.size());


                        //공지사항 삭제하기


                        Toast.makeText(builder.getContext(), "공지사항이 삭제되었습니다.", Toast.LENGTH_LONG).show();
                    }
                });
                builder.setNeutralButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        holder.noticeCheckBox.setChecked(false);
                        Toast.makeText(builder.getContext(), "취소되었습니다.", Toast.LENGTH_LONG).show();
                    }
                });
                builder.create().show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return noticeArrayList.size();
    }

    void addItem(NoticeForm noticeForm) {
        noticeArrayList.add(noticeForm);
    }

    public class ViewHolder4 extends RecyclerView.ViewHolder {
        private TextView titleTextView;
        private TextView dateTextView;
        private CheckBox noticeCheckBox;

        public ViewHolder4(@NonNull View itemView) {
            super(itemView);

            titleTextView = itemView.findViewById(R.id.titleTextView);
            dateTextView = itemView.findViewById(R.id.dateTextView);
            noticeCheckBox = itemView.findViewById(R.id.noticeCheckBox);
        }

        public void onBind(NoticeForm noticeForm) {
            titleTextView.setText(noticeForm.getTitle());
            dateTextView.setText(noticeForm.getDate());
        }
    }
}
