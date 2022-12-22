package com.didi.component.driverbar.impl;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.core.IViewContainer;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.driverbar.AbsDriverBarPresenter;
import com.didi.component.driverbar.IDriverBarView;
import com.didi.component.driverbar.model.DriverBarCardInfo;
import com.didi.component.driverbar.model.DriverBarStyle;
import com.didi.component.driverbar.model.DriverBarV2Model;
import com.didi.component.driverbar.util.DriverBarInfoUtilsKt;
import com.didi.component.driverbar.view.DriverBarWaitingJapanStyleView;
import com.didi.map.global.flow.model.EtaEda;
import com.didi.sdk.app.DIDIApplication;
import com.didiglobal.travel.infra.content.ContextKt;
import com.didiglobal.travel.util.Preconditions;
import com.didiglobal.travel.util.view.ViewEx;
import com.taxis99.R;

public class DriverBarV2View implements IViewContainer, IDriverBarView {

    /* renamed from: a */
    private static final int f12985a = 0;

    /* renamed from: b */
    private static final int f12986b = 1;

    /* renamed from: c */
    private static final int f12987c = 2;

    /* renamed from: d */
    private static final int f12988d = 1;

    /* renamed from: e */
    private static final int f12989e = 2;
    protected DriverBarFieldBase currentView;

    /* renamed from: f */
    private FrameLayout f12990f;

    /* renamed from: g */
    private FrameLayout f12991g;

    /* renamed from: h */
    private FrameLayout f12992h;

    /* renamed from: i */
    private DriverBarV2Model f12993i;

    /* renamed from: j */
    private boolean f12994j = false;

    /* renamed from: k */
    private boolean f12995k;

    /* renamed from: l */
    private int f12996l = -1;

    /* renamed from: m */
    private int f12997m = 0;
    protected View mContainerView;
    protected Context mContext;
    protected AbsDriverBarPresenter mPresenter;

    /* renamed from: n */
    private DriverBarCardInfo f12998n;

    /* renamed from: o */
    private DriverBarStyle f12999o = DriverBarStyle.DEFAULT_STYLE;

    public void showPhoneGuide(String str) {
    }

    public DriverBarV2View(Context context, ViewGroup viewGroup) {
        m8804a(context, viewGroup);
        this.mContext = context;
        this.f12990f = (FrameLayout) findView(R.id.driver_bar_near_container);
        this.f12991g = (FrameLayout) findView(R.id.driver_bar_far_container);
        this.f12992h = (FrameLayout) findView(R.id.driver_bar_on_service_container);
    }

    /* renamed from: a */
    private void m8804a(Context context, ViewGroup viewGroup) {
        this.mContainerView = ViewEx.inflateViewAsync(context, (int) R.layout.driver_bar_v2_view, viewGroup, false);
    }

    /* access modifiers changed from: protected */
    public <T extends View> T findView(int i) {
        return this.mContainerView.findViewById(i);
    }

    public void setComponentCreator(IViewContainer.IComponentCreator iComponentCreator) {
        this.mPresenter.setComponentCreator(iComponentCreator);
    }

    public void setData(DriverBarV2Model driverBarV2Model) {
        if (!this.f12995k) {
            this.currentView.setPresenter(this.mPresenter);
            this.f12993i = driverBarV2Model;
            boolean z = true;
            if (driverBarV2Model.switchNearEnable != 1) {
                z = false;
            }
            m8806a(z);
            m8807b();
            m8810c();
        }
    }

    public void setData(DriverBarCardInfo driverBarCardInfo) {
        this.f12995k = true;
        this.f12998n = driverBarCardInfo;
        this.f12993i = DriverBarInfoUtilsKt.toDriverBarV2Model(driverBarCardInfo);
        m8806a(driverBarCardInfo.isNearEnable());
        m8807b();
        this.currentView.setPresenter(this.mPresenter);
        m8810c();
    }

    /* renamed from: a */
    private void m8802a() {
        this.f12991g.removeAllViews();
        this.f12990f.removeAllViews();
        this.f12992h.removeAllViews();
        this.currentView = null;
    }

