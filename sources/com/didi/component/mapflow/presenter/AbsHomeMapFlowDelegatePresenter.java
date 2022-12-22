package com.didi.component.mapflow.presenter;

import android.os.Bundle;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.mapflow.view.IMapFlowDelegateView;

public abstract class AbsHomeMapFlowDelegatePresenter extends AbsBeforeOrderMapFlowDelegatePresenter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public int f14372a = 0;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f14373b = 0;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f14374c = 0;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f14375d = true;

    /* renamed from: e */
    private BaseEventPublisher.OnEventListener<Integer> f14376e = new BaseEventPublisher.OnEventListener<Integer>() {
        public void onEvent(String str, Integer num) {
            int unused = AbsHomeMapFlowDelegatePresenter.this.f14372a = num.intValue();
            ((IMapFlowDelegateView) AbsHomeMapFlowDelegatePresenter.this.mView).addBottomMask(AbsHomeMapFlowDelegatePresenter.this.f14372a + (AbsHomeMapFlowDelegatePresenter.this.f14375d ? AbsHomeMapFlowDelegatePresenter.this.f14374c : 0) + AbsHomeMapFlowDelegatePresenter.this.f14373b);
        }
    };

    /* renamed from: f */
    private BaseEventPublisher.OnEventListener<Integer> f14377f = new BaseEventPublisher.OnEventListener<Integer>() {
        public void onEvent(String str, Integer num) {
            int unused = AbsHomeMapFlowDelegatePresenter.this.f14373b = num.intValue();
            AbsHomeMapFlowDelegatePresenter absHomeMapFlowDelegatePresenter = AbsHomeMapFlowDelegatePresenter.this;
            int unused2 = absHomeMapFlowDelegatePresenter.f14372a = absHomeMapFlowDelegatePresenter.mBusinessContext.getBizBarHeight();
            ((IMapFlowDelegateView) AbsHomeMapFlowDelegatePresenter.this.mView).addBottomMask(AbsHomeMapFlowDelegatePresenter.this.f14372a + (AbsHomeMapFlowDelegatePresenter.this.f14375d ? AbsHomeMapFlowDelegatePresenter.this.f14374c : 0) + AbsHomeMapFlowDelegatePresenter.this.f14373b);
        }
    };

    /* renamed from: g */
    private BaseEventPublisher.OnEventListener<Integer> f14378g = new BaseEventPublisher.OnEventListener<Integer>() {
        public void onEvent(String str, Integer num) {
            int unused = AbsHomeMapFlowDelegatePresenter.this.f14374c = num.intValue();
            AbsHomeMapFlowDelegatePresenter absHomeMapFlowDelegatePresenter = AbsHomeMapFlowDelegatePresenter.this;
            int unused2 = absHomeMapFlowDelegatePresenter.f14372a = absHomeMapFlowDelegatePresenter.mBusinessContext.getBizBarHeight();
            ((IMapFlowDelegateView) AbsHomeMapFlowDelegatePresenter.this.mView).addBottomMask(AbsHomeMapFlowDelegatePresenter.this.f14372a + (AbsHomeMapFlowDelegatePresenter.this.f14375d ? AbsHomeMapFlowDelegatePresenter.this.f14374c : 0) + AbsHomeMapFlowDelegatePresenter.this.f14373b);
        }
    };

    public AbsHomeMapFlowDelegatePresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        subscribe("event_show_new_sug_page", this.mShowNewSugPageListener);
        subscribe(BaseEventKeys.Home.EVENT_SHOW_NAV_BAR, this.f14376e);
        subscribe(BaseEventKeys.XPanel.EVENT_HEIGHT_CHANGED, this.f14377f);
        subscribe(BaseEventKeys.XBanner.EVENT_XBANNER_GET_HEIGHT, this.f14378g);
        setCurrentPage("home");
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        unsubscribe("event_show_new_sug_page", this.mShowNewSugPageListener);
        unsubscribe(BaseEventKeys.Home.EVENT_SHOW_NAV_BAR, this.f14376e);
        unsubscribe(BaseEventKeys.XPanel.EVENT_HEIGHT_CHANGED, this.f14377f);
        unsubscribe(BaseEventKeys.XBanner.EVENT_XBANNER_GET_HEIGHT, this.f14378g);
        setCurrentPage("");
    }

    /* access modifiers changed from: protected */
    public void onLeaveHome() {
        super.onLeaveHome();
        unsubscribe("event_show_new_sug_page", this.mShowNewSugPageListener);
        unsubscribe(BaseEventKeys.Home.EVENT_SHOW_NAV_BAR, this.f14376e);
        unsubscribe(BaseEventKeys.XPanel.EVENT_HEIGHT_CHANGED, this.f14377f);
        unsubscribe(BaseEventKeys.XBanner.EVENT_XBANNER_GET_HEIGHT, this.f14378g);
        ((IMapFlowDelegateView) this.mView).removeBottomMask();
        setCurrentPage("");
    }

    /* access modifiers changed from: protected */
    public void onBackHome(Bundle bundle) {
        super.onBackHome(bundle);
        subscribe("event_show_new_sug_page", this.mShowNewSugPageListener);
        subscribe(BaseEventKeys.Home.EVENT_SHOW_NAV_BAR, this.f14376e);
        subscribe(BaseEventKeys.XPanel.EVENT_HEIGHT_CHANGED, this.f14377f);
        subscribe(BaseEventKeys.XBanner.EVENT_XBANNER_GET_HEIGHT, this.f14378g);
        setCurrentPage("home");
    }
}
