package com.didi.hawaii.mapsdkv2.core;

import android.animation.Animator;
import android.os.Handler;
import com.didi.hawaii.mapsdkv2.common.MapLog;
import com.didi.hawaii.mapsdkv2.core.MapEngine;
import com.didi.hawaii.mapsdkv2.view.RenderTask;
import com.didi.map.outer.model.LatLng;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import rui.config.RConfigConstants;

public class GLView implements C9184d {
    private static final int CLICKABLE = 2;
    private static final int FUTURE_TIMEOUT_THRESHOLD = 800;
    private static final int LONG_CLICKABLE = 4;
    private static final String TAG = "GLView";
    static final AtomicInteger sIdGenerator = new AtomicInteger(0);
    private static Thread sMainThread = null;
    private boolean mAddToFrameCallback = false;
    protected Animator mCurrentAnimator = null;
    String mID;
    /* access modifiers changed from: protected */
    public GLOverlayLayer mLayer;
    private ListenerInfo mListenerInfo;
    /* access modifiers changed from: protected */
    public final MapCanvas mMapCanvas;
    protected final MapContext mMapContext;
    GLViewParent mParent;
    private Animator mPendingAnimator = null;
    SetTransaction mSetTransaction = null;
    private int mViewFlags = 6;
    protected final GLViewManager mViewManager;
    private final Handler mainHandler;

    public interface OnClickListener {
        boolean onClick(GLView gLView, LatLng latLng, float f, float f2);
    }

    public interface OnLongClickListener {
        boolean onLongClick(GLView gLView);
    }

    public interface Options {
    }

    /* access modifiers changed from: protected */
    public void checkThread() {
    }

    /* access modifiers changed from: protected */
    public void onAdded() {
    }

    public void onFrameFinish(boolean z) {
    }

    /* access modifiers changed from: protected */
    public void onHostSizeChanged(int i, int i2) {
    }

    /* access modifiers changed from: protected */
    public boolean onInterceptGestureEvent(Gesture gesture) {
        return false;
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
    }

    static class ListenerInfo {
        OnClickListener mOnClickListener;
        OnLongClickListener mOnLongClickListener;

        ListenerInfo() {
        }
    }

    public GLView(GLViewManager gLViewManager, GLOverlayLayer gLOverlayLayer) {
        checkThread();
        this.mMapContext = gLViewManager.getMapContext();
        this.mMapCanvas = ((GLViewRootImpl) gLViewManager).f23946b;
        this.mainHandler = gLViewManager.getMainHandler();
        this.mLayer = gLOverlayLayer;
        this.mID = String.valueOf(sIdGenerator.incrementAndGet());
        this.mViewManager = gLViewManager;
    }

