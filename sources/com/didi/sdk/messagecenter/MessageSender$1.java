package com.didi.sdk.messagecenter;

import com.didi.sdk.messagecenter.PushCallback;
import com.didi.sdk.messagecenter.util.MLog;
import com.didi.sdk.push.PushRequestCallback;

class MessageSender$1 implements PushRequestCallback {
    final /* synthetic */ C12466a this$0;
    final /* synthetic */ PushCallback val$callback;

    MessageSender$1(C12466a aVar, PushCallback pushCallback) {
        this.this$0 = aVar;
        this.val$callback = pushCallback;
    }

    public void onRequest(PushRequestCallback.CallbackInfo callbackInfo) {
        MLog.m26060i("PushRequestCallback#onRequest: " + callbackInfo);
        if (callbackInfo != null) {
            this.val$callback.onRequest(new PushCallback.CallbackInfo(callbackInfo.retCode, callbackInfo.msgType, callbackInfo.seqId));
        } else {
            this.val$callback.onRequest((PushCallback.CallbackInfo) null);
        }
    }
}
