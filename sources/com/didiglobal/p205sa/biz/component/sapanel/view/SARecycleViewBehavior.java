package com.didiglobal.p205sa.biz.component.sapanel.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.NestedScrollingChild;
import androidx.customview.widget.ViewDragHelper;
import com.didi.passenger.C10448R;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didichuxing.diface.utils.DisplayUtils;
import com.didichuxing.sdk.alphaface.utils.UIHandler;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.didiglobal.p205sa.biz.component.ComponentType;
import com.didiglobal.p205sa.biz.component.sapanel.PanelAnimatorMgr;
import com.didiglobal.p205sa.biz.component.sapanel.model.AnimationModel;
import com.didiglobal.p205sa.biz.component.sapanel.model.PageTouchEventManger;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.didiglobal.sa.biz.component.sapanel.view.SARecycleViewBehavior */
public class SARecycleViewBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    public static final int STATE_COLLAPSED = 4;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_EXPANDED = 3;

    /* renamed from: e */
    private static final int f51153e = 140;

    /* renamed from: a */
    private Logger f51154a = LoggerFactory.getLogger("SARecycleViewBehavior");
    /* access modifiers changed from: private */

    /* renamed from: b */
    public View f51155b;

    /* renamed from: c */
    private int f51156c;

    /* renamed from: d */
    private int f51157d;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f51158f = false;

    /* renamed from: g */
    private int f51159g;

    /* renamed from: h */
    private int f51160h;

    /* renamed from: i */
    private int f51161i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f51162j = true;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public int f51163k = 4;

    /* renamed from: l */
    private ViewDragHelper f51164l;

    /* renamed from: m */
    private boolean f51165m;

    /* renamed from: n */
    private int f51166n;

    /* renamed from: o */
    private boolean f51167o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public WeakReference<V> f51168p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public WeakReference<View> f51169q;

    /* renamed from: r */
    private VelocityTracker f51170r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public int f51171s;

    /* renamed from: t */
    private int f51172t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public boolean f51173u;

    /* renamed from: v */
    private final ViewDragHelper.Callback f51174v = new ViewDragHelper.Callback() {
        public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
        }

        public void onViewReleased(View view, float f, float f2) {
        }

        public boolean tryCaptureView(View view, int i) {
            if (SARecycleViewBehavior.this.f51163k == 1 || SARecycleViewBehavior.this.f51173u) {
                return false;
            }
            if (SARecycleViewBehavior.this.f51163k == 3 && SARecycleViewBehavior.this.f51171s == i) {
                View view2 = SARecycleViewBehavior.this.f51169q != null ? (View) SARecycleViewBehavior.this.f51169q.get() : null;
                if (view2 != null && view2.canScrollVertically(-1)) {
                    return false;
                }
            }
            if (SARecycleViewBehavior.this.f51168p == null || SARecycleViewBehavior.this.f51168p.get() != view) {
                return false;
            }
            return true;
        }

        public void onViewDragStateChanged(int i) {
            if (i == 1 && SARecycleViewBehavior.this.f51162j) {
                SARecycleViewBehavior.this.m36650a(1);
            }
        }
    };

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.didiglobal.sa.biz.component.sapanel.view.SARecycleViewBehavior$State */
    public @interface State {
    }

    public SARecycleViewBehavior() {
    }

    public SARecycleViewBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        context.obtainStyledAttributes(attributeSet, C10448R.styleable.BottomSheetBehavior_Layout).recycle();
        ViewConfiguration.get(context);
    }

    public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, V v) {
        return new SavedState(super.onSaveInstanceState(coordinatorLayout, v), this.f51163k);
    }

    public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(coordinatorLayout, v, savedState.getSuperState());
        if (savedState.state == 1) {
            this.f51163k = 4;
        } else {
            this.f51163k = savedState.state;
        }
    }

    public void onAttachedToLayoutParams(CoordinatorLayout.LayoutParams layoutParams) {
        super.onAttachedToLayoutParams(layoutParams);
        this.f51168p = null;
        this.f51164l = null;
    }

    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        this.f51168p = null;
        this.f51164l = null;
    }

    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v, int i) {
        View view;
        if (coordinatorLayout.getFitsSystemWindows() && !v.getFitsSystemWindows()) {
            v.setFitsSystemWindows(true);
        }
        if (this.f51168p == null) {
            this.f51168p = new WeakReference<>(v);
        }
        if (this.f51164l == null) {
            this.f51164l = ViewDragHelper.create(coordinatorLayout, this.f51174v);
        }
        coordinatorLayout.onLayoutChild(v, i);
        View childAt = ((ViewGroup) v).getChildAt(0);
        if (childAt != null && ComponentType.COMPONENT_RIDE_CARD.equals(childAt.getTag()) && ((view = this.f51155b) == null || childAt != view || (this.f51163k == 4 && this.f51156c != childAt.getHeight()))) {
            this.f51154a.info("onLayoutChild: change", new Object[0]);
            this.f51155b = childAt;
            if (childAt != null) {
                this.f51159g = childAt.getPaddingLeft();
                this.f51160h = this.f51155b.getPaddingRight();
                this.f51161i = this.f51155b.getPaddingTop();
                int height = this.f51155b.getHeight();
                this.f51156c = height;
                this.f51157d = height + 140;
            }
        }
        this.f51169q = new WeakReference<>(m36648a((View) v));
        return true;
    }

    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i, int i2) {
        this.f51166n = 0;
        this.f51167o = false;
        if ((i & 2) != 0) {
            return true;
        }
        return false;
    }

    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr, int i3) {
        if (i3 != 1) {
            if (this.f51158f) {
                iArr[1] = i2;
            } else if (i2 != 0 && this.f51155b != null && PageTouchEventManger.mapInFirstPosition && PageTouchEventManger.showMap) {
                WeakReference<View> weakReference = this.f51169q;
                if (view == (weakReference != null ? (View) weakReference.get() : null)) {
                    int height = this.f51155b.getHeight() - i2;
                    if (i2 > 0) {
                        if (height <= this.f51156c) {
                            m36650a(4);
                        } else if (this.f51162j) {
                            iArr[1] = i2;
                            m36650a(1);
                            resizeFirstChildHeight(i2);
                        } else {
                            return;
                        }
                    } else if (!view.canScrollVertically(-1) && height < DisplayUtils.getScreenHeight(v.getContext())) {
                        if (this.f51162j) {
                            iArr[1] = i2;
                            m36650a(1);
                            resizeFirstChildHeight(i2);
                            Logger logger = this.f51154a;
                            StringBuilder sb = new StringBuilder();
                            sb.append("onNestedPreScroll:pulldown: curH: ");
                            sb.append(this.f51155b.getHeight());
                            sb.append("-newHeight: ");
                            sb.append(height);
                            sb.append("-maxH: ");
                            sb.append(this.f51157d);
                            sb.append("-isExpand: ");
                            sb.append(height >= this.f51157d);
                            logger.info(sb.toString(), new Object[0]);
                            if (height >= this.f51157d) {
                                expandToRid(0);
                            }
                        } else {
                            return;
                        }
                    }
                    this.f51166n = i2;
                    this.f51167o = true;
                }
            }
        }
    }

    public void expandToRid(int i) {
        View view = this.f51155b;
        if (view != null && view.getContext() != null) {
            m36650a(3);
            View view2 = this.f51155b;
            PanelAnimatorMgr.valueAnimat(view2, view2.getHeight(), DisplayUtils.getScreenHeight(this.f51155b.getContext()) + 1000, 300, true, i, new PanelAnimatorMgr.AnimationListener() {
                public void onAnimationProcess(AnimationModel animationModel) {
                    boolean unused = SARecycleViewBehavior.this.f51158f = animationModel.getFraction() != 1.0f;
                    SARecycleViewBehavior.this.resizeViewPadding(1.0f - animationModel.getFraction());
                    int process = animationModel.getProcess();
                    SARecycleViewBehavior sARecycleViewBehavior = SARecycleViewBehavior.this;
                    sARecycleViewBehavior.resizeFirstChildHeight(sARecycleViewBehavior.f51155b.getHeight() - process);
                }
            });
        }
    }

    public void reverseAnimator() {
        View view = this.f51155b;
        if (view != null) {
            PanelAnimatorMgr.valueAnimat(view, view.getHeight(), this.f51156c, 300, false, -1, new PanelAnimatorMgr.AnimationListener() {
                public void onAnimationProcess(AnimationModel animationModel) {
                    int i = 1;
                    boolean unused = SARecycleViewBehavior.this.f51158f = animationModel.getFraction() != 1.0f;
                    SARecycleViewBehavior sARecycleViewBehavior = SARecycleViewBehavior.this;
                    if (animationModel.getFraction() == 1.0f) {
                        i = 4;
                    }
                    sARecycleViewBehavior.m36650a(i);
                    SARecycleViewBehavior.this.resizeViewPadding(animationModel.getFraction());
                    SARecycleViewBehavior sARecycleViewBehavior2 = SARecycleViewBehavior.this;
                    sARecycleViewBehavior2.resizeFirstChildHeight(sARecycleViewBehavior2.f51155b.getHeight() - animationModel.getProcess());
                    if (animationModel.getFraction() == 1.0f) {
                        UIHandler.post(new Runnable() {
                            public void run() {
                                if (SARecycleViewBehavior.this.f51155b != null) {
                                    ViewGroup.LayoutParams layoutParams = SARecycleViewBehavior.this.f51155b.getLayoutParams();
                                    layoutParams.height = -2;
                                    SARecycleViewBehavior.this.f51155b.setLayoutParams(layoutParams);
                                    SARecycleViewBehavior.this.f51155b.requestLayout();
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    public void resizeFirstChildHeight(int i) {
        View view = this.f51155b;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = this.f51155b.getHeight() - i;
            this.f51155b.setLayoutParams(layoutParams);
            this.f51155b.requestLayout();
        }
    }

    public void resizeViewPadding(float f) {
        View view = this.f51155b;
        if (view != null) {
            view.setPadding((int) (((float) this.f51159g) * f), (int) (((float) this.f51161i) * f), (int) (((float) this.f51160h) * f), view.getPaddingBottom());
        }
    }

    public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i) {
        if (PageTouchEventManger.mapInFirstPosition && PageTouchEventManger.showMap) {
            View view2 = this.f51155b;
            if (view2 == null) {
                this.f51154a.info("onStopNestedScroll: firstChild == null", new Object[0]);
            } else if (this.f51158f) {
                this.f51154a.info("onStopNestedScroll: doingAnimation", new Object[0]);
            } else if (view2.getHeight() == this.f51156c) {
                Logger logger = this.f51154a;
                logger.info("onStopNestedScroll: curHeight == firstChildDefaultHeight-" + this.f51156c, new Object[0]);
                m36650a(4);
            } else {
                WeakReference<View> weakReference = this.f51169q;
                if (weakReference != null && view == weakReference.get() && this.f51167o) {
                    if (m36652a()) {
                        ValueAnimator duration = ValueAnimator.ofInt(new int[]{this.f51155b.getHeight(), this.f51156c}).setDuration(400);
                        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                                int i = 1;
                                int i2 = (valueAnimator.getAnimatedFraction() > 1.0f ? 1 : (valueAnimator.getAnimatedFraction() == 1.0f ? 0 : -1));
                                boolean unused = SARecycleViewBehavior.this.f51158f = i2 != 0;
                                SARecycleViewBehavior sARecycleViewBehavior = SARecycleViewBehavior.this;
                                if (i2 == 0) {
                                    i = 4;
                                }
                                sARecycleViewBehavior.m36650a(i);
                                SARecycleViewBehavior sARecycleViewBehavior2 = SARecycleViewBehavior.this;
                                sARecycleViewBehavior2.resizeFirstChildHeight(sARecycleViewBehavior2.f51155b.getHeight() - intValue);
                            }
                        });
                        duration.start();
                        HashMap hashMap = new HashMap();
                        hashMap.put("type", 0);
                        hashMap.put("style", 4);
                        OmegaSDKAdapter.trackEvent("ibt_gp_sa_map_to_ridehome_ck", (Map<String, Object>) hashMap);
                    } else if (this.f51163k != 3) {
                        expandToRid(0);
                    }
                    this.f51167o = false;
                }
            }
        }
    }

    public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
        WeakReference<View> weakReference = this.f51169q;
        if (weakReference == null || view != weakReference.get()) {
            return false;
        }
        if (this.f51163k != 4 || super.onNestedPreFling(coordinatorLayout, v, view, f, f2)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m36650a(int i) {
        if (this.f51163k != i) {
            this.f51163k = i;
        }
    }

    public void reset() {
        this.f51171s = -1;
        VelocityTracker velocityTracker = this.f51170r;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f51170r = null;
        }
        this.f51155b = null;
    }

    /* renamed from: a */
    private boolean m36652a() {
        View view = this.f51155b;
        Logger logger = this.f51154a;
        StringBuilder sb = new StringBuilder();
        sb.append("shouldCollespe:-");
        sb.append(this.f51155b.getHeight());
        sb.append("-");
        sb.append(this.f51157d);
        sb.append("--");
        sb.append(view.getHeight() <= this.f51157d);
        logger.info(sb.toString(), new Object[0]);
        if (view.getHeight() <= this.f51157d) {
            return true;
        }
        return false;
    }

    /* renamed from: b */
    private boolean m36655b() {
        return this.f51155b.getHeight() > this.f51157d;
    }

    /* renamed from: a */
    private View m36648a(View view) {
        if (view instanceof NestedScrollingChild) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View a = m36648a(viewGroup.getChildAt(i));
            if (a != null) {
                return a;
            }
        }
        return null;
    }

    /* renamed from: com.didiglobal.sa.biz.component.sapanel.view.SARecycleViewBehavior$SavedState */
    protected static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        final int state;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.state = parcel.readInt();
        }

        public SavedState(Parcelable parcelable, int i) {
            super(parcelable);
            this.state = i;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.state);
        }
    }

    public static <V extends View> SARecycleViewBehavior<V> from(V v) {
        ViewGroup.LayoutParams layoutParams = v.getLayoutParams();
        if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior();
            if (behavior instanceof SARecycleViewBehavior) {
                return (SARecycleViewBehavior) behavior;
            }
            throw new IllegalArgumentException("The view is not associated with BottomSheetBehaviorGoogleMapsLike");
        }
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }
}
