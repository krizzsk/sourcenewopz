package com.didi.soda.customer.foundation.p164im;

import android.content.Context;
import com.didi.beatles.p099im.module.IMSessionUnreadCallback;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.foundation.util.ToastUtil;
import com.taxis99.R;

/* renamed from: com.didi.soda.customer.foundation.im.IMDowngradeImp */
public class IMDowngradeImp implements IIMInterface {

    /* renamed from: a */
    private static final String f40912a = "IMDowngradeImp";

    public void startChatDetailActivity(Context context, String str, String str2, String str3, String str4, int i, String str5, String str6) {
        m29078a("startChatDetailActivity");
    }

    public void startChatActivity(Context context) {
        m29078a("startChatActivity");
    }

    public void closeSession(String str, String str2) {
        LogUtil.m29104i(f40912a, "share down grade closeSession");
    }

    public long getSessionId(String str, String str2) {
        LogUtil.m29104i(f40912a, "share down grade getSessionId");
        return 0;
    }

    public void setRiderMessageUnreadCountListener(String str, String str2, IMSessionUnreadCallback iMSessionUnreadCallback) {
        LogUtil.m29104i(f40912a, "share down grade setRiderMessageUnreadCountListener");
    }

    public void getUnreadMessageCount(String str, String str2, IMSessionUnreadCallback iMSessionUnreadCallback) {
        LogUtil.m29104i(f40912a, "share down grade getUnreadMessageCount");
    }

    public void setMerchantMessageUnreadCountListener(String str, String str2, IMSessionUnreadCallback iMSessionUnreadCallback) {
        LogUtil.m29104i(f40912a, "share down grade setMerchantMessageUnreadCountListener");
    }

    public void setRiderCommonWords(Context context) {
        LogUtil.m29104i(f40912a, "share down grade setRiderCommonWords");
    }

    public void setMerchantCommonWords(Context context) {
        LogUtil.m29104i(f40912a, "share down grade setMerchantCommonWords ");
    }

    public boolean shouldUseImMessage(String str) {
        LogUtil.m29104i(f40912a, "share down grade shouldUseImMessage");
        return false;
    }

    public void addUserCenterMessageListener() {
        LogUtil.m29104i(f40912a, "share down grade addUserCenterMessageListener");
    }

    public void fetchUnReadNum() {
        LogUtil.m29104i(f40912a, "share down grade fetchUnReadNum");
    }

    /* renamed from: a */
    private void m29078a(String str) {
        ToastUtil.makeText(ResourceHelper.getString(R.string.FoodC_downgrade_tip_im));
        LogUtil.m29104i(f40912a, "share down grade = " + str);
    }
}
