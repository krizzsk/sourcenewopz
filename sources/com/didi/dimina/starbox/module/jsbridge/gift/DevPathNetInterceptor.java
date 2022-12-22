package com.didi.dimina.starbox.module.jsbridge.gift;

import android.text.TextUtils;
import com.didi.dimina.container.util.DomainComplianceUtil;
import com.didi.dimina.starbox.module.jsbridge.bean.JssdkModuleBean;
import com.didi.dimina.starbox.util.DHttpUtil;
import org.json.JSONArray;
import org.json.JSONObject;

public class DevPathNetInterceptor extends Interceptor<JssdkModuleBean, String> {
    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public InterceptorResult<String> onExecute(JssdkModuleBean jssdkModuleBean) throws Exception {
        String str = null;
        if (jssdkModuleBean instanceof JssdkModuleBean) {
            String str2 = (DomainComplianceUtil.getHttpsColonDoubleSlash() + "pkg-manage.chengxinyouxuan.com/") + "api/public_urls?keys=" + jssdkModuleBean.getKey() + "&channel=" + jssdkModuleBean.getChannel();
            String str3 = DHttpUtil.get(str2);
            if (!TextUtils.isEmpty(str3)) {
                JSONArray optJSONArray = new JSONObject(str3).optJSONArray("data");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    str = optJSONArray.optString(0);
                }
                if (TextUtils.isEmpty(str)) {
                    throw new Exception("ZIP 下载路径获取失败：" + str2);
                }
            } else {
                throw new Exception("ZIP 下载内容获取失败：" + str2);
            }
        }
        return new InterceptorResult<>(str);
    }
}
