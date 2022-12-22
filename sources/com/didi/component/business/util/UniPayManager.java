package com.didi.component.business.util;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.didi.beatles.p099im.utils.UiThreadHandler;
import com.didi.component.business.web.GlobalWebUrl;
import com.didi.component.common.util.GLog;
import com.didi.sdk.push.manager.DPushBody;
import com.didi.sdk.push.manager.DPushListener;
import com.didi.sdk.push.manager.DPushManager;
import com.didi.sdk.push.manager.DPushType;
import com.didi.sdk.webview.BaseWebActivity;
import com.didi.unifiedPay.component.presenter.AbsPaymentPresenter;
import com.didi.unifiedPay.sdk.model.PushMessage;
import com.didi.unifiedPay.sdk.proto.UnifiedCashierMessage;
import com.squareup.wire.Wire;
import java.util.List;

public class UniPayManager {
    public static final String EXTRA_PAGE = "EXTRA_PAGE";

    /* renamed from: a */
    private static final String f11398a = "PaymentManager";

    /* renamed from: b */
    private DPushListener f11399b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public String f11400c;

    public void registerPushListener(final Context context, String str) {
        this.f11400c = str;
        this.f11399b = new DPushListener() {
            public String topic() {
                return "2304";
            }

            public DPushType pushType() {
                return DPushType.TENCENT_PUSH;
            }

            public void pushBody(DPushBody dPushBody) {
                if (dPushBody == null || dPushBody.getData() == null) {
                    GLog.m7965d(UniPayManager.f11398a, "no data received");
                    return;
                }
                try {
                    final UnifiedCashierMessage unifiedCashierMessage = (UnifiedCashierMessage) new Wire((Class<?>[]) new Class[0]).parseFrom(dPushBody.getData(), UnifiedCashierMessage.class);
                    UiThreadHandler.post(new Runnable() {
                        public void run() {
                            Intent intent = new Intent();
                            intent.setAction(AbsPaymentPresenter.ACTION_PAY_PUSH_MESSAGE);
                            PushMessage pushMessage = new PushMessage();
                            pushMessage.code = ((Integer) Wire.get(unifiedCashierMessage.code, UnifiedCashierMessage.DEFAULT_CODE)).intValue();
                            pushMessage.msg = (String) Wire.get(unifiedCashierMessage.msg, "");
                            pushMessage.data = (String) Wire.get(unifiedCashierMessage.data, "");
                            pushMessage.oid = (String) Wire.get(unifiedCashierMessage.oid, "");
                            pushMessage.productId = (String) Wire.get(unifiedCashierMessage.product_id, "");
                            GLog.m7965d(UniPayManager.f11398a, "push message : " + pushMessage.toString());
                            intent.putExtra(AbsPaymentPresenter.EXTRA_PAY_PUSH_MESSAGE, pushMessage);
                            intent.putExtra(UniPayManager.EXTRA_PAGE, UniPayManager.this.f11400c);
                            LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                    GLog.m7965d(UniPayManager.f11398a, "data parse error");
                }
            }
        };
        DPushManager.getInstance().registerPush(this.f11399b);
    }

    public void unregisterPushListener() {
        this.f11400c = "";
        if (this.f11399b != null) {
            DPushManager.getInstance().unregisterPush(this.f11399b);
        }
    }

    @Deprecated
    public static void gotoWeb(Context context, Intent intent) {
        if (intent != null && intent.getClass() == null) {
            intent.setClass(context, BaseWebActivity.class);
        }
        context.startActivity(intent);
    }

    @Deprecated
    public static void gotoWeb(Context context, String str) {
        if (context != null) {
            Intent intent = new Intent(context, BaseWebActivity.class);
            intent.putExtra("web_view_model", GlobalWebUrl.buildWebViewModel(str));
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }

    public static String getPackageName(Context context) {
        int myPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null || runningAppProcesses.size() <= 0) {
            return "";
        }
        for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
            if (next.pid == myPid) {
                return next.processName;
            }
        }
        return "";
    }

    /* renamed from: a */
    private String m7727a(String str) {
        char[] charArray = str.toCharArray();
        char[] cArr = new char[charArray.length];
        int i = 0;
        for (int i2 = 0; i2 < charArray.length; i2++) {
            if (charArray[i2] > 31 && charArray[i2] < 127) {
                cArr[i] = charArray[i2];
                i++;
            }
        }
        return new String(cArr, 0, i);
    }
}
