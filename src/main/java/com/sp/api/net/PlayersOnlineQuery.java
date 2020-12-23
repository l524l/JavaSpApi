package com.sp.api.net;

import com.sp.api.SpApi;
import com.sp.api.entity.LastChatMessages;
import com.sp.api.entity.OnlinePlayers;

/**
 * @Author Pershin Andrew
 */
public class PlayersOnlineQuery extends ApiRequest<OnlinePlayers> {
    public PlayersOnlineQuery(SpApi spApi) {
        super("online", spApi.getGson(), spApi.getHttpClient(), OnlinePlayers.class);
    }
}
