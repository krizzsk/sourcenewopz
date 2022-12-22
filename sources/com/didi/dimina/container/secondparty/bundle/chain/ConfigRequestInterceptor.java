package com.didi.dimina.container.secondparty.bundle.chain;

import android.os.Build;
import android.text.TextUtils;
import com.didi.dimina.container.DMConfig;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.secondparty.DMConfig4Di;
import com.didi.dimina.container.secondparty.bundle.PmConstant;
import com.didi.dimina.container.secondparty.bundle.bean.DMConfigBean;
import com.didi.dimina.container.secondparty.bundle.http.PmHttpUtil;
import com.didi.dimina.container.secondparty.bundle.util.PckErrCode;
import com.didi.dimina.container.secondparty.util.Trace4DiUtil;
import com.didi.dimina.container.service.WsgService;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.util.TextUtil;
import com.didi.unifylogin.api.ILoginStoreApi;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didichuxing.apollo.sdk.Apollo;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u00020\tH\u0002J.\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000b2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0014J\b\u0010\u0014\u001a\u00020\tH\u0002J\b\u0010\u0015\u001a\u00020\fH\u0016J&\u0010\u0016\u001a\u00020\t2\b\b\u0002\u0010\u0017\u001a\u00020\u00042\b\b\u0002\u0010\u0018\u001a\u00020\u00042\b\b\u0002\u0010\u0019\u001a\u00020\fH\u0003J\b\u0010\u001a\u001a\u00020\tH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, mo175978d2 = {"Lcom/didi/dimina/container/secondparty/bundle/chain/ConfigRequestInterceptor;", "Lcom/didi/dimina/container/secondparty/bundle/chain/IPckInterceptor;", "()V", "mHttpRetryCount", "", "mHttpStartTime", "", "mTraceErrCode", "execNextInterceptorOrRetry", "", "getConfigRequestParam", "", "", "", "jsSdkId", "jsAppId", "localConfig", "Lcom/didi/dimina/container/secondparty/bundle/bean/DMConfigBean;", "process", "", "request", "toString", "traceHttpRequestEnd", "result", "errCode", "errMsg", "traceHttpRequestStart", "Companion", "2party-impl_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: ConfigRequestInterceptor.kt */
public final class ConfigRequestInterceptor extends IPckInterceptor {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "Dimina-PM ConfigRequestInterceptor";

    /* renamed from: a */
    private int f17063a;

    /* renamed from: b */
    private long f17064b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f17065c;

    /* renamed from: a */
    private final void m12598a(int i) {
        m12601a(this, i, 0, (String) null, 6, (Object) null);
    }

    /* renamed from: a */
    private final void m12599a(int i, int i2) {
        m12601a(this, i, i2, (String) null, 4, (Object) null);
    }

    /* renamed from: d */
    private final void m12604d() {
        m12601a(this, 0, 0, (String) null, 7, (Object) null);
    }

    /* access modifiers changed from: protected */
    public boolean process() {
        LogUtil.iRelease(TAG, "process() -> config=" + this.config + "\tthis@" + hashCode());
        if (this.config.remoteErrCode != -9999) {
            return true;
        }
        m12597a();
        return false;
    }

    /* renamed from: a */
    private final void m12597a() {
        this.f17063a++;
        String str = this.jsSdkId;
        Intrinsics.checkExpressionValueIsNotNull(str, "jsSdkId");
        String str2 = this.jsAppId;
        Intrinsics.checkExpressionValueIsNotNull(str2, "jsAppId");
        DMConfigBean dMConfigBean = this.config.localDmConfigBean;
        Intrinsics.checkExpressionValueIsNotNull(dMConfigBean, "config.localDmConfigBean");
        Map<String, Object> a = m12596a(str, str2, dMConfigBean);
        LogUtil.iRelease(TAG, "开始请求配置接口 -> " + a);
        m12603c();
        Companion companion = Companion;
        DMMina dMMina = this.mina;
        Intrinsics.checkExpressionValueIsNotNull(dMMina, "mina");
        PmHttpUtil.get(companion.getConfigRequestUrl(dMMina), Companion.getConfigRequestHeader(), a, new ConfigRequestInterceptor$request$1(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m12602b() {
        if (this.config.remoteErrCode == -9999 || this.f17063a >= 2) {
            execNextInterceptor();
            return;
        }
        LogUtil.eRelease(TAG, "请求配置接口出错， 继续重试 " + PckErrCode.code2Msg(this.config.remoteErrCode) + "\t 重试次数:" + this.f17063a);
        this.config.remoteErrCode = -9999;
        m12597a();
    }

    /* renamed from: a */
    private final Map<String, Object> m12596a(String str, String str2, DMConfigBean dMConfigBean) {
        Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("osVersion", "" + Build.VERSION.SDK_INT);
        Dimina.Config config = Dimina.getConfig();
        Intrinsics.checkExpressionValueIsNotNull(config, "Dimina.getConfig()");
        Dimina.AdapterConfig adapterConfig = config.getAdapterConfig();
        Intrinsics.checkExpressionValueIsNotNull(adapterConfig, "Dimina.getConfig().adapterConfig");
        WsgService wsgService = adapterConfig.getWsgService();
        Dimina.Config config2 = Dimina.getConfig();
        Intrinsics.checkExpressionValueIsNotNull(config2, "Dimina.getConfig()");
        hashMap.put("model", wsgService.getModel(config2.getApp()));
        hashMap.put("nativeSdkVersion", Dimina.getVersion());
        hashMap.put("platform", "android");
        hashMap.put("sdkId", str);
        hashMap.put("appId", str2);
        ILoginStoreApi store = OneLoginFacade.getStore();
        Intrinsics.checkExpressionValueIsNotNull(store, "OneLoginFacade.getStore()");
        hashMap.put("uid", store.getUid());
        Dimina.Config config3 = Dimina.getConfig();
        Intrinsics.checkExpressionValueIsNotNull(config3, "Dimina.getConfig()");
        Dimina.AdapterConfig adapterConfig2 = config3.getAdapterConfig();
        Intrinsics.checkExpressionValueIsNotNull(adapterConfig2, "Dimina.getConfig().adapterConfig");
        WsgService wsgService2 = adapterConfig2.getWsgService();
        Dimina.Config config4 = Dimina.getConfig();
        Intrinsics.checkExpressionValueIsNotNull(config4, "Dimina.getConfig()");
        hashMap.put("nativeAppVersion", wsgService2.getAppVersionName(config4.getApp()));
        if (!TextUtils.isEmpty(Apollo.getNamespace())) {
            hashMap.put("nativeAppNameSpace", Apollo.getNamespace());
        }
        DMMina dMMina = this.mina;
        Intrinsics.checkExpressionValueIsNotNull(dMMina, "mina");
        DMConfig config5 = dMMina.getConfig();
        Intrinsics.checkExpressionValueIsNotNull(config5, "mina.config");
        DMConfig.LaunchConfig launchConfig = config5.getLaunchConfig();
        if (launchConfig != null) {
            if (!TextUtil.isEmpty(((DMConfig4Di.LaunchConfig) launchConfig).getBundleManagerBusinessParams())) {
                DMMina dMMina2 = this.mina;
                Intrinsics.checkExpressionValueIsNotNull(dMMina2, "mina");
                DMConfig config6 = dMMina2.getConfig();
                Intrinsics.checkExpressionValueIsNotNull(config6, "mina.config");
                DMConfig.LaunchConfig launchConfig2 = config6.getLaunchConfig();
                if (launchConfig2 != null) {
                    hashMap.put("businessParams", ((DMConfig4Di.LaunchConfig) launchConfig2).getBundleManagerBusinessParams());
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type com.didi.dimina.container.secondparty.DMConfig4Di.LaunchConfig");
                }
            }
            return hashMap;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.didi.dimina.container.secondparty.DMConfig4Di.LaunchConfig");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ConfigRequestInterceptor{, App:'");
        sb.append(this.jsAppId);
        sb.append('\'');
        sb.append(", sdk:'");
        sb.append(this.jsSdkId);
        sb.append('\'');
        sb.append(", @");
        sb.append(hashCode());
        sb.append(", DMMina@");
        sb.append(this.mina != null ? Integer.valueOf(this.mina.hashCode()) : "null");
        sb.append('}');
        return sb.toString();
    }

    /* renamed from: c */
    private final void m12603c() {
        this.f17064b = System.currentTimeMillis();
        DMMina dMMina = this.mina;
        Intrinsics.checkExpressionValueIsNotNull(dMMina, "mina");
        Trace4DiUtil.tracePmConfigRequestStart(dMMina.getMinaIndex());
    }

    /* renamed from: a */
    static /* synthetic */ void m12601a(ConfigRequestInterceptor configRequestInterceptor, int i, int i2, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        if ((i3 & 4) != 0) {
            str = "";
        }
        configRequestInterceptor.m12600a(i, i2, str);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m12600a(int i, int i2, String str) {
        DMMina dMMina = this.mina;
        Intrinsics.checkExpressionValueIsNotNull(dMMina, "mina");
        int minaIndex = dMMina.getMinaIndex();
        long currentTimeMillis = System.currentTimeMillis() - this.f17064b;
        Trace4DiUtil.tracePmConfigRequestEnd(minaIndex, i, currentTimeMillis, "" + i2, str);
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00068BX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, mo175978d2 = {"Lcom/didi/dimina/container/secondparty/bundle/chain/ConfigRequestInterceptor$Companion;", "", "()V", "TAG", "", "configRequestHeader", "", "getConfigRequestHeader", "()Ljava/util/Map;", "getConfigRequestUrl", "mina", "Lcom/didi/dimina/container/DMMina;", "2party-impl_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: ConfigRequestInterceptor.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final String getConfigRequestUrl(DMMina dMMina) {
            return PmHttpUtil.getBaseUrl(dMMina) + PmConstant.HTTP.API_CONFIG_V2;
        }

        /* access modifiers changed from: private */
        public final Map<String, String> getConfigRequestHeader() {
            return new HashMap<>();
        }
    }
}
