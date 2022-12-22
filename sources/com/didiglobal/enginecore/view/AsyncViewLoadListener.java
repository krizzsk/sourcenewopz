package com.didiglobal.enginecore.view;

import android.view.View;

public interface AsyncViewLoadListener {
    void onAsyncViewLoad(View view);

    void onAsyncViewLoadFailed();
}
