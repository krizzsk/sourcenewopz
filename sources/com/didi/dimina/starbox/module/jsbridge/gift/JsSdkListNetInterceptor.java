package com.didi.dimina.starbox.module.jsbridge.gift;

import android.text.TextUtils;
import com.didi.dimina.container.bean.Constant;
import com.didi.dimina.container.util.DomainComplianceUtil;
import com.didi.dimina.starbox.module.jsbridge.bean.GiftBean;
import com.didi.dimina.starbox.module.jsbridge.bean.JssdkBean;
import com.didi.dimina.starbox.module.jsbridge.bean.JssdkData;
import com.didi.dimina.starbox.module.jsbridge.bean.JssdkModuleBean;
import com.didi.dimina.starbox.util.DHttpUtil;
import com.google.gson.Gson;
import java.util.Iterator;

public class JsSdkListNetInterceptor extends Interceptor<GiftBean, JssdkModuleBean> {
    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public InterceptorResult<JssdkModuleBean> onExecute(GiftBean giftBean) throws Exception {
        String jsSdkId = giftBean.getJsSdkId();
        String str = DHttpUtil.get(DomainComplianceUtil.getHttpsColonDoubleSlash() + "dimina.intra.xiaojukeji.com/api/general/getSdkVersions?mait_app_id=" + jsSdkId);
        if (!TextUtils.isEmpty(str)) {
            String jssdkversion = giftBean.getJssdkversion();
            JssdkData jssdkData = (JssdkData) new Gson().fromJson(str, JssdkData.class);
            JssdkModuleBean jssdkModuleBean = null;
            if (!(jssdkData == null || jssdkData.getData() == null)) {
                Iterator<JssdkBean> it = jssdkData.getData().iterator();
                while (it.hasNext()) {
                    JssdkBean next = it.next();
                    Iterator<JssdkModuleBean> it2 = next.getModules().iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        JssdkModuleBean next2 = it2.next();
                        if (Constant.BundleConstant.SDK_MODULE_NAME.equals(next2.getModule_name()) && jssdkversion.equals(next2.getVersion())) {
                            next2.setChannel(next.getChannel());
                            jssdkModuleBean = next2;
                            break;
                        }
                    }
                }
            }
            if (jssdkModuleBean != null) {
                return new InterceptorResult<>(jssdkModuleBean);
            }
            throw new Exception("JsSdkListNetInterceptor cJssdkModuleBean=null！");
        }
        throw new Exception("获取Jssdklist列表数据失败！");
    }
}
