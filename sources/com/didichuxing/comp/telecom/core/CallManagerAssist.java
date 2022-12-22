package com.didichuxing.comp.telecom.core;

import android.content.Context;
import com.didichuxing.comp.telecom.core.request.model.CallListModel;
import com.didichuxing.comp.telecom.core.request.model.CallMethodItem;
import com.didichuxing.comp.telecom.core.voip.SimpleCallEventTickHandler;
import com.didichuxing.comp.telecom.core.voip.VoipCallModel;
import java.util.HashMap;
import java.util.Map;

public class CallManagerAssist {
    public static final String TAG = "CallManagerAssist";

    /* renamed from: a */
    private Context f46391a;

    /* renamed from: b */
    private CallManagerConfig f46392b;

    /* renamed from: c */
    private HashMap<String, Integer> f46393c = new HashMap<>();

    public interface CallEventTickHandler {
        void onCallListItemClick(CallMethodItem callMethodItem, VoipCallModel voipCallModel);

        void onCallListShow(CallListModel callListModel);

        void onCallPageBtnClick(String str, String str2, String str3, VoipCallModel voipCallModel);

        void onCallPageShow(String str, String str2, VoipCallModel voipCallModel);

        void onCollapseClick(String str, String str2, VoipCallModel voipCallModel);

        void onFloatWindowClick(String str, String str2, VoipCallModel voipCallModel);

        void onFloatWindowShow(String str, String str2, VoipCallModel voipCallModel);

        void onRequestAudioResult(boolean z);

        void onRequestAudioShow();

        void onRequestFloatWindowClick(boolean z, String str, String str2, VoipCallModel voipCallModel);

        void onRequestFloatWindowShow(String str, String str2, VoipCallModel voipCallModel);

        void onToastShow(String str, String str2, String str3, VoipCallModel voipCallModel);
    }

    public interface HostProvider {

        /* renamed from: com.didichuxing.comp.telecom.core.CallManagerAssist$HostProvider$-CC  reason: invalid class name */
        public final /* synthetic */ class CC {
            @Deprecated
            public static String $default$getVoipHost(HostProvider hostProvider) {
                return null;
            }
        }

        String getCallApiHost();

        @Deprecated
        String getVoipHost();
    }

    public interface ParamsProvider {

        /* renamed from: com.didichuxing.comp.telecom.core.CallManagerAssist$ParamsProvider$-CC  reason: invalid class name */
        public final /* synthetic */ class CC {
            public static String $default$getPlatform(ParamsProvider paramsProvider) {
                return "2";
            }
        }

        String getAppPushType();

        String getAppVersion();

        String getCountryCode();

        String getPlatform();

        String getTerminalId();

        String getToken();
    }

    public static boolean isTest() {
        CallManagerConfig config = getInstance().getConfig();
        if (config == null || config.env != 1) {
            return false;
        }
        return true;
    }

    public static boolean isRelease() {
        CallManagerConfig config = getInstance().getConfig();
        return config != null && config.env == 3;
    }

    public static long getTimeMillis() {
        CallManagerConfig config = getInstance().getConfig();
        AppServiceProvider appServiceProvider = config != null ? config.getAppServiceProvider() : null;
        return appServiceProvider != null ? appServiceProvider.serverTime() : System.currentTimeMillis();
    }

    private static final class Singleton {
        static final CallManagerAssist INSTANCE = new CallManagerAssist();

        private Singleton() {
        }
    }

    public static CallManagerAssist getInstance() {
        return Singleton.INSTANCE;
    }

    public void init(Context context) {
        init(context, (CallManagerConfig) null);
    }

    public void init(Context context, CallManagerConfig callManagerConfig) {
        this.f46391a = context;
        if (callManagerConfig == null) {
            callManagerConfig = new CallManagerConfig.Builder().build();
        }
        this.f46392b = callManagerConfig;
    }

    public Context getAppContext() {
        return this.f46391a;
    }

    public boolean initialized() {
        return (this.f46391a == null || this.f46392b == null) ? false : true;
    }

    public CallManagerConfig getConfig() {
        if (this.f46392b == null) {
            this.f46392b = new CallManagerConfig.Builder().build();
        }
        return this.f46392b;
    }

    public void bindResources(Map<String, Integer> map) {
        if (map != null) {
            this.f46393c.putAll(map);
        }
    }

    public Map<String, Integer> getResources() {
        return this.f46393c;
    }

    public static class CallManagerConfig {
        public static final int ENV_DEBUG = 2;
        public static final int ENV_RELEASE = 3;
        public static final int ENV_TEST = 1;
        private AppServiceProvider appServiceProvider;
        /* access modifiers changed from: private */
        public int env;
        private CallEventTickHandler eventTickHandler;
        private HostProvider hostProvider;
        private ParamsProvider paramsProvider;

        private CallManagerConfig(Builder builder) {
            this.env = builder.env;
            this.hostProvider = builder.hostProvider;
            this.paramsProvider = builder.paramsProvider;
            this.appServiceProvider = builder.appServiceProvider;
            this.eventTickHandler = builder.eventTickHandler != null ? builder.eventTickHandler : new SimpleCallEventTickHandler();
        }

        public static Builder builder() {
            return new Builder();
        }

        public static class Builder {
            /* access modifiers changed from: private */
            public AppServiceProvider appServiceProvider;
            /* access modifiers changed from: private */
            public int env;
            /* access modifiers changed from: private */
            public CallEventTickHandler eventTickHandler;
            /* access modifiers changed from: private */
            public HostProvider hostProvider;
            /* access modifiers changed from: private */
            public ParamsProvider paramsProvider;

            private Builder() {
                this.env = 3;
            }

            public Builder env(int i) {
                this.env = i;
                return this;
            }

            public Builder hostProvider(HostProvider hostProvider2) {
                this.hostProvider = hostProvider2;
                return this;
            }

            public Builder paramsProvider(ParamsProvider paramsProvider2) {
                this.paramsProvider = paramsProvider2;
                return this;
            }

            public Builder appServiceProvider(AppServiceProvider appServiceProvider2) {
                this.appServiceProvider = appServiceProvider2;
                return this;
            }

            public Builder eventTickHandler(CallEventTickHandler callEventTickHandler) {
                this.eventTickHandler = callEventTickHandler;
                return this;
            }

            public CallManagerConfig build() {
                return new CallManagerConfig(this);
            }
        }

        public int getEnv() {
            return this.env;
        }

        public void setEnv(int i) {
            this.env = i;
        }

        public HostProvider getHostProvider() {
            return this.hostProvider;
        }

        public ParamsProvider getParamsProvider() {
            return this.paramsProvider;
        }

        public AppServiceProvider getAppServiceProvider() {
            return this.appServiceProvider;
        }

        public CallEventTickHandler getEventTickHandler() {
            return this.eventTickHandler;
        }
    }

    public interface AppServiceProvider {
        boolean isForeGround();

        void log(String str, String str2);

        long serverTime();

        void tickEvent(String str, Map<String, Object> map);

        /* renamed from: com.didichuxing.comp.telecom.core.CallManagerAssist$AppServiceProvider$-CC  reason: invalid class name */
        public final /* synthetic */ class CC {
            public static long $default$serverTime(AppServiceProvider _this) {
                return System.currentTimeMillis();
            }
        }
    }
}
