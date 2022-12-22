package com.iproov.sdk.graphics.iproov;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import com.iproov.sdk.IProov;
import com.iproov.sdk.cameray.C19792try;
import com.iproov.sdk.cameray.Orientation;
import com.iproov.sdk.core.C19898import;
import com.iproov.sdk.core.C19909while;
import com.iproov.sdk.graphics.iproov.C19920do;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import p057class.C1281break;
import p057class.C1288for;
import p057class.C1291new;
import p057class.C1292this;
import p057class.C1293try;
import p093switch.C3116else;
import p093switch.C3127throw;
import p094this.C3131do;
import p094this.C3133if;
import p227const.C20725for;
import p227const.C20726if;
import p227const.C20727new;
import p232do.C20817break;
import p238goto.C20993if;

public class OpenGLRenderer extends GLSurfaceView implements GLSurfaceView.Renderer {

    /* renamed from: a */
    private Context f54359a;

    /* renamed from: b */
    private C19792try f54360b;

    /* renamed from: c */
    private IProov.Options.C19751UI f54361c;

    /* renamed from: d */
    private C20993if f54362d;

    /* renamed from: e */
    private final C20727new f54363e = new C20727new();

    /* renamed from: f */
    private C1293try f54364f;

    /* renamed from: g */
    private C1281break f54365g;

    /* renamed from: h */
    private C1291new f54366h;

    /* renamed from: i */
    private C1292this f54367i;

    /* renamed from: j */
    private C1288for f54368j;

    /* renamed from: k */
    private boolean f54369k;

    /* renamed from: l */
    private boolean f54370l;

    /* renamed from: m */
    private SurfaceTexture f54371m;

    /* renamed from: n */
    private int f54372n;

    /* renamed from: o */
    private volatile boolean f54373o;

    /* renamed from: p */
    private int f54374p = 0;

    /* renamed from: q */
    private int f54375q = 0;

    /* renamed from: r */
    private final C20726if f54376r = new C20726if();

    /* renamed from: s */
    private boolean f54377s = false;

    /* renamed from: t */
    private C19919do f54378t;

    /* renamed from: com.iproov.sdk.graphics.iproov.OpenGLRenderer$do */
    public interface C19919do {
        /* renamed from: do */
        void mo161963do();
    }

    public OpenGLRenderer(Context context) {
        super(context);
        m39286a(context);
    }

    /* renamed from: a */
    private void m39285a() {
        queueEvent(new Runnable() {
            public final void run() {
                OpenGLRenderer.this.m39293g();
            }
        });
    }

    /* renamed from: a */
    private void m39286a(Context context) {
        this.f54359a = context;
        setEGLContextClientVersion(2);
        setPreserveEGLContextOnPause(true);
        setRenderer(this);
        setRenderMode(0);
    }

    /* renamed from: b */
    private void m39288b() {
        C1293try c = m39289c();
        this.f54364f = c;
        c.m46208new();
    }

    /* renamed from: c */
    private C1293try m39289c() {
        C1293try tryR = new C1293try(C3116else.m4027do(this.f54363e.mo169182if()));
        DisplayMetrics displayMetrics = this.f54359a.getResources().getDisplayMetrics();
        C19920do doVar = new C19920do(new C20817break(displayMetrics.widthPixels, displayMetrics.heightPixels), this.f54361c);
        tryR.mo14164do(doVar.mo162162do(C19920do.C19922if.CROP));
        tryR.mo14164do(doVar.mo162162do(C19920do.C19922if.LUMINANCE));
        tryR.mo14164do(doVar.mo162162do(C19920do.C19922if.HORIZONTAL_BLUR));
        tryR.mo14164do(doVar.mo162162do(C19920do.C19922if.VERTICAL_BLUR));
        tryR.mo14164do(doVar.mo162162do(C19920do.C19922if.SOBEL));
        tryR.mo14164do(doVar.mo162162do(C19920do.C19922if.SUPRESSION));
        tryR.mo14164do(doVar.mo162162do(C19920do.C19922if.INCLUSION));
        C1281break breakR = (C1281break) doVar.mo162162do(C19920do.C19922if.SHADE);
        this.f54365g = breakR;
        tryR.mo14164do(breakR);
        C1288for forR = (C1288for) doVar.mo162162do(C19920do.C19922if.FADE);
        this.f54368j = forR;
        tryR.mo14164do(forR);
        C1291new newR = (C1291new) doVar.mo162162do(C19920do.C19922if.FLASHING);
        this.f54366h = newR;
        tryR.mo14164do(newR);
        C1292this thisR = (C1292this) doVar.mo162162do(C19920do.C19922if.SCANNER);
        this.f54367i = thisR;
        tryR.mo14164do(thisR);
        return tryR;
    }

