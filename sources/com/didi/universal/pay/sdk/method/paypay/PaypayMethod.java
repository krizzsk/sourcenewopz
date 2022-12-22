package com.didi.universal.pay.sdk.method.paypay;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.text.TextUtils;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.didi.universal.pay.sdk.method.internal.PayMethod;
import com.didi.universal.pay.sdk.method.model.PayPayModel;
import com.didi.universal.pay.sdk.method.model.PrepayInfo;
import com.didi.universal.pay.sdk.util.DeviceUtil;
import com.didi.universal.pay.sdk.util.LogUtil;
import java.net.URLDecoder;

public class PaypayMethod extends PayMethod {
    public static final String PAYPAYPOLLACTION = "com.xiaojukeji.action.paypayPollAction";
    /* access modifiers changed from: private */
    public BroadcastReceiver resultPollBR = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            LocalBroadcastManager.getInstance(PaypayMethod.this.mContext).unregisterReceiver(PaypayMethod.this.resultPollBR);
            if (intent.getExtras() != null && intent.getExtras().getInt("code", 0) == 1 && PaypayMethod.this.mCallBack != null) {
                PaypayMethod.this.mCallBack.onComplete();
                PaypayMethod.this.mCallBack.startPoll();
            }
        }
    };

    public int getChannelID() {
        return 182;
    }

    public int getRequestCodeForSign() {
        return 0;
    }

    public PaypayMethod(Context context) {
        super(context);
    }

    public <T> boolean checkDataValid(T t) {
        return ((PrepayInfo) t) != null;
    }

    public <T> boolean checkPaySupport(T t) {
        PayPayModel payPayModel;
        if (!(t instanceof PrepayInfo) || (payPayModel = ((PrepayInfo) t).paypayParams) == null || TextUtils.isEmpty(payPayModel.appPayString) || !DeviceUtil.isSchemeSupport(this.mContext, payPayModel.appPayString)) {
            return false;
        }
        return true;
    }

    public void dopay(PrepayInfo prepayInfo) {
        if (prepayInfo != null && prepayInfo.paypayParams != null && !TextUtils.isEmpty(prepayInfo.paypayParams.appPayString)) {
            String str = prepayInfo.paypayParams.appPayString;
            try {
                this.mCallBack.onStart();
                LocalBroadcastManager.getInstance(this.mContext).registerReceiver(this.resultPollBR, new IntentFilter("com.xiaojukeji.action.paypayPollAction"));
                Intent intent = new Intent();
                intent.setData(Uri.parse(URLDecoder.decode(str)));
                intent.setAction("android.intent.action.VIEW");
                this.mContext.startActivity(intent);
            } catch (Exception e) {
                LogUtil.m32408d("PaypayPayMethod", e.toString());
            }
        }
    }
}
