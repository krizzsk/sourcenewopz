package com.didiglobal.p205sa.biz.component.homemsg;

import com.didichuxing.bigdata.p173dp.locsdk.setting.LocationSettingRequestCallback;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, mo175978d2 = {"com/didiglobal/sa/biz/component/homemsg/HomeMsgPresenter$showOpenSystemLocationDialog$1", "Lcom/didichuxing/bigdata/dp/locsdk/setting/LocationSettingRequestCallback;", "onFailed", "", "onSuccess", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didiglobal.sa.biz.component.homemsg.HomeMsgPresenter$showOpenSystemLocationDialog$1 */
/* compiled from: HomeMsgPresenter.kt */
public final class HomeMsgPresenter$showOpenSystemLocationDialog$1 implements LocationSettingRequestCallback {
    final /* synthetic */ HomeMsgPresenter this$0;

    public void onFailed() {
    }

    public /* synthetic */ void onFailed(boolean z) {
        LocationSettingRequestCallback.CC.$default$onFailed(this, z);
    }

    HomeMsgPresenter$showOpenSystemLocationDialog$1(HomeMsgPresenter homeMsgPresenter) {
        this.this$0 = homeMsgPresenter;
    }

    public void onSuccess() {
        this.this$0.f50996a.debug("open-systemLoaction", new Object[0]);
        this.this$0.m36540c();
    }
}
