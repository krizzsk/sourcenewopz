package com.didi.map.sdk.nav.inertia;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.DDSphericalUtil;
import com.didi.common.map.util.DLog;
import com.didi.map.sdk.nav.car.AnimateNode;
import com.didi.map.sdk.nav.inertia.IInertiaDelegate;
import com.didi.map.sdk.nav.inertia.SimulateInfo;
import com.didi.map.sdk.nav.jni.JniCreator;
import com.didi.map.sdk.nav.prediction.SctxPredictionDataManager;
import com.didi.map.sdk.nav.prediction.SctxPredictionOmegaData;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.bigdata.p173dp.locsdk.ntp.TimeServiceManager;
import com.map.sdk.nav.libc.common.ApolloUtil;
import com.map.sdk.nav.libc.common.CommonUtils;
import com.map.sdk.nav.libc.common.Convertor;
import com.map.sdk.nav.libc.common.DMKEventPoint;
import com.map.sdk.nav.libc.common.DMKMatchResult;
import com.map.sdk.nav.libc.common.DMKMockConfig;
import com.map.sdk.nav.libc.common.GeoPoint;
import com.map.sdk.nav.libc.common.MapMatchTracker;
import com.map.sdk.nav.libc.common.MapMatchType;
import com.map.sdk.nav.libc.common.RouteGuidanceGPSPoint;
import com.map.sdk.nav.libc.jni.JniWrapperInterface;
import java.util.ArrayList;
import java.util.List;

public class InertiaEngine implements IInertiaDelegate {

    /* renamed from: a */
    private static final String f28432a = "InertiaEngine";

    /* renamed from: b */
    private static final int f28433b = 1;

    /* renamed from: c */
    private static final int f28434c = 2;

    /* renamed from: d */
    private static final int f28435d = 3;

    /* renamed from: e */
    private static final int f28436e = 4;

    /* renamed from: f */
    private static final int f28437f = 5;

    /* renamed from: g */
    private static final int f28438g = 6;

    /* renamed from: h */
    private static final int f28439h = 7;

    /* renamed from: v */
    private static final int f28440v = 4;

    /* renamed from: x */
    private static final int f28441x = 6;

    /* renamed from: A */
    private ApolloCache f28442A;

    /* renamed from: B */
    private SctxStateEnum f28443B;

    /* renamed from: C */
    private SctxStateInfo f28444C;

    /* renamed from: D */
    private IInertiaDelegate.ISimulateEvaluateCallback f28445D;

    /* renamed from: E */
    private SimulateInfo f28446E;

    /* renamed from: F */
    private ApolloParamsSctxPrediction f28447F;

    /* renamed from: G */
    private long f28448G = 3000;

    /* renamed from: H */
    private String f28449H = "ddMapkit";

    /* renamed from: i */
    private Context f28450i;

    /* renamed from: j */
    private List<LatLng> f28451j;

    /* renamed from: k */
    private OnLocationMatched f28452k;

    /* renamed from: l */
    private JniWrapperInterface f28453l;

    /* renamed from: m */
    private DMKMatchResult f28454m;

    /* renamed from: n */
    private DMKEventPoint f28455n;

    /* renamed from: o */
    private MatchPointType f28456o = MatchPointType.UNKNOWN;

    /* renamed from: p */
    private RouteGuidanceGPSPoint f28457p;

    /* renamed from: q */
    private LimitQueue<RouteGuidanceGPSPoint> f28458q;

    /* renamed from: r */
    private RouteGuidanceGPSPoint f28459r;

    /* renamed from: s */
    private RouteGuidanceGPSPoint f28460s;

    /* renamed from: t */
    private RouteGuidanceGPSPoint f28461t;

    /* renamed from: u */
    private int f28462u = 0;

    /* renamed from: w */
    private int f28463w = 0;

    /* renamed from: y */
    private boolean f28464y;

    /* renamed from: z */
    private int f28465z;

    private InertiaEngine(Context context) {
        this.f28450i = context;
        CommonUtils.setContext(context);
        this.f28457p = new RouteGuidanceGPSPoint();
        this.f28442A = new ApolloCache();
        this.f28457p.segmentIndex = -1;
        this.f28455n = new DMKEventPoint();
        this.f28454m = new DMKMatchResult();
        this.f28458q = new LimitQueue<>(this.f28442A.getListSize());
        SimulateInfo simulateInfo = new SimulateInfo();
        this.f28446E = simulateInfo;
        simulateInfo.reset();
        this.f28444C = new SctxStateInfo();
    }

    public static InertiaEngine create(Context context) {
        return new InertiaEngine(context);
    }

