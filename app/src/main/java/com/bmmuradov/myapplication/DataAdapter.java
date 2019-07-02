package com.bmmuradov.myapplication;

import android.widget.BaseAdapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class DataAdapter extends BaseAdapter {
    //properties
    ArrayList<CurrencyModel> currModelList;
    Context context;

    //constructor
    public DataAdapter(Context cntxt, ArrayList<CurrencyModel> currModelList) {
        this.currModelList=currModelList;
        context= cntxt;
    }

    //methods
    @Override
    public int getCount() {
        return currModelList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
        if (view == null) {
            view = inflater.inflate(R.layout.element_currency_data, viewGroup, false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.currName.setText(currModelList.get(i).getName());
        holder.currRate.setText(currModelList.get(i).getRate()+"");
        return view;
    }

}
