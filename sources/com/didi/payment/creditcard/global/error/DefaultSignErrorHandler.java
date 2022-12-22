package com.didi.payment.creditcard.global.error;

import android.text.TextUtils;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.didi.payment.base.dialog.GlobalAlertDialog;
import com.didi.payment.creditcard.global.error.ISignErrorHandler;
import com.didi.payment.creditcard.global.model.bean.SignResult;
import com.didi.payment.creditcard.global.omega.GlobalOmegaConstant;
import com.didi.payment.creditcard.global.omega.GlobalOmegaUtils;
import com.didi.payment.creditcard.global.p130v2.utils.CreditCardOmegaUtil;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DefaultSignErrorHandler implements ISignErrorHandler {
    protected final FragmentActivity mActivity;
    protected ISignErrorHandler.Callback mCallback;

    public DefaultSignErrorHandler(FragmentActivity fragmentActivity) {
        this.mActivity = fragmentActivity;
    }

    public void setCallback(ISignErrorHandler.Callback callback) {
        this.mCallback = callback;
    }

    public void handleError(SignResult signResult) {
        if (this.mActivity != null && this.mCallback != null && signResult != null) {
            GlobalAlertDialog globalAlertDialog = new GlobalAlertDialog();
            globalAlertDialog.setTitle(this.mActivity.getString(R.string.one_payment_creditcard_global_sign_fail_title));
            globalAlertDialog.setMsg(signResult.errMsg);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            createDialogButton(signResult, arrayList, arrayList2);
            globalAlertDialog.setButtons(arrayList);
            globalAlertDialog.setListeners(arrayList2);
            globalAlertDialog.show(this.mActivity.getSupportFragmentManager(), "signFail");
        }
    }

    /* access modifiers changed from: protected */
    public void createDialogButton(final SignResult signResult, List<String> list, List<GlobalAlertDialog.OnBtnClickListener> list2) {
        final int i;
        final String str;
        final String str2 = "";
        switch (signResult.errNo) {
            case 16100:
            case 16107:
                str = this.mActivity.getString(R.string.one_payment_creditcard_global_sign_fail_got_it);
                break;
            case 16101:
            case 16102:
            case 16103:
                str = this.mActivity.getString(R.string.one_payment_creditcard_global_sign_fail_try_another_card);
                str2 = this.mActivity.getString(R.string.one_payment_creditcard_global_sign_fail_try_again);
                i = 2;
                break;
            case 16104:
            case 16105:
            case 16106:
                str = this.mActivity.getString(R.string.one_payment_creditcard_global_sign_fail_try_again);
                i = 3;
                break;
            case 16108:
                str = this.mActivity.getString(R.string.one_payment_creditcard_global_sign_fail_help);
                str2 = this.mActivity.getString(R.string.one_payment_creditcard_global_sign_fail_not_now);
                i = 4;
                break;
            default:
                str = this.mActivity.getString(R.string.one_payment_creditcard_global_sign_fail_got_it);
                break;
        }
        i = 5;
        list.add(str);
        final SignResult signResult2 = signResult;
        final String str3 = str;
        final String str4 = str2;
        list2.add(new GlobalAlertDialog.OnBtnClickListener() {
            public void onBtnClick(DialogFragment dialogFragment, int i) {
                HashMap hashMap = new HashMap();
                hashMap.put(GlobalOmegaConstant.AddCardPage.EventKey.ERR_NO, Integer.valueOf(signResult2.errNo));
                GlobalOmegaUtils.track(DefaultSignErrorHandler.this.mActivity, GlobalOmegaConstant.AddCardPage.EventId.GLOBAL_PAS_ORANGEBUTTON_CK, hashMap);
                dialogFragment.dismissAllowingStateLoss();
                DefaultSignErrorHandler.this.mCallback.onResult(i, signResult2);
                CreditCardOmegaUtil.Companion.errorCkTrace(Integer.valueOf(signResult2.errNo), str3, str4, "1");
            }
        });
        if (!TextUtils.isEmpty(str2)) {
            list.add(str2);
            list2.add(new GlobalAlertDialog.OnBtnClickListener() {
                public void onBtnClick(DialogFragment dialogFragment, int i) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(GlobalOmegaConstant.AddCardPage.EventKey.ERR_NO, Integer.valueOf(signResult.errNo));
                    GlobalOmegaUtils.track(DefaultSignErrorHandler.this.mActivity, GlobalOmegaConstant.AddCardPage.EventId.GLOBAL_PAS_GRAYBUTTON_CK, hashMap);
                    dialogFragment.dismissAllowingStateLoss();
                    DefaultSignErrorHandler.this.mCallback.onResult(0, signResult);
                    CreditCardOmegaUtil.Companion.errorCkTrace(Integer.valueOf(signResult.errNo), str, str2, "2");
                }
            });
        }
        CreditCardOmegaUtil.Companion.errorShowTrace(Integer.valueOf(signResult.errNo), str, str2);
    }
}
