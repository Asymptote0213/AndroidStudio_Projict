package com.example.homework_app;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Map;

public class Adapter extends RecyclerView.Adapter<Adapter.myviewholder> {

    private List<Map<String,Object>> list;
    private Context context;
    private View inflater;
    ActivityResultLauncher<Intent> launcher;

    public Adapter(Context context, List<Map<String,Object>>
            list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public myviewholder onCreateViewHolder(ViewGroup viewGroup, int i) {
        inflater = LayoutInflater.from(context).inflate(R.layout.layout_item02,viewGroup,false);
        myviewholder myviewholder =new myviewholder(inflater);
        return myviewholder;
    }



    @Override
    public void onBindViewHolder( myviewholder myviewholder, int j) {
        Map<String,Object> currentItem=list.get(j);
        myviewholder.imageView.setImageResource((Integer) currentItem.get("name"));

        //myviewholder.textView1.setText(list.get(j).get("name").toString());

        String str1=list.get(j).get("price").toString();
        String str2=list.get(j).get("config").toString();
        myviewholder.textView2.setText(str1);
        myviewholder.textView3.setText(str2);

/*
        launcher=registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if(result.getResultCode()==666){
                            String str1=result.getData().getStringExtra("result");
                            textView.setText(str1);
                        };
                    }
                }
        );*/



        myviewholder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainActivity_Contact_detail.class);

                intent.putExtra("price",str1);
                intent.putExtra("config",str2);

                context.startActivity(intent);

                //launcher.launch(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class myviewholder extends RecyclerView.ViewHolder{
        TextView textView1,textView2,textView3;
        ImageView imageView;
        public myviewholder( View itemView) {
            super(itemView);
            //textView1 = itemView.findViewById(R.id.textView_rc_01);
            imageView=itemView.findViewById(R.id.imageView_rc_01);
            textView2 = itemView.findViewById(R.id.textView_rc_01);
            textView3 = itemView.findViewById(R.id.textView_rc_02);
        }
    }

}
