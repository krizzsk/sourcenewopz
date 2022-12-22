package com.didi.component.homepop.request;

import android.content.Context;

public interface HomePopupRequest {
    void cancelGroup();

    void closeWindow();

    void requestByService(Context context, String str);
}
