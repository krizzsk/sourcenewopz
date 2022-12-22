package com.didi.sdk.paxadsdk;

import android.view.View;

public interface AdLoadListenner {
    void onAdClicked();

    void onAdClosed();

    void onAdImpression();

    void onAdLoaded();

    void onAdOpened();

    void onFailed(String str, String str2, String str3);

    void onSuccess(View view);
}
