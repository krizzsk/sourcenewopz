package com.didi.beatles.p099im.views.widget.photoview;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.OverScroller;
import androidx.core.view.MotionEventCompat;

/* renamed from: com.didi.beatles.im.views.widget.photoview.PhotoViewAttacher */
public class PhotoViewAttacher implements View.OnLayoutChangeListener, View.OnTouchListener {

    /* renamed from: a */
    private static float f10612a = 3.0f;

    /* renamed from: b */
    private static float f10613b = 1.75f;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static float f10614c = 1.0f;

    /* renamed from: d */
    private static int f10615d = 200;

    /* renamed from: e */
    private static final int f10616e = -1;

    /* renamed from: f */
    private static final int f10617f = 0;

    /* renamed from: g */
    private static final int f10618g = 1;

    /* renamed from: h */
    private static final int f10619h = 2;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public static int f10620i = 1;
    /* access modifiers changed from: private */

    /* renamed from: A */
    public OnOutsidePhotoTapListener f10621A;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public OnViewTapListener f10622B;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public View.OnClickListener f10623C;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public View.OnLongClickListener f10624D;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public OnScaleChangedListener f10625E;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public OnSingleFlingListener f10626F;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public OnViewDragListener f10627G;
    /* access modifiers changed from: private */

    /* renamed from: H */
    public FlingRunnable f10628H;
    /* access modifiers changed from: private */

    /* renamed from: I */
    public int f10629I = 2;

    /* renamed from: J */
    private float f10630J;

    /* renamed from: K */
    private boolean f10631K = true;

    /* renamed from: L */
    private ImageView.ScaleType f10632L = ImageView.ScaleType.FIT_CENTER;
    /* access modifiers changed from: private */

