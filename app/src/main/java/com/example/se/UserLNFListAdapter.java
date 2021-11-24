package com.example.se;

import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserLNFListAdapter extends RecyclerView.Adapter<UserLNFListAdapter.ViewHolder> {

    private ArrayList<LNF> lnfArrayList = new ArrayList<>();
    private Dialog detailDialog;
    private TextView title, explain;
    private ImageView image;
    private Button closeButton;

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

                detailDialog = new Dialog(view.getContext());
                detailDialog.setContentView(R.layout.lnf_detail);

                title = detailDialog.findViewById(R.id.lnfTitle);
                image = detailDialog.findViewById(R.id.lnfImage);
                explain = detailDialog.findViewById(R.id.lnfExplain);

                //lnfArrayList 저장된 내용 가져와서 dialog로 표시하기
                title.setText("" + lnfArrayList.get(pos).getTitle());
                //image.setImage...
                explain.setText("" + lnfArrayList.get(pos).getExplain());

                detailDialog.show();

                closeButton = detailDialog.findViewById(R.id.lnfCloseButton);
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
