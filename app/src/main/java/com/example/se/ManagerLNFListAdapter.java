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

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ManagerLNFListAdapter extends RecyclerView.Adapter<ManagerLNFListAdapter.ViewHolder> {
    ArrayList<LNF> lnfArrayList = new ArrayList<>();

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
                builder.setMessage("게시물을 삭제하시겠습니까?");
                builder.setPositiveButton("삭제", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        lnfArrayList.remove(pos);       //리스트 항목 삭제됨
                        notifyItemRemoved(pos);
                        notifyItemRangeChanged(pos, lnfArrayList.size());


                        //공지사항 삭제하기


                        Toast.makeText(builder.getContext(), "게시물이 삭제되었습니다.", Toast.LENGTH_LONG).show();
                    }
                });
                builder.setNeutralButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        holder.lnfCheckBox.setChecked(false);
                        Toast.makeText(builder.getContext(), "취소되었습니다.", Toast.LENGTH_LONG).show();
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
