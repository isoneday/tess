package com.teamproject.plastikproject.plastik.network;


import com.teamproject.plastikproject.plastik.helper.MyConstant;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Blackswan on 9/12/2017.
 */

public class MyRetrofitClient2 {
    private static Retrofit getRetrofit(){
        //insialisasi retrofit 2
        Retrofit r = new Retrofit.Builder()
                .baseUrl(MyConstant.BASE_URL2)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return r;
    }


    public static RestApi getInstaceRetrofit(){
        return getRetrofit().create(RestApi.class);
    }

}
