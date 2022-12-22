package com.didichuxing.comp.telecom.biz.p176ui.voipcall.page;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo175978d2 = {"<anonymous>", "", "run"}, mo175979k = 3, mo175980mv = {1, 1, 13})
/* renamed from: com.didichuxing.comp.telecom.biz.ui.voipcall.page.ACallPageController$onStateChange$1 */
/* compiled from: ACallPageController.kt */
final class ACallPageController$onStateChange$1 implements Runnable {
    final /* synthetic */ ACallPageController this$0;

    ACallPageController$onStateChange$1(ACallPageController aCallPageController) {
        this.this$0 = aCallPageController;
    }

    public final void run() {
        FragmentActivity activity;
        Fragment mFragment = this.this$0.getMFragment();
        if (mFragment != null && (activity = mFragment.getActivity()) != null) {
            Intrinsics.checkExpressionValueIsNotNull(activity, "mFragment?.activity ?: return@postDelayed");
            if (!activity.isFinishing() && !activity.isDestroyed()) {
                activity.finish();
            }
        }
    }
}
