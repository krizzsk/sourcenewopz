package com.didi.safetoolkit.api;

import android.content.Context;

public interface ISfJarvisService {
    void monitorAbnormalClick(Context context, String str);

    void nullShieldClick(Context context);

    void requestJarvisStatus(int i);

    void startSocialShare(boolean z);
}
