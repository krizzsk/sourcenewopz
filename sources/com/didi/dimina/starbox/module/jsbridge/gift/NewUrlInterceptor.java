package com.didi.dimina.starbox.module.jsbridge.gift;

import android.text.TextUtils;
import com.didi.dimina.starbox.module.jsbridge.bean.GiftBean;

public class NewUrlInterceptor extends Interceptor<String, GiftBean> {
    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public InterceptorResult<GiftBean> onExecute(String str) throws Exception {
        if (!TextUtils.isEmpty(str)) {
            try {
                GiftBean b = m13499b(str);
                if (!TextUtils.isEmpty(b.getAppUrl()) && !TextUtils.isEmpty(b.getJssdkversion()) && !TextUtils.isEmpty(b.getSdkUrl())) {
                    return new InterceptorResult<>(b);
                }
                throw new Exception("appUrl=null 或 jssdkversion=null 或sdkUrl=null ！");
            } catch (Exception unused) {
                throw new Exception("UrlInterceptor传参格式错误！");
            }
        } else {
            throw new Exception("下载路径url为空！");
        }
    }

    /* renamed from: b */
    private GiftBean m13499b(String str) {
        GiftBean giftBean = new GiftBean();
        giftBean.setdUrl(str);
        String[] split = str.split("&&");
        giftBean.setAppId(split[1]);
        giftBean.setAppUrl(split[2]);
        giftBean.setSdkUrl(split[3]);
        giftBean.setJssdkversion(split[4]);
        giftBean.setEnv(split[5]);
        giftBean.setVersionId(split[6]);
        return giftBean;
    }
}
