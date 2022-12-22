package com.didiglobal.pay.paysecure.p204ui.fragment;

import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didiglobal.pay.paysecure.base.PaySecureState;
import com.didiglobal.pay.paysecure.omega.OmegaUtil;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo175978d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo175979k = 3, mo175980mv = {1, 1, 16})
/* renamed from: com.didiglobal.pay.paysecure.ui.fragment.CreatePayPwdFragment$onCreateView$5 */
/* compiled from: CreatePayPwdFragment.kt */
final class CreatePayPwdFragment$onCreateView$5 implements View.OnClickListener {
    final /* synthetic */ CreatePayPwdFragment this$0;

    CreatePayPwdFragment$onCreateView$5(CreatePayPwdFragment createPayPwdFragment) {
        this.this$0 = createPayPwdFragment;
    }

    public final void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        OmegaUtil.Companion.trackEvent("ibt_password_original_password_change_veri_ck");
        this.this$0.getMessenger().setScene("FORGET");
        this.this$0.getMessenger().setSceneType(3);
        this.this$0.transform(PaySecureState.STATE_FORGOT_PWD);
    }
}
