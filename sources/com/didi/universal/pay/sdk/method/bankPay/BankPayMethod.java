package com.didi.universal.pay.sdk.method.bankPay;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.didi.payment.base.utils.PayBaseParamUtil;
import com.didi.universal.pay.sdk.method.internal.PayMethod;
import com.didi.universal.pay.sdk.method.model.BankModel;
import com.didi.universal.pay.sdk.method.model.PrepayInfo;
import com.didi.universal.pay.sdk.util.DeviceUtil;
import com.didi.universal.pay.sdk.util.LogUtil;
import com.didi.universal.pay.sdk.util.UnipayTextUtil;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;

public class BankPayMethod<T extends PrepayInfo> extends PayMethod {
    public static final String BANKPOLLACTION = "com.xiaojukeji.action.bankPollAction";
    private static WeakReference<Context> weakReference;
    /* access modifiers changed from: private */
    public BroadcastReceiver resultPollBR = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            LocalBroadcastManager.getInstance(BankPayMethod.this.mContext).unregisterReceiver(BankPayMethod.this.resultPollBR);
            if (BankPayMethod.this.mCallBack != null) {
                BankPayMethod.this.mCallBack.onComplete();
                LogUtil.m32410fi("BankPayMethod", "pay onComplete()");
            }
        }
    };

    public <T> boolean checkPaySupport(T t) {
        return true;
    }

    public int getChannelID() {
        return 135;
    }

    public int getRequestCodeForSign() {
        return 0;
    }

    public BankPayMethod(Context context) {
        super(context);
    }

    public <T> boolean checkDataValid(T t) {
        PrepayInfo prepayInfo = (PrepayInfo) t;
        return (prepayInfo == null || prepayInfo.cmbParams == null) ? false : true;
    }

    public void dopay(PrepayInfo prepayInfo) {
        BankModel bankModel = prepayInfo.cmbParams;
        LogUtil.m32410fi("BankPayMethod", "dopay");
        if (TextUtils.isEmpty(bankModel.appPayString) || !DeviceUtil.isCMBAppInstalled(this.mContext)) {
            BankPayIntent bankPayIntent = new BankPayIntent();
            bankPayIntent.setWebUrl(UnipayTextUtil.buildExtURLParams(bankModel.payString, "lang", PayBaseParamUtil.getStringParam(this.mContext, "lang")));
            bankPayIntent.setFlags(View.NAVIGATION_BAR_UNHIDE);
            if (this.mCallBack != null) {
                this.mCallBack.startActivityForResult(bankPayIntent, 104);
                LogUtil.m32410fi("BankPayMethod", "pay H5");
                return;
            }
            return;
        }
        try {
            weakReference = new WeakReference<>(this.mContext);
            LocalBroadcastManager.getInstance(this.mContext).registerReceiver(this.resultPollBR, new IntentFilter(BANKPOLLACTION));
            Intent intent = new Intent();
            intent.setData(Uri.parse(URLDecoder.decode(bankModel.appPayString)));
            intent.setAction("android.intent.action.VIEW");
            this.mContext.startActivity(intent);
            LogUtil.m32410fi("BankPayMethod", "pay native");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Context getActivity() {
        WeakReference<Context> weakReference2 = weakReference;
        if (weakReference2 != null) {
            return (Context) weakReference2.get();
        }
        return null;
    }
}
