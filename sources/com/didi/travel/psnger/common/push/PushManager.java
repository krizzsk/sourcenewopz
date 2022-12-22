package com.didi.travel.psnger.common.push;

import android.content.Context;
import android.text.TextUtils;
import com.didi.common.map.model.LatLng;
import com.didi.sdk.messagecenter.C12462M;
import com.didi.sdk.messagecenter.interfaces.IHandler;
import com.didi.sdk.messagecenter.p152pb.CollectSvrCoordinateReq;
import com.didi.sdk.messagecenter.p152pb.CollectSvrMessageType;
import com.didi.sdk.messagecenter.p152pb.CoordinateType;
import com.didi.sdk.messagecenter.p152pb.DispatchMessageType;
import com.didi.sdk.messagecenter.p152pb.DoublePoint;
import com.didi.sdk.messagecenter.p152pb.LocPoint;
import com.didi.sdk.messagecenter.p152pb.MsgType;
import com.didi.sdk.messagecenter.p152pb.OrderStat;
import com.didi.sdk.messagecenter.p152pb.POPEActionReq;
import com.didi.sdk.messagecenter.p152pb.PassengerDiverLocGetByIdReq;
import com.didi.sdk.messagecenter.p152pb.PassengerDiverLocGetReq;
import com.didi.sdk.messagecenter.p152pb.PassengerOrderRouteReq;
import com.didi.sdk.messagecenter.p152pb.PassengerPayStatusReq;
import com.didi.sdk.messagecenter.p152pb.PassengerState;
import com.didi.sdk.messagecenter.p152pb.PreAuthResultReq;
import com.didi.sdk.messagecenter.p152pb.Role;
import com.didi.sdk.messagecenter.util.MLog;
import com.didi.sdk.security.SecurityUtil;
import com.didi.sdk.util.SystemUtil;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.travel.psnger.TEBridge;
import com.didi.travel.psnger.TravelSDK;
import com.didi.travel.psnger.common.push.PushCenter;
import com.didi.travel.psnger.model.response.CarMoveBean;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didi.travel.psnger.model.response.CarPopeAction;
import com.didi.travel.psnger.model.response.DriverPosition;
import com.didi.travel.psnger.model.response.NearDrivers;
import com.didi.travel.psnger.model.response.NextPayResult;
import com.didi.travel.psnger.model.response.NextTotalFeeDetail;
import com.didi.travel.psnger.model.response.OrderRealtimePriceCount;
import com.didi.travel.psnger.model.response.PreAuthModel;
import com.didi.travel.psnger.store.DDTravelOrderStore;
import com.didi.travel.psnger.utils.LogUtil;
import com.didi.travel.psnger.utils.NumberUtil;
import com.didi.travel.psnger.utils.TimeUtil;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationManager;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;

public class PushManager {

    /* renamed from: a */
    private static final int f44068a = 0;

    /* renamed from: b */
    private static final int f44069b = 1;

    public interface CommonMessageListener {
        void onMessageReceived(int i, String str);
    }

    public interface DriversLocationGetListenerNew {
        void onDriversLocationReceivedNew(byte[] bArr);
    }

    public interface DriversMigrationRoutesListener {
        void onDriversMigrationRoutesMessageReceived(byte[] bArr);
    }

    public interface MultiRouteListener {
        void onMultiRouteRecieved(byte[] bArr);
    }

    public interface PopeActionListener {
        void onPopeActionReceived(CarPopeAction carPopeAction);
    }

    public interface PreAuthListener {
        void onPreAuthReceived(PreAuthModel preAuthModel);
    }

    public static void registerCommonMessageListener(final CommonMessageListener commonMessageListener) {
        PushCenter.registerCommonMessageListener(new PushCenter.CommonMessageListener() {
            public void onMessageReceived(int i, String str) {
                CommonMessageListener commonMessageListener = CommonMessageListener.this;
                if (commonMessageListener != null) {
                    commonMessageListener.onMessageReceived(i, str);
                }
            }
        });
    }

