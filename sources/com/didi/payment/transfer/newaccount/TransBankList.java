package com.didi.payment.transfer.newaccount;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public class TransBankList {
    public List<BankInfo> fullBankList = new ArrayList();
    public List<BankInfo> topFiveBank = new ArrayList();

    public static class BankInfo {
        public String code;
        public String name;

        public String toString4Biz() {
            return this.name + " " + this.code;
        }
    }

    public BankInfo getBankByName(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (BankInfo next : this.topFiveBank) {
            if (str.equalsIgnoreCase(next.name)) {
                return next;
            }
        }
        for (BankInfo next2 : this.fullBankList) {
            if (str.equalsIgnoreCase(next2.name)) {
                return next2;
            }
        }
        return null;
    }
}
