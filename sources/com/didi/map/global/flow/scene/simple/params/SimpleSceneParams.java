package com.didi.map.global.flow.scene.simple.params;

import android.content.Context;
import com.didi.map.global.component.departure.model.DepartureLocationInfo;
import com.didi.map.global.component.departure.model.PinStyle;
import com.didi.map.global.flow.scene.PageSceneParam;
import com.didi.map.global.flow.scene.global.IMapChangeListener;
import com.didi.map.global.flow.scene.simple.IDeparturePinCallback;
import com.didi.sdk.address.address.entity.Address;

public class SimpleSceneParams extends PageSceneParam {

    /* renamed from: a */
    private IDeparturePinCallback f27042a;

    /* renamed from: b */
    private Address f27043b;

    /* renamed from: c */
    private boolean f27044c;

    /* renamed from: d */
    private PinStyle f27045d;

    /* renamed from: e */
    private DepartureLocationInfo f27046e;

    /* renamed from: f */
    private int f27047f;

    private SimpleSceneParams(Builder builder) {
        super(builder);
        this.f27042a = builder.componentCallback;
        this.f27046e = builder.departureLocationInfo;
        this.f27043b = builder.endInfo;
        this.f27044c = builder.hasWayPoint;
        this.f27045d = builder.pinStyle;
        this.f27047f = builder.sceneType;
    }

    public IDeparturePinCallback getDeparturePinCallback() {
        return this.f27042a;
    }

    public Address getEndInfo() {
        return this.f27043b;
    }

    public boolean isHasWayPoint() {
        return this.f27044c;
    }

    public PinStyle getPinStyle() {
        return this.f27045d;
    }

    public DepartureLocationInfo getDepartureLocationInfo() {
        return this.f27046e;
    }

    public int getSceneType() {
        return this.f27047f;
    }

    public static class Builder extends PageSceneParam.Builder {
        /* access modifiers changed from: private */
        public IDeparturePinCallback componentCallback;
        /* access modifiers changed from: private */
        public DepartureLocationInfo departureLocationInfo;
        /* access modifiers changed from: private */
        public Address endInfo;
        /* access modifiers changed from: private */
        public boolean hasWayPoint;
        /* access modifiers changed from: private */
        public PinStyle pinStyle;
        /* access modifiers changed from: private */
        public int sceneType = 0;

        public Builder mapChangeListener(IMapChangeListener iMapChangeListener) {
            return (Builder) super.mapChangeListener(iMapChangeListener);
        }

        public Builder context(Context context) {
            return (Builder) super.context(context);
        }

        public Builder departurePinCallback(IDeparturePinCallback iDeparturePinCallback) {
            this.componentCallback = iDeparturePinCallback;
            return this;
        }

        public Builder endInfo(Address address) {
            this.endInfo = address;
            return this;
        }

        public Builder hasWayPoint(boolean z) {
            this.hasWayPoint = z;
            return this;
        }

        public Builder pinStyle(PinStyle pinStyle2) {
            this.pinStyle = pinStyle2;
            return this;
        }

        public Builder departureLocationInfo(DepartureLocationInfo departureLocationInfo2) {
            this.departureLocationInfo = departureLocationInfo2;
            return this;
        }

        public Builder sceneType(int i) {
            this.sceneType = i;
            return this;
        }

        public SimpleSceneParams build() {
            return new SimpleSceneParams(this);
        }
    }
}
