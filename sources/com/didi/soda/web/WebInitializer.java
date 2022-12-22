package com.didi.soda.web;

import android.app.Application;
import android.content.res.Resources;
import com.didi.onehybrid.BaseHybridModule;
import com.didi.onehybrid.FusionEngine;
import com.didi.onehybrid.FusionInitConfig;
import com.didi.soda.web.SodaFusionEngine;
import com.didi.soda.web.config.WebConstant;
import com.didi.soda.web.tools.LogUtil;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;

public final class WebInitializer {
    public static final String GLOBAL_JS_KEY = "Soda";

    /* renamed from: a */
    private static WebInitializer f43863a;

    /* renamed from: b */
    private FusionInitConfig.Builder f43864b;

    /* renamed from: c */
    private SodaFusionEngine.SodaConfingBuilder f43865c;

    /* renamed from: d */
    private Class<? extends GlobalJsBridge> f43866d;

    /* renamed from: e */
    private BizAgent f43867e;

    /* renamed from: f */
    private HashMap<String, Class<? extends BaseHybridModule>> f43868f = new HashMap<>();

    /* renamed from: g */
    private FusionInitConfig f43869g;

    /* renamed from: h */
    private LogUtil.LogInterface f43870h;

    /* renamed from: i */
    private boolean f43871i = true;
    public Application mApplication;

    private WebInitializer(Application application) {
        Resources resources = application.getApplicationContext().getResources();
        this.f43865c = new SodaFusionEngine.SodaConfingBuilder();
        FusionInitConfig.Builder builder = new FusionInitConfig.Builder();
        this.f43864b = builder;
        builder.addExtraAttr(WebConstant.TITLE_BAR_BACKGROUND_COLOR, Integer.valueOf(resources.getColor(R.color.assembly_color_titleBar)));
        this.f43864b.addExtraAttr(WebConstant.TITLE_BAR_TEXT_COLOR, Integer.valueOf(resources.getColor(R.color.white)));
        this.f43864b.addExtraAttr("progressbar_color", Integer.valueOf(resources.getColor(R.color.assembly_unit_color_fffc9153)));
    }

    public static WebInitializer start(Application application) {
        if (f43863a == null) {
            WebInitializer webInitializer = new WebInitializer(application);
            f43863a = webInitializer;
            webInitializer.mApplication = application;
        }
        return f43863a;
    }

    public static WebInitializer getInitializer() {
        return f43863a;
    }

    public WebInitializer setPhone(String str) {
        this.f43864b.setPhone(str);
        return this;
    }

    public WebInitializer setCityId(int i) {
        this.f43864b.setCityId(i);
        return this;
    }

    public WebInitializer setBusinessAgent(BizAgent bizAgent) {
        this.f43867e = bizAgent;
        return this;
    }

    public WebInitializer setAppKey(String str) {
        this.f43864b.setAppKey(str);
        return this;
    }

    public WebInitializer setProgressBarColor(int i) {
        this.f43864b.addExtraAttr("progressbar_color", Integer.valueOf(i));
        return this;
    }

    public WebInitializer setReadTimeMillisecond(long j) {
        this.f43864b.addExtraAttr(WebConstant.READ_TIMEOUT, Long.valueOf(j));
        return this;
    }

    public WebInitializer exportGlobalJsBridge(Class<? extends GlobalJsBridge> cls) {
        this.f43866d = cls;
        return this;
    }

    public WebInitializer isAddFusionAgent(boolean z) {
        this.f43871i = z;
        return this;
    }

    public void execute() {
        this.f43865c.setBusinessAgent(this.f43867e).setGlobalJsBridge(this.f43866d);
        SodaFusionEngine.init(this.f43865c);
        if (this.f43871i) {
            this.f43864b.setBusinessAgent(this.f43867e);
            FusionEngine.init(this.mApplication, getFusionInitConfig());
        }
        m31206a();
    }

    public FusionInitConfig getFusionInitConfig() {
        if (this.f43869g == null) {
            this.f43869g = this.f43864b.build();
        }
        return this.f43869g;
    }

    /* renamed from: a */
    private void m31206a() {
        Class<? extends GlobalJsBridge> cls = this.f43866d;
        if (cls != null) {
            m31207a(GLOBAL_JS_KEY, cls);
        }
        if (this.f43868f.size() > 0) {
            for (Map.Entry next : this.f43868f.entrySet()) {
                m31207a((String) next.getKey(), (Class) next.getValue());
            }
        }
    }

    @Deprecated
    public WebInitializer setTitleBarBackground(int i) {
        this.f43864b.addExtraAttr(WebConstant.TITLE_BAR_BACKGROUND_COLOR, Integer.valueOf(i));
        return this;
    }

    /* renamed from: a */
    private void m31207a(String str, Class cls) {
        FusionEngine.export(str, cls);
    }

    public WebInitializer setLogUtil(LogUtil.LogInterface logInterface) {
        this.f43870h = logInterface;
        return this;
    }

    public LogUtil.LogInterface getLogUtil() {
        return this.f43870h;
    }

    @Deprecated
    public WebInitializer setTitleBarTextColor(int i) {
        this.f43864b.addExtraAttr(WebConstant.TITLE_BAR_TEXT_COLOR, Integer.valueOf(i));
        return this;
    }

    public WebInitializer exportJsBridge(String str, Class<? extends BaseHybridModule> cls) {
        this.f43868f.put(str, cls);
        return this;
    }

    @Deprecated
    public WebInitializer exportJsBridges(HashMap<String, Class<? extends BaseHybridModule>> hashMap) {
        this.f43868f.putAll(hashMap);
        return this;
    }

    @Deprecated
    public WebInitializer addExtraAttr(String str, Object obj) {
        this.f43864b.addExtraAttr(str, obj);
        return this;
    }
}
