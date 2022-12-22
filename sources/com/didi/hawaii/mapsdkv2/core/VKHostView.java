package com.didi.hawaii.mapsdkv2.core;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewDebug;
import com.didi.flutter.nacho2.p115v2.NachoLifecycleManager;
import com.didi.hawaii.mapsdkv2.MapHost;
import com.didi.hawaii.mapsdkv2.MapRender;
import com.didi.hawaii.mapsdkv2.common.MapLog;
import com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView;
import com.didi.map.core.SurfaceChangeListener;
import com.didi.map.outer.map.MapOptions;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public abstract class VKHostView extends VulkanSurfaceView implements MapHost, MapRender, VulkanSurfaceView.Renderer {
    private static final String TAG = "VKHostView";
    private MapHost.LifeCycleCallback lifeCycleCallback;
    private final GLViewRootImpl mGlViewRootImpl;
    /* access modifiers changed from: private */
    public SurfaceChangeListener surfaceChangeListener;

    /* access modifiers changed from: protected */
    public abstract GLBaseMapFactory generateBaseMapFactory(MapOptions mapOptions);

    /* access modifiers changed from: protected */
    public abstract GLHttpClient getHttpClient();

    public VKHostView(Context context) {
        super(context);
        GLBaseMapFactory generateBaseMapFactory = generateBaseMapFactory(MapOptions.createDefaultOptions());
        initVulkanEnvironment();
        GLViewRootImpl gLViewRootImpl = new GLViewRootImpl(this, generateBaseMapFactory, getHttpClient());
        this.mGlViewRootImpl = gLViewRootImpl;
        setLifeCycleCallback(gLViewRootImpl);
    }

    public VKHostView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        GLBaseMapFactory generateBaseMapFactory = generateBaseMapFactory(MapOptions.createDefaultOptions());
        initVulkanEnvironment();
        GLViewRootImpl gLViewRootImpl = new GLViewRootImpl(this, generateBaseMapFactory, getHttpClient());
        this.mGlViewRootImpl = gLViewRootImpl;
        setLifeCycleCallback(gLViewRootImpl);
    }

    public VKHostView(Context context, MapOptions mapOptions) {
        super(context);
        GLBaseMapFactory generateBaseMapFactory = generateBaseMapFactory(mapOptions);
        initVulkanEnvironment();
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

    private void initVulkanEnvironment() {
        setRenderer(this);
        setRenderMode(0);
    }

    public void onDestroy() {
        MapLog.m16914d(TAG, NachoLifecycleManager.LIFECYCLE_ON_DESTROY);
        notifyDestroyed();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        MapLog.m16914d(TAG, "onDetachedFromWindow");
        super.onDetachedFromWindow();
        notifyDetached();
    }

    public void onResume() {
        MapLog.m16914d(TAG, "onResume");
        super.onResume();
        notifyResumed();
    }

    public void onPause() {
        MapLog.m16914d(TAG, "onPause");
        super.onPause();
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
                if (VKHostView.this.surfaceChangeListener != null) {
                    VKHostView.this.surfaceChangeListener.onSurfaceChange();
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

    public void queueEvent(Runnable runnable) {
        super.queueEvent(runnable);
    }

    public void setSurfaceChangeListener(SurfaceChangeListener surfaceChangeListener2) {
        this.surfaceChangeListener = surfaceChangeListener2;
    }
}
