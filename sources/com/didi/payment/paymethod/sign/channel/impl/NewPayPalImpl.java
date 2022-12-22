package com.didi.payment.paymethod.sign.channel.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.didi.payment.base.proxy.LoadingProxyHolder;
import com.didi.payment.base.router.ActivityLauncher;
import com.didi.payment.paymethod.open.callback.Callback;
import com.didi.payment.paymethod.server.global.GlobalPayMethodModel;
import com.didi.payment.paymethod.server.global.request.SignPollingQueryReq;
import com.didi.payment.paymethod.server.global.request.SignReq;
import com.didi.payment.paymethod.server.global.response.SignPollingQueryResp;
import com.didi.payment.paymethod.server.global.response.SignResultResp;
import com.didi.payment.paymethod.sign.channel.ISimpleSignChannel;
import com.didi.payment.paymethod.sign.channel.paypal.activity.PayPalSignDetailActivity;
import com.didi.payment.paymethod.sign.channel.paypal.activity.PayPalSignWebActivity;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didichuxing.foundation.rpc.RpcService;
import java.io.IOException;
import java.util.HashMap;

public class NewPayPalImpl implements ISimpleSignChannel {
    public void sign(HashMap<String, Object> hashMap, final Callback callback) {
        final Activity b = m21758b(hashMap, "context");
        int c = m21760c(hashMap, ParamConst.PARAM_BIND_TYPE);
        if (b != null) {
            m21759b();
            GlobalPayMethodModel globalPayMethodModel = new GlobalPayMethodModel(b);
            SignReq signReq = new SignReq();
            signReq.bindType = c;
            signReq.channelId = 183;
            globalPayMethodModel.sign(signReq, new RpcService.Callback<SignResultResp>() {
                public void onSuccess(SignResultResp signResultResp) {
                    NewPayPalImpl.m21761c();
                    if (signResultResp != null) {
                        if (signResultResp.errNo == 0) {
                            NewPayPalImpl.this.m21756a(b, signResultResp.newSignUrl, signResultResp.backUrl, signResultResp.pollingTimes, signResultResp.pollingFrequency, callback);
                        } else {
                            callback.onResult(-2, signResultResp.errMsg, "");
                        }
                    }
                }

                public void onFailure(IOException iOException) {
                    NewPayPalImpl.m21761c();
                    callback.onResult(-2, "", "");
                }
            });
        }
    }

    public void cancelSign(HashMap<String, Object> hashMap, final Callback callback) {
        Activity b = m21758b(hashMap, "context");
        String d = m21762d(hashMap, "email");
        if (b != null) {
            PayPalSignDetailActivity.launch(b, d, new ActivityLauncher.Callback() {
                public void onActivityResult(int i, Intent intent) {
                    if (i == -1) {
                        callback.onResult(0, "", "");
                    } else {
                        callback.onResult(-1, "", "");
                    }
                }
            });
        }
    }

    public void querySignStatus(HashMap<String, Object> hashMap, final Callback callback) {
        Context a;
        if (callback != null && (a = m21754a(hashMap, "context")) != null) {
            GlobalPayMethodModel globalPayMethodModel = new GlobalPayMethodModel(a);
            SignPollingQueryReq signPollingQueryReq = new SignPollingQueryReq();
            signPollingQueryReq.channelId = 183;
            signPollingQueryReq.pollingTimes = 1;
            globalPayMethodModel.pollSignStatus(signPollingQueryReq, new RpcService.Callback<SignPollingQueryResp>() {
                public void onSuccess(SignPollingQueryResp signPollingQueryResp) {
                    if (signPollingQueryResp != null) {
                        if (signPollingQueryResp.errNo == 0) {
                            callback.onResult(0, "", "");
                        } else {
                            callback.onResult(-2, signPollingQueryResp.errMsg, "");
                        }
                    }
                }

                public void onFailure(IOException iOException) {
                    callback.onResult(-2, "", "");
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m21756a(Activity activity, String str, String str2, int i, int i2, final Callback callback) {
        if (activity != null && callback != null) {
            PayPalSignWebActivity.launch(activity, str, str2, i, i2, new ActivityLauncher.Callback() {
                public void onActivityResult(int i, Intent intent) {
                    if (i == -1) {
                        callback.onResult(0, "", "");
                    } else {
                        callback.onResult(-1, "", "");
                    }
                }
            });
        }
    }

    /* renamed from: a */
    private Context m21754a(HashMap<String, Object> hashMap, String str) {
        if (hashMap != null && !TextUtils.isEmpty(str)) {
            Object obj = hashMap.get(str);
            if (obj instanceof Context) {
                return (Context) obj;
            }
            if (obj instanceof Fragment) {
                return ((Fragment) obj).getContext();
            }
        }
        return null;
    }

    /* renamed from: b */
    private Activity m21758b(HashMap<String, Object> hashMap, String str) {
        if (hashMap != null && !TextUtils.isEmpty(str)) {
            Object obj = hashMap.get(str);
            if (obj instanceof Activity) {
                return (Activity) obj;
            }
            if (obj instanceof Fragment) {
                return ((Fragment) obj).getActivity();
            }
        }
        return null;
    }

    /* renamed from: c */
    private int m21760c(HashMap<String, Object> hashMap, String str) {
        if (hashMap != null && !TextUtils.isEmpty(str)) {
            Object obj = hashMap.get(str);
            if (obj instanceof Integer) {
                return ((Integer) obj).intValue();
            }
        }
        return 0;
    }

    /* renamed from: d */
    private String m21762d(HashMap<String, Object> hashMap, String str) {
        if (hashMap != null && !TextUtils.isEmpty(str)) {
            Object obj = hashMap.get(str);
            if (obj instanceof String) {
                return (String) obj;
            }
        }
        return "";
    }

    /* renamed from: b */
    private static void m21759b() {
        if (LoadingProxyHolder.getProxy() != null) {
            LoadingProxyHolder.getProxy().showLoading();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static void m21761c() {
        if (LoadingProxyHolder.getProxy() != null) {
            LoadingProxyHolder.getProxy().dismissLoading();
        }
    }
}
