package com.didi.foundation.sdk.p116im;

import android.text.TextUtils;
import com.didi.beatles.p099im.access.core.IMNotifyLister;
import com.didi.foundation.sdk.liveconnection.MessageListener;
import com.didi.foundation.sdk.liveconnection.Response;
import com.didi.sdk.logging.Logger;

/* renamed from: com.didi.foundation.sdk.im.FoundationIMAssistant$2 */
class FoundationIMAssistant$2 implements MessageListener {
    final /* synthetic */ C8357a this$0;
    final /* synthetic */ IMNotifyLister val$imNotifyLister;

    public int getPushKey() {
        return 4096;
    }

    FoundationIMAssistant$2(C8357a aVar, IMNotifyLister iMNotifyLister) {
        this.this$0 = aVar;
        this.val$imNotifyLister = iMNotifyLister;
    }

    public void onReceive(Response response) {
        IMNotifyLister iMNotifyLister;
        String str = new String(response.getData());
        Logger a = this.this$0.f21177b;
        a.info("LiveConnectionServiceProvider onReceive: " + str, new Object[0]);
        if (!TextUtils.isEmpty(str) && (iMNotifyLister = this.val$imNotifyLister) != null) {
            iMNotifyLister.onPushArrive(str, 104);
        }
    }
}
