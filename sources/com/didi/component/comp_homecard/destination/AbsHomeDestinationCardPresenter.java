package com.didi.component.comp_homecard.destination;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.model.HomeCardModel;
import com.didi.component.business.util.GlobalApolloUtil;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.NationComponentDataUtil;
import com.didi.component.common.adapter.CommonListAdapter;
import com.didi.component.common.adapter.ICommonListCardBindDataReadyCallback;
import com.didi.component.common.base.BaseExpressPresenter;
import com.didi.component.common.helper.SceneHelper;
import com.didi.component.common.util.GLog;
import com.didi.component.common.util.GsonUtils;
import com.didi.component.common.util.LocationController;
import com.didi.component.common.util.SearchIdUploadManager;
import com.didi.component.comp_homecard.destination.HomeDestinationRecAdapter;
import com.didi.component.comp_homecard.destination.IHomeDestinationCardView;
import com.didi.component.comp_homecard.locpermission.LocPermission;
import com.didi.component.comp_homecard.model.HomeAddressModel;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.IGroupView;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.homedestination.model.HomeCardListResponse;
import com.didi.drouter.api.DRouter;
import com.didi.global.globalgenerickit.GGKData;
import com.didi.global.globalgenerickit.GGKView;
import com.didi.global.globalgenerickit.GlobalGenericKit;
import com.didi.global.globalgenerickit.template.yoga.EventListener;
import com.didi.map.global.flow.scene.sug.SugResult;
import com.didi.reactive.tracker.EventTracker;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.travel.psnger.core.model.response.ICarOrder;
import com.didi.travel.psnger.p170v2.TravelConstant;
import com.didi.travel.psnger.store.DDTravelOrderStore;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didi.unifylogin.listener.LoginListeners;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.omega.sdk.init.OmegaSDK;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class AbsHomeDestinationCardPresenter extends BaseExpressPresenter<IHomeDestinationCardView> implements CommonListAdapter, HomeDestinationRecAdapter.OnItemClickListener, IHomeDestinationCardView.IClickCallBack {

    /* renamed from: b */
    private static final int f12227b = 70;

    /* renamed from: a */
    private Logger f12228a = LoggerFactory.getLogger(getClass().getName());

    /* renamed from: c */
    private Address f12229c;

    /* renamed from: d */
    private Address f12230d;

    /* renamed from: e */
    private boolean f12231e;

    /* renamed from: f */
    private HomeAddressModel f12232f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public LocPermission f12233g;

    /* renamed from: h */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f12234h = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (AbsHomeDestinationCardPresenter.this.f12233g != null) {
                AbsHomeDestinationCardPresenter.this.f12233g.onMainBtnClick();
            }
        }
    };

    /* renamed from: i */
    private BaseEventPublisher.OnEventListener<String> f12235i = new BaseEventPublisher.OnEventListener<String>() {
        public void onEvent(String str, String str2) {
            GLog.m7965d("hgl_tag", "onEvent() category = " + str + " switch2TargetBiz = " + str2);
            if (str.equals(BaseEventKeys.Componentization.EVENT_COMPONENTIZATION_OPEN_SUG)) {
                AbsHomeDestinationCardPresenter.this.m8281b();
                AbsHomeDestinationCardPresenter.this.openSugPage4Router();
            }
        }
    };
    protected BusinessContext mBusinessContext;
    protected boolean mIsRequestingRecAndCoupon = false;
    protected LoginListeners.LoginOutListener mLoginOutListener = new LoginListeners.LoginOutListener() {
        public void onSuccess() {
            if (AbsHomeDestinationCardPresenter.this.mView != null) {
                ((IHomeDestinationCardView) AbsHomeDestinationCardPresenter.this.mView).clearRecData();
                ((IHomeDestinationCardView) AbsHomeDestinationCardPresenter.this.mView).hideRecList();
            }
        }
    };
    protected List<HomeCardModel> mResultList = new ArrayList();
    protected String mSearchId = "";
    protected String mSearchName = "";

    public void setViewWithData(JSONObject jSONObject, ICommonListCardBindDataReadyCallback iCommonListCardBindDataReadyCallback) {
        if (jSONObject != null) {
            this.f12228a.debug(jSONObject.toString(), new Object[0]);
            JSONObject optJSONObject = jSONObject.optJSONObject("normal");
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("data");
                if (!TextUtils.isEmpty(optString)) {
                    HomeAddressModel homeAddressModel = (HomeAddressModel) GsonUtils.singleGson().fromJson(optString, HomeAddressModel.class);
                    this.f12232f = homeAddressModel;
                    if (homeAddressModel == null || homeAddressModel.address_forbid != 0) {
                        iCommonListCardBindDataReadyCallback.ready(false);
                        return;
                    }
                    GGKData gGKData = null;
                    if (this.f12232f.coupon_info != null) {
                        try {
                            gGKData = new GGKData().parse(new JSONObject(this.f12232f.coupon_info.toString()));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    m8278a(gGKData);
                    m8277a(this.f12232f.recommend_info);
                    iCommonListCardBindDataReadyCallback.ready(true);
                    return;
                }
            }
        }
        iCommonListCardBindDataReadyCallback.ready(false);
    }

    /* renamed from: a */
    private void m8278a(final GGKData gGKData) {
        if (gGKData == null || gGKData.getData() == null || TextUtils.isEmpty(gGKData.getCdn()) || TextUtils.isEmpty(gGKData.getTemplate())) {
            ((IHomeDestinationCardView) this.mView).hideCouponAssistant();
            return;
        }
        gGKData.setCDNCallback(new GGKData.CDNCallback() {
            public void onCDNCached() {
                AbsHomeDestinationCardPresenter.this.m8282b(gGKData);
            }
        });
        gGKData.setEventListener(new EventListener() {
            public boolean handleEvent(String str, String str2, Map<String, Object> map) {
                if (TextUtils.isEmpty(str2) || "null".equals(str2) || (!str2.startsWith("http") && !str2.startsWith("https"))) {
                    return false;
                }
                DRouter.build(str2).start(AbsHomeDestinationCardPresenter.this.getHost().getActivity());
                return false;
            }
        });
        m8282b(gGKData);
    }

    /* renamed from: a */
    private void m8277a(HomeCardListResponse homeCardListResponse) {
        List<HomeCardModel> list;
        if (homeCardListResponse != null && (list = homeCardListResponse.newDataList) != null && !list.isEmpty()) {
            if (list.size() > 2) {
                list = new ArrayList<>(list.subList(0, 2));
            }
            this.mResultList = new ArrayList();
            this.mSearchId = homeCardListResponse.searchId;
            for (HomeCardModel next : list) {
                if (!(next.base_info == null || next.base_info.displayname == null || next.base_info.displayname.trim().isEmpty())) {
                    this.mResultList.add(next);
                }
            }
            if (this.mResultList.size() > 0) {
                ((IHomeDestinationCardView) this.mView).setRecData(this.mResultList);
                ((IHomeDestinationCardView) this.mView).showRecList();
            }
            JSONArray jSONArray = new JSONArray();
            List<HomeCardModel> list2 = this.mResultList;
            if (list2 != null && list2.size() > 0) {
                for (HomeCardModel next2 : this.mResultList) {
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
                List<HomeCardModel> list3 = this.mResultList;
                if (list3 != null && list3.size() > 0 && this.mResultList.size() == 1) {
                    HomeCardModel homeCardModel = this.mResultList.get(0);
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
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m8282b(GGKData gGKData) {
        GGKView createTemplateView = GlobalGenericKit.createTemplateView(this.mContext, gGKData);
        if (createTemplateView != null && createTemplateView.getView() != null) {
            ((IHomeDestinationCardView) this.mView).showCouponAssistant(createTemplateView.getView());
        }
    }

    public AbsHomeDestinationCardPresenter(ComponentParams componentParams) {
        super(componentParams);
        this.mBusinessContext = componentParams.bizCtx;
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        this.f12233g = new LocPermission(this.mContext);
        GlobalApolloUtil.addToTotalSample("Mapdraging_Guess_Test_BR");
        GlobalApolloUtil.addToTotalSample("Direct_Call_Test_Pid");
        bindRxEventTracker();
        NationComponentDataUtil.addLoginOutlistener(this.mLoginOutListener);
        subscribe(BaseEventKeys.Componentization.EVENT_COMPONENTIZATION_OPEN_SUG, this.f12235i);
        subscribe(BaseEventKeys.Componentization.EVENT_COMPONENTIZATION_OPEN_LOCATION_SERVICE, this.f12234h);
        LocPermission locPermission = this.f12233g;
        if (locPermission != null) {
            locPermission.showOpenPositionDialog();
        }
    }

    /* access modifiers changed from: protected */
    public void onBackHome(Bundle bundle) {
        super.onBackHome(bundle);
        LocPermission locPermission = this.f12233g;
        if (locPermission != null) {
            locPermission.showOpenPositionDialog();
        }
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        NationComponentDataUtil.removeLoginOutlistener(this.mLoginOutListener);
        unsubscribe(BaseEventKeys.Componentization.EVENT_COMPONENTIZATION_OPEN_SUG, this.f12235i);
        unsubscribe(BaseEventKeys.Componentization.EVENT_COMPONENTIZATION_OPEN_LOCATION_SERVICE, this.f12234h);
    }

    /* access modifiers changed from: protected */
    public void onPageResume() {
        super.onPageResume();
    }

    /* access modifiers changed from: protected */
    public void onPagePause() {
        super.onPagePause();
    }

    /* access modifiers changed from: protected */
    public Address getStartAddress(Context context) {
        DIDILocation lastKnownLocation = LocationController.getInstance().getLastKnownLocation(context);
        if (lastKnownLocation == null) {
            return null;
        }
        Address address = new Address();
        address.setLatitude(lastKnownLocation.getLatitude());
        address.setLongitude(lastKnownLocation.getLongitude());
        try {
            address.setCityId(Integer.parseInt(NationComponentDataUtil.getLocCityId()));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        if (!TextUtils.isEmpty(FormStore.getInstance().getDisplayName())) {
            address.setDisplayName(FormStore.getInstance().getDisplayName());
        }
        address.setCityName(NationComponentDataUtil.getLocCityName());
        return address;
    }

    /* access modifiers changed from: protected */
    public void clearOpenRideCarOrder() {
        if (DDTravelOrderStore.getOrder() != null && FormStore.getInstance().isFromOpenRide()) {
            DDTravelOrderStore.setOrder((ICarOrder) null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m8281b() {
        goBackRoot(new Bundle());
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
                m8279a(address, z, address2);
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
                    AbsHomeDestinationCardPresenter.this.openSugPage(1, new Object[0]);
                }
            }, 500);
        } else {
            OneLoginFacade.getAction().go2Login(this.mContext);
        }
    }

    /* renamed from: a */
    private void m8279a(Address address, boolean z, Address address2) {
        if (!NationComponentDataUtil.isLoginNow()) {
            this.f12231e = z;
            this.f12229c = address;
            this.f12230d = address2;
            NationComponentDataUtil.goToLoginPageForResult(getHost(), 70);
            return;
        }
        BusinessContext businessContext = this.mBusinessContext;
        if (businessContext != null) {
            businessContext.hideBizBar();
        }
        this.f12231e = false;
        this.f12229c = null;
        this.f12230d = null;
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
        if (i == 70 && i2 == -1 && (address = this.f12229c) != null && (address2 = this.f12230d) != null) {
            m8279a(address, this.f12231e, address2);
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
    public void bindRxEventTracker() {
        EventTracker.bind(((IHomeDestinationCardView) this.mView).getView()).trackOnShow(true, "pas_home_sw_new");
    }
}