    public static void unregisterCommonMessageListener() {
        PushCenter.unregisterCommonMessageListener();
    }

    public static void sendPushMessage(MsgType msgType, int i, byte[] bArr) {
        PushCenter.sendPushRequest(msgType, i, bArr);
    }

    public static void registerLocationCallNearDrivers(PushCallBackListener<NearDrivers> pushCallBackListener) {
        PushCenter.subscribe(C12462M.DriverLocMsg.class, pushCallBackListener, NearDrivers.class);
    }

    public static void unregisteLocationCallNearDrivers() {
        PushCenter.unsubscribe(C12462M.DriverLocMsg.class);
    }

    public static void sendLocationCallNearDrivers(Context context, int i, int i2, double d, double d2, String str, int i3, String str2, OrderStat orderStat, int i4, int i5, String str3) {
        LogUtil.m31426d("sendLocationCallNearDrivers DepartureHelper.isUseDepart():  lat:" + d + " lng: " + d2 + " map's zoom: ");
        String phone = TEBridge.clientConfig().phone();
        if (!TextUtils.isEmpty(phone)) {
            PassengerDiverLocGetReq.Builder builder = new PassengerDiverLocGetReq.Builder();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(phone);
            stringBuffer.append("_");
            stringBuffer.append(TEBridge.clientConfig().originId());
            builder.phone_num(stringBuffer.toString());
            builder.role(Integer.valueOf(Role.Passenger.getValue()));
            builder.lat(Double.valueOf(d));
            builder.lng(Double.valueOf(d2));
            builder.radius(Double.valueOf(5000.0d));
            builder.channel(Integer.valueOf(i2));
            builder.type(Integer.valueOf(i3));
            builder.order_stat(orderStat);
            builder.car_level(Integer.valueOf(i4));
            builder.is_carpool(Integer.valueOf(i5));
            builder.timestamp(Integer.valueOf((int) System.currentTimeMillis()));
            builder.sdkmaptype(str);
            builder.data_type("android");
            builder.device_id(SecurityUtil.getDeviceId());
            builder.app_version(SystemUtil.getVersionName(context));
            builder.coord_type(Integer.valueOf(TEBridge.clientConfig().mapTypeInt()));
            CarOrder carOrder = (CarOrder) DDTravelOrderStore.getOrder();
            if (carOrder != null && carOrder.status == 7 && !TextUtils.isEmpty(carOrder.xActivityId)) {
                builder.xtags(carOrder.xActivityId);
            }
            if (!TextUtil.isEmpty(str2)) {
                builder.extra(str2);
            }
            builder.location_country(TEBridge.clientConfig().locationCountry());
            builder.trip_country(str3);
            builder.lang(TEBridge.clientConfig().locale());
            LogUtil.m31426d("sendLocationCallNearDrivers phoneNum " + builder.phone_num + "  -----  type: " + i3 + builder.toString());
            PushCenter.sendPushRequest(DispatchMessageType.kDispatchMessageTypePassengerDiverLocGetByLocReq.getValue(), builder.build().toByteArray());
        }
    }

    public static void registerDriversLocationMessageListener(PushCallBackListener<NearDrivers> pushCallBackListener) {
        PushCenter.subscribe(C12462M.DriverLocByIdMsg.class, pushCallBackListener, NearDrivers.class);
    }

    public static void unregisterDriversLocationMessageListener() {
        PushCenter.unsubscribe(C12462M.DriverLocByIdMsg.class);
    }

