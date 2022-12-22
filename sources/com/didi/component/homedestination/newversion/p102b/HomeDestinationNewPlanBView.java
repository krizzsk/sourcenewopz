package com.didi.component.homedestination.newversion.p102b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.model.HomeCardModel;
import com.didi.component.common.model.HomeCouponPerception;
import com.didi.component.homedestination.newversion.HomeDestinationNewRecAdapter;
import com.didi.component.homedestination.newversion.p102b.IHomeDestinationPlantBNewView;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.async.AsyncLayoutFactory;
import com.didi.sdk.util.AppUtils;
import com.taxis99.R;
import java.util.List;

/* renamed from: com.didi.component.homedestination.newversion.b.HomeDestinationNewPlanBView */
public class HomeDestinationNewPlanBView implements View.OnClickListener, View.OnTouchListener, IHomeDestinationPlantBNewView<HomeDestinationNewPlanBPresenter> {

    /* renamed from: a */
    private BusinessContext f14112a;

    /* renamed from: b */
    private Context f14113b;

    /* renamed from: c */
    private ViewGroup f14114c;

    /* renamed from: d */
    private View f14115d;

    /* renamed from: e */
    private LinearLayout f14116e;

    /* renamed from: f */
    private RecyclerView f14117f;

    /* renamed from: g */
    private FrameLayout f14118g;

    /* renamed from: h */
    private boolean f14119h = false;

    /* renamed from: i */
    private HomeDestinationNewRecAdapter f14120i;

    /* renamed from: j */
    private HomeDestinationNewRecAdapter.OnItemClickListener f14121j;

    /* renamed from: k */
    private IHomeDestinationPlantBNewView.IClickCallBack f14122k;

    /* renamed from: l */
    private HomeDestinationNewPlanBPresenter f14123l;

    public void hideCouponPerception() {
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }

    public void showCouponPerception(HomeCouponPerception homeCouponPerception) {
    }

    public HomeDestinationNewPlanBView(BusinessContext businessContext, ViewGroup viewGroup) {
        this.f14112a = businessContext;
        this.f14113b = businessContext.getContext();
        this.f14114c = viewGroup;
        m9866a();
    }

    /* renamed from: a */
    private void m9866a() {
        View viewByResId = AsyncLayoutFactory.getInstance().getViewByResId(R.layout.global_home_destination_view_layout_new_ui_plan_b);
        if (viewByResId == null) {
            viewByResId = LayoutInflater.from(this.f14113b).inflate(R.layout.global_home_destination_view_layout_new_ui_plan_b, (ViewGroup) null);
        }
        this.f14115d = viewByResId;
        this.f14116e = (LinearLayout) viewByResId.findViewById(R.id.oc_home_destination_where_to_ll_b);
        this.f14118g = (FrameLayout) this.f14115d.findViewById(R.id.discount_assistant_layout);
        this.f14116e.setOnClickListener(this);
        if (!AppUtils.isBrazilApp(this.f14113b)) {
            ((ImageView) this.f14115d.findViewById(R.id.oc_home_where_to_dot_b)).setImageResource(R.drawable.global_home_dot_destination);
        }
    }

    /* renamed from: b */
    private void m9867b() {
        RecyclerView recyclerView = (RecyclerView) this.f14115d.findViewById(R.id.oc_home_destination_recommend_rec_b);
        this.f14117f = recyclerView;
        recyclerView.setVisibility(8);
        this.f14120i = new HomeDestinationNewRecAdapter();
        this.f14117f.setLayoutManager(new LinearLayoutManager(this.f14113b, 1, false));
        this.f14117f.setAdapter(this.f14120i);
        HomeDestinationNewRecAdapter.OnItemClickListener onItemClickListener = this.f14121j;
        if (onItemClickListener != null) {
            this.f14120i.setOnItemClickListener(onItemClickListener);
        }
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        IHomeDestinationPlantBNewView.IClickCallBack iClickCallBack = this.f14122k;
        if (iClickCallBack != null) {
            iClickCallBack.clickWhereToGo();
        }
    }

    public void setRecData(List<HomeCardModel> list) {
        if (this.f14117f == null) {
            m9867b();
        }
        this.f14120i.setDataList(list);
        this.f14120i.notifyDataSetChanged();
    }

    public void showRecList() {
        RecyclerView recyclerView = this.f14117f;
        if (recyclerView != null) {
            recyclerView.setVisibility(0);
        }
    }

    public void hideRecList() {
        RecyclerView recyclerView = this.f14117f;
        if (recyclerView != null) {
            recyclerView.setVisibility(8);
        }
    }

    public void clearRecData() {
        HomeDestinationNewRecAdapter homeDestinationNewRecAdapter = this.f14120i;
        if (homeDestinationNewRecAdapter != null) {
            homeDestinationNewRecAdapter.cleanTheData();
            this.f14120i.notifyDataSetChanged();
        }
    }

    public boolean isRecListShown() {
        RecyclerView recyclerView = this.f14117f;
        return recyclerView != null && recyclerView.getVisibility() == 0 && this.f14117f.getWidth() > 0;
    }

    public void setClickListener(IHomeDestinationPlantBNewView.IClickCallBack iClickCallBack) {
        this.f14122k = iClickCallBack;
    }

    public void setGuessItemClickListener(HomeDestinationNewRecAdapter.OnItemClickListener onItemClickListener) {
        HomeDestinationNewRecAdapter homeDestinationNewRecAdapter = this.f14120i;
        if (homeDestinationNewRecAdapter != null) {
            homeDestinationNewRecAdapter.setOnItemClickListener(onItemClickListener);
        } else {
            this.f14121j = onItemClickListener;
        }
    }

    public void setVisibility(int i) {
        setVisibility(i, (Runnable) null);
    }

    public void setVisibility(int i, Runnable runnable) {
        if (i == 0) {
            this.f14115d.setVisibility(0);
        } else {
            this.f14115d.setVisibility(4);
        }
        if (runnable != null) {
            runnable.run();
        }
    }

    public boolean isVisibility() {
        return this.f14115d.getVisibility() == 0;
    }

    public void showCouponAssistant(View view) {
        if (view != null) {
            this.f14118g.removeAllViews();
            this.f14118g.setVisibility(0);
            this.f14118g.addView(view);
            this.f14119h = true;
        }
    }

    public void hideCouponAssistant() {
        if (this.f14119h) {
            this.f14119h = false;
            this.f14118g.setVisibility(8);
        }
    }

    public View getView() {
        return this.f14115d;
    }

    public void setPresenter(HomeDestinationNewPlanBPresenter homeDestinationNewPlanBPresenter) {
        this.f14123l = homeDestinationNewPlanBPresenter;
        setClickListener(homeDestinationNewPlanBPresenter);
    }
}
