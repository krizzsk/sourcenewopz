package com.didi.map.sdk.departure.internal.pin;

import android.content.Context;
import android.view.View;
import com.didi.common.map.Map;
import com.didi.map.sdk.departure.internal.bubble.DepartureBubble;
import com.didi.map.sdk.departure.internal.bubble.DepartureBubbleFactory;
import com.didi.map.sdk.departure.internal.pin.DepartureMarkerView;
import com.didi.map.sdk.departure.param.PinStyle;

public class DeparturePinDrawer implements IPinDrawer {

    /* renamed from: a */
    private static final String f28200a = DeparturePinDrawer.class.getSimpleName();

    /* renamed from: b */
    private DepartureMarkerWrapperView f28201b = null;

    /* renamed from: c */
    private Map f28202c;

    /* renamed from: d */
    private PinStyle f28203d;

    /* renamed from: e */
    private long f28204e;

    public void startJumpAnimation(DepartureMarkerView.AnimationFinishListener animationFinishListener) {
        DepartureMarkerWrapperView departureMarkerWrapperView = this.f28201b;
        if (departureMarkerWrapperView != null) {
            departureMarkerWrapperView.startJump(animationFinishListener);
        }
    }

    public void startLoadingAnimation() {
        DepartureMarkerWrapperView departureMarkerWrapperView = this.f28201b;
        if (departureMarkerWrapperView != null) {
            departureMarkerWrapperView.startLoading();
        }
    }

    public void stopAnimation() {
        DepartureMarkerWrapperView departureMarkerWrapperView = this.f28201b;
        if (departureMarkerWrapperView != null) {
            departureMarkerWrapperView.setNormal();
        }
    }

    public void setNoStopZoneStatus() {
        DepartureMarkerWrapperView departureMarkerWrapperView = this.f28201b;
        if (departureMarkerWrapperView != null) {
            departureMarkerWrapperView.setNoStopZoneStatus();
        }
    }

    public <T extends DepartureBubble> T createDepartureBubble(Class<T> cls) {
        DepartureMarkerWrapperView departureMarkerWrapperView = this.f28201b;
        if (departureMarkerWrapperView == null || departureMarkerWrapperView.getBubbleLayout() == null) {
            return null;
        }
        return DepartureBubbleFactory.createDepartureBubble(cls, this.f28201b.getBubbleLayout());
    }

    public void removeDepartureBubble(boolean z) {
        DepartureMarkerWrapperView departureMarkerWrapperView = this.f28201b;
        if (departureMarkerWrapperView != null) {
            departureMarkerWrapperView.removeViewFromBubbleLayout(z);
        }
    }

    public View getDepartureBubbleView() {
        DepartureMarkerWrapperView departureMarkerWrapperView = this.f28201b;
        if (departureMarkerWrapperView != null) {
            return departureMarkerWrapperView.getDepartureBubbleView();
        }
        return null;
    }

    public int getPinHeight() {
        DepartureMarkerWrapperView departureMarkerWrapperView = this.f28201b;
        if (departureMarkerWrapperView != null) {
            return departureMarkerWrapperView.getHeight();
        }
        return 0;
    }

    public void setDurationMillis(long j) {
        this.f28204e = j;
    }

    public void create(Context context, Map map) {
        this.f28202c = map;
    }

    public void destroy() {
        remove();
        this.f28202c = null;
        this.f28203d = null;
    }

    public void setConfigParam(PinStyle pinStyle) {
        if (pinStyle != null) {
            this.f28203d = pinStyle;
            DepartureMarkerWrapperView departureMarkerWrapperView = this.f28201b;
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
        if (this.f28202c != null && this.f28203d != null) {
            DepartureMarkerWrapperView departureMarkerWrapperView = new DepartureMarkerWrapperView(this.f28202c.getContext(), this.f28203d);
            this.f28201b = departureMarkerWrapperView;
            this.f28202c.setTopViewToCenter(departureMarkerWrapperView, this.f28203d.anchorX, this.f28203d.anchorY);
            this.f28201b.animateBar(this.f28204e);
        }
    }

    public void remove() {
        Map map = this.f28202c;
        if (map != null) {
            map.removeTopView();
        }
    }

    public void visible(boolean z) {
        DepartureMarkerWrapperView departureMarkerWrapperView = this.f28201b;
        if (departureMarkerWrapperView != null) {
            departureMarkerWrapperView.setVisibility(z ? 0 : 4);
        }
    }

    public boolean isVisible() {
        DepartureMarkerWrapperView departureMarkerWrapperView = this.f28201b;
        if (departureMarkerWrapperView == null || departureMarkerWrapperView.getVisibility() != 0) {
            return false;
        }
        return true;
    }
}
