package com.didi.universal.pay.sdk.net;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.os.Build;
import android.text.TextUtils;
import com.didi.payment.base.utils.PayBaseParamUtil;
import com.didi.sdk.util.SystemUtil;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.universal.pay.sdk.method.internal.PayServiceCallback;
import com.didi.universal.pay.sdk.method.model.BasicPayInfo;
import com.didi.universal.pay.sdk.method.model.DeductionInfo;
import com.didi.universal.pay.sdk.method.model.PayBillDetail;
import com.didi.universal.pay.sdk.method.model.PayInfo;
import com.didi.universal.pay.sdk.method.model.PayStatus;
import com.didi.universal.pay.sdk.method.model.PrepayInfo;
import com.didi.universal.pay.sdk.method.model.SubChannel;
import com.didi.universal.pay.sdk.method.model.UniversalPayChannelResponse;
import com.didi.universal.pay.sdk.model.UniversalPayParams;
import com.didi.universal.pay.sdk.net.IUniversalPayHttp;
import com.didi.universal.pay.sdk.net.api.Api;
import com.didi.universal.pay.sdk.net.api.nontrip.GetDepositInfo;
import com.didi.universal.pay.sdk.net.api.trip.GetBillDetail;
import com.didi.universal.pay.sdk.net.api.trip.GetPayBasicInfo;
import com.didi.universal.pay.sdk.net.config.UniversalNetConfig;
import com.didi.universal.pay.sdk.net.model.BaseParam;
import com.didi.universal.pay.sdk.net.model.BaseResponse;
import com.didi.universal.pay.sdk.net.model.Error;
import com.didi.universal.pay.sdk.util.DeviceUtil;
import com.didi.universal.pay.sdk.util.JsonUtil;
import com.didi.universal.pay.sdk.util.LogUtil;
import com.didichuxing.foundation.net.http.HttpBody;
import com.didichuxing.foundation.net.rpc.http.HttpRpc;
import com.didichuxing.foundation.net.rpc.http.HttpRpcClient;
import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;
import com.didichuxing.foundation.net.rpc.http.HttpRpcResponse;
import com.didichuxing.foundation.p188io.StringDeserializer;
import com.google.gson.JsonElement;
import com.taxis99.R;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class AbsUniversalPayHttp implements IUniversalPayHttp {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f45114a = AbsUniversalPayHttp.class.getSimpleName();
    protected List<String> arrSelectedPayChannels = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Context f45115b;

    /* renamed from: c */
    private UniversalNetConfig f45116c;

    /* renamed from: d */
    private HttpRpcClient f45117d;

    /* renamed from: e */
    private HttpHelper f45118e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f45119f;
    protected int hasDeduction;
    protected String mCouponId;
    protected int mEnterpriseType;
    protected String mMonthlyCardId;
    public UniversalPayParams mPayParams;
    protected String mSelectedPayChannel;
    protected String mWantPayChannel;

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract Object mo113153a();

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract Object mo113154a(int i);

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract Object mo113155a(String str, String str2);

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public abstract Object mo113156b();

    public AbsUniversalPayHttp(Context context, UniversalPayParams universalPayParams) {
        this.f45115b = context;
        this.mPayParams = universalPayParams;
        this.f45116c = new UniversalNetConfig(universalPayParams.isTrip, this.mPayParams.isOnline);
        if (!this.mPayParams.isOnline && !TextUtils.isEmpty(this.mPayParams.mOfflineURL)) {
            if (universalPayParams.isTrip) {
                this.f45116c.setTripSdkOfflineEnv(this.mPayParams.mOfflineURL);
            } else {
                this.f45116c.setNonTripSdkOfflineEnv(this.mPayParams.mOfflineURL);
            }
        }
        this.f45116c.resetDomain(universalPayParams.domain);
        HttpHelper httpHelper = new HttpHelper();
        this.f45118e = httpHelper;
        this.f45117d = httpHelper.getHttpClient(this.f45115b);
    }

    public void getBasicInfo(PayServiceCallback<BasicPayInfo> payServiceCallback) {
        request(new GetPayBasicInfo(), payServiceCallback, (IUniversalPayHttp.Interceptor) null, BasicPayInfo.class);
    }

    public void getDepositInfo(String str, String str2, String str3, PayServiceCallback<PayInfo> payServiceCallback) {
        GetDepositInfo getDepositInfo = new GetDepositInfo();
        getDepositInfo.sign = str;
        getDepositInfo.sign_type = str2;
        getDepositInfo.biz_content = str3;
        request(getDepositInfo, payServiceCallback, new IUniversalPayHttp.Interceptor<PayInfo>() {
            public void onSuccess(PayInfo payInfo) {
                if (payInfo != null) {
                    AbsUniversalPayHttp.this.interceptPayInfo(payInfo);
                }
            }
        }, PayInfo.class);
    }

    public void getPayInfo(PayServiceCallback<PayInfo> payServiceCallback) {
        request(mo113153a(), payServiceCallback, new IUniversalPayHttp.Interceptor<PayInfo>() {
            public void onSuccess(PayInfo payInfo) {
                if (payInfo != null) {
                    AbsUniversalPayHttp.this.interceptPayInfo(payInfo);
                }
            }
        }, PayInfo.class);
    }

    public void setCouponID(String str) {
        this.mCouponId = str;
    }

    public void setMonthlyCardIDandDeduction(String str, int i) {
        this.mMonthlyCardId = str;
        this.hasDeduction = i;
    }

    public void setEnterprisePayType(int i) {
        this.mEnterpriseType = i;
        this.mWantPayChannel = "" + i;
    }

    public void setPayMethod(int i, String str) {
        if (TextUtils.isEmpty(str)) {
            this.mWantPayChannel = "" + i;
            this.mSelectedPayChannel = "" + i;
            return;
        }
        this.mWantPayChannel = i + "+" + str;
        this.mSelectedPayChannel = i + "+" + str;
    }

    public void changePayInfo(int i, PayServiceCallback<PayInfo> payServiceCallback) {
        request(mo113154a(i), payServiceCallback, new IUniversalPayHttp.Interceptor<PayInfo>() {
            public void onSuccess(PayInfo payInfo) {
                AbsUniversalPayHttp.this.interceptPayInfo(payInfo);
            }
        }, PayInfo.class);
    }

    public void prepay(String str, String str2, PayServiceCallback<PrepayInfo> payServiceCallback) {
        request(mo113155a(str, str2), payServiceCallback, new IUniversalPayHttp.Interceptor<PrepayInfo>() {
            public void onSuccess(PrepayInfo prepayInfo) {
            }
        }, PrepayInfo.class);
    }

    public void getPayStatus(PayServiceCallback<PayStatus> payServiceCallback) {
        request(mo113156b(), payServiceCallback, new IUniversalPayHttp.Interceptor<PayStatus>() {
            public void onSuccess(PayStatus payStatus) {
            }
        }, PayStatus.class);
    }

    public void getBillDetail(PayServiceCallback<PayBillDetail> payServiceCallback) {
        GetBillDetail getBillDetail = new GetBillDetail();
        getBillDetail.oid = this.mPayParams.oid;
        getBillDetail.token = PayBaseParamUtil.getStringParam(this.f45115b, "token");
        request(getBillDetail, payServiceCallback, (IUniversalPayHttp.Interceptor) null, PayBillDetail.class);
    }

    public String getPayChannels() {
        List<String> list = this.arrSelectedPayChannels;
        if (list == null || list.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = this.arrSelectedPayChannels.iterator();
        synchronized (it) {
            while (it != null) {
                if (!it.hasNext()) {
                    break;
                }
                sb.append(it.next() + ",");
            }
        }
        return sb.length() > 0 ? sb.substring(0, sb.length() - 1) : "";
    }

    public void onDestroy() {
        this.f45119f = true;
    }

    /* access modifiers changed from: protected */
    public <T> void request(Object obj, PayServiceCallback<T> payServiceCallback, IUniversalPayHttp.Interceptor<T> interceptor, Class<T> cls) {
        Api api = (Api) obj.getClass().getAnnotation(Api.class);
        if (api != null) {
            String name = api.name();
            String str = f45114a;
            LogUtil.m32410fi(str, "unified pay request [" + name + "] : " + JsonUtil.jsonFromObject(obj));
            createAndPostRequest(name, obj, payServiceCallback, interceptor, cls);
        }
    }

    /* access modifiers changed from: protected */
    public <T> Object createAndPostRequest(String str, Object obj, PayServiceCallback<T> payServiceCallback, IUniversalPayHttp.Interceptor<T> interceptor, Class<T> cls) {
        String str2;
        String str3 = this.f45116c.getBaseUrl() + str;
        LogUtil.m32408d(f45114a, "url : " + str3);
        try {
            str2 = this.f45118e.createBody(buildBaseParams(), obj, this.f45115b);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            str2 = "";
        }
        LogUtil.m32408d(f45114a, "request body : " + str2);
        return this.f45117d.newRpc(new HttpRpcRequest.Builder().addHeaders((Iterable) this.f45118e.getHeaders()).post(str3, HttpBody.newInstance("application/x-www-form-urlencoded", str2)).setTag((Object) str).build()).enqueue(m32389a(str, new MainThreadCallback(payServiceCallback), interceptor, cls));
    }

    /* renamed from: a */
    private <T> HttpRpc.Callback m32389a(String str, PayServiceCallback<T> payServiceCallback, IUniversalPayHttp.Interceptor<T> interceptor, Class<T> cls) {
        final String str2 = str;
        final PayServiceCallback<T> payServiceCallback2 = payServiceCallback;
        final Class<T> cls2 = cls;
        final IUniversalPayHttp.Interceptor<T> interceptor2 = interceptor;
        return new HttpRpc.Callback() {
            public void onSuccess(HttpRpcResponse httpRpcResponse) {
                try {
                    if (httpRpcResponse.getStatus() == 200) {
                        BaseResponse baseResponse = (BaseResponse) JsonUtil.objectFromJson(new StringDeserializer().deserialize(httpRpcResponse.getEntity().getContent()), BaseResponse.class);
                        if (baseResponse.errno == 0) {
                            JsonElement jsonElement = baseResponse.data;
                            String str = "{}";
                            if (jsonElement != null) {
                                str = jsonElement.toString();
                            }
                            String c = AbsUniversalPayHttp.f45114a;
                            LogUtil.m32408d(c, "success [" + str2 + "] : " + str);
                            if (payServiceCallback2 != null) {
                                Object objectFromJson = JsonUtil.objectFromJson(str, cls2);
                                if (objectFromJson != null) {
                                    if (interceptor2 != null) {
                                        interceptor2.onSuccess(objectFromJson);
                                    }
                                    payServiceCallback2.onSuccess(objectFromJson);
                                    return;
                                }
                                payServiceCallback2.onFail(new Error(-1, AbsUniversalPayHttp.this.f45115b.getString(R.string.universal_net_failed)));
                                return;
                            }
                            return;
                        }
                        String c2 = AbsUniversalPayHttp.f45114a;
                        LogUtil.m32408d(c2, "fail [" + str2 + "] : " + baseResponse.errno + " - " + baseResponse.errmsg);
                        if (payServiceCallback2 != null) {
                            payServiceCallback2.onFail(new Error(baseResponse.errno, baseResponse.errmsg));
                            return;
                        }
                        return;
                    }
                    String c3 = AbsUniversalPayHttp.f45114a;
                    LogUtil.m32408d(c3, "fail [" + str2 + "] : " + httpRpcResponse.getStatus() + " - " + httpRpcResponse.getReason());
                    if (payServiceCallback2 != null) {
                        payServiceCallback2.onFail(new Error(httpRpcResponse.getStatus(), AbsUniversalPayHttp.this.f45115b.getString(R.string.universal_net_failed)));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    PayServiceCallback payServiceCallback = payServiceCallback2;
                    if (payServiceCallback != null) {
                        payServiceCallback.onFail(new Error(-1, AbsUniversalPayHttp.this.f45115b.getString(R.string.universal_net_failed)));
                    }
                }
            }

            public void onFailure(HttpRpcRequest httpRpcRequest, IOException iOException) {
                String c = AbsUniversalPayHttp.f45114a;
                LogUtil.m32408d(c, "fail [" + str2 + "] : " + iOException.getMessage());
                PayServiceCallback payServiceCallback = payServiceCallback2;
                if (payServiceCallback != null) {
                    payServiceCallback.onFail(new Error(-1, AbsUniversalPayHttp.this.f45115b.getString(R.string.universal_net_failed)));
                }
            }
        };
    }

    class MainThreadCallback<T> implements PayServiceCallback<T> {
        /* access modifiers changed from: private */
        public PayServiceCallback mCallback;

        MainThreadCallback(PayServiceCallback payServiceCallback) {
            String c = AbsUniversalPayHttp.f45114a;
            LogUtil.m32410fi(c, "PayServiceCallback:" + payServiceCallback);
            this.mCallback = payServiceCallback;
        }

        public void onSuccess(final T t) {
            UiThreadHandler.post(new Runnable() {
                public void run() {
                    String c = AbsUniversalPayHttp.f45114a;
                    LogUtil.m32410fi(c, "UiThreadHandler onSuccess mCallback:" + MainThreadCallback.this.mCallback + " isViewDestroyed:" + AbsUniversalPayHttp.this.f45119f);
                    if (MainThreadCallback.this.mCallback != null && !AbsUniversalPayHttp.this.f45119f) {
                        MainThreadCallback.this.mCallback.onSuccess(t);
                    }
                }
            });
        }

        public void onFail(final Error error) {
            UiThreadHandler.post(new Runnable() {
                public void run() {
                    String c = AbsUniversalPayHttp.f45114a;
                    LogUtil.m32410fi(c, "UiThreadHandler onFail mCallback:" + MainThreadCallback.this.mCallback + " isViewDestroyed:" + AbsUniversalPayHttp.this.f45119f);
                    if (MainThreadCallback.this.mCallback != null && !AbsUniversalPayHttp.this.f45119f) {
                        MainThreadCallback.this.mCallback.onFail(error);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void interceptPayInfo(PayInfo payInfo) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        PayInfo payInfo2 = payInfo;
        this.arrSelectedPayChannels.clear();
        if (payInfo2.billDetail != null) {
            DeductionInfo[] deductionInfoArr = payInfo2.billDetail.deductions;
            if (deductionInfoArr == null || deductionInfoArr.length <= 0) {
                z3 = false;
                z2 = false;
                z = false;
            } else {
                z3 = false;
                z2 = false;
                z = false;
                for (DeductionInfo deductionInfo : deductionInfoArr) {
                    if (deductionInfo.type == 1) {
                        this.mCouponId = deductionInfo.couponId;
                        z3 = true;
                    } else if (deductionInfo.type == 5) {
                        this.mMonthlyCardId = deductionInfo.deduction_id;
                        z = true;
                    } else if (deductionInfo.type == 6 && (deductionInfo.status == 1 || deductionInfo.status == 5)) {
                        this.hasDeduction = 1;
                        z2 = true;
                    }
                }
            }
            if (!z3) {
                this.mCouponId = "";
            }
            if (!z) {
                this.mMonthlyCardId = "";
            }
            if (!z2) {
                this.hasDeduction = 0;
            }
            UniversalPayChannelResponse[] universalPayChannelResponseArr = payInfo2.billDetail.externalChannels;
            if (universalPayChannelResponseArr == null || universalPayChannelResponseArr.length <= 0) {
                z4 = false;
            } else {
                z4 = false;
                for (UniversalPayChannelResponse universalPayChannelResponse : universalPayChannelResponseArr) {
                    if (universalPayChannelResponse.selected == 1) {
                        this.mSelectedPayChannel = "" + universalPayChannelResponse.channel_id;
                        if ((universalPayChannelResponse.channel_id == 150 || universalPayChannelResponse.channel_id == 192) && !TextUtils.isEmpty(universalPayChannelResponse.selected_sub_id) && universalPayChannelResponse.sub_channels != null && universalPayChannelResponse.sub_channels.length > 0) {
                            for (SubChannel subChannel : universalPayChannelResponse.sub_channels) {
                                if (subChannel.sub_id.equals(universalPayChannelResponse.selected_sub_id)) {
                                    this.mSelectedPayChannel = universalPayChannelResponse.channel_id + "+" + subChannel.sub_id;
                                    this.arrSelectedPayChannels.add(universalPayChannelResponse.channel_id + "+" + subChannel.sub_id);
                                }
                            }
                        } else {
                            this.arrSelectedPayChannels.add("" + universalPayChannelResponse.channel_id);
                        }
                        z4 = true;
                    }
                }
            }
            if (!z4) {
                this.mSelectedPayChannel = "";
            }
            UniversalPayChannelResponse[] universalPayChannelResponseArr2 = payInfo2.billDetail.internalChannels;
            if (universalPayChannelResponseArr2 == null || universalPayChannelResponseArr2.length <= 0) {
                z6 = false;
                z5 = false;
            } else {
                z6 = false;
                z5 = false;
                for (UniversalPayChannelResponse universalPayChannelResponse2 : universalPayChannelResponseArr2) {
                    if (universalPayChannelResponse2.channel_id == 121) {
                        z5 = universalPayChannelResponse2.selected == 1;
                        z6 = true;
                    }
                    if (universalPayChannelResponse2.selected == 1) {
                        this.mSelectedPayChannel = "" + universalPayChannelResponse2.channel_id;
                        this.arrSelectedPayChannels.add("" + universalPayChannelResponse2.channel_id);
                    }
                }
            }
            if (!z6) {
                this.mEnterpriseType = 0;
            } else if (z5) {
                this.mEnterpriseType = 21;
            } else {
                this.mEnterpriseType = 20;
            }
        }
        if (!TextUtils.isEmpty(payInfo2.outTradeId)) {
            this.mPayParams.outTradeId = payInfo2.outTradeId;
        }
    }

    /* access modifiers changed from: protected */
    public Map<String, String> buildBaseParams() {
        String str;
        HashMap hashMap = new HashMap();
        hashMap.put("vcode", SystemUtil.getVersionCode() + "");
        hashMap.put("appversion", SystemUtil.getVersionName(this.f45115b));
        hashMap.put("model", SystemUtil.getModel());
        hashMap.put("os", Build.VERSION.RELEASE);
        hashMap.put("imei", SystemUtil.getIMEI());
        hashMap.put("channel", SystemUtil.getChannelId());
        hashMap.put("datatype", "1");
        hashMap.put("_t", System.currentTimeMillis() + "");
        hashMap.put("nonce_str", System.currentTimeMillis() + "");
        WifiInfo wifiInfo = SystemUtil.getWifiInfo(this.f45115b);
        if (wifiInfo != null) {
            str = wifiInfo.getSSID();
        } else {
            str = "";
        }
        hashMap.put("ssid", str);
        hashMap.put("wsgsig", "");
        hashMap.put(BaseParam.PARAM_ISUNIVERSAL, "1");
        UniversalPayParams universalPayParams = this.mPayParams;
        if (universalPayParams != null) {
            hashMap.put("oid", universalPayParams.oid);
            hashMap.put("product_id", this.mPayParams.bid + "");
            if (this.mPayParams.terminalId > 0) {
                hashMap.put("terminal_id", "" + this.mPayParams.terminalId);
            }
        }
        try {
            hashMap.put("lang", PayBaseParamUtil.getStringParam(this.f45115b, "lang"));
            hashMap.put("suuid", PayBaseParamUtil.getStringParam(this.f45115b, "suuid"));
            hashMap.put("uuid", PayBaseParamUtil.getStringParam(this.f45115b, "uuid"));
            hashMap.put("device_id", PayBaseParamUtil.getStringParam(this.f45115b, "dviceid"));
            hashMap.put("token", PayBaseParamUtil.getStringParam(this.f45115b, "token"));
            hashMap.put("app_uni_id", DeviceUtil.getPackageName(this.f45115b));
        } catch (Exception e) {
            e.printStackTrace();
        }
        String str2 = f45114a;
        LogUtil.m32410fi(str2, "buildBaseParams-> " + hashMap.toString());
        return hashMap;
    }
}