    /* renamed from: a */
    private boolean m20132a(int i) {
        if (this.f28451j != null) {
            RouteGuidanceGPSPoint routeGuidanceGPSPoint = this.f28459r;
            double d = 0.0d;
            if (routeGuidanceGPSPoint == null || routeGuidanceGPSPoint.segmentIndex <= -1 || this.f28459r.segmentIndex >= this.f28451j.size() - 1) {
                int i2 = 0;
                while (i2 < this.f28451j.size() - 1) {
                    i2++;
                    d += DDSphericalUtil.computeDistanceBetween(this.f28451j.get(i2), this.f28451j.get(i2));
                    if (d > ((double) i)) {
                        return true;
                    }
                }
            } else {
                double d2 = 0.0d - ((double) this.f28459r.shapeOffSet);
                int i3 = this.f28459r.segmentIndex;
                while (i3 < this.f28451j.size() - 1) {
                    i3++;
                    d2 += DDSphericalUtil.computeDistanceBetween(this.f28451j.get(i3), this.f28451j.get(i3));
                    if (d2 > ((double) i)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    private void m20126a() {
        RouteGuidanceGPSPoint last;
        RouteGuidanceGPSPoint first;
        LimitQueue<RouteGuidanceGPSPoint> limitQueue = this.f28458q;
        if (limitQueue != null && limitQueue.size() > 0 && (first = this.f28458q.getFirst()) != null && this.f28460s.timestamp - first.timestamp > 150) {
            this.f28458q.poll();
        }
        LimitQueue<RouteGuidanceGPSPoint> limitQueue2 = this.f28458q;
        if (limitQueue2 != null && this.f28457p != null) {
            if (limitQueue2.size() <= 0 || (last = this.f28458q.getLast()) == null || (!(this.f28457p.segmentIndex == last.segmentIndex && this.f28457p.shapeOffSet == last.shapeOffSet) && !this.f28457p.point.equals(last.point))) {
                this.f28458q.offer(this.f28457p.copy());
            }
        }
    }

    public void getMatchPoint(boolean z) {
        if (!m20132a(this.f28442A.getAllow_dis())) {
            DLog.m7384d(f28432a, "getMatchPoint|LastDistance less than AllowDis", new Object[0]);
            z = false;
        }
        RouteGuidanceGPSPoint routeGuidanceGPSPoint = this.f28460s;
        if (routeGuidanceGPSPoint == null) {
            this.f28456o = MatchPointType.UNKNOWN;
            DLog.m7384d(f28432a, "onMatchRoute gps is null", new Object[0]);
            m20128a(1, z);
            return;
        }
        if (this.f28459r == null) {
            this.f28459r = routeGuidanceGPSPoint.copy();
        }
        if (this.f28461t == null || !this.f28460s.point.equals(this.f28461t.point)) {
            this.f28461t = this.f28460s;
            if (m20135b()) {
                m20136c();
                if (this.f28452k != null && this.f28453l.isOutWay()) {
                    this.f28452k.onOffRoute();
                }
                m20128a(4, z);
                return;
            }
            m20128a(3, z);
        } else if (this.f28461t.timestamp != this.f28460s.timestamp) {
            this.f28461t = this.f28460s;
            if (!m20135b()) {
                m20128a(3, z);
            } else if (this.f28456o == MatchPointType.UNKNOWN || this.f28456o == MatchPointType.GPS) {
                m20128a(5, z);
            } else {
                m20128a(6, z);
            }
        } else {
            this.f28461t = this.f28460s;
            m20128a(2, z);
        }
    }

    /* renamed from: b */
    private boolean m20135b() {
        ApolloParamsSctxPrediction apolloParamsSctxPrediction;
        if (this.f28453l == null) {
            return false;
        }
        if (this.f28454m == null) {
            this.f28454m = new DMKMatchResult();
        }
        this.f28454m.resGpsFrequency = ((float) this.f28448G) / 1000.0f;
        RouteGuidanceGPSPoint matchResult = this.f28453l.matchResult(this.f28460s, this.f28454m);
        if (!(this.f28465z != 0 || (apolloParamsSctxPrediction = this.f28447F) == null || !apolloParamsSctxPrediction.isPredictionOmegaEnabled() || matchResult == null || distanceLeft(matchResult) >= this.f28447F.startOmgDist || matchResult.point == null || matchResult.originMatchPoint == null || matchResult.originMatchPoint.point == null)) {
            LatLng a = m20124a(matchResult.originMatchPoint.point);
            LatLng a2 = m20124a(matchResult.point);
            SctxPredictionDataManager instance = SctxPredictionDataManager.getInstance();
            SctxPredictionOmegaData sctxPredictionOmegaData = r6;
            SctxPredictionOmegaData sctxPredictionOmegaData2 = new SctxPredictionOmegaData(a.latitude, a.longitude, a2.latitude, a2.longitude, matchResult.timestamp);
            instance.insertData(sctxPredictionOmegaData);
        }
        DMKMatchResult dMKMatchResult = this.f28454m;
        if (dMKMatchResult == null) {
            return false;
        }
        RouteGuidanceGPSPoint convertFromDMKGPSPoint = Convertor.convertFromDMKGPSPoint(dMKMatchResult.resMatchPoint);
        this.f28457p.point = convertFromDMKGPSPoint.point;
        this.f28457p.velocity = convertFromDMKGPSPoint.velocity;
        this.f28457p.timestamp = convertFromDMKGPSPoint.timestamp;
        this.f28457p.source = convertFromDMKGPSPoint.source;
        this.f28457p.shapeOffSet = convertFromDMKGPSPoint.shapeOffSet;
        this.f28457p.segmentIndex = convertFromDMKGPSPoint.segmentIndex;
        this.f28457p.matchedStatus = convertFromDMKGPSPoint.matchedStatus;
        this.f28457p.heading = convertFromDMKGPSPoint.heading;
        this.f28457p.accuracy = convertFromDMKGPSPoint.accuracy;
        if (matchResult != null) {
            this.f28457p.originMatchPoint = matchResult.originMatchPoint;
        }
        this.f28456o = MatchPointType.valueOf(this.f28454m.resPointType);
        this.f28455n = this.f28454m.resEventPoint;
        return true;
    }

    public void destroy() {
        DLog.m7384d(f28432a, "destroy", new Object[0]);
        JniWrapperInterface jniWrapperInterface = this.f28453l;
        if (jniWrapperInterface != null) {
            jniWrapperInterface.destroy();
            this.f28453l = null;
        }
        LimitQueue<RouteGuidanceGPSPoint> limitQueue = this.f28458q;
        if (limitQueue != null) {
            limitQueue.clear();
            this.f28458q = null;
        }
        this.f28446E = null;
        this.f28457p = null;
        this.f28459r = null;
        this.f28451j = null;
        this.f28463w = 0;
        this.f28462u = 0;
        this.f28444C = null;
        this.f28442A = null;
        this.f28455n = null;
        this.f28445D = null;
    }

    public void setRoutePoints(List<LatLng> list, boolean z) {
        this.f28464y = z;
        setRoutePoints(list);
    }

    public void setRoutePoints(List<LatLng> list) {
        DLog.m7384d(f28432a, " setRoutePoints", new Object[0]);
        this.f28451j = list;
        JniWrapperInterface jniWrapperInterface = this.f28453l;
        if (jniWrapperInterface != null) {
            jniWrapperInterface.destroy();
            this.f28453l = null;
        }
        LimitQueue<RouteGuidanceGPSPoint> limitQueue = this.f28458q;
        if (limitQueue != null) {
            limitQueue.clear();
        }
        this.f28459r = null;
        this.f28463w = 0;
        this.f28462u = 0;
        this.f28461t = null;
        RouteGuidanceGPSPoint routeGuidanceGPSPoint = new RouteGuidanceGPSPoint();
        this.f28457p = routeGuidanceGPSPoint;
        routeGuidanceGPSPoint.segmentIndex = -1;
        if (list != null && list.size() > 1) {
            this.f28453l = JniCreator.get();
            DMKMockConfig dMKMockConfig = new DMKMockConfig();
            ApolloParamsSctxPrediction apolloParamsSctxPrediction = this.f28447F;
            if (apolloParamsSctxPrediction != null) {
                dMKMockConfig.enableMock = apolloParamsSctxPrediction.isPredictionEnabled();
                dMKMockConfig.coefficient = this.f28447F.coefficient;
                dMKMockConfig.distDisableMock = this.f28447F.distDisableMock;
            }
            this.f28453l.setMockConfig(dMKMockConfig);
            this.f28453l.setRouteId(this.f28449H);
            this.f28453l.setRoutePoints(m20133a(list));
            this.f28453l.setNextRoutePoints((List<LatLng>) null);
        }
    }

    public void setRoutePoints(List<LatLng> list, int i) {
        if (list == null || list.size() <= 1 || list.size() <= i) {
            setRoutePoints(list);
            return;
        }
        setRoutePoints(list.subList(0, i));
        List<LatLng> subList = list.subList(i, list.size());
        JniWrapperInterface jniWrapperInterface = this.f28453l;
        if (jniWrapperInterface != null) {
            jniWrapperInterface.setNextRoutePoints(subList);
        }
    }

    public void setRoutePoints(List<LatLng> list, int i, boolean z) {
        this.f28464y = z;
        setRoutePoints(list, i);
    }

    public void setRouteId(String str) {
        this.f28449H = str;
    }

    public void onRecvDriverLocation(RouteGuidanceGPSPoint routeGuidanceGPSPoint) {
        this.f28460s = routeGuidanceGPSPoint;
        if (routeGuidanceGPSPoint != null) {
            DLog.m7384d(f28432a, "onRecvDriverLocation: %s ", routeGuidanceGPSPoint.toString());
            return;
        }
        DLog.m7384d(f28432a, "onRecvDriverLocation: null", new Object[0]);
    }

    public void resetRecvDriverLocation() {
        this.f28461t = null;
    }

    public void setOnLocationMatched(OnLocationMatched onLocationMatched) {
        this.f28452k = onLocationMatched;
    }

    public void setOrderInfo(String str, int i) {
        this.f28465z = i;
        ApolloParamsSctxPrediction apolloParamsSctxPrediction = this.f28447F;
        if (apolloParamsSctxPrediction != null && apolloParamsSctxPrediction.isPredictionOmegaEnabled()) {
            if (i == 0) {
                SctxPredictionDataManager.getInstance().clearData();
            } else if (i == 1) {
                SctxPredictionDataManager.getInstance().doOmega(str);
            }
        }
        MapMatchTracker.setOrderId(str);
        DLog.m7384d(f28432a, "setOrderInfo: id= " + str + ",stage=" + i, new Object[0]);
    }

    public void setPredictionApolloParams(ApolloParamsSctxPrediction apolloParamsSctxPrediction) {
        this.f28447F = apolloParamsSctxPrediction;
        if (apolloParamsSctxPrediction != null) {
            DLog.m7384d(f28432a, apolloParamsSctxPrediction.toString(), new Object[0]);
        }
    }

    public int distanceLeft(RouteGuidanceGPSPoint routeGuidanceGPSPoint) {
        JniWrapperInterface jniWrapperInterface = this.f28453l;
        if (jniWrapperInterface != null) {
            return jniWrapperInterface.distanceLeft(routeGuidanceGPSPoint);
        }
        return 0;
    }

    public int distanceLeft() {
        JniWrapperInterface jniWrapperInterface = this.f28453l;
        if (jniWrapperInterface != null) {
            return jniWrapperInterface.distanceLeft2();
        }
        return 0;
    }

    public MatchPointType getMatchPointType() {
        DLog.m7384d(f28432a, "getMatchPointType = " + this.f28456o, new Object[0]);
        return this.f28456o;
    }

    public void setSimulateEvaluateCallback(IInertiaDelegate.ISimulateEvaluateCallback iSimulateEvaluateCallback) {
        this.f28445D = iSimulateEvaluateCallback;
    }

    public void setRequestIntervalInMills(int i) {
        this.f28448G = (long) i;
    }

    public RouteGuidanceGPSPoint getLastMatchGPSPoint() {
        return this.f28457p;
    }

    public int getEventPointSize() {
        JniWrapperInterface jniWrapperInterface = this.f28453l;
        if (jniWrapperInterface != null) {
            return jniWrapperInterface.getEventPointSize();
        }
        return 0;
    }

    public ArrayList<DMKEventPoint> getEventPointList() {
        ArrayList<DMKEventPoint> arrayList = new ArrayList<>();
        JniWrapperInterface jniWrapperInterface = this.f28453l;
        if (jniWrapperInterface != null) {
            jniWrapperInterface.getEventPointList(arrayList);
        }
        return arrayList;
    }

    public MapMatchType getMapMatchType() {
        JniWrapperInterface jniWrapperInterface = this.f28453l;
        if (jniWrapperInterface != null) {
            return jniWrapperInterface.getMapMatchType();
        }
        return MapMatchType.UNKNOWN;
    }

    /* renamed from: a */
    private void m20128a(int i, boolean z) {
        RouteGuidanceGPSPoint routeGuidanceGPSPoint;
        OnLocationMatched onLocationMatched;
        DLog.m7384d(f28432a, "doInertiaNavi, matchType:" + i + ",isNeedSimulate =" + z, new Object[0]);
        RouteGuidanceGPSPoint routeGuidanceGPSPoint2 = this.f28459r;
        if (routeGuidanceGPSPoint2 != null) {
            if (this.f28464y) {
                switch (i) {
                    case 1:
                    case 2:
                        SctxStateEnum sctxStateEnum = SctxStateEnum.NO_CAR_LOC_INERTIA;
                        int i2 = this.f28463w;
                        double d = 0.0d;
                        if (i2 > 2) {
                            LimitQueue<RouteGuidanceGPSPoint> limitQueue = this.f28458q;
                            if (limitQueue == null || limitQueue.size() <= 2) {
                                d = (double) this.f28442A.getMinSpeed();
                            } else {
                                RouteGuidanceGPSPoint first = this.f28458q.getFirst();
                                RouteGuidanceGPSPoint last = this.f28458q.getLast();
                                if (!(first == null || last == null)) {
                                    d = m20122a(first, last) / ((double) (last.timestamp - first.timestamp));
                                }
                                d = Math.min(Math.max(d * ((double) this.f28442A.getCoefficient()), (double) this.f28442A.getMinSpeed()), (double) this.f28442A.getMaxSpeed());
                            }
                        } else {
                            this.f28463w = i2 + 1;
                        }
                        m20127a((float) d, 3, sctxStateEnum, z);
                        return;
                    case 3:
                    case 5:
                        break;
                    case 4:
                        RouteGuidanceGPSPoint routeGuidanceGPSPoint3 = this.f28457p;
                        if (routeGuidanceGPSPoint3 != null && routeGuidanceGPSPoint3.segmentIndex > -1) {
                            this.f28463w = 0;
                            int i3 = this.f28462u;
                            if (i3 >= 4) {
                                OnLocationMatched onLocationMatched2 = this.f28452k;
                                if (onLocationMatched2 != null) {
                                    onLocationMatched2.onSctxSuspiciousJumpError(SctxInertiaSuspiciousStatus.INERTIA_MATCH_FAIL);
                                }
                            } else if (i3 == 0 && DDSphericalUtil.computeDistanceBetween(m20124a(this.f28459r.point), m20124a(this.f28457p.point)) > 100.0d && (onLocationMatched = this.f28452k) != null) {
                                onLocationMatched.onSctxSuspiciousJumpError(SctxInertiaSuspiciousStatus.DRIVER_LOC_TOO_FAR);
                            }
                            this.f28462u = 0;
                            RouteGuidanceGPSPoint routeGuidanceGPSPoint4 = this.f28459r;
                            if (routeGuidanceGPSPoint4 == null || routeGuidanceGPSPoint4.segmentIndex <= -1 || (this.f28459r.segmentIndex <= this.f28457p.segmentIndex && (this.f28459r.segmentIndex != this.f28457p.segmentIndex || this.f28459r.shapeOffSet <= this.f28457p.shapeOffSet))) {
                                RouteGuidanceGPSPoint routeGuidanceGPSPoint5 = this.f28457p;
                                if (routeGuidanceGPSPoint5 != null && routeGuidanceGPSPoint5.point != null && this.f28452k != null) {
                                    m20129a(new LatLng(((double) this.f28457p.point.getLatitudeE6()) / 1000000.0d, ((double) this.f28457p.point.getLongitudeE6()) / 1000000.0d), this.f28457p.segmentIndex, this.f28457p.shapeOffSet, 0, 0, false, this.f28455n);
                                    this.f28459r.shapeOffSet = this.f28457p.shapeOffSet;
                                    this.f28459r.segmentIndex = this.f28457p.segmentIndex;
                                    this.f28459r.timestamp = this.f28457p.timestamp;
                                    this.f28459r.source = this.f28457p.source;
                                    this.f28459r.point = this.f28457p.point;
                                    m20134b(SctxStateEnum.NORMAL, 0);
                                    return;
                                }
                                return;
                            }
                            m20127a(z ? (float) this.f28442A.getCatchspeed() : 0.0f, 3, SctxStateEnum.MATCH_SUCCESS_INERTIA, z);
                            return;
                        }
                        break;
                    case 6:
                        SctxStateEnum sctxStateEnum2 = SctxStateEnum.WIFI_INERTIA;
                        if (this.f28456o == MatchPointType.MOBILE_STATION) {
                            sctxStateEnum2 = SctxStateEnum.NETWORK_INERTIA;
                        }
                        m20127a((float) this.f28442A.getNetpoint_speed(), 3, sctxStateEnum2, z);
                        return;
                    case 7:
                        SctxStateEnum sctxStateEnum3 = SctxStateEnum.NOT_MOVE;
                        int i4 = this.f28462u;
                        if (i4 >= 6) {
                            m20127a((float) this.f28442A.getStandstill_speed(), 3, sctxStateEnum3, z);
                            return;
                        }
                        this.f28462u = i4 + 1;
                        DLog.m7384d(f28432a, "doInertiaNavi, mCarStandCount=" + this.f28462u, new Object[0]);
                        m20127a(0.0f, 3, sctxStateEnum3, z);
                        return;
                    default:
                        return;
                }
                SctxStateEnum sctxStateEnum4 = i != 5 ? SctxStateEnum.MATCH_FAIL_INERTIA : SctxStateEnum.NOT_MOVE;
                int i5 = this.f28462u;
                if (i5 >= 4) {
                    m20127a((float) this.f28442A.getStandstill_speed(), 3, sctxStateEnum4, z);
                    return;
                }
                this.f28462u = i5 + 1;
                m20127a(0.0f, 3, sctxStateEnum4, z);
                return;
            }
            if (i == 4) {
                RouteGuidanceGPSPoint routeGuidanceGPSPoint6 = this.f28457p;
                if (routeGuidanceGPSPoint6 != null) {
                    this.f28459r = routeGuidanceGPSPoint6.copy();
                }
            } else if (!(routeGuidanceGPSPoint2 == null || (routeGuidanceGPSPoint = this.f28460s) == null)) {
                RouteGuidanceGPSPoint copy = routeGuidanceGPSPoint.copy();
                this.f28459r = copy;
                copy.segmentIndex = -1;
            }
            RouteGuidanceGPSPoint routeGuidanceGPSPoint7 = this.f28459r;
            if (routeGuidanceGPSPoint7 != null && routeGuidanceGPSPoint7.point != null && this.f28452k != null) {
                m20129a(new LatLng(((double) this.f28459r.point.getLatitudeE6()) / 1000000.0d, ((double) this.f28459r.point.getLongitudeE6()) / 1000000.0d), this.f28459r.segmentIndex, this.f28459r.shapeOffSet, 0, 0, false, this.f28455n);
                m20134b(SctxStateEnum.IDLE, 0);
            }
        }
    }

    /* renamed from: a */
    private double m20122a(RouteGuidanceGPSPoint routeGuidanceGPSPoint, RouteGuidanceGPSPoint routeGuidanceGPSPoint2) {
        List<LatLng> list;
        if (routeGuidanceGPSPoint == null || routeGuidanceGPSPoint2 == null || (list = this.f28451j) == null || list.size() < routeGuidanceGPSPoint2.segmentIndex + 1) {
            return -1.0d;
        }
        if (routeGuidanceGPSPoint.segmentIndex == routeGuidanceGPSPoint2.segmentIndex) {
            return DDSphericalUtil.computeDistanceBetween(m20124a(routeGuidanceGPSPoint.point), m20124a(routeGuidanceGPSPoint2.point));
        }
        if (routeGuidanceGPSPoint.segmentIndex > routeGuidanceGPSPoint2.segmentIndex) {
            return -1.0d;
        }
        double computeDistanceBetween = DDSphericalUtil.computeDistanceBetween(m20124a(routeGuidanceGPSPoint.point), this.f28451j.get(routeGuidanceGPSPoint.segmentIndex + 1));
        if (routeGuidanceGPSPoint.segmentIndex + 1 < routeGuidanceGPSPoint2.segmentIndex) {
            int i = routeGuidanceGPSPoint.segmentIndex + 1;
            while (i < routeGuidanceGPSPoint2.segmentIndex) {
                i++;
                computeDistanceBetween += DDSphericalUtil.computeDistanceBetween(this.f28451j.get(i), this.f28451j.get(i));
            }
        }
        return routeGuidanceGPSPoint2.shapeOffSet > 0 ? computeDistanceBetween + DDSphericalUtil.computeDistanceBetween(this.f28451j.get(routeGuidanceGPSPoint2.segmentIndex), m20124a(routeGuidanceGPSPoint2.point)) : computeDistanceBetween;
    }

    /* renamed from: c */
    private void m20136c() {
        RouteGuidanceGPSPoint routeGuidanceGPSPoint = this.f28457p;
        if (routeGuidanceGPSPoint != null && routeGuidanceGPSPoint.segmentIndex > -1 && this.f28451j != null && this.f28457p.segmentIndex < this.f28451j.size()) {
            double computeDistanceBetween = ((double) this.f28457p.shapeOffSet) / DDSphericalUtil.computeDistanceBetween(this.f28451j.get(this.f28457p.segmentIndex), this.f28451j.get(this.f28457p.segmentIndex + 1));
            if (computeDistanceBetween > 0.0d && computeDistanceBetween < 1.0d) {
                LatLng interpolate = DDSphericalUtil.interpolate(this.f28451j.get(this.f28457p.segmentIndex), this.f28451j.get(this.f28457p.segmentIndex + 1), computeDistanceBetween);
                this.f28457p.point = new GeoPoint((int) (interpolate.latitude * 1000000.0d), (int) (interpolate.longitude * 1000000.0d));
            }
            m20126a();
        }
    }

    /* renamed from: a */
    private LatLng m20124a(GeoPoint geoPoint) {
        if (geoPoint == null) {
            return null;
        }
        return new LatLng(((double) geoPoint.getLatitudeE6()) / 1000000.0d, ((double) geoPoint.getLongitudeE6()) / 1000000.0d);
    }

    /* renamed from: a */
    private GeoPoint m20125a(LatLng latLng) {
        if (latLng == null) {
            return null;
        }
        GeoPoint geoPoint = new GeoPoint();
        geoPoint.setLatitudeE6((int) (latLng.latitude * 1000000.0d));
        geoPoint.setLongitudeE6((int) (latLng.longitude * 1000000.0d));
        return geoPoint;
    }

    /* renamed from: a */
    private GeoPoint[] m20133a(List<LatLng> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        int size = list.size();
        GeoPoint[] geoPointArr = new GeoPoint[size];
        for (int i = 0; i < size; i++) {
            GeoPoint geoPoint = new GeoPoint();
            geoPoint.setLatitudeE6((int) (list.get(i).latitude * 1000000.0d));
            geoPoint.setLongitudeE6((int) (list.get(i).longitude * 1000000.0d));
            geoPointArr[i] = geoPoint;
        }
        return geoPointArr;
    }

    /* renamed from: a */
    private void m20127a(float f, long j, SctxStateEnum sctxStateEnum, boolean z) {
        double d;
        double d2;
        List<LatLng> list;
        RouteGuidanceGPSPoint routeGuidanceGPSPoint;
        long j2 = j;
        SctxStateEnum sctxStateEnum2 = sctxStateEnum;
        if (!z) {
            RouteGuidanceGPSPoint routeGuidanceGPSPoint2 = this.f28459r;
            if (routeGuidanceGPSPoint2 != null && (routeGuidanceGPSPoint = this.f28460s) != null) {
                routeGuidanceGPSPoint2.timestamp = routeGuidanceGPSPoint.timestamp;
                this.f28459r.source = this.f28460s.source;
                m20134b(SctxStateEnum.INERTIA_LIMIT, 0);
                return;
            }
            return;
        }
        RouteGuidanceGPSPoint routeGuidanceGPSPoint3 = this.f28459r;
        if (routeGuidanceGPSPoint3 == null || routeGuidanceGPSPoint3.segmentIndex <= -1) {
            List<LatLng> list2 = this.f28451j;
            if (list2 != null && list2.size() > 0) {
                if (this.f28459r == null) {
                    this.f28459r = new RouteGuidanceGPSPoint();
                }
                this.f28459r.segmentIndex = 0;
                this.f28459r.shapeOffSet = 0;
                this.f28459r.point = m20125a(this.f28451j.get(0));
                if (!ApolloUtil.isSctxSimulationTimestampNTP() || !TimeServiceManager.getInstance().isNTPAvailable()) {
                    this.f28459r.timestamp = System.currentTimeMillis() / 1000;
                } else {
                    this.f28459r.timestamp = TimeServiceManager.getInstance().getNTPCurrenTimeMillis() / 1000;
                }
                RouteGuidanceGPSPoint routeGuidanceGPSPoint4 = this.f28459r;
                RouteGuidanceGPSPoint routeGuidanceGPSPoint5 = this.f28460s;
                routeGuidanceGPSPoint4.source = routeGuidanceGPSPoint5 == null ? 0 : routeGuidanceGPSPoint5.source;
                m20129a(this.f28451j.get(0), this.f28459r.segmentIndex, this.f28459r.shapeOffSet, 0, 0, true, this.f28455n);
                m20134b(sctxStateEnum2, 0);
            }
        } else if (f == 0.0f) {
            RouteGuidanceGPSPoint routeGuidanceGPSPoint6 = this.f28460s;
            if (routeGuidanceGPSPoint6 != null) {
                this.f28459r.timestamp = routeGuidanceGPSPoint6.timestamp;
                this.f28459r.source = this.f28460s.source;
                m20134b(sctxStateEnum2, 0);
            }
        } else {
            float f2 = (this.f28460s == null || (list = this.f28451j) == null || list.size() <= 0 || DDSphericalUtil.computeDistanceBetween(new LatLng(((double) this.f28460s.point.getLatitudeE6()) / 1000000.0d, ((double) this.f28460s.point.getLongitudeE6()) / 1000000.0d), this.f28451j.get(0)) >= 10.0d) ? f : 1.0f;
            if (f2 > ((float) this.f28442A.getMaxSpeed())) {
                f2 = (float) this.f28442A.getMaxSpeed();
            }
            double d3 = 0.0d;
            double d4 = (double) (f2 * ((float) j2));
            int i = this.f28459r.segmentIndex + 1;
            while (i < this.f28451j.size()) {
                if (i == this.f28459r.segmentIndex + 1) {
                    d = DDSphericalUtil.computeDistanceBetween(m20124a(this.f28459r.point), this.f28451j.get(i));
                    d3 += d;
                    if (d3 > d4) {
                        RouteGuidanceGPSPoint routeGuidanceGPSPoint7 = this.f28459r;
                        routeGuidanceGPSPoint7.shapeOffSet = (int) (((double) routeGuidanceGPSPoint7.shapeOffSet) + d4);
                        double d5 = d4;
                        LatLng a = m20123a(this.f28451j.get(this.f28459r.segmentIndex), this.f28451j.get(this.f28459r.segmentIndex + 1), ((double) this.f28459r.shapeOffSet) / (d + ((double) this.f28459r.shapeOffSet)));
                        this.f28459r.point = m20125a(a);
                        if (!ApolloUtil.isSctxSimulationTimestampNTP() || !TimeServiceManager.getInstance().isNTPAvailable()) {
                            this.f28459r.timestamp = System.currentTimeMillis() / 1000;
                        } else {
                            this.f28459r.timestamp = TimeServiceManager.getInstance().getNTPCurrenTimeMillis() / 1000;
                        }
                        RouteGuidanceGPSPoint routeGuidanceGPSPoint8 = this.f28459r;
                        RouteGuidanceGPSPoint routeGuidanceGPSPoint9 = this.f28460s;
                        routeGuidanceGPSPoint8.source = routeGuidanceGPSPoint9 == null ? 0 : routeGuidanceGPSPoint9.source;
                        int i2 = (int) d5;
                        m20129a(a, this.f28459r.segmentIndex, this.f28459r.shapeOffSet, i2, (int) j2, true, this.f28455n);
                        m20134b(sctxStateEnum2, i2);
                        return;
                    }
                    d2 = d4;
                } else {
                    d2 = d4;
                    d = DDSphericalUtil.computeDistanceBetween(this.f28451j.get(i - 1), this.f28451j.get(i));
                    d3 += d;
                }
                if (d3 > d2) {
                    this.f28459r.segmentIndex = i - 1;
                    this.f28459r.shapeOffSet = (int) ((d - d3) + d2);
                    if (!ApolloUtil.isSctxSimulationTimestampNTP() || !TimeServiceManager.getInstance().isNTPAvailable()) {
                        this.f28459r.timestamp = System.currentTimeMillis() / 1000;
                    } else {
                        this.f28459r.timestamp = TimeServiceManager.getInstance().getNTPCurrenTimeMillis() / 1000;
                    }
                    RouteGuidanceGPSPoint routeGuidanceGPSPoint10 = this.f28459r;
                    RouteGuidanceGPSPoint routeGuidanceGPSPoint11 = this.f28460s;
                    routeGuidanceGPSPoint10.source = routeGuidanceGPSPoint11 == null ? 0 : routeGuidanceGPSPoint11.source;
                    LatLng a2 = m20123a(this.f28451j.get(this.f28459r.segmentIndex), this.f28451j.get(this.f28459r.segmentIndex + 1), ((double) this.f28459r.shapeOffSet) / d);
                    this.f28459r.point = m20125a(a2);
                    int i3 = (int) d2;
                    m20129a(a2, this.f28459r.segmentIndex, this.f28459r.shapeOffSet, i3, (int) j2, true, this.f28455n);
                    m20134b(sctxStateEnum2, i3);
                    return;
                }
                i++;
                d4 = d2;
            }
        }
    }

    /* renamed from: a */
    private void m20129a(LatLng latLng, int i, int i2, int i3, int i4, boolean z, DMKEventPoint dMKEventPoint) {
        OnLocationMatched onLocationMatched = this.f28452k;
        if (onLocationMatched != null) {
            onLocationMatched.onMatched(latLng, i, i2, i3, i4, z, dMKEventPoint);
        }
    }

    /* renamed from: a */
    private void m20131a(SctxStateEnum sctxStateEnum, int i) {
        RouteGuidanceGPSPoint routeGuidanceGPSPoint;
        if (this.f28446E != null && (routeGuidanceGPSPoint = this.f28459r) != null && routeGuidanceGPSPoint.point != null && this.f28442A.isEvaluate() && this.f28464y) {
            AnimateNode animateNode = new AnimateNode(new LatLng(((double) this.f28459r.point.getLatitudeE6()) / 1000000.0d, ((double) this.f28459r.point.getLongitudeE6()) / 1000000.0d), this.f28459r.segmentIndex, this.f28459r.shapeOffSet, false);
            AnimateNode animateNode2 = new AnimateNode(new LatLng(((double) this.f28457p.point.getLatitudeE6()) / 1000000.0d, ((double) this.f28457p.point.getLongitudeE6()) / 1000000.0d), this.f28457p.segmentIndex, this.f28457p.shapeOffSet, false);
            if (sctxStateEnum == SctxStateEnum.NORMAL) {
                this.f28446E.setUseablePoint(animateNode2);
                this.f28446E.setUsablePointTimestamp(System.currentTimeMillis());
            } else if (sctxStateEnum == SctxStateEnum.MATCH_SUCCESS_INERTIA) {
                this.f28446E.setUseablePoint(animateNode2);
                this.f28446E.setUsablePointTimestamp(System.currentTimeMillis());
                if (i > 0) {
                    this.f28446E.setCurrentPoint(animateNode);
                    this.f28446E.setCurrentPointTimestamp(System.currentTimeMillis());
                }
            } else if (i > 0) {
                if (this.f28446E.getStartPoint() == null) {
                    DLog.m7384d(f28432a, " handleSimulate, set startpoint state=" + sctxStateEnum + ",cartStandCount=" + this.f28462u, new Object[0]);
                    this.f28446E.reset();
                    this.f28446E.setStartPoint(animateNode);
                    this.f28446E.setStartPointTimestamp(System.currentTimeMillis());
                    this.f28446E.setSctxStateEnum(sctxStateEnum);
                    this.f28446E.setRepeatPoint(this.f28462u > 4);
                }
                this.f28446E.setCurrentPoint(animateNode);
                this.f28446E.setCurrentPointTimestamp(System.currentTimeMillis());
            }
            int hashCode = this.f28451j.hashCode();
            if (this.f28446E.getRouteCode() == 0) {
                this.f28446E.setRouteCode(hashCode);
                this.f28446E.setMockType(SimulateInfo.MockType.SIMULATINT_WAIT_ARRIVE_R);
            } else if (this.f28446E.getRouteCode() != hashCode) {
                DLog.m7384d(f28432a, " handleSimulate, routeCode changed.", new Object[0]);
                this.f28446E.setRouteCode(hashCode);
                this.f28446E.setMockType(SimulateInfo.MockType.SIMULATE_STOP_ON_OFFROUTE_JUMPTO_R);
            } else if (this.f28446E.mockType != SimulateInfo.MockType.SIMULATE_STOP_ON_OFFROUTE_JUMPTO_R && sctxStateEnum == SctxStateEnum.MATCH_SUCCESS_INERTIA) {
                this.f28446E.setMockType(SimulateInfo.MockType.SIMULATINT_OVER_R_POINT_WAIT_DRIVER_POINT);
            }
            if (this.f28445D != null && this.f28446E.isReportable()) {
                DLog.m7384d(f28432a, " handleSimulate, begin Simulateinfo report. mocktype=" + this.f28446E.getMockType() + ",state=" + sctxStateEnum, new Object[0]);
                this.f28445D.onReceiveSimulateInfo(this.f28446E);
                this.f28446E.setReported(true);
            }
            if (sctxStateEnum == SctxStateEnum.NORMAL) {
                this.f28446E.reset();
            }
        }
    }

    /* renamed from: a */
    private LatLng m20123a(LatLng latLng, LatLng latLng2, double d) {
        return DDSphericalUtil.interpolate(latLng, latLng2, d);
    }

    /* renamed from: b */
    private void m20134b(SctxStateEnum sctxStateEnum, int i) {
        if (this.f28459r != null) {
            m20130a(sctxStateEnum);
            SctxStateInfo sctxStateInfo = this.f28444C;
            if (sctxStateInfo != null && sctxStateInfo.getState() != null) {
                m20137d();
                m20138e();
                m20131a(this.f28444C.getState(), i);
            }
        }
    }

    /* renamed from: d */
    private void m20137d() {
        OnLocationMatched onLocationMatched = this.f28452k;
        if (onLocationMatched != null) {
            onLocationMatched.onSctxStateUpdate(this.f28444C);
        }
    }

    /* renamed from: e */
    private void m20138e() {
        if (this.f28445D != null && this.f28465z == 0) {
            CarMoveInfo carMoveInfo = new CarMoveInfo();
            carMoveInfo.localTime = System.currentTimeMillis() / 1000;
            carMoveInfo.gpsTime = this.f28459r.timestamp;
            if (this.f28459r.point != null) {
                DLog.m7384d(f28432a, "onMatchedAfter mReturnedGps= " + this.f28459r.toString(), new Object[0]);
                carMoveInfo.lat = ((double) this.f28459r.point.getLatitudeE6()) / 1000000.0d;
                carMoveInfo.lon = ((double) this.f28459r.point.getLongitudeE6()) / 1000000.0d;
            }
            carMoveInfo.type = this.f28444C.getState().type;
            carMoveInfo.source = this.f28459r.source;
            carMoveInfo.bindResult = getMapMatchType();
            this.f28445D.onReceiveCarMoveInfo(carMoveInfo);
        }
    }

    /* renamed from: a */
    private void m20130a(SctxStateEnum sctxStateEnum) {
        boolean z = false;
        if (this.f28443B == null || sctxStateEnum != SctxStateEnum.INERTIA_LIMIT) {
            this.f28443B = sctxStateEnum;
            this.f28444C.mo77866a(sctxStateEnum);
            this.f28444C.mo77867a(false);
            return;
        }
        int i = C100111.$SwitchMap$com$didi$map$sdk$nav$inertia$SctxStateEnum[this.f28443B.ordinal()];
        if (i == 1 || i == 2 || i == 3 || i == 4 || i == 5) {
            DLog.m7384d(f28432a, "reset SctxState,stateEnum=" + sctxStateEnum, new Object[0]);
            this.f28444C.mo77867a(false);
            this.f28443B = SctxStateEnum.KEEP_NOW_ON_LIMIT;
        } else {
            SctxStateInfo sctxStateInfo = this.f28444C;
            if (this.f28443B == SctxStateEnum.INERTIA_LIMIT) {
                z = true;
            }
            sctxStateInfo.mo77867a(z);
            this.f28443B = sctxStateEnum;
        }
        this.f28444C.mo77866a(this.f28443B);
    }

    /* renamed from: com.didi.map.sdk.nav.inertia.InertiaEngine$1 */
    static /* synthetic */ class C100111 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$map$sdk$nav$inertia$SctxStateEnum;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.didi.map.sdk.nav.inertia.SctxStateEnum[] r0 = com.didi.map.sdk.nav.inertia.SctxStateEnum.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$didi$map$sdk$nav$inertia$SctxStateEnum = r0
                com.didi.map.sdk.nav.inertia.SctxStateEnum r1 = com.didi.map.sdk.nav.inertia.SctxStateEnum.NORMAL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$didi$map$sdk$nav$inertia$SctxStateEnum     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.map.sdk.nav.inertia.SctxStateEnum r1 = com.didi.map.sdk.nav.inertia.SctxStateEnum.NOT_MOVE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$didi$map$sdk$nav$inertia$SctxStateEnum     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.map.sdk.nav.inertia.SctxStateEnum r1 = com.didi.map.sdk.nav.inertia.SctxStateEnum.MATCH_FAIL_INERTIA     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$didi$map$sdk$nav$inertia$SctxStateEnum     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.didi.map.sdk.nav.inertia.SctxStateEnum r1 = com.didi.map.sdk.nav.inertia.SctxStateEnum.MATCH_SUCCESS_INERTIA     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$didi$map$sdk$nav$inertia$SctxStateEnum     // Catch:{ NoSuchFieldError -> 0x003e }
                com.didi.map.sdk.nav.inertia.SctxStateEnum r1 = com.didi.map.sdk.nav.inertia.SctxStateEnum.KEEP_NOW_ON_LIMIT     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.map.sdk.nav.inertia.InertiaEngine.C100111.<clinit>():void");
        }
    }

    public static boolean isNetWorkEnable(Context context) {
        if (context == null) {
            DLog.m7384d(f28432a, "isNetWorkEnable false 0", new Object[0]);
            return false;
        }
        NetworkInfo activeNetworkInfo = SystemUtils.getActiveNetworkInfo((ConnectivityManager) context.getSystemService("connectivity"));
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        DLog.m7384d(f28432a, "isNetWorkEnable false 1", new Object[0]);
        return false;
    }
}
