package com.didiglobal.p205sa.biz.component.activity.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.drouter.api.DRouter;
import com.didi.global.globaluikit.utils.UiUtils;
import com.didi.sdk.util.AppUtils;
import com.didi.sdk.util.NetUtil;
import com.didiglobal.p205sa.biz.component.activity.ActivityRecAdapter;
import com.didiglobal.p205sa.biz.component.activity.model.ActivityProperty;
import com.didiglobal.p205sa.biz.component.activity.omega.ActivityOmegaTracker;
import com.didiglobal.p205sa.biz.component.activity.presenter.IActivityPresenter;
import com.didiglobal.p205sa.biz.weight.tkrefreshlayout.RefreshListenerAdapter;
import com.didiglobal.p205sa.biz.weight.tkrefreshlayout.TwinklingRefreshLayout;
import com.taxis99.R;
import java.util.List;

/* renamed from: com.didiglobal.sa.biz.component.activity.view.ActivityRecyclerView */
public class ActivityRecyclerView implements IActivityPanelView {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Context f50765a;

    /* renamed from: b */
    private View f50766b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public View f50767c;

    /* renamed from: d */
    private ActivityRecAdapter f50768d;

    /* renamed from: e */
    private ViewStub f50769e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f50770f = 0;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f50771g = 0;

    /* renamed from: h */
    private View f50772h;

    /* renamed from: i */
    private TwinklingRefreshLayout f50773i;

    /* renamed from: j */
    private View f50774j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public IActivityPresenter f50775k;

    /* renamed from: l */
    private View f50776l;

    /* renamed from: a */
    static /* synthetic */ int m36456a(ActivityRecyclerView activityRecyclerView, int i) {
        int i2 = activityRecyclerView.f50770f + i;
        activityRecyclerView.f50770f = i2;
        return i2;
    }

    public ActivityRecyclerView(Context context) {
        this.f50765a = context;
        m36457a();
    }

