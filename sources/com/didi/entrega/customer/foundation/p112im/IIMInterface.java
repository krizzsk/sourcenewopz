package com.didi.entrega.customer.foundation.p112im;

import android.content.Context;
import com.didi.beatles.p099im.module.IMSessionUnreadCallback;

/* renamed from: com.didi.entrega.customer.foundation.im.IIMInterface */
public interface IIMInterface {
    void closeSession(String str, String str2);

    long getSessionId(String str, String str2);

    void getUnreadMessageCount(String str, String str2, IMSessionUnreadCallback iMSessionUnreadCallback);

    void setMerchantCommonWords(Context context);

    void setMerchantMessageUnreadCountListener(String str, String str2, IMSessionUnreadCallback iMSessionUnreadCallback);

    void setRiderCommonWords(Context context);

    void setRiderMessageUnreadCountListener(String str, String str2, IMSessionUnreadCallback iMSessionUnreadCallback);

    boolean shouldUseImMessage(String str);

    void startChatActivity(Context context);

    void startChatDetailActivity(Context context, String str, String str2, String str3, String str4, int i, String str5, String str6);
}
