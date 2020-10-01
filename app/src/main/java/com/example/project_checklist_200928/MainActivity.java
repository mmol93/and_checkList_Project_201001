package com.example.project_checklist_200928;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter recyclerAdapter;
    private RecyclerView.LayoutManager recyclerManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 앱바에 엑세스 하기
        ActionBar ab = getSupportActionBar();

        recyclerView = findViewById(R.id.recyclerView);

        // 리사이클러뷰 안에 있는 컨텐츠로 인해 리사이클러 뷰 자체의 사이즈가 바뀌지 않게 고정
        recyclerView.setHasFixedSize(true);

        // 리사이클뷰를 linearLayout처럼 사용
        // 즉, 1행 or 1열에 아이템을 하나씩 배치
        recyclerManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(recyclerManager);

        // 어댑터를 구체화
        recyclerAdapter = new RecyclerAdapter(myDataset);
        recyclerView.setAdapter(recyclerAdapter);
    }
}