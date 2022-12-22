package com.didi.payment.commonsdk.view.helper;

import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import androidx.core.text.TextUtilsCompat;
import androidx.core.view.GravityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Locale;

public class GravitySnapHelper extends LinearSnapHelper {
    public static final int FLING_DISTANCE_DISABLE = -1;
    public static final float FLING_SIZE_FRACTION_DISABLE = -1.0f;

    /* renamed from: a */
    private int f30217a;

    /* renamed from: b */
    private boolean f30218b;

    /* renamed from: c */
    private boolean f30219c;

    /* renamed from: d */
    private int f30220d;

    /* renamed from: e */
    private boolean f30221e;

    /* renamed from: f */
    private boolean f30222f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public float f30223g;

    /* renamed from: h */
    private int f30224h;

    /* renamed from: i */
    private float f30225i;

    /* renamed from: j */
    private OrientationHelper f30226j;

    /* renamed from: k */
    private OrientationHelper f30227k;

    /* renamed from: l */
    private SnapListener f30228l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public RecyclerView f30229m;

    /* renamed from: n */
    private RecyclerView.OnScrollListener f30230n;

    public interface SnapListener {
        void onSnap(int i);
    }

    public GravitySnapHelper(int i) {
        this(i, false, (SnapListener) null);
    }

    public GravitySnapHelper(int i, SnapListener snapListener) {
        this(i, false, snapListener);
    }

    public GravitySnapHelper(int i, boolean z) {
        this(i, z, (SnapListener) null);
    }

