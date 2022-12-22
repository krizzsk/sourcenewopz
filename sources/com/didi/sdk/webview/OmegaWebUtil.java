package com.didi.sdk.webview;

import com.didi.sdk.webview.tool.WebViewToolModel;
import com.didi.soda.web.config.WebConstant;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OmegaWebUtil {
    public static final String CHANNEL = "chanel";
    public static final String SHARE_CHANNEL_CLICK = "share_chanel_ck";
    public static final String SHARE_WINDOW_SHOW = "share_window_sw";
    public static final String SOURCE = "source";
    public static final String TYPE = "type";
    public static final int TYPE_H5 = 2;

    public static void trackSharePagedShow(List<WebViewToolModel> list, String str) {
        if (list != null && !list.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).onkKeyShareModel != null) {
                    sb.append(m27160a(list.get(i).onkKeyShareModel.getPlatform()));
                    if (i < list.size() - 1) {
                        sb.append("、");
                    }
                }
            }
            HashMap hashMap = new HashMap();
            hashMap.put("chanel", sb.toString());
            hashMap.put("type", 2);
            hashMap.put("source", str);
            OmegaSDKAdapter.trackEvent("share_window_sw", (Map<String, Object>) hashMap);
        }
    }

    public static void trackShareChannelClick(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("chanel", m27160a(str));
        hashMap.put("type", 2);
        hashMap.put("source", str2);
        OmegaSDKAdapter.trackEvent("share_chanel_ck", (Map<String, Object>) hashMap);
    }

    /* renamed from: a */
    private static String m27160a(String str) {
        if (WebConstant.WXCHAT_PLATFORM.equals(str)) {
            return "wechat";
        }
        if (WebConstant.WXMOMENTS_PLATFORM.equals(str)) {
            return "moments";
        }
        if (WebConstant.QQ_PLATFORM.equals(str)) {
            return WebConstant.QQ_PLATFORM;
        }
        if (WebConstant.QZONE_PLATFORM.equals(str)) {
            return "QQzone";
        }
        if ("ALIPAY_FRIENDS".equals(str)) {
            return "alipay";
        }
        return "ALIPAY_TIMELINE".equals(str) ? "life" : str;
    }
}
