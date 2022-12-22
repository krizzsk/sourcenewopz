package com.didi.one.netdetect;

import android.content.Context;
import android.text.TextUtils;
import com.didi.one.netdetect.command.Command;
import com.didi.one.netdetect.command.PingResult;
import com.didi.one.netdetect.http.HttpService;
import com.didi.one.netdetect.http.ResponseListener;
import com.didi.one.netdetect.model.DetectionGroup;
import com.didi.one.netdetect.model.DetectionItem;
import com.didi.one.netdetect.model.DetectionItemResult;
import com.didi.one.netdetect.model.DetectionParam;
import com.didi.one.netdetect.model.DetectionReportInfo;
import com.didi.one.netdetect.model.PingParam;
import com.didi.one.netdetect.model.ResponseInfo;
import com.didi.one.netdetect.model.TraceRouteItemResult;
import com.didi.one.netdetect.model.TraceRouteParam;
import com.didi.one.netdetect.model.TraceRouteReportInfo;
import com.didi.one.netdetect.provider.ApolloProvider;
import com.didi.one.netdetect.provider.IDetectionGroupProvider;
import com.didi.one.netdetect.security.SignGenerator;
import com.didi.one.netdetect.task.DidiHttpTask;
import com.didi.one.netdetect.task.PingTask;
import com.didi.one.netdetect.task.TracePathTask;
import com.didi.one.netdetect.task.TraceRouteTask;
import com.didi.one.netdetect.util.ONDLog;
import com.didi.one.netdetect.util.PrefUtil;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

public class DetectionTaskManager {

    /* renamed from: a */
    private static final String f29400a = "OND_TaskManager";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Context f29401b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public DetectionGroup f29402c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public List<DetectionItem> f29403d;

    /* renamed from: e */
    private Thread f29404e;

    /* renamed from: f */
    private DetectionTask f29405f;

    /* renamed from: g */
    private boolean f29406g;

    /* renamed from: h */
    private DetectionParam f29407h;

    /* renamed from: i */
    private SignGenerator f29408i;

    /* renamed from: j */
    private IDetectionGroupProvider f29409j;

    /* renamed from: k */
    private State f29410k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public Logger f29411l;

    /* renamed from: m */
    private ExecutorService f29412m;

    /* renamed from: n */
    private AtomicBoolean f29413n;

    /* renamed from: o */
    private boolean f29414o;

    public static abstract class Callback<T> implements Command.OutPutHandler<T> {
        public void handleMsg(String str) {
        }

        public void handleResult(T t) {
        }
    }

    public enum State {
        NONE,
        STARTED,
        RUNNING,
        STOP,
        RESUME,
        CANCEL
    }

    private DetectionTaskManager() {
        this.f29403d = new ArrayList();
        this.f29410k = State.NONE;
        this.f29411l = LoggerFactory.getLogger("OneNetDetect");
        this.f29413n = new AtomicBoolean(false);
    }

    public static DetectionTaskManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    static class SingletonHolder {
        /* access modifiers changed from: private */
        public static DetectionTaskManager INSTANCE = new DetectionTaskManager();

        SingletonHolder() {
        }
    }

    public void init(Context context, DetectionParam detectionParam, SignGenerator signGenerator) {
        if (this.f29413n.compareAndSet(false, true)) {
            this.f29401b = context.getApplicationContext();
            this.f29407h = detectionParam;
            this.f29408i = signGenerator;
            this.f29409j = new ApolloProvider(detectionParam.apolloName);
            TraceRouteStore.m20718a().mo80419a(context, detectionParam, signGenerator);
        }
    }

    public void setDetectionGroupProvider(IDetectionGroupProvider iDetectionGroupProvider) {
        this.f29409j = iDetectionGroupProvider;
    }

    public synchronized void startDetection() {
        if (!this.f29413n.get()) {
            ONDLog.m20755d(f29400a, "not inited");
            return;
        }
        ONDLog.m20755d(f29400a, "invoke startDetection()");
        if (this.f29410k == State.STOP) {
            this.f29410k = State.STARTED;
        } else if (this.f29410k == State.NONE || this.f29410k == State.RESUME) {
            m20705a();
        }
        ONDLog.m20755d(f29400a, "current state: " + this.f29410k.toString());
    }

