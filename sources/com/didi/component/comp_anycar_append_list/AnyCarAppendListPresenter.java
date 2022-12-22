package com.didi.component.comp_anycar_append_list;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.didi.component.business.tracker.anycar.AnycarTrack;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.OrderComManager;
import com.didi.component.business.xengine.XERequestKey;
import com.didi.component.business.xengine.XEngineReq;
import com.didi.component.business.xpanelnew.IXpCardBindDataReadyCallback;
import com.didi.component.business.xpanelnew.IXpCardLifeCycle;
import com.didi.component.business.xpanelnew.IXpCompRefresh;
import com.didi.component.business.xpanelnew.XpNewAdapter;
import com.didi.component.common.base.ComponentType;
import com.didi.component.common.net.CarRequest;
import com.didi.component.common.util.GsonUtils;
import com.didi.component.core.IPresenter;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.drouter.router.RouterCallback;
import com.didi.global.globaluikit.toast.LEGOToastHelper;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didi.travel.psnger.common.net.base.ResponseListener;
import com.didi.travel.psnger.model.response.OrderCom;
import com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel;
import com.didi.travel.psnger.model.response.anycar.AnyCarEstimateNetModel;
import com.didi.travel.psnger.model.response.anycar.AnyCarGroup;
import com.didi.travel.psnger.model.response.estimate.CarMessageModel;
import com.didi.travel.psnger.model.response.estimate.CarOperationDataModel;
import com.didi.xengine.callback.XEReqJSONParamsCallbackImpl;
import com.didi.xengine.register.XERegister;
import com.didi.xengine.request.XEBizParamsImpl;
import com.didiglobal.enginecore.callback.XEResponseCallback;
import com.didiglobal.enginecore.component.XEComponent;
import com.didiglobal.enginecore.data.exception.EngineErrorException;
import com.didiglobal.enginecore.data.model.XEngineData;
import com.didiglobal.enginecore.register.XERegisterModel;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.google.gson.JsonObject;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AnyCarAppendListPresenter extends IPresenter<IAnyCarAppendListView> implements IXpCardLifeCycle, IXpCompRefresh, XpNewAdapter {

    /* renamed from: a */
    private static final Logger f12086a = LoggerFactory.getLogger((Class<?>) AnyCarAppendListPresenter.class);

    /* renamed from: b */
    private AnyCarAppendData f12087b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public List<AnyCarEstimateItemModel> f12088c = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f12089d = false;

    /* renamed from: e */
    private boolean f12090e = false;

    /* renamed from: f */
    private int f12091f;

    /* renamed from: g */
    private boolean f12092g = false;

    /* renamed from: h */
    private XEResponseCallback f12093h = new XEResponseCallback() {
        public void onFailed(String str, EngineErrorException engineErrorException) {
        }

        public void onSuccess(String str, XEngineData xEngineData, List<XEComponent> list) {
            BaseEventPublisher.getPublisher().publish("event_hide_loading_on_titlebar_in_home");
            if (XERequestKey.SCENE_TRIP.equals(str)) {
                boolean unused = AnyCarAppendListPresenter.this.f12089d = false;
            }
        }
    };

    /* renamed from: i */
    private XEReqJSONParamsCallbackImpl f12094i = new XEReqJSONParamsCallbackImpl() {
        public JSONObject getRequestParams() {
            HashMap hashMap = new HashMap();
            hashMap.put("need_append_card", Boolean.valueOf(AnyCarAppendListPresenter.this.f12089d));
            hashMap.put(ParamKeys.PARAM_ANYCAR_PRODUCTS_SELECTED, AnyCarAppendListPresenter.this.m8150b());
            return new JSONObject(hashMap);
        }
    };

    public void compIds(List<String> list, int i, IXpCompRefresh.IXpCompRefreshCb iXpCompRefreshCb) {
    }

    public void compRefresh(int i, String str, int i2, IXpCompRefresh.IXpCompRefreshCb iXpCompRefreshCb) {
    }

    public void onCardAdd() {
    }

    public void onCardRemove() {
    }

    public AnyCarAppendListPresenter(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        XERegisterModel xERegisterModel = new XERegisterModel(ComponentType.ANY_CAR_APPEND_LIST, XERequestKey.SCENE_TRIP, this.f12093h);
        xERegisterModel.requestParams = this.f12094i;
        XERegister.registerTemplate(xERegisterModel);
        this.f12092g = false;
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        XERegister.unregisterTemplate(ComponentType.ANY_CAR_APPEND_LIST);
        this.f12092g = false;
    }

    public void setViewWithData(JSONObject jSONObject, IXpCardBindDataReadyCallback iXpCardBindDataReadyCallback) {
        JSONObject optJSONObject = jSONObject.optJSONObject("normal");
        if (optJSONObject != null) {
            try {
                AnyCarAppendData anyCarAppendData = (AnyCarAppendData) GsonUtils.singleGson().fromJson(optJSONObject.optString("data"), AnyCarAppendData.class);
                this.f12087b = anyCarAppendData;
                if (!(anyCarAppendData == null || anyCarAppendData.carAppendList == null)) {
                    if (this.f12087b.carAppendList.size() != 0) {
                        this.f12088c.clear();
                        ((IAnyCarAppendListView) this.mView).getView().setVisibility(0);
                        ((IAnyCarAppendListView) this.mView).setTitle(this.f12087b.title);
                        ((IAnyCarAppendListView) this.mView).setData(this.f12087b.carAppendList);
                        ((IAnyCarAppendListView) this.mView).setSubmitBtn(this.f12087b.btnInfo);
                        if (!this.f12092g) {
                            m8147a(this.f12087b.carAppendList);
                        }
                        this.f12092g = true;
                        iXpCardBindDataReadyCallback.ready(true);
                        return;
                    }
                }
                ((IAnyCarAppendListView) this.mView).getView().setVisibility(8);
                if (!this.f12090e) {
                    new Timer(true).schedule(new TimerTask() {
                        public void run() {
                            boolean unused = AnyCarAppendListPresenter.this.f12089d = true;
                            XEngineReq.pageRequest(XERequestKey.SCENE_TRIP);
                        }
                    }, new Date(this.f12087b.show_timestamp * 1000));
                    this.f12090e = true;
                }
                iXpCardBindDataReadyCallback.ready(false);
            } catch (Exception e) {
                e.printStackTrace();
                AnycarTrack.anycarMonitorTrack(AnycarTrack.mSceneAppendCarList, (Map<String, Object>) null);
                iXpCardBindDataReadyCallback.ready(false);
            }
        } else {
            iXpCardBindDataReadyCallback.ready(false);
        }
    }

    public List<AnyCarEstimateItemModel> getSelectedAnyCarItems() {
        return this.f12088c;
    }

    public void defaultSelectedItem(AnyCarEstimateItemModel anyCarEstimateItemModel) {
        this.f12088c.add(anyCarEstimateItemModel);
    }

    public void selectedItem(AnyCarEstimateItemModel anyCarEstimateItemModel) {
        this.f12088c.add(anyCarEstimateItemModel);
        ((IAnyCarAppendListView) this.mView).refreshBtnContent();
        ((IAnyCarAppendListView) this.mView).updateMsgTips(getAnyCarMsg());
        bubbleSelectUpload(anyCarEstimateItemModel);
        m8144a(anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig.carBussinessId);
    }

    public void unSelectItem(AnyCarEstimateItemModel anyCarEstimateItemModel) {
        this.f12088c.remove(anyCarEstimateItemModel);
        ((IAnyCarAppendListView) this.mView).refreshBtnContent();
        ((IAnyCarAppendListView) this.mView).updateMsgTips(getAnyCarMsg());
    }

    public void carpoolSeatSelected(AnyCarEstimateItemModel anyCarEstimateItemModel) {
        if (anyCarEstimateItemModel != null && anyCarEstimateItemModel.anycarCarpool != null) {
            this.f12091f = anyCarEstimateItemModel.anycarCarpool.mSelectedIndex + 1;
            XEBizParamsImpl xEBizParamsImpl = new XEBizParamsImpl();
            xEBizParamsImpl.requestKeys = new String[]{ComponentType.ANY_CAR_APPEND_LIST};
            xEBizParamsImpl.scene = XERequestKey.SCENE_TRIP;
            XEngineReq.simpleRequest(xEBizParamsImpl);
        }
    }

    public CarMessageModel getAnyCarMsg() {
        CarMessageModel carMessageModel = null;
        if (!CollectionUtil.isEmpty((Collection<?>) this.f12088c)) {
            int i = Integer.MIN_VALUE;
            for (AnyCarEstimateItemModel next : this.f12088c) {
                if (!(next == null || next.mAnyCarEstimateNetItem == null || next.mAnyCarEstimateNetItem.carMessage == null || next.mAnyCarEstimateNetItem.carMessage.level < i)) {
                    int i2 = next.mAnyCarEstimateNetItem.carMessage.level;
                    i = i2;
                    carMessageModel = next.mAnyCarEstimateNetItem.carMessage;
                }
            }
        }
        return carMessageModel;
    }

    public void submitCarModelAppend() {
        if (this.f12088c.size() != 0) {
            OrderCom orderCom = OrderComManager.getInstance().getOrderCom();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("oid", orderCom.getOid());
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < this.f12088c.size(); i++) {
                    AnyCarEstimateItemModel anyCarEstimateItemModel = this.f12088c.get(i);
                    if (!(anyCarEstimateItemModel == null || anyCarEstimateItemModel.mAnyCarEstimateNetItem == null || anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig == null)) {
                        if (anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig.extraData != null) {
                            JsonObject jsonObject = anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig.extraData.orderParamsObject;
                            if (jsonObject != null) {
                                JSONObject jSONObject2 = new JSONObject();
                                if (jsonObject.has("bubble_id")) {
                                    jSONObject2.put("bubble_id", jsonObject.get("bubble_id").getAsString());
                                }
                                if (jsonObject.has(ParamKeys.PARAM_ESTIMATE_ID)) {
                                    jSONObject2.put(ParamKeys.PARAM_ESTIMATE_ID, jsonObject.get(ParamKeys.PARAM_ESTIMATE_ID).getAsString());
                                }
                                jSONObject2.put("seat_num", this.f12091f);
                                jSONArray.put(jSONObject2);
                            }
                        }
                    }
                }
                jSONObject.put("append_list", jSONArray);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            try {
                if (!TextUtils.isEmpty(this.f12087b.append_link)) {
                    String str = this.f12087b.append_link;
                    String queryParameter = Uri.parse(str).getQueryParameter("query");
                    if (!TextUtils.isEmpty(queryParameter)) {
                        String substring = str.substring(0, str.indexOf("?"));
                        JSONObject jSONObject3 = new JSONObject(URLDecoder.decode(queryParameter, "UTF-8"));
                        jSONObject3.put("anycar_append_list", jSONObject);
                        ((Request) DRouter.build(substring + "?query=" + URLEncoder.encode(jSONObject3.toString(), "UTF-8")).putExtra("KEY_COMMIT_SCENE", XERequestKey.SCENE_TRIP)).start(this.mContext, new RouterCallback() {
                            public void onResult(Result result) {
                                AnyCarAppendListPresenter.this.m8156d();
                                BaseEventPublisher.getPublisher().publish("event_hide_loading_on_titlebar_in_home");
                                ((IAnyCarAppendListView) AnyCarAppendListPresenter.this.mView).updateBtnLoading(false);
                                AnyCarAppendListPresenter.this.f12088c.clear();
                                ((IAnyCarAppendListView) AnyCarAppendListPresenter.this.mView).refreshBtnContent();
                                ((IAnyCarAppendListView) AnyCarAppendListPresenter.this.mView).updateMsgTips((CarMessageModel) null);
                                AnyCarAppendListPresenter.this.m8146a(result);
                            }
                        });
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public List<JSONObject> m8150b() {
        CarOperationDataModel.AnycarCarpoolSeat anycarCarpoolSeat;
        ArrayList arrayList = new ArrayList();
        for (AnyCarEstimateItemModel next : this.f12088c) {
            JsonObject jsonObject = null;
            if (!(next == null || next.mAnyCarEstimateNetItem == null || next.mAnyCarEstimateNetItem.carConfig == null || next.mAnyCarEstimateNetItem.carConfig.extraData == null || next.mAnyCarEstimateNetItem.carConfig.extraData.orderParamsObject == null)) {
                jsonObject = next.mAnyCarEstimateNetItem.carConfig.extraData.orderParamsObject;
            }
            if (!(next == null || next.anycarCarpool == null || next.anycarCarpool.operationData == null || CollectionUtil.isEmpty((Collection<?>) next.anycarCarpool.operationData.anycarCarpoolSeatList) || (anycarCarpoolSeat = next.anycarCarpool.operationData.anycarCarpoolSeatList.get(next.anycarCarpool.mSelectedIndex)) == null || anycarCarpoolSeat.selectValueParams == null)) {
                if (jsonObject == null) {
                    jsonObject = anycarCarpoolSeat.selectValueParams;
                } else {
                    for (String next2 : anycarCarpoolSeat.selectValueParams.keySet()) {
                        jsonObject.add(next2, anycarCarpoolSeat.selectValueParams.get(next2));
                    }
                }
            }
            if (jsonObject != null) {
                try {
                    arrayList.add(new JSONObject(jsonObject.toString()));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return arrayList;
    }

    public void bubbleSelectUpload(AnyCarEstimateItemModel anyCarEstimateItemModel) {
        JsonObject jsonObject;
        String str;
        if (anyCarEstimateItemModel != null) {
            String str2 = this.f12087b.selectItemCommitUrl;
            if (!TextUtils.isEmpty(str2)) {
                HashMap hashMap = new HashMap();
                String orderId = CarOrderHelper.getOrderId();
                if (anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig != null) {
                    str = anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig.estimateId;
                    if (anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig.extraData != null) {
                        jsonObject = anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig.extraData.orderParamsObject;
                        hashMap.put("oid", orderId);
                        hashMap.put(ParamKeys.PARAM_ESTIMATE_ID, str);
                        CarRequest.doBubbleSelectXEngineCommit(this.mContext, hashMap, jsonObject, str2, XERequestKey.SCENE_TRIP, (ResponseListener<String>) null);
                    }
                } else {
                    str = "";
                }
                jsonObject = null;
                hashMap.put("oid", orderId);
                hashMap.put(ParamKeys.PARAM_ESTIMATE_ID, str);
                CarRequest.doBubbleSelectXEngineCommit(this.mContext, hashMap, jsonObject, str2, XERequestKey.SCENE_TRIP, (ResponseListener<String>) null);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8146a(Result result) {
        JSONObject optJSONObject;
        String string = result.getString("KEY_CALLBACK");
        if (TextUtils.isEmpty(string)) {
            f12086a.info("xEngine commit failed", new Object[0]);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(string);
            if (jSONObject.has("data")) {
                JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
                if (optJSONObject2.has("extension") && (optJSONObject = optJSONObject2.optJSONObject("extension")) != null && optJSONObject.optInt("errno") != 0) {
                    LEGOToastHelper.showToast(this.mContext, optJSONObject.optString("errmsg"));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00ab  */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List<java.lang.String> m8153c() {
        /*
            r9 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.List<com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel> r1 = r9.f12088c
            int r1 = r1.size()
            if (r1 != 0) goto L_0x000e
            return r0
        L_0x000e:
            java.util.List<com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel> r1 = r9.f12088c
            java.util.Iterator r1 = r1.iterator()
        L_0x0014:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x00ce
            java.lang.Object r2 = r1.next()
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel r2 = (com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel) r2
            if (r2 == 0) goto L_0x0014
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateNetModel r3 = r2.mAnyCarEstimateNetItem
            if (r3 == 0) goto L_0x0014
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateNetModel r3 = r2.mAnyCarEstimateNetItem
            com.didi.travel.psnger.model.response.anycar.AnyCarConfigModel r3 = r3.carConfig
            if (r3 == 0) goto L_0x0014
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateNetModel r3 = r2.mAnyCarEstimateNetItem
            com.didi.travel.psnger.model.response.anycar.AnyCarConfigModel r3 = r3.carConfig
            com.didi.travel.psnger.model.response.anycar.AnyCarExtraData r3 = r3.extraData
            if (r3 != 0) goto L_0x0035
            goto L_0x0014
        L_0x0035:
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateNetModel r3 = r2.mAnyCarEstimateNetItem
            com.didi.travel.psnger.model.response.anycar.AnyCarConfigModel r3 = r3.carConfig
            com.didi.travel.psnger.model.response.anycar.AnyCarExtraData r3 = r3.extraData
            if (r3 != 0) goto L_0x003e
            goto L_0x0014
        L_0x003e:
            r4 = 0
            com.didi.travel.psnger.model.response.estimate.CarExtraLogModel r5 = r3.getExtraLog()
            if (r5 == 0) goto L_0x0014
            com.didi.travel.psnger.model.response.estimate.CarExtraLogModel r3 = r3.getExtraLog()
            java.lang.String r5 = r3.eta
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x0059
            java.lang.String r5 = r3.eta     // Catch:{ Exception -> 0x0058 }
            int r4 = java.lang.Integer.parseInt(r5)     // Catch:{ Exception -> 0x0058 }
            goto L_0x0059
        L_0x0058:
        L_0x0059:
            java.lang.String r5 = r3.originFee
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            r6 = 0
            if (r5 != 0) goto L_0x0069
            java.lang.String r3 = r3.originFee     // Catch:{ Exception -> 0x0069 }
            float r3 = java.lang.Float.parseFloat(r3)     // Catch:{ Exception -> 0x0069 }
            goto L_0x006a
        L_0x0069:
            r3 = 0
        L_0x006a:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateNetModel r7 = r2.mAnyCarEstimateNetItem
            com.didi.travel.psnger.model.response.anycar.AnyCarConfigModel r7 = r7.carConfig
            int r7 = r7.carLevel
            r5.append(r7)
            java.lang.String r7 = ""
            java.lang.String r8 = ":"
            if (r4 != 0) goto L_0x0085
            r5.append(r8)
            r5.append(r7)
            goto L_0x008b
        L_0x0085:
            r5.append(r8)
            r5.append(r4)
        L_0x008b:
            float r4 = r2.feeNumber
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 != 0) goto L_0x0098
            r5.append(r8)
            r5.append(r7)
            goto L_0x00a0
        L_0x0098:
            r5.append(r8)
            float r4 = r2.feeNumber
            r5.append(r4)
        L_0x00a0:
            int r4 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r4 != 0) goto L_0x00ab
            r5.append(r8)
            r5.append(r7)
            goto L_0x00b1
        L_0x00ab:
            r5.append(r8)
            r5.append(r3)
        L_0x00b1:
            r5.append(r8)
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateNetModel r3 = r2.mAnyCarEstimateNetItem
            com.didi.travel.psnger.model.response.anycar.AnyCarConfigModel r3 = r3.carConfig
            java.util.List<java.lang.String> r3 = r3.guideType
            r5.append(r3)
            r5.append(r8)
            boolean r2 = r2.isSelected
            r5.append(r2)
            java.lang.String r2 = r5.toString()
            r0.add(r2)
            goto L_0x0014
        L_0x00ce:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.comp_anycar_append_list.AnyCarAppendListPresenter.m8153c():java.util.List");
    }

    /* renamed from: a */
    private void m8147a(List<AnyCarGroup> list) {
        HashMap hashMap = new HashMap();
        StringBuilder sb = new StringBuilder();
        List<AnyCarEstimateNetModel> b = m8152b(list);
        if (b != null && b.size() > 0) {
            for (int i = 0; i < b.size(); i++) {
                if (i < b.size() - 1) {
                    sb.append(b.get(i).carConfig.carBussinessId);
                    sb.append(",");
                } else {
                    sb.append(b.get(i).carConfig.carBussinessId);
                }
            }
        }
        hashMap.put("actual_bizlist", sb.toString());
        OmegaSDKAdapter.trackEvent("ibt_gp_anycar_morecartype_card_sw", (Map<String, Object>) hashMap);
    }

    /* renamed from: a */
    private void m8144a(int i) {
        int i2 = getAnyCarMsg() != null ? 1 : 0;
        HashMap hashMap = new HashMap();
        hashMap.put("type", Integer.valueOf(i2));
        hashMap.put("info_list", m8153c().toString());
        hashMap.put("actual_biz", Integer.valueOf(i));
        OmegaSDKAdapter.trackEvent("ibt_gp_anycar_morecartypes_ck", (Map<String, Object>) hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m8156d() {
        int i = getAnyCarMsg() != null ? 1 : 0;
        HashMap hashMap = new HashMap();
        hashMap.put("type", Integer.valueOf(i));
        hashMap.put("info_list", m8153c().toString());
        StringBuilder sb = new StringBuilder();
        if (this.f12088c.size() > 0) {
            for (int i2 = 0; i2 < this.f12088c.size(); i2++) {
                AnyCarEstimateItemModel anyCarEstimateItemModel = this.f12088c.get(i2);
                if (!(anyCarEstimateItemModel == null || anyCarEstimateItemModel.mAnyCarEstimateNetItem == null || anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig == null)) {
                    if (i2 < this.f12088c.size() - 1) {
                        sb.append(anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig.carBussinessId);
                        sb.append(",");
                    } else {
                        sb.append(anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig.carBussinessId);
                    }
                }
            }
        }
        hashMap.put("actual_bizlist", sb.toString());
        OmegaSDKAdapter.trackEvent("ibt_gp_anycar_morecartypes_request_ck", (Map<String, Object>) hashMap);
    }

    /* renamed from: b */
    private List<AnyCarEstimateNetModel> m8152b(List<AnyCarGroup> list) {
        ArrayList arrayList = new ArrayList();
        for (AnyCarGroup next : list) {
            if (next != null && !CollectionUtil.isEmpty((Collection<?>) next.group)) {
                for (AnyCarEstimateNetModel next2 : next.group) {
                    if (next2 != null) {
                        arrayList.add(next2);
                    }
                }
            }
        }
        return arrayList;
    }
}
