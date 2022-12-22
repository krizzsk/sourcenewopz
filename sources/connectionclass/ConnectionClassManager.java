package connectionclass;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

public class ConnectionClassManager {

    /* renamed from: a */
    static final double f56270a = 5.0d;

    /* renamed from: b */
    static final int f56271b = 150;

    /* renamed from: c */
    static final int f56272c = 550;

    /* renamed from: d */
    static final int f56273d = 2000;

    /* renamed from: e */
    static final long f56274e = 20;

    /* renamed from: f */
    static final long f56275f = 10;

    /* renamed from: g */
    private static final int f56276g = 8;

    /* renamed from: h */
    private static final double f56277h = 1.25d;

    /* renamed from: i */
    private static final double f56278i = 0.8d;

    /* renamed from: j */
    private static final double f56279j = 0.05d;

    /* renamed from: k */
    private C20723a f56280k;

    /* renamed from: l */
    private volatile boolean f56281l;

    /* renamed from: m */
    private AtomicReference<ConnectionQuality> f56282m;

    /* renamed from: n */
    private AtomicReference<ConnectionQuality> f56283n;

    /* renamed from: o */
    private ArrayList<ConnectionClassStateChangeListener> f56284o;

    /* renamed from: p */
    private int f56285p;

    public interface ConnectionClassStateChangeListener {
        void onBandwidthStateChange(ConnectionQuality connectionQuality);
    }

    /* synthetic */ ConnectionClassManager(C207211 r1) {
        this();
    }

    private static class ConnectionClassManagerHolder {
        public static final ConnectionClassManager instance = new ConnectionClassManager((C207211) null);

        private ConnectionClassManagerHolder() {
        }
    }

    public static ConnectionClassManager getInstance() {
        return ConnectionClassManagerHolder.instance;
    }

