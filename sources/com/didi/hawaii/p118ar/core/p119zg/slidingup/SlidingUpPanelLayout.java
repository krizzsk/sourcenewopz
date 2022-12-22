package com.didi.hawaii.p118ar.core.p119zg.slidingup;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.hawaii.p118ar.core.p119zg.slidingup.utils.ScrollableViewHelper;
import com.didi.hawaii.p118ar.core.p119zg.slidingup.utils.ViewDragHelper;
import com.didi.passenger.C10448R;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.didi.hawaii.ar.core.zg.slidingup.SlidingUpPanelLayout */
public class SlidingUpPanelLayout extends ViewGroup {
    public static final String SLIDING_STATE = "sliding_state";

    /* renamed from: a */
    private static final String f23213a = SlidingUpPanelLayout.class.getSimpleName();

    /* renamed from: b */
    private static final int f23214b = 68;

    /* renamed from: c */
    private static final float f23215c = 1.0f;

    /* renamed from: d */
    private static PanelState f23216d = PanelState.COLLAPSED;

    /* renamed from: e */
    private static final int f23217e = 4;

    /* renamed from: f */
    private static final int f23218f = -1728053248;

    /* renamed from: g */
    private static final int f23219g = 400;

    /* renamed from: h */
    private static final boolean f23220h = false;

    /* renamed from: i */
    private static final boolean f23221i = true;

    /* renamed from: l */
    private static final int f23222l = 0;

    /* renamed from: A */
    private View f23223A;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public PanelState f23224B;

    /* renamed from: C */
    private PanelState f23225C;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public float f23226D;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public int f23227E;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public float f23228F;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public boolean f23229G;

    /* renamed from: H */
    private boolean f23230H;

    /* renamed from: I */
    private float f23231I;

    /* renamed from: J */
    private float f23232J;

    /* renamed from: K */
    private float f23233K;

    /* renamed from: L */
    private float f23234L;

    /* renamed from: M */
    private boolean f23235M;

    /* renamed from: N */
    private final List<PanelSlideListener> f23236N;

    /* renamed from: O */
    private View.OnClickListener f23237O;
    /* access modifiers changed from: private */

    /* renamed from: P */
    public final ViewDragHelper f23238P;

    /* renamed from: Q */
    private boolean f23239Q;

    /* renamed from: R */
    private final Rect f23240R;

    /* renamed from: j */
    private int f23241j;

    /* renamed from: k */
    private int f23242k;

    /* renamed from: m */
    private final Paint f23243m;

    /* renamed from: n */
    private final Drawable f23244n;

    /* renamed from: o */
    private int f23245o;

    /* renamed from: p */
    private int f23246p;

    /* renamed from: q */
    private int f23247q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public boolean f23248r;

    /* renamed from: s */
    private boolean f23249s;

    /* renamed from: t */
    private boolean f23250t;

    /* renamed from: u */
    private View f23251u;

    /* renamed from: v */
    private int f23252v;

    /* renamed from: w */
    private View f23253w;

    /* renamed from: x */
    private int f23254x;

    /* renamed from: y */
    private ScrollableViewHelper f23255y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public View f23256z;

    /* renamed from: com.didi.hawaii.ar.core.zg.slidingup.SlidingUpPanelLayout$PanelSlideListener */
    public interface PanelSlideListener {
        void onPanelSlide(View view, float f);

        void onPanelStateChanged(View view, PanelState panelState, PanelState panelState2);
    }

    /* renamed from: com.didi.hawaii.ar.core.zg.slidingup.SlidingUpPanelLayout$PanelState */
    public enum PanelState {
        EXPANDED,
        COLLAPSED,
        ANCHORED,
        HIDDEN,
        DRAGGING
    }

    /* renamed from: com.didi.hawaii.ar.core.zg.slidingup.SlidingUpPanelLayout$SimplePanelSlideListener */
    public static class SimplePanelSlideListener implements PanelSlideListener {
        public void onPanelSlide(View view, float f) {
        }

        public void onPanelStateChanged(View view, PanelState panelState, PanelState panelState2) {
        }
    }

