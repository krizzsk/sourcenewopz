package com.didichuxing.ditest.agent.android;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import com.didichuxing.ditest.agent.android.background.ApplicationStateEvent;
import com.didichuxing.ditest.agent.android.background.ApplicationStateListener;
import com.didichuxing.ditest.agent.android.background.ApplicationStateMonitor;
import com.didichuxing.ditest.agent.android.logging.AgentLog;
import com.didichuxing.ditest.agent.android.logging.AgentLogManager;
import com.didichuxing.ditest.agent.android.measurement.http.HttpTransactionMeasurement;
import com.didichuxing.ditest.agent.android.util.AndroidEncoder;
import com.didichuxing.ditest.agent.android.util.Connectivity;
import com.didichuxing.ditest.agent.android.util.Encoder;
import com.didichuxing.ditest.agent.android.util.PersistentCounter;
import com.didichuxing.ditest.agent.android.util.UiBackgroundListener;
import com.didichuxing.omega.sdk.common.OmegaConfig;
import com.didichuxing.omega.sdk.common.collector.NetworkCollector;

public class AndroidAgentImpl implements AgentImpl, ApplicationStateListener {
    private static final String NET_ERR_UPLOADED_TODAY_KEY = "NetErrUploadedToday";
    private static final AgentLog log = AgentLogManager.getAgentLog();
    private final AgentConfiguration agentConfiguration;
    private final Context context;
    private final Encoder encoder = new AndroidEncoder();
    private NetworkEventAnalysis networkEventAnalysis;
    private PersistentCounter persistentCounter;
    private SavedState savedState;

    public void addTrafficToMonitor(long j) {
    }

    public AndroidAgentImpl(Context context2, AgentConfiguration agentConfiguration2) throws AgentInitializationException {
        Context appContext = appContext(context2);
        this.context = appContext;
        this.agentConfiguration = agentConfiguration2;
        this.savedState = new SavedState(appContext);
        if (!isDisabled()) {
            ApplicationStateMonitor.getInstance().addApplicationStateListener(this);
            if (Build.VERSION.SDK_INT >= 14) {
                context2.registerComponentCallbacks(new UiBackgroundListener());
            }
            if (agentConfiguration2.isNetEventLogEnabled()) {
                this.networkEventAnalysis = new NetworkEventAnalysis(context2, agentConfiguration2.getNetEventLogUploadInterval(), agentConfiguration2.getMaxNetEventUploadNum());
            }
            this.persistentCounter = new PersistentCounter(this.savedState);
            return;
        }
        throw new AgentInitializationException("apm is disabled!");
    }

    private static Context appContext(Context context2) {
        if (!(context2 instanceof Application)) {
            context2 = context2.getApplicationContext();
        }
        Application application = (Application) context2;
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
        return this.agentConfiguration.getResponseBodyLimit();
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
        this.agentConfiguration.setDisabled(true);
        try {
            stop();
        } finally {
            Agent.setImpl(NullAgentImpl.instance);
        }
    }

    public boolean isDisabled() {
        return this.agentConfiguration.isDisabled();
    }

    public String getNetworkCarrier() {
        return NetworkCollector.getNetworkOperatorName();
    }

    public String getNetworkWanType() {
        return Connectivity.wanType(this.context);
    }

    public static void init(Context context2, AgentConfiguration agentConfiguration2) {
        try {
            Agent.setImpl(new AndroidAgentImpl(context2, agentConfiguration2));
            Agent.start();
        } catch (AgentInitializationException e) {
            AgentLog agentLog = log;
            agentLog.error("Failed to initialize the agent: " + e.toString());
        }
    }

    public void setLocation(String str, String str2) {
        if (str == null || str2 == null) {
            throw new IllegalArgumentException("Country code and administrative region are required.");
        }
    }

    public Encoder getEncoder() {
        return this.encoder;
    }

    public boolean isApmNetEnable() {
        return this.agentConfiguration.isApmNetEnable();
    }

    public boolean isApmUiEnable() {
        return this.agentConfiguration.isApmUiEnable();
    }

    public boolean isUploadNetPerf() {
        return this.agentConfiguration.isUploadNetPerf();
    }

    public boolean isUploadErrorDiag() {
        return this.agentConfiguration.isUploadErrorDiag();
    }

    public boolean canUploadNetErrEvent() {
        String str = NET_ERR_UPLOADED_TODAY_KEY + (System.currentTimeMillis() / 86400000);
        int i = this.savedState.getInt(str);
        if (i >= this.agentConfiguration.getMaxUploadNetErrEventPerDay()) {
            return false;
        }
        this.savedState.save(str, i + 1);
        return true;
    }

    public AgentConfiguration getAgentConfig() {
        return this.agentConfiguration;
    }

    public void addNetEventLog(HttpTransactionMeasurement httpTransactionMeasurement) {
        if (this.agentConfiguration.isNetEventLogEnabled() && this.networkEventAnalysis != null) {
            if (OmegaConfig.NET_DIAG_USE_MEMORY_CACHE) {
                this.networkEventAnalysis.addEventV2(httpTransactionMeasurement);
            } else {
                this.networkEventAnalysis.addEvent(httpTransactionMeasurement);
            }
        }
    }

    public boolean upperLimitToday(String str, long j) {
        return this.persistentCounter.upperLimitToday(str, j);
    }

    public int maxUploadErrEventNum() {
        return this.agentConfiguration.getMaxUploadNetErrEventPerDay();
    }

    public void applicationForegrounded(ApplicationStateEvent applicationStateEvent) {
        log.info("AndroidAgentImpl: application foregrounded ");
    }

    public void applicationBackgrounded(ApplicationStateEvent applicationStateEvent) {
        log.info("AndroidAgentImpl: application backgrounded ");
    }

    class IPCounter {
        private int count;

        /* renamed from: ip */
        private String f47544ip;

        IPCounter() {
        }

        public String getIp() {
            return this.f47544ip;
        }

        public void setIp(String str) {
            this.f47544ip = str;
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