    public static void sendMsgCallDriverLocation(int i, double d, double d2, OrderStat orderStat, String str, List<Long> list, List<LatLng> list2, boolean z) {
        String phone = TEBridge.clientConfig().phone();
        if (!TextUtil.isEmpty(phone)) {
            PassengerDiverLocGetByIdReq.Builder builder = new PassengerDiverLocGetByIdReq.Builder();
            builder.phone_num(phone + "_" + TEBridge.clientConfig().originId());
            builder.role(Integer.valueOf(Role.Passenger.getValue()));
            builder.lat(Double.valueOf(d));
            builder.lng(Double.valueOf(d2));
            builder.channel(Integer.valueOf(i));
            builder.diverIds(list);
            builder.order_stat(orderStat);
            builder.timestamp(Integer.valueOf((int) System.currentTimeMillis()));
            builder.sdkmaptype(str);
            builder.coord_type(Integer.valueOf(TEBridge.clientConfig().mapTypeInt()));
            if (z) {
                builder.is_eta = 0;
            } else {
                builder.is_eta = 1;
            }
            ArrayList arrayList = null;
            if (list2 != null) {
                int size = list2.size();
                if (size > 0) {
                    arrayList = new ArrayList();
                }
                for (int i2 = 0; i2 < size; i2++) {
                    LatLng latLng = list2.get(i2);
                    LocPoint.Builder builder2 = new LocPoint.Builder();
                    builder2.lat(Double.valueOf(latLng.latitude));
                    builder2.lng(Double.valueOf(latLng.longitude));
                    arrayList.add(builder2.build());
                }
            }
            if (arrayList != null) {
                builder.passLocPoints(arrayList);
            }
            builder.lang(TEBridge.clientConfig().locale());
            builder.trip_country(TEBridge.clientConfig().tripCountry());
            LogUtil.m31426d("sendMsgCallDriverLocation----- " + builder.toString());
            PushCenter.sendPushRequest(DispatchMessageType.kDispatchMessageTypePassengerDiverLocGetByIdReq.getValue(), builder.build().toByteArray());
        }
    }

    public static void sendMsgCallDriverLocation(int i, int i2, double d, double d2, OrderStat orderStat, String str, List<Long> list, List<LatLng> list2, boolean z, String str2) {
        String phone = TEBridge.clientConfig().phone();
        if (!TextUtil.isEmpty(phone)) {
            PassengerDiverLocGetByIdReq.Builder builder = new PassengerDiverLocGetByIdReq.Builder();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(phone);
            stringBuffer.append("_");
            stringBuffer.append(TEBridge.clientConfig().originId());
            builder.phone_num(stringBuffer.toString());
            builder.role(Integer.valueOf(Role.Passenger.getValue()));
            builder.lat(Double.valueOf(d));
            builder.lng(Double.valueOf(d2));
            builder.channel(Integer.valueOf(i2));
            builder.diverIds(list);
            builder.order_stat(orderStat);
            builder.timestamp(Integer.valueOf((int) System.currentTimeMillis()));
            builder.sdkmaptype(str);
            builder.coord_type(Integer.valueOf(TEBridge.clientConfig().mapTypeInt()));
            if (z) {
                builder.is_eta = 0;
            } else {
                builder.is_eta = 1;
            }
            ArrayList arrayList = null;
            if (list2 != null) {
                int size = list2.size();
                if (size > 0) {
                    arrayList = new ArrayList();
                }
                for (int i3 = 0; i3 < size; i3++) {
                    LatLng latLng = list2.get(i3);
                    LocPoint.Builder builder2 = new LocPoint.Builder();
                    builder2.lat(Double.valueOf(latLng.latitude));
                    builder2.lng(Double.valueOf(latLng.longitude));
                    arrayList.add(builder2.build());
                }
            }
            if (arrayList != null) {
                builder.passLocPoints(arrayList);
            }
            builder.location_country(TEBridge.clientConfig().locationCountry());
            builder.trip_country(str2);
            builder.lang(TEBridge.clientConfig().locale());
            LogUtil.m31426d("sendMsgCallDriverLocation----- " + builder.toString());
            PushCenter.sendPushRequest(DispatchMessageType.kDispatchMessageTypePassengerDiverLocGetByIdReq.getValue(), builder.build().toByteArray());
        }
    }

    public static CollectSvrCoordinateReq sendPassengerPositionMessage(int i, CarOrder carOrder) {
        return sendLocation(carOrder, true, PassengerState.PassengerStateNormal.getValue());
    }