    /* renamed from: a */
    private void m36457a() {
        View inflate = LayoutInflater.from(this.f50765a).inflate(R.layout.activity_component_panel_recyclerview, (ViewGroup) null, false);
        this.f50766b = inflate;
        this.f50769e = (ViewStub) inflate.findViewById(R.id.empty_container);
        this.f50774j = this.f50766b.findViewById(R.id.activity_loading);
        this.f50776l = this.f50766b.findViewById(R.id.subtitle);
        this.f50774j.setVisibility(0);
        RecyclerView recyclerView = (RecyclerView) this.f50766b.findViewById(R.id.activity_panel_view);
        this.f50767c = this.f50766b.findViewById(R.id.activity_title_container);
        final TextView textView = (TextView) this.f50766b.findViewById(R.id.title);
        this.f50773i = (TwinklingRefreshLayout) this.f50766b.findViewById(R.id.activity_refresh_layout);
        final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f50767c.getLayoutParams();
        layoutParams.height += AppUtils.getStatusBarHeight(this.f50765a);
        this.f50776l.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                DRouter.build("GlobalOneTravel://one/history").start();
                ActivityOmegaTracker.OmegaHistoryClick();
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        ActivityRecAdapter activityRecAdapter = new ActivityRecAdapter(this.f50765a);
        this.f50768d = activityRecAdapter;
        recyclerView.setAdapter(activityRecAdapter);
        final int dip2px = UiUtils.dip2px(this.f50765a, 20.0f);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                ActivityRecyclerView.m36456a(ActivityRecyclerView.this, i2);
                if (ActivityRecyclerView.this.f50770f < dip2px) {
                    if (layoutParams.height != UiUtils.dip2px(ActivityRecyclerView.this.f50765a, 72.0f) + AppUtils.getStatusBarHeight(ActivityRecyclerView.this.f50765a)) {
                        ActivityRecyclerView.this.f50767c.setBackgroundColor(ActivityRecyclerView.this.f50765a.getResources().getColor(R.color.sa_activity_bgcolor));
                        textView.setTextSize(2, 24.0f);
                        layoutParams.height = UiUtils.dip2px(ActivityRecyclerView.this.f50765a, 72.0f) + AppUtils.getStatusBarHeight(ActivityRecyclerView.this.f50765a);
                        ActivityRecyclerView.this.f50767c.requestLayout();
                    }
                    View c = ActivityRecyclerView.this.f50767c;
                    float f = 0.0f;
                    if (1.0f - ((((float) ActivityRecyclerView.this.f50770f) * 1.0f) / ((float) dip2px)) >= 0.0f) {
                        f = 1.0f - ((((float) ActivityRecyclerView.this.f50770f) * 1.0f) / ((float) dip2px));
                    }
                    c.setAlpha(f);
                } else if (ActivityRecyclerView.this.f50770f < dip2px * 2) {
                    if (layoutParams.height != UiUtils.dip2px(ActivityRecyclerView.this.f50765a, 52.0f) + AppUtils.getStatusBarHeight(ActivityRecyclerView.this.f50765a)) {
                        ActivityRecyclerView.this.f50767c.setBackgroundColor(-1);
                        textView.setTextSize(2, 20.0f);
                        layoutParams.height = UiUtils.dip2px(ActivityRecyclerView.this.f50765a, 52.0f) + AppUtils.getStatusBarHeight(ActivityRecyclerView.this.f50765a);
                        ActivityRecyclerView.this.f50767c.requestLayout();
                    }
                    View c2 = ActivityRecyclerView.this.f50767c;
                    int a = ActivityRecyclerView.this.f50770f;
                    int i3 = dip2px;
                    c2.setAlpha((((float) (a - i3)) * 1.0f) / ((float) i3));
                } else if (ActivityRecyclerView.this.f50770f > dip2px * 2) {
                    ActivityRecyclerView.this.f50767c.setAlpha(1.0f);
                }
            }

            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0) {
                    ActivityOmegaTracker.OmegaActivitySlide(ActivityRecyclerView.this.f50770f - ActivityRecyclerView.this.f50771g > 0 ? "up" : "down");
                    ActivityRecyclerView activityRecyclerView = ActivityRecyclerView.this;
                    int unused = activityRecyclerView.f50771g = activityRecyclerView.f50770f;
                }
            }
        });
        this.f50773i.setOnRefreshListener(new RefreshListenerAdapter() {
            public void onRefresh(TwinklingRefreshLayout twinklingRefreshLayout) {
                if (ActivityRecyclerView.this.f50775k != null && ActivityRecyclerView.this.m36461b()) {
                    ActivityRecyclerView.this.f50775k.requestRefresh();
                }
            }

            public void onLoadMore(TwinklingRefreshLayout twinklingRefreshLayout) {
                if (ActivityRecyclerView.this.f50775k != null && ActivityRecyclerView.this.m36461b()) {
                    ActivityRecyclerView.this.f50775k.requestLoadMore();
                }
            }
        });
        this.f50768d.addHeader(new ActivityEmptyHeader(this.f50765a));
        this.f50773i.setBottomView(new ActivityLoadMore(this.f50765a));
        this.f50773i.setHeaderView(new ActivityRefreshView(this.f50765a));
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public boolean m36461b() {
        boolean isAvailable = NetUtil.isAvailable(this.f50765a);
        if (!isAvailable) {
            Context context = this.f50765a;
            ToastUtils.showToast(context, context.getString(R.string.GRider_batch1__SSTN), R.drawable.activity_toast_icon);
            resetLoading();
        }
        return isAvailable;
    }

    public View getView() {
        return this.f50766b;
    }

    public void setData(List<ActivityProperty> list, int i, int i2) {
        resetLoading();
        this.f50774j.setVisibility(8);
        TwinklingRefreshLayout twinklingRefreshLayout = this.f50773i;
        if (twinklingRefreshLayout != null && twinklingRefreshLayout.getVisibility() == 8) {
            this.f50773i.setVisibility(0);
            View view = this.f50772h;
            if (view != null) {
                view.setVisibility(8);
            }
        }
        this.f50768d.addAll(list, i);
        m36458a(i2);
    }

    public void resetLoading() {
        if (this.f50773i.isRefreshing()) {
            this.f50773i.finishRefreshing();
        }
        if (this.f50773i.isLoadingMore()) {
            this.f50773i.finishLoadmore();
        }
    }

    public void setPresenter(IActivityPresenter iActivityPresenter) {
        this.f50775k = iActivityPresenter;
    }

    public void showErrorView(int i, String str) {
        resetLoading();
        this.f50774j.setVisibility(8);
        if (this.f50772h == null) {
            this.f50772h = this.f50769e.inflate();
        }
        if (this.f50772h != null) {
            this.f50773i.setVisibility(8);
            this.f50772h.setVisibility(0);
            ImageView imageView = (ImageView) this.f50772h.findViewById(R.id.empty_img);
            TextView textView = (TextView) this.f50772h.findViewById(R.id.empty_tips);
            if (imageView != null) {
                imageView.setImageResource(i);
            }
            if (textView != null) {
                textView.setText(str);
            }
            this.f50772h.findViewById(R.id.empty_retry).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    ActivityRecyclerView.this.f50775k.reqeustRetry();
                }
            });
        }
    }

    /* renamed from: a */
    private void m36458a(int i) {
        if (i == 0) {
            this.f50773i.setEnableLoadmore(true);
            this.f50768d.removeFooters();
        } else if (i == 1) {
            if (this.f50768d.getFooters().size() == 0) {
                this.f50768d.addFooter(new ActivityRecAdapter.ItemView() {
                    public View onCreateView(ViewGroup viewGroup) {
                        return LayoutInflater.from(ActivityRecyclerView.this.f50765a).inflate(R.layout.activity_card_no_more_data, viewGroup, false);
                    }

                    public void onBindView(View view) {
                        View findViewById = view.findViewById(R.id.foot_des);
                        if (findViewById != null) {
                            ((TextView) findViewById).setText("- " + ActivityRecyclerView.this.f50765a.getString(R.string.GRider_batch1__PsJO) + " -");
                        }
                    }
                });
                this.f50773i.setEnableLoadmore(false);
            }
        } else if (i == -1) {
            this.f50768d.removeFooters();
            this.f50773i.setEnableLoadmore(false);
        }
    }
}