    /* renamed from: d */
    private void m39290d() {
        this.f54362d = C20725for.m40543do(this.f54360b, this.f54363e.m47609for(), this.f54363e.mo169178do(), this.f54363e.mo169182if());
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public /* synthetic */ void m39291e() {
        SurfaceTexture surfaceTexture = this.f54371m;
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public /* synthetic */ void m39292f() {
        setBackgroundColor(0);
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public /* synthetic */ void m39293g() {
        if (this.f54373o) {
            this.f54374p++;
            requestRender();
        }
    }

    private C20817break getCameraPreviewSizeForCrop() {
        C20817break breakR = this.f54360b.m47474new().mo161911if();
        return !this.f54363e.mo169182if().isPortrait() ? new C20817break(breakR.mo170629do(), breakR.mo170632if()) : breakR;
    }

    /* renamed from: break  reason: not valid java name */
    public void m47543break() {
        float f;
        m39290d();
        C3131do.m4095do(this.f54363e.m47609for(), this.f54363e.mo169178do());
        float f2 = 0.0f;
        if (this.f54361c.orientation.isPortrait()) {
            f = (((float) (this.f54363e.mo169178do() - this.f54362d.f57260if)) / ((float) this.f54363e.mo169178do())) * 0.5f;
        } else {
            f2 = (((float) (this.f54363e.m47609for() - this.f54362d.f57259do)) / ((float) this.f54363e.m47609for())) * 0.5f;
            f = 0.0f;
        }
        this.f54368j.mo14158do(f2, f);
        this.f54377s = true;
    }

    /* renamed from: catch  reason: not valid java name */
    public synchronized void m47544catch() {
        this.f54373o = false;
        this.f54375q = 0;
        this.f54374p = 0;
        C1293try tryR = this.f54364f;
        if (tryR != null) {
            tryR.m46209try();
        }
        C19792try tryR2 = this.f54360b;
        if (tryR2 != null) {
            tryR2.mo161902do((Runnable) new Runnable() {
                public final void run() {
                    OpenGLRenderer.this.m39291e();
                }
            });
        }
    }

    public float getFrameRate() {
        return this.f54376r.mo169173do();
    }

    public String getScreenSizeString() {
        return this.f54363e.m47609for() + " x " + this.f54363e.mo169178do();
    }

    public synchronized void onDrawFrame(GL10 gl10) {
        while (this.f54373o && this.f54375q != this.f54374p) {
            GLES20.glClear(16384);
            this.f54371m.updateTexImage();
            this.f54375q++;
            this.f54364f.mo38640do(this.f54372n, this.f54363e.m47609for(), this.f54363e.mo169178do(), this.f54362d);
            GLES20.glFlush();
            if (!this.f54370l) {
                C3127throw.m4052do((Runnable) new Runnable() {
                    public final void run() {
                        OpenGLRenderer.this.m39292f();
                    }
                });
                this.f54370l = true;
            }
            this.f54376r.m47606for();
        }
    }

    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        this.f54363e.mo169179do(i, i2);
        mo162151do();
    }

    public synchronized void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        this.f54373o = true;
    }

    public void setPermissionsDelegate(C19919do doVar) {
        this.f54378t = doVar;
    }

    /* renamed from: this  reason: not valid java name */
    public void m47545this() {
        if (!this.f54369k) {
            this.f54369k = true;
            this.f54368j.m46133new();
        }
    }

    /* renamed from: do */
    public void mo162154do(C19792try tryR, IProov.Options.C19751UI ui, Orientation orientation) {
        this.f54360b = tryR;
        this.f54361c = ui;
        this.f54363e.mo169180do(orientation);
        m39288b();
        this.f54372n = C3133if.m4105do(36197);
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.f54372n);
        this.f54371m = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() {
            public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
                OpenGLRenderer.this.m39287a(surfaceTexture);
            }
        });
        tryR.mo161900do(this.f54371m);
    }

    public OpenGLRenderer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m39286a(context);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m39287a(SurfaceTexture surfaceTexture) {
        C19909while.m39264do(C19898import.AND4);
        if (this.f54377s) {
            m39285a();
        }
    }

    /* renamed from: do */
    public void mo162152do(int i, float f, long j) {
        this.f54365g.mo14153do(1.0f);
        this.f54367i.mo14162do(f, j);
        this.f54366h.mo14161if(C20725for.m40544do(i));
        this.f54366h.mo14160do(C20725for.m40544do(C20725for.m40545if(i)));
    }

    /* renamed from: do */
    public void mo162151do() {
        this.f54378t.mo161963do();
    }

    /* renamed from: do */
    public void mo162153do(Rect rect) {
        this.f54364f.mo38642do(rect, getCameraPreviewSizeForCrop());
    }
}
