package com.microblink.blinkbarcode.fragment;

import android.content.res.Configuration;
import android.os.Bundle;

/* compiled from: line */
public interface LifecycleObserver {
    void onConfigurationChanged(Configuration configuration);

    void onCreate(Bundle bundle);

    void onDestroy();

    void onPause();

    void onResume();

    void onSaveInstanceState(Bundle bundle);

    void onStart();

    void onStop();
}
