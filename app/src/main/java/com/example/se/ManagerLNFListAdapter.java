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

public class ManagerLNFListAdapter extends RecyclerView.Adapter<ManagerLNFListAdapter.ViewHolder> {
    private ArrayList<LNF> lnfArrayList = new ArrayList<>();

    @NonNull
    @Override
    public ManagerLNFListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.lnf_checkbox, parent, false);
        return new ManagerLNFListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ManagerLNFListAdapter.ViewHolder holder, int position) {
        holder.onBind(lnfArrayList.get(position));

        int pos = position;

        holder.lnfCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setTitle("Confirm");
                builder.setMessage("공지사항을 삭제하시겠습니까?");
                builder.setPositiveButton("닫기", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        //상세내용
                        Toast.makeText(builder.getContext(), "상세보기", Toast.LENGTH_LONG).show();
                    }
                });
                builder.create().show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return lnfArrayList.size();
    }

    void addItem(LNF lnf) {
        lnfArrayList.add(lnf);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView lnfTextView;
        private CheckBox lnfCheckBox;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            lnfTextView = itemView.findViewById(R.id.lnfTextView);
            lnfCheckBox = itemView.findViewById(R.id.lnfCheckBox);
        }

        public void onBind(LNF lnf) {
            lnfTextView.setText(lnf.getTitle());
        }
    }
}
