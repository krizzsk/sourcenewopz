package com.didi.component.comp_selectseat.shiftselect;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.UiUtils;
import com.didi.component.common.AbsNormalFragment;
import com.didi.component.common.util.GLog;
import com.didi.component.comp_selectseat.activity.ShiftSelectActivity;
import com.didi.component.comp_selectseat.adapter.FrequencySelectCallBack;
import com.didi.component.comp_selectseat.adapter.RecycleViewScrollableListener;
import com.didi.component.comp_selectseat.adapter.ViewPagerAdapter;
import com.didi.component.comp_selectseat.model.ItemsBean;
import com.didi.component.comp_selectseat.model.ShiftBean;
import com.didi.component.core.PresenterGroup;
import com.didi.sdk.util.Utils;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShiftSelectFragment extends AbsNormalFragment implements View.OnClickListener, IShiftSelectView {

    /* renamed from: b */
    private static final String f12442b = "ShiftSelectFragment";

    /* renamed from: A */
    private final int f12443A = 3;

    /* renamed from: B */
    private AppBarLayout f12444B;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public final List<Boolean> f12445C = new ArrayList();

    /* renamed from: D */
    private final TabLayout.OnTabSelectedListener f12446D = new TabLayout.OnTabSelectedListener() {
        public void onTabReselected(TabLayout.Tab tab) {
        }

        public void onTabSelected(TabLayout.Tab tab) {
            ShiftSelectFragment.this.m8472a(tab, true);
        }

        public void onTabUnselected(TabLayout.Tab tab) {
            ShiftSelectFragment.this.m8472a(tab, false);
        }
    };

    /* renamed from: E */
    private final FrequencySelectCallBack f12447E = new FrequencySelectCallBack() {
        public void onFrequencySelectCallBack(ShiftBean shiftBean, boolean z) {
            if (z) {
                ShiftBean unused = ShiftSelectFragment.this.f12465p = shiftBean;
            } else {
                ShiftBean unused2 = ShiftSelectFragment.this.f12465p = null;
            }
            ShiftSelectFragment.this.f12460k.setEnabled(z);
        }
    };

    /* renamed from: F */
    private final ViewPager2.OnPageChangeCallback f12448F = new ViewPager2.OnPageChangeCallback() {
        public void onPageScrolled(int i, float f, int i2) {
            super.onPageScrolled(i, f, i2);
        }

        public void onPageSelected(int i) {
            super.onPageSelected(i);
            GLog.m7968e(ShiftSelectFragment.f12442b, "onPageSelected: " + i + " size== " + ShiftSelectFragment.this.f12445C.size());
            if (ShiftSelectFragment.this.f12445C.size() > 0 && i < ShiftSelectFragment.this.f12445C.size()) {
                ShiftSelectFragment shiftSelectFragment = ShiftSelectFragment.this;
                shiftSelectFragment.m8478b(((Boolean) shiftSelectFragment.f12445C.get(i)).booleanValue());
            }
        }

        public void onPageScrollStateChanged(int i) {
            super.onPageScrollStateChanged(i);
        }
    };

    /* renamed from: G */
    private final AppBarLayout.BaseOnOffsetChangedListener f12449G = new AppBarLayout.BaseOnOffsetChangedListener() {
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            int abs = Math.abs(i);
            int measuredHeight = ShiftSelectFragment.this.f12456g.getMeasuredHeight() + UiUtils.dip2px(ShiftSelectFragment.this.getContext(), 4.0f);
            GLog.m7972v(ShiftSelectFragment.f12442b, "mVerticalOffset= " + abs + " titleHeight= " + measuredHeight);
            if (abs < measuredHeight - 3 || measuredHeight == 0) {
                if (ShiftSelectFragment.this.f12472w == 2) {
                    int unused = ShiftSelectFragment.this.f12472w = 3;
                    ShiftSelectFragment.this.m8474a(false);
                }
            } else if (ShiftSelectFragment.this.f12472w == 0) {
                int unused2 = ShiftSelectFragment.this.f12472w = 1;
                ShiftSelectFragment.this.m8474a(true);
            }
        }
    };

    /* renamed from: H */
    private final RecycleViewScrollableListener f12450H = new RecycleViewScrollableListener() {
        public void updateScrollableList(int i, boolean z) {
            GLog.m7968e(ShiftSelectFragment.f12442b, "updateScrollableList: " + i + " scrollable== " + z + " size== " + ShiftSelectFragment.this.f12445C.size());
            if (i < ShiftSelectFragment.this.f12445C.size()) {
                ShiftSelectFragment.this.f12445C.set(i, Boolean.valueOf(z));
                ShiftSelectFragment.this.f12445C.set(i, Boolean.valueOf(z));
                ShiftSelectFragment.this.m8478b(z);
            }
        }
    };

    /* renamed from: a */
    private View f12451a;

    /* renamed from: c */
    private ImageView f12452c;

    /* renamed from: d */
    private ImageView f12453d;

    /* renamed from: e */
    private ImageView f12454e;

    /* renamed from: f */
    private TextView f12455f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public TextView f12456g;

    /* renamed from: h */
    private TextView f12457h;

    /* renamed from: i */
    private TextView f12458i;

    /* renamed from: j */
    private TabLayout f12459j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public TextView f12460k;

    /* renamed from: l */
    private ViewPager2 f12461l;

    /* renamed from: m */
    private ViewPagerAdapter f12462m;

    /* renamed from: n */
    private ShiftSelectTopPresenter f12463n;

    /* renamed from: o */
    private ShiftSelectActivity f12464o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public ShiftBean f12465p;

    /* renamed from: q */
    private LinearLayout f12466q;

    /* renamed from: r */
    private LinearLayout f12467r;

    /* renamed from: s */
    private LinearLayout f12468s;

    /* renamed from: t */
    private LinearLayout f12469t;

    /* renamed from: u */
    private CoordinatorLayout f12470u;

    /* renamed from: v */
    private ObjectAnimator f12471v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public int f12472w;

    /* renamed from: x */
    private final int f12473x = 0;

    /* renamed from: y */
    private final int f12474y = 1;

    /* renamed from: z */
    private final int f12475z = 2;

    /* access modifiers changed from: protected */
    public int currentPageId() {
        return 0;
    }

    public static ShiftSelectFragment newInstance(String str) {
        ShiftSelectFragment shiftSelectFragment = new ShiftSelectFragment();
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(str)) {
            bundle.putString("selectValueParams", str);
        } else {
            GLog.m7968e(f12442b, "newInstance()>> jsonObject is null ");
        }
        shiftSelectFragment.setArguments(bundle);
        return shiftSelectFragment;
    }

    /* access modifiers changed from: protected */
    public View onCreateViewImpl(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f12451a = layoutInflater.inflate(R.layout.shift_select_fragment, viewGroup, false);
        m8469a();
        return this.f12451a;
    }

    /* renamed from: a */
    private void m8469a() {
        ImageView imageView = (ImageView) this.f12451a.findViewById(R.id.btn_back);
        this.f12452c = imageView;
        imageView.setOnClickListener(this);
        this.f12455f = (TextView) this.f12451a.findViewById(R.id.tv_max_title);
        this.f12456g = (TextView) this.f12451a.findViewById(R.id.tv_min_title);
        this.f12457h = (TextView) this.f12451a.findViewById(R.id.tv_hint_info);
        TabLayout tabLayout = (TabLayout) this.f12451a.findViewById(R.id.rv_data);
        this.f12459j = tabLayout;
        tabLayout.addOnTabSelectedListener(this.f12446D);
        TextView textView = (TextView) this.f12451a.findViewById(R.id.btn_next);
        this.f12460k = textView;
        textView.setOnClickListener(this);
        this.f12460k.setEnabled(false);
        ViewPager2 viewPager2 = (ViewPager2) this.f12451a.findViewById(R.id.vp_frequency);
        this.f12461l = viewPager2;
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(viewPager2.getContext(), this.f12447E);
        this.f12462m = viewPagerAdapter;
        this.f12461l.setAdapter(viewPagerAdapter);
        this.f12461l.registerOnPageChangeCallback(this.f12448F);
        this.f12461l.setOffscreenPageLimit(-1);
        AppBarLayout appBarLayout = (AppBarLayout) this.f12451a.findViewById(R.id.appbar);
        this.f12444B = appBarLayout;
        appBarLayout.addOnOffsetChangedListener(this.f12449G);
        this.f12470u = (CoordinatorLayout) this.f12451a.findViewById(R.id.cl_content);
        ImageView imageView2 = (ImageView) this.f12451a.findViewById(R.id.btn_back_loading);
        this.f12453d = imageView2;
        imageView2.setOnClickListener(this);
        this.f12466q = (LinearLayout) this.f12451a.findViewById(R.id.ll_loading);
        this.f12467r = (LinearLayout) this.f12451a.findViewById(R.id.ll_net_error);
        ((Button) this.f12451a.findViewById(R.id.btn_retry)).setOnClickListener(this);
        ImageView imageView3 = (ImageView) this.f12451a.findViewById(R.id.btn_loading_error_back);
        this.f12454e = imageView3;
        imageView3.setOnClickListener(this);
        this.f12468s = (LinearLayout) this.f12451a.findViewById(R.id.ll_no_frequency);
        ((ImageView) this.f12451a.findViewById(R.id.no_frequency_btn_back)).setOnClickListener(this);
        this.f12458i = (TextView) this.f12451a.findViewById(R.id.tv_no_bus_title);
        this.f12469t = (LinearLayout) this.f12451a.findViewById(R.id.ll_bottom_content);
    }

    public void setDate(List<ItemsBean> list) {
        m8476b();
        m8473a(list);
        this.f12445C.clear();
        for (ItemsBean itemsBean : list) {
            if (itemsBean != null) {
                this.f12445C.add(false);
            }
        }
        this.f12462m.setRecycleViewSlidableListener(this.f12450H);
        this.f12462m.setDate(list);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.f12464o = (ShiftSelectActivity) context;
    }

    public void showLoadingErrorUi() {
        this.f12470u.setVisibility(8);
        this.f12469t.setVisibility(8);
        this.f12466q.setVisibility(8);
        this.f12467r.setVisibility(0);
        this.f12468s.setVisibility(8);
    }

    public void showNoBusLayout(String str) {
        this.f12470u.setVisibility(8);
        this.f12469t.setVisibility(8);
        this.f12466q.setVisibility(8);
        this.f12467r.setVisibility(8);
        this.f12468s.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            this.f12458i.setText(str);
        }
    }

    public void onDetach() {
        super.onDetach();
        this.f12464o = null;
        ObjectAnimator objectAnimator = this.f12471v;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.f12471v.cancel();
        }
    }

    public void setMaxTitle(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f12455f.setText(str);
            this.f12455f.setAlpha(0.0f);
        }
    }

    public void setMinTitle(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f12456g.setText(str);
        }
    }

    public void setHintInfo(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f12457h.setText(str);
        }
    }

    /* renamed from: a */
    private void m8473a(final List<ItemsBean> list) {
        new TabLayoutMediator(this.f12459j, this.f12461l, new TabLayoutMediator.TabConfigurationStrategy() {
            public void onConfigureTab(TabLayout.Tab tab, int i) {
                tab.setCustomView(ShiftSelectFragment.this.m8465a((ItemsBean) list.get(i)));
            }
        }).attach();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public View m8465a(ItemsBean itemsBean) {
        View inflate = LayoutInflater.from(this.f12459j.getContext()).inflate(R.layout.tablayout_item_view, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.iv_week);
        TextView textView2 = (TextView) inflate.findViewById(R.id.iv_date);
        if (itemsBean != null) {
            if (!TextUtils.isEmpty(itemsBean.title)) {
                textView.setText(itemsBean.title);
            } else {
                GLog.m7968e(f12442b, "makeTabLayoutItemView>> title is null ");
            }
            if (!TextUtils.isEmpty(itemsBean.content)) {
                textView2.setText(itemsBean.content);
            } else {
                GLog.m7968e(f12442b, "makeTabLayoutItemView>> content is null ");
            }
        } else {
            GLog.m7968e(f12442b, "makeTabLayoutItemView>> itemsBean is null ");
        }
        return inflate;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8472a(TabLayout.Tab tab, boolean z) {
        View customView = tab.getCustomView();
        if (customView != null) {
            TextView textView = (TextView) customView.findViewById(R.id.iv_week);
            TextView textView2 = (TextView) customView.findViewById(R.id.iv_date);
            Context context = getContext();
            if (context != null) {
                if (z) {
                    textView.setTextColor(context.getResources().getColor(R.color.tab_layout_text_selected_color));
                    textView2.setTextColor(context.getResources().getColor(R.color.tab_layout_text_selected_color));
                    return;
                }
                textView.setTextColor(context.getResources().getColor(R.color.tab_layout_text_unselected_color));
                textView2.setTextColor(context.getResources().getColor(R.color.tab_layout_text_unselected_color));
            }
        }
    }

    /* access modifiers changed from: protected */
    public PresenterGroup onCreateTopPresenter() {
        ShiftSelectTopPresenter shiftSelectTopPresenter = new ShiftSelectTopPresenter(getContext(), getArguments());
        this.f12463n = shiftSelectTopPresenter;
        return shiftSelectTopPresenter;
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        int id = view.getId();
        if (id == R.id.btn_next) {
            if (!Utils.isFastDoubleClick()) {
                this.f12463n.onConfirmBtnClick(this.f12465p);
                this.f12464o.clickConfirm();
            }
        } else if (id == R.id.btn_back_loading || id == R.id.btn_back || id == R.id.btn_loading_error_back || id == R.id.no_frequency_btn_back) {
            HashMap hashMap = new HashMap();
            hashMap.put("k", "click");
            GlobalOmegaUtils.trackEvent("ibt_gp_minibus_shift_return_ck", (Map<String, Object>) hashMap);
            this.f12464o.finish();
        } else if (id == R.id.btn_retry) {
            this.f12463n.PageRequest();
        }
    }

    /* renamed from: b */
    private void m8476b() {
        this.f12470u.setVisibility(0);
        this.f12469t.setVisibility(0);
        this.f12466q.setVisibility(8);
        this.f12467r.setVisibility(8);
        this.f12468s.setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8474a(boolean z) {
        if (z) {
            this.f12471v = ObjectAnimator.ofFloat(this.f12455f, "alpha", new float[]{0.0f, 1.0f});
        } else {
            this.f12471v = ObjectAnimator.ofFloat(this.f12455f, "alpha", new float[]{1.0f, 0.0f});
        }
        this.f12471v.setDuration(100);
        if (!this.f12471v.isRunning()) {
            this.f12471v.start();
        }
        this.f12471v.addListener(new Animator.AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
                GLog.m7965d(ShiftSelectFragment.f12442b, "onAnimationEnd:mNavigationBarTitleStatus=  " + ShiftSelectFragment.this.f12472w);
                if (ShiftSelectFragment.this.f12472w == 1) {
                    int unused = ShiftSelectFragment.this.f12472w = 2;
                } else if (ShiftSelectFragment.this.f12472w == 3) {
                    int unused2 = ShiftSelectFragment.this.f12472w = 0;
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m8478b(boolean z) {
        View childAt = this.f12444B.getChildAt(0);
        if (childAt.getLayoutParams() instanceof AppBarLayout.LayoutParams) {
            AppBarLayout.LayoutParams layoutParams = (AppBarLayout.LayoutParams) childAt.getLayoutParams();
            GLog.m7968e(f12442b, "setAppBarLayoutScrollFlags?>>: " + z);
            if (z) {
                layoutParams.setScrollFlags(3);
            } else {
                layoutParams.setScrollFlags(0);
            }
            childAt.setLayoutParams(layoutParams);
        }
    }
}
