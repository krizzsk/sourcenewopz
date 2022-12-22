package com.iproov.sdk.core;

import android.graphics.Bitmap;
import android.graphics.RectF;
import android.os.Build;
import com.iproov.sdk.core.C19880const;
import com.iproov.sdk.face.model.FaceFeature;
import com.iproov.sdk.logging.IPLog;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import p093switch.C3108catch;
import p093switch.C3121for;
import p093switch.C3123if;
import p096try.C3136do;
import p232do.C20821for;

/* renamed from: com.iproov.sdk.core.class */
/* compiled from: LivenessFrameSelector */
class C19878class {

    /* renamed from: a */
    private static final String f54190a = "class";

    /* renamed from: b */
    private final C3123if f54191b = new C3123if();

    /* renamed from: c */
    private final BlockingQueue<C19879do> f54192c;

    /* renamed from: d */
    private C19880const.C19881do f54193d;

    /* renamed from: e */
    private final int f54194e;

    /* renamed from: f */
    private int f54195f = 0;

    /* renamed from: g */
    private int f54196g = 1;

    /* renamed from: h */
    private final AtomicInteger f54197h = new AtomicInteger(0);

    /* renamed from: i */
    private Double f54198i = null;

    /* renamed from: j */
    private C19879do f54199j = null;

    /* renamed from: k */
    private boolean f54200k = true;

    /* renamed from: l */
    private int f54201l = 0;

    /* renamed from: m */
    private long f54202m = 0;

    /* renamed from: n */
    private int f54203n = 0;

    /* renamed from: o */
    private int f54204o = 0;

    /* renamed from: p */
    private final StringBuffer f54205p = new StringBuffer();

    /* renamed from: q */
    private final StringBuffer f54206q = new StringBuffer();

    /* renamed from: com.iproov.sdk.core.class$do */
    /* compiled from: LivenessFrameSelector */
    private static class C19879do {

        /* renamed from: case  reason: not valid java name */
        public final boolean f61763case;

        /* renamed from: do */
        public final C20821for f54207do;

        /* renamed from: else  reason: not valid java name */
        public final int f61764else;

        /* renamed from: for  reason: not valid java name */
        public final FaceFeature f61765for;

        /* renamed from: if */
        public final Bitmap f54208if;

        /* renamed from: new  reason: not valid java name */
        public final RectF f61766new;

        /* renamed from: try  reason: not valid java name */
        public final int f61767try;

        public C19879do(C20821for forR, Bitmap bitmap, FaceFeature faceFeature, RectF rectF, C3136do doVar, int i, boolean z, int i2) {
            this.f54207do = forR;
            this.f54208if = bitmap;
            this.f61765for = faceFeature;
            this.f61766new = rectF;
            this.f61767try = i;
            this.f61763case = z;
            this.f61764else = i2;
        }
    }

