package com.didi.dimina.starbox.module.jsbridge.gift;

import android.text.TextUtils;
import com.didi.dimina.container.Dimina;
import com.didi.dimina.starbox.module.jsbridge.bean.GiftBean;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedHashMap;

public class UrlInterceptor extends Interceptor<String, GiftBean> {
    public static final String TAG = "UrlInterceptor";

    public InterceptorResult<GiftBean> onExecute(String str) throws Exception {
        if (TextUtils.isEmpty(str) || !str.contains("?")) {
            throw new Exception("下载路径url为空或未找到可用参数！");
        }
        try {
            GiftBean a = m13501a(str);
            if (a != null && !TextUtils.isEmpty(a.getJsSdkId()) && !TextUtils.isEmpty(a.getJssdkversion())) {
                return new InterceptorResult<>(a);
            }
            throw new Exception("appid=null 或 jssdkversion=null！");
        } catch (URISyntaxException unused) {
            throw new Exception("UrlInterceptor传参格式错误！");
        }
    }

    /* renamed from: a */
    private GiftBean m13501a(String str) throws URISyntaxException {
        GiftBean giftBean = new GiftBean();
        giftBean.setdUrl(str);
        String query = new URI(str).getQuery();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (String str2 : query.split(ParamKeys.SIGN_AND)) {
            int indexOf = str2.indexOf("=");
            linkedHashMap.put(str2.substring(0, indexOf), str2.substring(indexOf + 1));
        }
        giftBean.setJsSdkId((String) linkedHashMap.get("appid"));
        giftBean.setJssdkversion((String) linkedHashMap.get("jssdkversion"));
        if (TextUtils.isEmpty(giftBean.getJsSdkId())) {
            giftBean.setJsSdkId((String) linkedHashMap.get("jssdkId"));
            if (giftBean.getJsSdkId() == null || giftBean.getJsSdkId().equals("")) {
                giftBean.setJsSdkId(Dimina.getConfig().getJsSdkId());
            }
        }
        if (TextUtils.isEmpty(giftBean.getJssdkversion())) {
            giftBean.setJssdkversion((String) linkedHashMap.get("sdkVersion"));
        }
        giftBean.setAppId((String) linkedHashMap.get("realJsAppId"));
        return giftBean;
    }
}
