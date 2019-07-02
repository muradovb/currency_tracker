package com.bmmuradov.myapplication;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import java.util.Calendar;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DataActivity extends AppCompatActivity implements Callback<CurrencyData> {

    Calendar calendar = Calendar.getInstance();
    ListView lvCurrencies;
    Button refreshButton;
    TextView tv_time;
    TextView tv_date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        init();
    }


    //initiates the activity.
    private void init() {
        //bind xml elems.
        lvCurrencies= (ListView) findViewById(R.id.lv_currencies);
        refreshButton=(Button) findViewById(R.id.bttn_refresh);
        tv_date=(TextView) findViewById(R.id.tv_date);
        tv_time=(TextView) findViewById(R.id.tv_time);

        //set listeners
        refreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCurrencyData();
            }
        });

        //load currencies
        updateCurrData();
    }

    //updates currency data in every 2 secs.
    Runnable updater;
    private void updateCurrData() {
        final Handler timerHandler = new Handler();
        updater = new Runnable() {
            @Override
            public void run() {
                getCurrencyData();
                timerHandler.postDelayed(updater,2000);
            }
        };
        timerHandler.post(updater);
    }

    //gets currecy data
    private void getCurrencyData() {
        Retrofit retrofit = new Retrofit.Builder().
                                baseUrl("http://data.fixer.io/api/").
                                addConverterFactory(GsonConverterFactory.create()).
                                build();

        CurrencyRateService service=retrofit.create(CurrencyRateService.class);
        Call<CurrencyData> call = service.loadCurrencyExchange();
        call.enqueue(this);
        updateDateData();
        updateTimeData();
    }

    //updates date xml.
    private void updateDateData() {
        //date attrs.
        String day;
        String month;
        String year;
        String retDate;
        day=calendar.get(Calendar.DATE)+"";
        month=calendar.get(Calendar.MONTH)+"";
        year=calendar.get(Calendar.YEAR)+"";
        retDate= day+"."+month+"."+year;
        tv_date.setText(retDate);
    }

    //updates time xml.
    private void updateTimeData() {
        //time attrs.
        String hour;
        String min;
        String sec;
        String retTime;
        hour=calendar.get(Calendar.HOUR)+"";
        min=calendar.get(Calendar.MINUTE)+"";
        sec=calendar.get(Calendar.SECOND)+"";
        retTime= hour+":"+min+":"+sec;
        tv_time.setText(retTime);
    }


    //API responses
    @Override
    public void onResponse(Call<CurrencyData> call, Response<CurrencyData> response) {
        CurrencyData currencyData=response.body();
        lvCurrencies.setAdapter(new DataAdapter(this, currencyData.getCurrList()));

    }

    @Override
    public void onFailure(Call<CurrencyData> call, Throwable t) {

    }
}
