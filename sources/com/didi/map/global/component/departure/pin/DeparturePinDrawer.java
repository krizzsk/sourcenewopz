package com.didi.map.global.component.departure.pin;

import android.content.Context;
import android.view.View;
import com.didi.common.map.Map;
import com.didi.map.global.component.departure.bubble.DepartureBubble;
import com.didi.map.global.component.departure.bubble.DepartureBubbleFactory;
import com.didi.map.global.component.departure.model.PinStyle;
import com.didi.map.global.component.departure.pin.DepartureMarkerView;

public class DeparturePinDrawer implements IPinDrawer {

    /* renamed from: a */
    private DepartureMarkerWrapperView f25234a = null;

    /* renamed from: b */
    private Map f25235b;

    /* renamed from: c */
    private PinStyle f25236c;

    /* renamed from: d */
    private long f25237d;

    public void startJumpAnimation(DepartureMarkerView.AnimationFinishListener animationFinishListener) {
        DepartureMarkerWrapperView departureMarkerWrapperView = this.f25234a;
        if (departureMarkerWrapperView != null) {
            departureMarkerWrapperView.startJump(animationFinishListener);
        }
    }

    public void startLoadingAnimation() {
        DepartureMarkerWrapperView departureMarkerWrapperView = this.f25234a;
        if (departureMarkerWrapperView != null) {
            departureMarkerWrapperView.startLoading();
        }
    }

    public void stopAnimation() {
        DepartureMarkerWrapperView departureMarkerWrapperView = this.f25234a;
        if (departureMarkerWrapperView != null) {
            departureMarkerWrapperView.setNormal();
        }
    }

    public void setNoStopZoneStatus() {
        DepartureMarkerWrapperView departureMarkerWrapperView = this.f25234a;
        if (departureMarkerWrapperView != null) {
            departureMarkerWrapperView.setNoStopZoneStatus();
        }
    }

    public <T extends DepartureBubble> T createDepartureBubble(Class<T> cls) {
        DepartureMarkerWrapperView departureMarkerWrapperView = this.f25234a;
        if (departureMarkerWrapperView == null || departureMarkerWrapperView.getBubbleLayout() == null) {
            return null;
        }
        return DepartureBubbleFactory.createDepartureBubble(cls, this.f25234a.getBubbleLayout());
    }

    public void removeDepartureBubble(boolean z) {
        DepartureMarkerWrapperView departureMarkerWrapperView = this.f25234a;
        if (departureMarkerWrapperView != null) {
            departureMarkerWrapperView.removeViewFromBubbleLayout(z);
        }
    }

    public View getDepartureBubbleView() {
        DepartureMarkerWrapperView departureMarkerWrapperView = this.f25234a;
        if (departureMarkerWrapperView != null) {
            return departureMarkerWrapperView.getDepartureBubbleView();
        }
        return null;
    }

    public int getPinHeight() {
        DepartureMarkerWrapperView departureMarkerWrapperView = this.f25234a;
        if (departureMarkerWrapperView != null) {
            return departureMarkerWrapperView.getHeight();
        }
        return 0;
    }

    public void setDurationMillis(long j) {
        this.f25237d = j;
    }

    public void create(Context context, Map map) {
        this.f25235b = map;
    }

    public void destroy() {
        remove();
        this.f25235b = null;
        this.f25236c = null;
    }

    public void setConfigParam(PinStyle pinStyle) {
        if (pinStyle != null) {
            this.f25236c = pinStyle;
            DepartureMarkerWrapperView departureMarkerWrapperView = this.f25234a;
            if (departureMarkerWrapperView != null) {
                departureMarkerWrapperView.setPinStyle(pinStyle);
            }
        }
    }

    public void onMapVisible(boolean z) {
        if (!z) {
            stopAnimation();
        }
    }

    public void add() {
        if (this.f25235b != null && this.f25236c != null) {
            DepartureMarkerWrapperView departureMarkerWrapperView = new DepartureMarkerWrapperView(this.f25235b.getContext(), this.f25236c);
            this.f25234a = departureMarkerWrapperView;
            this.f25235b.setTopViewToCenter(departureMarkerWrapperView, this.f25236c.anchorX, this.f25236c.anchorY);
            this.f25234a.animateBar(this.f25237d);
        }
    }

    public void remove() {
        Map map = this.f25235b;
        if (map != null) {
            map.removeTopView();
        }
    }

    public void visible(boolean z) {
        DepartureMarkerWrapperView departureMarkerWrapperView = this.f25234a;
        if (departureMarkerWrapperView != null) {
            departureMarkerWrapperView.setVisibility(z ? 0 : 4);
        }
    }

    public boolean isVisible() {
        DepartureMarkerWrapperView departureMarkerWrapperView = this.f25234a;
        if (departureMarkerWrapperView == null || departureMarkerWrapperView.getVisibility() != 0) {
            return false;
        }
        return true;
    }
}
