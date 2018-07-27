package com.cp.customspinner;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.AppCompatSpinner;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;




import java.util.ArrayList;

public class CpCustomSpinner extends AppCompatSpinner implements  AdapterView.OnItemSelectedListener {
    private CpCustomSpinnerAdapter adapter;
    protected  int selectedPosition = -1;
    protected  boolean isFirstItemColor = true;

    public CpCustomSpinner(Context context) {
        super(context);
        init(context);
    }

    public CpCustomSpinner(Context context, int mode) {
        super(context, mode);
        init(context);
    }

    public CpCustomSpinner(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CpCustomSpinner(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public CpCustomSpinner(Context context, AttributeSet attrs, int defStyleAttr, int mode) {
        super(context, attrs, defStyleAttr, mode);
        init(context);
    }

    public CpCustomSpinner(Context context, AttributeSet attrs, int defStyleAttr, int mode, Resources.Theme popupTheme) {
        super(context, attrs, defStyleAttr, mode, popupTheme);
        init(context);
    }

    protected void init(Context context) {
        adapter = new CpCustomSpinnerAdapter(context);
        setAdapter(adapter);
        this.setOnItemSelectedListener(this);
    }

    protected void setData(ArrayList<SpinnerBean> arrayList) {
        adapter.setData(arrayList,isFirstItemColor);
    }
    protected void isFirstItemColor(boolean isFirstItemColor){
        this.isFirstItemColor  =  isFirstItemColor;
        adapter.setFirstItemColor(isFirstItemColor);
    }

    protected void setSelectedItemBackgroundColor(int color){
        adapter.setSelectedItemBackgroundColor(color);
    }
    protected void setNormalItemBackgroundColor(int color){
        adapter.setNormalItemBackgroundColor(color);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        selectedPosition =  this.getSelectedItemPosition();
        adapter.setSelectedPosition(selectedPosition);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
