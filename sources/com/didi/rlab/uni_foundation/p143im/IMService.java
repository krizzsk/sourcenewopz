package com.didi.rlab.uni_foundation.p143im;

import java.util.Map;

/* renamed from: com.didi.rlab.uni_foundation.im.IMService */
public interface IMService {

    /* renamed from: com.didi.rlab.uni_foundation.im.IMService$Result */
    public interface Result<T> {
        void success(T t);
    }

    void closeChat(Map<String, String> map);

    void getAllUnreadCount(Map<String, String> map, Result<Long> result);

    void getUnreadCount(Map<String, String> map, Result<Long> result);

    void openChat(Map<String, String> map);

    void sendMessage(Map<String, String> map, Result<Boolean> result);
}
