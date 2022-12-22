package com.didichuxing.omega.sdk.feedback.leaked;

import android.content.Context;

public class ByteArrayLeakMaker extends LeakMaker<ByteArrayHolder> {

    public static class ByteArrayHolder {
        private byte[] array = new byte[262145];
    }

    public void startLeak(Context context) {
        this.uselessObjectList.add(new ByteArrayHolder());
    }
}
