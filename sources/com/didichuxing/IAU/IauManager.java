package com.didichuxing.IAU;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.net.Uri;
import com.didi.sdk.p154ms.common.ICollector;
import com.didi.sdk.p154ms.common.update.IAppUpdateInfo;
import com.didi.sdk.p154ms.common.update.IAppUpdateManager;
import com.didi.sdk.p154ms.common.utils.ServiceUtil;
import com.didichuxing.upgrade.UpgradeConfig;
import com.didichuxing.util.OmegaUtilsKt;
import com.didichuxing.util.UpLogger;
import com.didichuxing.util.UpgradeSp;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.C21490Reflection;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0004J\b\u0010\u0012\u001a\u00020\fH\u0002J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0010H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, mo175978d2 = {"Lcom/didichuxing/IAU/IauManager;", "", "()V", "_tag", "", "mAppUpdateInfo", "Lcom/didi/sdk/ms/common/update/IAppUpdateInfo;", "mAppUpdateManager", "Lcom/didi/sdk/ms/common/update/IAppUpdateManager;", "mCollector", "Lcom/didi/sdk/ms/common/ICollector;", "checkAvailableUpdates", "", "context", "Landroid/content/Context;", "upgradeType", "", "inviteUrl", "jumpPlayStore", "updateImmediately", "updateType", "Companion", "upgrade_release"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: IauManager.kt */
public final class IauManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static final Lazy f45525e = LazyKt.lazy(IauManager$Companion$instance$2.INSTANCE);
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final String f45526a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public IAppUpdateInfo f45527b;

    /* renamed from: c */
    private final ICollector f45528c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final IAppUpdateManager f45529d;

    private IauManager() {
        this.f45526a = "IauManager";
        this.f45528c = (ICollector) ServiceUtil.getServiceImp(ICollector.class);
        this.f45529d = (IAppUpdateManager) ServiceUtil.getServiceImp(IAppUpdateManager.class);
    }

    public /* synthetic */ IauManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final void checkAvailableUpdates(Context context, int i, String str) {
        Intrinsics.checkParameterIsNotNull(str, "inviteUrl");
        if (context != null && this.f45528c != null && this.f45529d != null) {
            boolean z = true;
            if (i >= 1) {
                if (!(str.length() == 0)) {
                    long lastIauRequestTime = UpgradeSp.Companion.getInstance().getLastIauRequestTime();
                    int iauDialogCount = UpgradeSp.Companion.getInstance().getIauDialogCount();
                    long j = (long) 1000;
                    if ((System.currentTimeMillis() / j) - (lastIauRequestTime / j) >= ((long) 86400)) {
                        UpgradeSp.Companion.getInstance().setLastIauRequestTime(System.currentTimeMillis());
                        UpgradeSp.Companion.getInstance().setIauDialogCount(0);
                    } else if (iauDialogCount > 2 && i != 3) {
                        return;
                    }
                    UpLogger.m35522d(this.f45526a, "checkAvailableUpdates");
                    UpgradeConfig.IConfig iConfig = UpgradeConfig.iConfig;
                    Intrinsics.checkExpressionValueIsNotNull(iConfig, "UpgradeConfig.iConfig");
                    Activity updateContext = iConfig.getUpdateContext();
                    if (updateContext == null || updateContext.isFinishing()) {
                        z = false;
                    }
                    if (!z) {
                        updateContext = null;
                    }
                    Activity activity = updateContext;
                    if (activity != null) {
                        this.f45529d.createAppUpdateInfoTask(context, new IauManager$checkAvailableUpdates$$inlined$let$lambda$1(activity, this, context, i, str), new IauManager$checkAvailableUpdates$$inlined$let$lambda$2(this, context, i, str));
                    }
                    OmegaUtilsKt.OmegaTrack_appupdate_iau_req();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m32654a(int i) {
        IAppUpdateInfo iAppUpdateInfo;
        UpgradeConfig.IConfig iConfig = UpgradeConfig.iConfig;
        Intrinsics.checkExpressionValueIsNotNull(iConfig, "UpgradeConfig.iConfig");
        Activity updateContext = iConfig.getUpdateContext();
        if (this.f45529d != null && this.f45528c != null) {
            if ((updateContext != null && !updateContext.isFinishing() ? updateContext : null) != null && (iAppUpdateInfo = this.f45527b) != null) {
                if (iAppUpdateInfo.isUpdateAvailable()) {
                    try {
                        this.f45529d.startUpdateFlowForResult(iAppUpdateInfo, i, updateContext, 273);
                        OmegaUtilsKt.OmegaTrack_appupdate_iau_update_sw();
                    } catch (IntentSender.SendIntentException e) {
                        e.printStackTrace();
                    }
                }
                UpgradeSp.Companion.getInstance().setIauDialogCount(UpgradeSp.Companion.getInstance().getIauDialogCount() + 1);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m32653a() {
        UpgradeConfig.IConfig iConfig = UpgradeConfig.iConfig;
        Intrinsics.checkExpressionValueIsNotNull(iConfig, "UpgradeConfig.iConfig");
        Activity updateContext = iConfig.getUpdateContext();
        if (updateContext != null) {
            String packageName = updateContext.getPackageName();
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + packageName));
                intent.setFlags(268435456);
                updateContext.startActivity(intent);
            } catch (ActivityNotFoundException unused) {
                Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + packageName));
                intent2.setFlags(268435456);
                updateContext.startActivity(intent2);
            }
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, mo175978d2 = {"Lcom/didichuxing/IAU/IauManager$Companion;", "", "()V", "instance", "Lcom/didichuxing/IAU/IauManager;", "getInstance", "()Lcom/didichuxing/IAU/IauManager;", "instance$delegate", "Lkotlin/Lazy;", "upgrade_release"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: IauManager.kt */
    public static final class Companion {
        static final /* synthetic */ KProperty[] $$delegatedProperties = {C21490Reflection.property1(new PropertyReference1Impl(C21490Reflection.getOrCreateKotlinClass(Companion.class), "instance", "getInstance()Lcom/didichuxing/IAU/IauManager;"))};

        public final IauManager getInstance() {
            Lazy access$getInstance$cp = IauManager.f45525e;
            Companion companion = IauManager.Companion;
            KProperty kProperty = $$delegatedProperties[0];
            return (IauManager) access$getInstance$cp.getValue();
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
