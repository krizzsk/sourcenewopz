package com.didichuxing.bigdata.p173dp.locsdk.trace.data;

import androidx.core.app.NotificationCompat;
import com.didichuxing.bigdata.p173dp.locsdk.ErrInfo;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.trace.data.ETraceSource */
public enum ETraceSource {
    didi("didi"),
    didiwifi("didi-wifi"),
    didicell("didi-cell"),
    flp("flp"),
    gps("gps"),
    cache("cache"),
    tencent(ErrInfo.SOURCE_TENCENT),
    nlp("nlp"),
    googleflp("googleflp"),
    hmsflp("hmsflp"),
    ios("ios"),
    err(NotificationCompat.CATEGORY_ERROR);
    
    private String mName;

    private ETraceSource(String str) {
        this.mName = str;
    }

    public String toString() {
        return this.mName;
    }
}
