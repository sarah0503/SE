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

public class ManagerNoticeListAdapter extends RecyclerView.Adapter<ManagerNoticeListAdapter.ViewHolder> {

    private ArrayList<Notice> noticeArrayList = new ArrayList<>();

    @NonNull
    @Override
    public ManagerNoticeListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.notice_checkbox, parent, false);
        return new ManagerNoticeListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ManagerNoticeListAdapter.ViewHolder holder, int position) {
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

    void addItem(Notice notice) {
        noticeArrayList.add(notice);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView titleTextView;
        private TextView dateTextView;
        private CheckBox noticeCheckBox;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            titleTextView = itemView.findViewById(R.id.titleTextView);
            dateTextView = itemView.findViewById(R.id.dateTextView);
            noticeCheckBox = itemView.findViewById(R.id.noticeCheckBox);
        }

        public void onBind(Notice notice) {
            titleTextView.setText(notice.getTitle());
            dateTextView.setText(notice.getDate());
        }
    }
}
