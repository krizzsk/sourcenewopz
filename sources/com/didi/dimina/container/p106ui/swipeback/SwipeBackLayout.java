package com.didi.dimina.container.p106ui.swipeback;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.didi.dimina.container.page.DMTabBarPageHostFragment;
import com.didi.dimina.container.util.LogUtil;
import com.taxis99.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didi.dimina.container.ui.swipeback.SwipeBackLayout */
public class SwipeBackLayout extends FrameLayout {
    public static final int EDGE_ALL = 3;
    public static final int EDGE_LEFT = 1;
    public static final int EDGE_RIGHT = 2;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;

    /* renamed from: a */
    private static final int f17801a = -1728053248;

    /* renamed from: b */
    private static final int f17802b = 255;

    /* renamed from: c */
    private static final float f17803c = 0.4f;

    /* renamed from: d */
    private static final int f17804d = 10;

    /* renamed from: w */
    private static final float f17805w = 0.618f;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public float f17806e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public ViewDragHelper f17807f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public float f17808g;

    /* renamed from: h */
    private float f17809h;

    /* renamed from: i */
    private final boolean f17810i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public FragmentActivity f17811j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public View f17812k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public SwipeBackFragment f17813l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public View f17814m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public Drawable f17815n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public Drawable f17816o;

    /* renamed from: p */
    private final Rect f17817p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public int f17818q;

    /* renamed from: r */
    private boolean f17819r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public int f17820s;

    /* renamed from: t */
    private final Context f17821t;

    /* renamed from: u */
    private EdgeLevel f17822u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public List<OnSwipeListener> f17823v;

    /* renamed from: com.didi.dimina.container.ui.swipeback.SwipeBackLayout$EdgeLevel */
    public enum EdgeLevel {
        MAX,
        MIN,
        MED
    }

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.didi.dimina.container.ui.swipeback.SwipeBackLayout$EdgeOrientation */
    public @interface EdgeOrientation {
    }

    /* renamed from: com.didi.dimina.container.ui.swipeback.SwipeBackLayout$OnSwipeListener */
    public interface OnSwipeListener {
        void onDragScrolled(float f);

        void onDragStateChange(int i);

        void onEdgeTouch(int i);

        void onPageFinish();
    }

