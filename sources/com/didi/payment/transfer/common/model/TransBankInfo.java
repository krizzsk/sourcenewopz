package com.didi.payment.transfer.common.model;

import com.didi.sdk.util.TextUtil;

public class TransBankInfo extends NameValuePair<String> implements Comparable<TransBankInfo> {
    public TransBankInfo(String str, String str2) {
        super(str, str2);
    }

    public String toString() {
        int length = !TextUtil.isEmpty((String) this.value) ? 3 - ((String) this.value).length() : 0;
        StringBuilder sb = new StringBuilder((String) this.value);
        if (length > 0) {
            for (int i = 0; i < length; i++) {
                sb.append(" ");
            }
        }
        sb.append("  ");
        sb.append(this.name);
        return sb.toString();
    }

    public int compareTo(TransBankInfo transBankInfo) {
        return this.name.compareToIgnoreCase(transBankInfo.name);
    }
}
