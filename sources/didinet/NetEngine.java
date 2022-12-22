package didinet;

import android.content.Context;
import android.os.SystemClock;
import didihttp.Interceptor;
import didihttp.StatisticalCallback;
import didihttp.internal.trace.LogStrategy;
import didinet.ApolloAPI;
import didinet.ConnectCallback;
import didinet.DnsCallback;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import utils.ContextUtil;

public class NetEngine {

    /* renamed from: a */
    private HashSet<StatisticalCallback> f57106a;

    /* renamed from: b */
    private Lock f57107b;

    /* renamed from: c */
    private NetworkStateManager f57108c;

    /* renamed from: d */
    private OmegaAPI f57109d;

    /* renamed from: e */
    private ApolloAPI f57110e;

    /* renamed from: f */
    private NetworkDetectionAPI f57111f;

    /* renamed from: g */
    private PushAPI f57112g;

    /* renamed from: h */
    private NetConfig f57113h;

    /* renamed from: i */
    private volatile Interceptor f57114i;

    /* renamed from: j */
    private final List<DnsCallback> f57115j;

    /* renamed from: k */
    private final List<ConnectCallback> f57116k;

    /* renamed from: l */
    private String f57117l;

    /* renamed from: m */
    private ExternalParamGetter f57118m;

    /* renamed from: n */
    private volatile int f57119n;

    /* renamed from: o */
    private boolean f57120o;

    public interface ExternalParamGetter {
        ExternalParam onGetExternalParam();
    }

    public static NetEngine getInstance() {
        return Holder.STATISTICAL_DATA_MANAGER;
    }

    private static class Holder {
        /* access modifiers changed from: private */
        public static final NetEngine STATISTICAL_DATA_MANAGER = new NetEngine();

        private Holder() {
        }
    }

    private NetEngine() {
        this.f57106a = new HashSet<>();
        this.f57107b = new ReentrantLock();
        this.f57109d = OmegaAPI.NONE;
        this.f57110e = ApolloAPI.NONE;
        this.f57111f = NetworkDetectionAPI.NONE;
        this.f57112g = PushAPI.NONE;
        this.f57113h = NetConfig.f57081a;
        this.f57115j = new ArrayList();
        this.f57116k = new ArrayList();
        this.f57119n = -1;
        this.f57120o = true;
    }

    public void create(Context context) {
        ContextUtil.initApplicationContext(context);
        NetworkStateManager networkStateManager = new NetworkStateManager(context);
        this.f57108c = networkStateManager;
        networkStateManager.listene();
        ApolloKeySwitcher.getInstance().init(context);
        LogStrategy.getStrategy().readFromApollo();
    }

    public void destroy() {
        this.f57108c.remove();
        this.f57108c = null;
    }

    public NetworkStateManager getNetworkStateManager() {
        return this.f57108c;
    }

    public void addStatisticalCallback(StatisticalCallback statisticalCallback) {
        this.f57107b.lock();
        try {
            this.f57106a.add(statisticalCallback);
        } finally {
            this.f57107b.unlock();
        }
    }

    public void removeStatisticalCallback(StatisticalCallback statisticalCallback) {
        this.f57107b.lock();
        try {
            this.f57106a.remove(statisticalCallback);
        } finally {
            this.f57107b.unlock();
        }
    }

    public Collection<StatisticalCallback> getStatisticalCallbacks() {
        this.f57107b.lock();
        try {
            return new HashSet(this.f57106a);
        } finally {
            this.f57107b.unlock();
        }
    }

    public void addDnsCallback(DnsCallback dnsCallback) {
        synchronized (this.f57115j) {
            this.f57115j.add(dnsCallback);
        }
    }

    public void removeDnsCallback(DnsCallback dnsCallback) {
        synchronized (this.f57115j) {
            this.f57115j.remove(dnsCallback);
        }
    }

    public void notifyDnsCallback(DnsCallback.DnsContext dnsContext) {
        ArrayList<DnsCallback> arrayList;
        synchronized (this.f57115j) {
            arrayList = new ArrayList<>(this.f57115j);
        }
        for (DnsCallback onDnsFinished : arrayList) {
            onDnsFinished.onDnsFinished(dnsContext);
        }
    }

    public void addConnectCallback(ConnectCallback connectCallback) {
        synchronized (this.f57116k) {
            this.f57116k.add(connectCallback);
        }
    }

