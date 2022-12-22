package com.didi.soda.customer.foundation.p164im;

import android.content.Context;
import com.didi.beatles.p099im.module.IMSessionUnreadCallback;
import com.didi.soda.customer.downgrade.CustomerDowngradeHelper;

/* renamed from: com.didi.soda.customer.foundation.im.ImMessageHelper */
public final class ImMessageHelper implements IIMInterface {
    public static final String IM_ROLE_MERCHANT = "merchant";
    public static final String IM_ROLE_RIDER = "rider";

    /* renamed from: a */
    private static ImMessageHelper f40913a;

    /* renamed from: b */
    private static IIMInterface f40914b;

    public static ImMessageHelper getInstance() {
        if (f40913a == null) {
            f40913a = new ImMessageHelper();
            if (CustomerDowngradeHelper.isDowngradeIM()) {
                f40914b = new IMDowngradeImp();
            } else {
                f40914b = new IMDefaultImp();
            }
        }
        return f40913a;
    }

    public void startChatDetailActivity(Context context, String str, String str2, String str3, String str4, int i, String str5, String str6) {
        f40914b.startChatDetailActivity(context, str, str2, str3, str4, i, str5, str6);
    }

    public void startChatActivity(Context context) {
        f40914b.startChatActivity(context);
    }

    public void closeSession(String str, String str2) {
        f40914b.closeSession(str, str2);
    }

    public long getSessionId(String str, String str2) {
        return f40914b.getSessionId(str, str2);
    }

    public void setRiderMessageUnreadCountListener(String str, String str2, IMSessionUnreadCallback iMSessionUnreadCallback) {
        f40914b.setRiderMessageUnreadCountListener(str, str2, iMSessionUnreadCallback);
    }

    public void getUnreadMessageCount(String str, String str2, IMSessionUnreadCallback iMSessionUnreadCallback) {
        f40914b.getUnreadMessageCount(str, str2, iMSessionUnreadCallback);
    }

    public void setMerchantMessageUnreadCountListener(String str, String str2, IMSessionUnreadCallback iMSessionUnreadCallback) {
        f40914b.setMerchantMessageUnreadCountListener(str, str2, iMSessionUnreadCallback);
    }

    public void setRiderCommonWords(Context context) {
        f40914b.setRiderCommonWords(context);
    }

    public void setMerchantCommonWords(Context context) {
        f40914b.setMerchantCommonWords(context);
    }

    public boolean shouldUseImMessage(String str) {
        return f40914b.shouldUseImMessage(str);
    }

    public void addUserCenterMessageListener() {
        f40914b.addUserCenterMessageListener();
    }

    public void fetchUnReadNum() {
        f40914b.fetchUnReadNum();
    }
}
