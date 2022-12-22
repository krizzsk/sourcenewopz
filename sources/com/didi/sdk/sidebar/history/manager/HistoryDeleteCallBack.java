package com.didi.sdk.sidebar.history.manager;

import com.didi.sdk.push.http.BaseObject;

public interface HistoryDeleteCallBack {
    void onFailure(String str);

    void onSuccess(BaseObject baseObject);
}
