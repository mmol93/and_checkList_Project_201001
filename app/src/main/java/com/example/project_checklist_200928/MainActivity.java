package com.example.project_checklist_200928;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter recyclerAdapter;
    private RecyclerView.LayoutManager recyclerManager;
    ArrayList<RecyclerItem> mList = new ArrayList<RecyclerItem>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 앱바에 엑세스 하기
        ActionBar ab = getSupportActionBar();

        recyclerView = findViewById(R.id.recyclerView);

        // 리사이클러뷰 안에 있는 컨텐츠로 인해 리사이클러 뷰 자체의 사이즈가 바뀌지 않게 고정
//        recyclerView.setHasFixedSize(true);

        // 리사이클러뷰에 객체를 등록
        recyclerAdapter = new RecyclerAdapter(mList);
        // 리사이클러뷰에 어댑터를 등록
        recyclerView.setAdapter(recyclerAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        addItem("hi", "2020-09-30");
        addItem("myName", "2020-10-02");
    }

    public void addItem(String title, String date){
        RecyclerItem item = new RecyclerItem();
        item.setTitle(title);
        item.setDate(date);

        mList.add(item);
    }
}