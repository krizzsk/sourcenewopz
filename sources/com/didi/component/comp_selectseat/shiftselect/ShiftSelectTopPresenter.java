package com.didi.component.comp_selectseat.shiftselect;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.data.form.PageCompDataTransfer;
import com.didi.component.business.data.form.listener.ConfirmListener;
import com.didi.component.business.tracker.GPageIdConstant;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.xengine.XERequestKey;
import com.didi.component.business.xengine.XEngineReq;
import com.didi.component.common.util.CollectionUtils;
import com.didi.component.common.util.GLog;
import com.didi.component.comp_selectseat.model.FrequencySelectModel;
import com.didi.component.comp_selectseat.model.ShiftBean;
import com.didi.component.comp_selectseat.model.ShiftSelectData;
import com.didi.component.comp_selectseat.model.ShiftSelectModel;
import com.didi.component.core.PresenterGroup;
import com.didi.travel.p171v2.util.LogUtils;
import com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel;
import com.didi.travel.psnger.model.response.estimate.EstimateItemModel;
import com.didi.xengine.callback.XEReqJSONParamsCallbackImpl;
import com.didi.xengine.register.XERegister;
import com.didiglobal.enginecore.callback.XEResponseCallback;
import com.didiglobal.enginecore.component.XEComponent;
import com.didiglobal.enginecore.data.exception.EngineErrorException;
import com.didiglobal.enginecore.data.model.XEngineData;
import com.didiglobal.enginecore.register.XERegisterModel;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import global.didi.pay.omega.GlobalPayOmegaConstant;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class ShiftSelectTopPresenter extends PresenterGroup<IShiftSelectView> {

    /* renamed from: a */
    private static final String f12476a = "ShiftSelectTopPresenter";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final HashMap<String, Object> f12477b = new HashMap<>();

    /* renamed from: c */
    private final XEReqJSONParamsCallbackImpl f12478c = new XEReqJSONParamsCallbackImpl() {
        public JSONObject getRequestParams() {
            HashMap hashMap = new HashMap();
            if (!CollectionUtils.isEmpty((Map) ShiftSelectTopPresenter.this.f12477b)) {
                hashMap.putAll(ShiftSelectTopPresenter.this.f12477b);
            }
            hashMap.put("to_address", FormStore.getInstance().getEndAddress().getAddress());
            hashMap.put("from_address", FormStore.getInstance().getStartAddress().getAddress());
            hashMap.put("to_name", FormStore.getInstance().getEndAddress().getDisplayName());
            hashMap.put("from_name", FormStore.getInstance().getStartAddress().getDisplayName());
            return new JSONObject(hashMap);
        }
    };
    public List<ShiftSelectData.ConfirmInfo> mConfirmInfos;
    protected XEResponseCallback mXELogicCallbackShiftSelect = new XEResponseCallback() {
        public void onSuccess(String str, XEngineData xEngineData, List<XEComponent> list) {
            if (xEngineData != null) {
                LogUtils.m31493i(ShiftSelectTopPresenter.f12476a, "onSuccessWithLogic:jsonObject = " + xEngineData.jsonObject);
                ShiftSelectTopPresenter.this.onSuccess(xEngineData.jsonObject);
            }
        }

        public void onFailed(String str, EngineErrorException engineErrorException) {
            LogUtils.m31493i(ShiftSelectTopPresenter.f12476a, "onFailed:e = " + engineErrorException);
            ShiftSelectTopPresenter.this.onFail(engineErrorException);
        }
    };

    public ShiftSelectTopPresenter(Context context, Bundle bundle) {
        super(context, bundle);
        if (bundle != null) {
            String string = bundle.getString("selectValueParams");
            if (!TextUtils.isEmpty(string)) {
                try {
                    HashMap hashMap = (HashMap) new Gson().fromJson(string, new TypeToken<HashMap<String, Object>>() {
                    }.getType());
                    if (!CollectionUtils.isEmpty((Map) hashMap)) {
                        this.f12477b.putAll(hashMap);
                    }
                } catch (JsonSyntaxException e) {
                    GLog.m7968e(f12476a, "ShiftSelectTopPresenter " + e.toString());
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSuccess(JsonObject jsonObject) {
        ShiftSelectModel shiftSelectModel;
        if (getHost() != null && getHost().getActivity() != null && jsonObject != null) {
            try {
                shiftSelectModel = (ShiftSelectModel) new Gson().fromJson(jsonObject.toString(), ShiftSelectModel.class);
            } catch (JsonSyntaxException e) {
                e.printStackTrace();
                shiftSelectModel = null;
            }
            if (shiftSelectModel == null || shiftSelectModel.data == null) {
                ((IShiftSelectView) this.mView).showLoadingErrorUi();
                return;
            }
            this.mConfirmInfos = shiftSelectModel.data.confirmInfos;
            FrequencySelectModel frequencySelectModel = shiftSelectModel.data.shiftInfo;
            if (frequencySelectModel == null) {
                LogUtils.m31492e(f12476a, "shiftInfos is null");
            } else if (frequencySelectModel.items == null || frequencySelectModel.items.size() <= 0) {
                ((IShiftSelectView) this.mView).showNoBusLayout(frequencySelectModel.title);
                m8484b();
            } else {
                ((IShiftSelectView) this.mView).setMinTitle(frequencySelectModel.title);
                ((IShiftSelectView) this.mView).setMaxTitle(frequencySelectModel.title);
                ((IShiftSelectView) this.mView).setHintInfo(frequencySelectModel.hint_info);
                ((IShiftSelectView) this.mView).setDate(frequencySelectModel.items);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onFail(Exception exc) {
        ((IShiftSelectView) this.mView).showLoadingErrorUi();
        GLog.m7968e(f12476a, exc.toString());
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        XERegisterModel xERegisterModel = new XERegisterModel(XERequestKey.REQUEST_KEY_SHIFT, XERequestKey.SCENE_SHIFT, this.mXELogicCallbackShiftSelect);
        xERegisterModel.requestParams = this.f12478c;
        XERegister.registerTemplate(xERegisterModel);
        PageRequest();
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        XERegister.unregisterTemplate(XERequestKey.REQUEST_KEY_SHIFT);
    }

    public void PageRequest() {
        XEngineReq.pageRequest(XERequestKey.SCENE_SHIFT);
    }

    public void onConfirmBtnClick(ShiftBean shiftBean) {
        if (shiftBean != null) {
            String str = shiftBean.routeId;
            if (this.mConfirmInfos != null) {
                HashMap hashMap = null;
                if (shiftBean.selectValueParam != null && !TextUtils.isEmpty(shiftBean.selectValueParam.toString())) {
                    try {
                        hashMap = (HashMap) new Gson().fromJson(shiftBean.selectValueParam.toString(), new TypeToken<HashMap<String, Object>>() {
                        }.getType());
                    } catch (JsonSyntaxException e) {
                        e.printStackTrace();
                    }
                }
                HashMap hashMap2 = new HashMap();
                if (!CollectionUtils.isEmpty((Map) hashMap)) {
                    hashMap2.putAll(hashMap);
                }
                if (!CollectionUtils.isEmpty((Map) this.f12477b)) {
                    hashMap2.putAll(this.f12477b);
                }
                if (!CollectionUtils.isEmpty((Map) hashMap2)) {
                    FormStore.getInstance().setSelectValueParams(hashMap2);
                }
                Iterator<ShiftSelectData.ConfirmInfo> it = this.mConfirmInfos.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ShiftSelectData.ConfirmInfo next = it.next();
                    if (!TextUtils.isEmpty(str) && str.equals(next.routeId)) {
                        if (next.info != null && next.info.cardModel != null) {
                            FormStore.getInstance().setShiftSelected(true);
                            FormStore.getInstance().setSkipEstimateGet(true);
                            doPublish(BaseEventKeys.Service.SendOrder.EVENT_REQUEST_ACTION_SEND_ORDER);
                            next.info.cardModel.xmlData = shiftBean.operationArea;
                            if (!(shiftBean.mExtension == null || shiftBean.mExtension.mLogData == null)) {
                                HashMap hashMap3 = new HashMap();
                                next.info.cardModel.extraLogData = shiftBean.getExtraLog(hashMap3);
                            }
                            doPublish(BaseEventKeys.Confirm.EVENT_CONFORM_START_END, next.info.cardModel);
                            doPublish(BaseEventKeys.Confirm.EVENT_CONFORM_MAP_INFO, next.info.mapModel);
                            GLog.m7965d(f12476a, "click shift btn");
                        }
                    }
                }
                m8482a(shiftBean);
            }
        }
    }

    /* renamed from: b */
    private void m8484b() {
        HashMap hashMap = new HashMap();
        hashMap.put("k", "show");
        hashMap.put(GlobalPayOmegaConstant.EventKey.TAB, GPageIdConstant.G_PAGE_ID_CONF);
        trackEventEstimateId(hashMap, "noFrequencyClickTrackEvent");
        GlobalOmegaUtils.trackEvent("ibt_gp_minibus_shift_none_sw", (Map<String, Object>) hashMap);
    }

    /* renamed from: a */
    private void m8482a(ShiftBean shiftBean) {
        HashMap hashMap = new HashMap();
        hashMap.put("k", "click");
        hashMap.put(GlobalPayOmegaConstant.EventKey.TAB, GPageIdConstant.G_PAGE_ID_CONF);
        m8483a(hashMap, shiftBean);
        trackEventEstimateId(hashMap, "confirmClickTrackEvent");
        GlobalOmegaUtils.trackEvent("ibt_gp_minibus_shift_next_ck", (Map<String, Object>) hashMap);
    }

    public void trackEventEstimateId(Map<String, Object> map, String str) {
        AnyCarEstimateItemModel selectedSingleAnyCarItem;
        ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
        if (confirmListener == null || (selectedSingleAnyCarItem = confirmListener.getSelectedSingleAnyCarItem()) == null) {
            EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
            if (newEstimateItem == null || newEstimateItem.carConfig == null || TextUtils.isEmpty(newEstimateItem.carConfig.estimateId)) {
                GLog.m7968e(f12476a, str + " >> estimateId is null");
                return;
            }
            map.put("pre_bubble_id", newEstimateItem.carConfig.estimateId);
        } else if (selectedSingleAnyCarItem.mAnyCarEstimateNetItem.carConfig != null && !TextUtils.isEmpty(selectedSingleAnyCarItem.mAnyCarEstimateNetItem.carConfig.estimateId)) {
            map.put("pre_bubble_id", selectedSingleAnyCarItem.mAnyCarEstimateNetItem.carConfig.estimateId);
        }
    }

    /* renamed from: a */
    private void m8483a(Map<String, Object> map, ShiftBean shiftBean) {
        if (shiftBean != null && shiftBean.mExtension != null && shiftBean.mExtension.mLogData != null) {
            try {
                HashMap hashMap = (HashMap) new Gson().fromJson((JsonElement) shiftBean.mExtension.mLogData, new TypeToken<HashMap<String, Object>>() {
                }.getType());
                if (!CollectionUtils.isEmpty((Map) hashMap)) {
                    map.putAll(hashMap);
                }
            } catch (JsonSyntaxException e) {
                GLog.m7968e(f12476a, "setLogDataMap " + e.toString());
            }
        }
    }
}
