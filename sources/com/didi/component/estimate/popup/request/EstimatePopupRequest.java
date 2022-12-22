package com.didi.component.estimate.popup.request;

import android.content.Context;

public interface EstimatePopupRequest {
    void cancelGroup();

    void closeWindow();

    void requestByService(Context context, String str, int i, int i2, int i3, String str2, int i4);

    void requestByService(Context context, String str, String str2, int i);
}
