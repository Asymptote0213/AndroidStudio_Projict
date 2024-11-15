package com.example.homework_app;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Fragment2 extends Fragment {


    private RecyclerView recyclerView;
    private List<String> list;
    private Context context;
    private RecyclerView.Adapter adapter1;

    List<Map<String,Object>> list1;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.layout_recycleview02, container, false);

        context = getContext();
        recyclerView = view.findViewById(R.id.recycleview02);

        int[] phonename={R.drawable.head01,R.drawable.head02,R.drawable.head03,R.drawable.head04,R.drawable.head05,R.drawable.head06,R.drawable.head07,R.drawable.head08,R.drawable.head09,R.drawable.head10};
        String[] price={"尘世闲游",
                "愚人众第十一席——公子",
                "白飞飞",
                "剑客00_shdbde",
                "xiao",
                 "太郎丸爱玩刀",
        "🦊",
        "云",
        "北斗七星",
        "吟游诗人（爱喝酒版）"};

        String[] config={"👍👍👍👍👍",
                "👍👍👍👍👍👍👍",
                "好吃好吃好吃，旅行者我还想吃。【星星眼】",
                "万民堂无疑是一家值得一试的本地餐馆。无论是家庭聚餐还是朋友小聚，都能在这里找到满意的美食体验。如果你是一个美食爱好者，那么这里绝对是你的不二之选。",
                "该用户没有评价",
        "汪汪汪，汪汪，汪汪汪汪汪汪汪汪汪汪汪",
        "一二三，啊啊啊",
        "来璃月港必去餐馆。",
        "海味轩的海鲜新鲜度无可挑剔，每道菜都能感受到食材的鲜活。特别推荐的是他们的招牌菜——金丝虾球，虾肉细嫩，汤汁鲜美，简单的烹饪方式完美保留了海鲜的原味。另一道印象深刻的是来来菜，肉质饱满，与粉丝的结合堪称完美。",
        "在海上飘着就想念这一口璃月的味道",
        "好！"};

        list1=new ArrayList<Map<String,Object>>() ;
        for(int i=0;i<phonename.length;i++){
            Map<String,Object> map=new HashMap<>();
            map.put("name",phonename[i]);
            map.put("price",price[i]);
            map.put("config",config[i]);
            list1.add(map);
        }
        adapter1 = new com.example.homework_app.Adapter(context,list1);
        recyclerView.setAdapter(adapter1);

        LinearLayoutManager manager = new LinearLayoutManager(context);
        manager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(manager);


        return view;
    }

}

