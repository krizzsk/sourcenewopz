package com.didi.nova.assembly.components.bigimage.photoview;

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

public class PhotoViewAttacher implements View.OnLayoutChangeListener, View.OnTouchListener {

    /* renamed from: a */
    private static float f29099a = 3.0f;

    /* renamed from: b */
    private static float f29100b = 1.75f;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static float f29101c = 1.0f;

    /* renamed from: d */
    private static int f29102d = 200;

    /* renamed from: e */
    private static final int f29103e = -1;

    /* renamed from: f */
    private static final int f29104f = 0;

    /* renamed from: g */
    private static final int f29105g = 1;

    /* renamed from: h */
    private static final int f29106h = 2;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public static int f29107i = 1;
    /* access modifiers changed from: private */

    /* renamed from: A */
    public OnOutsidePhotoTapListener f29108A;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public OnViewTapListener f29109B;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public View.OnClickListener f29110C;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public View.OnLongClickListener f29111D;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public OnScaleChangedListener f29112E;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public OnSingleFlingListener f29113F;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public OnViewDragListener f29114G;
    /* access modifiers changed from: private */

    /* renamed from: H */
    public FlingRunnable f29115H;
    /* access modifiers changed from: private */

    /* renamed from: I */
    public int f29116I = 2;

    /* renamed from: J */
    private float f29117J;

    /* renamed from: K */
    private boolean f29118K = true;

    /* renamed from: L */
    private ImageView.ScaleType f29119L = ImageView.ScaleType.FIT_CENTER;
    /* access modifiers changed from: private */

