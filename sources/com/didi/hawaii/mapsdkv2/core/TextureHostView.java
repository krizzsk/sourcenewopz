package com.didi.hawaii.mapsdkv2.core;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewDebug;
import com.didi.flutter.nacho2.p115v2.NachoLifecycleManager;
import com.didi.hawaii.log.HWLog;
import com.didi.hawaii.mapsdkv2.MapHost;
import com.didi.hawaii.mapsdkv2.MapRender;
import com.didi.hawaii.mapsdkv2.view.DMapTextureView;
import com.didi.map.core.SurfaceChangeListener;
import com.didi.map.outer.map.MapOptions;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.opengles.GL10;

public abstract class TextureHostView extends DMapTextureView implements MapHost, MapRender, DMapTextureView.Renderer {
    private static final String TAG = "MapHostView";
    private MapHost.LifeCycleCallback lifeCycleCallback;
    final DefaultEGLContextFactory mEGLContextFactory = new DefaultEGLContextFactory();
    private final GLViewRootImpl mGlViewRootImpl;
    /* access modifiers changed from: private */
    public SurfaceChangeListener surfaceChangeListener;

    /* access modifiers changed from: protected */
    public abstract GLBaseMapFactory generateBaseMapFactory(MapOptions mapOptions);

    /* access modifiers changed from: protected */
    public abstract GLHttpClient getHttpClient();

    public TextureHostView(Context context) {
        super(context);
        GLBaseMapFactory generateBaseMapFactory = generateBaseMapFactory(MapOptions.createDefaultOptions());
        initOpenGLEnvironment();
        GLViewRootImpl gLViewRootImpl = new GLViewRootImpl(this, generateBaseMapFactory, getHttpClient());
        this.mGlViewRootImpl = gLViewRootImpl;
        setLifeCycleCallback(gLViewRootImpl);
    }

    public TextureHostView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        GLBaseMapFactory generateBaseMapFactory = generateBaseMapFactory(MapOptions.createDefaultOptions());
        initOpenGLEnvironment();
        GLViewRootImpl gLViewRootImpl = new GLViewRootImpl(this, generateBaseMapFactory, getHttpClient());
        this.mGlViewRootImpl = gLViewRootImpl;
        setLifeCycleCallback(gLViewRootImpl);
    }

    public TextureHostView(Context context, MapOptions mapOptions) {
        super(context);
        GLBaseMapFactory generateBaseMapFactory = generateBaseMapFactory(mapOptions);
        initOpenGLEnvironment(mapOptions.isBetterDisplay());
        GLViewRootImpl gLViewRootImpl = new GLViewRootImpl(this, generateBaseMapFactory, getHttpClient());
        this.mGlViewRootImpl = gLViewRootImpl;
        setLifeCycleCallback(gLViewRootImpl);
    }

    public void setOnBaseMapCreatedCallback(OnBaseMapCreateCallback onBaseMapCreateCallback) {
        this.mGlViewRootImpl.mo70269a(onBaseMapCreateCallback);
    }

    public void setRenderProfile(RenderProfile renderProfile) {
        this.mGlViewRootImpl.setRenderProfile(renderProfile);
    }

    private void initOpenGLEnvironment() {
        setEGLContextClientVersion(2);
        setPreserveEGLContextOnPause(true);
        setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        setEGLContextFactory(this.mEGLContextFactory);
        setRenderer(this);
        setRenderMode(0);
    }

    private void initOpenGLEnvironment(boolean z) {
        setEGLContextClientVersion(2);
        setPreserveEGLContextOnPause(true);
        setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        HWLog.m16761i(TAG, "isBetterDisplay:" + z);
        setEGLContextFactory(this.mEGLContextFactory);
        setRenderer(this);
        setRenderMode(0);
    }

    public void onDestroy() {
        HWLog.m16761i(TAG, NachoLifecycleManager.LIFECYCLE_ON_DESTROY);
        super.onPause();
        notifyDetached();
        notifyDestroyed();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        super.onResume();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        HWLog.m16761i(TAG, "onDetachedFromWindow");
        super.onDetachedFromWindow();
    }

    public void onResume() {
        HWLog.m16761i(TAG, "onResume");
        notifyResumed();
    }

    public void onPause() {
        HWLog.m16761i(TAG, "onPause");
        notifyPaused();
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        return this.mGlViewRootImpl.mo70271a(motionEvent);
    }

    @ViewDebug.ExportedProperty(deepExport = true)
    public final GLViewManager getGLViewManage() {
        return this.mGlViewRootImpl;
    }

    public void setLifeCycleCallback(MapHost.LifeCycleCallback lifeCycleCallback2) {
        this.lifeCycleCallback = lifeCycleCallback2;
    }

    private void notifySurfaceCreated() {
        MapHost.LifeCycleCallback lifeCycleCallback2 = this.lifeCycleCallback;
        if (lifeCycleCallback2 != null) {
            lifeCycleCallback2.onHostCreated();
        }
    }

    private void notifySurfaceChanged(int i, int i2) {
        MapHost.LifeCycleCallback lifeCycleCallback2 = this.lifeCycleCallback;
        if (lifeCycleCallback2 != null) {
            lifeCycleCallback2.onHostSizeChanged(i, i2);
        }
        this.mGlViewRootImpl.getMainHandler().post(new Runnable() {
            public void run() {
                if (TextureHostView.this.surfaceChangeListener != null) {
                    TextureHostView.this.surfaceChangeListener.onSurfaceChange();
                }
            }
        });
    }

    private void notifyResumed() {
        MapHost.LifeCycleCallback lifeCycleCallback2 = this.lifeCycleCallback;
        if (lifeCycleCallback2 != null) {
            lifeCycleCallback2.onHostResume();
        }
    }

    private void notifyPaused() {
        MapHost.LifeCycleCallback lifeCycleCallback2 = this.lifeCycleCallback;
        if (lifeCycleCallback2 != null) {
            lifeCycleCallback2.onHostPause();
        }
    }

    private void notifyDestroyed() {
        MapHost.LifeCycleCallback lifeCycleCallback2 = this.lifeCycleCallback;
        if (lifeCycleCallback2 != null) {
            lifeCycleCallback2.onHostDestroy();
        }
    }

    private void notifyDetached() {
        MapHost.LifeCycleCallback lifeCycleCallback2 = this.lifeCycleCallback;
        if (lifeCycleCallback2 != null) {
            lifeCycleCallback2.onHostDetached();
        }
    }

    public final void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        notifySurfaceCreated();
    }

    public final void onSurfaceChanged(GL10 gl10, int i, int i2) {
        notifySurfaceChanged(i, i2);
    }

    public final boolean onDrawFrame(GL10 gl10) {
        return this.mGlViewRootImpl.mo70270a();
    }

    public void requestRender() {
        super.requestRender();
    }

    public void setSurfaceChangeListener(SurfaceChangeListener surfaceChangeListener2) {
        this.surfaceChangeListener = surfaceChangeListener2;
    }

    static final class DefaultEGLContextFactory implements DMapTextureView.EGLContextFactory {
        DefaultEGLContextFactory() {
        }

        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
        }

        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            egl10.eglDestroyContext(eGLDisplay, eGLContext);
        }
    }
}
