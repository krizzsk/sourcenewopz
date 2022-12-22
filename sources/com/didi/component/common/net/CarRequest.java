package com.didi.component.common.net;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.android.didi.bfflib.Bff;
import com.android.didi.bfflib.IBffProxy;
import com.android.didi.bfflib.business.BffBaseObject;
import com.android.didi.bfflib.business.BffRequestUtil;
import com.android.didi.bfflib.business.BffResponseListener;
import com.didi.common.map.model.LatLng;
import com.didi.component.business.bff.callback_adapter.BffCommonCallbackAdapter;
import com.didi.component.business.bff.callback_adapter.BffTravelCallbackAdapter;
import com.didi.component.business.constant.BffConstants;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.util.BusinessDataUtil;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.GlobalApolloUtil;
import com.didi.component.business.util.NationComponentDataUtil;
import com.didi.component.business.util.Utils;
import com.didi.component.common.cache.CacheApolloUtils;
import com.didi.component.common.helper.ThreadPoolHelper;
import com.didi.component.common.model.CPFBlockingModel;
import com.didi.component.common.model.DrainageModel;
import com.didi.component.common.model.HomeNewCouponModel;
import com.didi.component.common.model.LoginEmailSuffixModel;
import com.didi.component.common.model.SafeToolkitBean;
import com.didi.component.common.util.LocationController;
import com.didi.component.comp_xpanel.XPanelScene;
import com.didi.component.company.select.view.GlobalCompanySelectActivity;
import com.didi.component.framework.pages.promo.helper.PromoCodeInterceptor;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.drouter.router.RouterCallback;
import com.didi.global.globalgenerickit.eventtracker.Const;
import com.didi.global.globaluikit.toast.LEGOToastHelper;
import com.didi.map.global.component.departure.DepartureConstants;
import com.didi.onehybrid.resource.offline.FusionContract;
import com.didi.safetoolkit.business.bubble.model.SfJarvisData;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.apm.utils.ApmThreadPool;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.map.LocationPerformer;
import com.didi.sdk.messagecenter.p152pb.Role;
import com.didi.sdk.misconfig.model.CarGrop;
import com.didi.sdk.misconfig.p153v2.ConfProxy;
import com.didi.sdk.misconfig.p153v2.SecondConfProxy;
import com.didi.sdk.misconfig.store.MisRequestParams;
import com.didi.sdk.nation.NationComponentData;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.store.FetchCallback;
import com.didi.sdk.util.Constant;
import com.didi.sdk.util.MD5;
import com.didi.sdk.util.SUUIDHelper;
import com.didi.sdk.util.SystemUtil;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.travel.psnger.TEBridge;
import com.didi.travel.psnger.TravelSDK;
import com.didi.travel.psnger.biz.waitornot.NearbyWaitRequest;
import com.didi.travel.psnger.common.net.DTSDKRequest;
import com.didi.travel.psnger.common.net.SpecialRequest;
import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didi.travel.psnger.common.net.base.GsonResponseListener;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didi.travel.psnger.common.net.base.ResponseListener;
import com.didi.travel.psnger.core.model.request.CancelTripParams;
import com.didi.travel.psnger.core.model.request.EstimateParams;
import com.didi.travel.psnger.core.model.request.OrderParams;
import com.didi.travel.psnger.core.order.OrderService;
import com.didi.travel.psnger.model.response.A3DeviceInfo;
import com.didi.travel.psnger.model.response.ActivityResInfo;
import com.didi.travel.psnger.model.response.CarCancelTrip;
import com.didi.travel.psnger.model.response.CarConfig;
import com.didi.travel.psnger.model.response.CarEvaluateQuestionData;
import com.didi.travel.psnger.model.response.CarHasEvaluateData;
import com.didi.travel.psnger.model.response.CarNoEvaluateData;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didi.travel.psnger.model.response.CarTipInfo;
import com.didi.travel.psnger.model.response.FixedPriceRouteData;
import com.didi.travel.psnger.model.response.IMOrNOSecurity;
import com.didi.travel.psnger.model.response.NearDrivers;
import com.didi.travel.psnger.model.response.PayMethodInfoResult;
import com.didi.travel.psnger.model.response.PayWayModel;
import com.didi.travel.psnger.model.response.PinCodeInfoResult;
import com.didi.travel.psnger.model.response.PrePayTipsModel;
import com.didi.travel.psnger.model.response.QuotaFenceInfo;
import com.didi.travel.psnger.model.response.TaxiCompanyListModel;
import com.didi.travel.psnger.model.response.UpdateDestModel;
import com.didi.travel.psnger.model.response.UpdateOrderInfoModel;
import com.didi.travel.psnger.model.response.VerifyCardPerception;
import com.didi.travel.psnger.model.response.WayPointModel;
import com.didi.travel.psnger.model.response.estimate.BubbleSelectResponse;
import com.didi.travel.psnger.utils.NumberUtil;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didi.unifylogin.country.CountryManager;
import com.didi.unifylogin.store.LoginStore;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.omega.sdk.Omega;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.didiglobal.p205sa.biz.component.ComponentType;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CarRequest {
    public static final String RESOURCE_NAME_G_PAS_SIGN_UP_BANNER = "g_pas_sign_up_banner";
    public static final String RESOURCE_NAME_PAS_REGISTERPAGE_TIP = "pas_registerpage_tip";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final Logger f11646a = LoggerFactory.getLogger((Class<?>) CarRequest.class);

    /* renamed from: b */
    private static final String f11647b = "_5";

    /* renamed from: c */
    private static final String f11648c = "2";

    /* renamed from: d */
    private static final String f11649d = "3";

    @Deprecated
    public static void doBubbleSelect(Context context, EstimateParams estimateParams, String str, String str2, JsonObject jsonObject, ResponseListener<BubbleSelectResponse> responseListener) {
        Map<String, Object> params = estimateParams.getParams();
        params.put(CarServerParam.PARAM_PRE_ESTIMATE_ID, str);
        params.put("estimate_trace_id", str2);
        if (jsonObject != null) {
            try {
                HashMap hashMap = (HashMap) new Gson().fromJson((JsonElement) jsonObject, new TypeToken<HashMap<String, Object>>() {
                }.getType());
                if (hashMap != null) {
                    params.putAll(hashMap);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        DTSDKRequest.getInstance(context).doBubbleSelect(params, responseListener);
    }

    public static void doBubbleSelectXEngineCommit(final Context context, Map<String, Object> map, JsonObject jsonObject, String str, String str2, final ResponseListener<String> responseListener) {
        if (map == null) {
            map = new HashMap<>();
        }
        if (jsonObject != null) {
            try {
                HashMap hashMap = (HashMap) new Gson().fromJson((JsonElement) jsonObject, new TypeToken<HashMap<String, Object>>() {
                }.getType());
                if (hashMap != null) {
                    map.putAll(hashMap);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        String queryParameter = Uri.parse(str).getQueryParameter("query");
        if (!TextUtils.isEmpty(queryParameter)) {
            try {
                String substring = str.substring(0, str.indexOf("?"));
                try {
                    HashMap hashMap2 = (HashMap) new Gson().fromJson(URLDecoder.decode(queryParameter, "UTF-8"), new TypeToken<HashMap<String, Object>>() {
                    }.getType());
                    if (hashMap2 != null) {
                        map.putAll(hashMap2);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                JSONObject jSONObject = new JSONObject(map);
                ((Request) DRouter.build(substring + "?query=" + URLEncoder.encode(jSONObject.toString(), "UTF-8")).putExtra("KEY_COMMIT_SCENE", str2)).start(context, new RouterCallback() {
                    public void onResult(Result result) {
                        JSONObject optJSONObject;
                        String string = result.getString("KEY_CALLBACK");
                        if (TextUtils.isEmpty(string)) {
                            CarRequest.f11646a.info("xengine commit failed", new Object[0]);
                            ResponseListener responseListener = ResponseListener.this;
                            if (responseListener != null) {
                                responseListener.onFinish("");
                                return;
                            }
                            return;
                        }
                        try {
                            JSONObject jSONObject = new JSONObject(string);
                            if (jSONObject.has("data")) {
                                JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
                                if (optJSONObject2.has("extension") && (optJSONObject = optJSONObject2.optJSONObject("extension")) != null) {
                                    if (optJSONObject.optInt("errno") != 0) {
                                        LEGOToastHelper.showToast(context, optJSONObject.optString("errmsg"));
                                        return;
                                    }
                                    JSONObject optJSONObject3 = optJSONObject.optJSONObject("data");
                                    if (optJSONObject3 != null) {
                                        String optString = optJSONObject3.optString("bubble_id", "");
                                        if (ResponseListener.this != null) {
                                            ResponseListener.this.onFinish(optString);
                                        }
                                    }
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            ResponseListener responseListener2 = ResponseListener.this;
                            if (responseListener2 != null) {
                                responseListener2.onFinish("");
                            }
                        }
                    }
                });
            } catch (Exception e3) {
                e3.printStackTrace();
                if (responseListener != null) {
                    responseListener.onFinish("");
                }
            }
        } else if (responseListener != null) {
            responseListener.onFinish("");
        }
    }

    public static void updateOrderBroadcast(Context context, ResponseListener<UpdateOrderInfoModel> responseListener) {
        HashMap hashMap = new HashMap();
        hashMap.put("token", NationComponentDataUtil.getToken());
        CarOrder order = CarOrderHelper.getOrder();
        hashMap.put("oid", order != null ? order.getOid() : "");
        TaxiCompanyListModel.CompanyModel curCompany = FormStore.getInstance().getCurCompany();
        if (curCompany != null && !"0".equalsIgnoreCase(curCompany.f44227id)) {
            hashMap.put("change_type", Integer.valueOf("1".equals(curCompany.f44227id) ? 2 : 1));
        }
        if (curCompany != null && !"1".equalsIgnoreCase(curCompany.f44227id) && !"0".equalsIgnoreCase(curCompany.f44227id)) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(curCompany.f44227id);
            hashMap.put("company_group_ids", jSONArray.toString());
        }
        NearbyWaitRequest.getInstance(context).updateCompanyOrderInfo(hashMap, responseListener);
    }

    public static void getConfig(Context context, int i, final ResponseListener<CarConfig> responseListener) {
        HashMap hashMap = new HashMap();
        put(hashMap, "version", Integer.valueOf(i));
        if (GlobalApolloUtil.isBffStageNewFifth()) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("version", Integer.valueOf(i));
            Bff.call(new IBffProxy.Ability.Builder(context, BffConstants.AbilityID.ABILITY_GET_CONFIG).setParams(hashMap2).setCallback(new RpcService.Callback<JsonObject>() {
                public void onSuccess(final JsonObject jsonObject) {
                    ApmThreadPool.execute((ApmThreadPool.IORunnable) new ApmThreadPool.IORunnable<CarConfig>() {
                        public CarConfig run() {
                            CarConfig carConfig = new CarConfig();
                            try {
                                carConfig.parse(new JSONObject(jsonObject.get("data").getAsJsonObject().toString()));
                                carConfig.errno = jsonObject.get("errno").getAsInt();
                                carConfig.errmsg = jsonObject.get("errmsg").getAsString();
                                return carConfig;
                            } catch (JSONException e) {
                                e.printStackTrace();
                            } catch (Throwable unused) {
                            }
                            return carConfig;
                        }

                        public void postRun(CarConfig carConfig) {
                            if (ResponseListener.this != null) {
                                if (carConfig == null || carConfig.errno != 0) {
                                    ResponseListener.this.onFail(carConfig);
                                } else {
                                    ResponseListener.this.onSuccess(carConfig);
                                }
                                ResponseListener.this.onFinish(carConfig);
                            }
                        }
                    });
                }

                public void onFailure(IOException iOException) {
                    ResponseListener responseListener = ResponseListener.this;
                    if (responseListener != null) {
                        responseListener.onError(null);
                        ResponseListener.this.onFinish(null);
                    }
                }
            }).build());
            return;
        }
        DTSDKRequest.getInstance(context.getApplicationContext()).getConfig(hashMap, responseListener);
    }

    public static void createOrder(Context context, OrderParams orderParams, ResponseListener<CarOrder> responseListener) {
        ((OrderService) TravelSDK.getService("order")).createOrder(context, orderParams, responseListener);
    }

    public static void cancelTrip(Context context, String str, int i, int i2, String str2, Map<String, Object> map, ResponseListener<CarCancelTrip> responseListener) {
        String str3 = LocationController.getInstance().getLng(context.getApplicationContext()) + "";
        String str4 = LocationController.getInstance().getLat(context.getApplicationContext()) + "";
        CancelTripParams cancelTripParams = new CancelTripParams();
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null) {
            cancelTripParams.setBusinessId(order.productid);
            cancelTripParams.setSubStatus(order.substatus);
        }
        cancelTripParams.setToken(m7874b());
        cancelTripParams.setOrderId(str);
        cancelTripParams.setLat(str4);
        cancelTripParams.setLng(str3);
        cancelTripParams.setContent(str2);
        cancelTripParams.setType(i2);
        cancelTripParams.setNativeCancel(i);
        if (map != null) {
            cancelTripParams.getParams().putAll(map);
        }
        ((OrderService) TravelSDK.getService("order")).cancelTrip(context, cancelTripParams, responseListener);
    }

    @Deprecated
    public static void getIMOrNOSecurityConfig(Context context, String str, ResponseListener<IMOrNOSecurity> responseListener) {
        HashMap hashMap = new HashMap();
        put(hashMap, "oid", str);
        put(hashMap, "im_type", "2");
        m7873a(context, hashMap, responseListener);
    }

    public static void getSecurityConfig(Context context, String str, ResponseListener<IMOrNOSecurity> responseListener) {
        HashMap hashMap = new HashMap();
        put(hashMap, "oid", str);
        put(hashMap, "im_type", "3");
        m7873a(context, hashMap, responseListener);
    }

    /* renamed from: a */
    private static void m7873a(Context context, Map<String, String> map, ResponseListener<IMOrNOSecurity> responseListener) {
        if (GlobalApolloUtil.isBffStageNewFifth()) {
            HashMap hashMap = new HashMap();
            hashMap.put("oid", map.get("oid"));
            hashMap.put("im_type", Integer.valueOf(NumberUtil.strToInt(map.get("im_type"))));
            Bff.callImmediately(new IBffProxy.Ability.Builder(context, BffConstants.AbilityID.ABILITY_GET_PANEL_CONFIG).setParams(hashMap).setCallback(new BffCommonCallbackAdapter(responseListener, context)).build());
            return;
        }
        DTSDKRequest.getInstance(context).getIMOrNOSecurityConfig(map, responseListener);
    }

    public static void getCommentFlag(Context context, String str, ResponseListener<CarNoEvaluateData> responseListener) {
        HashMap hashMap = new HashMap();
        put(hashMap, "oid", str);
        Bff.call(new IBffProxy.Ability.Builder(context, BffConstants.AbilityID.ABILITY_GET_COMMENTTAG).setParams(hashMap).setCallback(new BffTravelCallbackAdapter(responseListener, context)).build());
    }

    public static void getEvaluateQuestionData(Context context, String str, ResponseListener<CarEvaluateQuestionData> responseListener) {
        HashMap hashMap = new HashMap();
        put(hashMap, "oid", str);
        Bff.call(new IBffProxy.Ability.Builder(context, BffConstants.AbilityID.ABILITY_GET_QUESTIONAIRE).setParams(hashMap).setCallback(new BffTravelCallbackAdapter(responseListener, context, true)).build());
    }

    public static void getCommentData(Context context, String str, ResponseListener<CarHasEvaluateData> responseListener) {
        HashMap hashMap = new HashMap();
        put(hashMap, "oid", str);
        Bff.call(new IBffProxy.Ability.Builder(context, BffConstants.AbilityID.ABILITY_HAS_COMMENTED).setParams(hashMap).setCallback(new BffTravelCallbackAdapter(responseListener, context)).build());
    }

    public static void prePayTips(Context context, String str, String str2, ResponseListener<PrePayTipsModel> responseListener) {
        double d;
        HashMap hashMap = new HashMap();
        hashMap.put("oid", str);
        try {
            d = Double.parseDouble(str2);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            d = 0.0d;
        }
        hashMap.put(CarServerParam.PARAM_FEE, Double.valueOf(d));
        hashMap.put(CarServerParam.PARAM_FEE_TYPE, 2);
        NationComponentData nationComponentData = NationTypeUtil.getNationComponentData();
        if (nationComponentData != null) {
            hashMap.put("trip_country", nationComponentData.getLocCountry());
            hashMap.put("trip_cityid", Integer.valueOf(NumberUtil.strToInt(nationComponentData.getCityId())));
        }
        Bff.call(new IBffProxy.Ability.Builder(context, BffConstants.AbilityID.ABILITY_PRE_PAY_TIPS).setParams(hashMap).setCallback(new BffTravelCallbackAdapter(responseListener, context)).build());
    }

    public static void doComment(Context context, String str, int i, String str2, String str3, ResponseListener<CarHasEvaluateData> responseListener) {
        HashMap hashMap = new HashMap();
        hashMap.put("oid", str);
        hashMap.put("level", Integer.valueOf(i));
        hashMap.put("type", str2);
        hashMap.put("content", str3);
        Bff.call(new IBffProxy.Ability.Builder(context, BffConstants.AbilityID.ABILITY_COMMENT).setParams(hashMap).setCallback(new BffTravelCallbackAdapter(responseListener, context)).build());
    }

    public static void commitEvaluateQuestionData(Context context, String str, int i, int i2, String str2, String str3, String str4, int i3, ResponseListener<CarEvaluateQuestionData> responseListener) {
        HashMap hashMap = new HashMap();
        if (TextUtils.isEmpty(str)) {
            str = CarOrderHelper.getOrder() == null ? null : CarOrderHelper.getOrder().oid;
        }
        hashMap.put("oid", str);
        hashMap.put("question_id", Integer.valueOf(i));
        hashMap.put("answer", str3);
        hashMap.put("caller", str4);
        hashMap.put("index", Integer.valueOf(i3));
        if (CarOrderHelper.isOnService()) {
            hashMap.put("business_scene", XPanelScene.SCENE_TRIP);
        }
        Bff.call(new IBffProxy.Ability.Builder(context, BffConstants.AbilityID.ABILITY_SUBMIT_QUESTIONAIRE).setParams(hashMap).setCallback(new BffTravelCallbackAdapter(responseListener, context, true)).build());
    }

    public static void doGetTipInfo(Context context, String str, ResponseListener<CarTipInfo> responseListener) {
        HashMap hashMap = new HashMap();
        hashMap.put("oid", str);
        StringBuilder sb = new StringBuilder();
        sb.append("test");
        sb.append(MD5.toMD5(SUUIDHelper.getDiDiSUUID() + Constant.SIGN_KEY).toLowerCase());
        hashMap.put("cancel", sb.toString());
        NationComponentData nationComponentData = NationTypeUtil.getNationComponentData();
        if (nationComponentData != null) {
            hashMap.put("trip_country", nationComponentData.getLocCountry());
            hashMap.put("trip_cityid", Integer.valueOf(NumberUtil.strToInt(nationComponentData.getCityId())));
        }
        Bff.call(new IBffProxy.Ability.Builder(context, BffConstants.AbilityID.ABILITY_GET_TIPINFO).setParams(hashMap).setCallback(new BffTravelCallbackAdapter(responseListener, context)).build());
    }

    /* renamed from: b */
    private static String m7874b() {
        return NationComponentDataUtil.getToken();
    }

    protected static void put(Map map, String str, Object obj) {
        String valueOf = String.valueOf(obj);
        if (TextUtil.isEmpty(valueOf)) {
            map.put(str, "");
        } else {
            map.put(str, valueOf.trim());
        }
    }

    protected static void putInteger(Map map, String str, Object obj) {
        if (obj instanceof Integer) {
            map.put(str, Integer.valueOf(Integer.parseInt(String.valueOf(obj))));
        } else {
            put(map, str, obj);
        }
    }

    public static void sendMsgCallDriverLocation(Context context, int i, String str, LatLng latLng, LatLng latLng2, int i2, int i3, List<Long> list, List<LatLng> list2, boolean z, GsonResponseListener<NearDrivers> gsonResponseListener) {
        int i4 = i;
        LatLng latLng3 = latLng;
        LatLng latLng4 = latLng2;
        int i5 = i2;
        List<Long> list3 = list;
        List<LatLng> list4 = list2;
        Logger logger = f11646a;
        logger.info("sendMsgCallDriverLocation channel " + i + "  -----  type: " + i5, new Object[0]);
        HashMap hashMap = new HashMap();
        String phone = NationComponentDataUtil.getPhone();
        if (!TextUtil.isEmpty(phone)) {
            put(hashMap, "phone_num", phone + "_5");
        }
        put(hashMap, "role", Integer.valueOf(Role.Passenger.getValue()));
        put(hashMap, "token", m7874b());
        if (latLng3 != null) {
            put(hashMap, "lat", Double.valueOf(latLng3.latitude));
            put(hashMap, "lng", Double.valueOf(latLng3.longitude));
        }
        if (latLng4 != null) {
            put(hashMap, "tlat", Double.valueOf(latLng4.latitude));
            put(hashMap, "tlng", Double.valueOf(latLng4.longitude));
        }
        if (list4 != null && list2.size() > 0) {
            put(hashMap, "passLocPoints", "[\"" + list4.get(0).latitude + "|" + list4.get(0).longitude + "\"]");
        }
        if (list3 != null && list.size() > 0) {
            put(hashMap, "diverIds", list3.get(0));
        }
        put(hashMap, "is_eta", Integer.valueOf(z ^ true ? 1 : 0));
        put(hashMap, "product_id", Integer.valueOf(i));
        put(hashMap, "type", Integer.valueOf(i2));
        put(hashMap, "order_stat", Integer.valueOf(i3));
        put(hashMap, "timestamp", Long.valueOf(System.currentTimeMillis()));
        put(hashMap, "platform", 1);
        put(hashMap, "ostype", 2);
        put(hashMap, "coord_type", Integer.valueOf(NationComponentDataUtil.getMapTypeIntForApi()));
        String str2 = str;
        put(hashMap, "sdkmaptype", str);
        Logger logger2 = f11646a;
        logger2.info("sendLocationCallNearDrivers channel " + i + "  -----  type: " + i5, new Object[0]);
        SpecialRequest.getInstance(context).sendOnServiceNearDrivers(hashMap, gsonResponseListener);
    }

    public static void getMisConfigFromNet(double d, double d2, int i, FetchCallback<List<CarGrop>> fetchCallback) {
        MisRequestParams misRequestParams = new MisRequestParams();
        misRequestParams.lat = d;
        misRequestParams.lng = d2;
        misRequestParams.cityId = i;
        misRequestParams.callback = fetchCallback;
        ConfProxy.getInstance().getConfigFromNet(misRequestParams);
    }

    public static void getMisConfigFromNet(double d, double d2, int i) {
        SecondConfProxy.getInstance().getSecConfigFromNet(d2, d, i);
    }

    public static void getEndServiceShareInfo(Context context, String str, ResponseListener responseListener) {
        HashMap hashMap = new HashMap();
        hashMap.put("order_id", str);
        NationComponentData nationComponentData = NationTypeUtil.getNationComponentData();
        if (nationComponentData != null) {
            hashMap.put("trip_country", nationComponentData.getLocCountry());
            hashMap.put("trip_cityid", Integer.valueOf(NumberUtil.strToInt(nationComponentData.getCityId())));
        }
        Bff.call(new IBffProxy.Ability.Builder(context, BffConstants.AbilityID.ABILITY_GET_SHAREINFO).setParams(hashMap).setCallback(new BffTravelCallbackAdapter(responseListener, context, "share_coupon")).build());
    }

    public static void updateDest(Context context, String str, Address address, ResponseListener<UpdateDestModel> responseListener) {
        HashMap hashMap = new HashMap();
        put(hashMap, "oid", str);
        put(hashMap, "toName", address.displayName);
        put(hashMap, "toAddress", address.address);
        put(hashMap, ParamKeys.PARAM_TO_ADDRESS_ALL, address.fullName);
        put(hashMap, "tlat", Double.valueOf(address.latitude));
        put(hashMap, "tlng", Double.valueOf(address.longitude));
        put(hashMap, ParamKeys.PARAM_TO_POI_UID, address.uid);
        DTSDKRequest.getInstance(context).updateDestination(hashMap, responseListener);
    }

    public static void updateWayPoints(Context context, String str, Address address, String str2, String str3, boolean z, Map<String, Object> map, ResponseListener<WayPointModel> responseListener) {
        HashMap hashMap = new HashMap();
        put(hashMap, "oid", str);
        if (address != null) {
            put(hashMap, "toName", address.displayName);
            put(hashMap, "toAddress", address.address);
            put(hashMap, ParamKeys.PARAM_TO_ADDRESS_ALL, m7872a(address));
            put(hashMap, "tlat", Double.valueOf(address.latitude));
            put(hashMap, "tlng", Double.valueOf(address.longitude));
            put(hashMap, ParamKeys.PARAM_TO_POI_UID, address.uid);
            put(hashMap, ParamKeys.PARAM_TO_ADDRESS_VAGUE_NAME, address.hideAddress);
        }
        if (!TextUtils.isEmpty(str2)) {
            put(hashMap, ParamKeys.PARAM_WAY_POINTS, str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            put(hashMap, ParamKeys.PARAM_WAY_POINTS_VERSION, str3);
        }
        putInteger(hashMap, ParamKeys.PARAM_IS_PRE, Integer.valueOf(z ? 1 : 0));
        if (!CollectionUtil.isEmpty((Map<?, ?>) map)) {
            for (String next : map.keySet()) {
                hashMap.put(next, map.get(next));
            }
        }
        DIDILocation didiLocation = NationTypeUtil.getNationComponentData().getDidiLocation();
        if (didiLocation == null || (didiLocation.getLatitude() == 0.0d && didiLocation.getLongitude() == 0.0d)) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("request", BffConstants.AbilityID.ABILITY_UPDATE_WAY_POINTS);
            hashMap2.put("err_no", Integer.valueOf(LocationPerformer.getInstance().getLastErrNo()));
            OmegaSDKAdapter.trackEvent("tech_pax_request_loc_permission", (Map<String, Object>) hashMap2);
        }
        Bff.call(new IBffProxy.Ability.Builder(context, BffConstants.AbilityID.ABILITY_UPDATE_WAY_POINTS).setParams(hashMap).setCallback(new BffTravelCallbackAdapter(responseListener, context)).build());
    }

    /* renamed from: a */
    private static String m7872a(Address address) {
        if (!TextUtils.isEmpty(address.fullName)) {
            return address.fullName;
        }
        if (TextUtils.isEmpty(address.displayName)) {
            return address.address;
        }
        return address.displayName + "-" + address.address;
    }

    public static void checkOpenRide(Context context, int i, int i2, int i3, ResponseListener<PayMethodInfoResult> responseListener) {
        HashMap hashMap = new HashMap();
        put(hashMap, CarServerParam.PARAM_CHECK_PAY_TYPE, Integer.valueOf(i));
        put(hashMap, "order_type", Integer.valueOf(i2));
        put(hashMap, "user_type", Integer.valueOf(i3));
        DTSDKRequest.getInstance(context).checkOpenRide(hashMap, responseListener);
    }

    public static void confirmPinCode(Context context, int i, ResponseListener<PinCodeInfoResult> responseListener) {
        HashMap hashMap = new HashMap();
        put(hashMap, CarServerParam.PARAM_PIN_CODE, Integer.valueOf(i));
        DTSDKRequest.getInstance(context).confirmPinCode(hashMap, responseListener);
    }

    public static void notifyDriverStateOfPsg(Context context, int i, String str, ResponseListener<BaseObject> responseListener) {
        HashMap hashMap = new HashMap();
        put(hashMap, "msg_type", Integer.valueOf(i));
        put(hashMap, CarServerParam.PARAM_DRIVER_ID, str);
        DTSDKRequest.getInstance(context).notifyDriverStateOfPsg(hashMap, responseListener);
    }

    public static void updatePickUp(Context context, String str, Address address, ResponseListener<BaseObject> responseListener) {
        HashMap hashMap = new HashMap();
        put(hashMap, "oid", str);
        put(hashMap, "from_name", address.displayName);
        put(hashMap, "from_address", address.address);
        put(hashMap, ParamKeys.PARAM_FROM_ADDRESS_ALL_V2, address.fullName);
        put(hashMap, "from_lat", Double.valueOf(address.latitude));
        put(hashMap, "from_lng", Double.valueOf(address.longitude));
        put(hashMap, "from_poi_id", address.uid);
        put(hashMap, DepartureConstants.SRCTAG, address.srcTag);
        Bff.call(new IBffProxy.Ability.Builder(context, BffConstants.AbilityID.ABILITY_UPDATE_BOARDING_POINT).setParams(hashMap).setCallback(new BffTravelCallbackAdapter(responseListener, context)).build());
    }

    public static void getDeviceInfo(Context context, final ResponseListener<A3DeviceInfo> responseListener) {
        Context applicationContext = context.getApplicationContext();
        HashMap hashMap = new HashMap();
        hashMap.put("datatype", "1");
        hashMap.put("imsi", SystemUtil.getIMSI());
        hashMap.put("imei", SystemUtil.getIMEI());
        hashMap.put("model", SystemUtil.getModel());
        hashMap.put("os", Build.VERSION.RELEASE);
        if (TEBridge.clientConfig() != null) {
            hashMap.put("idfa", TEBridge.clientConfig().idfa());
        }
        hashMap.put(ParamKeys.PARAM_SDCARD_ID, Utils.getSDCardId());
        hashMap.put(ParamKeys.PARAM_ICCID, Utils.getSimSerialNumber(applicationContext));
        hashMap.put(ParamKeys.PARAM_CPU_INFO, SystemUtil.getCPUSerialno());
        Bff.call(new IBffProxy.Ability.Builder(context, BffConstants.AbilityID.ABILITY_GET_A3_ID).setParams(hashMap).setCallback(new RpcService.Callback<JsonObject>() {
            /* JADX INFO: finally extract failed */
            public void onSuccess(JsonObject jsonObject) {
                A3DeviceInfo a3DeviceInfo = new A3DeviceInfo();
                try {
                    a3DeviceInfo.errno = jsonObject.get("errno").getAsInt();
                    a3DeviceInfo.errmsg = jsonObject.get("errmsg").getAsString();
                    if (ResponseListener.this != null) {
                        if (a3DeviceInfo.errno == 0) {
                            a3DeviceInfo.setData(jsonObject.get("data").getAsJsonObject().get("data").getAsString());
                            ResponseListener.this.onSuccess(a3DeviceInfo);
                        } else {
                            ResponseListener.this.onFail(a3DeviceInfo);
                        }
                    }
                    ResponseListener responseListener = ResponseListener.this;
                    if (responseListener != null) {
                        responseListener.onFinish(a3DeviceInfo);
                    }
                } catch (Throwable th) {
                    ResponseListener responseListener2 = ResponseListener.this;
                    if (responseListener2 != null) {
                        responseListener2.onFinish(a3DeviceInfo);
                    }
                    throw th;
                }
            }

            public void onFailure(IOException iOException) {
                ResponseListener responseListener = ResponseListener.this;
                if (responseListener != null) {
                    responseListener.onError(null);
                    ResponseListener.this.onFinish(null);
                }
            }
        }).build());
    }

    public static void verifyCard(Context context, Map map, ResponseListener<VerifyCardPerception> responseListener) {
        DTSDKRequest.getInstance(context).verifyCard(map, responseListener);
    }

    public static void getQuotaFence(Context context, Address address, final ResponseListener<QuotaFenceInfo> responseListener) {
        HashMap hashMap = new HashMap();
        hashMap.put("scene_type", 1);
        Bff.call(new IBffProxy.Ability.Builder(context, BffConstants.AbilityID.ABILITY_GET_FENCE_INFO).setParams(hashMap).setCallback(new RpcService.Callback<JsonObject>() {
            /* JADX INFO: finally extract failed */
            public void onSuccess(JsonObject jsonObject) {
                QuotaFenceInfo quotaFenceInfo = new QuotaFenceInfo();
                try {
                    quotaFenceInfo.errno = jsonObject.get("errno").getAsInt();
                    quotaFenceInfo.errmsg = jsonObject.get("errmsg").getAsString();
                    quotaFenceInfo.parse(jsonObject.toString());
                    if (ResponseListener.this != null) {
                        if (quotaFenceInfo.errno == 0) {
                            ResponseListener.this.onSuccess(quotaFenceInfo);
                        } else {
                            ResponseListener.this.onFail(quotaFenceInfo);
                        }
                    }
                    ResponseListener responseListener = ResponseListener.this;
                    if (responseListener != null) {
                        responseListener.onFinish(quotaFenceInfo);
                    }
                } catch (Throwable th) {
                    ResponseListener responseListener2 = ResponseListener.this;
                    if (responseListener2 != null) {
                        responseListener2.onFinish(quotaFenceInfo);
                    }
                    throw th;
                }
            }

            public void onFailure(IOException iOException) {
                ResponseListener.this.onError(new QuotaFenceInfo());
                ResponseListener.this.onFinish(new QuotaFenceInfo());
            }
        }).build());
    }

    public static void getActivityRes(Context context, String str, ResponseListener<ActivityResInfo> responseListener) {
        HashMap hashMap = new HashMap();
        hashMap.put(FusionContract.OfflineBundle.COLUMN_NAME_RESOURCE_NAME, str);
        hashMap.put("city_id", NationComponentDataUtil.getLocCityId());
        SpecialRequest.getInstance(context).getActivityRes(hashMap, responseListener);
    }

    public static void getTaxiCompanyListInfo(Context context, double d, double d2, ResponseListener<TaxiCompanyListModel> responseListener) {
        HashMap hashMap = new HashMap();
        put(hashMap, GlobalCompanySelectActivity.DATA_EXTRA_START_LAT, Double.valueOf(d));
        put(hashMap, GlobalCompanySelectActivity.DATA_EXTRA_START_LNG, Double.valueOf(d2));
        put(hashMap, "car_level", Integer.valueOf(FormStore.getInstance().getCarLevel()));
        if (FormStore.getInstance().getTransportTime() > 0) {
            put(hashMap, "order_type", 1);
            put(hashMap, "reserve_time", Long.valueOf(FormStore.getInstance().getTransportTime() / 1000));
        } else {
            put(hashMap, "order_type", 0);
        }
        List<PayWayModel.PayWayItem> payWaySelectedItem = FormStore.getInstance().getPayWaySelectedItem();
        if (!CollectionUtil.isEmpty((Collection<?>) payWaySelectedItem)) {
            PayWayModel.PayWayItem payWayItem = payWaySelectedItem.get(0);
            put(hashMap, "choose_pay", payWayItem != null ? String.valueOf(payWayItem.tag) : "");
        }
        Bff.call(new IBffProxy.Ability.Builder(context, BffConstants.AbilityID.ABILITY_GETCOMPANYGROUP).setParams(hashMap).setCallback(new BffTravelCallbackAdapter(responseListener, context)).build());
    }

    public static void fetchHomeCoupon(Context context, String str, ResponseListener<HomeNewCouponModel> responseListener) {
        HashMap hashMap = new HashMap();
        hashMap.put(ParamConst.PARAM_COUPON_TYPE, "0");
        hashMap.put("is_first_login", Integer.valueOf(OneLoginFacade.getStore().isNewUser() ? 1 : 0));
        Bff.call(new IBffProxy.Ability.Builder(context, BffConstants.AbilityID.ABILITY_COUPON_DISPLAY).setParams(hashMap).setCallback(new BffTravelCallbackAdapter(responseListener, context)).setServiceId(str).build());
    }

    public static void fetchDrainage(Context context, String str, ResponseListener<DrainageModel> responseListener) {
        HashMap hashMap = new HashMap();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("scene", "home");
            jSONObject.put("biz_param", new JSONObject());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        hashMap.put(ComponentType.COMPONENT_DRAINAGE_GUIDE, jSONObject);
        Bff.call(new IBffProxy.Ability.Builder(context, BffConstants.AbilityID.ABILITY_DRAINAGE_COVER).setParams(hashMap).setCallback(new BffTravelCallbackAdapter(responseListener, context)).setServiceId(str).build());
    }

    public static Object fetchRouteId(Context context, Address address, Address address2, ResponseListener<FixedPriceRouteData> responseListener) {
        HashMap hashMap = new HashMap();
        if (address != null) {
            hashMap.put(GlobalCompanySelectActivity.DATA_EXTRA_START_LAT, Double.valueOf(address.latitude));
            hashMap.put(GlobalCompanySelectActivity.DATA_EXTRA_START_LNG, Double.valueOf(address.longitude));
        }
        if (address2 != null) {
            hashMap.put("end_lat", Double.valueOf(address2.latitude));
            hashMap.put("end_lng", Double.valueOf(address2.longitude));
        }
        hashMap.put("product_id", BusinessDataUtil.getProductId());
        return SpecialRequest.getInstance(context).getMapRouteInfo(hashMap, responseListener);
    }

    public static void getNewGuidInfo(Context context, int i, int i2, int i3, int i4, int i5, int i6, RpcService.Callback<JsonObject> callback) {
        HashMap hashMap = new HashMap();
        hashMap.put("business_id", Integer.valueOf(i));
        hashMap.put("car_level", Integer.valueOf(i2));
        hashMap.put("city_id", Integer.valueOf(i3));
        hashMap.put("country_id", Integer.valueOf(i4));
        hashMap.put("combo_type", Integer.valueOf(i5));
        hashMap.put("origin", Integer.valueOf(i6));
        Bff.call(new IBffProxy.Ability.Builder(context, BffConstants.AbilityID.ABILITY_NEW_GUIDE_SHOW).setParams(hashMap).setCallback(callback).build());
    }

    public static void getFeeDetails(Context context, RpcService.Callback<JsonObject> callback) {
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("oid", order.getOid());
            hashMap.put("nginx_cors", false);
            Bff.call(new IBffProxy.Ability.Builder(context, BffConstants.AbilityID.ABILITY_FEE_DETAILS).setParams(hashMap).setCallback(callback).build());
        }
    }

    public static void getPromoCodeRsp(Context context, RpcService.Callback<JsonObject> callback, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(PromoCodeInterceptor.PROMO_CODE, str);
        Bff.call(new IBffProxy.Ability.Builder(context, BffConstants.AbilityID.ABILITY_PROMO_CODE).setParams(hashMap).setCallback(callback).build());
    }

    public static void getInvitationInfo(Context context, RpcService.Callback<JsonObject> callback, long j) {
        HashMap hashMap = new HashMap();
        hashMap.put("resourceChannel", Long.valueOf(j));
        Bff.call(new IBffProxy.Ability.Builder(context, BffConstants.AbilityID.ABILITY_INVITE_PAGE).setParams(hashMap).setCallback(callback).build());
    }

    public static void getInvitationList(Context context, RpcService.Callback<JsonObject> callback, long j, long j2) {
        HashMap hashMap = new HashMap();
        hashMap.put("pageNo", Long.valueOf(j));
        hashMap.put("pageSize", Long.valueOf(j2));
        Bff.call(new IBffProxy.Ability.Builder(context, BffConstants.AbilityID.ABILITY_INVITE_LIST).setParams(hashMap).setCallback(callback).build());
    }

    public static void checkContractIsOrInvite(Context context, List<String> list, int i, RpcService.Callback<JsonObject> callback) {
        HashMap hashMap = new HashMap();
        hashMap.put("phoneList", list);
        hashMap.put("needCheck", Integer.valueOf(i));
        Bff.call(new IBffProxy.Ability.Builder(context, BffConstants.AbilityID.ABILITY_CHECK_VALIDFRIENDLIST).setParams(hashMap).setCallback(callback).build());
    }

    public static void getCarCheckResult(Context context, String str, ResponseListener<CarEvaluateQuestionData> responseListener) {
        HashMap hashMap = new HashMap();
        hashMap.put("oid", str);
        hashMap.put("source", 1);
        Bff.call(new IBffProxy.Ability.Builder(context, BffConstants.AbilityID.ABILITY_GET_QUESTIONAIRE).setParams(hashMap).setCallback(new BffTravelCallbackAdapter(responseListener, context, true)).build());
    }

    public static void commitCarCheckResult(Context context, String str, int i, String str2, ResponseListener<CarEvaluateQuestionData> responseListener) {
        HashMap hashMap = new HashMap();
        hashMap.put("oid", str);
        hashMap.put("question_id", Integer.valueOf(i));
        hashMap.put("answer", str2);
        Bff.call(new IBffProxy.Ability.Builder(context, BffConstants.AbilityID.ABILITY_SUBMIT_QUESTIONAIRE).setParams(hashMap).setCallback(new BffTravelCallbackAdapter(responseListener, context, true)).build());
    }

    public static void unMatch(Context context, String str, RpcService.Callback<JsonObject> callback) {
        HashMap hashMap = new HashMap();
        hashMap.put("oid", str);
        hashMap.put("type", 2);
        Bff.call(new IBffProxy.Ability.Builder(context, BffConstants.AbilityID.ABILITY_UNMATCH).setParams(hashMap).setCallback(callback).build());
    }

    public static void getLoginEmailSuffixApollo(Context context, ResponseListener<LoginEmailSuffixModel> responseListener) {
        HashMap hashMap = new HashMap();
        hashMap.put("oid", Omega.getOmegaIdSafety());
        hashMap.put("pid", Long.valueOf(NationComponentDataUtil.getUid()));
        hashMap.put("location_country", NationComponentDataUtil.getLocCountry());
        Bff.call(new IBffProxy.Ability.Builder(context, BffConstants.AbilityID.ABILITY_EMAIL_SUFFIX).setParams(hashMap).setCallback(new BffTravelCallbackAdapter(responseListener, context)).build());
    }

    public static void getCPFBlockingSuffixApollo(final Context context, final ResponseListener<CPFBlockingModel> responseListener) {
        ThreadPoolHelper.getInstance().execute(new Runnable() {
            public void run() {
                String omegaIdSafety = Omega.getOmegaIdSafety();
                final HashMap hashMap = new HashMap();
                hashMap.put("omega_id", omegaIdSafety);
                hashMap.put("user_id", Long.valueOf(NationComponentDataUtil.getUid()));
                hashMap.put("location_country", NationComponentDataUtil.getLocCountry());
                UiThreadHandler.post(new Runnable() {
                    public void run() {
                        Bff.call(new IBffProxy.Ability.Builder(context, BffConstants.AbilityID.ABILITY_NEW_CPF_BLOCKING).setParams(hashMap).setCallback(new BffTravelCallbackAdapter(new ResponseListener<CPFBlockingModel>() {
                            public void onSuccess(CPFBlockingModel cPFBlockingModel) {
                                if (responseListener != null) {
                                    responseListener.onSuccess(cPFBlockingModel);
                                }
                                if (cPFBlockingModel == null) {
                                    CacheApolloUtils.setNewCPUBlockingOpen(-1);
                                } else if (cPFBlockingModel.is_allow && TextUtils.equals(cPFBlockingModel.pid_group_name, "treatment_group_1")) {
                                    CacheApolloUtils.setNewCPUBlockingOpen(1);
                                } else if (!cPFBlockingModel.is_allow || !TextUtils.equals(cPFBlockingModel.pid_group_name, "treatment_group_2")) {
                                    CacheApolloUtils.setNewCPUBlockingOpen(0);
                                } else {
                                    CacheApolloUtils.setNewCPUBlockingOpen(2);
                                }
                            }
                        }, context)).build());
                    }
                });
            }
        });
    }

    public static void getCPFBlockingSuffixApolloV2(Context context, final ResponseListener<CPFBlockingModel> responseListener) {
        HashMap hashMap = new HashMap();
        hashMap.put("omega_id", Omega.getOmegaIdSafety());
        hashMap.put("user_id", Long.valueOf(NationComponentDataUtil.getUid()));
        hashMap.put("location_country", NationComponentDataUtil.getLocCountry());
        hashMap.put("city_id", Integer.valueOf(Integer.parseInt(NationComponentDataUtil.getLocCityId())));
        if (NationComponentDataUtil.isLoginNow()) {
            hashMap.put("phone", NationComponentDataUtil.getPhoneCountryCode() + NationComponentDataUtil.getPhone());
        } else {
            hashMap.put("phone", CountryManager.getIns().getCurrentCountryCode() + LoginStore.getInstance().getPhone());
        }
        Bff.call(new IBffProxy.Ability.Builder(context, BffConstants.AbilityID.ABILITY_NEW_CPF_BLOCKING_V2).setParams(hashMap).setCallback(new BffTravelCallbackAdapter(new ResponseListener<CPFBlockingModel>() {
            public void onFinish(CPFBlockingModel cPFBlockingModel) {
                if (cPFBlockingModel == null) {
                    CacheApolloUtils.setCPFBlockingTypeV2(0);
                } else if (cPFBlockingModel.is_allow && TextUtils.equals(cPFBlockingModel.pid_group_name, "treatment_group_1")) {
                    CacheApolloUtils.setCPFBlockingTypeV2(1);
                } else if (cPFBlockingModel.is_allow && TextUtils.equals(cPFBlockingModel.pid_group_name, "treatment_group_2")) {
                    CacheApolloUtils.setCPFBlockingTypeV2(2);
                } else if (!cPFBlockingModel.is_allow || !TextUtils.equals(cPFBlockingModel.pid_group_name, "treatment_group_3")) {
                    CacheApolloUtils.setCPFBlockingTypeV2(0);
                } else {
                    CacheApolloUtils.setCPFBlockingTypeV2(3);
                }
                if (ResponseListener.this == null) {
                    return;
                }
                if (cPFBlockingModel == null || !cPFBlockingModel.isAvailable()) {
                    ResponseListener.this.onFail(cPFBlockingModel);
                } else {
                    ResponseListener.this.onSuccess(cPFBlockingModel);
                }
            }
        }, context)).build());
    }

    public static void getSaveAddressCardInfo(Context context, RpcService.Callback<JsonObject> callback) {
        HashMap hashMap = new HashMap();
        hashMap.put("omega_id", Omega.getOmegaIdSafety());
        hashMap.put("user_id", Long.valueOf(NationComponentDataUtil.getUid()));
        hashMap.put("location_country", NationComponentDataUtil.getLocCountry());
        Bff.call(new IBffProxy.Ability.Builder(context, BffConstants.AbilityID.ABILITY_SAVE_ADDRESS).setParams(hashMap).setCallback(callback).build());
    }

    public static void getCashUnpaySign(Context context, int i, String str, String str2, int i2, ResponseListener<PrePayTipsModel> responseListener) {
        HashMap hashMap = new HashMap();
        hashMap.put("source", Integer.valueOf(i));
        hashMap.put("caller", str);
        hashMap.put("oid", str2);
        hashMap.put(CarServerParam.PARAM_FEE, Integer.valueOf(i2));
        Bff.call(new IBffProxy.Ability.Builder(context, BffConstants.AbilityID.ABILITY_CASH_UNPAY_GET_SIGN).setParams(hashMap).setCallback(new BffTravelCallbackAdapter(responseListener, context)).build());
    }

    public static void reportCashUnpay(Context context, String str, String str2, int i, RpcService.Callback<JsonObject> callback) {
        HashMap hashMap = new HashMap();
        hashMap.put("caller", str);
        hashMap.put("oid", str2);
        hashMap.put(Const.BUTTON_ID, Integer.valueOf(i));
        Bff.call(new IBffProxy.Ability.Builder(context, BffConstants.AbilityID.ABILITY_CASH_UNPAY_CHOOSE_REPORT).setParams(hashMap).setCallback(callback).build());
    }

    public static void getSafetoolkitStatus(Context context, int i, int i2, boolean z, int i3, ResponseListener<SafeToolkitBean> responseListener) {
        HashMap hashMap = new HashMap();
        hashMap.put("new_guidecnt", Integer.valueOf(i));
        hashMap.put("add_contactcnt", Integer.valueOf(i2));
        hashMap.put("is_oasis_driver", Integer.valueOf(z ? 1 : 0));
        hashMap.put("page", Integer.valueOf(i3));
        Bff.call(new IBffProxy.Ability.Builder(context, BffConstants.AbilityID.ABILITY_SAFETOOLKIT_STATUS).setParams(hashMap).setCallback(new BffTravelCallbackAdapter(responseListener, context)).build());
    }

    public static void getJarvisStatus(Context context, String str, String str2, int i, String str3, String str4, int i2, int i3, BffResponseListener<SfJarvisData> bffResponseListener) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("oid", str);
            hashMap.put("product", str2);
        }
        hashMap.put("is_oasis_driver", Integer.valueOf(i));
        hashMap.put("page", str3);
        hashMap.put("data_version", str4);
        hashMap.put("in_recording", Integer.valueOf(i2));
        hashMap.put("open_manual_record", Integer.valueOf(i3));
        BffRequestUtil.request(context, BffConstants.AbilityID.ABILITY_JARVIS_STATUS, hashMap, bffResponseListener);
    }

    public static void getFareDoubtUrl(Context context, String str, String str2, RpcService.Callback<JsonObject> callback) {
        HashMap hashMap = new HashMap();
        hashMap.put("orderId", str);
        hashMap.put("tag", str2);
        Bff.call(new IBffProxy.Ability.Builder(context, BffConstants.AbilityID.ABILITY_FARE_DOUBT_URL).setParams(hashMap).setCallback(callback).build());
    }

    public static void tripBuy(Context context, String str, String str2, int i, int i2, BffResponseListener<BffBaseObject> bffResponseListener) {
        HashMap hashMap = new HashMap();
        hashMap.put("estimateId", str);
        hashMap.put("packageId", str2);
        hashMap.put("type", Integer.valueOf(i));
        hashMap.put("requestSource", Integer.valueOf(i2));
        BffRequestUtil.request(context, BffConstants.AbilityID.ABLITY_TRIP_BUY, hashMap, bffResponseListener);
    }
}
