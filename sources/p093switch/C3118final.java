package p093switch;

import java.util.Timer;
import java.util.TimerTask;

/* renamed from: switch.final */
/* compiled from: UITimer */
public class C3118final {

    /* renamed from: a */
    private Timer f6948a;

    /* renamed from: switch.final$do */
    /* compiled from: UITimer */
    class C3119do extends TimerTask {

        /* renamed from: do */
        final /* synthetic */ Runnable f6949do;

        C3119do(C3118final finalR, Runnable runnable) {
            this.f6949do = runnable;
        }

        public void run() {
            C3127throw.m4052do(this.f6949do);
        }
    }

    /* renamed from: switch.final$if */
    /* compiled from: UITimer */
    class C3120if extends TimerTask {

        /* renamed from: do */
        final /* synthetic */ Runnable f6950do;

        C3120if(C3118final finalR, Runnable runnable) {
            this.f6950do = runnable;
        }

        public void run() {
            C3127throw.m4052do(this.f6950do);
        }
    }

    public C3118final(long j, boolean z, Runnable runnable) {
        Timer timer = new Timer();
        this.f6948a = timer;
        if (z) {
            timer.schedule(new C3119do(this, runnable), j, j);
        } else {
            timer.schedule(new C3120if(this, runnable), j);
        }
    }

    /* renamed from: do */
    public void mo38620do() {
        this.f6948a.cancel();
    }
}
