package com.didi.global.globaluikit.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Scroller;
import com.taxis99.R;
import java.text.Format;
import java.util.List;

public class LEGOWheelPicker<T> extends View {

    /* renamed from: A */
    private int f22387A;

    /* renamed from: B */
    private Rect f22388B;

    /* renamed from: C */
    private Rect f22389C;

    /* renamed from: D */
    private int f22390D;

    /* renamed from: E */
    private int f22391E;

    /* renamed from: F */
    private int f22392F;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public Scroller f22393G;

    /* renamed from: H */
    private int f22394H;

    /* renamed from: I */
    private boolean f22395I;

    /* renamed from: J */
    private VelocityTracker f22396J;

    /* renamed from: K */
    private int f22397K;
    /* access modifiers changed from: private */

    /* renamed from: L */
    public int f22398L;

    /* renamed from: M */
    private int f22399M;

    /* renamed from: N */
    private boolean f22400N;

    /* renamed from: O */
    private int f22401O;

    /* renamed from: P */
    private int f22402P;

    /* renamed from: Q */
    private int f22403Q;

    /* renamed from: R */
    private int f22404R;

    /* renamed from: S */
    private boolean f22405S;

    /* renamed from: T */
    private LEGOLinearGradient f22406T;
    /* access modifiers changed from: private */

    /* renamed from: U */
    public Handler f22407U;
    /* access modifiers changed from: private */

    /* renamed from: V */
    public OnWheelChangeListener<T> f22408V;

    /* renamed from: W */
    private Runnable f22409W;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public List<T> f22410a;

    /* renamed from: b */
    private Format f22411b;

    /* renamed from: c */
    private int f22412c;

    /* renamed from: d */
    private int f22413d;

    /* renamed from: e */
    private Paint f22414e;

    /* renamed from: f */
    private boolean f22415f;

    /* renamed from: g */
    private int f22416g;

    /* renamed from: h */
    private int f22417h;

    /* renamed from: i */
    private Paint f22418i;

    /* renamed from: j */
    private String f22419j;

    /* renamed from: k */
    private int f22420k;

    /* renamed from: l */
    private int f22421l;

    /* renamed from: m */
    private Paint f22422m;

    /* renamed from: n */
    private Paint f22423n;

    /* renamed from: o */
    private int f22424o;

    /* renamed from: p */
    private int f22425p;

    /* renamed from: q */
    private String f22426q;

    /* renamed from: r */
    private int f22427r;

    /* renamed from: s */
    private int f22428s;

    /* renamed from: t */
    private int f22429t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public int f22430u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public int f22431v;

    /* renamed from: w */
    private boolean f22432w;

    /* renamed from: x */
    private boolean f22433x;

    /* renamed from: y */
    private int f22434y;

    /* renamed from: z */
    private boolean f22435z;

    public interface OnWheelChangeListener<T> {
        void onWheelSelected(T t, int i);
    }

    public LEGOWheelPicker(Context context) {
        this(context, (AttributeSet) null);
    }

