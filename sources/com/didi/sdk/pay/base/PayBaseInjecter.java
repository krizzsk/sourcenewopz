package com.didi.sdk.pay.base;

import android.content.Context;
import android.text.TextUtils;
import com.didi.payment.base.proxy.CommonProxyHolder;
import com.didi.payment.base.proxy.WebViewProxyHolder;
import com.didi.payment.base.web.WebViewModel;
import com.didi.sdk.pay.base.PayCommonParamsUtil;
import com.didi.sdk.payment.view.browser.WebViewListener;
import com.didi.sdk.payment.view.browser.WebViewModelProxy;
import com.pay99.diff_base.DiffConstants;
import com.pay99.diff_base.DiffUtil;
import com.pay99.diff_base.base.IDcrypto;
import com.pay99.diff_base.base.IDcryptoInitCallback;
import com.pay99.diff_base.base.IDiff;
import java.util.HashMap;

public class PayBaseInjecter {

    /* renamed from: a */
    private static final int f36884a = 0;

    /* renamed from: b */
    private static final int f36885b = 1;

    /* renamed from: c */
    private static final int f36886c = 2;

    /* renamed from: d */
    private static final int f36887d = 3;

    /* renamed from: e */
    private static final int f36888e = 4;

    public static void injectCommonParamsProxy(final PayCommonParamsUtil.CommonParamsProxy commonParamsProxy) {
        CommonProxyHolder.setProxy(new CommonProxyHolder.ICommonProxy() {
            public HashMap<String, Object> getBaseParams(Context context) {
                HashMap<String, Object> addCommonParam = PayCommonParamsUtil.CommonParamsProxy.this.addCommonParam(new HashMap(), context);
                addCommonParam.put("country", PayBaseInjecter.m26129c(context, PayCommonParamsUtil.CommonParamsProxy.this));
                addCommonParam.put("trip_city_id", Integer.valueOf(PayCommonParamsUtil.CommonParamsProxy.this.getStartCityId()));
                addCommonParam.put("trip_country", PayBaseInjecter.m26132d(context, PayCommonParamsUtil.CommonParamsProxy.this));
                addCommonParam.put("currency", PayCommonParamsUtil.CommonParamsProxy.this.getCurrency());
                addCommonParam.put("uid", PayCommonParamsUtil.CommonParamsProxy.this.getUid(context));
                addCommonParam.put("phone", PayBaseInjecter.m26130c(PayCommonParamsUtil.CommonParamsProxy.this.getCommonParam(context), "phone"));
                addCommonParam.put("phone_country_code", PayBaseInjecter.m26130c(PayCommonParamsUtil.CommonParamsProxy.this.getCommonParam(context), "phone_area_code"));
                addCommonParam.put("idfa", PayBaseInjecter.m26130c(PayCommonParamsUtil.CommonParamsProxy.this.getRiskParam(context), "idfa"));
                addCommonParam.put("a3", PayBaseInjecter.m26130c(PayCommonParamsUtil.CommonParamsProxy.this.getRiskParam(context), "a3"));
                addCommonParam.put("ip", PayBaseInjecter.m26130c(PayCommonParamsUtil.CommonParamsProxy.this.getRiskParam(context), "ip"));
                addCommonParam.put("imsi", PayBaseInjecter.m26130c(PayCommonParamsUtil.CommonParamsProxy.this.getRiskParam(context), "phone_imsi"));
                addCommonParam.put("utc_offset", PayBaseInjecter.m26130c(PayCommonParamsUtil.CommonParamsProxy.this.getCommonParam(context), "utc_offset"));
                return addCommonParam;
            }

            public Object getTerminalId(Context context) {
                return PayBaseInjecter.m26131d(PayCommonParamsUtil.CommonParamsProxy.this.getCommonParam(context), "terminal_id");
            }

            public boolean isLogin(Context context) {
                return PayCommonParamsUtil.CommonParamsProxy.this.isLogin(context);
            }

            public void doLogin(Context context) {
                PayCommonParamsUtil.CommonParamsProxy.this.startLogin(context);
            }
        });
        IDiff diffValue = DiffUtil.INSTANCE.getDiffValue(DiffConstants.DIFF_WALLET_DCRYPTO);
        if (diffValue instanceof IDcrypto) {
            ((IDcrypto) diffValue).init(new IDcryptoInitCallback() {
                public HashMap<String, Object> getParams(Context context) {
                    HashMap<String, Object> addCommonParam = PayCommonParamsUtil.CommonParamsProxy.this.addCommonParam(new HashMap(), context);
                    addCommonParam.put("country", PayBaseInjecter.m26129c(context, PayCommonParamsUtil.CommonParamsProxy.this));
                    addCommonParam.put("trip_city_id", Integer.valueOf(PayCommonParamsUtil.CommonParamsProxy.this.getStartCityId()));
                    addCommonParam.put("trip_country", PayBaseInjecter.m26132d(context, PayCommonParamsUtil.CommonParamsProxy.this));
                    addCommonParam.put("currency", PayCommonParamsUtil.CommonParamsProxy.this.getCurrency());
                    addCommonParam.put("uid", PayCommonParamsUtil.CommonParamsProxy.this.getUid(context));
                    addCommonParam.put("phone", PayBaseInjecter.m26130c(PayCommonParamsUtil.CommonParamsProxy.this.getCommonParam(context), "phone"));
                    addCommonParam.put("phone_country_code", PayBaseInjecter.m26130c(PayCommonParamsUtil.CommonParamsProxy.this.getCommonParam(context), "phone_area_code"));
                    addCommonParam.put("idfa", PayBaseInjecter.m26130c(PayCommonParamsUtil.CommonParamsProxy.this.getRiskParam(context), "idfa"));
                    addCommonParam.put("a3", PayBaseInjecter.m26130c(PayCommonParamsUtil.CommonParamsProxy.this.getRiskParam(context), "a3"));
                    addCommonParam.put("ip", PayBaseInjecter.m26130c(PayCommonParamsUtil.CommonParamsProxy.this.getRiskParam(context), "ip"));
                    addCommonParam.put("imsi", PayBaseInjecter.m26130c(PayCommonParamsUtil.CommonParamsProxy.this.getRiskParam(context), "phone_imsi"));
                    addCommonParam.put("utc_offset", PayBaseInjecter.m26130c(PayCommonParamsUtil.CommonParamsProxy.this.getCommonParam(context), "utc_offset"));
                    return addCommonParam;
                }

                public boolean isLogin(Context context) {
                    return PayCommonParamsUtil.CommonParamsProxy.this.isLogin(context);
                }

                public void doLogin(Context context) {
                    PayCommonParamsUtil.CommonParamsProxy.this.startLogin(context);
                }

                public Object getTerminalId(Context context) {
                    return PayBaseInjecter.m26131d(PayCommonParamsUtil.CommonParamsProxy.this.getCommonParam(context), "terminal_id");
                }
            });
        }
    }

