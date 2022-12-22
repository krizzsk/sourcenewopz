package com.didi.flutter.nacho2.p115v2;

import android.content.Context;
import android.text.TextUtils;
import com.didi.flutter.nacho2.p115v2.NachoEngineCreator;
import com.didi.flutter.nacho2.p115v2.callback.NachoEngineCallback;
import com.didi.flutter.nacho2.p115v2.callback.NachoRouterCallback;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p242io.flutter.embedding.engine.FlutterEngine;
import p242io.flutter.plugin.common.MethodChannel;

/* renamed from: com.didi.flutter.nacho2.v2.NachoAction */
public class NachoAction {

    /* renamed from: a */
    private Context f21134a;

    /* renamed from: b */
    private String f21135b;

    /* renamed from: c */
    private FlutterEngine f21136c;

    /* renamed from: d */
    private String f21137d;

    /* renamed from: e */
    private String f21138e;

    /* renamed from: f */
    private List<String> f21139f;

    /* renamed from: g */
    private Map<String, MethodChannel> f21140g;

    /* renamed from: h */
    private NachoRouterCallback f21141h;

    /* renamed from: i */
    private NachoEngineCallback f21142i;

    /* renamed from: j */
    private NachoEngineCreator.EngineCreateMode f21143j;

    private NachoAction(Builder builder) {
        this.f21134a = builder.context;
        this.f21135b = builder.engineId;
        this.f21137d = builder.entrypoint;
        this.f21138e = builder.dartEntrypointLibrary;
        this.f21139f = builder.dartEntrypointArgs;
        this.f21141h = builder.onRouteCallback;
        this.f21142i = builder.onEngineCallback;
        this.f21143j = builder.engineCreateMode;
        this.f21140g = new HashMap();
    }

    /* renamed from: com.didi.flutter.nacho2.v2.NachoAction$Builder */
    public static class Builder {
        /* access modifiers changed from: private */
        public Context context;
        /* access modifiers changed from: private */
        public List<String> dartEntrypointArgs;
        /* access modifiers changed from: private */
        public String dartEntrypointLibrary;
        /* access modifiers changed from: private */
        public NachoEngineCreator.EngineCreateMode engineCreateMode;
        /* access modifiers changed from: private */
        public String engineId;
        /* access modifiers changed from: private */
        public String entrypoint;
        /* access modifiers changed from: private */
        public NachoEngineCallback onEngineCallback;
        /* access modifiers changed from: private */
        public NachoRouterCallback onRouteCallback;

        public Builder(Context context2) {
            this.context = context2;
        }

        public Builder engineId(String str) {
            this.engineId = str;
            return this;
        }

        @Deprecated
        public Builder entrypoint(String str) {
            this.entrypoint = str;
            return this;
        }

        @Deprecated
        public Builder dartEntrypointLibrary(String str) {
            this.dartEntrypointLibrary = str;
            return this;
        }

        public Builder routeCallback(NachoRouterCallback nachoRouterCallback) {
            this.onRouteCallback = nachoRouterCallback;
            return this;
        }

        public Builder engineCallback(NachoEngineCallback nachoEngineCallback) {
            this.onEngineCallback = nachoEngineCallback;
            return this;
        }

        public Builder engineCreateMode(NachoEngineCreator.EngineCreateMode engineCreateMode2) {
            this.engineCreateMode = engineCreateMode2;
            return this;
        }

        public Builder dartEntrypointArgs(List<String> list) {
            this.dartEntrypointArgs = list;
            return this;
        }

        public NachoAction build() {
            return new NachoAction(this);
        }
    }

    public Context getContext() {
        return this.f21134a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo62875a(Context context) {
        this.f21134a = context;
    }

    public String getEngineId() {
        return this.f21135b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo62878a(String str) {
        this.f21135b = str;
    }

    public FlutterEngine getEngine() {
        return this.f21136c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo62877a(FlutterEngine flutterEngine) {
        this.f21136c = flutterEngine;
    }

    public String getEntrypoint() {
        return this.f21137d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo62879b(String str) {
        this.f21137d = str;
    }

    public String getDartEntrypointLibrary() {
        return this.f21138e;
    }

    public void setDartEntrypointLibrary(String str) {
        this.f21138e = str;
    }

    public NachoRouterCallback getOnRouteCallback() {
        return this.f21141h;
    }

    public void setOnRouteCallback(NachoRouterCallback nachoRouterCallback) {
        this.f21141h = nachoRouterCallback;
    }

    public NachoEngineCallback getOnEngineCallback() {
        return this.f21142i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo62876a(NachoEngineCallback nachoEngineCallback) {
        this.f21142i = nachoEngineCallback;
    }

    public NachoEngineCreator.EngineCreateMode getEngineCreateMode() {
        return this.f21143j;
    }

    public List<String> getDartEntrypointArgs() {
        return this.f21139f;
    }

    public void setDartEntrypointArgs(List<String> list) {
        this.f21139f = list;
    }

    public void registerChannel(String str, MethodChannel methodChannel) {
        if (!TextUtils.isEmpty(str) && methodChannel != null) {
            this.f21140g.put(str, methodChannel);
        }
    }

    public MethodChannel getChannel(String str) {
        if (!TextUtils.isEmpty(str)) {
            return this.f21140g.get(str);
        }
        return null;
    }

    public void openPage(String str, String str2, HashMap<String, Object> hashMap) {
        NachoRouterCallback nachoRouterCallback = this.f21141h;
        if (nachoRouterCallback != null) {
            nachoRouterCallback.onPageOpen(str, str2, hashMap);
        }
    }
}