    /* renamed from: a */
    private void m20705a() {
        if (!this.f29406g) {
            DetectionGroup providerDetectionGroup = this.f29409j.providerDetectionGroup();
            this.f29402c = providerDetectionGroup;
            if (providerDetectionGroup == null) {
                this.f29410k = State.CANCEL;
                return;
            }
            this.f29406g = true;
            this.f29410k = State.RUNNING;
            this.f29405f = new DetectionTask();
            Thread thread = new Thread(this.f29405f);
            this.f29404e = thread;
            thread.setPriority(1);
            this.f29404e.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                public void uncaughtException(Thread thread, Throwable th) {
                    StringWriter stringWriter = new StringWriter();
                    th.printStackTrace(new PrintWriter(stringWriter));
                    String stringWriter2 = stringWriter.toString();
                    HashMap hashMap = new HashMap();
                    hashMap.put("exception", stringWriter2);
                    DetectionTaskManager.this.f29411l.errorEvent("DetectionThreadException", (Map<?, ?>) hashMap);
                }
            });
            this.f29404e.start();
        }
    }

    public synchronized void cancelDetection() {
        if (!this.f29413n.get()) {
            ONDLog.m20755d(f29400a, "not inited");
            return;
        }
        ONDLog.m20759i(f29400a, "invoke cancelDetection()");
        this.f29410k = State.CANCEL;
        if (this.f29405f != null) {
            this.f29405f.cancel();
        }
        ONDLog.m20755d(f29400a, "current state: " + this.f29410k.toString());
    }

    public synchronized void stopDetection() {
        if (!this.f29413n.get()) {
            ONDLog.m20755d(f29400a, "not inited");
            return;
        }
        ONDLog.m20759i(f29400a, "invoke stopDetection()");
        if (this.f29410k != State.CANCEL) {
            this.f29410k = State.STOP;
            if (this.f29405f != null) {
                this.f29405f.stop();
            }
        }
        ONDLog.m20755d(f29400a, "current state: " + this.f29410k.toString());
    }

    public synchronized void resumeDetection() {
        if (!this.f29413n.get()) {
            ONDLog.m20755d(f29400a, "not inited");
            return;
        }
        ONDLog.m20759i(f29400a, "invoke resumeDetection()");
        if (this.f29410k == State.STARTED) {
            m20705a();
        } else if (this.f29410k == State.STOP) {
            if (this.f29406g) {
                this.f29410k = State.RUNNING;
            } else {
                this.f29410k = State.RESUME;
            }
            if (this.f29405f != null) {
                this.f29405f.resume();
            }
        }
        ONDLog.m20755d(f29400a, "current state: " + this.f29410k.toString());
    }

    private class DetectionTask implements Runnable {
        volatile boolean cancelled;
        volatile boolean stopped;

        private DetectionTask() {
        }

        public void cancel() {
            this.cancelled = true;
        }

        public void stop() {
            this.stopped = true;
        }

        public void resume() {
            this.stopped = false;
        }

        public void run() {
            while (!this.cancelled) {
                if (!this.stopped) {
                    DetectionTaskManager.this.f29403d.clear();
                    long currentTimeMillis = System.currentTimeMillis();
                    ArrayList arrayList = new ArrayList();
                    DidiHttpTask.TaskParams taskParams = new DidiHttpTask.TaskParams();
                    taskParams.mTimeout = DetectionTaskManager.this.f29402c.detecTimeout;
                    DidiHttpTask didiHttpTask = new DidiHttpTask(taskParams);
                    PingTask pingTask = new PingTask(DetectionTaskManager.this.f29401b);
                    pingTask.setTimeout(((DetectionTaskManager.this.f29402c.pingTimeout / 1000) * DetectionTaskManager.this.f29402c.pingCount) + 3);
                    pingTask.setCount(DetectionTaskManager.this.f29402c.pingCount);
                    for (DetectionItem next : DetectionTaskManager.this.f29402c.detectList) {
                        ONDLog.m20755d(DetectionTaskManager.f29400a, "START GET");
                        DidiHttpTask.HttpTaskResult doTask = didiHttpTask.doTask(next);
                        ONDLog.m20755d(DetectionTaskManager.f29400a, "END GET");
                        ONDLog.m20755d(DetectionTaskManager.f29400a, "START PING");
                        PingResult doTask2 = pingTask.doTask(next);
                        ONDLog.m20755d(DetectionTaskManager.f29400a, "END PING");
                        DetectionItemResult detectionItemResult = new DetectionItemResult();
                        detectionItemResult.detectId = next.f29447id;
                        detectionItemResult.resolveHttpTaskResult(doTask);
                        detectionItemResult.resolvePingTaskResult(doTask2);
                        DetectionTaskManager detectionTaskManager = DetectionTaskManager.this;
                        if (detectionTaskManager.m20710a(detectionTaskManager.f29402c, doTask2)) {
                            PrefUtil.setPingOutputTime(DetectionTaskManager.this.f29401b, System.currentTimeMillis());
                            detectionItemResult.resolvePingTaskResultExtra(doTask2);
                        }
                        arrayList.add(detectionItemResult);
                        DetectionTaskManager detectionTaskManager2 = DetectionTaskManager.this;
                        if (detectionTaskManager2.m20711a(detectionTaskManager2.f29402c, detectionItemResult)) {
                            DetectionTaskManager.this.f29403d.add(next);
                        }
                    }
                    long currentTimeMillis2 = System.currentTimeMillis();
                    ONDLog.m20755d(DetectionTaskManager.f29400a, "one round get and ping takes " + String.valueOf(currentTimeMillis2 - currentTimeMillis) + " ms");
                    DetectionTaskManager.this.m20715b((List<DetectionItemResult>) arrayList);
                    if (DetectionTaskManager.this.f29403d.size() > 0) {
                        PrefUtil.setTraceRouteTime(DetectionTaskManager.this.f29401b, System.currentTimeMillis());
                        long currentTimeMillis3 = System.currentTimeMillis();
                        ArrayList arrayList2 = new ArrayList();
                        TracePathTask tracePathTask = new TracePathTask(DetectionTaskManager.this.f29401b);
                        for (DetectionItem detectionItem : DetectionTaskManager.this.f29403d) {
                            ONDLog.m20755d(DetectionTaskManager.f29400a, "START TRACEROUTE");
                            String doTask3 = tracePathTask.doTask(detectionItem);
                            ONDLog.m20755d(DetectionTaskManager.f29400a, "END TRACEROUTE");
                            TraceRouteItemResult traceRouteItemResult = new TraceRouteItemResult();
                            traceRouteItemResult.detectId = detectionItem.f29447id;
                            traceRouteItemResult.trTime = System.currentTimeMillis();
                            traceRouteItemResult.info = doTask3;
                            arrayList2.add(traceRouteItemResult);
                        }
                        long currentTimeMillis4 = System.currentTimeMillis();
                        ONDLog.m20755d(DetectionTaskManager.f29400a, "one round traceRoute takes " + String.valueOf(currentTimeMillis4 - currentTimeMillis3) + " ms");
                        DetectionTaskManager.this.m20707a((List<TraceRouteItemResult>) arrayList2);
                        try {
                            if (DetectionTaskManager.this.f29402c.detectInterval > 0) {
                                Thread.sleep((long) (DetectionTaskManager.this.f29402c.detectInterval * 1000));
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        try {
                            if (DetectionTaskManager.this.f29402c.detectInterval > 0) {
                                Thread.sleep((long) (DetectionTaskManager.this.f29402c.detectInterval * 1000));
                            }
                        } catch (InterruptedException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m20707a(List<TraceRouteItemResult> list) {
        final TraceRouteReportInfo traceRouteReportInfo = new TraceRouteReportInfo();
        traceRouteReportInfo.setData(list);
        final String b = m20712b();
        if (!TextUtils.isEmpty(b)) {
            HttpService.traceRouteInfoReport(this.f29401b, b + HttpService.TRACE_ROUTE_REPORT_PATH, this.f29407h, traceRouteReportInfo, this.f29408i, new ResponseListener<ResponseInfo>() {
                public void onSuccess(ResponseInfo responseInfo) {
                }

                public void onFail(Throwable th) {
                    TraceRouteStore.m20718a().mo80421a(b, 1, traceRouteReportInfo);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m20715b(List<DetectionItemResult> list) {
        DetectionReportInfo detectionReportInfo = new DetectionReportInfo();
        detectionReportInfo.setData(list);
        String b = m20712b();
        if (!TextUtils.isEmpty(b)) {
            HttpService.detectionInfoReport(this.f29401b, b + HttpService.DETECTION_REPORT_PATH, this.f29407h, detectionReportInfo, this.f29408i, new ResponseListener<ResponseInfo>() {
                public void onSuccess(ResponseInfo responseInfo) {
                    ONDLog.m20755d(DetectionTaskManager.f29400a, "uploadDetectionInfo success");
                }

                public void onFail(Throwable th) {
                    ONDLog.m20755d(DetectionTaskManager.f29400a, "uploadDetectionInfo failed");
                }
            });
        }
    }

    /* renamed from: b */
    private String m20712b() {
        int i;
        DetectionGroup detectionGroup = this.f29402c;
        if (detectionGroup == null || detectionGroup.reportUrl == null || this.f29402c.reportUrl.size() == 0) {
            return "";
        }
        if (this.f29402c.reportUrl.size() == 1) {
            i = 0;
        } else {
            i = new Random().nextInt(this.f29402c.reportUrl.size());
        }
        String str = this.f29402c.reportUrl.get(i);
        if (str.startsWith("http") || str.startsWith("https")) {
            return str;
        }
        if (this.f29414o) {
            return "http://" + str;
        }
        return "https://" + str;
    }

    public void setDebugMode(boolean z) {
        this.f29414o = z;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m20710a(DetectionGroup detectionGroup, PingResult pingResult) {
        if (this.f29414o) {
            return true;
        }
        if (detectionGroup != null && pingResult != null && pingResult.isFailAll() && new Random().nextInt(1000) < detectionGroup.pingOutputPercent) {
            if (System.currentTimeMillis() - PrefUtil.getPingOutputTime(this.f29401b) > ((long) (detectionGroup.pingOutputInterval * 1000))) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m20711a(DetectionGroup detectionGroup, DetectionItemResult detectionItemResult) {
        if (this.f29414o) {
            return true;
        }
        if ((detectionItemResult.detectErrCode >= 2200 && detectionItemResult.detectErrCode <= 2300 && detectionItemResult.pingErrorNum != detectionGroup.pingCount) || new Random().nextInt(1000) >= detectionGroup.trPercent) {
            return false;
        }
        if (System.currentTimeMillis() - PrefUtil.getTraceRouteTime(this.f29401b) > ((long) (detectionGroup.trInterval * 1000))) {
            return true;
        }
        return false;
    }

    public void callPingCommand(final Context context, final PingParam pingParam, final Callback<PingResult> callback) {
        if (context != null && pingParam != null) {
            if (this.f29412m == null) {
                this.f29412m = Executors.newFixedThreadPool(2);
            }
            this.f29412m.execute(new Runnable() {
                public void run() {
                    DetectionItem detectionItem = new DetectionItem();
                    detectionItem.url = pingParam.getUrl();
                    PingTask pingTask = new PingTask(context, new Command.OutPutHandler<PingResult>() {
                        public void handleMsg(String str) {
                            if (callback != null) {
                                callback.handleMsg(str);
                            }
                        }

                        public void handleResult(PingResult pingResult) {
                            if (callback != null) {
                                callback.handleResult(pingResult);
                            }
                        }
                    });
                    pingTask.setTimeout((pingParam.getTimeout() * pingParam.getCount()) + 3);
                    pingTask.setCount(pingParam.getCount());
                    pingTask.doTask(detectionItem);
                }
            });
        }
    }

    public void callTraceRouteCommand(final Context context, final TraceRouteParam traceRouteParam, final Callback<String> callback) {
        if (context != null && traceRouteParam != null) {
            if (this.f29412m == null) {
                this.f29412m = Executors.newFixedThreadPool(2);
            }
            this.f29412m.execute(new Runnable() {
                public void run() {
                    DetectionItem detectionItem = new DetectionItem();
                    detectionItem.url = traceRouteParam.url;
                    TraceRouteTask traceRouteTask = new TraceRouteTask(context, new Command.OutPutHandler<String>() {
                        public void handleMsg(String str) {
                            if (callback != null) {
                                callback.handleMsg(str);
                            }
                        }

                        public void handleResult(String str) {
                            if (callback != null) {
                                callback.handleResult(str);
                            }
                        }
                    });
                    traceRouteTask.setMaxTTL(traceRouteParam.maxTTL);
                    traceRouteTask.setWaitTime(traceRouteParam.waitTime);
                    traceRouteTask.doTask(detectionItem);
                }
            });
        }
    }
}
