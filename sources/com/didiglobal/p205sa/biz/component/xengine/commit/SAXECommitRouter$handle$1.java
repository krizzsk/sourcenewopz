package com.didiglobal.p205sa.biz.component.xengine.commit;

import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.drouter.router.RouterHelper;
import com.didiglobal.enginecore.XEngineCommitCallback;
import com.didiglobal.enginecore.data.exception.EngineErrorException;
import com.didiglobal.enginecore.data.model.XEngineData;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, mo175978d2 = {"com/didiglobal/sa/biz/component/xengine/commit/SAXECommitRouter$handle$1", "Lcom/didiglobal/enginecore/XEngineCommitCallback;", "onFailed", "", "e", "Lcom/didiglobal/enginecore/data/exception/EngineErrorException;", "onSuccess", "xEngineData", "Lcom/didiglobal/enginecore/data/model/XEngineData;", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didiglobal.sa.biz.component.xengine.commit.SAXECommitRouter$handle$1 */
/* compiled from: SAXECommitRouter.kt */
public final class SAXECommitRouter$handle$1 implements XEngineCommitCallback {
    final /* synthetic */ boolean $blockAutoRoute;
    final /* synthetic */ boolean $finalNeedLoading;
    final /* synthetic */ Request $request;
    final /* synthetic */ Result $result;

    SAXECommitRouter$handle$1(boolean z, Result result, boolean z2, Request request) {
        this.$finalNeedLoading = z;
        this.$result = result;
        this.$blockAutoRoute = z2;
        this.$request = request;
    }

    public void onSuccess(XEngineData xEngineData) {
        JsonObject asJsonObject;
        if (this.$finalNeedLoading) {
            Intrinsics.checkNotNull(xEngineData);
            JsonObject jsonObject = xEngineData.jsonObject;
            this.$result.putExtra("KEY_CALLBACK", jsonObject.toString());
            this.$result.putExtra("KEY_REQUEST_KEY", xEngineData.requestKey);
            this.$result.putExtra("KEY_CALLBACK_TYPE", true);
            if (!this.$blockAutoRoute) {
                try {
                    if (jsonObject.has("data") && (asJsonObject = jsonObject.get("data").getAsJsonObject()) != null) {
                        DRouter.build(asJsonObject.get("url").getAsString()).start(this.$request.getContext());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            RouterHelper.release(this.$request);
        }
    }

    public void onFailed(EngineErrorException engineErrorException) {
        this.$result.putExtra("KEY_CALLBACK_TYPE", false);
        Result result = this.$result;
        Intrinsics.checkNotNull(engineErrorException);
        result.putExtra("KEY_ERRNO", engineErrorException.getErrNo());
        RouterHelper.release(this.$request);
    }
}
