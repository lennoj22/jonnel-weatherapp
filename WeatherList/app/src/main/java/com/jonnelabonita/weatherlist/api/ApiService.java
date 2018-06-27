package com.jonnelabonita.weatherlist.api;

import com.jonnelabonita.weatherlist.models.OpenWeather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author Jonnel Abonita.
 */
public interface ApiService {

    /*
    Retrofit get annotation with our URL
    And our method that will return us the List of ContactList
    */
    @GET("data/2.5/weather")
    Call<OpenWeather> getWeatherLondon(@Query("q") String location, @Query("APPID") String APPID, @Query("units") String metric
    );

    @GET("data/2.5/weather")
    Call<OpenWeather> getWeatherSeoul(@Query("q") String location, @Query("APPID") String APPID, @Query("units") String metric
    );

    @GET("data/2.5/weather")
    Call<OpenWeather> getWeatherNewYork(@Query("q") String location, @Query("APPID") String APPID, @Query("units") String metric
    );

    @GET("data/2.5/weather")
    Call<OpenWeather> getWeatherTokyo(@Query("q") String location, @Query("APPID") String APPID, @Query("units") String metric
    );

    @GET("data/2.5/weather")
    Call<OpenWeather> getWeatherOrtigas( @Query("lat") String lat,
                                         @Query("lon") String lng,
                                         @Query("APPID") String APPID,
                                         @Query("units") String metric
    );

}
