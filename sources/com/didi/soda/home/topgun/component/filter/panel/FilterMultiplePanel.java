package com.didi.soda.home.topgun.component.filter.panel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.legacy.widget.Space;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.widget.support.CustomerAppCompatTextView;
import com.didi.soda.home.topgun.component.filter.FilterDataManager;
import com.didi.soda.home.topgun.component.filter.module.AbsFilterModule;
import com.didi.soda.home.topgun.component.filter.module.CommonFilterModule;
import com.didi.soda.home.topgun.component.filter.module.FlowFilterModule;
import com.didi.soda.home.topgun.component.filter.module.SingleLineWithIconFilterModule;
import com.didi.soda.home.topgun.component.topicact.TopicActOmegaHelper;
import com.didi.soda.home.topgun.manager.HomeOmegaHelper;
import com.didi.soda.home.topgun.model.FilterItemParam;
import com.didi.soda.home.topgun.model.FilterModel;
import com.didi.soda.home.topgun.widget.HasListenerScollView;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

public class FilterMultiplePanel extends FilterPanel implements View.OnClickListener {
    public static final int MULTIPLE_SHOW_TYPE = 3;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public LinearLayout f42864a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public HasListenerScollView f42865b;

    /* renamed from: c */
    private List<AbsFilterModule> f42866c = new ArrayList();

    /* renamed from: d */
    private CustomerAppCompatTextView f42867d;

    /* renamed from: e */
    private CustomerAppCompatTextView f42868e;

    /* renamed from: f */
    private ConstraintLayout f42869f;

    /* renamed from: g */
    private View f42870g;

    /* renamed from: h */
    private View f42871h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public boolean f42872i = true;

    /* renamed from: j */
    private int f42873j = 1;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public List<AbsFilterModule.MoudleAppearListener> f42874k = new ArrayList();

    /* renamed from: l */
    private List<AbsFilterModule.MoudleAppearListener> f42875l = new ArrayList();

    public FilterMultiplePanel(Context context) {
        super(context);
    }

