package didinet;

import android.os.SystemClock;
import android.text.TextUtils;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import didihttp.Request;
import didinet.ApolloAPI;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;

public class ProcessSleepDetector {
    public static final String TAG = "ProcessSleepDetector";

    /* renamed from: a */
    private static final String f57133a = "process_sleep_detect";

    /* renamed from: b */
    private AtomicBoolean f57134b = new AtomicBoolean();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public List<SleepBlock> f57135c = new LinkedList();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public long f57136d;

    /* renamed from: e */
    private Timer f57137e = new Timer("sleep_detect_timer", true);

    /* renamed from: f */
    private TimerTask f57138f = new TimerTask() {
        public void run() {
            long uptimeMillis = SystemClock.uptimeMillis();
            Logger.m40928d(ProcessSleepDetector.TAG, "detecting sleep, now:" + uptimeMillis);
            if (ProcessSleepDetector.this.f57136d <= 0) {
                long unused = ProcessSleepDetector.this.f57136d = uptimeMillis;
            }
            if (uptimeMillis - ProcessSleepDetector.this.f57136d > ((long) (ApolloConfig.getInstance().interval + ApolloConfig.getInstance().deviation))) {
                ProcessSleepDetector.this.f57135c.add(new SleepBlock(ProcessSleepDetector.this.f57136d, uptimeMillis));
                while (ProcessSleepDetector.this.f57135c.size() > ApolloConfig.getInstance().maxBlockSize) {
                    ProcessSleepDetector.this.f57135c.remove(0);
                }
            }
            long unused2 = ProcessSleepDetector.this.f57136d = uptimeMillis;
        }
    };

    private static class SingletonHolder {
        /* access modifiers changed from: private */
        public static ProcessSleepDetector INSTANCE = new ProcessSleepDetector();

        private SingletonHolder() {
        }
    }

    public static ProcessSleepDetector getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void start() {
        if (this.f57134b.compareAndSet(false, true)) {
            ApolloConfig.getInstance().parseConfig(f57133a);
        }
        Logger.m40928d(TAG, "detect sleep apollo => " + ApolloConfig.getInstance().isAllow);
        if (ApolloConfig.getInstance().isAllow) {
            Logger.m40928d(TAG, "start detect sleep.");
            this.f57137e.schedule(this.f57138f, 0, (long) ApolloConfig.getInstance().interval);
        }
    }

    public void stop() {
        Logger.m40928d(TAG, "stop detect sleep.");
        this.f57137e.cancel();
        this.f57135c.clear();
    }

    public long adjustHttpCostTime(Request request, long j, long j2) {
        long j3 = j;
        long j4 = j2;
        LinkedList linkedList = new LinkedList();
        linkedList.add(new SleepBlock(j3, j4));
        int size = linkedList.size() - 1;
        int size2 = this.f57135c.size() - 1;
        long j5 = 0;
        while (size > 0 && size2 > 0) {
            long max = Math.max(((SleepBlock) linkedList.get(size)).start, this.f57135c.get(size2).start);
            long min = Math.min(((SleepBlock) linkedList.get(size)).end, this.f57135c.get(size2).end);
            if (max <= min) {
                j5 += min - max;
            }
            if (((SleepBlock) linkedList.get(size)).start > this.f57135c.get(size2).start) {
                size--;
            } else {
                size2--;
            }
        }
        if (j5 > 0) {
            Logger.m40928d(TAG, "find a request during app sleeping. [" + request + Const.jaRight);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("adjustHttpCostTime: t:");
        long j6 = j4 - j3;
        sb.append(j6);
        sb.append(", fix:");
        long j7 = j6 - j5;
        sb.append(j7);
        sb.append(", totalSleepTime:");
        sb.append(j5);
        sb.append(", sleepBlockSize:");
        sb.append(this.f57135c.size());
        Logger.m40928d(TAG, sb.toString());
        return j7;
    }

    private static class SleepBlock {
        long end;
        long start;

        SleepBlock(long j, long j2) {
            if (j > j2) {
                Logger.m40930e(ProcessSleepDetector.TAG, String.format("Error Sleep Block [%s, %s]", new Object[]{Long.valueOf(j), Long.valueOf(j2)}));
            }
            this.start = j;
            this.end = j2;
        }
    }

    private static class ApolloConfig {
        private static final int DEFAULT_DEVIATION = 100;
        private static final int DEFAULT_INTERVAL = 1000;
        private static final boolean DEFAULT_ONLY_BACKGROUND = false;
        private static final int MAX_BLOCK_SIZE = 100;
        /* access modifiers changed from: private */
        public int deviation;
        /* access modifiers changed from: private */
        public int interval;
        /* access modifiers changed from: private */
        public boolean isAllow;
        /* access modifiers changed from: private */
        public int maxBlockSize;
        private boolean onlyDetectInBackground;

        private static class SingletonHolder {
            /* access modifiers changed from: private */
            public static ApolloConfig INSTANCE = new ApolloConfig();

            private SingletonHolder() {
            }
        }

        public static ApolloConfig getInstance() {
            return SingletonHolder.INSTANCE;
        }

        private ApolloConfig() {
            this.isAllow = true;
            this.onlyDetectInBackground = false;
            this.interval = 1000;
            this.deviation = 100;
            this.maxBlockSize = 100;
        }

        /* access modifiers changed from: package-private */
        public void parseConfig(String str) {
            Logger.m40928d(ProcessSleepDetector.TAG, String.format("SleepDetector apollo name is [%s]", new Object[]{str}));
            if (!TextUtils.isEmpty(str)) {
                ApolloAPI apolloAPI = NetEngine.getInstance().getApolloAPI();
                boolean allow = apolloAPI.getToggle(str).allow();
                this.isAllow = allow;
                if (allow) {
                    ApolloAPI.Experiment experiment = apolloAPI.getToggle(str).getExperiment();
                    int intValue = ((Integer) experiment.getParam("interval", 1000)).intValue();
                    this.interval = intValue;
                    Logger.m40928d(ProcessSleepDetector.TAG, String.format("interval => [%s]", new Object[]{Integer.valueOf(intValue)}));
                    int intValue2 = ((Integer) experiment.getParam("deviation", 100)).intValue();
                    this.deviation = intValue2;
                    Logger.m40928d(ProcessSleepDetector.TAG, String.format("deviation => [%s]", new Object[]{Integer.valueOf(intValue2)}));
                    int intValue3 = ((Integer) experiment.getParam("max_blocks", 100)).intValue();
                    this.maxBlockSize = intValue3;
                    Logger.m40928d(ProcessSleepDetector.TAG, String.format("maxBlockSize => [%s]", new Object[]{Integer.valueOf(intValue3)}));
                    boolean booleanValue = ((Boolean) experiment.getParam("only_bg", false)).booleanValue();
                    this.onlyDetectInBackground = booleanValue;
                    Logger.m40928d(ProcessSleepDetector.TAG, String.format("only_bg => [%s]", new Object[]{Boolean.valueOf(booleanValue)}));
                }
            }
        }
    }
}
