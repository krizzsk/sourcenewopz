package com.didichuxing.upgrade;

import android.content.DialogInterface;
import com.didi.autotracker.AutoTrackHelper;
import com.didichuxing.util.OmegaUtilsKt;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, mo175978d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"}, mo175979k = 3, mo175980mv = {1, 1, 15})
/* compiled from: UpgradeSDK.kt */
final class UpgradeSDK$showUpdateDialog$2$2 implements DialogInterface.OnClickListener {
    public static final UpgradeSDK$showUpdateDialog$2$2 INSTANCE = new UpgradeSDK$showUpdateDialog$2$2();

    UpgradeSDK$showUpdateDialog$2$2() {
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        AutoTrackHelper.trackViewOnClick(dialogInterface, i);
        OmegaUtilsKt.OmegaTrack_alert_ignoe();
    }
}
