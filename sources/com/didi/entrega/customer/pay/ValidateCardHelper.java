package com.didi.entrega.customer.pay;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.didi.entrega.customer.app.GlobalContext;
import com.didi.entrega.customer.app.constant.AppConst;
import com.didi.payment.creditcard.open.DidiCreditCardFactory;
import com.didi.payment.creditcard.open.DidiGlobalVerifyCardData;

public class ValidateCardHelper {
    public static void validateCard(String str, String str2, int i) {
        DidiGlobalVerifyCardData.VerifyCardParam verifyCardParam = new DidiGlobalVerifyCardData.VerifyCardParam();
        verifyCardParam.cardIndex = str2;
        verifyCardParam.cardNo = str;
        verifyCardParam.productId = AppConst.BUSINESS_ID;
        if (GlobalContext.isEmbed()) {
            DidiCreditCardFactory.createGlobalCreditCardApi().startVerifyBalanceActivity((Fragment) GlobalContext.getFragment(), i, verifyCardParam);
        } else {
            DidiCreditCardFactory.createGlobalCreditCardApi().startVerifyBalanceActivity((FragmentActivity) GlobalContext.getContext(), i, verifyCardParam);
        }
    }
}
