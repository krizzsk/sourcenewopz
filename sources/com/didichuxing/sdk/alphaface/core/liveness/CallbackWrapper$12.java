package com.didichuxing.sdk.alphaface.core.liveness;

import java.util.List;

class CallbackWrapper$12 implements Runnable {
    final /* synthetic */ C16337c this$0;
    final /* synthetic */ List val$bestPicList;

    CallbackWrapper$12(C16337c cVar, List list) {
        this.this$0 = cVar;
        this.val$bestPicList = list;
    }

    public void run() {
        if (this.this$0.f48730a != null) {
            this.this$0.f48730a.onActionSuccess(this.val$bestPicList);
        }
        C16337c cVar = this.this$0;
        cVar.onSuccess(cVar.f48738i);
    }
}
