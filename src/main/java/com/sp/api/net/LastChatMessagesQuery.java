package com.sp.api.net;

import com.sp.api.SpApi;
import com.sp.api.entity.LastChatMessages;

/**
 * Author Pershin Andrew
 */
public class LastChatMessagesQuery extends ApiRequest<LastChatMessages> {
    public LastChatMessagesQuery(SpApi spApi) {
        super("chat", spApi.getGson(), spApi.getHttpClient(), LastChatMessages.class);
    }
}
