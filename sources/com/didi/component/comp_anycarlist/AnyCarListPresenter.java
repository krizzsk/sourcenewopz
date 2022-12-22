package com.didi.component.comp_anycarlist;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.didi.component.business.constant.BaseConstants;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.constant.BaseExtras;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.data.form.PageCompDataTransfer;
import com.didi.component.business.data.form.listener.ConfirmListener;
import com.didi.component.business.pageswitchparam.BackToConfirmParam;
import com.didi.component.business.tracker.anycar.AnycarTrack;
import com.didi.component.business.util.GlobalApolloUtil;
import com.didi.component.business.util.GlobalSPUtil;
import com.didi.component.business.xengine.XERequestKey;
import com.didi.component.common.bff.BFFStore;
import com.didi.component.common.dialog.ImageHintDialogInfo;
import com.didi.component.common.helper.SceneHelper;
import com.didi.component.common.net.CarRequest;
import com.didi.component.common.net.CarServerParam;
import com.didi.component.common.util.GsonUtils;
import com.didi.component.comp_anycarlist.utils.AnycarEstimateOmegaUtil;
import com.didi.component.estimate.view.guidedialog.NewbieDialogManager;
import com.didi.sdk.app.DIDIApplication;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.misconfig.p153v2.ConfProxy;
import com.didi.sdk.util.AppUtils;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didi.travel.psnger.common.net.base.ResponseListener;
import com.didi.travel.psnger.core.model.request.EstimateParams;
import com.didi.travel.psnger.model.response.PinCodeInfoResult;
import com.didi.travel.psnger.model.response.anycar.AnyCarEstimate;
import com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel;
import com.didi.travel.psnger.model.response.anycar.AnyCarGroup;
import com.didi.travel.psnger.model.response.estimate.CarOperationDataModel;
import com.didi.travel.psnger.model.response.estimate.daijiao.FriendItem;
import com.didi.travel.psnger.store.DDTravelConfigStore;
import com.didi.travel.psnger.utils.NumberUtil;
import com.didi.travel.psnger.utils.TextUtil;
import com.didi.xengine.callback.XEReqJSONParamsCallbackImpl;
import com.didi.xengine.register.XERegister;
import com.didiglobal.enginecore.callback.XEResponseCallback;
import com.didiglobal.enginecore.component.XEComponent;
import com.didiglobal.enginecore.data.exception.EngineErrorException;
import com.didiglobal.enginecore.data.model.XEngineData;
import com.didiglobal.enginecore.register.XERegisterModel;
import com.didiglobal.travel.util.CollectionUtils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.taxis99.R;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class AnyCarListPresenter extends AbsAnyCarListPresenter {
    public static final int REQUEST_FROM_GOOGLE_MAP = 1;

    /* renamed from: a */
    private static final int f12109a = 101;

    /* renamed from: b */
    private int f12110b = -1;

    /* renamed from: c */
    private boolean f12111c;

    /* renamed from: d */
    private List<AnyCarEstimateItemModel> f12112d;

    /* renamed from: e */
    private XEResponseCallback f12113e = new XEResponseCallback() {
        public void onSuccess(String str, XEngineData xEngineData, List<XEComponent> list) {
            if (xEngineData != null) {
                AnyCarListPresenter.this.m8168a(xEngineData.jsonObject);
            } else {
                AnyCarListPresenter.this.doPublish(BaseEventKeys.AnyCar.ANYCAR_EYEBALL_RESPONSE, false);
                AnycarTrack.anycarMonitorTrack(AnycarTrack.mSceneAnycarResponse, (Map<String, Object>) null);
            }
            AnyCarListPresenter.this.m8171b();
        }

        public void onFailed(String str, EngineErrorException engineErrorException) {
            AnyCarListPresenter.this.doPublish(BaseEventKeys.AnyCar.ANYCAR_EYEBALL_RESPONSE, false);
            AnyCarListPresenter.this.m8171b();
        }
    };

    /* renamed from: f */
    private XEReqJSONParamsCallbackImpl f12114f = new XEReqJSONParamsCallbackImpl() {
        public JSONObject getRequestParams() {
            EstimateParams b = AnyCarListPresenter.this.m8174c();
            b.setUserType(BFFStore.getCarWanliuUserType(DIDIApplication.getAppContext()));
            return new JSONObject(b.getParams());
        }
    };
    protected final Logger mLogger = LoggerFactory.getLogger(getClass());

    public AnyCarListPresenter(Context context) {
        super(context);
    }

    public void bubbleSelected(AnyCarEstimateItemModel anyCarEstimateItemModel) {
        if (anyCarEstimateItemModel != null) {
            bubbleSelectUpload(anyCarEstimateItemModel);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m8171b() {
        doPublish(BaseEventKeys.Estimate.ESTIMATE_CALLBACK_FINISH);
        FormStore.getInstance().setEstimateTime(System.currentTimeMillis());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8168a(JsonObject jsonObject) {
        if (getHost() == null || getHost().getActivity() == null || jsonObject == null || TextUtils.isEmpty(jsonObject.toString())) {
            doPublish(BaseEventKeys.AnyCar.ANYCAR_EYEBALL_RESPONSE, false);
        } else {
            m8169a(jsonObject.toString());
        }
    }

    /* renamed from: a */
    private void m8169a(String str) {
        if (str != null) {
            try {
                JSONObject optJSONObject = new JSONObject(str).optJSONObject("data");
                if (optJSONObject != null) {
                    m8172b(optJSONObject.toString());
                }
            } catch (JSONException e) {
                e.printStackTrace();
                doPublish(BaseEventKeys.AnyCar.ANYCAR_EYEBALL_RESPONSE, false);
                AnycarTrack.anycarMonitorTrack(AnycarTrack.mSceneAnycarResponse, (Map<String, Object>) null);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public EstimateParams m8174c() {
        String str;
        FriendItem selectedFriend;
        List<AnyCarEstimateItemModel> list;
        CarOperationDataModel.AnycarCarpoolSeat anycarCarpoolSeat;
        FormStore instance = FormStore.getInstance();
        EstimateParams estimateParams = new EstimateParams();
        if (FormStore.getInstance().isFromOpenRide()) {
            estimateParams.setFormOpenRide(true);
            PinCodeInfoResult driverInfo = FormStore.getInstance().getDriverInfo();
            if (driverInfo != null) {
                int parseInt = NumberUtil.parseInt(driverInfo.carLevel);
                estimateParams.setProductId(NumberUtil.parseInt(driverInfo.driverProductId));
                estimateParams.setRequireLevel(parseInt);
                estimateParams.setComboType(500);
            }
        } else {
            estimateParams.setFormOpenRide(false);
        }
        if (this.f12110b != -1 && SceneHelper.getInstance().isDeepLinkFromGoogle) {
            estimateParams.setProductId(this.f12110b);
            estimateParams.setComboType(0);
            estimateParams.setRequireLevel(FormStore.getInstance().getCarLevel());
            estimateParams.setRequestSource(1);
        }
        estimateParams.setDepartureTime(instance.getTransportTime());
        estimateParams.setStartAddress(instance.getStartAddress());
        estimateParams.setEndAddress(instance.getEndAddress());
        estimateParams.setWayPointAddressList(instance.getWayPointAddressListJsonArray());
        estimateParams.fixedPrice = false;
        if (instance.getCurCompany() != null) {
            estimateParams.curCompanyId = instance.getCurCompany().f44227id;
        }
        ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
        if (confirmListener == null || !confirmListener.isConfirmAddressPage()) {
            estimateParams.setUser_input_price((String) null);
        } else {
            estimateParams.setUser_input_price(instance.getInputOfferPrice());
        }
        if (confirmListener == null || !confirmListener.getIsAnyCar()) {
            str = FormStore.getInstance().getNewEstimateItem() != null ? "eyeball" : "";
        } else {
            str = "anycar";
        }
        estimateParams.addParam("last_estimate", str);
        if (confirmListener != null) {
            estimateParams.setAnyCarPreference(confirmListener.getPreference());
        }
        if (confirmListener != null) {
            int currentPage = confirmListener.getCurrentPage();
            if (currentPage == 1) {
                estimateParams.addParam("price_change_check", 0);
            } else if (currentPage == 3) {
                estimateParams.addParam("price_change_check", 1);
                AnyCarEstimateItemModel selectedSingleAnyCarItem = confirmListener.getSelectedSingleAnyCarItem();
                if (!(selectedSingleAnyCarItem == null || selectedSingleAnyCarItem.mAnyCarEstimateNetItem.carConfig == null || selectedSingleAnyCarItem.mAnyCarEstimateNetItem.carConfig.extraData == null || selectedSingleAnyCarItem.mAnyCarEstimateNetItem.carConfig.extraData.orderParamsObject == null)) {
                    try {
                        estimateParams.addParam("single_product_selected", new JSONObject(selectedSingleAnyCarItem.mAnyCarEstimateNetItem.carConfig.extraData.orderParamsObject.toString()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        if (confirmListener != null) {
            if (this.f12111c) {
                list = this.f12112d;
                this.f12111c = false;
            } else {
                list = confirmListener.getSelectedAnyCarItems();
            }
            if (!CollectionUtil.isEmpty((Collection<?>) list)) {
                Iterator<AnyCarEstimateItemModel> it = list.iterator();
                while (it.hasNext()) {
                    AnyCarEstimateItemModel next = it.next();
                    JsonObject jsonObject = (next == null || next.mAnyCarEstimateNetItem.carConfig == null || next.mAnyCarEstimateNetItem.carConfig.extraData == null || next.mAnyCarEstimateNetItem.carConfig.extraData.orderParamsObject == null) ? null : next.mAnyCarEstimateNetItem.carConfig.extraData.orderParamsObject;
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
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        }
        if (arrayList.size() > 0) {
            estimateParams.setSelectProducts(arrayList);
        }
        if (confirmListener != null && !CollectionUtil.isEmpty((Collection<?>) confirmListener.getSelectedAnyCarItems())) {
            Iterator<AnyCarEstimateItemModel> it2 = confirmListener.getSelectedAnyCarItems().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                AnyCarEstimateItemModel next3 = it2.next();
                if (next3.estimatePass != null) {
                    if (next3.mAnyCarEstimateNetItem.carConfig != null) {
                        estimateParams.setPassProductId(next3.mAnyCarEstimateNetItem.carConfig.carProductId);
                    }
                    if (FormStore.getInstance().isEstimatePassConfirm()) {
                        estimateParams.setPassBuyChoose(2);
                    } else {
                        estimateParams.setPassBuyChoose(1);
                    }
                }
            }
        }
        estimateParams.setPaymentsType(FormStore.getInstance().getPayWay());
        estimateParams.setCardIndex(FormStore.getInstance().getCardIndex());
        estimateParams.setGroupType(ConfProxy.getInstance().getSelectedType());
        if (!(!FormStore.getInstance().isHasSubstituteCall() || (selectedFriend = FormStore.getInstance().getSelectedFriend()) == null || selectedFriend.getExtension() == null || selectedFriend.getExtension().getSelectValueParams() == null)) {
            try {
                HashMap hashMap = (HashMap) new Gson().fromJson((JsonElement) selectedFriend.getExtension().getSelectValueParams(), new TypeToken<HashMap<String, Object>>() {
                }.getType());
                if (!CollectionUtils.isEmpty((Map<?, ?>) hashMap) && estimateParams.getParams() != null) {
                    estimateParams.getParams().putAll(hashMap);
                }
            } catch (JsonSyntaxException e3) {
                e3.printStackTrace();
            }
        }
        if (!(confirmListener == null || confirmListener.getGroups() == null)) {
            List<AnyCarGroup> groups = confirmListener.getGroups();
            for (int i = 0; i < groups.size(); i++) {
                AnyCarGroup anyCarGroup = groups.get(i);
                if (!(anyCarGroup == null || anyCarGroup.config == null)) {
                    anyCarGroup.config.putOrderParams(estimateParams.getParams());
                }
            }
        }
        return estimateParams;
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        ConfirmListener confirmListener;
        super.onAdd(bundle);
        if (bundle != null) {
            int i = bundle.getInt(BaseConstants.ConfirmPageExtraKeys.DEFAULT_SELECT_BIZ_INT, -1);
            this.f12110b = i;
            if (i != -1 && SceneHelper.getInstance().isDeepLinkFromGoogle) {
                FormStore.getInstance().setCurrentComboType(0);
            }
            Serializable serializable = bundle.getSerializable(BaseExtras.Common.EXTRA_BACK_TO_CONFIRM);
            BackToConfirmParam backToConfirmParam = null;
            if (serializable instanceof BackToConfirmParam) {
                backToConfirmParam = (BackToConfirmParam) serializable;
            }
            if (backToConfirmParam != null && !CollectionUtil.isEmpty((Collection<?>) backToConfirmParam.mAnyCarSelectedItemModels)) {
                ((IAnyCarListView) this.mView).setInitParam(backToConfirmParam.mAnyCarSelectedItemModels);
                this.f12112d = backToConfirmParam.mAnyCarSelectedItemModels;
                this.f12111c = true;
                ConfirmListener confirmListener2 = PageCompDataTransfer.getInstance().getConfirmListener();
                if (confirmListener2 != null) {
                    confirmListener2.setSelectedAnyCarItem(this.f12112d);
                }
            }
            if (!(backToConfirmParam == null || (confirmListener = PageCompDataTransfer.getInstance().getConfirmListener()) == null)) {
                confirmListener.setCurrentPage(1);
                confirmListener.setIsAnyCar(backToConfirmParam.mIsAnyCar);
                confirmListener.setPreference(backToConfirmParam.mPreference);
                confirmListener.setGroups(backToConfirmParam.groups);
            }
        }
        XERegisterModel xERegisterModel = new XERegisterModel(XERequestKey.SingleCompRefresh.REQUEST_KEY_ANYCAR_EYEBALL, XERequestKey.SCENE_ESTIMATE, this.f12113e);
        xERegisterModel.requestParams = this.f12114f;
        XERegister.registerTemplate(xERegisterModel);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        XERegister.unregisterTemplate(XERequestKey.SingleCompRefresh.REQUEST_KEY_ANYCAR_EYEBALL);
    }

    /* renamed from: b */
    private void m8172b(String str) {
        GsonUtils.fromJsonAsync(str, AnyCarEstimate.class, new GsonUtils.OnFromJsonListener<AnyCarEstimate>() {
            public void onSuccess(AnyCarEstimate anyCarEstimate) {
                boolean z = false;
                if (anyCarEstimate != null) {
                    ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
                    if (confirmListener != null) {
                        if (anyCarEstimate.anyCarResponse != null && !CollectionUtil.isEmpty((Collection<?>) anyCarEstimate.anyCarResponse.groups)) {
                            ((IAnyCarListView) AnyCarListPresenter.this.mView).setData(anyCarEstimate.anyCarResponse.groups);
                            confirmListener.setSelectedSingleAnyCarItem((AnyCarEstimateItemModel) null);
                            AnycarEstimateOmegaUtil.trackOrderConfirmDialogShow();
                        }
                        confirmListener.setIsAnyCar(true);
                        confirmListener.setAnyCarResponse(anyCarEstimate.anyCarResponse);
                        if (anyCarEstimate.anyCarResponse != null) {
                            confirmListener.setGroups(anyCarEstimate.anyCarResponse.groups);
                            if (!(anyCarEstimate.anyCarResponse.globalConfig == null || anyCarEstimate.anyCarResponse.globalConfig.preference == null)) {
                                confirmListener.setPreference(anyCarEstimate.anyCarResponse.globalConfig.preference.userType);
                            }
                        }
                        AnyCarListPresenter anyCarListPresenter = AnyCarListPresenter.this;
                        if (!(anyCarEstimate.anyCarResponse == null || anyCarEstimate.anyCarResponse.groups == null)) {
                            z = true;
                        }
                        anyCarListPresenter.doPublish(BaseEventKeys.AnyCar.ANYCAR_EYEBALL_RESPONSE, Boolean.valueOf(z));
                        return;
                    }
                    return;
                }
                AnyCarListPresenter.this.doPublish(BaseEventKeys.AnyCar.ANYCAR_EYEBALL_RESPONSE, false);
                AnycarTrack.anycarMonitorTrack(AnycarTrack.mSceneAnycarResponse, (Map<String, Object>) null);
            }

            public void onFail() {
                AnyCarListPresenter.this.doPublish(BaseEventKeys.AnyCar.ANYCAR_EYEBALL_RESPONSE, false);
                AnycarTrack.anycarMonitorTrack(AnycarTrack.mSceneAnycarResponse, (Map<String, Object>) null);
            }
        });
    }

    /* renamed from: a */
    private String m8163a(AnyCarEstimateItemModel anyCarEstimateItemModel, int i) {
        if (anyCarEstimateItemModel == null || anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig == null) {
            return "";
        }
        if (TextUtils.isEmpty(anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig.uniqueId)) {
            return m8162a(anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig.carBussinessId, anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig.carLevel, i);
        }
        String str = anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig.uniqueId + "_" + i;
        SceneHelper.getInstance().setLatestKey(str);
        return str;
    }

    /* renamed from: a */
    private String m8162a(int i, int i2, int i3) {
        String str = i + "_" + i2 + "_" + FormStore.getInstance().getCurrentComboType() + "_" + i3;
        SceneHelper.getInstance().setLatestKey(str);
        this.mLogger.info("new_guide_key", str);
        return str;
    }

    public void bubbleSelectUpload(AnyCarEstimateItemModel anyCarEstimateItemModel) {
        JsonObject jsonObject;
        String str;
        if (!(getHost() == null || anyCarEstimateItemModel == null || anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig == null)) {
            NewbieDialogManager.onInterceptNewGuideShow(getHost().getActivity(), anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig.countPriceType, anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig.carBussinessId, anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig.carLevel, anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig.carComboType, 0, m8163a(anyCarEstimateItemModel, 0));
        }
        FormStore instance = FormStore.getInstance();
        EstimateParams estimateParams = new EstimateParams();
        estimateParams.setDepartureTime(instance.getTransportTime());
        estimateParams.setStartAddress(instance.getStartAddress());
        estimateParams.setEndAddress(instance.getEndAddress());
        estimateParams.setPaymentsType(instance.getPayWay());
        estimateParams.setUserType(BFFStore.getCarWanliuUserType(this.mContext));
        JsonObject jsonObject2 = null;
        String str2 = "";
        if (anyCarEstimateItemModel == null || anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig == null) {
            jsonObject = null;
            str = str2;
        } else {
            str = anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig.estimateId;
            estimateParams.setBusinessId(anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig.carBussinessId);
            estimateParams.setCarLevelId(String.valueOf(anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig.carLevel));
            if (anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig.extraData != null) {
                jsonObject2 = anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig.extraData.orderParamsObject;
            }
            jsonObject = jsonObject2;
        }
        ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
        if (!(confirmListener == null || confirmListener.getAnyCarResponse() == null || confirmListener.getAnyCarResponse().globalConfig == null)) {
            str2 = confirmListener.getAnyCarResponse().globalConfig.globalEstimateTraceId;
        }
        if (confirmListener == null || confirmListener.getAnyCarResponse() == null) {
            this.mLogger.info("bubbleSelectUpload response is null", new Object[0]);
            return;
        }
        String str3 = confirmListener.getAnyCarResponse().globalConfig.selectItemCommitUrl;
        if (TextUtils.isEmpty(str3)) {
            this.mLogger.info("onCheckedChanged link is null", new Object[0]);
            return;
        }
        Map<String, Object> params = estimateParams.getParams();
        params.put(CarServerParam.PARAM_PRE_ESTIMATE_ID, str);
        params.put("estimate_trace_id", str2);
        CarRequest.doBubbleSelectXEngineCommit(this.mContext, params, jsonObject, str3, XERequestKey.SCENE_ESTIMATE, new ResponseListener<String>() {
            public void onFinish(String str) {
                super.onFinish(str);
                if (!TextUtils.isEmpty(str)) {
                    FormStore.getInstance().setBubbleId(str);
                }
            }
        });
        m8167a(anyCarEstimateItemModel);
    }

    /* renamed from: a */
    private void m8167a(AnyCarEstimateItemModel anyCarEstimateItemModel) {
        if (anyCarEstimateItemModel != null && anyCarEstimateItemModel.mAnyCarEstimateNetItem != null && anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig != null && anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig.isEnableFixedPricePopup() && GlobalApolloUtil.getStatus("global_fix_price_user_guide") && !GlobalSPUtil.isShowedFixedPriceTipsDialog(this.mContext)) {
            String fixedPriceCommunicationTitle = DDTravelConfigStore.getInstance().getFixedPriceCommunicationTitle(this.mContext.getString(R.string.global_estimate_fixed_price_dialog_title));
            String fixedPriceCommunicationImageUrl = DDTravelConfigStore.getInstance().getFixedPriceCommunicationImageUrl((String) null);
            String fixedPriceCommunicationContent = DDTravelConfigStore.getInstance().getFixedPriceCommunicationContent(this.mContext.getString(R.string.global_estimate_fixed_price_dialog_content));
            String fixedPriceCommunicationButton = DDTravelConfigStore.getInstance().getFixedPriceCommunicationButton(this.mContext.getString(R.string.global_estimate_fixed_price_dialog_button));
            ImageHintDialogInfo imageHintDialogInfo = new ImageHintDialogInfo(101);
            imageHintDialogInfo.setTitle(fixedPriceCommunicationTitle);
            imageHintDialogInfo.setSubtitle(fixedPriceCommunicationContent);
            imageHintDialogInfo.setImageUrl(fixedPriceCommunicationImageUrl);
            imageHintDialogInfo.setButton(fixedPriceCommunicationButton);
            imageHintDialogInfo.setCancelable(false);
            if (TextUtil.isEmpty(fixedPriceCommunicationImageUrl)) {
                imageHintDialogInfo.setImageHolder(R.drawable.global_estimate_fixed_price_dialog_bg);
            } else {
                m8164a(imageHintDialogInfo);
            }
            showDialog(imageHintDialogInfo);
            GlobalSPUtil.setShowedFixedPriceTipsDialog(this.mContext, true);
        }
    }

    /* renamed from: a */
    private void m8164a(ImageHintDialogInfo imageHintDialogInfo) {
        if (imageHintDialogInfo == null) {
            return;
        }
        if (AppUtils.isBrazilApp(DIDIApplication.getAppContext())) {
            imageHintDialogInfo.setImageHolder(1);
        } else {
            imageHintDialogInfo.setImageHolder(0);
        }
    }

    /* access modifiers changed from: protected */
    public void onDialogAction(int i, int i2) {
        super.onDialogAction(i, i2);
        if (101 == i) {
            dismissDialog(i);
        }
    }
}
