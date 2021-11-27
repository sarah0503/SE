package com.example.se;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

public class ManagerLNFActivity extends AppCompatActivity {

    private ManagerLNFListAdapter adapter;
    private Button lnfAddButton;

    private Dialog addDialog;
    private EditText lnfTitle, lnfExplain;
    private Button lnfSave;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lnf_screen);
        lnfAddButton = findViewById(R.id.lnfAddButton);

        init();

        getData();

        lnfAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addDialog = new Dialog(view.getContext());
                addDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                addDialog.setContentView(R.layout.add_lnf_screen);
                WindowManager.LayoutParams params = addDialog.getWindow().getAttributes();
                params.width = WindowManager.LayoutParams.MATCH_PARENT;
                params.height = WindowManager.LayoutParams.WRAP_CONTENT;
                addDialog.getWindow().setAttributes((WindowManager.LayoutParams) params);

                addDialog.show();

                lnfTitle = addDialog.findViewById(R.id.lnfTitleEditText);
                lnfExplain = addDialog.findViewById(R.id.lnfExplainEditText);
                lnfSave = addDialog.findViewById(R.id.lnfSaveButton);

                lnfSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        LNF lnf = new LNF();
                        lnf.setTitle(lnfTitle.getText().toString());
                        lnf.setExplain(lnfExplain.getText().toString());

                        adapter.addItem(lnf);
                        adapter.notifyDataSetChanged();

                        addDialog.dismiss();
                    }
                });
            }
        });
    }

    private void init() {
        RecyclerView recyclerView = findViewById(R.id.lnfRecyclerView);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, 1));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new ManagerLNFListAdapter();
        recyclerView.setAdapter(adapter);
    }

    private void getData() {

        /******************************임의 데이터******************************/

        List<String> titleList = Arrays.asList("제목1", "제목2", "제목3", "제목4", "제목5", "제목6", "제목7",
                "제목8", "제목9", "제목10", "제목11", "제목12");

        List<String> explainList = Arrays.asList(
                "천마아트센터 스타벅스 \n2021.08.16 \n 스페이스그레이, 핑크색 케이스",
                "djkfjoiwejklajojf \nkjfdsaeojfo \n kjdfpajkwjf \nskjaiofjkejfio",
                "sgsdesafbdgeregaa \nkjfdsaeojfo \n kjdfpajkwjf \nskjaiofjkejfio",
                "fdfhgdsgdfgvervs \nkjfdsaeojfo \n kjdfpajkwjf \nskjaiofjkejfio",
                "sdrhrhtfghg \nkjfdsaeojfo \n kjdfpajkwjf \nskjaiofjkejfio",
                "dfjtejetyynghnfg \nkjfdsaeojfo \n kjdfpajkwjf \nskjaiofjkejfio",
                "dyynytntnynjuj \nkjfdsaeojfo \n kjdfpajkwjf \nskjaiofjkejfio",
                "yfumk,yjmjummyr \nkjfdsaeojfo \n kjdfpajkwjf \nskjaiofjkejfio",
                "jk,yrbnhtnynt \nkjfdsaeojfo \n kjdfpajkwjf \nskjaiofjkejfio",
                "jym hgnhynmyu \nkjfdsaeojfo \n kjdfpajkwjf \nskjaiofjkejfio",
                "rynrhyuuymnymyk \nkjfdsaeojfo \n kjdfpajkwjf \nskjaiofjkejfio",
                "ytktskyhk \nkjfdsaeojfo \n kjdfpajkwjf \nskjaiofjkejfio",
                "dtk,ltkajojf \nkjfdsaeojfo \n kjdfpajkwjf \nskjaiofjkejfio",
                "tllkjiluhujky \nkjfdsaeojfo \n kjdfpajkwjf \nskjaiofjkejfio");

        /**********************************************************************/

        for(int i = 0; i < titleList.size(); i++) {
            LNF lnf = new LNF();
            lnf.setTitle(titleList.get(i));
            lnf.setExplain(explainList.get(i));

            adapter.addItem(lnf);
        }

        adapter.notifyDataSetChanged();
    }
}
