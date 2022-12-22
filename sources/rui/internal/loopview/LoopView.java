package rui.internal.loopview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.didi.passenger.C10448R;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import rui.debug.RUIDebugControl;

public class LoopView extends View {

    /* renamed from: q */
    private static final float f6767q = 1.25f;

    /* renamed from: r */
    private static final int f6768r = 9;

    /* renamed from: A */
    private int[] f6769A;

    /* renamed from: B */
    private float f6770B;

    /* renamed from: C */
    private float f6771C;

    /* renamed from: D */
    private float f6772D;

    /* renamed from: E */
    private long f6773E;

    /* renamed from: F */
    private Rect f6774F;

    /* renamed from: G */
    private GestureDetector f6775G;

    /* renamed from: H */
    private ScheduledExecutorService f6776H;

    /* renamed from: I */
    private ScheduledFuture<?> f6777I;

    /* renamed from: J */
    private Paint f6778J;

    /* renamed from: K */
    private Paint f6779K;

    /* renamed from: L */
    private Paint f6780L;

    /* renamed from: M */
    private DecoratorLineLocationListener f6781M;

    /* renamed from: a */
    boolean f6782a;

    /* renamed from: b */
    int f6783b;

    /* renamed from: c */
    int f6784c;

    /* renamed from: d */
    int f6785d;

    /* renamed from: e */
    int f6786e;

    /* renamed from: f */
    int f6787f;

    /* renamed from: g */
    int f6788g;

    /* renamed from: h */
    int f6789h;

    /* renamed from: i */
    int f6790i;

    /* renamed from: j */
    int f6791j;

    /* renamed from: k */
    int f6792k;

    /* renamed from: l */
    float f6793l;

    /* renamed from: m */
    SparseArray<IndexString> f6794m;

    /* renamed from: n */
    Handler f6795n;

    /* renamed from: o */
    OnItemSelectedListener f6796o;

    /* renamed from: p */
    List<IndexString> f6797p;

    /* renamed from: s */
    private int f6798s;

    /* renamed from: t */
    private int f6799t;

    /* renamed from: u */
    private int f6800u;

    /* renamed from: v */
    private int f6801v;

    /* renamed from: w */
    private int f6802w;

    /* renamed from: x */
    private int f6803x;

    /* renamed from: y */
    private int f6804y;

    /* renamed from: z */
    private int f6805z;

    public enum ACTION {
        CLICK,
        FLING,
        DAGGLE
    }

    public interface DecoratorLineLocationListener {
        void onLineLocationChange(int i, int i2);
    }

    public LoopView(Context context) {
        this(context, (AttributeSet) null);
    }

