package com.didi.map.global.sctx.mock;

import com.didi.common.map.model.LatLng;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 \u00152\u00020\u0001:\u0002\u0015\u0016B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b¨\u0006\u0017"}, mo175978d2 = {"Lcom/didi/map/global/sctx/mock/MockParam;", "", "()V", "destPosition", "Lcom/didi/common/map/model/LatLng;", "getDestPosition", "()Lcom/didi/common/map/model/LatLng;", "setDestPosition", "(Lcom/didi/common/map/model/LatLng;)V", "driverPosition", "getDriverPosition", "setDriverPosition", "location", "getLocation", "setLocation", "pickupPosition", "getPickupPosition", "setPickupPosition", "recommendPickupPosition", "getRecommendPickupPosition", "setRecommendPickupPosition", "Companion", "SingletonHolder", "base-sync-trip_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: MockParam.kt */
public final class MockParam {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static final MockParam f27631f = SingletonHolder.INSTANCE.getINSTANCE();

    /* renamed from: a */
    private LatLng f27632a;

    /* renamed from: b */
    private LatLng f27633b;

    /* renamed from: c */
    private LatLng f27634c;

    /* renamed from: d */
    private LatLng f27635d;

    /* renamed from: e */
    private LatLng f27636e;

    private MockParam() {
        this.f27632a = new LatLng(-25.57269d, -49.39746d);
        this.f27633b = new LatLng(-25.57527d, -49.39706d);
        this.f27634c = new LatLng(-25.57286d, -49.39946d);
        this.f27635d = new LatLng(-25.5736579d, -49.3989945d);
        this.f27636e = new LatLng(-25.56945d, -49.40373d);
    }

    public /* synthetic */ MockParam(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final LatLng getLocation() {
        return this.f27632a;
    }

    public final void setLocation(LatLng latLng) {
        this.f27632a = latLng;
    }

    public final LatLng getDriverPosition() {
        return this.f27633b;
    }

    public final void setDriverPosition(LatLng latLng) {
        this.f27633b = latLng;
    }

    public final LatLng getPickupPosition() {
        return this.f27634c;
    }

    public final void setPickupPosition(LatLng latLng) {
        this.f27634c = latLng;
    }

    public final LatLng getRecommendPickupPosition() {
        return this.f27635d;
    }

    public final void setRecommendPickupPosition(LatLng latLng) {
        this.f27635d = latLng;
    }

    public final LatLng getDestPosition() {
        return this.f27636e;
    }

    public final void setDestPosition(LatLng latLng) {
        this.f27636e = latLng;
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/map/global/sctx/mock/MockParam$Companion;", "", "()V", "instance", "Lcom/didi/map/global/sctx/mock/MockParam;", "getInstance", "()Lcom/didi/map/global/sctx/mock/MockParam;", "base-sync-trip_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: MockParam.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MockParam getInstance() {
            return MockParam.f27631f;
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/map/global/sctx/mock/MockParam$SingletonHolder;", "", "()V", "INSTANCE", "Lcom/didi/map/global/sctx/mock/MockParam;", "getINSTANCE", "()Lcom/didi/map/global/sctx/mock/MockParam;", "base-sync-trip_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: MockParam.kt */
    private static final class SingletonHolder {
        public static final SingletonHolder INSTANCE = new SingletonHolder();

        /* renamed from: INSTANCE  reason: collision with other field name */
        private static final MockParam f61732INSTANCE = new MockParam((DefaultConstructorMarker) null);

        private SingletonHolder() {
        }

        public final MockParam getINSTANCE() {
            return f61732INSTANCE;
        }
    }
}
