package com.didi.sdk.app;

import android.app.Activity;
import android.content.Intent;

public interface MainActivityIntentFilter {
    boolean doFilter(Intent intent, Activity activity, BusinessContextHelper businessContextHelper);
}
