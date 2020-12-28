package com.sp.api.net;

import com.sp.api.SpApi;
import com.sp.api.entity.Time;

/**
 * Author Pershin Andrew
 */
public class TimeQuery extends ApiRequest<Time> {
    public TimeQuery(SpApi spApi) {
        super("time", spApi.getGson(), spApi.getHttpClient(), Time.class);
    }
}
