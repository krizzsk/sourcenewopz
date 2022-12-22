package com.didiglobal.p205sa.biz.tab.delegate;

import com.didi.sdk.app.business.ISaTabObserver;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.didiglobal.p205sa.biz.tab.manager.SaTabBusinessRedPointManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@ServiceProvider({ISaTabObserver.class})
@Metadata(mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\r"}, mo175978d2 = {"Lcom/didiglobal/sa/biz/tab/delegate/SaTabObserver;", "Lcom/didi/sdk/app/business/ISaTabObserver;", "()V", "notifyTabDown", "", "groupId", "", "notifyTabRedPoint", "show", "", "notifyTabTip", "tip", "notifyTabUp", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didiglobal.sa.biz.tab.delegate.SaTabObserver */
/* compiled from: SaTabObserver.kt */
public final class SaTabObserver implements ISaTabObserver {
    public void notifyTabTip(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "groupId");
        Intrinsics.checkNotNullParameter(str2, "tip");
        SaTabBusinessRedPointManager.INSTANCE.notifyTabTip(str, str2);
    }

    public void notifyTabDown(String str) {
        Intrinsics.checkNotNullParameter(str, "groupId");
        SaTabBusinessRedPointManager.INSTANCE.notifyTabDown(str);
    }

    public void notifyTabRedPoint(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "groupId");
        SaTabBusinessRedPointManager.INSTANCE.notifyTabRedPoint(str, z);
    }

    public void notifyTabUp(String str) {
        Intrinsics.checkNotNullParameter(str, "groupId");
        SaTabBusinessRedPointManager.INSTANCE.notifyTabUp(str);
    }
}
