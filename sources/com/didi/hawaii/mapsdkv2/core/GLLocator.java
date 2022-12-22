package com.didi.hawaii.mapsdkv2.core;

import android.animation.FloatEvaluator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.location.Location;
import android.view.animation.LinearInterpolator;
import com.didi.hawaii.mapsdkv2.common.MapTransform;
import com.didi.hawaii.mapsdkv2.common.Tranform2Piex20Utils;
import com.didi.hawaii.mapsdkv2.common.evaluator.AngleEvaluator;
import com.didi.hawaii.mapsdkv2.common.evaluator.CameraEvaluator;
import com.didi.hawaii.mapsdkv2.common.evaluator.LatLngEvaluator;
import com.didi.hawaii.mapsdkv2.core.GLViewDebug;
import com.didi.hawaii.mapsdkv2.core.IGLInfoWindow;
import com.didi.hawaii.mapsdkv2.view.RenderTask;
import com.didi.map.common.ApolloHawaii;
import com.didi.map.core.point.DoublePoint;
import com.didi.map.outer.model.LatLng;
import com.didi.map.outer.model.LatLngBounds;
import com.didi.sdk.apm.SystemUtils;
import com.didi.soda.customer.blocks.BlocksConst;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@GLViewDebug.ExportClass(name = "Locator")
public class GLLocator extends GLView implements IGLInfoWindow.Host {

    /* renamed from: w */
    private static final long f23898w = 1000;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final GLBaseMapView f23899a;
    /* access modifiers changed from: private */
    @GLViewDebug.ExportField(name = "position")

    /* renamed from: b */
    public final LatLng f23900b = new LatLng(0.0d, 0.0d);

    /* renamed from: c */
    private Texture f23901c;

    /* renamed from: d */
    private Texture f23902d;

    /* renamed from: e */
    private Texture f23903e;

    /* renamed from: f */
    private Texture f23904f;

    /* renamed from: g */
    private Texture f23905g;

    /* renamed from: h */
    private Texture f23906h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public float f23907i;
    @GLViewDebug.ExportField(name = "visible")

    /* renamed from: j */
    private boolean f23908j = false;

    /* renamed from: k */
    private boolean f23909k = false;

    /* renamed from: l */
    private boolean f23910l = false;

    /* renamed from: m */
    private boolean f23911m = false;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public int f23912n;
    @GLViewDebug.ExportField(name = "navigation_mode")

    /* renamed from: o */
    private int f23913o;
    /* access modifiers changed from: private */
    @GLViewDebug.ExportField(name = "heading")

    /* renamed from: p */
    public float f23914p;

    /* renamed from: q */
    private int f23915q;

    /* renamed from: r */
    private MapEngine f23916r;

    /* renamed from: s */
    private OnNaviModeChangeListener f23917s;

    /* renamed from: t */
    private final IGLInfoWindow.Holder f23918t;

    /* renamed from: u */
    private final RectF f23919u = new RectF();
    /* access modifiers changed from: private */

    /* renamed from: v */
    public final float[] f23920v = new float[4];

    public interface OnNaviModeChangeListener {
        void onChange(int i);
    }

    public RectF getInfoWindowScreenRect() {
        return null;
    }

    public void removeInfoWindow() {
    }

    GLLocator(GLViewManager gLViewManager, MapEngine mapEngine) {
        super(gLViewManager, GLOverlayLayer.LOCATOR);
        this.f23899a = gLViewManager.getBaseMap();
        this.f23916r = mapEngine;
        this.f23918t = new IGLInfoWindow.Holder(gLViewManager, this);
    }

    /* access modifiers changed from: protected */
    public void onAdded() {
        this.mMapCanvas.setLocatorCarVisible(this.f23909k);
        this.mMapCanvas.setLocatorCompassVisible(this.f23909k);
        this.mMapCanvas.setLocatorAccuracyVisible(this.f23909k);
        if (!(this.f23902d == null || this.f23903e == null || this.f23904f == null || this.f23905g == null || this.f23906h == null)) {
            this.mMapCanvas.setLocatorCompassImage(this.f23902d.getBitmapKey(), this.f23903e.getBitmapKey(), this.f23904f.getBitmapKey(), this.f23905g.getBitmapKey(), this.f23906h.getBitmapKey(), 0.5f, 0.5f);
        }
        if (this.f23901c != null) {
            this.mMapCanvas.setLocatorCarImage(this.f23901c.getBitmapKey(), 0.5f, 0.5f);
        }
        this.mMapCanvas.setLocatorInfo(this.f23900b, this.f23914p, this.f23899a.getCamera().getRotate(), this.f23907i, false, false);
        this.f23912n = this.mMapCanvas.getLocatorId();
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        this.f23911m = false;
        this.f23910l = false;
        this.f23909k = false;
        this.mMapCanvas.setLocatorCarVisible(false);
        this.mMapCanvas.setLocatorCompassVisible(false);
        this.mMapCanvas.setLocatorAccuracyVisible(false);
        this.f23912n = -1;
    }