    public LoopView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6782a = true;
        this.f6789h = 0;
        this.f6790i = 0;
        this.f6799t = 9;
        this.f6800u = 0;
        this.f6804y = 0;
        this.f6793l = 0.0f;
        this.f6770B = 1.05f;
        this.f6772D = f6767q;
        this.f6773E = 0;
        this.f6774F = new Rect();
        this.f6776H = Executors.newSingleThreadScheduledExecutor();
        m3852a(context, attributeSet);
    }

    public LoopView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6782a = true;
        this.f6789h = 0;
        this.f6790i = 0;
        this.f6799t = 9;
        this.f6800u = 0;
        this.f6804y = 0;
        this.f6793l = 0.0f;
        this.f6770B = 1.05f;
        this.f6772D = f6767q;
        this.f6773E = 0;
        this.f6774F = new Rect();
        this.f6776H = Executors.newSingleThreadScheduledExecutor();
        m3852a(context, attributeSet);
    }

    /* renamed from: a */
    private void m3852a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            m3854b(context, attributeSet);
        }
        this.f6795n = new C3019c(this);
        GestureDetector gestureDetector = new GestureDetector(context, new C3018b(this));
        this.f6775G = gestureDetector;
        gestureDetector.setIsLongpressEnabled(false);
        int i = this.f6799t;
        if (i % 2 == 0) {
            this.f6799t = 9;
        } else {
            this.f6800u = i / 2;
        }
        this.f6794m = new SparseArray<>();
        m3851a();
    }

    /* renamed from: b */
    private void m3854b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.RUILoopView);
        this.f6793l = obtainStyledAttributes.getDimension(8, this.f6793l);
        this.f6772D = obtainStyledAttributes.getFloat(5, this.f6772D);
        this.f6785d = obtainStyledAttributes.getInteger(0, this.f6785d);
        this.f6784c = obtainStyledAttributes.getInteger(6, this.f6784c);
        this.f6786e = obtainStyledAttributes.getInteger(1, this.f6786e);
        this.f6799t = obtainStyledAttributes.getInteger(4, this.f6799t);
        this.f6782a = obtainStyledAttributes.getBoolean(3, this.f6782a);
        obtainStyledAttributes.recycle();
    }

    /* renamed from: a */
    private void m3851a() {
        Paint paint = new Paint();
        this.f6779K = paint;
        paint.setColor(this.f6784c);
        this.f6779K.setAntiAlias(true);
        this.f6779K.setTextSize(this.f6793l);
        Paint paint2 = new Paint();
        this.f6778J = paint2;
        paint2.setColor(this.f6785d);
        this.f6778J.setAntiAlias(true);
        this.f6778J.setTextScaleX(this.f6770B);
        this.f6778J.setTextSize(this.f6793l);
        Paint paint3 = new Paint();
        this.f6780L = paint3;
        paint3.setColor(this.f6786e);
        this.f6780L.setAntiAlias(true);
    }

    public void setCenterTextColor(int i) {
        this.f6778J.setColor(i);
    }

    public void setOuterTextColor(int[] iArr) {
        if (iArr.length != 0) {
            if (iArr.length == 1) {
                this.f6779K.setColor(iArr[0]);
            } else {
                this.f6769A = iArr;
            }
        }
    }

    public void setDividerColor(int i) {
        this.f6780L.setColor(i);
    }

    public void setItemsVisibleCount(int i) {
        if (i % 2 != 0 && i != this.f6799t) {
            this.f6799t = i;
            this.f6800u = i / 2;
            this.f6794m.clear();
        }
    }

    /* renamed from: b */
    private int m3853b() {
        Paint.FontMetrics fontMetrics = this.f6778J.getFontMetrics();
        return (int) Math.abs(fontMetrics.bottom - fontMetrics.top);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        this.f6805z = getPaddingLeft();
        int b = m3853b();
        this.f6783b = b;
        int i3 = (int) (((double) (((float) b) * this.f6772D)) + 0.5d);
        this.f6792k = i3;
        int i4 = this.f6799t * i3;
        setMeasuredDimension(getDefaultSize(getSuggestedMinimumWidth(), i), i4);
        int measuredWidth = getMeasuredWidth();
        this.f6801v = measuredWidth;
        this.f6801v = measuredWidth - getPaddingRight();
        this.f6802w = i4;
        this.f6803x = i4 / 2;
        List<IndexString> list = this.f6797p;
        if (list != null) {
            int i5 = this.f6792k;
            this.f6787f = ((i4 - i5) / 2) - 1;
            this.f6788g = ((i4 + i5) / 2) + 1;
            if (this.f6790i == -1) {
                if (this.f6782a) {
                    this.f6790i = (list.size() + 1) / 2;
                } else {
                    this.f6790i = 0;
                }
            }
            this.f6791j = this.f6790i;
            DecoratorLineLocationListener decoratorLineLocationListener = this.f6781M;
            if (decoratorLineLocationListener != null) {
                decoratorLineLocationListener.onLineLocationChange(this.f6787f, this.f6788g);
            }
        }
    }

    public void setDecoratorLineLocationListener(DecoratorLineLocationListener decoratorLineLocationListener) {
        this.f6781M = decoratorLineLocationListener;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.f6775G.onTouchEvent(motionEvent);
        float f = this.f6772D * ((float) this.f6783b);
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f6773E = System.currentTimeMillis();
            cancelFuture();
            this.f6771C = motionEvent.getRawY();
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
        } else if (action != 2) {
            if (!onTouchEvent) {
                float y = motionEvent.getY();
                int i = this.f6803x;
                this.f6804y = (int) ((((float) (((int) (((Math.acos((double) ((((float) i) - y) / ((float) i))) * ((double) this.f6803x)) + ((double) (f / 2.0f))) / ((double) f))) - this.f6800u)) * f) - (((((float) this.f6789h) % f) + f) % f));
                if (System.currentTimeMillis() - this.f6773E > 120) {
                    mo38468a(ACTION.DAGGLE);
                }
            }
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
        } else {
            this.f6771C = motionEvent.getRawY();
            this.f6789h = (int) (((float) this.f6789h) + (this.f6771C - motionEvent.getRawY()));
            if (!this.f6782a) {
                float f2 = ((float) (-this.f6790i)) * f;
                float size = ((float) ((this.f6797p.size() - 1) - this.f6790i)) * f;
                int i2 = this.f6789h;
                if (((float) i2) < f2) {
                    this.f6789h = (int) f2;
                } else if (((float) i2) > size) {
                    this.f6789h = (int) size;
                }
            }
        }
        invalidate();
        return true;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        List<IndexString> list = this.f6797p;
        if (list != null) {
            int i = this.f6789h;
            int i2 = this.f6792k;
            int i3 = i / i2;
            int i4 = i % i2;
            int size = this.f6790i + (i3 % list.size());
            this.f6791j = size;
            if (!this.f6782a) {
                if (size < 0) {
                    this.f6791j = 0;
                }
                if (this.f6791j > this.f6797p.size() - 1) {
                    this.f6791j = this.f6797p.size() - 1;
                }
            } else {
                if (size < 0) {
                    this.f6791j = this.f6797p.size() + this.f6791j;
                }
                if (this.f6791j > this.f6797p.size() - 1) {
                    this.f6791j -= this.f6797p.size();
                }
            }
            for (int i5 = 0; i5 < this.f6799t; i5++) {
                int i6 = (this.f6791j + i5) - this.f6800u;
                if (this.f6782a) {
                    while (i6 < 0) {
                        i6 += this.f6797p.size();
                    }
                    while (i6 > this.f6797p.size() - 1) {
                        i6 -= this.f6797p.size();
                    }
                    this.f6794m.put(i5, this.f6797p.get(i6));
                } else if (i6 < 0) {
                    this.f6794m.put(i5, IndexString.EMPTY);
                } else if (i6 > this.f6797p.size() - 1) {
                    this.f6794m.put(i5, IndexString.EMPTY);
                } else {
                    this.f6794m.put(i5, this.f6797p.get(i6));
                }
            }
            float f = (float) this.f6805z;
            int i7 = this.f6787f;
            Canvas canvas2 = canvas;
            canvas2.drawLine(f, (float) i7, (float) this.f6801v, (float) i7, this.f6780L);
            float f2 = (float) this.f6805z;
            int i8 = this.f6788g;
            canvas2.drawLine(f2, (float) i8, (float) this.f6801v, (float) i8, this.f6780L);
            for (int i9 = 0; i9 < this.f6799t; i9++) {
                canvas.save();
                double d = ((((double) ((((float) i9) / ((float) (this.f6799t - 1))) - (((float) i4) / ((float) this.f6802w)))) * 0.55d) + 0.225d) * 3.141592653589793d;
                if (d >= 3.141592653589793d || d <= 0.0d) {
                    canvas.restore();
                } else {
                    int cos = (int) ((((double) this.f6803x) * (1.0d - Math.cos(d))) - ((Math.sin(d) * ((double) this.f6792k)) / 2.0d));
                    canvas.translate(0.0f, (float) cos);
                    canvas.scale(1.0f, (float) Math.sin(d));
                    int i10 = this.f6783b + cos;
                    if (cos < this.f6787f || i10 > this.f6788g) {
                        int i11 = this.f6787f;
                        if (cos > i11 || i10 < i11) {
                            int i12 = this.f6788g;
                            if (cos > i12 || i10 < i12) {
                                if (this.f6769A != null) {
                                    int abs = Math.abs(this.f6800u - i9);
                                    int length = this.f6769A.length;
                                    if (abs > length) {
                                        abs = length;
                                    }
                                    if (abs < 1) {
                                        abs = 1;
                                    }
                                    this.f6779K.setColor(this.f6769A[abs - 1]);
                                }
                                canvas.clipRect(0, 0, this.f6801v, this.f6792k);
                                canvas.drawText(this.f6794m.get(i9).string, (float) m3850a(this.f6794m.get(i9).string, this.f6779K, this.f6774F), (float) this.f6783b, this.f6779K);
                            } else {
                                int[] iArr = this.f6769A;
                                if (iArr != null) {
                                    this.f6779K.setColor(iArr[0]);
                                }
                                canvas.save();
                                canvas.clipRect(0, 0, this.f6801v, this.f6788g - cos);
                                canvas.drawText(this.f6794m.get(i9).string, (float) m3850a(this.f6794m.get(i9).string, this.f6778J, this.f6774F), (float) this.f6783b, this.f6778J);
                                canvas.restore();
                                canvas.save();
                                canvas.clipRect(0, this.f6788g - cos, this.f6801v, this.f6792k);
                                canvas.drawText(this.f6794m.get(i9).string, (float) m3850a(this.f6794m.get(i9).string, this.f6779K, this.f6774F), (float) this.f6783b, this.f6779K);
                                canvas.restore();
                            }
                        } else {
                            int[] iArr2 = this.f6769A;
                            if (iArr2 != null) {
                                this.f6779K.setColor(iArr2[0]);
                            }
                            canvas.save();
                            canvas.clipRect(0, 0, this.f6801v, this.f6787f - cos);
                            canvas.drawText(this.f6794m.get(i9).string, (float) m3850a(this.f6794m.get(i9).string, this.f6779K, this.f6774F), (float) this.f6783b, this.f6779K);
                            canvas.restore();
                            canvas.save();
                            canvas.clipRect(0, this.f6787f - cos, this.f6801v, this.f6792k);
                            canvas.drawText(this.f6794m.get(i9).string, (float) m3850a(this.f6794m.get(i9).string, this.f6778J, this.f6774F), (float) this.f6783b, this.f6778J);
                            canvas.restore();
                        }
                    } else {
                        canvas.clipRect(0, 0, this.f6801v, this.f6792k);
                        canvas.drawText(this.f6794m.get(i9).string, (float) m3850a(this.f6794m.get(i9).string, this.f6778J, this.f6774F), (float) this.f6783b, this.f6778J);
                        this.f6798s = this.f6797p.indexOf(this.f6794m.get(i9));
                    }
                    canvas.restore();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo38468a(ACTION action) {
        cancelFuture();
        if (action == ACTION.FLING || action == ACTION.DAGGLE) {
            float f = (float) this.f6792k;
            int i = (int) (((((float) this.f6789h) % f) + f) % f);
            this.f6804y = i;
            if (((float) i) > f / 2.0f) {
                this.f6804y = (int) (f - ((float) i));
            } else {
                this.f6804y = -i;
            }
        }
        this.f6777I = this.f6776H.scheduleWithFixedDelay(new C3021e(this, this.f6804y), 0, 10, TimeUnit.MILLISECONDS);
    }

    /* access modifiers changed from: protected */
    public final void scrollBy(float f) {
        cancelFuture();
        this.f6777I = this.f6776H.scheduleWithFixedDelay(new C3017a(this, f), 0, (long) 10, TimeUnit.MILLISECONDS);
    }

    public void cancelFuture() {
        ScheduledFuture<?> scheduledFuture = this.f6777I;
        if (scheduledFuture != null && !scheduledFuture.isCancelled()) {
            this.f6777I.cancel(true);
            this.f6777I = null;
        }
    }

    public void setNotLoop() {
        this.f6782a = false;
    }

    public final void setTextSize(float f) {
        if (f > 0.0f) {
            this.f6793l = f;
            this.f6779K.setTextSize(f);
            this.f6778J.setTextSize(this.f6793l);
            requestLayout();
        }
    }

    public final void setListener(OnItemSelectedListener onItemSelectedListener) {
        this.f6796o = onItemSelectedListener;
    }

    public final void setItems(List<String> list) {
        if ((list == null || list.size() == 0) && RUIDebugControl.isDebug()) {
            throw new IllegalStateException("items must have item");
        }
        this.f6797p = convertData(list);
        requestLayout();
    }

    public List<IndexString> convertData(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            arrayList.add(new IndexString(i, list.get(i)));
        }
        return arrayList;
    }

    public final int getSelectedItemPosition() {
        return this.f6798s;
    }

    /* access modifiers changed from: protected */
    public final void onItemSelected() {
        if (this.f6796o != null) {
            postDelayed(new C3020d(this), 200);
        }
    }

    public void setScaleX(float f) {
        this.f6770B = f;
    }

    public void setCurrentPosition(int i) {
        List<IndexString> list = this.f6797p;
        if (list != null && !list.isEmpty()) {
            int size = this.f6797p.size();
            if (i >= 0 && i < size && i != this.f6798s) {
                this.f6790i = i;
                this.f6789h = 0;
                this.f6804y = 0;
                invalidate();
            }
        }
    }

    /* renamed from: a */
    private int m3850a(String str, Paint paint, Rect rect) {
        paint.getTextBounds(str, 0, str.length(), rect);
        int i = this.f6801v;
        int i2 = this.f6805z;
        return (((i - i2) - ((int) (((float) rect.width()) * this.f6770B))) / 2) + i2;
    }

    static class IndexString {
        public static IndexString EMPTY = new IndexString();
        private int index;
        /* access modifiers changed from: private */
        public String string;

        public IndexString() {
            this.string = "";
        }

        public IndexString(int i, String str) {
            this.index = i;
            this.string = str;
        }
    }
}
