package com.didi.payment.base.mvp;

import android.content.Intent;

public interface ILifeCycle {
    void onCreate(Intent intent);

    void onDestroy();

    void onPause();

    void onResume();

    void onStart();

    void onStop();
}
