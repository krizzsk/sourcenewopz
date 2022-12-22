package com.android.didi.safetoolkit.observer.action;

import android.content.Intent;

public interface IActionObserver {
    void onActivityResult(int i, int i2, Intent intent);

    void onBackPressed();
}
