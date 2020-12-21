package com.sp.api;

import com.sp.api.entity.LastChatMessages;
import com.sp.api.entity.OnlinePlayers;
import com.sp.api.entity.Time;
import com.sp.api.entity.Weather;

/**
 * @Author Pershin Andrew
 */
public class SpApi {
    public Weather getServerWeather(){
        return new Weather();
    }
    public Time getServerTime(){
        return new Time();
    }
    public OnlinePlayers getServerOnlinePlayers(){
        return new OnlinePlayers();
    }
    public LastChatMessages getServerLastChatMessages(){
        return new LastChatMessages();
    }
}
