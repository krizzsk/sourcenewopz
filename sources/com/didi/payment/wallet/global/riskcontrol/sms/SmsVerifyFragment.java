package com.didi.payment.wallet.global.riskcontrol.sms;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000¨\u0006\u0014"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/riskcontrol/sms/SmsVerifyFragment;", "Landroidx/fragment/app/Fragment;", "()V", "editSms", "Lcom/didi/payment/wallet/global/riskcontrol/sms/SmsEditView;", "titleBar", "Landroid/widget/FrameLayout;", "tvSubmit", "Landroid/widget/TextView;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SmsVerifyFragment.kt */
public final class SmsVerifyFragment extends Fragment {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public SmsEditView f31806a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public TextView f31807b;

    /* renamed from: c */
    private FrameLayout f31808c;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fragment_sms_verify, viewGroup, false);
        View findViewById = inflate.findViewById(R.id.title_bar);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.title_bar)");
        this.f31808c = (FrameLayout) findViewById;
        View findViewById2 = inflate.findViewById(R.id.edit_sms);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.edit_sms)");
        this.f31806a = (SmsEditView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.tv_submit);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.tv_submit)");
        this.f31807b = (TextView) findViewById3;
        return inflate;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        FrameLayout frameLayout = this.f31808c;
        TextView textView = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBar");
            frameLayout = null;
        }
        frameLayout.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                SmsVerifyFragment.m22544a(SmsVerifyFragment.this, view);
            }
        });
        SmsEditView smsEditView = this.f31806a;
        if (smsEditView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editSms");
            smsEditView = null;
        }
        smsEditView.setInputListener(new SmsVerifyFragment$onViewCreated$2(this));
        SmsEditView smsEditView2 = this.f31806a;
        if (smsEditView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editSms");
            smsEditView2 = null;
        }
        smsEditView2.setClearListener(new SmsVerifyFragment$onViewCreated$3(this));
        TextView textView2 = this.f31807b;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvSubmit");
            textView2 = null;
        }
        textView2.setEnabled(false);
        TextView textView3 = this.f31807b;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvSubmit");
        } else {
            textView = textView3;
        }
        textView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                SmsVerifyFragment.m22545b(SmsVerifyFragment.this, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m22544a(SmsVerifyFragment smsVerifyFragment, View view) {
        Intrinsics.checkNotNullParameter(smsVerifyFragment, "this$0");
        Context context = smsVerifyFragment.getContext();
        FragmentActivity fragmentActivity = context instanceof FragmentActivity ? (FragmentActivity) context : null;
        if (fragmentActivity != null) {
            fragmentActivity.finish();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: com.didi.payment.wallet.global.riskcontrol.sms.SmsEditView} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r1v3, types: [androidx.fragment.app.FragmentActivity] */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m22545b(com.didi.payment.wallet.global.riskcontrol.sms.SmsVerifyFragment r5, android.view.View r6) {
        /*
            java.lang.String r6 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r6)
            com.didi.payment.wallet.global.riskcontrol.sms.SmsEditView r6 = r5.f31806a
            java.lang.String r0 = "editSms"
            r1 = 0
            if (r6 != 0) goto L_0x0010
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            r6 = r1
        L_0x0010:
            android.text.Editable r6 = r6.getText()
            r2 = 1
            r3 = 0
            if (r6 != 0) goto L_0x0019
            goto L_0x0029
        L_0x0019:
            java.lang.String r6 = r6.toString()
            if (r6 != 0) goto L_0x0020
            goto L_0x0029
        L_0x0020:
            java.lang.String r4 = "123456"
            boolean r6 = r6.equals(r4)
            if (r6 != r2) goto L_0x0029
            r3 = 1
        L_0x0029:
            if (r3 == 0) goto L_0x003d
            android.content.Context r5 = r5.getContext()
            boolean r6 = r5 instanceof androidx.fragment.app.FragmentActivity
            if (r6 == 0) goto L_0x0036
            r1 = r5
            androidx.fragment.app.FragmentActivity r1 = (androidx.fragment.app.FragmentActivity) r1
        L_0x0036:
            if (r1 != 0) goto L_0x0039
            goto L_0x0049
        L_0x0039:
            r1.finish()
            goto L_0x0049
        L_0x003d:
            com.didi.payment.wallet.global.riskcontrol.sms.SmsEditView r5 = r5.f31806a
            if (r5 != 0) goto L_0x0045
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            goto L_0x0046
        L_0x0045:
            r1 = r5
        L_0x0046:
            r1.updateUI(r2)
        L_0x0049:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.wallet.global.riskcontrol.sms.SmsVerifyFragment.m22545b(com.didi.payment.wallet.global.riskcontrol.sms.SmsVerifyFragment, android.view.View):void");
    }
}
