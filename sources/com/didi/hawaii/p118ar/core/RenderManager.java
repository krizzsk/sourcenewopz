package com.didi.hawaii.p118ar.core;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.didi.hawaii.p118ar.core.modle.ARCoreSession;
import com.didi.hawaii.p118ar.core.render.BackgroundRenderer;
import com.didi.hawaii.p118ar.jni.DARCLocationInScene;
import com.didi.hawaii.p118ar.jni.DARCNAVStatus;
import com.didi.hawaii.p118ar.jni.DARCNAVUpdateData;
import com.didi.hawaii.p118ar.utils.DisplayRotationHelper;
import com.didichuxing.hawaii.arsdk.darcore.OSImage;
import com.google.p217ar.core.Camera;
import com.google.p217ar.core.Frame;
import com.google.p217ar.core.TrackingState;
import com.google.p217ar.core.exceptions.CameraNotAvailableException;
import com.google.p217ar.core.exceptions.UnavailableApkTooOldException;
import com.google.p217ar.core.exceptions.UnavailableArcoreNotInstalledException;
import com.google.p217ar.core.exceptions.UnavailableDeviceNotCompatibleException;
import com.google.p217ar.core.exceptions.UnavailableSdkTooOldException;
import java.io.IOException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.didi.hawaii.ar.core.RenderManager */
public class RenderManager extends BaseDelegate {

    /* renamed from: a */
    private static final String f23027a = RenderManager.class.getSimpleName();

    /* renamed from: i */
    private static final long f23028i = 333;

    /* renamed from: j */
    private static final long f23029j = 24;

    /* renamed from: b */
    private ARCoreSession f23030b = null;

    /* renamed from: c */
    private final BackgroundRenderer f23031c = new BackgroundRenderer();

    /* renamed from: d */
    private DisplayRotationHelper f23032d;

    /* renamed from: e */
    private long f23033e = 0;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public long f23034f = 0;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f23035g = false;

    /* renamed from: h */
    private OSImage f23036h = null;

    /* renamed from: k */
    private boolean f23037k = false;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public Lock f23038l = new ReentrantLock();
    /* access modifiers changed from: private */

    /* renamed from: m */
    public volatile boolean f23039m = true;

    /* renamed from: n */
    private Context f23040n;

    /* renamed from: o */
    private Handler f23041o = new Handler(Looper.getMainLooper());

    public RenderManager(Context context, DiAREngine diAREngine) {
        this.f23040n = context;
        attachEngine(diAREngine);
        try {
            this.f23030b = new ARCoreSession(context);
        } catch (UnavailableSdkTooOldException e) {
            e.printStackTrace();
        } catch (UnavailableDeviceNotCompatibleException e2) {
            e2.printStackTrace();
        } catch (UnavailableArcoreNotInstalledException e3) {
            e3.printStackTrace();
        } catch (UnavailableApkTooOldException e4) {
            e4.printStackTrace();
        }
        this.f23032d = new DisplayRotationHelper(context);
    }

    public void createRender(Context context) {
        try {
            this.f23031c.createOnGlThread(context);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onSizeChange(int i, int i2) {
        this.f23032d.onSurfaceChanged(i, i2);
    }

    public void start() {
        this.f23037k = true;
    }

    public void drawRender(int[] iArr, DARCNAVStatus dARCNAVStatus) {
        boolean z;
        Lock lock;
        OSImage acquireCameraOSImage;
        ARCoreSession aRCoreSession = this.f23030b;
        if (aRCoreSession != null) {
            try {
                this.f23032d.updateSessionIfNeeded(aRCoreSession);
                this.f23030b.setCameraTextureName(this.f23031c.getTextureId());
                DARCLocationInScene dARCLocationInScene = new DARCLocationInScene();
                m16570a(dARCLocationInScene);
                Frame update = this.f23030b.update(iArr, dARCLocationInScene, dARCNAVStatus);
                Camera camera = update.getCamera();
                this.f23031c.draw(update);
                camera.getTrackingState();
                TrackingState trackingState = TrackingState.TRACKING;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f23033e <= f23028i || (acquireCameraOSImage = this.f23030b.acquireCameraOSImage()) == null) {
                    z = false;
                } else {
                    this.f23036h = acquireCameraOSImage;
                    z = true;
                    this.f23033e = currentTimeMillis;
                }
                if (this.f23038l.tryLock()) {
                    if (this.f23039m && currentTimeMillis - this.f23034f >= f23029j) {
                        final DARCNAVUpdateData updateData = this.f23030b.getUpdateData(this.f23036h, z);
                        this.f23039m = false;
                        this.f23041o.post(new Runnable() {
                            public void run() {
                                RenderManager.this.m16571a(updateData);
                                RenderManager.this.m16576c();
                                long unused = RenderManager.this.f23034f = System.currentTimeMillis();
                                RenderManager.this.f23038l.lock();
                                boolean unused2 = RenderManager.this.f23039m = true;
                                RenderManager.this.f23038l.unlock();
                            }
                        });
                    }
                    lock = this.f23038l;
                    lock.unlock();
                }
            } catch (Exception unused) {
                lock = this.f23038l;
            } catch (CameraNotAvailableException e) {
                e.printStackTrace();
            } catch (Throwable unused2) {
            }
        }
    }

    /* renamed from: a */
    private void m16567a() {
        this.f23041o.post(new Runnable() {
            public void run() {
                if (RenderManager.this.mAREngine != null) {
                    boolean unused = RenderManager.this.f23035g = true;
                    RenderManager.this.mAREngine.errorAppear();
                }
            }
        });
    }

    /* renamed from: b */
    private void m16574b() {
        this.f23041o.post(new Runnable() {
            public void run() {
                if (RenderManager.this.mAREngine != null && RenderManager.this.f23035g) {
                    RenderManager.this.mAREngine.errorDisappear();
                    boolean unused = RenderManager.this.f23035g = false;
                }
            }
        });
    }

    public void resume() {
        try {
            if (this.f23030b == null) {
                try {
                    this.f23030b = new ARCoreSession(this.f23040n);
                } catch (UnavailableSdkTooOldException e) {
                    e.printStackTrace();
                } catch (UnavailableDeviceNotCompatibleException e2) {
                    e2.printStackTrace();
                } catch (UnavailableArcoreNotInstalledException e3) {
                    e3.printStackTrace();
                } catch (UnavailableApkTooOldException e4) {
                    e4.printStackTrace();
                }
            }
            if (this.f23030b != null) {
                this.f23030b.resume();
                this.f23032d.onResume();
            }
        } catch (CameraNotAvailableException e5) {
            e5.printStackTrace();
        }
    }

    public void pause() {
        if (this.f23030b != null) {
            this.f23032d.onPause();
            this.f23030b.pause();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m16576c() {
        if (this.mAREngine != null) {
            this.mAREngine.renderUpdate();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m16571a(DARCNAVUpdateData dARCNAVUpdateData) {
        if (this.mAREngine != null) {
            this.mAREngine.update(dARCNAVUpdateData);
        }
    }

    /* renamed from: a */
    private void m16570a(DARCLocationInScene dARCLocationInScene) {
        if (this.mAREngine != null) {
            this.mAREngine.currentLocation(dARCLocationInScene);
        }
    }

    public void updateNavHintData() {
        ARCoreSession aRCoreSession = this.f23030b;
        if (aRCoreSession != null) {
            aRCoreSession.updateNavHintData();
        }
    }

    public void release() {
        this.f23030b = null;
    }
}
