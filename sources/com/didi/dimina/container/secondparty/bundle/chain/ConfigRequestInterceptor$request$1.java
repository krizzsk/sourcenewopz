package com.didi.dimina.container.secondparty.bundle.chain;

import android.text.TextUtils;
import android.util.Log;
import com.didi.dimina.container.secondparty.bundle.PmNodeConfigManager;
import com.didi.dimina.container.secondparty.bundle.bean.DMConfigBean;
import com.didi.dimina.container.secondparty.bundle.http.PmHttpCallback;
import com.didi.dimina.container.secondparty.bundle.util.PckErrCode;
import com.didi.dimina.container.secondparty.bundle.util.PmJsonUtil;
import com.didi.dimina.container.util.CollectionsUtil;
import com.didi.dimina.container.util.LogUtil;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0014\u0010\u0003\u001a\u00020\u00042\n\u0010\u0005\u001a\u00060\u0006j\u0002`\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\n"}, mo175978d2 = {"com/didi/dimina/container/secondparty/bundle/chain/ConfigRequestInterceptor$request$1", "Lcom/didi/dimina/container/secondparty/bundle/http/PmHttpCallback;", "", "onFailed", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onSucceed", "result", "2party-impl_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: ConfigRequestInterceptor.kt */
public final class ConfigRequestInterceptor$request$1 implements PmHttpCallback<String> {
    final /* synthetic */ ConfigRequestInterceptor this$0;

    ConfigRequestInterceptor$request$1(ConfigRequestInterceptor configRequestInterceptor) {
        this.this$0 = configRequestInterceptor;
    }

    public void onSucceed(String str) {
        LogUtil.iRelease(ConfigRequestInterceptor.TAG, "onSucceed() = result.length=" + CollectionsUtil.getSize(str));
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                int i = jSONObject.getInt("code");
                if (i == 200) {
                    String jSONObject2 = jSONObject.getJSONObject("data").toString();
                    Intrinsics.checkExpressionValueIsNotNull(jSONObject2, "dataObj.toString()");
                    this.this$0.config.httpDmConfigBean = PmJsonUtil.json2DmConfigBean(jSONObject2);
                    LogUtil.iRelease(ConfigRequestInterceptor.TAG, "转化后的结果=" + this.this$0.config.httpDmConfigBean);
                    if (this.this$0.config.httpDmConfigBean != null) {
                        PmNodeConfigManager.writeConfigRespJsonFile(this.this$0.jsAppId, jSONObject2);
                    }
                    DMConfigBean dMConfigBean = this.this$0.config.httpDmConfigBean;
                    Intrinsics.checkExpressionValueIsNotNull(dMConfigBean, "config.httpDmConfigBean");
                    if (dMConfigBean.getSdkModule() == null) {
                        DMConfigBean dMConfigBean2 = this.this$0.config.httpDmConfigBean;
                        Intrinsics.checkExpressionValueIsNotNull(dMConfigBean2, "config.httpDmConfigBean");
                        if (CollectionsUtil.isEmpty((Collection) dMConfigBean2.getAppModules())) {
                            this.this$0.config.remoteErrCode = PckErrCode.CONFIG_API_APP_SDK_MODULE_BOTH_NULL;
                        }
                    }
                    DMConfigBean dMConfigBean3 = this.this$0.config.httpDmConfigBean;
                    Intrinsics.checkExpressionValueIsNotNull(dMConfigBean3, "config.httpDmConfigBean");
                    if (dMConfigBean3.getSdkModule() == null) {
                        this.this$0.config.remoteErrCode = PckErrCode.CONFIG_API_SDK_MODULE_NULL;
                    } else {
                        DMConfigBean dMConfigBean4 = this.this$0.config.httpDmConfigBean;
                        Intrinsics.checkExpressionValueIsNotNull(dMConfigBean4, "config.httpDmConfigBean");
                        if (CollectionsUtil.isEmpty((Collection) dMConfigBean4.getAppModules())) {
                            this.this$0.config.remoteErrCode = PckErrCode.CONFIG_API_APP_MODULE_NULL;
                        }
                    }
                } else {
                    this.this$0.config.remoteErrCode = PckErrCode.CONFIG_API_NO_SUCC;
                    this.this$0.f17065c = i;
                }
            } else {
                this.this$0.config.remoteErrCode = PckErrCode.CONFIG_REQUEST_RESULT_NULL;
            }
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.eRelease(ConfigRequestInterceptor.TAG, "请求配置接口onSucc发生错误 = " + Log.getStackTraceString(e));
            this.this$0.config.remoteErrCode = PckErrCode.API_CONFIG_SUCC_DEAL_ECEPTION;
        }
        if (this.this$0.f17065c == 0) {
            ConfigRequestInterceptor configRequestInterceptor = this.this$0;
            configRequestInterceptor.f17065c = configRequestInterceptor.config.remoteErrCode == -9999 ? 0 : this.this$0.config.remoteErrCode;
        }
        ConfigRequestInterceptor configRequestInterceptor2 = this.this$0;
        ConfigRequestInterceptor.m12601a(configRequestInterceptor2, configRequestInterceptor2.f17065c == 0 ? 1 : -1, this.this$0.f17065c, (String) null, 4, (Object) null);
        this.this$0.m12602b();
    }

    public void onFailed(Exception exc) {
        Intrinsics.checkParameterIsNotNull(exc, "e");
        LogUtil.eRelease(ConfigRequestInterceptor.TAG, "onFailed() = " + Log.getStackTraceString(exc));
        this.this$0.config.remoteErrCode = PckErrCode.CONFIG_API_FAIL;
        this.this$0.m12600a(-1, (int) PckErrCode.CONFIG_API_FAIL, exc.toString());
        this.this$0.m12602b();
    }
}
