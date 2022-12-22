package com.didi.sdk.paxadsdk;

import android.content.Context;

public interface AdAgency {
    String getName();

    void init(Context context);

    void loadNativeAD(Context context, NativeAdStyle nativeAdStyle, String str, AdLoadListenner adLoadListenner);

    void release(NativeAdStyle nativeAdStyle, String str);

    void releaseAll();
}
