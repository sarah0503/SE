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

public class UserNoticeListAdapter extends RecyclerView.Adapter<UserNoticeListAdapter.ViewHolder> {

    private ArrayList<Notice> noticeArrayList = new ArrayList<>();

    @NonNull
    @Override
    public UserNoticeListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.user_notice, parent, false);
        return new UserNoticeListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserNoticeListAdapter.ViewHolder holder, int position) {
        holder.onBind(noticeArrayList.get(position));

        int pos = position;

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                Toast.makeText(builder.getContext(), noticeArrayList.get(pos).getTitle() + " - "
                        + noticeArrayList.get(pos).getDate() + " 선택됨", Toast.LENGTH_SHORT).show();
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
        private TextView userNoticeTitle;
        private TextView userNoticeDate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            userNoticeTitle = itemView.findViewById(R.id.userNoticeTitle);
            userNoticeDate = itemView.findViewById(R.id.userNoticeDate);
        }

        public void onBind(Notice notice) {
            userNoticeTitle.setText(notice.getTitle());
            userNoticeDate.setText(notice.getDate());
        }
    }
}
