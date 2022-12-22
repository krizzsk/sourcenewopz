package com.didi.component.comp_homecard.destination;

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
import com.didi.component.comp_homecard.destination.HomeDestinationRecAdapter;
import com.didi.component.comp_homecard.destination.IHomeDestinationCardView;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.util.AppUtils;
import com.taxis99.R;
import java.util.List;

public class HomeDestinationCardView implements View.OnClickListener, View.OnTouchListener, IHomeDestinationCardView {

    /* renamed from: a */
    private Context f12237a;

    /* renamed from: b */
    private View f12238b;

    /* renamed from: c */
    private LinearLayout f12239c;

    /* renamed from: d */
    private RecyclerView f12240d;

    /* renamed from: e */
    private FrameLayout f12241e;

    /* renamed from: f */
    private boolean f12242f = false;

    /* renamed from: g */
    private HomeDestinationRecAdapter f12243g;

    /* renamed from: h */
    private HomeDestinationRecAdapter.OnItemClickListener f12244h;

    /* renamed from: i */
    private IHomeDestinationCardView.IClickCallBack f12245i;

    /* renamed from: j */
    private AbsHomeDestinationCardPresenter f12246j;

    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }

    public HomeDestinationCardView(BusinessContext businessContext, ViewGroup viewGroup) {
        this.f12237a = businessContext.getContext();
        m8290a();
    }

    /* renamed from: a */
    private void m8290a() {
        View inflate = LayoutInflater.from(this.f12237a).inflate(R.layout.global_home_card_view_layout, (ViewGroup) null);
        this.f12238b = inflate;
        this.f12239c = (LinearLayout) inflate.findViewById(R.id.oc_home_destination_where_to_ll_b);
        this.f12241e = (FrameLayout) this.f12238b.findViewById(R.id.discount_assistant_layout);
        this.f12239c.setOnClickListener(this);
        if (!AppUtils.isBrazilApp(this.f12237a)) {
            ((ImageView) this.f12238b.findViewById(R.id.oc_home_where_to_dot_b)).setImageResource(R.drawable.global_home_dot_destination);
        }
    }

    /* renamed from: b */
    private void m8291b() {
        RecyclerView recyclerView = (RecyclerView) this.f12238b.findViewById(R.id.oc_home_destination_recommend_rec_b);
        this.f12240d = recyclerView;
        recyclerView.setVisibility(8);
        this.f12243g = new HomeDestinationRecAdapter();
        this.f12240d.setLayoutManager(new LinearLayoutManager(this.f12237a, 1, false));
        this.f12240d.setAdapter(this.f12243g);
        HomeDestinationRecAdapter.OnItemClickListener onItemClickListener = this.f12244h;
        if (onItemClickListener != null) {
            this.f12243g.setOnItemClickListener(onItemClickListener);
        }
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        IHomeDestinationCardView.IClickCallBack iClickCallBack = this.f12245i;
        if (iClickCallBack != null) {
            iClickCallBack.clickWhereToGo();
        }
    }

    public void setRecData(List<HomeCardModel> list) {
        if (this.f12240d == null) {
            m8291b();
        }
        this.f12243g.setDataList(list);
        this.f12243g.notifyDataSetChanged();
    }

    public void showRecList() {
        RecyclerView recyclerView = this.f12240d;
        if (recyclerView != null) {
            recyclerView.setVisibility(0);
        }
    }

    public void hideRecList() {
        RecyclerView recyclerView = this.f12240d;
        if (recyclerView != null) {
            recyclerView.setVisibility(8);
        }
    }

    public void clearRecData() {
        HomeDestinationRecAdapter homeDestinationRecAdapter = this.f12243g;
        if (homeDestinationRecAdapter != null) {
            homeDestinationRecAdapter.cleanTheData();
            this.f12243g.notifyDataSetChanged();
        }
    }

    public boolean isRecListShown() {
        RecyclerView recyclerView = this.f12240d;
        return recyclerView != null && recyclerView.getVisibility() == 0 && this.f12240d.getWidth() > 0;
    }

    public void setClickListener(IHomeDestinationCardView.IClickCallBack iClickCallBack) {
        this.f12245i = iClickCallBack;
    }

    public void setGuessItemClickListener(HomeDestinationRecAdapter.OnItemClickListener onItemClickListener) {
        HomeDestinationRecAdapter homeDestinationRecAdapter = this.f12243g;
        if (homeDestinationRecAdapter != null) {
            homeDestinationRecAdapter.setOnItemClickListener(onItemClickListener);
        } else {
            this.f12244h = onItemClickListener;
        }
    }

    public void setVisibility(int i, Runnable runnable) {
        if (i == 0) {
            this.f12238b.setVisibility(0);
        } else {
            this.f12238b.setVisibility(4);
        }
        if (runnable != null) {
            runnable.run();
        }
    }

    public void showCouponAssistant(View view) {
        if (view != null) {
            this.f12241e.removeAllViews();
            this.f12241e.setVisibility(0);
            this.f12241e.addView(view);
            this.f12242f = true;
        }
    }

    public void hideCouponAssistant() {
        if (this.f12242f) {
            this.f12242f = false;
            this.f12241e.setVisibility(8);
        }
    }

    public View getView() {
        return this.f12238b;
    }

    public void setPresenter(AbsHomeDestinationCardPresenter absHomeDestinationCardPresenter) {
        this.f12246j = absHomeDestinationCardPresenter;
        setClickListener(absHomeDestinationCardPresenter);
    }
}
