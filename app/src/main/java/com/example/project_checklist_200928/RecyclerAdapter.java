package com.example.project_checklist_200928;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

// 어댑터 상속 및 구현
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private ArrayList<RecyclerItem> mData = null;

    // 생성자에서 데이터 리스트 객체를 전달 받음
    RecyclerAdapter(ArrayList<RecyclerItem> list){
        mData = list;
    }
    // 아이템 뷰를 위한 뷰홀더 객체 생성하여 리턴
    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.recycler_item, parent, false);
        RecyclerAdapter.ViewHolder vh = new RecyclerAdapter.ViewHolder(view);
        return vh;
    }
    // onBindViewHolder() : position에 해당하는 데이터를 뷰홀더의 아이템 뷰에 표시
    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {
        RecyclerItem item = mData.get(position);
        holder.title.setText(item.getTitle());
        holder.date.setText(item.getDate());
    }

    // 전체 아이템 갯수 리턴
    @Override
    public int getItemCount() {
        return mData.size();
    }

    // 아이템 뷰를 저장하는 ViewHolder 클래스
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView date;

        // 뷰 인스턴스 정의
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // 각각의 객체 참조
            title = itemView.findViewById(R.id.title_text);
            date = itemView.findViewById(R.id.date_text);

        }
    }
}

