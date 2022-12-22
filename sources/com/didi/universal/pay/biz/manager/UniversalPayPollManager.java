package com.didi.universal.pay.biz.manager;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.didi.universal.pay.biz.model.PayStatusModel;
import com.didi.universal.pay.biz.model.PollState;
import com.didi.universal.pay.sdk.method.internal.PayServiceCallback;
import com.didi.universal.pay.sdk.method.model.PayStatus;
import com.didi.universal.pay.sdk.net.IUniversalPayHttp;
import com.didi.universal.pay.sdk.net.model.Error;
import com.didi.universal.pay.sdk.util.JsonUtil;
import com.didi.universal.pay.sdk.util.LogUtil;
import com.taxis99.R;

public class UniversalPayPollManager {
    /* access modifiers changed from: private */
    public static final String TAG = UniversalPayPollManager.class.getSimpleName();
    public final int MSG_SYS_PAY_RESULT = 1;
    private final long SYS_INTERVAL_DEFAULT = 1000;
    private final int SYS_MAX_TIME = 10;
    /* access modifiers changed from: private */
    public CallBack mCallBack;
    /* access modifiers changed from: private */
    public Context mContext;
    private Handler mHandler = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1) {
                if (UniversalPayPollManager.this.mCallBack != null) {
                    UniversalPayPollManager.this.mCallBack.onPolling(UniversalPayPollManager.this.mPollingCount);
                }
                UniversalPayPollManager.this.mHttpManager.getPayStatus(UniversalPayPollManager.this.payStatusCallback);
            }
        }
    };
    /* access modifiers changed from: private */
    public IUniversalPayHttp mHttpManager;
    /* access modifiers changed from: private */
    public PollState mPollState;
    /* access modifiers changed from: private */
    public int mPollingCount;
    PayServiceCallback<PayStatus> payStatusCallback = new PayServiceCallback<PayStatus>() {
        public void onSuccess(PayStatus payStatus) {
            String str;
            String access$300 = UniversalPayPollManager.TAG;
            LogUtil.m32410fi(access$300, "payStatusCallback payStatus" + JsonUtil.jsonFromObject(payStatus) + ", mPollingCount: " + UniversalPayPollManager.this.mPollingCount);
            PayStatusModel payStatusModel = new PayStatusModel();
            payStatusModel.payStatus = payStatus.payStatus;
            payStatusModel.payStatusDetail = payStatus.payStatusDetail;
            payStatusModel.statusMsg = payStatus.statusMsg;
            UniversalPayPollManager.this.mCallBack.onBizFail(payStatusModel);
            switch (payStatus.payStatus) {
                case 0:
                case 2:
                case 8:
                    UniversalPayPollManager.this.reCall();
                    return;
                case 1:
                    if (UniversalPayPollManager.this.mPollState == PollState.QUERY) {
                        UniversalPayPollManager.this.stop();
                        if (UniversalPayPollManager.this.mCallBack != null) {
                            UniversalPayPollManager.this.mCallBack.onBizFail((PayStatusModel) null);
                            return;
                        }
                        return;
                    }
                    UniversalPayPollManager.this.reCall();
                    return;
                case 3:
                case 5:
                    UniversalPayPollManager.this.stop();
                    if (UniversalPayPollManager.this.mCallBack != null) {
                        UniversalPayPollManager.this.mCallBack.onSuccess();
                        return;
                    }
                    return;
                case 4:
                    UniversalPayPollManager.this.stop();
                    if (UniversalPayPollManager.this.mCallBack != null) {
                        CallBack access$000 = UniversalPayPollManager.this.mCallBack;
                        if (!TextUtils.isEmpty(payStatus.statusMsg)) {
                            str = payStatus.statusMsg;
                        } else {
                            str = UniversalPayPollManager.this.mContext.getResources().getString(R.string.universal_pay_fail_title);
                        }
                        access$000.onFail(5, payStatusModel, str);
                        return;
                    }
                    return;
                case 7:
                    UniversalPayPollManager.this.stop();
                    if (UniversalPayPollManager.this.mCallBack != null) {
                        UniversalPayPollManager.this.mCallBack.onFail(6, payStatusModel, UniversalPayPollManager.this.mContext.getResources().getString(R.string.universal_fail_closed));
                        return;
                    }
                    return;
                default:
                    UniversalPayPollManager.this.stop();
                    if (UniversalPayPollManager.this.mCallBack != null) {
                        UniversalPayPollManager.this.mCallBack.onFail(3, payStatusModel, UniversalPayPollManager.this.mContext.getResources().getString(R.string.universal_err_loop_timeout));
                        return;
                    }
                    return;
            }
        }

        public void onFail(Error error) {
            UniversalPayPollManager.this.reCall();
        }
    };

    public interface CallBack {
        void onBizFail(PayStatusModel payStatusModel);

        void onFail(int i, PayStatusModel payStatusModel, String str);

        void onPolling(int i);

        void onSuccess();
    }

    public UniversalPayPollManager(Context context, IUniversalPayHttp iUniversalPayHttp) {
        this.mContext = context;
        this.mHttpManager = iUniversalPayHttp;
    }

    public void start(PollState pollState) {
        this.mPollState = pollState;
        this.mPollingCount = 0;
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeMessages(1);
            this.mHandler.sendEmptyMessage(1);
        }
        String str = TAG;
        LogUtil.m32410fi(str, "start mPollingCount ： " + this.mPollingCount);
    }

    public void stop() {
        this.mPollingCount = 0;
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeMessages(1);
        }
        String str = TAG;
        LogUtil.m32410fi(str, "stop mPollingCount ： " + this.mPollingCount);
    }

    public void addListener(CallBack callBack) {
        this.mCallBack = callBack;
    }

    /* access modifiers changed from: private */
    public void reCall() {
        int i = this.mPollingCount;
        if (i < 10) {
            this.mPollingCount = i + 1;
            this.mHandler.sendEmptyMessageDelayed(1, 1000);
            return;
        }
        stop();
        CallBack callBack = this.mCallBack;
        if (callBack != null) {
            callBack.onFail(3, (PayStatusModel) null, this.mContext.getResources().getString(R.string.universal_err_loop_timeout));
        }
    }
}
