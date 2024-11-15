package com.example.homework_app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter_fragment02 extends RecyclerView.Adapter<Adapter_fragment02.MyViewHolder02> {

    private List<ItemData02> dataList;
    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(ItemData02 itemData);
    }

    // 构造函数
    public Adapter_fragment02(List<ItemData02> dataList,OnItemClickListener listener) {
        this.dataList = dataList;
        this.onItemClickListener = listener;
    }



    @NonNull
    @Override
    public MyViewHolder02 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item03, parent, false);
        return new MyViewHolder02(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder02 holder, int position) {
        ItemData02 itemData = dataList.get(position);

        holder.imageView.setImageResource(itemData.getImageResId());
        holder.textView8.setText(itemData.getText1());
        holder.textView10.setText(itemData.getText2());

        holder.itemView.setOnClickListener(v -> onItemClickListener.onItemClick(itemData));
    }

    @Override
    public int getItemCount() {
        return dataList.size(); // 返回数据列表的大小
    }

    // ViewHolder 类
    static class MyViewHolder02 extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView8;
        TextView textView10;

        MyViewHolder02(View view) {
            super(view);
            imageView = view.findViewById(R.id.imageView9);
            textView8 = view.findViewById(R.id.textView8);
            textView10 = view.findViewById(R.id.textView10);
        }
    }
}