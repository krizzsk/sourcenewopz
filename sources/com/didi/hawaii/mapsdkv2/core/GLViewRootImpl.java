package com.didi.hawaii.mapsdkv2.core;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.ViewDebug;
import com.didi.hawaii.mapsdkv2.MapHost;
import com.didi.hawaii.mapsdkv2.MapRender;
import com.didi.hawaii.mapsdkv2.core.GLInstrumentation;
import com.didi.hawaii.mapsdkv2.core.RenderHeartbeat;
import com.didi.hawaii.mapsdkv2.view.RenderTask;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

final class GLViewRootImpl implements MapHost.LifeCycleCallback, GLViewManager, GLViewParent {

    /* renamed from: a */
    static final boolean f23938a = false;

    /* renamed from: c */
    private static final String f23939c = "GLViewRootImpl";

    /* renamed from: d */
    private static final int f23940d = 1;

    /* renamed from: e */
    private static final int f23941e = 2;

    /* renamed from: f */
    private static final int f23942f = 10;

    /* renamed from: g */
    private static final int f23943g = 100;

    /* renamed from: A */
    private final Thread f23944A = Thread.currentThread();

    /* renamed from: B */
    private final GLInstrumentation f23945B = new GLInstrumentation() {
        public boolean postToRenderThread(final GLInstrumentation.GLInstrumentationTask gLInstrumentationTask) {
            return GLViewRootImpl.this.postToRenderThread((RenderTask) new RenderTask() {
                public void run() {
                    gLInstrumentationTask.run(GLViewRootImpl.this.f23949j, GLViewRootImpl.this.f23946b);
                }
            });
        }

        public <T> Future<T> postToRenderThread(final GLInstrumentation.GLInstrumentationFutureTask<T> gLInstrumentationFutureTask) {
            return GLViewRootImpl.this.postToRenderThread(new Callable<T>() {
                public T call() throws Exception {
                    return gLInstrumentationFutureTask.call(GLViewRootImpl.this.f23949j, GLViewRootImpl.this.f23946b);
                }
            });
        }
    };

    /* renamed from: b */
    final MapCanvas f23946b;

    /* renamed from: h */
    private MapRender f23947h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final GLBaseMapView f23948i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public final MapEngine f23949j;

    /* renamed from: k */
    private final List<GLView> f23950k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public final SparseArray<GLOverlayView> f23951l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public final SparseArray<GLOverlayView> f23952m;

    /* renamed from: n */
    private final Handler f23953n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public final C9185e f23954o;

    /* renamed from: p */
    private final TouchDispatcher f23955p;

    /* renamed from: q */
    private Thread f23956q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public final RenderHeartbeat f23957r;

    /* renamed from: s */
    private RenderProfile f23958s;

    /* renamed from: t */
    private int f23959t = 100;

    /* renamed from: u */
    private volatile boolean f23960u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public int f23961v = -1;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public int f23962w = -1;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public final List<C9184d> f23963x = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: y */
    public int f23964y;

    /* renamed from: z */
    private int f23965z = 2;

    /* renamed from: c */
    private void m17030c(int i) {
    }

    GLViewRootImpl(MapRender mapRender, GLBaseMapFactory gLBaseMapFactory, GLHttpClient gLHttpClient) {
        C9185e a = C9185e.m17084a(mapRender.getContext(), gLHttpClient);
        this.f23954o = a;
        this.f23947h = mapRender;
        if (mapRender instanceof MapHostView) {
            a.f24019a = ((MapHostView) mapRender).mEGLContextFactory;
        }
        C9186f fVar = new C9186f();
        this.f23949j = fVar;
        this.f23946b = fVar;
        this.f23953n = new Handler(Looper.getMainLooper());
        GLBaseMapView newGLBaseMapView = gLBaseMapFactory.newGLBaseMapView(this);
        this.f23948i = newGLBaseMapView;
        this.f23954o.f24020b = newGLBaseMapView.f23885f;
        this.f23948i.mo69782a(this.f23949j);
        this.f23950k = new ArrayList(10);
        this.f23951l = new SparseArray<>();
        this.f23952m = new SparseArray<>();
        this.f23955p = new TouchDispatcher(this, this.f23949j);
        this.f23957r = new RenderHeartbeat(new RenderHeartbeat.RenderListener() {
            public void invokeRequestRender() {
                GLViewRootImpl.this.m17029c();
            }
        });
        this.f23964y = 1;
        this.f23948i.mo69783a((OnBaseMapCreateCallback) new OnBaseMapCreateCallback() {
            public void onCreate() {
                GLViewRootImpl.this.f23957r.mo70581a(GLViewRootImpl.this.f23964y);
            }
        });
        this.f23960u = true;
        SetTransaction setTransaction = new SetTransaction((Runnable) null, this);
        setTransaction.chain(new Runnable() {
            public void run() {
                GLViewRootImpl.this.f23954o.getResources().mo70589a(GLViewRootImpl.this.f23949j.checkNeedGuard(GLViewRootImpl.this.f23954o.getResources().getPrefs().getMapGuardPath()));
            }
        });
        m17026a((GLView) this.f23948i, setTransaction);
        GLLocator gLLocator = new GLLocator(this, this.f23949j);
        m17026a((GLView) gLLocator, setTransaction);
        setTransaction.commit();
        this.f23948i.mo69781a(gLLocator);
    }

