package com.bmmuradov.myapplication;

import android.view.View;
import android.widget.TextView;

public class ViewHolder {
    //properties
    TextView currName;
    TextView currRate;

    //constructor
    ViewHolder(View view) {
        currName = (TextView) view.findViewById(R.id.tv_currency_name);
        currRate = (TextView) view.findViewById(R.id.tv_currency_rate);
    }
}