    /* access modifiers changed from: package-private */
    public void performAdd() {
        onAdded();
        if (this.mAddToFrameCallback) {
            getMainHandler().post(new Runnable() {
                public void run() {
                    GLView.this.mViewManager.addFrameCallback(GLView.this);
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public void performRemove() {
        getMainHandler().post(new Runnable() {
            public void run() {
                GLView.this.stopAnimation();
                GLView.this.attachToFrame(false);
            }
        });
        onRemove();
    }

    /* access modifiers changed from: protected */
    public final void attachToFrame(boolean z) {
        checkThread();
        if (this.mAddToFrameCallback != z) {
            this.mAddToFrameCallback = z;
            if (!z || !isAdded()) {
                this.mViewManager.removeFrameCallback(this);
            } else {
                this.mViewManager.addFrameCallback(this);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final boolean isAddToFrameCallback() {
        return this.mAddToFrameCallback;
    }

    protected static <T> T futureGet(Future<T> future) {
        if (future == null) {
            return null;
        }
        try {
            return future.get(800, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            MapLog.m16916e(TAG, e.getMessage(), e);
            Thread.currentThread().interrupt();
            return null;
        } catch (ExecutionException | TimeoutException e2) {
            MapLog.m16916e(TAG, e2.getMessage(), e2);
            return null;
        }
    }

    public void setClickable(boolean z) {
        if (z) {
            this.mViewFlags |= 2;
        } else {
            this.mViewFlags &= -3;
        }
    }

    public boolean isClickable() {
        return (this.mViewFlags & 2) == 2;
    }

    public void setLongClickable(boolean z) {
        if (z) {
            this.mViewFlags |= 4;
        } else {
            this.mViewFlags &= -5;
        }
    }

    public boolean isLongClickable() {
        return (this.mViewFlags & 4) == 4;
    }

    /* access modifiers changed from: package-private */
    public boolean dispatchGestureEvent(Gesture gesture) {
        return onInterceptGestureEvent(gesture) || onGesture(gesture);
    }

    /* access modifiers changed from: protected */
    public boolean onGesture(Gesture gesture) {
        int type = gesture.getType();
        if (type == 17) {
            Object obj = gesture.getObj();
            if (obj instanceof LatLng) {
                return performClick((LatLng) obj, gesture.getX(), gesture.getY());
            }
            if (obj instanceof MapEngine.TapItem) {
                return performClick(((MapEngine.TapItem) obj).geo, gesture.getX(), gesture.getY());
            }
            return performClick(new LatLng(-1.0d, -1.0d), gesture.getX(), gesture.getY());
        } else if (type != 18) {
            return false;
        } else {
            return performLongClick();
        }
    }

    public boolean performClick(LatLng latLng, float f, float f2) {
        OnClickListener onClickListener;
        if (!isClickable() || (onClickListener = getListenerInfo().mOnClickListener) == null) {
            return false;
        }
        return onClickListener.onClick(this, latLng, f, f2);
    }

    public boolean performLongClick() {
        OnLongClickListener onLongClickListener;
        if (!isLongClickable() || (onLongClickListener = getListenerInfo().mOnLongClickListener) == null) {
            return false;
        }
        return onLongClickListener.onLongClick(this);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        getListenerInfo().mOnClickListener = onClickListener;
    }

    public void setOnLongClickListener(OnLongClickListener onLongClickListener) {
        getListenerInfo().mOnLongClickListener = onLongClickListener;
    }

    private ListenerInfo getListenerInfo() {
        ListenerInfo listenerInfo = this.mListenerInfo;
        if (listenerInfo != null) {
            return listenerInfo;
        }
        ListenerInfo listenerInfo2 = new ListenerInfo();
        this.mListenerInfo = listenerInfo2;
        return listenerInfo2;
    }

    public GLViewParent getParent() {
        return this.mParent;
    }

    public MapContext getMapContext() {
        return this.mMapContext;
    }

    public String getId() {
        return this.mID;
    }

    public boolean isAdded() {
        return this.mParent != null;
    }

    public Animator getAnimator() {
        return this.mCurrentAnimator;
    }

    public Animator getPendingAnimator() {
        return this.mPendingAnimator;
    }

    public void setAnimator(Animator animator) {
        this.mPendingAnimator = animator;
    }

    public GLOverlayLayer getLayer() {
        return this.mLayer;
    }

    public void startAnimator() {
        Animator animator = this.mCurrentAnimator;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.mPendingAnimator;
        this.mCurrentAnimator = animator2;
        this.mPendingAnimator = null;
        if (animator2 != null) {
            animator2.setTarget(this);
            this.mCurrentAnimator.start();
        }
    }

    public void stopAnimation() {
        Animator animator = this.mCurrentAnimator;
        if (animator != null) {
            if (animator.isRunning()) {
                this.mCurrentAnimator.cancel();
            }
            this.mCurrentAnimator = null;
        }
    }

    /* access modifiers changed from: protected */
    public void set(RenderTask renderTask) {
        checkThread();
        GLViewParent parent = getParent();
        if (parent != null) {
            SetTransaction setTransaction = this.mSetTransaction;
            if (setTransaction != null) {
                setTransaction.chain(renderTask);
            } else {
                parent.postToRenderThread(renderTask);
            }
        }
    }

    /* access modifiers changed from: protected */
    public <T> Future<T> get(Callable<T> callable) {
        checkThread();
        GLViewParent parent = getParent();
        if (parent != null) {
            return parent.postToRenderThread(callable);
        }
        return null;
    }

    public final Handler getMainHandler() {
        return this.mainHandler;
    }

    /* access modifiers changed from: protected */
    public void beginSetTransaction() {
        checkThread();
        GLViewParent parent = getParent();
        if (parent != null && this.mSetTransaction == null) {
            this.mSetTransaction = new SetTransaction((Runnable) null, parent);
        }
    }

    /* access modifiers changed from: protected */
    public void beginSetTransaction(SetTransaction setTransaction) {
        checkThread();
        if (getParent() != null && this.mSetTransaction == null) {
            this.mSetTransaction = setTransaction;
        }
    }

    /* access modifiers changed from: protected */
    public void commitSetTransaction() {
        checkThread();
        SetTransaction setTransaction = this.mSetTransaction;
        if (setTransaction != null) {
            setTransaction.commit();
        }
        this.mSetTransaction = null;
    }

    /* access modifiers changed from: protected */
    public boolean inSetTransaction() {
        checkThread();
        return this.mSetTransaction != null;
    }

    public String toString() {
        return super.toString() + RConfigConstants.KEYWORD_COLOR_SIGN + this.mID;
    }

    protected static class LatLngSafe {
        private double latitude;
        private double longitude;

        public LatLngSafe() {
        }

        public LatLngSafe(double d, double d2) {
            this.longitude = d;
            this.latitude = d2;
        }

        public LatLngSafe(LatLngSafe latLngSafe) {
            this(latLngSafe.longitude, latLngSafe.latitude);
        }

        public synchronized void set(LatLngSafe latLngSafe) {
            this.longitude = latLngSafe.longitude;
            this.latitude = latLngSafe.latitude;
        }

        public synchronized void set(LatLng latLng) {
            this.longitude = latLng.longitude;
            this.latitude = latLng.latitude;
        }

        public synchronized double getLongitude() {
            return this.longitude;
        }

        public synchronized double getLatitude() {
            return this.latitude;
        }

        public synchronized void setLatitude(double d) {
            this.latitude = d;
        }

        public synchronized void setLongitude(double d) {
            this.longitude = d;
        }

        public synchronized void set(double d, double d2) {
            this.longitude = d;
            this.latitude = d2;
        }

        public synchronized boolean equals(Object obj) {
            return (obj instanceof LatLngSafe) && Double.compare(((LatLngSafe) obj).latitude, this.latitude) == 0 && Double.compare(((LatLngSafe) obj).longitude, this.longitude) == 0;
        }

        public synchronized boolean equalLatLng(LatLng latLng) {
            return Double.compare(latLng.latitude, this.latitude) == 0 && Double.compare(latLng.longitude, this.longitude) == 0;
        }

        public String toString() {
            return Const.jaLeft + this.longitude + ", " + this.latitude + Const.jaRight;
        }

        public synchronized LatLngSafe copy() {
            return new LatLngSafe(this);
        }

        public synchronized LatLng copyLatLng() {
            return new LatLng(this.latitude, this.longitude);
        }
    }
}