    public View createRootView(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.customer_widget_home_filter_mul_panel, (ViewGroup) null);
        this.f42864a = (LinearLayout) inflate.findViewById(R.id.customer_ll_filter_mul_panel_container);
        this.f42865b = (HasListenerScollView) inflate.findViewById(R.id.customer_ll_filter_mul_panel_scroll);
        this.f42869f = (ConstraintLayout) inflate.findViewById(R.id.customer_ll_filter_mul_panel_bottom);
        this.f42867d = (CustomerAppCompatTextView) inflate.findViewById(R.id.customer_tv_home_filter_reset);
        this.f42868e = (CustomerAppCompatTextView) inflate.findViewById(R.id.customer_tv_home_filter_confirm);
        this.f42870g = inflate.findViewById(R.id.customer_tv_home_filter_marker);
        this.f42871h = inflate.findViewById(R.id.customer_tv_home_single_filter_confirm);
        this.f42867d.setOnClickListener(this);
        this.f42868e.setOnClickListener(this);
        this.f42871h.setOnClickListener(this);
        this.f42868e.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 0) {
                    return false;
                }
                CustomerSystemUtil.virate(view.getContext());
                return false;
            }
        });
        this.f42865b.setOnScrollChangeListener(new HasListenerScollView.OnScrollChangeListener() {
            public void onScrollChanged(int i, int i2, int i3, int i4) {
                if (FilterMultiplePanel.this.f42872i) {
                    FilterMultiplePanel.this.f42874k.clear();
                    FilterMultiplePanel filterMultiplePanel = FilterMultiplePanel.this;
                    filterMultiplePanel.m30323a((ViewGroup) filterMultiplePanel.f42864a, 1);
                    boolean unused = FilterMultiplePanel.this.f42872i = false;
                }
                FilterMultiplePanel.this.m30321a();
            }
        });
        return inflate;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m30323a(ViewGroup viewGroup, int i) {
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt instanceof AbsFilterModule.MoudleAppearListener) {
                this.f42874k.add((AbsFilterModule.MoudleAppearListener) childAt);
            }
            if ((childAt instanceof ViewGroup) && i <= this.f42873j) {
                m30323a((ViewGroup) childAt, i + 1);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m30321a() {
        if (getFilterModel().mShowType == 4) {
            int[] iArr = new int[2];
            this.f42865b.getLocationOnScreen(iArr);
            int i = iArr[1];
            int height = ((this.f42865b.getHeight() + i) - ResourceHelper.getDimensionPixelSize(R.dimen.customer_68px)) - this.f42865b.getPaddingBottom();
            for (AbsFilterModule.MoudleAppearListener next : this.f42874k) {
                int[] iArr2 = new int[2];
                ((View) next).getLocationOnScreen(iArr2);
                int i2 = iArr2[1];
                if (i2 < i || i2 > height) {
                    this.f42875l.remove(next);
                } else if (!this.f42875l.contains(next)) {
                    next.onMoudleAppear();
                    this.f42875l.add(next);
                }
            }
        }
    }

    public void bindData(FilterModel filterModel) {
        AbsFilterModule absFilterModule;
        super.bindData(filterModel);
        this.f42864a.removeAllViews();
        this.f42866c.clear();
        int size = filterModel.mFilterComponent.size();
        int i = 0;
        while (true) {
            boolean z = true;
            if (i >= size) {
                break;
            }
            FilterModel.FilterComponentModel filterComponentModel = filterModel.mFilterComponent.get(i);
            if (filterComponentModel != null) {
                if (filterComponentModel.mType == 1) {
                    absFilterModule = new SingleLineWithIconFilterModule(this.f42864a, this.mFromScene);
                } else if (filterComponentModel.mColNum == -1) {
                    absFilterModule = new FlowFilterModule(this.f42864a, this.mFromScene);
                    absFilterModule.setMOnSWFilterItemListener(new Function2<FilterModel.FilterItemRvModel, Boolean, Unit>() {
                        public Unit invoke(FilterModel.FilterItemRvModel filterItemRvModel, Boolean bool) {
                            TopicActOmegaHelper instance = TopicActOmegaHelper.Companion.getInstance();
                            instance.headerFilterTopicCatesItemSW(FilterMultiplePanel.this.mTopicFromScence + "", FilterMultiplePanel.this.mTimePeriod, filterItemRvModel.mId);
                            return null;
                        }
                    });
                } else {
                    absFilterModule = new CommonFilterModule(this.f42864a, this.mFromScene);
                }
                boolean z2 = size < 2;
                if (i != 0) {
                    z = false;
                }
                absFilterModule.bindModuleOnPanel(z2, z, filterComponentModel, new Function2(filterModel) {
                    public final /* synthetic */ FilterModel f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final Object invoke(Object obj, Object obj2) {
                        return FilterMultiplePanel.this.m30320a(this.f$1, (FilterModel.FilterItemRvModel) obj, (Boolean) obj2);
                    }
                });
                this.f42866c.add(absFilterModule);
            }
            i++;
        }
        if (filterModel.mShowType == 4) {
            this.f42869f.setVisibility(0);
            this.f42871h.setVisibility(8);
            this.f42870g.setVisibility(0);
            this.f42865b.setPadding(0, 0, 0, DisplayUtils.dip2px(this.f42864a.getContext(), 58.0f));
            m30322a((ViewGroup) this.f42864a);
        } else if (filterModel.mShowType == 1) {
            this.f42869f.setVisibility(8);
            this.f42871h.setVisibility(8);
            this.f42870g.setVisibility(8);
            this.f42865b.setPadding(0, 0, 0, 0);
        } else if (filterModel.mShowType == 7) {
            this.f42869f.setVisibility(8);
            if (filterModel.showConfirmBtn == 1) {
                this.f42871h.setVisibility(0);
            } else {
                this.f42871h.setVisibility(8);
            }
        } else {
            this.f42869f.setVisibility(8);
            this.f42871h.setVisibility(0);
            this.f42870g.setVisibility(8);
            this.f42865b.setPadding(0, 0, 0, 0);
        }
        m30325a(filterModel);
        this.f42865b.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                FilterMultiplePanel filterMultiplePanel = FilterMultiplePanel.this;
                filterMultiplePanel.m30323a((ViewGroup) filterMultiplePanel.f42864a, 1);
                FilterMultiplePanel.this.m30321a();
                FilterMultiplePanel.this.f42865b.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ Unit m30320a(FilterModel filterModel, FilterModel.FilterItemRvModel filterItemRvModel, Boolean bool) {
        boolean z = false;
        if (filterModel.mShowType == 4 || (filterModel.mShowType == 7 && filterModel.showConfirmBtn == 1)) {
            z = true;
        }
        if (z) {
            m30329b();
        } else {
            m30332d();
        }
        TopicActOmegaHelper instance = TopicActOmegaHelper.Companion.getInstance();
        instance.headerFilterTopicCatesItemCK(this.mTopicFromScence + "", this.mTimePeriod, filterItemRvModel.mId);
        return Unit.INSTANCE;
    }

    public void onClick(View view) {
        if (view.getId() == R.id.customer_tv_home_filter_reset) {
            m30331c();
        } else if (view.getId() == R.id.customer_tv_home_filter_confirm || view.getId() == R.id.customer_tv_home_single_filter_confirm) {
            m30332d();
        }
    }

    /* renamed from: a */
    private void m30322a(ViewGroup viewGroup) {
        viewGroup.addView(new Space(viewGroup.getContext()), new LinearLayout.LayoutParams(0, DisplayUtils.dip2px(viewGroup.getContext(), 21.0f)));
    }

    /* renamed from: a */
    private void m30325a(FilterModel filterModel) {
        if (!filterModel.isOriginal()) {
            this.f42867d.setEnabled(true);
        } else {
            this.f42867d.setEnabled(false);
        }
    }

    /* renamed from: b */
    private void m30329b() {
        boolean z;
        Iterator<AbsFilterModule> it = this.f42866c.iterator();
        while (true) {
            if (it.hasNext()) {
                if (!it.next().isOriginal()) {
                    z = false;
                    break;
                }
            } else {
                z = true;
                break;
            }
        }
        this.f42867d.setEnabled(!z);
    }

    /* renamed from: c */
    private void m30331c() {
        for (AbsFilterModule resetFilterModule : this.f42866c) {
            resetFilterModule.resetFilterModule();
        }
        if (!getFilterModel().isOriginal()) {
            getFilterModel().reset();
        }
        doConfirm(true, true);
        HomeOmegaHelper.getInstance().trackMulFilterRest();
    }

    /* renamed from: d */
    private void m30332d() {
        for (AbsFilterModule confirmFilterModule : this.f42866c) {
            confirmFilterModule.confirmFilterModule();
        }
        doConfirm(true, false);
        FilterDataManager instanceByScene = FilterDataManager.Companion.getInstanceByScene(this.mFromScene);
        ArrayList<FilterItemParam> generateGroupOutParams = instanceByScene.generateGroupOutParams(getFilterModel());
        if (getFilterModel().mShowType == 4) {
            HomeOmegaHelper.getInstance().trackFilterMulConfirm(generateGroupOutParams, this.mFromScene, instanceByScene.getMCateId());
        } else if (getFilterModel().mShowType == 1) {
            HomeOmegaHelper.getInstance().trackFilterSortConfirm(generateGroupOutParams, this.mFromScene, instanceByScene.getMCateId());
        } else {
            HomeOmegaHelper.getInstance().traceOutsideConfirmCK(generateGroupOutParams, (getFilterModel().mFilterComponent == null || getFilterModel().mFilterComponent.isEmpty()) ? "" : String.valueOf(getFilterModel().mFilterComponent.get(0).mType), this.mFromScene);
        }
    }
}
