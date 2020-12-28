package com.sp.api.net;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.sp.api.entity.Weather;
import com.sp.api.exception.SpApiException;
import com.sp.api.exception.SpApiServerException;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Author Pershin Andrew
 */
public class SpApiHttpClient {
    private final Gson gson = new Gson();
    private final CloseableHttpClient httpClient = HttpClients.createDefault();
    private final String SERVER_URL = "https://sp-api.ru/spm/";
    
    public String get(String method) throws SpApiException {
        HttpGet get = new HttpGet(SERVER_URL + method);
        JsonObject jsonObject;
        try {
            HttpResponse httpResponse = httpClient.execute(get);
            InputStream entityInputStream = httpResponse.getEntity().getContent();

            int statusCode = httpResponse.getStatusLine().getStatusCode();
            if (statusCode != 200) throw new SpApiServerException("Response status cod is " + statusCode);

            String contentResponse = parseToString(entityInputStream);

            return contentResponse;
        } catch (IOException e) {
            throw new SpApiException(e);
        }
    }

    private String parseToString(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder stringBuilder = new StringBuilder();
        String line = "";
        while ((line = bufferedReader.readLine()) != null){
            stringBuilder.append(line);
        }
        return stringBuilder.toString();
    }
}
