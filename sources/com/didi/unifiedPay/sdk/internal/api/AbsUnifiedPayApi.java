package com.didi.unifiedPay.sdk.internal.api;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.didi.unifiedPay.component.model.PayParam;
import com.didi.unifiedPay.sdk.PayMethodFactory;
import com.didi.unifiedPay.sdk.change.ChangePayMethod;
import com.didi.unifiedPay.sdk.internal.PayCallback;
import com.didi.unifiedPay.sdk.internal.PayConstant;
import com.didi.unifiedPay.sdk.internal.PayError;
import com.didi.unifiedPay.sdk.internal.PayMethod;
import com.didi.unifiedPay.sdk.internal.PayServiceCallback;
import com.didi.unifiedPay.sdk.internal.PayServiceResponseCallback;
import com.didi.unifiedPay.sdk.internal.ThreeDSAdyenCallBack;
import com.didi.unifiedPay.sdk.model.BasicPayInfo;
import com.didi.unifiedPay.sdk.model.PayInfo;
import com.didi.unifiedPay.sdk.model.PayParamObject;
import com.didi.unifiedPay.sdk.model.PayStatus;
import com.didi.unifiedPay.sdk.model.PaymentThreeDSDetailsInfo;
import com.didi.unifiedPay.sdk.model.PrepayInfo;
import com.didi.unifiedPay.sdk.model.VisaPayModel;
import com.didi.unifiedPay.sdk.net.C14489Util;
import com.didi.unifiedPay.sdk.net.Error;
import com.didi.unifiedPay.sdk.net.service.IUnipayService;
import com.didi.unifiedPay.util.LogUtil;
import com.didi.unifiedPay.util.OmegaUtils;
import com.didi.unifiedPay.util.UniPayParamUtil;
import com.didichuxing.foundation.net.rpc.http.HttpRpcResponse;
import com.taxis99.R;
import global.didi.pay.merchant.processor.model.MerchantRequestType;
import global.didi.pay.merchantcore.model.DPayRequest;
import global.didi.pay.model.LoadingState;
import global.didi.pay.omega.GlobalPayOmegaManager;
import global.didi.pay.threeds.model.Adyen3DSModel;
import global.didi.pay.threeds.model.AdyenActionComponentData;
import global.didi.pay.threeds.network.model.ThreedsCybsDataResponse;
import org.json.JSONObject;

public abstract class AbsUnifiedPayApi implements IUnifiedPayApi {
    public static final int SYSC_GET_PAY_INFO_MSG = 2;
    public static final long SYSC_INTERVAL_DEFAULT = 1000;
    public static final int SYSC_PAY_RESULT_MSG = 1;
    public static final int SYSC_PAY_RESULT_MSG_ARG1_CANSTOP = 1;

    /* renamed from: c */
    private static final String f44549c = "UnifiedPayApiImpl";

    /* renamed from: a */
    PayServiceCallback<PayInfo> f44550a;