    /* renamed from: a */
    public void mo70269a(OnBaseMapCreateCallback onBaseMapCreateCallback) {
        if (this.f23960u) {
            this.f23948i.mo69790b(onBaseMapCreateCallback);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m17029c() {
        if (this.f23947h != null && this.f23960u) {
            this.f23947h.requestRender();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo70270a() {
        if (this.f23958s != null) {
            long uptimeMillis = SystemClock.uptimeMillis();
            boolean renderFrame = this.f23949j.renderFrame();
            long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
            long uptimeMillis3 = SystemClock.uptimeMillis();
            m17025a(renderFrame);
            m17024a(SystemClock.uptimeMillis() - uptimeMillis, uptimeMillis2, SystemClock.uptimeMillis() - uptimeMillis3);
            return renderFrame;
        }
        boolean renderFrame2 = this.f23949j.renderFrame();
        m17025a(renderFrame2);
        return renderFrame2;
    }

    /* renamed from: a */
    private void m17024a(long j, long j2, long j3) {
        RenderProfile renderProfile = this.f23958s;
        if (renderProfile != null) {
            renderProfile.onFrame(j, j2, j3);
            if (j > ((long) this.f23959t)) {
                this.f23958s.onSlowRender(j, j2, j3);
            }
        }
    }

    public boolean addView(GLOverlayView gLOverlayView) {
        SetTransaction setTransaction = new SetTransaction((Runnable) null, this);
        return m17026a((GLView) gLOverlayView, setTransaction) && setTransaction.commit();
    }

    public int addView(GLOverlayView... gLOverlayViewArr) {
        SetTransaction setTransaction = new SetTransaction((Runnable) null, this);
        int i = 0;
        for (GLOverlayView gLOverlayView : gLOverlayViewArr) {
            if (gLOverlayView != null && m17026a((GLView) gLOverlayView, setTransaction)) {
                i++;
            }
        }
        if (i <= 0 || !setTransaction.commit()) {
            return 0;
        }
        return i;
    }

    /* renamed from: a */
    private boolean m17026a(final GLView gLView, SetTransaction setTransaction) {
        final GLOverlayView gLOverlayView;
        if (!this.f23960u) {
            return false;
        }
        m17030c(2);
        if (gLView.mParent != null) {
            return false;
        }
        synchronized (this.f23950k) {
            if ((gLView instanceof GLOverlayView) && ((GLOverlayView) gLView).mSingleInstance) {
                Iterator<GLView> it = this.f23950k.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        gLOverlayView = null;
                        break;
                    }
                    GLView next = it.next();
                    if (next.getClass().equals(gLView.getClass()) && next.mParent != null) {
                        gLOverlayView = (GLOverlayView) next;
                        it.remove();
                        break;
                    }
                }
                if (!(gLOverlayView == null || gLOverlayView.mParent == null)) {
                    gLOverlayView.mParent = null;
                    setTransaction.chain(new Runnable() {
                        public void run() {
                            synchronized (GLViewRootImpl.this.f23951l) {
                                GLViewRootImpl.this.f23951l.remove(gLOverlayView.mDisplayId);
                            }
                            if (gLOverlayView.mBubbleId > 0) {
                                synchronized (GLViewRootImpl.this.f23952m) {
                                    GLViewRootImpl.this.f23952m.remove(gLOverlayView.mBubbleId);
                                }
                            }
                            gLOverlayView.performRemove();
                        }
                    });
                }
            }
            if (!this.f23950k.contains(gLView)) {
                this.f23950k.add(gLView);
            }
        }
        if (gLView.mParent != null) {
            return false;
        }
        gLView.mParent = this;
        int i = this.f23962w;
        if (i != -1) {
            gLView.onHostSizeChanged(this.f23961v, i);
        }
        setTransaction.chain(new Runnable() {
            public void run() {
                gLView.performAdd();
                GLView gLView = gLView;
                if (gLView instanceof GLOverlayView) {
                    GLOverlayView gLOverlayView = (GLOverlayView) gLView;
                    if (gLOverlayView.mBubbleId > 0) {
                        synchronized (GLViewRootImpl.this.f23952m) {
                            GLViewRootImpl.this.f23952m.append(gLOverlayView.mBubbleId, gLOverlayView);
                        }
                    }
                    if (gLOverlayView.mDisplayId >= 0) {
                        synchronized (GLViewRootImpl.this.f23951l) {
                            GLViewRootImpl.this.f23951l.append(gLOverlayView.mDisplayId, gLOverlayView);
                        }
                    }
                }
            }
        });
        return true;
    }

    public boolean removeView(final GLOverlayView gLOverlayView) {
        boolean remove;
        m17030c(2);
        if (!this.f23960u) {
            return false;
        }
        synchronized (this.f23950k) {
            remove = this.f23950k.remove(gLOverlayView);
        }
        if (!remove || gLOverlayView.mParent == null) {
            return false;
        }
        gLOverlayView.mParent = null;
        return postToRenderThread((RenderTask) new RenderTask() {
            public void run() {
                synchronized (GLViewRootImpl.this.f23951l) {
                    GLViewRootImpl.this.f23951l.remove(gLOverlayView.mDisplayId);
                }
                if (gLOverlayView.mBubbleId > 0) {
                    synchronized (GLViewRootImpl.this.f23952m) {
                        GLViewRootImpl.this.f23952m.remove(gLOverlayView.mBubbleId);
                    }
                }
                gLOverlayView.performRemove();
            }
        });
    }

    public GLOverlayView findViewById(String str) {
        m17030c(2);
        if (!this.f23960u) {
            return null;
        }
        synchronized (this.f23950k) {
            for (GLView next : this.f23950k) {
                if (next.mParent != null) {
                    if (next.mID.equals(str) && (next instanceof GLOverlayView)) {
                        GLOverlayView gLOverlayView = (GLOverlayView) next;
                        return gLOverlayView;
                    }
                }
            }
            return null;
        }
    }

    public void insertCollisionDisPlayId(int i, GLOverlayView gLOverlayView) {
        m17030c(1);
        if (this.f23960u) {
            synchronized (this.f23951l) {
                this.f23951l.append(i, gLOverlayView);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public GLOverlayView mo70267a(int i) {
        GLOverlayView gLOverlayView;
        m17030c(2);
        if (!this.f23960u) {
            return null;
        }
        synchronized (this.f23951l) {
            gLOverlayView = this.f23951l.get(i);
        }
        return gLOverlayView;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo70268a(int i, GLOverlayView gLOverlayView) {
        m17030c(1);
        if (this.f23960u) {
            synchronized (this.f23951l) {
                this.f23951l.append(i, gLOverlayView);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public GLOverlayView mo70272b(int i) {
        GLOverlayView gLOverlayView;
        m17030c(2);
        if (!this.f23960u) {
            return null;
        }
        synchronized (this.f23952m) {
            gLOverlayView = this.f23952m.get(i);
        }
        return gLOverlayView;
    }

    @ViewDebug.ExportedProperty(deepExport = true)
    public GLBaseMapView getBaseMap() {
        return this.f23948i;
    }

    public MapContext getMapContext() {
        m17030c(3);
        return this.f23954o;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m17032d() {
        synchronized (this.f23950k) {
            for (GLView next : this.f23950k) {
                if (next instanceof GLOverlayView) {
                    ((GLOverlayView) next).mDisplayId = -2;
                } else if (next instanceof GLBaseMapView) {
                }
                next.performRemove();
            }
            this.f23950k.clear();
            this.f23948i.performRemove();
        }
    }

    public Handler getMainHandler() {
        return this.f23953n;
    }

    public boolean postToRenderThread(RenderTask renderTask) {
        MapRender mapRender;
        if (!this.f23960u || (mapRender = this.f23947h) == null) {
            return false;
        }
        mapRender.queueRenderEvent(renderTask);
        return true;
    }

    public <T> Future<T> postToRenderThread(Callable<T> callable) {
        if (!this.f23960u || this.f23947h == null) {
            return null;
        }
        FutureTask futureTask = new FutureTask(callable);
        this.f23947h.queueEvent(futureTask);
        return futureTask;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo70271a(MotionEvent motionEvent) {
        return this.f23955p.mo70609a(motionEvent);
    }

    public void onHostCreated() {
        this.f23956q = Thread.currentThread();
        this.f23948i.mo69777a();
    }

    public void onHostDestroy() {
        this.f23948i.mo69788b();
    }

    public void onHostDetached() {
        m17030c(2);
        synchronized (this.f23950k) {
            for (GLView gLView : this.f23950k) {
                gLView.mParent = null;
            }
        }
        this.f23960u = false;
        new CleanUpThread(this).start();
    }

    public void addFrameCallback(final C9184d dVar) {
        if (this.f23960u) {
            postToRenderThread((RenderTask) new RenderTask() {
                public void run() {
                    GLViewRootImpl.this.f23963x.add(dVar);
                }
            });
        }
    }

    public void removeFrameCallback(final C9184d dVar) {
        postToRenderThread((RenderTask) new RenderTask() {
            public void run() {
                GLViewRootImpl.this.f23963x.remove(dVar);
            }
        });
    }

    public void setFps(int i) {
        int i2;
        if (this.f23960u && (i2 = this.f23965z) != 1 && i2 != 3 && this.f23964y != i) {
            this.f23964y = i;
            this.f23957r.mo70584c(i);
        }
    }

    public void setFpsMode(int i) {
        this.f23965z = i;
    }

    public int getFps() {
        return this.f23964y;
    }

    public GLInstrumentation getGLInstrumentation() {
        return this.f23945B;
    }

    public Future<Bitmap> screenShots() {
        return postToRenderThread(new Callable<Bitmap>() {
            public Bitmap call() throws Exception {
                return GLViewRootImpl.this.f23949j.screenShot(GLViewRootImpl.this.f23961v, GLViewRootImpl.this.f23962w, Bitmap.Config.ARGB_8888);
            }
        });
    }

    public Future<File> dumpInspectInfo(final File file) {
        return postToRenderThread(new Callable<File>() {
            public File call() throws Exception {
                try {
                    return GLViewDebug.m17011a(GLViewRootImpl.this, GLViewRootImpl.this.f23949j.screenShot(GLViewRootImpl.this.f23961v, GLViewRootImpl.this.f23962w, Bitmap.Config.ARGB_8888), file);
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        });
    }

    /* renamed from: a */
    private void m17025a(boolean z) {
        if (!this.f23963x.isEmpty()) {
            for (C9184d onFrameFinish : this.f23963x) {
                onFrameFinish.onFrameFinish(z);
            }
        }
    }

    public void setRenderProfile(RenderProfile renderProfile) {
        if (this.f23960u) {
            this.f23958s = renderProfile;
            int slowRenderInterval = renderProfile.getSlowRenderInterval();
            if (slowRenderInterval > 0) {
                this.f23959t = slowRenderInterval;
            }
        }
    }

    public void onHostResume() {
        this.f23957r.mo70583b(this.f23964y);
        this.f23948i.mo69801d();
    }

    public void onHostPause() {
        this.f23948i.mo69805e();
        this.f23957r.mo70580a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public GLView[] mo70273b() {
        GLView[] gLViewArr;
        synchronized (this.f23950k) {
            gLViewArr = (GLView[]) this.f23950k.toArray(new GLView[this.f23950k.size()]);
        }
        return gLViewArr;
    }

    public void onHostSizeChanged(int i, int i2) {
        GLView[] gLViewArr;
        this.f23961v = i;
        this.f23962w = i2;
        synchronized (this.f23950k) {
            gLViewArr = (GLView[]) this.f23950k.toArray(new GLView[this.f23950k.size()]);
        }
        for (GLView onHostSizeChanged : gLViewArr) {
            onHostSizeChanged.onHostSizeChanged(i, i2);
        }
    }

    private static class CleanUpThread extends Thread {
        /* access modifiers changed from: private */
        public final GLViewRootImpl glViewRoot;

        CleanUpThread(GLViewRootImpl gLViewRootImpl) {
            super("GLViewCleanUp");
            this.glViewRoot = gLViewRootImpl;
            gLViewRootImpl.f23957r.mo70580a();
        }

        public void run() {
            this.glViewRoot.f23957r.mo70582b();
            if (C9188h.m17100a()) {
                this.glViewRoot.f23948i.mo69784a((Runnable) new Runnable() {
                    public void run() {
                        CleanUpThread.this.glViewRoot.f23949j.setRenderThread(Thread.currentThread());
                        CleanUpThread.this.glViewRoot.m17032d();
                    }
                });
                return;
            }
            this.glViewRoot.f23949j.setRenderThread(this);
            this.glViewRoot.f23948i.mo69784a((Runnable) null);
            this.glViewRoot.m17032d();
        }
    }
}