    public static void injectWebViewProxy(final WebViewListener webViewListener) {
        WebViewProxyHolder.setProxy(new WebViewProxyHolder.IWebViewProxy() {
            public void callWebActivity(WebViewModel webViewModel) {
                int i = webViewModel.type;
                if (i != 0) {
                    if (i != 1) {
                        int i2 = 2;
                        if (i != 2) {
                            if (i != 3) {
                                if (i == 4 && WebViewListener.this != null) {
                                    WebViewModelProxy webViewModelProxy = new WebViewModelProxy();
                                    webViewModelProxy.setActivity(webViewModel.activity);
                                    webViewModelProxy.setFragment(webViewModel.fragment);
                                    webViewModelProxy.setUrl(webViewModel.url);
                                    webViewModelProxy.setPostData(webViewModel.postData);
                                    webViewModelProxy.setRequestCode(webViewModel.requestCode);
                                    webViewModelProxy.setType(4);
                                    WebViewListener.this.callSignWebActivity(webViewModelProxy);
                                }
                            } else if (WebViewListener.this != null) {
                                WebViewModelProxy webViewModelProxy2 = new WebViewModelProxy();
                                webViewModelProxy2.setActivity(webViewModel.activity);
                                webViewModelProxy2.setFragment(webViewModel.fragment);
                                webViewModelProxy2.setUrl(webViewModel.url);
                                webViewModelProxy2.setPostData(webViewModel.postData);
                                webViewModelProxy2.setRequestCode(webViewModel.requestCode);
                                webViewModelProxy2.setBackUrl(webViewModel.backUrl);
                                webViewModelProxy2.setCancelUrl(webViewModel.cancelUrl);
                                if (webViewModel.activity == null) {
                                    i2 = 3;
                                }
                                webViewModelProxy2.setType(i2);
                                WebViewListener.this.callZftWebActivity(webViewModelProxy2);
                            }
                        } else if (WebViewListener.this != null) {
                            WebViewModelProxy webViewModelProxy3 = new WebViewModelProxy();
                            webViewModelProxy3.setActivity(webViewModel.activity);
                            webViewModelProxy3.setFragment(webViewModel.fragment);
                            webViewModelProxy3.setTitle(webViewModel.title);
                            webViewModelProxy3.setUrl(webViewModel.url);
                            webViewModelProxy3.setRequestCode(webViewModel.requestCode);
                            webViewModelProxy3.setType(3);
                            WebViewListener.this.callPaypalWebView(webViewModelProxy3);
                        }
                    } else if (WebViewListener.this != null) {
                        WebViewModelProxy webViewModelProxy4 = new WebViewModelProxy();
                        webViewModelProxy4.setActivity(webViewModel.activity);
                        webViewModelProxy4.setFragment(webViewModel.fragment);
                        webViewModelProxy4.setTitle(webViewModel.title);
                        webViewModelProxy4.setUrl(webViewModel.url);
                        webViewModelProxy4.setPostData(webViewModel.postData);
                        webViewModelProxy4.setBackUrl(webViewModel.backUrl);
                        webViewModelProxy4.setType(1);
                        WebViewListener.this.callPostWebView(webViewModel.activity, webViewModelProxy4);
                    }
                } else if (WebViewListener.this != null) {
                    WebViewModelProxy webViewModelProxy5 = new WebViewModelProxy();
                    webViewModelProxy5.setActivity(webViewModel.activity);
                    webViewModelProxy5.setFragment(webViewModel.fragment);
                    webViewModelProxy5.setTitle(webViewModel.title);
                    webViewModelProxy5.setUrl(webViewModel.url);
                    webViewModelProxy5.setPostBaseParams(true);
                    webViewModelProxy5.setType(0);
                    WebViewListener.this.callWebView(webViewModelProxy5);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static String m26129c(Context context, PayCommonParamsUtil.CommonParamsProxy commonParamsProxy) {
        String c = m26130c(commonParamsProxy.getCommonParam(context), "location_country");
        return TextUtils.isEmpty(c) ? m26130c(commonParamsProxy.getCommonParam(context), "trip_country") : c;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static String m26132d(Context context, PayCommonParamsUtil.CommonParamsProxy commonParamsProxy) {
        String c = m26130c(commonParamsProxy.getCommonParam(context), "trip_country");
        return TextUtils.isEmpty(c) ? m26130c(commonParamsProxy.getCommonParam(context), "location_country") : c;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static String m26130c(HashMap<String, Object> hashMap, String str) {
        if (hashMap == null) {
            return "";
        }
        Object obj = hashMap.get(str);
        if (obj instanceof String) {
            String str2 = (String) obj;
            if (!TextUtils.isEmpty(str2)) {
                return str2;
            }
        }
        return "";
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static Object m26131d(HashMap<String, Object> hashMap, String str) {
        if (hashMap == null) {
            return null;
        }
        return hashMap.get(str);
    }
}
