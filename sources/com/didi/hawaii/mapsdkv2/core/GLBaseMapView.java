package com.didi.hawaii.mapsdkv2.core;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.FloatEvaluator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.ViewDebug;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;
import com.didi.hawaii.log.HWLog;
import com.didi.hawaii.log.HwDLog;
import com.didi.hawaii.mapsdk.gesture.NNGestureClassfy;
import com.didi.hawaii.mapsdkv2.Prefs;
import com.didi.hawaii.mapsdkv2.common.MapGlobal;
import com.didi.hawaii.mapsdkv2.common.MapTransform;
import com.didi.hawaii.mapsdkv2.common.MathsUtils;
import com.didi.hawaii.mapsdkv2.common.PauseableThread;
import com.didi.hawaii.mapsdkv2.common.Tranform2Piex20Utils;
import com.didi.hawaii.mapsdkv2.common.evaluator.AngleEvaluator;
import com.didi.hawaii.mapsdkv2.common.evaluator.CameraEvaluator;
import com.didi.hawaii.mapsdkv2.common.evaluator.LatLngEvaluator;
import com.didi.hawaii.mapsdkv2.common.evaluator.ScrollByPointFEvaluator;
import com.didi.hawaii.mapsdkv2.core.DefaultEGLContextFactory;
import com.didi.hawaii.mapsdkv2.core.GLView;
import com.didi.hawaii.mapsdkv2.core.GLViewDebug;
import com.didi.hawaii.mapsdkv2.core.MapEngine;
import com.didi.hawaii.mapsdkv2.view.RenderTask;
import com.didi.hawaii.utils.DeviceUtils;
import com.didi.hawaii.utils.OmegaUtils;
import com.didi.map.base.TextLableOnRoute;
import com.didi.map.base.TrafficEventModel;
import com.didi.map.base.TrafficEventRoutePoint;
import com.didi.map.base.bubble.AnimationSetting;
import com.didi.map.base.bubble.Bubble;
import com.didi.map.common.ApolloHawaii;
import com.didi.map.common.utils.TransformUtil;
import com.didi.map.core.SurfaceChangeListener;
import com.didi.map.core.point.DoublePoint;
import com.didi.map.core.point.GeoPoint;
import com.didi.map.outer.EnlargPicSetting;
import com.didi.map.outer.model.IMapElement;
import com.didi.map.outer.model.LatLng;
import com.didi.map.outer.model.LatLngBounds;
import com.didi.map.outer.model.OutBlockInfo;
import com.didi.map.outer.model.VisibleRegion;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import javax.microedition.khronos.egl.EGL10;

@GLViewDebug.ExportClass(name = "BaseMap")
public class GLBaseMapView extends GLView {

    /* renamed from: a */
    static final float f23828a = 35.0f;

    /* renamed from: b */
    static final float f23829b = 0.0f;

    /* renamed from: l */
    private static final String f23830l = "GLBaseMapView";

    /* renamed from: m */
    private static final double f23831m = 1.0E-4d;

    /* renamed from: n */
    private static final String f23832n = "BaseMap_";

    /* renamed from: o */
    private static final long f23833o = 200;

    /* renamed from: p */
    private static final long f23834p = 250;

    /* renamed from: q */
    private static final float f23835q = 1.1f;

    /* renamed from: r */
    private static final int[] f23836r = {-1670576, -208863, -8593757, -3711116};

    /* renamed from: s */
    private static final int[] f23837s = {-5418940, -7897037, -15565734, -7921852};

    /* renamed from: t */
    private static final int[] f23838t = {-629917, -208863, -8593757, -4181169};

    /* renamed from: A */
    private boolean f23839A = false;
    /* access modifiers changed from: private */
    @GLViewDebug.ExportField(name = "screen_width")

    /* renamed from: B */
    public int f23840B;
    /* access modifiers changed from: private */
    @GLViewDebug.ExportField(name = "screen_height")

    /* renamed from: C */
    public int f23841C;

    /* renamed from: D */
    private boolean f23842D = false;

    /* renamed from: E */
    private final MapModeAdapter f23843E;

    /* renamed from: F */
    private float f23844F = 0.0f;
    @ViewDebug.ExportedProperty(category = "hawaii", mapping = {@ViewDebug.IntToString(from = 0, to = "Chinese"), @ViewDebug.IntToString(from = 1, to = "English"), @ViewDebug.IntToString(from = 2, to = "Traditional Chinese")})
    @GLViewDebug.ExportField(name = "language")

    /* renamed from: G */
    private int f23845G;
    @GLViewDebug.ExportField(name = "theme")

    /* renamed from: H */
    private int f23846H;

    /* renamed from: I */
    private final EngineLogSwitch f23847I;

    /* renamed from: J */
    private final EngineDynamicConfigProvider f23848J;

    /* renamed from: K */
    private String f23849K;
    /* access modifiers changed from: private */

    /* renamed from: L */
    public String f23850L;

    /* renamed from: M */
    private String f23851M;

    /* renamed from: N */
    private ArrayList<String> f23852N;

    /* renamed from: O */
    private int f23853O;
    /* access modifiers changed from: private */
    @GLViewDebug.ExportField(name = "max_scale_level")

    /* renamed from: P */
    public final int f23854P;

    /* renamed from: Q */
    private float f23855Q;
    @GLViewDebug.ExportField(name = "min_scale_level")

    /* renamed from: R */
    private final int f23856R;

    /* renamed from: S */
    private final float f23857S;
    /* access modifiers changed from: private */

    /* renamed from: T */
    public boolean f23858T;
    @GLViewDebug.ExportField(name = "vulkan")

    /* renamed from: U */
    private boolean f23859U;

    /* renamed from: V */
    private final MapEngine.MJOCallback f23860V = new MapEngine.MJOCallback() {
        public void onMJOEvent(final long j, final int i) {
            if (i == 1) {
                GLBaseMapView.this.f23894x.restoreMapCameraOnMJOHide(GLBaseMapView.this.f23854P, GLBaseMapView.this.f23884e);
                GLBaseMapView.this.f23893w.setAllGesturesEnabled(true);
            }
            GLBaseMapView.this.getMainHandler().post(new Runnable() {
                public void run() {
                    if (GLBaseMapView.this.f23871ag != null) {
                        GLBaseMapView.this.f23871ag.onMJOEvent(j, i);
                    }
                    if (GLBaseMapView.this.f23877am != null) {
                        GLBaseMapView.this.f23877am.stopAnimation();
                    }
                }
            });
        }
    };

    /* renamed from: W */
    private final MapEngine.BlockEventCallback f23861W = new MapEngine.BlockEventCallback() {
        public void onBlockEvent(long j, double d, double d2) {
            final long j2 = j;
            final double d3 = d;
            final double d4 = d2;
            GLBaseMapView.this.getMainHandler().post(new Runnable() {
                public void run() {
                    if (GLBaseMapView.this.f23871ag != null) {
                        GLBaseMapView.this.f23871ag.onBlockEvent(j2, d3, d4);
                    }
                }
            });
        }
    };

    /* renamed from: X */
    private ScaleRulerUpdateCallback f23862X;
    /* access modifiers changed from: private */

    /* renamed from: Y */
    public ScaleRulerShowCallback f23863Y;
    @ViewDebug.ExportedProperty(category = "hawaii", mapping = {@ViewDebug.IntToString(from = 1, to = "Normal"), @ViewDebug.IntToString(from = 3, to = "Navigation"), @ViewDebug.IntToString(from = 9, to = "Navigation(Night)"), @ViewDebug.IntToString(from = 11, to = "Navigation(Night, Traffic)")})
    @GLViewDebug.ExportField(name = "map_mode")

    /* renamed from: Z */
    private int f23864Z;

    /* renamed from: aa */
    private boolean f23865aa;

    /* renamed from: ab */
    private volatile boolean f23866ab = false;

    /* renamed from: ac */
    private OnBaseMapCreateCallback f23867ac;

    /* renamed from: ad */
    private OnBaseMapCreateCallback f23868ad;
    /* access modifiers changed from: private */

    /* renamed from: ae */
    public boolean f23869ae = false;
    /* access modifiers changed from: private */

    /* renamed from: af */
    public boolean f23870af = false;
    /* access modifiers changed from: private */

    /* renamed from: ag */
    public BaseMapCallback f23871ag;

    /* renamed from: ah */
    private BaseMapAllGestureListener f23872ah;
    /* access modifiers changed from: private */
    @GLViewDebug.ExportField(name = "center_offset_x")

    /* renamed from: ai */
    public float f23873ai = 0.5f;
    /* access modifiers changed from: private */
    @GLViewDebug.ExportField(name = "center_offset_y")

    /* renamed from: aj */
    public float f23874aj = 0.5f;
    @GLViewDebug.ExportField(name = "support_share_context")

    /* renamed from: ak */
    private boolean f23875ak = true;

