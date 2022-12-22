package com.didi.component.notalk.presenter;

import android.os.Bundle;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.event.SafeToolkitVisibilityEvent;
import com.didi.component.common.base.BaseExpressPresenter;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.notalk.view.INoTalkView;

public abstract class AbsNoTalkPresenter extends BaseExpressPresenter<INoTalkView> {

    /* renamed from: a */
    int f14707a;

    /* renamed from: b */
    int f14708b;

    /* renamed from: c */
    private int f14709c;

    /* renamed from: d */
    private float f14710d = 0.0f;
    protected BaseEventPublisher.OnEventListener mOnEventListener = new BaseEventPublisher.OnEventListener<Integer>() {
        public void onEvent(String str, Integer num) {
            if (str.equalsIgnoreCase(BaseEventKeys.XPanel.EVENT_HEIGHT_CHANGED)) {
                AbsNoTalkPresenter.this.onXPanelDefaultHeightChanged(num.intValue());
            }
        }
    };
    protected BaseEventPublisher.OnEventListener mOnSafeToolkitVisibilityListener = new BaseEventPublisher.OnEventListener<SafeToolkitVisibilityEvent>() {
        public void onEvent(String str, SafeToolkitVisibilityEvent safeToolkitVisibilityEvent) {
            if (safeToolkitVisibilityEvent.isVisible) {
                AbsNoTalkPresenter.this.f14708b = safeToolkitVisibilityEvent.mViewHeight;
            } else {
                AbsNoTalkPresenter.this.f14708b = 0;
            }
            AbsNoTalkPresenter absNoTalkPresenter = AbsNoTalkPresenter.this;
            int newHeightWithUIOffset = absNoTalkPresenter.getNewHeightWithUIOffset(absNoTalkPresenter.f14707a);
            AbsNoTalkPresenter absNoTalkPresenter2 = AbsNoTalkPresenter.this;
            absNoTalkPresenter2.m10500a((-newHeightWithUIOffset) - absNoTalkPresenter2.f14708b);
        }
    };
    protected BaseEventPublisher.OnEventListener mOnScrollEventListener = new BaseEventPublisher.OnEventListener<Integer>() {
        public void onEvent(String str, Integer num) {
            if (str.equalsIgnoreCase(BaseEventKeys.XPanel.EVENT_HEIGHT_CHANGED_SCROLL_LISTENER)) {
                AbsNoTalkPresenter.this.onXPanelHeightScrollChanged(num.intValue());
            }
        }
    };

    public abstract void showNonTalkingMeetCard();

    public AbsNoTalkPresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        subscribe(BaseEventKeys.XPanel.EVENT_HEIGHT_CHANGED, this.mOnEventListener);
        subscribe(BaseEventKeys.XPanel.EVENT_HEIGHT_CHANGED_SCROLL_LISTENER, this.mOnScrollEventListener);
        BaseEventPublisher.getPublisher().subscribeSticky(BaseEventKeys.SafeToolkit.EVENT_VISIBILITY_CHANGED, this.mOnSafeToolkitVisibilityListener);
        doPublish(BaseEventKeys.XPanel.EVENT_REQUEST_FETCH_DEFAULT_HEIGHT);
        doPublish(BaseEventKeys.XPanel.EVENT_REQUEST_FETCH_DEFAULT_SCROLL_HEIGHT);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        unsubscribe(BaseEventKeys.XPanel.EVENT_HEIGHT_CHANGED, this.mOnEventListener);
        unsubscribe(BaseEventKeys.XPanel.EVENT_HEIGHT_CHANGED_SCROLL_LISTENER, this.mOnScrollEventListener);
        unsubscribe(BaseEventKeys.SafeToolkit.EVENT_VISIBILITY_CHANGED, this.mOnSafeToolkitVisibilityListener);
    }

    /* access modifiers changed from: protected */
    public void onXPanelDefaultHeightChanged(int i) {
        if (i >= 0 && this.f14709c != i) {
            this.f14709c = i;
            int i2 = this.f14707a;
            if (i2 > i) {
                onXPanelHeightScrollChanged(i2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onXPanelHeightScrollChanged(int i) {
        if (this.f14709c < 0) {
            this.f14709c = i;
        }
        this.f14707a = i;
        m10500a((-getNewHeightWithUIOffset(i)) - this.f14708b);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10500a(int i) {
        if (this.mView != null) {
            ((INoTalkView) this.mView).setTranslationY(i);
        }
    }

    /* access modifiers changed from: protected */
    public int getNewHeightWithUIOffset(int i) {
        if (this.mView == null) {
            return i;
        }
        float f = (float) i;
        float f2 = this.f14710d;
        return f > f2 ? (int) (f + f2) : i;
    }
}
