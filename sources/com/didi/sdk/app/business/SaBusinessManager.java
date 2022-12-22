package com.didi.sdk.app.business;

import android.os.Bundle;
import com.didi.sdk.util.SingletonHolder;
import com.didichuxing.foundation.spi.ServiceLoader;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004J\u0016\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004J\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004J \u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¨\u0006\u0014"}, mo175978d2 = {"Lcom/didi/sdk/app/business/SaBusinessManager;", "", "()V", "getCurrentBusiness", "", "notifyTabDown", "", "groupId", "notifyTabRedPoint", "show", "", "notifyTabTip", "tip", "notifyTabUp", "switchBusiness", "groupType", "link", "bundle", "Landroid/os/Bundle;", "Companion", "publicservice_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: SaBusinessManager.kt */
public final class SaBusinessManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/sdk/app/business/SaBusinessManager$Companion;", "", "()V", "getIns", "Lcom/didi/sdk/app/business/SaBusinessManager;", "publicservice_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: SaBusinessManager.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SaBusinessManager getIns() {
            Object instance = SingletonHolder.getInstance(SaBusinessManager.class);
            Intrinsics.checkExpressionValueIsNotNull(instance, "SingletonHolder.getInsta…inessManager::class.java)");
            return (SaBusinessManager) instance;
        }
    }

    public final void switchBusiness(String str, String str2, Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(str, "groupType");
        Intrinsics.checkParameterIsNotNull(str2, "link");
        ISaSwitchBusiness iSaSwitchBusiness = (ISaSwitchBusiness) ServiceLoader.load(ISaSwitchBusiness.class).get();
        if (iSaSwitchBusiness != null) {
            iSaSwitchBusiness.m46706switch(str, str2, bundle);
        }
    }

    public final String getCurrentBusiness() {
        S s = ServiceLoader.load(ICurrentBusiness.class).get();
        Intrinsics.checkExpressionValueIsNotNull(s, "ServiceLoader.load(ICurr…siness::class.java).get()");
        return ((ICurrentBusiness) s).getCurrentBusiness();
    }

    public final void notifyTabRedPoint(String str, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, "groupId");
        ISaTabObserver iSaTabObserver = (ISaTabObserver) ServiceLoader.load(ISaTabObserver.class).get();
        if (iSaTabObserver != null) {
            iSaTabObserver.notifyTabRedPoint(str, z);
        }
    }

    public final void notifyTabTip(String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "groupId");
        Intrinsics.checkParameterIsNotNull(str2, "tip");
        ISaTabObserver iSaTabObserver = (ISaTabObserver) ServiceLoader.load(ISaTabObserver.class).get();
        if (iSaTabObserver != null) {
            iSaTabObserver.notifyTabTip(str, str2);
        }
    }

    public final void notifyTabUp(String str) {
        Intrinsics.checkParameterIsNotNull(str, "groupId");
        ISaTabObserver iSaTabObserver = (ISaTabObserver) ServiceLoader.load(ISaTabObserver.class).get();
        if (iSaTabObserver != null) {
            iSaTabObserver.notifyTabUp(str);
        }
    }

    public final void notifyTabDown(String str) {
        Intrinsics.checkParameterIsNotNull(str, "groupId");
        ISaTabObserver iSaTabObserver = (ISaTabObserver) ServiceLoader.load(ISaTabObserver.class).get();
        if (iSaTabObserver != null) {
            iSaTabObserver.notifyTabDown(str);
        }
    }
}
