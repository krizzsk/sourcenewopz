package com.didichuxing.IAU;

import android.content.Context;
import com.didi.sdk.p154ms.common.tasks.OnFailureListener;
import com.didi.sdk.util.ToastUtil;
import com.didichuxing.upgrade.UpgradeConfig;
import com.didichuxing.util.OmegaUtilsKt;
import com.didichuxing.util.UpLogger;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, mo175978d2 = {"<anonymous>", "", "it", "Ljava/lang/Exception;", "onFailure", "com/didichuxing/IAU/IauManager$checkAvailableUpdates$2$2"}, mo175979k = 3, mo175980mv = {1, 1, 15})
/* compiled from: IauManager.kt */
final class IauManager$checkAvailableUpdates$$inlined$let$lambda$2 implements OnFailureListener {
    final /* synthetic */ Context $context$inlined;
    final /* synthetic */ String $inviteUrl$inlined;
    final /* synthetic */ int $upgradeType$inlined;
    final /* synthetic */ IauManager this$0;

    IauManager$checkAvailableUpdates$$inlined$let$lambda$2(IauManager iauManager, Context context, int i, String str) {
        this.this$0 = iauManager;
        this.$context$inlined = context;
        this.$upgradeType$inlined = i;
        this.$inviteUrl$inlined = str;
    }

    public final void onFailure(Exception exc) {
        Intrinsics.checkParameterIsNotNull(exc, "it");
        UpgradeConfig.IConfig iConfig = UpgradeConfig.iConfig;
        Intrinsics.checkExpressionValueIsNotNull(iConfig, "UpgradeConfig.iConfig");
        ToastUtil.show((Context) iConfig.getUpdateContext(), (int) R.string.err_network);
        OmegaUtilsKt.OmegaTrack_appupdate_iau_resp(false, false, 0);
        UpLogger.m35522d(this.this$0.f45526a, "appUpdateInfoTask failed");
    }
}
