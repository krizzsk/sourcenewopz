package com.didi.map.google.manager;

import android.text.TextUtils;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.DLog;
import com.didi.map.google.config.Config;
import com.didi.map.google.model.MockMovementInfo;
import com.didi.map.google.model.OmegaTraceEvent;
import com.didi.map.google.util.ApolloUtils;
import com.didi.map.google.util.BizUtil;
import com.didi.map.google.util.ConvertUtil;
import com.didi.map.google.util.GoogleSyncTripLogUtil;
import com.didi.map.google.util.GoogleSyncTripOmegaUtil;
import com.didi.map.google.util.OmegaCommonArgsAppender;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didi.map.sdk.nav.car.CarMarker;
import com.didi.map.sdk.nav.car.IMyLocationDelegate;
import com.didi.map.sdk.nav.inertia.CarMoveInfo;
import com.didi.map.sdk.nav.inertia.IInertiaDelegate;
import com.didi.map.sdk.nav.inertia.SctxStateInfo;
import com.didi.map.utils.AnalysisAbnormalError;
import com.didi.map.utils.DiskLog;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.map.sdk.nav.libc.common.MapMatchType;
import com.map.sdk.nav.libc.common.RouteGuidanceGPSPoint;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class OmegaReportManager {

    /* renamed from: a */
    private static final String f27784a = "OmegaReportManager";

    /* renamed from: b */
    private double f27785b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public SctxReportGetter f27786c;

    /* renamed from: d */
    private boolean f27787d = false;

    /* renamed from: e */
    private long f27788e = (System.currentTimeMillis() / 1000);
    /* access modifiers changed from: private */

    /* renamed from: f */
    public List<MockMovementInfo> f27789f = new ArrayList();

    /* renamed from: g */
    private AnalysisAbnormalError f27790g = new AnalysisAbnormalError();
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f27791h = false;

    /* renamed from: i */
    private AnalysisAbnormalError.AbnormalErrorCallBack f27792i = new AnalysisAbnormalError.AbnormalErrorCallBack() {
        public void errorInfo(int i) {
            try {
                OmegaReportManager.traceSctxAbnormalError(String.valueOf(i), 0, PaxEnvironment.getInstance().getAppVersion(), OmegaReportManager.this.f27786c.getOrderId(), OmegaReportManager.this.f27786c.getOrderState());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    /* renamed from: j */
    private IInertiaDelegate.ISimulateEvaluateCallback f27793j = new IInertiaDelegate.ISimulateEvaluateCallback() {
        /* JADX WARNING: Removed duplicated region for block: B:53:0x0133  */
        /* JADX WARNING: Removed duplicated region for block: B:54:0x013c  */
        /* JADX WARNING: Removed duplicated region for block: B:67:0x0183  */
        /* JADX WARNING: Removed duplicated region for block: B:71:0x01ba  */
        /* JADX WARNING: Removed duplicated region for block: B:76:0x0201  */
        /* JADX WARNING: Removed duplicated region for block: B:77:0x020d  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onReceiveSimulateInfo(com.didi.map.sdk.nav.inertia.SimulateInfo r22) {
            /*
                r21 = this;
                r0 = r21
                r1 = r22
                if (r1 == 0) goto L_0x0286
                com.didi.map.google.manager.OmegaReportManager r2 = com.didi.map.google.manager.OmegaReportManager.this
                com.didi.map.google.manager.OmegaReportManager$SctxReportGetter r2 = r2.f27786c
                if (r2 != 0) goto L_0x0010
                goto L_0x0286
            L_0x0010:
                com.didi.map.google.manager.OmegaReportManager r2 = com.didi.map.google.manager.OmegaReportManager.this
                com.didi.map.google.manager.OmegaReportManager$SctxReportGetter r2 = r2.f27786c
                int r2 = r2.getOrderState()
                r3 = 4
                java.lang.String r4 = "OmegaReportManager"
                r5 = 0
                if (r2 == r3) goto L_0x027e
                com.didi.map.google.manager.OmegaReportManager r2 = com.didi.map.google.manager.OmegaReportManager.this
                com.didi.map.google.manager.OmegaReportManager$SctxReportGetter r2 = r2.f27786c
                boolean r2 = r2.isArrived()
                if (r2 == 0) goto L_0x002e
                goto L_0x027e
            L_0x002e:
                boolean r2 = com.didi.map.sdk.nav.util.ApolloToggleUtils.isMockOnlineEvaluateEnabled()
                if (r2 != 0) goto L_0x003c
                java.lang.Object[] r1 = new java.lang.Object[r5]
                java.lang.String r2 = "sctx_mock_online_evaluate: apollo is closed, do not omega"
                com.didi.common.map.util.DLog.m7384d(r4, r2, r1)
                return
            L_0x003c:
                java.util.HashMap r2 = new java.util.HashMap
                r2.<init>()
                com.didi.map.sdk.nav.inertia.SctxStateEnum r3 = r22.getSctxStateEnum()
                if (r3 != 0) goto L_0x0049
                r3 = 0
                goto L_0x004f
            L_0x0049:
                com.didi.map.sdk.nav.inertia.SctxStateEnum r3 = r22.getSctxStateEnum()
                int r3 = r3.type
            L_0x004f:
                java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
                java.lang.String r4 = "carStopType"
                r2.put(r4, r3)
                com.didi.map.sdk.nav.car.AnimateNode r3 = r1.startPoint
                r4 = 0
                if (r3 == 0) goto L_0x0068
                com.didi.map.sdk.nav.car.AnimateNode r3 = r1.startPoint
                com.didi.common.map.model.LatLng r3 = r3.latLng
                if (r3 == 0) goto L_0x0068
                com.didi.map.sdk.nav.car.AnimateNode r3 = r1.startPoint
                com.didi.common.map.model.LatLng r3 = r3.latLng
                goto L_0x0069
            L_0x0068:
                r3 = r4
            L_0x0069:
                java.lang.String r6 = "xyMockStart"
                java.lang.String r7 = "(0,0)"
                java.lang.String r8 = "(%.6f,%.6f)"
                r9 = 2
                r14 = 1
                if (r3 != 0) goto L_0x0077
                r2.put(r6, r7)
                goto L_0x0092
            L_0x0077:
                java.util.Locale r10 = java.util.Locale.ENGLISH
                java.lang.Object[] r11 = new java.lang.Object[r9]
                double r12 = r3.longitude
                java.lang.Double r12 = java.lang.Double.valueOf(r12)
                r11[r5] = r12
                double r12 = r3.latitude
                java.lang.Double r12 = java.lang.Double.valueOf(r12)
                r11[r14] = r12
                java.lang.String r10 = java.lang.String.format(r10, r8, r11)
                r2.put(r6, r10)
            L_0x0092:
                com.didi.map.sdk.nav.car.AnimateNode r6 = r1.currentPoint
                if (r6 == 0) goto L_0x00a1
                com.didi.map.sdk.nav.car.AnimateNode r6 = r1.currentPoint
                com.didi.common.map.model.LatLng r6 = r6.latLng
                if (r6 == 0) goto L_0x00a1
                com.didi.map.sdk.nav.car.AnimateNode r6 = r1.currentPoint
                com.didi.common.map.model.LatLng r6 = r6.latLng
                goto L_0x00a2
            L_0x00a1:
                r6 = r4
            L_0x00a2:
                java.lang.String r10 = "xyMockReal"
                if (r6 != 0) goto L_0x00aa
                r2.put(r10, r7)
                goto L_0x00c7
            L_0x00aa:
                java.util.Locale r11 = java.util.Locale.ENGLISH
                java.lang.Object[] r12 = new java.lang.Object[r9]
                r15 = r10
                double r9 = r6.longitude
                java.lang.Double r9 = java.lang.Double.valueOf(r9)
                r12[r5] = r9
                double r9 = r6.latitude
                java.lang.Double r9 = java.lang.Double.valueOf(r9)
                r12[r14] = r9
                java.lang.String r9 = java.lang.String.format(r11, r8, r12)
                r10 = r15
                r2.put(r10, r9)
            L_0x00c7:
                com.didi.map.sdk.nav.car.AnimateNode r9 = r1.useablePoint
                if (r9 == 0) goto L_0x00d5
                com.didi.map.sdk.nav.car.AnimateNode r9 = r1.useablePoint
                com.didi.common.map.model.LatLng r9 = r9.latLng
                if (r9 == 0) goto L_0x00d5
                com.didi.map.sdk.nav.car.AnimateNode r4 = r1.useablePoint
                com.didi.common.map.model.LatLng r4 = r4.latLng
            L_0x00d5:
                java.lang.String r9 = "xyReal"
                if (r4 != 0) goto L_0x00e1
                r2.put(r9, r7)
                r7 = 0
            L_0x00de:
                r9 = 0
                goto L_0x010c
            L_0x00e1:
                java.util.Locale r7 = java.util.Locale.ENGLISH
                r12 = 2
                java.lang.Object[] r15 = new java.lang.Object[r12]
                double r10 = r4.longitude
                java.lang.Double r10 = java.lang.Double.valueOf(r10)
                r15[r5] = r10
                double r10 = r4.latitude
                java.lang.Double r10 = java.lang.Double.valueOf(r10)
                r15[r14] = r10
                java.lang.String r7 = java.lang.String.format(r7, r8, r15)
                r2.put(r9, r7)
                if (r3 == 0) goto L_0x0104
                double r7 = com.didi.common.map.util.DDSphericalUtil.computeDistanceBetween(r3, r4)
                goto L_0x0106
            L_0x0104:
                r7 = 0
            L_0x0106:
                if (r6 == 0) goto L_0x00de
                double r9 = com.didi.common.map.util.DDSphericalUtil.computeDistanceBetween(r6, r4)
            L_0x010c:
                com.didi.map.google.manager.OmegaReportManager r4 = com.didi.map.google.manager.OmegaReportManager.this
                com.didi.map.google.manager.OmegaReportManager$SctxReportGetter r4 = r4.f27786c
                java.util.List r4 = r4.getSctxRoutePoints()
                com.didi.map.sdk.nav.car.AnimateNode r6 = r1.startPoint
                com.didi.map.sdk.nav.car.AnimateNode r11 = r1.currentPoint
                double r11 = com.didi.map.sdk.nav.car.C10010utils.getOnRoadDistance(r4, r6, r11)
                long r5 = r1.usablePointTimestamp
                long r13 = r1.startPointTimestamp
                long r5 = r5 - r13
                com.didi.map.google.manager.OmegaReportManager r13 = com.didi.map.google.manager.OmegaReportManager.this
                com.didi.map.google.manager.OmegaReportManager$SctxReportGetter r13 = r13.f27786c
                double r13 = r13.getMaxMockDistance()
                java.lang.String r15 = "mockType"
                int r20 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
                if (r20 < 0) goto L_0x013c
                r11 = 1
                java.lang.Integer r5 = java.lang.Integer.valueOf(r11)
                r2.put(r15, r5)
                goto L_0x0172
            L_0x013c:
                com.didi.map.google.manager.OmegaReportManager r11 = com.didi.map.google.manager.OmegaReportManager.this
                com.didi.map.google.manager.OmegaReportManager$SctxReportGetter r11 = r11.f27786c
                long r11 = r11.getMaxMockTime()
                int r13 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
                if (r13 < 0) goto L_0x0153
                r5 = 2
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                r2.put(r15, r5)
                goto L_0x0172
            L_0x0153:
                com.didi.map.google.manager.OmegaReportManager r5 = com.didi.map.google.manager.OmegaReportManager.this
                com.didi.map.google.manager.OmegaReportManager$SctxReportGetter r5 = r5.f27786c
                r6 = 0
                boolean r5 = r5.isSimulateEtaEdaLimit(r6)
                if (r5 == 0) goto L_0x0169
                r5 = 6
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                r2.put(r15, r5)
                goto L_0x0172
            L_0x0169:
                int r5 = r1.mockType
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                r2.put(r15, r5)
            L_0x0172:
                com.didi.map.sdk.nav.car.AnimateNode r5 = r1.useablePoint
                java.lang.String r11 = "cover"
                java.lang.String r12 = "%.2f"
                if (r5 == 0) goto L_0x01ba
                com.didi.map.sdk.nav.car.AnimateNode r5 = r1.currentPoint
                if (r5 == 0) goto L_0x01ba
                com.didi.map.sdk.nav.car.AnimateNode r5 = r1.startPoint
                if (r5 != 0) goto L_0x0183
                goto L_0x01ba
            L_0x0183:
                com.didi.map.sdk.nav.car.AnimateNode r5 = r1.startPoint
                com.didi.map.sdk.nav.car.AnimateNode r13 = r1.useablePoint
                double r13 = com.didi.map.sdk.nav.car.C10010utils.getOnRoadDistance(r4, r5, r13)
                com.didi.map.sdk.nav.car.AnimateNode r5 = r1.startPoint
                com.didi.map.sdk.nav.car.AnimateNode r15 = r1.currentPoint
                double r18 = com.didi.map.sdk.nav.car.C10010utils.getOnRoadDistance(r4, r5, r15)
                r16 = 0
                int r5 = (r13 > r16 ? 1 : (r13 == r16 ? 0 : -1))
                if (r5 > 0) goto L_0x01a3
                r5 = 0
                java.lang.Integer r6 = java.lang.Integer.valueOf(r5)
                r2.put(r11, r6)
                r14 = 0
                goto L_0x01c4
            L_0x01a3:
                r5 = 0
                java.util.Locale r6 = java.util.Locale.ENGLISH
                r15 = 1
                java.lang.Object[] r5 = new java.lang.Object[r15]
                double r18 = r18 / r13
                java.lang.Double r13 = java.lang.Double.valueOf(r18)
                r14 = 0
                r5[r14] = r13
                java.lang.String r5 = java.lang.String.format(r6, r12, r5)
                r2.put(r11, r5)
                goto L_0x01c4
            L_0x01ba:
                r14 = 0
                r16 = 0
                java.lang.Integer r5 = java.lang.Integer.valueOf(r14)
                r2.put(r11, r5)
            L_0x01c4:
                java.util.Locale r5 = java.util.Locale.ENGLISH
                r6 = 1
                java.lang.Object[] r11 = new java.lang.Object[r6]
                java.lang.Double r7 = java.lang.Double.valueOf(r7)
                r11[r14] = r7
                java.lang.String r5 = java.lang.String.format(r5, r12, r11)
                java.lang.String r7 = "dis_MS_R"
                r2.put(r7, r5)
                java.util.Locale r5 = java.util.Locale.ENGLISH
                java.lang.Object[] r7 = new java.lang.Object[r6]
                java.lang.Double r6 = java.lang.Double.valueOf(r9)
                r7[r14] = r6
                java.lang.String r5 = java.lang.String.format(r5, r12, r7)
                java.lang.String r6 = "dis_MR_R"
                r2.put(r6, r5)
                long r5 = r1.usablePointTimestamp
                long r7 = r1.currentPointTimestamp
                long r5 = r5 - r7
                java.lang.Long r1 = java.lang.Long.valueOf(r5)
                java.lang.String r5 = "time_R_ME"
                r2.put(r5, r1)
                if (r3 == 0) goto L_0x020d
                boolean r1 = com.didi.common.map.util.CollectionUtil.isEmpty((java.util.Collection<?>) r4)
                if (r1 != 0) goto L_0x020d
                r1 = 0
                java.lang.Object r4 = r4.get(r1)
                com.didi.common.map.model.LatLng r4 = (com.didi.common.map.model.LatLng) r4
                double r10 = com.didi.common.map.util.DDSphericalUtil.computeDistanceBetween(r4, r3)
                goto L_0x0210
            L_0x020d:
                r1 = 0
                r10 = r16
            L_0x0210:
                java.util.Locale r3 = java.util.Locale.ENGLISH
                r4 = 1
                java.lang.Object[] r5 = new java.lang.Object[r4]
                java.lang.Double r4 = java.lang.Double.valueOf(r10)
                r5[r1] = r4
                java.lang.String r1 = java.lang.String.format(r3, r12, r5)
                java.lang.String r3 = "dis_first_MS"
                r2.put(r3, r1)
                com.didi.map.google.manager.OmegaReportManager r1 = com.didi.map.google.manager.OmegaReportManager.this
                com.didi.map.google.manager.OmegaReportManager$SctxReportGetter r1 = r1.f27786c
                java.lang.String r6 = r1.getUid()
                com.didi.map.google.manager.OmegaReportManager r1 = com.didi.map.google.manager.OmegaReportManager.this
                com.didi.map.google.manager.OmegaReportManager$SctxReportGetter r1 = r1.f27786c
                java.lang.String r7 = r1.getOrderId()
                com.didi.map.google.manager.OmegaReportManager r1 = com.didi.map.google.manager.OmegaReportManager.this
                com.didi.map.google.manager.OmegaReportManager$SctxReportGetter r1 = r1.f27786c
                int r8 = r1.getOrderState()
                com.didi.map.google.manager.OmegaReportManager r1 = com.didi.map.google.manager.OmegaReportManager.this
                com.didi.map.google.manager.OmegaReportManager$SctxReportGetter r1 = r1.f27786c
                boolean r9 = r1.isArrived()
                com.didi.map.google.manager.OmegaReportManager r1 = com.didi.map.google.manager.OmegaReportManager.this
                com.didi.map.google.manager.OmegaReportManager$SctxReportGetter r1 = r1.f27786c
                int r10 = r1.getProductId()
                com.didi.map.google.manager.OmegaReportManager r1 = com.didi.map.google.manager.OmegaReportManager.this
                com.didi.map.google.manager.OmegaReportManager$SctxReportGetter r1 = r1.f27786c
                java.lang.String r11 = r1.getRole()
                com.didi.map.google.manager.OmegaReportManager r1 = com.didi.map.google.manager.OmegaReportManager.this
                com.didi.map.google.manager.OmegaReportManager$SctxReportGetter r1 = r1.f27786c
                java.lang.String r13 = r1.getPageReferrer()
                java.lang.String r12 = "inservice_page"
                r5 = r2
                com.didi.map.google.util.OmegaCommonArgsAppender.append(r5, r6, r7, r8, r9, r10, r11, r12, r13)
                java.lang.String r1 = "map_mockType_sw"
                java.lang.String r3 = ""
                com.didiglobal.omegasdkadapter.OmegaSDKAdapter.trackEvent(r1, r3, r2)
                com.didi.map.google.manager.OmegaReportManager r1 = com.didi.map.google.manager.OmegaReportManager.this
                r2 = 1
                boolean unused = r1.f27791h = r2
                return
            L_0x027e:
                r1 = 0
                java.lang.Object[] r1 = new java.lang.Object[r1]
                java.lang.String r2 = "sctx_mock_online_evaluate: mOrderStage is not pickup, do not omega"
                com.didi.common.map.util.DLog.m7384d(r4, r2, r1)
            L_0x0286:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.map.google.manager.OmegaReportManager.C98662.onReceiveSimulateInfo(com.didi.map.sdk.nav.inertia.SimulateInfo):void");
        }

        public void onReceiveCarMoveInfo(CarMoveInfo carMoveInfo) {
            if (OmegaReportManager.this.f27786c != null && !OmegaReportManager.this.f27786c.isSplitAccounts() && carMoveInfo != null) {
                OmegaReportManager.this.f27789f.add(OmegaReportManager.this.m19904a(carMoveInfo));
            }
        }
    };

    public interface SctxReportGetter {
        int getCarAnimEda();

        CarMarker getDriverMarker();

        int getDriverMatchEda();

        double getMaxMockDistance();

        long getMaxMockTime();

        String getOrderId();

        int getOrderState();

        RouteGuidanceGPSPoint getOriginDriverPoint();

        String getPageReferrer();

        int getProductId();

        String getRole();

        List<MockMovementInfo.SctxAnimData> getSctxAnimDataList();

        List<LatLng> getSctxRoutePoints();

        String getUid();

        boolean isArrived();

        boolean isSimulateEtaEdaLimit(boolean z);

        boolean isSplitAccounts();
    }

    public OmegaReportManager(SctxReportGetter sctxReportGetter) {
        this.f27786c = sctxReportGetter;
        this.f27790g.setAnalysisAbnormalCallBack(this.f27792i);
    }

    public void onReceiveSctxState(String str, SctxStateInfo sctxStateInfo) {
        if (!sctxStateInfo.isExceptionState()) {
            this.f27787d = false;
        } else if (!this.f27787d) {
            this.f27787d = true;
            GoogleSyncTripOmegaUtil.traceSctxExceptionEvent(this.f27786c.getUid(), str, this.f27786c.getOrderState(), this.f27786c.isArrived(), this.f27786c.getProductId(), this.f27786c.getRole(), this.f27786c.getPageReferrer());
        }
    }

    public IInertiaDelegate.ISimulateEvaluateCallback getSimulateCallback() {
        return this.f27793j;
    }

    public boolean hasSimulateNav() {
        return this.f27791h;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public MockMovementInfo m19904a(CarMoveInfo carMoveInfo) {
        MockMovementInfo mockMovementInfo = new MockMovementInfo(carMoveInfo);
        SctxReportGetter sctxReportGetter = this.f27786c;
        if (sctxReportGetter != null) {
            if (sctxReportGetter.getOriginDriverPoint() != null) {
                mockMovementInfo.oriDriverLatLng = ConvertUtil.convertFromGeoPoint(this.f27786c.getOriginDriverPoint().point);
            }
            mockMovementInfo.driverMatchEda = this.f27786c.getDriverMatchEda();
            if (this.f27786c.getDriverMarker() != null) {
                mockMovementInfo.carAnimLatLng = this.f27786c.getDriverMarker().getPosition();
            }
            mockMovementInfo.carAnimEda = this.f27786c.getCarAnimEda();
            if (Config.DEBUG) {
                String str = Config.DEBUG_TAG;
                DLog.m7384d(str, "mockMovementInfo, carAnimEda:" + mockMovementInfo.carAnimEda + ", carAnimLatLng:" + mockMovementInfo.carAnimLatLng + ", oriDriverLatLng:" + mockMovementInfo.oriDriverLatLng + ", type:" + carMoveInfo.type, new Object[0]);
            }
            List<MockMovementInfo.SctxAnimData> sctxAnimDataList = this.f27786c.getSctxAnimDataList();
            if (sctxAnimDataList != null) {
                mockMovementInfo.sctxAnimDataList.addAll(sctxAnimDataList);
            }
        }
        return mockMovementInfo;
    }

    public void doOmegaOnCarDelayed(int i, String str, boolean z, long j, IMyLocationDelegate iMyLocationDelegate, IInertiaDelegate iInertiaDelegate) {
        LatLng latLng;
        int i2;
        SctxReportGetter sctxReportGetter;
        IInertiaDelegate iInertiaDelegate2 = iInertiaDelegate;
        if (iMyLocationDelegate != null && iInertiaDelegate2 != null && iInertiaDelegate.getLastMatchGPSPoint() != null && iInertiaDelegate.getLastMatchGPSPoint().segmentIndex != -1) {
            float animDistanceLeft = (float) BizUtil.animDistanceLeft(iMyLocationDelegate, iInertiaDelegate);
            RouteGuidanceGPSPoint lastMatchGPSPoint = iInertiaDelegate.getLastMatchGPSPoint();
            if (!z || lastMatchGPSPoint.originMatchPoint == null) {
                latLng = ConvertUtil.convertFromGeoPoint(lastMatchGPSPoint.point);
                i2 = iInertiaDelegate2.distanceLeft(lastMatchGPSPoint);
            } else {
                latLng = ConvertUtil.convertFromGeoPoint(lastMatchGPSPoint.originMatchPoint.point);
                i2 = iInertiaDelegate2.distanceLeft(lastMatchGPSPoint.originMatchPoint);
            }
            float f = (float) i2;
            LatLng latLng2 = latLng;
            if (latLng2 != null && animDistanceLeft > 0.0f && f > 0.0f && (sctxReportGetter = this.f27786c) != null) {
                CarMarker driverMarker = sctxReportGetter.getDriverMarker();
                LatLng position = driverMarker != null ? driverMarker.getPosition() : null;
                if (this.f27785b >= 130.0d && f < 130.0f && position != null) {
                    DLog.m7384d(f27784a, "doCarDelayOmega, carDistanceLeft:%.2f, newMatchedDriverDistanceLeft:%.2f, newMatchedLatLng:%s, currLatLng:%s", Float.valueOf(animDistanceLeft), Float.valueOf(f), GoogleSyncTripLogUtil.getLatLngLogInfo(latLng2), GoogleSyncTripLogUtil.getLatLngLogInfo(position));
                    GoogleSyncTripOmegaUtil.map_pax_animation_car_delay(this.f27786c.getUid(), this.f27786c.getOrderId(), this.f27786c.getOrderState(), this.f27786c.isArrived(), (int) lastMatchGPSPoint.velocity, f, animDistanceLeft, latLng2, driverMarker.getPosition(), j, i, str, this.f27786c.getPageReferrer());
                }
                this.f27785b = (double) f;
            }
        }
    }

    public void doOmegaReportCarMoveInfo() {
        m19905a();
    }

    public void doOmegaReportByTimeInterval() {
        if ((System.currentTimeMillis() / 1000) - this.f27788e > 60) {
            m19905a();
        }
    }

    /* renamed from: a */
    private void m19905a() {
        String str;
        String str2;
        int i;
        String str3;
        int i2;
        AnalysisAbnormalError.CarAnimData carAnimData;
        SctxReportGetter sctxReportGetter = this.f27786c;
        if (sctxReportGetter != null && sctxReportGetter.getOrderState() == 3 && !this.f27786c.isArrived()) {
            this.f27788e = System.currentTimeMillis() / 1000;
            List<MockMovementInfo> list = this.f27789f;
            if (list != null && !list.isEmpty()) {
                HashMap hashMap = new HashMap();
                hashMap.put("order_id", this.f27786c.getOrderId());
                hashMap.put(OmegaTraceEvent.CommentParamNames.TRIP_STEP, 0);
                String str4 = "ccc";
                DLog.m7384d(str4, "OmegaSDK:order_id =" + this.f27786c.getOrderId(), new Object[0]);
                StringBuffer stringBuffer = new StringBuffer();
                String str5 = Const.jaLeft;
                stringBuffer.append(str5);
                int size = this.f27789f.size();
                int i3 = 0;
                while (true) {
                    str = Const.jaRight;
                    if (i3 >= size) {
                        break;
                    }
                    MockMovementInfo mockMovementInfo = this.f27789f.get(i3);
                    CarMoveInfo carMoveInfo = mockMovementInfo.carMoveInfo;
                    String str6 = ",";
                    if (i3 != 0) {
                        stringBuffer.append(str6);
                    }
                    String str7 = Const.joLeft;
                    stringBuffer.append(str7);
                    stringBuffer.append("'gpstime':");
                    stringBuffer.append(carMoveInfo.gpsTime);
                    stringBuffer.append(",'localtime':");
                    stringBuffer.append(carMoveInfo.localTime);
                    stringBuffer.append(",'lat':");
                    stringBuffer.append(carMoveInfo.lat);
                    stringBuffer.append(",'lon':");
                    stringBuffer.append(carMoveInfo.lon);
                    stringBuffer.append(",'type':");
                    stringBuffer.append(carMoveInfo.type);
                    stringBuffer.append(",'source':");
                    stringBuffer.append(carMoveInfo.source);
                    if (carMoveInfo.bindResult == MapMatchType.NG_VP_MATCH) {
                        stringBuffer.append(",'road_bind':");
                        stringBuffer.append(0);
                    } else if (carMoveInfo.bindResult == MapMatchType.HAWAII_MATCH) {
                        stringBuffer.append(",'road_bind':");
                        stringBuffer.append(1);
                    } else if (carMoveInfo.bindResult == MapMatchType.UNKNOWN) {
                        stringBuffer.append(",'road_bind':");
                        stringBuffer.append(-1);
                    }
                    if (mockMovementInfo.oriDriverLatLng != null) {
                        stringBuffer.append(",'lat_ori_pax':");
                        stringBuffer.append(mockMovementInfo.oriDriverLatLng.latitude);
                        stringBuffer.append(",'lng_ori_pax':");
                        stringBuffer.append(mockMovementInfo.oriDriverLatLng.longitude);
                    }
                    stringBuffer.append(",'eda_pax':");
                    stringBuffer.append(mockMovementInfo.driverMatchEda);
                    if (!mockMovementInfo.sctxAnimDataList.isEmpty()) {
                        stringBuffer.append(",'location_anim':");
                        stringBuffer.append(str5);
                        int i4 = 0;
                        for (int size2 = mockMovementInfo.sctxAnimDataList.size(); i4 < size2; size2 = size2) {
                            MockMovementInfo.SctxAnimData sctxAnimData = mockMovementInfo.sctxAnimDataList.get(i4);
                            if (i4 != 0) {
                                stringBuffer.append(str6);
                            }
                            stringBuffer.append(str7);
                            String str8 = str5;
                            stringBuffer.append("'timestamp_ntp':");
                            int i5 = size;
                            stringBuffer.append(sctxAnimData.ntpTimestamp);
                            stringBuffer.append(",'timestamp_pax':");
                            stringBuffer.append(sctxAnimData.localTime);
                            stringBuffer.append(",'lat_anim_pax':");
                            MockMovementInfo mockMovementInfo2 = mockMovementInfo;
                            String str9 = str4;
                            stringBuffer.append(String.format(Locale.ENGLISH, "%.6f", new Object[]{Double.valueOf(sctxAnimData.animLat)}));
                            stringBuffer.append(",'lng_anim_pax':");
                            int i6 = i3;
                            String str10 = str;
                            stringBuffer.append(String.format(Locale.ENGLISH, "%.6f", new Object[]{Double.valueOf(sctxAnimData.animLng)}));
                            stringBuffer.append(",'eda_anim_pax':");
                            stringBuffer.append(sctxAnimData.carAnimEda);
                            stringBuffer.append(",'distance_anim':");
                            stringBuffer.append(String.format(Locale.ENGLISH, "%.2f", new Object[]{Double.valueOf(sctxAnimData.animDistance)}));
                            if (!TextUtils.isEmpty(sctxAnimData.jumpOverException)) {
                                stringBuffer.append(",'jump_over_exception_type':");
                                stringBuffer.append(sctxAnimData.jumpOverException);
                            }
                            stringBuffer.append("}");
                            if (Config.DEBUG && sctxAnimData.animDistance > 100.0d) {
                                String str11 = Config.DEBUG_TAG;
                                SystemUtils.log(6, str11, "anim distance:" + sctxAnimData.animDistance, (Throwable) null, "com.didi.map.google.manager.OmegaReportManager", 439);
                                DiskLog.log(this.f27786c.getOrderId(), stringBuffer.substring(stringBuffer.toString().lastIndexOf(str7)));
                            }
                            AnalysisAbnormalError analysisAbnormalError = this.f27790g;
                            CarMoveInfo carMoveInfo2 = carMoveInfo;
                            new AnalysisAbnormalError.CarAnimData(carMoveInfo.type, carMoveInfo.gpsTime, sctxAnimData.ntpTimestamp, sctxAnimData.animDistance);
                            analysisAbnormalError.handle(carAnimData);
                            i4++;
                            i3 = i6;
                            str5 = str8;
                            size = i5;
                            mockMovementInfo = mockMovementInfo2;
                            str4 = str9;
                            str = str10;
                            carMoveInfo = carMoveInfo2;
                            str6 = str6;
                            str7 = str7;
                        }
                        str3 = str5;
                        i = size;
                        str2 = str4;
                        i2 = i3;
                        stringBuffer.append(str);
                    } else {
                        str3 = str5;
                        i = size;
                        str2 = str4;
                        i2 = i3;
                    }
                    stringBuffer.append("}");
                    i3 = i2 + 1;
                    str5 = str3;
                    size = i;
                    str4 = str2;
                }
                stringBuffer.append(str);
                hashMap.put("list", stringBuffer.toString());
                DLog.m7384d(str4, " 上报数据 OmegaSDK:list =" + stringBuffer.toString(), new Object[0]);
                OmegaCommonArgsAppender.append(hashMap, this.f27786c.getUid(), this.f27786c.getOrderId(), this.f27786c.getOrderState(), this.f27786c.isArrived(), this.f27786c.getProductId(), this.f27786c.getRole(), GoogleSyncTripOmegaUtil.PARAM_PAGE_VALUE, this.f27786c.getPageReferrer());
                OmegaSDKAdapter.trackEvent(OmegaTraceEvent.Keys.COM_MAP_MOCK_MOVEMENT_SW_GLOBAL, "", hashMap);
                if (Config.DEBUG) {
                    DiskLog.log(this.f27786c.getOrderId(), stringBuffer.toString());
                }
                this.f27789f.clear();
            }
        }
    }

    public void trackPhoneLocationType(int i, int i2) {
        SystemUtils.log(4, f27784a, "trackPhoneLocationType: \t typeBf = " + i + "\t typeAf = " + i2, (Throwable) null, "com.didi.map.google.manager.OmegaReportManager", 477);
        HashMap hashMap = new HashMap();
        hashMap.put("timestamp", Long.valueOf(System.currentTimeMillis()));
        hashMap.put("type_bf", Integer.valueOf(i));
        hashMap.put("type_af", Integer.valueOf(i2));
        OmegaCommonArgsAppender.append(hashMap, this.f27786c.getUid(), this.f27786c.getOrderId(), this.f27786c.getOrderState(), this.f27786c.isArrived(), this.f27786c.getProductId(), this.f27786c.getRole(), GoogleSyncTripOmegaUtil.PARAM_PAGE_VALUE, this.f27786c.getPageReferrer());
        OmegaSDKAdapter.trackEvent("map_phone_permissions_change_pas_android_ck", (Map<String, Object>) hashMap);
    }

    public void trackLocationErrorInfos(long j, Set<Integer> set) {
        SystemUtils.log(4, f27784a, "trackLocationErrorInfos: \t errorInfos = " + Arrays.toString(set.toArray()), (Throwable) null, "com.didi.map.google.manager.OmegaReportManager", 503);
        HashMap hashMap = new HashMap();
        hashMap.put("timestamp_start", Long.valueOf(j));
        hashMap.put("timestamp_end", Long.valueOf(System.currentTimeMillis()));
        hashMap.put("error_code_android", Arrays.toString(set.toArray()));
        OmegaCommonArgsAppender.append(hashMap, this.f27786c.getUid(), this.f27786c.getOrderId(), this.f27786c.getOrderState(), this.f27786c.isArrived(), this.f27786c.getProductId(), this.f27786c.getRole(), GoogleSyncTripOmegaUtil.PARAM_PAGE_VALUE, this.f27786c.getPageReferrer());
        OmegaSDKAdapter.trackEvent("map_traj_fail_pas_sw", (Map<String, Object>) hashMap);
    }

    public void trackAppLocationPermission(int i, int i2) {
        SystemUtils.log(4, f27784a, "trackAppLocationPermission: \t typeBf = " + i + "\t typeAf = " + i2, (Throwable) null, "com.didi.map.google.manager.OmegaReportManager", 526);
        HashMap hashMap = new HashMap();
        hashMap.put("timestamp", Long.valueOf(System.currentTimeMillis()));
        hashMap.put("type_bf", Integer.valueOf(i));
        hashMap.put("type_af", Integer.valueOf(i2));
        OmegaCommonArgsAppender.append(hashMap, this.f27786c.getUid(), this.f27786c.getOrderId(), this.f27786c.getOrderState(), this.f27786c.isArrived(), this.f27786c.getProductId(), this.f27786c.getRole(), GoogleSyncTripOmegaUtil.PARAM_PAGE_VALUE, this.f27786c.getPageReferrer());
        OmegaSDKAdapter.trackEvent("map_app_permissions_change_pas_android_ck", (Map<String, Object>) hashMap);
    }

    public void trackScreenState(int i) {
        SystemUtils.log(4, f27784a, "trackScreenState: \t type = " + i, (Throwable) null, "com.didi.map.google.manager.OmegaReportManager", 549);
        HashMap hashMap = new HashMap();
        hashMap.put("timestamp", Long.valueOf(System.currentTimeMillis()));
        hashMap.put("type", Integer.valueOf(i));
        OmegaCommonArgsAppender.append(hashMap, this.f27786c.getUid(), this.f27786c.getOrderId(), this.f27786c.getOrderState(), this.f27786c.isArrived(), this.f27786c.getProductId(), this.f27786c.getRole(), GoogleSyncTripOmegaUtil.PARAM_PAGE_VALUE, this.f27786c.getPageReferrer());
        OmegaSDKAdapter.trackEvent("map_screen_change_ck", (Map<String, Object>) hashMap);
    }

    public void trackOrderLocationPermission(int i, int i2) {
        SystemUtils.log(4, f27784a, "trackOrderLocationPermission: phoneType = " + i + "\t appType = " + i2, (Throwable) null, "com.didi.map.google.manager.OmegaReportManager", 571);
        HashMap hashMap = new HashMap();
        hashMap.put("timestamp", Long.valueOf(System.currentTimeMillis()));
        hashMap.put("type", Integer.valueOf(i));
        hashMap.put("app", Integer.valueOf(i2));
        OmegaCommonArgsAppender.append(hashMap, this.f27786c.getUid(), this.f27786c.getOrderId(), this.f27786c.getOrderState(), this.f27786c.isArrived(), this.f27786c.getProductId(), this.f27786c.getRole(), GoogleSyncTripOmegaUtil.PARAM_PAGE_VALUE, this.f27786c.getPageReferrer());
        OmegaSDKAdapter.trackEvent("map_permissions_per_order_pas_android_sw", (Map<String, Object>) hashMap);
    }

    public void trackOrderRouteParamError(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("error_field", Integer.valueOf(i));
        OmegaSDKAdapter.trackEvent("tech_global_orderroute_error", (Map<String, Object>) hashMap);
    }

    public void trackOrderRouteResultError(int i, long j) {
        HashMap hashMap = new HashMap();
        hashMap.put("logid", Long.valueOf(j));
        hashMap.put("errno", Integer.valueOf(i));
        OmegaSDKAdapter.trackEvent("tech_global_orderroute_error", (Map<String, Object>) hashMap);
    }

    public static void traceSctxAbnormalError(String str, int i, String str2, String str3, int i2) {
        if (ApolloUtils.getSctxAbnormalErrorOmegaToggle()) {
            HashMap hashMap = new HashMap();
            hashMap.put("error_code", str);
            hashMap.put("sctx_version", Integer.valueOf(i));
            hashMap.put("sctx_orderid", str3);
            hashMap.put("sctx_app_version", str2);
            hashMap.put("sctx_order_status", Integer.valueOf(i2));
            OmegaSDKAdapter.trackEvent("tech_sctx_abnormal_error", (Map<String, Object>) hashMap);
        }
    }

    public void reportSctxErrorCode(String str) {
        traceSctxAbnormalError(str, 1, PaxEnvironment.getInstance().getAppVersion(), this.f27786c.getOrderId(), this.f27786c.getOrderState());
    }

    public void clear() {
        this.f27785b = 0.0d;
        this.f27789f.clear();
    }
}
