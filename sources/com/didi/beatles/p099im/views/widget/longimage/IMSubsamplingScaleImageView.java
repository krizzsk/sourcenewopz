package com.didi.beatles.p099im.views.widget.longimage;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import com.didi.passenger.C10448R;
import com.didi.sdk.apm.SystemUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executor;

/* renamed from: com.didi.beatles.im.views.widget.longimage.IMSubsamplingScaleImageView */
public class IMSubsamplingScaleImageView extends View {
    public static final int EASE_IN_OUT_QUAD = 2;
    public static final int EASE_OUT_QUAD = 1;
    public static final int ORIENTATION_0 = 0;
    public static final int ORIENTATION_180 = 180;
    public static final int ORIENTATION_270 = 270;
    public static final int ORIENTATION_90 = 90;
    public static final int ORIENTATION_USE_EXIF = -1;
    public static final int ORIGIN_ANIM = 1;
    public static final int ORIGIN_DOUBLE_TAP_ZOOM = 4;
    public static final int ORIGIN_FLING = 3;
    public static final int ORIGIN_TOUCH = 2;
    public static final int PAN_LIMIT_CENTER = 3;
    public static final int PAN_LIMIT_INSIDE = 1;
    public static final int PAN_LIMIT_OUTSIDE = 2;
    public static final int SCALE_TYPE_CENTER_CROP = 2;
    public static final int SCALE_TYPE_CENTER_INSIDE = 1;
    public static final int SCALE_TYPE_CUSTOM = 3;
    public static int TILE_SIZE_AUTO = Integer.MAX_VALUE;
    public static final int ZOOM_FOCUS_CENTER = 2;
    public static final int ZOOM_FOCUS_CENTER_IMMEDIATE = 3;
    public static final int ZOOM_FOCUS_FIXED = 1;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f10535a = IMSubsamplingScaleImageView.class.getSimpleName();

    /* renamed from: an */
    private static final int f10536an = 1;

    /* renamed from: b */
    private static final List<Integer> f10537b = Arrays.asList(new Integer[]{0, 90, 180, 270, -1});

    /* renamed from: c */
    private static final List<Integer> f10538c = Arrays.asList(new Integer[]{1, 2, 3});
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static final List<Integer> f10539d = Arrays.asList(new Integer[]{2, 1});

    /* renamed from: e */
    private static final List<Integer> f10540e = Arrays.asList(new Integer[]{1, 2, 3});

    /* renamed from: f */
    private static final List<Integer> f10541f = Arrays.asList(new Integer[]{2, 1, 3});

    /* renamed from: A */
    private int f10542A;

    /* renamed from: B */
    private int f10543B;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public float f10544C;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public float f10545D;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public PointF f10546E;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public PointF f10547F;

    /* renamed from: G */
    private PointF f10548G;

    /* renamed from: H */
    private Float f10549H;

    /* renamed from: I */
    private PointF f10550I;

    /* renamed from: J */
    private PointF f10551J;

    /* renamed from: K */
    private int f10552K;

    /* renamed from: L */
    private int f10553L;

    /* renamed from: M */
    private int f10554M;
    /* access modifiers changed from: private */

    /* renamed from: N */
    public Rect f10555N;

    /* renamed from: O */
    private Rect f10556O;
    /* access modifiers changed from: private */

    /* renamed from: P */
    public boolean f10557P;

    /* renamed from: Q */
    private boolean f10558Q;
    /* access modifiers changed from: private */

    /* renamed from: R */
    public boolean f10559R;
    /* access modifiers changed from: private */

    /* renamed from: S */
    public int f10560S;

    /* renamed from: T */
    private GestureDetector f10561T;

    /* renamed from: U */
    private ImageRegionDecoder f10562U;
    /* access modifiers changed from: private */

    /* renamed from: V */
    public final Object f10563V;

    /* renamed from: W */
    private DecoderFactory<? extends ImageDecoder> f10564W;

    /* renamed from: X */
    private DecoderFactory<? extends ImageRegionDecoder> f10565X;
    /* access modifiers changed from: private */

    /* renamed from: Y */
    public PointF f10566Y;

    /* renamed from: Z */
    private float f10567Z;

    /* renamed from: aa */
    private final float f10568aa;
    /* access modifiers changed from: private */

    /* renamed from: ab */
    public float f10569ab;
    /* access modifiers changed from: private */

    /* renamed from: ac */
    public boolean f10570ac;
    /* access modifiers changed from: private */

    /* renamed from: ad */
    public PointF f10571ad;
    /* access modifiers changed from: private */

    /* renamed from: ae */
    public PointF f10572ae;
    /* access modifiers changed from: private */

    /* renamed from: af */
    public PointF f10573af;
    /* access modifiers changed from: private */

    /* renamed from: ag */
    public Anim f10574ag;
    /* access modifiers changed from: private */

    /* renamed from: ah */
    public boolean f10575ah;

    /* renamed from: ai */
    private boolean f10576ai;
    /* access modifiers changed from: private */

    /* renamed from: aj */
    public OnImageEventListener f10577aj;

    /* renamed from: ak */
    private OnStateChangedListener f10578ak;
    /* access modifiers changed from: private */

    /* renamed from: al */
    public View.OnLongClickListener f10579al;

    /* renamed from: am */
    private Handler f10580am;

    /* renamed from: ao */
    private Paint f10581ao;

    /* renamed from: ap */
    private Paint f10582ap;

    /* renamed from: aq */
    private Paint f10583aq;

    /* renamed from: ar */
    private ScaleAndTranslate f10584ar;

    /* renamed from: as */
    private Matrix f10585as;

    /* renamed from: at */
    private RectF f10586at;

    /* renamed from: au */
    private float[] f10587au;

    /* renamed from: av */
    private float[] f10588av;

    /* renamed from: aw */
    private float f10589aw;

    /* renamed from: g */
    private Bitmap f10590g;

    /* renamed from: h */
    private boolean f10591h;

    /* renamed from: i */
    private boolean f10592i;

    /* renamed from: j */
    private Uri f10593j;

    /* renamed from: k */
    private int f10594k;

    /* renamed from: l */
    private Map<Integer, List<Tile>> f10595l;

    /* renamed from: m */
    private boolean f10596m;

    /* renamed from: n */
    private int f10597n;

    /* renamed from: o */
    private float f10598o;

    /* renamed from: p */
    private float f10599p;

    /* renamed from: q */
    private int f10600q;

    /* renamed from: r */
    private int f10601r;

    /* renamed from: s */
    private int f10602s;

    /* renamed from: t */
    private int f10603t;

    /* renamed from: u */
    private int f10604u;

    /* renamed from: v */
    private boolean f10605v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public boolean f10606w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public boolean f10607x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public boolean f10608y;

    /* renamed from: z */
    private float f10609z;

    /* renamed from: com.didi.beatles.im.views.widget.longimage.IMSubsamplingScaleImageView$DefaultOnAnimationEventListener */
    public static class DefaultOnAnimationEventListener implements OnAnimationEventListener {
        public void onComplete() {
        }

        public void onInterruptedByNewAnim() {
        }

        public void onInterruptedByUser() {
        }
    }

    /* renamed from: com.didi.beatles.im.views.widget.longimage.IMSubsamplingScaleImageView$DefaultOnImageEventListener */
    public static class DefaultOnImageEventListener implements OnImageEventListener {
        public void onImageLoadError(Exception exc) {
        }

        public void onImageLoaded() {
        }

        public void onPreviewLoadError(Exception exc) {
        }

        public void onPreviewReleased() {
        }

        public void onReady() {
        }

        public void onTileLoadError(Exception exc) {
        }
    }

    /* renamed from: com.didi.beatles.im.views.widget.longimage.IMSubsamplingScaleImageView$DefaultOnStateChangedListener */
    public static class DefaultOnStateChangedListener implements OnStateChangedListener {
        public void onCenterChanged(PointF pointF, int i) {
        }

        public void onScaleChanged(float f, int i) {
        }
    }

    /* renamed from: com.didi.beatles.im.views.widget.longimage.IMSubsamplingScaleImageView$OnAnimationEventListener */
    public interface OnAnimationEventListener {
        void onComplete();

        void onInterruptedByNewAnim();

        void onInterruptedByUser();
    }

    /* renamed from: com.didi.beatles.im.views.widget.longimage.IMSubsamplingScaleImageView$OnImageEventListener */
    public interface OnImageEventListener {
        void onImageLoadError(Exception exc);

        void onImageLoaded();

        void onPreviewLoadError(Exception exc);

        void onPreviewReleased();

        void onReady();

        void onTileLoadError(Exception exc);
    }

    /* renamed from: com.didi.beatles.im.views.widget.longimage.IMSubsamplingScaleImageView$OnStateChangedListener */
    public interface OnStateChangedListener {
        void onCenterChanged(PointF pointF, int i);

        void onScaleChanged(float f, int i);
    }

    /* renamed from: a */
    private float m7140a(long j, float f, float f2, long j2) {
        float f3 = ((float) j) / ((float) j2);
        return ((-f2) * f3 * (f3 - 2.0f)) + f;
    }

    /* renamed from: b */
    private float m7180b(long j, float f, float f2, long j2) {
        float f3;
        float f4 = ((float) j) / (((float) j2) / 2.0f);
        if (f4 < 1.0f) {
            f3 = (f2 / 2.0f) * f4;
        } else {
            float f5 = f4 - 1.0f;
            f3 = (-f2) / 2.0f;
            f4 = (f5 * (f5 - 2.0f)) - 1.0f;
        }
        return (f3 * f4) + f;
    }

    /* access modifiers changed from: protected */
    public void onImageLoaded() {
    }

    /* access modifiers changed from: protected */
    public void onReady() {
    }

