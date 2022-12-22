package com.didi.unifiedPay.sdk.net.service;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.os.Build;
import android.text.TextUtils;
import com.didi.sdk.util.SystemUtil;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.unifiedPay.UnifiedPayConstant;
import com.didi.unifiedPay.sdk.internal.PayConstant;
import com.didi.unifiedPay.sdk.internal.PayServiceCallback;
import com.didi.unifiedPay.sdk.internal.PayServiceResponseCallback;
import com.didi.unifiedPay.sdk.model.BasicPayInfo;
import com.didi.unifiedPay.sdk.model.ConfirmTipsInfo;
import com.didi.unifiedPay.sdk.model.DeductionInfo;
import com.didi.unifiedPay.sdk.model.ExternalPayChannel;
import com.didi.unifiedPay.sdk.model.InternalPayChannel;
import com.didi.unifiedPay.sdk.model.PayInfo;
import com.didi.unifiedPay.sdk.model.PayStatus;
import com.didi.unifiedPay.sdk.model.PaymentThreeDSDetailsInfo;
import com.didi.unifiedPay.sdk.model.PrepayInfo;
import com.didi.unifiedPay.sdk.model.SubChannel;
import com.didi.unifiedPay.sdk.net.BaseParam;
import com.didi.unifiedPay.sdk.net.BaseResponse;
import com.didi.unifiedPay.sdk.net.C14489Util;
import com.didi.unifiedPay.sdk.net.Error;
import com.didi.unifiedPay.sdk.net.Helper;
import com.didi.unifiedPay.sdk.net.api.Api;
import com.didi.unifiedPay.sdk.net.api.trip.ChangePayInfo;
import com.didi.unifiedPay.sdk.net.api.trip.ConfirmBill;
import com.didi.unifiedPay.sdk.net.api.trip.GetConfirmTips;
import com.didi.unifiedPay.sdk.net.api.trip.GetPayBasicInfo;
import com.didi.unifiedPay.sdk.net.api.trip.GetPayInfo;
import com.didi.unifiedPay.sdk.net.api.trip.GetPayStatus;
import com.didi.unifiedPay.sdk.net.api.trip.PaymentThreeDSDetails;
import com.didi.unifiedPay.sdk.net.api.trip.Prepay;
import com.didi.unifiedPay.sdk.net.config.Config;
import com.didi.unifiedPay.sdk.net.service.IUnipayService;
import com.didi.unifiedPay.util.ABTestProxyHolder;
import com.didi.unifiedPay.util.DeviceUtil;
import com.didi.unifiedPay.util.LogUtil;
import com.didi.unifiedPay.util.UniPayParamUtil;
import com.didi.unifiedPay.util.UnipayAppUtil;
import com.didichuxing.foundation.net.http.HttpBody;
import com.didichuxing.foundation.net.rpc.http.HttpRpc;
import com.didichuxing.foundation.net.rpc.http.HttpRpcClient;
import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;
import com.didichuxing.foundation.net.rpc.http.HttpRpcResponse;
import com.didichuxing.foundation.p188io.StringDeserializer;
import com.google.gson.JsonElement;
import com.taxis99.R;
import global.didi.pay.threeds.model.Adyen3DSModel;
import global.didi.pay.threeds.model.AdyenActionComponentData;
import global.didi.pay.threeds.network.model.ThreedsCybsDataResponse;
import global.didi.pay.threeds.utils.ThreeDSUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UniPayTripHttpServiceImpl implements IUnipayService {

    /* renamed from: a */
    private static final String f44590a = "UniPayHttpServiceImpl";
    protected List<String> arrSelectedPayChannels = new ArrayList();
    protected boolean isViewDestroyed;
    protected String mActivityId;
    protected HttpRpcClient mClient;
    protected Config mConfig;
    protected Context mContext;
    protected String mCouponId;
    protected ThreedsCybsDataResponse mCybsDataResponse;
    protected Helper mHelper;
    protected String mInstallmentNumber;
    protected String mOid;
    protected String mPassword;
    protected String mPayChannelType;
    protected int mPayType;
    protected int mProductId;
    protected String mUserLastSelectType;

    public UniPayTripHttpServiceImpl(Context context) {
        this.mContext = context;
        this.isViewDestroyed = false;
    }

    public void init(int i, String str) {
        this.mProductId = i;
        this.mOid = str;
        this.mHelper = new Helper();
        this.mConfig = new Config(PayConstant.PayBillType.Trip);
        this.mClient = this.mHelper.getHttpClient(this.mContext);
    }

    public void billConfirm(int i, PayServiceCallback<Object> payServiceCallback) {
        request(new ConfirmBill(i), payServiceCallback, (IUnipayService.Interceptor) null, Object.class);
    }

    public void getBasicPayInfo(PayServiceCallback<BasicPayInfo> payServiceCallback) {
        request(new GetPayBasicInfo(), payServiceCallback, (IUnipayService.Interceptor) null, BasicPayInfo.class);
    }

    public void getPayInfo(PayServiceCallback<PayInfo> payServiceCallback) {
        request(new GetPayInfo(), payServiceCallback, new IUnipayService.Interceptor<PayInfo>() {
            public void onSuccess(PayInfo payInfo) {
                UniPayTripHttpServiceImpl.this.interceptPayInfo(payInfo);
            }
        }, PayInfo.class);
    }

    public void paymentThreeDSDetails(Adyen3DSModel adyen3DSModel, AdyenActionComponentData adyenActionComponentData, PayServiceCallback<PaymentThreeDSDetailsInfo> payServiceCallback) {
        PaymentThreeDSDetails paymentThreeDSDetails = new PaymentThreeDSDetails();
        paymentThreeDSDetails.reference = adyen3DSModel.reference;
        paymentThreeDSDetails.channelId = adyen3DSModel.channel;
        paymentThreeDSDetails.shopper = adyen3DSModel.shopper;
        paymentThreeDSDetails.vendor = adyen3DSModel.vendor;
        paymentThreeDSDetails.auth_details = adyenActionComponentData.trans().toString();
        request(paymentThreeDSDetails, payServiceCallback, (IUnipayService.Interceptor) null, PaymentThreeDSDetailsInfo.class);
    }

    /* access modifiers changed from: protected */
    public void interceptPayInfo(PayInfo payInfo) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        PayInfo payInfo2 = payInfo;
        this.arrSelectedPayChannels.clear();
        ABTestProxyHolder.getOptimizedUISwitch().setOptimize(payInfo2.hitOptimizedCashier == 1);
        if (payInfo2.billDetail != null) {
            DeductionInfo[] deductionInfoArr = payInfo2.billDetail.deductions;
            if (deductionInfoArr == null || deductionInfoArr.length <= 0) {
                z2 = false;
                z = false;
            } else {
                z2 = false;
                z = false;
                for (DeductionInfo deductionInfo : deductionInfoArr) {
                    if (deductionInfo.type == 1) {
                        this.mCouponId = deductionInfo.couponId;
                        z2 = true;
                    } else if (9 == deductionInfo.type) {
                        this.mActivityId = deductionInfo.activityId;
                        z = true;
                    }
                }
            }
            if (!z2) {
                this.mCouponId = "";
            }
            if (!z) {
                this.mActivityId = "";
            }
            ExternalPayChannel[] externalPayChannelArr = payInfo2.billDetail.externalChannels;
            if (externalPayChannelArr == null || externalPayChannelArr.length <= 0) {
                z3 = false;
            } else {
                z3 = false;
                for (ExternalPayChannel externalPayChannel : externalPayChannelArr) {
                    if (externalPayChannel.selected == 1) {
                        this.mPayChannelType = "" + externalPayChannel.channel_id;
                        if (externalPayChannel.channel_id != 150 || TextUtils.isEmpty(externalPayChannel.selected_sub_id) || externalPayChannel.sub_channels == null || externalPayChannel.sub_channels.length <= 0) {
                            this.arrSelectedPayChannels.add("" + externalPayChannel.channel_id);
                        } else {
                            for (SubChannel subChannel : externalPayChannel.sub_channels) {
                                if (subChannel.sub_id.equals(externalPayChannel.selected_sub_id)) {
                                    this.arrSelectedPayChannels.add(externalPayChannel.channel_id + "+" + subChannel.sub_id);
                                    this.mPayChannelType = externalPayChannel.channel_id + "+" + subChannel.sub_id;
                                }
                            }
                        }
                        z3 = true;
                    }
                }
            }
            if (!z3) {
                this.mPayChannelType = "";
            }
            InternalPayChannel[] internalPayChannelArr = payInfo2.billDetail.internalChannels;
            if (internalPayChannelArr == null || internalPayChannelArr.length <= 0) {
                z5 = false;
                z4 = false;
            } else {
                z5 = false;
                z4 = false;
                for (InternalPayChannel internalPayChannel : internalPayChannelArr) {
                    if (internalPayChannel.channel_id == 121) {
                        z4 = internalPayChannel.selected == 1;
                        z5 = true;
                    }
                    if (TextUtils.isEmpty(this.mPayChannelType) && internalPayChannel.selected == 1) {
                        this.mPayChannelType = "" + internalPayChannel.channel_id;
                    }
                    if (internalPayChannel.selected == 1) {
                        this.arrSelectedPayChannels.add("" + internalPayChannel.channel_id);
                    }
                }
            }
            if (!z5) {
                this.mPayType = 0;
            } else if (z4) {
                this.mPayType = 21;
            } else {
                this.mPayType = 20;
            }
        }
    }

    public void changeInstallmentNumber(String str) {
        this.mInstallmentNumber = str;
    }

    public void setPassword(String str) {
        this.mPassword = str;
    }

    public void setCybs3DSData(ThreedsCybsDataResponse threedsCybsDataResponse) {
        this.mCybsDataResponse = threedsCybsDataResponse;
    }

    public void prepay(String str, String str2, PayServiceCallback<PrepayInfo> payServiceCallback) {
        Prepay prepay = new Prepay();
        prepay.biz_pay_type = this.mPayType;
        prepay.coupon_id = this.mCouponId;
        prepay.activity_id = this.mActivityId;
        prepay.threeds_callback_scheme = ThreeDSUtils.getCallbackUrl(DeviceUtil.getPackageName(this.mContext));
        List<String> list = this.arrSelectedPayChannels;
        if (list != null && list.size() > 0) {
            prepay.pay_channels = getPayChannels();
        }
        if (!TextUtils.isEmpty(this.mInstallmentNumber)) {
            prepay.installment_number = this.mInstallmentNumber;
        }
        if (!TextUtils.isEmpty(this.mPassword)) {
            prepay.password_token = this.mPassword;
        }
        this.mPassword = null;
        ThreedsCybsDataResponse threedsCybsDataResponse = this.mCybsDataResponse;
        if (threedsCybsDataResponse != null) {
            prepay.three_ds_v2 = C14489Util.jsonFromObject(threedsCybsDataResponse);
        }
        this.mCybsDataResponse = null;
        if (!TextUtils.isEmpty(UnipayAppUtil.getMetaDataByKey(this.mContext, "paypayScheme"))) {
            prepay.redirect_scheme = UnipayAppUtil.getMetaDataByKey(this.mContext, "paypayScheme");
        }
        request(prepay, payServiceCallback, new IUnipayService.Interceptor<PrepayInfo>() {
            public void onSuccess(PrepayInfo prepayInfo) {
            }
        }, PrepayInfo.class);
    }

    public void getPayStatus(PayServiceCallback<PayStatus> payServiceCallback) {
        request(new GetPayStatus(), payServiceCallback, new IUnipayService.Interceptor<PayStatus>() {
            public void onSuccess(PayStatus payStatus) {
            }
        }, PayStatus.class);
    }

    public void changePayInfo(int i, PayServiceCallback<PayInfo> payServiceCallback) {
        ChangePayInfo changePayInfo = new ChangePayInfo();
        changePayInfo.biz_pay_type = this.mPayType;
        changePayInfo.coupon_id = this.mCouponId;
        changePayInfo.activity_id = this.mActivityId;
        changePayInfo.user_select = this.mUserLastSelectType;
        changePayInfo.change_type = i;
        changePayInfo.pay_channels = getPayChannels();
        if (!TextUtils.isEmpty(this.mInstallmentNumber)) {
            changePayInfo.installment_number = this.mInstallmentNumber;
        }
        request(changePayInfo, payServiceCallback, new IUnipayService.Interceptor<PayInfo>() {
            public void onSuccess(PayInfo payInfo) {
                UniPayTripHttpServiceImpl.this.interceptPayInfo(payInfo);
            }
        }, PayInfo.class);
    }

    /* access modifiers changed from: protected */
    public String getPayChannels() {
        List<String> list = this.arrSelectedPayChannels;
        String str = "";
        if (!(list == null || list.size() == 0)) {
            int size = this.arrSelectedPayChannels.size();
            for (int i = 0; i < size; i++) {
                str = str + this.arrSelectedPayChannels.get(i);
                if (i != this.arrSelectedPayChannels.size() - 1) {
                    str = str + ",";
                }
            }
        }
        return str;
    }

    public void changeCoupon(String str) {
        this.mCouponId = str;
    }

    public void changeEnterprisePayType(int i) {
        this.mPayType = i;
        this.mUserLastSelectType = "" + i;
    }

    public void changePayChannel(int i, String str) {
        if (TextUtils.isEmpty(str)) {
            this.mUserLastSelectType = "" + i;
            this.mPayChannelType = "" + i;
            return;
        }
        this.mUserLastSelectType = i + "+" + str;
        this.mPayChannelType = i + "+" + str;
    }

    public void changePayWithBalance(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            this.mUserLastSelectType = str;
            this.mPayChannelType = str;
            return;
        }
        this.mUserLastSelectType = str + "," + str2;
        this.mPayChannelType = str + "," + str2;
    }

    public void onDestroy() {
        this.isViewDestroyed = true;
    }

    public void getConfirmInfo(int i, long j, String str, PayServiceCallback<ConfirmTipsInfo> payServiceCallback) {
        GetConfirmTips getConfirmTips = new GetConfirmTips();
        getConfirmTips.channel_id = i;
        getConfirmTips.currency = str;
        getConfirmTips.total_fee = j;
        request(getConfirmTips, payServiceCallback, new IUnipayService.Interceptor<ConfirmTipsInfo>() {
            public void onSuccess(ConfirmTipsInfo confirmTipsInfo) {
            }
        }, ConfirmTipsInfo.class);
    }

    /* access modifiers changed from: protected */
    public <T> void request(Object obj, PayServiceCallback<T> payServiceCallback, IUnipayService.Interceptor<T> interceptor, Class<T> cls) {
        Api api = (Api) obj.getClass().getAnnotation(Api.class);
        if (api == null) {
            LogUtil.m31684d(f44590a, "api not defined");
            return;
        }
        String name = api.name();
        LogUtil.m31685fi(f44590a, "unified pay request [" + name + "] : " + C14489Util.jsonFromObject(obj));
        createAndPostRequest(name, obj, payServiceCallback, interceptor, cls);
    }

    /* access modifiers changed from: protected */
    public Map<String, String> buildBaseParams() {
        String str;
        HashMap<String, Object> commonParam = UniPayParamUtil.getCommonParam(this.mContext);
        HashMap hashMap = new HashMap();
        if (commonParam != null) {
            for (Map.Entry next : commonParam.entrySet()) {
                hashMap.put(next.getKey(), String.valueOf(next.getValue()));
            }
        }
        hashMap.put("vcode", SystemUtil.getVersionCode() + "");
        hashMap.put("appversion", SystemUtil.getVersionName(this.mContext));
        hashMap.put("model", SystemUtil.getModel());
        hashMap.put("os", Build.VERSION.RELEASE);
        hashMap.put("imei", SystemUtil.getIMEI());
        hashMap.put("channel", SystemUtil.getChannelId());
        hashMap.put("datatype", "1");
        hashMap.put("_t", System.currentTimeMillis() + "");
        hashMap.put("oid", this.mOid);
        if (this.mProductId > 0) {
            hashMap.put("product_id", this.mProductId + "");
        } else if (UniPayParamUtil.getProductId(this.mContext) > 0) {
            hashMap.put("product_id", UniPayParamUtil.getProductId(this.mContext) + "");
        }
        hashMap.put("token", UniPayParamUtil.getToken(this.mContext));
        hashMap.put("nonce_str", System.currentTimeMillis() + "");
        WifiInfo wifiInfo = SystemUtil.getWifiInfo(this.mContext);
        if (wifiInfo != null) {
            str = wifiInfo.getSSID();
        } else {
            str = "";
        }
        hashMap.put("ssid", str);
        hashMap.put("uuid", UniPayParamUtil.getUUID(this.mContext));
        hashMap.put("suuid", UniPayParamUtil.getSUUID(this.mContext));
        hashMap.put("lang", UniPayParamUtil.getLang());
        hashMap.put("device_id", UniPayParamUtil.getDeviceId(this.mContext));
        if (!TextUtils.isEmpty(DeviceUtil.getPackageName(this.mContext))) {
            hashMap.put("app_uni_id", DeviceUtil.getPackageName(this.mContext));
        }
        if (UniPayParamUtil.getTerminalId(this.mContext) > 0) {
            hashMap.put("terminal_id", "" + UniPayParamUtil.getTerminalId(this.mContext));
        }
        hashMap.put("lat", UniPayParamUtil.getLat(this.mContext) + "");
        hashMap.put("lng", UniPayParamUtil.getLng(this.mContext) + "");
        hashMap.put(BaseParam.PARAM_VIRTUAL_CASHIER_SDK_VERSION, UnipayAppUtil.getMetaDataByKey(this.mContext, UnifiedPayConstant.MetaKey.VIRTUAL_SDK_VERSION));
        hashMap.put(BaseParam.PARAM_VIRTUAL_3DS_SDK_VERSION, UnipayAppUtil.getMetaDataByKey(this.mContext, "global.didi.pay.threeds.sdk.version"));
        return hashMap;
    }

    /* renamed from: a */
    private HashMap<String, String> m31676a(HashMap<String, Object> hashMap) {
        HashMap<String, String> hashMap2 = new HashMap<>();
        for (Map.Entry next : hashMap.entrySet()) {
            hashMap2.put((String) next.getKey(), next.getValue() != null ? next.getValue().toString() : "");
        }
        return hashMap2;
    }

    /* access modifiers changed from: protected */
    public <T> Object createAndPostRequest(String str, Object obj, PayServiceCallback<T> payServiceCallback, IUnipayService.Interceptor<T> interceptor, Class<T> cls) {
        String str2;
        String str3 = this.mConfig.getBaseUrl() + str;
        LogUtil.m31684d(f44590a, "url : " + str3);
        try {
            str2 = this.mHelper.createBody(buildBaseParams(), obj, this.mContext);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            str2 = "";
        }
        LogUtil.m31684d(f44590a, "request body : " + str2);
        return this.mClient.newRpc(new HttpRpcRequest.Builder().addHeaders((Iterable) this.mHelper.getHeaders()).post(str3, HttpBody.newInstance("application/x-www-form-urlencoded", str2)).setTag((Object) str).build()).enqueue(m31675a(str, new MainThreadCallback(payServiceCallback), interceptor, cls));
    }

    /* renamed from: a */
    private <T> HttpRpc.Callback m31675a(String str, PayServiceResponseCallback<T> payServiceResponseCallback, IUnipayService.Interceptor<T> interceptor, Class<T> cls) {
        final PayServiceResponseCallback<T> payServiceResponseCallback2 = payServiceResponseCallback;
        final String str2 = str;
        final Class<T> cls2 = cls;
        final IUnipayService.Interceptor<T> interceptor2 = interceptor;
        return new HttpRpc.Callback() {
            public void onSuccess(HttpRpcResponse httpRpcResponse) {
                try {
                    if (httpRpcResponse.getStatus() == 200) {
                        payServiceResponseCallback2.setResponse(httpRpcResponse);
                        BaseResponse baseResponse = (BaseResponse) C14489Util.objectFromJson(new StringDeserializer().deserialize(httpRpcResponse.getEntity().getContent()), BaseResponse.class);
                        if (baseResponse.errno == 0) {
                            JsonElement jsonElement = baseResponse.data;
                            String str = "{}";
                            if (jsonElement != null) {
                                str = jsonElement.toString();
                            }
                            LogUtil.m31684d(UniPayTripHttpServiceImpl.f44590a, "success [" + str2 + "] : " + str);
                            if (payServiceResponseCallback2 != null) {
                                Object objectFromJson = C14489Util.objectFromJson(str, cls2);
                                if (objectFromJson != null) {
                                    if (interceptor2 != null) {
                                        interceptor2.onSuccess(objectFromJson);
                                    }
                                    payServiceResponseCallback2.onSuccess(objectFromJson);
                                    return;
                                }
                                payServiceResponseCallback2.onFail(new Error(-1, UniPayTripHttpServiceImpl.this.mContext.getString(R.string.oc_pay_net_failed)));
                                return;
                            }
                            return;
                        }
                        LogUtil.m31684d(UniPayTripHttpServiceImpl.f44590a, "fail [" + str2 + "] : " + baseResponse.errno + " - " + baseResponse.errmsg);
                        if (payServiceResponseCallback2 != null) {
                            payServiceResponseCallback2.onFail(new Error(baseResponse.errno, baseResponse.errmsg));
                            return;
                        }
                        return;
                    }
                    LogUtil.m31684d(UniPayTripHttpServiceImpl.f44590a, "fail [" + str2 + "] : " + httpRpcResponse.getStatus() + " - " + httpRpcResponse.getReason());
                    if (payServiceResponseCallback2 != null) {
                        payServiceResponseCallback2.onFail(new Error(httpRpcResponse.getStatus(), UniPayTripHttpServiceImpl.this.mContext.getString(R.string.oc_pay_net_failed)));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    PayServiceResponseCallback payServiceResponseCallback = payServiceResponseCallback2;
                    if (payServiceResponseCallback != null) {
                        payServiceResponseCallback.onFail(new Error(-1, UniPayTripHttpServiceImpl.this.mContext.getString(R.string.oc_pay_net_failed)));
                    }
                }
            }

            public void onFailure(HttpRpcRequest httpRpcRequest, IOException iOException) {
                LogUtil.m31684d(UniPayTripHttpServiceImpl.f44590a, "fail [" + str2 + "] : " + iOException.getMessage());
                PayServiceResponseCallback payServiceResponseCallback = payServiceResponseCallback2;
                if (payServiceResponseCallback != null) {
                    payServiceResponseCallback.onFail(new Error(-1, UniPayTripHttpServiceImpl.this.mContext.getString(R.string.oc_pay_net_failed)));
                }
            }
        };
    }

    class MainThreadCallback<T> implements PayServiceResponseCallback<T> {
        /* access modifiers changed from: private */
        public PayServiceCallback mCallback;

        MainThreadCallback(PayServiceCallback payServiceCallback) {
            LogUtil.m31685fi(UniPayTripHttpServiceImpl.f44590a, "PayServiceCallback:" + payServiceCallback);
            this.mCallback = payServiceCallback;
        }

        public void onSuccess(final T t) {
            UiThreadHandler.post(new Runnable() {
                public void run() {
                    LogUtil.m31685fi(UniPayTripHttpServiceImpl.f44590a, "UiThreadHandler onSuccess mCallback:" + MainThreadCallback.this.mCallback + " isViewDestroyed:" + UniPayTripHttpServiceImpl.this.isViewDestroyed);
                    if (MainThreadCallback.this.mCallback != null && !UniPayTripHttpServiceImpl.this.isViewDestroyed) {
                        MainThreadCallback.this.mCallback.onSuccess(t);
                    }
                }
            });
        }

        public void onFail(final Error error) {
            UiThreadHandler.post(new Runnable() {
                public void run() {
                    LogUtil.m31685fi(UniPayTripHttpServiceImpl.f44590a, "UiThreadHandler onFail mCallback:" + MainThreadCallback.this.mCallback + " isViewDestroyed:" + UniPayTripHttpServiceImpl.this.isViewDestroyed);
                    if (MainThreadCallback.this.mCallback != null && !UniPayTripHttpServiceImpl.this.isViewDestroyed) {
                        MainThreadCallback.this.mCallback.onFail(error);
                    }
                }
            });
        }

        public void setResponse(HttpRpcResponse httpRpcResponse) {
            PayServiceCallback payServiceCallback = this.mCallback;
            if (payServiceCallback instanceof PayServiceResponseCallback) {
                ((PayServiceResponseCallback) payServiceCallback).setResponse(httpRpcResponse);
            }
        }
    }
}