    public SlidingUpPanelLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public SlidingUpPanelLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingUpPanelLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f23241j = 400;
        this.f23242k = -1728053248;
        this.f23243m = new Paint();
        this.f23245o = -1;
        this.f23246p = -1;
        this.f23247q = -1;
        this.f23249s = false;
        this.f23250t = true;
        this.f23252v = -1;
        this.f23255y = new ScrollableViewHelper();
        PanelState panelState = f23216d;
        this.f23224B = panelState;
        this.f23225C = panelState;
        this.f23228F = 1.0f;
        this.f23235M = false;
        this.f23236N = new CopyOnWriteArrayList();
        this.f23239Q = true;
        this.f23240R = new Rect();
        if (isInEditMode()) {
            this.f23244n = null;
            this.f23238P = null;
            return;
        }
        Interpolator a = m16658a(context, attributeSet);
        float f = context.getResources().getDisplayMetrics().density;
        if (this.f23245o == -1) {
            this.f23245o = (int) ((68.0f * f) + 0.5f);
        }
        if (this.f23246p == -1) {
            this.f23246p = (int) ((4.0f * f) + 0.5f);
        }
        if (this.f23247q == -1) {
            this.f23247q = (int) (0.0f * f);
        }
        if (this.f23246p <= 0) {
            this.f23244n = null;
        } else if (this.f23248r) {
            this.f23244n = getResources().getDrawable(R.drawable.above_shadow);
        } else {
            this.f23244n = getResources().getDrawable(R.drawable.below_shadow);
        }
        setWillNotDraw(false);
        ViewDragHelper create = ViewDragHelper.create(this, 0.5f, a, new DragHelperCallback());
        this.f23238P = create;
        create.setMinVelocity(((float) this.f23241j) * f);
        this.f23230H = true;
    }

    public SlidingUpPanelLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f23241j = 400;
        this.f23242k = -1728053248;
        this.f23243m = new Paint();
        this.f23245o = -1;
        this.f23246p = -1;
        this.f23247q = -1;
        this.f23249s = false;
        this.f23250t = true;
        this.f23252v = -1;
        this.f23255y = new ScrollableViewHelper();
        PanelState panelState = f23216d;
        this.f23224B = panelState;
        this.f23225C = panelState;
        this.f23228F = 1.0f;
        this.f23235M = false;
        this.f23236N = new CopyOnWriteArrayList();
        this.f23239Q = true;
        this.f23240R = new Rect();
        if (isInEditMode()) {
            this.f23244n = null;
            this.f23238P = null;
            return;
        }
        Interpolator a = m16658a(context, attributeSet);
        float f = context.getResources().getDisplayMetrics().density;
        if (this.f23245o == -1) {
            this.f23245o = (int) ((68.0f * f) + 0.5f);
        }
        if (this.f23246p == -1) {
            this.f23246p = (int) ((4.0f * f) + 0.5f);
        }
        if (this.f23247q == -1) {
            this.f23247q = (int) (0.0f * f);
        }
        if (this.f23246p <= 0) {
            this.f23244n = null;
        } else if (this.f23248r) {
            this.f23244n = getResources().getDrawable(R.drawable.above_shadow);
        } else {
            this.f23244n = getResources().getDrawable(R.drawable.below_shadow);
        }
        setWillNotDraw(false);
        ViewDragHelper create = ViewDragHelper.create(this, 0.5f, a, new DragHelperCallback());
        this.f23238P = create;
        create.setMinVelocity(((float) this.f23241j) * f);
        this.f23230H = true;
    }

    /* renamed from: a */
    private Interpolator m16658a(Context context, AttributeSet attributeSet) {
        Interpolator interpolator = null;
        if (attributeSet != null) {
            setGravity(80);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.SlidingUpPanelLayout);
            if (obtainStyledAttributes != null) {
                this.f23245o = obtainStyledAttributes.getDimensionPixelSize(7, -1);
                this.f23246p = obtainStyledAttributes.getDimensionPixelSize(11, -1);
                this.f23247q = obtainStyledAttributes.getDimensionPixelSize(8, -1);
                this.f23241j = obtainStyledAttributes.getInt(4, 400);
                this.f23242k = obtainStyledAttributes.getColor(3, -1728053248);
                this.f23252v = obtainStyledAttributes.getResourceId(2, -1);
                this.f23254x = obtainStyledAttributes.getResourceId(10, -1);
                this.f23249s = obtainStyledAttributes.getBoolean(6, false);
                this.f23250t = obtainStyledAttributes.getBoolean(1, true);
                this.f23228F = obtainStyledAttributes.getFloat(0, 1.0f);
                int i = obtainStyledAttributes.getInt(5, 0);
                if (i == 0) {
                    this.f23224B = PanelState.EXPANDED;
                } else if (i == 1) {
                    this.f23224B = PanelState.COLLAPSED;
                } else if (i == 2) {
                    this.f23224B = PanelState.ANCHORED;
                } else if (i == 3) {
                    this.f23224B = PanelState.HIDDEN;
                } else if (i == 4) {
                    this.f23224B = PanelState.DRAGGING;
                }
                int resourceId = obtainStyledAttributes.getResourceId(9, -1);
                if (resourceId != -1) {
                    interpolator = AnimationUtils.loadInterpolator(context, resourceId);
                }
                obtainStyledAttributes.recycle();
            }
        }
        return interpolator;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        int i = this.f23252v;
        if (i != -1) {
            setDragView(findViewById(i));
        }
        int i2 = this.f23254x;
        if (i2 != -1) {
            setScrollableView(findViewById(i2));
        }
    }

    public void setGravity(int i) {
        if (i == 48 || i == 80) {
            this.f23248r = i == 80;
            if (!this.f23239Q) {
                requestLayout();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("gravity must be set to either top or bottom");
    }

    public void setCoveredFadeColor(int i) {
        this.f23242k = i;
        requestLayout();
    }

    public int getCoveredFadeColor() {
        return this.f23242k;
    }

    public void setTouchEnabled(boolean z) {
        this.f23230H = z;
    }

    public boolean isTouchEnabled() {
        return (!this.f23230H || this.f23256z == null || this.f23224B == PanelState.HIDDEN) ? false : true;
    }

    public void setPanelHeight(int i) {
        if (getPanelHeight() != i) {
            this.f23245o = i;
            if (!this.f23239Q) {
                requestLayout();
            }
            if (getPanelState() == PanelState.COLLAPSED) {
                smoothToBottom();
                invalidate();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void smoothToBottom() {
        mo67832a(0.0f, 0);
    }

    public int getShadowHeight() {
        return this.f23246p;
    }

    public void setShadowHeight(int i) {
        this.f23246p = i;
        if (!this.f23239Q) {
            invalidate();
        }
    }

    public int getPanelHeight() {
        return this.f23245o;
    }

    public int getCurrentParallaxOffset() {
        int max = (int) (((float) this.f23247q) * Math.max(this.f23226D, 0.0f));
        return this.f23248r ? -max : max;
    }

    public void setParallaxOffset(int i) {
        this.f23247q = i;
        if (!this.f23239Q) {
            requestLayout();
        }
    }

    public int getMinFlingVelocity() {
        return this.f23241j;
    }

    public void setMinFlingVelocity(int i) {
        this.f23241j = i;
    }

    public void addPanelSlideListener(PanelSlideListener panelSlideListener) {
        synchronized (this.f23236N) {
            this.f23236N.add(panelSlideListener);
        }
    }

    public void removePanelSlideListener(PanelSlideListener panelSlideListener) {
        synchronized (this.f23236N) {
            this.f23236N.remove(panelSlideListener);
        }
    }

    public void setFadeOnClickListener(View.OnClickListener onClickListener) {
        this.f23237O = onClickListener;
    }

    public void setDragView(View view) {
        View view2 = this.f23251u;
        if (view2 != null) {
            view2.setOnClickListener((View.OnClickListener) null);
        }
        this.f23251u = view;
        if (view != null) {
            view.setClickable(true);
            this.f23251u.setFocusable(false);
            this.f23251u.setFocusableInTouchMode(false);
            this.f23251u.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (SlidingUpPanelLayout.this.isEnabled() && SlidingUpPanelLayout.this.isTouchEnabled()) {
                        if (SlidingUpPanelLayout.this.f23224B == PanelState.EXPANDED || SlidingUpPanelLayout.this.f23224B == PanelState.ANCHORED) {
                            SlidingUpPanelLayout.this.setPanelState(PanelState.COLLAPSED);
                        } else if (SlidingUpPanelLayout.this.f23228F < 1.0f) {
                            SlidingUpPanelLayout.this.setPanelState(PanelState.ANCHORED);
                        } else {
                            SlidingUpPanelLayout.this.setPanelState(PanelState.EXPANDED);
                        }
                    }
                }
            });
        }
    }

    public void setDragView(int i) {
        this.f23252v = i;
        setDragView(findViewById(i));
    }

    public void setScrollableView(View view) {
        this.f23253w = view;
    }

    public void setScrollableViewHelper(ScrollableViewHelper scrollableViewHelper) {
        this.f23255y = scrollableViewHelper;
    }

    public void setAnchorPoint(float f) {
        if (f > 0.0f && f <= 1.0f) {
            this.f23228F = f;
            this.f23239Q = true;
            requestLayout();
        }
    }

    public float getAnchorPoint() {
        return this.f23228F;
    }

    public void setOverlayed(boolean z) {
        this.f23249s = z;
    }

    public boolean isOverlayed() {
        return this.f23249s;
    }

    public void setClipPanel(boolean z) {
        this.f23250t = z;
    }

    public boolean isClipPanel() {
        return this.f23250t;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo67830a(View view) {
        synchronized (this.f23236N) {
            for (PanelSlideListener onPanelSlide : this.f23236N) {
                onPanelSlide.onPanelSlide(view, this.f23226D);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo67831a(View view, PanelState panelState, PanelState panelState2) {
        synchronized (this.f23236N) {
            for (PanelSlideListener onPanelStateChanged : this.f23236N) {
                onPanelStateChanged.onPanelStateChanged(view, panelState, panelState2);
            }
        }
        sendAccessibilityEvent(32);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo67829a() {
        int i;
        int i2;
        int i3;
        int i4;
        if (getChildCount() != 0) {
            int paddingLeft = getPaddingLeft();
            int width = getWidth() - getPaddingRight();
            int paddingTop = getPaddingTop();
            int height = getHeight() - getPaddingBottom();
            View view = this.f23256z;
            int i5 = 0;
            if (view == null || !m16666b(view)) {
                i4 = 0;
                i3 = 0;
                i2 = 0;
                i = 0;
            } else {
                i4 = this.f23256z.getLeft();
                i3 = this.f23256z.getRight();
                i2 = this.f23256z.getTop();
                i = this.f23256z.getBottom();
            }
            View childAt = getChildAt(0);
            int max = Math.max(paddingLeft, childAt.getLeft());
            int max2 = Math.max(paddingTop, childAt.getTop());
            int min = Math.min(width, childAt.getRight());
            int min2 = Math.min(height, childAt.getBottom());
            if (max >= i4 && max2 >= i2 && min <= i3 && min2 <= i) {
                i5 = 4;
            }
            childAt.setVisibility(i5);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo67834b() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
    }

    /* renamed from: b */
    private static boolean m16666b(View view) {
        Drawable background = view.getBackground();
        return background != null && background.getOpacity() == -1;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f23239Q = true;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f23239Q = true;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode != 1073741824 && mode != Integer.MIN_VALUE) {
            throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
        } else if (mode2 == 1073741824 || mode2 == Integer.MIN_VALUE) {
            int childCount = getChildCount();
            if (childCount == 2) {
                this.f23223A = getChildAt(0);
                View childAt = getChildAt(1);
                this.f23256z = childAt;
                if (this.f23251u == null) {
                    setDragView(childAt);
                }
                if (this.f23256z.getVisibility() != 0) {
                    this.f23224B = PanelState.HIDDEN;
                }
                int paddingTop = (size2 - getPaddingTop()) - getPaddingBottom();
                int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
                for (int i7 = 0; i7 < childCount; i7++) {
                    View childAt2 = getChildAt(i7);
                    LayoutParams layoutParams = (LayoutParams) childAt2.getLayoutParams();
                    if (childAt2.getVisibility() != 8 || i7 != 0) {
                        if (childAt2 == this.f23223A) {
                            i4 = (this.f23249s || this.f23224B == PanelState.HIDDEN) ? paddingTop : paddingTop - this.f23245o;
                            i3 = paddingLeft - (layoutParams.leftMargin + layoutParams.rightMargin);
                        } else {
                            i4 = childAt2 == this.f23256z ? paddingTop - layoutParams.topMargin : paddingTop;
                            i3 = paddingLeft;
                        }
                        if (layoutParams.width == -2) {
                            i5 = View.MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE);
                        } else if (layoutParams.width == -1) {
                            i5 = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
                        } else {
                            i5 = View.MeasureSpec.makeMeasureSpec(layoutParams.width, 1073741824);
                        }
                        if (layoutParams.height == -2) {
                            i6 = View.MeasureSpec.makeMeasureSpec(i4, Integer.MIN_VALUE);
                        } else {
                            if (layoutParams.weight > 0.0f && layoutParams.weight < 1.0f) {
                                i4 = (int) (((float) i4) * layoutParams.weight);
                            } else if (layoutParams.height != -1) {
                                i4 = layoutParams.height;
                            }
                            i6 = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
                        }
                        childAt2.measure(i5, i6);
                        View view = this.f23256z;
                        if (childAt2 == view) {
                            this.f23227E = view.getMeasuredHeight() - this.f23245o;
                        }
                    }
                }
                setMeasuredDimension(size, size2);
                return;
            }
            throw new IllegalStateException("Sliding up panel layout must have exactly 2 children!");
        } else {
            throw new IllegalStateException("Height must have an exact value or MATCH_PARENT");
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        if (this.f23239Q) {
            int i5 = C89002.f23257xb884d6[this.f23224B.ordinal()];
            if (i5 == 1) {
                this.f23226D = 1.0f;
            } else if (i5 == 2) {
                this.f23226D = this.f23228F;
            } else if (i5 != 3) {
                this.f23226D = 0.0f;
            } else {
                this.f23226D = m16654a(m16657a(0.0f) + (this.f23248r ? this.f23245o : -this.f23245o));
            }
        }
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (childAt.getVisibility() != 8 || (i6 != 0 && !this.f23239Q)) {
                int measuredHeight = childAt.getMeasuredHeight();
                int a = childAt == this.f23256z ? m16657a(this.f23226D) : paddingTop;
                if (!this.f23248r && childAt == this.f23223A && !this.f23249s) {
                    a = m16657a(this.f23226D) + this.f23256z.getMeasuredHeight();
                }
                int i7 = layoutParams.leftMargin + paddingLeft;
                childAt.layout(i7, a, childAt.getMeasuredWidth() + i7, measuredHeight + a);
            }
        }
        if (this.f23239Q) {
            mo67829a();
        }
        m16667c();
        this.f23239Q = false;
    }

    /* renamed from: com.didi.hawaii.ar.core.zg.slidingup.SlidingUpPanelLayout$2 */
    static /* synthetic */ class C89002 {

        /* renamed from: $SwitchMap$com$didi$hawaii$ar$core$zg$slidingup$SlidingUpPanelLayout$PanelState */
        static final /* synthetic */ int[] f23257xb884d6;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.didi.hawaii.ar.core.zg.slidingup.SlidingUpPanelLayout$PanelState[] r0 = com.didi.hawaii.p118ar.core.p119zg.slidingup.SlidingUpPanelLayout.PanelState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f23257xb884d6 = r0
                com.didi.hawaii.ar.core.zg.slidingup.SlidingUpPanelLayout$PanelState r1 = com.didi.hawaii.p118ar.core.p119zg.slidingup.SlidingUpPanelLayout.PanelState.EXPANDED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f23257xb884d6     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.hawaii.ar.core.zg.slidingup.SlidingUpPanelLayout$PanelState r1 = com.didi.hawaii.p118ar.core.p119zg.slidingup.SlidingUpPanelLayout.PanelState.ANCHORED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f23257xb884d6     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.hawaii.ar.core.zg.slidingup.SlidingUpPanelLayout$PanelState r1 = com.didi.hawaii.p118ar.core.p119zg.slidingup.SlidingUpPanelLayout.PanelState.HIDDEN     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f23257xb884d6     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.didi.hawaii.ar.core.zg.slidingup.SlidingUpPanelLayout$PanelState r1 = com.didi.hawaii.p118ar.core.p119zg.slidingup.SlidingUpPanelLayout.PanelState.COLLAPSED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.hawaii.p118ar.core.p119zg.slidingup.SlidingUpPanelLayout.C89002.<clinit>():void");
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i2 != i4) {
            this.f23239Q = true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0038, code lost:
        if (r0 != 3) goto L_0x009d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r9) {
        /*
            r8 = this;
            boolean r0 = r8.f23235M
            r1 = 0
            if (r0 != 0) goto L_0x00a4
            boolean r0 = r8.isTouchEnabled()
            if (r0 != 0) goto L_0x000d
            goto L_0x00a4
        L_0x000d:
            int r0 = androidx.core.view.MotionEventCompat.getActionMasked(r9)
            float r2 = r9.getX()
            float r3 = r9.getY()
            float r4 = r8.f23233K
            float r4 = r2 - r4
            float r4 = java.lang.Math.abs(r4)
            float r5 = r8.f23234L
            float r5 = r3 - r5
            float r5 = java.lang.Math.abs(r5)
            com.didi.hawaii.ar.core.zg.slidingup.utils.ViewDragHelper r6 = r8.f23238P
            int r6 = r6.getTouchSlop()
            r7 = 1
            if (r0 == 0) goto L_0x0085
            if (r0 == r7) goto L_0x004c
            r2 = 2
            if (r0 == r2) goto L_0x003b
            r2 = 3
            if (r0 == r2) goto L_0x004c
            goto L_0x009d
        L_0x003b:
            float r0 = (float) r6
            int r0 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x009d
            int r0 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r0 <= 0) goto L_0x009d
            com.didi.hawaii.ar.core.zg.slidingup.utils.ViewDragHelper r9 = r8.f23238P
            r9.cancel()
            r8.f23229G = r7
            return r1
        L_0x004c:
            com.didi.hawaii.ar.core.zg.slidingup.utils.ViewDragHelper r0 = r8.f23238P
            boolean r0 = r0.isDragging()
            if (r0 == 0) goto L_0x005a
            com.didi.hawaii.ar.core.zg.slidingup.utils.ViewDragHelper r0 = r8.f23238P
            r0.processTouchEvent(r9)
            return r7
        L_0x005a:
            float r0 = (float) r6
            int r2 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r2 > 0) goto L_0x009d
            int r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r0 > 0) goto L_0x009d
            float r0 = r8.f23226D
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 <= 0) goto L_0x009d
            android.view.View r0 = r8.f23256z
            float r2 = r8.f23233K
            int r2 = (int) r2
            float r3 = r8.f23234L
            int r3 = (int) r3
            boolean r0 = r8.m16661a((android.view.View) r0, (int) r2, (int) r3)
            if (r0 != 0) goto L_0x009d
            android.view.View$OnClickListener r0 = r8.f23237O
            if (r0 == 0) goto L_0x009d
            r8.playSoundEffect(r1)
            android.view.View$OnClickListener r9 = r8.f23237O
            r9.onClick(r8)
            return r7
        L_0x0085:
            r8.f23229G = r1
            r8.f23233K = r2
            r8.f23234L = r3
            android.view.View r0 = r8.f23251u
            int r2 = (int) r2
            int r3 = (int) r3
            boolean r0 = r8.m16661a((android.view.View) r0, (int) r2, (int) r3)
            if (r0 != 0) goto L_0x009d
            com.didi.hawaii.ar.core.zg.slidingup.utils.ViewDragHelper r9 = r8.f23238P
            r9.cancel()
            r8.f23229G = r7
            return r1
        L_0x009d:
            com.didi.hawaii.ar.core.zg.slidingup.utils.ViewDragHelper r0 = r8.f23238P
            boolean r9 = r0.shouldInterceptTouchEvent(r9)
            return r9
        L_0x00a4:
            com.didi.hawaii.ar.core.zg.slidingup.utils.ViewDragHelper r9 = r8.f23238P
            r9.abort()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.hawaii.p118ar.core.p119zg.slidingup.SlidingUpPanelLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled() || !isTouchEnabled()) {
            return super.onTouchEvent(motionEvent);
        }
        try {
            this.f23238P.processTouchEvent(motionEvent);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (!isEnabled() || !isTouchEnabled() || (this.f23229G && actionMasked != 0)) {
            this.f23238P.abort();
            return super.dispatchTouchEvent(motionEvent);
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (actionMasked == 0) {
            this.f23235M = false;
            this.f23231I = x;
            this.f23232J = y;
        } else if (actionMasked == 2) {
            float f = y - this.f23232J;
            this.f23231I = x;
            this.f23232J = y;
            if (Math.abs(x - this.f23231I) > Math.abs(f)) {
                return super.dispatchTouchEvent(motionEvent);
            }
            if (!m16661a(this.f23253w, (int) this.f23233K, (int) this.f23234L)) {
                return super.dispatchTouchEvent(motionEvent);
            }
            int i = -1;
            if (((float) (this.f23248r ? 1 : -1)) * f <= 0.0f) {
                if (this.f23248r) {
                    i = 1;
                }
                if (f * ((float) i) < 0.0f) {
                    if (this.f23226D < 1.0f) {
                        this.f23235M = false;
                        return onTouchEvent(motionEvent);
                    }
                    if (!this.f23235M && this.f23238P.isDragging()) {
                        this.f23238P.cancel();
                        motionEvent.setAction(0);
                    }
                    this.f23235M = true;
                    return super.dispatchTouchEvent(motionEvent);
                }
            } else if (this.f23255y.getScrollableViewScrollPosition(this.f23253w, this.f23248r) > 0) {
                this.f23235M = true;
                return super.dispatchTouchEvent(motionEvent);
            } else {
                if (this.f23235M) {
                    MotionEvent obtain = MotionEvent.obtain(motionEvent);
                    obtain.setAction(3);
                    super.dispatchTouchEvent(obtain);
                    obtain.recycle();
                    motionEvent.setAction(0);
                }
                this.f23235M = false;
                return onTouchEvent(motionEvent);
            }
        } else if (actionMasked == 1 && this.f23235M) {
            this.f23238P.setDragState(0);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* renamed from: a */
    private boolean m16661a(View view, int i, int i2) {
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int[] iArr2 = new int[2];
        getLocationOnScreen(iArr2);
        int i3 = iArr2[0] + i;
        int i4 = iArr2[1] + i2;
        if (i3 < iArr[0] || i3 >= iArr[0] + view.getWidth() || i4 < iArr[1] || i4 >= iArr[1] + view.getHeight()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public int m16657a(float f) {
        View view = this.f23256z;
        int measuredHeight = view != null ? view.getMeasuredHeight() : 0;
        int i = (int) (f * ((float) this.f23227E));
        if (this.f23248r) {
            return ((getMeasuredHeight() - getPaddingBottom()) - this.f23245o) - i;
        }
        return (getPaddingTop() - measuredHeight) + this.f23245o + i;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public float m16654a(int i) {
        int a = m16657a(0.0f);
        return (this.f23248r ? (float) (a - i) : (float) (i - a)) / ((float) this.f23227E);
    }

    public PanelState getPanelState() {
        return this.f23224B;
    }

    public void setPanelState(PanelState panelState) {
        PanelState panelState2;
        if (this.f23238P.getViewDragState() == 2) {
            SystemUtils.log(3, f23213a, "View is settling. Aborting animation.", (Throwable) null, "com.didi.hawaii.ar.core.zg.slidingup.SlidingUpPanelLayout", 1158);
            this.f23238P.abort();
        }
        if (panelState == null || panelState == PanelState.DRAGGING) {
            throw new IllegalArgumentException("Panel state cannot be null or DRAGGING.");
        } else if (!isEnabled()) {
        } else {
            if ((this.f23239Q || this.f23256z != null) && panelState != (panelState2 = this.f23224B) && panelState2 != PanelState.DRAGGING) {
                if (this.f23239Q) {
                    setPanelStateInternal(panelState);
                    return;
                }
                if (this.f23224B == PanelState.HIDDEN) {
                    this.f23256z.setVisibility(0);
                    requestLayout();
                }
                int i = C89002.f23257xb884d6[panelState.ordinal()];
                if (i == 1) {
                    mo67832a(1.0f, 0);
                } else if (i == 2) {
                    mo67832a(this.f23228F, 0);
                } else if (i == 3) {
                    mo67832a(m16654a(m16657a(0.0f) + (this.f23248r ? this.f23245o : -this.f23245o)), 0);
                } else if (i == 4) {
                    mo67832a(0.0f, 0);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void setPanelStateInternal(PanelState panelState) {
        PanelState panelState2 = this.f23224B;
        if (panelState2 != panelState) {
            this.f23224B = panelState;
            mo67831a((View) this, panelState2, panelState);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m16667c() {
        if (this.f23247q > 0) {
            ViewCompat.setTranslationY(this.f23223A, (float) getCurrentParallaxOffset());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m16664b(int i) {
        if (this.f23224B != PanelState.DRAGGING) {
            this.f23225C = this.f23224B;
        }
        setPanelStateInternal(PanelState.DRAGGING);
        this.f23226D = m16654a(i);
        m16667c();
        mo67830a(this.f23256z);
        LayoutParams layoutParams = (LayoutParams) this.f23223A.getLayoutParams();
        int height = ((getHeight() - getPaddingBottom()) - getPaddingTop()) - this.f23245o;
        if (this.f23226D <= 0.0f && !this.f23249s) {
            layoutParams.height = this.f23248r ? i - getPaddingBottom() : ((getHeight() - getPaddingBottom()) - this.f23256z.getMeasuredHeight()) - i;
            if (layoutParams.height == height) {
                layoutParams.height = -1;
            }
            this.f23223A.requestLayout();
        } else if (layoutParams.height != -1 && !this.f23249s) {
            layoutParams.height = -1;
            this.f23223A.requestLayout();
        }
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j) {
        boolean z;
        int save = canvas.save();
        View view2 = this.f23256z;
        if (view2 == null || view2 == view) {
            z = super.drawChild(canvas, view, j);
        } else {
            canvas.getClipBounds(this.f23240R);
            if (!this.f23249s) {
                if (this.f23248r) {
                    Rect rect = this.f23240R;
                    rect.bottom = Math.min(rect.bottom, this.f23256z.getTop());
                } else {
                    Rect rect2 = this.f23240R;
                    rect2.top = Math.max(rect2.top, this.f23256z.getBottom());
                }
            }
            if (this.f23250t) {
                canvas.clipRect(this.f23240R);
            }
            z = super.drawChild(canvas, view, j);
            int i = this.f23242k;
            if (i != 0) {
                float f = this.f23226D;
                if (f > 0.0f) {
                    this.f23243m.setColor((i & 16777215) | (((int) (((float) ((-16777216 & i) >>> 24)) * f)) << 24));
                    canvas.drawRect(this.f23240R, this.f23243m);
                }
            }
        }
        canvas.restoreToCount(save);
        return z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo67832a(float f, int i) {
        if (isEnabled() && this.f23256z != null) {
            int a = m16657a(f);
            ViewDragHelper viewDragHelper = this.f23238P;
            View view = this.f23256z;
            if (viewDragHelper.smoothSlideViewTo(view, view.getLeft(), a)) {
                mo67834b();
                ViewCompat.postInvalidateOnAnimation(this);
                return true;
            }
        }
        return false;
    }

    public void computeScroll() {
        ViewDragHelper viewDragHelper = this.f23238P;
        if (viewDragHelper != null && viewDragHelper.continueSettling(true)) {
            if (!isEnabled()) {
                this.f23238P.abort();
            } else {
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }
    }

    public void draw(Canvas canvas) {
        View view;
        int i;
        int i2;
        super.draw(canvas);
        if (this.f23244n != null && (view = this.f23256z) != null) {
            int right = view.getRight();
            if (this.f23248r) {
                i2 = this.f23256z.getTop() - this.f23246p;
                i = this.f23256z.getTop();
            } else {
                i2 = this.f23256z.getBottom();
                i = this.f23256z.getBottom() + this.f23246p;
            }
            this.f23244n.setBounds(this.f23256z.getLeft(), i2, right, i);
            this.f23244n.draw(canvas);
        }
    }

    /* access modifiers changed from: protected */
    public boolean canScroll(View view, boolean z, int i, int i2, int i3) {
        int i4;
        View view2 = view;
        if (view2 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view2;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i5 = i2 + scrollX;
                if (i5 >= childAt.getLeft() && i5 < childAt.getRight() && (i4 = i3 + scrollY) >= childAt.getTop() && i4 < childAt.getBottom()) {
                    if (canScroll(childAt, true, i, i5 - childAt.getLeft(), i4 - childAt.getTop())) {
                        return true;
                    }
                }
            }
        }
        if (!z || !ViewCompat.canScrollHorizontally(view, -i)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("superState", super.onSaveInstanceState());
        bundle.putSerializable(SLIDING_STATE, this.f23224B != PanelState.DRAGGING ? this.f23224B : this.f23225C);
        return bundle;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            PanelState panelState = (PanelState) bundle.getSerializable(SLIDING_STATE);
            this.f23224B = panelState;
            if (panelState == null) {
                panelState = f23216d;
            }
            this.f23224B = panelState;
            parcelable = bundle.getParcelable("superState");
        }
        super.onRestoreInstanceState(parcelable);
    }

    /* renamed from: com.didi.hawaii.ar.core.zg.slidingup.SlidingUpPanelLayout$DragHelperCallback */
    private class DragHelperCallback extends ViewDragHelper.Callback {
        private DragHelperCallback() {
        }

        public boolean tryCaptureView(View view, int i) {
            return !SlidingUpPanelLayout.this.f23229G && view == SlidingUpPanelLayout.this.f23256z;
        }

        public void onViewDragStateChanged(int i) {
            if (SlidingUpPanelLayout.this.f23238P != null && SlidingUpPanelLayout.this.f23238P.getViewDragState() == 0) {
                SlidingUpPanelLayout slidingUpPanelLayout = SlidingUpPanelLayout.this;
                float unused = slidingUpPanelLayout.f23226D = slidingUpPanelLayout.m16654a(slidingUpPanelLayout.f23256z.getTop());
                SlidingUpPanelLayout.this.m16667c();
                if (SlidingUpPanelLayout.this.f23226D == 1.0f) {
                    SlidingUpPanelLayout.this.mo67829a();
                    SlidingUpPanelLayout.this.setPanelStateInternal(PanelState.EXPANDED);
                } else if (SlidingUpPanelLayout.this.f23226D == 0.0f) {
                    SlidingUpPanelLayout.this.setPanelStateInternal(PanelState.COLLAPSED);
                } else if (SlidingUpPanelLayout.this.f23226D < 0.0f) {
                    SlidingUpPanelLayout.this.setPanelStateInternal(PanelState.HIDDEN);
                    SlidingUpPanelLayout.this.f23256z.setVisibility(4);
                } else {
                    SlidingUpPanelLayout.this.mo67829a();
                    SlidingUpPanelLayout.this.setPanelStateInternal(PanelState.ANCHORED);
                }
            }
        }

        public void onViewCaptured(View view, int i) {
            SlidingUpPanelLayout.this.mo67834b();
        }

        public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
            SlidingUpPanelLayout.this.m16664b(i2);
            SlidingUpPanelLayout.this.invalidate();
        }

        public void onViewReleased(View view, float f, float f2) {
            int i;
            if (SlidingUpPanelLayout.this.f23248r) {
                f2 = -f2;
            }
            int i2 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
            if (i2 > 0 && SlidingUpPanelLayout.this.f23226D <= SlidingUpPanelLayout.this.f23228F) {
                SlidingUpPanelLayout slidingUpPanelLayout = SlidingUpPanelLayout.this;
                i = slidingUpPanelLayout.m16657a(slidingUpPanelLayout.f23228F);
            } else if (i2 <= 0 || SlidingUpPanelLayout.this.f23226D <= SlidingUpPanelLayout.this.f23228F) {
                int i3 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
                if (i3 < 0 && SlidingUpPanelLayout.this.f23226D >= SlidingUpPanelLayout.this.f23228F) {
                    SlidingUpPanelLayout slidingUpPanelLayout2 = SlidingUpPanelLayout.this;
                    i = slidingUpPanelLayout2.m16657a(slidingUpPanelLayout2.f23228F);
                } else if (i3 < 0 && SlidingUpPanelLayout.this.f23226D < SlidingUpPanelLayout.this.f23228F) {
                    i = SlidingUpPanelLayout.this.m16657a(0.0f);
                } else if (SlidingUpPanelLayout.this.f23226D >= (SlidingUpPanelLayout.this.f23228F + 1.0f) / 2.0f) {
                    i = SlidingUpPanelLayout.this.m16657a(1.0f);
                } else if (SlidingUpPanelLayout.this.f23226D >= SlidingUpPanelLayout.this.f23228F / 2.0f) {
                    SlidingUpPanelLayout slidingUpPanelLayout3 = SlidingUpPanelLayout.this;
                    i = slidingUpPanelLayout3.m16657a(slidingUpPanelLayout3.f23228F);
                } else {
                    i = SlidingUpPanelLayout.this.m16657a(0.0f);
                }
            } else {
                i = SlidingUpPanelLayout.this.m16657a(1.0f);
            }
            if (SlidingUpPanelLayout.this.f23238P != null) {
                SlidingUpPanelLayout.this.f23238P.settleCapturedViewAt(view.getLeft(), i);
            }
            SlidingUpPanelLayout.this.invalidate();
        }

        public int getViewVerticalDragRange(View view) {
            return SlidingUpPanelLayout.this.f23227E;
        }

        public int clampViewPositionVertical(View view, int i, int i2) {
            int b = SlidingUpPanelLayout.this.m16657a(0.0f);
            int b2 = SlidingUpPanelLayout.this.m16657a(1.0f);
            if (SlidingUpPanelLayout.this.f23248r) {
                return Math.min(Math.max(i, b2), b);
            }
            return Math.min(Math.max(i, b), b2);
        }
    }

    /* renamed from: com.didi.hawaii.ar.core.zg.slidingup.SlidingUpPanelLayout$LayoutParams */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        private static final int[] ATTRS = {16843137};
        public float weight = 0.0f;

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(int i, int i2, float f) {
            super(i, i2);
            this.weight = f;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ATTRS);
            if (obtainStyledAttributes != null) {
                this.weight = obtainStyledAttributes.getFloat(0, 0.0f);
                obtainStyledAttributes.recycle();
            }
        }
    }
}
