package com.bmmuradov.myapplication;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CurrencyRateService {

    @GET("latest?access_key=3b8fa32b5d610002aef96d2ef18ecc04&format=1")
    Call<CurrencyData> loadCurrencyExchange();
}
