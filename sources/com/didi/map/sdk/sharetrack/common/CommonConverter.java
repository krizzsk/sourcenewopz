package com.didi.map.sdk.sharetrack.common;

import com.didi.map.sdk.proto.driver_gl.DoublePoint;
import com.didi.map.sdk.proto.driver_gl.OdPoint;
import com.didi.map.sdk.sharetrack.entity.OrderPoint;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/map/sdk/sharetrack/common/CommonConverter;", "", "()V", "Companion", "CommonShareTrack_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: CommonConverter.kt */
public final class CommonConverter {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004¨\u0006\b"}, mo175978d2 = {"Lcom/didi/map/sdk/sharetrack/common/CommonConverter$Companion;", "", "()V", "convertOrderPoints2OdPoints", "", "Lcom/didi/map/sdk/proto/driver_gl/OdPoint;", "orderPointsList", "Lcom/didi/map/sdk/sharetrack/entity/OrderPoint;", "CommonShareTrack_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: CommonConverter.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final List<OdPoint> convertOrderPoints2OdPoints(List<? extends OrderPoint> list) {
            List<OdPoint> arrayList = new ArrayList<>();
            if (list != null) {
                for (OrderPoint orderPoint : list) {
                    arrayList.add(new OdPoint(Long.valueOf(orderPoint.orderId), Integer.valueOf(orderPoint.orderType), new DoublePoint.Builder().lat(Float.valueOf((float) orderPoint.point.latitude)).lng(Float.valueOf((float) orderPoint.point.longitude)).build(), orderPoint.strOrderId, Integer.valueOf(orderPoint.pointType), Float.valueOf(0.0f), 0, (DoublePoint) null, ""));
                }
            }
            return arrayList;
        }
    }
}
