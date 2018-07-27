package com.cp.customspinner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.cp.customspinner.adapter.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.sp_demo)
    CpCustomSpinner spDemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        ArrayList<SpinnerBean> beans =  new ArrayList<>();
        for (int i = 0; i < 20 ; i++) {
            beans.add(new SpinnerBean(i,("Game :" + i)));
        }
        spDemo.setData(beans);
        spDemo.isFirstItemColor(false);
        spDemo.setSelectedItemBackgroundColor(R.color.colorPrimary);
        spDemo.setNormalItemBackgroundColor(android.R.color.darker_gray);
    }
}