    public C19878class(C19880const.C19881do doVar, int i, int i2) {
        this.f54194e = i2;
        this.f54193d = doVar;
        this.f54192c = new ArrayBlockingQueue(i2 * i);
        C3108catch.m4014do("LivenessFrameSelector", C3108catch.C3110for.LOW, (Runnable) new Runnable(doVar) {
            public final /* synthetic */ C19880const.C19881do f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                C19878class.this.m39069a(this.f$1);
            }
        }).start();
    }

    /* renamed from: a */
    private void m39066a(int i) {
        this.f54197h.set(i);
    }

    /* renamed from: a */
    private void m39067a(C19879do doVar) {
        this.f54193d.mo162068do(doVar.f54207do, doVar.f61763case, doVar.f61766new);
    }

    /* renamed from: b */
    private double m39070b(C19879do doVar) {
        FaceFeature faceFeature = doVar.f61765for;
        Bitmap bitmap = doVar.f54208if;
        if (faceFeature != null) {
            RectF faceBounds = faceFeature.getFaceBounds();
            float f = faceBounds.left;
            float f2 = faceBounds.top;
            bitmap = C3121for.m4029do(bitmap, (int) f, (int) f2, (int) (faceBounds.right - f), (int) (faceBounds.bottom - f2));
            if (bitmap == null) {
                throw new IllegalStateException("Bitmap can not be null");
            }
        }
        return this.f54191b.mo38625do(bitmap);
    }

    /* renamed from: c */
    private void m39071c(C19879do doVar) {
        try {
            if (doVar.f61763case) {
                m39066a(doVar.f61767try);
            }
            this.f54192c.add(doVar);
            int size = this.f54192c.size();
            if (this.f54203n < size) {
                this.f54203n = size;
            }
            StringBuffer stringBuffer = this.f54205p;
            stringBuffer.append(" ");
            stringBuffer.append(size);
            StringBuilder sb = new StringBuilder();
            sb.append("queue size = ");
            sb.append(size);
        } catch (IllegalStateException unused) {
            IPLog.m39305w(f54190a, "Liveness Blur Detection Queue full");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m39069a(C19880const.C19881do doVar) {
        C19879do doVar2 = null;
        while (this.f54200k) {
            try {
                C19879do poll = this.f54192c.poll(1, TimeUnit.SECONDS);
                if (poll != null) {
                    boolean z = poll.f61767try < this.f54197h.get();
                    if (poll.f61764else == 1) {
                        m39068a(poll, doVar2, z);
                    } else if (!z) {
                        m39072d(poll);
                    }
                    doVar2 = poll;
                }
            } catch (InterruptedException e) {
                doVar.mo162069do(e);
                return;
            } catch (IllegalStateException e2) {
                doVar.mo162069do(e2);
                return;
            }
        }
        this.f54193d = null;
    }

    /* renamed from: d */
    private void m39072d(C19879do doVar) {
        if (this.f54198i == null) {
            this.f54198i = Double.valueOf(m39070b(this.f54199j));
        }
        double b = m39070b(doVar);
        if (b > this.f54198i.doubleValue()) {
            this.f54199j = doVar;
            this.f54198i = Double.valueOf(b);
        }
    }

    /* renamed from: a */
    private void m39068a(C19879do doVar, C19879do doVar2, boolean z) {
        int i;
        if (this.f54199j != null) {
            if (doVar2 == null) {
                i = 0;
            } else {
                i = doVar2.f61764else - 1;
            }
            this.f54204o += i;
            this.f54206q.append(String.format(" %d", new Object[]{Integer.valueOf(i)}));
            m39067a(this.f54199j);
            this.f54199j = null;
        }
        if (z || doVar.f61763case) {
            this.f54206q.append(" 0");
            m39067a(doVar);
            if (doVar.f61763case) {
                String.format("Stats: device %s %s cpus[%d] frames %3d choices[%3d] %s (overrun %.2f)", new Object[]{Build.MANUFACTURER, Build.MODEL, Integer.valueOf(Runtime.getRuntime().availableProcessors()), Integer.valueOf(this.f54201l), Integer.valueOf(this.f54204o), this.f54206q.toString(), Double.valueOf(((double) (System.nanoTime() - this.f54202m)) / 1.0E9d)});
                this.f54200k = false;
                return;
            }
            return;
        }
        this.f54199j = doVar;
        this.f54198i = null;
    }

    /* renamed from: a */
    public C3136do mo162059a(C20821for forR, Bitmap bitmap, FaceFeature faceFeature, RectF rectF, C3136do doVar, int i, int i2) {
        boolean z;
        int i3;
        int i4 = i;
        this.f54201l++;
        int i5 = this.f54196g + 1;
        this.f54196g = i5;
        boolean z2 = i5 > this.f54194e;
        if (i4 != this.f54195f) {
            i3 = i2;
            z = true;
        } else {
            i3 = i2;
            z = false;
        }
        boolean z3 = i4 == i3;
        if (z) {
            this.f54195f = i4;
            this.f54196g = 1;
            if (z3) {
                this.f54202m = System.nanoTime();
            }
            m39071c(new C19879do(forR, bitmap, faceFeature, rectF, doVar, i, z3, this.f54196g));
            if (z3) {
                return C3136do.END_FACE_PATH;
            }
            return C3136do.FACE_PATH;
        } else if (z2) {
            return doVar;
        } else {
            m39071c(new C19879do(forR, bitmap, faceFeature, rectF, doVar, i, z3, i5));
            return C3136do.FACE_PATH;
        }
    }

    /* renamed from: a */
    public void mo162060a() {
        this.f54200k = false;
    }
}
