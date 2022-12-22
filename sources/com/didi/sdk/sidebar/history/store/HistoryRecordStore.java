package com.didi.sdk.sidebar.history.store;

import android.content.Context;
import android.os.Build;
import android.os.Message;
import android.text.TextUtils;
import com.didi.dcrypto.util.DCryptoUtils;
import com.didi.dimina.container.secondparty.jsmodule.jsbridge.websocket.DMWebSocketListener;
import com.didi.entrega.customer.foundation.rpc.ParamsHelper;
import com.didi.sdk.nation.NationComponentData;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.push.ServerParam;
import com.didi.sdk.push.http.BaseObject;
import com.didi.sdk.security.SecurityUtil;
import com.didi.sdk.sidebar.compatible.SideBarAdapterStore;
import com.didi.sdk.sidebar.history.manager.HistoryDeleteCallBack;
import com.didi.sdk.sidebar.history.manager.HistoryRequestCallBack;
import com.didi.sdk.sidebar.history.manager.soda.CipherUtil;
import com.didi.sdk.sidebar.history.manager.soda.Clock;
import com.didi.sdk.sidebar.history.manager.soda.CustomerSystemUtil;
import com.didi.sdk.sidebar.history.manager.soda.FoodHistoryItemModel;
import com.didi.sdk.sidebar.history.manager.soda.HistoryEntity;
import com.didi.sdk.sidebar.history.manager.soda.HistoryItemEntity;
import com.didi.sdk.sidebar.history.manager.soda.HistoryListEntity;
import com.didi.sdk.sidebar.history.model.HistoryOrder;
import com.didi.sdk.sidebar.history.model.HistoryOrdersResponse;
import com.didi.sdk.sidebar.history.model.InvoiceOrder;
import com.didi.sdk.sidebar.sdk.api.model.CommonDispatchMessage;
import com.didi.sdk.sidebar.sdk.commonapi.CommonAPIPublicParamCombiner;
import com.didi.sdk.sidebar.sdk.commonapi.Consts;
import com.didi.sdk.sidebar.setup.mutilocale.MultiLocaleStore;
import com.didi.sdk.sidebar.util.SideBarBusinessUtil;
import com.didi.sdk.util.AppUtils;
import com.didi.sdk.util.SingletonHolder;
import com.didi.sdk.util.SystemUtil;
import com.didi.sdk.util.TextUtil;
import com.didi.soda.customer.app.constant.Const;
import com.didichuxing.foundation.gson.GsonDeserializer;
import com.didichuxing.foundation.gson.GsonFormSerializer;
import com.didichuxing.foundation.gson.GsonSerializer;
import com.didichuxing.foundation.net.rpc.http.FormSerializer;
import com.didichuxing.foundation.net.rpc.http.annotation.Get;
import com.didichuxing.foundation.net.rpc.http.annotation.Post;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.annotation.BodyParameter;
import com.didichuxing.foundation.rpc.annotation.Deserialization;
import com.didichuxing.foundation.rpc.annotation.Path;
import com.didichuxing.foundation.rpc.annotation.QueryParameter;
import com.didichuxing.foundation.rpc.annotation.Serialization;
import com.didichuxing.foundation.rpc.annotation.TargetThread;
import com.didichuxing.foundation.rpc.annotation.ThreadType;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HistoryRecordStore extends SideBarAdapterStore {
    public static final String ACTION_CLOSE_HISTORY_RECORDS = "com.didi.passenger.ACTION_CLOSE_HISTORY_RECORDS";
    public static final String ACTION_DELETE_HISTORY_RECORDS = "com.didi.passenger.ACTION_DELETE_HISTORY_RECORDS";
    public static final String ACTION_GET_BIKE_HISTORY_RECORDS = "com.didi.passenger.ACTION_GET_BIKE_HISTORY_RECORDS";
    public static final String ACTION_GET_HISTORY_RECORDS = "com.didi.passenger.ACTION_GET_HISTORY_RECORDS";
    public static final String ACTION_GET_SODA_HISTORY_RECORDS = "com.didi.passenger.ACTION_GET_SODA_HISTORY_RECORDS";
    public static final String ACTION_SHOW_LOADING = "com.didi.passenger.ACTION_SHOW_LOADING";

    public interface HistoryRecordService extends RpcService {
        @Get
        @Serialization(GsonSerializer.class)
        @Path("/common/v6/order/delete")
        @Deserialization(GsonDeserializer.class)
        Object deleteHistory(@QueryParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<BaseObject> callback);

        @Get
        @Serialization(GsonSerializer.class)
        @Path("/passenger/deleteorder")
        @Deserialization(GsonDeserializer.class)
        Object deleteRecords(@QueryParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<BaseObject> callback);

        @Get
        @Serialization(GsonSerializer.class)
        @Path("/common/v6/order/history")
        @Deserialization(GsonDeserializer.class)
        Object getHistory(@QueryParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<HistoryOrdersResponse<HistoryOrder>> callback);

        @Get
        @Serialization(GsonSerializer.class)
        @Path("/passenger/history")
        @Deserialization(GsonDeserializer.class)
        Object getHistoryRecords(@QueryParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<HistoryOrdersResponse<HistoryOrder>> callback);

        @Serialization(GsonSerializer.class)
        @Path("/common/v5/general/historyV2")
        @Deserialization(GsonDeserializer.class)
        Object getHistoryRecordsNew(@QueryParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<HistoryOrdersResponse<HistoryOrder>> callback);

        @Serialization(GsonFormSerializer.class)
        @Path("/common/v6/order/invoice")
        @Post
        @Deserialization(GsonDeserializer.class)
        Object getInvoiceResponse(@QueryParameter("") Map<String, String> map, @BodyParameter("orders") List<InvoiceOrder> list, @TargetThread(ThreadType.MAIN) RpcService.Callback<BaseObject> callback);

        @Serialization(FormSerializer.class)
        @Path("/order/orderList")
        @Post
        @Deserialization(GsonDeserializer.class)
        Object getSodaHistoryRecords(@BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<HistoryEntity> callback);
    }

    private HistoryRecordStore() {
    }

    public static HistoryRecordStore getInstance() {
        return (HistoryRecordStore) SingletonHolder.getInstance(HistoryRecordStore.class);
    }

    public void closeHistoryRecordFragment() {
        dispatch(ACTION_CLOSE_HISTORY_RECORDS, CommonDispatchMessage.getSuccessMessage((Object) null));
    }

    public void getHistoryRecords(final Context context, Map<String, Object> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        map.put("detail_source", "list_page");
        NationComponentData nationComponentData = NationTypeUtil.getNationComponentData();
        if (!TextUtil.isEmpty(nationComponentData.getLoginInfo().getToken())) {
            map.put(ServerParam.PARAM_DDRIVER_SWITCH, "1");
        } else {
            map.put(ServerParam.PARAM_DDRIVER_SWITCH, "0");
        }
        map.put(ServerParam.PARAM_HISTORY_RECORD_ORDER, String.valueOf(1));
        if (!TextUtil.isEmpty(nationComponentData.getLoginInfo().getPid())) {
            map.put(ServerParam.PARAM_DDRIVER_PID, nationComponentData.getLoginInfo().getPid());
        }
        if (!TextUtil.isEmpty(nationComponentData.getLoginInfo().getKDToken())) {
            map.put(ServerParam.PARAM_DDRIVER_TOKEN, nationComponentData.getLoginInfo().getKDToken());
        }
        map.put(ServerParam.PARAM_DDRIVER_OSTYPE, "2");
        map.put("osVersion", Build.VERSION.RELEASE);
        map.put("imsi", SystemUtil.getIMSI());
        map.put(ServerParam.PARAM_DDRIVER_APP_TIME, String.valueOf(System.currentTimeMillis() / 1000));
        CommonAPIPublicParamCombiner.combineUserInfo(map);
        CommonAPIPublicParamCombiner.combineSystemInfo(map, context);
        ((HistoryRecordService) getService(context, HistoryRecordService.class, "https://common.didiglobal.com")).getHistory(map, new RpcService.Callback<HistoryOrdersResponse<HistoryOrder>>() {
            public void onSuccess(HistoryOrdersResponse historyOrdersResponse) {
                HistoryRecordStore.this.m26599a(context, historyOrdersResponse);
            }

            public void onFailure(IOException iOException) {
                HistoryRecordStore.this.m26602a(iOException);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m26599a(Context context, HistoryOrdersResponse historyOrdersResponse) {
        if (historyOrdersResponse.errno == 0) {
            dispatch(ACTION_GET_HISTORY_RECORDS, CommonDispatchMessage.getSuccessMessage(historyOrdersResponse));
            return;
        }
        HashMap hashMap = new HashMap();
        if (SideBarBusinessUtil.isRedirectToLogin(context, historyOrdersResponse)) {
            hashMap.put(DMWebSocketListener.KEY_ERR_MSG, "SideBarBusinessUtil.isRedirectToLogin true");
        } else {
            Message errorMessage = CommonDispatchMessage.getErrorMessage(historyOrdersResponse);
            hashMap.put(DMWebSocketListener.KEY_ERR_MSG, errorMessage.what + "," + errorMessage.obj);
            dispatch(ACTION_GET_HISTORY_RECORDS, errorMessage);
        }
        OmegaSDKAdapter.trackEvent("tong_p_x_mytrips_sw_error", (Map<String, Object>) hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m26602a(IOException iOException) {
        HashMap hashMap = new HashMap();
        hashMap.put(DMWebSocketListener.KEY_ERR_MSG, iOException.getMessage());
        OmegaSDKAdapter.trackEvent("tong_p_x_mytrips_sw_error", (Map<String, Object>) hashMap);
        dispatch(ACTION_GET_HISTORY_RECORDS, CommonDispatchMessage.getNetworkErrorMessage((Object) null));
    }

    public void getSodaHistoryRecords(Context context, Map<String, Object> map, final HistoryRequestCallBack historyRequestCallBack) {
        if (map == null) {
            map = new HashMap<>();
        }
        map.putAll(getSodaCommonParams(context));
        CommonAPIPublicParamCombiner.combineUserInfo(map);
        CommonAPIPublicParamCombiner.combineSystemInfo(map, context);
        ((HistoryRecordService) getService(context, HistoryRecordService.class, Consts.getSodaApiByEnviroment(context))).getSodaHistoryRecords(map, new RpcService.Callback<HistoryEntity>() {
            public void onSuccess(HistoryEntity historyEntity) {
                HistoryListEntity historyListEntity = historyEntity.data;
                if (historyListEntity != null) {
                    HistoryOrdersResponse historyOrdersResponse = new HistoryOrdersResponse();
                    historyOrdersResponse.setErrorCode(0);
                    historyOrdersResponse.setToastTips(historyListEntity.toast);
                    historyOrdersResponse.setPageTips(historyListEntity.nextText);
                    historyOrdersResponse.setHavenext(historyListEntity.mhaveNext);
                    historyOrdersResponse.setMonthPageHaveNext(historyListEntity.haveNext);
                    historyOrdersResponse.setTimeMode(historyListEntity.timeMode);
                    historyOrdersResponse.setWaitingOrderList(HistoryRecordStore.this.m26598a(false, historyListEntity.orderWaiting));
                    historyOrdersResponse.setDoneOrderList(HistoryRecordStore.this.m26598a(true, historyListEntity.orderDone));
                    HistoryRequestCallBack historyRequestCallBack = historyRequestCallBack;
                    if (historyRequestCallBack != null) {
                        historyRequestCallBack.onSuccess(historyOrdersResponse);
                        return;
                    }
                    return;
                }
                HistoryRequestCallBack historyRequestCallBack2 = historyRequestCallBack;
                if (historyRequestCallBack2 != null) {
                    historyRequestCallBack2.onFailure(-1);
                }
            }

            public void onFailure(IOException iOException) {
                HistoryRequestCallBack historyRequestCallBack = historyRequestCallBack;
                if (historyRequestCallBack != null) {
                    historyRequestCallBack.onFailure(-1);
                }
            }
        });
    }

    public static Map<String, Object> getSodaCommonParams(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("bizId", Integer.valueOf(AppUtils.isBrazilApp(context) ? 601 : 392));
        hashMap.put("appVersion", SystemUtil.getVersionName());
        hashMap.put("versionCode", Integer.valueOf(SystemUtil.getVersionCode()));
        hashMap.put("deviceType", SystemUtil.getModel());
        hashMap.put("deviceBrand", CustomerSystemUtil.getDeviceBrand());
        hashMap.put("clientType", 6);
        hashMap.put("deviceId", SecurityUtil.getDeviceId());
        NationComponentData nationComponentData = NationTypeUtil.getNationComponentData();
        if (!TextUtils.isEmpty(nationComponentData.getCityId())) {
            hashMap.put("cityId", Integer.valueOf(Integer.parseInt(nationComponentData.getCityId())));
            hashMap.put("poiCityId", Integer.valueOf(Integer.parseInt(nationComponentData.getCityId())));
        } else {
            hashMap.put("cityId", -1);
            hashMap.put("poiCityId", -1);
        }
        hashMap.put(Const.H5Params.POIID, "");
        hashMap.put("poiLat", 0);
        hashMap.put("poiLng", 0);
        hashMap.put("poiName", "");
        hashMap.put("timestamp", Long.valueOf(Clock.timeAtSeconds()));
        hashMap.put("ip", CustomerSystemUtil.getLocalIpAddress(context));
        hashMap.put("linuxKernel", CustomerSystemUtil.getKernelVersion());
        hashMap.put("locationType", Integer.valueOf(CustomerSystemUtil.getLocationType()));
        hashMap.put("wifiName", CustomerSystemUtil.getSsId(context));
        hashMap.put("wifiMac", "");
        hashMap.put("requestId", m26596a());
        hashMap.put("locale", nationComponentData.getLocaleCode());
        hashMap.put(DCryptoUtils.PARAMS_KEY_TERMINAL_ID, 300103);
        hashMap.put("userRole", "");
        hashMap.put("uid", SecurityUtil.getSUUID());
        hashMap.put("sig", "");
        hashMap.put("osVersion", Build.VERSION.RELEASE);
        hashMap.put(ServerParam.PARAM_DDRIVER_OSTYPE, 2);
        hashMap.put("operatorName", "");
        hashMap.put("mobileType", "");
        hashMap.put("imsi", "");
        hashMap.put("scg", "");
        hashMap.put(ParamsHelper.DATA_TYPE, Integer.valueOf(AppUtils.isBrazilApp(context) ? 16 : 12));
        return hashMap;
    }

    /* renamed from: a */
    private static String m26596a() {
        return CipherUtil.md5(CustomerSystemUtil.getDeviceId() + "_" + Clock.timeAtSeconds());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public List<FoodHistoryItemModel> m26598a(boolean z, List<HistoryItemEntity> list) {
        ArrayList arrayList = new ArrayList();
        for (HistoryItemEntity foodHistoryItemModel : list) {
            FoodHistoryItemModel foodHistoryItemModel2 = new FoodHistoryItemModel(foodHistoryItemModel);
            if (z) {
                foodHistoryItemModel2.setStatus(0);
            } else {
                foodHistoryItemModel2.setStatus(1);
            }
            arrayList.add(foodHistoryItemModel2);
        }
        return arrayList;
    }

    public void deleteRecords(Context context, Map<String, Object> map, final HistoryDeleteCallBack historyDeleteCallBack) {
        CommonAPIPublicParamCombiner.combineUserInfo(map);
        CommonAPIPublicParamCombiner.combineSystemInfo(map, context);
        ((HistoryRecordService) getService(context, HistoryRecordService.class, "https://common.didiglobal.com")).deleteHistory(map, new RpcService.Callback<BaseObject>() {
            public void onSuccess(BaseObject baseObject) {
                HistoryDeleteCallBack historyDeleteCallBack = historyDeleteCallBack;
                if (historyDeleteCallBack != null) {
                    historyDeleteCallBack.onSuccess(baseObject);
                }
            }

            public void onFailure(IOException iOException) {
                HistoryDeleteCallBack historyDeleteCallBack = historyDeleteCallBack;
                if (historyDeleteCallBack != null) {
                    historyDeleteCallBack.onFailure(iOException.getMessage());
                }
            }
        });
    }

    public void getInvoice(Context context, String str, String str2, List<InvoiceOrder> list, RpcService.Callback<BaseObject> callback) {
        HashMap hashMap = new HashMap();
        hashMap.put("token", NationTypeUtil.getNationComponentData().getLoginInfo().getToken());
        hashMap.put("lang", MultiLocaleStore.getInstance().getLocaleCode());
        hashMap.put("email", str);
        hashMap.put("invoice_title", str2);
        ((HistoryRecordService) getService(context, HistoryRecordService.class, "https://common.didiglobal.com")).getInvoiceResponse(hashMap, list, callback);
    }
}
