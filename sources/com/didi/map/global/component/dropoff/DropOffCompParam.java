package com.didi.map.global.component.dropoff;

import com.didi.map.global.component.dropoff.model.DropOffLocationInfo;
import com.didi.map.global.component.dropoff.pin.PinStyle;
import com.didi.map.global.component.recmarker.model.RecPointStyle;
import com.sdk.poibase.CallFrom;

public class DropOffCompParam {

    /* renamed from: a */
    private CallFrom f25430a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public DropOffLocationInfo f25431b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public PinStyle f25432c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public RecPointStyle f25433d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public float f25434e;

    /* renamed from: f */
    private IDropOffComponentCallback f25435f;

    private DropOffCompParam(CallFrom callFrom, IDropOffComponentCallback iDropOffComponentCallback) {
        this.f25430a = callFrom;
        this.f25435f = iDropOffComponentCallback;
    }

    public CallFrom getReqCallerId() {
        return this.f25430a;
    }

    public DropOffLocationInfo getLocationInfo() {
        return this.f25431b;
    }

    public PinStyle getPinStyle() {
        return this.f25432c;
    }

    public RecPointStyle getRecPointStyle() {
        return this.f25433d;
    }

    public float getZoom() {
        return this.f25434e;
    }

    public IDropOffComponentCallback getComponentCallback() {
        return this.f25435f;
    }

    public static class Builder {
        private DropOffCompParam compParam;

        public Builder(CallFrom callFrom, IDropOffComponentCallback iDropOffComponentCallback) {
            this.compParam = new DropOffCompParam(callFrom, iDropOffComponentCallback);
        }

        public Builder locationInfo(DropOffLocationInfo dropOffLocationInfo) {
            DropOffLocationInfo unused = this.compParam.f25431b = dropOffLocationInfo;
            return this;
        }

        public Builder pinStyle(PinStyle pinStyle) {
            PinStyle unused = this.compParam.f25432c = pinStyle;
            return this;
        }

        public Builder recPointStyle(RecPointStyle recPointStyle) {
            RecPointStyle unused = this.compParam.f25433d = recPointStyle;
            return this;
        }

        public Builder zoom(float f) {
            float unused = this.compParam.f25434e = f;
            return this;
        }

        public DropOffCompParam build() {
            return this.compParam;
        }
    }
}
