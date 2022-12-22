package com.didichuxing.security.cardverify.presenter;

import android.content.Context;
import android.text.TextUtils;
import com.didi.global.globaluikit.toast.LEGOToastHelper;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import com.didichuxing.security.cardverify.DiCardVerifyCallback;
import com.didichuxing.security.cardverify.DiCardVerifyParam;
import com.didichuxing.security.cardverify.activity.CardVerificationActivity;
import com.didichuxing.security.cardverify.activity.RandomPayTransActivity;
import com.didichuxing.security.cardverify.constant.Server;
import com.didichuxing.security.cardverify.model.CardVerifyInfo;
import com.didichuxing.security.cardverify.model.RandomPayStatusService;
import com.didichuxing.security.cardverify.model.bean.WithdrawPageInfo;
import com.didichuxing.security.cardverify.report.DiCardVerifyTracker;
import com.didichuxing.security.cardverify.utils.ParamUtils;
import com.taxis99.R;
import java.io.IOException;
import java.util.HashMap;

public class RequestPay24Status {
    public static void requestWithdrawInfo(final Context context, final DiCardVerifyParam diCardVerifyParam, final DiCardVerifyCallback diCardVerifyCallback) {
        m35134a(context, diCardVerifyParam, (RpcService.Callback<WithdrawPageInfo>) new RpcService.Callback<WithdrawPageInfo>() {
            public void onSuccess(WithdrawPageInfo withdrawPageInfo) {
                RequestPay24Status.m35140b(diCardVerifyCallback, 1, "request 24h pay status success");
                if (withdrawPageInfo == null || withdrawPageInfo.content == null) {
                    Context context = context;
                    RequestPay24Status.m35139b(context, context.getString(R.string.didi_security_card_verify_net_serverbusy));
                    return;
                }
                int i = withdrawPageInfo.content.code;
                String str = withdrawPageInfo.content.frontMsg;
                if (i == 100003) {
                    RequestPay24Status.m35138b(context, diCardVerifyParam, diCardVerifyCallback, str, (withdrawPageInfo.content.extendResultList == null || withdrawPageInfo.content.extendResultList.size() <= 0) ? null : withdrawPageInfo.content.extendResultList.get(0));
                } else if (i == 100001) {
                    RequestPay24Status.m35139b(context, str);
                } else if (i == 100002) {
                    RequestPay24Status.startRandomPayActivity(context, diCardVerifyParam, str, diCardVerifyCallback);
                } else {
                    Context context2 = context;
                    RequestPay24Status.m35139b(context2, context2.getString(R.string.didi_security_card_verify_net_serverbusy));
                }
            }

            public void onFailure(IOException iOException) {
                RequestPay24Status.m35140b(diCardVerifyCallback, 1, "request 24h pay status exception");
                Context context = context;
                RequestPay24Status.m35139b(context, context.getString(R.string.didi_security_card_verify_net_connerror));
            }
        });
    }

    /* renamed from: a */
    private static void m35134a(Context context, DiCardVerifyParam diCardVerifyParam, RpcService.Callback<WithdrawPageInfo> callback) {
        HashMap hashMap = new HashMap();
        ParamUtils.addCommonParam(diCardVerifyParam, hashMap);
        ((RandomPayStatusService) new RpcServiceFactory(context).newRpcService(RandomPayStatusService.class, Server.GLOBAL_SEC_HOST)).requestWithdrawInfo(hashMap, callback);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m35138b(Context context, DiCardVerifyParam diCardVerifyParam, DiCardVerifyCallback diCardVerifyCallback, String str, WithdrawPageInfo.ExtendContent extendContent) {
        String a = m35133a(str, diCardVerifyParam.getCardNo());
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
        CardVerificationActivity.startActivity(context, diCardVerifyParam, cardVerifyInfo, diCardVerifyCallback);
    }

    /* renamed from: a */
    private static String m35133a(String str, String str2) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str2.length() < 4) ? str : str.replaceAll("[*][*][*][*]", str2.substring(str2.length() - 4, str2.length()));
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m35139b(Context context, String str) {
        LEGOToastHelper.showShortNagToast(context, str);
    }

    public static void startRandomPayActivity(Context context, DiCardVerifyParam diCardVerifyParam, String str, DiCardVerifyCallback diCardVerifyCallback) {
        RandomPayTransActivity.start(context, diCardVerifyParam, str, diCardVerifyCallback);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m35140b(DiCardVerifyCallback diCardVerifyCallback, int i, String str) {
        if (diCardVerifyCallback != null) {
            diCardVerifyCallback.onCallback(i, str);
        }
    }
}