    public IMSubsamplingScaleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int resourceId;
        String string;
        this.f10597n = 0;
        this.f10598o = 2.0f;
        this.f10599p = m7217k();
        this.f10600q = -1;
        this.f10601r = 1;
        this.f10602s = 1;
        int i = TILE_SIZE_AUTO;
        this.f10603t = i;
        this.f10604u = i;
        this.f10606w = true;
        this.f10607x = true;
        this.f10608y = true;
        this.f10609z = 1.0f;
        this.f10542A = 1;
        this.f10543B = 500;
        this.f10563V = new Object();
        this.f10564W = new CompatDecoderFactory(IMSkiaImageDecoder.class);
        this.f10565X = new CompatDecoderFactory(IMSkiaImageRegionDecoder.class);
        this.f10587au = new float[8];
        this.f10588av = new float[8];
        this.f10589aw = getResources().getDisplayMetrics().density;
        setMinimumDpi(160);
        setDoubleTapZoomDpi(160);
        setGestureDetector(context);
        this.f10580am = new Handler(new Handler.Callback() {
            public boolean handleMessage(Message message) {
                if (message.what == 1 && IMSubsamplingScaleImageView.this.f10579al != null) {
                    int unused = IMSubsamplingScaleImageView.this.f10560S = 0;
                    IMSubsamplingScaleImageView iMSubsamplingScaleImageView = IMSubsamplingScaleImageView.this;
                    IMSubsamplingScaleImageView.super.setOnLongClickListener(iMSubsamplingScaleImageView.f10579al);
                    IMSubsamplingScaleImageView.this.performLongClick();
                    IMSubsamplingScaleImageView.super.setOnLongClickListener((View.OnLongClickListener) null);
                }
                return true;
            }
        });
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C10448R.styleable.IMSubsamplingScaleImageView);
            if (obtainStyledAttributes.hasValue(0) && (string = obtainStyledAttributes.getString(0)) != null && string.length() > 0) {
                setImage(IMImageSource.asset(string).tilingEnabled());
            }
            if (obtainStyledAttributes.hasValue(3) && (resourceId = obtainStyledAttributes.getResourceId(3, 0)) > 0) {
                setImage(IMImageSource.resource(resourceId).tilingEnabled());
            }
            if (obtainStyledAttributes.hasValue(1)) {
                setPanEnabled(obtainStyledAttributes.getBoolean(1, true));
            }
            if (obtainStyledAttributes.hasValue(5)) {
                setZoomEnabled(obtainStyledAttributes.getBoolean(5, true));
            }
            if (obtainStyledAttributes.hasValue(2)) {
                setQuickScaleEnabled(obtainStyledAttributes.getBoolean(2, true));
            }
            if (obtainStyledAttributes.hasValue(4)) {
                setTileBackgroundColor(obtainStyledAttributes.getColor(4, Color.argb(0, 0, 0, 0)));
            }
            obtainStyledAttributes.recycle();
        }
        this.f10568aa = TypedValue.applyDimension(1, 20.0f, context.getResources().getDisplayMetrics());
    }

    public IMSubsamplingScaleImageView(Context context) {
        this(context, (AttributeSet) null);
    }

    public final void setOrientation(int i) {
        if (f10537b.contains(Integer.valueOf(i))) {
            this.f10597n = i;
            m7173a(false);
            invalidate();
            requestLayout();
            return;
        }
        throw new IllegalArgumentException("Invalid orientation: " + i);
    }

    public final void setImage(IMImageSource iMImageSource) {
        setImage(iMImageSource, (IMImageSource) null, (IMImageViewState) null);
    }

    public final void setImage(IMImageSource iMImageSource, IMImageViewState iMImageViewState) {
        setImage(iMImageSource, (IMImageSource) null, iMImageViewState);
    }

    public final void setImage(IMImageSource iMImageSource, IMImageSource iMImageSource2) {
        setImage(iMImageSource, iMImageSource2, (IMImageViewState) null);
    }

    public final void setImage(IMImageSource iMImageSource, IMImageSource iMImageSource2, IMImageViewState iMImageViewState) {
        if (iMImageSource != null) {
            m7173a(true);
            if (iMImageViewState != null) {
                m7161a(iMImageViewState);
            }
            if (iMImageSource2 != null) {
                if (iMImageSource.getBitmap() != null) {
                    throw new IllegalArgumentException("Preview image cannot be used when a bitmap is provided for the main image");
                } else if (iMImageSource.getSWidth() <= 0 || iMImageSource.getSHeight() <= 0) {
                    throw new IllegalArgumentException("Preview image cannot be used unless dimensions are provided for the main image");
                } else {
                    this.f10552K = iMImageSource.getSWidth();
                    this.f10553L = iMImageSource.getSHeight();
                    this.f10556O = iMImageSource2.getSRegion();
                    if (iMImageSource2.getBitmap() != null) {
                        this.f10592i = iMImageSource2.isCached();
                        m7155a(iMImageSource2.getBitmap());
                    } else {
                        Uri uri = iMImageSource2.getUri();
                        if (uri == null && iMImageSource2.getResource() != null) {
                            uri = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + iMImageSource2.getResource());
                        }
                        m7160a((AsyncTask<Void, Void, ?>) new BitmapLoadTask(this, getContext(), this.f10564W, uri, true));
                    }
                }
            }
            if (iMImageSource.getBitmap() != null && iMImageSource.getSRegion() != null) {
                m7156a(Bitmap.createBitmap(iMImageSource.getBitmap(), iMImageSource.getSRegion().left, iMImageSource.getSRegion().top, iMImageSource.getSRegion().width(), iMImageSource.getSRegion().height()), 0, false);
            } else if (iMImageSource.getBitmap() != null) {
                m7156a(iMImageSource.getBitmap(), 0, iMImageSource.isCached());
            } else {
                this.f10555N = iMImageSource.getSRegion();
                Uri uri2 = iMImageSource.getUri();
                this.f10593j = uri2;
                if (uri2 == null && iMImageSource.getResource() != null) {
                    this.f10593j = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + iMImageSource.getResource());
                }
                if (iMImageSource.getTile() || this.f10555N != null) {
                    m7160a((AsyncTask<Void, Void, ?>) new TilesInitTask(this, getContext(), this.f10565X, this.f10593j));
                    return;
                }
                m7160a((AsyncTask<Void, Void, ?>) new BitmapLoadTask(this, getContext(), this.f10564W, this.f10593j, false));
            }
        } else {
            throw new NullPointerException("imageSource must not be null");
        }
    }

    /* renamed from: a */
    private void m7173a(boolean z) {
        OnImageEventListener onImageEventListener;
        m7172a("reset newImage=" + z, new Object[0]);
        this.f10544C = 0.0f;
        this.f10545D = 0.0f;
        this.f10546E = null;
        this.f10547F = null;
        this.f10548G = null;
        this.f10549H = Float.valueOf(0.0f);
        this.f10550I = null;
        this.f10551J = null;
        this.f10557P = false;
        this.f10558Q = false;
        this.f10559R = false;
        this.f10560S = 0;
        this.f10594k = 0;
        this.f10566Y = null;
        this.f10567Z = 0.0f;
        this.f10569ab = 0.0f;
        this.f10570ac = false;
        this.f10572ae = null;
        this.f10571ad = null;
        this.f10573af = null;
        this.f10574ag = null;
        this.f10584ar = null;
        this.f10585as = null;
        this.f10586at = null;
        if (z) {
            this.f10593j = null;
            if (this.f10562U != null) {
                synchronized (this.f10563V) {
                    this.f10562U.recycle();
                    this.f10562U = null;
                }
            }
            Bitmap bitmap = this.f10590g;
            if (bitmap != null && !this.f10592i) {
                bitmap.recycle();
            }
            if (!(this.f10590g == null || !this.f10592i || (onImageEventListener = this.f10577aj) == null)) {
                onImageEventListener.onPreviewReleased();
            }
            this.f10552K = 0;
            this.f10553L = 0;
            this.f10554M = 0;
            this.f10555N = null;
            this.f10556O = null;
            this.f10575ah = false;
            this.f10576ai = false;
            this.f10590g = null;
            this.f10591h = false;
            this.f10592i = false;
        }
        Map<Integer, List<Tile>> map = this.f10595l;
        if (map != null) {
            for (Map.Entry<Integer, List<Tile>> value : map.entrySet()) {
                for (Tile tile : (List) value.getValue()) {
                    boolean unused = tile.visible = false;
                    if (tile.bitmap != null) {
                        tile.bitmap.recycle();
                        Bitmap unused2 = tile.bitmap = null;
                    }
                }
            }
            this.f10595l = null;
        }
        setGestureDetector(getContext());
    }

    /* access modifiers changed from: private */
    public void setGestureDetector(final Context context) {
        this.f10561T = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (!IMSubsamplingScaleImageView.this.f10606w || !IMSubsamplingScaleImageView.this.f10575ah || IMSubsamplingScaleImageView.this.f10546E == null || motionEvent == null || motionEvent2 == null || ((Math.abs(motionEvent.getX() - motionEvent2.getX()) <= 50.0f && Math.abs(motionEvent.getY() - motionEvent2.getY()) <= 50.0f) || ((Math.abs(f) <= 500.0f && Math.abs(f2) <= 500.0f) || IMSubsamplingScaleImageView.this.f10557P))) {
                    return super.onFling(motionEvent, motionEvent2, f, f2);
                }
                PointF pointF = new PointF(IMSubsamplingScaleImageView.this.f10546E.x + (f * 0.25f), IMSubsamplingScaleImageView.this.f10546E.y + (f2 * 0.25f));
                new AnimationBuilder(new PointF((((float) (IMSubsamplingScaleImageView.this.getWidth() / 2)) - pointF.x) / IMSubsamplingScaleImageView.this.f10544C, (((float) (IMSubsamplingScaleImageView.this.getHeight() / 2)) - pointF.y) / IMSubsamplingScaleImageView.this.f10544C)).withEasing(1).withPanLimited(false).withOrigin(3).start();
                return true;
            }

            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                IMSubsamplingScaleImageView.this.performClick();
                return true;
            }

            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (!IMSubsamplingScaleImageView.this.f10607x || !IMSubsamplingScaleImageView.this.f10575ah || IMSubsamplingScaleImageView.this.f10546E == null) {
                    return super.onDoubleTapEvent(motionEvent);
                }
                IMSubsamplingScaleImageView.this.setGestureDetector(context);
                if (IMSubsamplingScaleImageView.this.f10608y) {
                    PointF unused = IMSubsamplingScaleImageView.this.f10566Y = new PointF(motionEvent.getX(), motionEvent.getY());
                    PointF unused2 = IMSubsamplingScaleImageView.this.f10547F = new PointF(IMSubsamplingScaleImageView.this.f10546E.x, IMSubsamplingScaleImageView.this.f10546E.y);
                    IMSubsamplingScaleImageView iMSubsamplingScaleImageView = IMSubsamplingScaleImageView.this;
                    float unused3 = iMSubsamplingScaleImageView.f10545D = iMSubsamplingScaleImageView.f10544C;
                    boolean unused4 = IMSubsamplingScaleImageView.this.f10559R = true;
                    boolean unused5 = IMSubsamplingScaleImageView.this.f10557P = true;
                    float unused6 = IMSubsamplingScaleImageView.this.f10569ab = -1.0f;
                    IMSubsamplingScaleImageView iMSubsamplingScaleImageView2 = IMSubsamplingScaleImageView.this;
                    PointF unused7 = iMSubsamplingScaleImageView2.f10572ae = iMSubsamplingScaleImageView2.viewToSourceCoord(iMSubsamplingScaleImageView2.f10566Y);
                    PointF unused8 = IMSubsamplingScaleImageView.this.f10573af = new PointF(motionEvent.getX(), motionEvent.getY());
                    PointF unused9 = IMSubsamplingScaleImageView.this.f10571ad = new PointF(IMSubsamplingScaleImageView.this.f10572ae.x, IMSubsamplingScaleImageView.this.f10572ae.y);
                    boolean unused10 = IMSubsamplingScaleImageView.this.f10570ac = false;
                    return false;
                }
                IMSubsamplingScaleImageView iMSubsamplingScaleImageView3 = IMSubsamplingScaleImageView.this;
                iMSubsamplingScaleImageView3.m7158a(iMSubsamplingScaleImageView3.viewToSourceCoord(new PointF(motionEvent.getX(), motionEvent.getY())), new PointF(motionEvent.getX(), motionEvent.getY()));
                return true;
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        m7172a("onSizeChanged %dx%d -> %dx%d", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i), Integer.valueOf(i2));
        PointF center = getCenter();
        if (this.f10575ah && center != null) {
            this.f10574ag = null;
            this.f10549H = Float.valueOf(this.f10544C);
            this.f10550I = center;
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        boolean z = true;
        boolean z2 = mode != 1073741824;
        if (mode2 == 1073741824) {
            z = false;
        }
        if (this.f10552K > 0 && this.f10553L > 0) {
            if (z2 && z) {
                size = m7213i();
                size2 = m7215j();
            } else if (z) {
                size2 = (int) ((((double) m7215j()) / ((double) m7213i())) * ((double) size));
            } else if (z2) {
                size = (int) ((((double) m7213i()) / ((double) m7215j())) * ((double) size2));
            }
        }
        setMeasuredDimension(Math.max(size, getSuggestedMinimumWidth()), Math.max(size2, getSuggestedMinimumHeight()));
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        GestureDetector gestureDetector;
        Anim anim = this.f10574ag;
        if (anim == null || anim.interruptible) {
            Anim anim2 = this.f10574ag;
            if (!(anim2 == null || anim2.listener == null)) {
                try {
                    this.f10574ag.listener.onInterruptedByUser();
                } catch (Exception e) {
                    SystemUtils.log(5, f10535a, "Error thrown by animation listener", e, "com.didi.beatles.im.views.widget.longimage.IMSubsamplingScaleImageView", 673);
                }
            }
            this.f10574ag = null;
            if (this.f10546E == null) {
                return true;
            }
            if (this.f10559R || ((gestureDetector = this.f10561T) != null && !gestureDetector.onTouchEvent(motionEvent))) {
                if (this.f10547F == null) {
                    this.f10547F = new PointF(0.0f, 0.0f);
                }
                if (this.f10548G == null) {
                    this.f10548G = new PointF(0.0f, 0.0f);
                }
                if (this.f10566Y == null) {
                    this.f10566Y = new PointF(0.0f, 0.0f);
                }
                float f = this.f10544C;
                this.f10548G.set(this.f10546E);
                boolean a = m7176a(motionEvent);
                m7154a(f, this.f10548G, 2);
                if (a || super.onTouchEvent(motionEvent)) {
                    return true;
                }
                return false;
            }
            this.f10557P = false;
            this.f10558Q = false;
            this.f10560S = 0;
            return true;
        }
        m7187b(true);
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001f, code lost:
        if (r1 != 262) goto L_0x03e4;
     */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x03db  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m7176a(android.view.MotionEvent r13) {
        /*
            r12 = this;
            int r0 = r13.getPointerCount()
            int r1 = r13.getAction()
            r2 = 1073741824(0x40000000, float:2.0)
            r3 = 2
            r4 = 0
            r5 = 1
            if (r1 == 0) goto L_0x0455
            if (r1 == r5) goto L_0x03e5
            if (r1 == r3) goto L_0x0023
            r6 = 5
            if (r1 == r6) goto L_0x0455
            r6 = 6
            if (r1 == r6) goto L_0x03e5
            r6 = 261(0x105, float:3.66E-43)
            if (r1 == r6) goto L_0x0455
            r2 = 262(0x106, float:3.67E-43)
            if (r1 == r2) goto L_0x03e5
            goto L_0x03e4
        L_0x0023:
            int r1 = r12.f10560S
            if (r1 <= 0) goto L_0x03d8
            r1 = 1084227584(0x40a00000, float:5.0)
            if (r0 < r3) goto L_0x0190
            float r0 = r13.getX(r4)
            float r6 = r13.getX(r5)
            float r7 = r13.getY(r4)
            float r8 = r13.getY(r5)
            float r0 = r12.m7138a((float) r0, (float) r6, (float) r7, (float) r8)
            float r6 = r13.getX(r4)
            float r7 = r13.getX(r5)
            float r6 = r6 + r7
            float r6 = r6 / r2
            float r7 = r13.getY(r4)
            float r13 = r13.getY(r5)
            float r7 = r7 + r13
            float r7 = r7 / r2
            boolean r13 = r12.f10607x
            if (r13 == 0) goto L_0x03d8
            android.graphics.PointF r13 = r12.f10566Y
            float r13 = r13.x
            android.graphics.PointF r2 = r12.f10566Y
            float r2 = r2.y
            float r13 = r12.m7138a((float) r13, (float) r6, (float) r2, (float) r7)
            int r13 = (r13 > r1 ? 1 : (r13 == r1 ? 0 : -1))
            if (r13 > 0) goto L_0x0077
            float r13 = r12.f10567Z
            float r13 = r0 - r13
            float r13 = java.lang.Math.abs(r13)
            int r13 = (r13 > r1 ? 1 : (r13 == r1 ? 0 : -1))
            if (r13 > 0) goto L_0x0077
            boolean r13 = r12.f10558Q
            if (r13 == 0) goto L_0x03d8
        L_0x0077:
            r12.f10557P = r5
            r12.f10558Q = r5
            float r13 = r12.f10544C
            double r1 = (double) r13
            float r13 = r12.f10598o
            float r8 = r12.f10567Z
            float r8 = r0 / r8
            float r9 = r12.f10545D
            float r8 = r8 * r9
            float r13 = java.lang.Math.min(r13, r8)
            r12.f10544C = r13
            float r8 = r12.m7217k()
            int r13 = (r13 > r8 ? 1 : (r13 == r8 ? 0 : -1))
            if (r13 > 0) goto L_0x00ac
            r12.f10567Z = r0
            float r13 = r12.m7217k()
            r12.f10545D = r13
            android.graphics.PointF r13 = r12.f10566Y
            r13.set(r6, r7)
            android.graphics.PointF r13 = r12.f10547F
            android.graphics.PointF r0 = r12.f10546E
            r13.set(r0)
            goto L_0x0188
        L_0x00ac:
            boolean r13 = r12.f10606w
            if (r13 == 0) goto L_0x0133
            android.graphics.PointF r13 = r12.f10566Y
            float r13 = r13.x
            android.graphics.PointF r3 = r12.f10547F
            float r3 = r3.x
            float r13 = r13 - r3
            android.graphics.PointF r3 = r12.f10566Y
            float r3 = r3.y
            android.graphics.PointF r8 = r12.f10547F
            float r8 = r8.y
            float r3 = r3 - r8
            float r8 = r12.f10544C
            float r9 = r12.f10545D
            float r10 = r8 / r9
            float r13 = r13 * r10
            float r8 = r8 / r9
            float r3 = r3 * r8
            android.graphics.PointF r8 = r12.f10546E
            float r13 = r6 - r13
            r8.x = r13
            android.graphics.PointF r13 = r12.f10546E
            float r3 = r7 - r3
            r13.y = r3
            int r13 = r12.m7215j()
            double r8 = (double) r13
            double r8 = r8 * r1
            int r13 = r12.getHeight()
            double r10 = (double) r13
            int r13 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r13 >= 0) goto L_0x00fb
            float r13 = r12.f10544C
            int r3 = r12.m7215j()
            float r3 = (float) r3
            float r13 = r13 * r3
            int r3 = r12.getHeight()
            float r3 = (float) r3
            int r13 = (r13 > r3 ? 1 : (r13 == r3 ? 0 : -1))
            if (r13 >= 0) goto L_0x011d
        L_0x00fb:
            int r13 = r12.m7213i()
            double r8 = (double) r13
            double r1 = r1 * r8
            int r13 = r12.getWidth()
            double r8 = (double) r13
            int r13 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r13 >= 0) goto L_0x0188
            float r13 = r12.f10544C
            int r1 = r12.m7213i()
            float r1 = (float) r1
            float r13 = r13 * r1
            int r1 = r12.getWidth()
            float r1 = (float) r1
            int r13 = (r13 > r1 ? 1 : (r13 == r1 ? 0 : -1))
            if (r13 < 0) goto L_0x0188
        L_0x011d:
            r12.m7200d((boolean) r5)
            android.graphics.PointF r13 = r12.f10566Y
            r13.set(r6, r7)
            android.graphics.PointF r13 = r12.f10547F
            android.graphics.PointF r1 = r12.f10546E
            r13.set(r1)
            float r13 = r12.f10544C
            r12.f10545D = r13
            r12.f10567Z = r0
            goto L_0x0188
        L_0x0133:
            android.graphics.PointF r13 = r12.f10551J
            if (r13 == 0) goto L_0x015e
            android.graphics.PointF r13 = r12.f10546E
            int r0 = r12.getWidth()
            int r0 = r0 / r3
            float r0 = (float) r0
            float r1 = r12.f10544C
            android.graphics.PointF r2 = r12.f10551J
            float r2 = r2.x
            float r1 = r1 * r2
            float r0 = r0 - r1
            r13.x = r0
            android.graphics.PointF r13 = r12.f10546E
            int r0 = r12.getHeight()
            int r0 = r0 / r3
            float r0 = (float) r0
            float r1 = r12.f10544C
            android.graphics.PointF r2 = r12.f10551J
            float r2 = r2.y
            float r1 = r1 * r2
            float r0 = r0 - r1
            r13.y = r0
            goto L_0x0188
        L_0x015e:
            android.graphics.PointF r13 = r12.f10546E
            int r0 = r12.getWidth()
            int r0 = r0 / r3
            float r0 = (float) r0
            float r1 = r12.f10544C
            int r2 = r12.m7213i()
            int r2 = r2 / r3
            float r2 = (float) r2
            float r1 = r1 * r2
            float r0 = r0 - r1
            r13.x = r0
            android.graphics.PointF r13 = r12.f10546E
            int r0 = r12.getHeight()
            int r0 = r0 / r3
            float r0 = (float) r0
            float r1 = r12.f10544C
            int r2 = r12.m7215j()
            int r2 = r2 / r3
            float r2 = (float) r2
            float r1 = r1 * r2
            float r0 = r0 - r1
            r13.y = r0
        L_0x0188:
            r12.m7200d((boolean) r5)
            r12.m7193c((boolean) r4)
            goto L_0x02f8
        L_0x0190:
            boolean r0 = r12.f10559R
            if (r0 == 0) goto L_0x02fb
            android.graphics.PointF r0 = r12.f10573af
            float r0 = r0.y
            float r1 = r13.getY()
            float r0 = r0 - r1
            float r0 = java.lang.Math.abs(r0)
            float r0 = r0 * r2
            float r1 = r12.f10568aa
            float r0 = r0 + r1
            float r1 = r12.f10569ab
            r2 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 != 0) goto L_0x01b0
            r12.f10569ab = r0
        L_0x01b0:
            float r1 = r13.getY()
            android.graphics.PointF r2 = r12.f10571ad
            float r2 = r2.y
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 <= 0) goto L_0x01be
            r1 = 1
            goto L_0x01bf
        L_0x01be:
            r1 = 0
        L_0x01bf:
            android.graphics.PointF r2 = r12.f10571ad
            float r13 = r13.getY()
            r6 = 0
            r2.set(r6, r13)
            float r13 = r12.f10569ab
            float r13 = r0 / r13
            r2 = 1065353216(0x3f800000, float:1.0)
            float r13 = r2 - r13
            float r13 = java.lang.Math.abs(r13)
            r7 = 1056964608(0x3f000000, float:0.5)
            float r13 = r13 * r7
            r7 = 1022739087(0x3cf5c28f, float:0.03)
            int r7 = (r13 > r7 ? 1 : (r13 == r7 ? 0 : -1))
            if (r7 > 0) goto L_0x01e4
            boolean r7 = r12.f10570ac
            if (r7 == 0) goto L_0x02f0
        L_0x01e4:
            r12.f10570ac = r5
            float r7 = r12.f10569ab
            int r7 = (r7 > r6 ? 1 : (r7 == r6 ? 0 : -1))
            if (r7 <= 0) goto L_0x01f2
            if (r1 == 0) goto L_0x01f1
            float r13 = r13 + r2
            r2 = r13
            goto L_0x01f2
        L_0x01f1:
            float r2 = r2 - r13
        L_0x01f2:
            float r13 = r12.f10544C
            double r7 = (double) r13
            float r13 = r12.m7217k()
            float r1 = r12.f10598o
            float r9 = r12.f10544C
            float r9 = r9 * r2
            float r1 = java.lang.Math.min(r1, r9)
            float r13 = java.lang.Math.max(r13, r1)
            r12.f10544C = r13
            boolean r13 = r12.f10606w
            if (r13 == 0) goto L_0x029b
            android.graphics.PointF r13 = r12.f10566Y
            float r13 = r13.x
            android.graphics.PointF r1 = r12.f10547F
            float r1 = r1.x
            float r13 = r13 - r1
            android.graphics.PointF r1 = r12.f10566Y
            float r1 = r1.y
            android.graphics.PointF r2 = r12.f10547F
            float r2 = r2.y
            float r1 = r1 - r2
            float r2 = r12.f10544C
            float r3 = r12.f10545D
            float r9 = r2 / r3
            float r13 = r13 * r9
            float r2 = r2 / r3
            float r1 = r1 * r2
            android.graphics.PointF r2 = r12.f10546E
            android.graphics.PointF r3 = r12.f10566Y
            float r3 = r3.x
            float r3 = r3 - r13
            r2.x = r3
            android.graphics.PointF r13 = r12.f10546E
            android.graphics.PointF r2 = r12.f10566Y
            float r2 = r2.y
            float r2 = r2 - r1
            r13.y = r2
            int r13 = r12.m7215j()
            double r1 = (double) r13
            double r1 = r1 * r7
            int r13 = r12.getHeight()
            double r9 = (double) r13
            int r13 = (r1 > r9 ? 1 : (r1 == r9 ? 0 : -1))
            if (r13 >= 0) goto L_0x025e
            float r13 = r12.f10544C
            int r1 = r12.m7215j()
            float r1 = (float) r1
            float r13 = r13 * r1
            int r1 = r12.getHeight()
            float r1 = (float) r1
            int r13 = (r13 > r1 ? 1 : (r13 == r1 ? 0 : -1))
            if (r13 >= 0) goto L_0x0280
        L_0x025e:
            int r13 = r12.m7213i()
            double r1 = (double) r13
            double r7 = r7 * r1
            int r13 = r12.getWidth()
            double r1 = (double) r13
            int r13 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r13 >= 0) goto L_0x02f0
            float r13 = r12.f10544C
            int r1 = r12.m7213i()
            float r1 = (float) r1
            float r13 = r13 * r1
            int r1 = r12.getWidth()
            float r1 = (float) r1
            int r13 = (r13 > r1 ? 1 : (r13 == r1 ? 0 : -1))
            if (r13 < 0) goto L_0x02f0
        L_0x0280:
            r12.m7200d((boolean) r5)
            android.graphics.PointF r13 = r12.f10566Y
            android.graphics.PointF r0 = r12.f10572ae
            android.graphics.PointF r0 = r12.sourceToViewCoord(r0)
            r13.set(r0)
            android.graphics.PointF r13 = r12.f10547F
            android.graphics.PointF r0 = r12.f10546E
            r13.set(r0)
            float r13 = r12.f10544C
            r12.f10545D = r13
            r0 = 0
            goto L_0x02f0
        L_0x029b:
            android.graphics.PointF r13 = r12.f10551J
            if (r13 == 0) goto L_0x02c6
            android.graphics.PointF r13 = r12.f10546E
            int r1 = r12.getWidth()
            int r1 = r1 / r3
            float r1 = (float) r1
            float r2 = r12.f10544C
            android.graphics.PointF r6 = r12.f10551J
            float r6 = r6.x
            float r2 = r2 * r6
            float r1 = r1 - r2
            r13.x = r1
            android.graphics.PointF r13 = r12.f10546E
            int r1 = r12.getHeight()
            int r1 = r1 / r3
            float r1 = (float) r1
            float r2 = r12.f10544C
            android.graphics.PointF r3 = r12.f10551J
            float r3 = r3.y
            float r2 = r2 * r3
            float r1 = r1 - r2
            r13.y = r1
            goto L_0x02f0
        L_0x02c6:
            android.graphics.PointF r13 = r12.f10546E
            int r1 = r12.getWidth()
            int r1 = r1 / r3
            float r1 = (float) r1
            float r2 = r12.f10544C
            int r6 = r12.m7213i()
            int r6 = r6 / r3
            float r6 = (float) r6
            float r2 = r2 * r6
            float r1 = r1 - r2
            r13.x = r1
            android.graphics.PointF r13 = r12.f10546E
            int r1 = r12.getHeight()
            int r1 = r1 / r3
            float r1 = (float) r1
            float r2 = r12.f10544C
            int r6 = r12.m7215j()
            int r6 = r6 / r3
            float r3 = (float) r6
            float r2 = r2 * r3
            float r1 = r1 - r2
            r13.y = r1
        L_0x02f0:
            r12.f10569ab = r0
            r12.m7200d((boolean) r5)
            r12.m7193c((boolean) r4)
        L_0x02f8:
            r13 = 1
            goto L_0x03d9
        L_0x02fb:
            boolean r0 = r12.f10557P
            if (r0 != 0) goto L_0x03d8
            float r0 = r13.getX()
            android.graphics.PointF r2 = r12.f10566Y
            float r2 = r2.x
            float r0 = r0 - r2
            float r0 = java.lang.Math.abs(r0)
            float r2 = r13.getY()
            android.graphics.PointF r3 = r12.f10566Y
            float r3 = r3.y
            float r2 = r2 - r3
            float r2 = java.lang.Math.abs(r2)
            float r3 = r12.f10589aw
            float r3 = r3 * r1
            int r1 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r1 > 0) goto L_0x0329
            int r6 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r6 > 0) goto L_0x0329
            boolean r6 = r12.f10558Q
            if (r6 == 0) goto L_0x03d8
        L_0x0329:
            android.graphics.PointF r6 = r12.f10546E
            android.graphics.PointF r7 = r12.f10547F
            float r7 = r7.x
            float r8 = r13.getX()
            android.graphics.PointF r9 = r12.f10566Y
            float r9 = r9.x
            float r8 = r8 - r9
            float r7 = r7 + r8
            r6.x = r7
            android.graphics.PointF r6 = r12.f10546E
            android.graphics.PointF r7 = r12.f10547F
            float r7 = r7.y
            float r13 = r13.getY()
            android.graphics.PointF r8 = r12.f10566Y
            float r8 = r8.y
            float r13 = r13 - r8
            float r7 = r7 + r13
            r6.y = r7
            android.graphics.PointF r13 = r12.f10546E
            float r13 = r13.x
            android.graphics.PointF r6 = r12.f10546E
            float r6 = r6.y
            r12.m7200d((boolean) r5)
            android.graphics.PointF r7 = r12.f10546E
            float r7 = r7.x
            int r13 = (r13 > r7 ? 1 : (r13 == r7 ? 0 : -1))
            if (r13 == 0) goto L_0x0362
            r13 = 1
            goto L_0x0363
        L_0x0362:
            r13 = 0
        L_0x0363:
            android.graphics.PointF r7 = r12.f10546E
            float r7 = r7.y
            int r7 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r7 == 0) goto L_0x036d
            r7 = 1
            goto L_0x036e
        L_0x036d:
            r7 = 0
        L_0x036e:
            if (r13 == 0) goto L_0x037a
            int r8 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r8 <= 0) goto L_0x037a
            boolean r8 = r12.f10558Q
            if (r8 != 0) goto L_0x037a
            r8 = 1
            goto L_0x037b
        L_0x037a:
            r8 = 0
        L_0x037b:
            if (r7 == 0) goto L_0x0387
            int r0 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x0387
            boolean r0 = r12.f10558Q
            if (r0 != 0) goto L_0x0387
            r0 = 1
            goto L_0x0388
        L_0x0387:
            r0 = 0
        L_0x0388:
            android.graphics.PointF r9 = r12.f10546E
            float r9 = r9.y
            int r6 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r6 != 0) goto L_0x039a
            r6 = 1077936128(0x40400000, float:3.0)
            float r6 = r6 * r3
            int r6 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r6 <= 0) goto L_0x039a
            r6 = 1
            goto L_0x039b
        L_0x039a:
            r6 = 0
        L_0x039b:
            if (r8 != 0) goto L_0x03ac
            if (r0 != 0) goto L_0x03ac
            if (r13 == 0) goto L_0x03a9
            if (r7 == 0) goto L_0x03a9
            if (r6 != 0) goto L_0x03a9
            boolean r13 = r12.f10558Q
            if (r13 == 0) goto L_0x03ac
        L_0x03a9:
            r12.f10558Q = r5
            goto L_0x03bc
        L_0x03ac:
            if (r1 > 0) goto L_0x03b2
            int r13 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r13 <= 0) goto L_0x03bc
        L_0x03b2:
            r12.f10560S = r4
            android.os.Handler r13 = r12.f10580am
            r13.removeMessages(r5)
            r12.m7187b((boolean) r4)
        L_0x03bc:
            boolean r13 = r12.f10606w
            if (r13 != 0) goto L_0x03d3
            android.graphics.PointF r13 = r12.f10546E
            android.graphics.PointF r0 = r12.f10547F
            float r0 = r0.x
            r13.x = r0
            android.graphics.PointF r13 = r12.f10546E
            android.graphics.PointF r0 = r12.f10547F
            float r0 = r0.y
            r13.y = r0
            r12.m7187b((boolean) r4)
        L_0x03d3:
            r12.m7193c((boolean) r4)
            goto L_0x02f8
        L_0x03d8:
            r13 = 0
        L_0x03d9:
            if (r13 == 0) goto L_0x03e4
            android.os.Handler r13 = r12.f10580am
            r13.removeMessages(r5)
            r12.invalidate()
            return r5
        L_0x03e4:
            return r4
        L_0x03e5:
            android.os.Handler r1 = r12.f10580am
            r1.removeMessages(r5)
            boolean r1 = r12.f10559R
            if (r1 == 0) goto L_0x03fb
            r12.f10559R = r4
            boolean r1 = r12.f10570ac
            if (r1 != 0) goto L_0x03fb
            android.graphics.PointF r1 = r12.f10572ae
            android.graphics.PointF r2 = r12.f10566Y
            r12.m7158a((android.graphics.PointF) r1, (android.graphics.PointF) r2)
        L_0x03fb:
            int r1 = r12.f10560S
            if (r1 <= 0) goto L_0x044c
            boolean r1 = r12.f10557P
            if (r1 != 0) goto L_0x0407
            boolean r1 = r12.f10558Q
            if (r1 == 0) goto L_0x044c
        L_0x0407:
            boolean r1 = r12.f10557P
            if (r1 == 0) goto L_0x043d
            if (r0 != r3) goto L_0x043d
            r12.f10558Q = r5
            android.graphics.PointF r1 = r12.f10547F
            android.graphics.PointF r2 = r12.f10546E
            float r2 = r2.x
            android.graphics.PointF r6 = r12.f10546E
            float r6 = r6.y
            r1.set(r2, r6)
            int r1 = r13.getActionIndex()
            if (r1 != r5) goto L_0x0430
            android.graphics.PointF r1 = r12.f10566Y
            float r2 = r13.getX(r4)
            float r13 = r13.getY(r4)
            r1.set(r2, r13)
            goto L_0x043d
        L_0x0430:
            android.graphics.PointF r1 = r12.f10566Y
            float r2 = r13.getX(r5)
            float r13 = r13.getY(r5)
            r1.set(r2, r13)
        L_0x043d:
            r13 = 3
            if (r0 >= r13) goto L_0x0442
            r12.f10557P = r4
        L_0x0442:
            if (r0 >= r3) goto L_0x0448
            r12.f10558Q = r4
            r12.f10560S = r4
        L_0x0448:
            r12.m7193c((boolean) r5)
            return r5
        L_0x044c:
            if (r0 != r5) goto L_0x0454
            r12.f10557P = r4
            r12.f10558Q = r4
            r12.f10560S = r4
        L_0x0454:
            return r5
        L_0x0455:
            r1 = 0
            r12.f10574ag = r1
            r12.m7187b((boolean) r5)
            int r1 = r12.f10560S
            int r1 = java.lang.Math.max(r1, r0)
            r12.f10560S = r1
            if (r0 < r3) goto L_0x04b2
            boolean r0 = r12.f10607x
            if (r0 == 0) goto L_0x04aa
            float r0 = r13.getX(r4)
            float r1 = r13.getX(r5)
            float r3 = r13.getY(r4)
            float r6 = r13.getY(r5)
            float r0 = r12.m7138a((float) r0, (float) r1, (float) r3, (float) r6)
            float r1 = r12.f10544C
            r12.f10545D = r1
            r12.f10567Z = r0
            android.graphics.PointF r0 = r12.f10547F
            android.graphics.PointF r1 = r12.f10546E
            float r1 = r1.x
            android.graphics.PointF r3 = r12.f10546E
            float r3 = r3.y
            r0.set(r1, r3)
            android.graphics.PointF r0 = r12.f10566Y
            float r1 = r13.getX(r4)
            float r3 = r13.getX(r5)
            float r1 = r1 + r3
            float r1 = r1 / r2
            float r3 = r13.getY(r4)
            float r13 = r13.getY(r5)
            float r3 = r3 + r13
            float r3 = r3 / r2
            r0.set(r1, r3)
            goto L_0x04ac
        L_0x04aa:
            r12.f10560S = r4
        L_0x04ac:
            android.os.Handler r13 = r12.f10580am
            r13.removeMessages(r5)
            goto L_0x04d7
        L_0x04b2:
            boolean r0 = r12.f10559R
            if (r0 != 0) goto L_0x04d7
            android.graphics.PointF r0 = r12.f10547F
            android.graphics.PointF r1 = r12.f10546E
            float r1 = r1.x
            android.graphics.PointF r2 = r12.f10546E
            float r2 = r2.y
            r0.set(r1, r2)
            android.graphics.PointF r0 = r12.f10566Y
            float r1 = r13.getX()
            float r13 = r13.getY()
            r0.set(r1, r13)
            android.os.Handler r13 = r12.f10580am
            r0 = 600(0x258, double:2.964E-321)
            r13.sendEmptyMessageDelayed(r5, r0)
        L_0x04d7:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.beatles.p099im.views.widget.longimage.IMSubsamplingScaleImageView.m7176a(android.view.MotionEvent):boolean");
    }

    /* renamed from: b */
    private void m7187b(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7158a(PointF pointF, PointF pointF2) {
        if (!this.f10606w) {
            PointF pointF3 = this.f10551J;
            if (pointF3 != null) {
                pointF.x = pointF3.x;
                pointF.y = this.f10551J.y;
            } else {
                pointF.x = (float) (m7213i() / 2);
                pointF.y = (float) (m7215j() / 2);
            }
        }
        float min = Math.min(this.f10598o, this.f10609z);
        boolean z = ((double) this.f10544C) <= ((double) min) * 0.9d;
        if (!z) {
            min = m7217k();
        }
        float f = min;
        int i = this.f10542A;
        if (i == 3) {
            setScaleAndCenter(f, pointF);
        } else if (i == 2 || !z || !this.f10606w) {
            new AnimationBuilder(f, pointF).withInterruptible(false).withDuration((long) this.f10543B).withOrigin(4).start();
        } else if (i == 1) {
            new AnimationBuilder(f, pointF, pointF2).withInterruptible(false).withDuration((long) this.f10543B).withOrigin(4).start();
        }
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        float f;
        Canvas canvas2 = canvas;
        super.onDraw(canvas);
        m7208f();
        if (this.f10552K != 0 && this.f10553L != 0 && getWidth() != 0 && getHeight() != 0) {
            if (this.f10595l == null && this.f10562U != null) {
                m7157a(m7146a(canvas));
            }
            if (m7201d()) {
                m7209g();
                if (this.f10574ag != null) {
                    float f2 = this.f10544C;
                    if (this.f10548G == null) {
                        this.f10548G = new PointF(0.0f, 0.0f);
                    }
                    this.f10548G.set(this.f10546E);
                    long currentTimeMillis = System.currentTimeMillis() - this.f10574ag.time;
                    boolean z = currentTimeMillis > this.f10574ag.duration;
                    long min = Math.min(currentTimeMillis, this.f10574ag.duration);
                    this.f10544C = m7139a(this.f10574ag.easing, min, this.f10574ag.scaleStart, this.f10574ag.scaleEnd - this.f10574ag.scaleStart, this.f10574ag.duration);
                    float a = m7139a(this.f10574ag.easing, min, this.f10574ag.vFocusStart.x, this.f10574ag.vFocusEnd.x - this.f10574ag.vFocusStart.x, this.f10574ag.duration);
                    float a2 = m7139a(this.f10574ag.easing, min, this.f10574ag.vFocusStart.y, this.f10574ag.vFocusEnd.y - this.f10574ag.vFocusStart.y, this.f10574ag.duration);
                    this.f10546E.x -= m7197d(this.f10574ag.sCenterEnd.x) - a;
                    this.f10546E.y -= m7202e(this.f10574ag.sCenterEnd.y) - a2;
                    m7200d(z || this.f10574ag.scaleStart == this.f10574ag.scaleEnd);
                    m7154a(f2, this.f10548G, this.f10574ag.origin);
                    m7193c(z);
                    if (z) {
                        if (this.f10574ag.listener != null) {
                            try {
                                this.f10574ag.listener.onComplete();
                            } catch (Exception e) {
                                SystemUtils.log(5, f10535a, "Error thrown by animation listener", e, "com.didi.beatles.im.views.widget.longimage.IMSubsamplingScaleImageView", 1034);
                            }
                        }
                        this.f10574ag = null;
                    }
                    invalidate();
                }
                if (this.f10595l == null || !m7194c()) {
                    Bitmap bitmap = this.f10590g;
                    if (bitmap != null) {
                        float f3 = this.f10544C;
                        if (this.f10591h) {
                            f3 *= ((float) this.f10552K) / ((float) bitmap.getWidth());
                            f = this.f10544C * (((float) this.f10553L) / ((float) this.f10590g.getHeight()));
                        } else {
                            f = f3;
                        }
                        if (this.f10585as == null) {
                            this.f10585as = new Matrix();
                        }
                        this.f10585as.reset();
                        this.f10585as.postScale(f3, f);
                        this.f10585as.postRotate((float) getRequiredRotation());
                        this.f10585as.postTranslate(this.f10546E.x, this.f10546E.y);
                        if (getRequiredRotation() == 180) {
                            Matrix matrix = this.f10585as;
                            float f4 = this.f10544C;
                            matrix.postTranslate(((float) this.f10552K) * f4, f4 * ((float) this.f10553L));
                        } else if (getRequiredRotation() == 90) {
                            this.f10585as.postTranslate(this.f10544C * ((float) this.f10553L), 0.0f);
                        } else if (getRequiredRotation() == 270) {
                            this.f10585as.postTranslate(0.0f, this.f10544C * ((float) this.f10552K));
                        }
                        if (this.f10583aq != null) {
                            if (this.f10586at == null) {
                                this.f10586at = new RectF();
                            }
                            this.f10586at.set(0.0f, 0.0f, (float) (this.f10591h ? this.f10590g.getWidth() : this.f10552K), (float) (this.f10591h ? this.f10590g.getHeight() : this.f10553L));
                            this.f10585as.mapRect(this.f10586at);
                            canvas2.drawRect(this.f10586at, this.f10583aq);
                        }
                        canvas2.drawBitmap(this.f10590g, this.f10585as, this.f10581ao);
                    }
                } else {
                    int min2 = Math.min(this.f10594k, m7142a(this.f10544C));
                    boolean z2 = false;
                    for (Map.Entry next : this.f10595l.entrySet()) {
                        if (((Integer) next.getKey()).intValue() == min2) {
                            for (Tile tile : (List) next.getValue()) {
                                if (tile.visible && (tile.loading || tile.bitmap == null)) {
                                    z2 = true;
                                }
                            }
                        }
                    }
                    for (Map.Entry next2 : this.f10595l.entrySet()) {
                        if (((Integer) next2.getKey()).intValue() == min2 || z2) {
                            for (Tile tile2 : (List) next2.getValue()) {
                                m7183b(tile2.sRect, tile2.vRect);
                                if (!tile2.loading && tile2.bitmap != null) {
                                    if (this.f10583aq != null) {
                                        canvas2.drawRect(tile2.vRect, this.f10583aq);
                                    }
                                    if (this.f10585as == null) {
                                        this.f10585as = new Matrix();
                                    }
                                    this.f10585as.reset();
                                    m7175a(this.f10587au, 0.0f, 0.0f, (float) tile2.bitmap.getWidth(), 0.0f, (float) tile2.bitmap.getWidth(), (float) tile2.bitmap.getHeight(), 0.0f, (float) tile2.bitmap.getHeight());
                                    if (getRequiredRotation() == 0) {
                                        m7175a(this.f10588av, (float) tile2.vRect.left, (float) tile2.vRect.top, (float) tile2.vRect.right, (float) tile2.vRect.top, (float) tile2.vRect.right, (float) tile2.vRect.bottom, (float) tile2.vRect.left, (float) tile2.vRect.bottom);
                                    } else if (getRequiredRotation() == 90) {
                                        m7175a(this.f10588av, (float) tile2.vRect.right, (float) tile2.vRect.top, (float) tile2.vRect.right, (float) tile2.vRect.bottom, (float) tile2.vRect.left, (float) tile2.vRect.bottom, (float) tile2.vRect.left, (float) tile2.vRect.top);
                                    } else if (getRequiredRotation() == 180) {
                                        m7175a(this.f10588av, (float) tile2.vRect.right, (float) tile2.vRect.bottom, (float) tile2.vRect.left, (float) tile2.vRect.bottom, (float) tile2.vRect.left, (float) tile2.vRect.top, (float) tile2.vRect.right, (float) tile2.vRect.top);
                                    } else if (getRequiredRotation() == 270) {
                                        m7175a(this.f10588av, (float) tile2.vRect.left, (float) tile2.vRect.bottom, (float) tile2.vRect.left, (float) tile2.vRect.top, (float) tile2.vRect.right, (float) tile2.vRect.top, (float) tile2.vRect.right, (float) tile2.vRect.bottom);
                                    }
                                    this.f10585as.setPolyToPoly(this.f10587au, 0, this.f10588av, 0, 4);
                                    canvas2.drawBitmap(tile2.bitmap, this.f10585as, this.f10581ao);
                                    if (this.f10596m) {
                                        canvas2.drawRect(tile2.vRect, this.f10582ap);
                                    }
                                } else if (tile2.loading && this.f10596m) {
                                    canvas2.drawText("LOADING", (float) (tile2.vRect.left + 5), (float) (tile2.vRect.top + 35), this.f10582ap);
                                }
                                if (tile2.visible && this.f10596m) {
                                    canvas2.drawText("ISS " + tile2.sampleSize + " RECT " + tile2.sRect.top + "," + tile2.sRect.left + "," + tile2.sRect.bottom + "," + tile2.sRect.right, (float) (tile2.vRect.left + 5), (float) (tile2.vRect.top + 15), this.f10582ap);
                                }
                            }
                        }
                    }
                }
                if (this.f10596m) {
                    canvas2.drawText("Scale: " + String.format(Locale.ENGLISH, "%.2f", new Object[]{Float.valueOf(this.f10544C)}), 5.0f, 15.0f, this.f10582ap);
                    canvas2.drawText("Translate: " + String.format(Locale.ENGLISH, "%.2f", new Object[]{Float.valueOf(this.f10546E.x)}) + ":" + String.format(Locale.ENGLISH, "%.2f", new Object[]{Float.valueOf(this.f10546E.y)}), 5.0f, 35.0f, this.f10582ap);
                    PointF center = getCenter();
                    canvas2.drawText("Source center: " + String.format(Locale.ENGLISH, "%.2f", new Object[]{Float.valueOf(center.x)}) + ":" + String.format(Locale.ENGLISH, "%.2f", new Object[]{Float.valueOf(center.y)}), 5.0f, 55.0f, this.f10582ap);
                    this.f10582ap.setStrokeWidth(2.0f);
                    Anim anim = this.f10574ag;
                    if (anim != null) {
                        PointF sourceToViewCoord = sourceToViewCoord(anim.sCenterStart);
                        PointF sourceToViewCoord2 = sourceToViewCoord(this.f10574ag.sCenterEndRequested);
                        PointF sourceToViewCoord3 = sourceToViewCoord(this.f10574ag.sCenterEnd);
                        canvas2.drawCircle(sourceToViewCoord.x, sourceToViewCoord.y, 10.0f, this.f10582ap);
                        this.f10582ap.setColor(-65536);
                        canvas2.drawCircle(sourceToViewCoord2.x, sourceToViewCoord2.y, 20.0f, this.f10582ap);
                        this.f10582ap.setColor(-16776961);
                        canvas2.drawCircle(sourceToViewCoord3.x, sourceToViewCoord3.y, 25.0f, this.f10582ap);
                        this.f10582ap.setColor(-16711681);
                        canvas2.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), 30.0f, this.f10582ap);
                    }
                    if (this.f10566Y != null) {
                        this.f10582ap.setColor(-65536);
                        canvas2.drawCircle(this.f10566Y.x, this.f10566Y.y, 20.0f, this.f10582ap);
                    }
                    if (this.f10572ae != null) {
                        this.f10582ap.setColor(-16776961);
                        canvas2.drawCircle(m7197d(this.f10572ae.x), m7202e(this.f10572ae.y), 35.0f, this.f10582ap);
                    }
                    if (this.f10573af != null) {
                        this.f10582ap.setColor(-16711681);
                        canvas2.drawCircle(this.f10573af.x, this.f10573af.y, 30.0f, this.f10582ap);
                    }
                    this.f10582ap.setColor(-65281);
                    this.f10582ap.setStrokeWidth(1.0f);
                }
            }
        }
    }

    /* renamed from: a */
    private void m7175a(float[] fArr, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        fArr[0] = f;
        fArr[1] = f2;
        fArr[2] = f3;
        fArr[3] = f4;
        fArr[4] = f5;
        fArr[5] = f6;
        fArr[6] = f7;
        fArr[7] = f8;
    }

    /* renamed from: c */
    private boolean m7194c() {
        boolean z = true;
        if (this.f10590g != null && !this.f10591h) {
            return true;
        }
        Map<Integer, List<Tile>> map = this.f10595l;
        if (map == null) {
            return false;
        }
        for (Map.Entry next : map.entrySet()) {
            if (((Integer) next.getKey()).intValue() == this.f10594k) {
                for (Tile tile : (List) next.getValue()) {
                    if (tile.loading || tile.bitmap == null) {
                        z = false;
                    }
                }
            }
        }
        return z;
    }

    /* renamed from: d */
    private boolean m7201d() {
        boolean z = getWidth() > 0 && getHeight() > 0 && this.f10552K > 0 && this.f10553L > 0 && (this.f10590g != null || m7194c());
        if (!this.f10575ah && z) {
            m7209g();
            this.f10575ah = true;
            onReady();
            OnImageEventListener onImageEventListener = this.f10577aj;
            if (onImageEventListener != null) {
                onImageEventListener.onReady();
            }
        }
        return z;
    }

    /* renamed from: e */
    private boolean m7204e() {
        boolean c = m7194c();
        if (!this.f10576ai && c) {
            m7209g();
            this.f10576ai = true;
            onImageLoaded();
            OnImageEventListener onImageEventListener = this.f10577aj;
            if (onImageEventListener != null) {
                onImageEventListener.onImageLoaded();
            }
        }
        return c;
    }

    /* renamed from: f */
    private void m7208f() {
        if (this.f10581ao == null) {
            Paint paint = new Paint();
            this.f10581ao = paint;
            paint.setAntiAlias(true);
            this.f10581ao.setFilterBitmap(true);
            this.f10581ao.setDither(true);
        }
        if (this.f10582ap == null && this.f10596m) {
            Paint paint2 = new Paint();
            this.f10582ap = paint2;
            paint2.setTextSize(18.0f);
            this.f10582ap.setColor(-65281);
            this.f10582ap.setStyle(Paint.Style.STROKE);
        }
    }

    /* renamed from: a */
    private synchronized void m7157a(Point point) {
        m7172a("initialiseBaseLayer maxTileDimensions=%dx%d", Integer.valueOf(point.x), Integer.valueOf(point.y));
        ScaleAndTranslate scaleAndTranslate = new ScaleAndTranslate(0.0f, new PointF(0.0f, 0.0f));
        this.f10584ar = scaleAndTranslate;
        m7174a(true, scaleAndTranslate);
        int a = m7142a(this.f10584ar.scale);
        this.f10594k = a;
        if (a > 1) {
            this.f10594k = a / 2;
        }
        if (this.f10594k != 1 || this.f10555N != null || m7213i() >= point.x || m7215j() >= point.y) {
            m7185b(point);
            for (Tile tileLoadTask : this.f10595l.get(Integer.valueOf(this.f10594k))) {
                m7160a((AsyncTask<Void, Void, ?>) new TileLoadTask(this, this.f10562U, tileLoadTask));
            }
            m7193c(true);
        } else {
            this.f10562U.recycle();
            this.f10562U = null;
            m7160a((AsyncTask<Void, Void, ?>) new BitmapLoadTask(this, getContext(), this.f10564W, this.f10593j, false));
        }
    }

    /* renamed from: c */
    private void m7193c(boolean z) {
        if (this.f10562U != null && this.f10595l != null) {
            int min = Math.min(this.f10594k, m7142a(this.f10544C));
            for (Map.Entry<Integer, List<Tile>> value : this.f10595l.entrySet()) {
                for (Tile tile : (List) value.getValue()) {
                    if (tile.sampleSize < min || (tile.sampleSize > min && tile.sampleSize != this.f10594k)) {
                        boolean unused = tile.visible = false;
                        if (tile.bitmap != null) {
                            tile.bitmap.recycle();
                            Bitmap unused2 = tile.bitmap = null;
                        }
                    }
                    if (tile.sampleSize == min) {
                        if (m7177a(tile)) {
                            boolean unused3 = tile.visible = true;
                            if (!tile.loading && tile.bitmap == null && z) {
                                m7160a((AsyncTask<Void, Void, ?>) new TileLoadTask(this, this.f10562U, tile));
                            }
                        } else if (tile.sampleSize != this.f10594k) {
                            boolean unused4 = tile.visible = false;
                            if (tile.bitmap != null) {
                                tile.bitmap.recycle();
                                Bitmap unused5 = tile.bitmap = null;
                            }
                        }
                    } else if (tile.sampleSize == this.f10594k) {
                        boolean unused6 = tile.visible = true;
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private boolean m7177a(Tile tile) {
        return m7179b(0.0f) <= ((float) tile.sRect.right) && ((float) tile.sRect.left) <= m7179b((float) getWidth()) && m7190c(0.0f) <= ((float) tile.sRect.bottom) && ((float) tile.sRect.top) <= m7190c((float) getHeight());
    }

    /* renamed from: g */
    private void m7209g() {
        Float f;
        if (getWidth() != 0 && getHeight() != 0 && this.f10552K > 0 && this.f10553L > 0) {
            if (!(this.f10550I == null || (f = this.f10549H) == null)) {
                this.f10544C = f.floatValue();
                if (this.f10546E == null) {
                    this.f10546E = new PointF();
                }
                this.f10546E.x = ((float) (getWidth() / 2)) - (this.f10544C * this.f10550I.x);
                this.f10546E.y = ((float) (getHeight() / 2)) - (this.f10544C * this.f10550I.y);
                this.f10550I = null;
                this.f10549H = null;
                m7200d(true);
                m7193c(true);
            }
            m7200d(false);
        }
    }

    /* renamed from: a */
    private int m7142a(float f) {
        int i;
        if (this.f10600q > 0) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            f *= ((float) this.f10600q) / ((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f);
        }
        int i2 = (int) (((float) m7213i()) * f);
        int j = (int) (((float) m7215j()) * f);
        if (i2 == 0 || j == 0) {
            return 32;
        }
        int i3 = 1;
        if (m7215j() > j || m7213i() > i2) {
            i = Math.round(((float) m7215j()) / ((float) j));
            int round = Math.round(((float) m7213i()) / ((float) i2));
            if (i >= round) {
                i = round;
            }
        } else {
            i = 1;
        }
        while (true) {
            int i4 = i3 * 2;
            if (i4 >= i) {
                return i3;
            }
            i3 = i4;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7174a(boolean z, ScaleAndTranslate scaleAndTranslate) {
        float f;
        float f2;
        int i;
        if (this.f10601r == 2 && isReady()) {
            z = false;
        }
        PointF access$4800 = scaleAndTranslate.vTranslate;
        float f3 = m7206f(scaleAndTranslate.scale);
        float i2 = ((float) m7213i()) * f3;
        float j = ((float) m7215j()) * f3;
        if (this.f10601r == 3 && isReady()) {
            access$4800.x = Math.max(access$4800.x, ((float) (getWidth() / 2)) - i2);
            access$4800.y = Math.max(access$4800.y, ((float) (getHeight() / 2)) - j);
        } else if (z) {
            access$4800.x = Math.max(access$4800.x, ((float) getWidth()) - i2);
            access$4800.y = Math.max(access$4800.y, ((float) getHeight()) - j);
        } else {
            access$4800.x = Math.max(access$4800.x, -i2);
            access$4800.y = Math.max(access$4800.y, -j);
        }
        float f4 = 0.5f;
        float paddingLeft = (getPaddingLeft() > 0 || getPaddingRight() > 0) ? ((float) getPaddingLeft()) / ((float) (getPaddingLeft() + getPaddingRight())) : 0.5f;
        if (getPaddingTop() > 0 || getPaddingBottom() > 0) {
            f4 = ((float) getPaddingTop()) / ((float) (getPaddingTop() + getPaddingBottom()));
        }
        if (this.f10601r == 3 && isReady()) {
            f = (float) Math.max(0, getWidth() / 2);
            i = Math.max(0, getHeight() / 2);
        } else if (z) {
            f = Math.max(0.0f, (((float) getWidth()) - i2) * paddingLeft);
            f2 = Math.max(0.0f, (((float) getHeight()) - j) * f4);
            access$4800.x = Math.min(access$4800.x, f);
            access$4800.y = Math.min(access$4800.y, f2);
            float unused = scaleAndTranslate.scale = f3;
        } else {
            f = (float) Math.max(0, getWidth());
            i = Math.max(0, getHeight());
        }
        f2 = (float) i;
        access$4800.x = Math.min(access$4800.x, f);
        access$4800.y = Math.min(access$4800.y, f2);
        float unused2 = scaleAndTranslate.scale = f3;
    }

    /* renamed from: d */
    private void m7200d(boolean z) {
        boolean z2;
        if (this.f10546E == null) {
            z2 = true;
            this.f10546E = new PointF(0.0f, 0.0f);
        } else {
            z2 = false;
        }
        if (this.f10584ar == null) {
            this.f10584ar = new ScaleAndTranslate(0.0f, new PointF(0.0f, 0.0f));
        }
        float unused = this.f10584ar.scale = this.f10544C;
        this.f10584ar.vTranslate.set(this.f10546E);
        m7174a(z, this.f10584ar);
        this.f10544C = this.f10584ar.scale;
        this.f10546E.set(this.f10584ar.vTranslate);
        if (z2) {
            this.f10546E.set(m7147a((float) (m7213i() / 2), (float) (m7215j() / 2), this.f10544C));
        }
    }

    /* renamed from: b */
    private void m7185b(Point point) {
        Point point2 = point;
        int i = 1;
        m7172a("initialiseTileMap maxTileDimensions=%dx%d", Integer.valueOf(point2.x), Integer.valueOf(point2.y));
        this.f10595l = new LinkedHashMap();
        int i2 = this.f10594k;
        int i3 = 1;
        int i4 = 1;
        while (true) {
            int i5 = m7213i() / i3;
            int j = m7215j() / i4;
            int i6 = i5 / i2;
            int i7 = j / i2;
            while (true) {
                if (i6 + i3 + i > point2.x || (((double) i6) > ((double) getWidth()) * 1.25d && i2 < this.f10594k)) {
                    i3++;
                    i5 = m7213i() / i3;
                    i6 = i5 / i2;
                    i = 1;
                }
            }
            while (true) {
                if (i7 + i4 + i > point2.y || (((double) i7) > ((double) getHeight()) * 1.25d && i2 < this.f10594k)) {
                    i4++;
                    j = m7215j() / i4;
                    i7 = j / i2;
                    i = 1;
                }
            }
            ArrayList arrayList = new ArrayList(i3 * i4);
            int i8 = 0;
            while (i8 < i3) {
                int i9 = 0;
                while (i9 < i4) {
                    Tile tile = new Tile();
                    int unused = tile.sampleSize = i2;
                    boolean unused2 = tile.visible = i2 == this.f10594k;
                    Rect unused3 = tile.sRect = new Rect(i8 * i5, i9 * j, i8 == i3 + -1 ? m7213i() : (i8 + 1) * i5, i9 == i4 + -1 ? m7215j() : (i9 + 1) * j);
                    Rect unused4 = tile.vRect = new Rect(0, 0, 0, 0);
                    Rect unused5 = tile.fileSRect = new Rect(tile.sRect);
                    arrayList.add(tile);
                    i9++;
                }
                i8++;
            }
            this.f10595l.put(Integer.valueOf(i2), arrayList);
            if (i2 != 1) {
                i2 /= 2;
                i = 1;
            } else {
                return;
            }
        }
    }

    /* renamed from: com.didi.beatles.im.views.widget.longimage.IMSubsamplingScaleImageView$TilesInitTask */
    private static class TilesInitTask extends AsyncTask<Void, Void, int[]> {
        private final WeakReference<Context> contextRef;
        private ImageRegionDecoder decoder;
        private final WeakReference<DecoderFactory<? extends ImageRegionDecoder>> decoderFactoryRef;
        private Exception exception;
        private final Uri source;
        private final WeakReference<IMSubsamplingScaleImageView> viewRef;

        TilesInitTask(IMSubsamplingScaleImageView iMSubsamplingScaleImageView, Context context, DecoderFactory<? extends ImageRegionDecoder> decoderFactory, Uri uri) {
            this.viewRef = new WeakReference<>(iMSubsamplingScaleImageView);
            this.contextRef = new WeakReference<>(context);
            this.decoderFactoryRef = new WeakReference<>(decoderFactory);
            this.source = uri;
        }

        /* access modifiers changed from: protected */
        public int[] doInBackground(Void... voidArr) {
            try {
                String uri = this.source.toString();
                Context context = (Context) this.contextRef.get();
                DecoderFactory decoderFactory = (DecoderFactory) this.decoderFactoryRef.get();
                IMSubsamplingScaleImageView iMSubsamplingScaleImageView = (IMSubsamplingScaleImageView) this.viewRef.get();
                if (context == null || decoderFactory == null || iMSubsamplingScaleImageView == null) {
                    return null;
                }
                iMSubsamplingScaleImageView.m7172a("TilesInitTask.doInBackground", new Object[0]);
                ImageRegionDecoder imageRegionDecoder = (ImageRegionDecoder) decoderFactory.make();
                this.decoder = imageRegionDecoder;
                Point init = imageRegionDecoder.init(context, this.source);
                int i = init.x;
                int i2 = init.y;
                int a = iMSubsamplingScaleImageView.m7143a(context, uri);
                if (iMSubsamplingScaleImageView.f10555N != null) {
                    i = iMSubsamplingScaleImageView.f10555N.width();
                    i2 = iMSubsamplingScaleImageView.f10555N.height();
                }
                return new int[]{i, i2, a};
            } catch (Exception e) {
                SystemUtils.log(6, IMSubsamplingScaleImageView.f10535a, "Failed to initialise bitmap decoder", e, "com.didi.beatles.im.views.widget.longimage.IMSubsamplingScaleImageView$TilesInitTask", 1587);
                this.exception = e;
                return null;
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(int[] iArr) {
            IMSubsamplingScaleImageView iMSubsamplingScaleImageView = (IMSubsamplingScaleImageView) this.viewRef.get();
            if (iMSubsamplingScaleImageView != null) {
                ImageRegionDecoder imageRegionDecoder = this.decoder;
                if (imageRegionDecoder != null && iArr != null && iArr.length == 3) {
                    iMSubsamplingScaleImageView.m7171a(imageRegionDecoder, iArr[0], iArr[1], iArr[2]);
                } else if (this.exception != null && iMSubsamplingScaleImageView.f10577aj != null) {
                    iMSubsamplingScaleImageView.f10577aj.onImageLoadError(this.exception);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m7171a(ImageRegionDecoder imageRegionDecoder, int i, int i2, int i3) {
        m7172a("onTilesInited sWidth=%d, sHeight=%d, sOrientation=%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(this.f10597n));
        if (this.f10552K > 0 && this.f10553L > 0 && !(this.f10552K == i && this.f10553L == i2)) {
            m7173a(false);
            if (this.f10590g != null) {
                if (!this.f10592i) {
                    this.f10590g.recycle();
                }
                this.f10590g = null;
                if (this.f10577aj != null && this.f10592i) {
                    this.f10577aj.onPreviewReleased();
                }
                this.f10591h = false;
                this.f10592i = false;
            }
        }
        this.f10562U = imageRegionDecoder;
        this.f10552K = i;
        this.f10553L = i2;
        this.f10554M = i3;
        m7201d();
        if (!m7204e() && this.f10603t > 0 && this.f10603t != TILE_SIZE_AUTO && this.f10604u > 0 && this.f10604u != TILE_SIZE_AUTO && getWidth() > 0 && getHeight() > 0) {
            m7157a(new Point(this.f10603t, this.f10604u));
        }
        invalidate();
        requestLayout();
    }

    /* renamed from: com.didi.beatles.im.views.widget.longimage.IMSubsamplingScaleImageView$TileLoadTask */
    private static class TileLoadTask extends AsyncTask<Void, Void, Bitmap> {
        private final WeakReference<ImageRegionDecoder> decoderRef;
        private Exception exception;
        private final WeakReference<Tile> tileRef;
        private final WeakReference<IMSubsamplingScaleImageView> viewRef;

        TileLoadTask(IMSubsamplingScaleImageView iMSubsamplingScaleImageView, ImageRegionDecoder imageRegionDecoder, Tile tile) {
            this.viewRef = new WeakReference<>(iMSubsamplingScaleImageView);
            this.decoderRef = new WeakReference<>(imageRegionDecoder);
            this.tileRef = new WeakReference<>(tile);
            boolean unused = tile.loading = true;
        }

        /* access modifiers changed from: protected */
        public Bitmap doInBackground(Void... voidArr) {
            Bitmap decodeRegion;
            try {
                IMSubsamplingScaleImageView iMSubsamplingScaleImageView = (IMSubsamplingScaleImageView) this.viewRef.get();
                ImageRegionDecoder imageRegionDecoder = (ImageRegionDecoder) this.decoderRef.get();
                Tile tile = (Tile) this.tileRef.get();
                if (imageRegionDecoder != null && tile != null && iMSubsamplingScaleImageView != null && imageRegionDecoder.isReady() && tile.visible) {
                    iMSubsamplingScaleImageView.m7172a("TileLoadTask.doInBackground, tile.sRect=%s, tile.sampleSize=%d", tile.sRect, Integer.valueOf(tile.sampleSize));
                    synchronized (iMSubsamplingScaleImageView.f10563V) {
                        iMSubsamplingScaleImageView.m7159a(tile.sRect, tile.fileSRect);
                        if (iMSubsamplingScaleImageView.f10555N != null) {
                            tile.fileSRect.offset(iMSubsamplingScaleImageView.f10555N.left, iMSubsamplingScaleImageView.f10555N.top);
                        }
                        decodeRegion = imageRegionDecoder.decodeRegion(tile.fileSRect, tile.sampleSize);
                    }
                    return decodeRegion;
                } else if (tile == null) {
                    return null;
                } else {
                    boolean unused = tile.loading = false;
                    return null;
                }
            } catch (Exception e) {
                SystemUtils.log(6, IMSubsamplingScaleImageView.f10535a, "Failed to decode tile", e, "com.didi.beatles.im.views.widget.longimage.IMSubsamplingScaleImageView$TileLoadTask", 1674);
                this.exception = e;
                return null;
            } catch (OutOfMemoryError e2) {
                SystemUtils.log(6, IMSubsamplingScaleImageView.f10535a, "Failed to decode tile - OutOfMemoryError", e2, "com.didi.beatles.im.views.widget.longimage.IMSubsamplingScaleImageView$TileLoadTask", 1677);
                this.exception = new RuntimeException(e2);
                return null;
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Bitmap bitmap) {
            IMSubsamplingScaleImageView iMSubsamplingScaleImageView = (IMSubsamplingScaleImageView) this.viewRef.get();
            Tile tile = (Tile) this.tileRef.get();
            if (iMSubsamplingScaleImageView != null && tile != null) {
                if (bitmap != null) {
                    Bitmap unused = tile.bitmap = bitmap;
                    boolean unused2 = tile.loading = false;
                    iMSubsamplingScaleImageView.m7211h();
                } else if (this.exception != null && iMSubsamplingScaleImageView.f10577aj != null) {
                    iMSubsamplingScaleImageView.f10577aj.onTileLoadError(this.exception);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public synchronized void m7211h() {
        m7172a("onTileLoaded", new Object[0]);
        m7201d();
        m7204e();
        if (m7194c() && this.f10590g != null) {
            if (!this.f10592i) {
                this.f10590g.recycle();
            }
            this.f10590g = null;
            if (this.f10577aj != null && this.f10592i) {
                this.f10577aj.onPreviewReleased();
            }
            this.f10591h = false;
            this.f10592i = false;
        }
        invalidate();
    }

    /* renamed from: com.didi.beatles.im.views.widget.longimage.IMSubsamplingScaleImageView$BitmapLoadTask */
    private static class BitmapLoadTask extends AsyncTask<Void, Void, Integer> {
        private Bitmap bitmap;
        private final WeakReference<Context> contextRef;
        private final WeakReference<DecoderFactory<? extends ImageDecoder>> decoderFactoryRef;
        private Exception exception;
        private final boolean preview;
        private final Uri source;
        private final WeakReference<IMSubsamplingScaleImageView> viewRef;

        BitmapLoadTask(IMSubsamplingScaleImageView iMSubsamplingScaleImageView, Context context, DecoderFactory<? extends ImageDecoder> decoderFactory, Uri uri, boolean z) {
            this.viewRef = new WeakReference<>(iMSubsamplingScaleImageView);
            this.contextRef = new WeakReference<>(context);
            this.decoderFactoryRef = new WeakReference<>(decoderFactory);
            this.source = uri;
            this.preview = z;
        }

        /* access modifiers changed from: protected */
        public Integer doInBackground(Void... voidArr) {
            try {
                String uri = this.source.toString();
                Context context = (Context) this.contextRef.get();
                DecoderFactory decoderFactory = (DecoderFactory) this.decoderFactoryRef.get();
                IMSubsamplingScaleImageView iMSubsamplingScaleImageView = (IMSubsamplingScaleImageView) this.viewRef.get();
                if (context == null || decoderFactory == null || iMSubsamplingScaleImageView == null) {
                    return null;
                }
                iMSubsamplingScaleImageView.m7172a("BitmapLoadTask.doInBackground", new Object[0]);
                this.bitmap = ((ImageDecoder) decoderFactory.make()).decode(context, this.source);
                return Integer.valueOf(iMSubsamplingScaleImageView.m7143a(context, uri));
            } catch (Exception e) {
                SystemUtils.log(6, IMSubsamplingScaleImageView.f10535a, "Failed to load bitmap", e, "com.didi.beatles.im.views.widget.longimage.IMSubsamplingScaleImageView$BitmapLoadTask", 1753);
                this.exception = e;
                return null;
            } catch (OutOfMemoryError e2) {
                SystemUtils.log(6, IMSubsamplingScaleImageView.f10535a, "Failed to load bitmap - OutOfMemoryError", e2, "com.didi.beatles.im.views.widget.longimage.IMSubsamplingScaleImageView$BitmapLoadTask", 1756);
                this.exception = new RuntimeException(e2);
                return null;
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Integer num) {
            IMSubsamplingScaleImageView iMSubsamplingScaleImageView = (IMSubsamplingScaleImageView) this.viewRef.get();
            if (iMSubsamplingScaleImageView != null) {
                Bitmap bitmap2 = this.bitmap;
                if (bitmap2 == null || num == null) {
                    if (this.exception != null && iMSubsamplingScaleImageView.f10577aj != null) {
                        if (this.preview) {
                            iMSubsamplingScaleImageView.f10577aj.onPreviewLoadError(this.exception);
                        } else {
                            iMSubsamplingScaleImageView.f10577aj.onImageLoadError(this.exception);
                        }
                    }
                } else if (this.preview) {
                    iMSubsamplingScaleImageView.m7155a(bitmap2);
                } else {
                    iMSubsamplingScaleImageView.m7156a(bitmap2, num.intValue(), false);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0043, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void m7155a(android.graphics.Bitmap r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.lang.String r0 = "onPreviewLoaded"
            r1 = 0
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x0049 }
            r4.m7172a((java.lang.String) r0, (java.lang.Object[]) r1)     // Catch:{ all -> 0x0049 }
            android.graphics.Bitmap r0 = r4.f10590g     // Catch:{ all -> 0x0049 }
            if (r0 != 0) goto L_0x0044
            boolean r0 = r4.f10576ai     // Catch:{ all -> 0x0049 }
            if (r0 == 0) goto L_0x0012
            goto L_0x0044
        L_0x0012:
            android.graphics.Rect r0 = r4.f10556O     // Catch:{ all -> 0x0049 }
            if (r0 == 0) goto L_0x0031
            android.graphics.Rect r0 = r4.f10556O     // Catch:{ all -> 0x0049 }
            int r0 = r0.left     // Catch:{ all -> 0x0049 }
            android.graphics.Rect r1 = r4.f10556O     // Catch:{ all -> 0x0049 }
            int r1 = r1.top     // Catch:{ all -> 0x0049 }
            android.graphics.Rect r2 = r4.f10556O     // Catch:{ all -> 0x0049 }
            int r2 = r2.width()     // Catch:{ all -> 0x0049 }
            android.graphics.Rect r3 = r4.f10556O     // Catch:{ all -> 0x0049 }
            int r3 = r3.height()     // Catch:{ all -> 0x0049 }
            android.graphics.Bitmap r5 = android.graphics.Bitmap.createBitmap(r5, r0, r1, r2, r3)     // Catch:{ all -> 0x0049 }
            r4.f10590g = r5     // Catch:{ all -> 0x0049 }
            goto L_0x0033
        L_0x0031:
            r4.f10590g = r5     // Catch:{ all -> 0x0049 }
        L_0x0033:
            r5 = 1
            r4.f10591h = r5     // Catch:{ all -> 0x0049 }
            boolean r5 = r4.m7201d()     // Catch:{ all -> 0x0049 }
            if (r5 == 0) goto L_0x0042
            r4.invalidate()     // Catch:{ all -> 0x0049 }
            r4.requestLayout()     // Catch:{ all -> 0x0049 }
        L_0x0042:
            monitor-exit(r4)
            return
        L_0x0044:
            r5.recycle()     // Catch:{ all -> 0x0049 }
            monitor-exit(r4)
            return
        L_0x0049:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.beatles.p099im.views.widget.longimage.IMSubsamplingScaleImageView.m7155a(android.graphics.Bitmap):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m7156a(Bitmap bitmap, int i, boolean z) {
        m7172a("onImageLoaded", new Object[0]);
        if (this.f10552K > 0 && this.f10553L > 0 && !(this.f10552K == bitmap.getWidth() && this.f10553L == bitmap.getHeight())) {
            m7173a(false);
        }
        if (this.f10590g != null && !this.f10592i) {
            this.f10590g.recycle();
        }
        if (!(this.f10590g == null || !this.f10592i || this.f10577aj == null)) {
            this.f10577aj.onPreviewReleased();
        }
        this.f10591h = false;
        this.f10592i = z;
        this.f10590g = bitmap;
        this.f10552K = bitmap.getWidth();
        this.f10553L = bitmap.getHeight();
        this.f10554M = i;
        boolean d = m7201d();
        boolean e = m7204e();
        if (d || e) {
            invalidate();
            requestLayout();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x005f, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        com.didi.sdk.apm.SystemUtils.log(5, f10535a, "Could not get orientation of image from media store", (java.lang.Throwable) null, "com.didi.beatles.im.views.widget.longimage.IMSubsamplingScaleImageView", 1858);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0071, code lost:
        if (r0 != null) goto L_0x0073;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0073, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0076, code lost:
        throw r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        return 0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0061 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int m7143a(android.content.Context r10, java.lang.String r11) {
        /*
            r9 = this;
            java.lang.String r0 = "content"
            boolean r0 = r11.startsWith(r0)
            r1 = 0
            if (r0 == 0) goto L_0x0077
            r0 = 0
            java.lang.String r2 = "orientation"
            java.lang.String[] r5 = new java.lang.String[]{r2}     // Catch:{ Exception -> 0x0061 }
            android.content.ContentResolver r3 = r10.getContentResolver()     // Catch:{ Exception -> 0x0061 }
            android.net.Uri r4 = android.net.Uri.parse(r11)     // Catch:{ Exception -> 0x0061 }
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r0 = r3.query(r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x0061 }
            if (r0 == 0) goto L_0x0058
            boolean r10 = r0.moveToFirst()     // Catch:{ Exception -> 0x0061 }
            if (r10 == 0) goto L_0x0058
            int r10 = r0.getInt(r1)     // Catch:{ Exception -> 0x0061 }
            java.util.List<java.lang.Integer> r11 = f10537b     // Catch:{ Exception -> 0x0061 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r10)     // Catch:{ Exception -> 0x0061 }
            boolean r11 = r11.contains(r2)     // Catch:{ Exception -> 0x0061 }
            if (r11 == 0) goto L_0x003c
            r11 = -1
            if (r10 == r11) goto L_0x003c
            r1 = r10
            goto L_0x0058
        L_0x003c:
            java.lang.String r3 = f10535a     // Catch:{ Exception -> 0x0061 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0061 }
            r11.<init>()     // Catch:{ Exception -> 0x0061 }
            java.lang.String r2 = "Unsupported orientation: "
            r11.append(r2)     // Catch:{ Exception -> 0x0061 }
            r11.append(r10)     // Catch:{ Exception -> 0x0061 }
            java.lang.String r4 = r11.toString()     // Catch:{ Exception -> 0x0061 }
            r2 = 5
            r5 = 0
            java.lang.String r6 = "com.didi.beatles.im.views.widget.longimage.IMSubsamplingScaleImageView"
            r7 = 1853(0x73d, float:2.597E-42)
            com.didi.sdk.apm.SystemUtils.log(r2, r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x0061 }
        L_0x0058:
            if (r0 == 0) goto L_0x00e0
        L_0x005a:
            r0.close()
            goto L_0x00e0
        L_0x005f:
            r10 = move-exception
            goto L_0x0071
        L_0x0061:
            java.lang.String r3 = f10535a     // Catch:{ all -> 0x005f }
            java.lang.String r4 = "Could not get orientation of image from media store"
            r2 = 5
            r5 = 0
            java.lang.String r6 = "com.didi.beatles.im.views.widget.longimage.IMSubsamplingScaleImageView"
            r7 = 1858(0x742, float:2.604E-42)
            com.didi.sdk.apm.SystemUtils.log(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x005f }
            if (r0 == 0) goto L_0x00e0
            goto L_0x005a
        L_0x0071:
            if (r0 == 0) goto L_0x0076
            r0.close()
        L_0x0076:
            throw r10
        L_0x0077:
            java.lang.String r10 = "file:///"
            boolean r10 = r11.startsWith(r10)
            if (r10 == 0) goto L_0x00e0
            java.lang.String r10 = "file:///android_asset/"
            boolean r10 = r11.startsWith(r10)
            if (r10 != 0) goto L_0x00e0
            android.media.ExifInterface r10 = new android.media.ExifInterface     // Catch:{ Exception -> 0x00d3 }
            r0 = 7
            java.lang.String r11 = r11.substring(r0)     // Catch:{ Exception -> 0x00d3 }
            r10.<init>(r11)     // Catch:{ Exception -> 0x00d3 }
            java.lang.String r11 = "Orientation"
            r0 = 1
            int r10 = r10.getAttributeInt(r11, r0)     // Catch:{ Exception -> 0x00d3 }
            if (r10 == r0) goto L_0x00e0
            if (r10 != 0) goto L_0x009d
            goto L_0x00e0
        L_0x009d:
            r11 = 6
            if (r10 != r11) goto L_0x00a5
            r10 = 90
            r1 = 90
            goto L_0x00e0
        L_0x00a5:
            r11 = 3
            if (r10 != r11) goto L_0x00ad
            r10 = 180(0xb4, float:2.52E-43)
            r1 = 180(0xb4, float:2.52E-43)
            goto L_0x00e0
        L_0x00ad:
            r11 = 8
            if (r10 != r11) goto L_0x00b6
            r10 = 270(0x10e, float:3.78E-43)
            r1 = 270(0x10e, float:3.78E-43)
            goto L_0x00e0
        L_0x00b6:
            java.lang.String r3 = f10535a     // Catch:{ Exception -> 0x00d3 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00d3 }
            r11.<init>()     // Catch:{ Exception -> 0x00d3 }
            java.lang.String r0 = "Unsupported EXIF orientation: "
            r11.append(r0)     // Catch:{ Exception -> 0x00d3 }
            r11.append(r10)     // Catch:{ Exception -> 0x00d3 }
            java.lang.String r4 = r11.toString()     // Catch:{ Exception -> 0x00d3 }
            r2 = 5
            r5 = 0
            java.lang.String r6 = "com.didi.beatles.im.views.widget.longimage.IMSubsamplingScaleImageView"
            r7 = 1877(0x755, float:2.63E-42)
            com.didi.sdk.apm.SystemUtils.log(r2, r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x00d3 }
            goto L_0x00e0
        L_0x00d3:
            java.lang.String r3 = f10535a
            r2 = 5
            r5 = 0
            r7 = 1880(0x758, float:2.634E-42)
            java.lang.String r4 = "Could not get EXIF orientation of image"
            java.lang.String r6 = "com.didi.beatles.im.views.widget.longimage.IMSubsamplingScaleImageView"
            com.didi.sdk.apm.SystemUtils.log(r2, r3, r4, r5, r6, r7)
        L_0x00e0:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.beatles.p099im.views.widget.longimage.IMSubsamplingScaleImageView.m7143a(android.content.Context, java.lang.String):int");
    }

    /* renamed from: a */
    private void m7160a(AsyncTask<Void, Void, ?> asyncTask) {
        if (this.f10605v && Build.VERSION.SDK_INT >= 11) {
            try {
                AsyncTask.class.getMethod("executeOnExecutor", new Class[]{Executor.class, Object[].class}).invoke(asyncTask, new Object[]{(Executor) AsyncTask.class.getField("THREAD_POOL_EXECUTOR").get((Object) null), null});
                return;
            } catch (Exception e) {
                SystemUtils.log(4, f10535a, "Failed to execute AsyncTask on thread pool executor, falling back to single threaded executor", e, "com.didi.beatles.im.views.widget.longimage.IMSubsamplingScaleImageView", 1895);
            }
        }
        asyncTask.execute(new Void[0]);
    }

    /* renamed from: com.didi.beatles.im.views.widget.longimage.IMSubsamplingScaleImageView$Tile */
    private static class Tile {
        /* access modifiers changed from: private */
        public Bitmap bitmap;
        /* access modifiers changed from: private */
        public Rect fileSRect;
        /* access modifiers changed from: private */
        public boolean loading;
        /* access modifiers changed from: private */
        public Rect sRect;
        /* access modifiers changed from: private */
        public int sampleSize;
        /* access modifiers changed from: private */
        public Rect vRect;
        /* access modifiers changed from: private */
        public boolean visible;

        private Tile() {
        }
    }

    /* renamed from: com.didi.beatles.im.views.widget.longimage.IMSubsamplingScaleImageView$Anim */
    private static class Anim {
        /* access modifiers changed from: private */
        public long duration;
        /* access modifiers changed from: private */
        public int easing;
        /* access modifiers changed from: private */
        public boolean interruptible;
        /* access modifiers changed from: private */
        public OnAnimationEventListener listener;
        /* access modifiers changed from: private */
        public int origin;
        /* access modifiers changed from: private */
        public PointF sCenterEnd;
        /* access modifiers changed from: private */
        public PointF sCenterEndRequested;
        /* access modifiers changed from: private */
        public PointF sCenterStart;
        /* access modifiers changed from: private */
        public float scaleEnd;
        /* access modifiers changed from: private */
        public float scaleStart;
        /* access modifiers changed from: private */
        public long time;
        /* access modifiers changed from: private */
        public PointF vFocusEnd;
        /* access modifiers changed from: private */
        public PointF vFocusStart;

        private Anim() {
            this.duration = 500;
            this.interruptible = true;
            this.easing = 2;
            this.origin = 1;
            this.time = System.currentTimeMillis();
        }
    }

    /* renamed from: com.didi.beatles.im.views.widget.longimage.IMSubsamplingScaleImageView$ScaleAndTranslate */
    private static class ScaleAndTranslate {
        /* access modifiers changed from: private */
        public float scale;
        /* access modifiers changed from: private */
        public PointF vTranslate;

        private ScaleAndTranslate(float f, PointF pointF) {
            this.scale = f;
            this.vTranslate = pointF;
        }
    }

    /* renamed from: a */
    private void m7161a(IMImageViewState iMImageViewState) {
        if (iMImageViewState != null && iMImageViewState.getCenter() != null && f10537b.contains(Integer.valueOf(iMImageViewState.getOrientation()))) {
            this.f10597n = iMImageViewState.getOrientation();
            this.f10549H = Float.valueOf(iMImageViewState.getScale());
            this.f10550I = iMImageViewState.getCenter();
            invalidate();
        }
    }

    public void setMaxTileSize(int i) {
        this.f10603t = i;
        this.f10604u = i;
    }

    public void setMaxTileSize(int i, int i2) {
        this.f10603t = i;
        this.f10604u = i2;
    }

    /* renamed from: a */
    private Point m7146a(Canvas canvas) {
        int i;
        int i2;
        int i3 = 2048;
        if (Build.VERSION.SDK_INT >= 14) {
            try {
                i2 = ((Integer) Canvas.class.getMethod("getMaximumBitmapWidth", new Class[0]).invoke(canvas, new Object[0])).intValue();
                try {
                    i = ((Integer) Canvas.class.getMethod("getMaximumBitmapHeight", new Class[0]).invoke(canvas, new Object[0])).intValue();
                    i3 = i2;
                } catch (Exception unused) {
                    i3 = i2;
                    i = 2048;
                    return new Point(Math.min(i3, this.f10603t), Math.min(i, this.f10604u));
                }
            } catch (Exception unused2) {
                i2 = 2048;
                i3 = i2;
                i = 2048;
                return new Point(Math.min(i3, this.f10603t), Math.min(i, this.f10604u));
            }
            return new Point(Math.min(i3, this.f10603t), Math.min(i, this.f10604u));
        }
        i = 2048;
        return new Point(Math.min(i3, this.f10603t), Math.min(i, this.f10604u));
    }

    /* renamed from: i */
    private int m7213i() {
        int requiredRotation = getRequiredRotation();
        if (requiredRotation == 90 || requiredRotation == 270) {
            return this.f10553L;
        }
        return this.f10552K;
    }

    /* renamed from: j */
    private int m7215j() {
        int requiredRotation = getRequiredRotation();
        if (requiredRotation == 90 || requiredRotation == 270) {
            return this.f10552K;
        }
        return this.f10553L;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7159a(Rect rect, Rect rect2) {
        if (getRequiredRotation() == 0) {
            rect2.set(rect);
        } else if (getRequiredRotation() == 90) {
            rect2.set(rect.top, this.f10553L - rect.right, rect.bottom, this.f10553L - rect.left);
        } else if (getRequiredRotation() == 180) {
            rect2.set(this.f10552K - rect.right, this.f10553L - rect.bottom, this.f10552K - rect.left, this.f10553L - rect.top);
        } else {
            rect2.set(this.f10552K - rect.bottom, rect.left, this.f10552K - rect.top, rect.right);
        }
    }

    private int getRequiredRotation() {
        int i = this.f10597n;
        return i == -1 ? this.f10554M : i;
    }

    /* renamed from: a */
    private float m7138a(float f, float f2, float f3, float f4) {
        float f5 = f - f2;
        float f6 = f3 - f4;
        return (float) Math.sqrt((double) ((f5 * f5) + (f6 * f6)));
    }

    public void recycle() {
        m7173a(true);
        this.f10581ao = null;
        this.f10582ap = null;
        this.f10583aq = null;
    }

    /* renamed from: b */
    private float m7179b(float f) {
        PointF pointF = this.f10546E;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f - pointF.x) / this.f10544C;
    }

    /* renamed from: c */
    private float m7190c(float f) {
        PointF pointF = this.f10546E;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f - pointF.y) / this.f10544C;
    }

    public final PointF viewToSourceCoord(PointF pointF) {
        return viewToSourceCoord(pointF.x, pointF.y, new PointF());
    }

    public final PointF viewToSourceCoord(float f, float f2) {
        return viewToSourceCoord(f, f2, new PointF());
    }

    public final PointF viewToSourceCoord(PointF pointF, PointF pointF2) {
        return viewToSourceCoord(pointF.x, pointF.y, pointF2);
    }

    public final PointF viewToSourceCoord(float f, float f2, PointF pointF) {
        if (this.f10546E == null) {
            return null;
        }
        pointF.set(m7179b(f), m7190c(f2));
        return pointF;
    }

    /* renamed from: d */
    private float m7197d(float f) {
        PointF pointF = this.f10546E;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f * this.f10544C) + pointF.x;
    }

    /* renamed from: e */
    private float m7202e(float f) {
        PointF pointF = this.f10546E;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f * this.f10544C) + pointF.y;
    }

    public final PointF sourceToViewCoord(PointF pointF) {
        return sourceToViewCoord(pointF.x, pointF.y, new PointF());
    }

    public final PointF sourceToViewCoord(float f, float f2) {
        return sourceToViewCoord(f, f2, new PointF());
    }

    public final PointF sourceToViewCoord(PointF pointF, PointF pointF2) {
        return sourceToViewCoord(pointF.x, pointF.y, pointF2);
    }

    public final PointF sourceToViewCoord(float f, float f2, PointF pointF) {
        if (this.f10546E == null) {
            return null;
        }
        pointF.set(m7197d(f), m7202e(f2));
        return pointF;
    }

    /* renamed from: b */
    private Rect m7183b(Rect rect, Rect rect2) {
        rect2.set((int) m7197d((float) rect.left), (int) m7202e((float) rect.top), (int) m7197d((float) rect.right), (int) m7202e((float) rect.bottom));
        return rect2;
    }

    /* renamed from: a */
    private PointF m7147a(float f, float f2, float f3) {
        int paddingLeft = getPaddingLeft() + (((getWidth() - getPaddingRight()) - getPaddingLeft()) / 2);
        int paddingTop = getPaddingTop() + (((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2);
        if (this.f10584ar == null) {
            this.f10584ar = new ScaleAndTranslate(0.0f, new PointF(0.0f, 0.0f));
        }
        float unused = this.f10584ar.scale = f3;
        this.f10584ar.vTranslate.set(((float) paddingLeft) - (f * f3), ((float) paddingTop) - (f2 * f3));
        m7174a(true, this.f10584ar);
        return this.f10584ar.vTranslate;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public PointF m7148a(float f, float f2, float f3, PointF pointF) {
        PointF a = m7147a(f, f2, f3);
        pointF.set((((float) (getPaddingLeft() + (((getWidth() - getPaddingRight()) - getPaddingLeft()) / 2))) - a.x) / f3, (((float) (getPaddingTop() + (((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2))) - a.y) / f3);
        return pointF;
    }

    /* renamed from: k */
    private float m7217k() {
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int i = this.f10602s;
        if (i == 2) {
            return Math.max(((float) (getWidth() - paddingLeft)) / ((float) m7213i()), ((float) (getHeight() - paddingBottom)) / ((float) m7215j()));
        }
        if (i == 3) {
            float f = this.f10599p;
            if (f > 0.0f) {
                return f;
            }
        }
        return Math.min(((float) (getWidth() - paddingLeft)) / ((float) m7213i()), ((float) (getHeight() - paddingBottom)) / ((float) m7215j()));
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public float m7206f(float f) {
        return Math.min(this.f10598o, Math.max(m7217k(), f));
    }

    /* renamed from: a */
    private float m7139a(int i, long j, float f, float f2, long j2) {
        if (i == 1) {
            return m7140a(j, f, f2, j2);
        }
        if (i == 2) {
            return m7180b(j, f, f2, j2);
        }
        throw new IllegalStateException("Unexpected easing type: " + i);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7172a(String str, Object... objArr) {
        if (this.f10596m) {
            SystemUtils.log(3, f10535a, String.format(str, objArr), (Throwable) null, "com.didi.beatles.im.views.widget.longimage.IMSubsamplingScaleImageView", 2302);
        }
    }

    public final void setRegionDecoderClass(Class<? extends ImageRegionDecoder> cls) {
        if (cls != null) {
            this.f10565X = new CompatDecoderFactory(cls);
            return;
        }
        throw new IllegalArgumentException("Decoder class cannot be set to null");
    }

    public final void setRegionDecoderFactory(DecoderFactory<? extends ImageRegionDecoder> decoderFactory) {
        if (decoderFactory != null) {
            this.f10565X = decoderFactory;
            return;
        }
        throw new IllegalArgumentException("Decoder factory cannot be set to null");
    }

    public final void setBitmapDecoderClass(Class<? extends ImageDecoder> cls) {
        if (cls != null) {
            this.f10564W = new CompatDecoderFactory(cls);
            return;
        }
        throw new IllegalArgumentException("Decoder class cannot be set to null");
    }

    public final void setBitmapDecoderFactory(DecoderFactory<? extends ImageDecoder> decoderFactory) {
        if (decoderFactory != null) {
            this.f10564W = decoderFactory;
            return;
        }
        throw new IllegalArgumentException("Decoder factory cannot be set to null");
    }

    public final void setPanLimit(int i) {
        if (f10540e.contains(Integer.valueOf(i))) {
            this.f10601r = i;
            if (isReady()) {
                m7200d(true);
                invalidate();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Invalid pan limit: " + i);
    }

    public final void setMinimumScaleType(int i) {
        if (f10541f.contains(Integer.valueOf(i))) {
            this.f10602s = i;
            if (isReady()) {
                m7200d(true);
                invalidate();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Invalid scale type: " + i);
    }

    public final void setMaxScale(float f) {
        this.f10598o = f;
    }

    public final void setMinScale(float f) {
        this.f10599p = f;
    }

    public final void setMinimumDpi(int i) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setMaxScale(((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) / ((float) i));
    }

    public final void setMaximumDpi(int i) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setMinScale(((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) / ((float) i));
    }

    public float getMaxScale() {
        return this.f10598o;
    }

    public final float getMinScale() {
        return m7217k();
    }

    public void setMinimumTileDpi(int i) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.f10600q = (int) Math.min((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f, (float) i);
        if (isReady()) {
            m7173a(false);
            invalidate();
        }
    }

    public final PointF getCenter() {
        return viewToSourceCoord((float) (getWidth() / 2), (float) (getHeight() / 2));
    }

    public final float getScale() {
        return this.f10544C;
    }

    public final void setScaleAndCenter(float f, PointF pointF) {
        this.f10574ag = null;
        this.f10549H = Float.valueOf(f);
        this.f10550I = pointF;
        this.f10551J = pointF;
        invalidate();
    }

    public final void resetScaleAndCenter() {
        this.f10574ag = null;
        this.f10549H = Float.valueOf(m7206f(0.0f));
        if (isReady()) {
            this.f10550I = new PointF((float) (m7213i() / 2), (float) (m7215j() / 2));
        } else {
            this.f10550I = new PointF(0.0f, 0.0f);
        }
        invalidate();
    }

    public final boolean isReady() {
        return this.f10575ah;
    }

    public final boolean isImageLoaded() {
        return this.f10576ai;
    }

    public final int getSWidth() {
        return this.f10552K;
    }

    public final int getSHeight() {
        return this.f10553L;
    }

    public final int getOrientation() {
        return this.f10597n;
    }

    public final int getAppliedOrientation() {
        return getRequiredRotation();
    }

    public final IMImageViewState getState() {
        if (this.f10546E == null || this.f10552K <= 0 || this.f10553L <= 0) {
            return null;
        }
        return new IMImageViewState(getScale(), getCenter(), getOrientation());
    }

    public final boolean isZoomEnabled() {
        return this.f10607x;
    }

    public final void setZoomEnabled(boolean z) {
        this.f10607x = z;
    }

    public final boolean isQuickScaleEnabled() {
        return this.f10608y;
    }

    public final void setQuickScaleEnabled(boolean z) {
        this.f10608y = z;
    }

    public final boolean isPanEnabled() {
        return this.f10606w;
    }

    public final void setPanEnabled(boolean z) {
        PointF pointF;
        this.f10606w = z;
        if (!z && (pointF = this.f10546E) != null) {
            pointF.x = ((float) (getWidth() / 2)) - (this.f10544C * ((float) (m7213i() / 2)));
            this.f10546E.y = ((float) (getHeight() / 2)) - (this.f10544C * ((float) (m7215j() / 2)));
            if (isReady()) {
                m7193c(true);
                invalidate();
            }
        }
    }

    public final void setTileBackgroundColor(int i) {
        if (Color.alpha(i) == 0) {
            this.f10583aq = null;
        } else {
            Paint paint = new Paint();
            this.f10583aq = paint;
            paint.setStyle(Paint.Style.FILL);
            this.f10583aq.setColor(i);
        }
        invalidate();
    }

    public final void setDoubleTapZoomScale(float f) {
        this.f10609z = f;
    }

    public final void setDoubleTapZoomDpi(int i) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setDoubleTapZoomScale(((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) / ((float) i));
    }

    public final void setDoubleTapZoomStyle(int i) {
        if (f10538c.contains(Integer.valueOf(i))) {
            this.f10542A = i;
            return;
        }
        throw new IllegalArgumentException("Invalid zoom style: " + i);
    }

    public final void setDoubleTapZoomDuration(int i) {
        this.f10543B = Math.max(0, i);
    }

    public void setParallelLoadingEnabled(boolean z) {
        this.f10605v = z;
    }

    public final void setDebug(boolean z) {
        this.f10596m = z;
    }

    public boolean hasImage() {
        return (this.f10593j == null && this.f10590g == null) ? false : true;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f10579al = onLongClickListener;
    }

    public void setOnImageEventListener(OnImageEventListener onImageEventListener) {
        this.f10577aj = onImageEventListener;
    }

    public void setOnStateChangedListener(OnStateChangedListener onStateChangedListener) {
        this.f10578ak = onStateChangedListener;
    }

    /* renamed from: a */
    private void m7154a(float f, PointF pointF, int i) {
        OnStateChangedListener onStateChangedListener = this.f10578ak;
        if (onStateChangedListener != null) {
            float f2 = this.f10544C;
            if (f2 != f) {
                onStateChangedListener.onScaleChanged(f2, i);
            }
            if (!this.f10546E.equals(pointF)) {
                this.f10578ak.onCenterChanged(getCenter(), i);
            }
        }
    }

    public AnimationBuilder animateCenter(PointF pointF) {
        if (!isReady()) {
            return null;
        }
        return new AnimationBuilder(pointF);
    }

    public AnimationBuilder animateScale(float f) {
        if (!isReady()) {
            return null;
        }
        return new AnimationBuilder(f);
    }

    public AnimationBuilder animateScaleAndCenter(float f, PointF pointF) {
        if (!isReady()) {
            return null;
        }
        return new AnimationBuilder(f, pointF);
    }

    /* renamed from: com.didi.beatles.im.views.widget.longimage.IMSubsamplingScaleImageView$AnimationBuilder */
    public final class AnimationBuilder {
        private long duration;
        private int easing;
        private boolean interruptible;
        private OnAnimationEventListener listener;
        private int origin;
        private boolean panLimited;
        private final PointF targetSCenter;
        private final float targetScale;
        private final PointF vFocus;

        private AnimationBuilder(PointF pointF) {
            this.duration = 500;
            this.easing = 2;
            this.origin = 1;
            this.interruptible = true;
            this.panLimited = true;
            this.targetScale = IMSubsamplingScaleImageView.this.f10544C;
            this.targetSCenter = pointF;
            this.vFocus = null;
        }

        private AnimationBuilder(float f) {
            this.duration = 500;
            this.easing = 2;
            this.origin = 1;
            this.interruptible = true;
            this.panLimited = true;
            this.targetScale = f;
            this.targetSCenter = IMSubsamplingScaleImageView.this.getCenter();
            this.vFocus = null;
        }

        private AnimationBuilder(float f, PointF pointF) {
            this.duration = 500;
            this.easing = 2;
            this.origin = 1;
            this.interruptible = true;
            this.panLimited = true;
            this.targetScale = f;
            this.targetSCenter = pointF;
            this.vFocus = null;
        }

        private AnimationBuilder(float f, PointF pointF, PointF pointF2) {
            this.duration = 500;
            this.easing = 2;
            this.origin = 1;
            this.interruptible = true;
            this.panLimited = true;
            this.targetScale = f;
            this.targetSCenter = pointF;
            this.vFocus = pointF2;
        }

        public AnimationBuilder withDuration(long j) {
            this.duration = j;
            return this;
        }

        public AnimationBuilder withInterruptible(boolean z) {
            this.interruptible = z;
            return this;
        }

        public AnimationBuilder withEasing(int i) {
            if (IMSubsamplingScaleImageView.f10539d.contains(Integer.valueOf(i))) {
                this.easing = i;
                return this;
            }
            throw new IllegalArgumentException("Unknown easing type: " + i);
        }

        public AnimationBuilder withOnAnimationEventListener(OnAnimationEventListener onAnimationEventListener) {
            this.listener = onAnimationEventListener;
            return this;
        }

        /* access modifiers changed from: private */
        public AnimationBuilder withPanLimited(boolean z) {
            this.panLimited = z;
            return this;
        }

        /* access modifiers changed from: private */
        public AnimationBuilder withOrigin(int i) {
            this.origin = i;
            return this;
        }

        public void start() {
            if (!(IMSubsamplingScaleImageView.this.f10574ag == null || IMSubsamplingScaleImageView.this.f10574ag.listener == null)) {
                try {
                    IMSubsamplingScaleImageView.this.f10574ag.listener.onInterruptedByNewAnim();
                } catch (Exception e) {
                    SystemUtils.log(5, IMSubsamplingScaleImageView.f10535a, "Error thrown by animation listener", e, "com.didi.beatles.im.views.widget.longimage.IMSubsamplingScaleImageView$AnimationBuilder", 2917);
                }
            }
            int paddingLeft = IMSubsamplingScaleImageView.this.getPaddingLeft() + (((IMSubsamplingScaleImageView.this.getWidth() - IMSubsamplingScaleImageView.this.getPaddingRight()) - IMSubsamplingScaleImageView.this.getPaddingLeft()) / 2);
            int paddingTop = IMSubsamplingScaleImageView.this.getPaddingTop() + (((IMSubsamplingScaleImageView.this.getHeight() - IMSubsamplingScaleImageView.this.getPaddingBottom()) - IMSubsamplingScaleImageView.this.getPaddingTop()) / 2);
            float c = IMSubsamplingScaleImageView.this.m7206f(this.targetScale);
            PointF a = this.panLimited ? IMSubsamplingScaleImageView.this.m7148a(this.targetSCenter.x, this.targetSCenter.y, c, new PointF()) : this.targetSCenter;
            Anim unused = IMSubsamplingScaleImageView.this.f10574ag = new Anim();
            float unused2 = IMSubsamplingScaleImageView.this.f10574ag.scaleStart = IMSubsamplingScaleImageView.this.f10544C;
            float unused3 = IMSubsamplingScaleImageView.this.f10574ag.scaleEnd = c;
            long unused4 = IMSubsamplingScaleImageView.this.f10574ag.time = System.currentTimeMillis();
            PointF unused5 = IMSubsamplingScaleImageView.this.f10574ag.sCenterEndRequested = a;
            PointF unused6 = IMSubsamplingScaleImageView.this.f10574ag.sCenterStart = IMSubsamplingScaleImageView.this.getCenter();
            PointF unused7 = IMSubsamplingScaleImageView.this.f10574ag.sCenterEnd = a;
            PointF unused8 = IMSubsamplingScaleImageView.this.f10574ag.vFocusStart = IMSubsamplingScaleImageView.this.sourceToViewCoord(a);
            PointF unused9 = IMSubsamplingScaleImageView.this.f10574ag.vFocusEnd = new PointF((float) paddingLeft, (float) paddingTop);
            long unused10 = IMSubsamplingScaleImageView.this.f10574ag.duration = this.duration;
            boolean unused11 = IMSubsamplingScaleImageView.this.f10574ag.interruptible = this.interruptible;
            int unused12 = IMSubsamplingScaleImageView.this.f10574ag.easing = this.easing;
            int unused13 = IMSubsamplingScaleImageView.this.f10574ag.origin = this.origin;
            long unused14 = IMSubsamplingScaleImageView.this.f10574ag.time = System.currentTimeMillis();
            OnAnimationEventListener unused15 = IMSubsamplingScaleImageView.this.f10574ag.listener = this.listener;
            PointF pointF = this.vFocus;
            if (pointF != null) {
                float f = pointF.x - (IMSubsamplingScaleImageView.this.f10574ag.sCenterStart.x * c);
                float f2 = this.vFocus.y - (IMSubsamplingScaleImageView.this.f10574ag.sCenterStart.y * c);
                ScaleAndTranslate scaleAndTranslate = new ScaleAndTranslate(c, new PointF(f, f2));
                IMSubsamplingScaleImageView.this.m7174a(true, scaleAndTranslate);
                PointF unused16 = IMSubsamplingScaleImageView.this.f10574ag.vFocusEnd = new PointF(this.vFocus.x + (scaleAndTranslate.vTranslate.x - f), this.vFocus.y + (scaleAndTranslate.vTranslate.y - f2));
            }
            IMSubsamplingScaleImageView.this.invalidate();
        }
    }
}
