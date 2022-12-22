package com.didi.travel.psnger.core.service;

import android.content.Context;
import android.text.TextUtils;
import com.android.didi.bfflib.Bff;
import com.android.didi.bfflib.IBffProxy;
import com.didi.address.util.SugWayPointsUtils;
import com.didi.travel.p171v2.store.Store;
import com.didi.travel.p171v2.util.LogUtils;
import com.didi.travel.psnger.bff.BffConstants;
import com.didi.travel.psnger.bff.BffUtils;
import com.didi.travel.psnger.common.net.DTSDKRequest;
import com.didi.travel.psnger.common.net.base.ITravelOrderListener;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didi.travel.psnger.common.net.base.ResponseListener;
import com.didi.travel.psnger.core.model.request.BaseOrderDetailParams;
import com.didi.travel.psnger.core.model.request.OrderStatusParams;
import com.didi.travel.psnger.core.model.response.DTSDKOrderDetail;
import com.didi.travel.psnger.core.model.response.DTSDKOrderStatus;
import com.didi.travel.psnger.core.model.response.ICancelOrder;
import com.didi.travel.psnger.core.model.response.ICarCancelTrip;
import com.didi.travel.psnger.core.model.response.ICarOrder;
import com.didi.travel.psnger.core.model.response.IOrderStatus;
import com.didi.travel.psnger.core.order.OrderReassignInfo;
import com.didi.travel.psnger.model.FlierFeature;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didi.travel.psnger.model.response.CarUpdateAddress;
import com.didi.travel.psnger.model.response.DTSDKShareCouponModel;
import com.didi.travel.psnger.model.response.FlierCarPoolDetail;
import com.didi.travel.psnger.model.response.OrderRealtimePriceCount;
import com.didi.travel.psnger.p170v2.TravelUtil;
import com.didi.travel.psnger.store.DDTravelOrderStore;
import com.didi.travel.psnger.utils.LogUtil;
import com.didi.travel.psnger.utils.OmegaUtils;
import com.didi.travel.psnger.utils.TextUtil;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.mas.sdk.quality.report.utils.Constants;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class CoreHttpRequest {
    public static void createOrder(Context context, Map map, ResponseListener<? extends ICarOrder> responseListener) {
        DTSDKRequest.getInstance(context).createOrder(map, responseListener);
    }

    public static void cancelTrip(Context context, Map map, ResponseListener<? extends ICarCancelTrip> responseListener) {
        DTSDKRequest.getInstance(context).cancelTrip(map, responseListener);
    }

    public static void cancelOrder(Context context, Map map, ResponseListener<? extends ICancelOrder> responseListener) {
        DTSDKRequest.getInstance(context).cancelOrder(map, responseListener);
    }

    public static void getOrderStatus(Context context, OrderStatusParams orderStatusParams, ResponseListener<? extends IOrderStatus> responseListener) {
        HashMap hashMap = new HashMap(1);
        hashMap.put("order_id", orderStatusParams.getOid());
        DTSDKRequest.getInstance(context).getOrderStatus(hashMap, responseListener);
    }

    public static void getOrderDetail(Context context, BaseOrderDetailParams baseOrderDetailParams, final ITravelOrderListener iTravelOrderListener) {
        OmegaUtils.trackEvent("gp_confirm_orderDetail_request");
        TravelUtil.checkAndStoreOid(baseOrderDetailParams.getOid(), "CoreHttpRequest.getOrderDetail");
        if (BffUtils.isBffStageNewFifth()) {
            HashMap hashMap = new HashMap();
            hashMap.put("order_id", baseOrderDetailParams.getOid());
            Bff.call(new IBffProxy.Ability.Builder(context, BffConstants.AbilityID.ABILITY_ORDER_DETAIL).setParams(hashMap).setCallback(new RpcService.Callback<JsonObject>() {
                public void onSuccess(JsonObject jsonObject) {
                    DTSDKOrderDetail dTSDKOrderDetail = new DTSDKOrderDetail();
                    try {
                        dTSDKOrderDetail.parse(new JSONObject(jsonObject.toString()));
                        dTSDKOrderDetail.errno = jsonObject.get("errno").getAsInt();
                        dTSDKOrderDetail.errmsg = jsonObject.get("errmsg").getAsString();
                        if (dTSDKOrderDetail.errno == 0) {
                            CoreHttpRequest.doOrderDetailFetchSuccess(dTSDKOrderDetail, ITravelOrderListener.this);
                            return;
                        }
                        if (ITravelOrderListener.this != null) {
                            ITravelOrderListener.this.onFail(dTSDKOrderDetail.errno, dTSDKOrderDetail.errmsg);
                        }
                        CoreHttpRequest.trackOrderDetailResult(dTSDKOrderDetail.errno);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                public void onFailure(IOException iOException) {
                    DTSDKOrderDetail dTSDKOrderDetail = new DTSDKOrderDetail();
                    if (ITravelOrderListener.this != null) {
                        String str = null;
                        if (iOException != null) {
                            str = " throwable=" + iOException.getMessage();
                        }
                        ITravelOrderListener.this.onError(dTSDKOrderDetail.errno, str);
                    }
                    CoreHttpRequest.trackOrderDetailResult(dTSDKOrderDetail.errno);
                }
            }).build());
            return;
        }
        DTSDKRequest.getInstance(context).getOrderDetail(baseOrderDetailParams.getParams(), new ResponseListener<DTSDKOrderDetail>() {
            public void onSuccess(DTSDKOrderDetail dTSDKOrderDetail) {
                super.onSuccess(dTSDKOrderDetail);
                CoreHttpRequest.doOrderDetailFetchSuccess(dTSDKOrderDetail, ITravelOrderListener.this);
            }

            public void onError(DTSDKOrderDetail dTSDKOrderDetail) {
                super.onError(dTSDKOrderDetail);
                if (ITravelOrderListener.this != null) {
                    String str = dTSDKOrderDetail.errmsg;
                    if (dTSDKOrderDetail.getThrowable() != null) {
                        str = str + " throwable=" + dTSDKOrderDetail.getThrowable().getMessage();
                    }
                    ITravelOrderListener.this.onError(dTSDKOrderDetail.errno, str);
                }
                CoreHttpRequest.trackOrderDetailResult(dTSDKOrderDetail.errno);
            }

            public void onFail(DTSDKOrderDetail dTSDKOrderDetail) {
                super.onFail(dTSDKOrderDetail);
                ITravelOrderListener iTravelOrderListener = ITravelOrderListener.this;
                if (iTravelOrderListener != null) {
                    iTravelOrderListener.onFail(dTSDKOrderDetail.errno, dTSDKOrderDetail.errmsg);
                }
                CoreHttpRequest.trackOrderDetailResult(dTSDKOrderDetail.errno);
            }
        });
    }

    public static void doOrderDetailFetchSuccess(DTSDKOrderDetail dTSDKOrderDetail, ITravelOrderListener iTravelOrderListener) {
        if (!(dTSDKOrderDetail == null || dTSDKOrderDetail.dtsdkBasicData == null || dTSDKOrderDetail.dtsdkBasicData.basicOrderData == null)) {
            TravelUtil.checkAndStoreOid(dTSDKOrderDetail.dtsdkBasicData.basicOrderData.oid, "doOrderDetailFetchSuccess");
            if (dTSDKOrderDetail.dtsdkBasicData.basicOrderData.isTimeout) {
                if (iTravelOrderListener != null) {
                    iTravelOrderListener.onTimeout(dTSDKOrderDetail.dtsdkBasicData.basicOrderData.timeOutMsg);
                }
                trackOrderDetailResult(-3);
                return;
            }
        }
        if (dTSDKOrderDetail.dtsdkBasicData != null) {
            DTSDKOrderDetail.DTSDKBasicOrderData dTSDKBasicOrderData = dTSDKOrderDetail.dtsdkBasicData.basicOrderData;
            CarOrder carOrder = (CarOrder) DDTravelOrderStore.getOrder();
            CarOrder parseCarOrder = parseCarOrder(dTSDKOrderDetail);
            if (parseCarOrder != null && !TextUtils.isEmpty(parseCarOrder.oid)) {
                Store.getOrCreateStore(TravelUtil.generateCarOrderStoreKey(parseCarOrder.oid)).setStore(Store.S_NONE_INVOKE_ARGS, parseCarOrder);
            }
            if (dTSDKBasicOrderData != null && dTSDKBasicOrderData.status == 2 && dTSDKBasicOrderData.subStatus == 2003 && carOrder != null && !TextUtil.isEmpty(carOrder.oid) && OrderReassignInfo.getInstance().isReassignOidMatched(dTSDKBasicOrderData.oid, carOrder.oid)) {
                LogUtil.m31431fe("oldOrder.oid = " + carOrder.oid + ", orderData.oid = " + dTSDKBasicOrderData.oid + ", orderData.newOid = " + dTSDKBasicOrderData.newOid);
                LogUtils.m31492e("CoreHttpRequest", "doOrderDetailFetchSuccess:oldOrder.oid = " + TravelUtil.getRichOid(carOrder.oid) + ", orderData.oid = " + TravelUtil.getRichOid(dTSDKBasicOrderData.oid) + ", orderData.newOid = " + TravelUtil.getRichOid(dTSDKBasicOrderData.newOid));
                DDTravelOrderStore.setOrder(carOrder);
            }
            if (iTravelOrderListener != null) {
                iTravelOrderListener.onSuccess(parseCarOrder);
            }
            trackOrderDetailResult(0);
            m31409a(parseCarOrder, carOrder);
        } else if (iTravelOrderListener != null) {
            iTravelOrderListener.onFail(dTSDKOrderDetail.errno, dTSDKOrderDetail.errmsg);
        }
    }

    /* renamed from: a */
    private static void m31409a(CarOrder carOrder, CarOrder carOrder2) {
        HashMap hashMap = new HashMap();
        hashMap.put("oid", carOrder.getOid());
        hashMap.put("status", Integer.valueOf(carOrder.getStatus()));
        hashMap.put(ParamKeys.PARAM_SUB_STATUS, Integer.valueOf(carOrder.getSubStatus()));
        if (carOrder2 != null) {
            hashMap.put("p_oid", carOrder2.getOid());
            hashMap.put("p_status", Integer.valueOf(carOrder2.getStatus()));
            hashMap.put("p_sub_status", Integer.valueOf(carOrder2.getSubStatus()));
        }
        OmegaUtils.trackEvent("tech_pax_order_detail_get", (Map<String, Object>) hashMap);
    }

    public static void trackOrderDetailResult(int i) {
        OmegaUtils.trackEvent("gp_confirm_orderDetail_request_result", Constants.ERROR_CODE, i + "");
    }

    public static CarOrder parseCarOrder(DTSDKOrderDetail dTSDKOrderDetail) {
        DTSDKOrderDetail.DTSDKBasicOrderData dTSDKBasicOrderData = dTSDKOrderDetail.dtsdkBasicData.basicOrderData;
        CarOrder carOrder = new CarOrder();
        carOrder.mapData = dTSDKOrderDetail.dtsdkMapData;
        carOrder.feeObjection = dTSDKBasicOrderData.feeObjection;
        carOrder.oid = dTSDKBasicOrderData.oid;
        carOrder.travelid = dTSDKBasicOrderData.travelid;
        carOrder.lastOrderId = dTSDKBasicOrderData.getLastOrderId();
        carOrder.comboType = dTSDKBasicOrderData.comboType;
        carOrder.waitTime = dTSDKBasicOrderData.waitTime;
        carOrder.holdTime = dTSDKBasicOrderData.holdTime;
        carOrder.productid = dTSDKBasicOrderData.businessId;
        carOrder.imBusinessId = dTSDKBasicOrderData.imBusinessId;
        carOrder.orderType = dTSDKBasicOrderData.orderType;
        carOrder.mapType = dTSDKBasicOrderData.mapType;
        carOrder.tripCountry = dTSDKBasicOrderData.tripCountry;
        carOrder.isCapPrice = dTSDKBasicOrderData.isCapPrice;
        carOrder.capPrice = dTSDKBasicOrderData.capPrice;
        carOrder.capPriceDisplay = dTSDKBasicOrderData.capPriceDisplay;
        carOrder.carPoolOrderScene = dTSDKBasicOrderData.carPoolOrderScene;
        carOrder.countPriceType = dTSDKBasicOrderData.countPriceType;
        carOrder.wayPointList = SugWayPointsUtils.getWayPointListFromJson(dTSDKBasicOrderData.wayPoints);
        carOrder.wayPointsVersion = dTSDKBasicOrderData.wayPointsVersion;
        carOrder.stationGuideName = dTSDKBasicOrderData.stationGuideName;
        carOrder.stationWalkGuideLink = dTSDKBasicOrderData.stationWalkGuideLink;
        carOrder.enterpriseFlag = dTSDKBasicOrderData.enterpriseFlag;
        if (dTSDKOrderDetail.dtsdkBizConfig != null) {
            carOrder.servicePhone = dTSDKOrderDetail.dtsdkBizConfig.service_phone;
        }
        if (dTSDKOrderDetail.dtsdkEntryData != null) {
            carOrder.share = dTSDKOrderDetail.dtsdkEntryData.share;
            carOrder.updateDest = dTSDKOrderDetail.dtsdkEntryData.updateDestModel;
            carOrder.updateWayPoint = dTSDKOrderDetail.dtsdkEntryData.updateWayPoint;
            carOrder.showUpdatePickUpPop = dTSDKOrderDetail.dtsdkEntryData.showUpdatePickUpPop;
            carOrder.isDetailPriceClosed = dTSDKOrderDetail.dtsdkEntryData.isDetailPriceClosed;
            carOrder.unevaluatedViewModel = dTSDKOrderDetail.dtsdkEntryData.unevaluatedViewModel;
            carOrder.showWalletFloat = dTSDKOrderDetail.dtsdkEntryData.showWalletFloat;
        }
        if (dTSDKBasicOrderData.orderType == 0) {
            carOrder.transportTime = 0;
        } else {
            carOrder.transportTime = dTSDKBasicOrderData.departureTime;
        }
        carOrder.departureTime = dTSDKBasicOrderData.departureTime;
        carOrder.carLevel = dTSDKBasicOrderData.requireLevel;
        carOrder.isCallCar = dTSDKBasicOrderData.isCallCar;
        carOrder.status = dTSDKBasicOrderData.status;
        carOrder.substatus = dTSDKBasicOrderData.subStatus;
        carOrder.startAddress = dTSDKBasicOrderData.startAddress;
        carOrder.endAddress = dTSDKBasicOrderData.endAddress;
        if (dTSDKBasicOrderData.departureAddressesAbout != null) {
            carOrder.startAddress.srcTag = dTSDKBasicOrderData.departureAddressesAbout.chooseFSrctag;
        }
        carOrder.carCancelTrip = dTSDKBasicOrderData.carCancelTrip;
        carOrder.createTime = dTSDKBasicOrderData.createTime;
        carOrder.arriveTime = dTSDKBasicOrderData.arriveTime;
        carOrder.startChargeTime = dTSDKBasicOrderData.startChargeTime;
        carOrder.finishTime = dTSDKBasicOrderData.driverEndPriceTime;
        carOrder.consultTime = dTSDKBasicOrderData.consultTime;
        carOrder.assignedTime = dTSDKBasicOrderData.assignedTime;
        carOrder.disTrict = dTSDKBasicOrderData.disTrict;
        boolean z = false;
        carOrder.tip = dTSDKBasicOrderData.tip != null ? Integer.valueOf(dTSDKBasicOrderData.tip).intValue() : 0;
        carOrder.carDriver = dTSDKOrderDetail.dtsdkBasicData.driverModel;
        carOrder.upgradeInfo = dTSDKOrderDetail.dtsdkBasicData.upgradeModel;
        carOrder.carInfo = dTSDKOrderDetail.dtsdkBasicData.carModel;
        carOrder.labelInfo = dTSDKOrderDetail.dtsdkBasicData.labelInfo;
        carOrder.payResult = dTSDKOrderDetail.dtsdkBasicData.payResult;
        carOrder.opActivityInfo = dTSDKOrderDetail.dtsdkBasicData.opActivityInfo;
        if (dTSDKOrderDetail.dtsdkBasicData.driverModel != null) {
            carOrder.joinModel = dTSDKOrderDetail.dtsdkBasicData.driverModel.joinModel;
        }
        if (dTSDKOrderDetail.dtsdkBasicData.payResult != null) {
            carOrder.isPay = dTSDKOrderDetail.dtsdkBasicData.payResult.isPay;
        }
        carOrder.payType = dTSDKBasicOrderData.payType;
        carOrder.countryCode = dTSDKBasicOrderData.tripCountry;
        carOrder.currency = dTSDKBasicOrderData.currency;
        carOrder.payInfo = dTSDKBasicOrderData.payInfo;
        carOrder.couponInfo = dTSDKOrderDetail.dtsdkBasicData.couponInfo;
        carOrder.expensiveCompensationInfo = dTSDKOrderDetail.dtsdkBasicData.expensiveCompensationInfo;
        carOrder.invoiceInfo = dTSDKOrderDetail.dtsdkBasicData.mInvoiceInfo;
        carOrder.cardInfo = dTSDKOrderDetail.dtsdkBasicData.cardInfo;
        carOrder.cancelInfo = dTSDKOrderDetail.dtsdkBasicData.cancelInfo;
        if (dTSDKOrderDetail.dtsdkBasicData.carModel != null) {
            carOrder.passengerCount = dTSDKOrderDetail.dtsdkBasicData.carModel.passengerCount;
        }
        carOrder.comboInfo = dTSDKOrderDetail.dtsdkSceneData.comboData;
        FlierFeature flierFeature = new FlierFeature();
        flierFeature.carPool = (dTSDKBasicOrderData.comboType == 4 || dTSDKBasicOrderData.comboType == 302) ? 1 : 0;
        flierFeature.isPoolStation = dTSDKBasicOrderData.isPoolStation;
        flierFeature.flierPoolStationModel = dTSDKOrderDetail.dtsdkSceneData.flierPoolStationModel;
        try {
            if (flierFeature.flierPoolStationModel != null) {
                flierFeature.flierPoolStationModel.readyDepartureTime = String.valueOf(dTSDKOrderDetail.dtsdkBasicData.basicOrderData.departureTime);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        carOrder.flierFeature = flierFeature;
        carOrder.isCarpoolCommute = dTSDKOrderDetail.dtsdkSceneData.isCarpoolCommute;
        carOrder.donateInfo = dTSDKOrderDetail.dtsdkSceneData.donateInfo;
        carOrder.timeSegment = dTSDKOrderDetail.dtsdkSceneData.timeArray;
        carOrder.prepareSCModel = dTSDKOrderDetail.dtsdkPushInfo;
        carOrder.bannerTopInfo = dTSDKOrderDetail.dtsdkPushInfo.bannerTopInfo;
        carOrder.striveInfo = dTSDKOrderDetail.striveInfo;
        carOrder.loopMsg = dTSDKOrderDetail.pollMsg;
        carOrder.evaluateModel = dTSDKOrderDetail.dtsdkEntryData.carEvaluateModel;
        carOrder.showQuestion = dTSDKOrderDetail.dtsdkEntryData.showQuestion;
        carOrder.buttonControl = dTSDKOrderDetail.dtsdkEntryData.buttonControl;
        carOrder.postOrderRecInfo = dTSDKOrderDetail.dtsdkEntryData.postOrderRecInfo;
        carOrder.bookingAssignInfo = dTSDKOrderDetail.dtsdkEntryData.bookAssignInfo;
        if (!(carOrder.postOrderRecInfo == null || carOrder.postOrderRecInfo.isPostOrderRec != 1 || carOrder.postOrderRecInfo.carPostOrderModel == null)) {
            m31410a(carOrder, carOrder.postOrderRecInfo.carPostOrderModel.updateAddress);
        }
        carOrder.airportPanelData = dTSDKOrderDetail.dtsdkAirportPanel;
        CarOrder carOrder2 = (CarOrder) DDTravelOrderStore.getOrder();
        if (!(carOrder2 == null || carOrder2.oid == null || !carOrder2.oid.equalsIgnoreCase(carOrder.oid))) {
            boolean z2 = carOrder.startAddress == null || carOrder2.startAddress == null || TextUtils.isEmpty(carOrder2.startAddress.uid) || !carOrder2.startAddress.uid.equals(carOrder.startAddress.uid);
            if (carOrder.endAddress == null || carOrder2.endAddress == null || TextUtils.isEmpty(carOrder2.endAddress.uid) || !carOrder2.endAddress.uid.equals(carOrder.endAddress.uid)) {
                z = true;
            }
            if (!z2 && !z) {
                carOrder.startAddress = carOrder2.startAddress;
                carOrder.endAddress = carOrder2.endAddress;
                carOrder.orderSource = carOrder2.orderSource;
                carOrder.mOrderTag = carOrder2.mOrderTag;
                carOrder.mRealtimePriceCount = carOrder2.mRealtimePriceCount;
                carOrder.assignResult = carOrder2.assignResult;
                carOrder.orderState = carOrder2.orderState;
                if (carOrder.orderState != null) {
                    carOrder.orderState.status = dTSDKBasicOrderData.status;
                    carOrder.orderState.subStatus = dTSDKBasicOrderData.subStatus;
                }
            }
        }
        if (carOrder.orderState == null) {
            DTSDKOrderStatus dTSDKOrderStatus = new DTSDKOrderStatus();
            dTSDKOrderStatus.oid = dTSDKBasicOrderData.oid;
            dTSDKOrderStatus.newOrderId = dTSDKBasicOrderData.newOid;
            dTSDKOrderStatus.status = dTSDKBasicOrderData.status;
            dTSDKOrderStatus.subStatus = dTSDKBasicOrderData.subStatus;
            dTSDKOrderStatus.carpoolStatus = dTSDKBasicOrderData.carpoolStatus;
            carOrder.orderState = dTSDKOrderStatus;
        }
        carOrder.carpoolStatus = dTSDKBasicOrderData.carpoolStatus;
        carOrder.splitFareInfo = dTSDKOrderDetail.dtsdkBasicData.splitFareInfo;
        carOrder.companyTags = dTSDKOrderDetail.dtsdkBasicData.companyTags;
        carOrder.toastData = dTSDKOrderDetail.toastData;
        DDTravelOrderStore.setOrder(carOrder);
        TravelUtil.setCarOrder(carOrder);
        return carOrder;
    }

    public static void getOnServiceRealtimePrice(Context context, String str, ResponseListener<OrderRealtimePriceCount> responseListener) {
        HashMap hashMap = new HashMap(1);
        hashMap.put("order_id", str);
        DTSDKRequest.getInstance(context).getOnServiceRealtimePrice(hashMap, responseListener);
    }

    public static void getEndServiceShareInfo(Context context, String str, ResponseListener<DTSDKShareCouponModel> responseListener) {
        HashMap hashMap = new HashMap(1);
        hashMap.put("order_id", str);
        DTSDKRequest.getInstance(context).getEndServiceShareInfo(hashMap, responseListener);
    }

    /* renamed from: a */
    private static void m31410a(CarOrder carOrder, CarUpdateAddress carUpdateAddress) {
        if (carOrder != null && carOrder.startAddress != null && carUpdateAddress != null) {
            carOrder.startAddress.latitude = carUpdateAddress.lat;
            carOrder.startAddress.longitude = carUpdateAddress.lng;
            carOrder.startAddress.address = carUpdateAddress.address;
            carOrder.startAddress.displayName = carUpdateAddress.name;
            carOrder.startAddress.uid = carUpdateAddress.poiId;
        }
    }

    public static void getCarPoolDetail(Context context, Map map, ResponseListener<FlierCarPoolDetail> responseListener) {
        DTSDKRequest.getInstance(context).getCarPoolDetail(map, responseListener);
    }
}
