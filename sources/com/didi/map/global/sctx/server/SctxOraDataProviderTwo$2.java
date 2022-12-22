package com.didi.map.global.sctx.server;

import com.didi.map.global.sctx.case_parser.model.SctxCaseCode;
import java.util.concurrent.TimeoutException;

class SctxOraDataProviderTwo$2 implements Runnable {
    final /* synthetic */ C9834b this$0;
    final /* synthetic */ Throwable val$e;
    final /* synthetic */ String val$err;

    SctxOraDataProviderTwo$2(C9834b bVar, Throwable th, String str) {
        this.this$0 = bVar;
        this.val$e = th;
        this.val$err = str;
    }

    public void run() {
        if (this.this$0.mDataCallback != null && !this.this$0.mStop) {
            if (this.this$0.sctxCaseParser != null && this.this$0.sctxCaseParser.isEnable()) {
                this.this$0.sctxCaseParser.recordJumpCode(this.val$e instanceof TimeoutException ? SctxCaseCode.ORA_REQUEST_TIMEOUT : SctxCaseCode.ORA_REQUEST_ERROR);
            }
            if (this.this$0.mErrorCodeCollect != null) {
                this.this$0.mErrorCodeCollect.setOraErrorStr(this.val$err);
            }
            this.this$0.mDataCallback.onError(this.val$err);
            if (this.this$0.f27704e != null) {
                this.this$0.mDataCallback.onSuccess(this.this$0.f27704e);
            }
        }
    }
}