    public LEGOWheelPicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LEGOWheelPicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f22400N = true;
        this.f22403Q = 50;
        this.f22404R = 12000;
        this.f22407U = new Handler();
        this.f22409W = new Runnable() {
            public void run() {
                int b;
                if (LEGOWheelPicker.this.f22393G.computeScrollOffset()) {
                    LEGOWheelPicker lEGOWheelPicker = LEGOWheelPicker.this;
                    int unused = lEGOWheelPicker.f22398L = lEGOWheelPicker.f22393G.getCurrY();
                    LEGOWheelPicker.this.postInvalidate();
                    LEGOWheelPicker.this.f22407U.postDelayed(this, 16);
                }
                if ((LEGOWheelPicker.this.f22393G.isFinished() || (LEGOWheelPicker.this.f22393G.getFinalY() == LEGOWheelPicker.this.f22393G.getCurrY() && LEGOWheelPicker.this.f22393G.getFinalX() == LEGOWheelPicker.this.f22393G.getCurrX())) && LEGOWheelPicker.this.f22430u != 0 && LEGOWheelPicker.this.f22431v != (b = LEGOWheelPicker.this.m16132a((-LEGOWheelPicker.this.f22398L) / LEGOWheelPicker.this.f22430u))) {
                    int unused2 = LEGOWheelPicker.this.f22431v = b;
                    if (LEGOWheelPicker.this.f22408V != null) {
                        LEGOWheelPicker.this.f22408V.onWheelSelected(LEGOWheelPicker.this.f22410a.get(b), b);
                    }
                }
            }
        };
        m16137a(context, attributeSet);
        m16136a();
        this.f22406T = new LEGOLinearGradient(this.f22412c, this.f22416g);
        this.f22388B = new Rect();
        this.f22389C = new Rect();
        this.f22393G = new Scroller(context);
        this.f22394H = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    /* renamed from: a */
    private void m16137a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            this.f22413d = getResources().getDimensionPixelSize(R.dimen.lego_date_picker_text_size);
            this.f22412c = -16777216;
            this.f22415f = true;
            this.f22400N = false;
            this.f22427r = 2;
            this.f22416g = -16777216;
            this.f22417h = getResources().getDimensionPixelSize(R.dimen.lego_date_picker_selected_text_size);
            this.f22431v = 0;
            this.f22429t = getResources().getDimensionPixelOffset(R.dimen.lego_date_picker_item_width_space);
            this.f22428s = getResources().getDimensionPixelOffset(R.dimen.lego_date_picker_item_height_space);
            this.f22432w = true;
            this.f22433x = true;
            this.f22434y = 0;
            this.f22435z = false;
            this.f22387A = -16777216;
            this.f22420k = -16777216;
            this.f22421l = getResources().getDimensionPixelSize(R.dimen.lego_date_picker_text_size);
        }
    }

    public void computeTextSize() {
        this.f22425p = 0;
        this.f22424o = 0;
        if (this.f22410a.size() != 0) {
            this.f22423n.setTextSize((float) Math.max(this.f22417h, this.f22413d));
            if (!TextUtils.isEmpty(this.f22426q)) {
                this.f22424o = (int) this.f22423n.measureText(this.f22426q);
            } else {
                this.f22424o = (int) this.f22423n.measureText(this.f22410a.get(0).toString());
            }
            Paint.FontMetrics fontMetrics = this.f22423n.getFontMetrics();
            this.f22425p = (int) (fontMetrics.bottom - fontMetrics.top);
        }
    }

    /* renamed from: a */
    private void m16136a() {
        Paint paint = new Paint(69);
        this.f22423n = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f22423n.setTextAlign(Paint.Align.CENTER);
        Paint paint2 = new Paint(69);
        this.f22414e = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.f22414e.setTextAlign(Paint.Align.CENTER);
        this.f22414e.setColor(this.f22412c);
        this.f22414e.setTextSize((float) this.f22413d);
        Paint paint3 = new Paint(69);
        this.f22418i = paint3;
        paint3.setStyle(Paint.Style.FILL);
        this.f22418i.setTextAlign(Paint.Align.CENTER);
        this.f22418i.setColor(this.f22416g);
        this.f22418i.setTextSize((float) this.f22417h);
        Paint paint4 = new Paint(69);
        this.f22422m = paint4;
        paint4.setStyle(Paint.Style.FILL);
        this.f22422m.setTextAlign(Paint.Align.LEFT);
        this.f22422m.setColor(this.f22420k);
        this.f22422m.setTextSize((float) this.f22421l);
    }

    /* renamed from: a */
    private int m16133a(int i, int i2, int i3) {
        return i == 1073741824 ? i2 : Math.min(i2, i3);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        int i3 = this.f22424o + this.f22429t;
        int visibleItemCount = (this.f22425p + this.f22428s) * getVisibleItemCount();
        setMeasuredDimension(m16133a(mode, size, i3 + getPaddingLeft() + getPaddingRight()), m16133a(mode2, size2, visibleItemCount + getPaddingTop() + getPaddingBottom()));
    }

    /* renamed from: b */
    private void m16141b() {
        int i;
        if (this.f22400N) {
            i = Integer.MIN_VALUE;
        } else {
            i = (-this.f22430u) * (this.f22410a.size() - 1);
        }
        this.f22402P = i;
        this.f22401O = this.f22400N ? Integer.MAX_VALUE : 0;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f22388B.set(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
        this.f22430u = this.f22388B.height() / getVisibleItemCount();
        this.f22390D = this.f22388B.centerX();
        this.f22391E = (int) ((((float) this.f22430u) - (this.f22418i.ascent() + this.f22418i.descent())) / 2.0f);
        Rect rect = this.f22389C;
        int paddingLeft = getPaddingLeft();
        int i5 = this.f22430u * this.f22427r;
        int width = getWidth() - getPaddingRight();
        int i6 = this.f22430u;
        rect.set(paddingLeft, i5, width, i6 + (this.f22427r * i6));
        m16141b();
        int i7 = this.f22391E;
        int i8 = this.f22430u;
        this.f22392F = i7 + (this.f22427r * i8);
        this.f22398L = (-i8) * this.f22431v;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public int m16132a(int i) {
        if (i < 0) {
            i = (i % this.f22410a.size()) + this.f22410a.size();
        }
        return i >= this.f22410a.size() ? i % this.f22410a.size() : i;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int i;
        String str;
        super.onDraw(canvas);
        this.f22423n.setTextAlign(Paint.Align.CENTER);
        if (this.f22433x) {
            this.f22423n.setStyle(Paint.Style.FILL);
            this.f22423n.setColor(this.f22434y);
            canvas.drawRect(this.f22389C, this.f22423n);
        }
        if (this.f22435z) {
            this.f22423n.setStyle(Paint.Style.STROKE);
            this.f22423n.setColor(this.f22387A);
            canvas.drawLines(new float[]{(float) this.f22389C.left, (float) this.f22389C.top, (float) this.f22389C.left, (float) this.f22389C.bottom, (float) this.f22389C.right, (float) this.f22389C.top, (float) this.f22389C.right, (float) this.f22389C.bottom}, 0, 8, this.f22423n);
        }
        int i2 = (-this.f22398L) / this.f22430u;
        this.f22423n.setStyle(Paint.Style.FILL);
        for (int i3 = (i2 - this.f22427r) - 1; i3 <= this.f22427r + i2 + 1; i3++) {
            if (this.f22400N) {
                i = m16132a(i3);
            } else {
                if (i3 >= 0 && i3 <= this.f22410a.size() - 1) {
                    i = i3;
                }
            }
            T t = this.f22410a.get(i);
            int i4 = this.f22391E + ((this.f22427r + i3) * this.f22430u) + this.f22398L;
            int abs = Math.abs(this.f22392F - i4);
            if (this.f22415f) {
                int i5 = this.f22430u;
                if (abs < i5) {
                    float f = 1.0f - (((float) abs) / ((float) i5));
                    this.f22418i.setColor(this.f22406T.getColor(f));
                    this.f22414e.setColor(this.f22406T.getColor(f));
                } else {
                    this.f22418i.setColor(this.f22416g);
                    this.f22414e.setColor(this.f22412c);
                }
                int i6 = this.f22392F;
                float height = i4 > i6 ? ((float) (this.f22388B.height() - i4)) / ((float) (this.f22388B.height() - this.f22392F)) : ((float) i4) / ((float) i6);
                if (height < 0.0f) {
                    height = 0.0f;
                }
                int i7 = (int) (height * 255.0f);
                this.f22418i.setAlpha(i7);
                this.f22414e.setAlpha(i7);
            }
            if (this.f22432w) {
                int i8 = this.f22430u;
                if (abs < i8) {
                    float f2 = ((float) (i8 - abs)) / ((float) i8);
                    int i9 = this.f22417h;
                    int i10 = this.f22413d;
                    float f3 = f2 * ((float) (i9 - i10));
                    this.f22418i.setTextSize(((float) i10) + f3);
                    this.f22414e.setTextSize(((float) this.f22413d) + f3);
                } else {
                    this.f22418i.setTextSize((float) this.f22413d);
                    this.f22414e.setTextSize((float) this.f22413d);
                }
            } else {
                this.f22418i.setTextSize((float) this.f22413d);
                this.f22414e.setTextSize((float) this.f22413d);
            }
            try {
                str = this.f22411b == null ? t.toString() : this.f22411b.format(t);
            } catch (IllegalArgumentException unused) {
                str = t.toString();
            }
            if (abs < this.f22430u / 2) {
                canvas.drawText(str, (float) this.f22390D, (float) i4, this.f22418i);
            } else {
                canvas.drawText(str, (float) this.f22390D, (float) i4, this.f22414e);
            }
        }
        if (!TextUtils.isEmpty(this.f22419j)) {
            canvas.drawText(this.f22419j, (float) (this.f22390D + (this.f22424o / 2)), (float) this.f22392F, this.f22422m);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f22396J == null) {
            this.f22396J = VelocityTracker.obtain();
        }
        this.f22396J.addMovement(motionEvent);
        int action = motionEvent.getAction();
        if (action == 0) {
            if (!this.f22393G.isFinished()) {
                this.f22393G.abortAnimation();
                this.f22405S = true;
            } else {
                this.f22405S = false;
            }
            this.f22396J.clear();
            int y = (int) motionEvent.getY();
            this.f22399M = y;
            this.f22397K = y;
            this.f22395I = true;
        } else if (action == 1) {
            if (this.f22405S || this.f22397K != this.f22399M) {
                this.f22396J.computeCurrentVelocity(1000, (float) this.f22404R);
                int yVelocity = (int) this.f22396J.getYVelocity();
                if (Math.abs(yVelocity) > this.f22403Q) {
                    this.f22393G.fling(0, this.f22398L, 0, yVelocity, 0, 0, this.f22402P, this.f22401O);
                    Scroller scroller = this.f22393G;
                    scroller.setFinalY(scroller.getFinalY() + m16138b(this.f22393G.getFinalY() % this.f22430u));
                } else {
                    Scroller scroller2 = this.f22393G;
                    int i = this.f22398L;
                    scroller2.startScroll(0, i, 0, m16138b(i % this.f22430u));
                }
            } else {
                performClick();
                if (motionEvent.getY() > ((float) this.f22389C.bottom)) {
                    int i2 = this.f22430u;
                    this.f22393G.startScroll(0, this.f22398L, 0, (-((((int) (motionEvent.getY() - ((float) this.f22389C.bottom))) / i2) + 1)) * i2);
                } else if (motionEvent.getY() < ((float) this.f22389C.top)) {
                    int y2 = (int) (((float) this.f22389C.top) - motionEvent.getY());
                    int i3 = this.f22430u;
                    this.f22393G.startScroll(0, this.f22398L, 0, ((y2 / i3) + 1) * i3);
                }
            }
            if (!this.f22400N) {
                int finalY = this.f22393G.getFinalY();
                int i4 = this.f22401O;
                if (finalY > i4) {
                    this.f22393G.setFinalY(i4);
                } else {
                    int finalY2 = this.f22393G.getFinalY();
                    int i5 = this.f22402P;
                    if (finalY2 < i5) {
                        this.f22393G.setFinalY(i5);
                    }
                }
            }
            this.f22407U.post(this.f22409W);
            this.f22396J.recycle();
            this.f22396J = null;
        } else if (action == 2 && (!this.f22395I || Math.abs(((float) this.f22397K) - motionEvent.getY()) >= ((float) this.f22394H))) {
            this.f22395I = false;
            this.f22398L = (int) (((float) this.f22398L) + (motionEvent.getY() - ((float) this.f22399M)));
            this.f22399M = (int) motionEvent.getY();
            invalidate();
        }
        return true;
    }

    public boolean performClick() {
        return super.performClick();
    }

    /* renamed from: b */
    private int m16138b(int i) {
        int abs = Math.abs(i);
        int i2 = this.f22430u;
        if (abs > i2 / 2) {
            return this.f22398L < 0 ? (-i2) - i : i2 - i;
        }
        return -i;
    }

    public void setOnWheelChangeListener(OnWheelChangeListener<T> onWheelChangeListener) {
        this.f22408V = onWheelChangeListener;
    }

    public Paint getTextPaint() {
        return this.f22414e;
    }

    public Paint getSelectedItemPaint() {
        return this.f22418i;
    }

    public Paint getPaint() {
        return this.f22423n;
    }

    public Paint getIndicatorPaint() {
        return this.f22422m;
    }

    public List<T> getDataList() {
        return this.f22410a;
    }

    public void setDataList(List<T> list) {
        if (list.size() != 0) {
            this.f22410a = list;
            computeTextSize();
            m16141b();
            requestLayout();
            postInvalidate();
        }
    }

    public int getTextColor() {
        return this.f22412c;
    }

    public void setTextColor(int i) {
        if (this.f22412c != i) {
            this.f22414e.setColor(i);
            this.f22412c = i;
            this.f22406T.setStartColor(i);
            postInvalidate();
        }
    }

    public int getTextSize() {
        return this.f22413d;
    }

    public void setTextSize(int i) {
        if (this.f22413d != i) {
            this.f22413d = i;
            this.f22414e.setTextSize((float) i);
            computeTextSize();
            postInvalidate();
        }
    }

    public int getSelectedItemTextColor() {
        return this.f22416g;
    }

    public void setSelectedItemTextColor(int i) {
        if (this.f22416g != i) {
            this.f22418i.setColor(i);
            this.f22416g = i;
            this.f22406T.setEndColor(i);
            postInvalidate();
        }
    }

    public int getSelectedItemTextSize() {
        return this.f22417h;
    }

    public void setSelectedItemTextSize(int i) {
        if (this.f22417h != i) {
            this.f22418i.setTextSize((float) i);
            this.f22417h = i;
            computeTextSize();
            postInvalidate();
        }
    }

    public String getItemMaximumWidthText() {
        return this.f22426q;
    }

    public void setItemMaximumWidthText(String str) {
        this.f22426q = str;
        requestLayout();
        postInvalidate();
    }

    public int getHalfVisibleItemCount() {
        return this.f22427r;
    }

    public int getVisibleItemCount() {
        return (this.f22427r * 2) + 1;
    }

    public void setHalfVisibleItemCount(int i) {
        if (this.f22427r != i) {
            this.f22427r = i;
            requestLayout();
        }
    }

    public int getItemWidthSpace() {
        return this.f22429t;
    }

    public void setItemWidthSpace(int i) {
        if (this.f22429t != i) {
            this.f22429t = i;
            requestLayout();
        }
    }

    public int getItemHeightSpace() {
        return this.f22428s;
    }

    public void setItemHeightSpace(int i) {
        if (this.f22428s != i) {
            this.f22428s = i;
            requestLayout();
        }
    }

    public int getCurrentPosition() {
        return this.f22431v;
    }

    public void setCurrentItem(T t) {
        setCurrentItem(t);
    }

    public void setCurrentItem(T t, boolean z) {
        int i = -1;
        for (T next : this.f22410a) {
            if (t.toString().equals(next.toString())) {
                i = this.f22410a.indexOf(next);
            }
        }
        setCurrentPosition(i, z);
    }

    public void setCurrentPosition(int i) {
        setCurrentPosition(i, true);
    }

    public synchronized void setCurrentPosition(int i, boolean z) {
        if (i > this.f22410a.size() - 1) {
            i = this.f22410a.size() - 1;
        }
        if (i < 0) {
            i = 0;
        }
        if (!this.f22393G.isFinished()) {
            this.f22393G.abortAnimation();
        }
        if (!z || this.f22430u <= 0) {
            this.f22431v = i;
            this.f22398L = (-this.f22430u) * i;
            postInvalidate();
        } else {
            this.f22393G.startScroll(0, this.f22398L, 0, (this.f22431v - i) * this.f22430u);
            this.f22393G.setFinalY((-i) * this.f22430u);
            this.f22407U.post(this.f22409W);
        }
    }

    public boolean isZoomInSelectedItem() {
        return this.f22432w;
    }

    public void setZoomInSelectedItem(boolean z) {
        if (this.f22432w != z) {
            this.f22432w = z;
            postInvalidate();
        }
    }

    public boolean isCyclic() {
        return this.f22400N;
    }

    public void setCyclic(boolean z) {
        if (this.f22400N != z) {
            this.f22400N = z;
            m16141b();
            requestLayout();
        }
    }

    public int getMinimumVelocity() {
        return this.f22403Q;
    }

    public void setMinimumVelocity(int i) {
        this.f22403Q = i;
    }

    public int getMaximumVelocity() {
        return this.f22404R;
    }

    public void setMaximumVelocity(int i) {
        this.f22404R = i;
    }

    public boolean isTextGradual() {
        return this.f22415f;
    }

    public void setTextGradual(boolean z) {
        if (this.f22415f != z) {
            this.f22415f = z;
            postInvalidate();
        }
    }

    public boolean isShowCurtain() {
        return this.f22433x;
    }

    public void setShowCurtain(boolean z) {
        if (this.f22433x != z) {
            this.f22433x = z;
            postInvalidate();
        }
    }

    public int getCurtainColor() {
        return this.f22434y;
    }

    public void setCurtainColor(int i) {
        if (this.f22434y != i) {
            this.f22434y = i;
            postInvalidate();
        }
    }

    public boolean isShowCurtainBorder() {
        return this.f22435z;
    }

    public void setShowCurtainBorder(boolean z) {
        if (this.f22435z != z) {
            this.f22435z = z;
            postInvalidate();
        }
    }

    public int getCurtainBorderColor() {
        return this.f22387A;
    }

    public void setCurtainBorderColor(int i) {
        if (this.f22387A != i) {
            this.f22387A = i;
            postInvalidate();
        }
    }

    public void setIndicatorText(String str) {
        this.f22419j = str;
        postInvalidate();
    }

    public void setIndicatorTextColor(int i) {
        this.f22420k = i;
        this.f22422m.setColor(i);
        postInvalidate();
    }

    public void setIndicatorTextSize(int i) {
        this.f22421l = i;
        this.f22422m.setTextSize((float) i);
        postInvalidate();
    }

    public void setDataFormat(Format format) {
        this.f22411b = format;
        postInvalidate();
    }

    public Format getDataFormat() {
        return this.f22411b;
    }
}