    public static CollectSvrCoordinateReq sendLocation(CarOrder carOrder, boolean z, int i) {
        double d;
        CoordinateType coordinateType = CoordinateType.GCJ_02;
        try {
            DIDILocation lastKnownLocation = TravelSDK.appContext() != null ? DIDILocationManager.getInstance(TravelSDK.appContext()).getLastKnownLocation() : null;
            double d2 = 0.0d;
            if (lastKnownLocation != null) {
                d2 = lastKnownLocation.getLatitude();
                d = lastKnownLocation.getLongitude();
                coordinateType = lastKnownLocation.getCoordinateType() == 0 ? CoordinateType.WGS_84 : CoordinateType.GCJ_02;
            } else {
                d = 0.0d;
            }
            LogUtil.m31434i("sendLocation lat:" + d2 + " | lng:" + d);
            int value = CollectSvrMessageType.kCollectSvrMessageTypeCollectSvrCoordinateReq.getValue();
            CollectSvrCoordinateReq.Builder builder = new CollectSvrCoordinateReq.Builder();
            builder.phone(TEBridge.clientConfig().phone());
            builder.lat(Double.valueOf(d2));
            builder.lng(Double.valueOf(d));
            builder.type(coordinateType);
            builder.pull_peer(Boolean.valueOf(z));
            builder.state(Integer.valueOf(i));
            if (lastKnownLocation != null) {
                builder.accuracy(Double.valueOf((double) lastKnownLocation.getAccuracy()));
            }
            builder.utc_offset(Integer.valueOf(NumberUtil.parseInt(TimeUtil.getTimeZonID())));
            if (!(carOrder == null || carOrder.startAddress == null)) {
                builder.pre_lng(Double.valueOf(carOrder.startAddress.getLongitude()));
                builder.pre_lat(Double.valueOf(carOrder.startAddress.getLatitude()));
            }
            CollectSvrCoordinateReq build = builder.build();
            LogUtil.m31426d("sending----- " + build);
            PushCenter.sendPushRequest(MsgType.kMsgTypeCollectSvrNoRspReq, value, build.toByteArray());
            return build;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void registerDriversLocationMessageListenerNew(final DriversLocationGetListenerNew driversLocationGetListenerNew) {
        PushCenter.subscribe(C12462M.OrderRouteResMsg.class, new IHandler<C12462M.OrderRouteResMsg>() {
            public void handle(C12462M.OrderRouteResMsg orderRouteResMsg) {
                MLog.m26058d("handle M.OrderRouteResMsg");
                DriversLocationGetListenerNew.this.onDriversLocationReceivedNew(orderRouteResMsg.raw);
            }
        });
    }

    public static void unDriversLocationMessageListenerNew() {
        PushCenter.unsubscribe(C12462M.OrderRouteResMsg.class);
    }

    public static void sendMsgCallDriverLocationNew(Context context, CarMoveBean carMoveBean) {
        if (!TextUtil.isEmpty(TEBridge.clientConfig().phone()) && !TextUtil.isEmpty(TEBridge.clientConfig().token())) {
            try {
                PassengerOrderRouteReq.Builder builder = new PassengerOrderRouteReq.Builder();
                builder.phoneNum(carMoveBean.passengerPhone);
                builder.bizType(Integer.valueOf(carMoveBean.bizType));
                builder.driverId(Long.valueOf(carMoveBean.driverId));
                builder.imei(carMoveBean.imei);
                builder.orderId(carMoveBean.orderId);
                builder.orderStage(Integer.valueOf(carMoveBean.orderStage.getValue()));
                builder.token(TEBridge.clientConfig().token());
                builder.timestamp(Long.valueOf(System.currentTimeMillis()));
                builder.version(carMoveBean.version);
                builder.curRouteId(Long.valueOf(carMoveBean.curRouteId));
                builder.isNeedTraj(Boolean.valueOf(carMoveBean.isNeedTraj));
                builder.sdkmaptype(carMoveBean.sdkmaptype);
                DoublePoint.Builder builder2 = new DoublePoint.Builder();
                builder2.lat(Float.valueOf((float) carMoveBean.startLatLng.latitude));
                builder2.lng(Float.valueOf((float) carMoveBean.startLatLng.longitude));
                builder.pickupEndPoint(builder2.build());
                DoublePoint.Builder builder3 = new DoublePoint.Builder();
                builder3.lat(Float.valueOf((float) carMoveBean.endLatLng.latitude));
                builder3.lng(Float.valueOf((float) carMoveBean.endLatLng.longitude));
                builder.orderEndPoint(builder3.build());
                LogUtil.m31432fi(String.format("sctx push: phone:%s  orderId:%s startLatLng(lat: %s, lng:%s)  endLatLng(lat: %s, lng:%s)", new Object[]{carMoveBean.passengerPhone, carMoveBean.orderId, Double.valueOf(carMoveBean.startLatLng.latitude), Double.valueOf(carMoveBean.startLatLng.longitude), Double.valueOf(carMoveBean.endLatLng.latitude), Double.valueOf(carMoveBean.endLatLng.longitude)}));
                LogUtil.m31426d("CarPushHelper passenger sendMsgCallDriverLocation-----");
                PushCenter.sendPushRequest(DispatchMessageType.kDispatchMessageTypeMapPassengerOrderRouteReq.getValue(), builder.build().toByteArray());
            } catch (Exception unused) {
            }
        }
    }

    public static void sendDriverLocationPayload(Context context, byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            try {
                PushCenter.sendPushRequest(DispatchMessageType.kDispatchMessageTypeMapPassengerOrderRouteReq.getValue(), bArr);
            } catch (Exception unused) {
            }
        }
    }

    public static void registerMultiRouteListener(final MultiRouteListener multiRouteListener) {
        PushCenter.subscribe(C12462M.MultiRouteMsg.class, new IHandler<C12462M.MultiRouteMsg>() {
            public void handle(C12462M.MultiRouteMsg multiRouteMsg) {
                MLog.m26058d("handle M.MultiRouteMsg");
                MultiRouteListener.this.onMultiRouteRecieved(multiRouteMsg.raw);
            }
        });
    }

    public static void unRegisterMultiRouteListener() {
        PushCenter.unsubscribe(C12462M.MultiRouteMsg.class);
    }

    public static void sendMultiRoutePayload(Context context, byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            try {
                PushCenter.sendPushRequest(DispatchMessageType.KDispatchMessageTypeMapPassengerMultiRouteListReq.getValue(), bArr);
            } catch (Exception unused) {
            }
        }
    }

