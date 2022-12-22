package com.didichuxing.request;

import com.didichuxing.bean.UpdateResponse;
import com.didichuxing.request.UpgradeRequester;
import com.didichuxing.upgrade.IUpGetInfoCallback;
import com.didichuxing.util.OmegaUtilsKt;
import com.didichuxing.util.UpLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, mo175978d2 = {"com/didichuxing/request/Requester$requestUpgradeInfo$1", "Lcom/didichuxing/request/UpgradeRequester$RequestCallback;", "requestFailed", "", "errorCode", "", "requestSucceed", "response", "Lcom/didichuxing/bean/UpdateResponse;", "upgrade_release"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: Requester.kt */
public final class Requester$requestUpgradeInfo$1 implements UpgradeRequester.RequestCallback {
    final /* synthetic */ Requester this$0;

    Requester$requestUpgradeInfo$1(Requester requester) {
        this.this$0 = requester;
    }

    public void requestSucceed(UpdateResponse updateResponse) {
        Intrinsics.checkParameterIsNotNull(updateResponse, "response");
        this.this$0.f48496b = false;
        IUpGetInfoCallback access$getMCallback$p = this.this$0.f48497c;
        if (access$getMCallback$p != null) {
            access$getMCallback$p.onRequestSuccess(updateResponse);
        }
        OmegaUtilsKt.OmegaTrack_request_success();
    }

    public void requestFailed(int i) {
        this.this$0.f48496b = false;
        IUpGetInfoCallback access$getMCallback$p = this.this$0.f48497c;
        if (access$getMCallback$p != null) {
            access$getMCallback$p.onRequestFailed(i);
        }
        OmegaUtilsKt.OmegaTrack_request_fail(i);
        String access$get_tag$p = this.this$0.f48495a;
        UpLogger.m35522d(access$get_tag$p, "request update failed. errorCode = " + i);
    }
}
