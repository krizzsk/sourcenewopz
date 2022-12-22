package com.didichuxing.mas.sdk.quality.collect.ditest.agent.android;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.background.ApplicationStateEvent;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.background.ApplicationStateListener;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.background.ApplicationStateMonitor;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.logging.AgentLog;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.logging.AgentLogManager;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.measurement.http.HttpTransactionMeasurement;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.util.AndroidEncoder;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.util.Connectivity;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.util.Encoder;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.util.PersistentCounter;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.util.UiBackgroundListener;
import com.didichuxing.mas.sdk.quality.report.MASConfig;
import com.didichuxing.mas.sdk.quality.report.collector.NetworkCollector;

public class AndroidAgentImpl implements AgentImpl, ApplicationStateListener {

    /* renamed from: a */
    private static final AgentLog f47816a = AgentLogManager.getAgentLog();

    /* renamed from: f */
    private static final String f47817f = "NetErrUploadedToday";

    /* renamed from: b */
    private final Context f47818b;

    /* renamed from: c */
    private SavedState f47819c;

    /* renamed from: d */
    private final Encoder f47820d = new AndroidEncoder();

    /* renamed from: e */
    private final AgentConfiguration f47821e;

    /* renamed from: g */
    private NetworkEventAnalysis f47822g;

    /* renamed from: h */
    private PersistentCounter f47823h;

    public void addTrafficToMonitor(long j) {
    }

    public AndroidAgentImpl(Context context, AgentConfiguration agentConfiguration) throws AgentInitializationException {
        Context a = m34210a(context);
        this.f47818b = a;
        this.f47821e = agentConfiguration;
        this.f47819c = new SavedState(a);
        if (!isDisabled()) {
            ApplicationStateMonitor.getInstance().addApplicationStateListener(this);
            if (Build.VERSION.SDK_INT >= 14) {
                context.registerComponentCallbacks(new UiBackgroundListener());
            }
            if (agentConfiguration.isNetEventLogEnabled()) {
                this.f47822g = new NetworkEventAnalysis(context, agentConfiguration.getNetEventLogUploadInterval(), agentConfiguration.getMaxNetEventUploadNum());
            }
            this.f47823h = new PersistentCounter(this.f47819c);
            return;
        }
        throw new AgentInitializationException("apm is disabled!");
    }

    /* renamed from: a */
    private static Context m34210a(Context context) {
        if (!(context instanceof Application)) {
            context = context.getApplicationContext();
        }
        Application application = (Application) context;
        application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
            public void onActivityCreated(Activity activity, Bundle bundle) {
            }

            public void onActivityDestroyed(Activity activity) {
            }

            public void onActivityPaused(Activity activity) {
            }

            public void onActivityResumed(Activity activity) {
            }

            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            public void onActivityStarted(Activity activity) {
                ApplicationStateMonitor.getInstance().activityStarted();
            }

            public void onActivityStopped(Activity activity) {
                ApplicationStateMonitor.getInstance().activityStopped();
            }
        });
        return application;
    }

    public int getResponseBodyLimit() {
        return this.f47821e.getResponseBodyLimit();
    }

    public void start() {
        if (!isDisabled()) {
            Measurements.initialize();
        } else {
            stop();
        }
    }

    public void stop() {
        Measurements.shutdown();
    }

    public void disable() {
        this.f47821e.setDisabled(true);
        try {
            stop();
        } finally {
            Agent.setImpl(NullAgentImpl.instance);
        }
    }

    public boolean isDisabled() {
        return this.f47821e.isDisabled();
    }

    public String getNetworkCarrier() {
        return NetworkCollector.getNetworkOperatorType();
    }

    public String getNetworkWanType() {
        return Connectivity.wanType(this.f47818b);
    }

    public static void init(Context context, AgentConfiguration agentConfiguration) {
        try {
            Agent.setImpl(new AndroidAgentImpl(context, agentConfiguration));
            Agent.start();
        } catch (AgentInitializationException e) {
            AgentLog agentLog = f47816a;
            agentLog.error("Failed to initialize the agent: " + e.toString());
        }
    }

    public void setLocation(String str, String str2) {
        if (str == null || str2 == null) {
            throw new IllegalArgumentException("Country code and administrative region are required.");
        }
    }

    public Encoder getEncoder() {
        return this.f47820d;
    }

    public boolean isApmNetEnable() {
        return this.f47821e.isApmNetEnable();
    }

    public boolean isApmUiEnable() {
        return this.f47821e.isApmUiEnable();
    }

    public boolean isUploadNetPerf() {
        return this.f47821e.isUploadNetPerf();
    }

    public boolean isUploadErrorDiag() {
        return this.f47821e.isUploadErrorDiag();
    }

    public boolean canUploadNetErrEvent() {
        String str = f47817f + (System.currentTimeMillis() / 86400000);
        int i = this.f47819c.getInt(str);
        if (i >= this.f47821e.getMaxUploadNetErrEventPerDay()) {
            return false;
        }
        this.f47819c.save(str, i + 1);
        return true;
    }

    public AgentConfiguration getAgentConfig() {
        return this.f47821e;
    }

    public void addNetEventLog(HttpTransactionMeasurement httpTransactionMeasurement) {
        if (this.f47821e.isNetEventLogEnabled() && this.f47822g != null) {
            if (MASConfig.NET_DIAG_USE_MEMORY_CACHE) {
                this.f47822g.addEventV2(httpTransactionMeasurement);
            } else {
                this.f47822g.addEvent(httpTransactionMeasurement);
            }
        }
    }

    public boolean upperLimitToday(String str, long j) {
        return this.f47823h.upperLimitToday(str, j);
    }

    public int maxUploadErrEventNum() {
        return this.f47821e.getMaxUploadNetErrEventPerDay();
    }

    public void applicationForegrounded(ApplicationStateEvent applicationStateEvent) {
        f47816a.info("AndroidAgentImpl: application foregrounded ");
    }

    public void applicationBackgrounded(ApplicationStateEvent applicationStateEvent) {
        f47816a.info("AndroidAgentImpl: application backgrounded ");
    }

    class IPCounter {
        private int count;

        /* renamed from: ip */
        private String f47824ip;

        IPCounter() {
        }

        public String getIp() {
            return this.f47824ip;
        }

        public void setIp(String str) {
            this.f47824ip = str;
        }

        public int getCount() {
            return this.count;
        }

        public void setCount(int i) {
            this.count = i;
        }

        public void addCount() {
            this.count++;
        }

        public void delCount() {
            this.count--;
        }
    }
}
