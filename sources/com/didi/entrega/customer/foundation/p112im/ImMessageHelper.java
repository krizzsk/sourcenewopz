package com.didi.entrega.customer.foundation.p112im;

import android.content.Context;
import com.didi.beatles.p099im.module.IMSessionUnreadCallback;

/* renamed from: com.didi.entrega.customer.foundation.im.ImMessageHelper */
public final class ImMessageHelper implements IIMInterface {
    public static final String IM_ROLE_MERCHANT = "merchant";
    public static final String IM_ROLE_RIDER = "rider";

    /* renamed from: a */
    private static ImMessageHelper f19906a;

    /* renamed from: b */
    private static IIMInterface f19907b;

    public static ImMessageHelper getInstance() {
        if (f19906a == null) {
            f19906a = new ImMessageHelper();
            f19907b = new IMDefaultImp();
        }
        return f19906a;
    }

    public void startChatDetailActivity(Context context, String str, String str2, String str3, String str4, int i, String str5, String str6) {
        f19907b.startChatDetailActivity(context, str, str2, str3, str4, i, str5, str6);
    }

    public void startChatActivity(Context context) {
        f19907b.startChatActivity(context);
    }

    public void closeSession(String str, String str2) {
        f19907b.closeSession(str, str2);
    }

    public long getSessionId(String str, String str2) {
        return f19907b.getSessionId(str, str2);
    }

    public void setRiderMessageUnreadCountListener(String str, String str2, IMSessionUnreadCallback iMSessionUnreadCallback) {
        f19907b.setRiderMessageUnreadCountListener(str, str2, iMSessionUnreadCallback);
    }

    public void getUnreadMessageCount(String str, String str2, IMSessionUnreadCallback iMSessionUnreadCallback) {
        f19907b.getUnreadMessageCount(str, str2, iMSessionUnreadCallback);
    }

    public void setMerchantMessageUnreadCountListener(String str, String str2, IMSessionUnreadCallback iMSessionUnreadCallback) {
        f19907b.setMerchantMessageUnreadCountListener(str, str2, iMSessionUnreadCallback);
    }

    public void setRiderCommonWords(Context context) {
        f19907b.setRiderCommonWords(context);
    }

    public void setMerchantCommonWords(Context context) {
        f19907b.setMerchantCommonWords(context);
    }

    public boolean shouldUseImMessage(String str) {
        return f19907b.shouldUseImMessage(str);
    }
}
