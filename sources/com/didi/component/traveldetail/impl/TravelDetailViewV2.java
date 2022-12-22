package com.didi.component.traveldetail.impl;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.GlobalSPUtil;
import com.didi.component.business.util.I18NUtils;
import com.didi.component.traveldetail.AbsTravelDetailPresenterV2;
import com.didi.component.traveldetail.CommonTravelDetailItemDecorationV2;
import com.didi.component.traveldetail.ITravelDetailViewV2;
import com.didi.component.traveldetail.OnServiceUtil;
import com.didi.component.traveldetail.adapter.TravelDetailCommonAdapterV2;
import com.didi.component.traveldetail.model.TravelDetailItemV2;
import com.didi.global.globaluikit.popup.BubbleCloseListener;
import com.didi.global.globaluikit.popup.LEGOBubble;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didiglobal.travel.util.CollectionUtils;
import com.taxis99.R;
import java.util.Collection;
import java.util.List;

public class TravelDetailViewV2 implements View.OnClickListener, ITravelDetailViewV2 {

    /* renamed from: a */
    private View f16162a;

    /* renamed from: b */
    private RecyclerView f16163b;

    /* renamed from: c */
    private ImageView f16164c = ((ImageView) this.f16162a.findViewById(R.id.routeEditButton));

    /* renamed from: d */
    private TravelDetailCommonAdapterV2 f16165d = new TravelDetailCommonAdapterV2();
    /* access modifiers changed from: private */

    /* renamed from: e */
    public AbsTravelDetailPresenterV2 f16166e;

    /* renamed from: f */
    private TextView f16167f;

    /* renamed from: g */
    private TextView f16168g;

    /* renamed from: h */
    private View f16169h;

    /* renamed from: i */
    private ViewGroup f16170i;

    /* renamed from: j */
    private LEGOBubble f16171j;

    public void doXPanelStatusChanged(int i) {
    }

    public void setTravelDetailData(List<TravelDetailItemV2> list) {
        if (!CollectionUtils.isEmpty((Collection<?>) list)) {
            m11856a();
            this.f16165d.setTravelDetailList(list);
            if (CarOrderHelper.getOrderStatus() != 4 || CarOrderHelper.getOrder().isSplitFareUser()) {
                this.f16164c.setVisibility(8);
                m11857a(this.f16164c.getContext(), false);
                return;
            }
            this.f16164c.setVisibility(0);
            UiThreadHandler.postDelayed(new Runnable() {
                public void run() {
                    TravelDetailViewV2.this.m11861b();
                }
            }, 1000);
        }
    }

    public void hideGuide() {
        if (getView() != null) {
            m11857a(getView().getContext(), false);
        }
    }

    public void showGuide() {
        m11861b();
    }

    public View getView() {
        return this.f16162a;
    }

    public void setPresenter(AbsTravelDetailPresenterV2 absTravelDetailPresenterV2) {
        this.f16166e = absTravelDetailPresenterV2;
    }

    public TravelDetailViewV2(Context context, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.global_travel_detail_layout_v2, (ViewGroup) null);
        this.f16162a = inflate;
        this.f16163b = (RecyclerView) inflate.findViewById(R.id.travelDetailRecycler);
        this.f16163b.setLayoutManager(new LinearLayoutManager(context, 1, false));
        this.f16163b.setNestedScrollingEnabled(false);
        this.f16163b.addItemDecoration(new CommonTravelDetailItemDecorationV2(context));
        this.f16163b.setAdapter(this.f16165d);
        this.f16164c.setOnClickListener(this);
        this.f16167f = (TextView) this.f16162a.findViewById(R.id.title);
        this.f16168g = (TextView) this.f16162a.findViewById(R.id.subTitle);
        this.f16169h = this.f16162a.findViewById(R.id.divider);
        this.f16170i = (ViewGroup) this.f16162a.findViewById(R.id.guideLayout);
    }

    /* renamed from: a */
    private void m11856a() {
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null) {
            if (CarOrderHelper.isOrderEnd()) {
                this.f16167f.setVisibility(0);
                this.f16168g.setVisibility(0);
                this.f16168g.setText(I18NUtils.getTimeAllDate(order.createTime, true));
                this.f16169h.setVisibility(0);
                return;
            }
            this.f16167f.setVisibility(8);
            this.f16168g.setVisibility(8);
            this.f16169h.setVisibility(8);
        }
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (view.getId() == this.f16164c.getId()) {
            m11857a(this.f16164c.getContext(), true);
            this.f16166e.onEditClick();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m11861b() {
        ImageView imageView = this.f16164c;
        if (imageView != null && imageView.getVisibility() == 0) {
            final Context context = this.f16162a.getContext();
            AbsTravelDetailPresenterV2 absTravelDetailPresenterV2 = this.f16166e;
            if ((!(absTravelDetailPresenterV2 instanceof TravelDetailPresenterV2) || !((TravelDetailPresenterV2) absTravelDetailPresenterV2).getShowEditGuideNow()) && OnServiceUtil.INSTANCE.needShowOnServiceRouteEditShow(context) && GlobalSPUtil.getChangePaywayGuideShown(context)) {
                if (this.f16171j == null) {
                    LEGOBubble.Builder builder = new LEGOBubble.Builder(context);
                    GlobalOmegaUtils.trackEvent("ibt_gp_editroute_newguide_sw");
                    this.f16171j = builder.setDirection("right").setCloseBtnListener((BubbleCloseListener) null).setText(ResourcesHelper.getString(context, R.string.GR_Pick_and_OnTrip_2020_tripCard_editRoute_edu)).setTextTypeface(3).setCloseBtnVisible(false).setBgColor(Color.parseColor("#E05C6166")).setContentViewOnClick(new View.OnClickListener() {
                        public void onClick(View view) {
                            AutoTrackHelper.trackViewOnClick(view);
                            TravelDetailViewV2.this.m11857a(context, true);
                            TravelDetailViewV2.this.f16166e.onEditClick();
                        }
                    }).build();
                }
                this.f16170i.removeAllViews();
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 8388629;
                this.f16170i.addView(this.f16171j.getView(), layoutParams);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11857a(Context context, boolean z) {
        if (this.f16171j != null) {
            this.f16170i.removeAllViews();
            if (z) {
                OnServiceUtil.INSTANCE.setOnServiceRouteEditShow(context, true);
            }
        }
    }
}
