package com.sp.api.net;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.sp.api.exception.SpApiException;
import com.sp.api.exception.SpApiServerException;

import java.lang.reflect.Type;

/**
 * @Author Pershin Andrew
 */
public abstract class ApiRequest<R> {
    private String apiMethod;
    private SpApiHttpClient spApiHttpClient;
    private Gson gson;
    private Type type;

    public ApiRequest(String apiMethod,Gson gson, SpApiHttpClient spApiHttpClient, Type type){
        this.apiMethod = apiMethod;
        this.type = type;
        this.gson = gson;
        this.spApiHttpClient = spApiHttpClient;
    }

    public R execute() throws SpApiException {
        JsonObject jsonObject;
        R result;

        String contentResponse = spApiHttpClient.get(apiMethod);
        jsonObject = gson.fromJson(contentResponse, JsonObject.class);

        if (jsonObject.get("error").getAsBoolean())
            throw new SpApiServerException("Server response has error flag true");

        result = gson.fromJson(jsonObject, type);
        return result;
    }
}