    /* renamed from: M */
    public C4409c f10633M = new C4409c() {
        public void onDrag(float f, float f2) {
            if (!PhotoViewAttacher.this.f10643s.mo44629a()) {
                if (PhotoViewAttacher.this.f10627G != null) {
                    PhotoViewAttacher.this.f10627G.onDrag(f, f2);
                }
                PhotoViewAttacher.this.f10646v.postTranslate(f, f2);
                PhotoViewAttacher.this.m7242e();
                ViewParent parent = PhotoViewAttacher.this.f10641q.getParent();
                if (!PhotoViewAttacher.this.f10639o || PhotoViewAttacher.this.f10643s.mo44629a() || PhotoViewAttacher.this.f10640p) {
                    if (parent != null) {
                        parent.requestDisallowInterceptTouchEvent(true);
                    }
                } else if ((PhotoViewAttacher.this.f10629I == 2 || ((PhotoViewAttacher.this.f10629I == 0 && f >= 1.0f) || (PhotoViewAttacher.this.f10629I == 1 && f <= -1.0f))) && parent != null) {
                    parent.requestDisallowInterceptTouchEvent(false);
                }
            }
        }

        public void onFling(float f, float f2, float f3, float f4) {
            PhotoViewAttacher photoViewAttacher = PhotoViewAttacher.this;
            FlingRunnable unused = photoViewAttacher.f10628H = new FlingRunnable(photoViewAttacher.f10641q.getContext());
            FlingRunnable i = PhotoViewAttacher.this.f10628H;
            PhotoViewAttacher photoViewAttacher2 = PhotoViewAttacher.this;
            int a = photoViewAttacher2.m7226a(photoViewAttacher2.f10641q);
            PhotoViewAttacher photoViewAttacher3 = PhotoViewAttacher.this;
            i.fling(a, photoViewAttacher3.m7233b(photoViewAttacher3.f10641q), (int) f3, (int) f4);
            PhotoViewAttacher.this.f10641q.post(PhotoViewAttacher.this.f10628H);
        }

        public void onScale(float f, float f2, float f3) {
            if (PhotoViewAttacher.this.getScale() >= PhotoViewAttacher.this.f10638n && f >= 1.0f) {
                return;
            }
            if (PhotoViewAttacher.this.getScale() > PhotoViewAttacher.this.f10636l || f > 1.0f) {
                if (PhotoViewAttacher.this.f10625E != null) {
                    PhotoViewAttacher.this.f10625E.onScaleChange(f, f2, f3);
                }
                PhotoViewAttacher.this.f10646v.postScale(f, f, f2, f3);
                PhotoViewAttacher.this.m7242e();
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: j */
    public Interpolator f10634j = new AccelerateDecelerateInterpolator();
    /* access modifiers changed from: private */

    /* renamed from: k */
    public int f10635k = f10615d;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public float f10636l = f10614c;

    /* renamed from: m */
    private float f10637m = f10613b;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public float f10638n = f10612a;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public boolean f10639o = true;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public boolean f10640p = false;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public ImageView f10641q;

    /* renamed from: r */
    private GestureDetector f10642r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public C4408b f10643s;

    /* renamed from: t */
    private final Matrix f10644t = new Matrix();

    /* renamed from: u */
    private final Matrix f10645u = new Matrix();
    /* access modifiers changed from: private */

    /* renamed from: v */
    public final Matrix f10646v = new Matrix();

    /* renamed from: w */
    private final RectF f10647w = new RectF();

    /* renamed from: x */
    private final float[] f10648x = new float[9];

    /* renamed from: y */
    private OnMatrixChangedListener f10649y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public OnPhotoTapListener f10650z;

    public PhotoViewAttacher(ImageView imageView) {
        this.f10641q = imageView;
        imageView.setOnTouchListener(this);
        imageView.addOnLayoutChangeListener(this);
        if (!imageView.isInEditMode()) {
            this.f10630J = 0.0f;
            this.f10643s = new C4408b(imageView.getContext(), this.f10633M);
            GestureDetector gestureDetector = new GestureDetector(imageView.getContext(), new GestureDetector.SimpleOnGestureListener() {
                public void onLongPress(MotionEvent motionEvent) {
                    if (PhotoViewAttacher.this.f10624D != null) {
                        PhotoViewAttacher.this.f10624D.onLongClick(PhotoViewAttacher.this.f10641q);
                    }
                }

                public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                    if (PhotoViewAttacher.this.f10626F == null || PhotoViewAttacher.this.getScale() > PhotoViewAttacher.f10614c || MotionEventCompat.getPointerCount(motionEvent) > PhotoViewAttacher.f10620i || MotionEventCompat.getPointerCount(motionEvent2) > PhotoViewAttacher.f10620i) {
                        return false;
                    }
                    return PhotoViewAttacher.this.f10626F.onFling(motionEvent, motionEvent2, f, f2);
                }
            });
            this.f10642r = gestureDetector;
            gestureDetector.setOnDoubleTapListener(new GestureDetector.OnDoubleTapListener() {
                public boolean onDoubleTapEvent(MotionEvent motionEvent) {
                    return false;
                }

                public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                    if (PhotoViewAttacher.this.f10623C != null) {
                        PhotoViewAttacher.this.f10623C.onClick(PhotoViewAttacher.this.f10641q);
                    }
                    RectF displayRect = PhotoViewAttacher.this.getDisplayRect();
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    if (PhotoViewAttacher.this.f10622B != null) {
                        PhotoViewAttacher.this.f10622B.onViewTap(PhotoViewAttacher.this.f10641q, x, y);
                    }
                    if (displayRect == null) {
                        return false;
                    }
                    if (displayRect.contains(x, y)) {
                        float width = (x - displayRect.left) / displayRect.width();
                        float height = (y - displayRect.top) / displayRect.height();
                        if (PhotoViewAttacher.this.f10650z == null) {
                            return true;
                        }
                        PhotoViewAttacher.this.f10650z.onPhotoTap(PhotoViewAttacher.this.f10641q, width, height);
                        return true;
                    } else if (PhotoViewAttacher.this.f10621A == null) {
                        return false;
                    } else {
                        PhotoViewAttacher.this.f10621A.onOutsidePhotoTap(PhotoViewAttacher.this.f10641q);
                        return false;
                    }
                }

                public boolean onDoubleTap(MotionEvent motionEvent) {
                    try {
                        float scale = PhotoViewAttacher.this.getScale();
                        float x = motionEvent.getX();
                        float y = motionEvent.getY();
                        if (scale < PhotoViewAttacher.this.getMediumScale()) {
                            PhotoViewAttacher.this.setScale(PhotoViewAttacher.this.getMediumScale(), x, y, true);
                        } else if (scale < PhotoViewAttacher.this.getMediumScale() || scale >= PhotoViewAttacher.this.getMaximumScale()) {
                            PhotoViewAttacher.this.setScale(PhotoViewAttacher.this.getMinimumScale(), x, y, true);
                        } else {
                            PhotoViewAttacher.this.setScale(PhotoViewAttacher.this.getMaximumScale(), x, y, true);
                        }
                    } catch (ArrayIndexOutOfBoundsException unused) {
                    }
                    return true;
                }
            });
        }
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.f10642r.setOnDoubleTapListener(onDoubleTapListener);
    }

    public void setOnScaleChangeListener(OnScaleChangedListener onScaleChangedListener) {
        this.f10625E = onScaleChangedListener;
    }

    public void setOnSingleFlingListener(OnSingleFlingListener onSingleFlingListener) {
        this.f10626F = onSingleFlingListener;
    }

    @Deprecated
    public boolean isZoomEnabled() {
        return this.f10631K;
    }

    public RectF getDisplayRect() {
        m7243f();
        return m7235b(m7237c());
    }

    public boolean setDisplayMatrix(Matrix matrix) {
        if (matrix == null) {
            throw new IllegalArgumentException("Matrix cannot be null");
        } else if (this.f10641q.getDrawable() == null) {
            return false;
        } else {
            this.f10646v.set(matrix);
            m7242e();
            return true;
        }
    }

    public void setBaseRotation(float f) {
        this.f10630J = f % 360.0f;
        update();
        setRotationBy(this.f10630J);
        m7242e();
    }

    public void setRotationTo(float f) {
        this.f10646v.setRotate(f % 360.0f);
        m7242e();
    }

    public void setRotationBy(float f) {
        this.f10646v.postRotate(f % 360.0f);
        m7242e();
    }

    public float getMinimumScale() {
        return this.f10636l;
    }

    public float getMediumScale() {
        return this.f10637m;
    }

    public float getMaximumScale() {
        return this.f10638n;
    }

    public float getScale() {
        return (float) Math.sqrt((double) (((float) Math.pow((double) m7225a(this.f10646v, 0), 2.0d)) + ((float) Math.pow((double) m7225a(this.f10646v, 3), 2.0d))));
    }

    public ImageView.ScaleType getScaleType() {
        return this.f10632L;
    }

    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (i != i5 || i2 != i6 || i3 != i7 || i4 != i8) {
            m7231a(this.f10641q.getDrawable());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00bd A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouch(android.view.View r11, android.view.MotionEvent r12) {
        /*
            r10 = this;
            boolean r0 = r10.f10631K
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x00be
            r0 = r11
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            boolean r0 = com.didi.beatles.p099im.views.widget.photoview.C4410d.m7273a((android.widget.ImageView) r0)
            if (r0 == 0) goto L_0x00be
            int r0 = r12.getAction()
            if (r0 == 0) goto L_0x006e
            if (r0 == r2) goto L_0x001b
            r3 = 3
            if (r0 == r3) goto L_0x001b
            goto L_0x007a
        L_0x001b:
            float r0 = r10.getScale()
            float r3 = r10.f10636l
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 >= 0) goto L_0x0044
            android.graphics.RectF r0 = r10.getDisplayRect()
            if (r0 == 0) goto L_0x007a
            com.didi.beatles.im.views.widget.photoview.PhotoViewAttacher$AnimatedZoomRunnable r9 = new com.didi.beatles.im.views.widget.photoview.PhotoViewAttacher$AnimatedZoomRunnable
            float r5 = r10.getScale()
            float r6 = r10.f10636l
            float r7 = r0.centerX()
            float r8 = r0.centerY()
            r3 = r9
            r4 = r10
            r3.<init>(r5, r6, r7, r8)
            r11.post(r9)
            goto L_0x006c
        L_0x0044:
            float r0 = r10.getScale()
            float r3 = r10.f10638n
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 <= 0) goto L_0x007a
            android.graphics.RectF r0 = r10.getDisplayRect()
            if (r0 == 0) goto L_0x007a
            com.didi.beatles.im.views.widget.photoview.PhotoViewAttacher$AnimatedZoomRunnable r9 = new com.didi.beatles.im.views.widget.photoview.PhotoViewAttacher$AnimatedZoomRunnable
            float r5 = r10.getScale()
            float r6 = r10.f10638n
            float r7 = r0.centerX()
            float r8 = r0.centerY()
            r3 = r9
            r4 = r10
            r3.<init>(r5, r6, r7, r8)
            r11.post(r9)
        L_0x006c:
            r11 = 1
            goto L_0x007b
        L_0x006e:
            android.view.ViewParent r11 = r11.getParent()
            if (r11 == 0) goto L_0x0077
            r11.requestDisallowInterceptTouchEvent(r2)
        L_0x0077:
            r10.m7245g()
        L_0x007a:
            r11 = 0
        L_0x007b:
            com.didi.beatles.im.views.widget.photoview.b r0 = r10.f10643s
            if (r0 == 0) goto L_0x00b2
            boolean r11 = r0.mo44629a()
            com.didi.beatles.im.views.widget.photoview.b r0 = r10.f10643s
            boolean r0 = r0.mo44631b()
            com.didi.beatles.im.views.widget.photoview.b r3 = r10.f10643s
            boolean r3 = r3.mo44630a((android.view.MotionEvent) r12)
            if (r11 != 0) goto L_0x009b
            com.didi.beatles.im.views.widget.photoview.b r11 = r10.f10643s
            boolean r11 = r11.mo44629a()
            if (r11 != 0) goto L_0x009b
            r11 = 1
            goto L_0x009c
        L_0x009b:
            r11 = 0
        L_0x009c:
            if (r0 != 0) goto L_0x00a8
            com.didi.beatles.im.views.widget.photoview.b r0 = r10.f10643s
            boolean r0 = r0.mo44631b()
            if (r0 != 0) goto L_0x00a8
            r0 = 1
            goto L_0x00a9
        L_0x00a8:
            r0 = 0
        L_0x00a9:
            if (r11 == 0) goto L_0x00ae
            if (r0 == 0) goto L_0x00ae
            r1 = 1
        L_0x00ae:
            r10.f10640p = r1
            r1 = r3
            goto L_0x00b3
        L_0x00b2:
            r1 = r11
        L_0x00b3:
            android.view.GestureDetector r11 = r10.f10642r
            if (r11 == 0) goto L_0x00be
            boolean r11 = r11.onTouchEvent(r12)
            if (r11 == 0) goto L_0x00be
            r1 = 1
        L_0x00be:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.beatles.p099im.views.widget.photoview.PhotoViewAttacher.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public void setAllowParentInterceptOnEdge(boolean z) {
        this.f10639o = z;
    }

    public void setMinimumScale(float f) {
        C4410d.m7271a(f, this.f10637m, this.f10638n);
        this.f10636l = f;
    }

    public void setMediumScale(float f) {
        C4410d.m7271a(this.f10636l, f, this.f10638n);
        this.f10637m = f;
    }

    public void setMaximumScale(float f) {
        C4410d.m7271a(this.f10636l, this.f10637m, f);
        this.f10638n = f;
    }

    public void setScaleLevels(float f, float f2, float f3) {
        C4410d.m7271a(f, f2, f3);
        this.f10636l = f;
        this.f10637m = f2;
        this.f10638n = f3;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f10624D = onLongClickListener;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f10623C = onClickListener;
    }

    public void setOnMatrixChangeListener(OnMatrixChangedListener onMatrixChangedListener) {
        this.f10649y = onMatrixChangedListener;
    }

    public void setOnPhotoTapListener(OnPhotoTapListener onPhotoTapListener) {
        this.f10650z = onPhotoTapListener;
    }

    public void setOnOutsidePhotoTapListener(OnOutsidePhotoTapListener onOutsidePhotoTapListener) {
        this.f10621A = onOutsidePhotoTapListener;
    }

    public void setOnViewTapListener(OnViewTapListener onViewTapListener) {
        this.f10622B = onViewTapListener;
    }

    public void setOnViewDragListener(OnViewDragListener onViewDragListener) {
        this.f10627G = onViewDragListener;
    }

    public void setScale(float f) {
        setScale(f, false);
    }

    public void setScale(float f, boolean z) {
        setScale(f, (float) (this.f10641q.getRight() / 2), (float) (this.f10641q.getBottom() / 2), z);
    }

    public void setScale(float f, float f2, float f3, boolean z) {
        if (f < this.f10636l || f > this.f10638n) {
            throw new IllegalArgumentException("Scale must be within the range of minScale and maxScale");
        } else if (z) {
            this.f10641q.post(new AnimatedZoomRunnable(getScale(), f, f2, f3));
        } else {
            this.f10646v.setScale(f, f, f2, f3);
            m7242e();
        }
    }

    public void setZoomInterpolator(Interpolator interpolator) {
        this.f10634j = interpolator;
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        if (C4410d.m7272a(scaleType) && scaleType != this.f10632L) {
            this.f10632L = scaleType;
            update();
        }
    }

    public boolean isZoomable() {
        return this.f10631K;
    }

    public void setZoomable(boolean z) {
        this.f10631K = z;
        update();
    }

    public void update() {
        if (this.f10631K) {
            m7231a(this.f10641q.getDrawable());
        } else {
            m7239d();
        }
    }

    public void getDisplayMatrix(Matrix matrix) {
        matrix.set(m7237c());
    }

    public void getSuppMatrix(Matrix matrix) {
        matrix.set(this.f10646v);
    }

    /* renamed from: c */
    private Matrix m7237c() {
        this.f10645u.set(this.f10644t);
        this.f10645u.postConcat(this.f10646v);
        return this.f10645u;
    }

    public Matrix getImageMatrix() {
        return this.f10645u;
    }

    public void setZoomTransitionDuration(int i) {
        this.f10635k = i;
    }

    /* renamed from: a */
    private float m7225a(Matrix matrix, int i) {
        matrix.getValues(this.f10648x);
        return this.f10648x[i];
    }

    /* renamed from: d */
    private void m7239d() {
        this.f10646v.reset();
        setRotationBy(this.f10630J);
        m7230a(m7237c());
        m7243f();
    }

    /* renamed from: a */
    private void m7230a(Matrix matrix) {
        RectF b;
        this.f10641q.setImageMatrix(matrix);
        if (this.f10649y != null && (b = m7235b(matrix)) != null) {
            this.f10649y.onMatrixChanged(b);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m7242e() {
        if (m7243f()) {
            m7230a(m7237c());
        }
    }

    /* renamed from: b */
    private RectF m7235b(Matrix matrix) {
        Drawable drawable = this.f10641q.getDrawable();
        if (drawable == null) {
            return null;
        }
        this.f10647w.set(0.0f, 0.0f, (float) drawable.getIntrinsicWidth(), (float) drawable.getIntrinsicHeight());
        matrix.mapRect(this.f10647w);
        return this.f10647w;
    }

    /* renamed from: a */
    private void m7231a(Drawable drawable) {
        if (drawable != null) {
            float a = (float) m7226a(this.f10641q);
            float b = (float) m7233b(this.f10641q);
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            this.f10644t.reset();
            float f = (float) intrinsicWidth;
            float f2 = a / f;
            float f3 = (float) intrinsicHeight;
            float f4 = b / f3;
            if (this.f10632L == ImageView.ScaleType.CENTER) {
                this.f10644t.postTranslate((a - f) / 2.0f, (b - f3) / 2.0f);
            } else if (this.f10632L == ImageView.ScaleType.CENTER_CROP) {
                float max = Math.max(f2, f4);
                this.f10644t.postScale(max, max);
                this.f10644t.postTranslate((a - (f * max)) / 2.0f, (b - (f3 * max)) / 2.0f);
            } else if (this.f10632L == ImageView.ScaleType.CENTER_INSIDE) {
                float min = Math.min(1.0f, Math.min(f2, f4));
                this.f10644t.postScale(min, min);
                this.f10644t.postTranslate((a - (f * min)) / 2.0f, (b - (f3 * min)) / 2.0f);
            } else {
                RectF rectF = new RectF(0.0f, 0.0f, f, f3);
                RectF rectF2 = new RectF(0.0f, 0.0f, a, b);
                if (((int) this.f10630J) % 180 != 0) {
                    rectF = new RectF(0.0f, 0.0f, f3, f);
                }
                int i = C44064.$SwitchMap$android$widget$ImageView$ScaleType[this.f10632L.ordinal()];
                if (i == 1) {
                    this.f10644t.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
                } else if (i == 2) {
                    this.f10644t.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
                } else if (i == 3) {
                    this.f10644t.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.END);
                } else if (i == 4) {
                    this.f10644t.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
                }
            }
            m7239d();
        }
    }

    /* renamed from: com.didi.beatles.im.views.widget.photoview.PhotoViewAttacher$4 */
    static /* synthetic */ class C44064 {
        static final /* synthetic */ int[] $SwitchMap$android$widget$ImageView$ScaleType;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                android.widget.ImageView$ScaleType[] r0 = android.widget.ImageView.ScaleType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$android$widget$ImageView$ScaleType = r0
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_CENTER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$android$widget$ImageView$ScaleType     // Catch:{ NoSuchFieldError -> 0x001d }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_START     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$android$widget$ImageView$ScaleType     // Catch:{ NoSuchFieldError -> 0x0028 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_END     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$android$widget$ImageView$ScaleType     // Catch:{ NoSuchFieldError -> 0x0033 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_XY     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.beatles.p099im.views.widget.photoview.PhotoViewAttacher.C44064.<clinit>():void");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x007f  */
    /* renamed from: f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m7243f() {
        /*
            r11 = this;
            android.graphics.Matrix r0 = r11.m7237c()
            android.graphics.RectF r0 = r11.m7235b((android.graphics.Matrix) r0)
            r1 = 0
            if (r0 != 0) goto L_0x000c
            return r1
        L_0x000c:
            float r2 = r0.height()
            float r3 = r0.width()
            android.widget.ImageView r4 = r11.f10641q
            int r4 = r11.m7233b((android.widget.ImageView) r4)
            float r4 = (float) r4
            r5 = 1073741824(0x40000000, float:2.0)
            r6 = 3
            r7 = 2
            r8 = 0
            int r9 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r9 > 0) goto L_0x003f
            int[] r9 = com.didi.beatles.p099im.views.widget.photoview.PhotoViewAttacher.C44064.$SwitchMap$android$widget$ImageView$ScaleType
            android.widget.ImageView$ScaleType r10 = r11.f10632L
            int r10 = r10.ordinal()
            r9 = r9[r10]
            if (r9 == r7) goto L_0x003c
            if (r9 == r6) goto L_0x0037
            float r4 = r4 - r2
            float r4 = r4 / r5
            float r2 = r0.top
            goto L_0x003a
        L_0x0037:
            float r4 = r4 - r2
            float r2 = r0.top
        L_0x003a:
            float r4 = r4 - r2
            goto L_0x0053
        L_0x003c:
            float r2 = r0.top
            goto L_0x0047
        L_0x003f:
            float r2 = r0.top
            int r2 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r2 <= 0) goto L_0x0049
            float r2 = r0.top
        L_0x0047:
            float r4 = -r2
            goto L_0x0053
        L_0x0049:
            float r2 = r0.bottom
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 >= 0) goto L_0x0052
            float r2 = r0.bottom
            goto L_0x003a
        L_0x0052:
            r4 = 0
        L_0x0053:
            android.widget.ImageView r2 = r11.f10641q
            int r2 = r11.m7226a((android.widget.ImageView) r2)
            float r2 = (float) r2
            r9 = 1
            int r10 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r10 > 0) goto L_0x007f
            int[] r1 = com.didi.beatles.p099im.views.widget.photoview.PhotoViewAttacher.C44064.$SwitchMap$android$widget$ImageView$ScaleType
            android.widget.ImageView$ScaleType r8 = r11.f10632L
            int r8 = r8.ordinal()
            r1 = r1[r8]
            if (r1 == r7) goto L_0x0078
            if (r1 == r6) goto L_0x0072
            float r2 = r2 - r3
            float r2 = r2 / r5
            float r0 = r0.left
            goto L_0x0075
        L_0x0072:
            float r2 = r2 - r3
            float r0 = r0.left
        L_0x0075:
            float r2 = r2 - r0
            r8 = r2
            goto L_0x007c
        L_0x0078:
            float r0 = r0.left
            float r0 = -r0
            r8 = r0
        L_0x007c:
            r11.f10629I = r7
            goto L_0x009b
        L_0x007f:
            float r3 = r0.left
            int r3 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r3 <= 0) goto L_0x008b
            r11.f10629I = r1
            float r0 = r0.left
            float r8 = -r0
            goto L_0x009b
        L_0x008b:
            float r1 = r0.right
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 >= 0) goto L_0x0098
            float r0 = r0.right
            float r8 = r2 - r0
            r11.f10629I = r9
            goto L_0x009b
        L_0x0098:
            r0 = -1
            r11.f10629I = r0
        L_0x009b:
            android.graphics.Matrix r0 = r11.f10646v
            r0.postTranslate(r8, r4)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.beatles.p099im.views.widget.photoview.PhotoViewAttacher.m7243f():boolean");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public int m7226a(ImageView imageView) {
        return (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public int m7233b(ImageView imageView) {
        return (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
    }

    /* renamed from: g */
    private void m7245g() {
        FlingRunnable flingRunnable = this.f10628H;
        if (flingRunnable != null) {
            flingRunnable.cancelFling();
            this.f10628H = null;
        }
    }

    /* renamed from: com.didi.beatles.im.views.widget.photoview.PhotoViewAttacher$AnimatedZoomRunnable */
    private class AnimatedZoomRunnable implements Runnable {
        private final float mFocalX;
        private final float mFocalY;
        private final long mStartTime = System.currentTimeMillis();
        private final float mZoomEnd;
        private final float mZoomStart;

        public AnimatedZoomRunnable(float f, float f2, float f3, float f4) {
            this.mFocalX = f3;
            this.mFocalY = f4;
            this.mZoomStart = f;
            this.mZoomEnd = f2;
        }

        public void run() {
            float interpolate = interpolate();
            float f = this.mZoomStart;
            PhotoViewAttacher.this.f10633M.onScale((f + ((this.mZoomEnd - f) * interpolate)) / PhotoViewAttacher.this.getScale(), this.mFocalX, this.mFocalY);
            if (interpolate < 1.0f) {
                C4407a.m7261a(PhotoViewAttacher.this.f10641q, this);
            }
        }

        private float interpolate() {
            return PhotoViewAttacher.this.f10634j.getInterpolation(Math.min(1.0f, (((float) (System.currentTimeMillis() - this.mStartTime)) * 1.0f) / ((float) PhotoViewAttacher.this.f10635k)));
        }
    }

    /* renamed from: com.didi.beatles.im.views.widget.photoview.PhotoViewAttacher$FlingRunnable */
    private class FlingRunnable implements Runnable {
        private int mCurrentX;
        private int mCurrentY;
        private final OverScroller mScroller;

        public FlingRunnable(Context context) {
            this.mScroller = new OverScroller(context);
        }

        public void cancelFling() {
            this.mScroller.forceFinished(true);
        }

        public void fling(int i, int i2, int i3, int i4) {
            int i5;
            int i6;
            int i7;
            int i8;
            RectF displayRect = PhotoViewAttacher.this.getDisplayRect();
            if (displayRect != null) {
                int round = Math.round(-displayRect.left);
                float f = (float) i;
                if (f < displayRect.width()) {
                    i5 = Math.round(displayRect.width() - f);
                    i6 = 0;
                } else {
                    i6 = round;
                    i5 = i6;
                }
                int round2 = Math.round(-displayRect.top);
                float f2 = (float) i2;
                if (f2 < displayRect.height()) {
                    i7 = Math.round(displayRect.height() - f2);
                    i8 = 0;
                } else {
                    i8 = round2;
                    i7 = i8;
                }
                this.mCurrentX = round;
                this.mCurrentY = round2;
                if (round != i5 || round2 != i7) {
                    this.mScroller.fling(round, round2, i3, i4, i6, i5, i8, i7, 0, 0);
                }
            }
        }

        public void run() {
            if (!this.mScroller.isFinished() && this.mScroller.computeScrollOffset()) {
                int currX = this.mScroller.getCurrX();
                int currY = this.mScroller.getCurrY();
                PhotoViewAttacher.this.f10646v.postTranslate((float) (this.mCurrentX - currX), (float) (this.mCurrentY - currY));
                PhotoViewAttacher.this.m7242e();
                this.mCurrentX = currX;
                this.mCurrentY = currY;
                C4407a.m7261a(PhotoViewAttacher.this.f10641q, this);
            }
        }
    }
}
