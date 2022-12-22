package com.didi.rfusion.widget.tab;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.didi.rfusion.config.RFLogger;
import com.didi.rfusion.utils.RFDisplayUtils;
import com.didi.rfusion.utils.RFResUtils;
import com.didi.rfusion.widget.RFTextView;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class RFScroller extends HorizontalScrollView implements C11568a {

    /* renamed from: b */
    private static final int f33741b = 8;

    /* renamed from: a */
    private int f33742a;

    /* renamed from: c */
    private LinearLayout f33743c;

    /* renamed from: d */
    private View f33744d;

    /* renamed from: e */
    private int f33745e;

    /* renamed from: f */
    private int f33746f;

    /* renamed from: g */
    private boolean f33747g;

    /* renamed from: h */
    private View f33748h;

    /* renamed from: i */
    private int f33749i;

    /* renamed from: j */
    private int f33750j;

    /* renamed from: k */
    private int f33751k;

    /* renamed from: l */
    private RFTabAdapter f33752l;

    /* renamed from: m */
    private List<View> f33753m;

    /* renamed from: n */
    private List<Integer> f33754n;

    /* renamed from: o */
    private int f33755o;

    /* renamed from: p */
    private OnRFTabSelectedListener f33756p;

    /* renamed from: q */
    private OnRFTabFirstExposureListener f33757q;

    /* renamed from: r */
    private ViewTreeObserver.OnScrollChangedListener f33758r;

    /* renamed from: s */
    private OnScrollPositionChangeListener f33759s;

    /* renamed from: t */
    private ObjectAnimator f33760t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public boolean f33761u;

    public RFScroller(Context context) {
        this(context, (AttributeSet) null);
    }

    public RFScroller(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RFScroller(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f33742a = 1;
        this.f33747g = true;
        this.f33755o = -1;
        this.f33761u = false;
        m23756a(context);
    }

    public void setTabBarSpec(int i) {
        this.f33742a = i;
    }

    public void showDividerLine(boolean z) {
        this.f33748h.setVisibility(z ? 0 : 8);
    }

    public void setData(List<String> list) {
        setTabBarAdapter(new SimpleTabAdapter(getContext(), list));
    }

    public void setTabBarAdapter(RFTabAdapter rFTabAdapter) {
        if (!m23761a(rFTabAdapter)) {
            this.f33754n.clear();
            this.f33752l = rFTabAdapter;
            if (rFTabAdapter != null && rFTabAdapter.getItemCount() > 0) {
                int itemCount = rFTabAdapter.getItemCount();
                this.f33743c.removeAllViews();
                int i = 0;
                while (i < itemCount) {
                    m23759a(rFTabAdapter.getData(), rFTabAdapter.getItemView(), i, i == itemCount + -1);
                    i++;
                }
                m23752a();
            }
        }
    }

    public void selectTab(int i) {
        m23755a(i, false);
    }

    public void setOnTabSelectedListener(OnRFTabSelectedListener onRFTabSelectedListener) {
        this.f33756p = onRFTabSelectedListener;
    }

    public void setOnTabFirstExposureListener(OnRFTabFirstExposureListener onRFTabFirstExposureListener) {
        this.f33757q = onRFTabFirstExposureListener;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        ViewGroup viewGroup = (ViewGroup) getParent();
        this.f33750j = viewGroup.getPaddingLeft();
        this.f33751k = viewGroup.getPaddingRight();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnScrollChangedListener(this.f33758r);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnScrollChangedListener(this.f33758r);
    }

    /* access modifiers changed from: protected */
    public void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.onOverScrolled(i, i2, z, z2);
        int measuredWidth = getChildAt(0).getMeasuredWidth() - getMeasuredWidth();
        if (this.f33759s != null) {
            if (i == 0) {
                RFLogger.getLogger().debug("滑到最左");
                this.f33759s.onScrollToLeft();
            } else if (i == measuredWidth) {
                RFLogger.getLogger().debug("滑到最右");
                this.f33759s.onScrollToRight();
            } else {
                RFLogger.getLogger().debug("滑到中间");
                this.f33759s.onScrollToMiddle();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void setOnScrollPositionChangeListener(OnScrollPositionChangeListener onScrollPositionChangeListener) {
        this.f33759s = onScrollPositionChangeListener;
    }

    /* renamed from: a */
    private void m23756a(Context context) {
        this.f33753m = new ArrayList();
        this.f33754n = new ArrayList();
        this.f33749i = RFResUtils.getDimensionPixelSize(R.dimen.rf_dimen_56);
        setHorizontalScrollBarEnabled(false);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setMinimumWidth(RFDisplayUtils.getScreenWidth());
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        LinearLayout linearLayout2 = new LinearLayout(context);
        this.f33743c = linearLayout2;
        linearLayout2.setOrientation(0);
        this.f33743c.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        View view = new View(context);
        this.f33744d = view;
        view.setBackground(m23768d());
        this.f33745e = RFResUtils.getDimensionPixelSize(R.dimen.rf_dimen_6);
        this.f33746f = RFResUtils.getDimensionPixelSize(R.dimen.rf_dimen_68);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.f33746f, this.f33745e);
        layoutParams.topMargin = RFResUtils.getDimensionPixelSize(R.dimen.rf_dimen_20);
        this.f33744d.setLayoutParams(layoutParams);
        View view2 = new View(context);
        this.f33748h = view2;
        view2.setBackgroundColor(RFResUtils.getColor(R.color.rf_color_gery_5_90_E5E5E5));
        this.f33748h.setLayoutParams(new LinearLayout.LayoutParams(-1, RFResUtils.getDimensionPixelSize(R.dimen.rf_dimen_1)));
        linearLayout.addView(this.f33743c);
        linearLayout.addView(this.f33744d);
        linearLayout.addView(this.f33748h);
        addView(linearLayout);
        this.f33758r = new ViewTreeObserver.OnScrollChangedListener(new Rect()) {
            public final /* synthetic */ Rect f$1;

            {
                this.f$1 = r2;
            }

            public final void onScrollChanged() {
                RFScroller.this.m23757a(this.f$1);
            }
        };
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m23757a(Rect rect) {
        int childCount = this.f33743c.getChildCount();
        if (this.f33754n.size() < childCount) {
            for (int i = 0; i < childCount; i++) {
                if (!this.f33754n.contains(Integer.valueOf(i)) && this.f33743c.getChildAt(i).getLocalVisibleRect(rect)) {
                    this.f33754n.add(Integer.valueOf(i));
                    OnRFTabFirstExposureListener onRFTabFirstExposureListener = this.f33757q;
                    if (onRFTabFirstExposureListener != null) {
                        onRFTabFirstExposureListener.onTabFirstExposure(i);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m23752a() {
        m23755a(0, true);
    }

    /* renamed from: a */
    private void m23755a(int i, boolean z) {
        this.f33743c.post(new Runnable(i, z) {
            public final /* synthetic */ int f$1;
            public final /* synthetic */ boolean f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                RFScroller.this.m23767c(this.f$1, this.f$2);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m23767c(int i, boolean z) {
        List<View> list = this.f33753m;
        if (list != null && this.f33755o != i && i >= 0 && i < list.size()) {
            m23764b(i, z);
        }
    }

    /* renamed from: a */
    private void m23759a(List list, IRFTab iRFTab, int i, boolean z) {
        if (iRFTab instanceof View) {
            int i2 = 0;
            iRFTab.setSelectedState(false);
            iRFTab.setTabBarSpec(this.f33742a);
            iRFTab.bindData(list.get(i));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            if (!z) {
                i2 = this.f33749i;
            }
            layoutParams.rightMargin = i2;
            View view = (View) iRFTab;
            view.setLayoutParams(layoutParams);
            this.f33753m.add(view);
            this.f33743c.addView(view);
            view.setOnClickListener(new View.OnClickListener(i) {
                public final /* synthetic */ int f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    RFScroller.this.m23754a(this.f$1, view);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m23754a(int i, View view) {
        selectTab(i);
    }

    /* renamed from: b */
    private void m23764b(int i, boolean z) {
        m23763b(i);
        OnRFTabSelectedListener onRFTabSelectedListener = this.f33756p;
        if (onRFTabSelectedListener != null) {
            onRFTabSelectedListener.onTabSelected(i);
        }
        if (z) {
            m23762b();
            return;
        }
        m23766c(i);
        post(new Runnable(i) {
            public final /* synthetic */ int f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                RFScroller.this.m23769d(this.f$1);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m23769d(int i) {
        View view = this.f33753m.get(i);
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        smoothScrollBy((iArr[0] - this.f33749i) - (view.getWidth() / 3), 0);
    }

    /* renamed from: b */
    private void m23763b(int i) {
        int i2 = this.f33755o;
        if (i2 >= 0 && i2 < this.f33753m.size()) {
            ((IRFTab) this.f33753m.get(this.f33755o)).setSelectedState(false);
        }
        this.f33755o = i;
        if (i >= 0 && i < this.f33753m.size()) {
            ((IRFTab) this.f33753m.get(this.f33755o)).setSelectedState(true);
        }
    }

    /* renamed from: c */
    private void m23766c(int i) {
        m23765c();
        View view = this.f33753m.get(i);
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = this.f33744d.getLayoutParams();
            int width = (view.getWidth() - view.getPaddingLeft()) - view.getPaddingRight();
            Float valueOf = Float.valueOf(this.f33744d.getX());
            if (this.f33747g) {
                PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("translationX", new float[]{valueOf.floatValue(), Float.valueOf(((view.getX() + ((float) view.getPaddingLeft())) + (((float) width) / 2.0f)) - (((float) this.f33744d.getWidth()) / 2.0f)).floatValue()});
                this.f33760t = ObjectAnimator.ofPropertyValuesHolder(this.f33744d, new PropertyValuesHolder[]{ofFloat});
            } else {
                PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("translationX", new float[]{valueOf.floatValue(), Float.valueOf(view.getX() + ((float) view.getPaddingLeft()) + this.f33743c.getX()).floatValue()});
                PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt("", new int[]{layoutParams.width, width});
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.f33744d, new PropertyValuesHolder[]{ofInt, ofFloat2});
                this.f33760t = ofPropertyValuesHolder;
                ofPropertyValuesHolder.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(layoutParams) {
                    public final /* synthetic */ ViewGroup.LayoutParams f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        RFScroller.this.m23758a(this.f$1, valueAnimator);
                    }
                });
            }
            this.f33760t.addListener(new AnimatorListenerAdapter() {
                public void onAnimationStart(Animator animator) {
                    boolean unused = RFScroller.this.f33761u = true;
                }

                public void onAnimationEnd(Animator animator) {
                    boolean unused = RFScroller.this.f33761u = false;
                }
            });
            this.f33760t.setInterpolator(new FastOutSlowInInterpolator());
            this.f33760t.start();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m23758a(ViewGroup.LayoutParams layoutParams, ValueAnimator valueAnimator) {
        layoutParams.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.f33744d.setLayoutParams(layoutParams);
    }

    /* renamed from: b */
    private void m23762b() {
        List<View> list = this.f33753m;
        if (list != null) {
            View view = list.get(0);
            if (view != null) {
                int width = (view.getWidth() - view.getPaddingLeft()) - view.getPaddingRight();
                if (this.f33747g) {
                    float x = view.getX() + ((float) view.getPaddingLeft());
                    View view2 = this.f33744d;
                    view2.setX((x + (((float) width) / 2.0f)) - (((float) view2.getWidth()) / 2.0f));
                } else {
                    this.f33744d.setLayoutParams(new LinearLayout.LayoutParams(width, this.f33745e));
                    this.f33744d.setX((float) view.getPaddingLeft());
                }
            }
            scrollTo(0, 0);
        }
    }

    /* renamed from: c */
    private void m23765c() {
        ObjectAnimator objectAnimator;
        if (this.f33761u && (objectAnimator = this.f33760t) != null) {
            objectAnimator.cancel();
        }
    }

    /* renamed from: d */
    private Drawable m23768d() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(RFResUtils.getColor(R.color.rf_color_gery_1_0_000000));
        gradientDrawable.setCornerRadius((float) RFResUtils.getDimensionPixelSize(R.dimen.rf_dimen_3));
        return gradientDrawable;
    }

    /* renamed from: a */
    private boolean m23761a(RFTabAdapter rFTabAdapter) {
        RFTabAdapter rFTabAdapter2 = this.f33752l;
        if (rFTabAdapter2 == null || rFTabAdapter2.getData() == null || rFTabAdapter.getItemCount() != this.f33752l.getItemCount()) {
            return false;
        }
        if (rFTabAdapter.getData() == null) {
            return true;
        }
        return this.f33752l.getData().equals(rFTabAdapter.getData());
    }

    public static final class SimpleTab extends RFTextView implements IRFTab<String> {
        public SimpleTab(Context context) {
            this(context, (AttributeSet) null);
        }

        public SimpleTab(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, 0);
        }

        public SimpleTab(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            init();
        }

        private void init() {
            setPadding(0, RFResUtils.getDimensionPixelSize(R.dimen.rf_dimen_40), 0, 0);
            setTabBarSpec(1);
        }

        public void setSelectedState(boolean z) {
            if (z) {
                setTextColor(RFResUtils.getColor(R.color.rf_color_gery_1_0_000000));
                setTypeface(1);
                return;
            }
            setTextColor(RFResUtils.getColor(R.color.rf_color_gery_3_60_999999));
            setTypeface(0);
        }

        public void bindData(String str) {
            if (!TextUtils.isEmpty(str)) {
                if (str.length() > 8) {
                    str = str.substring(0, 8);
                }
                setText(str);
            }
        }

        public void setTabBarSpec(int i) {
            if (i == 1) {
                setTextSize(0, (float) RFResUtils.getDimensionPixelSize(R.dimen.f_07_app_36_pad_24));
            } else {
                setTextSize(0, (float) RFResUtils.getDimensionPixelSize(R.dimen.f_10_app_28_pad_16));
            }
        }
    }

    public static final class SimpleTabAdapter extends RFTabAdapter<String> {
        private final List<String> mData;

        public SimpleTabAdapter(Context context, List<String> list) {
            super(context);
            this.mData = list;
        }

        public IRFTab<String> getItemView() {
            return new SimpleTab(getContext());
        }

        public int getItemCount() {
            if (getData() == null) {
                return 0;
            }
            return getData().size();
        }

        public List<String> getData() {
            return this.mData;
        }
    }

    static abstract class OnScrollPositionChangeListener {
        /* access modifiers changed from: package-private */
        public void onScrollToLeft() {
        }

        /* access modifiers changed from: package-private */
        public void onScrollToMiddle() {
        }

        /* access modifiers changed from: package-private */
        public void onScrollToRight() {
        }

        OnScrollPositionChangeListener() {
        }
    }
}