    public void setCarVisible(final boolean z) {
        if (this.f23909k != z) {
            this.f23909k = z;
            set(new RenderTask() {
                public void run() {
                    GLLocator.this.mMapCanvas.setLocatorCarVisible(z);
                }
            });
        }
    }

    public void setCompassVisible(final boolean z) {
        if (this.f23910l != z) {
            this.f23910l = z;
            set(new RenderTask() {
                public void run() {
                    GLLocator.this.mMapCanvas.setLocatorCompassVisible(z);
                }
            });
        }
    }

    public void setAccuracyVisible(final boolean z) {
        if (this.f23911m != z) {
            this.f23911m = z;
            set(new RenderTask() {
                public void run() {
                    GLLocator.this.mMapCanvas.setLocatorAccuracyVisible(z);
                }
            });
        }
    }

    public boolean isCarVisible() {
        return this.f23909k;
    }

    public boolean isCompassVisible() {
        return this.f23910l;
    }

    public boolean isAccuracyVisible() {
        return this.f23911m;
    }

    public void setVisible(final boolean z) {
        if (this.f23908j != z) {
            this.f23908j = z;
            set(new RenderTask() {
                public void run() {
                    GLLocator.this.mMapCanvas.setLocatorVisible(z);
                }
            });
        }
    }

    public boolean isVisible() {
        return this.f23908j;
    }

    public void setAccuracy(final float f) {
        if (this.f23907i != f) {
            this.f23907i = f;
            set(new RenderTask() {
                public void run() {
                    GLLocator.this.mMapCanvas.setLocatorInfo(GLLocator.this.f23900b, GLLocator.this.f23914p, GLLocator.this.f23899a.getCamera().getRotate(), f, false, false);
                }
            });
        }
    }

    public void setGuideLineDestination(final LatLng latLng) {
        set(new RenderTask() {
            public void run() {
                GLLocator.this.mMapCanvas.setLocatorDestination(latLng);
                GLLocator.this.mMapCanvas.setLocatorInfo(GLLocator.this.f23900b, GLLocator.this.f23914p, GLLocator.this.f23899a.getCamera().getRotate(), GLLocator.this.f23907i, false, false);
            }
        });
    }

    public void showGuideLine(final boolean z) {
        set(new RenderTask() {
            public void run() {
                GLLocator.this.mMapCanvas.showLocatorGuideLine(z, GLLocator.this.f23900b);
            }
        });
    }

    public void setZIndex(int i) {
        if (this.f23915q != i) {
            this.f23915q = i;
            final int zIndexStart = GLOverlayLayer.getZIndexStart(GLOverlayLayer.OVERLAY) + i;
            set(new RenderTask() {
                public void run() {
                    GLLocator.this.mMapCanvas.setLocatorZIndex(zIndexStart);
                }
            });
        }
    }

    public LatLng getPosition() {
        return new LatLng(this.f23900b);
    }

    public boolean isInfoWindowShow() {
        return this.f23918t.isShow();
    }

    public LatLngBounds getInfoWindowGeoBound() {
        return this.f23918t.getInfoWindowGeoBound();
    }

    public float getAngle() {
        return this.f23914p;
    }