    public void removeConnectCallback(ConnectCallback connectCallback) {
        synchronized (this.f57116k) {
            this.f57116k.remove(connectCallback);
        }
    }

    public void notifyConnectCallback(ConnectCallback.ConnectContext connectContext) {
        ArrayList<ConnectCallback> arrayList;
        synchronized (this.f57115j) {
            arrayList = new ArrayList<>(this.f57116k);
        }
        for (ConnectCallback onConnectFinished : arrayList) {
            onConnectFinished.onConnectFinished(connectContext);
        }
    }

    public NetConfig getNetConfig() {
        return this.f57113h;
    }

    /* renamed from: a */
    private void m40942a() {
        try {
            ApolloAPI.Toggle toggle = this.f57110e.getToggle("net_config_expr");
            if (toggle.allow()) {
                this.f57113h = new NetConfig((String) toggle.getExperiment().getParam("cfg", ""));
            }
        } catch (Exception unused) {
            this.f57113h = NetConfig.f57081a;
        }
    }

    public void setOmegaAPI(OmegaAPI omegaAPI) {
        if (omegaAPI == null) {
            omegaAPI = OmegaAPI.NONE;
        }
        this.f57109d = omegaAPI;
    }

    public void setApolloAPI(ApolloAPI apolloAPI) {
        if (apolloAPI == null) {
            apolloAPI = ApolloAPI.NONE;
        }
        this.f57110e = apolloAPI;
        m40942a();
    }

    public OmegaAPI getOmegaAPI() {
        return this.f57109d;
    }

    public ApolloAPI getApolloAPI() {
        return this.f57110e;
    }

    public NetworkDetectionAPI getNetworkDetectionAPI() {
        return this.f57111f;
    }

    public void setNetworkDetectionAPI(NetworkDetectionAPI networkDetectionAPI) {
        if (networkDetectionAPI == null) {
            networkDetectionAPI = NetworkDetectionAPI.NONE;
        }
        this.f57111f = networkDetectionAPI;
    }

    public PushAPI getPushAPI() {
        return this.f57112g;
    }

    public void setPushAPI(PushAPI pushAPI) {
        if (pushAPI == null) {
            pushAPI = PushAPI.NONE;
        }
        this.f57112g = pushAPI;
    }

    public Interceptor getTransformInterceptor() {
        return this.f57114i;
    }

    public void setTransformInterceptor(Interceptor interceptor) {
        this.f57114i = interceptor;
    }

    public ExternalParamGetter getParamGetter() {
        return this.f57118m;
    }

    public void setParamGetter(ExternalParamGetter externalParamGetter) {
        this.f57118m = externalParamGetter;
    }

    public static class ExternalParam {
        public static final int APP_STATE_BACKGROUND = 2;
        public static final int APP_STATE_FOREGROUND = 1;
        private volatile int appState = -1;
        private volatile long backgroundTimeMillis;
        private volatile int cityId = -1;
        private volatile int flowTag = -1;

        public int getCityId() {
            return this.cityId;
        }

        public void setCityId(int i) {
            this.cityId = i;
        }

        public boolean hasCityId() {
            return this.cityId != -1;
        }

        public int getFlowTag() {
            return this.flowTag;
        }

        public void setFlowTag(int i) {
            this.flowTag = i;
        }

        public boolean hasFlowTag() {
            return this.flowTag != -1;
        }

        public int getAppState() {
            return this.appState;
        }

        public void setAppState(int i) {
            this.appState = i;
            if (this.appState == 2) {
                this.backgroundTimeMillis = SystemClock.elapsedRealtime();
            }
        }

        public boolean hasAppState() {
            return this.appState != -1;
        }

        public long getBackgroundDuration() {
            return SystemClock.elapsedRealtime() - this.backgroundTimeMillis;
        }
    }

    public int getBootStatus() {
        return this.f57119n;
    }

    public void setBootStatus(int i) {
        this.f57119n = i;
    }

    public String getTerminalTag() {
        return this.f57117l;
    }

    public void setTerminalTag(String str) {
        this.f57117l = str;
    }

    public void setTransEnabled(boolean z) {
        this.f57120o = z;
    }

    public boolean isTransEnabled() {
        return this.f57120o;
    }

    public boolean supportIpv6() {
        LocalIPStack localIPStack = getPushAPI().getLocalIPStack();
        return localIPStack == LocalIPStack.IPv6 || localIPStack == LocalIPStack.Dual;
    }
}
