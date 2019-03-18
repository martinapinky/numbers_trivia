package com.martina.numbers.numbers.network;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by Martina Alinda on 3/18/2019.
 */

public interface GetDataService {

    @GET()
    Call<String> getTrivia(@Url String url);
}