package com.didi.payment.creditcard.global.p130v2.error;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.didi.payment.base.widget.DoubleCheckOnClickListener;
import com.didi.payment.commonsdk.p129ui.helper.NLEGODialogBuilder;
import com.didi.payment.creditcard.global.model.bean.SignResult;
import com.didi.payment.creditcard.global.omega.GlobalOmegaConstant;
import com.didi.payment.creditcard.global.omega.GlobalOmegaUtils;
import com.didi.payment.creditcard.global.p130v2.utils.CreditCardOmegaUtil;
import com.taxis99.R;
import java.util.HashMap;

/* renamed from: com.didi.payment.creditcard.global.v2.error.GuideSignErrorHandlerV2 */
public class GuideSignErrorHandlerV2 extends DefaultSignErrorHandlerV2 {
    public GuideSignErrorHandlerV2(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    /* access modifiers changed from: protected */
    public void createDialogButton(final SignResult signResult, NLEGODialogBuilder nLEGODialogBuilder) {
        final String string = this.mActivity.getString(R.string.one_payment_creditcard_global_sign_fail_enter_homepage);
        final String string2 = this.mActivity.getString(R.string.one_payment_creditcard_global_sign_fail_try_again);
        nLEGODialogBuilder.confirmAction(string, new DoubleCheckOnClickListener() {
            public void doClick(View view) {
                if (GuideSignErrorHandlerV2.this.mConfirmDialog != null) {
                    GuideSignErrorHandlerV2.this.mConfirmDialog.dismiss();
                }
                GuideSignErrorHandlerV2.this.mCallback.onResult(1, signResult);
                HashMap hashMap = new HashMap();
                hashMap.put(GlobalOmegaConstant.AddCardPage.EventKey.ERR_NO, Integer.valueOf(signResult.errNo));
                CreditCardOmegaUtil.Companion.errorCkTrace(Integer.valueOf(signResult.errNo), string, string2, "1");
                GlobalOmegaUtils.track(GuideSignErrorHandlerV2.this.mActivity, GlobalOmegaConstant.AddCardPage.EventId.GLOBAL_PAS_ORANGEBUTTON_CK, hashMap);
            }
        });
        nLEGODialogBuilder.negativeAction(string2, new DoubleCheckOnClickListener() {
            public void doClick(View view) {
                if (GuideSignErrorHandlerV2.this.mConfirmDialog != null) {
                    GuideSignErrorHandlerV2.this.mConfirmDialog.dismiss();
                }
                HashMap hashMap = new HashMap();
                hashMap.put(GlobalOmegaConstant.AddCardPage.EventKey.ERR_NO, Integer.valueOf(signResult.errNo));
                GlobalOmegaUtils.track(GuideSignErrorHandlerV2.this.mActivity, GlobalOmegaConstant.AddCardPage.EventId.GLOBAL_PAS_GRAYBUTTON_CK, hashMap);
                GuideSignErrorHandlerV2.this.mCallback.onResult(0, signResult);
                CreditCardOmegaUtil.Companion.errorCkTrace(Integer.valueOf(signResult.errNo), string, string2, "2");
            }
        });
        CreditCardOmegaUtil.Companion.errorShowTrace(Integer.valueOf(signResult.errNo), string, string2);
    }
}