    /* renamed from: al */
    private final Runnable f23876al = new RenderTask() {
        public void run() {
            if (GLBaseMapView.this.f23871ag != null) {
                GLBaseMapView.this.f23871ag.onMapStable();
            }
            if (GLBaseMapView.this.f23895y != null && GLBaseMapView.this.f23858T) {
                GLBaseMapView.this.f23895y.mo70622a(false);
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: am */
    public GLLocator f23877am;
    /* access modifiers changed from: private */

    /* renamed from: an */
    public final Rect f23878an = new Rect();
    /* access modifiers changed from: private */

    /* renamed from: ao */
    public int f23879ao = 1;
    /* access modifiers changed from: private */

    /* renamed from: ap */
    public SurfaceChangeListener f23880ap;
    /* access modifiers changed from: private */

    /* renamed from: aq */
    public boolean f23881aq = false;

    /* renamed from: c */
    final MapDataUpdateHandler f23882c;

    /* renamed from: d */
    BaseMapData f23883d;
    @ViewDebug.ExportedProperty(category = "hawaii")
    @GLViewDebug.ExportField(name = "camera")

    /* renamed from: e */
    final Camera f23884e;

    /* renamed from: f */
    String f23885f;

    /* renamed from: g */
    final float f23886g;

    /* renamed from: h */
    final float f23887h;

    /* renamed from: i */
    LabelOnRouteCallback f23888i;

    /* renamed from: j */
    BitmapLoaderListener f23889j;

    /* renamed from: k */
    LatLngEvaluator f23890k = new LatLngEvaluator();
    /* access modifiers changed from: private */

    /* renamed from: u */
    public boolean f23891u = false;

    /* renamed from: v */
    private final GLProjection f23892v = new GLProjection() {
        public LatLng fromScreen(float f, float f2) {
            return GLBaseMapView.this.f23894x.fromScreenLocationUnsafe(f, f2);
        }

        public PointF toScreen(LatLng latLng) {
            float[] screenLocationUnsafe = GLBaseMapView.this.f23894x.toScreenLocationUnsafe(latLng);
            return new PointF(screenLocationUnsafe[0], screenLocationUnsafe[1]);
        }

        public VisibleRegion getVisibleRegion() {
            return (VisibleRegion) GLView.futureGet(GLBaseMapView.this.get(new Callable<VisibleRegion>() {
                public VisibleRegion call() {
                    LatLng fromScreenLocation = GLBaseMapView.this.f23894x.fromScreenLocation((float) GLBaseMapView.this.f23878an.left, (float) (GLBaseMapView.this.f23841C - GLBaseMapView.this.f23878an.bottom));
                    LatLng fromScreenLocation2 = GLBaseMapView.this.f23894x.fromScreenLocation((float) (GLBaseMapView.this.f23840B - GLBaseMapView.this.f23878an.right), (float) (GLBaseMapView.this.f23841C - GLBaseMapView.this.f23878an.bottom));
                    LatLng fromScreenLocation3 = GLBaseMapView.this.f23894x.fromScreenLocation((float) GLBaseMapView.this.f23878an.left, (float) GLBaseMapView.this.f23878an.top);
                    LatLng fromScreenLocation4 = GLBaseMapView.this.f23894x.fromScreenLocation((float) (GLBaseMapView.this.f23840B - GLBaseMapView.this.f23878an.right), (float) GLBaseMapView.this.f23878an.top);
                    return new VisibleRegion(fromScreenLocation, fromScreenLocation2, fromScreenLocation3, fromScreenLocation4, LatLngBounds.builder().include(fromScreenLocation).include(fromScreenLocation2).include(fromScreenLocation3).include(fromScreenLocation4).build());
                }
            }));
        }
    };
    /* access modifiers changed from: private */
    @ViewDebug.ExportedProperty(deepExport = true)

    /* renamed from: w */
    public final GLUiSetting f23893w = new GLUiSetting();
    /* access modifiers changed from: private */

    /* renamed from: x */
    public MapEngine f23894x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public C9189i f23895y;

    /* renamed from: z */
    private TextureThread f23896z;

    public interface BaseMapCallback {
        void onBlockEvent(long j, double d, double d2);

        void onCameraChange(double d, double d2, float f, float f2, float f3, float f4);

        void onGLOverlayViewClick(GLOverlayView gLOverlayView);

        void onMJOEvent(long j, int i);

        void onMapClick(LatLng latLng);

        void onMapCompassClick();

        void onMapLoaded();

        void onMapLocatorClick();

        void onMapLongClick(LatLng latLng);

        void onMapModeChange(int i);

        void onMapPoiClick(Poi poi);

        void onMapStable();
    }

    public interface BitmapLoaderListener {
        Bitmap onLoadBitmap(int i, String str);
    }

    public static class ExtendIcon extends Poi {
        public int itemType;
        public byte[] outBype;
    }

    public interface LabelOnRouteCallback {
        void onRouteNew(List<TextLableOnRoute> list);
    }

    public static class Poi {
        public static final int TYPE_ANNOTATION = 0;
        public static final int TYPE_EXTENDICON = 3;
        public static final int TYPE_POI_ABOARD = 2;
        public static final int TYPE_TRAFFIC = 1;
        public LatLng geo;

        /* renamed from: id */
        public long f23897id;
        public long identity;
        public int itemType;
        public String name;
        public String poiUrl;
        public int type;
    }

    public static class PoiEvent extends Poi {
        public int itemType;
        public int subIndex;
    }

    public interface ScaleRulerShowCallback {
        void onMapModeChange(int i);

        void onScaleChange();
    }

    public interface ScaleRulerUpdateCallback {
        void onUpdate(float f, float f2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo69777a() {
    }

    public void setZoomControlVisible(boolean z) {
    }

    public void setScaleRuler(ScaleRulerUpdateCallback scaleRulerUpdateCallback) {
        this.f23862X = scaleRulerUpdateCallback;
        if (scaleRulerUpdateCallback != null) {
            attachToFrame(true);
        } else {
            attachToFrame(false);
        }
        this.f23844F = 0.0f;
    }

    public void setScaleRulerControl(ScaleRulerShowCallback scaleRulerShowCallback) {
        this.f23863Y = scaleRulerShowCallback;
    }

    private class BaseMapDataImpl implements BaseMapData {
        private BaseMapDataImpl() {
        }

        public int fetchTrafficBlockData(byte[] bArr, int i, int i2, int i3, int i4, int i5) {
            GLViewParent parent = GLBaseMapView.this.getParent();
            if (parent == null) {
                return 0;
            }
            final byte[] bArr2 = bArr;
            final int i6 = i;
            final int i7 = i2;
            final int i8 = i3;
            final int i9 = i4;
            final int i10 = i5;
            Integer num = (Integer) GLView.futureGet(parent.postToRenderThread(new Callable<Integer>() {
                public Integer call() {
                    return Integer.valueOf(GLBaseMapView.this.f23894x.fetchTrafficBlockData(bArr2, i6, i7, i8, i9, i10));
                }
            }));
            if (num != null) {
                return num.intValue();
            }
            return 0;
        }

        public int refreshTrafficData(final byte[] bArr, final byte[] bArr2, final int i) {
            Integer num;
            GLViewParent parent = GLBaseMapView.this.getParent();
            if (parent == null || (num = (Integer) GLView.futureGet(parent.postToRenderThread(new Callable<Integer>() {
                public Integer call() {
                    MapEngine a = GLBaseMapView.this.f23894x;
                    byte[] bArr = bArr;
                    return Integer.valueOf(a.refreshTrafficData(bArr, bArr.length, bArr2, i));
                }
            }))) == null) {
                return 0;
            }
            return num.intValue();
        }

        public void refreshBaseMapData(final byte[] bArr, final String str, final int i) {
            GLViewParent parent;
            if ((MapGlobal.curLanguage == i || ApolloHawaii.CANCEL_TILE_DATA_REQUEST) && (parent = GLBaseMapView.this.getParent()) != null) {
                parent.postToRenderThread((RenderTask) new RenderTask() {
                    public void run() {
                        if (MapGlobal.curLanguage == i || !ApolloHawaii.CANCEL_TILE_DATA_REQUEST) {
                            GLBaseMapView.this.f23894x.writeMapData(str, bArr);
                        } else {
                            GLBaseMapView.this.f23894x.cancelMapDataDownloadTask(str);
                        }
                    }
                });
                if (!GLBaseMapView.this.f23891u && GLBaseMapView.this.f23871ag != null) {
                    GLBaseMapView.this.f23871ag.onMapLoaded();
                    boolean unused = GLBaseMapView.this.f23891u = true;
                }
            }
        }

        public void refreshDynamicLayerMapData(final String str, final byte[] bArr, int i) {
            GLViewParent parent = GLBaseMapView.this.getParent();
            if (parent != null) {
                parent.postToRenderThread((RenderTask) new RenderTask() {
                    public void run() {
                        if (GLBaseMapView.this.f23894x != null) {
                            HwDLog.m16764d("________dynamicdebug_____", "writeMapDynamicLayerData", new Object[0]);
                            GLBaseMapView.this.f23894x.writeMapDynamicLayerData(str, bArr);
                        }
                    }
                });
            }
        }

        public void cancelMapDynamicLayerLoadTask(String str) {
            if (GLBaseMapView.this.f23894x != null) {
                HwDLog.m16764d("________dynamicdebug_____", "cancelMapDynamicLayerLoadTask", new Object[0]);
                GLBaseMapView.this.f23894x.cancelMapDynamicLayerLoadTask(str);
            }
        }

        public void cancelBaseMapDataTask(final String str) {
            GLViewParent parent = GLBaseMapView.this.getParent();
            if (parent != null) {
                parent.postToRenderThread((RenderTask) new RenderTask() {
                    public void run() {
                        GLBaseMapView.this.f23894x.cancelMapDataDownloadTask(str);
                    }
                });
            }
        }

        public String getTrafficUpdateUrl() {
            return GLBaseMapView.this.f23894x.getTrafficUpdateUrl();
        }
    }

    public GLBaseMapView(GLViewManager gLViewManager, Option option, MapDataUpdateHandler mapDataUpdateHandler, boolean z) {
        super(gLViewManager, GLOverlayLayer.f23923a);
        this.f23875ak = z;
        this.mID = f23832n + sIdGenerator.getAndIncrement();
        this.f23882c = mapDataUpdateHandler;
        this.f23884e = new Camera(option.center, option.scale, option.rotate, option.skew);
        this.f23846H = option.mapTheme;
        this.f23845G = option.language;
        this.f23885f = option.configPath;
        this.f23849K = option.dataPath;
        this.f23850L = option.satellitePath;
        this.f23851M = option.wmsPath;
        this.f23852N = option.configurations;
        this.f23853O = option.mapVersion;
        this.f23854P = option.maxScaleLevel;
        this.f23856R = option.minScaleLevel;
        this.f23855Q = option.maxSkew;
        this.f23847I = option.engineLogSwitch;
        this.f23848J = option.engineDynamicConfigProvider;
        this.f23886g = (float) MathsUtils.getScale((double) this.f23854P);
        this.f23887h = (float) MathsUtils.getScale((double) this.f23856R);
        MapModeAdapter mapModeAdapter = new MapModeAdapter();
        this.f23843E = mapModeAdapter;
        boolean unused = mapModeAdapter.isNight = option.isNight;
        boolean unused2 = this.f23843E.isNavi = option.isNavi;
        boolean unused3 = this.f23843E.isTraffic = option.isTraffic;
        boolean unused4 = this.f23843E.isDynamicLayerEnable = option.isDynamicLayerEnable;
        if (this.f23843E.isTraffic) {
            m16941a(true);
        }
        this.f23859U = option.isVulkan;
        this.f23865aa = option.compassVisible;
        this.f23857S = gLViewManager.getMapContext().getAndroidContext().getResources().getDisplayMetrics().density;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo69781a(GLLocator gLLocator) {
        this.f23877am = gLLocator;
    }

    public void setLabelOnRouteCallback(LabelOnRouteCallback labelOnRouteCallback) {
        this.f23888i = labelOnRouteCallback;
    }

    public void setBitmapLoaderListener(BitmapLoaderListener bitmapLoaderListener) {
        this.f23889j = bitmapLoaderListener;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo69783a(OnBaseMapCreateCallback onBaseMapCreateCallback) {
        this.f23867ac = onBaseMapCreateCallback;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo69790b(OnBaseMapCreateCallback onBaseMapCreateCallback) {
        synchronized (this) {
            if (this.f23842D) {
                onBaseMapCreateCallback.onCreate();
            } else {
                this.f23868ad = onBaseMapCreateCallback;
            }
        }
    }

    public Camera computeZoomToSpanTarget(final RectF rectF, Rect rect) {
        final Rect rect2 = new Rect(0, 0, this.f23840B, this.f23841C);
        rect2.set(rect2.left + rect.left, rect2.top + rect.top, rect2.right - rect.right, rect2.bottom - rect.bottom);
        return (Camera) futureGet(get(new Callable<Camera>() {
            public Camera call() {
                return (((double) Math.abs(GLBaseMapView.this.f23873ai - 0.5f)) > GLBaseMapView.f23831m || ((double) Math.abs(GLBaseMapView.this.f23874aj - 0.5f)) > GLBaseMapView.f23831m) ? GLBaseMapView.this.f23894x.zoomToSpan4CenterOffset(rectF, rect2, GLBaseMapView.this.f23873ai, GLBaseMapView.this.f23874aj, GLBaseMapView.this.f23840B, GLBaseMapView.this.f23841C) : GLBaseMapView.this.f23894x.zoomToSpan(rectF, rect2);
            }
        }));
    }

    public Camera computeZoomToSpanTarget(LatLng latLng, RectF rectF, Rect rect, List<IMapElement> list) {
        final Rect rect2 = new Rect(0, 0, this.f23840B, this.f23841C);
        rect2.set((((this.f23840B - this.f23878an.left) - this.f23878an.right) / 2) - rect.left, (((this.f23841C - this.f23878an.top) - this.f23878an.bottom) / 2) - rect.top, (((this.f23840B - this.f23878an.left) - this.f23878an.right) / 2) - rect.right, (((this.f23841C - this.f23878an.top) - this.f23878an.bottom) / 2) - rect.bottom);
        final LatLng latLng2 = latLng;
        final RectF rectF2 = rectF;
        final List<IMapElement> list2 = list;
        return (Camera) futureGet(get(new Callable<Camera>() {
            public Camera call() {
                DoublePoint doublePoint = new DoublePoint();
                DoublePoint doublePoint2 = new DoublePoint();
                DoublePoint geo2PixelStandardScaleLevel = Tranform2Piex20Utils.geo2PixelStandardScaleLevel(new GeoPoint((int) (latLng2.latitude * 1000000.0d), (int) (latLng2.longitude * 1000000.0d)), (DoublePoint) null);
                RectF rectF = rectF2;
                if (rectF != null) {
                    doublePoint = Tranform2Piex20Utils.geo2PixelStandardScaleLevel(new GeoPoint((int) (((double) rectF.top) * 1000000.0d), (int) (((double) rectF2.left) * 1000000.0d)), (DoublePoint) null);
                    doublePoint2 = Tranform2Piex20Utils.geo2PixelStandardScaleLevel(new GeoPoint((int) (((double) rectF2.bottom) * 1000000.0d), (int) (((double) rectF2.right) * 1000000.0d)), (DoublePoint) null);
                }
                float f = 4.0f;
                while (f >= 3.0517578E-5f) {
                    RectF rectF2 = new RectF();
                    if (rectF2 != null) {
                        double d = (double) f;
                        rectF2 = new RectF((float) Math.min(doublePoint.f24753x * d, doublePoint2.f24753x * d), (float) Math.min(doublePoint2.f24754y * d, doublePoint.f24754y * d), (float) Math.max(doublePoint.f24753x * d, doublePoint2.f24753x * d), (float) Math.max(doublePoint2.f24754y * d, doublePoint.f24754y * d));
                    }
                    for (IMapElement pixel20Bound : list2) {
                        RectF pixel20Bound2 = pixel20Bound.getPixel20Bound(f);
                        if (pixel20Bound2 != null) {
                            if (rectF2.left == 0.0f) {
                                rectF2.left = pixel20Bound2.left;
                            }
                            if (rectF2.top == 0.0f) {
                                rectF2.top = pixel20Bound2.top;
                            }
                            if (rectF2.right == 0.0f) {
                                rectF2.right = pixel20Bound2.right;
                            }
                            if (rectF2.bottom == 0.0f) {
                                rectF2.bottom = pixel20Bound2.bottom;
                            }
                            if (rectF2.left > pixel20Bound2.left) {
                                rectF2.left = pixel20Bound2.left;
                            }
                            if (rectF2.top > pixel20Bound2.top) {
                                rectF2.top = pixel20Bound2.top;
                            }
                            if (rectF2.right < pixel20Bound2.right) {
                                rectF2.right = pixel20Bound2.right;
                            }
                            if (rectF2.bottom < pixel20Bound2.bottom) {
                                rectF2.bottom = pixel20Bound2.bottom;
                            }
                        }
                    }
                    double d2 = (double) f;
                    double d3 = (geo2PixelStandardScaleLevel.f24753x * d2) - ((double) rectF2.left);
                    double d4 = ((double) rectF2.right) - (geo2PixelStandardScaleLevel.f24753x * d2);
                    double d5 = (geo2PixelStandardScaleLevel.f24754y * d2) - ((double) rectF2.top);
                    double d6 = (double) rectF2.bottom;
                    DoublePoint doublePoint3 = doublePoint;
                    DoublePoint doublePoint4 = doublePoint2;
                    double d7 = d6 - (geo2PixelStandardScaleLevel.f24754y * d2);
                    if (d3 <= ((double) rect2.left) && d4 <= ((double) rect2.right) && d7 <= ((double) rect2.top) && d5 <= ((double) rect2.bottom)) {
                        return new Camera(latLng2, f, 0.0f, 0.0f);
                    }
                    f /= GLBaseMapView.f23835q;
                    doublePoint = doublePoint3;
                    doublePoint2 = doublePoint4;
                }
                return null;
            }
        }));
    }

    public Camera computeZoomToSpanTarget(Camera camera, RectF rectF, Rect rect, List<IMapElement> list) {
        Rect rect2 = new Rect(0, 0, this.f23840B, this.f23841C);
        rect2.set(rect2.left + rect.left, rect2.top + rect.top, rect2.right - rect.right, rect2.bottom - rect.bottom);
        final float width = (float) rect2.width();
        final float height = (float) rect2.height();
        final Camera camera2 = camera;
        final RectF rectF2 = rectF;
        final List<IMapElement> list2 = list;
        final Rect rect3 = rect;
        return (Camera) futureGet(get(new Callable<Camera>() {
            public Camera call() {
                DoublePoint doublePoint;
                DoublePoint doublePoint2;
                float f;
                float f2;
                float f3;
                Camera camera;
                float l = GLBaseMapView.this.f23873ai;
                float m = GLBaseMapView.this.f23874aj;
                float unused = GLBaseMapView.this.f23873ai = 0.5f;
                float unused2 = GLBaseMapView.this.f23874aj = 0.5f;
                GLBaseMapView.this.f23894x.setCenterOffset(0.0f, 0.0f);
                DoublePoint doublePoint3 = new DoublePoint();
                DoublePoint doublePoint4 = new DoublePoint();
                Camera camera2 = camera2;
                if (camera2 != null) {
                    f = camera2.getScale();
                    doublePoint2 = Tranform2Piex20Utils.geo2PixelStandardScaleLevel(new GeoPoint((int) (((double) rectF2.top) * 1000000.0d), (int) (((double) rectF2.left) * 1000000.0d)), (DoublePoint) null);
                    doublePoint = Tranform2Piex20Utils.geo2PixelStandardScaleLevel(new GeoPoint((int) (((double) rectF2.bottom) * 1000000.0d), (int) (((double) rectF2.right) * 1000000.0d)), (DoublePoint) null);
                } else {
                    doublePoint = doublePoint4;
                    doublePoint2 = doublePoint3;
                    f = 1.0f;
                }
                if (f > 4.0f) {
                    f = 4.0f;
                }
                while (true) {
                    if (f < 3.0517578E-5f) {
                        f2 = l;
                        f3 = m;
                        camera = null;
                        break;
                    }
                    RectF rectF = new RectF();
                    if (camera2 != null) {
                        double d = (double) f;
                        f2 = l;
                        f3 = m;
                        rectF = new RectF((float) Math.min(doublePoint2.f24753x * d, doublePoint.f24753x * d), (float) Math.min(doublePoint.f24754y * d, doublePoint2.f24754y * d), (float) Math.max(doublePoint2.f24753x * d, doublePoint.f24753x * d), (float) Math.max(doublePoint.f24754y * d, doublePoint2.f24754y * d));
                    } else {
                        f2 = l;
                        f3 = m;
                    }
                    for (IMapElement pixel20Bound : list2) {
                        RectF pixel20Bound2 = pixel20Bound.getPixel20Bound(f);
                        if (pixel20Bound2 != null) {
                            if (rectF.left == 0.0f) {
                                rectF.left = pixel20Bound2.left;
                            }
                            if (rectF.top == 0.0f) {
                                rectF.top = pixel20Bound2.top;
                            }
                            if (rectF.right == 0.0f) {
                                rectF.right = pixel20Bound2.right;
                            }
                            if (rectF.bottom == 0.0f) {
                                rectF.bottom = pixel20Bound2.bottom;
                            }
                            if (rectF.left > pixel20Bound2.left) {
                                rectF.left = pixel20Bound2.left;
                            }
                            if (rectF.top > pixel20Bound2.top) {
                                rectF.top = pixel20Bound2.top;
                            }
                            if (rectF.right < pixel20Bound2.right) {
                                rectF.right = pixel20Bound2.right;
                            }
                            if (rectF.bottom < pixel20Bound2.bottom) {
                                rectF.bottom = pixel20Bound2.bottom;
                            }
                        }
                    }
                    if (Math.abs(rectF.width()) >= width || Math.abs(rectF.height()) >= height) {
                        f /= GLBaseMapView.f23835q;
                        l = f2;
                        m = f3;
                    } else {
                        LatLng a = GLBaseMapView.this.m16932a(rectF, rect3, f);
                        camera = new Camera(a, f, 0.0f, 0.0f);
                        camera.setScale(f);
                        if (a != null) {
                            camera.setCenter(a);
                        }
                    }
                }
                float f4 = f2;
                float unused3 = GLBaseMapView.this.f23873ai = f4;
                float f5 = f3;
                float unused4 = GLBaseMapView.this.f23874aj = f5;
                GLBaseMapView.this.f23894x.setCenterOffset(f4 - 0.5f, f5 - 0.5f);
                return camera;
            }
        }));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public LatLng m16932a(RectF rectF, Rect rect, float f) {
        if (rectF == null) {
            return null;
        }
        if (((double) Math.abs(this.f23873ai - 0.5f)) > f23831m || ((double) Math.abs(this.f23874aj - 0.5f)) > f23831m) {
            int i = rect.left + (((this.f23840B - rect.left) - rect.right) / 2);
            int i2 = rect.top + (((this.f23841C - rect.top) - rect.bottom) / 2);
            float f2 = (((float) i) * 1.0f) / ((float) this.f23840B);
            float f3 = (((float) i2) * 1.0f) / ((float) this.f23841C);
            if (((double) Math.abs(f2 - this.f23873ai)) <= f23831m && ((double) Math.abs(f3 - this.f23874aj)) <= f23831m) {
                return Tranform2Piex20Utils.pixel20ToLatlng(new DoublePoint((double) (rectF.centerX() / f), (double) (rectF.centerY() / f)), (LatLng) null);
            }
            return Tranform2Piex20Utils.pixel20ToLatlng(new DoublePoint((double) ((rectF.centerX() - (((float) this.f23840B) * (this.f23873ai - f2))) / f), (double) ((rectF.centerY() - (((float) this.f23841C) * (this.f23874aj - f3))) / f)), (LatLng) null);
        } else if (rect == null) {
            return null;
        } else {
            double centerX = ((double) rectF.centerX()) - (((double) (rect.left - rect.right)) * 0.5d);
            double d = (double) f;
            return Tranform2Piex20Utils.pixel20ToLatlng(new DoublePoint(centerX / d, (((double) rectF.centerY()) + (((double) (rect.top - rect.bottom)) * 0.5d)) / d), (LatLng) null);
        }
    }

    public float calculateNavigationZoom(float f, float f2, float f3, float f4, LatLng latLng, LatLng latLng2) {
        final float f5 = f2;
        final float f6 = f;
        final LatLng latLng3 = latLng;
        final float f7 = f3;
        final float f8 = f4;
        final LatLng latLng4 = latLng2;
        Float f9 = (Float) futureGet(get(new Callable<Float>() {
            public Float call() {
                float skew = GLBaseMapView.this.f23894x.getSkew();
                float rotate = GLBaseMapView.this.f23894x.getRotate();
                double scale = GLBaseMapView.this.f23894x.getScale();
                LatLng center = GLBaseMapView.this.f23894x.getCenter();
                GLBaseMapView.this.f23894x.skewTo(f5);
                GLBaseMapView.this.f23894x.rotateTo(f6);
                GLBaseMapView.this.f23894x.moveTo(latLng3);
                GLBaseMapView.this.f23894x.setEdgePaddingOffset(0.0f, f7, 0.0f, f8);
                float zoomForNavigation = GLBaseMapView.this.f23894x.zoomForNavigation(latLng4);
                GLBaseMapView.this.f23894x.skewTo(skew);
                GLBaseMapView.this.f23894x.rotateTo(rotate);
                GLBaseMapView.this.f23894x.scaleTo(scale);
                GLBaseMapView.this.f23894x.moveTo(center);
                return Float.valueOf(zoomForNavigation);
            }
        }));
        if (f9 != null) {
            return f9.floatValue();
        }
        return 0.0f;
    }

    public void setLanguage(final int i) {
        if (this.f23845G != i) {
            this.f23845G = i;
            MapGlobal.curLanguage = i;
            final Prefs prefs = getMapContext().getResources().getPrefs();
            set(new RenderTask() {
                public void run() {
                    GLBaseMapView.this.f23894x.setNeedDisplay();
                    GLBaseMapView.this.f23894x.resetMapPath(i, GLBaseMapView.this.f23885f, prefs.getMapPath4Language(i), GLBaseMapView.this.f23850L);
                }
            });
        }
    }

    public int getTheme() {
        return this.f23846H;
    }

    public void setTheme(final int i) {
        if (this.f23846H != i) {
            this.f23846H = i;
            HWLog.m16761i("setTheme", "mapv2 theme = " + i);
            set(new RenderTask() {
                public void run() {
                    GLBaseMapView.this.f23894x.setNeedDisplay();
                    GLBaseMapView.this.f23894x.setMapTheme(i);
                }
            });
        }
    }

    public void setBlockInfo(int i, long j, List<LatLng> list, List<OutBlockInfo> list2) {
        final int i2 = i;
        final long j2 = j;
        final List<LatLng> list3 = list;
        final List<OutBlockInfo> list4 = list2;
        set(new RenderTask() {
            public void run() {
                GLBaseMapView.this.f23894x.setBlockInfo(i2, j2, list3, list4);
            }
        });
    }

    public void showFishBoneGrayBubbleOnly(final boolean z) {
        set(new RenderTask() {
            public void run() {
                GLBaseMapView.this.f23894x.showFishBoneGrayBubbleOnly(z);
            }
        });
    }

    public int getLanguage() {
        return this.f23845G;
    }

    /* renamed from: g */
    private int[] m16960g() {
        int i = this.f23864Z;
        if (i == 9 || i == 11) {
            return f23837s;
        }
        if (i == 8 || i == 6) {
            return f23838t;
        }
        return f23836r;
    }

    public void setAnimator(Animator animator) {
        super.setAnimator(animator);
        if (this.mViewManager.getFps() != 1) {
            this.f23879ao = this.mViewManager.getFps();
        }
        animator.addListener(new Animator.AnimatorListener() {
            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
                GLBaseMapView.this.mViewManager.setFps(1);
            }

            public void onAnimationEnd(Animator animator) {
                GLBaseMapView.this.mViewManager.setFps(GLBaseMapView.this.f23879ao);
            }

            public void onAnimationCancel(Animator animator) {
                GLBaseMapView.this.mViewManager.setFps(GLBaseMapView.this.f23879ao);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onAdded() {
        DisplayMetrics displayMetrics;
        super.onAdded();
        DisplayMetrics displayMetrics2 = DeviceUtils.getDisplayMetrics(this.mMapContext.getAndroidContext());
        C9183c cVar = new C9183c(this);
        this.f23894x.createEngineContext();
        this.f23894x.setDynamicConfigProvider(this.f23848J);
        this.f23894x.setUseVulkan(this.f23859U);
        this.f23843E.setUseStyleV2(this.f23894x.isUseStyleV2());
        DisplayMetrics displayMetrics3 = displayMetrics2;
        if (this.f23894x.create(displayMetrics2.density, this.f23885f, this.f23849K, this.f23850L, this.f23851M, this.f23852N, m16960g(), displayMetrics2.density, this.f23853O, this.f23845G, this.f23846H, cVar, this.f23847I, this.f23875ak)) {
            MapGlobal.curLanguage = this.f23845G;
            Prefs prefs = getMapContext().getResources().getPrefs();
            MapEngine mapEngine = this.f23894x;
            int i = this.f23845G;
            mapEngine.resetMapPath(i, this.f23885f, prefs.getMapPath4Language(i), this.f23850L);
            synchronized (this) {
                if (this.f23868ad != null) {
                    this.f23868ad.onCreate();
                    this.f23868ad = null;
                }
                this.f23842D = true;
            }
            OnBaseMapCreateCallback onBaseMapCreateCallback = this.f23867ac;
            if (onBaseMapCreateCallback != null) {
                onBaseMapCreateCallback.onCreate();
            }
            this.f23894x.setMaxScaleLevel(this.f23854P);
            this.f23894x.setMinScaleLevel(this.f23856R);
            int mapMode = this.f23843E.getMapMode();
            this.f23864Z = mapMode;
            this.f23894x.setMapMode(mapMode);
            final int i2 = this.f23864Z;
            getMainHandler().post(new Runnable() {
                public void run() {
                    if (GLBaseMapView.this.f23863Y != null) {
                        GLBaseMapView.this.f23863Y.onMapModeChange(i2);
                    }
                }
            });
            if (this.f23843E.isUseStyleV2) {
                this.f23894x.setShowTraffic(this.f23843E.isTraffic);
            }
            if (!(this.f23894x == null || this.f23843E == null)) {
                HwDLog.m16764d("init map ", "isDynamicLayerEnable" + this.f23843E.isDynamicLayerEnable, new Object[0]);
                this.f23894x.setShowDynamicLayer(this.f23843E.isDynamicLayerEnable);
            }
            if (this.f23866ab) {
                this.f23894x.setViewPort(0, 0, this.f23840B, this.f23841C);
                displayMetrics = displayMetrics3;
                this.f23894x.setViewDPI(displayMetrics.xdpi, displayMetrics.ydpi, displayMetrics.widthPixels, displayMetrics.heightPixels);
                Tranform2Piex20Utils.init(this.f23894x.getLevelPointPerMeter(displayMetrics.density));
                this.f23866ab = false;
                mo69791c();
            } else {
                displayMetrics = displayMetrics3;
            }
            if (ApolloHawaii.HWBUSSThresholdOpen) {
                this.f23894x.SetHWBussThresholdOpen(true, (float) ((int) ((((float) ApolloHawaii.HWBUSSThreshold) * displayMetrics.density) + 0.5f)));
            }
            this.f23894x.scaleTo((double) this.f23884e.getScale());
            this.f23894x.moveTo(this.f23884e.getCenter());
            this.f23894x.setMapPadding(this.f23878an);
            this.f23894x.setCompassVisible(this.f23865aa);
            TextureThread textureThread = new TextureThread();
            this.f23896z = textureThread;
            textureThread.start();
            this.f23839A = true;
            this.f23894x.setMJOCallback(this.f23860V);
            this.f23894x.setBlockEventCallback(this.f23861W);
            getMainHandler().postDelayed(this.f23876al, 200);
        }
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        getMainHandler().removeCallbacks(this.f23876al);
        this.f23894x.destroy();
    }

    public void onFrameFinish(boolean z) {
        float scaleLevel = getScaleLevel();
        ScaleRulerUpdateCallback scaleRulerUpdateCallback = this.f23862X;
        if (scaleRulerUpdateCallback != null && this.f23844F != scaleLevel) {
            this.f23844F = scaleLevel;
            scaleRulerUpdateCallback.onUpdate(this.f23844F, this.f23894x.calculateScaleRuler(this.f23841C));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo69782a(MapEngine mapEngine) {
        this.f23894x = mapEngine;
        this.f23883d = new BaseMapDataImpl();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo69788b() {
        getMainHandler().removeCallbacks(this.f23876al);
        this.f23871ag = null;
    }

    /* access modifiers changed from: protected */
    public boolean onGesture(Gesture gesture) {
        MapEngine.TapItem tapItem;
        float x = gesture.getX();
        float y = gesture.getY();
        if (!super.onGesture(gesture)) {
            int type = gesture.getType();
            if (type == 0) {
                this.f23879ao = this.mViewManager.getFps();
                this.mViewManager.setFps(1);
                this.mViewManager.setFpsMode(1);
                BaseMapAllGestureListener baseMapAllGestureListener = this.f23872ah;
                if (baseMapAllGestureListener != null) {
                    baseMapAllGestureListener.onDown(x, y);
                }
            } else if (type == 1) {
                this.mViewManager.setFpsMode(2);
                if (this.mCurrentAnimator == null || !this.mCurrentAnimator.isRunning()) {
                    this.mViewManager.setFps(this.f23879ao);
                }
                BaseMapAllGestureListener baseMapAllGestureListener2 = this.f23872ah;
                if (baseMapAllGestureListener2 != null) {
                    baseMapAllGestureListener2.onUp(x, y);
                }
                return true;
            } else if (type == 2) {
                BaseMapAllGestureListener baseMapAllGestureListener3 = this.f23872ah;
                if (baseMapAllGestureListener3 != null) {
                    baseMapAllGestureListener3.onMove(x, y);
                }
                return true;
            } else if (type == 5) {
                BaseMapAllGestureListener baseMapAllGestureListener4 = this.f23872ah;
                if (baseMapAllGestureListener4 != null) {
                    baseMapAllGestureListener4.onTwoFingerDown();
                }
                return true;
            } else if (type == 6) {
                BaseMapAllGestureListener baseMapAllGestureListener5 = this.f23872ah;
                if (baseMapAllGestureListener5 != null) {
                    baseMapAllGestureListener5.onTwoFingerUp();
                }
                return false;
            } else if (type != 8) {
                switch (type) {
                    case 17:
                        BaseMapAllGestureListener baseMapAllGestureListener6 = this.f23872ah;
                        if (baseMapAllGestureListener6 != null) {
                            baseMapAllGestureListener6.onSingleTap(x, y);
                        }
                        if (!(this.f23871ag == null || (tapItem = (MapEngine.TapItem) gesture.getObj()) == null)) {
                            int i = tapItem.type;
                            if (i == 9) {
                                PoiEvent poiEvent = new PoiEvent();
                                poiEvent.f23897id = (long) tapItem.displayId;
                                poiEvent.name = tapItem.name;
                                poiEvent.type = 2;
                                poiEvent.poiUrl = tapItem.poiUrl;
                                this.f23871ag.onMapPoiClick(poiEvent);
                            } else if (i != 10) {
                                if (i != 99) {
                                    switch (i) {
                                        case 0:
                                            break;
                                        case 1:
                                        case 2:
                                            Poi poi = new Poi();
                                            poi.f23897id = (long) tapItem.displayId;
                                            poi.name = tapItem.name;
                                            poi.geo = tapItem.geo;
                                            poi.type = 0;
                                            poi.identity = tapItem.identity;
                                            poi.itemType = tapItem.itemType;
                                            this.f23871ag.onMapPoiClick(poi);
                                            break;
                                        case 3:
                                            this.f23871ag.onMapCompassClick();
                                            break;
                                        case 4:
                                        case 5:
                                            this.f23871ag.onGLOverlayViewClick(gesture.getGlOverlayView());
                                            break;
                                        case 6:
                                            this.f23871ag.onMapLocatorClick();
                                            break;
                                        case 7:
                                            PoiEvent poiEvent2 = new PoiEvent();
                                            poiEvent2.f23897id = (long) tapItem.displayId;
                                            poiEvent2.name = tapItem.name;
                                            poiEvent2.geo = tapItem.geo;
                                            poiEvent2.type = 1;
                                            poiEvent2.identity = tapItem.identity;
                                            poiEvent2.itemType = tapItem.itemType;
                                            poiEvent2.subIndex = tapItem.subIndex;
                                            this.f23871ag.onMapPoiClick(poiEvent2);
                                            break;
                                    }
                                }
                                this.f23871ag.onMapClick(tapItem.geo);
                            } else {
                                ExtendIcon extendIcon = new ExtendIcon();
                                extendIcon.identity = tapItem.identity;
                                extendIcon.outBype = tapItem.outArray;
                                extendIcon.type = 3;
                                extendIcon.itemType = tapItem.itemType;
                                extendIcon.geo = tapItem.geo;
                                this.f23871ag.onMapPoiClick(extendIcon);
                            }
                        }
                        return true;
                    case 18:
                        BaseMapAllGestureListener baseMapAllGestureListener7 = this.f23872ah;
                        if (baseMapAllGestureListener7 != null) {
                            baseMapAllGestureListener7.onLongPress(x, y);
                        }
                        if (this.f23871ag != null && (gesture.getObj() instanceof LatLng)) {
                            this.f23871ag.onMapLongClick((LatLng) gesture.getObj());
                        }
                        return true;
                    case 19:
                        if (!this.f23893w.isScrollGesturesEnabled()) {
                            return false;
                        }
                        BaseMapAllGestureListener baseMapAllGestureListener8 = this.f23872ah;
                        if (baseMapAllGestureListener8 != null) {
                            baseMapAllGestureListener8.onFling(x, y);
                        }
                        m16939a(gesture);
                        return true;
                    case 20:
                        float floatValue = ((Float) gesture.getObj()).floatValue();
                        BaseMapAllGestureListener baseMapAllGestureListener9 = this.f23872ah;
                        if (baseMapAllGestureListener9 != null) {
                            baseMapAllGestureListener9.onTwoFingerMoveVertical(floatValue);
                        }
                        setSkew(this.f23884e.getSkew() + gesture.getY());
                        return true;
                    case 21:
                        float floatValue2 = ((Float) gesture.getObj()).floatValue();
                        BaseMapAllGestureListener baseMapAllGestureListener10 = this.f23872ah;
                        if (baseMapAllGestureListener10 != null) {
                            baseMapAllGestureListener10.onTwoFingerRotate(gesture.preCenter, gesture.postCenter, floatValue2);
                        }
                        m16954c(this.f23884e.getRotate() + floatValue2, gesture.getX(), gesture.getY());
                        return true;
                    case 22:
                        BaseMapAllGestureListener baseMapAllGestureListener11 = this.f23872ah;
                        if (baseMapAllGestureListener11 != null) {
                            baseMapAllGestureListener11.onTwoFingerMoveAgainst(gesture.preCenter, gesture.postCenter, gesture.preVector, gesture.postVector);
                        }
                        float floatValue3 = ((Float) gesture.getObj()).floatValue();
                        float scale = this.f23884e.getScale();
                        if (!this.f23870af || !this.f23869ae) {
                            setScale(scale * floatValue3);
                        } else {
                            m16946b(scale * floatValue3, gesture.getX(), gesture.getY());
                        }
                        return true;
                    case 23:
                        BaseMapAllGestureListener baseMapAllGestureListener12 = this.f23872ah;
                        if (baseMapAllGestureListener12 != null) {
                            baseMapAllGestureListener12.onDoubleTap(x, y);
                        }
                        return true;
                    default:
                        switch (type) {
                            case 32:
                                m16945b(x, y);
                                return true;
                            case 33:
                                BaseMapAllGestureListener baseMapAllGestureListener13 = this.f23872ah;
                                if (baseMapAllGestureListener13 != null) {
                                    baseMapAllGestureListener13.onDoubleTapDown(x, y);
                                }
                                return true;
                            case 34:
                                BaseMapAllGestureListener baseMapAllGestureListener14 = this.f23872ah;
                                if (baseMapAllGestureListener14 != null) {
                                    baseMapAllGestureListener14.onDoubleTapUp(x, y);
                                }
                                return true;
                            case 35:
                                if (!this.f23893w.isZoomGesturesEnabled()) {
                                    return false;
                                }
                                BaseMapAllGestureListener baseMapAllGestureListener15 = this.f23872ah;
                                if (baseMapAllGestureListener15 != null) {
                                    baseMapAllGestureListener15.onDoubleTapMove(x, y);
                                }
                                setScale(getScale() * ((Float) gesture.getObj()).floatValue());
                                return true;
                            case 36:
                                BaseMapAllGestureListener baseMapAllGestureListener16 = this.f23872ah;
                                if (baseMapAllGestureListener16 != null) {
                                    baseMapAllGestureListener16.onTwoFingerSingleTap(x, y);
                                }
                                if (gesture.getObj() != null && (gesture.getObj() instanceof PointF)) {
                                    m16935a((PointF) gesture.getObj());
                                }
                                return true;
                            default:
                                return false;
                        }
                }
            } else if (!this.f23893w.isScrollGesturesEnabled()) {
                return false;
            } else {
                BaseMapAllGestureListener baseMapAllGestureListener17 = this.f23872ah;
                if (baseMapAllGestureListener17 != null) {
                    baseMapAllGestureListener17.onScroll(x, y);
                }
                ScaleRulerShowCallback scaleRulerShowCallback = this.f23863Y;
                if (scaleRulerShowCallback != null) {
                    scaleRulerShowCallback.onScaleChange();
                }
                m16953c(x * -1.0f, y * -1.0f);
                return true;
            }
        }
        return true;
    }

    /* renamed from: a */
    private void m16935a(PointF pointF) {
        float f = pointF.x;
        float f2 = pointF.y;
        if (!this.f23870af) {
            zoomOut(true, 250, (Animator.AnimatorListener) null);
        } else if (f == 0.0f && f2 == 0.0f) {
            zoomOut(true, 250, (Animator.AnimatorListener) null);
        } else {
            zoomByPoint(true, -1.0f, new Point((int) f, (int) f2), 250, (Animator.AnimatorListener) null);
        }
    }

    /* renamed from: b */
    private void m16945b(float f, float f2) {
        if (this.f23869ae) {
            zoomByPoint(true, 1.0f, new Point((int) f, (int) f2), 250, (Animator.AnimatorListener) null);
            return;
        }
        zoomIn(true, 250, (Animator.AnimatorListener) null);
    }

    /* renamed from: a */
    private void m16939a(Gesture gesture) {
        LatLng fromScreen;
        if (ApolloHawaii.openMapLoop) {
            m16949b(gesture);
            return;
        }
        float x = gesture.getX();
        float y = gesture.getY();
        float f = this.f23857S;
        double hypot = Math.hypot((double) (x / f), (double) (y / f));
        float f2 = this.f23857S;
        double d = (double) ((x / f2) * 0.75f);
        double d2 = (double) ((y / f2) * 0.75f);
        long j = (long) ((hypot / 7.0d) + 400.0d);
        PointF screen = this.f23892v.toScreen(getCenter());
        if (screen != null && (fromScreen = this.f23892v.fromScreen((float) (((double) screen.x) - d), (float) (((double) screen.y) - d2))) != null) {
            m16942a(true, fromScreen, j, (Animator.AnimatorListener) null, true);
        }
    }

    /* renamed from: b */
    private void m16949b(Gesture gesture) {
        float x = gesture.getX();
        float y = gesture.getY();
        final float f = x / 64.0f;
        final float f2 = y / 64.0f;
        if (f != 0.0f || f2 != 0.0f) {
            long max = Math.max(512, ((long) Math.max(Math.abs(x), Math.abs(y))) >> 3);
            GLAnimator gLAnimator = new GLAnimator();
            gLAnimator.setDuration(max);
            gLAnimator.setFloatValues(new float[]{0.0f, 1.0f});
            gLAnimator.setInterpolator(new LinearOutSlowInInterpolator());
            gLAnimator.setEvaluator(new FloatEvaluator());
            gLAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float animatedFraction = valueAnimator.getAnimatedFraction();
                    float f = f;
                    final float f2 = f - (f * animatedFraction);
                    float f3 = f2;
                    final float f4 = f3 - (animatedFraction * f3);
                    GLBaseMapView.this.set(new RenderTask() {
                        public void run() {
                            GLBaseMapView.this.f23894x.moveBy(f2, f4);
                            GLBaseMapView.this.f23884e.setCenter(GLBaseMapView.this.f23894x.getCenter());
                            GLBaseMapView.this.getMainHandler().post(new Runnable() {
                                public void run() {
                                    GLBaseMapView.this.mo69806f();
                                }
                            });
                        }
                    });
                }
            });
            setAnimator(gLAnimator);
            startAnimator();
        }
    }

    /* access modifiers changed from: protected */
    public void onHostSizeChanged(int i, int i2) {
        super.onHostSizeChanged(i, i2);
        if (this.f23840B != i || this.f23841C != i2) {
            if (this.f23839A) {
                this.f23894x.setViewPort(0, 0, i, i2);
                DisplayMetrics displayMetrics = DeviceUtils.getDisplayMetrics(this.mMapContext.getAndroidContext());
                this.f23894x.setViewDPI(displayMetrics.xdpi, displayMetrics.ydpi, displayMetrics.widthPixels, displayMetrics.heightPixels);
                Tranform2Piex20Utils.init(this.f23894x.getLevelPointPerMeter(displayMetrics.density));
                mo69791c();
            } else {
                this.f23866ab = true;
            }
            this.f23840B = i;
            this.f23841C = i2;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo69791c() {
        getMainHandler().post(new Runnable() {
            public void run() {
                if (GLBaseMapView.this.f23880ap != null && !GLBaseMapView.this.f23881aq) {
                    GLBaseMapView.this.f23880ap.onSurfaceChange();
                    boolean unused = GLBaseMapView.this.f23881aq = true;
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo69784a(Runnable runnable) {
        if (this.f23839A) {
            C9189i iVar = this.f23895y;
            if (iVar != null) {
                iVar.shutDownBlock();
            }
            this.f23896z.setReleaseTextureRunnable(runnable);
            this.f23896z.shutDownBlock();
        }
        this.f23839A = false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo69801d() {
        if (this.f23839A) {
            this.f23894x.resume();
            C9189i iVar = this.f23895y;
            if (iVar != null && this.f23858T) {
                iVar.resumeFromPause();
            }
            this.f23896z.resumeFromPause();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo69805e() {
        if (this.f23839A) {
            this.f23894x.pause();
            C9189i iVar = this.f23895y;
            if (iVar != null) {
                iVar.pause();
            }
            this.f23896z.pause();
        }
    }

    public BaseMapData getBaseMapData() {
        return this.f23883d;
    }

    public BaseMapAllGestureListener getGestureListener() {
        return this.f23872ah;
    }

    public int getMapMode() {
        return this.f23864Z;
    }

    public void setMapGestureListener(BaseMapAllGestureListener baseMapAllGestureListener) {
        this.f23872ah = baseMapAllGestureListener;
    }

    public void setGLBaseCallBack(BaseMapCallback baseMapCallback) {
        this.f23871ag = baseMapCallback;
    }

    public void setZoomInByTapCenter(boolean z) {
        this.f23869ae = z;
    }

    public void setZoomOutByTapCenter(boolean z) {
        this.f23870af = z;
    }

    public void setModeNavi(boolean z) {
        if (this.f23843E.isNavi != z) {
            boolean unused = this.f23843E.isNavi = z;
            m16934a(this.f23843E.getMapMode());
        }
    }

    public void setModeNight(boolean z) {
        if (this.f23843E.isNight != z) {
            boolean unused = this.f23843E.isNight = z;
            m16934a(this.f23843E.getMapMode());
        }
    }

    public void setTrafficEnabled(boolean z) {
        if (this.f23843E.isTraffic != z) {
            boolean unused = this.f23843E.isTraffic = z;
            m16934a(this.f23843E.getMapMode());
            m16941a(z);
        }
    }

    /* renamed from: a */
    private void m16934a(final int i) {
        if (this.f23864Z != i) {
            this.f23864Z = i;
            beginSetTransaction();
            set(new RenderTask() {
                public void run() {
                    GLBaseMapView.this.f23894x.setMapMode(i);
                }
            });
            int[] g = m16960g();
            setTrafficColors(g[1], g[2], g[0], g[3]);
            commitSetTransaction();
            BaseMapCallback baseMapCallback = this.f23871ag;
            if (baseMapCallback != null) {
                baseMapCallback.onMapModeChange(i);
            }
            ScaleRulerShowCallback scaleRulerShowCallback = this.f23863Y;
            if (scaleRulerShowCallback != null) {
                scaleRulerShowCallback.onMapModeChange(this.f23864Z);
            }
        }
    }

    /* renamed from: a */
    private void m16941a(final boolean z) {
        if (z) {
            if (this.f23895y == null) {
                C9189i iVar = new C9189i(this, this.f23882c);
                this.f23895y = iVar;
                iVar.start();
            }
            this.f23895y.resumeFromPause();
        } else {
            this.f23895y.pause();
        }
        this.f23858T = z;
        set(new RenderTask() {
            public void run() {
                GLBaseMapView.this.f23894x.setShowTraffic(z);
            }
        });
    }

    public void setTrafficColors(int i, int i2, int i3, int i4) {
        final int i5 = i;
        final int i6 = i2;
        final int i7 = i3;
        final int i8 = i4;
        set(new RenderTask() {
            public void run() {
                GLBaseMapView.this.f23894x.setTrafficColor(i5, i6, i7, i8);
            }
        });
    }

    public void setExtendEventData(final byte[] bArr) {
        set(new RenderTask() {
            public void run() {
                GLBaseMapView.this.f23894x.setExtendEventData(bArr);
            }
        });
    }

    public void setExtendIconVisible(final long j, final boolean z) {
        set(new RenderTask() {
            public void run() {
                GLBaseMapView.this.f23894x.setExtendIconVisible(j, z);
            }
        });
    }

    public void setPoiHidden(final int i, final LatLng latLng, final boolean z) {
        set(new RenderTask() {
            public void run() {
                GLBaseMapView.this.f23894x.setPoiHidden(i, latLng, z);
            }
        });
    }

    public void setPoiHidden(final BigInteger bigInteger, final boolean z) {
        set(new RenderTask() {
            public void run() {
                GLBaseMapView.this.f23894x.setPoiHidden(bigInteger, z);
            }
        });
    }

    public void showHiddenPoi() {
        set(new RenderTask() {
            public void run() {
                GLBaseMapView.this.f23894x.showHiddenPoi();
            }
        });
    }

    public void setExtendIconVisible(final boolean z) {
        set(new RenderTask() {
            public void run() {
                GLBaseMapView.this.f23894x.setExtendIconVisible(z);
            }
        });
    }

    public int getRenderExtendIconNumber() {
        Integer num = (Integer) futureGet(get(new Callable<Integer>() {
            public Integer call() throws Exception {
                return Integer.valueOf(GLBaseMapView.this.f23894x.getRenderExtendIconNumber());
            }
        }));
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public void setRestrictAreaVisible(final boolean z) {
        set(new RenderTask() {
            public void run() {
                GLBaseMapView.this.f23894x.setRestrictAreaVisible(z);
            }
        });
    }

    public void setMJOEnabled(final boolean z) {
        set(new RenderTask() {
            public void run() {
                GLBaseMapView.this.f23894x.setMJOEnabled(z);
            }
        });
    }

    public LatLng[] loadMJOAndGetBindRoute(long j, int i, byte[] bArr, long[] jArr, int[] iArr, double[] dArr, int i2, long j2) {
        GLViewParent parent = getParent();
        if (parent == null) {
            return null;
        }
        final long j3 = j;
        final int i3 = i;
        final byte[] bArr2 = bArr;
        final long[] jArr2 = jArr;
        final int[] iArr2 = iArr;
        final double[] dArr2 = dArr;
        final int i4 = i2;
        final long j4 = j2;
        return (LatLng[]) futureGet(parent.postToRenderThread(new Callable<LatLng[]>() {
            public LatLng[] call() {
                return GLBaseMapView.this.f23894x.loadMJOAndGetBindRoute(j3, i3, bArr2, jArr2, iArr2, dArr2, i4, j4);
            }
        }));
    }

    public void setVioParkingRegionData(final byte[] bArr, final int i) {
        set(new RenderTask() {
            public void run() {
                GLBaseMapView.this.f23894x.setVioParkingRegionData(bArr, i);
            }
        });
    }

    public void showMJO() {
        set(new RenderTask() {
            public void run() {
                GLBaseMapView.this.f23894x.showMJO();
            }
        });
        this.f23893w.setAllGesturesEnabled(false);
    }

    public void hideMJO(final boolean z) {
        set(new RenderTask() {
            public void run() {
                GLBaseMapView.this.f23894x.hideMJO(z);
            }
        });
    }

    public void clearMJORouteInfo() {
        set(new RenderTask() {
            public void run() {
                GLBaseMapView.this.f23894x.clearMJORouteInfo();
            }
        });
    }

    public void setBubbleEdgePadding(final float f) {
        set(new RenderTask() {
            public void run() {
                GLBaseMapView.this.f23894x.setBubbleEdgePaddingTop(f);
            }
        });
    }

    public void setTrafficEventData(final byte[] bArr) {
        set(new RenderTask() {
            public void run() {
                GLBaseMapView.this.f23894x.setTrafficEventData(bArr);
            }
        });
    }

    public void hideTrafficEventExcludeClosure(final boolean z) {
        set(new RenderTask() {
            public void run() {
                GLBaseMapView.this.f23894x.hideTrafficEventExcludeClosure(z);
            }
        });
    }

    public void clearTrafficEventData() {
        set(new RenderTask() {
            public void run() {
                GLBaseMapView.this.f23894x.clearTrafficEventData();
            }
        });
    }

    public void updateLocalTrafficIcon(final TrafficEventModel[] trafficEventModelArr) {
        set(new RenderTask() {
            public void run() {
                GLBaseMapView.this.f23894x.updateTrafficLocalIcon(trafficEventModelArr);
            }
        });
    }

    public void updateTrafficItemState(final BigInteger bigInteger, final short s, final boolean z) {
        set(new RenderTask() {
            public void run() {
                GLBaseMapView.this.f23894x.updateTrafficItemState(bigInteger, s, z);
            }
        });
    }

    public List<TrafficEventRoutePoint> getTrafficEventRoutePointInfo() {
        TrafficEventRoutePoint[] trafficEventRoutePointArr;
        GLViewParent parent = getParent();
        if (parent == null || (trafficEventRoutePointArr = (TrafficEventRoutePoint[]) futureGet(parent.postToRenderThread(new Callable<TrafficEventRoutePoint[]>() {
            public TrafficEventRoutePoint[] call() {
                return GLBaseMapView.this.f23894x.getTrafficEventRoutePointInfo();
            }
        }))) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (TrafficEventRoutePoint trafficEventRoutePoint : trafficEventRoutePointArr) {
            if (trafficEventRoutePoint.accessType == 1) {
                arrayList.add(trafficEventRoutePoint);
            }
        }
        return arrayList;
    }

    public List<TrafficEventRoutePoint> getTrafficEventsPointInfo() {
        TrafficEventRoutePoint[] trafficEventRoutePointArr;
        GLViewParent parent = getParent();
        if (parent == null || (trafficEventRoutePointArr = (TrafficEventRoutePoint[]) futureGet(parent.postToRenderThread(new Callable<TrafficEventRoutePoint[]>() {
            public TrafficEventRoutePoint[] call() {
                return GLBaseMapView.this.f23894x.getTrafficEventRoutePointInfo();
            }
        }))) == null) {
            return null;
        }
        return Arrays.asList(trafficEventRoutePointArr);
    }

    public byte[] genVecEnlargePNGImage(byte[] bArr, long j) {
        return this.f23894x.genVecEnlargePNGImage(bArr, j, m16961h());
    }

    public boolean setVecEnlargeData(String str, byte[] bArr, long j) {
        Boolean bool;
        final float h = m16961h();
        final String str2 = str;
        final byte[] bArr2 = bArr;
        final long j2 = j;
        Future future = get(new Callable<Boolean>() {
            public Boolean call() throws Exception {
                return Boolean.valueOf(GLBaseMapView.this.f23894x.setVecEnlargeData(str2, bArr2, j2, h));
            }
        });
        if (future == null || (bool = (Boolean) futureGet(future)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public boolean setVecEnlargeIsVisible(final String str, final boolean z) {
        Boolean bool;
        Future future = get(new Callable<Boolean>() {
            public Boolean call() throws Exception {
                return Boolean.valueOf(GLBaseMapView.this.f23894x.setVecEnlargeIsVisible(str, z));
            }
        });
        if (future == null || (bool = (Boolean) futureGet(future)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public boolean destroyNewVecEnlarge(final String str) {
        Boolean bool;
        Future future = get(new Callable<Boolean>() {
            public Boolean call() throws Exception {
                return Boolean.valueOf(GLBaseMapView.this.f23894x.destroyNewVecEnlarge(str));
            }
        });
        if (future == null || (bool = (Boolean) futureGet(future)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* renamed from: h */
    private float m16961h() {
        WindowManager windowManager = (WindowManager) getMapContext().getAndroidContext().getSystemService("window");
        if (EnlargPicSetting.whRatio >= 0.0f) {
            return EnlargPicSetting.whRatio;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return ((float) displayMetrics.widthPixels) / ((float) displayMetrics.heightPixels);
    }

    public void setVecEnlargeVisibleArea(int i, int i2, int i3, int i4, float f) {
        final int i5 = i;
        final int i6 = i2;
        final int i7 = i3;
        final int i8 = i4;
        final float f2 = f;
        set(new RenderTask() {
            public void run() {
                GLBaseMapView.this.f23894x.setVecEnlargeVisibleArea(i5, i6, i7, i8, f2);
            }
        });
    }

    public void destroyAllVecEnlarge() {
        set(new RenderTask() {
            public void run() {
                GLBaseMapView.this.f23894x.destroyAllVecEnlarge();
            }
        });
    }

    public void setTrafficEventIconCustomSize(final int i) {
        set(new RenderTask() {
            public void run() {
                GLBaseMapView.this.f23894x.setTrafficEventIconCustomSize(i);
            }
        });
    }

    public void resetTrafficEventIconCustomSize() {
        set(new RenderTask() {
            public void run() {
                GLBaseMapView.this.f23894x.resetTrafficEventIconCustomSize();
            }
        });
    }

    public void clearTrafficLocalIcons() {
        set(new RenderTask() {
            public void run() {
                GLBaseMapView.this.f23894x.clearTrafficLocalIcons();
            }
        });
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0021, code lost:
        if (r8 < r0) goto L_0x001b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setScale(final float r8) {
        /*
            r7 = this;
            boolean r0 = java.lang.Float.isNaN(r8)
            if (r0 == 0) goto L_0x0015
            r1 = 5
            r4 = 0
            r6 = 2170(0x87a, float:3.041E-42)
            java.lang.String r2 = "GLBaseMapView"
            java.lang.String r3 = "setScale: scale is NaN"
            java.lang.String r5 = "com.didi.hawaii.mapsdkv2.core.GLBaseMapView"
            com.didi.sdk.apm.SystemUtils.log(r1, r2, r3, r4, r5, r6)
            return
        L_0x0015:
            float r0 = r7.f23886g
            int r1 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r1 <= 0) goto L_0x001d
        L_0x001b:
            r8 = r0
            goto L_0x0024
        L_0x001d:
            float r0 = r7.f23887h
            int r1 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r1 >= 0) goto L_0x0024
            goto L_0x001b
        L_0x0024:
            com.didi.hawaii.mapsdkv2.core.Camera r0 = r7.f23884e
            float r0 = r0.getScale()
            int r0 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r0 == 0) goto L_0x0045
            com.didi.hawaii.mapsdkv2.core.Camera r0 = r7.f23884e
            r0.setScale(r8)
            com.didi.hawaii.mapsdkv2.core.GLBaseMapView$50 r0 = new com.didi.hawaii.mapsdkv2.core.GLBaseMapView$50
            r0.<init>(r8)
            r7.set(r0)
            r7.mo69806f()
            com.didi.hawaii.mapsdkv2.core.GLBaseMapView$ScaleRulerShowCallback r8 = r7.f23863Y
            if (r8 == 0) goto L_0x0045
            r8.onScaleChange()
        L_0x0045:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.hawaii.mapsdkv2.core.GLBaseMapView.setScale(float):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0015, code lost:
        if (r7 < r0) goto L_0x000f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setScaleByFixPos(final float r7, final com.didi.map.outer.model.LatLng r8) {
        /*
            r6 = this;
            boolean r0 = java.lang.Float.isNaN(r7)
            if (r0 != 0) goto L_0x003a
            if (r8 != 0) goto L_0x0009
            goto L_0x003a
        L_0x0009:
            float r0 = r6.f23886g
            int r1 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r1 <= 0) goto L_0x0011
        L_0x000f:
            r7 = r0
            goto L_0x0018
        L_0x0011:
            float r0 = r6.f23887h
            int r1 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r1 >= 0) goto L_0x0018
            goto L_0x000f
        L_0x0018:
            com.didi.hawaii.mapsdkv2.core.Camera r0 = r6.f23884e
            float r0 = r0.getScale()
            int r0 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r0 == 0) goto L_0x0039
            com.didi.hawaii.mapsdkv2.core.Camera r0 = r6.f23884e
            r0.setScale(r7)
            com.didi.hawaii.mapsdkv2.core.GLBaseMapView$51 r0 = new com.didi.hawaii.mapsdkv2.core.GLBaseMapView$51
            r0.<init>(r8, r7)
            r6.set(r0)
            r6.mo69806f()
            com.didi.hawaii.mapsdkv2.core.GLBaseMapView$ScaleRulerShowCallback r7 = r6.f23863Y
            if (r7 == 0) goto L_0x0039
            r7.onScaleChange()
        L_0x0039:
            return
        L_0x003a:
            r0 = 5
            r3 = 0
            r5 = 2200(0x898, float:3.083E-42)
            java.lang.String r1 = "GLBaseMapView"
            java.lang.String r2 = "setScale: scale is NaN"
            java.lang.String r4 = "com.didi.hawaii.mapsdkv2.core.GLBaseMapView"
            com.didi.sdk.apm.SystemUtils.log(r0, r1, r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.hawaii.mapsdkv2.core.GLBaseMapView.setScaleByFixPos(float, com.didi.map.outer.model.LatLng):void");
    }

    public void setSkew(final float f) {
        if (f <= this.f23855Q && f >= 0.0f) {
            if (Float.compare(f, 0.2f) < 0) {
                f = 0.0f;
            }
            if (this.f23884e.getSkew() != f) {
                this.f23884e.setSkew(f);
                set(new RenderTask() {
                    public void run() {
                        GLBaseMapView.this.f23894x.skewTo(f);
                    }
                });
                mo69806f();
            }
        }
    }

    public void setMaxSkew(float f) {
        this.f23855Q = f;
        if (this.f23884e.getSkew() > this.f23855Q) {
            setSkew(f);
        }
    }

    public float getMaxSkew() {
        return this.f23855Q;
    }

    public void setRotate(float f) {
        final float normalizeRotate = MapTransform.normalizeRotate(f);
        if (this.f23884e.getRotate() != normalizeRotate) {
            this.f23884e.setRotate(normalizeRotate);
            set(new RenderTask() {
                public void run() {
                    GLBaseMapView.this.f23894x.rotateTo(normalizeRotate);
                }
            });
            mo69806f();
        }
    }

    public void setCenter(final LatLng latLng) {
        if (!latLng.equals(this.f23884e.getCenter())) {
            this.f23884e.setCenter(latLng);
            set(new RenderTask() {
                public void run() {
                    GLBaseMapView.this.f23894x.moveTo(latLng);
                }
            });
            mo69806f();
        }
    }

    public void setMapPadding(int i, int i2, int i3, int i4) {
        if (i != this.f23878an.left || i2 != this.f23878an.top || i3 != this.f23878an.right || i4 != this.f23878an.bottom) {
            this.f23878an.left = i;
            this.f23878an.top = i2;
            this.f23878an.right = i3;
            this.f23878an.bottom = i4;
        }
    }

    public void setNavigationLineMargin(float f, float f2, float f3, float f4) {
        final float f5 = f;
        final float f6 = f2;
        final float f7 = f3;
        final float f8 = f4;
        set(new RenderTask() {
            public void run() {
                GLBaseMapView.this.f23894x.setNavigationLineMargin(f5, f6, f7, f8);
            }
        });
    }

    public void setCenterOffset(final float f, final float f2) {
        if (this.f23873ai != f || this.f23874aj != f2) {
            this.f23873ai = f;
            this.f23874aj = f2;
            set(new RenderTask() {
                public void run() {
                    GLBaseMapView.this.f23894x.setCenterOffset(f - 0.5f, f2 - 0.5f);
                }
            });
        }
    }

    public void setDrawPillarWith2DStyle(final boolean z) {
        set(new RenderTask() {
            public void run() {
                GLBaseMapView.this.f23894x.setDrawPillarWith2DStyle(z);
            }
        });
    }

    public int setIsInternationalWMS(final boolean z) {
        Integer num = (Integer) futureGet(get(new Callable<Integer>() {
            public Integer call() throws Exception {
                return Integer.valueOf(GLBaseMapView.this.f23894x.setIsInternationalWms(z));
            }
        }));
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    public void setAnnotationShowLight(final boolean z) {
        set(new RenderTask() {
            public void run() {
                GLBaseMapView.this.f23894x.setAnnotationShowLight(z);
            }
        });
    }

    public void setPoiMarkerRect(final Rect[] rectArr) {
        set(new RenderTask() {
            public void run() {
                GLBaseMapView.this.f23894x.setPoiMarkerRect(rectArr);
            }
        });
    }

    public void setAboardPointJson(final String str) {
        set(new RenderTask() {
            public void run() {
                GLBaseMapView.this.f23894x.setAboardPointJson(str);
            }
        });
    }

    public boolean isCompassVisible() {
        return this.f23865aa;
    }

    public void setCompassVisible(final boolean z) {
        if (this.f23865aa != z) {
            this.f23865aa = z;
            set(new RenderTask() {
                public void run() {
                    GLBaseMapView.this.f23894x.setCompassVisible(GLBaseMapView.this.m16964i() && z);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public boolean m16964i() {
        return ((double) Math.abs(this.f23884e.getSkew())) > 1.0E-6d || Math.abs(this.f23884e.getRotate()) > 1.0f;
    }

    public GLLocator getLocator() {
        return this.f23877am;
    }

    public GLUiSetting getUiSetting() {
        return this.f23893w;
    }

    public String getCityName(final LatLng latLng) {
        return (String) futureGet(get(new Callable<String>() {
            public String call() {
                return GLBaseMapView.this.f23894x.getCityName(latLng);
            }
        }));
    }

    public Bitmap screenShots(final Bitmap.Config config) {
        return (Bitmap) futureGet(get(new Callable<Bitmap>() {
            public Bitmap call() throws Exception {
                return GLBaseMapView.this.f23894x.screenShot(GLBaseMapView.this.f23840B, GLBaseMapView.this.f23841C, config);
            }
        }));
    }

    public void setRouteNameVisible(final boolean z) {
        set(new RenderTask() {
            public void run() {
                GLBaseMapView.this.f23894x.setRouteNameVisible(z);
            }
        });
    }

    public void clearRouteNameSegments() {
        set(new RenderTask() {
            public void run() {
                GLBaseMapView.this.f23894x.clearRouteNameSegments();
            }
        });
    }

    public void showTrafficEvent(final boolean z) {
        set(new RenderTask() {
            public void run() {
                GLBaseMapView.this.f23894x.showTrafficEvent(z);
            }
        });
    }

    public void setZhongYanEventData(final byte[] bArr, final long j) {
        set(new RenderTask() {
            public void run() {
                GLBaseMapView.this.f23894x.setZhongYanEventData(bArr, j);
            }
        });
    }

    public void setUseLowMemoryMode(final boolean z) {
        set(new RenderTask() {
            public void run() {
                GLBaseMapView.this.f23894x.setUseLowMemoryMode(z);
            }
        });
    }

    public void setSurfaceChangeListener(final SurfaceChangeListener surfaceChangeListener) {
        set(new RenderTask() {
            public void run() {
                SurfaceChangeListener unused = GLBaseMapView.this.f23880ap = surfaceChangeListener;
                if (GLBaseMapView.this.f23840B != 0 && GLBaseMapView.this.f23841C != 0) {
                    GLBaseMapView.this.mo69791c();
                }
            }
        });
    }

    public void removeRouteName(final long j) {
        set(new RenderTask() {
            public void run() {
                GLBaseMapView.this.f23894x.removeRouteName(j);
            }
        });
    }

    public void addMultipleRouteNameSegments(long j, RouteName[] routeNameArr, LatLng[] latLngArr, int i, int i2, String str, String str2, int i3, int i4) {
        final long j2 = j;
        final RouteName[] routeNameArr2 = routeNameArr;
        final LatLng[] latLngArr2 = latLngArr;
        final int i5 = i;
        final int i6 = i2;
        final String str3 = str;
        final String str4 = str2;
        final int i7 = i3;
        final int i8 = i4;
        set(new RenderTask() {
            public void run() {
                GLBaseMapView.this.f23894x.addMultipleRouteNames(j2, routeNameArr2, latLngArr2, i5, i6, str3, str4, i7, i8);
            }
        });
    }

    public void setClipArea(final int i, final int i2, final int i3) {
        if (i >= 0) {
            set(new RenderTask() {
                public void run() {
                    GLBaseMapView.this.f23894x.setClipArea(i, i2, i3);
                }
            });
        }
    }

    public void addSpecialBubble(RouteName[] routeNameArr, LatLng[] latLngArr, long j, int i) {
        final RouteName[] routeNameArr2 = routeNameArr;
        final LatLng[] latLngArr2 = latLngArr;
        final long j2 = j;
        final int i2 = i;
        set(new RenderTask() {
            public void run() {
                GLBaseMapView.this.f23894x.addSpecialBubble(routeNameArr2, latLngArr2, j2, i2);
            }
        });
    }

    public void updateSpecialBubble(final RouteName[] routeNameArr, final long j) {
        set(new RenderTask() {
            public void run() {
                GLBaseMapView.this.f23894x.updateSpecialBubble(routeNameArr, j);
            }
        });
    }

    public void removeSpecialBubble(final long j) {
        set(new RenderTask() {
            public void run() {
                GLBaseMapView.this.f23894x.removeSpecialBubble(j);
            }
        });
    }

    public void deleteSpecialBubbleWithType(final int i) {
        set(new RenderTask() {
            public void run() {
                GLBaseMapView.this.f23894x.deleteSpecialBubbleWithType(i);
            }
        });
    }

    public void addBubble(Bubble bubble) {
        final long id = bubble.getId();
        final int type = bubble.getType();
        final int collisionType = bubble.getCollisionType();
        final double longitude = bubble.getLongitude();
        final double latitude = bubble.getLatitude();
        final boolean isAvoidAnnocation = bubble.getMarkerOptions().isAvoidAnnocation();
        final int i = bubble.getzIndex();
        final int priority = bubble.getPriority();
        final boolean isVirtual = bubble.isVirtual();
        final boolean isNeedSelectBottomRect = bubble.isNeedSelectBottomRect();
        String showInfo = bubble.getShowInfo();
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        String str = showInfo;
        while (i2 < bubble.getOverlayRectCnt()) {
            arrayList.add(bubble.getOverlayRect(i2));
            i2++;
            isNeedSelectBottomRect = isNeedSelectBottomRect;
        }
        Bubble bubble2 = bubble;
        boolean z = isNeedSelectBottomRect;
        final Bubble.PointArea pointArea = bubble.getPointArea();
        final Bubble.TrafficIconAttrs trafficIconAttrs = bubble.getTrafficIconAttrs();
        final AnimationSetting animatiomSetting = bubble.getAnimatiomSetting();
        C910478 r22 = r0;
        final String str2 = str;
        final ArrayList arrayList2 = arrayList;
        C910478 r0 = new RenderTask(this) {
            final /* synthetic */ GLBaseMapView this$0;

            {
                this.this$0 = r4;
            }

            public void run() {
                this.this$0.f23894x.addBubble(id, type, collisionType, longitude, latitude, 1.0f, 1.0f, 0, 0, 0.0f, true, true, isAvoidAnnocation, true, i, priority, 1.0f, true, isVirtual, isNeedSelectBottomRect, str2, arrayList2, pointArea, trafficIconAttrs, animatiomSetting);
            }
        };
        set(r22);
    }

    public void removeBubble(final long j) {
        set(new RenderTask() {
            public void run() {
                GLBaseMapView.this.f23894x.removeBubble(j);
            }
        });
    }

    public void removeRemoteBubble(final long j) {
        set(new RenderTask() {
            public void run() {
                GLBaseMapView.this.f23894x.removeRemoteBubble(j);
            }
        });
    }

    public void updateBubble(Bubble bubble) {
        final long id = bubble.getId();
        final int type = bubble.getType();
        final int collisionType = bubble.getCollisionType();
        final double longitude = bubble.getLongitude();
        final double latitude = bubble.getLatitude();
        final boolean isAvoidAnnocation = bubble.getMarkerOptions().isAvoidAnnocation();
        final int i = bubble.getzIndex();
        final int priority = bubble.getPriority();
        boolean isVirtual = bubble.isVirtual();
        boolean isNeedSelectBottomRect = bubble.isNeedSelectBottomRect();
        String showInfo = bubble.getShowInfo();
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        boolean z = isNeedSelectBottomRect;
        while (i2 < bubble.getOverlayRectCnt()) {
            arrayList.add(bubble.getOverlayRect(i2));
            i2++;
            isVirtual = isVirtual;
        }
        Bubble bubble2 = bubble;
        boolean z2 = isVirtual;
        Bubble.PointArea pointArea = bubble.getPointArea();
        Bubble.PointArea pointArea2 = new Bubble.PointArea();
        ArrayList arrayList2 = arrayList;
        if (pointArea != null) {
            pointArea2.points = pointArea.points;
            pointArea2.startNums = pointArea.startNums;
            pointArea2.endNums = pointArea.endNums;
            pointArea2.sectionCount = pointArea.sectionCount;
            pointArea2.routeID = pointArea.routeID;
        }
        Bubble.TrafficIconAttrs trafficIconAttrs = bubble.getTrafficIconAttrs();
        if (trafficIconAttrs == null || !trafficIconAttrs.isHintIcon) {
            Bubble.PointArea pointArea3 = pointArea2;
            final boolean z3 = z2;
            C910982 r21 = r0;
            final boolean z4 = z;
            final String str = showInfo;
            final ArrayList arrayList3 = arrayList2;
            final Bubble.PointArea pointArea4 = pointArea3;
            C910982 r0 = new RenderTask(this) {
                final /* synthetic */ GLBaseMapView this$0;

                {
                    this.this$0 = r4;
                }

                public void run() {
                    this.this$0.f23894x.updateBubble(id, type, collisionType, longitude, latitude, 1.0f, 1.0f, 0, 0, 0.0f, true, true, isAvoidAnnocation, true, i, priority, 1.0f, true, z3, z4, str, arrayList3, pointArea4);
                }
            };
            set(r21);
            return;
        }
        final long j = trafficIconAttrs.bindId;
        set(new RenderTask() {
            public void run() {
                GLBaseMapView.this.f23894x.updateRemoteIconBindId(id, j);
            }
        });
    }

    public void handleBubbleCollision() {
        set(new RenderTask() {
            public void run() {
                GLBaseMapView.this.f23894x.handleBubbleCollision();
            }
        });
    }

    public LatLng getCenter() {
        return new LatLng(this.f23884e.getCenter());
    }

    public float getScale() {
        return this.f23884e.getScale();
    }

    public float getScaleLevel() {
        return this.f23884e.getScaleLevel();
    }

    public int getMaxScaleLevel() {
        return this.f23854P;
    }

    public int getMinScaleLevel() {
        return this.f23856R;
    }

    public float getSkew() {
        return this.f23884e.getSkew();
    }

    public float getRotate() {
        return this.f23884e.getRotate();
    }

    public int getWidth() {
        return this.f23840B;
    }

    public int getHeight() {
        return this.f23841C;
    }

    public float getCenterOffsetX() {
        return this.f23873ai;
    }

    public boolean isNight() {
        return this.f23843E.isNight;
    }

    public float getCenterOffsetY() {
        return this.f23874aj;
    }

    public Camera getCamera() {
        return this.f23884e.copy();
    }

    public GLProjection getProjection() {
        return this.f23892v;
    }

    public Rect getMapPadding() {
        return this.f23878an;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public final void mo69806f() {
        if (!inSetTransaction()) {
            Handler mainHandler = getMainHandler();
            if (this.f23871ag != null) {
                LatLng center = this.f23884e.getCenter();
                this.f23871ag.onCameraChange(center.longitude, center.latitude, this.f23884e.getScale(), this.f23884e.getScaleLevel(), this.f23884e.getSkew(), this.f23884e.getRotate());
            }
            C9189i iVar = this.f23895y;
            if (iVar != null && this.f23858T) {
                iVar.mo70622a(true);
            }
            mainHandler.removeCallbacks(this.f23876al);
            mainHandler.postDelayed(this.f23876al, 200);
        }
    }

    private static class MapModeAdapter {
        /* access modifiers changed from: private */
        public boolean isDynamicLayerEnable;
        /* access modifiers changed from: private */
        public boolean isNavi;
        /* access modifiers changed from: private */
        public boolean isNight;
        /* access modifiers changed from: private */
        public boolean isTraffic;
        /* access modifiers changed from: private */
        public boolean isUseStyleV2;

        private MapModeAdapter() {
        }

        /* access modifiers changed from: package-private */
        @Deprecated
        public int getMapMode() {
            if (this.isUseStyleV2) {
                return getMapModeV2();
            }
            return this.isNavi ? this.isNight ? this.isTraffic ? 11 : 9 : this.isTraffic ? 8 : 3 : this.isTraffic ? 6 : 1;
        }

        /* access modifiers changed from: package-private */
        public int getMapModeV2() {
            if (this.isNavi) {
                return this.isNight ? 9 : 3;
            }
            return 1;
        }

        public void setUseStyleV2(boolean z) {
            this.isUseStyleV2 = z;
        }
    }

    private class TextureThread extends PauseableThread {
        private static final int TEXTURE_GENERATE_INTERVAL = 160;
        private Runnable releaseRunnable;

        TextureThread() {
            super("texture");
        }

        /* access modifiers changed from: protected */
        public void onBeginRun() {
            createGLContext();
        }

        /* access modifiers changed from: protected */
        public int onRun() {
            return !GLBaseMapView.this.f23894x.generateTexture() ? 160 : 0;
        }

        private void createGLContext() {
            DefaultEGLContextFactory.EGLEnv a;
            if (((C9185e) GLBaseMapView.this.mMapContext).f24019a != null && ApolloHawaii.USE_SHARE_CONTEXT && (a = ((C9185e) GLBaseMapView.this.mMapContext).f24019a.mo69752a()) != null) {
                EGL10 egl10 = a.egl10;
                if (!egl10.eglMakeCurrent(a.display, a.eglSurface, a.eglSurface, a.sharedContext)) {
                    OmegaUtils.trackShareContextException("eglMakeCurrent failed,error" + egl10.eglGetError());
                }
            }
        }

        /* access modifiers changed from: protected */
        public void onEndRun() {
            DefaultEGLContextFactory.EGLEnv a;
            Runnable runnable = this.releaseRunnable;
            if (runnable != null) {
                runnable.run();
            }
            if (((C9185e) GLBaseMapView.this.mMapContext).f24019a != null && ApolloHawaii.USE_SHARE_CONTEXT && (a = ((C9185e) GLBaseMapView.this.mMapContext).f24019a.mo69752a()) != null) {
                EGL10 egl10 = a.egl10;
                egl10.eglMakeCurrent(a.display, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                egl10.eglDestroySurface(a.display, a.eglSurface);
                egl10.eglDestroyContext(a.display, a.sharedContext);
                a.eglSurface = null;
            }
        }

        /* access modifiers changed from: private */
        public void setReleaseTextureRunnable(Runnable runnable) {
            this.releaseRunnable = runnable;
        }
    }

    public static final class Option implements GLView.Options {
        final LatLng center;
        final boolean compassVisible;
        final String configPath;
        final ArrayList<String> configurations;
        final String dataPath;
        EngineDynamicConfigProvider engineDynamicConfigProvider;
        EngineLogSwitch engineLogSwitch = EngineLogSwitch.OFF;
        boolean isDynamicLayerEnable = false;
        boolean isNavi;
        boolean isNight;
        boolean isTraffic;
        boolean isVulkan;
        int language;
        int mapTheme;
        final int mapVersion;
        final int maxScaleLevel;
        final float maxSkew;
        final int minScaleLevel;
        float rotate;
        final String satellitePath;
        float scale;
        float skew;
        final String wmsPath;

        public Option(String str, String str2, String str3, String str4, ArrayList<String> arrayList, int i, int i2, float f, double d, double d2, float f2, float f3, float f4, boolean z, int i3, int i4, EngineLogSwitch engineLogSwitch2, EngineDynamicConfigProvider engineDynamicConfigProvider2, boolean z2, boolean z3, boolean z4, boolean z5, int i5, boolean z6) {
            EngineLogSwitch engineLogSwitch3 = engineLogSwitch2;
            this.configPath = str;
            this.dataPath = str2;
            this.satellitePath = str3;
            this.wmsPath = str4;
            this.configurations = arrayList;
            this.maxScaleLevel = i;
            this.minScaleLevel = i2;
            this.maxSkew = f;
            this.center = new LatLng(d2, d);
            this.scale = f2;
            this.rotate = f3;
            this.skew = f4;
            this.compassVisible = z;
            this.language = i3;
            this.mapVersion = i4;
            this.isNight = z2;
            this.isNavi = z3;
            this.isTraffic = z4;
            this.isVulkan = z5;
            this.mapTheme = i5;
            if (engineLogSwitch3 != null) {
                this.engineLogSwitch = engineLogSwitch3;
            }
            this.isDynamicLayerEnable = z6;
            this.engineDynamicConfigProvider = engineDynamicConfigProvider2;
        }
    }

    public void zoomIn(boolean z, long j, Animator.AnimatorListener animatorListener) {
        float scale = getScale();
        float f = 2.0f * scale;
        float f2 = this.f23886g;
        if (f > f2) {
            f = f2;
        }
        if (z) {
            GLAnimator gLAnimator = new GLAnimator();
            gLAnimator.setDuration(j);
            gLAnimator.setFloatValues(new float[]{scale, f});
            gLAnimator.setEvaluator(new FloatEvaluator());
            gLAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    GLBaseMapView.this.setScale(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
            if (animatorListener != null) {
                gLAnimator.addListener(animatorListener);
            }
            setAnimator(gLAnimator);
            startAnimator();
            return;
        }
        setScale(f);
    }

    public void zoomOut(boolean z, long j, Animator.AnimatorListener animatorListener) {
        float scale = getScale();
        float f = scale / 2.0f;
        float f2 = this.f23887h;
        if (f < f2) {
            f = f2;
        }
        if (z) {
            GLAnimator gLAnimator = new GLAnimator();
            gLAnimator.setDuration(j);
            gLAnimator.setEvaluator(new FloatEvaluator());
            gLAnimator.setFloatValues(new float[]{scale, f});
            gLAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    GLBaseMapView.this.setScale(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
            if (animatorListener != null) {
                gLAnimator.addListener(animatorListener);
            }
            setAnimator(gLAnimator);
            startAnimator();
            return;
        }
        setScale(f);
    }

    public void scrollBy(boolean z, float f, float f2, long j, Animator.AnimatorListener animatorListener) {
        PointF pointF = new PointF(0.0f, 0.0f);
        PointF pointF2 = new PointF(f, f2);
        if (z) {
            GLAnimator gLAnimator = new GLAnimator();
            gLAnimator.setDuration(j);
            gLAnimator.setObjectValues(new Object[]{pointF, pointF2});
            gLAnimator.setEvaluator(new ScrollByPointFEvaluator());
            gLAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    PointF pointF = (PointF) valueAnimator.getAnimatedValue();
                    GLBaseMapView.this.m16953c(pointF.x, pointF.y);
                }
            });
            if (animatorListener != null) {
                gLAnimator.addListener(animatorListener);
            }
            setAnimator(gLAnimator);
            startAnimator();
            return;
        }
        m16953c(pointF2.x, pointF2.y);
    }

    public void zoomTo(boolean z, float f, long j, Animator.AnimatorListener animatorListener) {
        float scale = getScale();
        float scale2 = (float) MathsUtils.getScale((double) f);
        if (z) {
            GLAnimator gLAnimator = new GLAnimator();
            gLAnimator.setDuration(j);
            gLAnimator.setFloatValues(new float[]{scale, scale2});
            gLAnimator.setEvaluator(new FloatEvaluator());
            gLAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    GLBaseMapView.this.setScale(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
            if (animatorListener != null) {
                gLAnimator.addListener(animatorListener);
            }
            setAnimator(gLAnimator);
            startAnimator();
            return;
        }
        setScale(scale2);
    }

    public void zoomBy(boolean z, float f, long j, Animator.AnimatorListener animatorListener) {
        double d;
        if (f < 0.0f) {
            d = Math.pow(2.0d, (double) Math.abs(f));
        } else {
            d = Math.pow(0.5d, (double) f);
        }
        float scale = getScale();
        float f2 = ((float) (1.0d / d)) * scale;
        if (z) {
            GLAnimator gLAnimator = new GLAnimator();
            gLAnimator.setDuration(j);
            gLAnimator.setFloatValues(new float[]{scale, f2});
            gLAnimator.setEvaluator(new FloatEvaluator());
            gLAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    GLBaseMapView.this.setScale(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
            if (animatorListener != null) {
                gLAnimator.addListener(animatorListener);
            }
            setAnimator(gLAnimator);
            startAnimator();
            return;
        }
        setScale(f2);
    }

    public void zoomByPoint(boolean z, float f, final Point point, long j, Animator.AnimatorListener animatorListener) {
        double d;
        if (f < 0.0f) {
            d = Math.pow(2.0d, (double) Math.abs(f));
        } else {
            d = Math.pow(0.5d, (double) f);
        }
        float scale = getScale();
        float f2 = ((float) (1.0d / d)) * scale;
        if (z) {
            GLAnimator gLAnimator = new GLAnimator();
            gLAnimator.setDuration(j);
            gLAnimator.setFloatValues(new float[]{scale, f2});
            gLAnimator.setEvaluator(new FloatEvaluator());
            gLAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    GLBaseMapView.this.m16946b(((Float) valueAnimator.getAnimatedValue()).floatValue(), (float) point.x, (float) point.y);
                }
            });
            if (animatorListener != null) {
                gLAnimator.addListener(animatorListener);
            }
            setAnimator(gLAnimator);
            startAnimator();
            return;
        }
        m16946b(f2, (float) point.x, (float) point.y);
    }

    public void newCameraPositionV2(boolean z, final Camera camera, long j, Animator.AnimatorListener animatorListener) {
        Camera camera2 = getCamera();
        if (z) {
            PropertyValuesHolder ofObject = PropertyValuesHolder.ofObject("camera", new CameraEvaluator(true), new Object[]{camera2, camera});
            GLAnimator gLAnimator = new GLAnimator();
            gLAnimator.setValues(new PropertyValuesHolder[]{ofObject});
            gLAnimator.setDuration(j);
            gLAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    GLBaseMapView.this.setMovePixelWithScale(((Camera) valueAnimator.getAnimatedValue("camera")).getScale(), camera.getCenter(), valueAnimator.getAnimatedFraction());
                }
            });
            if (animatorListener != null) {
                gLAnimator.addListener(animatorListener);
            }
            setAnimator(gLAnimator);
            startAnimator();
            return;
        }
        setCamera(camera);
    }

    public void newCameraPosition(boolean z, Camera camera, long j, Animator.AnimatorListener animatorListener) {
        Camera camera2 = getCamera();
        if (z) {
            PropertyValuesHolder ofObject = PropertyValuesHolder.ofObject("camera", new CameraEvaluator(), new Object[]{camera2, camera});
            GLAnimator gLAnimator = new GLAnimator();
            gLAnimator.setValues(new PropertyValuesHolder[]{ofObject});
            gLAnimator.setDuration(j);
            gLAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    GLBaseMapView.this.setCamera((Camera) valueAnimator.getAnimatedValue("camera"));
                }
            });
            if (animatorListener != null) {
                gLAnimator.addListener(animatorListener);
            }
            setAnimator(gLAnimator);
            startAnimator();
            return;
        }
        setCamera(camera);
    }

    /* renamed from: a */
    private void m16942a(boolean z, LatLng latLng, long j, Animator.AnimatorListener animatorListener, boolean z2) {
        LatLng center = getCenter();
        if (z) {
            GLAnimator gLAnimator = new GLAnimator();
            gLAnimator.setDuration(j);
            gLAnimator.setObjectValues(new Object[]{center, latLng});
            if (z2) {
                gLAnimator.setInterpolator(new LinearOutSlowInInterpolator());
            }
            gLAnimator.setEvaluator(new LatLngEvaluator());
            gLAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    GLBaseMapView.this.setCenter((LatLng) valueAnimator.getAnimatedValue());
                }
            });
            if (animatorListener != null) {
                gLAnimator.addListener(animatorListener);
            }
            setAnimator(gLAnimator);
            startAnimator();
            return;
        }
        setCenter(latLng);
    }

    public void newLatLng(boolean z, LatLng latLng, long j, Animator.AnimatorListener animatorListener) {
        m16942a(z, latLng, j, animatorListener, false);
    }

    public void newLatLngZoom(boolean z, float f, LatLng latLng, long j, Animator.AnimatorListener animatorListener) {
        float scale = getScale();
        float scale2 = (float) MathsUtils.getScale((double) f);
        LatLng center = getCenter();
        if (z) {
            PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat(NNGestureClassfy.SCALE_LABLE, new float[]{scale, scale2});
            PropertyValuesHolder ofObject = PropertyValuesHolder.ofObject("center", new LatLngEvaluator(), new Object[]{center, latLng});
            GLAnimator gLAnimator = new GLAnimator();
            gLAnimator.setDuration(j);
            gLAnimator.setValues(new PropertyValuesHolder[]{ofFloat, ofObject});
            gLAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue(NNGestureClassfy.SCALE_LABLE)).floatValue();
                    GLBaseMapView.this.m16940a((LatLng) valueAnimator.getAnimatedValue("center"), floatValue);
                }
            });
            if (animatorListener != null) {
                gLAnimator.addListener(animatorListener);
            }
            setAnimator(gLAnimator);
            startAnimator();
            return;
        }
        m16940a(latLng, scale2);
    }

    public void newLatLngBounds(boolean z, LatLngBounds latLngBounds, int i, long j, Animator.AnimatorListener animatorListener) {
        Camera computeZoomToSpanTarget = computeZoomToSpanTarget(new RectF((float) latLngBounds.southwest.longitude, (float) latLngBounds.northeast.latitude, (float) latLngBounds.northeast.longitude, (float) latLngBounds.southwest.latitude), new Rect(i, i, i, i));
        if (computeZoomToSpanTarget != null) {
            LatLng center = getCenter();
            float scale = getScale();
            float scale2 = computeZoomToSpanTarget.getScale();
            if (z) {
                PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat(NNGestureClassfy.SCALE_LABLE, new float[]{scale, scale2});
                PropertyValuesHolder ofObject = PropertyValuesHolder.ofObject("center", new LatLngEvaluator(), new Object[]{center, computeZoomToSpanTarget.getCenter()});
                GLAnimator gLAnimator = new GLAnimator();
                gLAnimator.setDuration(j);
                gLAnimator.setValues(new PropertyValuesHolder[]{ofFloat, ofObject});
                gLAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue(NNGestureClassfy.SCALE_LABLE)).floatValue();
                        GLBaseMapView.this.m16940a((LatLng) valueAnimator.getAnimatedValue("center"), floatValue);
                    }
                });
                if (animatorListener != null) {
                    gLAnimator.addListener(animatorListener);
                }
                setAnimator(gLAnimator);
                startAnimator();
                return;
            }
            m16940a(computeZoomToSpanTarget.getCenter(), scale2);
        } else if (animatorListener != null) {
            animatorListener.onAnimationCancel((Animator) null);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v15, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: com.didi.hawaii.mapsdkv2.core.Camera} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void newLatLngBoundsRect4MoveMapCenter(boolean r17, com.didi.map.outer.model.LatLngBounds r18, int r19, int r20, int r21, int r22, long r23, android.animation.Animator.AnimatorListener r25) {
        /*
            r16 = this;
            r6 = r16
            r0 = r18
            r1 = r19
            r2 = r20
            r7 = r23
            r9 = r25
            int r3 = r6.f23840B
            int r4 = r3 - r1
            int r4 = r4 - r21
            r10 = 2
            int r4 = r4 / r10
            int r4 = r4 + r1
            int r5 = r6.f23841C
            int r11 = r5 - r2
            int r11 = r11 - r22
            int r11 = r11 / r10
            int r11 = r11 + r2
            float r4 = (float) r4
            r12 = 1065353216(0x3f800000, float:1.0)
            float r4 = r4 * r12
            float r3 = (float) r3
            float r13 = r4 / r3
            float r3 = (float) r11
            float r3 = r3 * r12
            float r4 = (float) r5
            float r11 = r3 / r4
            com.didi.map.outer.model.LatLng r3 = r0.southwest
            com.didi.map.outer.model.LatLng r4 = r0.northeast
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x004f
            com.didi.hawaii.mapsdkv2.core.Camera r1 = new com.didi.hawaii.mapsdkv2.core.Camera
            com.didi.map.outer.model.LatLng r0 = r0.southwest
            com.didi.hawaii.mapsdkv2.core.Camera r2 = r6.f23884e
            float r2 = r2.getScale()
            com.didi.hawaii.mapsdkv2.core.Camera r3 = r6.f23884e
            float r3 = r3.getRotate()
            com.didi.hawaii.mapsdkv2.core.Camera r4 = r6.f23884e
            float r4 = r4.getSkew()
            r1.<init>(r0, r2, r3, r4)
            goto L_0x008b
        L_0x004f:
            com.didi.map.outer.model.LatLng r3 = r0.southwest
            double r3 = r3.longitude
            float r3 = (float) r3
            com.didi.map.outer.model.LatLng r4 = r0.northeast
            double r4 = r4.latitude
            float r4 = (float) r4
            com.didi.map.outer.model.LatLng r5 = r0.northeast
            double r14 = r5.longitude
            float r5 = (float) r14
            com.didi.map.outer.model.LatLng r0 = r0.southwest
            double r14 = r0.latitude
            float r0 = (float) r14
            android.graphics.RectF r12 = new android.graphics.RectF
            r12.<init>(r3, r4, r5, r0)
            android.graphics.Rect r3 = new android.graphics.Rect
            int r0 = r6.f23840B
            int r0 = r0 - r21
            int r4 = r6.f23841C
            int r4 = r4 - r22
            r3.<init>(r1, r2, r0, r4)
            com.didi.hawaii.mapsdkv2.core.GLBaseMapView$95 r14 = new com.didi.hawaii.mapsdkv2.core.GLBaseMapView$95
            r0 = r14
            r1 = r16
            r2 = r12
            r4 = r13
            r5 = r11
            r0.<init>(r2, r3, r4, r5)
            java.util.concurrent.Future r0 = r6.get(r14)
            java.lang.Object r0 = futureGet(r0)
            r1 = r0
            com.didi.hawaii.mapsdkv2.core.Camera r1 = (com.didi.hawaii.mapsdkv2.core.Camera) r1
        L_0x008b:
            if (r1 != 0) goto L_0x008e
            return
        L_0x008e:
            if (r17 == 0) goto L_0x011b
            com.didi.hawaii.mapsdkv2.common.evaluator.CameraEvaluator r0 = new com.didi.hawaii.mapsdkv2.common.evaluator.CameraEvaluator
            r0.<init>()
            java.lang.Object[] r2 = new java.lang.Object[r10]
            com.didi.hawaii.mapsdkv2.core.Camera r3 = r16.getCamera()
            r4 = 0
            r2[r4] = r3
            r3 = 1
            r2[r3] = r1
            java.lang.String r1 = "camera"
            android.animation.PropertyValuesHolder r0 = android.animation.PropertyValuesHolder.ofObject(r1, r0, r2)
            com.didi.hawaii.mapsdkv2.core.GLAnimator r1 = new com.didi.hawaii.mapsdkv2.core.GLAnimator
            r1.<init>()
            android.animation.PropertyValuesHolder[] r2 = new android.animation.PropertyValuesHolder[r3]
            r2[r4] = r0
            r1.setValues(r2)
            r1.setDuration(r7)
            com.didi.hawaii.mapsdkv2.core.GLBaseMapView$96 r0 = new com.didi.hawaii.mapsdkv2.core.GLBaseMapView$96
            r0.<init>()
            r1.addUpdateListener(r0)
            float[] r0 = new float[r10]
            float r2 = r16.getCenterOffsetX()
            r0[r4] = r2
            r0[r3] = r13
            java.lang.String r2 = "offsetX"
            android.animation.PropertyValuesHolder r0 = android.animation.PropertyValuesHolder.ofFloat(r2, r0)
            float[] r2 = new float[r10]
            float r5 = r16.getCenterOffsetY()
            r2[r4] = r5
            r2[r3] = r11
            java.lang.String r5 = "offsetY"
            android.animation.PropertyValuesHolder r2 = android.animation.PropertyValuesHolder.ofFloat(r5, r2)
            com.didi.hawaii.mapsdkv2.core.GLAnimator r5 = new com.didi.hawaii.mapsdkv2.core.GLAnimator
            r5.<init>()
            android.animation.PropertyValuesHolder[] r11 = new android.animation.PropertyValuesHolder[r10]
            r11[r4] = r0
            r11[r3] = r2
            r5.setValues(r11)
            r5.setDuration(r7)
            androidx.interpolator.view.animation.FastOutSlowInInterpolator r0 = new androidx.interpolator.view.animation.FastOutSlowInInterpolator
            r0.<init>()
            r5.setInterpolator(r0)
            com.didi.hawaii.mapsdkv2.core.GLBaseMapView$97 r0 = new com.didi.hawaii.mapsdkv2.core.GLBaseMapView$97
            r0.<init>()
            r5.addUpdateListener(r0)
            android.animation.AnimatorSet r0 = new android.animation.AnimatorSet
            r0.<init>()
            android.animation.Animator[] r2 = new android.animation.Animator[r10]
            r2[r4] = r5
            r2[r3] = r1
            r0.playTogether(r2)
            if (r9 == 0) goto L_0x0114
            r0.addListener(r9)
        L_0x0114:
            r6.setAnimator(r0)
            r16.startAnimator()
            goto L_0x0121
        L_0x011b:
            r6.setCenterOffset(r13, r11)
            r6.setCamera(r1)
        L_0x0121:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.hawaii.mapsdkv2.core.GLBaseMapView.newLatLngBoundsRect4MoveMapCenter(boolean, com.didi.map.outer.model.LatLngBounds, int, int, int, int, long, android.animation.Animator$AnimatorListener):void");
    }

    public void newLatLngBoundsRect(boolean z, LatLngBounds latLngBounds, int i, int i2, int i3, int i4, long j, Animator.AnimatorListener animatorListener) {
        Camera computeZoomToSpanTarget = computeZoomToSpanTarget(new RectF((float) latLngBounds.southwest.longitude, (float) latLngBounds.northeast.latitude, (float) latLngBounds.northeast.longitude, (float) latLngBounds.southwest.latitude), new Rect(i, i2, i3, i4));
        if (computeZoomToSpanTarget != null) {
            LatLng center = getCenter();
            float scale = getScale();
            float scale2 = computeZoomToSpanTarget.getScale();
            if (z) {
                PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat(NNGestureClassfy.SCALE_LABLE, new float[]{scale, scale2});
                PropertyValuesHolder ofObject = PropertyValuesHolder.ofObject("center", new LatLngEvaluator(), new Object[]{center, computeZoomToSpanTarget.getCenter()});
                GLAnimator gLAnimator = new GLAnimator();
                gLAnimator.setDuration(j);
                gLAnimator.setValues(new PropertyValuesHolder[]{ofFloat, ofObject});
                gLAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue(NNGestureClassfy.SCALE_LABLE)).floatValue();
                        GLBaseMapView.this.m16940a((LatLng) valueAnimator.getAnimatedValue("center"), floatValue);
                    }
                });
                if (animatorListener != null) {
                    gLAnimator.addListener(animatorListener);
                }
                setAnimator(gLAnimator);
                startAnimator();
                return;
            }
            m16940a(computeZoomToSpanTarget.getCenter(), scale2);
        } else if (animatorListener != null) {
            animatorListener.onAnimationCancel((Animator) null);
        }
    }

    public void rotateTo(boolean z, float f, float f2, long j, Animator.AnimatorListener animatorListener) {
        float rotate = getRotate();
        float skew = getSkew();
        if (z) {
            PropertyValuesHolder ofObject = PropertyValuesHolder.ofObject(NNGestureClassfy.ROTATE_LABLE, AngleEvaluator.INSTANCE, new Object[]{Float.valueOf(rotate), Float.valueOf(f)});
            PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("skew", new float[]{skew, f2});
            GLAnimator gLAnimator = new GLAnimator();
            gLAnimator.setDuration(j);
            gLAnimator.setValues(new PropertyValuesHolder[]{ofObject, ofFloat});
            gLAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    GLBaseMapView.this.m16956d(((Float) valueAnimator.getAnimatedValue(NNGestureClassfy.ROTATE_LABLE)).floatValue(), ((Float) valueAnimator.getAnimatedValue("skew")).floatValue());
                }
            });
            if (animatorListener != null) {
                gLAnimator.addListener(animatorListener);
            }
            setAnimator(gLAnimator);
            startAnimator();
            return;
        }
        m16956d(f, f2);
    }

    public void navigateMap(boolean z, Camera camera, long j, Animator.AnimatorListener animatorListener) {
        if (z) {
            Camera camera2 = getCamera();
            AnimatorSet animatorSet = new AnimatorSet();
            GLAnimator gLAnimator = new GLAnimator();
            gLAnimator.setFloatValues(new float[]{camera2.getScale(), camera.getScale()});
            gLAnimator.setDuration(j);
            gLAnimator.setInterpolator(new FastOutSlowInInterpolator());
            gLAnimator.setEvaluator(new FloatEvaluator());
            gLAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    GLBaseMapView.this.setScale(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
            PropertyValuesHolder ofObject = PropertyValuesHolder.ofObject(NNGestureClassfy.ROTATE_LABLE, AngleEvaluator.INSTANCE, new Object[]{Float.valueOf(camera2.getRotate()), Float.valueOf(camera.getRotate())});
            PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("skew", new float[]{camera2.getSkew(), camera.getSkew()});
            GLAnimator gLAnimator2 = new GLAnimator();
            gLAnimator2.setDuration((long) ((Math.abs(camera.getRotate() - camera2.getRotate()) * 150.0f) / 30.0f));
            gLAnimator2.setValues(new PropertyValuesHolder[]{ofObject, ofFloat});
            gLAnimator2.setInterpolator(new FastOutSlowInInterpolator());
            gLAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    GLBaseMapView.this.m16956d(((Float) valueAnimator.getAnimatedValue(NNGestureClassfy.ROTATE_LABLE)).floatValue(), ((Float) valueAnimator.getAnimatedValue("skew")).floatValue());
                }
            });
            if (animatorListener != null) {
                animatorSet.addListener(animatorListener);
            }
            animatorSet.playTogether(new Animator[]{gLAnimator, gLAnimator2});
            setAnimator(animatorSet);
            startAnimator();
            setCenter(camera.getCenter());
            return;
        }
        setCamera(camera);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m16953c(final float f, final float f2) {
        set(new RenderTask() {
            public void run() {
                GLBaseMapView.this.f23894x.moveBy(f, f2);
                GLBaseMapView.this.f23884e.setCenter(GLBaseMapView.this.f23894x.getCenter());
                GLBaseMapView.this.getMainHandler().post(new Runnable() {
                    public void run() {
                        GLBaseMapView.this.mo69806f();
                    }
                });
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m16946b(float f, final float f2, final float f3) {
        beginSetTransaction();
        set(new RenderTask() {
            public void run() {
                GLBaseMapView.this.f23894x.moveBy((((float) GLBaseMapView.this.f23840B) * GLBaseMapView.this.f23873ai) - f2, (((float) GLBaseMapView.this.f23841C) * GLBaseMapView.this.f23874aj) - f3);
            }
        });
        setScale(f);
        set(new RenderTask() {
            public void run() {
                GLBaseMapView.this.f23894x.moveBy(f2 - (((float) GLBaseMapView.this.f23840B) * GLBaseMapView.this.f23873ai), f3 - (((float) GLBaseMapView.this.f23841C) * GLBaseMapView.this.f23874aj));
                GLBaseMapView.this.f23884e.setCenter(GLBaseMapView.this.f23894x.getCenter());
                GLBaseMapView.this.getMainHandler().post(new Runnable() {
                    public void run() {
                        GLBaseMapView.this.mo69806f();
                    }
                });
            }
        });
        commitSetTransaction();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m16954c(float f, final float f2, final float f3) {
        beginSetTransaction();
        set(new RenderTask() {
            public void run() {
                GLBaseMapView.this.f23894x.moveBy((((float) GLBaseMapView.this.f23840B) * GLBaseMapView.this.f23873ai) - f2, (((float) GLBaseMapView.this.f23841C) * GLBaseMapView.this.f23874aj) - f3);
            }
        });
        setRotate(f);
        set(new RenderTask() {
            public void run() {
                GLBaseMapView.this.f23894x.moveBy(f2 - (((float) GLBaseMapView.this.f23840B) * GLBaseMapView.this.f23873ai), f3 - (((float) GLBaseMapView.this.f23841C) * GLBaseMapView.this.f23874aj));
                GLBaseMapView.this.f23884e.setCenter(GLBaseMapView.this.f23894x.getCenter());
                GLBaseMapView.this.getMainHandler().post(new Runnable() {
                    public void run() {
                        GLBaseMapView.this.mo69806f();
                    }
                });
            }
        });
        commitSetTransaction();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo69780a(float f, long j, final PointF pointF) {
        double d;
        if (f < 0.0f) {
            d = Math.pow(2.0d, (double) Math.abs(f));
        } else {
            d = Math.pow(0.5d, (double) f);
        }
        float scale = getScale();
        GLAnimator gLAnimator = new GLAnimator();
        gLAnimator.setFloatValues(new float[]{scale, ((float) (1.0d / d)) * scale});
        gLAnimator.setDuration(j);
        gLAnimator.setInterpolator(new DecelerateInterpolator());
        gLAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (!GLBaseMapView.this.f23870af || !GLBaseMapView.this.f23869ae) {
                    GLBaseMapView.this.setScale(floatValue);
                } else {
                    GLBaseMapView.this.m16946b(floatValue, pointF.x, pointF.y);
                }
            }
        });
        setAnimator(gLAnimator);
        startAnimator();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo69789b(float f, long j, PointF pointF) {
        final Point point = new Point((int) pointF.x, (int) pointF.y);
        GLAnimator gLAnimator = new GLAnimator();
        gLAnimator.setFloatValues(new float[]{f, 0.0f});
        gLAnimator.setDuration(j);
        gLAnimator.setInterpolator(new DecelerateInterpolator());
        gLAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                GLBaseMapView gLBaseMapView = GLBaseMapView.this;
                gLBaseMapView.m16954c(gLBaseMapView.getRotate() + floatValue, (float) point.x, (float) point.y);
            }
        });
        setAnimator(gLAnimator);
        startAnimator();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m16940a(LatLng latLng, float f) {
        beginSetTransaction();
        setCenter(latLng);
        setScale(f);
        commitSetTransaction();
        mo69806f();
    }

    public void setCamera(Camera camera) {
        beginSetTransaction();
        setCenter(camera.getCenter());
        setScale(camera.getScale());
        setRotate(camera.getRotate());
        setSkew(camera.getSkew());
        commitSetTransaction();
        mo69806f();
    }

    public void setMovePixelWithScale(float f, final LatLng latLng, final float f2) {
        beginSetTransaction();
        setScaleByFixPos(f, latLng);
        set(new RenderTask() {
            public void run() {
                LatLng evaluate = GLBaseMapView.this.f23890k.evaluate(f2, GLBaseMapView.this.f23894x.getCenter(), latLng);
                GLBaseMapView.this.f23894x.moveTo(evaluate);
                GLBaseMapView.this.f23884e.setCenter(evaluate);
            }
        });
        commitSetTransaction();
        mo69806f();
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m16956d(float f, float f2) {
        beginSetTransaction();
        setRotate(f);
        setSkew(f2);
        commitSetTransaction();
        mo69806f();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo69778a(float f, float f2) {
        beginSetTransaction();
        setScale(f2);
        setSkew(f);
        commitSetTransaction();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo69779a(float f, float f2, float f3) {
        beginSetTransaction();
        setScale(f2);
        setSkew(f);
        setCenterOffset(f3, getCenterOffsetY());
        commitSetTransaction();
    }

    public LatLng calculateRoute3DArrowFurthestPoint() {
        return this.f23894x.calculateRoute3DArrowFurthestPointUnsafe();
    }

    public void hibernate() {
        set(new RenderTask() {
            public void run() {
                GLBaseMapView.this.f23894x.hibernate();
            }
        });
    }

    public void overview2fullview(Camera camera, float f, float f2, long j, Animator.AnimatorListener animatorListener) {
        float f3 = f;
        float f4 = f2;
        long j2 = j;
        Animator.AnimatorListener animatorListener2 = animatorListener;
        if (getLocator() != null) {
            Camera camera2 = getCamera();
            HWLog.m16761i("overview2fullview", "start = " + camera2.toString());
            HWLog.m16761i("overview2fullview", "end = " + camera.toString());
            LatLng position = getLocator().getPosition();
            if (position.equals(camera2.getCenter())) {
                GLAnimator gLAnimator = new GLAnimator();
                gLAnimator.setFloatValues(new float[]{camera2.getScale(), camera.getScale()});
                gLAnimator.setDuration(j2);
                gLAnimator.setInterpolator(new FastOutSlowInInterpolator());
                gLAnimator.setEvaluator(new FloatEvaluator());
                gLAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        GLBaseMapView.this.setScale(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                });
                PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("offsetX", new float[]{getCenterOffsetX(), f3});
                PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("offsetY", new float[]{getCenterOffsetY(), f4});
                GLAnimator gLAnimator2 = new GLAnimator();
                gLAnimator2.setValues(new PropertyValuesHolder[]{ofFloat, ofFloat2});
                gLAnimator2.setDuration(j2);
                gLAnimator2.setInterpolator(new FastOutSlowInInterpolator());
                gLAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        GLBaseMapView.this.setCenterOffset(((Float) valueAnimator.getAnimatedValue("offsetX")).floatValue(), ((Float) valueAnimator.getAnimatedValue("offsetY")).floatValue());
                    }
                });
                PropertyValuesHolder ofObject = PropertyValuesHolder.ofObject(NNGestureClassfy.ROTATE_LABLE, AngleEvaluator.INSTANCE, new Object[]{Float.valueOf(camera2.getRotate()), Float.valueOf(camera.getRotate())});
                PropertyValuesHolder ofFloat3 = PropertyValuesHolder.ofFloat("skew", new float[]{camera2.getSkew(), camera.getSkew()});
                GLAnimator gLAnimator3 = new GLAnimator();
                gLAnimator3.setDuration(j2);
                gLAnimator3.setValues(new PropertyValuesHolder[]{ofObject, ofFloat3});
                gLAnimator3.setInterpolator(new FastOutSlowInInterpolator());
                gLAnimator3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        GLBaseMapView.this.m16956d(((Float) valueAnimator.getAnimatedValue(NNGestureClassfy.ROTATE_LABLE)).floatValue(), ((Float) valueAnimator.getAnimatedValue("skew")).floatValue());
                    }
                });
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(new Animator[]{gLAnimator, gLAnimator3, gLAnimator2});
                final Animator.AnimatorListener animatorListener3 = animatorListener;
                final LatLng latLng = position;
                final float f5 = f;
                final float f6 = f2;
                animatorSet.addListener(new Animator.AnimatorListener() {
                    public void onAnimationStart(Animator animator) {
                        Animator.AnimatorListener animatorListener = animatorListener3;
                        if (animatorListener != null) {
                            animatorListener.onAnimationStart(animator);
                        }
                    }

                    public void onAnimationEnd(Animator animator) {
                        GLBaseMapView.this.setCenter(latLng);
                        GLBaseMapView.this.setCenterOffset(f5, f6);
                        Animator.AnimatorListener animatorListener = animatorListener3;
                        if (animatorListener != null) {
                            animatorListener.onAnimationEnd(animator);
                        }
                    }

                    public void onAnimationCancel(Animator animator) {
                        Animator.AnimatorListener animatorListener = animatorListener3;
                        if (animatorListener != null) {
                            animatorListener.onAnimationCancel(animator);
                        }
                    }

                    public void onAnimationRepeat(Animator animator) {
                        Animator.AnimatorListener animatorListener = animatorListener3;
                        if (animatorListener != null) {
                            animatorListener.onAnimationRepeat(animator);
                        }
                    }
                });
                setAnimator(animatorSet);
                startAnimator();
                return;
            }
            setCenter(position);
            setCenterOffset(f3, f4);
            m16956d(camera.getRotate(), camera.getScale());
            setScale(camera.getScale());
            if (animatorListener2 != null) {
                animatorListener2.onAnimationCancel((Animator) null);
            }
        }
    }

    public void fullview2overview(Camera camera, long j, Animator.AnimatorListener animatorListener) {
        long j2 = j;
        Animator.AnimatorListener animatorListener2 = animatorListener;
        if (getLocator() != null) {
            Camera camera2 = getCamera();
            HWLog.m16761i("fullview2overview", "start = " + camera2.toString());
            HWLog.m16761i("fullview2overview", "end = " + camera.toString());
            LatLng position = getLocator().getPosition();
            double metersPerPixel = MathsUtils.metersPerPixel((double) camera.getScaleLevel(), camera.getCenter().latitude);
            double distanceBetween = TransformUtil.distanceBetween(camera.getCenter().latitude, camera.getCenter().longitude, position.latitude, camera.getCenter().longitude) / metersPerPixel;
            double distanceBetween2 = (TransformUtil.distanceBetween(camera.getCenter().latitude, camera.getCenter().longitude, camera.getCenter().latitude, position.longitude) / metersPerPixel) / ((double) getWidth());
            double height = distanceBetween / ((double) getHeight());
            if (position.longitude < camera.getCenter().longitude) {
                distanceBetween2 *= -1.0d;
            }
            if (position.latitude > camera.getCenter().latitude) {
                height *= -1.0d;
            }
            float f = ((float) distanceBetween2) + 0.5f;
            float f2 = 0.5f + ((float) height);
            if (position.equals(camera2.getCenter())) {
                GLAnimator gLAnimator = new GLAnimator();
                gLAnimator.setFloatValues(new float[]{camera2.getScale(), camera.getScale()});
                long j3 = j;
                gLAnimator.setDuration(j3);
                gLAnimator.setInterpolator(new FastOutSlowInInterpolator());
                gLAnimator.setEvaluator(new FloatEvaluator());
                gLAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        GLBaseMapView.this.setScale(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                });
                PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("offsetX", new float[]{getCenterOffsetX(), f});
                PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("offsetY", new float[]{getCenterOffsetY(), f2});
                GLAnimator gLAnimator2 = new GLAnimator();
                gLAnimator2.setValues(new PropertyValuesHolder[]{ofFloat, ofFloat2});
                gLAnimator2.setDuration(j3);
                gLAnimator2.setInterpolator(new FastOutSlowInInterpolator());
                gLAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        GLBaseMapView.this.setCenterOffset(((Float) valueAnimator.getAnimatedValue("offsetX")).floatValue(), ((Float) valueAnimator.getAnimatedValue("offsetY")).floatValue());
                    }
                });
                PropertyValuesHolder ofObject = PropertyValuesHolder.ofObject(NNGestureClassfy.ROTATE_LABLE, AngleEvaluator.INSTANCE, new Object[]{Float.valueOf(camera2.getRotate()), Float.valueOf(camera.getRotate())});
                PropertyValuesHolder ofFloat3 = PropertyValuesHolder.ofFloat("skew", new float[]{camera2.getSkew(), camera.getSkew()});
                GLAnimator gLAnimator3 = new GLAnimator();
                gLAnimator3.setDuration(j3);
                gLAnimator3.setValues(new PropertyValuesHolder[]{ofObject, ofFloat3});
                gLAnimator3.setInterpolator(new FastOutSlowInInterpolator());
                gLAnimator3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        GLBaseMapView.this.m16956d(((Float) valueAnimator.getAnimatedValue(NNGestureClassfy.ROTATE_LABLE)).floatValue(), ((Float) valueAnimator.getAnimatedValue("skew")).floatValue());
                    }
                });
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(new Animator[]{gLAnimator, gLAnimator3, gLAnimator2});
                final Animator.AnimatorListener animatorListener3 = animatorListener;
                final LatLng latLng = position;
                final float f3 = f;
                final float f4 = f2;
                animatorSet.addListener(new Animator.AnimatorListener() {
                    public void onAnimationStart(Animator animator) {
                        Animator.AnimatorListener animatorListener = animatorListener3;
                        if (animatorListener != null) {
                            animatorListener.onAnimationStart(animator);
                        }
                    }

                    public void onAnimationEnd(Animator animator) {
                        GLBaseMapView.this.setCenter(latLng);
                        GLBaseMapView.this.setCenterOffset(f3, f4);
                        Animator.AnimatorListener animatorListener = animatorListener3;
                        if (animatorListener != null) {
                            animatorListener.onAnimationEnd(animator);
                        }
                    }

                    public void onAnimationCancel(Animator animator) {
                        Animator.AnimatorListener animatorListener = animatorListener3;
                        if (animatorListener != null) {
                            animatorListener.onAnimationCancel(animator);
                        }
                    }

                    public void onAnimationRepeat(Animator animator) {
                        Animator.AnimatorListener animatorListener = animatorListener3;
                        if (animatorListener != null) {
                            animatorListener.onAnimationRepeat(animator);
                        }
                    }
                });
                setAnimator(animatorSet);
                startAnimator();
                return;
            }
            setCenter(position);
            setCenterOffset(f, f2);
            m16956d(camera.getRotate(), camera.getScale());
            setScale(camera.getScale());
            if (animatorListener2 != null) {
                animatorListener2.onAnimationCancel((Animator) null);
            }
        }
    }

    public void navigate4MapFullView(final Camera camera, long j, Animator.AnimatorListener animatorListener) {
        if (getLocator() != null) {
            Camera camera2 = getCamera();
            final LatLng center = camera2.getCenter();
            Future future = get(new Callable<PointF>() {
                public PointF call() throws Exception {
                    return GLBaseMapView.this.f23894x.calculateTargetOffset(center, camera, GLBaseMapView.this.f23840B, GLBaseMapView.this.f23841C);
                }
            });
            final float f = this.f23873ai;
            final float f2 = this.f23874aj;
            PointF pointF = (PointF) futureGet(future);
            if (pointF != null) {
                GLAnimator gLAnimator = new GLAnimator();
                gLAnimator.setFloatValues(new float[]{camera2.getScale(), camera.getScale()});
                gLAnimator.setDuration(j);
                gLAnimator.setInterpolator(new FastOutSlowInInterpolator());
                gLAnimator.setEvaluator(new FloatEvaluator());
                gLAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        GLBaseMapView.this.setScale(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                });
                PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("offsetX", new float[]{getCenterOffsetX(), pointF.x});
                PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("offsetY", new float[]{getCenterOffsetY(), pointF.y});
                GLAnimator gLAnimator2 = new GLAnimator();
                gLAnimator2.setValues(new PropertyValuesHolder[]{ofFloat, ofFloat2});
                gLAnimator2.setDuration(j);
                gLAnimator2.setInterpolator(new FastOutSlowInInterpolator());
                gLAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        GLBaseMapView.this.setCenterOffset(((Float) valueAnimator.getAnimatedValue("offsetX")).floatValue(), ((Float) valueAnimator.getAnimatedValue("offsetY")).floatValue());
                    }
                });
                PropertyValuesHolder ofObject = PropertyValuesHolder.ofObject(NNGestureClassfy.ROTATE_LABLE, AngleEvaluator.INSTANCE, new Object[]{Float.valueOf(camera2.getRotate()), Float.valueOf(camera.getRotate())});
                PropertyValuesHolder ofFloat3 = PropertyValuesHolder.ofFloat("skew", new float[]{camera2.getSkew(), camera.getSkew()});
                GLAnimator gLAnimator3 = new GLAnimator();
                gLAnimator3.setDuration(j);
                gLAnimator3.setValues(new PropertyValuesHolder[]{ofObject, ofFloat3});
                gLAnimator3.setInterpolator(new FastOutSlowInInterpolator());
                gLAnimator3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        GLBaseMapView.this.m16956d(((Float) valueAnimator.getAnimatedValue(NNGestureClassfy.ROTATE_LABLE)).floatValue(), ((Float) valueAnimator.getAnimatedValue("skew")).floatValue());
                    }
                });
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(new Animator[]{gLAnimator, gLAnimator3, gLAnimator2});
                final Animator.AnimatorListener animatorListener2 = animatorListener;
                final Camera camera3 = camera;
                animatorSet.addListener(new Animator.AnimatorListener() {
                    public void onAnimationStart(Animator animator) {
                        Animator.AnimatorListener animatorListener = animatorListener2;
                        if (animatorListener != null) {
                            animatorListener.onAnimationStart(animator);
                        }
                    }

                    public void onAnimationEnd(Animator animator) {
                        GLBaseMapView.this.setCenterOffset(f, f2);
                        GLBaseMapView.this.setCamera(camera3);
                        Animator.AnimatorListener animatorListener = animatorListener2;
                        if (animatorListener != null) {
                            animatorListener.onAnimationEnd(animator);
                        }
                    }

                    public void onAnimationCancel(Animator animator) {
                        GLBaseMapView.this.setCenterOffset(f, f2);
                        GLBaseMapView.this.setCamera(camera3);
                        Animator.AnimatorListener animatorListener = animatorListener2;
                        if (animatorListener != null) {
                            animatorListener.onAnimationCancel(animator);
                        }
                    }

                    public void onAnimationRepeat(Animator animator) {
                        Animator.AnimatorListener animatorListener = animatorListener2;
                        if (animatorListener != null) {
                            animatorListener.onAnimationRepeat(animator);
                        }
                    }
                });
                setAnimator(animatorSet);
                startAnimator();
            }
        }
    }
}
