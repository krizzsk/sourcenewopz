package com.didi.component.pudo.newversion;

import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.pudo.AbsPudoPresenter;
import com.didi.component.pudo.IPudoView;

public class ConfirmGetOnPresenter extends AbsPudoPresenter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public int f15240a = 0;

    /* renamed from: b */
    private BaseEventPublisher.OnEventListener<View> f15241b = new BaseEventPublisher.OnEventListener<View>() {
        public void onEvent(String str, View view) {
            if (view != null) {
                ((IPudoView) ConfirmGetOnPresenter.this.mView).setFenceCardView(view);
                ConfirmGetOnPresenter.this.m10935b();
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: c */
    public ViewTreeObserver f15242c;

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m10935b() {
        if (this.mView != null && ((IPudoView) this.mView).getView() != null) {
            ViewTreeObserver viewTreeObserver = this.f15242c;
            if (viewTreeObserver == null || !viewTreeObserver.isAlive()) {
                this.f15242c = ((IPudoView) this.mView).getView().getViewTreeObserver();
            }
            this.f15242c.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    if (ConfirmGetOnPresenter.this.f15242c.isAlive()) {
                        ConfirmGetOnPresenter.this.f15242c.removeOnGlobalLayoutListener(this);
                        int measuredHeight = ((IPudoView) ConfirmGetOnPresenter.this.mView).getView().getMeasuredHeight();
                        if (Math.abs(measuredHeight - ConfirmGetOnPresenter.this.f15240a) >= 200) {
                            ConfirmGetOnPresenter.this.doPublish(BaseEventKeys.Map.EVENT_GET_ON_FENCE_PADDING_BOTTOM, Integer.valueOf(measuredHeight));
                        }
                        int unused = ConfirmGetOnPresenter.this.f15240a = measuredHeight;
                    }
                }
            });
        }
    }

    public ConfirmGetOnPresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        BaseEventPublisher.getPublisher().subscribeSticky(BaseEventKeys.Confirm.EVENT_CONFIRM_GET_ON_SHOW_FENCE, this.f15241b);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        BaseEventPublisher.getPublisher().removeStickyEvent(BaseEventKeys.Confirm.EVENT_CONFIRM_GET_ON_SHOW_FENCE);
        unsubscribe(BaseEventKeys.Confirm.EVENT_CONFIRM_GET_ON_SHOW_FENCE, this.f15241b);
    }
}