    /* renamed from: b */
    PayServiceCallback<PayStatus> f44551b = new PayServiceResponseCallback<PayStatus>() {
        String responseTraceId;

        public void setResponse(HttpRpcResponse httpRpcResponse) {
            this.responseTraceId = OmegaUtils.getHeader(httpRpcResponse.getHeaders(), "didi-header-rid");
        }

        public void onSuccess(PayStatus payStatus) {
            PayCallback a = AbsUnifiedPayApi.this.m31662a();
            if (a != null) {
                LogUtil.m31685fi(AbsUnifiedPayApi.f44549c, "unified pay payStatus" + C14489Util.jsonFromObject(payStatus));
                int i = payStatus.payStatus;
                if (i != 0 && i != 1 && i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            if (AbsUnifiedPayApi.this.f44561m != null) {
                                AbsUnifiedPayApi.this.f44561m.removeMessages(1);
                            }
                            a.onPayFail(new PayError(5), !TextUtils.isEmpty(payStatus.statusMsg) ? payStatus.statusMsg : "");
                            GlobalPayOmegaManager.doOmegaForPayError(2, payStatus.statusMsg, 4, this.responseTraceId, "pollingQueryPayStatus");
                            return;
                        } else if (i == 7) {
                            a.onPayFail(new PayError(6), AbsUnifiedPayApi.this.mContext.getResources().getString(R.string.oc_pay_closed));
                            return;
                        } else if (i != 10) {
                            if (i != 11) {
                                reCall(false);
                                return;
                            }
                            int unused = AbsUnifiedPayApi.this.f44555g = 0;
                            if (AbsUnifiedPayApi.this.f44561m != null) {
                                AbsUnifiedPayApi.this.f44561m.removeMessages(1);
                            }
                            a.onAdyenThreeDSActionHandle(payStatus.mAdyen3DSModel);
                            return;
                        }
                    }
                    a.onPaySuccess(payStatus.payStatus, payStatus.statusMsg);
                    int unused2 = AbsUnifiedPayApi.this.f44555g = 0;
                    if (AbsUnifiedPayApi.this.f44561m != null) {
                        AbsUnifiedPayApi.this.f44561m.removeMessages(1);
                    }
                } else if (payStatus.mOfflinePayStatus == null || AbsUnifiedPayApi.this.f44557i == null || !PayConstant.isGlobalOfflineChannel(AbsUnifiedPayApi.this.f44557i.getPayChannel())) {
                    reCall(true);
                } else {
                    a.onPrePaySuccess(payStatus.mOfflinePayStatus.transToPrepayInfo());
                }
            }
        }

        private void reCall(boolean z) {
            if (!z || AbsUnifiedPayApi.this.f44555g >= AbsUnifiedPayApi.this.f44553e) {
                AbsUnifiedPayApi.this.cancelSyncPayResult();
            } else {
                AbsUnifiedPayApi.m31670h(AbsUnifiedPayApi.this);
            }
        }

        public void onFail(Error error) {
            if (AbsUnifiedPayApi.this.f44561m != null) {
                AbsUnifiedPayApi.this.f44561m.removeMessages(1);
            }
            if (AbsUnifiedPayApi.this.f44555g < AbsUnifiedPayApi.this.f44553e) {
                AbsUnifiedPayApi.m31670h(AbsUnifiedPayApi.this);
                if (AbsUnifiedPayApi.this.f44561m != null) {
                    AbsUnifiedPayApi.this.f44561m.sendEmptyMessage(1);
                    return;
                }
                return;
            }
            PayCallback a = AbsUnifiedPayApi.this.m31662a();
            if (a != null) {
                a.onPayFail(new PayError(3), AbsUnifiedPayApi.this.mContext != null ? AbsUnifiedPayApi.this.mContext.getResources().getString(R.string.oc_uni_pay_err_loop_timeout) : "");
                GlobalPayOmegaManager.doOmegaForPayError(0, error.msg, error.code, this.responseTraceId, "pollingQueryPayStatus");
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: d */
    public long f44552d = 1000;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f44553e = 15;

    /* renamed from: f */
    private int f44554f = 15;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f44555g;

    /* renamed from: h */
    private int f44556h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public PayMethod f44557i;

    /* renamed from: j */
    private PayCallback f44558j;

    /* renamed from: k */
    private String f44559k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public LoadingState f44560l = LoadingState.TYPE_WAITING;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public Handler f44561m = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i == 1) {
                AbsUnifiedPayApi.this.mUnipayService.getPayStatus(AbsUnifiedPayApi.this.f44551b);
                PayCallback a = AbsUnifiedPayApi.this.m31662a();
                if (a != null) {
                    a.onQueryPayResult(AbsUnifiedPayApi.this.f44555g == 0, AbsUnifiedPayApi.this.f44560l, message.arg1);
                }
                Message obtain = Message.obtain();
                obtain.what = 1;
                obtain.arg1 = message.arg1;
                sendMessageDelayed(obtain, AbsUnifiedPayApi.this.f44552d);
            } else if (i == 2) {
                AbsUnifiedPayApi.this.mUnipayService.getPayInfo(AbsUnifiedPayApi.this.f44550a);
            }
        }
    };
    protected int mBid;
    protected Context mContext;
    protected FragmentManager mFragmentManager;
    protected String mOid;
    protected PayParam mPayParam;
    protected IUnipayService mUnipayService;

    /* renamed from: n */
    private PayServiceCallback<PrepayInfo> f44562n = new PayServiceResponseCallback<PrepayInfo>() {
        int netStatus = -1;
        String responseTraceId;

        public void setResponse(HttpRpcResponse httpRpcResponse) {
            this.responseTraceId = OmegaUtils.getHeader(httpRpcResponse.getHeaders(), "didi-header-rid");
            this.netStatus = httpRpcResponse.getStatus();
        }

        public void onSuccess(PrepayInfo prepayInfo) {
            if (AbsUnifiedPayApi.this.f44557i != null && prepayInfo != null) {
                AbsUnifiedPayApi.this.f44557i.onPay(prepayInfo);
            }
        }

        public void onFail(Error error) {
            if (error != null) {
                int i = 2;
                if (error.code == 80200) {
                    VisaPayModel visaPayModel = new VisaPayModel();
                    visaPayModel.isNeedBindCard = true;
                    PrepayInfo prepayInfo = new PrepayInfo();
                    prepayInfo.visaPayModel = visaPayModel;
                    AbsUnifiedPayApi.this.f44557i.onPay(prepayInfo);
                } else if (error.code == 12004) {
                    PrepayInfo prepayInfo2 = new PrepayInfo();
                    prepayInfo2.resultType = 0;
                    onSuccess(prepayInfo2);
                } else if (error.code == 10902) {
                    PrepayInfo prepayInfo3 = new PrepayInfo();
                    prepayInfo3.resultType = -1;
                    AbsUnifiedPayApi.this.f44557i.onPay(prepayInfo3);
                } else {
                    PayCallback callbackLisenter = AbsUnifiedPayApi.this.f44557i.getCallbackLisenter();
                    if (callbackLisenter != null) {
                        callbackLisenter.onPrePayFail(error.code, error.msg);
                    }
                    i = -1;
                }
                GlobalPayOmegaManager.doOmegaForPayError(i, error.msg, error.code, this.responseTraceId, "prePay");
            }
            GlobalPayOmegaManager.doOmegaForPayError(0, (String) null, this.netStatus, this.responseTraceId, "prePay");
        }
    };

    /* access modifiers changed from: protected */
    public abstract IUnipayService createService(Context context);

    /* access modifiers changed from: protected */
    public abstract void initService();

    public void setDPayRequest(DPayRequest dPayRequest) {
    }

    public void setExtraParam(JSONObject jSONObject) {
    }

    public void setRequestType(MerchantRequestType merchantRequestType) {
    }

    /* renamed from: h */
    static /* synthetic */ int m31670h(AbsUnifiedPayApi absUnifiedPayApi) {
        int i = absUnifiedPayApi.f44555g + 1;
        absUnifiedPayApi.f44555g = i;
        return i;
    }

    public AbsUnifiedPayApi(Context context) {
        this.mContext = context;
        this.mUnipayService = createService(context);
    }

    public void setPayParam(PayParam payParam) {
        this.mPayParam = payParam;
    }

    public void init(int i, String str, FragmentManager fragmentManager) {
        this.mBid = i;
        this.mOid = str;
        initService();
    }

    public void changeCoupon(String str) {
        this.mUnipayService.changeCoupon(str);
    }

    public void changeInstallmentNumber(String str) {
        this.mUnipayService.changeInstallmentNumber(str);
    }

    public void setPassword(String str) {
        this.mUnipayService.setPassword(str);
    }

    public void setCybs3DSData(ThreedsCybsDataResponse threedsCybsDataResponse) {
        this.mUnipayService.setCybs3DSData(threedsCybsDataResponse);
    }

    public void changeEnterprisePayType(int i) {
        this.mUnipayService.changeEnterprisePayType(i);
    }

    public void changePayChannel(int i, String str) {
        this.mUnipayService.changePayChannel(i, str);
    }

    public void changePayWithBalance(String str, String str2) {
        this.mUnipayService.changePayWithBalance(str, str2);
    }

    public void getBasicPayInfo(PayServiceCallback<BasicPayInfo> payServiceCallback) {
        this.mUnipayService.getBasicPayInfo(payServiceCallback);
    }

    public void getPayInfo(PayServiceCallback<PayInfo> payServiceCallback, int i) {
        this.f44556h = 1;
        this.f44550a = payServiceCallback;
        if (i > 0) {
            this.f44554f = i;
        }
        Handler handler = this.f44561m;
        if (handler != null) {
            handler.removeMessages(2);
            this.f44561m.sendEmptyMessage(2);
        }
    }

    public boolean syncPayInfo() {
        int i = this.f44556h + 1;
        this.f44556h = i;
        if (i == this.f44554f) {
            return false;
        }
        Handler handler = this.f44561m;
        if (handler != null) {
            handler.removeMessages(2);
            this.f44561m.sendEmptyMessage(2);
        }
        return true;
    }

    public void changePayInfo(int i, PayServiceCallback<PayInfo> payServiceCallback) {
        this.mUnipayService.changePayInfo(i, payServiceCallback);
    }

    public void billConfirm(int i, PayServiceCallback<Object> payServiceCallback) {
        this.mUnipayService.billConfirm(i, payServiceCallback);
    }

    public void registerCallback(PayCallback payCallback) {
        this.f44558j = payCallback;
    }

    public void doPay(FragmentActivity fragmentActivity, PayParamObject payParamObject, PayCallback payCallback) {
        synchronized (AbsUnifiedPayApi.class) {
            this.f44555g = 0;
            if (payParamObject != null) {
                this.f44559k = payParamObject.wXAppId;
                PayMethod method = PayMethodFactory.getMethod(payParamObject);
                this.f44557i = method;
                if (method != null) {
                    method.setCallbackListener(payCallback);
                    this.f44557i.setNeedCheckResult(payParamObject.checkPayResultSilent);
                    this.f44557i.setUnifiedPayApi(this);
                    this.f44557i.setPayChannel(payParamObject.thirdPayType);
                    if (payParamObject.needSign == 1 && this.f44557i.supportSign()) {
                        this.f44557i.startSignPage(fragmentActivity, payParamObject.signData);
                    } else if (!(this.f44557i instanceof ChangePayMethod) || payParamObject.needInputPwd != 1) {
                        this.f44557i.createPay(fragmentActivity, this.mUnipayService, this.f44559k, this.f44562n);
                    } else {
                        ((ChangePayMethod) this.f44557i).createVerify(fragmentActivity, this.mUnipayService, this.f44559k, this.f44562n);
                    }
                }
            }
        }
    }

    public void doPixPay(FragmentActivity fragmentActivity, PayCallback payCallback, LoadingState loadingState, int i) {
        synchronized (AbsUnifiedPayApi.class) {
            this.f44555g = 0;
            PayMethod method = PayMethodFactory.getMethod(212);
            this.f44557i = method;
            if (method != null) {
                method.setCallbackListener(payCallback);
                this.f44557i.setNeedCheckResult(true);
                this.f44557i.setUnifiedPayApi(this);
                this.f44557i.setPayChannel(212);
                this.f44557i.mActivity = fragmentActivity;
                this.f44557i.mPayService = this.mUnipayService;
                this.f44557i.mPrepayCallback = this.f44562n;
                startSyncPayResult(20, 3000, loadingState, i);
            }
        }
    }

    public void paymentThreeDSDetails(Adyen3DSModel adyen3DSModel, AdyenActionComponentData adyenActionComponentData, final ThreeDSAdyenCallBack threeDSAdyenCallBack) {
        this.mUnipayService.paymentThreeDSDetails(adyen3DSModel, adyenActionComponentData, new PayServiceCallback<PaymentThreeDSDetailsInfo>() {
            public void onSuccess(PaymentThreeDSDetailsInfo paymentThreeDSDetailsInfo) {
                GlobalPayOmegaManager.doOmegaForThreedsResult(UniPayParamUtil.getUid(AbsUnifiedPayApi.this.mContext), AbsUnifiedPayApi.this.mOid, 1);
                if (paymentThreeDSDetailsInfo.threeDSResult == 1) {
                    AbsUnifiedPayApi.this.startSyncPayResult(paymentThreeDSDetailsInfo.mPollingTimes, (long) (paymentThreeDSDetailsInfo.mPollingInterval * 1000));
                } else if (paymentThreeDSDetailsInfo.threeDSResult == 2 && paymentThreeDSDetailsInfo.adyen3DSModel != null) {
                    paymentThreeDSDetailsInfo.adyen3DSModel.channel = AbsUnifiedPayApi.this.getPayChannelId();
                    threeDSAdyenCallBack.onAdyenThreeDSActionHandle(paymentThreeDSDetailsInfo.adyen3DSModel);
                }
            }

            public void onFail(Error error) {
                PayCallback callbackLisenter;
                GlobalPayOmegaManager.doOmegaForThreedsResult(UniPayParamUtil.getUid(AbsUnifiedPayApi.this.mContext), AbsUnifiedPayApi.this.mOid, 0);
                if (error != null && AbsUnifiedPayApi.this.f44557i != null && (callbackLisenter = AbsUnifiedPayApi.this.f44557i.getCallbackLisenter()) != null) {
                    callbackLisenter.onPrePayFail(error.code, error.msg);
                }
            }
        });
    }

    public void startSyncPayResult(int i, long j, LoadingState loadingState, int i2) {
        startSyncPayResult(i, j, i2);
        this.f44560l = loadingState;
    }

    public void startSyncPayResult(int i, long j, int i2) {
        this.f44555g = 0;
        if (i > 0) {
            this.f44553e = i;
        }
        if (j > 0) {
            this.f44552d = j;
        }
        Handler handler = this.f44561m;
        if (handler != null) {
            handler.removeMessages(1);
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = i2;
            this.f44561m.sendMessage(obtain);
        }
        this.f44560l = LoadingState.TYPE_WAITING;
    }

    public void startSyncPayResult(int i, long j) {
        startSyncPayResult(i, j, 0);
    }

    public void stopSyncPayResult() {
        Handler handler = this.f44561m;
        if (handler != null) {
            handler.removeMessages(1);
        }
    }

    public void cancelSyncPayResult() {
        stopSyncPayResult();
        PayCallback a = m31662a();
        if (a != null) {
            Context context = this.mContext;
            String string = context != null ? context.getResources().getString(R.string.oc_uni_pay_err_loop_timeout) : "";
            PayMethod payMethod = this.f44557i;
            if (payMethod == null || payMethod.getPayChannel() != 212) {
                a.onPayFail(new PayError(3), string);
            } else {
                a.onNewPixCode((String) null);
            }
        }
    }

    public void onDestroy() {
        removeCallback();
    }

    public void removeCallback() {
        IUnipayService iUnipayService = this.mUnipayService;
        if (iUnipayService != null) {
            iUnipayService.onDestroy();
        }
        this.f44558j = null;
        PayMethod payMethod = this.f44557i;
        if (payMethod != null) {
            payMethod.removeListener();
        }
        Handler handler = this.f44561m;
        if (handler != null) {
            handler.removeMessages(1);
            this.f44561m = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public PayCallback m31662a() {
        PayMethod payMethod = this.f44557i;
        if (payMethod != null) {
            return payMethod.getCallbackLisenter();
        }
        return this.f44558j;
    }

    public int getPayChannelId() {
        PayMethod payMethod = this.f44557i;
        if (payMethod != null) {
            return payMethod.getPayChannel();
        }
        return 0;
    }
}
