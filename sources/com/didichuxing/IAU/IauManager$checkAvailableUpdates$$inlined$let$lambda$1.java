package com.didichuxing.IAU;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.didi.sdk.p154ms.common.tasks.OnSuccessListener;
import com.didi.sdk.p154ms.common.update.IAppUpdateInfo;
import com.didi.sdk.p154ms.common.update.IAppUpdateManager;
import com.didichuxing.upgrade.UpgradeActivity;
import com.didichuxing.upgrade.UpgradeActivityKt;
import com.didichuxing.upgrade.UpgradeConfig;
import com.didichuxing.util.OmegaUtilsKt;
import com.didichuxing.util.UpLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, mo175978d2 = {"<anonymous>", "", "appUpdateInfo", "Lcom/didi/sdk/ms/common/update/IAppUpdateInfo;", "kotlin.jvm.PlatformType", "onSuccess", "com/didichuxing/IAU/IauManager$checkAvailableUpdates$2$1"}, mo175979k = 3, mo175980mv = {1, 1, 15})
/* compiled from: IauManager.kt */
final class IauManager$checkAvailableUpdates$$inlined$let$lambda$1<TResult> implements OnSuccessListener<IAppUpdateInfo> {
    final /* synthetic */ Context $context$inlined;
    final /* synthetic */ String $inviteUrl$inlined;
    final /* synthetic */ Activity $it;
    final /* synthetic */ int $upgradeType$inlined;
    final /* synthetic */ IauManager this$0;

    IauManager$checkAvailableUpdates$$inlined$let$lambda$1(Activity activity, IauManager iauManager, Context context, int i, String str) {
        this.$it = activity;
        this.this$0 = iauManager;
        this.$context$inlined = context;
        this.$upgradeType$inlined = i;
        this.$inviteUrl$inlined = str;
    }

    public final void onSuccess(IAppUpdateInfo iAppUpdateInfo) {
        UpLogger.m35522d(this.this$0.f45526a, "checkAvailableUpdates success : " + "\n" + "updateAvailability :  " + iAppUpdateInfo.updateAvailability() + "\n" + "availableVersionCode :  " + iAppUpdateInfo.availableVersionCode() + "\n");
        this.this$0.f45527b = iAppUpdateInfo;
        Intrinsics.checkExpressionValueIsNotNull(iAppUpdateInfo, "appUpdateInfo");
        if (iAppUpdateInfo.isUpdateAvailable()) {
            IAppUpdateManager access$getMAppUpdateManager$p = this.this$0.f45529d;
            boolean z = false;
            if (this.$upgradeType$inlined == 3) {
                if (iAppUpdateInfo.isUpdateTypeAllowed(this.this$0.f45529d.getAppUpdateType(this.$upgradeType$inlined == 3))) {
                    z = true;
                }
            }
            this.this$0.m32654a(access$getMAppUpdateManager$p.getAppUpdateType(z));
        } else if (UpgradeConfig.iConfig == null || this.$upgradeType$inlined != 1) {
            this.this$0.m32653a();
        } else {
            UpgradeConfig.IConfig iConfig = UpgradeConfig.iConfig;
            Intrinsics.checkExpressionValueIsNotNull(iConfig, "UpgradeConfig.iConfig");
            Activity updateContext = iConfig.getUpdateContext();
            if (updateContext != null) {
                updateContext.startActivity(new Intent(this.$it, UpgradeActivity.class).setFlags(268435456).putExtra(UpgradeActivityKt.EXTRA_URL_JOIN_TESTING_PLAN, this.$inviteUrl$inlined));
            }
        }
        OmegaUtilsKt.OmegaTrack_appupdate_iau_resp(true, iAppUpdateInfo.isUpdateAvailable(), iAppUpdateInfo.availableVersionCode());
    }
}
