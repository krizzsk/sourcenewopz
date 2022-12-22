package com.didi.map.global.flow.scene.order.serving.scene.sctx;

import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, mo175978d2 = {"Lcom/didi/map/global/flow/scene/order/serving/scene/sctx/SerialOrderErrorEnum;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "ORA_LAST_ORDER_HAS_OD_NO_DEST", "ORA_LAST_ORDER_POINT_TYPE_ERROR", "ORA_LAST_ORDER_COORDINATE_ERROR", "ORA_LAST_ORDER_OD_TYPE_ERROR", "ORA_LAST_ORDER_CURDST_NULL_ODPOINTS_NONNULL", "ORA_LAST_ORDER_CURDST_NONNULL_ODPOINTS_NULL", "ORA_LAST_ORDER_CURDST_POINT_TOO_FAR_FROM_FIRST_ODPOINT", "ORA_ROUTE_POINTS_NULL", "ORA_ETA_OR_EDA_NULL", "ORA_DRIVER_LOC_NULL", "UI_NO_ICON", "UI_NO_LAST_DST_TEXT", "UI_DRAW_TRAFFIC_DATA_FAIL", "sdk-mapflow_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SctxOmegaHelper.kt */
public enum SerialOrderErrorEnum {
    ORA_LAST_ORDER_HAS_OD_NO_DEST(101),
    ORA_LAST_ORDER_POINT_TYPE_ERROR(102),
    ORA_LAST_ORDER_COORDINATE_ERROR(103),
    ORA_LAST_ORDER_OD_TYPE_ERROR(104),
    ORA_LAST_ORDER_CURDST_NULL_ODPOINTS_NONNULL(105),
    ORA_LAST_ORDER_CURDST_NONNULL_ODPOINTS_NULL(106),
    ORA_LAST_ORDER_CURDST_POINT_TOO_FAR_FROM_FIRST_ODPOINT(107),
    ORA_ROUTE_POINTS_NULL(108),
    ORA_ETA_OR_EDA_NULL(109),
    ORA_DRIVER_LOC_NULL(110),
    UI_NO_ICON(111),
    UI_NO_LAST_DST_TEXT(112),
    UI_DRAW_TRAFFIC_DATA_FAIL(113);
    
    private final int value;

    private SerialOrderErrorEnum(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
