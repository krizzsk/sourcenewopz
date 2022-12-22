package com.didi.universal.pay.sdk.method.internal;

import android.content.Context;
import com.didi.universal.pay.sdk.method.balance.BalanceMethod;
import com.didi.universal.pay.sdk.method.bankPay.BankPayMethod;
import com.didi.universal.pay.sdk.method.change.ChangePayMethod;
import com.didi.universal.pay.sdk.method.model.PayParamObject;
import com.didi.universal.pay.sdk.method.nineninepay.NineNinePayMethod;
import com.didi.universal.pay.sdk.method.paypal.PaypalMethod;
import com.didi.universal.pay.sdk.method.paypay.PaypayMethod;
import com.didi.universal.pay.sdk.method.visa.VisaPayMethod;

public class PayMethodFactory {
    public static PayMethod getMethod(Context context, PayParamObject payParamObject) {
        int i = payParamObject.channelId;
        if (i == 126) {
            return new BalanceMethod(context);
        }
        if (i == 135) {
            return new BankPayMethod(context);
        }
        if (i != 150) {
            if (i == 152) {
                return new PaypalMethod(context);
            }
            if (i == 180) {
                return new ChangePayMethod(context);
            }
            if (i == 182) {
                return new PaypayMethod(context);
            }
            if (i == 190) {
                return new NineNinePayMethod(context);
            }
            if (i != 192) {
                return new InnerPayMethod(context);
            }
        }
        return new VisaPayMethod(context, i);
    }
}
