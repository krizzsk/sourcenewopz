package com.didi.payment.paymethod.sign.channel.impl;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.didi.payment.creditcard.open.DidiCreditCardFactory;
import com.didi.payment.paymethod.open.callback.SignCallback;
import com.didi.payment.paymethod.open.param.SignParam;
import com.didi.payment.paymethod.sign.channel.ISignChannel;

public class CreditCardImpl extends BasePayImpl implements ISignChannel {
    public void onActivityResume() {
    }

    public CreditCardImpl(Context context) {
        super(context);
        CHANNEL_ID = 150;
    }

    public CreditCardImpl(Context context, int i) {
        super(context);
        CHANNEL_ID = i;
    }

    public void sign(Fragment fragment, SignParam signParam, SignCallback signCallback) {
        this.signCallback = signCallback;
        if (signParam.globalCreditCardParam != null) {
            DidiCreditCardFactory.createGlobalCreditCardApi().startAddCreditCardActivity(fragment, CHANNEL_ID, signParam.globalCreditCardParam);
        }
    }

    public void onActivityResult(int i) {
        if (i == -1) {
            onSignResult(0, "");
        } else {
            onSignResult(-2, "");
        }
    }
}
