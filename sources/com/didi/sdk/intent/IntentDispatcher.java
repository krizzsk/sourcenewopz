package com.didi.sdk.intent;

import android.content.Context;
import android.content.Intent;

public interface IntentDispatcher {
    boolean dispatchIntent(Intent intent, Context context);
}
