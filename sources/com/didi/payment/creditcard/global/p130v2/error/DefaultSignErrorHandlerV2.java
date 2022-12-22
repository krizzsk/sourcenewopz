package com.didi.payment.creditcard.global.p130v2.error;

import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.didi.global.globaluikit.drawer.LEGODrawer;
import com.didi.payment.commonsdk.p129ui.helper.NLEGODialogBuilder;
import com.didi.payment.creditcard.global.error.ISignErrorHandler;
import com.didi.payment.creditcard.global.model.bean.SignResult;
import com.taxis99.R;

/* renamed from: com.didi.payment.creditcard.global.v2.error.DefaultSignErrorHandlerV2 */
public class DefaultSignErrorHandlerV2 implements ISignErrorHandler {
    protected final FragmentActivity mActivity;
    protected ISignErrorHandler.Callback mCallback;
    protected LEGODrawer mConfirmDialog;

    public DefaultSignErrorHandlerV2(FragmentActivity fragmentActivity) {
        this.mActivity = fragmentActivity;
    }

    public void setCallback(ISignErrorHandler.Callback callback) {
        this.mCallback = callback;
    }

    public void handleError(SignResult signResult) {
        FragmentActivity fragmentActivity = this.mActivity;
        if (fragmentActivity != null && this.mCallback != null && signResult != null) {
            NLEGODialogBuilder title = new NLEGODialogBuilder(fragmentActivity).title(this.mActivity.getString(R.string.one_payment_creditcard_global_sign_fail_title));
            if (!TextUtils.isEmpty(signResult.errMsg)) {
                title.subTitle(signResult.errMsg);
            }
            createDialogButton(signResult, title);
            this.mConfirmDialog = title.build(1).show();
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0052, code lost:
        if (android.text.TextUtils.isEmpty(r5) != false) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0054, code lost:
        r14.negativeAction(r5, new com.didi.payment.creditcard.global.p130v2.error.DefaultSignErrorHandlerV2.C107242(r12));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x005c, code lost:
        com.didi.payment.creditcard.global.p130v2.utils.CreditCardOmegaUtil.Companion.errorShowTrace(java.lang.Integer.valueOf(r13.errNo), r0, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0067, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0038, code lost:
        r9 = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0040, code lost:
        r9 = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0041, code lost:
        r8 = r13;
        r10 = r0;
        r11 = r5;
        r14.confirmAction(r0, new com.didi.payment.creditcard.global.p130v2.error.DefaultSignErrorHandlerV2.C107231(r12));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void createDialogButton(final com.didi.payment.creditcard.global.model.bean.SignResult r13, com.didi.payment.commonsdk.p129ui.helper.NLEGODialogBuilder r14) {
        /*
            r12 = this;
            int r0 = r13.errNo
            r1 = 2131956722(0x7f1313f2, float:1.9550008E38)
            r2 = 3
            r3 = 5
            r4 = 2131956718(0x7f1313ee, float:1.955E38)
            java.lang.String r5 = ""
            switch(r0) {
                case 16100: goto L_0x003a;
                case 16101: goto L_0x0032;
                case 16102: goto L_0x0032;
                case 16103: goto L_0x0032;
                case 16104: goto L_0x002b;
                case 16105: goto L_0x002b;
                case 16106: goto L_0x002b;
                case 16107: goto L_0x003a;
                case 16108: goto L_0x0016;
                default: goto L_0x000f;
            }
        L_0x000f:
            androidx.fragment.app.FragmentActivity r0 = r12.mActivity
            java.lang.String r0 = r0.getString(r4)
            goto L_0x0040
        L_0x0016:
            androidx.fragment.app.FragmentActivity r0 = r12.mActivity
            r1 = 2131956719(0x7f1313ef, float:1.9550002E38)
            java.lang.String r0 = r0.getString(r1)
            r2 = 4
            androidx.fragment.app.FragmentActivity r1 = r12.mActivity
            r3 = 2131956720(0x7f1313f0, float:1.9550004E38)
            java.lang.String r5 = r1.getString(r3)
            r9 = 4
            goto L_0x0041
        L_0x002b:
            androidx.fragment.app.FragmentActivity r0 = r12.mActivity
            java.lang.String r0 = r0.getString(r1)
            goto L_0x0038
        L_0x0032:
            androidx.fragment.app.FragmentActivity r0 = r12.mActivity
            java.lang.String r0 = r0.getString(r1)
        L_0x0038:
            r9 = 3
            goto L_0x0041
        L_0x003a:
            androidx.fragment.app.FragmentActivity r0 = r12.mActivity
            java.lang.String r0 = r0.getString(r4)
        L_0x0040:
            r9 = 5
        L_0x0041:
            com.didi.payment.creditcard.global.v2.error.DefaultSignErrorHandlerV2$1 r1 = new com.didi.payment.creditcard.global.v2.error.DefaultSignErrorHandlerV2$1
            r6 = r1
            r7 = r12
            r8 = r13
            r10 = r0
            r11 = r5
            r6.<init>(r8, r9, r10, r11)
            r14.confirmAction(r0, r1)
            boolean r1 = android.text.TextUtils.isEmpty(r5)
            if (r1 != 0) goto L_0x005c
            com.didi.payment.creditcard.global.v2.error.DefaultSignErrorHandlerV2$2 r1 = new com.didi.payment.creditcard.global.v2.error.DefaultSignErrorHandlerV2$2
            r1.<init>(r13, r0, r5)
            r14.negativeAction(r5, r1)
        L_0x005c:
            com.didi.payment.creditcard.global.v2.utils.CreditCardOmegaUtil$Companion r14 = com.didi.payment.creditcard.global.p130v2.utils.CreditCardOmegaUtil.Companion
            int r13 = r13.errNo
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
            r14.errorShowTrace(r13, r0, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.creditcard.global.p130v2.error.DefaultSignErrorHandlerV2.createDialogButton(com.didi.payment.creditcard.global.model.bean.SignResult, com.didi.payment.commonsdk.ui.helper.NLEGODialogBuilder):void");
    }
}
