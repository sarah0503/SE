package com.example.se;

import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserNoticeListAdapter extends RecyclerView.Adapter<UserNoticeListAdapter.ViewHolder> {

    private ArrayList<Notice> noticeArrayList = new ArrayList<>();
    private Dialog detailDialog;
    private TextView title, date, content;
    private Button closeButton;

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

        holder.itemView.setOnClickListener(new View.OnClickListener() { //공지사항 누르면 내용 상세보기
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());

                detailDialog = new Dialog(view.getContext());
                detailDialog.setContentView(R.layout.notice_detail);

                title = detailDialog.findViewById(R.id.noticeTitle);
                date = detailDialog.findViewById(R.id.noticeDate);
                content = detailDialog.findViewById(R.id.noticeContent);

                //noticeArrayList에 저장된 내용 가져와서 dialog로 표시하기
                title.setText("" + noticeArrayList.get(pos).getTitle());
                date.setText("" + noticeArrayList.get(pos).getDate());
                content.setText("" + noticeArrayList.get(pos).getContent());

                detailDialog.show();

                closeButton = detailDialog.findViewById(R.id.noticeCloseButton);
                closeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        detailDialog.dismiss();
                    }
                });
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
