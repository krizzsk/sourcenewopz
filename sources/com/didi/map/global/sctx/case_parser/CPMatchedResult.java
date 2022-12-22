package com.didi.map.global.sctx.case_parser;

import com.didi.common.map.model.LatLng;
import com.didi.map.sdk.nav.inertia.SctxStateEnum;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\tR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, mo175978d2 = {"Lcom/didi/map/global/sctx/case_parser/CPMatchedResult;", "", "loc", "Lcom/didi/common/map/model/LatLng;", "isSimulate", "", "stateEnum", "Lcom/didi/map/sdk/nav/inertia/SctxStateEnum;", "(Lcom/didi/common/map/model/LatLng;ZLcom/didi/map/sdk/nav/inertia/SctxStateEnum;)V", "()Z", "getLoc", "()Lcom/didi/common/map/model/LatLng;", "getStateEnum", "()Lcom/didi/map/sdk/nav/inertia/SctxStateEnum;", "base-sync-trip_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: SctxCaseParser.kt */
public final class CPMatchedResult {

    /* renamed from: a */
    private final LatLng f27624a;

    /* renamed from: b */
    private final boolean f27625b;

    /* renamed from: c */
    private final SctxStateEnum f27626c;

    public CPMatchedResult(LatLng latLng, boolean z, SctxStateEnum sctxStateEnum) {
        Intrinsics.checkParameterIsNotNull(sctxStateEnum, "stateEnum");
        this.f27624a = latLng;
        this.f27625b = z;
        this.f27626c = sctxStateEnum;
    }

    public final LatLng getLoc() {
        return this.f27624a;
    }

    public final SctxStateEnum getStateEnum() {
        return this.f27626c;
    }

    public final boolean isSimulate() {
        return this.f27625b;
    }
}
