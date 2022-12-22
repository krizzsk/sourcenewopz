package com.didi.unifiedPay.component.view;

import android.content.Context;
import com.taxis99.R;

public class NonTripPayManager implements IPayManager {

    /* renamed from: a */
    private Context f44394a;

    /* renamed from: b */
    private PaymentView f44395b;

    public void onPayBtnClick() {
    }

    public NonTripPayManager(Context context, PaymentView paymentView) {
        this.f44394a = context;
        this.f44395b = paymentView;
    }

    public void showQueryPayResultView(boolean z) {
        if (z && this.f44395b.mListener != null) {
            this.f44395b.mListener.onShowQueryPayResultView();
        }
        this.f44395b.showLoadingView(this.f44394a.getResources().getString(R.string.oc_pay_loading_state_string), z);
    }

    /* JADX WARNING: type inference failed for: r2v7, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void showSuccessView(boolean r5, java.lang.String r6) {
        /*
            r4 = this;
            r0 = 8
            r1 = 0
            if (r5 == 0) goto L_0x0056
            com.didi.unifiedPay.component.view.PaymentView r5 = r4.f44395b
            com.didi.unifiedPay.component.view.IPayView$PayViewListener r5 = r5.mListener
            if (r5 == 0) goto L_0x0012
            com.didi.unifiedPay.component.view.PaymentView r5 = r4.f44395b
            com.didi.unifiedPay.component.view.IPayView$PayViewListener r5 = r5.mListener
            r5.onPaySuccess()
        L_0x0012:
            r5 = 0
            com.didi.unifiedPay.component.view.PaymentView r2 = r4.f44395b
            android.widget.FrameLayout r2 = r2.payStateLayout
            int r2 = r2.getChildCount()
            if (r2 <= 0) goto L_0x002e
            com.didi.unifiedPay.component.view.PaymentView r2 = r4.f44395b
            android.widget.FrameLayout r2 = r2.payStateLayout
            android.view.View r2 = r2.getChildAt(r1)
            boolean r3 = r2 instanceof com.didi.unifiedPay.component.widget.LoadingStateView
            if (r3 == 0) goto L_0x002e
            r5 = r2
            com.didi.unifiedPay.component.widget.LoadingStateView r5 = (com.didi.unifiedPay.component.widget.LoadingStateView) r5
            r2 = 1
            goto L_0x002f
        L_0x002e:
            r2 = 0
        L_0x002f:
            if (r5 != 0) goto L_0x0038
            com.didi.unifiedPay.component.widget.LoadingStateView r5 = new com.didi.unifiedPay.component.widget.LoadingStateView
            android.content.Context r3 = r4.f44394a
            r5.<init>(r3)
        L_0x0038:
            r5.setText((java.lang.String) r6)
            com.didi.unifiedPay.component.widget.LoadingStateView$State r6 = com.didi.unifiedPay.component.widget.LoadingStateView.State.SUCCESS_STATE
            r5.changeState(r6)
            if (r2 != 0) goto L_0x006b
            com.didi.unifiedPay.component.view.PaymentView r6 = r4.f44395b
            r6.showPayStateView(r5)
            com.didi.unifiedPay.component.view.PaymentView r5 = r4.f44395b
            android.widget.LinearLayout r5 = r5.payBizViewLayout
            r5.setVisibility(r0)
            com.didi.unifiedPay.component.view.PaymentView r5 = r4.f44395b
            android.widget.FrameLayout r5 = r5.payStateLayout
            r5.setVisibility(r1)
            goto L_0x006b
        L_0x0056:
            com.didi.unifiedPay.component.view.PaymentView r5 = r4.f44395b
            android.widget.FrameLayout r5 = r5.payStateLayout
            r5.removeAllViews()
            com.didi.unifiedPay.component.view.PaymentView r5 = r4.f44395b
            android.widget.FrameLayout r5 = r5.payStateLayout
            r5.setVisibility(r0)
            com.didi.unifiedPay.component.view.PaymentView r5 = r4.f44395b
            android.widget.LinearLayout r5 = r5.payBizViewLayout
            r5.setVisibility(r1)
        L_0x006b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.unifiedPay.component.view.NonTripPayManager.showSuccessView(boolean, java.lang.String):void");
    }
}
