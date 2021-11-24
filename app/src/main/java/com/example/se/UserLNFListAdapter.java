package com.example.se;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserLNFListAdapter extends RecyclerView.Adapter<UserLNFListAdapter.ViewHolder> {
    private ArrayList<LNF> lnfArrayList = new ArrayList<>();

    @NonNull
    @Override
    public UserLNFListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.user_lnf, parent, false);
        return new UserLNFListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserLNFListAdapter.ViewHolder holder, int position) {
        holder.onBind(lnfArrayList.get(position));

        int pos = position;

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                Toast.makeText(builder.getContext(), lnfArrayList.get(pos).getTitle() + " 선택됨", Toast.LENGTH_SHORT).show();
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
        private TextView userLnf;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            userLnf = itemView.findViewById(R.id.userLnf);
        }

        public void onBind(LNF lnf) {
            userLnf.setText(lnf.getTitle());
        }
    }

}
