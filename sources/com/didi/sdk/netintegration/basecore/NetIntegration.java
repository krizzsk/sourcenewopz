package com.didi.sdk.netintegration.basecore;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.didi.one.netdetect.DetectionTaskManager;
import com.didi.one.netdetect.command.PingResult;
import com.didi.one.netdetect.model.PingParam;
import com.didi.one.netdetect.model.TraceRouteParam;
import com.didi.sdk.connectivity.ConnectivityDetector;
import com.didi.sdk.connectivity.ConnectivityStatistics;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.push.PushLog;
import com.didi.sdk.push.TransAdapter;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import com.didichuxing.apollo.sdk.IToggle;
import com.didichuxing.apollo.sdk.observer.OnCacheLoadedListener;
import com.didichuxing.mas.sdk.quality.init.MASSDK;
import com.didichuxing.mas.sdk.quality.report.utils.Constants;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import didihttp.DidiHttpClient;
import didihttp.HttpUrl;
import didihttp.Interceptor;
import didihttp.Request;
import didihttp.Response;
import didihttp.StatisticalCallback;
import didihttp.StatisticalContext;
import didihttpdns.HttpDnsManager;
import didihttpdns.security.InterceptorGetter;
import didihttpdns.security.SigGenerator;
import didinet.ApolloAPI;
import didinet.NetEngine;
import didinet.NetworkDetectionAPI;
import didinet.OmegaAPI;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class NetIntegration {

    /* renamed from: a */
    private static final String f36852a = NetIntegration.class.getSimpleName();

    /* renamed from: b */
    private static final NetIntegration f36853b = new NetIntegration();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static NetParamsAPI f36854d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static Context f36855e;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Logger f36856c = LoggerFactory.getLogger("NetIntegration_LOG");

    public static NetIntegration getInstance() {
        return f36853b;
    }

    private NetIntegration() {
        setLogLevel(2);
    }

    public void init(Context context, NetParamsAPI netParamsAPI) {
        f36854d = netParamsAPI;
        if (netParamsAPI != null) {
            Logger logger = this.f36856c;
            String str = f36852a;
            logger.debug(str, "init with netParams: " + f36854d.toString());
            f36855e = context;
            m26107a(context);
            return;
        }
        throw new NullPointerException("NetParams must NOT be null in NetIntegration.");
    }

    public NetIntegration setLogLevel(int i) {
        PushLog.setLevel(i);
        didinet.Logger.setLevel(i);
        return this;
    }

    /* renamed from: a */
    private void m26107a(final Context context) {
        NetEngine instance = NetEngine.getInstance();
        instance.setTerminalTag(f36854d.getTerminalTag());
        instance.setApolloAPI(new ApolloWrapper());
        instance.setOmegaAPI(new OmegaWrapper());
        instance.setNetworkDetectionAPI(new NetWorkDetectionWrapper());
        instance.setPushAPI(new TransAdapter());
        instance.addStatisticalCallback(new StatisticalCallback() {
            public void onStatisticalDataCallback(StatisticalContext statisticalContext) {
                HashMap hashMap = new HashMap();
                HttpUrl url = statisticalContext.getRequest().url();
                hashMap.put("url", url.toString());
                statisticalContext.addDataToOmega(hashMap);
                int intValue = ((Integer) hashMap.get(Constants.ERROR_CODE)).intValue();
                ConnectivityDetector.getsInstance().trigger(url.toString(), intValue == 0, (Throwable) hashMap.get("e"));
                ConnectivityStatistics lastConnStatistics = ConnectivityDetector.getsInstance().getLastConnStatistics();
                if (lastConnStatistics != null) {
                    int id = lastConnStatistics.getId();
                    int status = lastConnStatistics.getStatus();
                    int source = lastConnStatistics.getSource();
                    String errsPack = lastConnStatistics.getErrsPack();
                    hashMap.put("conn_id_t", id + "," + lastConnStatistics.getTaskTime());
                    hashMap.put("conn_status", Integer.valueOf(status));
                    hashMap.put("conn_source", Integer.valueOf(source));
                    if (!TextUtils.isEmpty(errsPack)) {
                        hashMap.put("conn_errs_pack", errsPack);
                    }
                }
                MASSDK.trackHttpTransactionEvent(hashMap);
            }
        });
        instance.addStatisticalCallback(new StatisticalCallback() {
            public void onStatisticalDataCallback(StatisticalContext statisticalContext) {
                HashMap hashMap = new HashMap();
                statisticalContext.addDataToLocalStorage(hashMap);
                if (!hashMap.isEmpty()) {
                    hashMap.put("url", statisticalContext.getRequest().url().toString());
                    NetIntegration.this.f36856c.errorEvent("HTTP_LOG", (Map<?, ?>) hashMap);
                }
            }
        });
        instance.setParamGetter(new ParamGetter(context, f36854d));
        instance.create(context);
        if (!f36854d.manualInitHttpDns()) {
            Apollo.addCacheLoadedListener(new OnCacheLoadedListener() {
                public void onCacheAlreadyLoaded() {
                    NetIntegration.this.f36856c.debug("initHttpDns from Apollo onCacheAlreadyLoaded()", new Object[0]);
                    new Thread(new Runnable() {
                        public void run() {
                            NetIntegration.this.initHttpDns(context);
                        }
                    }).start();
                    Apollo.removeCacheLoadedListener(this);
                }
            });
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    NetIntegration.this.f36856c.debug("initHttpDns, from initNetwork()", new Object[0]);
                    NetIntegration.this.initHttpDns(context);
                }
            }, 3000);
        }
        NetEngine.getInstance().setTransEnabled(f36854d.getTransEnable(context));
    }

    public void initHttpDns(Context context) {
        InterceptorGetter signInterceptorGetter = f36854d.getSignInterceptorGetter();
        if (signInterceptorGetter != null) {
            HttpDnsManager.getInstance().init(context, f36854d.getDnsParam(), (SigGenerator) null, new HttpDnsParamInterceptorGetter(), signInterceptorGetter);
        } else {
            HttpDnsManager.getInstance().init(context, f36854d.getDnsParam(), (SigGenerator) null, new HttpDnsParamInterceptorGetter());
        }
        ConnectivityDetector.getsInstance().init(context);
    }

    private static class HttpDnsParamInterceptorGetter implements InterceptorGetter {
        private HttpDnsParamInterceptorGetter() {
        }

        public Interceptor get(DidiHttpClient didiHttpClient) {
            return new Interceptor() {
                public Response intercept(Interceptor.Chain chain) throws IOException {
                    Request request = chain.request();
                    HttpUrl.Builder newBuilder = request.url().newBuilder();
                    newBuilder.addQueryParameter("cityid", String.valueOf(NetIntegration.f36854d.getCityID(NetIntegration.f36855e)));
                    return chain.proceed(request.newBuilder().url(newBuilder.build()).build());
                }
            };
        }
    }

    private static class ApolloWrapper implements ApolloAPI {

        static class ToggleWrapper implements ApolloAPI.Toggle {
            private IToggle toggle;

            ToggleWrapper(IToggle iToggle) {
                this.toggle = iToggle;
            }

            public String getName() {
                return this.toggle.getName();
            }

            public boolean allow() {
                return this.toggle.allow();
            }

            public ApolloAPI.Experiment getExperiment() {
                IExperiment experiment = this.toggle.getExperiment();
                return experiment == null ? ApolloAPI.Experiment.NONE : new ExperimentWrapper(experiment);
            }

            public Integer getLogRate() {
                return this.toggle.getLogRate();
            }
        }

        static class ExperimentWrapper implements ApolloAPI.Experiment {
            private IExperiment experiment;

            ExperimentWrapper(IExperiment iExperiment) {
                this.experiment = iExperiment;
            }

            public <T> T getParam(String str, T t) {
                return this.experiment.getParam(str, t);
            }

            public String getTestKey() {
                return this.experiment.getTestKey();
            }
        }

        ApolloWrapper() {
        }

        public ApolloAPI.Toggle getToggle(String str) {
            IToggle toggle = Apollo.getToggle(str);
            return toggle == null ? ApolloAPI.Toggle.NONE : new ToggleWrapper(toggle);
        }

        public ApolloAPI.Toggle getToggle(String str, boolean z) {
            IToggle toggle = Apollo.getToggle(str, z);
            return toggle == null ? ApolloAPI.Toggle.NONE : new ToggleWrapper(toggle);
        }
    }

    private static class OmegaWrapper implements OmegaAPI {
        OmegaWrapper() {
        }

        public void trackEvent(String str) {
            OmegaSDKAdapter.trackEvent(str);
        }

        public void trackEvent(String str, String str2) {
            OmegaSDKAdapter.trackEvent(str, str2);
        }

        public void trackEvent(String str, String str2, Map map) {
            OmegaSDKAdapter.trackEvent(str, str2, map);
        }
    }

    public static class NetWorkDetectionWrapper implements NetworkDetectionAPI {
        public void callPing(NetworkDetectionAPI.PingParam pingParam, final NetworkDetectionAPI.Callback<NetworkDetectionAPI.PingResult> callback) {
            PingParam pingParam2 = new PingParam();
            pingParam2.setUrl(pingParam.url);
            pingParam2.setTimeout(pingParam.pingTimeout);
            pingParam2.setCount(pingParam.pingCount);
            DetectionTaskManager.getInstance().callPingCommand(NetIntegration.f36855e, pingParam2, new DetectionTaskManager.Callback<PingResult>() {
                public void handleResult(PingResult pingResult) {
                    NetworkDetectionAPI.PingResult pingResult2 = new NetworkDetectionAPI.PingResult();
                    pingResult2.normalValue = pingResult.getNormalValue();
                    pingResult2.errValue = pingResult.getErrValue();
                    pingResult2.f57121ip = pingResult.getIp();
                    pingResult2.totalCount = pingResult.getTotalCount();
                    pingResult2.sucCount = pingResult.getSucCount();
                    pingResult2.failCount = pingResult.getFailCount();
                    pingResult2.averageTime = pingResult.getAverageTime();
                    callback.handleResult(pingResult2);
                }
            });
        }

        public void callTraceRoute(NetworkDetectionAPI.TraceRouteParam traceRouteParam, final NetworkDetectionAPI.Callback<NetworkDetectionAPI.TraceRouteResult> callback) {
            TraceRouteParam traceRouteParam2 = new TraceRouteParam();
            traceRouteParam2.url = traceRouteParam.url;
            DetectionTaskManager.getInstance().callTraceRouteCommand(NetIntegration.f36855e, traceRouteParam2, new DetectionTaskManager.Callback<String>() {
                public void handleResult(String str) {
                    NetworkDetectionAPI.TraceRouteResult traceRouteResult = new NetworkDetectionAPI.TraceRouteResult();
                    traceRouteResult.value = str;
                    callback.handleResult(traceRouteResult);
                }
            });
        }
    }

    private static class ParamGetter implements NetEngine.ExternalParamGetter {
        private Context context;
        /* access modifiers changed from: private */
        public AtomicInteger count = new AtomicInteger(0);
        /* access modifiers changed from: private */
        public NetEngine.ExternalParam externalParam;
        private NetParamsAPI netParams;

        public ParamGetter(Context context2, NetParamsAPI netParamsAPI) {
            this.context = context2;
            this.netParams = netParamsAPI;
            register();
        }

        private void register() {
            Context context2 = this.context;
            if (!(context2 instanceof Application)) {
                context2 = context2.getApplicationContext();
            }
            ((Application) context2).registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
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
                    if (ParamGetter.this.count.get() == 0 && ParamGetter.this.externalParam != null) {
                        ParamGetter.this.externalParam.setAppState(1);
                    }
                    ParamGetter.this.count.incrementAndGet();
                }

                public void onActivityStopped(Activity activity) {
                    ParamGetter.this.count.decrementAndGet();
                    if (ParamGetter.this.count.get() == 0 && ParamGetter.this.externalParam != null) {
                        ParamGetter.this.externalParam.setAppState(2);
                    }
                }
            });
        }

        public NetEngine.ExternalParam onGetExternalParam() {
            if (this.externalParam == null) {
                synchronized (this) {
                    if (this.externalParam == null) {
                        this.externalParam = new NetEngine.ExternalParam();
                        if (Apollo.getToggle("flow_mark").allow()) {
                            this.externalParam.setCityId(this.netParams.getCityID(this.context));
                            int flowTag = this.netParams.getFlowTag();
                            if (flowTag != 0) {
                                this.externalParam.setFlowTag(flowTag);
                            }
                        }
                        this.externalParam.setAppState(1);
                    }
                }
            }
            return this.externalParam;
        }
    }

    /* renamed from: a */
    static String m26106a(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", new Class[]{String.class, String.class}).invoke(cls, new Object[]{str, "unknown"});
        } catch (Throwable unused) {
        }
        return str2;
    }
}
