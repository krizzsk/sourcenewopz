package com.component.android.comp_location.presenter;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.component.android.comp_location.AbsGlobalLocationPresenter;
import com.component.android.comp_location.IGlobalLocationView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.constant.BaseExtras;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.event.OpenRideVisibilityEvent;
import com.didi.component.business.event.ResetMapEvent;
import com.didi.component.business.event.SafeToolkitVisibilityEvent;
import com.didi.component.common.base.ComponentWrap;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.event.BaseEventPublisher;
import com.taxis99.R;

public class GlobalConfirmLocationPresenter extends AbsGlobalLocationPresenter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public boolean f3292a = false;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public boolean f3293b = false;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f3294c = false;

    /* renamed from: d */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f3295d = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (BaseEventKeys.Confirm.EVENT_SHOW_CONFIRM_PRICE.equals(str)) {
                GlobalConfirmLocationPresenter.this.isInConfirmPricePage = true;
                boolean unused = GlobalConfirmLocationPresenter.this.f3292a = false;
                ((IGlobalLocationView) GlobalConfirmLocationPresenter.this.mView).setStartOrEndOverviewVisible(8);
                GlobalConfirmLocationPresenter.this.onResetOverviewState(true);
            } else if (BaseEventKeys.Confirm.EVENT_SHOW_CONFIRM_ADDRESS.equals(str)) {
                GlobalConfirmLocationPresenter.this.isInConfirmPricePage = false;
                ((IGlobalLocationView) GlobalConfirmLocationPresenter.this.mView).setOverviewVisibility(8);
                if (FormStore.getInstance().isInMiniBus()) {
                    ((IGlobalLocationView) GlobalConfirmLocationPresenter.this.mView).setStartOrEndOverviewVisible(0);
                }
            }
        }
    };

    /* renamed from: e */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f3296e = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (GlobalConfirmLocationPresenter.this.f3293b) {
                GlobalConfirmLocationPresenter.this.onResetOverviewState(false);
            }
        }
    };

    /* renamed from: f */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f3297f = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (GlobalConfirmLocationPresenter.this.f3294c) {
                boolean unused = GlobalConfirmLocationPresenter.this.f3292a = false;
                boolean unused2 = GlobalConfirmLocationPresenter.this.f3294c = false;
            }
            GlobalConfirmLocationPresenter.this.m2235b();
        }
    };

    /* renamed from: g */
    private BaseEventPublisher.OnEventListener<ComponentWrap> f3298g = new BaseEventPublisher.OnEventListener<ComponentWrap>() {
        public void onEvent(String str, ComponentWrap componentWrap) {
            if (BaseEventKeys.Template.EVENT_SHOW_POPUP_COMPONENT.equals(str)) {
                boolean unused = GlobalConfirmLocationPresenter.this.f3294c = true;
            }
        }
    };
    protected boolean isCarpoolOverviewState = false;
    protected boolean isInConfirmPricePage = true;
    protected Handler mInitBestViewHandler = new Handler() {
        public void handleMessage(Message message) {
            GlobalConfirmLocationPresenter.this.m2235b();
            GlobalConfirmLocationPresenter.this.requestMapLayout();
        }
    };

    /* access modifiers changed from: protected */
    public int getCarpoolNormalIcon() {
        return R.drawable.global_carpool_overview_normal_icon;
    }

    public GlobalConfirmLocationPresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public void onSafeToolkitVisibilityChanged(SafeToolkitVisibilityEvent safeToolkitVisibilityEvent) {
        super.onSafeToolkitVisibilityChanged(new SafeToolkitVisibilityEvent(0, false));
    }

    /* access modifiers changed from: protected */
    public void onPageResume() {
        super.onPageResume();
        requestMapLayout();
    }

    /* access modifiers changed from: protected */
    public void onOpenRideVisibilityChanged(OpenRideVisibilityEvent openRideVisibilityEvent) {
        super.onOpenRideVisibilityChanged(new OpenRideVisibilityEvent(0, false));
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        if (bundle != null) {
            this.isInConfirmPricePage = !bundle.getBoolean(BaseExtras.ConfirmService.EXTRA_CONFIRM_GET_ON_SCENE, false);
        }
        subscribe(BaseEventKeys.Confirm.EVENT_SHOW_CONFIRM_PRICE, this.f3295d);
        subscribe(BaseEventKeys.Confirm.EVENT_SHOW_CONFIRM_ADDRESS, this.f3295d);
        subscribe(BaseEventKeys.Estimate.ESTIMATE_COMPONENT_SHOWN, this.f3296e);
        subscribe(BaseEventKeys.Template.EVENT_SHOW_POPUP_COMPONENT, this.f3298g);
        subscribe(BaseEventKeys.Confirm.EVENT_SHOW_XPANEL, this.f3297f);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        this.isInConfirmPricePage = false;
        unsubscribe(BaseEventKeys.Confirm.EVENT_SHOW_CONFIRM_PRICE, this.f3295d);
        unsubscribe(BaseEventKeys.Confirm.EVENT_SHOW_CONFIRM_ADDRESS, this.f3295d);
        unsubscribe(BaseEventKeys.Estimate.ESTIMATE_COMPONENT_SHOWN, this.f3296e);
        unsubscribe(BaseEventKeys.Template.EVENT_SHOW_POPUP_COMPONENT, this.f3298g);
        unsubscribe(BaseEventKeys.Confirm.EVENT_SHOW_XPANEL, this.f3297f);
    }

    public void onXPanelDefaultHeightChanged(int i) {
        if (i >= 0) {
            if (this.mDefaultBottom != i) {
                this.mDefaultBottom = i;
                if (this.mPaddingBottom > this.mDefaultBottom) {
                    onXPanelScrollChanged(this.mDefaultBottom);
                }
            }
            if (this.isInConfirmPricePage) {
                doBestView();
                return;
            }
            this.mInitBestViewHandler.removeCallbacksAndMessages((Object) null);
            this.mInitBestViewHandler.sendEmptyMessageDelayed(0, 300);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m2235b() {
        ResetMapEvent obtain = ResetMapEvent.obtain();
        obtain.fillData(0, this.mPaddingTop, 0, this.mPaddingBottom);
        doPublish(BaseEventKeys.Map.EVENT_GET_ON_SCENE_INIT_MAP, obtain);
        if (!this.f3292a) {
            if (this.mPaddingBottom != 0) {
                this.f3292a = true;
            }
            switchViewForGetOnAndOff(0);
        }
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (view.getId() == R.id.global_carpool_overview_btn) {
            if (this.isCarpoolOverviewState) {
                ((IGlobalLocationView) this.mView).setOverviewIcon(R.drawable.global_carpool_overview_normal_icon);
            } else {
                ((IGlobalLocationView) this.mView).setOverviewIcon(R.drawable.global_carpool_overview_back_icon);
            }
            boolean z = !this.isCarpoolOverviewState;
            this.isCarpoolOverviewState = z;
            doPublish(BaseEventKeys.CarPool.EVENT_CAR_POOL_MAPFLOW_OVERVIEW_SWITCH, Boolean.valueOf(z));
            return;
        }
        super.onClick(view);
    }

    /* access modifiers changed from: protected */
    public void onResetOverviewState(boolean z) {
        this.f3293b = z;
        ((IGlobalLocationView) this.mView).setVisibility(4);
        if (!FormStore.getInstance().isBubbleShowCarpoolStyle()) {
            ((IGlobalLocationView) this.mView).setOverviewVisibility(8);
        } else if (!z) {
            ((IGlobalLocationView) this.mView).setOverviewVisibility(0);
            this.isCarpoolOverviewState = false;
            ((IGlobalLocationView) this.mView).setOverviewIcon(getCarpoolNormalIcon());
        }
    }
}
