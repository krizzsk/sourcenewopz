package com.didichuxing.dfbasesdk.logupload2;

import com.didichuxing.diface.utils.http.BaseResult;
import com.didichuxing.foundation.rpc.RpcService;
import java.io.IOException;
import java.util.List;

class LogUploader2$7 implements RpcService.Callback<BaseResult> {
    final /* synthetic */ C15304a this$0;
    final /* synthetic */ List val$ids;

    LogUploader2$7(C15304a aVar, List list) {
        this.this$0 = aVar;
        this.val$ids = list;
    }

    public void onSuccess(BaseResult baseResult) {
        boolean unused = this.this$0.f46660b = false;
        this.this$0.m33505a(2, (Object) this.val$ids);
    }

    public void onFailure(IOException iOException) {
        boolean unused = this.this$0.f46660b = false;
        this.this$0.m33505a(3, (Object) this.val$ids);
    }
}