    public void setPositionAndAngle(LatLng latLng, float f) {
        setPositionAndAngle(latLng, f, this.f23899a.f23884e.getRotate());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m16997a(LatLng latLng, float f, float f2, float f3, float f4) {
        LatLng latLng2 = latLng;
        float f5 = f;
        float f6 = f2;
        float f7 = f3;
        float f8 = f4;
        if (Float.isNaN(f3)) {
            SystemUtils.log(5, "GLLocator", "setPositionAngleSkewScale: mapScale is NaN", (Throwable) null, "com.didi.hawaii.mapsdkv2.core.GLLocator", 295);
        } else if (f7 <= this.f23899a.f23886g && f7 >= this.f23899a.f23887h && f8 <= 35.0f && f8 >= 0.0f) {
            Camera camera = this.f23899a.f23884e;
            if (this.f23914p != f5 || !this.f23900b.equals(latLng) || camera.getRotate() != f6 || camera.getScale() != f7 || camera.getSkew() != f8) {
                this.f23900b.longitude = latLng2.longitude;
                this.f23900b.latitude = latLng2.latitude;
                this.f23914p = f5;
                boolean isCarFollowMode = isCarFollowMode();
                final boolean isCarUpAndFollowMode = isCarUpAndFollowMode();
                boolean z = isCarFollowMode || isCarUpAndFollowMode;
                if (z) {
                    this.f23899a.f23884e.setCenter(latLng);
                }
                if (isCarUpAndFollowMode) {
                    this.f23899a.f23884e.setRotate(f2);
                }
                this.f23899a.f23884e.setScale(f7);
                this.f23899a.f23884e.setSkew(f8);
                final LatLng latLng3 = latLng;
                final float f9 = f;
                final float f10 = f2;
                final float f11 = f3;
                final float f12 = f4;
                final boolean z2 = z;
                set(new RenderTask() {
                    public void run() {
                        GLLocator.this.mMapCanvas.setLocatorInfoWithSkewAndScale(latLng3, f9, f10, GLLocator.this.f23907i, f11, f12, z2, isCarUpAndFollowMode);
                    }
                });
                if (z) {
                    this.f23899a.mo69806f();
                }
            }
        }
    }

    public void setPositionAndAngle(LatLng latLng, float f, float f2) {
        if (this.f23914p != f || !this.f23900b.equals(latLng) || this.f23899a.f23884e.getRotate() != f2) {
            this.f23900b.longitude = latLng.longitude;
            this.f23900b.latitude = latLng.latitude;
            this.f23914p = f;
            boolean isCarFollowMode = isCarFollowMode();
            final boolean isCarUpAndFollowMode = isCarUpAndFollowMode();
            boolean z = isCarFollowMode || isCarUpAndFollowMode;
            if (z) {
                this.f23899a.f23884e.setCenter(latLng);
            }
            if (isCarUpAndFollowMode) {
                this.f23899a.f23884e.setRotate(f2);
            }
            final LatLng latLng2 = latLng;
            final float f3 = f;
            final float f4 = f2;
            final boolean z2 = z;
            set(new RenderTask() {
                public void run() {
                    GLLocator.this.mMapCanvas.setLocatorInfo(latLng2, f3, f4, GLLocator.this.f23907i, z2, isCarUpAndFollowMode);
                }
            });
            if (z) {
                this.f23899a.mo69806f();
            }
        }
    }

    public void setNaviMode(int i) {
        if (this.f23913o != i) {
            stopAnimation();
            this.f23913o = i;
            m16995a(i);
            OnNaviModeChangeListener onNaviModeChangeListener = this.f23917s;
            if (onNaviModeChangeListener != null) {
                onNaviModeChangeListener.onChange(i);
            }
        }
    }

    /* renamed from: a */
    private void m16995a(int i) {
        attachToFrame(true);
    }

    public boolean isCarFollowMode() {
        return (this.f23913o & 2) != 0;
    }

    public boolean isCarUpAndFollowMode() {
        return (this.f23913o & 1) != 0;
    }

    public int getNaviMode() {
        return this.f23913o;
    }

    public void setCarTexture(final Texture texture) {
        if (!texture.equals(this.f23901c)) {
            this.f23901c = texture;
            set(new RenderTask() {
                public void run() {
                    GLLocator.this.mMapCanvas.setLocatorCarImage(texture.getBitmapKey(), 0.5f, 0.5f);
                }
            });
        }
    }

    public RectF getPiexBound(float f) {
        DoublePoint latlng2PixelStandardScaleLevel = Tranform2Piex20Utils.latlng2PixelStandardScaleLevel(getPosition(), (DoublePoint) null);
        Bitmap bitmap = this.f23901c.getBitmap();
        RectF rectF = new RectF();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f2 = ((float) latlng2PixelStandardScaleLevel.f24753x) * f;
        float f3 = ((float) latlng2PixelStandardScaleLevel.f24754y) * f;
        rectF.left = f2;
        float f4 = (float) width;
        rectF.right = f2 + f4;
        float f5 = (float) height;
        rectF.top = f3 - f5;
        rectF.bottom = f3;
        float f6 = (float) ((int) (f4 * 0.5f));
        rectF.left -= f6;
        rectF.right -= f6;
        float f7 = (float) ((int) (f5 * 0.5f));
        rectF.top += f7;
        rectF.bottom += f7;
        return rectF;
    }

    public void setCompassTexture(Texture texture, Texture texture2, Texture texture3, Texture texture4, Texture texture5) {
        if (!texture.equals(this.f23902d)) {
            this.f23902d = texture;
            this.f23903e = texture2;
            this.f23904f = texture3;
            this.f23905g = texture4;
            this.f23906h = texture5;
            final Texture texture6 = texture;
            final Texture texture7 = texture2;
            final Texture texture8 = texture3;
            final Texture texture9 = texture4;
            final Texture texture10 = texture5;
            set(new RenderTask() {
                public void run() {
                    GLLocator.this.mMapCanvas.setLocatorCompassImage(texture6.getBitmapKey(), texture7.getBitmapKey(), texture8.getBitmapKey(), texture9.getBitmapKey(), texture10.getBitmapKey(), 0.5f, 0.5f);
                }
            });
        }
    }

    public void setOnNaviModeChangeListener(OnNaviModeChangeListener onNaviModeChangeListener) {
        this.f23917s = onNaviModeChangeListener;
    }

    public LatLngBounds getGeoBound() {
        Future future = get(new Callable<LatLngBounds>() {
            public LatLngBounds call() {
                return GLLocator.this.mMapCanvas.calculateLocatorGeoBound(GLLocator.this.f23912n);
            }
        });
        if (future == null) {
            return null;
        }
        try {
            return (LatLngBounds) future.get(800, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
            return null;
        } catch (ExecutionException e2) {
            e2.printStackTrace();
            return null;
        } catch (TimeoutException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public RectF getScreenBound() {
        if (isAddToFrameCallback()) {
            return this.f23919u;
        }
        Future future = get(new Callable<RectF>() {
            public RectF call() {
                GLLocator.this.mMapCanvas.calculateLocatorScreenBound(GLLocator.this.f23912n, GLLocator.this.f23920v);
                return new RectF(GLLocator.this.f23920v[0], GLLocator.this.f23920v[1], GLLocator.this.f23920v[2], GLLocator.this.f23920v[3]);
            }
        });
        if (future == null) {
            return null;
        }
        try {
            return (RectF) future.get(800, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
            return null;
        } catch (ExecutionException e2) {
            e2.printStackTrace();
            return null;
        } catch (TimeoutException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public void onFrameFinish(boolean z) {
        this.mMapCanvas.calculateLocatorScreenBound(this.f23912n, this.f23920v);
        synchronized (this.f23919u) {
            this.f23919u.set(this.f23920v[0], this.f23920v[1], this.f23920v[2], this.f23920v[3]);
        }
    }

    public void showInfoWindow(boolean z) {
        this.f23918t.show(z);
    }

    public IGLInfoWindow getInfoWindowView() {
        return this.f23918t.get();
    }

    public void setInfoWindowView(IGLInfoWindow iGLInfoWindow) {
        this.f23918t.set(iGLInfoWindow);
    }

    public boolean navigateToPosition(boolean z, LatLng latLng, float f, float f2, int i, int i2, boolean z2, long j, long j2) {
        if (z2) {
            this.mViewManager.setFps(1);
        }
        stopAnimation();
        return m16998a(latLng, f, i, i2, j, j2, z2);
    }

    /* renamed from: a */
    private boolean m16998a(LatLng latLng, float f, int i, int i2, long j, long j2, boolean z) {
        LatLng latLng2 = latLng;
        float f2 = f;
        if (z) {
            this.f23900b.latitude = latLng2.latitude;
            this.f23900b.longitude = latLng2.longitude;
            this.f23914p = f2;
            this.f23899a.f23884e.setCenter(latLng);
            this.f23899a.f23884e.setRotate(-f2);
        }
        final LatLng latLng3 = latLng;
        final int i3 = i;
        final int i4 = i2;
        final long j3 = j;
        final long j4 = j2;
        Future future = get(new Callable<Boolean>() {
            public Boolean call() {
                return Boolean.valueOf(GLLocator.this.mMapCanvas.setMJOLocatorInfo(latLng3, i3, i4, j3, j4));
            }
        });
        if (future == null) {
            return false;
        }
        try {
            return ((Boolean) future.get(500, TimeUnit.MILLISECONDS)).booleanValue();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        } catch (ExecutionException e2) {
            e2.printStackTrace();
            return false;
        } catch (TimeoutException e3) {
            e3.printStackTrace();
            return false;
        }
    }

    public void navigateToPosition(boolean z, LatLng latLng, float f) {
        if (z) {
            PropertyValuesHolder ofObject = PropertyValuesHolder.ofObject("locator", new LatLngEvaluator(), new Object[]{getPosition(), latLng});
            PropertyValuesHolder ofObject2 = PropertyValuesHolder.ofObject(BlocksConst.WIDGET_PARAMS_ANGLE, AngleEvaluator.INSTANCE, new Object[]{Float.valueOf(this.f23914p), Float.valueOf(f)});
            GLAnimator gLAnimator = new GLAnimator();
            gLAnimator.mo69773a(this.mViewManager.getFps());
            gLAnimator.setValues(new PropertyValuesHolder[]{ofObject, ofObject2});
            gLAnimator.setDuration(1000);
            gLAnimator.setInterpolator(new LinearInterpolator());
            gLAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue(BlocksConst.WIDGET_PARAMS_ANGLE)).floatValue();
                    GLLocator.this.setPositionAndAngle((LatLng) valueAnimator.getAnimatedValue("locator"), floatValue);
                }
            });
            setAnimator(gLAnimator);
            startAnimator();
            return;
        }
        stopAnimation();
        setPositionAndAngle(latLng, f);
    }

    public void navigateToPosition(boolean z, LatLng latLng, float f, float f2, float f3, float f4) {
        float normalizeRotate = MapTransform.normalizeRotate(-f2);
        if (z) {
            m16994a(f4, normalizeRotate);
            Camera camera = new Camera(this.f23899a.getCenter(), f4, this.f23899a.getRotate(), f3);
            Camera camera2 = this.f23899a.getCamera();
            PropertyValuesHolder ofObject = PropertyValuesHolder.ofObject("camera", new CameraEvaluator(true), new Object[]{camera2, camera});
            PropertyValuesHolder ofObject2 = PropertyValuesHolder.ofObject("locator", new LatLngEvaluator(), new Object[]{getPosition(), latLng});
            PropertyValuesHolder ofObject3 = PropertyValuesHolder.ofObject(BlocksConst.WIDGET_PARAMS_ANGLE, AngleEvaluator.INSTANCE, new Object[]{Float.valueOf(getAngle()), Float.valueOf(f)});
            PropertyValuesHolder ofObject4 = PropertyValuesHolder.ofObject("mapAngle", AngleEvaluator.INSTANCE, new Object[]{Float.valueOf(camera2.getRotate()), Float.valueOf(normalizeRotate)});
            GLAnimator gLAnimator = new GLAnimator();
            gLAnimator.setValues(new PropertyValuesHolder[]{ofObject, ofObject2, ofObject3, ofObject4});
            gLAnimator.mo69773a(this.mViewManager.getFps());
            gLAnimator.setDuration(1000);
            gLAnimator.setInterpolator(new LinearInterpolator());
            gLAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Camera camera = (Camera) valueAnimator.getAnimatedValue("camera");
                    LatLng latLng = (LatLng) valueAnimator.getAnimatedValue("locator");
                    float floatValue = ((Float) valueAnimator.getAnimatedValue(BlocksConst.WIDGET_PARAMS_ANGLE)).floatValue();
                    float floatValue2 = ((Float) valueAnimator.getAnimatedValue("mapAngle")).floatValue();
                    if (GLLocator.this.isCarUpAndFollowMode()) {
                        GLLocator.this.m16997a(latLng, floatValue, floatValue2, camera.getScale(), camera.getSkew());
                    } else {
                        GLLocator.this.setPositionAndAngle(latLng, floatValue, floatValue2);
                    }
                }
            });
            setAnimator(gLAnimator);
            startAnimator();
            return;
        }
        if (isCarUpAndFollowMode()) {
            this.f23899a.mo69778a(f3, f4);
        }
        setPositionAndAngle(latLng, f, normalizeRotate);
    }

