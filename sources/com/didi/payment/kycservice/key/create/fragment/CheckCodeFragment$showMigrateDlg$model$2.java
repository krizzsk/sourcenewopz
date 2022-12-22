package com.didi.payment.kycservice.key.create.fragment;

import android.view.View;
import com.didi.global.globaluikit.callback.LEGOOnAntiShakeClickListener;
import com.didi.global.globaluikit.drawer.LEGODrawer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, mo175978d2 = {"com/didi/payment/kycservice/key/create/fragment/CheckCodeFragment$showMigrateDlg$model$2", "Lcom/didi/global/globaluikit/callback/LEGOOnAntiShakeClickListener;", "onAntiShakeClick", "", "p0", "Landroid/view/View;", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CheckCodeFragment.kt */
public final class CheckCodeFragment$showMigrateDlg$model$2 extends LEGOOnAntiShakeClickListener {
    final /* synthetic */ CheckCodeFragment this$0;

    CheckCodeFragment$showMigrateDlg$model$2(CheckCodeFragment checkCodeFragment) {
        this.this$0 = checkCodeFragment;
    }

    public void onAntiShakeClick(View view) {
        if (this.this$0.f30637c != null) {
            LEGODrawer access$getDlgMigrate$p = this.this$0.f30637c;
            Intrinsics.checkNotNull(access$getDlgMigrate$p);
            if (access$getDlgMigrate$p.isShowing()) {
                LEGODrawer access$getDlgMigrate$p2 = this.this$0.f30637c;
                Intrinsics.checkNotNull(access$getDlgMigrate$p2);
                access$getDlgMigrate$p2.dismiss();
            }
        }
    }
}
