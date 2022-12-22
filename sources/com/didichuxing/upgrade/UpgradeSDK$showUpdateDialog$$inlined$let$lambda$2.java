package com.didichuxing.upgrade;

import android.app.Activity;
import android.content.DialogInterface;
import com.didi.autotracker.AutoTrackHelper;
import com.didichuxing.IAU.IauManager;
import com.didichuxing.bean.UpdateResponse;
import com.didichuxing.util.OmegaUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007¨\u0006\b"}, mo175978d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick", "com/didichuxing/upgrade/UpgradeSDK$showUpdateDialog$2$builder$1"}, mo175979k = 3, mo175980mv = {1, 1, 15})
/* compiled from: UpgradeSDK.kt */
final class UpgradeSDK$showUpdateDialog$$inlined$let$lambda$2 implements DialogInterface.OnClickListener {
    final /* synthetic */ Activity $context$inlined;
    final /* synthetic */ UpdateResponse $response$inlined;

    UpgradeSDK$showUpdateDialog$$inlined$let$lambda$2(Activity activity, UpdateResponse updateResponse) {
        this.$context$inlined = activity;
        this.$response$inlined = updateResponse;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        AutoTrackHelper.trackViewOnClick(dialogInterface, i);
        int i2 = this.$response$inlined.updateType;
        String str = this.$response$inlined.updateUrl;
        Intrinsics.checkExpressionValueIsNotNull(str, "response.updateUrl");
        IauManager.Companion.getInstance().checkAvailableUpdates(this.$context$inlined, i2, str);
        OmegaUtilsKt.OmegaTrack_alert_ck();
    }
}
