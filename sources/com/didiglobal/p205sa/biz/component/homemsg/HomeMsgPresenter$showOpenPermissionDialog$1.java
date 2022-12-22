package com.didiglobal.p205sa.biz.component.homemsg;

import com.didi.commoninterfacelib.permission.PermissionCallback;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032,\u0010\u0004\u001a(\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006 \u0007*\u0014\u0012\u000e\b\u0001\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\u00050\u0005H\n"}, mo175978d2 = {"<anonymous>", "", "b", "", "<anonymous parameter 1>", "", "", "kotlin.jvm.PlatformType"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didiglobal.sa.biz.component.homemsg.HomeMsgPresenter$showOpenPermissionDialog$1 */
/* compiled from: HomeMsgPresenter.kt */
final class HomeMsgPresenter$showOpenPermissionDialog$1 implements PermissionCallback {
    final /* synthetic */ HomeMsgPresenter this$0;

    HomeMsgPresenter$showOpenPermissionDialog$1(HomeMsgPresenter homeMsgPresenter) {
        this.this$0 = homeMsgPresenter;
    }

    public final void isAllGranted(boolean z, String[] strArr) {
        if (z) {
            this.this$0.f50996a.debug("openpermission", new Object[0]);
            this.this$0.m36540c();
        }
    }
}