    public static void registerDriverMigrationRoutesMessageListener(final DriversMigrationRoutesListener driversMigrationRoutesListener) {
        PushCenter.subscribe(C12462M.OrderRouteNotifyReqMsg.class, new IHandler<C12462M.OrderRouteNotifyReqMsg>() {
            public void handle(C12462M.OrderRouteNotifyReqMsg orderRouteNotifyReqMsg) {
                MLog.m26058d("handle M.OrderRouteNotifyReqMsg");
                DriversMigrationRoutesListener.this.onDriversMigrationRoutesMessageReceived(orderRouteNotifyReqMsg.raw);
            }
        });
    }

    public static void unregisterDriverMigrationRoutesMessageListener() {
        PushCenter.unsubscribe(C12462M.OrderRouteNotifyReqMsg.class);
    }

    public static void registerDriverPositionListener(PushCallBackListener<DriverPosition> pushCallBackListener) {
        PushCenter.subscribe(C12462M.CdntSvrDownMsg.class, pushCallBackListener, DriverPosition.class);
    }

    public static void unregisterDriverPositionListener() {
        PushCenter.unsubscribe(C12462M.CdntSvrDownMsg.class);
    }

    public static void registerOrderRealtimePriceCountListener(PushCallBackListener<OrderRealtimePriceCount> pushCallBackListener) {
        PushCenter.subscribe(C12462M.OrderRealtimeFeeMsg.class, pushCallBackListener, OrderRealtimePriceCount.class);
    }

    public static void unregisterOrderRealtimePriceCountListener() {
        PushCenter.unsubscribe(C12462M.OrderRealtimeFeeMsg.class);
    }

