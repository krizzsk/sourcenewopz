package com.didichuxing.request;

import android.content.Context;
import com.didichuxing.upgrade.IUpGetInfoCallback;
import com.didichuxing.util.OmegaUtilsKt;
import com.didichuxing.util.UpLogger;
import com.didichuxing.util.UpgradeSp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bJ\u0018\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, mo175978d2 = {"Lcom/didichuxing/request/Requester;", "", "()V", "_tag", "", "isProcessing", "", "mCallback", "Lcom/didichuxing/upgrade/IUpGetInfoCallback;", "isEnoughIntervalTime", "intervalTime", "", "requestUpdateInfo", "", "context", "Landroid/content/Context;", "callback", "requestUpgradeInfo", "interval", "upgrade_release"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: Requester.kt */
public final class Requester {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final String f48495a = "Requester";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public boolean f48496b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public IUpGetInfoCallback f48497c;

    public final void requestUpdateInfo(Context context, IUpGetInfoCallback iUpGetInfoCallback) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(iUpGetInfoCallback, "callback");
        this.f48497c = iUpGetInfoCallback;
        this.f48496b = true;
        CubeRequester.m34783a(context, new Requester$requestUpdateInfo$1(this, context));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m34786a(Context context, int i) {
        if (!m34787a(i)) {
            this.f48496b = false;
            return;
        }
        new UpgradeRequester(context, new Requester$requestUpgradeInfo$1(this)).mo120186a();
        OmegaUtilsKt.OmegaTrack_request_start();
    }

    /* renamed from: a */
    private final boolean m34787a(int i) {
        if (i <= 0) {
            i = 21600;
        }
        long j = (long) (i * 1000);
        boolean z = true;
        long lastUpgradeDialogTime$default = UpgradeSp.getLastUpgradeDialogTime$default(UpgradeSp.Companion.getInstance(), 0, 1, (Object) null);
        String str = this.f48495a;
        UpLogger.m35522d(str, "last show dialog time = " + lastUpgradeDialogTime$default);
        long currentTimeMillis = System.currentTimeMillis() - lastUpgradeDialogTime$default;
        if (currentTimeMillis < j) {
            z = false;
        }
        if (!z) {
            String str2 = this.f48495a;
            UpLogger.m35522d(str2, "not enough interval time. local interval = " + currentTimeMillis + "  server interval = " + j);
        }
        return z;
    }
}
