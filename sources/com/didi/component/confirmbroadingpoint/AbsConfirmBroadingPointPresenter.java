package com.didi.component.confirmbroadingpoint;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.HighlightUtil;
import com.didi.component.business.util.NationComponentDataUtil;
import com.didi.component.business.xpanel.sdk.IGlobalXPanelControllerInflater;
import com.didi.component.business.xpanel.sdk.controllers.IXPanelBaseController;
import com.didi.component.common.base.BaseExpressPresenter;
import com.didi.component.common.util.FireBaseEventUtils;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.map.global.component.departure.model.DepartureAddress;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.sdk.util.Utils;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didi.travel.psnger.model.response.EstimateItem;
import com.didi.travel.psnger.model.response.GlobalRichInfo;
import com.didi.travel.psnger.model.response.TaxiCompanyListModel;
import com.didi.travel.psnger.model.response.estimate.CarExtraLogModel;
import com.didi.travel.psnger.model.response.estimate.EstimateItemModel;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.sdk.poibase.model.poi.FenceInfo;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;

public abstract class AbsConfirmBroadingPointPresenter extends BaseExpressPresenter<IConfirmBroadingPointView> implements IGlobalXPanelControllerInflater {
    protected static final int SUB_TITLE_TYPE_NORMAL = 0;
    protected static final int SUB_TITLE_TYPE_WARNING = 1;

    /* renamed from: l */
    private static final int f12632l = 1000;

