package com.didi.foundation.sdk.p116im;

import android.text.TextUtils;
import com.didi.beatles.p099im.access.core.IMNotifyLister;
import com.didi.foundation.sdk.push.PushMessageReceiver;
import com.didi.foundation.sdk.push.PushServiceProvider;
import com.didi.sdk.logging.Logger;

/* renamed from: com.didi.foundation.sdk.im.FoundationIMAssistant$1 */
class FoundationIMAssistant$1 implements PushMessageReceiver {
    final /* synthetic */ C8357a this$0;
    final /* synthetic */ IMNotifyLister val$imNotifyLister;
    final /* synthetic */ PushServiceProvider val$pushServiceProvider;

    FoundationIMAssistant$1(C8357a aVar, IMNotifyLister iMNotifyLister, PushServiceProvider pushServiceProvider) {
        this.this$0 = aVar;
        this.val$imNotifyLister = iMNotifyLister;
        this.val$pushServiceProvider = pushServiceProvider;
    }

    public void onMessageReceived(String str) {
        IMNotifyLister iMNotifyLister;
        Logger a = this.this$0.f21177b;
        a.info("PushServiceProvider onMessageReceived: " + str, new Object[0]);
        if (!TextUtils.isEmpty(str) && (iMNotifyLister = this.val$imNotifyLister) != null) {
            iMNotifyLister.onPushArrive(str, getPushType());
        }
    }

    private int getPushType() {
        int pushType = this.val$pushServiceProvider.getPushType();
        if (pushType == 1) {
            return 103;
        }
        if (pushType != 2) {
            return pushType != 3 ? 0 : 104;
        }
        return 102;
    }
}
