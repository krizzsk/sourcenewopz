package com.didi.unifiedPay.component;

import android.content.Intent;

public interface IViewCallback {
    void callStartActivity(Intent intent);

    void callStartActivityForResult(Intent intent, int i);

    void closeView();

    int requestCode(int i);
}
