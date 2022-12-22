package com.didi.soda.customer.foundation.p164im;

import android.content.Context;
import com.didi.beatles.p099im.module.IMSessionUnreadCallback;

/* renamed from: com.didi.soda.customer.foundation.im.IIMInterface */
public interface IIMInterface {
    void addUserCenterMessageListener();

    void closeSession(String str, String str2);

    void fetchUnReadNum();

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
