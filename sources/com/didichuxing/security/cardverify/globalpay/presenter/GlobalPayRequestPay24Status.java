package com.didichuxing.security.cardverify.globalpay.presenter;

import android.content.Context;
import android.text.TextUtils;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import com.didichuxing.security.cardverify.DiCardVerifyCallback;
import com.didichuxing.security.cardverify.DiCardVerifyParam;
import com.didichuxing.security.cardverify.constant.Server;
import com.didichuxing.security.cardverify.globalpay.activity.GlobalPayCardVerificationActivity;
import com.didichuxing.security.cardverify.globalpay.activity.GlobalPayLoading;
import com.didichuxing.security.cardverify.globalpay.activity.GlobalRandomPayConfirmActivity;
import com.didichuxing.security.cardverify.model.CardVerifyInfo;
import com.didichuxing.security.cardverify.model.RandomPayStatusService;
import com.didichuxing.security.cardverify.model.bean.WithdrawPageInfo;
import com.didichuxing.security.cardverify.report.DiCardVerifyTracker;
import com.didichuxing.security.cardverify.utils.ParamUtils;
import java.io.IOException;
import java.util.HashMap;

public class GlobalPayRequestPay24Status {
    public static void requestWithdrawInfo(final Context context, final DiCardVerifyParam diCardVerifyParam, final DiCardVerifyCallback diCardVerifyCallback) {
        GlobalPayLoading.show(context);
        m35104a(context, diCardVerifyParam, (RpcService.Callback<WithdrawPageInfo>) new RpcService.Callback<WithdrawPageInfo>() {
            public void onSuccess(WithdrawPageInfo withdrawPageInfo) {
                GlobalPayLoading.hide();
                if (withdrawPageInfo == null || withdrawPageInfo.content == null) {
                    GlobalPayRequestPay24Status.m35108b(diCardVerifyCallback, 6, "service exception");
                    return;
                }
                int i = withdrawPageInfo.content.code;
                String str = withdrawPageInfo.content.frontMsg;
                if (i == 100003) {
                    GlobalPayRequestPay24Status.m35107b(context, diCardVerifyParam, diCardVerifyCallback, str, (withdrawPageInfo.content.extendResultList == null || withdrawPageInfo.content.extendResultList.size() <= 0) ? null : withdrawPageInfo.content.extendResultList.get(0));
                } else if (i == 100001) {
                    GlobalPayRequestPay24Status.m35108b(diCardVerifyCallback, 1, "payment not finish");
                } else if (i == 100002) {
                    GlobalPayRequestPay24Status.startRandomPayActivity(context, diCardVerifyParam, str, diCardVerifyCallback);
                } else {
                    GlobalPayRequestPay24Status.m35108b(diCardVerifyCallback, 6, "service exception");
                }
            }

            public void onFailure(IOException iOException) {
                GlobalPayLoading.hide();
                GlobalPayRequestPay24Status.m35108b(diCardVerifyCallback, 7, "net exception");
            }
        });
    }

    /* renamed from: a */
    private static void m35104a(Context context, DiCardVerifyParam diCardVerifyParam, RpcService.Callback<WithdrawPageInfo> callback) {
        HashMap hashMap = new HashMap();
        ParamUtils.addCommonParam(diCardVerifyParam, hashMap);
        ((RandomPayStatusService) new RpcServiceFactory(context).newRpcService(RandomPayStatusService.class, Server.GLOBAL_SEC_HOST)).requestWithdrawInfo(hashMap, callback);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m35107b(Context context, DiCardVerifyParam diCardVerifyParam, DiCardVerifyCallback diCardVerifyCallback, String str, WithdrawPageInfo.ExtendContent extendContent) {
        String a = m35103a(str, diCardVerifyParam.getCardNo());
        CardVerifyInfo cardVerifyInfo = new CardVerifyInfo();
        cardVerifyInfo.pageContent = a;
        if (extendContent != null) {
            cardVerifyInfo.currencyText = extendContent.currency;
            boolean z = false;
            cardVerifyInfo.isShowDecimal = extendContent.isDecimal == 1;
            if (extendContent.isSuffix == 1) {
                z = true;
            }
            cardVerifyInfo.isCurrencySuffix = z;
            cardVerifyInfo.defaultText = extendContent.defaultText;
        }
        DiCardVerifyTracker.trackVerify(2);
        GlobalPayCardVerificationActivity.startActivity(context, diCardVerifyParam, cardVerifyInfo, diCardVerifyCallback);
    }

    /* renamed from: a */
    private static String m35103a(String str, String str2) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str2.length() < 4) ? str : str.replaceAll("[*][*][*][*]", str2.substring(str2.length() - 4, str2.length()));
    }

    public static void startRandomPayActivity(Context context, DiCardVerifyParam diCardVerifyParam, String str, DiCardVerifyCallback diCardVerifyCallback) {
        GlobalRandomPayConfirmActivity.start(context, diCardVerifyParam, str, diCardVerifyCallback);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m35108b(DiCardVerifyCallback diCardVerifyCallback, int i, String str) {
        if (diCardVerifyCallback != null) {
            diCardVerifyCallback.onCallback(i, str);
        }
    }
}
