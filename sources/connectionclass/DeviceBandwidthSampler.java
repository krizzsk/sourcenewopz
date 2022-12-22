package connectionclass;

import android.net.TrafficStats;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import java.util.concurrent.atomic.AtomicInteger;

public class DeviceBandwidthSampler {

    /* renamed from: f */
    private static long f56286f = -1;

    /* renamed from: a */
    private final ConnectionClassManager f56287a;

    /* renamed from: b */
    private AtomicInteger f56288b;

    /* renamed from: c */
    private SamplingHandler f56289c;

    /* renamed from: d */
    private HandlerThread f56290d;

    /* renamed from: e */
    private long f56291e;

    private static class DeviceBandwidthSamplerHolder {
        public static final DeviceBandwidthSampler instance = new DeviceBandwidthSampler(ConnectionClassManager.getInstance());

        private DeviceBandwidthSamplerHolder() {
        }
    }

    public static DeviceBandwidthSampler getInstance() {
        return DeviceBandwidthSamplerHolder.instance;
    }

    private DeviceBandwidthSampler(ConnectionClassManager connectionClassManager) {
        this.f56287a = connectionClassManager;
        this.f56288b = new AtomicInteger();
        HandlerThread handlerThread = new HandlerThread("ParseThread");
        this.f56290d = handlerThread;
        handlerThread.start();
        this.f56289c = new SamplingHandler(this.f56290d.getLooper());
    }

    public void startSampling() {
        if (this.f56288b.getAndIncrement() == 0) {
            this.f56289c.startSamplingThread();
            this.f56291e = SystemClock.elapsedRealtime();
        }
    }

    public void stopSampling() {
        if (this.f56288b.decrementAndGet() == 0) {
            this.f56289c.stopSamplingThread();
            addFinalSample();
        }
    }

    /* access modifiers changed from: protected */
    public void addSample() {
        long totalRxBytes = TrafficStats.getTotalRxBytes();
        long j = f56286f;
        long j2 = totalRxBytes - j;
        if (j >= 0) {
            synchronized (this) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                this.f56287a.addBandwidth(j2, elapsedRealtime - this.f56291e);
                this.f56291e = elapsedRealtime;
            }
        }
        f56286f = totalRxBytes;
    }

    /* access modifiers changed from: protected */
    public void addFinalSample() {
        addSample();
        f56286f = -1;
    }

    public boolean isSampling() {
        return this.f56288b.get() != 0;
    }

    private class SamplingHandler extends Handler {
        private static final int MSG_START = 1;
        static final long SAMPLE_TIME = 1000;

        public SamplingHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            if (message.what == 1) {
                DeviceBandwidthSampler.this.addSample();
                sendEmptyMessageDelayed(1, 1000);
                return;
            }
            throw new IllegalArgumentException("Unknown what=" + message.what);
        }

        public void startSamplingThread() {
            sendEmptyMessage(1);
        }

        public void stopSamplingThread() {
            removeMessages(1);
        }
    }
}
