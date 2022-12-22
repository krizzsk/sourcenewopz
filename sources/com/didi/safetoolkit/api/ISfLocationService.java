package com.didi.safetoolkit.api;

import android.content.Context;
import com.didi.safetoolkit.model.SfLocation;

public interface ISfLocationService {

    public interface SfCallback {
        void onFailed(String str);

        void onSucceed(SfLocation sfLocation);
    }

    void getCurrentLocation(Context context, SfCallback sfCallback);
}
