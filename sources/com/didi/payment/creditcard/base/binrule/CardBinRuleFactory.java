package com.didi.payment.creditcard.base.binrule;

import android.content.Context;
import android.text.TextUtils;

public class CardBinRuleFactory {

    /* renamed from: a */
    private static final String f30271a = "bin_collection_for_debit_card";

    /* renamed from: b */
    private static final String f30272b = "card_bin_check_mexico";

    /* renamed from: c */
    private static final String f30273c = "card_bin_check_china";

    public static ICardBinRule createCardBinRule(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return new MexicoCardBinRule(context, "");
        }
        char c = 65535;
        int hashCode = str.hashCode();
        if (hashCode != -1333691053) {
            if (hashCode != -467824391) {
                if (hashCode == 940404290 && str.equals(f30271a)) {
                    c = 0;
                }
            } else if (str.equals(f30273c)) {
                c = 2;
            }
        } else if (str.equals(f30272b)) {
            c = 1;
        }
        if (c == 0) {
            return new BrazilCardBinRule(context, str);
        }
        if (c == 1) {
            return new MexicoCardBinRule(context, str);
        }
        if (c != 2) {
            return new MexicoCardBinRule(context, str);
        }
        return new ChinaCardBinRule(context, str);
    }
}
