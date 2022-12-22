package com.didi.map.global.flow.scene.order.serving.scene.sctx;

import com.didi.map.global.model.omega.GlobalOmegaTracker;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002JD\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013¨\u0006\u0014"}, mo175978d2 = {"Lcom/didi/map/global/flow/scene/order/serving/scene/sctx/SctxOmegaHelper;", "", "()V", "trackSerialOrderError", "", "errorEnum", "Lcom/didi/map/global/flow/scene/order/serving/scene/sctx/SerialOrderErrorEnum;", "orderId", "", "lastOrderId", "trackSerialOrderOraRelatedError", "routeRes", "Lcom/didi/map/sdk/proto/driver_gl/MapPassengeOrderRouteRes;", "routePoints", "", "Lcom/didi/common/map/model/LatLng;", "markManager", "Lcom/didi/map/global/flow/scene/order/serving/components/MarkerManager;", "needAddSerialOrderPassPointMarker", "", "sdk-mapflow_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SctxOmegaHelper.kt */
public final class SctxOmegaHelper {
    public static final SctxOmegaHelper INSTANCE = new SctxOmegaHelper();

    private SctxOmegaHelper() {
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v0, resolved type: com.didi.map.sdk.proto.driver_gl.TrafficItem} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v9, resolved type: com.didi.map.sdk.proto.driver_gl.TrafficItem} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v10, resolved type: com.didi.map.sdk.proto.driver_gl.TrafficItem} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v11, resolved type: com.didi.map.sdk.proto.driver_gl.TrafficItem} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v12, resolved type: com.didi.map.sdk.proto.driver_gl.TrafficItem} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v7, resolved type: com.didi.map.sdk.proto.driver_gl.TrafficItem} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v16, resolved type: com.didi.map.sdk.proto.driver_gl.TrafficItem} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v21, resolved type: com.didi.map.sdk.proto.driver_gl.TrafficItem} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v32, resolved type: java.lang.Float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v22, resolved type: java.lang.Float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v26, resolved type: java.lang.Float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v40, resolved type: java.lang.Float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v1, resolved type: com.didi.map.sdk.proto.driver_gl.TrafficItem} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v2, resolved type: com.didi.map.sdk.proto.driver_gl.TrafficItem} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v2, resolved type: com.didi.map.sdk.proto.driver_gl.OdPoint} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v104, resolved type: java.lang.Float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v63, resolved type: java.lang.Float} */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0193, code lost:
        if ((r10 >= 0 && r10 <= r7) == false) goto L_0x0195;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x02a8, code lost:
        if (((r3 == null || (r5 = r3.distance) == null) ? 0 : r5.intValue()) == 0) goto L_0x02aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:199:0x02e8, code lost:
        if (com.didi.common.map.util.LatLngUtils.locateCorrect(r5, r7 == 0 ? 0.0d : (double) r7.floatValue()) == false) goto L_0x02ea;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0160  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0167  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x016e  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0181  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0197  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x019e  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x01b3  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x01cb A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x01d2  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x01fb A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x0210  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x0217  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x026e  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x0271  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x0287  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x028e  */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x0295  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x029b  */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x02b1  */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x02b4  */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x02b8  */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x030a  */
    /* JADX WARNING: Removed duplicated region for block: B:219:0x0335  */
    /* JADX WARNING: Removed duplicated region for block: B:220:0x0338  */
    /* JADX WARNING: Removed duplicated region for block: B:223:0x034e  */
    /* JADX WARNING: Removed duplicated region for block: B:262:0x03b6  */
    /* JADX WARNING: Removed duplicated region for block: B:270:0x03a8 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:274:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0138  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void trackSerialOrderOraRelatedError(java.lang.String r26, java.lang.String r27, com.didi.map.sdk.proto.driver_gl.MapPassengeOrderRouteRes r28, java.util.List<com.didi.common.map.model.LatLng> r29, com.didi.map.global.flow.scene.order.serving.components.MarkerManager r30, boolean r31) {
        /*
            r25 = this;
            r0 = r25
            r1 = r26
            r2 = r27
            r3 = r28
            r4 = r29
            r5 = r30
            java.lang.String r6 = "markManager"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r6)
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.List r6 = (java.util.List) r6
            if (r3 != 0) goto L_0x001c
            r8 = 0
            goto L_0x001e
        L_0x001c:
            java.lang.Integer r8 = r3.curDstRouteGeoIndex
        L_0x001e:
            r9 = 0
            if (r8 == 0) goto L_0x0035
            java.lang.Integer r8 = r3.curDstRouteGeoIndex
            java.lang.String r10 = "routeRes.curDstRouteGeoIndex"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r10)
            java.lang.Number r8 = (java.lang.Number) r8
            int r8 = r8.intValue()
            if (r8 >= 0) goto L_0x0032
            goto L_0x0035
        L_0x0032:
            java.lang.Integer r8 = r3.curDstRouteGeoIndex
            goto L_0x0039
        L_0x0035:
            java.lang.Integer r8 = java.lang.Integer.valueOf(r9)
        L_0x0039:
            r12 = 1
            if (r3 != 0) goto L_0x003d
            goto L_0x0041
        L_0x003d:
            java.util.List<com.didi.map.sdk.proto.driver_gl.OdPoint> r13 = r3.odPoints
            if (r13 != 0) goto L_0x004c
        L_0x0041:
            r24 = r8
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            goto L_0x012f
        L_0x004c:
            java.lang.Iterable r13 = (java.lang.Iterable) r13
            java.util.Iterator r13 = r13.iterator()
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
        L_0x005a:
            boolean r19 = r13.hasNext()
            if (r19 == 0) goto L_0x012b
            java.lang.Object r19 = r13.next()
            int r20 = r14 + 1
            if (r14 >= 0) goto L_0x006b
            kotlin.collections.CollectionsKt.throwIndexOverflow()
        L_0x006b:
            r14 = r19
            com.didi.map.sdk.proto.driver_gl.OdPoint r14 = (com.didi.map.sdk.proto.driver_gl.OdPoint) r14
            if (r14 != 0) goto L_0x0073
            r9 = 0
            goto L_0x0075
        L_0x0073:
            java.lang.Integer r9 = r14.pointType
        L_0x0075:
            r10 = 2
            if (r9 != 0) goto L_0x0079
            goto L_0x007f
        L_0x0079:
            int r9 = r9.intValue()
            if (r9 == r10) goto L_0x0081
        L_0x007f:
            r16 = 1
        L_0x0081:
            if (r14 != 0) goto L_0x0085
            r9 = 0
            goto L_0x0087
        L_0x0085:
            com.didi.map.sdk.proto.driver_gl.DoublePoint r9 = r14.point
        L_0x0087:
            if (r9 != 0) goto L_0x008d
        L_0x0089:
            r11 = r8
            r7 = 0
            goto L_0x0099
        L_0x008d:
            java.lang.Double r9 = r9.dlat
            if (r9 != 0) goto L_0x0092
            goto L_0x0089
        L_0x0092:
            double r21 = r9.doubleValue()
            r11 = r8
            r7 = r21
        L_0x0099:
            if (r14 != 0) goto L_0x009d
            r9 = 0
            goto L_0x009f
        L_0x009d:
            com.didi.map.sdk.proto.driver_gl.DoublePoint r9 = r14.point
        L_0x009f:
            if (r9 != 0) goto L_0x00a6
        L_0x00a1:
            r24 = r11
            r10 = 0
            goto L_0x00b3
        L_0x00a6:
            java.lang.Double r9 = r9.dlng
            if (r9 != 0) goto L_0x00ab
            goto L_0x00a1
        L_0x00ab:
            double r22 = r9.doubleValue()
            r24 = r11
            r10 = r22
        L_0x00b3:
            boolean r7 = com.didi.common.map.util.LatLngUtils.locateCorrect(r7, r10)
            if (r7 != 0) goto L_0x00bb
            r17 = 1
        L_0x00bb:
            if (r14 != 0) goto L_0x00bf
            r7 = 0
            goto L_0x00c1
        L_0x00bf:
            java.lang.Integer r7 = r14.odType
        L_0x00c1:
            if (r7 != 0) goto L_0x00c4
            goto L_0x00ca
        L_0x00c4:
            int r7 = r7.intValue()
            if (r7 == r12) goto L_0x00dc
        L_0x00ca:
            if (r14 != 0) goto L_0x00ce
            r7 = 0
            goto L_0x00d0
        L_0x00ce:
            java.lang.Integer r7 = r14.odType
        L_0x00d0:
            if (r7 != 0) goto L_0x00d3
            goto L_0x00da
        L_0x00d3:
            int r7 = r7.intValue()
            r8 = 2
            if (r7 == r8) goto L_0x00dc
        L_0x00da:
            r18 = 1
        L_0x00dc:
            if (r14 != 0) goto L_0x00e0
            r7 = 0
            goto L_0x00e2
        L_0x00e0:
            java.lang.Integer r7 = r14.pointType
        L_0x00e2:
            if (r7 != 0) goto L_0x00e5
            goto L_0x00fc
        L_0x00e5:
            int r7 = r7.intValue()
            r8 = 2
            if (r7 != r8) goto L_0x00fc
            if (r14 != 0) goto L_0x00f0
            r7 = 0
            goto L_0x00f2
        L_0x00f0:
            java.lang.Integer r7 = r14.odType
        L_0x00f2:
            if (r7 != 0) goto L_0x00f5
            goto L_0x00fc
        L_0x00f5:
            int r7 = r7.intValue()
            if (r7 != r12) goto L_0x00fc
            r15 = r14
        L_0x00fc:
            if (r14 != 0) goto L_0x0100
            r7 = 0
            goto L_0x0102
        L_0x0100:
            java.lang.Integer r7 = r14.pointType
        L_0x0102:
            if (r7 != 0) goto L_0x0105
            goto L_0x0124
        L_0x0105:
            int r7 = r7.intValue()
            r8 = 2
            if (r7 != r8) goto L_0x0124
            if (r14 != 0) goto L_0x0110
            r7 = 0
            goto L_0x0112
        L_0x0110:
            java.lang.Integer r7 = r14.odType
        L_0x0112:
            if (r7 != 0) goto L_0x0115
            goto L_0x0124
        L_0x0115:
            int r7 = r7.intValue()
            if (r7 != r8) goto L_0x0124
            java.lang.String r7 = "odPoint"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r14, r7)
            r6.add(r14)
        L_0x0124:
            r14 = r20
            r8 = r24
            r9 = 0
            goto L_0x005a
        L_0x012b:
            r24 = r8
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
        L_0x012f:
            if (r3 != 0) goto L_0x0133
        L_0x0131:
            r7 = 0
            goto L_0x0143
        L_0x0133:
            java.util.List<com.didi.map.sdk.proto.driver_gl.OdPoint> r7 = r3.odPoints
            if (r7 != 0) goto L_0x0138
            goto L_0x0131
        L_0x0138:
            java.util.Collection r7 = (java.util.Collection) r7
            boolean r7 = r7.isEmpty()
            r7 = r7 ^ r12
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
        L_0x0143:
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r12)
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r8)
            if (r7 == 0) goto L_0x015e
            if (r15 != 0) goto L_0x015e
            r7 = r6
            java.util.Collection r7 = (java.util.Collection) r7
            boolean r7 = r7.isEmpty()
            r7 = r7 ^ r12
            if (r7 == 0) goto L_0x015e
            com.didi.map.global.flow.scene.order.serving.scene.sctx.SerialOrderErrorEnum r7 = com.didi.map.global.flow.scene.order.serving.scene.sctx.SerialOrderErrorEnum.ORA_LAST_ORDER_HAS_OD_NO_DEST
            r0.m18997a(r7, r1, r2)
        L_0x015e:
            if (r16 == 0) goto L_0x0165
            com.didi.map.global.flow.scene.order.serving.scene.sctx.SerialOrderErrorEnum r7 = com.didi.map.global.flow.scene.order.serving.scene.sctx.SerialOrderErrorEnum.ORA_LAST_ORDER_POINT_TYPE_ERROR
            r0.m18997a(r7, r1, r2)
        L_0x0165:
            if (r17 == 0) goto L_0x016c
            com.didi.map.global.flow.scene.order.serving.scene.sctx.SerialOrderErrorEnum r7 = com.didi.map.global.flow.scene.order.serving.scene.sctx.SerialOrderErrorEnum.ORA_LAST_ORDER_COORDINATE_ERROR
            r0.m18997a(r7, r1, r2)
        L_0x016c:
            if (r18 == 0) goto L_0x0173
            com.didi.map.global.flow.scene.order.serving.scene.sctx.SerialOrderErrorEnum r7 = com.didi.map.global.flow.scene.order.serving.scene.sctx.SerialOrderErrorEnum.ORA_LAST_ORDER_OD_TYPE_ERROR
            r0.m18997a(r7, r1, r2)
        L_0x0173:
            java.lang.String r7 = "curDstRouteGeoIndex"
            r8 = r24
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r7)
            int r7 = r8.intValue()
            r9 = -1
            if (r7 <= 0) goto L_0x0195
            if (r4 == 0) goto L_0x01b8
            int r7 = r29.size()
            int r7 = r7 + r9
            int r10 = r8.intValue()
            if (r10 < 0) goto L_0x0192
            if (r10 > r7) goto L_0x0192
            r7 = 1
            goto L_0x0193
        L_0x0192:
            r7 = 0
        L_0x0193:
            if (r7 != 0) goto L_0x01b8
        L_0x0195:
            if (r3 != 0) goto L_0x0199
        L_0x0197:
            r7 = 0
            goto L_0x01a9
        L_0x0199:
            java.util.List<com.didi.map.sdk.proto.driver_gl.OdPoint> r7 = r3.odPoints
            if (r7 != 0) goto L_0x019e
            goto L_0x0197
        L_0x019e:
            java.util.Collection r7 = (java.util.Collection) r7
            boolean r7 = r7.isEmpty()
            r7 = r7 ^ r12
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
        L_0x01a9:
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r12)
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r10)
            if (r7 == 0) goto L_0x01b8
            com.didi.map.global.flow.scene.order.serving.scene.sctx.SerialOrderErrorEnum r7 = com.didi.map.global.flow.scene.order.serving.scene.sctx.SerialOrderErrorEnum.ORA_LAST_ORDER_CURDST_NULL_ODPOINTS_NONNULL
            r0.m18997a(r7, r1, r2)
        L_0x01b8:
            int r7 = r8.intValue()
            if (r7 <= 0) goto L_0x01f5
            if (r4 == 0) goto L_0x01f5
            int r7 = r29.size()
            int r7 = r7 + r9
            int r10 = r8.intValue()
            if (r10 < 0) goto L_0x01cf
            if (r10 > r7) goto L_0x01cf
            r7 = 1
            goto L_0x01d0
        L_0x01cf:
            r7 = 0
        L_0x01d0:
            if (r7 == 0) goto L_0x01f5
            if (r3 != 0) goto L_0x01d6
        L_0x01d4:
            r7 = 0
            goto L_0x01e6
        L_0x01d6:
            java.util.List<com.didi.map.sdk.proto.driver_gl.OdPoint> r7 = r3.odPoints
            if (r7 != 0) goto L_0x01db
            goto L_0x01d4
        L_0x01db:
            java.util.Collection r7 = (java.util.Collection) r7
            boolean r7 = r7.isEmpty()
            r7 = r7 ^ r12
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
        L_0x01e6:
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r12)
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r10)
            if (r7 != 0) goto L_0x01f5
            com.didi.map.global.flow.scene.order.serving.scene.sctx.SerialOrderErrorEnum r7 = com.didi.map.global.flow.scene.order.serving.scene.sctx.SerialOrderErrorEnum.ORA_LAST_ORDER_CURDST_NONNULL_ODPOINTS_NULL
            r0.m18997a(r7, r1, r2)
        L_0x01f5:
            int r7 = r8.intValue()
            if (r7 <= 0) goto L_0x0209
            if (r4 != 0) goto L_0x01fe
            goto L_0x0209
        L_0x01fe:
            int r7 = r8.intValue()
            java.lang.Object r7 = kotlin.collections.CollectionsKt.getOrNull(r4, r7)
            com.didi.common.map.model.LatLng r7 = (com.didi.common.map.model.LatLng) r7
            goto L_0x020a
        L_0x0209:
            r7 = 0
        L_0x020a:
            boolean r10 = r6.isEmpty()
            if (r10 == 0) goto L_0x0217
            r21 = 0
            r6 = r21
            com.didi.common.map.model.LatLng r6 = (com.didi.common.map.model.LatLng) r6
            goto L_0x024b
        L_0x0217:
            r21 = 0
            com.didi.common.map.model.LatLng r10 = new com.didi.common.map.model.LatLng
            java.lang.Object r11 = kotlin.collections.CollectionsKt.first(r6)
            com.didi.map.sdk.proto.driver_gl.OdPoint r11 = (com.didi.map.sdk.proto.driver_gl.OdPoint) r11
            com.didi.map.sdk.proto.driver_gl.DoublePoint r11 = r11.point
            java.lang.Double r11 = r11.dlat
            java.lang.String r13 = "wayPoints.first().point.dlat"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r13)
            java.lang.Number r11 = (java.lang.Number) r11
            double r13 = r11.doubleValue()
            java.lang.Object r6 = kotlin.collections.CollectionsKt.first(r6)
            com.didi.map.sdk.proto.driver_gl.OdPoint r6 = (com.didi.map.sdk.proto.driver_gl.OdPoint) r6
            com.didi.map.sdk.proto.driver_gl.DoublePoint r6 = r6.point
            java.lang.Double r6 = r6.dlng
            java.lang.String r11 = "wayPoints.first().point.dlng"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r11)
            java.lang.Number r6 = (java.lang.Number) r6
            double r5 = r6.doubleValue()
            r10.<init>((double) r13, (double) r5)
            r6 = r10
        L_0x024b:
            int r5 = r8.intValue()
            if (r5 <= 0) goto L_0x026c
            boolean r5 = com.didi.common.map.util.LatLngUtils.locateCorrect(r7)
            if (r5 == 0) goto L_0x026c
            boolean r5 = com.didi.common.map.util.LatLngUtils.locateCorrect(r6)
            if (r5 == 0) goto L_0x026c
            double r5 = com.didi.common.map.util.DDSphericalUtil.computeDistanceBetween(r7, r6)
            r7 = 4617315517961601024(0x4014000000000000, double:5.0)
            int r10 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r10 <= 0) goto L_0x026c
            com.didi.map.global.flow.scene.order.serving.scene.sctx.SerialOrderErrorEnum r5 = com.didi.map.global.flow.scene.order.serving.scene.sctx.SerialOrderErrorEnum.ORA_LAST_ORDER_CURDST_POINT_TOO_FAR_FROM_FIRST_ODPOINT
            r0.m18997a(r5, r1, r2)
        L_0x026c:
            if (r4 != 0) goto L_0x0271
            r5 = r21
            goto L_0x027d
        L_0x0271:
            r5 = r4
            java.util.Collection r5 = (java.util.Collection) r5
            boolean r5 = r5.isEmpty()
            r5 = r5 ^ r12
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)
        L_0x027d:
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r12)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r6)
            if (r5 != 0) goto L_0x028c
            com.didi.map.global.flow.scene.order.serving.scene.sctx.SerialOrderErrorEnum r5 = com.didi.map.global.flow.scene.order.serving.scene.sctx.SerialOrderErrorEnum.ORA_ROUTE_POINTS_NULL
            r0.m18997a(r5, r1, r2)
        L_0x028c:
            if (r3 != 0) goto L_0x0290
        L_0x028e:
            r5 = 0
            goto L_0x0299
        L_0x0290:
            java.lang.Integer r5 = r3.eta
            if (r5 != 0) goto L_0x0295
            goto L_0x028e
        L_0x0295:
            int r5 = r5.intValue()
        L_0x0299:
            if (r5 == 0) goto L_0x02aa
            if (r3 != 0) goto L_0x029f
        L_0x029d:
            r5 = 0
            goto L_0x02a8
        L_0x029f:
            java.lang.Integer r5 = r3.distance
            if (r5 != 0) goto L_0x02a4
            goto L_0x029d
        L_0x02a4:
            int r5 = r5.intValue()
        L_0x02a8:
            if (r5 != 0) goto L_0x02af
        L_0x02aa:
            com.didi.map.global.flow.scene.order.serving.scene.sctx.SerialOrderErrorEnum r5 = com.didi.map.global.flow.scene.order.serving.scene.sctx.SerialOrderErrorEnum.ORA_ETA_OR_EDA_NULL
            r0.m18997a(r5, r1, r2)
        L_0x02af:
            if (r3 != 0) goto L_0x02b4
            r5 = r21
            goto L_0x02b6
        L_0x02b4:
            com.didi.map.sdk.proto.driver_gl.DoublePoint r5 = r3.driverPoint
        L_0x02b6:
            if (r5 == 0) goto L_0x02ea
            if (r3 != 0) goto L_0x02bd
        L_0x02ba:
            r5 = r21
            goto L_0x02c4
        L_0x02bd:
            com.didi.map.sdk.proto.driver_gl.DoublePoint r5 = r3.driverPoint
            if (r5 != 0) goto L_0x02c2
            goto L_0x02ba
        L_0x02c2:
            java.lang.Float r5 = r5.lat
        L_0x02c4:
            if (r5 != 0) goto L_0x02c9
            r5 = 0
            goto L_0x02ce
        L_0x02c9:
            float r5 = r5.floatValue()
            double r5 = (double) r5
        L_0x02ce:
            if (r3 != 0) goto L_0x02d3
        L_0x02d0:
            r7 = r21
            goto L_0x02da
        L_0x02d3:
            com.didi.map.sdk.proto.driver_gl.DoublePoint r7 = r3.driverPoint
            if (r7 != 0) goto L_0x02d8
            goto L_0x02d0
        L_0x02d8:
            java.lang.Float r7 = r7.lng
        L_0x02da:
            if (r7 != 0) goto L_0x02df
            r10 = 0
            goto L_0x02e4
        L_0x02df:
            float r7 = r7.floatValue()
            double r10 = (double) r7
        L_0x02e4:
            boolean r5 = com.didi.common.map.util.LatLngUtils.locateCorrect(r5, r10)
            if (r5 != 0) goto L_0x02ef
        L_0x02ea:
            com.didi.map.global.flow.scene.order.serving.scene.sctx.SerialOrderErrorEnum r5 = com.didi.map.global.flow.scene.order.serving.scene.sctx.SerialOrderErrorEnum.ORA_DRIVER_LOC_NULL
            r0.m18997a(r5, r1, r2)
        L_0x02ef:
            com.didi.map.global.flow.scene.param.MapElementId r5 = com.didi.map.global.flow.scene.param.MapElementId.ID_MARKER_WAYPOINT
            r6 = r30
            int r5 = r6.getMarkerIconResId(r5)
            com.didi.map.global.flow.scene.param.MapElementId r7 = com.didi.map.global.flow.scene.param.MapElementId.ID_MARKER_ODPOINT
            int r7 = r6.getMarkerIconResId(r7)
            if (r31 == 0) goto L_0x0301
            if (r5 <= 0) goto L_0x0303
        L_0x0301:
            if (r7 > 0) goto L_0x0308
        L_0x0303:
            com.didi.map.global.flow.scene.order.serving.scene.sctx.SerialOrderErrorEnum r5 = com.didi.map.global.flow.scene.order.serving.scene.sctx.SerialOrderErrorEnum.UI_NO_ICON
            r0.m18997a(r5, r1, r2)
        L_0x0308:
            if (r31 == 0) goto L_0x0333
            com.didi.map.global.flow.scene.param.MapElementId r5 = com.didi.map.global.flow.scene.param.MapElementId.ID_MARKER_WAYPOINT
            java.lang.String r5 = r6.getMarkerAddressName(r5)
            if (r5 != 0) goto L_0x0315
            r5 = r21
            goto L_0x0324
        L_0x0315:
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            int r5 = r5.length()
            if (r5 <= 0) goto L_0x031f
            r5 = 1
            goto L_0x0320
        L_0x031f:
            r5 = 0
        L_0x0320:
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)
        L_0x0324:
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r12)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r6)
            if (r5 != 0) goto L_0x0333
            com.didi.map.global.flow.scene.order.serving.scene.sctx.SerialOrderErrorEnum r5 = com.didi.map.global.flow.scene.order.serving.scene.sctx.SerialOrderErrorEnum.UI_NO_LAST_DST_TEXT
            r0.m18997a(r5, r1, r2)
        L_0x0333:
            if (r4 != 0) goto L_0x0338
            r5 = r21
            goto L_0x0344
        L_0x0338:
            r5 = r4
            java.util.Collection r5 = (java.util.Collection) r5
            boolean r5 = r5.isEmpty()
            r5 = r5 ^ r12
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)
        L_0x0344:
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r12)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r6)
            if (r5 == 0) goto L_0x03b3
            if (r3 != 0) goto L_0x0354
        L_0x0350:
            r7 = r21
            goto L_0x03ae
        L_0x0354:
            java.util.List<com.didi.map.sdk.proto.driver_gl.TrafficItem> r3 = r3.traffic
            if (r3 != 0) goto L_0x0359
            goto L_0x0350
        L_0x0359:
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.Iterator r3 = r3.iterator()
        L_0x035f:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x03aa
            java.lang.Object r5 = r3.next()
            r6 = r5
            com.didi.map.sdk.proto.driver_gl.TrafficItem r6 = (com.didi.map.sdk.proto.driver_gl.TrafficItem) r6
            int r7 = r29.size()
            int r7 = r7 + r9
            if (r6 != 0) goto L_0x0375
        L_0x0373:
            r8 = -1
            goto L_0x037e
        L_0x0375:
            java.lang.Integer r8 = r6.startIndex
            if (r8 != 0) goto L_0x037a
            goto L_0x0373
        L_0x037a:
            int r8 = r8.intValue()
        L_0x037e:
            if (r8 < 0) goto L_0x0384
            if (r8 > r7) goto L_0x0384
            r7 = 1
            goto L_0x0385
        L_0x0384:
            r7 = 0
        L_0x0385:
            if (r7 == 0) goto L_0x03a5
            int r7 = r29.size()
            int r7 = r7 + r9
            if (r6 != 0) goto L_0x0390
        L_0x038e:
            r6 = -1
            goto L_0x0399
        L_0x0390:
            java.lang.Integer r6 = r6.endIndex
            if (r6 != 0) goto L_0x0395
            goto L_0x038e
        L_0x0395:
            int r6 = r6.intValue()
        L_0x0399:
            if (r6 < 0) goto L_0x039f
            if (r6 > r7) goto L_0x039f
            r6 = 1
            goto L_0x03a0
        L_0x039f:
            r6 = 0
        L_0x03a0:
            if (r6 != 0) goto L_0x03a3
            goto L_0x03a5
        L_0x03a3:
            r6 = 0
            goto L_0x03a6
        L_0x03a5:
            r6 = 1
        L_0x03a6:
            if (r6 == 0) goto L_0x035f
            r7 = r5
            goto L_0x03ac
        L_0x03aa:
            r7 = r21
        L_0x03ac:
            com.didi.map.sdk.proto.driver_gl.TrafficItem r7 = (com.didi.map.sdk.proto.driver_gl.TrafficItem) r7
        L_0x03ae:
            if (r7 == 0) goto L_0x03b1
            goto L_0x03b3
        L_0x03b1:
            r9 = 0
            goto L_0x03b4
        L_0x03b3:
            r9 = 1
        L_0x03b4:
            if (r9 == 0) goto L_0x03bb
            com.didi.map.global.flow.scene.order.serving.scene.sctx.SerialOrderErrorEnum r3 = com.didi.map.global.flow.scene.order.serving.scene.sctx.SerialOrderErrorEnum.UI_DRAW_TRAFFIC_DATA_FAIL
            r0.m18997a(r3, r1, r2)
        L_0x03bb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.flow.scene.order.serving.scene.sctx.SctxOmegaHelper.trackSerialOrderOraRelatedError(java.lang.String, java.lang.String, com.didi.map.sdk.proto.driver_gl.MapPassengeOrderRouteRes, java.util.List, com.didi.map.global.flow.scene.order.serving.components.MarkerManager, boolean):void");
    }

    /* renamed from: a */
    private final void m18997a(SerialOrderErrorEnum serialOrderErrorEnum, String str, String str2) {
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("error_code", Integer.valueOf(serialOrderErrorEnum.getValue()));
        if (str2 == null) {
            str2 = "";
        }
        linkedHashMap.put("last_order_id", str2);
        if (str == null) {
            str = "";
        }
        linkedHashMap.put("order_id", str);
        GlobalOmegaTracker.trackEvent("tech_map_serial_order_error", linkedHashMap);
    }
}
