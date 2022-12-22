package com.didi.universal.pay.biz.manager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.didi.universal.pay.sdk.method.model.PushMessage;
import com.didi.universal.pay.sdk.util.LogUtil;

public class UniversalPayPushManager {
    public static final String ACTION_PAY_PUSH_MESSAGE = "universalpaypushmanager_action_pay_push_message";
    public static final String EXTRA_PAY_PUSH_MESSAGE = "universalpaypushmanager_extra_pay_push_message";
    private static final String TAG = "UniversalPayPushManager";
    private Context mContext;
    /* access modifiers changed from: private */
    public Listener mListener;
    private PushReceiver mPushReceiver = new PushReceiver();

    public interface Listener {
        void onReceive(String str, int i, String str2);
    }

    public UniversalPayPushManager(Context context) {
        this.mContext = context;
        LocalBroadcastManager.getInstance(this.mContext).registerReceiver(this.mPushReceiver, new IntentFilter(ACTION_PAY_PUSH_MESSAGE));
    }

    private class PushReceiver extends BroadcastReceiver {
        private PushReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            PushMessage pushMessage;
            if (intent != null && (pushMessage = (PushMessage) intent.getParcelableExtra(UniversalPayPushManager.EXTRA_PAY_PUSH_MESSAGE)) != null) {
                LogUtil.m32409fi("PushReceiver code:" + pushMessage.code + " msg:" + pushMessage.msg + " data:" + pushMessage.data + " oid:" + pushMessage.oid + " productId:" + pushMessage.productId);
                if (UniversalPayPushManager.this.mListener != null) {
                    UniversalPayPushManager.this.mListener.onReceive(pushMessage.oid, pushMessage.code, pushMessage.msg);
                }
            }
        }
    }

    public void addListener(Listener listener) {
        this.mListener = listener;
    }

    public void release() {
        this.mListener = null;
        Context context = this.mContext;
        if (!(context == null || this.mPushReceiver == null)) {
            LocalBroadcastManager.getInstance(context).unregisterReceiver(this.mPushReceiver);
        }
        LogUtil.m32409fi("UniversalPayPushManager release ");
    }
}
