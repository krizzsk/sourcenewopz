package com.component.android.comp_location.presenter;

import android.os.Bundle;
import com.component.android.comp_location.AbsGlobalLocationPresenter;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.event.NonTalkingVisibilityEvent;
import com.didi.component.business.event.OpenRideVisibilityEvent;
import com.didi.component.business.event.SafeToolkitVisibilityEvent;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.event.BaseEventPublisher;

public class GlobalHomeLocationPresenter extends AbsGlobalLocationPresenter {
    /* access modifiers changed from: protected */
    public void onNonTalkingVisibilityChanged(NonTalkingVisibilityEvent nonTalkingVisibilityEvent) {
        computeNewTranslationY(getNewHeightWithUIOffset(this.mPaddingBottom));
    }

    /* access modifiers changed from: protected */
    public void onOpenRideVisibilityChanged(OpenRideVisibilityEvent openRideVisibilityEvent) {
        computeNewTranslationY(getNewHeightWithUIOffset(this.mPaddingBottom));
    }

    /* access modifiers changed from: protected */
    public void onSafeToolkitVisibilityChanged(SafeToolkitVisibilityEvent safeToolkitVisibilityEvent) {
        computeNewTranslationY(getNewHeightWithUIOffset(this.mPaddingBottom));
    }

    public GlobalHomeLocationPresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
    }

    /* access modifiers changed from: protected */
    public void onBackHome(Bundle bundle) {
        super.onBackHome(bundle);
        subscribe(BaseEventKeys.Map.EVENT_SHOW_RESET_MAP, this.mVisibilityChangedListener);
        subscribe(BaseEventKeys.Map.EVENT_HIDE_RESET_MAP, this.mVisibilityChangedListener);
        subscribe(BaseEventKeys.XPanel.EVENT_HEIGHT_CHANGED, this.mOnEventListener);
        subscribe(BaseEventKeys.XPanel.EVENT_HEIGHT_CHANGED_SCROLL_LISTENER, this.mOnScrollEventListener);
        subscribe(BaseEventKeys.Location.EVENT_PADDING_TOP, this.mPaddingTopEventListener);
        subscribe(BaseEventKeys.Location.EVENT_BEST_VIEW, this.mOnBestViewListener);
        BaseEventPublisher.getPublisher().subscribeSticky(BaseEventKeys.SafeToolkit.EVENT_VISIBILITY_CHANGED, this.mOnSafeToolkitVisibilityListener);
        subscribe(BaseEventKeys.OpenRide.EVENT_OPEN_RIDE_VISIBILITY_CHANGED, this.mOnOpenRideVisibilityListener);
        doBestView();
    }

    /* access modifiers changed from: protected */
    public void onLeaveHome() {
        super.onLeaveHome();
        unsubscribe(BaseEventKeys.Map.EVENT_SHOW_RESET_MAP, this.mVisibilityChangedListener);
        unsubscribe(BaseEventKeys.Map.EVENT_HIDE_RESET_MAP, this.mVisibilityChangedListener);
        unsubscribe(BaseEventKeys.XPanel.EVENT_HEIGHT_CHANGED, this.mOnEventListener);
        unsubscribe(BaseEventKeys.XPanel.EVENT_HEIGHT_CHANGED_SCROLL_LISTENER, this.mOnScrollEventListener);
        unsubscribe(BaseEventKeys.Location.EVENT_PADDING_TOP, this.mPaddingTopEventListener);
        unsubscribe(BaseEventKeys.Location.EVENT_BEST_VIEW, this.mOnBestViewListener);
        BaseEventPublisher.getPublisher().unsubscribe(BaseEventKeys.SafeToolkit.EVENT_VISIBILITY_CHANGED, this.mOnSafeToolkitVisibilityListener);
        unsubscribe(BaseEventKeys.OpenRide.EVENT_OPEN_RIDE_VISIBILITY_CHANGED, this.mOnOpenRideVisibilityListener);
    }

    public void onXPanelScrollChanged(int i) {
        if (this.mDefaultBottom < 0) {
            this.mDefaultBottom = i;
        }
        this.mPaddingBottom = i;
        computeNewTranslationY(getNewHeightWithUIOffset(this.mPaddingBottom));
    }
}
