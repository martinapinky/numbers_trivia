package com.martina.numbers.numbers.network;

import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by Martina Alinda on 3/18/2019.
 */

public class RetrofitClientInstance {
    private static Retrofit retrofit;
    private static final String BASE_URL = "http://numbersapi.com/5/";

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
