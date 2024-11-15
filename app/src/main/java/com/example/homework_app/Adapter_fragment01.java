package com.example.homework_app;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;



public class Adapter_fragment01 extends RecyclerView.Adapter<Adapter_fragment01.MyViewHolder01> {

    private List<ItemData01> dataList;
    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(ItemData01 itemData);
    }

    public Adapter_fragment01(List<ItemData01> dataList, OnItemClickListener listener) {
        this.dataList = dataList;
        this.onItemClickListener = listener;

    }

    @NonNull
    @Override
    public MyViewHolder01 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item01, parent, false);
        return new MyViewHolder01(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder01 holder, int position) {
        ItemData01 itemData = dataList.get(position);
        Log.d("Adapter", "Text: " + itemData.getText()); // 打印文本
        holder.textView.setText(itemData.getText());
        holder.imageView.setImageResource(itemData.getImageResId());
        holder.imageView.setOnClickListener(v -> onItemClickListener.onItemClick(itemData));

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    static class MyViewHolder01 extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;

        MyViewHolder01(View view) {
            super(view);
            imageView = view.findViewById(R.id.imageView7);
            textView = view.findViewById(R.id.textView9);



        }
    }
}