package com.didi.sdk.data;

import android.content.Context;

public interface UserLocationDataGenerator {
    double getUserLat(Context context);

    double getUserLng(Context context);
}
