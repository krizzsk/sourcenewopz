package com.didi.sdk.sidebar.history.util;

import com.didi.sdk.sidebar.history.model.AbsHistoryOrder;
import com.didi.sdk.util.TextUtil;

public class HistoryUtils {
    public static boolean canInvoice(AbsHistoryOrder absHistoryOrder) {
        return absHistoryOrder != null && absHistoryOrder.allowSendInvoice == 1;
    }

    public static boolean emailFormatOk(String str) {
        int indexOf;
        if (TextUtil.isEmpty(str) || !str.contains("@") || (indexOf = str.indexOf(64)) == str.length() - 1 || indexOf == 0) {
            return false;
        }
        return true;
    }
}
