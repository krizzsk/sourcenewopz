package com.didi.sdk.app;

import android.app.Activity;
import android.content.Intent;

public interface ISchemeDispatcherHandler {
    String getProductPrefix();

    void handleClickOfPush(String str, Activity activity);

    void handleSchemeOfPush(Intent intent, Activity activity);
}
