package com.didichuxing.request;

import android.content.Context;
import com.didichuxing.request.CubeRequester;
import com.didichuxing.upgrade.IUpGetInfoCallback;
import com.didichuxing.util.UpLogger;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0016¨\u0006\t"}, mo175978d2 = {"com/didichuxing/request/Requester$requestUpdateInfo$1", "Lcom/didichuxing/request/CubeRequester$CubeCallback;", "onFailed", "", "errorCode", "", "onSuccess", "state", "interval", "upgrade_release"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: Requester.kt */
public final class Requester$requestUpdateInfo$1 implements CubeRequester.CubeCallback {
    final /* synthetic */ Context $context;
    final /* synthetic */ Requester this$0;

    Requester$requestUpdateInfo$1(Requester requester, Context context) {
        this.this$0 = requester;
        this.$context = context;
    }

    public void onSuccess(int i, int i2) {
        this.this$0.m34786a(this.$context, i2);
    }

    public void onFailed(int i) {
        IUpGetInfoCallback access$getMCallback$p = this.this$0.f48497c;
        if (access$getMCallback$p != null) {
            access$getMCallback$p.onRequestFailed(i);
        }
        String access$get_tag$p = this.this$0.f48495a;
        UpLogger.m35522d(access$get_tag$p, "request cube failed. errorCode = " + i);
    }
}
