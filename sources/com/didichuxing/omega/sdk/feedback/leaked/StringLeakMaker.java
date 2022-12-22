package com.didichuxing.omega.sdk.feedback.leaked;

import android.content.Context;

public class StringLeakMaker extends LeakMaker<String> {
    /* access modifiers changed from: package-private */
    public void startLeak(Context context) {
        this.uselessObjectList.add(new String(new byte[262145]));
    }
}
