package com.didi.travel.psnger.common.net;

import android.content.Context;
import com.android.didi.bfflib.Bff;
import com.android.didi.bfflib.IBffProxy;
import com.didi.travel.psnger.bff.BffConstants;
import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didi.travel.psnger.common.net.base.BaseRequest;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didi.travel.psnger.common.net.base.RPCServiceWrapper;
import com.didi.travel.psnger.common.net.base.ResponseListener;
import com.didi.travel.psnger.common.net.host.HostGroupManager;
import com.didi.travel.psnger.common.net.rpc.IBaseCarRpcSerivice;
import com.didi.travel.psnger.core.model.response.DTSDKOrderDetail;
import com.didi.travel.psnger.core.model.response.DTSDKOrderStatus;
import com.didi.travel.psnger.core.model.response.ICarOrder;
import com.didi.travel.psnger.core.model.response.IEstimateModel;
import com.didi.travel.psnger.model.response.A3DeviceInfo;
import com.didi.travel.psnger.model.response.BookingOrderModel;
import com.didi.travel.psnger.model.response.CancelOrder;
import com.didi.travel.psnger.model.response.CarCancelTrip;
import com.didi.travel.psnger.model.response.CarConfig;
import com.didi.travel.psnger.model.response.CarEvaluateQuestionData;
import com.didi.travel.psnger.model.response.CarHasEvaluateData;
import com.didi.travel.psnger.model.response.CarNoEvaluateData;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didi.travel.psnger.model.response.CarQuestionNaire;
import com.didi.travel.psnger.model.response.CarSignAgentLayer;
import com.didi.travel.psnger.model.response.CarTipInfo;
import com.didi.travel.psnger.model.response.CarWanliuProperty;
import com.didi.travel.psnger.model.response.CharteredComboInfos;
import com.didi.travel.psnger.model.response.CommentOnPanel;
import com.didi.travel.psnger.model.response.DTSDKShareCouponModel;
import com.didi.travel.psnger.model.response.FeeTipsModel;
import com.didi.travel.psnger.model.response.FlierCarPoolDetail;
import com.didi.travel.psnger.model.response.FlightOrderInfo;
import com.didi.travel.psnger.model.response.IMOrNOSecurity;
import com.didi.travel.psnger.model.response.InsuranceHistoryInfo;
import com.didi.travel.psnger.model.response.InsuranceStatusInfo;
import com.didi.travel.psnger.model.response.NextPrePayModel;
import com.didi.travel.psnger.model.response.OneKeyXConfig;
import com.didi.travel.psnger.model.response.OrderExtraInfoModel;
import com.didi.travel.psnger.model.response.OrderRealtimePriceCount;
import com.didi.travel.psnger.model.response.PayEnterpriseSelectModel;
import com.didi.travel.psnger.model.response.PayMethodInfoResult;
import com.didi.travel.psnger.model.response.PinCodeInfoResult;
import com.didi.travel.psnger.model.response.PoolStationTopModel;
import com.didi.travel.psnger.model.response.PrePayTipsModel;
import com.didi.travel.psnger.model.response.QuotaFenceInfo;
import com.didi.travel.psnger.model.response.RegionTimeDataV2;
import com.didi.travel.psnger.model.response.ScarEnsureCoupon;
import com.didi.travel.psnger.model.response.ScarFeeDetailResult;
import com.didi.travel.psnger.model.response.TaxiCompanyListModel;
import com.didi.travel.psnger.model.response.UpdateDestModel;
import com.didi.travel.psnger.model.response.UpdateOrderInfoModel;
import com.didi.travel.psnger.model.response.VerifyCardPerception;
import com.didi.travel.psnger.model.response.WayPointModel;
import com.didi.travel.psnger.model.response.estimate.BubbleSelectResponse;
import com.didi.travel.psnger.p170v2.host.HostManager;
import com.didi.travel.psnger.utils.GsonUtil;
import com.didi.travel.psnger.utils.LogUtil;
import com.didi.travel.psnger.utils.NumberUtil;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class DTSDKRequest extends BaseRequest {

    /* renamed from: b */
    private static DTSDKRequest f44031b;

    /* renamed from: a */
    private Context f44032a;

    /* renamed from: c */
    private final String f44033c = HostManager.SHARE_PATH_BIZ_V1;

    /* renamed from: d */
    private final String f44034d = HostManager.SHARE_PATH_BIZ_V2;

    /* renamed from: e */
    private final String f44035e = HostManager.SHARE_PATH_EVALUATE;

    /* renamed from: f */
    private final String f44036f = HostManager.SHARE_PATH_ENTERPRISE_PAY;

    /* renamed from: g */
    private IBaseCarRpcSerivice f44037g;

    /* renamed from: h */
    private IBaseCarRpcSerivice f44038h;

    /* renamed from: i */
    private IBaseCarRpcSerivice f44039i;

    /* renamed from: j */
    private IBaseCarRpcSerivice f44040j;

    public Object getEstimatePrice(Map map, ResponseListener<? extends IEstimateModel> responseListener) {
        return null;
    }

    private DTSDKRequest(Context context) {
        this.f44032a = context.getApplicationContext();
        RpcServiceFactory rpcServiceFactory = new RpcServiceFactory(context);
        this.f44037g = (IBaseCarRpcSerivice) RPCServiceWrapper.wrap(this.f44032a, (IBaseCarRpcSerivice) rpcServiceFactory.newRpcService(IBaseCarRpcSerivice.class, HostGroupManager.getInstance().getDiDiBizHost() + HostManager.SHARE_PATH_BIZ_V1));
        String diDiBizHost = HostGroupManager.getInstance().getDiDiBizHost();
        this.f44038h = (IBaseCarRpcSerivice) RPCServiceWrapper.wrap(this.f44032a, (IBaseCarRpcSerivice) rpcServiceFactory.newRpcService(IBaseCarRpcSerivice.class, diDiBizHost + HostManager.SHARE_PATH_BIZ_V2));
        this.f44039i = (IBaseCarRpcSerivice) RPCServiceWrapper.wrap(this.f44032a, (IBaseCarRpcSerivice) rpcServiceFactory.newRpcService(IBaseCarRpcSerivice.class, HostGroupManager.getInstance().getDiDiEvaluateHost() + HostManager.SHARE_PATH_EVALUATE));
        this.f44040j = (IBaseCarRpcSerivice) RPCServiceWrapper.wrap(this.f44032a, (IBaseCarRpcSerivice) rpcServiceFactory.newRpcService(IBaseCarRpcSerivice.class, HostGroupManager.getInstance().getDiDiPayEnterpriseHost() + HostManager.SHARE_PATH_ENTERPRISE_PAY));
    }

    public static DTSDKRequest getInstance(Context context) {
        if (f44031b == null) {
            synchronized (DTSDKRequest.class) {
                if (f44031b == null) {
                    f44031b = new DTSDKRequest(context.getApplicationContext());
                }
            }
        }
        return f44031b;
    }

    public void getWangliuInfo(Map map, ResponseListener<CarWanliuProperty> responseListener) {
        Map<String, Object> createBaseParams = createBaseParams(this.f44032a);
        createBaseParams.putAll(map);
        this.f44037g.getWanliuInfo(createBaseParams, getRpcCallback(responseListener, new CarWanliuProperty()));
    }

    public void getConfig(Map map, ResponseListener<CarConfig> responseListener) {
        Map<String, Object> createBaseParams = createBaseParams(this.f44032a);
        createBaseParams.putAll(map);
        try {
            this.f44037g.getConfig(createBaseParams, getRpcCallback(responseListener, new CarConfig()));
        } catch (Exception unused) {
        }
    }

    public void doBubbleSelect(Map map, ResponseListener<BubbleSelectResponse> responseListener) {
        Map<String, Object> createBaseParams = createBaseParams(this.f44032a);
        createBaseParams.putAll(map);
        this.f44038h.doBubbleSelect(createBaseParams, getRpcCallback(responseListener, new BubbleSelectResponse()));
    }

    public void createOrder(Map map, ResponseListener<? extends ICarOrder> responseListener) {
        Map<String, Object> createBaseParams = createBaseParams(this.f44032a);
        createBaseParams.putAll(map);
        this.f44037g.createOrder(createBaseParams, getRpcCallback(responseListener, new CarOrder()));
    }

    public void cancelOrder(Map map, final ResponseListener<CancelOrder> responseListener) {
        HashMap hashMap = new HashMap();
        hashMap.put("oid", map.get("oid"));
        Bff.call(new IBffProxy.Ability.Builder(this.f44032a, BffConstants.AbilityID.ABILITY_CANCEL_ORDER).setParams(hashMap).setCallback(new RpcService.Callback<JsonObject>() {
            public void onSuccess(JsonObject jsonObject) {
                CancelOrder cancelOrder = new CancelOrder();
                cancelOrder.parse(jsonObject.toString());
                if (cancelOrder.isAvailable()) {
                    responseListener.onSuccess(cancelOrder);
                } else {
                    responseListener.onFail(cancelOrder);
                }
                responseListener.onFinish(cancelOrder);
            }

            public void onFailure(IOException iOException) {
                CancelOrder cancelOrder = new CancelOrder();
                responseListener.onError(cancelOrder);
                responseListener.onFinish(cancelOrder);
            }
        }).build());
    }

    public void updateOrderInfo(Map map, ResponseListener<UpdateOrderInfoModel> responseListener) {
        Map<String, Object> createBaseParams = createBaseParams(this.f44032a);
        createBaseParams.putAll(map);
        this.f44037g.updateOrderInfo(createBaseParams, getRpcCallback(responseListener, new UpdateOrderInfoModel()));
    }

    public void getOrderStatus(Map map, final ResponseListener<DTSDKOrderStatus> responseListener) {
        HashMap hashMap = new HashMap();
        hashMap.put("order_id", map.get("order_id"));
        Bff.call(new IBffProxy.Ability.Builder(this.f44032a, BffConstants.AbilityID.ABILITY_ORDER_STATUS).setParams(hashMap).setCallback(new RpcService.Callback<JsonObject>() {
            public void onSuccess(JsonObject jsonObject) {
                DTSDKOrderStatus dTSDKOrderStatus = new DTSDKOrderStatus();
                dTSDKOrderStatus.errno = jsonObject.get("errno").getAsInt();
                dTSDKOrderStatus.errmsg = jsonObject.get("errmsg").getAsString();
                if (dTSDKOrderStatus.errno == 0) {
                    dTSDKOrderStatus.parseRecommendMsg(jsonObject.get("data").getAsJsonObject().toString());
                    responseListener.onSuccess(dTSDKOrderStatus);
                } else {
                    responseListener.onFail(dTSDKOrderStatus);
                }
                responseListener.onFinish(dTSDKOrderStatus);
            }

            public void onFailure(IOException iOException) {
                responseListener.onError(new DTSDKOrderStatus());
                responseListener.onFinish(new DTSDKOrderStatus());
            }
        }).build());
    }

    @Deprecated
    public Object getOrderDetail(Map map, ResponseListener<DTSDKOrderDetail> responseListener) {
        Map<String, Object> createBaseParams = createBaseParams(this.f44032a);
        createBaseParams.putAll(map);
        return this.f44038h.getOrderDetail(createBaseParams, getRpcCallback(responseListener, new DTSDKOrderDetail()));
    }

    public void doGetGenPayParams(Map map, ResponseListener<NextPrePayModel> responseListener) {
        Map<String, Object> createBaseParams = createBaseParams(this.f44032a);
        createBaseParams.putAll(map);
        this.f44037g.doGetGenPayParams(createBaseParams, getRpcCallback(responseListener, new NextPrePayModel()));
    }

    public void doGetTipInfo(Map map, ResponseListener<CarTipInfo> responseListener) {
        Map<String, Object> createBaseParams = createBaseParams(this.f44032a);
        createBaseParams.putAll(map);
        this.f44038h.doGetTipInfo(createBaseParams, getRpcCallback(responseListener, new CarTipInfo()));
    }

    public void updatePayInfo(Map map, ResponseListener<ScarFeeDetailResult> responseListener) {
        Map<String, Object> createBaseParams = createBaseParams(this.f44032a);
        createBaseParams.putAll(map);
        this.f44037g.updatePayInfo(createBaseParams, getRpcCallback(responseListener, new ScarFeeDetailResult()));
    }

    public void checkOpenRide(Map map, ResponseListener<PayMethodInfoResult> responseListener) {
        Map<String, Object> createBaseParams = createBaseParams(this.f44032a);
        createBaseParams.putAll(map);
        this.f44038h.checkOpenRide(createBaseParams, getRpcCallback(responseListener, new PayMethodInfoResult()));
    }

    public void confirmPinCode(Map map, ResponseListener<PinCodeInfoResult> responseListener) {
        Map<String, Object> createBaseParams = createBaseParams(this.f44032a);
        createBaseParams.putAll(map);
        this.f44038h.confirmPinCode(createBaseParams, getRpcCallback(responseListener, new PinCodeInfoResult()));
    }

    public void notifyDriverStateOfPsg(Map map, ResponseListener<BaseObject> responseListener) {
        Map<String, Object> createBaseParams = createBaseParams(this.f44032a);
        createBaseParams.putAll(map);
        this.f44038h.notifyDriverPsgState(createBaseParams, getRpcCallback(responseListener, new BaseObject()));
    }

    public void paypAgentRemind(Map map, ResponseListener<CarSignAgentLayer> responseListener) {
        Map<String, Object> createBaseParams = createBaseParams(this.f44032a);
        createBaseParams.putAll(map);
        this.f44037g.paypAgentRemind(createBaseParams, getRpcCallback(responseListener, new CarSignAgentLayer()));
    }

    public void getFeeDetail(Map map, ResponseListener<ScarFeeDetailResult> responseListener) {
        Map<String, Object> createBaseParams = createBaseParams(this.f44032a);
        createBaseParams.putAll(map);
        this.f44037g.getFeeDetail(createBaseParams, getRpcCallback(responseListener, new ScarFeeDetailResult()));
    }

    public void cancelTrip(Map map, final ResponseListener<CarCancelTrip> responseListener) {
        HashMap hashMap = new HashMap();
        hashMap.put("oid", map.get("oid"));
        hashMap.put("type", Integer.valueOf(NumberUtil.strToInt((String) map.get("type"))));
        hashMap.put(ParamKeys.PARAM_CONTROL, Integer.valueOf(NumberUtil.strToInt((String) map.get(ParamKeys.PARAM_CONTROL))));
        hashMap.put("content", map.get("content"));
        hashMap.put(ParamKeys.PARAM_NATIVE_CANCEL, Integer.valueOf(NumberUtil.strToInt((String) map.get(ParamKeys.PARAM_NATIVE_CANCEL))));
        hashMap.put(ParamKeys.INTERVENTION_TYPE, map.get(ParamKeys.INTERVENTION_TYPE));
        hashMap.put(ParamKeys.PARAM_SUB_STATUS, Integer.valueOf(NumberUtil.strToInt((String) map.get(ParamKeys.PARAM_SUB_STATUS))));
        if (map.get(ParamKeys.PARAM_CANCEL_REASON) != null) {
            hashMap.put(ParamKeys.PARAM_CANCEL_REASON, map.get(ParamKeys.PARAM_CANCEL_REASON));
        }
        Bff.call(new IBffProxy.Ability.Builder(this.f44032a, BffConstants.AbilityID.ABILITY_CANCEL_TRIP).setParams(hashMap).setCallback(new RpcService.Callback<JsonObject>() {
            public void onSuccess(JsonObject jsonObject) {
                CarCancelTrip carCancelTrip = new CarCancelTrip();
                try {
                    carCancelTrip.errno = jsonObject.get("errno").getAsInt();
                    carCancelTrip.errmsg = jsonObject.get("errmsg").getAsString();
                    if (carCancelTrip.errno == 0) {
                        if (jsonObject.has("data")) {
                            carCancelTrip.parse(new JSONObject(jsonObject.get("data").getAsJsonObject().toString()));
                        }
                        responseListener.onSuccess(carCancelTrip);
                    } else {
                        responseListener.onFail(carCancelTrip);
                    }
                    responseListener.onFinish(carCancelTrip);
                } catch (JSONException e) {
                    e.printStackTrace();
                    responseListener.onFail(new CarCancelTrip());
                    responseListener.onFinish(new CarCancelTrip());
                }
            }

            public void onFailure(IOException iOException) {
                responseListener.onError(new CarCancelTrip());
                responseListener.onFinish(new CarCancelTrip());
            }
        }).build());
    }

    public void getIMOrNOSecurityConfig(Map map, ResponseListener<IMOrNOSecurity> responseListener) {
        Map<String, Object> createBaseParams = createBaseParams(this.f44032a);
        createBaseParams.putAll(map);
        this.f44037g.getIMOrNOSecurityConfig(createBaseParams, getRpcCallback(responseListener, new IMOrNOSecurity()));
    }

    public void doFeeObjection(Map map, ResponseListener<BaseObject> responseListener) {
        Map<String, Object> createBaseParams = createBaseParams(this.f44032a);
        createBaseParams.putAll(map);
        this.f44037g.doFeeObjection(createBaseParams, getRpcCallback(responseListener, new BaseObject()));
    }

    public void updateLocationFlag(Map map, ResponseListener<BaseObject> responseListener) {
        Map<String, Object> createBaseParams = createBaseParams(this.f44032a);
        createBaseParams.putAll(map);
        this.f44037g.updateLocationFlag(createBaseParams, getRpcCallback(responseListener, new BaseObject()));
    }

    public void getCarPoolDetail(Map map, ResponseListener<FlierCarPoolDetail> responseListener) {
        Map<String, Object> createBaseParams = createBaseParams(this.f44032a);
        createBaseParams.putAll(map);
        this.f44038h.getCarPoolDetail(createBaseParams, getRpcCallback(responseListener, new FlierCarPoolDetail()));
    }

    public void getQuestionNaire(Map map, ResponseListener<CarQuestionNaire> responseListener) {
        Map<String, Object> createBaseParams = createBaseParams(this.f44032a);
        createBaseParams.putAll(map);
        this.f44037g.getQuestionNaire(createBaseParams, getRpcCallback(responseListener, new CarQuestionNaire()));
    }

    public void getEnsureCoupon(Map map, ResponseListener<ScarEnsureCoupon> responseListener) {
        Map<String, Object> createBaseParams = createBaseParams(this.f44032a);
        createBaseParams.putAll(map);
        this.f44037g.getEnsureCoupon(createBaseParams, getRpcCallback(responseListener, new ScarEnsureCoupon()));
    }

    public void addFlightBaseParams(Map<String, Object> map) {
        map.put("_t", Long.valueOf(System.currentTimeMillis() / 1000));
        map.put("sign", generateFlightSign(map));
    }

    public static String generateFlightSign(Map<String, Object> map) {
        Object[] array = new ArrayList(map.keySet()).toArray();
        Arrays.sort(array);
        StringBuilder sb = new StringBuilder();
        for (Object obj : array) {
            String str = (String) obj;
            Object obj2 = map.get(str);
            sb.append(str);
            sb.append(obj2);
        }
        String str2 = "didiwuxiankejiyouxian2013" + sb.toString() + "didiwuxiankejiyouxian2013";
        LogUtil.m31434i("generateFlightSign-->" + str2);
        try {
            return m31352a(str2);
        } catch (NoSuchAlgorithmException unused) {
            return "";
        }
    }

    /* renamed from: a */
    private static String m31352a(String str) throws NoSuchAlgorithmException {
        if (str == null || str.length() == 0) {
            return "";
        }
        MessageDigest instance = MessageDigest.getInstance("SHA-1");
        instance.update(str.getBytes());
        return m31353a(instance.digest());
    }

    /* renamed from: a */
    private static String m31353a(byte[] bArr) {
        String str = "";
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                str = str + "0" + hexString;
            } else {
                str = str + hexString;
            }
        }
        return str;
    }

    public void getFlightOrderInfo(Map map, ResponseListener<FlightOrderInfo> responseListener) {
        Map<String, Object> createBaseParams = createBaseParams(this.f44032a);
        createBaseParams.putAll(map);
        addFlightBaseParams(createBaseParams);
        this.f44037g.doGetFlightOrderInfo(createBaseParams, getRpcCallback(responseListener, new FlightOrderInfo()));
    }

    public void getFlightInsuranceHistoryInfo(Map map, ResponseListener<InsuranceHistoryInfo> responseListener) {
        Map<String, Object> createBaseParams = createBaseParams(this.f44032a);
        createBaseParams.putAll(map);
        addFlightBaseParams(createBaseParams);
        this.f44037g.doGetFlightInsuranceHistoryInfo(createBaseParams, getRpcCallback(responseListener, new InsuranceHistoryInfo()));
    }

    public void getFlightInsuranceInfo(Map map, ResponseListener<InsuranceStatusInfo> responseListener) {
        Map<String, Object> createBaseParams = createBaseParams(this.f44032a);
        createBaseParams.putAll(map);
        addFlightBaseParams(createBaseParams);
        this.f44037g.doGetFlightInsuranceInfo(createBaseParams, getRpcCallback(responseListener, new InsuranceStatusInfo()));
    }

    public void commitFlightInsuranceInfo(Map map, ResponseListener<InsuranceStatusInfo> responseListener) {
        Map<String, Object> createBaseParams = createBaseParams(this.f44032a);
        createBaseParams.putAll(map);
        addFlightBaseParams(createBaseParams);
        this.f44037g.doCommitFlightInsuranceInfo(createBaseParams, getRpcCallback(responseListener, new InsuranceStatusInfo()));
    }

    public void setPassengerAuthorizedNickName(Map map, ResponseListener<BaseObject> responseListener) {
        Map<String, Object> createBaseParams = createBaseParams(this.f44032a);
        createBaseParams.putAll(map);
        this.f44037g.setPassengerAuthorizedNickName(createBaseParams, getRpcCallback(responseListener, new BaseObject()));
    }

    public void getComboInfo(Map map, ResponseListener<CharteredComboInfos> responseListener) {
        Map<String, Object> createBaseParams = createBaseParams(this.f44032a);
        createBaseParams.putAll(map);
        this.f44037g.getComboInfo(createBaseParams, getRpcCallback(responseListener, new CharteredComboInfos()));
    }

    public void getOneKeyXConfig(Map map, ResponseListener<OneKeyXConfig> responseListener) {
        Map<String, Object> createBaseParams = createBaseParams(this.f44032a);
        createBaseParams.putAll(map);
        this.f44037g.getOneKeyXConfig(createBaseParams, getRpcCallback(responseListener, new OneKeyXConfig()));
    }

    public void requestAddressMapRouteForBooking(Map map, ResponseListener<BookingOrderModel> responseListener) {
        Map<String, Object> createBaseParams = createBaseParams(this.f44032a);
        createBaseParams.putAll(map);
        this.f44037g.requestAddressMapRouteForBooking(createBaseParams, getRpcCallback(responseListener, new BookingOrderModel()));
    }

    public Object requestGetStationStatus(Map map, ResponseListener<PoolStationTopModel> responseListener) {
        Map<String, Object> createBaseParams = createBaseParams(this.f44032a);
        createBaseParams.putAll(map);
        return this.f44037g.requestGetStationStatus(createBaseParams, getRpcCallback(responseListener, new PoolStationTopModel()));
    }

    public void prePayTips(Map map, ResponseListener<PrePayTipsModel> responseListener) {
        Map<String, Object> createBaseParams = createBaseParams(this.f44032a);
        createBaseParams.putAll(map);
        this.f44038h.prePayTips(createBaseParams, getRpcCallback(responseListener, new PrePayTipsModel()));
    }

    public void getCommentTag(Context context, Map map, ResponseListener<CarNoEvaluateData> responseListener) {
        Map<String, Object> createBaseParams = createBaseParams(context);
        createBaseParams.putAll(map);
        this.f44039i.getCommentTag(createBaseParams, getRpcCallback(responseListener, new CarNoEvaluateData()));
    }

    public void getCommentData(Context context, Map map, ResponseListener<CarHasEvaluateData> responseListener) {
        Map<String, Object> createBaseParams = createBaseParams(context);
        createBaseParams.putAll(map);
        this.f44039i.getCommentData(createBaseParams, getRpcCallback(responseListener, new CarHasEvaluateData()));
    }

    public void doComment(Context context, Map map, ResponseListener<CarHasEvaluateData> responseListener) {
        Map<String, Object> createBaseParams = createBaseParams(context);
        createBaseParams.putAll(map);
        this.f44039i.doComment(createBaseParams, getRpcCallback(responseListener, new CarHasEvaluateData()));
    }

    public void getCommentOnPanel(Context context, Map map, ResponseListener<CommentOnPanel> responseListener) {
        Map<String, Object> createBaseParams = createBaseParams(context);
        createBaseParams.putAll(map);
        this.f44039i.getCommentOnPanel(createBaseParams, getRpcCallback(responseListener, new CommentOnPanel()));
    }

    public void getEvaluateQuestionData(Context context, Map map, ResponseListener<CarEvaluateQuestionData> responseListener) {
        Map<String, Object> createBaseParams = createBaseParams(context);
        createBaseParams.putAll(map);
        this.f44039i.getEvaluateQuestionData(createBaseParams, getRpcCallback(responseListener, new CarEvaluateQuestionData()));
    }

    public void commitEvaluateQuestionData(Context context, Map map, ResponseListener<CarEvaluateQuestionData> responseListener) {
        Map<String, Object> createBaseParams = createBaseParams(context);
        createBaseParams.putAll(map);
        this.f44039i.commitEvaluateQuestionData(createBaseParams, getRpcCallback(responseListener, new CarEvaluateQuestionData()));
    }

    public void getOrderExtra(Map map, ResponseListener<OrderExtraInfoModel> responseListener) {
        Map<String, Object> createBaseParams = createBaseParams(this.f44032a);
        createBaseParams.putAll(map);
        this.f44038h.getOrderExtraInfo(createBaseParams, getRpcCallback(responseListener, new OrderExtraInfoModel()));
    }

    public void getOnServiceRealtimePrice(Map map, final ResponseListener<OrderRealtimePriceCount> responseListener) {
        HashMap hashMap = new HashMap();
        hashMap.put("order_id", map.get("order_id"));
        Bff.call(new IBffProxy.Ability.Builder(this.f44032a, BffConstants.AbilityID.ABILITY_GET_REAL_TIME_PRICE).setParams(hashMap).setCallback(new RpcService.Callback<JsonObject>() {
            public void onSuccess(JsonObject jsonObject) {
                OrderRealtimePriceCount orderRealtimePriceCount = (OrderRealtimePriceCount) GsonUtil.objectFromJson(jsonObject.toString(), OrderRealtimePriceCount.class);
                responseListener.onSuccess(orderRealtimePriceCount);
                responseListener.onFinish(orderRealtimePriceCount);
            }

            public void onFailure(IOException iOException) {
                responseListener.onError(new OrderRealtimePriceCount());
                responseListener.onFinish(new OrderRealtimePriceCount());
            }
        }).build());
    }

    public void getEndServiceShareInfo(Map map, ResponseListener<DTSDKShareCouponModel> responseListener) {
        Map<String, Object> createBaseParams = createBaseParams(this.f44032a);
        createBaseParams.putAll(map);
        this.f44038h.getEndServiceShareInfo(createBaseParams, getRpcCallback(responseListener, new DTSDKShareCouponModel()));
    }

    public void getRegionTimeRange(Map map, ResponseListener<RegionTimeDataV2> responseListener) {
        Map<String, Object> createBaseParams = createBaseParams(this.f44032a);
        createBaseParams.putAll(map);
        this.f44039i.getRegionTimeRanges(createBaseParams, getRpcCallback(responseListener, new RegionTimeDataV2()));
    }

    public void getFeeTips(Map map, ResponseListener<FeeTipsModel> responseListener) {
        Map<String, Object> createBaseParams = createBaseParams(this.f44032a);
        createBaseParams.putAll(map);
        this.f44038h.getFeeTips(createBaseParams, getRpcCallback(responseListener, new FeeTipsModel()));
    }

    public void updateDestination(Map map, ResponseListener<UpdateDestModel> responseListener) {
        Map<String, Object> createBaseParams = createBaseParams(this.f44032a);
        createBaseParams.putAll(map);
        this.f44038h.updateDestination(createBaseParams, getRpcCallback(responseListener, new UpdateDestModel()));
    }

    public void updateWayPoints(Map map, ResponseListener<WayPointModel> responseListener) {
        Map<String, Object> createBaseParams = createBaseParams(this.f44032a);
        createBaseParams.putAll(map);
        this.f44038h.updateWayPoints(createBaseParams, getRpcCallback(responseListener, new WayPointModel()));
    }

    public void getPayEnterpriseCompanyList(Map map, ResponseListener<PayEnterpriseSelectModel> responseListener) {
        Map<String, Object> createBaseParams = createBaseParams(this.f44032a);
        createBaseParams.putAll(map);
        this.f44040j.getPayEnterpriseCompanyList(createBaseParams, getRpcCallback(responseListener, new PayEnterpriseSelectModel(0)));
    }

    public void getPayEnterpriseCostCenterList(Map map, ResponseListener<PayEnterpriseSelectModel> responseListener) {
        Map<String, Object> createBaseParams = createBaseParams(this.f44032a);
        createBaseParams.putAll(map);
        this.f44040j.getPayEnterpriseCostCenterList(createBaseParams, getRpcCallback(responseListener, new PayEnterpriseSelectModel(1)));
    }

    public void getPayEnterpriseProjectList(Map map, ResponseListener<PayEnterpriseSelectModel> responseListener) {
        Map<String, Object> createBaseParams = createBaseParams(this.f44032a);
        createBaseParams.putAll(map);
        this.f44040j.getPayEnterpriseProjectList(createBaseParams, getRpcCallback(responseListener, new PayEnterpriseSelectModel(2)));
    }

    public void updatePickUp(Map map, ResponseListener<BaseObject> responseListener) {
        Map<String, Object> createBaseParams = createBaseParams(this.f44032a);
        createBaseParams.putAll(map);
        this.f44038h.updatePickUp(createBaseParams, getRpcCallback(responseListener, new BaseObject()));
    }

    public void getDeviceInfo(Map map, ResponseListener<A3DeviceInfo> responseListener) {
        Map<String, Object> createBaseParams = createBaseParams(this.f44032a);
        createBaseParams.putAll(map);
        this.f44038h.getDeviceInfo(createBaseParams, getRpcCallback(responseListener, new A3DeviceInfo()));
    }

    public void verifyCard(Map map, ResponseListener<VerifyCardPerception> responseListener) {
        Map<String, Object> createBaseParams = createBaseParams(this.f44032a);
        createBaseParams.putAll(map);
        this.f44038h.verifyCard(createBaseParams, getRpcCallback(responseListener, new VerifyCardPerception()));
    }

    public void getQuotaFence(Map map, ResponseListener<QuotaFenceInfo> responseListener) {
        Map<String, Object> createBaseParams = createBaseParams(this.f44032a);
        createBaseParams.putAll(map);
        this.f44038h.getQuotaFence(createBaseParams, getRpcCallback(responseListener, new QuotaFenceInfo()));
    }

    public void getTaxiCompanyList(Map map, ResponseListener<TaxiCompanyListModel> responseListener) {
        Map<String, Object> createBaseParams = createBaseParams(this.f44032a);
        createBaseParams.putAll(map);
        this.f44038h.getTaxiCompanyList(createBaseParams, getRpcCallback(responseListener, new TaxiCompanyListModel()));
    }
}