    private ConnectionClassManager() {
        this.f56280k = new C20723a(f56279j);
        this.f56281l = false;
        this.f56282m = new AtomicReference<>(ConnectionQuality.UNKNOWN);
        this.f56284o = new ArrayList<>();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005b, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0076, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x007b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void addBandwidth(long r5, long r7) {
        /*
            r4 = this;
            monitor-enter(r4)
            r0 = 0
            int r2 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r2 == 0) goto L_0x007a
            double r5 = (double) r5
            r0 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r5 = r5 * r0
            double r7 = (double) r7
            double r5 = r5 / r7
            r7 = 4620693217682128896(0x4020000000000000, double:8.0)
            double r5 = r5 * r7
            r7 = 4621819117588971520(0x4024000000000000, double:10.0)
            int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r0 >= 0) goto L_0x0019
            goto L_0x007a
        L_0x0019:
            connectionclass.a r7 = r4.f56280k     // Catch:{ all -> 0x0077 }
            r7.mo169164a(r5)     // Catch:{ all -> 0x0077 }
            boolean r5 = r4.f56281l     // Catch:{ all -> 0x0077 }
            r6 = 1
            if (r5 == 0) goto L_0x005c
            int r5 = r4.f56285p     // Catch:{ all -> 0x0077 }
            int r5 = r5 + r6
            r4.f56285p = r5     // Catch:{ all -> 0x0077 }
            connectionclass.ConnectionQuality r5 = r4.getCurrentBandwidthQuality()     // Catch:{ all -> 0x0077 }
            java.util.concurrent.atomic.AtomicReference<connectionclass.ConnectionQuality> r7 = r4.f56283n     // Catch:{ all -> 0x0077 }
            java.lang.Object r7 = r7.get()     // Catch:{ all -> 0x0077 }
            r8 = 0
            if (r5 == r7) goto L_0x0039
            r4.f56281l = r8     // Catch:{ all -> 0x0077 }
            r4.f56285p = r6     // Catch:{ all -> 0x0077 }
        L_0x0039:
            int r5 = r4.f56285p     // Catch:{ all -> 0x0077 }
            double r0 = (double) r5     // Catch:{ all -> 0x0077 }
            r2 = 4617315517961601024(0x4014000000000000, double:5.0)
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 < 0) goto L_0x005a
            boolean r5 = r4.m40531a()     // Catch:{ all -> 0x0077 }
            if (r5 == 0) goto L_0x005a
            r4.f56281l = r8     // Catch:{ all -> 0x0077 }
            r4.f56285p = r6     // Catch:{ all -> 0x0077 }
            java.util.concurrent.atomic.AtomicReference<connectionclass.ConnectionQuality> r5 = r4.f56282m     // Catch:{ all -> 0x0077 }
            java.util.concurrent.atomic.AtomicReference<connectionclass.ConnectionQuality> r6 = r4.f56283n     // Catch:{ all -> 0x0077 }
            java.lang.Object r6 = r6.get()     // Catch:{ all -> 0x0077 }
            r5.set(r6)     // Catch:{ all -> 0x0077 }
            r4.m40532b()     // Catch:{ all -> 0x0077 }
        L_0x005a:
            monitor-exit(r4)
            return
        L_0x005c:
            java.util.concurrent.atomic.AtomicReference<connectionclass.ConnectionQuality> r5 = r4.f56282m     // Catch:{ all -> 0x0077 }
            java.lang.Object r5 = r5.get()     // Catch:{ all -> 0x0077 }
            connectionclass.ConnectionQuality r7 = r4.getCurrentBandwidthQuality()     // Catch:{ all -> 0x0077 }
            if (r5 == r7) goto L_0x0075
            r4.f56281l = r6     // Catch:{ all -> 0x0077 }
            java.util.concurrent.atomic.AtomicReference r5 = new java.util.concurrent.atomic.AtomicReference     // Catch:{ all -> 0x0077 }
            connectionclass.ConnectionQuality r6 = r4.getCurrentBandwidthQuality()     // Catch:{ all -> 0x0077 }
            r5.<init>(r6)     // Catch:{ all -> 0x0077 }
            r4.f56283n = r5     // Catch:{ all -> 0x0077 }
        L_0x0075:
            monitor-exit(r4)
            return
        L_0x0077:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        L_0x007a:
            monitor-exit(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: connectionclass.ConnectionClassManager.addBandwidth(long, long):void");
    }

    /* renamed from: a */
    private boolean m40531a() {
        if (this.f56280k == null) {
            return false;
        }
        int i = C207211.$SwitchMap$connectionclass$ConnectionQuality[this.f56282m.get().ordinal()];
        double d = 2000.0d;
        double d2 = 550.0d;
        if (i == 1) {
            d2 = 0.0d;
            d = 150.0d;
        } else if (i == 2) {
            d = 550.0d;
            d2 = 150.0d;
        } else if (i != 3) {
            if (i != 4) {
                return true;
            }
            d = 3.4028234663852886E38d;
            d2 = 2000.0d;
        }
        double a = this.f56280k.mo169163a();
        if (a > d) {
            if (a > d * f56277h) {
                return true;
            }
        } else if (a < d2 * 0.8d) {
            return true;
        }
        return false;
    }

    /* renamed from: connectionclass.ConnectionClassManager$1 */
    static /* synthetic */ class C207211 {
        static final /* synthetic */ int[] $SwitchMap$connectionclass$ConnectionQuality;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                connectionclass.ConnectionQuality[] r0 = connectionclass.ConnectionQuality.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$connectionclass$ConnectionQuality = r0
                connectionclass.ConnectionQuality r1 = connectionclass.ConnectionQuality.POOR     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$connectionclass$ConnectionQuality     // Catch:{ NoSuchFieldError -> 0x001d }
                connectionclass.ConnectionQuality r1 = connectionclass.ConnectionQuality.MODERATE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$connectionclass$ConnectionQuality     // Catch:{ NoSuchFieldError -> 0x0028 }
                connectionclass.ConnectionQuality r1 = connectionclass.ConnectionQuality.GOOD     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$connectionclass$ConnectionQuality     // Catch:{ NoSuchFieldError -> 0x0033 }
                connectionclass.ConnectionQuality r1 = connectionclass.ConnectionQuality.EXCELLENT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: connectionclass.ConnectionClassManager.C207211.<clinit>():void");
        }
    }

    public void reset() {
        C20723a aVar = this.f56280k;
        if (aVar != null) {
            aVar.mo169165b();
        }
        this.f56282m.set(ConnectionQuality.UNKNOWN);
    }

    public synchronized ConnectionQuality getCurrentBandwidthQuality() {
        if (this.f56280k == null) {
            return ConnectionQuality.UNKNOWN;
        }
        return m40530a(this.f56280k.mo169163a());
    }

    /* renamed from: a */
    private ConnectionQuality m40530a(double d) {
        if (d < 0.0d) {
            return ConnectionQuality.UNKNOWN;
        }
        if (d < 150.0d) {
            return ConnectionQuality.POOR;
        }
        if (d < 550.0d) {
            return ConnectionQuality.MODERATE;
        }
        if (d < 2000.0d) {
            return ConnectionQuality.GOOD;
        }
        return ConnectionQuality.EXCELLENT;
    }

    public synchronized double getDownloadKBitsPerSecond() {
        double d;
        if (this.f56280k == null) {
            d = -1.0d;
        } else {
            d = this.f56280k.mo169163a();
        }
        return d;
    }

    public ConnectionQuality register(ConnectionClassStateChangeListener connectionClassStateChangeListener) {
        if (connectionClassStateChangeListener != null) {
            this.f56284o.add(connectionClassStateChangeListener);
        }
        return this.f56282m.get();
    }

    public void remove(ConnectionClassStateChangeListener connectionClassStateChangeListener) {
        if (connectionClassStateChangeListener != null) {
            this.f56284o.remove(connectionClassStateChangeListener);
        }
    }

    /* renamed from: b */
    private void m40532b() {
        int size = this.f56284o.size();
        for (int i = 0; i < size; i++) {
            this.f56284o.get(i).onBandwidthStateChange(this.f56282m.get());
        }
    }
}
