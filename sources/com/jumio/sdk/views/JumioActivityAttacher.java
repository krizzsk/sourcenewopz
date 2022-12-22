package com.jumio.sdk.views;

import android.app.Activity;
import com.jumio.core.interfaces.ActivityAttacherInterface;
import com.jumio.sdk.scanpart.JumioScanPart;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0019\u0010\u000b\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, mo175978d2 = {"Lcom/jumio/sdk/views/JumioActivityAttacher;", "", "Lcom/jumio/sdk/scanpart/JumioScanPart;", "scanPart", "", "attach", "Landroid/app/Activity;", "a", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "activity", "<init>", "(Landroid/app/Activity;)V", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: JumioActivityAttacher.kt */
public final class JumioActivityAttacher {

    /* renamed from: a */
    public final Activity f55130a;

    public JumioActivityAttacher(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.f55130a = activity;
    }

    public final void attach(JumioScanPart jumioScanPart) {
        Intrinsics.checkNotNullParameter(jumioScanPart, "scanPart");
        if (jumioScanPart.getScanPart$jumio_core_release() instanceof ActivityAttacherInterface) {
            ((ActivityAttacherInterface) jumioScanPart.getScanPart$jumio_core_release()).setActivityAttacher(this);
        }
    }

    public final Activity getActivity() {
        return this.f55130a;
    }
}