    public void navigateToPosition(boolean z, List<LatLng> list, float f, float f2, float f3, float f4, float f5) {
        float normalizeRotate = MapTransform.normalizeRotate(-f2);
        if (z) {
            m16994a(f3, normalizeRotate);
            Camera camera = new Camera(this.f23899a.getCenter(), f3, this.f23899a.getRotate(), f4);
            Camera camera2 = this.f23899a.getCamera();
            PropertyValuesHolder ofObject = PropertyValuesHolder.ofObject("camera", new CameraEvaluator(true), new Object[]{camera2, camera});
            list.add(0, getPosition());
            PropertyValuesHolder ofObject2 = PropertyValuesHolder.ofObject("locator", new LatLngEvaluator(), list.toArray());
            PropertyValuesHolder ofObject3 = PropertyValuesHolder.ofObject(BlocksConst.WIDGET_PARAMS_ANGLE, AngleEvaluator.INSTANCE, m16993a(f, list).toArray());
            PropertyValuesHolder ofObject4 = PropertyValuesHolder.ofObject("mapAngle", AngleEvaluator.INSTANCE, new Object[]{Float.valueOf(camera2.getRotate()), Float.valueOf(normalizeRotate)});
            PropertyValuesHolder ofObject5 = PropertyValuesHolder.ofObject("offsetX", new FloatEvaluator(), new Object[]{Float.valueOf(this.f23899a.getCenterOffsetX()), Float.valueOf(f5)});
            GLAnimator gLAnimator = new GLAnimator();
            gLAnimator.setValues(new PropertyValuesHolder[]{ofObject, ofObject2, ofObject3, ofObject5, ofObject4});
            gLAnimator.mo69773a(this.mViewManager.getFps());
            gLAnimator.setDuration(1000);
            gLAnimator.setInterpolator(new LinearInterpolator());
            gLAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Camera camera = (Camera) valueAnimator.getAnimatedValue("camera");
                    LatLng latLng = (LatLng) valueAnimator.getAnimatedValue("locator");
                    float floatValue = ((Float) valueAnimator.getAnimatedValue(BlocksConst.WIDGET_PARAMS_ANGLE)).floatValue();
                    float floatValue2 = ((Float) valueAnimator.getAnimatedValue("offsetX")).floatValue();
                    float floatValue3 = ((Float) valueAnimator.getAnimatedValue("mapAngle")).floatValue();
                    if (GLLocator.this.isCarUpAndFollowMode()) {
                        GLLocator.this.f23899a.mo69779a(camera.getSkew(), camera.getScale(), floatValue2);
                    }
                    GLLocator.this.setPositionAndAngle(latLng, floatValue, floatValue3);
                }
            });
            setAnimator(gLAnimator);
            startAnimator();
            return;
        }
        if (isCarUpAndFollowMode()) {
            this.f23899a.mo69779a(f4, f3, f5);
        }
        setPositionAndAngle(list.get(0), f, normalizeRotate);
    }

    /* renamed from: a */
    private List<Float> m16993a(float f, List<LatLng> list) {
        List<LatLng> list2 = list;
        int size = list.size() - 1;
        ArrayList arrayList = new ArrayList(size);
        float[] fArr = new float[2];
        int i = 0;
        while (i < size) {
            LatLng latLng = list2.get(i);
            int i2 = i + 1;
            LatLng latLng2 = list2.get(i2);
            if (!latLng.equals(latLng2)) {
                Location.distanceBetween(latLng.latitude, latLng.longitude, latLng2.latitude, latLng2.longitude, fArr);
                arrayList.add(Float.valueOf(fArr[1]));
            }
            i = i2;
        }
        if (arrayList.size() < 2) {
            arrayList.clear();
            arrayList.add(Float.valueOf(this.f23914p));
        }
        arrayList.add(Float.valueOf(f));
        return arrayList;
    }

    /* renamed from: a */
    private void m16994a(float f, float f2) {
        if (ApolloHawaii.IS_RENDER_DROP_FRAME) {
            float f3 = ApolloHawaii.SCALE_DELTA;
            float rotate = f2 - this.f23899a.getRotate();
            if (rotate > 180.0f) {
                rotate -= 360.0f;
            } else if (rotate < -180.0f) {
                rotate += 360.0f;
            }
            if (f - this.f23899a.getScale() >= f3 || Math.abs(rotate) >= ApolloHawaii.ROTATE_DELTA) {
                this.mViewManager.setFps(2);
            } else {
                this.mViewManager.setFps(6);
            }
        }
    }
}
