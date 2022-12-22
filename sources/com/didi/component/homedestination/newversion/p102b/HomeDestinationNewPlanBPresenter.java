package com.didi.component.homedestination.newversion.p102b;

import android.os.Bundle;
import android.text.TextUtils;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.model.HomeCardModel;
import com.didi.component.business.util.BusinessUtils;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.NationComponentDataUtil;
import com.didi.component.business.util.SendOrderUtils;
import com.didi.component.common.util.SearchIdUploadManager;
import com.didi.component.core.ComponentParams;
import com.didi.component.homedestination.model.HomeCouponAssistantModel;
import com.didi.component.homedestination.net.HomeCardListWrapperRequest;
import com.didi.component.homedestination.net.HomeCouponRequest;
import com.didi.component.homedestination.net.HomeGetRecRequest;
import com.didi.component.homedestination.net.HomeOrderBanRequest;
import com.didi.component.homedestination.newversion.AbsNewUiPresenter;
import com.didi.component.homedestination.newversion.HomeDestinationNewRecAdapter;
import com.didi.component.homedestination.newversion.p102b.IHomeDestinationPlantBNewView;
import com.didi.drouter.api.DRouter;
import com.didi.global.globalgenerickit.GGKData;
import com.didi.global.globalgenerickit.GGKView;
import com.didi.global.globalgenerickit.GlobalGenericKit;
import com.didi.global.globalgenerickit.template.yoga.EventListener;
import com.didi.map.global.component.departure.DepartureConstants;
import com.didi.map.global.flow.scene.sug.SugResult;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.sidebar.SidebarEvent;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.travel.psnger.common.net.base.ResponseListener;
import com.didi.travel.psnger.model.response.OrderBanCardInfo;
import com.sdk.poibase.model.RpcPoiBaseInfo;
import java.util.HashMap;
import java.util.Map;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* renamed from: com.didi.component.homedestination.newversion.b.HomeDestinationNewPlanBPresenter */
public class HomeDestinationNewPlanBPresenter extends AbsNewUiPresenter<IHomeDestinationPlantBNewView> implements HomeDestinationNewRecAdapter.OnItemClickListener, IHomeDestinationPlantBNewView.IClickCallBack {

