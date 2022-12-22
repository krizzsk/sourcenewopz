package com.didi.map.global.flow.scene.order.confirm.normal;

import android.content.Context;
import com.didi.map.global.component.departure.view.LoadingInfoWindow;
import com.didi.map.global.flow.scene.PageSceneParam;
import com.didi.map.global.flow.scene.global.IMapChangeListener;
import com.didi.map.global.flow.scene.param.CommonMarkerParam;
import com.didi.map.global.flow.scene.simple.IDeparturePinCallback;
import com.didi.sdk.address.address.entity.Address;
import java.util.List;

public class OrderConfirmSceneParam extends PageSceneParam {

    /* renamed from: a */
    private IDeparturePinCallback f26655a;

    /* renamed from: b */
    private ILineSelectedListener f26656b;

    /* renamed from: c */
    private LoadingInfoWindow.CollideRectCallback f26657c;

    /* renamed from: d */
    private Address f26658d;

    /* renamed from: e */
    private Address f26659e;

    /* renamed from: f */
    private boolean f26660f;

    /* renamed from: g */
    private List<CommonMarkerParam> f26661g;

    /* renamed from: h */
    private Runnable f26662h;

    public Runnable getSlidingSuccessRunnable() {
        return this.f26662h;
    }

    public IDeparturePinCallback getPinCallback() {
        return this.f26655a;
    }

    public ILineSelectedListener getLineSelectedListener() {
        return this.f26656b;
    }

    public Address getStartAddress() {
        return this.f26658d;
    }

    public Address getEndAddress() {
        return this.f26659e;
    }

    public boolean isGuessDestination() {
        return this.f26660f;
    }

    public List<CommonMarkerParam> getMarkerParams() {
        return this.f26661g;
    }

    public LoadingInfoWindow.CollideRectCallback getCollideRectCallback() {
        return this.f26657c;
    }

    public OrderConfirmSceneParam(Builder builder) {
        super(builder);
        this.f26660f = builder.isGuessDestination;
        this.f26655a = builder.pinCallback;
        this.f26662h = builder.slidingSuccessRunnable;
        this.f26656b = builder.lineSelectedListener;
        this.f26658d = builder.startAddress;
        this.f26661g = builder.markerParams;
        this.f26659e = builder.endAddress;
        this.f26657c = builder.collideRectCallback;
    }

    public static class Builder extends PageSceneParam.Builder {
        /* access modifiers changed from: private */
        public LoadingInfoWindow.CollideRectCallback collideRectCallback;
        /* access modifiers changed from: private */
        public Address endAddress;
        /* access modifiers changed from: private */
        public boolean isGuessDestination;
        /* access modifiers changed from: private */
        public ILineSelectedListener lineSelectedListener;
        /* access modifiers changed from: private */
        public List<CommonMarkerParam> markerParams;
        /* access modifiers changed from: private */
        public IDeparturePinCallback pinCallback;
        /* access modifiers changed from: private */
        public Runnable slidingSuccessRunnable;
        /* access modifiers changed from: private */
        public Address startAddress;

        public /* bridge */ /* synthetic */ PageSceneParam.Builder context(Context context) {
            return super.context(context);
        }

        public /* bridge */ /* synthetic */ PageSceneParam.Builder mapChangeListener(IMapChangeListener iMapChangeListener) {
            return super.mapChangeListener(iMapChangeListener);
        }

        public Builder setPinCallback(IDeparturePinCallback iDeparturePinCallback) {
            this.pinCallback = iDeparturePinCallback;
            return this;
        }

        public Builder setCollideRectCallback(LoadingInfoWindow.CollideRectCallback collideRectCallback2) {
            this.collideRectCallback = collideRectCallback2;
            return this;
        }

        public Builder setLineSelectedListener(ILineSelectedListener iLineSelectedListener) {
            this.lineSelectedListener = iLineSelectedListener;
            return this;
        }

        public Builder setStartAddress(Address address) {
            this.startAddress = address;
            return this;
        }

        public Builder setEndAddress(Address address) {
            this.endAddress = address;
            return this;
        }

        public Builder setGuessDestination(boolean z) {
            this.isGuessDestination = z;
            return this;
        }

        public Builder setMarkerParams(List<CommonMarkerParam> list) {
            this.markerParams = list;
            return this;
        }

        public Builder setCarSlidingSuccessRunnable(Runnable runnable) {
            this.slidingSuccessRunnable = runnable;
            return this;
        }
    }
}
