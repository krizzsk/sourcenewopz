package com.didi.sdk.data;

import android.content.Context;

public interface LocationDataGenerator2 {
    float getAccuracy(Context context);

    float getBearing(Context context);

    double getLat(Context context);

    double getLng(Context context);

    float getSpeed(Context context);

    long getTime(Context context);
}
