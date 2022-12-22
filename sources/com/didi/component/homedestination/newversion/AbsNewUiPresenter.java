package com.didi.component.homedestination.newversion;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.model.HomeCardModel;
import com.didi.component.business.model.LocationGuide;
import com.didi.component.business.util.GlobalApolloUtil;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.NationComponentDataUtil;
import com.didi.component.common.helper.SceneHelper;
import com.didi.component.common.util.GLog;
import com.didi.component.common.util.SearchIdUploadManager;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.IGroupView;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.homedestination.abs.AbsHomeDestinationPresenter;
import com.didi.component.homedestination.model.HomeCardListResponse;
import com.didi.component.homedestination.net.HomeGetRecRequest;
import com.didi.component.homedestination.net.HomeSafetyTrainRequest;
import com.didi.component.homedestination.newversion.AbsNewUiView;
import com.didi.map.global.flow.scene.sug.SugResult;
import com.didi.reactive.tracker.EventTracker;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.app.BusinessContext;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.travel.psnger.common.net.base.ResponseListener;
import com.didi.travel.psnger.model.response.OrderBanCardInfo;
import com.didi.travel.psnger.model.response.SafetyTrainCardInfo;
import com.didi.travel.psnger.p170v2.TravelConstant;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didi.unifylogin.listener.LoginListeners;
import com.didichuxing.omega.sdk.init.OmegaSDK;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AbsNewUiPresenter<V extends AbsNewUiView> extends AbsHomeDestinationPresenter<V> {

    /* renamed from: a */
    private static final int f14104a = 70;

    /* renamed from: b */
    private Address f14105b;

    /* renamed from: c */
    private Address f14106c;

    /* renamed from: d */
    private boolean f14107d;

    /* renamed from: e */
    private BaseEventPublisher.OnEventListener<String> f14108e = new BaseEventPublisher.OnEventListener<String>() {
        public void onEvent(String str, String str2) {
            GLog.m7965d("hgl_tag", "onEvent() category = " + str + " switch2TargetBiz = " + str2);
            if (str.equals(BaseEventKeys.Componentization.EVENT_COMPONENTIZATION_OPEN_SUG)) {
                AbsNewUiPresenter.this.m9843b();
                AbsNewUiPresenter.this.openSugPage4Router();
            }
        }
    };
    protected boolean isFirstAdd = true;
    protected boolean isInHome = true;
    protected BusinessContext mBusinessContext;
    /* access modifiers changed from: protected */
    public boolean mIsRequestingRecAndCoupon = false;
    protected LoginListeners.LoginOutListener mLoginOutListener = new LoginListeners.LoginOutListener() {
        public void onSuccess() {
            if (AbsNewUiPresenter.this.mView != null) {
                ((AbsNewUiView) AbsNewUiPresenter.this.mView).clearRecData();
                ((AbsNewUiView) AbsNewUiPresenter.this.mView).hideRecList();
            }
        }
    };
    protected List<HomeCardModel> mResultList = new ArrayList();
    protected String mSearchId = "";
    protected String mSearchName = "";

    public AbsNewUiPresenter(ComponentParams componentParams) {
        super(componentParams);
        this.mBusinessContext = componentParams.bizCtx;
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        NationComponentDataUtil.addLoginOutlistener(this.mLoginOutListener);
        GlobalApolloUtil.addToTotalSample("Mapdraging_Guess_Test_BR");
        GlobalApolloUtil.addToTotalSample("Direct_Call_Test_Pid");
        bindRxEventTracker();
        subscribe(BaseEventKeys.Componentization.EVENT_COMPONENTIZATION_OPEN_SUG, this.f14108e);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        NationComponentDataUtil.removeLoginOutlistener(this.mLoginOutListener);
        unsubscribe(BaseEventKeys.Componentization.EVENT_COMPONENTIZATION_OPEN_SUG, this.f14108e);
    }

    /* access modifiers changed from: protected */
    public void onPageResume() {
        super.onPageResume();
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                new HomeSafetyTrainRequest(AbsNewUiPresenter.this.mContext).getSafetyTrainRequest((Map) null, new ResponseListener<SafetyTrainCardInfo>() {
                    public void onFinish(SafetyTrainCardInfo safetyTrainCardInfo) {
                        if (safetyTrainCardInfo == null) {
                            safetyTrainCardInfo = new SafetyTrainCardInfo();
                            safetyTrainCardInfo.errno = -1;
                        }
                        AbsNewUiPresenter.this.doPublish(BaseEventKeys.Home.SAFETY_TRAIN_CARD_INFO, safetyTrainCardInfo);
                    }
                });
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m9843b() {
        goBackRoot(new Bundle());
    }

    /* access modifiers changed from: protected */
    public boolean showOrderBanCardInfoIfNeed(OrderBanCardInfo orderBanCardInfo) {
        if (orderBanCardInfo == null || !orderBanCardInfo.isAvailable() || orderBanCardInfo.banStatus == 0) {
            return false;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_status", Integer.valueOf(orderBanCardInfo.banStatus));
        hashMap.put("global_id", orderBanCardInfo.globalId);
        hashMap.put("passenger_id", Long.valueOf(NationComponentDataUtil.getUid()));
        GlobalOmegaUtils.trackEvent("pax_suspension_banner_sw", (Map<String, Object>) hashMap);
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean showPosition() {
        return LocationGuide.parseLocation().type != 0;
    }

    /* access modifiers changed from: protected */
    public void prepareForward(SugResult sugResult) {
        if (sugResult != null) {
            Address address = sugResult.start;
            Address address2 = sugResult.end;
            if (address2 != null) {
                SearchIdUploadManager.getInstance().addSearchId(address2.searchId);
            }
            boolean z = sugResult.isStartNeedNearRoad;
            if (address != null && address2 != null) {
                m9841a(address, z, address2);
                return;
            }
            return;
        }
        openSugPage();
    }

    /* access modifiers changed from: protected */
    public void openSugPage() {
        if (NationComponentDataUtil.getLastKnownLocation() != null || NationComponentDataUtil.isLoginNow()) {
            new Bundle().putInt("home_destination_address_type", 2);
            this.mComponentProxy.createSession(TravelConstant.SESSION_TAG_HOME_DESTINATION_PLAN_A_TO_SUG_PAGE);
            doPublish("event_show_new_sug_page", 2);
            return;
        }
        OneLoginFacade.getAction().go2Login(this.mContext);
    }

    /* access modifiers changed from: protected */
    public void openSugPage4Router() {
        if (NationComponentDataUtil.getLastKnownLocation() != null || NationComponentDataUtil.isLoginNow()) {
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    AbsNewUiPresenter.this.openSugPage(1, new Object[0]);
                }
            }, 500);
        } else {
            OneLoginFacade.getAction().go2Login(this.mContext);
        }
    }

    /* renamed from: a */
    private void m9841a(Address address, boolean z, Address address2) {
        if (!NationComponentDataUtil.isLoginNow()) {
            this.f14107d = z;
            this.f14105b = address;
            this.f14106c = address2;
            NationComponentDataUtil.goToLoginPageForResult(getHost(), 70);
            return;
        }
        BusinessContext businessContext = this.mBusinessContext;
        if (businessContext != null) {
            businessContext.hideBizBar();
        }
        this.f14107d = false;
        this.f14105b = null;
        this.f14106c = null;
        FormStore.getInstance().setStartAddress(address, FormStore.AddressSrcType.HOME_RECOMMEND, z);
        FormStore.getInstance().setEndAddress(address2);
        this.mComponentProxy.createSession(TravelConstant.SESSION_TAG_HOME_DESTINATION_PLAN_A_TO_CONFIRM_PAGE);
        Bundle bundle = new Bundle();
        bundle.putBoolean(IGroupView.BACK_VISIBILITY, true);
        bundle.putString("page_source", "page_home_destination");
        forward(1030, bundle);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        Address address;
        Address address2;
        super.onActivityResult(i, i2, intent);
        if (i == 70 && i2 == -1 && (address = this.f14105b) != null && (address2 = this.f14106c) != null) {
            m9841a(address, this.f14107d, address2);
        }
    }

    /* access modifiers changed from: protected */
    public void openSugPage(int i, Object... objArr) {
        if (NationComponentDataUtil.getLastKnownLocation() != null || NationComponentDataUtil.isLoginNow()) {
            doPublish("event_show_new_sug_page", Integer.valueOf(i));
        } else {
            OneLoginFacade.getAction().go2Login(this.mContext);
        }
    }

    /* access modifiers changed from: protected */
    public void showFetchCouponOrGuess(HomeGetRecRequest homeGetRecRequest, BusinessContext businessContext) {
        if (!this.mIsRequestingRecAndCoupon) {
            this.mIsRequestingRecAndCoupon = true;
            homeGetRecRequest.getRecRequest(getParams(), new ResponseListener<HomeCardListResponse>() {
                public void onFinish(HomeCardListResponse homeCardListResponse) {
                    if (homeCardListResponse == null) {
                        AbsNewUiPresenter.this.mIsRequestingRecAndCoupon = false;
                    } else if (AbsNewUiPresenter.this.showOrderBanCardInfoIfNeed(homeCardListResponse.orderBanCardInfo)) {
                        AbsNewUiPresenter.this.mIsRequestingRecAndCoupon = false;
                        AbsNewUiPresenter.this.doPublish(BaseEventKeys.Home.ORDER_BAN_CARD_INFO, homeCardListResponse.orderBanCardInfo);
                        AbsNewUiPresenter.this.doPublish(BaseEventKeys.Home.HIDE_HOME_DESTINATION);
                    } else {
                        AbsNewUiPresenter.this.doPublish(BaseEventKeys.Home.ORDER_BAN_CARD_INFO, (Object) null);
                        if (!homeCardListResponse.isAvailable()) {
                            AbsNewUiPresenter.this.mIsRequestingRecAndCoupon = false;
                            return;
                        }
                        List<HomeCardModel> list = homeCardListResponse.newDataList;
                        if (list == null || list.isEmpty()) {
                            AbsNewUiPresenter.this.mIsRequestingRecAndCoupon = false;
                            return;
                        }
                        if (list.size() > 2) {
                            list = new ArrayList<>(list.subList(0, 2));
                        }
                        AbsNewUiPresenter.this.mResultList = new ArrayList();
                        AbsNewUiPresenter.this.mSearchId = homeCardListResponse.searchId;
                        for (HomeCardModel next : list) {
                            if (!(next.base_info == null || next.base_info.displayname == null || next.base_info.displayname.trim().isEmpty())) {
                                AbsNewUiPresenter.this.mResultList.add(next);
                            }
                        }
                        if (AbsNewUiPresenter.this.mResultList.size() > 0) {
                            ((AbsNewUiView) AbsNewUiPresenter.this.mView).setRecData(AbsNewUiPresenter.this.mResultList);
                            ((AbsNewUiView) AbsNewUiPresenter.this.mView).showRecList();
                        }
                        JSONArray jSONArray = new JSONArray();
                        if (AbsNewUiPresenter.this.mResultList != null && AbsNewUiPresenter.this.mResultList.size() > 0) {
                            for (HomeCardModel next2 : AbsNewUiPresenter.this.mResultList) {
                                if (next2.base_info != null) {
                                    JSONObject jSONObject = new JSONObject();
                                    try {
                                        jSONObject.put("lat", next2.base_info.lat);
                                        jSONObject.put("lng", next2.base_info.lng);
                                        jSONObject.put("name", next2.base_info.displayname);
                                        if (next2.extend_info != null) {
                                            jSONObject.put("poi_ui_tag", next2.extend_info.poi_ui_tag);
                                        }
                                        jSONArray.put(jSONObject);
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        }
                        if ("home".equals(OmegaSDK.getGlobalAttr("g_PageId"))) {
                            HashMap hashMap = new HashMap();
                            SceneHelper instance = SceneHelper.getInstance();
                            if (instance.isFirstLaunchGuess()) {
                                hashMap.put("scene", "AA");
                                instance.setFirstLaunchGuess(false);
                            } else if (instance.isFromLoginGuess()) {
                                hashMap.put("scene", "ALoginA");
                                instance.setFromLoginGuess(false);
                            } else if (instance.isFromBackStackGuess()) {
                                hashMap.put("scene", "ABA");
                                instance.setFromBackStackGuess(false);
                            } else {
                                hashMap.put("scene", "AOA");
                            }
                            hashMap.put("guessDesid", homeCardListResponse.searchId);
                            if (AbsNewUiPresenter.this.mResultList != null && AbsNewUiPresenter.this.mResultList.size() > 0 && AbsNewUiPresenter.this.mResultList.size() == 1) {
                                HomeCardModel homeCardModel = AbsNewUiPresenter.this.mResultList.get(0);
                                if (homeCardModel.base_info != null) {
                                    hashMap.put("address", homeCardModel.base_info.address);
                                    if (homeCardModel.extend_info != null) {
                                        hashMap.put("poi_ui_tag", homeCardModel.extend_info.poi_ui_tag);
                                    }
                                    hashMap.put(ParamConst.PARAM_ADDRESS_LAT, Double.valueOf(homeCardModel.base_info.lat));
                                    hashMap.put(ParamConst.PARAM_ADDRESS_LNG, Double.valueOf(homeCardModel.base_info.lng));
                                }
                            }
                            hashMap.put("to_address_list", jSONArray.toString());
                            GlobalOmegaUtils.trackEvent("gp_guessDestination_sw", (Map<String, Object>) hashMap);
                        }
                        SearchIdUploadManager.getInstance().addSearchId(homeCardListResponse.searchId);
                        AbsNewUiPresenter.this.mIsRequestingRecAndCoupon = false;
                    }
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void bindRxEventTracker() {
        EventTracker.bind(((AbsNewUiView) this.mView).getView()).trackOnShow(true, "pas_home_sw_new");
    }
}