    /* renamed from: a */
    private BusinessContext f14111a;

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onSidebarOpened(SidebarEvent sidebarEvent) {
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m9856b() {
        HashMap hashMap = new HashMap();
        hashMap.put("message", "");
        GlobalOmegaUtils.trackEvent("ibt_gp_home_destinationbox_view_sw", (Map<String, Object>) hashMap);
    }

    public HomeDestinationNewPlanBPresenter(ComponentParams componentParams) {
        super(componentParams);
        this.f14111a = componentParams.bizCtx;
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        this.isFirstAdd = true;
        ((IHomeDestinationPlantBNewView) this.mView).setVisibility(0, new Runnable() {
            public void run() {
                HomeDestinationNewPlanBPresenter.this.m9856b();
                HomeDestinationNewPlanBPresenter.this.m9860c();
            }
        });
        ((IHomeDestinationPlantBNewView) this.mView).setGuessItemClickListener(this);
    }

    /* access modifiers changed from: protected */
    public void onPageResume() {
        super.onPageResume();
        if (this.isInHome && !this.isFirstAdd) {
            m9860c();
        }
        this.isFirstAdd = false;
    }

    /* access modifiers changed from: protected */
    public void onPagePause() {
        super.onPagePause();
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        this.isInHome = false;
    }

    /* access modifiers changed from: protected */
    public void onBackHome(Bundle bundle) {
        super.onBackHome(bundle);
        this.isInHome = true;
        ((IHomeDestinationPlantBNewView) this.mView).setVisibility(0);
        m9860c();
    }

    /* access modifiers changed from: protected */
    public void onLeaveHome() {
        super.onLeaveHome();
        this.isInHome = false;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m9860c() {
        HomeCardListWrapperRequest homeCardListWrapperRequest = new HomeCardListWrapperRequest(this.mContext);
        if (!showPosition()) {
            showFetchCouponOrGuess(homeCardListWrapperRequest, this.f14111a);
        } else {
            new HomeOrderBanRequest(this.mContext).getOrderBanRequest((Map) null, new ResponseListener<OrderBanCardInfo>() {
                public void onFinish(OrderBanCardInfo orderBanCardInfo) {
                    if (HomeDestinationNewPlanBPresenter.this.showOrderBanCardInfoIfNeed(orderBanCardInfo)) {
                        HomeDestinationNewPlanBPresenter.this.doPublish(BaseEventKeys.Home.ORDER_BAN_CARD_INFO, orderBanCardInfo);
                        HomeDestinationNewPlanBPresenter.this.doPublish(BaseEventKeys.Home.HIDE_HOME_DESTINATION);
                        return;
                    }
                    HomeDestinationNewPlanBPresenter.this.doPublish(BaseEventKeys.Home.ORDER_BAN_CARD_INFO, (Object) null);
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void showFetchCouponOrGuess(HomeGetRecRequest homeGetRecRequest, BusinessContext businessContext) {
        if (!this.mIsRequestingRecAndCoupon) {
            super.showFetchCouponOrGuess(homeGetRecRequest, businessContext);
            m9853a(businessContext);
        }
    }

    /* renamed from: a */
    private void m9853a(BusinessContext businessContext) {
        HomeCouponRequest homeCouponRequest = new HomeCouponRequest(this.mContext);
        HashMap hashMap = new HashMap();
        hashMap.put("product_id", Integer.valueOf(BusinessUtils.getCurrentBID(businessContext)));
        homeCouponRequest.getHomeCouponAssistant(this.mContext, hashMap, new ResponseListener<HomeCouponAssistantModel>() {
            public void onSuccess(final HomeCouponAssistantModel homeCouponAssistantModel) {
                if (homeCouponAssistantModel == null || homeCouponAssistantModel.ggkData == null || homeCouponAssistantModel.ggkData.getData() == null || TextUtils.isEmpty(homeCouponAssistantModel.ggkData.getCdn()) || TextUtils.isEmpty(homeCouponAssistantModel.ggkData.getTemplate())) {
                    ((IHomeDestinationPlantBNewView) HomeDestinationNewPlanBPresenter.this.mView).hideCouponAssistant();
                } else {
                    homeCouponAssistantModel.ggkData.setCDNCallback(new GGKData.CDNCallback() {
                        public void onCDNCached() {
                            HomeDestinationNewPlanBPresenter.this.m9852a(homeCouponAssistantModel.ggkData);
                        }
                    });
                    homeCouponAssistantModel.ggkData.setEventListener(new EventListener() {
                        public boolean handleEvent(String str, String str2, Map<String, Object> map) {
                            if (map != null) {
                                for (String next : map.keySet()) {
                                }
                            }
                            if (TextUtils.isEmpty(str2) || "null".equals(str2) || (!str2.startsWith("http") && !str2.startsWith("https"))) {
                                return false;
                            }
                            DRouter.build(str2).start(HomeDestinationNewPlanBPresenter.this.getHost().getActivity());
                            return false;
                        }
                    });
                    HomeDestinationNewPlanBPresenter.this.m9852a(homeCouponAssistantModel.ggkData);
                }
                boolean unused = HomeDestinationNewPlanBPresenter.this.mIsRequestingRecAndCoupon = false;
            }

            public void onError(HomeCouponAssistantModel homeCouponAssistantModel) {
                boolean unused = HomeDestinationNewPlanBPresenter.this.mIsRequestingRecAndCoupon = false;
                ((IHomeDestinationPlantBNewView) HomeDestinationNewPlanBPresenter.this.mView).hideCouponAssistant();
            }

            public void onFail(HomeCouponAssistantModel homeCouponAssistantModel) {
                boolean unused = HomeDestinationNewPlanBPresenter.this.mIsRequestingRecAndCoupon = false;
                ((IHomeDestinationPlantBNewView) HomeDestinationNewPlanBPresenter.this.mView).hideCouponAssistant();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9852a(GGKData gGKData) {
        GGKView createTemplateView = GlobalGenericKit.createTemplateView(this.mContext, gGKData);
        if (createTemplateView != null && createTemplateView.getView() != null) {
            ((IHomeDestinationPlantBNewView) this.mView).showCouponAssistant(createTemplateView.getView());
        }
    }

    public void clickWhereToGo() {
        clearOpenRideCarOrder();
        doPublish(BaseEventKeys.Service.EVENT_DESTINATION_CLICKED);
        m9863d();
    }

    /* renamed from: d */
    private void m9863d() {
        HashMap hashMap = new HashMap();
        hashMap.put("isRecommended", ((IHomeDestinationPlantBNewView) this.mView).isRecListShown() ? "1" : "0");
        hashMap.put("city_id", NationComponentDataUtil.getLocCityId());
        hashMap.put("country_code", NationComponentDataUtil.getLocCountry());
        hashMap.put("message", "");
        GlobalOmegaUtils.trackEvent("pas_destinationbox_ck", (Map<String, Object>) hashMap);
        prepareForward((SugResult) null);
        SearchIdUploadManager.getInstance().setEstimateAction("where_to_go");
    }

    public void onItemClick(int i, HomeCardModel homeCardModel) {
        HomeCardModel homeCardModel2;
        clearOpenRideCarOrder();
        FormStore.getInstance().setIsClickGuessDestination(true);
        SugResult sugResult = new SugResult();
        sugResult.isStartNeedNearRoad = true;
        Address endAddress = SendOrderUtils.getEndAddress(homeCardModel);
        sugResult.start = getStartAddress(this.mContext);
        sugResult.end = endAddress;
        prepareForward(sugResult);
        if (this.mResultList != null && this.mResultList.size() > i && (homeCardModel2 = (HomeCardModel) this.mResultList.get(i)) != null && homeCardModel2.base_info != null) {
            RpcPoiBaseInfo rpcPoiBaseInfo = homeCardModel2.base_info;
            HashMap hashMap = new HashMap();
            hashMap.put("name", rpcPoiBaseInfo.displayname);
            hashMap.put("address", rpcPoiBaseInfo.address);
            hashMap.put("uid", rpcPoiBaseInfo.poi_id);
            hashMap.put("guessDesid", this.mSearchId);
            hashMap.put("rank", Integer.valueOf(i));
            hashMap.put(DepartureConstants.SRCTAG, rpcPoiBaseInfo.srctag);
            if (homeCardModel2.extend_info != null) {
                hashMap.put("poi_ui_tag", homeCardModel2.extend_info.poi_ui_tag);
            }
            hashMap.put("searchname", this.mSearchName);
            hashMap.put(ParamConst.PARAM_ADDRESS_LAT, Double.valueOf(rpcPoiBaseInfo.lat));
            hashMap.put(ParamConst.PARAM_ADDRESS_LNG, Double.valueOf(rpcPoiBaseInfo.lng));
            hashMap.put("is_fastCall", false);
            GlobalOmegaUtils.trackEvent("requireDlg_guessDestination_ck", (Map<String, Object>) hashMap);
        }
    }
}
