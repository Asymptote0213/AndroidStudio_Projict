package com.example.homework_app;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


public class FragmentMain_Activity extends AppCompatActivity implements View.OnClickListener{

    Fragment fragment1,fragment2,fragment3,fragment4;
    LinearLayout layout1, layout2, layout3, layout4;

    FragmentManager manager;
    FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fragment_main);

        layout1 = findViewById(R.id.bottomlinearLayout_1);
        layout2 = findViewById(R.id.bottomlinearLayout_2);
        layout3 = findViewById(R.id.bottomlinearLayout_3);
        layout4 = findViewById(R.id.bottomlinearLayout_4);

        // 确保所有的布局都已经被正确初始化
        if (layout1 == null || layout2 == null || layout3 == null || layout4 == null) {
            throw new RuntimeException("One or more layouts were not found");
        }

        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();
        fragment4 = new Fragment4();

        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();

        intial();

        fragmentHide();

        transaction.show(fragment1);
        transaction.commit();

        setClickListeners();



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void intial() {
        transaction.add(R.id.framLayout, fragment1);
        transaction.add(R.id.framLayout, fragment2);
        transaction.add(R.id.framLayout, fragment3);
        transaction.add(R.id.framLayout, fragment4);
    }

    void fragmentHide() {
        transaction.hide(fragment1);
        transaction.hide(fragment2);
        transaction.hide(fragment3);
        transaction.hide(fragment4);
    }

    private void setClickListeners() {
        layout1.setOnClickListener(this);
        layout2.setOnClickListener(this);
        layout3.setOnClickListener(this);
        layout4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bottomlinearLayout_1:
                fragmentHide();
                showfragment(fragment1);
                break;
            case R.id.bottomlinearLayout_2:
                fragmentHide();
                showfragment(fragment2);
                break;
            case R.id.bottomlinearLayout_3:
                fragmentHide();
                showfragment(fragment3);
                break;
            case R.id.bottomlinearLayout_4:
                fragmentHide();
                showfragment(fragment4);
            default:
                break;
        }
    }

    private void showfragment(Fragment fragment) {
        transaction = manager.beginTransaction();
        fragmentHide();
        transaction.show(fragment);
        transaction.commit();
    }

}