package com.didi.payment.kycservice.kyc.fragment;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.payment.base.exts.ApplicationContextProvider;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, mo175978d2 = {"com/didi/payment/kycservice/kyc/fragment/SignUp99PayFragment$initTermView$clickableSpan$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SignUp99PayFragment.kt */
public final class SignUp99PayFragment$initTermView$clickableSpan$1 extends ClickableSpan {
    final /* synthetic */ SignUp99PayFragment this$0;

    SignUp99PayFragment$initTermView$clickableSpan$1(SignUp99PayFragment signUp99PayFragment) {
        this.this$0 = signUp99PayFragment;
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        Intrinsics.checkNotNullParameter(view, "widget");
        this.this$0.m21718l();
    }

    public void updateDrawState(TextPaint textPaint) {
        Intrinsics.checkNotNullParameter(textPaint, "ds");
        textPaint.setColor(ApplicationContextProvider.Companion.getContext().getResources().getColor(R.color.wallet_color_FF6F26));
    }
}
