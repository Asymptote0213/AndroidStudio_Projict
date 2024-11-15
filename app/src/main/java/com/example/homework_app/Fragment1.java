package com.example.homework_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;



public class Fragment1 extends Fragment implements
        Adapter_fragment01.OnItemClickListener,
        Adapter_fragment02.OnItemClickListener{

    private RecyclerView recyclerView1;
    private RecyclerView recyclerView2;
    private Adapter_fragment01 adapter1;
    private Adapter_fragment02 adapter2;
    private List<ItemData01> dataList1;
    private List<ItemData02> dataList2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment01_layout, container, false);

        recyclerView1 = view.findViewById(R.id.rc_page01);
        recyclerView2 = view.findViewById(R.id.rc_page02);


        // 创建数据源
        dataList1 = new ArrayList<>();

        dataList1.add(new ItemData01(".....", R.drawable.lfood01));
        dataList1.add(new ItemData01("hahaha", R.drawable.lfood02));
        dataList1.add(new ItemData01("hahaha", R.drawable.lfood03));
        dataList1.add(new ItemData01("hahaha", R.drawable.lfood05));
        dataList1.add(new ItemData01("hahaha", R.drawable.rfood04));
        dataList1.add(new ItemData01("hahaha", R.drawable.rfood03));

        dataList2 = new ArrayList<>();

        dataList2.add(new ItemData02(R.drawable.rfood01, "佛跳墙", "工艺复杂的璃月名菜，山珍海味聚一堂，佳肴美味开坛香"));
        dataList2.add(new ItemData02(R.drawable.rfood02, "摩拉肉", "肉块肥瘦均匀，如蜜般肉汁随着挤压丝丝渗出"));
        dataList2.add(new ItemData02(R.drawable.lfood06, "盛世太平", "色彩缤纷的主食，淡淡香甜萦绕唇舌"));
        dataList2.add(new ItemData02(R.drawable.lfood04, "树莓水晶馒", "晶莹剔透的点心，透明似水"));
        dataList2.add(new ItemData02(R.drawable.rfood05, "莲花酥", "璃月的传统点心之一"));
        dataList2.add(new ItemData02(R.drawable.rfood06, "来来菜", "用料丰富的菜肴，不仅荤素搭配得当，摆盘也十分工整"));



        recyclerView1.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        //在这里设置网格，横向，水平布局类型
        recyclerView2.setLayoutManager(new LinearLayoutManager(getContext()));


        adapter1 = new Adapter_fragment01(dataList1,(Adapter_fragment01.OnItemClickListener) this);
        adapter2 = new Adapter_fragment02(dataList2,(Adapter_fragment02.OnItemClickListener) this);


        recyclerView1.setAdapter(adapter1);
        recyclerView2.setAdapter(adapter2);

        return view;
    }
    @Override
    public void onItemClick(ItemData01 itemData) {

        Intent intent = new Intent(getContext(), DetailActivity.class);
        startActivity(intent);
    }

    @Override
    public void onItemClick(ItemData02 itemData) {
        Intent intent = new Intent(getContext(), DetailActivity.class);
        startActivity(intent);
    }

}

