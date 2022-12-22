package com.didi.map.global.flow.scene.mainpage;

import android.content.Context;
import com.didi.map.global.flow.scene.CarSlidingParam;
import com.didi.map.global.flow.scene.PageSceneParam;
import com.didi.map.global.flow.scene.global.FenceChangeListener;
import com.didi.map.global.flow.scene.global.ICarSlidingChangeListener;
import com.didi.map.global.flow.scene.global.IMapChangeListener;
import com.didi.map.global.flow.scene.global.IMapLocationLoadedListener;
import com.didi.map.global.flow.scene.global.IReverseGeoListener;
import com.sdk.poibase.model.AddressParam;

public class MainPageSceneParam extends PageSceneParam {

    /* renamed from: a */
    private IMapLocationLoadedListener f26325a;

    /* renamed from: b */
    private AddressParam f26326b;

    /* renamed from: c */
    private FenceChangeListener f26327c;

    /* renamed from: d */
    private IReverseGeoListener f26328d;

    /* renamed from: e */
    private CarSlidingParam f26329e;

    /* renamed from: f */
    private ICarSlidingChangeListener f26330f;

    /* renamed from: g */
    private boolean f26331g;

    /* renamed from: h */
    private IMapEventCallBack f26332h;

    public IMapLocationLoadedListener getMapLocationLoadedCallback() {
        return this.f26325a;
    }

    public AddressParam getAddressParam() {
        return this.f26326b;
    }

    public FenceChangeListener getFenceChangeListener() {
        return this.f26327c;
    }

    public IReverseGeoListener getReverseGeoListener() {
        return this.f26328d;
    }

    public CarSlidingParam getSlidingParam() {
        return this.f26329e;
    }

    public ICarSlidingChangeListener getCarSlidingChangeListener() {
        return this.f26330f;
    }

    public boolean isSuperAppScene() {
        return this.f26331g;
    }

    public IMapEventCallBack getMapClickListener() {
        return this.f26332h;
    }

    private MainPageSceneParam(Builder builder) {
        super(builder);
        this.f26325a = builder.mapLocationLoadedCallback;
        this.f26326b = builder.addressParam;
        this.f26327c = builder.fenceChangeListener;
        this.f26328d = builder.reverseGeoListener;
        this.f26329e = builder.slidingParam;
        this.f26330f = builder.carSlidingChangeListener;
        this.f26331g = builder.isSuperAppScene;
        this.f26332h = builder.mapClickListener;
    }

    public static class Builder extends PageSceneParam.Builder {
        AddressParam addressParam;
        ICarSlidingChangeListener carSlidingChangeListener;
        FenceChangeListener fenceChangeListener;
        boolean isSuperAppScene;
        IMapEventCallBack mapClickListener;
        IMapLocationLoadedListener mapLocationLoadedCallback;
        IReverseGeoListener reverseGeoListener;
        CarSlidingParam slidingParam;

        public Builder mapChangeListener(IMapChangeListener iMapChangeListener) {
            return (Builder) super.mapChangeListener(iMapChangeListener);
        }

        public Builder context(Context context) {
            return (Builder) super.context(context);
        }

        public Builder locationLoaded(IMapLocationLoadedListener iMapLocationLoadedListener) {
            this.mapLocationLoadedCallback = iMapLocationLoadedListener;
            return this;
        }

        public Builder addressParam(AddressParam addressParam2) {
            this.addressParam = addressParam2;
            return this;
        }

        public Builder fenceChange(FenceChangeListener fenceChangeListener2) {
            this.fenceChangeListener = fenceChangeListener2;
            return this;
        }

        public Builder reverseGeo(IReverseGeoListener iReverseGeoListener) {
            this.reverseGeoListener = iReverseGeoListener;
            return this;
        }

        public Builder slidingParam(CarSlidingParam carSlidingParam) {
            this.slidingParam = carSlidingParam;
            return this;
        }

        public Builder slidingChange(ICarSlidingChangeListener iCarSlidingChangeListener) {
            this.carSlidingChangeListener = iCarSlidingChangeListener;
            return this;
        }

        public Builder isSuperAppScene(boolean z) {
            this.isSuperAppScene = z;
            return this;
        }

        public Builder iMapEventCallBack(IMapEventCallBack iMapEventCallBack) {
            this.mapClickListener = iMapEventCallBack;
            return this;
        }

        public MainPageSceneParam build() {
            return new MainPageSceneParam(this);
        }
    }
}
