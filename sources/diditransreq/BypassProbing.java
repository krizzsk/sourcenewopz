package diditransreq;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import didinet.ApolloAPI;
import didinet.Logger;
import didinet.NetEngine;
import didinet.OmegaAPI;
import didinet.PushAPI;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.SocketFactory;
import org.jacoco.agent.p086rt.internal_8ff85ea.core.runtime.AgentOptions;

public class BypassProbing {

    /* renamed from: a */
    private static final String f57150a = "BypassProbing";

    /* renamed from: b */
    private static BypassProbing f57151b = null;

    /* renamed from: g */
    private static final int f57152g = 1;

    /* renamed from: h */
    private static final int f57153h = 2;

    /* renamed from: c */
    private LooperHandler f57154c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public WorkHandler f57155d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public List<Long> f57156e = Collections.synchronizedList(new ArrayList());

    /* renamed from: f */
    private boolean f57157f = false;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public long f57158i;

    /* renamed from: j */
    private int f57159j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public int f57160k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public int f57161l;

    private BypassProbing() {
        ApolloAPI apolloAPI = NetEngine.getInstance().getApolloAPI();
        boolean allow = apolloAPI.getToggle("PushBypassCheck").allow();
        this.f57157f = allow;
        Logger.m40928d(f57150a, String.format("apollo enabled => [%s]", new Object[]{Boolean.valueOf(allow)}));
        if (this.f57157f) {
            ApolloAPI.Experiment experiment = apolloAPI.getToggle("PushBypassCheck").getExperiment();
            this.f57159j = ((Integer) experiment.getParam("delay", 10)).intValue();
            this.f57160k = ((Integer) experiment.getParam("interval", 10)).intValue();
            this.f57161l = ((Integer) experiment.getParam("timeout", 10)).intValue();
            m40966a();
            HandlerThread handlerThread = new HandlerThread("BypassProbingLooperThread");
            handlerThread.start();
            this.f57154c = new LooperHandler(handlerThread.getLooper());
            HandlerThread handlerThread2 = new HandlerThread("BypassProbingWorkerThread");
            handlerThread2.start();
            this.f57155d = new WorkHandler(handlerThread2.getLooper());
        }
    }

    /* renamed from: a */
    private void m40966a() {
        if (this.f57159j < 5) {
            this.f57159j = 5;
        }
        if (this.f57160k < 10) {
            this.f57160k = 10;
        }
        if (this.f57161l < 5) {
            this.f57161l = 5;
        }
    }

    public static BypassProbing getDefault() {
        if (f57151b == null) {
            synchronized (BypassProbing.class) {
                if (f57151b == null) {
                    f57151b = new BypassProbing();
                }
            }
        }
        return f57151b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo170573a(long j) {
        if (this.f57157f) {
            this.f57156e.add(Long.valueOf(j));
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.obj = Long.valueOf(j);
            this.f57154c.sendMessageDelayed(obtain, (long) (this.f57159j * 1000));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo170574b(long j) {
        if (this.f57157f) {
            this.f57156e.remove(Long.valueOf(j));
        }
    }

    private class LooperHandler extends Handler {
        LooperHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1) {
                long longValue = ((Long) message.obj).longValue();
                if (BypassProbing.this.f57156e.contains(Long.valueOf(longValue))) {
                    BypassProbing.this.f57156e.remove(Long.valueOf(longValue));
                    BypassProbing.this.f57155d.addWork(longValue);
                }
            }
        }
    }

    private class WorkHandler extends Handler {
        private AtomicInteger atomic = new AtomicInteger();

        /* access modifiers changed from: package-private */
        public void addWork(long j) {
            if (this.atomic.get() == 0) {
                this.atomic.incrementAndGet();
                Logger.m40928d(BypassProbing.f57150a, String.format("seqId[%s] trigger bypass detect", new Object[]{Long.valueOf(j)}));
                sendEmptyMessage(2);
                return;
            }
            Logger.m40928d(BypassProbing.f57150a, String.format("seqId[%s] trigger bypass detect failed, because detect is doing!", new Object[]{Long.valueOf(j)}));
        }

        WorkHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            if (message.what == 2) {
                doConnect();
            }
        }

        private void doConnect() {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (elapsedRealtime - BypassProbing.this.f57158i < ((long) (BypassProbing.this.f57160k * 1000))) {
                Logger.m40928d(BypassProbing.f57150a, String.format("bypass detect interval be more than [%s] s", new Object[]{Integer.valueOf(BypassProbing.this.f57160k)}));
                this.atomic.decrementAndGet();
                return;
            }
            long unused = BypassProbing.this.f57158i = elapsedRealtime;
            PushAPI pushAPI = NetEngine.getInstance().getPushAPI();
            PushAPI.PushParam pushParam = pushAPI.getPushParam();
            String str = null;
            int i = -1;
            if (pushParam != null) {
                str = pushParam.pushHost;
                i = pushParam.pushPort;
            }
            if (TextUtils.isEmpty(str) || i < 0) {
                Logger.m40928d(BypassProbing.f57150a, String.format("push host[%s] or push port[%d] is not illegal!", new Object[]{"" + str, Integer.valueOf(i)}));
                this.atomic.decrementAndGet();
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("ip", str);
            hashMap.put(AgentOptions.PORT, Integer.valueOf(i));
            hashMap.put("isconn", Boolean.valueOf(pushAPI.isConnected()));
            hashMap.put("ver", pushParam.pushVer);
            hashMap.put("tls", Integer.valueOf(pushParam.tls ? 2 : 1));
            SocketFactory socketFactory = SocketFactory.getDefault();
            try {
                Logger.m40928d(BypassProbing.f57150a, String.format("start connect server [%s:%d]", new Object[]{str, Integer.valueOf(i)}));
                Socket createSocket = socketFactory.createSocket();
                createSocket.connect(new InetSocketAddress(str, i), BypassProbing.this.f57161l * 1000);
                createSocket.close();
                Logger.m40928d(BypassProbing.f57150a, "bypass detect success");
                hashMap.put(C12407a.f36608f, 1);
            } catch (IOException e) {
                Logger.m40929d(BypassProbing.f57150a, "An IO Exception was thrown", e);
                if (e.getMessage().contains("connection refused")) {
                    hashMap.put(C12407a.f36608f, 1);
                    hashMap.put("reason", e.getMessage());
                } else {
                    hashMap.put(C12407a.f36608f, 0);
                    hashMap.put("reason", e.getMessage());
                }
            } catch (Throwable th) {
                this.atomic.decrementAndGet();
                OmegaAPI omegaAPI = NetEngine.getInstance().getOmegaAPI();
                Logger.m40928d(BypassProbing.f57150a, "Omega trackEvent");
                omegaAPI.trackEvent("socket_bypass_detect", "", hashMap);
                throw th;
            }
            this.atomic.decrementAndGet();
            OmegaAPI omegaAPI2 = NetEngine.getInstance().getOmegaAPI();
            Logger.m40928d(BypassProbing.f57150a, "Omega trackEvent");
            omegaAPI2.trackEvent("socket_bypass_detect", "", hashMap);
        }
    }
}
