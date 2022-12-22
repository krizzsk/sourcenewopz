package com.didi.sdk.view.wheel;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Scroller;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.passenger.C10448R;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class Wheel extends View implements GestureDetector.OnGestureListener {

    /* renamed from: c */
    private static final String f38316c = "WheelTest0001";

    /* renamed from: d */
    private static final int f38317d = 200;

    /* renamed from: A */
    private boolean f38318A;

    /* renamed from: B */
    private boolean f38319B;

    /* renamed from: C */
    private int f38320C;

    /* renamed from: D */
    private boolean f38321D = false;

    /* renamed from: a */
    String f38322a = "";

    /* renamed from: b */
    int f38323b = 1;

    /* renamed from: e */
    private GestureDetector f38324e;

    /* renamed from: f */
    private int f38325f;

    /* renamed from: g */
    private int f38326g;

    /* renamed from: h */
    private List<WheelItem> f38327h;

    /* renamed from: i */
    private int f38328i = 20;

    /* renamed from: j */
    private Paint f38329j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public int f38330k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public float f38331l = 5.5f;

    /* renamed from: m */
    private List<String> f38332m;

    /* renamed from: n */
    private float f38333n;

    /* renamed from: o */
    private float f38334o;

    /* renamed from: p */
    private boolean f38335p = true;

    /* renamed from: q */
    private boolean f38336q = false;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public int f38337r;

    /* renamed from: s */
    private int f38338s;

    /* renamed from: t */
    private String f38339t = "";
    /* access modifiers changed from: private */

    /* renamed from: u */
    public OnItemChangedListener f38340u;

    /* renamed from: v */
    private FlingRunnable f38341v;

    /* renamed from: w */
    private int f38342w;

    /* renamed from: x */
    private int f38343x;

    /* renamed from: y */
    private int f38344y;

    /* renamed from: z */
    private int f38345z;

    public interface OnItemChangedListener {
        void onItemChanged(int i);
    }

    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    public void onLongPress(MotionEvent motionEvent) {
    }

    public void onShowPress(MotionEvent motionEvent) {
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    public Wheel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.wheel);
        this.f38326g = obtainStyledAttributes.getColor(3, -16777216);
        this.f38325f = obtainStyledAttributes.getDimensionPixelOffset(4, 48);
        this.f38330k = obtainStyledAttributes.getDimensionPixelOffset(0, 0);
        this.f38331l = obtainStyledAttributes.getFloat(5, this.f38331l);
        this.f38344y = obtainStyledAttributes.getDimensionPixelOffset(2, getContext().getResources().getDimensionPixelOffset(R.dimen.wheel_margin_top_bottom));
        this.f38345z = obtainStyledAttributes.getDimensionPixelOffset(1, getContext().getResources().getDimensionPixelOffset(R.dimen.wheel_margin_top_bottom));
        obtainStyledAttributes.recycle();
        setBackgroundColor(getResources().getColor(R.color.white));
        this.f38324e = new GestureDetector(getContext(), this);
        Paint paint = new Paint();
        this.f38329j = paint;
        paint.setAntiAlias(true);
        this.f38329j.setTextAlign(Paint.Align.CENTER);
        if (getResources().getDisplayMetrics().widthPixels <= 720 && getResources().getDisplayMetrics().widthPixels > 480) {
            this.f38325f = (int) (getResources().getDisplayMetrics().density * 18.0f);
        } else if (getResources().getDisplayMetrics().widthPixels <= 480) {
            this.f38325f = (int) (getResources().getDisplayMetrics().density * 16.0f);
        }
        this.f38329j.setTextSize((float) this.f38325f);
        this.f38329j.setColor(this.f38326g);
        Paint.FontMetrics fontMetrics = this.f38329j.getFontMetrics();
        int i = this.f38330k;
        if (i == 0) {
            Rect rect = new Rect();
            this.f38329j.getTextBounds("秦", 0, 1, rect);
            int height = rect.height();
            this.f38338s = height;
            this.f38330k = height + (this.f38328i << 1);
            this.f38320C = (int) (((double) getResources().getDisplayMetrics().density) * 8.5d);
        } else {
            this.f38338s = i;
        }
        this.f38334o = (((float) (this.f38330k / 2)) - fontMetrics.descent) + ((fontMetrics.descent - fontMetrics.ascent) / 2.0f);
        this.f38342w = 0;
        this.f38343x = 0;
        setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
            }
        });
        ViewCompat.setAccessibilityDelegate(this, new MyAccessibilityDelegate());
        setFocusable(true);
        if (ViewCompat.getImportantForAccessibility(this) == 0) {
            ViewCompat.setImportantForAccessibility(this, 1);
        }
    }

    public int getTextSize() {
        return this.f38325f;
    }

    public void setTextSize(int i) {
        this.f38325f = i;
    }

    public void setSuffix(String str) {
        this.f38339t = str;
    }

    public int getTextColor() {
        return this.f38326g;
    }

    public void setTextColor(int i) {
        this.f38326g = i;
    }

    public void setOnItemSelectedListener(OnItemChangedListener onItemChangedListener) {
        this.f38340u = onItemChangedListener;
    }

    public float getMaxTextHeight() {
        return (float) this.f38338s;
    }

    public int getSelectedIndex() {
        return this.f38337r;
    }

    public void setSelectedIndex(int i) {
        if (i != this.f38337r) {
            this.f38336q = true;
        }
        this.f38337r = i;
        invalidate();
    }

    public List<String> getData() {
        return this.f38332m;
    }

    public void setData(List<String> list) {
        this.f38335p = true;
        this.f38332m = list;
        this.f38337r = 0;
        FlingRunnable flingRunnable = this.f38341v;
        if (flingRunnable != null) {
            removeCallbacks(flingRunnable);
        }
        invalidate();
    }

    public String getSelectedValue() {
        List<String> list = this.f38332m;
        return (list == null || list.isEmpty() || this.f38337r >= this.f38332m.size()) ? "" : this.f38332m.get(this.f38337r);
    }

    /* renamed from: a */
    private void m27098a() {
        List<String> list = this.f38332m;
        if (list != null && !list.isEmpty() && getMeasuredWidth() != 0 && this.f38337r < this.f38332m.size()) {
            this.f38327h = new ArrayList(this.f38332m.size());
            int measuredWidth = getMeasuredWidth();
            float f = ((float) measuredWidth) / 2.0f;
            int size = this.f38332m.size();
            for (int i = 0; i < size; i++) {
                WheelItem wheelItem = new WheelItem(measuredWidth, this.f38330k, this.f38342w + this.f38343x);
                int i2 = this.f38337r;
                if (i <= i2 - 1) {
                    wheelItem.setTop(this.f38333n - ((float) ((i2 - i) * this.f38330k)));
                } else {
                    wheelItem.setTop(this.f38333n + ((float) ((i - i2) * this.f38330k)));
                }
                if (this.f38332m.get(i).equals(getResources().getString(R.string.now))) {
                    wheelItem.setTitle(this.f38332m.get(i));
                } else {
                    wheelItem.setTitle(this.f38332m.get(i) + this.f38339t);
                }
                wheelItem.setTextCenterX(f);
                wheelItem.setPaint(this.f38329j);
                wheelItem.setTextBaselineY(this.f38334o);
                this.f38327h.add(wheelItem);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f38335p || this.f38336q) {
            this.f38335p = false;
            this.f38336q = false;
            m27098a();
        }
        if (this.f38327h != null) {
            for (int i = 0; i < this.f38327h.size(); i++) {
                WheelItem wheelItem = this.f38327h.get(i);
                this.f38327h.get(i).draw(canvas);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        int measuredHeight = getMeasuredHeight();
        float maxTextHeight = getMaxTextHeight();
        float f = (((float) measuredHeight) - maxTextHeight) / 2.0f;
        Paint paint = new Paint();
        paint.setColor(getResources().getColor(R.color.wheelview_shadow));
        Paint paint2 = paint;
        canvas.drawRect(0.0f, 0.0f, (float) getMeasuredWidth(), f - ((float) this.f38320C), paint2);
        float f2 = f + maxTextHeight;
        Canvas canvas2 = canvas;
        canvas2.drawRect(0.0f, f2 + ((float) this.f38320C), (float) getMeasuredWidth(), (2.0f * f) + maxTextHeight, paint2);
        paint.setColor(getResources().getColor(R.color.title_bar_line_bg));
        canvas2.drawLine(0.0f, f - ((float) this.f38320C), (float) getMeasuredWidth(), f - ((float) this.f38320C), paint2);
        canvas2.drawLine(0.0f, f2 + ((float) this.f38320C), (float) getMeasuredWidth(), f2 + ((float) this.f38320C), paint2);
        paint.setColor(getResources().getColor(R.color.white));
        canvas2.drawRect(0.0f, 0.0f, (float) getMeasuredWidth(), (float) this.f38344y, paint2);
        canvas2.drawRect(0.0f, (float) (getMeasuredHeight() - this.f38345z), (float) getMeasuredWidth(), (float) getMeasuredHeight(), paint2);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        boolean onTouchEvent = this.f38324e.onTouchEvent(motionEvent);
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    return true;
                }
                if (action != 3) {
                    if (action == 4) {
                        this.f38318A = false;
                    }
                    return super.onTouchEvent(motionEvent);
                }
            }
            if (!onTouchEvent) {
                this.f38337r = m27102b();
            }
            return true;
        }
        this.f38318A = true;
        this.f38319B = true;
        return true;
    }

    /* renamed from: b */
    private int m27102b() {
        List<WheelItem> list = this.f38327h;
        int i = 0;
        if (list != null && !list.isEmpty()) {
            int size = this.f38327h.size();
            int measuredHeight = getMeasuredHeight() >> 1;
            int i2 = 0;
            float f = 0.0f;
            float f2 = 0.0f;
            while (true) {
                if (i >= size) {
                    i = i2;
                    break;
                }
                WheelItem wheelItem = this.f38327h.get(i);
                float top = wheelItem.getTop();
                if (((float) wheelItem.getHeight()) + top >= 0.0f) {
                    float f3 = (float) measuredHeight;
                    if (top <= f3 && ((float) this.f38330k) + top >= f3) {
                        f2 = top - this.f38333n;
                        break;
                    } else if (top <= f3 || f >= f3) {
                        if (i != size - 1 || ((float) this.f38330k) + top > f3) {
                            f = ((float) this.f38330k) + top;
                        } else {
                            f2 = top - this.f38333n;
                            i2 = i;
                        }
                    } else if (Math.abs(top - f3) > Math.abs(f - f3)) {
                        f2 = (f - ((float) this.f38330k)) - this.f38333n;
                    } else {
                        f2 = top - this.f38333n;
                    }
                }
                i++;
            }
            m27099a(f2);
        }
        return i;
    }

    private int getRealTimeSelectedIndex() {
        List<WheelItem> list = this.f38327h;
        if (list == null || list.isEmpty()) {
            return 0;
        }
        int size = this.f38327h.size();
        int measuredHeight = getMeasuredHeight() >> 1;
        int i = 0;
        float f = 0.0f;
        for (int i2 = 0; i2 < size; i2++) {
            WheelItem wheelItem = this.f38327h.get(i2);
            float top = wheelItem.getTop();
            if (((float) wheelItem.getHeight()) + top >= 0.0f) {
                float f2 = (float) measuredHeight;
                if (top <= f2 && ((float) this.f38330k) + top >= f2) {
                    return i2;
                }
                if (top > f2 && f < f2) {
                    int i3 = (Math.abs(top - f2) > Math.abs(f - f2) ? 1 : (Math.abs(top - f2) == Math.abs(f - f2) ? 0 : -1));
                    return i2;
                } else if (i2 != size - 1 || ((float) this.f38330k) + top > f2) {
                    f = ((float) this.f38330k) + top;
                } else {
                    i = i2;
                }
            }
        }
        return i;
    }

    /* renamed from: c */
    private int m27105c() {
        List<WheelItem> list = this.f38327h;
        if (list == null || list.isEmpty()) {
            return 0;
        }
        int size = this.f38327h.size();
        int measuredHeight = getMeasuredHeight() >> 1;
        int i = 0;
        float f = 0.0f;
        for (int i2 = 0; i2 < size; i2++) {
            WheelItem wheelItem = this.f38327h.get(i2);
            float top = wheelItem.getTop();
            if (((float) wheelItem.getHeight()) + top >= 0.0f) {
                float f2 = (float) measuredHeight;
                if (top <= f2 && ((float) this.f38330k) + top >= f2) {
                    return i2;
                }
                if (top > f2 && f < f2) {
                    int i3 = (Math.abs(top - f2) > Math.abs(f - f2) ? 1 : (Math.abs(top - f2) == Math.abs(f - f2) ? 0 : -1));
                    return i2;
                } else if (i2 != size - 1 || ((float) this.f38330k) + top > f2) {
                    f = ((float) this.f38330k) + top;
                } else {
                    i = i2;
                }
            }
        }
        return i;
    }

    /* renamed from: a */
    private void m27099a(float f) {
        FlingRunnable flingRunnable = new FlingRunnable();
        this.f38341v = flingRunnable;
        flingRunnable.flingUp((int) (-f), 200);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m27104b(float f) {
        if (this.f38327h != null) {
            for (int i = 0; i < this.f38327h.size(); i++) {
                WheelItem wheelItem = this.f38327h.get(i);
                wheelItem.setTop(wheelItem.getTop() + f);
            }
            if (f < 0.0f) {
                List<WheelItem> list = this.f38327h;
                if (list.get(list.size() - 1).getTop() + ((float) this.f38330k) < ((float) ((getMeasuredHeight() - this.f38338s) >> 1))) {
                    m27107d();
                    removeCallbacks(this.f38341v);
                    return;
                }
            }
            if (f > 0.0f) {
                if (this.f38327h.get(0).getTop() > ((float) ((getMeasuredHeight() + this.f38338s) >> 1))) {
                    m27108e();
                    removeCallbacks(this.f38341v);
                }
            }
        }
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        m27106c(f2);
        return true;
    }

    /* renamed from: d */
    private void m27107d() {
        if (this.f38327h != null) {
            float measuredHeight = ((float) ((getMeasuredHeight() - this.f38338s) >> 1)) - ((float) this.f38330k);
            for (int size = this.f38327h.size() - 1; size >= 0; size--) {
                this.f38327h.get(size).setTop(measuredHeight);
                measuredHeight -= (float) this.f38330k;
            }
            invalidate();
        }
    }

    /* renamed from: e */
    private void m27108e() {
        if (this.f38327h != null) {
            float measuredHeight = (float) ((getMeasuredHeight() + this.f38338s) >> 1);
            int size = this.f38327h.size();
            for (int i = 0; i < size; i++) {
                this.f38327h.get(i).setTop(measuredHeight);
                measuredHeight += (float) this.f38330k;
            }
            invalidate();
        }
    }

    /* renamed from: c */
    private void m27106c(float f) {
        WheelItem wheelItem;
        List<WheelItem> list = this.f38327h;
        if (list != null) {
            int size = list.size();
            if (f > 0.0f) {
                wheelItem = this.f38327h.get(size - 1);
                if (wheelItem.getTop() + ((float) this.f38330k) <= ((float) ((getMeasuredHeight() - this.f38338s) >> 1))) {
                    m27107d();
                    return;
                }
            } else {
                wheelItem = this.f38327h.get(0);
                if (wheelItem.getTop() >= ((float) ((getMeasuredHeight() + this.f38338s) >> 1))) {
                    m27108e();
                    return;
                }
            }
            for (int i = 0; i < size; i++) {
                wheelItem = this.f38327h.get(i);
                wheelItem.setTop(wheelItem.getTop() - f);
            }
            SystemUtils.log(3, "WhellTest", "handleScroll item:" + wheelItem.getTitle(), (Throwable) null, "com.didi.sdk.view.wheel.Wheel", 616);
            invalidate();
            m27109f();
        }
    }

    /* renamed from: f */
    private void m27109f() {
        int realTimeSelectedIndex = getRealTimeSelectedIndex();
        if (realTimeSelectedIndex != this.f38337r) {
            this.f38321D = true;
            this.f38337r = realTimeSelectedIndex;
            this.f38322a = getCurrentText();
            m27110g();
            SystemUtils.log(3, f38316c, "sleecte:" + realTimeSelectedIndex + " voiceText:" + this.f38322a + " mdata:" + this.f38332m, (Throwable) null, "com.didi.sdk.view.wheel.Wheel", 632);
        }
    }

    /* renamed from: g */
    private void m27110g() {
        setContentDescription(this.f38322a);
        sendAccessibilityEvent(4);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode != Integer.MIN_VALUE) {
        }
        float f = (((float) this.f38330k) * this.f38331l) + ((float) (this.f38344y + this.f38345z));
        setMeasuredDimension(size, (int) f);
        this.f38333n = (f - ((float) this.f38330k)) / 2.0f;
    }

    public class FlingRunnable implements Runnable {
        private int mLastFingY;
        private Scroller mScroller;

        public FlingRunnable() {
            this.mScroller = new Scroller(Wheel.this.getContext());
        }

        public void run() {
            if (this.mScroller.computeScrollOffset()) {
                Wheel.this.m27104b((float) (this.mScroller.getCurrY() - this.mLastFingY));
                Wheel.this.invalidate();
                this.mLastFingY = this.mScroller.getCurrY();
                Wheel.this.post(this);
                return;
            }
            Wheel.this.removeCallbacks(this);
            if (Wheel.this.f38340u != null) {
                Wheel.this.f38340u.onItemChanged(Wheel.this.f38337r);
            }
        }

        /* access modifiers changed from: private */
        public void flingUp(int i, int i2) {
            Wheel.this.removeCallbacks(this);
            this.mLastFingY = 0;
            this.mScroller.startScroll(0, 0, 0, i, i2);
            Wheel.this.post(this);
        }

        private void setVisibleCount(float f) {
            float unused = Wheel.this.f38331l = f;
        }

        private void setItemHeight(int i) {
            int unused = Wheel.this.f38330k = i;
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    private String getCurrentText() {
        List<String> list = this.f38332m;
        if (list == null || this.f38337r > list.size() - 1) {
            SystemUtils.log(3, f38316c, "getCurrentText: 为空  mCurrentIndex:" + this.f38337r, (Throwable) null, "com.didi.sdk.view.wheel.Wheel", 741);
            return "";
        }
        String str = this.f38332m.get(this.f38337r);
        SystemUtils.log(3, f38316c, "getCurrentText:" + str, (Throwable) null, "com.didi.sdk.view.wheel.Wheel", 738);
        return str;
    }

    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.getText().add(this.f38322a);
        accessibilityEvent.setContentDescription(this.f38322a);
    }

    private class MyAccessibilityDelegate extends AccessibilityDelegateCompat {
        int count;

        private MyAccessibilityDelegate() {
            this.count = 1;
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(Wheel.class.getName());
            accessibilityEvent.setScrollable(true);
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setClassName(Wheel.class.getName());
            accessibilityNodeInfoCompat.setClickable(true);
            accessibilityNodeInfoCompat.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
        }

        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            if (!TextUtils.isEmpty(Wheel.this.f38322a)) {
                SystemUtils.log(3, Wheel.f38316c, "onPopulateAccessibilityEvent:" + Wheel.this.f38322a, (Throwable) null, "com.didi.sdk.view.wheel.Wheel$MyAccessibilityDelegate", 774);
                StringBuilder sb = new StringBuilder();
                sb.append(Wheel.this.f38322a);
                int i = this.count + 1;
                this.count = i;
                sb.append(i);
                accessibilityEvent.setContentDescription(sb.toString());
                List text = accessibilityEvent.getText();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(Wheel.this.f38322a);
                int i2 = this.count + 1;
                this.count = i2;
                sb2.append(i2);
                text.add(sb2.toString());
            }
        }
    }
}
