package com.didi.map.sdk.sharetrack.external;

import android.app.Activity;
import android.content.Context;
import com.didi.common.map.Map;
import com.didi.common.map.MapVendor;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.BitmapDescriptor;
import com.didi.common.map.model.GpsLocation;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.LineOptions;
import com.didi.common.map.model.Marker;
import com.didi.common.map.util.DDSphericalUtil;
import com.didi.map.sdk.nav.car.CameraMode;
import com.didi.map.sdk.nav.line.MultiLine;
import com.didi.map.sdk.sharetrack.callback.IBusinessEventCallback;
import com.didi.map.sdk.sharetrack.callback.INavigationCallback;
import com.didi.map.sdk.sharetrack.callback.INavigationInnerCallback;
import com.didi.map.sdk.sharetrack.callback.IOrderFeatureDataCallback;
import com.didi.map.sdk.sharetrack.callback.ISearchOffRouteCallback;
import com.didi.map.sdk.sharetrack.callback.ISearchRouteCallback;
import com.didi.map.sdk.sharetrack.common.ShareTrackApolloHelper;
import com.didi.map.sdk.sharetrack.common.ShareTrackUtils;
import com.didi.map.sdk.sharetrack.entity.OrderInfo;
import com.didi.map.sdk.sharetrack.entity.OrderPoint;
import com.didi.map.sdk.sharetrack.entity.StreetViewInfo;
import com.didi.map.sdk.sharetrack.external.round.BaseRoundStrategy;
import com.didi.map.sdk.sharetrack.external.round.FarNoRoundStrategy;
import com.didi.map.sdk.sharetrack.external.round.IRoundStatusChangeListener;
import com.didi.map.sdk.sharetrack.external.round.NearNoRoundStrategy;
import com.didi.map.sdk.sharetrack.external.round.NearRoundStrategy;
import com.didi.map.sdk.sharetrack.external.view.INavSkin;
import com.didi.map.sdk.sharetrack.logger.DLog;
import com.didi.map.sdk.sharetrack.net.DataFetcherManager;
import com.didichuxing.routesearchsdk.CallFrom;
import com.map.sdk.nav.libc.common.RouteGuidanceGPSPoint;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 ­\u00012\u00020\u00012\u00020\u0002:\u0002­\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0013H\u0016J\b\u0010'\u001a\u00020%H\u0002J\u0010\u0010(\u001a\u00020%2\u0006\u0010)\u001a\u00020\tH\u0002J\b\u0010*\u001a\u00020%H\u0016J\b\u0010+\u001a\u00020%H\u0002J\u0010\u0010,\u001a\u00020%2\u0006\u0010-\u001a\u00020\u0013H\u0016J\n\u0010.\u001a\u0004\u0018\u00010/H\u0016J\b\u00100\u001a\u00020\tH\u0016J\n\u00101\u001a\u0004\u0018\u000102H\u0016J\n\u00103\u001a\u0004\u0018\u000104H\u0016J\n\u00105\u001a\u0004\u0018\u000106H\u0016J\n\u00107\u001a\u0004\u0018\u000108H\u0016J\b\u00109\u001a\u00020\tH\u0016J\n\u0010:\u001a\u0004\u0018\u000106H\u0016J\b\u0010;\u001a\u00020\tH\u0016J\u0012\u0010<\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010>\u0018\u00010=H\u0016J\u0010\u0010?\u001a\u00020\t2\u0006\u0010@\u001a\u00020\tH\u0016J\u0010\u0010A\u001a\u00020\t2\u0006\u0010@\u001a\u00020\tH\u0016J\b\u0010B\u001a\u00020\tH\u0016J\n\u0010C\u001a\u0004\u0018\u00010DH\u0016J\u0010\u0010E\u001a\u00020%2\u0006\u0010)\u001a\u00020\tH\u0002J$\u0010F\u001a\u00020%2\b\u0010G\u001a\u0004\u0018\u00010\u00072\b\u0010H\u001a\u0004\u0018\u00010#2\u0006\u0010I\u001a\u00020\u0013H\u0016J\b\u0010J\u001a\u00020\u0013H\u0016J\b\u0010K\u001a\u00020\u0013H\u0016J\b\u0010L\u001a\u00020\u0013H\u0016J\b\u0010M\u001a\u00020%H\u0002J*\u0010N\u001a\u00020%2\b\u0010O\u001a\u0004\u0018\u00010\u00102\u000e\u0010P\u001a\n\u0012\u0004\u0012\u00020>\u0018\u00010=2\u0006\u0010Q\u001a\u00020RH\u0016J\u0010\u0010S\u001a\u00020%2\u0006\u0010T\u001a\u00020\tH\u0016J\u0010\u0010U\u001a\u00020%2\u0006\u0010V\u001a\u00020\u0013H\u0016J\b\u0010W\u001a\u00020%H\u0016J\u0010\u0010X\u001a\u00020%2\u0006\u0010Y\u001a\u00020\u0013H\u0016J\"\u0010Z\u001a\u00020%2\b\u0010[\u001a\u0004\u0018\u00010\\2\u000e\u0010]\u001a\n\u0012\u0004\u0012\u00020\\\u0018\u00010=H\u0016J(\u0010^\u001a\u00020%2\u0006\u0010_\u001a\u00020\t2\u0006\u0010`\u001a\u00020\t2\u0006\u0010a\u001a\u00020\t2\u0006\u0010b\u001a\u00020\tH\u0016J\b\u0010c\u001a\u00020%H\u0016J\b\u0010d\u001a\u00020%H\u0016J\b\u0010e\u001a\u00020%H\u0016J\b\u0010f\u001a\u00020%H\u0016J\b\u0010g\u001a\u00020%H\u0002J\b\u0010h\u001a\u00020%H\u0016J\b\u0010i\u001a\u00020%H\u0016J\u0012\u0010j\u001a\u00020%2\b\u0010k\u001a\u0004\u0018\u00010lH\u0016J\u0010\u0010m\u001a\u00020%2\u0006\u0010n\u001a\u00020\u0013H\u0016J\u0012\u0010o\u001a\u00020%2\b\u0010p\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010q\u001a\u00020%2\b\u0010r\u001a\u0004\u0018\u00010sH\u0016J\u0012\u0010t\u001a\u00020%2\b\u0010u\u001a\u0004\u0018\u00010vH\u0016J\u0010\u0010w\u001a\u00020%2\u0006\u0010x\u001a\u00020yH\u0016J\u0012\u0010z\u001a\u00020%2\b\u0010{\u001a\u0004\u0018\u00010|H\u0016J\u0010\u0010}\u001a\u00020%2\u0006\u0010~\u001a\u00020\u0013H\u0016J\u0012\u0010\u001a\u00020%2\b\u0010\u0001\u001a\u00030\u0001H\u0016J\u0013\u0010\u0001\u001a\u00020%2\b\u0010O\u001a\u0004\u0018\u00010\u0010H\u0016J\u0014\u0010\u0001\u001a\u00020%2\t\u0010\u0001\u001a\u0004\u0018\u000102H\u0016J\u0013\u0010\u0001\u001a\u00020%2\b\u0010\u0001\u001a\u00030\u0001H\u0016J\u0012\u0010\u0001\u001a\u00020%2\u0007\u0010\u0001\u001a\u00020\u0013H\u0016J!\u0010\u0001\u001a\u00020%2\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J\u0012\u0010\u0001\u001a\u00020%2\u0007\u0010\u0001\u001a\u00020\u0013H\u0016J\u0014\u0010\u0001\u001a\u00020%2\t\u0010\u0001\u001a\u0004\u0018\u00010\fH\u0016J\u0014\u0010\u0001\u001a\u00020%2\t\u0010\u0001\u001a\u0004\u0018\u00010\fH\u0016J\u0013\u0010\u0001\u001a\u00020%2\b\u0010p\u001a\u0004\u0018\u00010\u0015H\u0016J\u0014\u0010\u0001\u001a\u00020%2\t\u0010\u0001\u001a\u0004\u0018\u00010\u001eH\u0016J\u0019\u0010\u0001\u001a\u00020%2\u000e\u0010P\u001a\n\u0012\u0004\u0012\u00020>\u0018\u00010=H\u0016J\u0011\u0010\u0001\u001a\u00020%2\u0006\u0010Q\u001a\u00020RH\u0016J@\u0010\u0001\u001a\u00020%2\u000f\u0010\u0001\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010=2\u0007\u0010\u0001\u001a\u00020\t2\u0007\u0010\u0001\u001a\u00020\t2\u0007\u0010\u0001\u001a\u00020R2\t\u0010\u0001\u001a\u0004\u0018\u00010\\H\u0016J\u0012\u0010\u0001\u001a\u00020%2\u0007\u0010\u0001\u001a\u00020\tH\u0016J\u0012\u0010 \u0001\u001a\u00020%2\u0007\u0010\u0001\u001a\u00020\u0013H\u0016J\u0014\u0010¡\u0001\u001a\u00020%2\t\u0010p\u001a\u0005\u0018\u00010¢\u0001H\u0016J\u0014\u0010£\u0001\u001a\u00020%2\t\u0010p\u001a\u0005\u0018\u00010¤\u0001H\u0016J\t\u0010¥\u0001\u001a\u00020\u0013H\u0002J\t\u0010¦\u0001\u001a\u00020%H\u0016J\t\u0010§\u0001\u001a\u00020%H\u0016J\t\u0010¨\u0001\u001a\u00020%H\u0016JC\u0010©\u0001\u001a\u00020%2\u0010\u0010ª\u0001\u001a\u000b\u0012\u0005\u0012\u00030«\u0001\u0018\u00010=2\u0006\u0010_\u001a\u00020\t2\u0006\u0010a\u001a\u00020\t2\u0006\u0010`\u001a\u00020\t2\u0006\u0010b\u001a\u00020\t2\u0006\u0010@\u001a\u00020\tH\u0016J\t\u0010¬\u0001\u001a\u00020%H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000¨\u0006®\u0001"}, mo175978d2 = {"Lcom/didi/map/sdk/sharetrack/external/CommonNavigator;", "Lcom/didi/map/sdk/sharetrack/external/INavigator;", "Lcom/didi/map/sdk/sharetrack/external/round/IRoundStatusChangeListener;", "()V", "mBizCallback", "Lcom/didi/map/sdk/sharetrack/callback/IBusinessEventCallback;", "mContext", "Landroid/content/Context;", "mCurEDA", "", "mCurETA", "mCurRouteId", "", "mDataFetcherManager", "Lcom/didi/map/sdk/sharetrack/net/DataFetcherManager;", "mDestination", "Lcom/didi/common/map/model/LatLng;", "mDisBetweenStartAndCar", "mHasSetupStrategy", "", "mNavCallbackOut", "Lcom/didi/map/sdk/sharetrack/callback/INavigationCallback;", "mNavDelegate", "Lcom/didi/map/sdk/sharetrack/external/INavDelegate;", "mNavDelegateCallback", "Lcom/didi/map/sdk/sharetrack/callback/INavigationInnerCallback;", "mNearbyStatus", "mOrderFeatureDataCallback", "Lcom/didi/map/sdk/sharetrack/callback/IOrderFeatureDataCallback;", "mOrderInfo", "Lcom/didi/map/sdk/sharetrack/entity/OrderInfo;", "mParkingStatus", "mStrategy", "Lcom/didi/map/sdk/sharetrack/external/round/BaseRoundStrategy;", "mVendor", "Lcom/didi/common/map/MapVendor;", "changeNightMode", "", "isNight", "checkIsNoRoadNet", "debugToast", "type", "destroy", "fetchORAInfo", "followMyLocation", "isFlow", "getCarMarker", "Lcom/didi/common/map/model/Marker;", "getCurrentNaviStatus", "getDiDiMap", "Lcom/didi/common/map/Map;", "getLine", "Lcom/didi/map/sdk/nav/line/MultiLine;", "getMatchedPoint", "Lcom/map/sdk/nav/libc/common/RouteGuidanceGPSPoint;", "getNavSkin", "Lcom/didi/map/sdk/sharetrack/external/view/INavSkin;", "getNearbyStatus", "getOriginMatchPoint", "getParkingStatus", "getPassPoints", "", "Lcom/didi/map/sdk/sharetrack/entity/OrderPoint;", "getRemainMeters", "endIndex", "getRemainMinutes", "getRemainStraightDistance", "getStreetViewInfo", "Lcom/didi/map/sdk/sharetrack/entity/StreetViewInfo;", "initStrategy", "initWithVendor", "context", "vendor", "isUseNavSDK", "isArriveDest", "isLightNavSctxPaused", "isSctxStarted", "mockData", "modifyRoutes", "dest", "points", "timestamp", "", "onApproaching", "eda", "onArrived", "lineVisible", "onDriveAway", "onLineVisibleChange", "shouldShow", "onLocationChanged", "location", "Lcom/didi/common/map/model/GpsLocation;", "recentLocList", "onNewMargin", "left", "top", "right", "bottom", "onPassPointYaw", "pause4Navigation", "pauseRequestOra", "playOpenningVoice", "resetStatus", "resumeAfterNavigation", "resumeRequestOra", "setActivity", "activity", "Landroid/app/Activity;", "setAudioGuidanceEnabled", "enable", "setBusinessEventCallback", "callback", "setCaller", "caller", "Lcom/didichuxing/routesearchsdk/CallFrom;", "setCameraMode", "mode", "Lcom/didi/map/sdk/nav/car/CameraMode;", "setCarHeadMaxMapLevel", "level", "", "setCarMarkerBitmap", "bitmap", "Lcom/didi/common/map/model/BitmapDescriptor;", "setCarMarkerEnabled", "enabled", "setCarMarkerZindex", "zindex", "", "setDestination", "setDiDiMap", "map", "setGuideRouteLineOpt", "opt", "Lcom/didi/common/map/model/LineOptions;", "setIsPassNavi", "isPassNavi", "setLineOptions", "current", "remain", "setMainRouteBubbleVisible", "visible", "setMultiSctxGroup", "multiSctxGroup", "setNavEndName", "navEndName", "setNaviCallback", "setOrderInfo", "info", "setOrderPoints", "setOrderPointsTimeStamp", "setOutSideRoute", "routeList", "etaMinutes", "edaMeters", "routeId", "driverLoc", "setRetryCount", "retryCount", "setRouteLineVisible", "setSearchOffRouteCallback", "Lcom/didi/map/sdk/sharetrack/callback/ISearchOffRouteCallback;", "setSearchRouteCallbck", "Lcom/didi/map/sdk/sharetrack/callback/ISearchRouteCallback;", "shouldUseRoundRoadStrategy", "start", "startNav", "stop", "zoomToLeftRoute", "var1", "Lcom/didi/common/map/internal/IMapElement;", "zoomToNav", "Companion", "CommonShareTrack_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: CommonNavigator.kt */
public final class CommonNavigator extends INavigator implements IRoundStatusChangeListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: s */
    private static final String f28654s = "CommonNavigator";

    /* renamed from: a */
    private Context f28655a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public INavDelegate f28656b;

    /* renamed from: c */
    private MapVendor f28657c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public INavigationCallback f28658d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public BaseRoundStrategy f28659e;

    /* renamed from: f */
    private OrderInfo f28660f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public DataFetcherManager f28661g;

    /* renamed from: h */
    private IBusinessEventCallback f28662h;

    /* renamed from: i */
    private int f28663i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public int f28664j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public boolean f28665k;

    /* renamed from: l */
    private LatLng f28666l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public String f28667m = "0";
    /* access modifiers changed from: private */

    /* renamed from: n */
    public int f28668n = -1;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public int f28669o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public int f28670p;

    /* renamed from: q */
    private INavigationInnerCallback f28671q = new CommonNavigator$mNavDelegateCallback$1(this);

    /* renamed from: r */
    private IOrderFeatureDataCallback f28672r = new CommonNavigator$mOrderFeatureDataCallback$1(this);

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/map/sdk/sharetrack/external/CommonNavigator$Companion;", "", "()V", "TAG", "", "CommonShareTrack_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: CommonNavigator.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* renamed from: a */
    private final void m20214a() {
        INavDelegate iNavDelegate;
        DLog.m20357d(BaseRoundStrategy.TAG, "!!!!! MOCK DATA !!!!!", new Object[0]);
        this.f28669o = 2;
        BaseRoundStrategy baseRoundStrategy = this.f28659e;
        if (baseRoundStrategy != null) {
            baseRoundStrategy.updateParkingStatus(2);
        }
        this.f28670p = 1;
        DLog.m20357d(BaseRoundStrategy.TAG, "fetch strategy success: " + this.f28670p, new Object[0]);
        if (!this.f28665k) {
            m20217b(this.f28670p);
            m20215a(this.f28670p);
            this.f28665k = true;
            if (this.f28670p != 2 && (iNavDelegate = this.f28656b) != null) {
                iNavDelegate.setRouteLineVisible(true);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m20216b() {
        DLog.m20357d(BaseRoundStrategy.TAG, "start fetch ora info", new Object[0]);
        DataFetcherManager dataFetcherManager = this.f28661g;
        if (dataFetcherManager != null) {
            dataFetcherManager.updateRouteId(this.f28667m);
        }
        DataFetcherManager dataFetcherManager2 = this.f28661g;
        if (dataFetcherManager2 != null) {
            dataFetcherManager2.fetchOrderFeatureDataWith(this.f28672r, true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m20215a(int i) {
        BaseRoundStrategy baseRoundStrategy;
        if (this.f28657c != MapVendor.GOOGLE) {
            DLog.m20357d(BaseRoundStrategy.TAG, "do nothing when didi", new Object[0]);
            return;
        }
        DLog.m20357d(f28654s, "init strategy with type: " + i, new Object[0]);
        if (i == 2) {
            if (ShareTrackUtils.INSTANCE.isNoRoadNet()) {
                ShareTrackUtils.INSTANCE.debugToast(this.f28655a, "兜圈近应答无路网播报");
                DLog.m20357d(BaseRoundStrategy.TAG, "play no road tts near round", new Object[0]);
                IBusinessEventCallback iBusinessEventCallback = this.f28662h;
                if (iBusinessEventCallback != null) {
                    iBusinessEventCallback.onRouteUnreachableTts(this.f28664j, this.f28663i);
                }
            }
            baseRoundStrategy = new NearRoundStrategy();
        } else if (i != 3) {
            baseRoundStrategy = new FarNoRoundStrategy();
        } else {
            if (ShareTrackUtils.INSTANCE.isNoRoadNet()) {
                ShareTrackUtils.INSTANCE.debugToast(this.f28655a, "非兜圈近应答无路网播报");
                DLog.m20357d(BaseRoundStrategy.TAG, "play no road tts near no round", new Object[0]);
                IBusinessEventCallback iBusinessEventCallback2 = this.f28662h;
                if (iBusinessEventCallback2 != null) {
                    iBusinessEventCallback2.onRouteUnreachableTts(this.f28664j, this.f28663i);
                }
            }
            baseRoundStrategy = new NearNoRoundStrategy();
        }
        this.f28659e = baseRoundStrategy;
        if (baseRoundStrategy != null) {
            baseRoundStrategy.updateETA(this.f28668n);
        }
        BaseRoundStrategy baseRoundStrategy2 = this.f28659e;
        if (baseRoundStrategy2 != null) {
            baseRoundStrategy2.updateRouteId(this.f28667m);
        }
        BaseRoundStrategy baseRoundStrategy3 = this.f28659e;
        if (baseRoundStrategy3 != null) {
            baseRoundStrategy3.updateParkingStatus(this.f28669o);
        }
        BaseRoundStrategy baseRoundStrategy4 = this.f28659e;
        if (baseRoundStrategy4 != null) {
            baseRoundStrategy4.setOrderInfo(this.f28660f);
        }
        BaseRoundStrategy baseRoundStrategy5 = this.f28659e;
        if (baseRoundStrategy5 != null) {
            baseRoundStrategy5.setStatusChangeListener(this);
        }
        BaseRoundStrategy baseRoundStrategy6 = this.f28659e;
        if (baseRoundStrategy6 != null) {
            baseRoundStrategy6.initComplete();
        }
    }

    public void initWithVendor(Context context, MapVendor mapVendor, boolean z) {
        this.f28655a = context;
        this.f28657c = mapVendor;
        this.f28656b = DiFactory.createNavigator(context, mapVendor, z);
        if (this.f28657c == MapVendor.GOOGLE) {
            INavDelegate iNavDelegate = this.f28656b;
            if (iNavDelegate != null) {
                iNavDelegate.setRouteLineVisible(false);
            }
            DataFetcherManager dataFetcherManager = new DataFetcherManager(context);
            this.f28661g = dataFetcherManager;
            if (dataFetcherManager != null) {
                dataFetcherManager.updateMapVendor(mapVendor);
            }
            m20215a(0);
        }
    }

    public List<OrderPoint> getPassPoints() {
        INavDelegate iNavDelegate = this.f28656b;
        if (iNavDelegate != null) {
            return iNavDelegate.getPassPoints();
        }
        return null;
    }

    public void pauseRequestOra() {
        INavDelegate iNavDelegate = this.f28656b;
        if (iNavDelegate != null) {
            iNavDelegate.pauseRequestOra();
        }
    }

    public void setNaviCallback(INavigationCallback iNavigationCallback) {
        this.f28658d = iNavigationCallback;
        INavDelegate iNavDelegate = this.f28656b;
        if (iNavDelegate != null) {
            iNavDelegate.setNavDelegateCallback(this.f28671q);
        }
    }

    public void onNewMargin(int i, int i2, int i3, int i4) {
        INavDelegate iNavDelegate = this.f28656b;
        if (iNavDelegate != null) {
            iNavDelegate.onNewMargin(i, i2, i3, i4);
        }
    }

    public void setSearchRouteCallbck(ISearchRouteCallback iSearchRouteCallback) {
        INavDelegate iNavDelegate = this.f28656b;
        if (iNavDelegate != null) {
            iNavDelegate.setSearchRouteCallbck(iSearchRouteCallback);
        }
    }

    public void setCarHeadMaxMapLevel(double d) {
        INavDelegate iNavDelegate = this.f28656b;
        if (iNavDelegate != null) {
            iNavDelegate.setCarHeadMaxMapLevel(d);
        }
    }

    public void setDestination(LatLng latLng) {
        this.f28666l = latLng;
        INavDelegate iNavDelegate = this.f28656b;
        if (iNavDelegate != null) {
            iNavDelegate.setDestination(latLng);
        }
    }

    public int getNearbyStatus() {
        return this.f28670p;
    }

    public void setRouteLineVisible(boolean z) {
        INavDelegate iNavDelegate = this.f28656b;
        if (iNavDelegate != null) {
            iNavDelegate.setRouteLineVisible(z);
        }
    }

    public boolean isLightNavSctxPaused() {
        INavDelegate iNavDelegate = this.f28656b;
        if (iNavDelegate == null) {
            return false;
        }
        if (iNavDelegate == null) {
            Intrinsics.throwNpe();
        }
        return iNavDelegate.isLightNavSctxPaused();
    }

    public Marker getCarMarker() {
        INavDelegate iNavDelegate = this.f28656b;
        if (iNavDelegate != null) {
            return iNavDelegate.getCarMarker();
        }
        return null;
    }

    public void start() {
        INavDelegate iNavDelegate = this.f28656b;
        if (iNavDelegate != null) {
            iNavDelegate.start();
        }
    }

    public void modifyRoutes(LatLng latLng, List<OrderPoint> list, long j) {
        DLog.m20357d(BaseRoundStrategy.TAG, "modified route", new Object[0]);
        this.f28666l = latLng;
        DataFetcherManager dataFetcherManager = this.f28661g;
        if (dataFetcherManager != null) {
            dataFetcherManager.updateRouteId("0");
        }
        m20220e();
        if (m20219d()) {
            m20215a(0);
        }
        INavDelegate iNavDelegate = this.f28656b;
        if (iNavDelegate != null) {
            iNavDelegate.setArriveStatus(0);
        }
        INavDelegate iNavDelegate2 = this.f28656b;
        if (iNavDelegate2 != null) {
            iNavDelegate2.modifyRoutes(latLng, list, j);
        }
    }

    public void setLineOptions(LineOptions lineOptions, LineOptions lineOptions2) {
        INavDelegate iNavDelegate = this.f28656b;
        if (iNavDelegate != null) {
            iNavDelegate.setLineOptions(lineOptions, lineOptions2);
        }
    }

    public MultiLine getLine() {
        INavDelegate iNavDelegate = this.f28656b;
        if (iNavDelegate != null) {
            return iNavDelegate.getLine();
        }
        return null;
    }

    public Map getDiDiMap() {
        INavDelegate iNavDelegate = this.f28656b;
        if (iNavDelegate != null) {
            return iNavDelegate.getDiDiMap();
        }
        return null;
    }

    public void setOrderPointsTimeStamp(long j) {
        INavDelegate iNavDelegate = this.f28656b;
        if (iNavDelegate != null) {
            iNavDelegate.setOrderPointsTimeStamp(j);
        }
    }

    public void setRetryCount(int i) {
        INavDelegate iNavDelegate = this.f28656b;
        if (iNavDelegate != null) {
            iNavDelegate.setRetryCount(i);
        }
    }

    public RouteGuidanceGPSPoint getMatchedPoint() {
        INavDelegate iNavDelegate = this.f28656b;
        if (iNavDelegate != null) {
            return iNavDelegate.getMatchedPoint();
        }
        return null;
    }

    public void setNavEndName(String str) {
        INavDelegate iNavDelegate = this.f28656b;
        if (iNavDelegate != null) {
            iNavDelegate.setNavEndName(str);
        }
    }

    public void setOrderInfo(OrderInfo orderInfo) {
        this.f28660f = orderInfo;
        BaseRoundStrategy baseRoundStrategy = this.f28659e;
        if (baseRoundStrategy != null) {
            baseRoundStrategy.setOrderInfo(orderInfo);
        }
        DataFetcherManager dataFetcherManager = this.f28661g;
        if (dataFetcherManager != null) {
            dataFetcherManager.updateOrderInfo(orderInfo);
        }
        if (orderInfo != null) {
            ShareTrackUtils shareTrackUtils = ShareTrackUtils.INSTANCE;
            String orderId = orderInfo.getOrderId();
            Intrinsics.checkExpressionValueIsNotNull(orderId, "it.orderId");
            shareTrackUtils.updateCurOrderId(orderId);
        }
        INavDelegate iNavDelegate = this.f28656b;
        if (iNavDelegate != null) {
            iNavDelegate.setOrderInfo(orderInfo);
        }
    }

    public void followMyLocation(boolean z) {
        INavDelegate iNavDelegate = this.f28656b;
        if (iNavDelegate != null) {
            iNavDelegate.followMyLocation(z);
        }
    }

    public void playOpenningVoice() {
        INavDelegate iNavDelegate = this.f28656b;
        if (iNavDelegate != null) {
            iNavDelegate.playOpenningVoice();
        }
    }

    public void setMainRouteBubbleVisible(boolean z) {
        INavDelegate iNavDelegate = this.f28656b;
        if (iNavDelegate != null) {
            iNavDelegate.setMainRouteBubbleVisible(z);
        }
    }

    public void zoomToLeftRoute(List<IMapElement> list, int i, int i2, int i3, int i4, int i5) {
        INavDelegate iNavDelegate = this.f28656b;
        if (iNavDelegate != null) {
            iNavDelegate.zoomToLeftRoute(list, i, i2, i3, i4, i5);
        }
    }

    public void startNav() {
        INavDelegate iNavDelegate = this.f28656b;
        if (iNavDelegate != null) {
            iNavDelegate.startNav();
        }
    }

    public StreetViewInfo getStreetViewInfo() {
        INavDelegate iNavDelegate = this.f28656b;
        if (iNavDelegate != null) {
            return iNavDelegate.getStreetViewInfo();
        }
        return null;
    }

    public void setCameraMode(CameraMode cameraMode) {
        INavDelegate iNavDelegate = this.f28656b;
        if (iNavDelegate != null) {
            iNavDelegate.setCameraMode(cameraMode);
        }
    }

    public int getRemainStraightDistance() {
        INavDelegate iNavDelegate = this.f28656b;
        if (iNavDelegate == null) {
            return 0;
        }
        if (iNavDelegate == null) {
            Intrinsics.throwNpe();
        }
        return iNavDelegate.getRemainStraightDistance();
    }

    public void stop() {
        INavDelegate iNavDelegate = this.f28656b;
        if (iNavDelegate != null) {
            iNavDelegate.stop();
        }
    }

    public void setOrderPoints(List<OrderPoint> list) {
        INavDelegate iNavDelegate = this.f28656b;
        if (iNavDelegate != null) {
            iNavDelegate.setOrderPoints(list);
        }
    }

    public void resumeAfterNavigation() {
        INavDelegate iNavDelegate = this.f28656b;
        if (iNavDelegate != null) {
            iNavDelegate.resumeAfterNavigation();
        }
    }

    public void onLocationChanged(GpsLocation gpsLocation, List<GpsLocation> list) {
        INavDelegate iNavDelegate = this.f28656b;
        if (iNavDelegate != null) {
            iNavDelegate.onLocationChanged(gpsLocation, list);
        }
    }

    public INavSkin getNavSkin() {
        INavDelegate iNavDelegate = this.f28656b;
        if (iNavDelegate != null) {
            return iNavDelegate.getNavSkin();
        }
        return null;
    }

    public void setAudioGuidanceEnabled(boolean z) {
        INavDelegate iNavDelegate = this.f28656b;
        if (iNavDelegate != null) {
            iNavDelegate.setAudioGuidanceEnabled(z);
        }
    }

    public int getParkingStatus() {
        return this.f28669o;
    }

    public boolean isSctxStarted() {
        INavDelegate iNavDelegate = this.f28656b;
        if (iNavDelegate == null) {
            return false;
        }
        if (iNavDelegate == null) {
            Intrinsics.throwNpe();
        }
        iNavDelegate.isSctxStarted();
        return false;
    }

    public void setBusinessEventCallback(IBusinessEventCallback iBusinessEventCallback) {
        this.f28662h = iBusinessEventCallback;
        INavDelegate iNavDelegate = this.f28656b;
        if (iNavDelegate != null) {
            iNavDelegate.setBusinessEventCallback(iBusinessEventCallback);
        }
    }

    public void resumeRequestOra() {
        INavDelegate iNavDelegate = this.f28656b;
        if (iNavDelegate != null) {
            iNavDelegate.resumeRequestOra();
        }
    }

    public void setCarMarkerEnabled(boolean z) {
        INavDelegate iNavDelegate = this.f28656b;
        if (iNavDelegate != null) {
            iNavDelegate.setCarMarkerEnabled(z);
        }
    }

    public void changeNightMode(boolean z) {
        INavDelegate iNavDelegate = this.f28656b;
        if (iNavDelegate != null) {
            iNavDelegate.changeNightMode(z);
        }
    }

    public void setCarMarkerZindex(float f) {
        INavDelegate iNavDelegate = this.f28656b;
        if (iNavDelegate != null) {
            iNavDelegate.setCarMarkerZindex(f);
        }
    }

    public void setDiDiMap(Map map) {
        INavDelegate iNavDelegate = this.f28656b;
        if (iNavDelegate != null) {
            iNavDelegate.setDiDiMap(map);
        }
    }

    public void setMultiSctxGroup(String str) {
        INavDelegate iNavDelegate = this.f28656b;
        if (iNavDelegate != null) {
            iNavDelegate.setMultiSctxGroup(str);
        }
    }

    public void setIsPassNavi(boolean z) {
        INavDelegate iNavDelegate = this.f28656b;
        if (iNavDelegate != null) {
            iNavDelegate.setIsPassNavi(z);
        }
    }

    public void pause4Navigation() {
        INavDelegate iNavDelegate = this.f28656b;
        if (iNavDelegate != null) {
            iNavDelegate.pause4Navigation();
        }
    }

    public void destroy() {
        m20220e();
        INavDelegate iNavDelegate = this.f28656b;
        if (iNavDelegate != null) {
            iNavDelegate.destroy();
        }
    }

    public void zoomToNav() {
        INavDelegate iNavDelegate = this.f28656b;
        if (iNavDelegate != null) {
            iNavDelegate.zoomToNav();
        }
    }

    public int getRemainMinutes(int i) {
        INavDelegate iNavDelegate = this.f28656b;
        if (iNavDelegate == null) {
            return 0;
        }
        if (iNavDelegate == null) {
            Intrinsics.throwNpe();
        }
        return iNavDelegate.getRemainMinutes(i);
    }

    public void setSearchOffRouteCallback(ISearchOffRouteCallback iSearchOffRouteCallback) {
        INavDelegate iNavDelegate = this.f28656b;
        if (iNavDelegate != null) {
            iNavDelegate.setSearchOffRouteCallback(iSearchOffRouteCallback);
        }
    }

    public void setCarMarkerBitmap(BitmapDescriptor bitmapDescriptor) {
        INavDelegate iNavDelegate = this.f28656b;
        if (iNavDelegate != null) {
            iNavDelegate.setCarMarkerBitmap(bitmapDescriptor);
        }
    }

    public boolean isArriveDest() {
        INavDelegate iNavDelegate = this.f28656b;
        if (iNavDelegate == null) {
            return false;
        }
        if (iNavDelegate == null) {
            Intrinsics.throwNpe();
        }
        return iNavDelegate.isArriveDest();
    }

    public RouteGuidanceGPSPoint getOriginMatchPoint() {
        INavDelegate iNavDelegate = this.f28656b;
        if (iNavDelegate != null) {
            return iNavDelegate.getOriginMatchPoint();
        }
        return null;
    }

    public void setGuideRouteLineOpt(LineOptions lineOptions) {
        Intrinsics.checkParameterIsNotNull(lineOptions, "opt");
        INavDelegate iNavDelegate = this.f28656b;
        if (iNavDelegate != null) {
            iNavDelegate.setGuideRouteLineOpt(lineOptions);
        }
    }

    public int getRemainMeters(int i) {
        INavDelegate iNavDelegate = this.f28656b;
        if (iNavDelegate == null) {
            return 0;
        }
        if (iNavDelegate == null) {
            Intrinsics.throwNpe();
        }
        return iNavDelegate.getRemainMeters(i);
    }

    public void setOutSideRoute(List<LatLng> list, int i, int i2, long j, GpsLocation gpsLocation) {
        INavDelegate iNavDelegate = this.f28656b;
        if (iNavDelegate != null) {
            iNavDelegate.setOutSideRoute(list, i, i2, j, gpsLocation);
        }
    }

    public void setActivity(Activity activity) {
        INavDelegate iNavDelegate = this.f28656b;
        if (iNavDelegate != null) {
            iNavDelegate.setActivity(activity);
        }
    }

    public int getCurrentNaviStatus() {
        INavDelegate iNavDelegate = this.f28656b;
        if (iNavDelegate == null) {
            return 0;
        }
        if (iNavDelegate == null) {
            Intrinsics.throwNpe();
        }
        iNavDelegate.getCurrentNaviStatus();
        return 0;
    }

    public void setCaller(CallFrom callFrom) {
        INavDelegate iNavDelegate = this.f28656b;
        if (iNavDelegate != null) {
            iNavDelegate.setCaller(callFrom);
        }
    }

    public void onArrived(boolean z) {
        StreetViewInfo streetViewInfo;
        ShareTrackUtils.INSTANCE.debugToast(this.f28655a, "DEBUG: 到达");
        if (z) {
            INavDelegate iNavDelegate = this.f28656b;
            if (iNavDelegate != null) {
                iNavDelegate.setArriveStatus(1);
            }
        } else {
            onPassPointYaw();
        }
        INavDelegate iNavDelegate2 = this.f28656b;
        if (!(iNavDelegate2 == null || (streetViewInfo = iNavDelegate2.getStreetViewInfo()) == null)) {
            streetViewInfo.isArrived = true;
        }
        INavigationCallback iNavigationCallback = this.f28658d;
        if (iNavigationCallback != null) {
            iNavigationCallback.onArriveDestination();
        }
    }

    public void onPassPointYaw() {
        INavDelegate iNavDelegate = this.f28656b;
        if (iNavDelegate != null) {
            iNavDelegate.setArriveStatus(2);
        }
    }

    public void onDriveAway() {
        StreetViewInfo streetViewInfo;
        ShareTrackUtils.INSTANCE.debugToast(this.f28655a, "DEBUG: 驶离");
        INavDelegate iNavDelegate = this.f28656b;
        if (iNavDelegate != null) {
            iNavDelegate.setArriveStatus(3);
        }
        INavDelegate iNavDelegate2 = this.f28656b;
        if (!(iNavDelegate2 == null || (streetViewInfo = iNavDelegate2.getStreetViewInfo()) == null)) {
            streetViewInfo.isArrived = false;
        }
        INavigationCallback iNavigationCallback = this.f28658d;
        if (iNavigationCallback != null) {
            iNavigationCallback.onDriveAway();
        }
    }

    public void onApproaching(int i) {
        INavigationCallback iNavigationCallback = this.f28658d;
        if (iNavigationCallback != null) {
            iNavigationCallback.onApproaching(i);
        }
    }

    public void onLineVisibleChange(boolean z) {
        INavDelegate iNavDelegate = this.f28656b;
        if (iNavDelegate != null) {
            iNavDelegate.setRouteLineVisible(z);
        }
        DataFetcherManager dataFetcherManager = this.f28661g;
        if (dataFetcherManager != null) {
            dataFetcherManager.updateLineVisibility(z);
        }
        DataFetcherManager dataFetcherManager2 = this.f28661g;
        if (dataFetcherManager2 != null) {
            dataFetcherManager2.fetchOrderFeatureDataWith((IOrderFeatureDataCallback) null, false);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public final void m20218c() {
        LatLng routeEndPoint;
        LatLng latLng;
        INavDelegate iNavDelegate = this.f28656b;
        if (iNavDelegate != null && (routeEndPoint = iNavDelegate.getRouteEndPoint()) != null && (latLng = this.f28666l) != null) {
            int computeDistanceBetween = (int) DDSphericalUtil.computeDistanceBetween(routeEndPoint, latLng);
            this.f28663i = computeDistanceBetween;
            boolean z = computeDistanceBetween > ShareTrackApolloHelper.INSTANCE.getNoRoadThreshold();
            DLog.m20357d(BaseRoundStrategy.TAG, "distance of unmatched end and route end: " + this.f28663i + ", no road? " + z, new Object[0]);
            ShareTrackUtils.INSTANCE.updateRoadNetStatus(z);
            if (z) {
                ShareTrackUtils.INSTANCE.debugToast(this.f28655a, "DEBUG: 无路网");
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public final boolean m20219d() {
        OrderInfo orderInfo = this.f28660f;
        if (orderInfo == null) {
            return false;
        }
        if ((orderInfo.getOrderStage() == 1 || orderInfo.getOrderStage() == 2) && this.f28657c == MapVendor.GOOGLE) {
            return true;
        }
        return false;
    }

    /* renamed from: e */
    private final void m20220e() {
        ShareTrackUtils.INSTANCE.updateRoadNetStatus(false);
        this.f28665k = false;
        DataFetcherManager dataFetcherManager = this.f28661g;
        if (dataFetcherManager != null) {
            dataFetcherManager.destroy();
        }
        BaseRoundStrategy baseRoundStrategy = this.f28659e;
        if (baseRoundStrategy != null) {
            baseRoundStrategy.setStatusChangeListener((IRoundStatusChangeListener) null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m20217b(int i) {
        ShareTrackUtils.INSTANCE.debugToast(this.f28655a, i != 2 ? i != 3 ? "远应答" : "非兜圈近应答" : "兜圈近应答");
    }
}
