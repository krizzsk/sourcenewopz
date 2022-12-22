package com.didi.component.common.widget.divider;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import com.didi.component.common.widget.divider.IMovePublisher;
import com.didi.passenger.C10448R;
import java.util.LinkedHashMap;
import java.util.Map;

public class DividerLinearLayout extends LinearLayout {

    /* renamed from: a */
    private static final boolean f12033a = false;

    /* renamed from: b */
    private Paint f12034b;

    /* renamed from: c */
    private Map<View, View> f12035c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Map<View, View> f12036d;

    /* renamed from: e */
    private int f12037e;

    /* renamed from: f */
    private int f12038f;

    /* renamed from: g */
    private int f12039g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f12040h;

    /* renamed from: i */
    private int f12041i;

    /* renamed from: j */
    private boolean f12042j;

    /* renamed from: k */
    private Drawable f12043k;

    /* renamed from: l */
    private int f12044l;

    /* renamed from: m */
    private boolean f12045m;

    /* renamed from: n */
    private IMovePublisher f12046n;

    /* renamed from: o */
    private OnSizeChangeListener f12047o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public ViewGroup.OnHierarchyChangeListener f12048p;

    /* renamed from: q */
    private ViewGroup.OnHierarchyChangeListener f12049q;

    public interface OnSizeChangeListener {
        void onSizeChanged(int i, int i2, int i3, int i4);
    }

    /* renamed from: b */
    private void m8118b(Canvas canvas) {
    }