    /* renamed from: M */
    public C10262c f29120M = new C10262c() {
        public void onDrag(float f, float f2) {
            if (!PhotoViewAttacher.this.f29130s.mo80110a()) {
                if (PhotoViewAttacher.this.f29114G != null) {
                    PhotoViewAttacher.this.f29114G.onDrag(f, f2);
                }
                PhotoViewAttacher.this.f29133v.postTranslate(f, f2);
                PhotoViewAttacher.this.m20532e();
                ViewParent parent = PhotoViewAttacher.this.f29128q.getParent();
                if (!PhotoViewAttacher.this.f29126o || PhotoViewAttacher.this.f29130s.mo80110a() || PhotoViewAttacher.this.f29127p) {
                    if (parent != null) {
                        parent.requestDisallowInterceptTouchEvent(true);
                    }
                } else if ((PhotoViewAttacher.this.f29116I == 2 || ((PhotoViewAttacher.this.f29116I == 0 && f >= 1.0f) || (PhotoViewAttacher.this.f29116I == 1 && f <= -1.0f))) && parent != null) {
                    parent.requestDisallowInterceptTouchEvent(false);
                }
            }
        }

        public void onFling(float f, float f2, float f3, float f4) {
            PhotoViewAttacher photoViewAttacher = PhotoViewAttacher.this;
            FlingRunnable unused = photoViewAttacher.f29115H = new FlingRunnable(photoViewAttacher.f29128q.getContext());
            FlingRunnable i = PhotoViewAttacher.this.f29115H;
            PhotoViewAttacher photoViewAttacher2 = PhotoViewAttacher.this;
            int a = photoViewAttacher2.m20516a(photoViewAttacher2.f29128q);
            PhotoViewAttacher photoViewAttacher3 = PhotoViewAttacher.this;
            i.fling(a, photoViewAttacher3.m20523b(photoViewAttacher3.f29128q), (int) f3, (int) f4);
            PhotoViewAttacher.this.f29128q.post(PhotoViewAttacher.this.f29115H);
        }

        public void onScale(float f, float f2, float f3) {
            if (PhotoViewAttacher.this.getScale() >= PhotoViewAttacher.this.f29125n && f >= 1.0f) {
                return;
            }
            if (PhotoViewAttacher.this.getScale() > PhotoViewAttacher.this.f29123l || f > 1.0f) {
                if (PhotoViewAttacher.this.f29112E != null) {
                    PhotoViewAttacher.this.f29112E.onScaleChange(f, f2, f3);
                }
                PhotoViewAttacher.this.f29133v.postScale(f, f, f2, f3);
                PhotoViewAttacher.this.m20532e();
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: j */
    public Interpolator f29121j = new AccelerateDecelerateInterpolator();
    /* access modifiers changed from: private */

    /* renamed from: k */
    public int f29122k = f29102d;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public float f29123l = f29101c;

    /* renamed from: m */
    private float f29124m = f29100b;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public float f29125n = f29099a;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public boolean f29126o = true;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public boolean f29127p = false;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public ImageView f29128q;

    /* renamed from: r */
    private GestureDetector f29129r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public C10261b f29130s;

    /* renamed from: t */
    private final Matrix f29131t = new Matrix();

    /* renamed from: u */
    private final Matrix f29132u = new Matrix();
    /* access modifiers changed from: private */

    /* renamed from: v */
    public final Matrix f29133v = new Matrix();

    /* renamed from: w */
    private final RectF f29134w = new RectF();

    /* renamed from: x */
    private final float[] f29135x = new float[9];

    /* renamed from: y */
    private OnMatrixChangedListener f29136y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public OnPhotoTapListener f29137z;

    public PhotoViewAttacher(ImageView imageView) {
        this.f29128q = imageView;
        imageView.setOnTouchListener(this);
        imageView.addOnLayoutChangeListener(this);
        if (!imageView.isInEditMode()) {
            this.f29117J = 0.0f;
            this.f29130s = new C10261b(imageView.getContext(), this.f29120M);
            GestureDetector gestureDetector = new GestureDetector(imageView.getContext(), new GestureDetector.SimpleOnGestureListener() {
                public void onLongPress(MotionEvent motionEvent) {
                    if (PhotoViewAttacher.this.f29111D != null) {
                        PhotoViewAttacher.this.f29111D.onLongClick(PhotoViewAttacher.this.f29128q);
                    }
                }

                public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                    if (PhotoViewAttacher.this.f29113F == null || PhotoViewAttacher.this.getScale() > PhotoViewAttacher.f29101c || MotionEventCompat.getPointerCount(motionEvent) > PhotoViewAttacher.f29107i || MotionEventCompat.getPointerCount(motionEvent2) > PhotoViewAttacher.f29107i) {
                        return false;
                    }
                    return PhotoViewAttacher.this.f29113F.onFling(motionEvent, motionEvent2, f, f2);
                }
            });
            this.f29129r = gestureDetector;
            gestureDetector.setOnDoubleTapListener(new GestureDetector.OnDoubleTapListener() {
                public boolean onDoubleTapEvent(MotionEvent motionEvent) {
                    return false;
                }

                public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                    if (PhotoViewAttacher.this.f29110C != null) {
                        PhotoViewAttacher.this.f29110C.onClick(PhotoViewAttacher.this.f29128q);
                    }
                    RectF displayRect = PhotoViewAttacher.this.getDisplayRect();
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    if (PhotoViewAttacher.this.f29109B != null) {
                        PhotoViewAttacher.this.f29109B.onViewTap(PhotoViewAttacher.this.f29128q, x, y);
                    }
                    if (displayRect == null) {
                        return false;
                    }
                    if (displayRect.contains(x, y)) {
                        float width = (x - displayRect.left) / displayRect.width();
                        float height = (y - displayRect.top) / displayRect.height();
                        if (PhotoViewAttacher.this.f29137z == null) {
                            return true;
                        }
                        PhotoViewAttacher.this.f29137z.onPhotoTap(PhotoViewAttacher.this.f29128q, width, height);
                        return true;
                    } else if (PhotoViewAttacher.this.f29108A == null) {
                        return false;
                    } else {
                        PhotoViewAttacher.this.f29108A.onOutsidePhotoTap(PhotoViewAttacher.this.f29128q);
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
        this.f29129r.setOnDoubleTapListener(onDoubleTapListener);
    }

    public void setOnScaleChangeListener(OnScaleChangedListener onScaleChangedListener) {
        this.f29112E = onScaleChangedListener;
    }

    public void setOnSingleFlingListener(OnSingleFlingListener onSingleFlingListener) {
        this.f29113F = onSingleFlingListener;
    }

    @Deprecated
    public boolean isZoomEnabled() {
        return this.f29118K;
    }

    public RectF getDisplayRect() {
        m20533f();
        return m20525b(m20527c());
    }

    public boolean setDisplayMatrix(Matrix matrix) {
        if (matrix == null) {
            throw new IllegalArgumentException("Matrix cannot be null");
        } else if (this.f29128q.getDrawable() == null) {
            return false;
        } else {
            this.f29133v.set(matrix);
            m20532e();
            return true;
        }
    }

    public void setBaseRotation(float f) {
        this.f29117J = f % 360.0f;
        update();
        setRotationBy(this.f29117J);
        m20532e();
    }

    public void setRotationTo(float f) {
        this.f29133v.setRotate(f % 360.0f);
        m20532e();
    }

    public void setRotationBy(float f) {
        this.f29133v.postRotate(f % 360.0f);
        m20532e();
    }

    public float getMinimumScale() {
        return this.f29123l;
    }

    public float getMediumScale() {
        return this.f29124m;
    }

    public float getMaximumScale() {
        return this.f29125n;
    }

    public float getScale() {
        return (float) Math.sqrt((double) (((float) Math.pow((double) m20515a(this.f29133v, 0), 2.0d)) + ((float) Math.pow((double) m20515a(this.f29133v, 3), 2.0d))));
    }

    public ImageView.ScaleType getScaleType() {
        return this.f29119L;
    }

    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (i != i5 || i2 != i6 || i3 != i7 || i4 != i8) {
            m20521a(this.f29128q.getDrawable());
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
            boolean r0 = r10.f29118K
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x00be
            r0 = r11
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            boolean r0 = com.didi.nova.assembly.components.bigimage.photoview.C10263d.m20563a((android.widget.ImageView) r0)
            if (r0 == 0) goto L_0x00be
            int r0 = r12.getAction()
            if (r0 == 0) goto L_0x006e
            if (r0 == r2) goto L_0x001b
            r3 = 3
            if (r0 == r3) goto L_0x001b
            goto L_0x007a
        L_0x001b:
            float r0 = r10.getScale()
            float r3 = r10.f29123l
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 >= 0) goto L_0x0044
            android.graphics.RectF r0 = r10.getDisplayRect()
            if (r0 == 0) goto L_0x007a
            com.didi.nova.assembly.components.bigimage.photoview.PhotoViewAttacher$AnimatedZoomRunnable r9 = new com.didi.nova.assembly.components.bigimage.photoview.PhotoViewAttacher$AnimatedZoomRunnable
            float r5 = r10.getScale()
            float r6 = r10.f29123l
            float r7 = r0.centerX()
            float r8 = r0.centerY()
            r3 = r9
            r4 = r10
            r3.<init>(r5, r6, r7, r8)
            r11.post(r9)
            goto L_0x006c
        L_0x0044:
            float r0 = r10.getScale()
            float r3 = r10.f29125n
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 <= 0) goto L_0x007a
            android.graphics.RectF r0 = r10.getDisplayRect()
            if (r0 == 0) goto L_0x007a
            com.didi.nova.assembly.components.bigimage.photoview.PhotoViewAttacher$AnimatedZoomRunnable r9 = new com.didi.nova.assembly.components.bigimage.photoview.PhotoViewAttacher$AnimatedZoomRunnable
            float r5 = r10.getScale()
            float r6 = r10.f29125n
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
            r10.m20535g()
        L_0x007a:
            r11 = 0
        L_0x007b:
            com.didi.nova.assembly.components.bigimage.photoview.b r0 = r10.f29130s
            if (r0 == 0) goto L_0x00b2
            boolean r11 = r0.mo80110a()
            com.didi.nova.assembly.components.bigimage.photoview.b r0 = r10.f29130s
            boolean r0 = r0.mo80112b()
            com.didi.nova.assembly.components.bigimage.photoview.b r3 = r10.f29130s
            boolean r3 = r3.mo80111a((android.view.MotionEvent) r12)
            if (r11 != 0) goto L_0x009b
            com.didi.nova.assembly.components.bigimage.photoview.b r11 = r10.f29130s
            boolean r11 = r11.mo80110a()
            if (r11 != 0) goto L_0x009b
            r11 = 1
            goto L_0x009c
        L_0x009b:
            r11 = 0
        L_0x009c:
            if (r0 != 0) goto L_0x00a8
            com.didi.nova.assembly.components.bigimage.photoview.b r0 = r10.f29130s
            boolean r0 = r0.mo80112b()
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
            r10.f29127p = r1
            r1 = r3
            goto L_0x00b3
        L_0x00b2:
            r1 = r11
        L_0x00b3:
            android.view.GestureDetector r11 = r10.f29129r
            if (r11 == 0) goto L_0x00be
            boolean r11 = r11.onTouchEvent(r12)
            if (r11 == 0) goto L_0x00be
            r1 = 1
        L_0x00be:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.nova.assembly.components.bigimage.photoview.PhotoViewAttacher.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public void setAllowParentInterceptOnEdge(boolean z) {
        this.f29126o = z;
    }

    public void setMinimumScale(float f) {
        C10263d.m20561a(f, this.f29124m, this.f29125n);
        this.f29123l = f;
    }

    public void setMediumScale(float f) {
        C10263d.m20561a(this.f29123l, f, this.f29125n);
        this.f29124m = f;
    }

    public void setMaximumScale(float f) {
        C10263d.m20561a(this.f29123l, this.f29124m, f);
        this.f29125n = f;
    }

    public void setScaleLevels(float f, float f2, float f3) {
        C10263d.m20561a(f, f2, f3);
        this.f29123l = f;
        this.f29124m = f2;
        this.f29125n = f3;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f29111D = onLongClickListener;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f29110C = onClickListener;
    }

    public void setOnMatrixChangeListener(OnMatrixChangedListener onMatrixChangedListener) {
        this.f29136y = onMatrixChangedListener;
    }

    public void setOnPhotoTapListener(OnPhotoTapListener onPhotoTapListener) {
        this.f29137z = onPhotoTapListener;
    }

    public void setOnOutsidePhotoTapListener(OnOutsidePhotoTapListener onOutsidePhotoTapListener) {
        this.f29108A = onOutsidePhotoTapListener;
    }

    public void setOnViewTapListener(OnViewTapListener onViewTapListener) {
        this.f29109B = onViewTapListener;
    }

    public void setOnViewDragListener(OnViewDragListener onViewDragListener) {
        this.f29114G = onViewDragListener;
    }

    public void setScale(float f) {
        setScale(f, false);
    }

    public void setScale(float f, boolean z) {
        setScale(f, (float) (this.f29128q.getRight() / 2), (float) (this.f29128q.getBottom() / 2), z);
    }

    public void setScale(float f, float f2, float f3, boolean z) {
        if (f < this.f29123l || f > this.f29125n) {
            throw new IllegalArgumentException("Scale must be within the range of minScale and maxScale");
        } else if (z) {
            this.f29128q.post(new AnimatedZoomRunnable(getScale(), f, f2, f3));
        } else {
            this.f29133v.setScale(f, f, f2, f3);
            m20532e();
        }
    }

    public void setZoomInterpolator(Interpolator interpolator) {
        this.f29121j = interpolator;
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        if (C10263d.m20562a(scaleType) && scaleType != this.f29119L) {
            this.f29119L = scaleType;
            update();
        }
    }

    public boolean isZoomable() {
        return this.f29118K;
    }

    public void setZoomable(boolean z) {
        this.f29118K = z;
        update();
    }

    public void update() {
        if (this.f29118K) {
            m20521a(this.f29128q.getDrawable());
        } else {
            m20529d();
        }
    }

    public void getDisplayMatrix(Matrix matrix) {
        matrix.set(m20527c());
    }

    public void getSuppMatrix(Matrix matrix) {
        matrix.set(this.f29133v);
    }

    /* renamed from: c */
    private Matrix m20527c() {
        this.f29132u.set(this.f29131t);
        this.f29132u.postConcat(this.f29133v);
        return this.f29132u;
    }

    public Matrix getImageMatrix() {
        return this.f29132u;
    }

    public void setZoomTransitionDuration(int i) {
        this.f29122k = i;
    }

    /* renamed from: a */
    private float m20515a(Matrix matrix, int i) {
        matrix.getValues(this.f29135x);
        return this.f29135x[i];
    }

    /* renamed from: d */
    private void m20529d() {
        this.f29133v.reset();
        setRotationBy(this.f29117J);
        m20520a(m20527c());
        m20533f();
    }

    /* renamed from: a */
    private void m20520a(Matrix matrix) {
        RectF b;
        this.f29128q.setImageMatrix(matrix);
        if (this.f29136y != null && (b = m20525b(matrix)) != null) {
            this.f29136y.onMatrixChanged(b);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m20532e() {
        if (m20533f()) {
            m20520a(m20527c());
        }
    }

    /* renamed from: b */
    private RectF m20525b(Matrix matrix) {
        Drawable drawable = this.f29128q.getDrawable();
        if (drawable == null) {
            return null;
        }
        this.f29134w.set(0.0f, 0.0f, (float) drawable.getIntrinsicWidth(), (float) drawable.getIntrinsicHeight());
        matrix.mapRect(this.f29134w);
        return this.f29134w;
    }

    /* renamed from: a */
    private void m20521a(Drawable drawable) {
        if (drawable != null) {
            float a = (float) m20516a(this.f29128q);
            float b = (float) m20523b(this.f29128q);
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            this.f29131t.reset();
            float f = (float) intrinsicWidth;
            float f2 = a / f;
            float f3 = (float) intrinsicHeight;
            float f4 = b / f3;
            if (this.f29119L == ImageView.ScaleType.CENTER) {
                this.f29131t.postTranslate((a - f) / 2.0f, (b - f3) / 2.0f);
            } else if (this.f29119L == ImageView.ScaleType.CENTER_CROP) {
                float max = Math.max(f2, f4);
                this.f29131t.postScale(max, max);
                this.f29131t.postTranslate((a - (f * max)) / 2.0f, (b - (f3 * max)) / 2.0f);
            } else if (this.f29119L == ImageView.ScaleType.CENTER_INSIDE) {
                float min = Math.min(1.0f, Math.min(f2, f4));
                this.f29131t.postScale(min, min);
                this.f29131t.postTranslate((a - (f * min)) / 2.0f, (b - (f3 * min)) / 2.0f);
            } else {
                RectF rectF = new RectF(0.0f, 0.0f, f, f3);
                RectF rectF2 = new RectF(0.0f, 0.0f, a, b);
                if (((int) this.f29117J) % 180 != 0) {
                    rectF = new RectF(0.0f, 0.0f, f3, f);
                }
                int i = C102594.$SwitchMap$android$widget$ImageView$ScaleType[this.f29119L.ordinal()];
                if (i == 1) {
                    this.f29131t.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
                } else if (i == 2) {
                    this.f29131t.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
                } else if (i == 3) {
                    this.f29131t.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.END);
                } else if (i == 4) {
                    this.f29131t.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
                }
            }
            m20529d();
        }
    }

    /* renamed from: com.didi.nova.assembly.components.bigimage.photoview.PhotoViewAttacher$4 */
    static /* synthetic */ class C102594 {
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
            throw new UnsupportedOperationException("Method not decompiled: com.didi.nova.assembly.components.bigimage.photoview.PhotoViewAttacher.C102594.<clinit>():void");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x007f  */
    /* renamed from: f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m20533f() {
        /*
            r11 = this;
            android.graphics.Matrix r0 = r11.m20527c()
            android.graphics.RectF r0 = r11.m20525b((android.graphics.Matrix) r0)
            r1 = 0
            if (r0 != 0) goto L_0x000c
            return r1
        L_0x000c:
            float r2 = r0.height()
            float r3 = r0.width()
            android.widget.ImageView r4 = r11.f29128q
            int r4 = r11.m20523b((android.widget.ImageView) r4)
            float r4 = (float) r4
            r5 = 1073741824(0x40000000, float:2.0)
            r6 = 3
            r7 = 2
            r8 = 0
            int r9 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r9 > 0) goto L_0x003f
            int[] r9 = com.didi.nova.assembly.components.bigimage.photoview.PhotoViewAttacher.C102594.$SwitchMap$android$widget$ImageView$ScaleType
            android.widget.ImageView$ScaleType r10 = r11.f29119L
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
            android.widget.ImageView r2 = r11.f29128q
            int r2 = r11.m20516a((android.widget.ImageView) r2)
            float r2 = (float) r2
            r9 = 1
            int r10 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r10 > 0) goto L_0x007f
            int[] r1 = com.didi.nova.assembly.components.bigimage.photoview.PhotoViewAttacher.C102594.$SwitchMap$android$widget$ImageView$ScaleType
            android.widget.ImageView$ScaleType r8 = r11.f29119L
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
            r11.f29116I = r7
            goto L_0x009b
        L_0x007f:
            float r3 = r0.left
            int r3 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r3 <= 0) goto L_0x008b
            r11.f29116I = r1
            float r0 = r0.left
            float r8 = -r0
            goto L_0x009b
        L_0x008b:
            float r1 = r0.right
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 >= 0) goto L_0x0098
            float r0 = r0.right
            float r8 = r2 - r0
            r11.f29116I = r9
            goto L_0x009b
        L_0x0098:
            r0 = -1
            r11.f29116I = r0
        L_0x009b:
            android.graphics.Matrix r0 = r11.f29133v
            r0.postTranslate(r8, r4)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.nova.assembly.components.bigimage.photoview.PhotoViewAttacher.m20533f():boolean");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public int m20516a(ImageView imageView) {
        return (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public int m20523b(ImageView imageView) {
        return (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
    }

    /* renamed from: g */
    private void m20535g() {
        FlingRunnable flingRunnable = this.f29115H;
        if (flingRunnable != null) {
            flingRunnable.cancelFling();
            this.f29115H = null;
        }
    }

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
            PhotoViewAttacher.this.f29120M.onScale((f + ((this.mZoomEnd - f) * interpolate)) / PhotoViewAttacher.this.getScale(), this.mFocalX, this.mFocalY);
            if (interpolate < 1.0f) {
                C10260a.m20551a(PhotoViewAttacher.this.f29128q, this);
            }
        }

        private float interpolate() {
            return PhotoViewAttacher.this.f29121j.getInterpolation(Math.min(1.0f, (((float) (System.currentTimeMillis() - this.mStartTime)) * 1.0f) / ((float) PhotoViewAttacher.this.f29122k)));
        }
    }

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
                PhotoViewAttacher.this.f29133v.postTranslate((float) (this.mCurrentX - currX), (float) (this.mCurrentY - currY));
                PhotoViewAttacher.this.m20532e();
                this.mCurrentX = currX;
                this.mCurrentY = currY;
                C10260a.m20551a(PhotoViewAttacher.this.f29128q, this);
            }
        }
    }
}