    public static void registerOrderTotalFeeDetailListener(PushCallBackListener<NextTotalFeeDetail> pushCallBackListener) {
        PushCenter.subscribe(C12462M.OrderTotalFeeMsg.class, pushCallBackListener, NextTotalFeeDetail.class);
    }

    public static void unregisterOrderTotalFeeDetailListener() {
        PushCenter.unsubscribe(C12462M.OrderTotalFeeMsg.class);
    }

    public static void registerPayResultMessageListener(PushCallBackListener<NextPayResult> pushCallBackListener) {
        PushCenter.subscribe(C12462M.OrderPaySucMsg.class, pushCallBackListener, NextPayResult.class);
    }

    public static void unregisterPayResultMessageListener() {
        PushCenter.unsubscribe(C12462M.OrderPaySucMsg.class);
    }

    public static void sendGetPayResultMessage(Context context, String str, int i, Object obj) {
        String str2 = TEBridge.clientConfig().token();
        if (!TextUtil.isEmpty(str2)) {
            PassengerPayStatusReq.Builder builder = new PassengerPayStatusReq.Builder();
            builder.oid(str);
            builder.trade_status(Integer.valueOf(i));
            builder.token(str2);
            PushCenter.sendPushRequest(DispatchMessageType.kDispatchMessageTypePassengerPayStatusReq.getValue(), builder.build().toByteArray());
        }
    }

    public static void registerPopeActionListener(final PopeActionListener popeActionListener) {
        PushCenter.subscribe(C12462M.PopeActionMsg.class, new IHandler<C12462M.PopeActionMsg>() {
            public void handle(C12462M.PopeActionMsg popeActionMsg) {
                if (popeActionMsg != null && popeActionMsg.msg != null) {
                    PushManager.m31359b(PopeActionListener.this, (POPEActionReq) popeActionMsg.msg);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m31359b(final PopeActionListener popeActionListener, POPEActionReq pOPEActionReq) {
        final int intValue = ((Integer) Wire.get(pOPEActionReq.product_id, POPEActionReq.DEFAULT_PRODUCT_ID)).intValue();
        final String str = (String) Wire.get(pOPEActionReq.type, "");
        final String str2 = (String) Wire.get(pOPEActionReq.data, "");
        UiThreadHandler.post(new Runnable() {
            public void run() {
                LogUtil.m31426d("onPopeActionReceived productId = " + intValue + ", actionType = " + str + ", actionData = " + str2);
                popeActionListener.onPopeActionReceived(new CarPopeAction(intValue, str, str2));
            }
        });
    }

    public static void unregisterPopeActionListener() {
        PushCenter.unsubscribe(C12462M.PopeActionMsg.class);
    }

    public static void registerPreAuthListener(final PreAuthListener preAuthListener) {
        PushCenter.subscribe(C12462M.PreAuthResultMsg.class, new IHandler<C12462M.PreAuthResultMsg>() {
            public void handle(C12462M.PreAuthResultMsg preAuthResultMsg) {
                if (preAuthResultMsg != null && preAuthResultMsg.msg != null) {
                    PushManager.m31360b(PreAuthListener.this, (PreAuthResultReq) preAuthResultMsg.msg);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m31360b(final PreAuthListener preAuthListener, PreAuthResultReq preAuthResultReq) {
        final String str = (String) Wire.get(preAuthResultReq.oid, "");
        final int intValue = ((Integer) Wire.get(preAuthResultReq.error_type, PreAuthResultReq.DEFAULT_ERROR_TYPE)).intValue();
        final String str2 = (String) Wire.get(preAuthResultReq.error_msg, "");
        UiThreadHandler.post(new Runnable() {
            public void run() {
                LogUtil.m31426d("onPreAuthReceived oid = " + str + ", errorType = " + intValue + ", errorMsg = " + str2);
                preAuthListener.onPreAuthReceived(new PreAuthModel(str, intValue, str2));
            }
        });
    }

    public static void unregisterPreAuthListener() {
        PushCenter.unsubscribe(C12462M.PreAuthResultMsg.class);
    }
}