    public DividerLinearLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public DividerLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DividerLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f12035c = new LinkedHashMap();
        this.f12036d = new LinkedHashMap();
        this.f12040h = -1;
        this.f12041i = -1;
        this.f12042j = true;
        this.f12043k = null;
        this.f12045m = false;
        this.f12049q = new ViewGroup.OnHierarchyChangeListener() {
            public void onChildViewAdded(View view, View view2) {
                ViewGroup.OnHierarchyChangeListener a = DividerLinearLayout.this.f12048p;
                if (a != null) {
                    a.onChildViewAdded(view, view2);
                }
                DividerLinearLayout.this.m8115a(view2);
            }

            public void onChildViewRemoved(View view, View view2) {
                ViewGroup.OnHierarchyChangeListener a = DividerLinearLayout.this.f12048p;
                if (a != null) {
                    a.onChildViewRemoved(view, view2);
                }
                DividerLinearLayout.this.m8119b(view2);
            }
        };
        m8113a(context, attributeSet);
    }

    /* renamed from: a */
    private void m8113a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.DividerLinearLayout);
            this.f12037e = obtainStyledAttributes.getDimensionPixelOffset(6, 0);
            this.f12038f = obtainStyledAttributes.getDimensionPixelOffset(7, 0);
            this.f12039g = obtainStyledAttributes.getDimensionPixelOffset(5, 0);
            this.f12040h = obtainStyledAttributes.getColor(4, -1);
            this.f12041i = obtainStyledAttributes.getColor(3, -1);
            this.f12043k = obtainStyledAttributes.getDrawable(0);
            this.f12042j = obtainStyledAttributes.getBoolean(2, true);
            this.f12044l = obtainStyledAttributes.getDimensionPixelOffset(1, 0);
            this.f12046n = obtainStyledAttributes.getBoolean(8, false) ? new MovePublisher(context) : null;
            obtainStyledAttributes.recycle();
        }
    }

    public void setOnMoveListener(IMovePublisher.OnMoveListener onMoveListener) {
        IMovePublisher iMovePublisher = this.f12046n;
        if (iMovePublisher != null) {
            iMovePublisher.setOnMoveListener(onMoveListener);
        }
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        super.setOnHierarchyChangeListener(this.f12049q);
    }

    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f12048p = onHierarchyChangeListener;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8115a(View view) {
        if (getChildCount() != 1 && !this.f12035c.containsValue(view)) {
            final DividerView dividerView = new DividerView(getContext());
            dividerView.setBackgroundColor(this.f12041i);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, this.f12039g);
            layoutParams.leftMargin = this.f12037e;
            layoutParams.rightMargin = this.f12038f;
            int indexOfChild = indexOfChild(view);
            if (indexOfChild == 0) {
                view = getChildAt(1);
            }
            this.f12035c.put(view, dividerView);
            this.f12036d.put(dividerView, view);
            if (indexOfChild == 0) {
                indexOfChild++;
            }
            super.addView(dividerView, indexOfChild, layoutParams);
            view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    dividerView.invalidate();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m8119b(View view) {
        View remove = this.f12035c.remove(view);
        if (remove != null) {
            this.f12036d.remove(remove);
            super.removeView(remove);
        }
    }

    public View getDivider(View view) {
        return this.f12035c.get(view);
    }

    public int getHeightWithDivider(View view) {
        View view2 = this.f12035c.get(view);
        return view.getHeight() + (view2 != null ? view2.getHeight() : 0);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f12045m = ((motionEvent.getX() > 0.0f ? 1 : (motionEvent.getX() == 0.0f ? 0 : -1)) >= 0 && (motionEvent.getX() > ((float) getWidth()) ? 1 : (motionEvent.getX() == ((float) getWidth()) ? 0 : -1)) < 0) && ((motionEvent.getY() > 0.0f ? 1 : (motionEvent.getY() == 0.0f ? 0 : -1)) >= 0 && (motionEvent.getY() > ((float) (getHeight() - getAdjustHeight())) ? 1 : (motionEvent.getY() == ((float) (getHeight() - getAdjustHeight())) ? 0 : -1)) < 0);
        }
        if (this.f12045m) {
            return false;
        }
        IMovePublisher iMovePublisher = this.f12046n;
        if (iMovePublisher == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        boolean dispatchTouchEvent = iMovePublisher.dispatchTouchEvent(motionEvent);
        if (dispatchTouchEvent) {
            return dispatchTouchEvent;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        IMovePublisher iMovePublisher = this.f12046n;
        if (iMovePublisher == null) {
            return true;
        }
        return iMovePublisher.onTouchEvent(motionEvent);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        IMovePublisher iMovePublisher = this.f12046n;
        if (iMovePublisher == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return iMovePublisher.onInterceptTouchEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        m8114a(canvas);
        super.dispatchDraw(canvas);
        m8118b(canvas);
    }

    /* renamed from: a */
    private void m8114a(Canvas canvas) {
        if (this.f12043k != null) {
            int adjustHeight = getAdjustHeight();
            int save = canvas.save();
            if (this.f12042j) {
                canvas.translate((float) this.f12044l, (float) ((getHeight() - adjustHeight) + this.f12044l));
            } else {
                int i = this.f12044l;
                canvas.translate((float) i, (float) i);
            }
            int width = getWidth();
            int i2 = this.f12044l;
            int i3 = adjustHeight - (i2 * 2);
            this.f12043k.setBounds(0, 0, width - (i2 * 2), i3);
            this.f12043k.draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    public int getAdjustHeight() {
        int paddingTop = getPaddingTop() + getPaddingBottom();
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (!(childAt == null || childAt.getVisibility() == 8)) {
                paddingTop = (int) (((float) paddingTop) + (((float) childAt.getHeight()) * childAt.getScaleY()));
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
                if (layoutParams != null) {
                    paddingTop = paddingTop + layoutParams.topMargin + layoutParams.bottomMargin;
                }
            }
        }
        return paddingTop;
    }

    private class DividerView extends View {
        private DividerView(Context context) {
            super(context);
        }

        /* access modifiers changed from: protected */
        public void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            View view = (View) DividerLinearLayout.this.f12036d.get(this);
            if (view != null && view.getVisibility() == 0 && ((float) view.getHeight()) * getScaleY() > 0.0f && ((float) view.getWidth()) * view.getScaleX() > 0.0f) {
                canvas.drawColor(DividerLinearLayout.this.f12040h);
            }
        }
    }

    public void setOnSizeChangeListener(OnSizeChangeListener onSizeChangeListener) {
        this.f12047o = onSizeChangeListener;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        OnSizeChangeListener onSizeChangeListener = this.f12047o;
        if (onSizeChangeListener != null) {
            onSizeChangeListener.onSizeChanged(i, i2, i3, i4);
        }
    }
}
