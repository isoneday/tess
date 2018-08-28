package com.teamproject.plastikproject.alarmapp.api;



import com.teamproject.plastikproject.alarmapp.models.weather.WeatherResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Denys on 02.02.2017.
 */

public interface OpenWeatherService {

    @GET("weather")
    Call<WeatherResponseModel> getWeather(@Query("q") String city, @Query("APPID") String apiKey);
}
