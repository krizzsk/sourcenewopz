package com.didichuxing.upgrade;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.app.AlertDialog;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.bean.UpdateResponse;
import com.didichuxing.request.Requester;
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

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0012\u0010\u0011\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\u000e\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, mo175978d2 = {"Lcom/didichuxing/upgrade/UpgradeSDK;", "", "()V", "_tag", "", "mHandler", "Landroid/os/Handler;", "mInviteUrl", "enableLog", "", "loggable", "", "init", "baseContext", "Landroid/content/Context;", "config", "Lcom/didichuxing/upgrade/UpgradeConfig$IConfig;", "showUpdateDialog", "response", "Lcom/didichuxing/bean/UpdateResponse;", "syncUpdates", "context", "Companion", "upgrade_release"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: UpgradeSDK.kt */
public final class UpgradeSDK {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static final Lazy f49242d = LazyKt.lazy(UpgradeSDK$Companion$instance$2.INSTANCE);

    /* renamed from: a */
    private final String f49243a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Handler f49244b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public String f49245c;

    private UpgradeSDK() {
        this.f49243a = "UpgradeSDK";
        this.f49244b = new Handler(Looper.getMainLooper());
        this.f49245c = "";
    }

    public /* synthetic */ UpgradeSDK(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final void enableLog(boolean z) {
        UpLogger.setCanLogger(z);
    }

    public final void init(Context context, UpgradeConfig.IConfig iConfig) {
        Intrinsics.checkParameterIsNotNull(context, "baseContext");
        Intrinsics.checkParameterIsNotNull(iConfig, "config");
        UpgradeConfig.iConfig = iConfig;
        UpgradeSp.Companion.getInstance().init(context);
        OmegaUtilsKt.OmegaTrack_first_start();
    }

    public final void syncUpdates(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        new Requester().requestUpdateInfo(context, new UpgradeSDK$syncUpdates$1(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m35517a(UpdateResponse updateResponse) {
        UpgradeConfig.IConfig iConfig = UpgradeConfig.iConfig;
        Intrinsics.checkExpressionValueIsNotNull(iConfig, "UpgradeConfig.iConfig");
        Activity updateContext = iConfig.getUpdateContext();
        if (updateResponse != null) {
            UpdateResponse updateResponse2 = updateResponse.errNum == 0 && updateContext != null && !updateContext.isFinishing() && updateResponse.needUpdate ? updateResponse : null;
            if (updateResponse2 != null) {
                if (!UpgradeConfig.iConfig.showCustomDialog(updateResponse2.updateTitle, updateResponse2.updateDesc, updateResponse2.updateBtn, updateResponse2.ignoreBtn, !updateResponse2.isForce && updateResponse2.updateType != 3, new UpgradeSDK$showUpdateDialog$$inlined$let$lambda$1(updateContext, updateResponse))) {
                    AlertDialog.Builder positiveButton = new AlertDialog.Builder(updateContext).setTitle((CharSequence) updateResponse2.updateTitle).setMessage((CharSequence) updateResponse2.updateDesc).setPositiveButton((CharSequence) updateResponse2.updateBtn, (DialogInterface.OnClickListener) new UpgradeSDK$showUpdateDialog$$inlined$let$lambda$2(updateContext, updateResponse));
                    if (updateResponse2.updateType == 3 || updateResponse2.isForce) {
                        positiveButton.setCancelable(false);
                    } else {
                        positiveButton.setNegativeButton((CharSequence) updateResponse.ignoreBtn, (DialogInterface.OnClickListener) UpgradeSDK$showUpdateDialog$2$2.INSTANCE);
                        positiveButton.setCancelable(true);
                    }
                    SystemUtils.showDialog(positiveButton.create());
                }
                OmegaUtilsKt.OmegaTrack_alert_show();
                UpgradeSp.Companion.getInstance().setLastUpgradeDialogTime(System.currentTimeMillis());
            }
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, mo175978d2 = {"Lcom/didichuxing/upgrade/UpgradeSDK$Companion;", "", "()V", "instance", "Lcom/didichuxing/upgrade/UpgradeSDK;", "getInstance", "()Lcom/didichuxing/upgrade/UpgradeSDK;", "instance$delegate", "Lkotlin/Lazy;", "upgrade_release"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: UpgradeSDK.kt */
    public static final class Companion {
        static final /* synthetic */ KProperty[] $$delegatedProperties = {C21490Reflection.property1(new PropertyReference1Impl(C21490Reflection.getOrCreateKotlinClass(Companion.class), "instance", "getInstance()Lcom/didichuxing/upgrade/UpgradeSDK;"))};

        public final UpgradeSDK getInstance() {
            Lazy access$getInstance$cp = UpgradeSDK.f49242d;
            Companion companion = UpgradeSDK.Companion;
            KProperty kProperty = $$delegatedProperties[0];
            return (UpgradeSDK) access$getInstance$cp.getValue();
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
