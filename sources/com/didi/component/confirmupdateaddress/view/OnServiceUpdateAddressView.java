package com.didi.component.confirmupdateaddress.view;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.confirmupdateaddress.presenter.OnServiceUpdateAddressPresenter;
import com.didi.component.confirmupdateaddress.util.OnServiceGuideUtil;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.global.globaluikit.LEGOUICreator;
import com.didi.global.globaluikit.popup.BubbleCloseListener;
import com.didi.global.globaluikit.popup.LEGOBubble;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.async.AsyncLayoutFactory;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.travel.psnger.model.response.CarOrder;
import com.taxis99.R;

public class OnServiceUpdateAddressView implements View.OnClickListener, IUpdateAddress {

    /* renamed from: a */
    private final Context f12721a;

    /* renamed from: b */
    private View f12722b;

    /* renamed from: c */
    private OnServiceUpdateAddressPresenter f12723c;

    /* renamed from: d */
    private TextView f12724d;

    /* renamed from: e */
    private TextView f12725e;

    /* renamed from: f */
    private View f12726f;

    /* renamed from: g */
    private ViewGroup f12727g;

    public OnServiceUpdateAddressView(ComponentParams componentParams, ViewGroup viewGroup) {
        this.f12721a = componentParams.bizCtx.getContext();
        View viewByResId = AsyncLayoutFactory.getInstance().getViewByResId(R.layout.global_onservice_update_address_layout);
        viewByResId = viewByResId == null ? LayoutInflater.from(this.f12721a).inflate(R.layout.global_onservice_update_address_layout, viewGroup, false) : viewByResId;
        this.f12722b = viewByResId;
        this.f12724d = (TextView) viewByResId.findViewById(R.id.global_confirm_update_address_pick_up_tv);
        this.f12725e = (TextView) this.f12722b.findViewById(R.id.global_confirm_update_address_change_tv);
        this.f12726f = this.f12722b.findViewById(R.id.divider);
        this.f12727g = (ViewGroup) this.f12722b.findViewById(R.id.global_confirm_update_address_guide_layout);
        this.f12725e.setOnClickListener(this);
        this.f12727g.setOnClickListener(this);
        this.f12724d.setOnClickListener(this);
        updateAddress();
        m8673c();
    }

    public void updateAddress() {
        CarOrder order = CarOrderHelper.getOrder();
        Address address = order != null ? order.startAddress : null;
        if (address == null || TextUtils.isEmpty(address.getDisplayName())) {
            this.f12724d.setText(ResourcesHelper.getString(this.f12721a, R.string.map_flow_current_location));
        } else {
            this.f12724d.setText(address.getDisplayName());
        }
    }

    /* renamed from: a */
    private boolean m8671a() {
        CarOrder order = CarOrderHelper.getOrder();
        boolean isFromOpenRide = FormStore.getInstance().isFromOpenRide();
        boolean z = order != null && order.isSplitFareUser();
        if (!(order != null && order.showUpdatePickUpPop) || isFromOpenRide || z) {
            return false;
        }
        return true;
    }

    public View getView() {
        return this.f12722b;
    }

    public void setPresenter(OnServiceUpdateAddressPresenter onServiceUpdateAddressPresenter) {
        this.f12723c = onServiceUpdateAddressPresenter;
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (view.getId() == R.id.global_confirm_update_address_change_tv) {
            GlobalOmegaUtils.trackEvent("gp_changeFromAddress_edit_ck");
            m8672b();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m8672b() {
        if (this.f12723c != null) {
            m8675e();
            this.f12723c.onChangeClick();
        }
    }

    public void updateChangeVisible() {
        m8673c();
    }

    public void setChangeVisible(int i) {
        TextView textView = this.f12725e;
        if (textView != null && this.f12726f != null) {
            textView.setVisibility(i);
            this.f12726f.setVisibility(i);
        }
    }

    public void setViewVisible(int i) {
        if (this.f12722b != null) {
            updateAddress();
            this.f12722b.setVisibility(i);
        }
    }

    /* renamed from: c */
    private void m8673c() {
        if (m8671a()) {
            setChangeVisible(0);
            m8674d();
            return;
        }
        setChangeVisible(8);
        m8675e();
    }

    /* renamed from: d */
    private void m8674d() {
        if (OnServiceGuideUtil.INSTANCE.isShowEditGuideOnService(this.f12721a)) {
            m8675e();
            return;
        }
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.OnService.EVENT_SHOW_EDIT_GUIDE, true);
        LEGOBubble createBubble = LEGOUICreator.createBubble(this.f12722b.getContext(), ResourcesHelper.getString(this.f12721a, R.string.GR_Pick_and_OnTrip_2020_PUP_change_eduBubble), Color.parseColor("#5C6166"), "top_right", 3, false, (BubbleCloseListener) null);
        this.f12727g.removeAllViews();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 5;
        View view = createBubble.getView();
        view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                OnServiceUpdateAddressView.this.m8672b();
            }
        });
        this.f12727g.addView(view, layoutParams);
        OnServiceGuideUtil.INSTANCE.setShowEditGuideOnService(this.f12721a, true);
    }

    /* renamed from: e */
    private void m8675e() {
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.OnService.EVENT_SHOW_EDIT_GUIDE, false);
        this.f12727g.removeAllViews();
    }
}
