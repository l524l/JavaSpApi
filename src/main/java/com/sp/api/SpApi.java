package com.sp.api;

import com.google.gson.Gson;
import com.sp.api.entity.LastChatMessages;
import com.sp.api.entity.OnlinePlayers;
import com.sp.api.entity.Time;
import com.sp.api.entity.Weather;
import com.sp.api.exception.SpApiException;
import com.sp.api.net.*;

/**
 * Author Pershin Andrew
 */
public class SpApi {
    private Gson gson;
    private SpApiHttpClient httpClient;

    public SpApi() {
        gson = new Gson();
        httpClient = new SpApiHttpClient();
    }

    public Gson getGson() {
        return gson;
    }

    public SpApiHttpClient getHttpClient() {
        return httpClient;
    }

    public Weather getServerWeather() throws SpApiException {
        return new WeatherQuery(this).execute();
    }
    public Time getServerTime() throws SpApiException {
        return new TimeQuery(this).execute();
    }
    public OnlinePlayers getServerOnlinePlayers() throws SpApiException {
        return new PlayersOnlineQuery(this).execute();
    }
    public LastChatMessages getServerLastChatMessages() throws SpApiException {
        return new LastChatMessagesQuery(this).execute();
    }
}
