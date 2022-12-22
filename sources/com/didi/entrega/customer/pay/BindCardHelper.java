package com.didi.entrega.customer.pay;

import androidx.fragment.app.Fragment;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.entrega.customer.app.GlobalContext;
import com.didi.entrega.customer.foundation.util.DialogUtil;
import com.didi.payment.creditcard.open.DidiCreditCardFactory;
import com.didi.payment.creditcard.open.DidiGlobalAddCardData;
import com.didi.payment.paymethod.open.DidiSignFactory;
import com.didi.payment.paymethod.open.callback.SignCallback;
import com.didi.payment.paymethod.open.param.SignParam;

public final class BindCardHelper {
    public static final int ADD_CARD_REQUEST_CODE = 1;

    private BindCardHelper() {
    }

    public static void bindCard(DidiGlobalAddCardData.AddCardParam addCardParam, int i) {
        DidiCreditCardFactory.createGlobalCreditCardApi().startAddCreditCardActivity((Fragment) GlobalContext.getFragment(), i, addCardParam);
    }

    public static void bindPayPay(ScopeContext scopeContext, SignParam signParam, final SignCallback signCallback) {
        if (scopeContext != null) {
            DialogUtil.showLoadingDialog(scopeContext, false);
        }
        DidiSignFactory.createSignApi().sign((Fragment) GlobalContext.getFragment(), signParam, (SignCallback) new SignCallback() {
            public void onPullStart() {
                SignCallback.this.onPullStart();
            }

            public void onResult(int i, String str, String str2) {
                SignCallback.this.onResult(i, str, str2);
                DialogUtil.hideLoadingDialog();
            }
        });
    }
}
