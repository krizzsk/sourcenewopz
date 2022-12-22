package com.didi.beatles.p099im.views.eggs.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.didi.beatles.p099im.api.entity.IMConfig;
import com.didi.beatles.p099im.utils.IMLog;
import com.didi.beatles.p099im.utils.IMWindowUtil;
import com.didi.beatles.p099im.views.eggs.IIMEggsDrop;
import com.didi.beatles.p099im.views.eggs.IIMEggsView;
import com.didi.beatles.p099im.views.eggs.IMEggsDropFactory;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.didi.beatles.im.views.eggs.impl.IMEggsSurfaceView */
public class IMEggsSurfaceView extends SurfaceView implements SurfaceHolder.Callback, IIMEggsView, Runnable {

    /* renamed from: a */
    private static final String f10233a = IMEggsSurfaceView.class.getSimpleName();

    /* renamed from: b */
    private static final int f10234b = 20;

    /* renamed from: c */
    private static final int f10235c = 40;

    /* renamed from: d */
    private int f10236d;

    /* renamed from: e */
    private int f10237e;

    /* renamed from: f */
    private AtomicBoolean f10238f;

    /* renamed from: g */
    private AtomicBoolean f10239g;

    /* renamed from: h */
    private Thread f10240h;

    /* renamed from: i */
    private List<IIMEggsDrop> f10241i;

    /* renamed from: j */
    private IIMEggsView.OnDrawCallback f10242j;

    public IMEggsSurfaceView(Context context) {
        this(context, (AttributeSet) null);
    }

    public IMEggsSurfaceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IMEggsSurfaceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f10236d = 20;
        this.f10237e = 40;
        this.f10238f = new AtomicBoolean(false);
        this.f10239g = new AtomicBoolean(false);
        this.f10241i = new CopyOnWriteArrayList();
        getHolder().setFormat(-2);
        getHolder().setFormat(-3);
        getHolder().addCallback(this);
        if (Build.VERSION.SDK_INT >= 21) {
            setZOrderOnTop(true);
        } else if (Build.VERSION.SDK_INT > 18) {
            setZOrderMediaOverlay(true);
        }
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        IMLog.m6631d(f10233a, "[surfaceCreated]");
        this.f10238f = new AtomicBoolean(true);
        m6973a();
    }

    /* renamed from: a */
    private void m6973a() {
        this.f10239g.set(true);
        if (this.f10240h == null) {
            Thread thread = new Thread(this, "IMEggsSurfaceView");
            this.f10240h = thread;
            thread.start();
        }
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        String str = f10233a;
        IMLog.m6631d(str, "[surfaceChanged] width=" + i2 + " |height=" + i3);
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        IMLog.m6631d(f10233a, "[surfaceDestroyed]");
        m6975b();
        this.f10238f = new AtomicBoolean(false);
        this.f10240h = null;
    }

    /* renamed from: b */
    private void m6975b() {
        this.f10239g.set(false);
        Thread thread = this.f10240h;
        this.f10240h = null;
        try {
            thread.interrupt();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setFrameInterval(int i) {
        this.f10236d = i;
    }

    public void setMaxCount(int i) {
        this.f10237e = i;
    }

    public void displayEggs(IMConfig.EggsInfo eggsInfo, Bitmap bitmap) {
        if (getVisibility() == 0) {
            this.f10241i.clear();
            int min = Math.min(eggsInfo.count, this.f10237e);
            for (int i = 0; i < min; i++) {
                IIMEggsDrop create = IMEggsDropFactory.create(eggsInfo);
                if (create != null) {
                    create.init(bitmap, IMWindowUtil.dip2px((float) eggsInfo.width), IMWindowUtil.dip2px((float) eggsInfo.height));
                    this.f10241i.add(create);
                }
            }
        }
    }

    public void setOnDrawCallback(IIMEggsView.OnDrawCallback onDrawCallback) {
        this.f10242j = onDrawCallback;
    }

    public void reset() {
        if (this.f10242j != null) {
            for (IIMEggsDrop onFinished : this.f10241i) {
                this.f10242j.onFinished(onFinished);
            }
        }
        this.f10241i.clear();
    }

    public void run() {
        Canvas lockCanvas;
        while (this.f10239g.get()) {
            try {
                long uptimeMillis = SystemClock.uptimeMillis();
                if (this.f10238f.get() && getHolder().getSurface().isValid() && (lockCanvas = getHolder().lockCanvas()) != null) {
                    m6974a(lockCanvas);
                    m6976b(lockCanvas);
                    getHolder().unlockCanvasAndPost(lockCanvas);
                }
                long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
                if (uptimeMillis2 - ((long) this.f10236d) < 0) {
                    try {
                        Thread.sleep(((long) this.f10236d) - uptimeMillis2);
                    } catch (InterruptedException e) {
                        IMLog.m6632e(f10233a, "[run]", e);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                reset();
                throw th;
            }
        }
        reset();
    }

    /* renamed from: a */
    private void m6974a(Canvas canvas) {
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
    }

    /* renamed from: b */
    private void m6976b(Canvas canvas) {
        for (IIMEggsDrop next : this.f10241i) {
            next.draw(canvas);
            if (!next.isActive()) {
                this.f10241i.remove(next);
                IIMEggsView.OnDrawCallback onDrawCallback = this.f10242j;
                if (!(onDrawCallback == null || next == null)) {
                    onDrawCallback.onFinished(next);
                }
            }
        }
    }
}
