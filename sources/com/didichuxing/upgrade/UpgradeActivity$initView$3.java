package com.didichuxing.upgrade;

import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didichuxing.request.UploadGAccountRequester;
import com.didichuxing.util.UpgradeSp;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo175978d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo175979k = 3, mo175980mv = {1, 1, 15})
/* compiled from: UpgradeActivity.kt */
final class UpgradeActivity$initView$3 implements View.OnClickListener {
    final /* synthetic */ UpgradeActivity this$0;

    UpgradeActivity$initView$3(UpgradeActivity upgradeActivity) {
        this.this$0 = upgradeActivity;
    }

    public final void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        UpgradeConfig.iConfig.openWebView(this.this$0.getIntent().getStringExtra(UpgradeActivityKt.EXTRA_URL_JOIN_TESTING_PLAN));
        String googleAccount$default = UpgradeSp.getGoogleAccount$default(UpgradeSp.Companion.getInstance(), (String) null, 1, (Object) null);
        if (googleAccount$default == null) {
            googleAccount$default = "";
        }
        new UploadGAccountRequester(googleAccount$default, 1).request();
        this.this$0.f49240c = 1;
        UpgradeSp.Companion.getInstance().setHasJoinedPlan(1);
    }
}
