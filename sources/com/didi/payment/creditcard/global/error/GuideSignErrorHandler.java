package com.didi.payment.creditcard.global.error;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.didi.payment.base.dialog.GlobalAlertDialog;
import com.didi.payment.creditcard.global.model.bean.SignResult;
import com.didi.payment.creditcard.global.omega.GlobalOmegaConstant;
import com.didi.payment.creditcard.global.omega.GlobalOmegaUtils;
import com.didi.payment.creditcard.global.p130v2.utils.CreditCardOmegaUtil;
import com.taxis99.R;
import java.util.HashMap;
import java.util.List;

public class GuideSignErrorHandler extends DefaultSignErrorHandler {
    public GuideSignErrorHandler(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    /* access modifiers changed from: protected */
    public void createDialogButton(final SignResult signResult, List<String> list, List<GlobalAlertDialog.OnBtnClickListener> list2) {
        final String string = this.mActivity.getString(R.string.one_payment_creditcard_global_sign_fail_enter_homepage);
        final String string2 = this.mActivity.getString(R.string.one_payment_creditcard_global_sign_fail_try_again);
        list.add(string);
        list2.add(new GlobalAlertDialog.OnBtnClickListener() {
            public void onBtnClick(DialogFragment dialogFragment, int i) {
                dialogFragment.dismissAllowingStateLoss();
                GuideSignErrorHandler.this.mCallback.onResult(1, signResult);
                HashMap hashMap = new HashMap();
                hashMap.put(GlobalOmegaConstant.AddCardPage.EventKey.ERR_NO, Integer.valueOf(signResult.errNo));
                GlobalOmegaUtils.track(GuideSignErrorHandler.this.mActivity, GlobalOmegaConstant.AddCardPage.EventId.GLOBAL_PAS_ORANGEBUTTON_CK, hashMap);
                CreditCardOmegaUtil.Companion.errorCkTrace(Integer.valueOf(signResult.errNo), string, string2, "1");
            }
        });
        list.add(string2);
        list2.add(new GlobalAlertDialog.OnBtnClickListener() {
            public void onBtnClick(DialogFragment dialogFragment, int i) {
                dialogFragment.dismissAllowingStateLoss();
                GuideSignErrorHandler.this.mCallback.onResult(0, signResult);
                HashMap hashMap = new HashMap();
                hashMap.put(GlobalOmegaConstant.AddCardPage.EventKey.ERR_NO, Integer.valueOf(signResult.errNo));
                GlobalOmegaUtils.track(GuideSignErrorHandler.this.mActivity, GlobalOmegaConstant.AddCardPage.EventId.GLOBAL_PAS_GRAYBUTTON_CK, hashMap);
                CreditCardOmegaUtil.Companion.errorCkTrace(Integer.valueOf(signResult.errNo), string, string2, "2");
            }
        });
        CreditCardOmegaUtil.Companion.errorShowTrace(Integer.valueOf(signResult.errNo), string, string2);
    }
}