    public SwipeBackLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public SwipeBackLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SwipeBackLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f17806e = 0.4f;
        this.f17810i = false;
        this.f17817p = new Rect();
        this.f17819r = true;
        this.f17821t = context;
        m13299a();
    }

    /* renamed from: a */
    private void m13299a() {
        this.f17807f = ViewDragHelper.create(this, new ViewDragCallback());
        setShadow((int) R.drawable.dimina_shadow_left, 1);
        setEdgeOrientation(1);
    }

    public void setScrollThresHold(float f) {
        if (f >= 1.0f || f <= 0.0f) {
            throw new IllegalArgumentException("Threshold value should be between 0 and 1.0");
        }
        this.f17806e = f;
    }

    public void setEdgeOrientation(int i) {
        this.f17818q = i;
        this.f17807f.setEdgeTrackingEnabled(i);
        if (i == 2 || i == 3) {
            setShadow((int) R.drawable.dinima_shadow_right, 2);
        }
    }

    public void setEdgeLevel(EdgeLevel edgeLevel) {
        this.f17822u = edgeLevel;
        m13300a(0, edgeLevel);
    }

    public void setEdgeLevel(int i) {
        m13300a(i, (EdgeLevel) null);
    }

    public EdgeLevel getEdgeLevel() {
        return this.f17822u;
    }

    /* renamed from: a */
    private void m13300a(int i, EdgeLevel edgeLevel) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) this.f17821t.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            Field declaredField = this.f17807f.getClass().getDeclaredField("mEdgeSize");
            declaredField.setAccessible(true);
            if (i != 0) {
                declaredField.setInt(this.f17807f, i);
            } else if (edgeLevel == EdgeLevel.MAX) {
                declaredField.setInt(this.f17807f, displayMetrics.widthPixels);
            } else if (edgeLevel == EdgeLevel.MED) {
                declaredField.setInt(this.f17807f, displayMetrics.widthPixels / 2);
            } else if (edgeLevel == EdgeLevel.MIN) {
                declaredField.setInt(this.f17807f, (int) ((displayMetrics.density * 20.0f) + 0.5f));
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        }
    }

    public void setShadow(Drawable drawable, int i) {
        if ((i & 1) != 0) {
            this.f17815n = drawable;
        } else if ((i & 2) != 0) {
            this.f17816o = drawable;
        }
        invalidate();
    }

    public void setShadow(int i, int i2) {
        setShadow(getResources().getDrawable(i), i2);
    }

    public void addSwipeListener(OnSwipeListener onSwipeListener) {
        if (this.f17823v == null) {
            this.f17823v = new ArrayList();
        }
        this.f17823v.add(onSwipeListener);
    }

    public void removeSwipeListener(OnSwipeListener onSwipeListener) {
        List<OnSwipeListener> list = this.f17823v;
        if (list != null) {
            list.remove(onSwipeListener);
        }
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j) {
        boolean z = view == this.f17812k;
        boolean drawChild = super.drawChild(canvas, view, j);
        if (z && this.f17809h > 0.0f && this.f17807f.getViewDragState() != 0) {
            m13301a(canvas, view);
            m13305b(canvas, view);
        }
        return drawChild;
    }

    /* renamed from: a */
    private void m13301a(Canvas canvas, View view) {
        Rect rect = this.f17817p;
        view.getGlobalVisibleRect(rect);
        int i = this.f17820s;
        if ((i & 1) != 0) {
            this.f17815n.setBounds(rect.left - this.f17815n.getIntrinsicWidth(), 0, rect.left, rect.bottom);
            this.f17815n.setAlpha((int) (this.f17809h * 255.0f));
            this.f17815n.draw(canvas);
        } else if ((i & 2) != 0) {
            this.f17816o.setBounds(rect.right, 0, rect.right + this.f17816o.getIntrinsicWidth(), rect.bottom);
            this.f17816o.setAlpha((int) (this.f17809h * 255.0f));
            this.f17816o.draw(canvas);
        }
    }

    /* renamed from: b */
    private void m13305b(Canvas canvas, View view) {
        int i = this.f17820s;
        if ((i & 1) != 0) {
            canvas.clipRect(0, 0, view.getLeft(), getHeight());
        } else if ((i & 2) != 0) {
            canvas.clipRect(view.getRight(), 0, getRight(), getHeight());
        }
        canvas.drawColor(0);
    }

    public void computeScroll() {
        float f = 1.0f - this.f17808g;
        this.f17809h = f;
        if (f >= 0.0f && this.f17807f.continueSettling(true)) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setFragment(SwipeBackFragment swipeBackFragment, View view) {
        this.f17813l = swipeBackFragment;
        this.f17812k = view;
    }

    public void hiddenPreView() {
        View view = this.f17814m;
        if (view != null) {
            m13302a(view, 1.0f);
        }
    }

    public void attachToActivity(FragmentActivity fragmentActivity) {
        this.f17811j = fragmentActivity;
        TypedArray obtainStyledAttributes = fragmentActivity.getTheme().obtainStyledAttributes(new int[]{16842836});
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        ViewGroup viewGroup = (ViewGroup) fragmentActivity.getWindow().getDecorView();
        ViewGroup viewGroup2 = (ViewGroup) viewGroup.getChildAt(0);
        viewGroup2.setBackgroundResource(resourceId);
        viewGroup.removeView(viewGroup2);
        addView(viewGroup2);
        setContentView(viewGroup2);
        viewGroup.addView(this);
    }

    public void attachToFragment(SwipeBackFragment swipeBackFragment, View view) {
        addView(view);
        setFragment(swipeBackFragment, view);
        View preView = getPreView();
        this.f17814m = preView;
        if (preView == null) {
            setEnableGesture(false);
        }
    }

    private void setContentView(View view) {
        this.f17812k = view;
    }

    public void setEnableGesture(boolean z) {
        this.f17819r = z;
    }

    /* renamed from: com.didi.dimina.container.ui.swipeback.SwipeBackLayout$ViewDragCallback */
    class ViewDragCallback extends ViewDragHelper.Callback {
        ViewDragCallback() {
        }

        public boolean tryCaptureView(View view, int i) {
            boolean isEdgeTouched = SwipeBackLayout.this.f17807f.isEdgeTouched(SwipeBackLayout.this.f17818q, i);
            if (isEdgeTouched) {
                if (SwipeBackLayout.this.f17807f.isEdgeTouched(1, i)) {
                    int unused = SwipeBackLayout.this.f17820s = 1;
                } else if (SwipeBackLayout.this.f17807f.isEdgeTouched(2, i)) {
                    int unused2 = SwipeBackLayout.this.f17820s = 2;
                }
                if (SwipeBackLayout.this.f17823v != null && !SwipeBackLayout.this.f17823v.isEmpty()) {
                    for (OnSwipeListener onEdgeTouch : SwipeBackLayout.this.f17823v) {
                        onEdgeTouch.onEdgeTouch(SwipeBackLayout.this.f17820s);
                    }
                }
            }
            return isEdgeTouched;
        }

        public int clampViewPositionHorizontal(View view, int i, int i2) {
            if ((SwipeBackLayout.this.f17820s & 1) != 0) {
                return Math.min(view.getWidth(), Math.max(i, 0));
            }
            if ((SwipeBackLayout.this.f17820s & 2) != 0) {
                return Math.min(0, Math.max(i, -view.getWidth()));
            }
            return 0;
        }

        public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
            super.onViewPositionChanged(view, i, i2, i3, i4);
            if ((SwipeBackLayout.this.f17820s & 1) != 0) {
                SwipeBackLayout swipeBackLayout = SwipeBackLayout.this;
                float unused = swipeBackLayout.f17808g = Math.abs(((float) i) / ((float) (swipeBackLayout.getWidth() + SwipeBackLayout.this.f17815n.getIntrinsicWidth())));
            } else if ((SwipeBackLayout.this.f17820s & 2) != 0) {
                SwipeBackLayout swipeBackLayout2 = SwipeBackLayout.this;
                float unused2 = swipeBackLayout2.f17808g = Math.abs(((float) i) / ((float) (swipeBackLayout2.f17812k.getWidth() + SwipeBackLayout.this.f17816o.getIntrinsicWidth())));
            }
            if (SwipeBackLayout.this.f17814m != null) {
                SwipeBackLayout swipeBackLayout3 = SwipeBackLayout.this;
                swipeBackLayout3.m13302a(swipeBackLayout3.f17814m, SwipeBackLayout.this.f17808g);
            }
            SwipeBackLayout.this.invalidate();
            if (SwipeBackLayout.this.f17823v != null && !SwipeBackLayout.this.f17823v.isEmpty() && SwipeBackLayout.this.f17807f.getViewDragState() == 1 && SwipeBackLayout.this.f17808g <= 1.0f && SwipeBackLayout.this.f17808g > 0.0f) {
                for (OnSwipeListener onDragScrolled : SwipeBackLayout.this.f17823v) {
                    onDragScrolled.onDragScrolled(SwipeBackLayout.this.f17808g);
                }
            }
            if (SwipeBackLayout.this.f17808g <= 1.0f) {
                return;
            }
            if (SwipeBackLayout.this.f17813l != null) {
                if (!SwipeBackLayout.this.f17813l.isDetached()) {
                    SwipeBackLayout.this.f17813l.f17798b = true;
                    if (SwipeBackLayout.this.f17813l.getView() != null) {
                        SwipeBackLayout.this.f17813l.getView().setVisibility(8);
                    }
                    for (OnSwipeListener onPageFinish : SwipeBackLayout.this.f17823v) {
                        onPageFinish.onPageFinish();
                    }
                    SwipeBackLayout.this.f17813l.f17798b = false;
                }
            } else if (!SwipeBackLayout.this.f17811j.isFinishing()) {
                SwipeBackLayout.this.f17811j.finish();
                SwipeBackLayout.this.f17811j.overridePendingTransition(0, 0);
            }
        }

        public int getViewHorizontalDragRange(View view) {
            if (SwipeBackLayout.this.f17813l != null) {
                return 1;
            }
            if (SwipeBackLayout.this.f17811j == null || !((SwipeBackActivity) SwipeBackLayout.this.f17811j).swipeBackPriority()) {
                return 0;
            }
            return 1;
        }

        public void onViewReleased(View view, float f, float f2) {
            int i;
            int width = view.getWidth();
            if ((SwipeBackLayout.this.f17820s & 1) != 0) {
                int i2 = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
                if (i2 > 0 || (i2 == 0 && SwipeBackLayout.this.f17808g > SwipeBackLayout.this.f17806e)) {
                    i = width + SwipeBackLayout.this.f17815n.getIntrinsicWidth() + 10;
                    LogUtil.m13410e("SwipeBackLayout", "onViewReleased: left = " + i + "  top = " + 0);
                    SwipeBackLayout.this.f17807f.settleCapturedViewAt(i, 0);
                    SwipeBackLayout.this.invalidate();
                }
            } else if ((SwipeBackLayout.this.f17820s & 2) != 0 && (f < 0.0f || (f == 0.0f && SwipeBackLayout.this.f17808g > SwipeBackLayout.this.f17806e))) {
                i = -(width + SwipeBackLayout.this.f17816o.getIntrinsicWidth() + 10);
                LogUtil.m13410e("SwipeBackLayout", "onViewReleased: left = " + i + "  top = " + 0);
                SwipeBackLayout.this.f17807f.settleCapturedViewAt(i, 0);
                SwipeBackLayout.this.invalidate();
            }
            i = 0;
            LogUtil.m13410e("SwipeBackLayout", "onViewReleased: left = " + i + "  top = " + 0);
            SwipeBackLayout.this.f17807f.settleCapturedViewAt(i, 0);
            SwipeBackLayout.this.invalidate();
        }

        public void onViewDragStateChanged(int i) {
            super.onViewDragStateChanged(i);
            if (SwipeBackLayout.this.f17823v != null && !SwipeBackLayout.this.f17823v.isEmpty()) {
                for (OnSwipeListener onDragStateChange : SwipeBackLayout.this.f17823v) {
                    onDragStateChange.onDragStateChange(i);
                }
            }
        }

        public void onEdgeTouched(int i, int i2) {
            super.onEdgeTouched(i, i2);
            if ((SwipeBackLayout.this.f17818q & i) != 0) {
                int unused = SwipeBackLayout.this.f17820s = i;
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.f17819r) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return this.f17807f.shouldInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f17819r) {
            return super.onTouchEvent(motionEvent);
        }
        this.f17807f.processTouchEvent(motionEvent);
        return true;
    }

    public void postBack() {
        if (this.f17819r) {
            this.f17820s = 1;
            this.f17807f.smoothSlideViewTo(this, getWidth() + this.f17815n.getIntrinsicWidth() + 10, 0);
            invalidate();
            return;
        }
        List<OnSwipeListener> list = this.f17823v;
        if (list != null) {
            for (OnSwipeListener onPageFinish : list) {
                onPageFinish.onPageFinish();
            }
        }
    }

    private View getPreView() {
        List<Fragment> fragments;
        View view = this.f17814m;
        if (view != null) {
            return view;
        }
        SwipeBackFragment swipeBackFragment = this.f17813l;
        if (swipeBackFragment == null || swipeBackFragment.getFragmentManager() == null || (fragments = this.f17813l.getFragmentManager().getFragments()) == null || fragments.size() <= 1) {
            return null;
        }
        for (int indexOf = fragments.indexOf(this.f17813l) - 1; indexOf >= 0; indexOf--) {
            Fragment fragment = fragments.get(indexOf);
            if (fragment != null && fragment.getView() != null && ((fragment instanceof SwipeBackFragment) || (fragment instanceof DMTabBarPageHostFragment))) {
                return fragment.getView();
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m13302a(View view, float f) {
        if (f <= 0.0f) {
            view.setVisibility(8);
        } else if (view.getVisibility() == 8) {
            view.setVisibility(0);
        }
        view.setTranslationX(((float) view.getWidth()) * 0.38200003f * (f - 1.0f));
    }
}
