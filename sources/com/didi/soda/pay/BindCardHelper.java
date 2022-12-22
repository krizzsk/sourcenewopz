package com.didi.soda.pay;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.payment.creditcard.open.DidiCreditCardFactory;
import com.didi.payment.creditcard.open.DidiGlobalAddCardData;
import com.didi.payment.paymethod.open.DidiSignFactory;
import com.didi.payment.paymethod.open.callback.SignCallback;
import com.didi.payment.paymethod.open.param.SignParam;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.foundation.util.DialogUtil;

public final class BindCardHelper {
    public static final int ADD_CARD_REQUEST_CODE = 1;

    private BindCardHelper() {
    }

    public static void bindCard(DidiGlobalAddCardData.AddCardParam addCardParam, int i) {
        if (GlobalContext.isEmbed()) {
            DidiCreditCardFactory.createGlobalCreditCardApi().startAddCreditCardActivity((Fragment) GlobalContext.getFragment(), i, addCardParam);
        } else {
            DidiCreditCardFactory.createGlobalCreditCardApi().startAddCreditCardActivity((Activity) (FragmentActivity) GlobalContext.getContext(), i, addCardParam);
        }
    }

    public static void bindPayPay(ScopeContext scopeContext, SignParam signParam, final SignCallback signCallback) {
        if (scopeContext != null) {
            DialogUtil.showLoadingDialog(scopeContext, false);
        }
        C141591 r1 = new SignCallback() {
            public void onPullStart() {
                SignCallback.this.onPullStart();
            }

            public void onResult(int i, String str, String str2) {
                SignCallback.this.onResult(i, str, str2);
                DialogUtil.hideLoadingDialog();
            }
        };
        if (GlobalContext.isEmbed()) {
            DidiSignFactory.createSignApi().sign((Fragment) GlobalContext.getFragment(), signParam, (SignCallback) r1);
        } else {
            DidiSignFactory.createSignApi().sign((Activity) (FragmentActivity) GlobalContext.getContext(), signParam, (SignCallback) r1);
        }
    }
}
