package com.sp.api.net;

import com.sp.api.SpApi;
import com.sp.api.entity.Weather;

/**
 * @Author Pershin Andrew
 */
public class WeatherQuery extends ApiRequest<Weather> {
    public WeatherQuery(SpApi spApi) {
        super("weather", spApi.getGson(), spApi.getHttpClient(), Weather.class);
    }
}