    public ViewGroup getContainer(int i) {
        DriverBarFieldBase driverBarFieldBase = this.currentView;
        if (Preconditions.nonNull(driverBarFieldBase)) {
            return driverBarFieldBase.getContainer(i);
        }
        return null;
    }

    public void setPhoneVisible(boolean z) {
        if (Preconditions.nonNull(this.currentView)) {
            this.currentView.setPhoneVisible(z);
        }
    }

    public boolean isPhoneVisible() {
        DriverBarFieldBase driverBarFieldBase = this.currentView;
        return Preconditions.nonNull(driverBarFieldBase) && driverBarFieldBase.isPhoneVisible();
    }

    public void setDriverBarStyle(DriverBarStyle driverBarStyle) {
        if (this.f12999o != driverBarStyle) {
            this.f12997m |= 1;
        }
        this.f12999o = driverBarStyle;
    }

    public void showCarUpdateInfo(String str, String str2, String str3, String str4) {
        if (Preconditions.nonNull(this.currentView)) {
            this.currentView.showCarUpdateInfo(str, str2, str3, str4);
        }
    }

    public void hideCarUpdateInfo() {
        if (Preconditions.nonNull(this.currentView)) {
            this.currentView.hideCarUpdateInfo();
        }
    }

    public void nearPickupShow(EtaEda etaEda) {
        if (!(this.f12993i == null || this.currentView == null)) {
            if (!m8812e()) {
                m8802a();
                DriverBarOnServiceView driverBarOnServiceView = new DriverBarOnServiceView(this.mContext, this.f12992h);
                driverBarOnServiceView.setData(this.f12993i);
                this.currentView = driverBarOnServiceView;
                this.f12992h.addView(driverBarOnServiceView.getView());
                this.mPresenter.buildInnerComponent(this.f12993i.imOption, this.f12993i.phoneOption, "small");
                this.currentView.setPresenter(this.mPresenter);
            } else if (this.f12994j) {
                showNearView();
            } else {
                this.currentView.nearPickupShow(etaEda);
            }
        }
        this.f12994j = true;
    }

    public void newMessageBubbleShow(boolean z) {
        if (Preconditions.nonNull(this.currentView)) {
            this.currentView.newMessageBubbleShow(z);
        }
    }

    public void handleBluetoothMeetEntranceShow(Boolean bool) {
        if (Preconditions.nonNull(this.currentView)) {
            this.currentView.handleBluetoothMeetEntranceShow(bool);
        }
    }

    public void hideBlueMeetGuide() {
        if (Preconditions.nonNull(this.currentView)) {
            this.currentView.hideBlueMeetGuide();
        }
    }

    public View getView() {
        return this.mContainerView;
    }

    public void setPresenter(AbsDriverBarPresenter absDriverBarPresenter) {
        this.mPresenter = absDriverBarPresenter;
    }

    /* renamed from: a */
    private void m8806a(boolean z) {
        boolean z2 = this.currentView == null;
        if (!m8811d()) {
            m8803a(0);
        } else if (this.f12999o != DriverBarStyle.DEFAULT_STYLE || !z || (!this.f12994j && (!m8813f() || !z2))) {
            m8803a(2);
        } else {
            m8803a(1);
        }
    }

    /* renamed from: b */
    private void m8807b() {
        m8802a();
        int i = this.f12996l;
        if (i == 0) {
            m8809b(this.f12998n, this.f12993i);
        } else if (i != 2) {
            showNearView();
        } else {
            m8805a(this.f12998n, this.f12993i);
        }
    }

    /* renamed from: c */
    private void m8810c() {
        m8808b(2);
        m8808b(1);
    }

    /* renamed from: d */
    private boolean m8811d() {
        int orderStatus = CarOrderHelper.getOrderStatus();
        if (orderStatus == 1 || orderStatus == 7) {
            return true;
        }
        if (orderStatus != 4 || !m8812e()) {
            return false;
        }
        return true;
    }

    /* renamed from: e */
    private boolean m8812e() {
        int orderSubStatus = CarOrderHelper.getOrderSubStatus();
        return orderSubStatus == 4002 || orderSubStatus == 4003 || orderSubStatus == 4004 || orderSubStatus == 4001 || orderSubStatus == 4007;
    }

