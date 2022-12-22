package com.didi.map.global.model.location;

import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationUpdateOption;

public class LocationRegisterParam {

    /* renamed from: a */
    private DIDILocationUpdateOption.IntervalMode f27323a;

    /* renamed from: b */
    private LocType f27324b;

    /* renamed from: c */
    private NLPRegisterParam f27325c;

    public enum LocType {
        NLP,
        FLP
    }

    public LocationRegisterParam(DIDILocationUpdateOption.IntervalMode intervalMode, LocType locType) {
        this.f27323a = intervalMode;
        this.f27324b = locType;
    }

    public NLPRegisterParam getNlpRegisterParam() {
        return this.f27325c;
    }

    public void setNlpRegisterParam(NLPRegisterParam nLPRegisterParam) {
        this.f27325c = nLPRegisterParam;
    }

    public LocType getLocType() {
        return this.f27324b;
    }

    public DIDILocationUpdateOption.IntervalMode getMode() {
        return this.f27323a;
    }

    public String toString() {
        return "LocationRegisterParam{mode=" + this.f27323a + ", locType=" + this.f27324b + ", nlpRegisterParam=" + this.f27325c + '}';
    }
}
