package com.cp.customspinner;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.cp.customspinner.adapter.R;


import java.util.ArrayList;

public class CpCustomSpinnerAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<SpinnerBean> alData;
    private int selectedPosition = -1;
    private boolean setFirstItemColor;
    private int selectedItemBackgroundColor;
    private int normalItemBackgroundColor;

    public CpCustomSpinnerAdapter(Context context) {
        this.mContext = context;
        alData = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return alData.size();
    }

    @Override
    public Object getItem(int position) {
        return alData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return (long) alData.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        try {
            viewHolder holder;
            view = convertView;
            if (view == null) {
                view = LayoutInflater.from(mContext).inflate(R.layout.item_spinner, parent, false);
                holder = new viewHolder();
                holder.tvName = view.findViewById(R.id.tv_name);
                view.setTag(holder);
            } else {
                holder = (viewHolder) view.getTag();
            }
            SpinnerBean bean = alData.get(position);
            holder.tvName.setText(bean.getName());
            holder.tvName.setTextColor(getTextColor(position));
            holder.tvName.setBackgroundColor(getBackgroundColor(position));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return view;


    }
    private int getTextColor(int position) {
        if (setFirstItemColor && position == selectedPosition)
            return  ContextCompat.getColor(mContext, R.color.colorAccent);
        else if ((!setFirstItemColor) && position == selectedPosition && position > 0)
            return ContextCompat.getColor(mContext, R.color.colorAccent);
        else
            return  ContextCompat.getColor(mContext, android.R.color.black);
    }

    private int getBackgroundColor(int position) {
        if (setFirstItemColor && position == selectedPosition)
            return  ContextCompat.getColor(mContext, selectedItemBackgroundColor == 0 ? android.R.color.transparent : selectedItemBackgroundColor);
        else if ((!setFirstItemColor) && position == selectedPosition && position > 0)
            return ContextCompat.getColor(mContext, selectedItemBackgroundColor == 0 ? android.R.color.transparent : selectedItemBackgroundColor);
        else
            return ContextCompat.getColor(mContext, normalItemBackgroundColor == 0 ? android.R.color.transparent : normalItemBackgroundColor);
    }


    public void setData(ArrayList<SpinnerBean> arrayList, boolean setFirstItemColor) {
        this.setFirstItemColor = setFirstItemColor;
        this.alData = arrayList;
        notifyDataSetChanged();
    }

    public void setSelectedPosition(int selectedPosition) {
        this.selectedPosition = selectedPosition;
        notifyDataSetChanged();
    }

    public void setFirstItemColor(boolean setFirstItemColor) {
        this.setFirstItemColor = setFirstItemColor;
        notifyDataSetChanged();
    }

    public void setSelectedItemBackgroundColor(int selectedItemBackgroundColor) {
        this.selectedItemBackgroundColor =  selectedItemBackgroundColor;
        notifyDataSetChanged();
    }

    public void setNormalItemBackgroundColor(int normalItemBackgroundColor) {
        this.normalItemBackgroundColor =  normalItemBackgroundColor;
        notifyDataSetChanged();
    }
    private class viewHolder {
        private TextView tvName;
    }
}
