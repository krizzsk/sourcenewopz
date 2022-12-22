package com.didi.sdk.apm.ext;

import android.util.Log;

public class AndroidPrintStream extends LoggingPrintStream {

    /* renamed from: a */
    private final int f35023a;

    /* renamed from: b */
    private final String f35024b;

    public AndroidPrintStream(int i, String str) {
        if (str != null) {
            this.f35023a = i;
            this.f35024b = str;
            return;
        }
        throw new NullPointerException("tag");
    }

    /* access modifiers changed from: protected */
    public void log(String str) {
        Log.println(this.f35023a, this.f35024b, str);
    }
}
