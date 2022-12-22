package p235for;

import com.iproov.sdk.core.C19908try;
import com.iproov.sdk.logging.IPLog;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import p093switch.C3108catch;
import p093switch.C3127throw;

/* renamed from: for.for */
/* compiled from: FlashingManager */
public final class C20837for implements C19908try {

    /* renamed from: a */
    private static final String f57246a = ("🔦 " + C20837for.class.getSimpleName());

    /* renamed from: b */
    private static long f57247b = -1;

    /* renamed from: c */
    private boolean f57248c = false;

    /* renamed from: d */
    private final List<C20836do> f57249d;

    /* renamed from: e */
    private final C20838do f57250e;

    /* renamed from: f */
    private final C20840new f57251f;

    /* renamed from: g */
    private final AtomicInteger f57252g = new AtomicInteger(0);

    /* renamed from: for.for$do */
    /* compiled from: FlashingManager */
    public interface C20838do {
        /* renamed from: do */
        void mo162112do();

        /* renamed from: do */
        void mo162113do(int i, C20836do doVar, int i2);

        /* renamed from: if */
        void mo162114if();
    }

    public C20837for(C20839if ifVar, C20840new newR, C20838do doVar) {
        this.f57251f = newR;
        this.f57249d = ifVar.mo170688do(newR.f61848new, newR.f61849try);
        this.f57250e = doVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m41049b() {
        int i = 0;
        while (i < m47647new() && !this.f57248c) {
            try {
                C20836do doVar = this.f57249d.get(i);
                m41048a();
                StringBuilder sb = new StringBuilder();
                sb.append("========== FLASHING ");
                sb.append(doVar);
                sb.append(" ==========");
                int i2 = this.f57252g.get();
                this.f57250e.mo162113do(i, doVar, i2);
                Thread.sleep((long) i2);
                if (i >= this.f57251f.f61847for) {
                    for (int i3 = 0; i3 < this.f57251f.f57255if; i3++) {
                        this.f57250e.mo162114if();
                    }
                }
                i++;
            } catch (InterruptedException unused) {
            }
        }
        this.f57250e.mo162112do();
    }

    /* renamed from: do */
    public void mo170684do(float f, float f2) {
        float min = Math.min(f, f2);
        C20840new newR = this.f57251f;
        int i = (int) C3127throw.m4046do((1.0d / ((double) min)) * ((double) newR.f57254do), (double) newR.f61845case, (double) newR.f61846else);
        this.f57252g.set(i);
        StringBuilder sb = new StringBuilder();
        sb.append("Flash speed: ");
        sb.append(i);
        sb.append("ms FPS=");
        sb.append(min);
        sb.append(" scalefactor=");
        sb.append(this.f57251f.f57254do);
        sb.append(" limits=");
        sb.append(this.f57251f.f61845case);
        sb.append("..");
        sb.append(this.f57251f.f61846else);
    }

    /* renamed from: for  reason: not valid java name */
    public void m47646for() {
        this.f57248c = true;
    }

    /* renamed from: if */
    public void mo170686if(float f, float f2) {
        mo170684do(f, f2);
        C3108catch.m4014do("FlashingLoop", C3108catch.C3110for.HIGH, (Runnable) new Runnable() {
            public final void run() {
                C20837for.this.m41049b();
            }
        }).start();
    }

    /* renamed from: new  reason: not valid java name */
    public int m47647new() {
        return this.f57249d.size();
    }

    /* renamed from: do */
    public int mo162065do() {
        int i = m47647new();
        C20840new newR = this.f57251f;
        return (i - newR.f61847for) * newR.f57255if;
    }

    /* renamed from: a */
    private static void m41048a() {
        long nanoTime = System.nanoTime();
        long j = (nanoTime - f57247b) / 1000000;
        if (j >= 175) {
            f57247b = nanoTime;
            return;
        }
        String str = "Maximum flash rate (175 ms) exceeded, flashing aborted (" + j + " ms)";
        IPLog.m39305w(f57246a, "Epilepsy warning! " + str);
        throw new IllegalStateException(str);
    }
}