    public GravitySnapHelper(int i, boolean z, SnapListener snapListener) {
        this.f30221e = false;
        this.f30222f = false;
        this.f30223g = 100.0f;
        this.f30224h = -1;
        this.f30225i = -1.0f;
        this.f30230n = new RecyclerView.OnScrollListener() {
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                GravitySnapHelper.this.m21146a(i);
            }
        };
        if (i == 8388611 || i == 8388613 || i == 80 || i == 48 || i == 17) {
            this.f30219c = z;
            this.f30217a = i;
            this.f30228l = snapListener;
            return;
        }
        throw new IllegalArgumentException("Invalid gravity value. Use START | END | BOTTOM | TOP | CENTER constants");
    }

    public void attachToRecyclerView(RecyclerView recyclerView) throws IllegalStateException {
        RecyclerView recyclerView2 = this.f30229m;
        if (recyclerView2 != null) {
            recyclerView2.removeOnScrollListener(this.f30230n);
        }
        if (recyclerView != null) {
            recyclerView.setOnFlingListener((RecyclerView.OnFlingListener) null);
            int i = this.f30217a;
            if (i == 8388611 || i == 8388613) {
                boolean z = true;
                if (TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) != 1) {
                    z = false;
                }
                this.f30218b = z;
            }
            recyclerView.addOnScrollListener(this.f30230n);
            this.f30229m = recyclerView;
        } else {
            this.f30229m = null;
        }
        super.attachToRecyclerView(recyclerView);
    }

    public View findSnapView(RecyclerView.LayoutManager layoutManager) {
        return findSnapView(layoutManager, true);
    }

    public View findSnapView(RecyclerView.LayoutManager layoutManager, boolean z) {
        View view;
        int i = this.f30217a;
        if (i != 17) {
            if (i == 48) {
                view = m21143a(layoutManager, m21144a(layoutManager), GravityCompat.START, z);
            } else if (i == 80) {
                view = m21143a(layoutManager, m21144a(layoutManager), GravityCompat.END, z);
            } else if (i == 8388611) {
                view = m21143a(layoutManager, m21152b(layoutManager), GravityCompat.START, z);
            } else if (i != 8388613) {
                view = null;
            } else {
                view = m21143a(layoutManager, m21152b(layoutManager), GravityCompat.END, z);
            }
        } else if (layoutManager.canScrollHorizontally()) {
            view = m21143a(layoutManager, m21152b(layoutManager), 17, z);
        } else {
            view = m21143a(layoutManager, m21144a(layoutManager), 17, z);
        }
        if (view != null) {
            this.f30220d = this.f30229m.getChildAdapterPosition(view);
        } else {
            this.f30220d = -1;
        }
        return view;
    }

    public int[] calculateDistanceToFinalSnap(RecyclerView.LayoutManager layoutManager, View view) {
        if (this.f30217a == 17) {
            return super.calculateDistanceToFinalSnap(layoutManager, view);
        }
        int[] iArr = new int[2];
        if (!(layoutManager instanceof LinearLayoutManager)) {
            return iArr;
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        if (linearLayoutManager.canScrollHorizontally()) {
            if ((!this.f30218b || this.f30217a != 8388613) && (this.f30218b || this.f30217a != 8388611)) {
                iArr[0] = m21151b(view, m21152b((RecyclerView.LayoutManager) linearLayoutManager));
            } else {
                iArr[0] = m21142a(view, m21152b((RecyclerView.LayoutManager) linearLayoutManager));
            }
        } else if (linearLayoutManager.canScrollVertically()) {
            if (this.f30217a == 48) {
                iArr[1] = m21142a(view, m21144a((RecyclerView.LayoutManager) linearLayoutManager));
            } else {
                iArr[1] = m21151b(view, m21144a((RecyclerView.LayoutManager) linearLayoutManager));
            }
        }
        return iArr;
    }

    public int[] calculateScrollDistance(int i, int i2) {
        if (this.f30229m == null || ((this.f30226j == null && this.f30227k == null) || (this.f30224h == -1 && this.f30225i == -1.0f))) {
            return super.calculateScrollDistance(i, i2);
        }
        Scroller scroller = new Scroller(this.f30229m.getContext(), new DecelerateInterpolator());
        int a = m21141a();
        int i3 = -a;
        scroller.fling(0, 0, i, i2, i3, a, i3, a);
        return new int[]{scroller.getFinalX(), scroller.getFinalY()};
    }

    public RecyclerView.SmoothScroller createScroller(RecyclerView.LayoutManager layoutManager) {
        RecyclerView recyclerView;
        if (!(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) || (recyclerView = this.f30229m) == null) {
            return null;
        }
        return new LinearSmoothScroller(recyclerView.getContext()) {
            /* access modifiers changed from: protected */
            public void onTargetFound(View view, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
                if (GravitySnapHelper.this.f30229m != null && GravitySnapHelper.this.f30229m.getLayoutManager() != null) {
                    GravitySnapHelper gravitySnapHelper = GravitySnapHelper.this;
                    int[] calculateDistanceToFinalSnap = gravitySnapHelper.calculateDistanceToFinalSnap(gravitySnapHelper.f30229m.getLayoutManager(), view);
                    int i = calculateDistanceToFinalSnap[0];
                    int i2 = calculateDistanceToFinalSnap[1];
                    int calculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(i), Math.abs(i2)));
                    if (calculateTimeForDeceleration > 0) {
                        action.update(i, i2, calculateTimeForDeceleration, this.mDecelerateInterpolator);
                    }
                }
            }

            /* access modifiers changed from: protected */
            public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                return GravitySnapHelper.this.f30223g / ((float) displayMetrics.densityDpi);
            }
        };
    }

    public void setSnapListener(SnapListener snapListener) {
        this.f30228l = snapListener;
    }

    public void setGravity(int i, Boolean bool) {
        if (this.f30217a != i) {
            this.f30217a = i;
            updateSnap(bool, false);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000b, code lost:
        r0 = r2.f30229m.getLayoutManager();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void updateSnap(java.lang.Boolean r3, java.lang.Boolean r4) {
        /*
            r2 = this;
            androidx.recyclerview.widget.RecyclerView r0 = r2.f30229m
            if (r0 == 0) goto L_0x003a
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r0.getLayoutManager()
            if (r0 != 0) goto L_0x000b
            goto L_0x003a
        L_0x000b:
            androidx.recyclerview.widget.RecyclerView r0 = r2.f30229m
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r0.getLayoutManager()
            boolean r4 = r4.booleanValue()
            android.view.View r4 = r2.findSnapView(r0, r4)
            if (r4 == 0) goto L_0x003a
            int[] r4 = r2.calculateDistanceToFinalSnap(r0, r4)
            boolean r3 = r3.booleanValue()
            r0 = 1
            r1 = 0
            if (r3 == 0) goto L_0x0031
            androidx.recyclerview.widget.RecyclerView r3 = r2.f30229m
            r1 = r4[r1]
            r4 = r4[r0]
            r3.smoothScrollBy(r1, r4)
            goto L_0x003a
        L_0x0031:
            androidx.recyclerview.widget.RecyclerView r3 = r2.f30229m
            r1 = r4[r1]
            r4 = r4[r0]
            r3.scrollBy(r1, r4)
        L_0x003a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.commonsdk.view.helper.GravitySnapHelper.updateSnap(java.lang.Boolean, java.lang.Boolean):void");
    }

    public boolean scrollToPosition(int i) {
        if (i == -1) {
            return false;
        }
        return m21148a(i, false);
    }

    public boolean smoothScrollToPosition(int i) {
        if (i == -1) {
            return false;
        }
        return m21148a(i, true);
    }

    public int getGravity() {
        return this.f30217a;
    }

    public void setGravity(int i) {
        setGravity(i, true);
    }

    public boolean getSnapLastItem() {
        return this.f30219c;
    }

    public void setSnapLastItem(boolean z) {
        this.f30219c = z;
    }

    public int getMaxFlingDistance() {
        return this.f30224h;
    }

    public void setMaxFlingDistance(int i) {
        this.f30224h = i;
        this.f30225i = -1.0f;
    }

    public float getMaxFlingSizeFraction() {
        return this.f30225i;
    }

    public void setMaxFlingSizeFraction(float f) {
        this.f30224h = -1;
        this.f30225i = f;
    }

    public float getScrollMsPerInch() {
        return this.f30223g;
    }

    public void setScrollMsPerInch(float f) {
        this.f30223g = f;
    }

    public boolean getSnapToPadding() {
        return this.f30222f;
    }

    public void setSnapToPadding(boolean z) {
        this.f30222f = z;
    }

    public int getCurrentSnappedPosition() {
        View findSnapView;
        RecyclerView recyclerView = this.f30229m;
        if (recyclerView == null || recyclerView.getLayoutManager() == null || (findSnapView = findSnapView(this.f30229m.getLayoutManager())) == null) {
            return -1;
        }
        return this.f30229m.getChildAdapterPosition(findSnapView);
    }

    /* renamed from: a */
    private int m21141a() {
        float width;
        float f;
        if (this.f30225i != -1.0f) {
            if (this.f30226j != null) {
                width = (float) this.f30229m.getHeight();
                f = this.f30225i;
            } else if (this.f30227k == null) {
                return Integer.MAX_VALUE;
            } else {
                width = (float) this.f30229m.getWidth();
                f = this.f30225i;
            }
            return (int) (width * f);
        }
        int i = this.f30224h;
        if (i != -1) {
            return i;
        }
        return Integer.MAX_VALUE;
    }

    /* renamed from: a */
    private boolean m21148a(int i, boolean z) {
        if (this.f30229m.getLayoutManager() != null) {
            if (z) {
                RecyclerView.SmoothScroller createScroller = createScroller(this.f30229m.getLayoutManager());
                if (createScroller != null) {
                    createScroller.setTargetPosition(i);
                    this.f30229m.getLayoutManager().startSmoothScroll(createScroller);
                    return true;
                }
            } else {
                RecyclerView.ViewHolder findViewHolderForAdapterPosition = this.f30229m.findViewHolderForAdapterPosition(i);
                if (findViewHolderForAdapterPosition != null) {
                    int[] calculateDistanceToFinalSnap = calculateDistanceToFinalSnap(this.f30229m.getLayoutManager(), findViewHolderForAdapterPosition.itemView);
                    this.f30229m.scrollBy(calculateDistanceToFinalSnap[0], calculateDistanceToFinalSnap[1]);
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    private int m21142a(View view, OrientationHelper orientationHelper) {
        int i;
        int i2;
        if (!this.f30222f) {
            i2 = orientationHelper.getDecoratedStart(view);
            if (i2 < orientationHelper.getStartAfterPadding() / 2) {
                return i2;
            }
            i = orientationHelper.getStartAfterPadding();
        } else {
            i2 = orientationHelper.getDecoratedStart(view);
            i = orientationHelper.getStartAfterPadding();
        }
        return i2 - i;
    }

    /* renamed from: b */
    private int m21151b(View view, OrientationHelper orientationHelper) {
        int i;
        int i2;
        if (!this.f30222f) {
            int decoratedEnd = orientationHelper.getDecoratedEnd(view);
            if (decoratedEnd < orientationHelper.getEnd() - ((orientationHelper.getEnd() - orientationHelper.getEndAfterPadding()) / 2)) {
                return decoratedEnd - orientationHelper.getEndAfterPadding();
            }
            i2 = orientationHelper.getDecoratedEnd(view);
            i = orientationHelper.getEnd();
        } else {
            i2 = orientationHelper.getDecoratedEnd(view);
            i = orientationHelper.getEndAfterPadding();
        }
        return i2 - i;
    }

    /* renamed from: a */
    private View m21143a(RecyclerView.LayoutManager layoutManager, OrientationHelper orientationHelper, int i, boolean z) {
        int i2;
        int i3;
        View view = null;
        if (layoutManager.getChildCount() != 0 && (layoutManager instanceof LinearLayoutManager)) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            if (z && m21149a(linearLayoutManager) && !this.f30219c) {
                return null;
            }
            int i4 = Integer.MAX_VALUE;
            if (layoutManager.getClipToPadding()) {
                i2 = orientationHelper.getStartAfterPadding() + (orientationHelper.getTotalSpace() / 2);
            } else {
                i2 = orientationHelper.getEnd() / 2;
            }
            boolean z2 = true;
            boolean z3 = (i == 8388611 && !this.f30218b) || (i == 8388613 && this.f30218b);
            if ((i != 8388611 || !this.f30218b) && (i != 8388613 || this.f30218b)) {
                z2 = false;
            }
            for (int i5 = 0; i5 < linearLayoutManager.getChildCount(); i5++) {
                View childAt = linearLayoutManager.getChildAt(i5);
                if (z3) {
                    if (!this.f30222f) {
                        i3 = Math.abs(orientationHelper.getDecoratedStart(childAt));
                    } else {
                        i3 = Math.abs(orientationHelper.getStartAfterPadding() - orientationHelper.getDecoratedStart(childAt));
                    }
                } else if (!z2) {
                    i3 = Math.abs((orientationHelper.getDecoratedStart(childAt) + (orientationHelper.getDecoratedMeasurement(childAt) / 2)) - i2);
                } else if (!this.f30222f) {
                    i3 = Math.abs(orientationHelper.getDecoratedEnd(childAt) - orientationHelper.getEnd());
                } else {
                    i3 = Math.abs(orientationHelper.getEndAfterPadding() - orientationHelper.getDecoratedEnd(childAt));
                }
                if (i3 < i4) {
                    view = childAt;
                    i4 = i3;
                }
            }
        }
        return view;
    }

    /* renamed from: a */
    private boolean m21149a(LinearLayoutManager linearLayoutManager) {
        if ((linearLayoutManager.getReverseLayout() || this.f30217a != 8388611) && ((!linearLayoutManager.getReverseLayout() || this.f30217a != 8388613) && ((linearLayoutManager.getReverseLayout() || this.f30217a != 48) && (!linearLayoutManager.getReverseLayout() || this.f30217a != 80)))) {
            if (this.f30217a == 17) {
                if (linearLayoutManager.findFirstCompletelyVisibleItemPosition() == 0 || linearLayoutManager.findLastCompletelyVisibleItemPosition() == linearLayoutManager.getItemCount() - 1) {
                    return true;
                }
                return false;
            } else if (linearLayoutManager.findFirstCompletelyVisibleItemPosition() == 0) {
                return true;
            } else {
                return false;
            }
        } else if (linearLayoutManager.findLastCompletelyVisibleItemPosition() == linearLayoutManager.getItemCount() - 1) {
            return true;
        } else {
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m21146a(int i) {
        SnapListener snapListener;
        if (i == 0 && (snapListener = this.f30228l) != null && this.f30221e) {
            int i2 = this.f30220d;
            if (i2 != -1) {
                snapListener.onSnap(i2);
            } else {
                m21153b();
            }
        }
        this.f30221e = i != 0;
    }

    /* renamed from: b */
    private void m21153b() {
        View findSnapView;
        int childAdapterPosition;
        RecyclerView.LayoutManager layoutManager = this.f30229m.getLayoutManager();
        if (layoutManager != null && (findSnapView = findSnapView(layoutManager, false)) != null && (childAdapterPosition = this.f30229m.getChildAdapterPosition(findSnapView)) != -1) {
            this.f30228l.onSnap(childAdapterPosition);
        }
    }

    /* renamed from: a */
    private OrientationHelper m21144a(RecyclerView.LayoutManager layoutManager) {
        OrientationHelper orientationHelper = this.f30226j;
        if (orientationHelper == null || orientationHelper.getLayoutManager() != layoutManager) {
            this.f30226j = OrientationHelper.createVerticalHelper(layoutManager);
        }
        return this.f30226j;
    }

    /* renamed from: b */
    private OrientationHelper m21152b(RecyclerView.LayoutManager layoutManager) {
        OrientationHelper orientationHelper = this.f30227k;
        if (orientationHelper == null || orientationHelper.getLayoutManager() != layoutManager) {
            this.f30227k = OrientationHelper.createHorizontalHelper(layoutManager);
        }
        return this.f30227k;
    }
}