    /* renamed from: a */
    BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f12633a = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            AbsConfirmBroadingPointPresenter.this.m8597a((Runnable) new Runnable() {
                public void run() {
                    AbsConfirmBroadingPointPresenter.this.onDepartureLoading();
                }
            });
        }
    };

    /* renamed from: b */
    BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f12634b = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            AbsConfirmBroadingPointPresenter.this.m8597a((Runnable) new Runnable() {
                public void run() {
                    AbsConfirmBroadingPointPresenter.this.onDepartureLoaded();
                }
            });
        }
    };

    /* renamed from: c */
    BaseEventPublisher.OnEventListener<Address> f12635c = new BaseEventPublisher.OnEventListener<Address>() {
        public void onEvent(String str, final Address address) {
            AbsConfirmBroadingPointPresenter.this.m8597a((Runnable) new Runnable() {
                public void run() {
                    AbsConfirmBroadingPointPresenter.this.onDepartureAddressLoadSucceed(true, address);
                }
            });
        }
    };

    /* renamed from: d */
    BaseEventPublisher.OnEventListener<Address> f12636d = new BaseEventPublisher.OnEventListener<Address>() {
        public void onEvent(String str, final Address address) {
            Logger a = AbsConfirmBroadingPointPresenter.this.f12643k;
            a.info("AbsConfirmBroadingPointPresenter  :onEvent" + str + ", Address:" + address, new Object[0]);
            AbsConfirmBroadingPointPresenter.this.m8597a((Runnable) new Runnable() {
                public void run() {
                    AbsConfirmBroadingPointPresenter.this.onDepartureAddressLoadSucceed(false, address);
                }
            });
        }
    };

    /* renamed from: e */
    BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f12637e = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            Logger a = AbsConfirmBroadingPointPresenter.this.f12643k;
            a.info("AbsConfirmBroadingPointPresenter  :onEvent" + str, new Object[0]);
            AbsConfirmBroadingPointPresenter.this.m8599b();
            AbsConfirmBroadingPointPresenter.this.enableConfirm(false);
            AbsConfirmBroadingPointPresenter.this.enableContent(false);
        }
    };

    /* renamed from: f */
    BaseEventPublisher.OnEventListener<Address> f12638f = new BaseEventPublisher.OnEventListener<Address>() {
        public void onEvent(String str, Address address) {
            Logger a = AbsConfirmBroadingPointPresenter.this.f12643k;
            a.info("AbsConfirmBroadingPointPresenter  :onEvent" + str + ", Address:" + address, new Object[0]);
            AbsConfirmBroadingPointPresenter.this.m8599b();
            if (AbsConfirmBroadingPointPresenter.this.mEditResult == 0) {
                AbsConfirmBroadingPointPresenter.this.mEditResult = 1;
            }
        }
    };

    /* renamed from: g */
    BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f12639g = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            Logger a = AbsConfirmBroadingPointPresenter.this.f12643k;
            a.info("AbsConfirmBroadingPointPresenter  :onEvent" + str, new Object[0]);
            AbsConfirmBroadingPointPresenter.this.onConfirmClicked();
        }
    };

    /* renamed from: h */
    BaseEventPublisher.OnEventListener<DepartureAddress> f12640h = new BaseEventPublisher.OnEventListener<DepartureAddress>() {
        public void onEvent(String str, DepartureAddress departureAddress) {
            Logger a = AbsConfirmBroadingPointPresenter.this.f12643k;
            a.info("AbsConfirmBroadingPointPresenter  :onEvent" + str, new Object[0]);
            if (AbsConfirmBroadingPointPresenter.this.mEditResult >= 0) {
                if (!(AbsConfirmBroadingPointPresenter.this.mDepartureAddress == null || departureAddress == null || departureAddress.getDepartureDisplayName() == null || !departureAddress.getDepartureDisplayName().equalsIgnoreCase(AbsConfirmBroadingPointPresenter.this.mDepartureAddress.getDepartureDisplayName()))) {
                    AbsConfirmBroadingPointPresenter.this.mEditResult = 0;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("result", Integer.valueOf(AbsConfirmBroadingPointPresenter.this.mEditResult));
                GlobalOmegaUtils.trackEvent("gp_pickuplocation_change_check", (Map<String, Object>) hashMap);
                AbsConfirmBroadingPointPresenter.this.mEditResult = -1;
            }
            AbsConfirmBroadingPointPresenter.this.mDepartureAddress = departureAddress;
        }
    };

    /* renamed from: i */
    BaseEventPublisher.OnEventListener<Boolean> f12641i = new BaseEventPublisher.OnEventListener<Boolean>() {
        public void onEvent(String str, Boolean bool) {
            if (bool.booleanValue()) {
                AbsConfirmBroadingPointPresenter absConfirmBroadingPointPresenter = AbsConfirmBroadingPointPresenter.this;
                absConfirmBroadingPointPresenter.setTitle(ResourcesHelper.getString(absConfirmBroadingPointPresenter.mContext, R.string.global_confirm_broading_title_in_onservice));
                return;
            }
            AbsConfirmBroadingPointPresenter absConfirmBroadingPointPresenter2 = AbsConfirmBroadingPointPresenter.this;
            absConfirmBroadingPointPresenter2.setTitle(ResourcesHelper.getString(absConfirmBroadingPointPresenter2.mContext, R.string.global_confirm_broading_title_error_in_onservice));
        }
    };
    protected boolean isFirstEnter;

    /* renamed from: j */
    Runnable f12642j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public final Logger f12643k = LoggerFactory.getLogger(getClass());

    /* renamed from: m */
    private int f12644m = 0;
    protected IXPanelBaseController mBaseController;
    protected DepartureAddress mDepartureAddress;
    protected int mEditResult = -1;

    /* renamed from: n */
    private boolean f12645n = false;

    /* access modifiers changed from: protected */
    public int getDistanceThresholdForPrice() {
        return 1000;
    }

    public void onTryAgainClicked() {
    }

    /* access modifiers changed from: private */
    @Deprecated
    /* renamed from: b */
    public void m8599b() {
        this.f12645n = true;
        if (this.f12644m == 0) {
            ((IConfirmBroadingPointView) this.mView).hideSubTitle();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8597a(Runnable runnable) {
        Runnable runnable2 = this.f12642j;
        if (runnable2 != null) {
            UiThreadHandler.removeCallbacks(runnable2);
        }
        this.f12642j = runnable;
        UiThreadHandler.postOnceDelayed(runnable, 300);
    }

    public AbsConfirmBroadingPointPresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        this.isFirstEnter = true;
        registerListener();
        m8602c();
    }

    /* renamed from: c */
    private void m8602c() {
        Address departureAddress = FormStore.getInstance().getDepartureAddress();
        if (departureAddress == null) {
            departureAddress = FormStore.getInstance().getStartAddress();
        }
        if (departureAddress == null || TextUtil.isEmpty(departureAddress.getDisplayName())) {
            showLoading();
        } else {
            updateContent(true, departureAddress);
        }
    }

    /* access modifiers changed from: protected */
    public void registerListener() {
        subscribe(BaseEventKeys.Confirm.EVENT_TO_FORM_DEPARTURE_LOADING, this.f12633a);
        subscribe(BaseEventKeys.Confirm.EVENT_TO_FORM_DEPARTURE_LOADED, this.f12634b);
        subscribe("event_confirm_boarding_enable_city", this.f12635c);
        subscribe(BaseEventKeys.Confirm.EVENT_CONFIRM_BOARDING_UNENABLE_CITY, this.f12636d);
        subscribe(BaseEventKeys.Confirm.EVENT_TO_FORM_DEPARTURE_START_DRAG, this.f12637e);
        subscribe(BaseEventKeys.Confirm.EVENT_CONFIRM_GET_ON_SUG_PAGE_CHANGE_ADDRESS, this.f12638f);
        subscribe(BaseEventKeys.Confirm.EVENT_CONFIRM_SEND_BUTTON_CLICK, this.f12639g);
        subscribe(BaseEventKeys.Confirm.EVENT_TO_FORM_DEPARTURE_LOAD_SUCCESS, this.f12640h);
        subscribe(BaseEventKeys.OnService.EVENT_UPDATE_PICK_UP_AREA_STATUS_CHANGE, this.f12641i);
    }

    /* access modifiers changed from: protected */
    public void unregisterListener() {
        unsubscribe(BaseEventKeys.Confirm.EVENT_TO_FORM_DEPARTURE_LOADING, this.f12633a);
        unsubscribe(BaseEventKeys.Confirm.EVENT_TO_FORM_DEPARTURE_LOADED, this.f12634b);
        unsubscribe("event_confirm_boarding_enable_city", this.f12635c);
        unsubscribe(BaseEventKeys.Confirm.EVENT_CONFIRM_BOARDING_UNENABLE_CITY, this.f12636d);
        unsubscribe(BaseEventKeys.Confirm.EVENT_TO_FORM_DEPARTURE_START_DRAG, this.f12637e);
        unsubscribe(BaseEventKeys.Confirm.EVENT_CONFIRM_GET_ON_SUG_PAGE_CHANGE_ADDRESS, this.f12638f);
        unsubscribe(BaseEventKeys.Confirm.EVENT_CONFIRM_SEND_BUTTON_CLICK, this.f12639g);
        unsubscribe(BaseEventKeys.Confirm.EVENT_TO_FORM_DEPARTURE_LOAD_SUCCESS, this.f12640h);
        unsubscribe(BaseEventKeys.OnService.EVENT_UPDATE_PICK_UP_AREA_STATUS_CHANGE, this.f12641i);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        unregisterListener();
        stopLoading();
    }

    /* access modifiers changed from: protected */
    public void onDepartureLoading() {
        enableConfirm(false);
        showLoading();
    }

    /* access modifiers changed from: protected */
    public void onDepartureLoaded() {
        enableConfirm(true);
        enableContent(true);
        stopLoading();
    }

    /* access modifiers changed from: protected */
    public void onDepartureAddressLoadSucceed(boolean z, Address address) {
        Logger logger = this.f12643k;
        logger.info(" AbsConfirmBroadingPointPresenter  >> " + z + ":" + address, new Object[0]);
        if (z) {
            enableConfirm(true);
        } else {
            enableConfirm(false);
        }
        if (address != null) {
            DepartureAddress departureAddress = this.mDepartureAddress;
            FenceInfo fenceInfo = departureAddress != null ? departureAddress.getFenceInfo() : null;
            if (fenceInfo != null && this.mDepartureAddress.getZoneType() == 1) {
                address.setDisplayName(fenceInfo.displayName);
            }
            updateContent(z, address);
            this.isFirstEnter = false;
        }
    }

    /* access modifiers changed from: protected */
    public boolean setTitleFromServer(Boolean bool, Address address) {
        if (!TextUtils.isEmpty(address.mainTitleDesc) && (!FormStore.getInstance().isCarPoolLineBeforeHaveOrder() || FormStore.getInstance().isTwoPriceBiz() || FormStore.getInstance().isNotMatchDiscount())) {
            GlobalRichInfo globalRichInfo = new GlobalRichInfo();
            globalRichInfo.setInfo(address.mainTitleDesc);
            if (TextUtils.isEmpty(globalRichInfo.getContent())) {
                setTitle(ResourcesHelper.getString(this.mContext, R.string.global_confirm_recommend_default_tips));
                hideSubTitle();
                return true;
            }
            globalRichInfo.bindTextView(((IConfirmBroadingPointView) this.mView).getMainTitleView());
            GlobalRichInfo globalRichInfo2 = new GlobalRichInfo();
            globalRichInfo2.setInfo(address.subTitleDesc);
            if (!TextUtils.isEmpty(globalRichInfo2.getContent())) {
                setSubTitleColor(ResourcesHelper.getColor(this.mContext, R.color.global_broading_point_subtitle_txt));
                ((IConfirmBroadingPointView) this.mView).showSubTitle();
                globalRichInfo2.bindTextView(((IConfirmBroadingPointView) this.mView).getSubTitleView());
            } else {
                hideSubTitle();
            }
            return true;
        } else if (bool.booleanValue()) {
            return false;
        } else {
            setTitle(ResourcesHelper.getString(this.mContext, R.string.global_confirm_recommend_default_tips));
            hideSubTitle();
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void updateContent(boolean z, Address address) {
        enableContent(true);
        if (z) {
            m8598a(address.displayName);
            Logger logger = this.f12643k;
            logger.info(" AbsConfirmBroadingPointPresenter  >> cityEnable:" + z + " displayName:" + address.displayName + " depLat:" + address.getLatitude() + " depLng:" + address.getLongitude() + ": mDepartureAddress:" + this.mDepartureAddress, new Object[0]);
            if (FormStore.getInstance().isCarPoolLineBeforeHaveOrder() && !FormStore.getInstance().isTwoPriceBiz() && !FormStore.getInstance().isNotMatchDiscount()) {
                setTitle(ResourcesHelper.getString(this.mContext, R.string.global_confirm_carpool_title));
                return;
            }
            return;
        }
        m8604d();
    }

    /* access modifiers changed from: protected */
    public void setRecommendSubTitle(int i) {
        if (i < 2) {
            setSubTitleColor(ResourcesHelper.getColor(this.mContext, R.color.gray));
            setSubTitle(ResourcesHelper.getString(this.mContext, R.string.global_confirm_recommend_tips));
        } else if (i == 2) {
            setSubTitle(ResourcesHelper.getString(this.mContext, R.string.global_confirm_recommend_one_point));
        } else {
            Context context = this.mContext;
            StringBuilder sb = new StringBuilder();
            sb.append(i - 1);
            sb.append("");
            setSubTitle(ResourcesHelper.getString(context, R.string.global_confirm_recommend_more_than_one, sb.toString()));
        }
    }

    /* renamed from: d */
    private void m8604d() {
        setTitle(ResourcesHelper.getString(this.mContext, R.string.global_confirm_broading_title_unable));
        hideSubTitle();
    }

    /* renamed from: a */
    private void m8598a(String str) {
        if (!TextUtils.isEmpty(str)) {
            setContent(onProcessBoardingPointContent(str));
        } else {
            setContent(ResourcesHelper.getString(this.mContext, R.string.global_confirm_current_location));
        }
    }

    /* access modifiers changed from: protected */
    public void setDefaultSubTitle(double d, double d2, boolean z) {
        Address startAddress = FormStore.getInstance().getStartAddress();
        if ((startAddress != null ? DIDILocation.distanceBetween(startAddress.latitude, startAddress.longitude, d, d2) : 0.0d) > ((double) getDistanceThresholdForPrice())) {
            GlobalOmegaUtils.trackEvent("pas_pickuptoofar_sw");
            setSubTitleWarning(ResourcesHelper.getString(this.mContext, R.string.global_confirm_broading_subtitle_too_far));
        } else if (FormStore.getInstance().isCarPoolLineBeforeHaveOrder() && !FormStore.getInstance().isTwoPriceBiz() && !FormStore.getInstance().isNotMatchDiscount()) {
            setSubTitle(ResourcesHelper.getString(this.mContext, R.string.global_confirm_carpool_subtitle), 1);
        } else if (!z) {
            hideSubTitle();
        }
    }

    /* access modifiers changed from: protected */
    public String onProcessBoardingPointContent(String str) {
        if (!FormStore.getInstance().isCarPoolLineBeforeHaveOrder() || FormStore.getInstance().isTwoPriceBiz() || FormStore.getInstance().isNotMatchDiscount()) {
            return str;
        }
        return this.mContext.getResources().getString(R.string.global_confirm_carpool_content, new Object[]{str});
    }

    public void setTitle(CharSequence charSequence) {
        ((IConfirmBroadingPointView) this.mView).setTitle(charSequence);
    }

    @Deprecated
    public void setSubTitle(CharSequence charSequence, int i) {
        this.f12644m = i;
        if (!this.f12645n || i != 0) {
            ((IConfirmBroadingPointView) this.mView).showSubTitle();
            ((IConfirmBroadingPointView) this.mView).setSubTitle(charSequence);
            return;
        }
        ((IConfirmBroadingPointView) this.mView).hideSubTitle();
    }

    public void setSubTitle(CharSequence charSequence) {
        ((IConfirmBroadingPointView) this.mView).showSubTitle();
        ((IConfirmBroadingPointView) this.mView).setSubTitle(charSequence);
    }

    public void setSubTitleWarning(CharSequence charSequence) {
        setSubTitle(HighlightUtil.highlight(Const.joLeft + charSequence + "}", 0, ResourcesHelper.getColor(this.mContext, R.color.g_color_FFFF525D)));
    }

    public void hideSubTitle() {
        ((IConfirmBroadingPointView) this.mView).hideSubTitle();
    }

    public void setSubTitleColor(int i) {
        ((IConfirmBroadingPointView) this.mView).setSubTitleColor(i);
    }

    public void setContent(CharSequence charSequence) {
        ((IConfirmBroadingPointView) this.mView).setContent(charSequence);
    }

    public void setContentColor(int i) {
        ((IConfirmBroadingPointView) this.mView).setContentColor(i);
    }

    public void showLoading() {
        ((IConfirmBroadingPointView) this.mView).showLoading();
    }

    public void stopLoading() {
        ((IConfirmBroadingPointView) this.mView).stopLoading();
    }

    public void showError() {
        ((IConfirmBroadingPointView) this.mView).showError();
    }

    public void enableConfirm(boolean z) {
        ((IConfirmBroadingPointView) this.mView).enableConfirm(z);
    }

    public void enableContent(boolean z) {
        ((IConfirmBroadingPointView) this.mView).enableContent(z);
    }

    public void setConfirmAction(String str) {
        ((IConfirmBroadingPointView) this.mView).setConfirmAction(str);
    }

    public void onConfirmClicked() {
        if (Utils.isFastDoubleClick()) {
        }
    }

    public void onAddressClicked() {
        doPublish(BaseEventKeys.Confirm.EVENT_SHOW_SUG_PAGE);
        FormStore instance = FormStore.getInstance();
        Address startAddress = instance.getStartAddress();
        HashMap hashMap = new HashMap();
        if (startAddress != null) {
            hashMap.put("from_poi_id", startAddress.poiId == null ? "" : startAddress.poiId);
            hashMap.put("from_lat", Double.valueOf(startAddress.getLatitude()));
            hashMap.put("from_lng", Double.valueOf(startAddress.getLongitude()));
        }
        EstimateItemModel newEstimateItem = instance.getNewEstimateItem();
        if (newEstimateItem != null) {
            hashMap.put("bubble_id", newEstimateItem.estimateId);
        }
        OmegaSDKAdapter.trackEvent("pas_pickupconfirm_input_ck", (Map<String, Object>) hashMap);
    }

    public void onEditClicked() {
        this.mEditResult = 0;
        GlobalOmegaUtils.trackEvent("pas_pickupconfirm_edit_ck");
    }

    public void onSizeChanged(int i) {
        doPublish(BaseEventKeys.XPanel.EVENT_HEIGHT_CHANGED, Integer.valueOf(i));
    }

    /* access modifiers changed from: protected */
    public void trackSubmit() {
        String str;
        FormStore instance = FormStore.getInstance();
        Address startAddress = instance.getStartAddress();
        Address endAddress = instance.getEndAddress();
        EstimateItem estimateItem = instance.getEstimateItem();
        String payWayMsg = instance.getPayWayMsg();
        int carLevel = instance.getCarLevel();
        long transportTime = instance.getTransportTime();
        ArrayMap arrayMap = new ArrayMap();
        if (startAddress != null) {
            arrayMap.put("from_addr", !TextUtils.isEmpty(startAddress.address) ? startAddress.address : startAddress.displayName);
            arrayMap.put("from_lng", Double.valueOf(startAddress.longitude));
            arrayMap.put("from_lat", Double.valueOf(startAddress.latitude));
            arrayMap.put("from_poi_id", startAddress.poiId);
            arrayMap.put("from_search_id", startAddress.searchId);
            arrayMap.put("from_srctag", startAddress.getSrcTag());
        }
        if (endAddress != null) {
            arrayMap.put("to_addr", !TextUtils.isEmpty(endAddress.address) ? endAddress.address : endAddress.displayName);
            arrayMap.put("to_lng", Double.valueOf(endAddress.longitude));
            arrayMap.put("to_lat", Double.valueOf(endAddress.latitude));
            arrayMap.put(ParamKeys.PARAM_TO_POI_UID, endAddress.poiId);
            arrayMap.put("to_search_id", endAddress.searchId == null ? "" : endAddress.searchId);
            arrayMap.put("to_srctag", endAddress.getSrcTag());
        }
        int i = 1;
        arrayMap.put("is_reservation", Integer.valueOf(transportTime > 0 ? 1 : 0));
        arrayMap.put(ParamKeys.PARAM_MODE, instance.Sid);
        arrayMap.put("cartype", Integer.valueOf(carLevel));
        arrayMap.put("payment", payWayMsg);
        EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
        if (newEstimateItem != null) {
            arrayMap.put("dynamic", 0);
            arrayMap.put("has_surgedprice", 1);
            arrayMap.put("fixed", FormStore.getInstance().isQuotaInCurEstimateItem() ? "1" : "0");
            arrayMap.put("has_tips", 0);
        }
        float f = 0.0f;
        if (!(newEstimateItem == null || newEstimateItem.carConfig == null || newEstimateItem.carConfig.extraData == null || newEstimateItem.carConfig.extraData.getExtraLog() == null)) {
            CarExtraLogModel extraLog = newEstimateItem.carConfig.extraData.getExtraLog();
            if (!TextUtils.isEmpty(extraLog.originFee)) {
                try {
                    f = Float.parseFloat(extraLog.originFee);
                } catch (Exception unused) {
                }
            }
        }
        if (newEstimateItem != null) {
            arrayMap.put("origin_fee", Float.valueOf(f));
            arrayMap.put("bubble_id", newEstimateItem.estimateId);
            arrayMap.put("price_estimated", Float.valueOf(newEstimateItem.feeNumber));
        }
        arrayMap.put("eta", Integer.valueOf(instance.getEta()));
        assembleEstimateData(arrayMap, estimateItem);
        if (!FormStore.getInstance().hasChangeAddressType(1) && !FormStore.getInstance().hasChangeAddressType(2)) {
            i = 0;
        }
        arrayMap.put("editaddr", Integer.valueOf(i));
        TaxiCompanyListModel.CompanyModel curCompany = instance.getCurCompany();
        if (curCompany != null) {
            if ("0".equals(curCompany.f44227id)) {
                str = "All";
            } else {
                str = "1".equals(curCompany.f44227id) ? "nopickupfeegroup" : curCompany.f44227id;
            }
            arrayMap.put("CompanyChoice", str);
        }
        GlobalOmegaUtils.trackEvent("pas_orderconfirm_submit_ck", (Map<String, Object>) arrayMap);
        FireBaseEventUtils.traceEvent("pas_orderconfirm_submit_ck", false);
    }

    /* access modifiers changed from: protected */
    public void assembleEstimateData(Map map, EstimateItem estimateItem) {
        EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
        int i = 1;
        if (newEstimateItem == null) {
            map.put("isestimated", 1);
            map.put("ispaymenterror", 1);
            return;
        }
        int i2 = (!NationComponentDataUtil.isLoginNow() || !(estimateItem.payWayList == null || estimateItem.payWayList.size() == 0)) ? 0 : 1;
        if (!Float.isNaN(newEstimateItem.feeNumber) && newEstimateItem.feeNumber != 0.0f) {
            i = 0;
        }
        map.put("isestimated", Integer.valueOf(i));
        map.put("ispaymenterror", Integer.valueOf(i2));
    }

    public void inflateController(IXPanelBaseController iXPanelBaseController) {
        this.mBaseController = iXPanelBaseController;
    }

    public void trackEvent() {
        HashMap hashMap = new HashMap();
        Address endAddress = FormStore.getInstance().getEndAddress();
        hashMap.put("passenger_id", NationComponentDataUtil.getLoginInfo().getUid());
        hashMap.put("point_name", endAddress != null ? endAddress.name : "");
        hashMap.put(ParamKeys.PARAM_PASSENGER_PHONE, NationComponentDataUtil.getPhone());
        GlobalOmegaUtils.trackEvent("select_destination_in_map_confirm", (Map<String, Object>) hashMap);
    }
}