    /* renamed from: f */
    private boolean m8813f() {
        int orderSubStatus = CarOrderHelper.getOrderSubStatus();
        return orderSubStatus >= 4003 && orderSubStatus < 4006;
    }

    public void showNearView() {
        m8802a();
        DriverBarNearFieldView driverBarNearFieldView = new DriverBarNearFieldView(this.mContext, this.f12990f);
        if (Preconditions.nonNull(this.f12998n)) {
            driverBarNearFieldView.setData(this.f12998n);
        }
        driverBarNearFieldView.setData(this.f12993i);
        this.currentView = driverBarNearFieldView;
        this.f12990f.addView(driverBarNearFieldView.getView());
        this.mPresenter.buildInnerComponent(this.f12993i.imOption, this.f12993i.phoneOption, "near");
        this.currentView.setPresenter(this.mPresenter);
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.NewXpanel.EVENT_XPANEL_NEW_CONFIG_DEFAULT_SHOW_HEIGHT, 0);
        this.f12994j = true;
    }

    /* renamed from: a */
    private void m8805a(DriverBarCardInfo driverBarCardInfo, DriverBarV2Model driverBarV2Model) {
        DriverBarFieldBase driverBarFieldBase;
        if (this.f12999o == DriverBarStyle.JAPAN_STYLE) {
            driverBarFieldBase = new DriverBarWaitingJapanStyleView(this.mContext, this.f12991g);
        } else {
            driverBarFieldBase = new DriverBarFarFieldView(this.mContext, this.f12991g, this);
        }
        this.currentView = driverBarFieldBase;
        driverBarFieldBase.setData(driverBarCardInfo);
        driverBarFieldBase.setData(driverBarV2Model);
        this.f12991g.addView(driverBarFieldBase.getView());
        this.mPresenter.buildInnerComponent(driverBarCardInfo.getImOption(), driverBarCardInfo.getPhoneOption(), this.f12999o == DriverBarStyle.JAPAN_STYLE ? "small" : "far", m8801a(this.f12999o));
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.NewXpanel.EVENT_XPANEL_NEW_CONFIG_DEFAULT_SHOW_HEIGHT, 83);
    }

    /* renamed from: b */
    private void m8809b(DriverBarCardInfo driverBarCardInfo, DriverBarV2Model driverBarV2Model) {
        DriverBarOnServiceView driverBarOnServiceView = new DriverBarOnServiceView(this.mContext, this.f12991g);
        this.currentView = driverBarOnServiceView;
        driverBarOnServiceView.setData(driverBarCardInfo);
        driverBarOnServiceView.setData(driverBarV2Model);
        this.f12992h.addView(driverBarOnServiceView.getView());
        this.mPresenter.buildInnerComponent(driverBarCardInfo.getImOption(), driverBarCardInfo.getPhoneOption(), "small");
    }

    /* renamed from: a */
    private void m8803a(int i) {
        if (this.f12996l == i) {
            m8808b(2);
            return;
        }
        this.f12996l = i;
        this.f12997m |= 2;
    }

    /* renamed from: g */
    private boolean m8814g() {
        int i = this.f12997m;
        return (i & 1) == 1 || (i & 2) == 2;
    }

    /* renamed from: b */
    private void m8808b(int i) {
        int i2 = this.f12997m;
        if ((i2 & i) == i) {
            this.f12997m = i ^ i2;
        }
    }

    /* renamed from: a */
    private Bundle m8801a(DriverBarStyle driverBarStyle) {
        if (driverBarStyle != DriverBarStyle.JAPAN_STYLE) {
            return null;
        }
        Context appContext = Preconditions.nonNull(this.mContext) ? this.mContext : DIDIApplication.getAppContext();
        Bundle bundle = new Bundle();
        bundle.putBoolean("notify_message", true);
        bundle.putInt("message_anchor_view", R.id.civ_driver_avatar);
        bundle.putInt("message_bubble_tint_color", ContextKt.colorOf(appContext, R.color.global_driver_bar_im_message_bubble_jp_style));
        return bundle;
    }
}
