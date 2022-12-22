package com.didi.unifylogin.utils.autologin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.didi.sdk.p154ms.common.ICollector;
import com.didi.sdk.p154ms.common.utils.ServiceUtil;
import com.didi.unifylogin.utils.LoginLog;

public class SmsReceiver extends BroadcastReceiver {
    public static final String TAG = "SmsReceiver";

    /* renamed from: a */
    private SmsReceiverListener f44949a;

    /* renamed from: b */
    private ICollector f44950b = ((ICollector) ServiceUtil.getServiceImp(ICollector.class));

    public interface SmsReceiverListener {
        void handleSmsCode(String str);
    }

    public void setListener(SmsReceiverListener smsReceiverListener) {
        this.f44949a = smsReceiverListener;
    }

    public void onReceive(Context context, Intent intent) {
        ICollector iCollector = this.f44950b;
        if (iCollector != null && !TextUtils.isEmpty(iCollector.getSmsReceiverAction()) && this.f44950b.getSmsReceiverAction().equals(intent.getAction())) {
            LoginLog.write(TAG, "onReceive:" + this.f44950b.getSmsReceiverAction());
            int statusCode = this.f44950b.getStatusCode(intent);
            if (this.f44950b.isStatusCodeSuccess(statusCode)) {
                if (this.f44949a != null) {
                    String smsMessage = this.f44950b.getSmsMessage(intent);
                    LoginLog.write("SmsReceiveronReceive: " + smsMessage);
                    this.f44949a.handleSmsCode(CodeMatcher.getCode(smsMessage));
                }
            } else if (this.f44950b.isStatusCodeTimeout(statusCode)) {
                LoginLog.write(TAG, "onReceive: TIMEOUT");
            }
        }
    }
}
