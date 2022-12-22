package com.didi.component.unenablecity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.util.BusinessUtils;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.NationComponentDataUtil;
import com.didi.component.business.util.Utils;
import com.didi.component.business.xbanner.XBannerConstants;
import com.didi.component.business.xpanel.sdk.controllers.IXPanelServiceCardController;
import com.didi.component.common.GlobalWebActivity;
import com.didi.component.common.base.BaseExpressPresenter;
import com.didi.component.common.util.ApkUtils;
import com.didi.component.common.view.card.GlobalTemplateCardModel;
import com.didi.component.core.ComponentParams;
import com.didi.component.unenablecity.utils.HomeCardOmegaUtils;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.misconfig.model.CountryInfo;
import com.didi.sdk.misconfig.model.WarmupActivity;
import com.didi.sdk.oneconf.OneConfStore;
import com.didi.sdk.util.GlobalApolloUtils;
import com.didi.sdk.util.GlobalCountryCode;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.util.SaApolloUtil;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.webview.WebViewModel;
import com.didi.travel.psnger.model.response.OrderBanCardInfo;
import com.didi.travel.psnger.model.response.SafetyTrainCardInfo;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;

public abstract class AbsUnableCityPresenter extends BaseExpressPresenter<IUnableCityContainerView> {
    protected BusinessContext mBizContext;
    protected Context mContext;
    protected IXPanelServiceCardController mXpanelController;

    /* access modifiers changed from: protected */
    public void setNoPositionClickEvent() {
    }

    public AbsUnableCityPresenter(ComponentParams componentParams) {
        super(componentParams);
        BusinessContext businessContext = componentParams.bizCtx;
        this.mBizContext = businessContext;
        this.mContext = businessContext.getContext();
    }

    /* access modifiers changed from: protected */
    public void showUnopenedView() {
        ((IUnableCityContainerView) this.mView).showUnopenedCityView();
        m11862a(R.string.global_unenable_city_title);
    }

    /* access modifiers changed from: protected */
    public void showNoOpenPositionView() {
        ((IUnableCityContainerView) this.mView).showNoOpenPositionView();
        setNoPositionClickEvent();
    }

    /* access modifiers changed from: protected */
    public void showOrderBanView(OrderBanCardInfo orderBanCardInfo) {
        if (orderBanCardInfo != null) {
            addViewToXpanel();
            ((IUnableCityContainerView) this.mView).showOrderBanView(orderBanCardInfo, this.mBizContext);
            FormStore.getInstance().setOrderBan(true);
            doPublish(BaseEventKeys.XBanner.EVENT_XBANNER_HOME_RELOAD_WITH_PAGE_STATE, XBannerConstants.PageState.HOME_BANNED);
            return;
        }
        FormStore.getInstance().setOrderBan(false);
    }

    /* access modifiers changed from: protected */
    public void showSafetyTrainView(SafetyTrainCardInfo safetyTrainCardInfo) {
        if (safetyTrainCardInfo != null && safetyTrainCardInfo.isAvailable()) {
            addViewToXpanel();
            if (((IUnableCityContainerView) this.mView).showSafetyTrainView(safetyTrainCardInfo)) {
                FormStore.getInstance().setSafetyTrain(true);
                doPublish(BaseEventKeys.XBanner.EVENT_XBANNER_HOME_RELOAD_WITH_PAGE_STATE, XBannerConstants.PageState.HOME_BANNED);
                doPublish(BaseEventKeys.Home.HIDE_HOME_DESTINATION);
                return;
            }
        }
        FormStore.getInstance().setSafetyTrain(false);
        if (((IUnableCityContainerView) this.mView).hideSafetyTrainView()) {
            doPublish(BaseEventKeys.Home.CHECK_HOME_DESTINATION);
        }
    }

    /* access modifiers changed from: protected */
    public void showPreHeatView() {
        WarmupActivity preheatActivity = BusinessUtils.getPreheatActivity(this.mBizContext);
        if (preheatActivity != null) {
            ((IUnableCityContainerView) this.mView).showPreheatView();
            ((IUnableCityContainerView) this.mView).setTitle(preheatActivity.getTitle());
            ((IUnableCityContainerView) this.mView).setContent(preheatActivity.getDescription());
            ((IUnableCityContainerView) this.mView).showImage((int) R.drawable.new_unable_city_no_guide);
            HashMap hashMap = new HashMap();
            hashMap.put("uid", Long.valueOf(NationComponentDataUtil.getUid()));
            hashMap.put("country_code", NationComponentDataUtil.getLocCountry());
            hashMap.put("city", NationComponentDataUtil.getLocCityId());
            GlobalOmegaUtils.trackEvent("gp_home_xpanel_warmup_sw", (Map<String, Object>) hashMap);
        } else {
            ((IUnableCityContainerView) this.mView).showUnopenedCityView();
            m11862a(R.string.global_unenable_city_prepare);
        }
        doPublish(BaseEventKeys.XBanner.EVENT_XBANNER_HOME_RELOAD_WITH_PAGE_STATE, XBannerConstants.PageState.HOME_WARM_UP);
    }

    /* renamed from: a */
    private void m11862a(int i) {
        String preHeatOrDisableText = BusinessUtils.getPreHeatOrDisableText(this.mBizContext);
        if (TextUtil.isEmpty(preHeatOrDisableText)) {
            Context context = this.mContext;
            preHeatOrDisableText = ResourcesHelper.getString(context, i, ApkUtils.getAppName(context));
        }
        GlobalTemplateCardModel globalTemplateCardModel = new GlobalTemplateCardModel();
        if (m11863b()) {
            globalTemplateCardModel.textAreaModel = new GlobalTemplateCardModel.TextAreaModel(preHeatOrDisableText, (String) null, ResourcesHelper.getString(this.mContext, R.string.global_unenable_city_content));
            if (GlobalApolloUtils.getStatus("china_download_didi_control", false)) {
                globalTemplateCardModel.newBtnModel = new GlobalTemplateCardModel.NewBtnModel(ResourcesHelper.getString(this.mContext, R.string.global_unenable_city_download), new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        Utils.launchGooglePlayStoreAppDetail("com.sdu.didi.psnger");
                    }
                });
                globalTemplateCardModel.linkBtnModel = new GlobalTemplateCardModel.LinkBtnModel(ResourcesHelper.getString(this.mContext, R.string.global_unenable_city_pick_up), new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        AbsUnableCityPresenter.this.gotoSugPage();
                    }
                });
            }
            globalTemplateCardModel.setCardBackGround(R.drawable.global_new_ui_home_card_bg);
            globalTemplateCardModel.imageModel = new GlobalTemplateCardModel.ImageModel(R.drawable.new_unable_city_guide_download_app, 120, 120, 1);
        } else {
            globalTemplateCardModel.textAreaModel = new GlobalTemplateCardModel.TextAreaModel(preHeatOrDisableText, (String) null, this.mContext.getResources().getString(R.string.global_unenable_city_content_new));
            globalTemplateCardModel.imageModel = new GlobalTemplateCardModel.ImageModel(SaApolloUtil.INSTANCE.getSaState() ? R.drawable.sa_unable_city_no_guide : R.drawable.new_unable_city_no_guide, 120, 120, 1);
            globalTemplateCardModel.btnModel = new GlobalTemplateCardModel.BtnModel((String) null, ResourcesHelper.getString(this.mContext, R.string.global_unenable_city_to_sug), 1, new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    HomeCardOmegaUtils.sendUnableCityCardCk(HomeCardOmegaUtils.CARD_ID_UNOPEN_CITY);
                    AbsUnableCityPresenter.this.gotoSugPage();
                }
            });
            globalTemplateCardModel.setCardBackGround(R.drawable.global_new_ui_home_card_bg);
        }
        ((IUnableCityContainerView) this.mView).setData(globalTemplateCardModel);
    }

    /* renamed from: b */
    private boolean m11863b() {
        CountryInfo countryInfo = BusinessUtils.getCountryInfo(this.mBizContext);
        if (countryInfo == null || TextUtils.isEmpty(countryInfo.getCountryIsoCode())) {
            return OneConfStore.getInstance().getCountryId() == 86;
        }
        if ("CHN".equals(countryInfo.getCountryIsoCode()) || GlobalCountryCode.CHINA.equals(countryInfo.getCountryIsoCode())) {
            return true;
        }
        return false;
    }

    public void onPreheatImageClicked() {
        WarmupActivity preheatActivity = BusinessUtils.getPreheatActivity(this.mBizContext);
        if (preheatActivity != null) {
            WebViewModel webViewModel = new WebViewModel();
            webViewModel.url = preheatActivity.getH5link();
            Intent intent = new Intent(this.mContext, GlobalWebActivity.class);
            intent.putExtra("web_view_model", webViewModel);
            startActivity(intent);
            HashMap hashMap = new HashMap();
            hashMap.put("uid", Long.valueOf(NationComponentDataUtil.getUid()));
            hashMap.put("country_code", NationComponentDataUtil.getLocCountry());
            hashMap.put("city", NationComponentDataUtil.getLocCityId());
            GlobalOmegaUtils.trackEvent("gp_home_xpanel_warmup_ck", (Map<String, Object>) hashMap);
        }
    }

    public void gotoSugPage() {
        Bundle bundle = new Bundle();
        bundle.putInt("home_destination_address_type", 1);
        bundle.putBoolean("is_form_home_page", true);
        doPublish("event_show_new_sug_page", 1);
    }

    public void gotoWebPage(String str) {
        if (!TextUtils.isEmpty(str)) {
            WebViewModel webViewModel = new WebViewModel();
            webViewModel.url = str;
            Intent intent = new Intent(this.mContext, GlobalWebActivity.class);
            intent.putExtra("web_view_model", webViewModel);
            startActivity(intent);
        }
    }

    /* access modifiers changed from: protected */
    public void addViewToXpanel() {
        IXPanelServiceCardController iXPanelServiceCardController = this.mXpanelController;
        if (iXPanelServiceCardController != null) {
            iXPanelServiceCardController.setVisibilityChanged(true);
        }
    }

    /* access modifiers changed from: protected */
    public void removeviewFromXpanel() {
        IXPanelServiceCardController iXPanelServiceCardController = this.mXpanelController;
        if (iXPanelServiceCardController != null) {
            iXPanelServiceCardController.setVisibilityChanged(false);
            ((IUnableCityContainerView) this.mView).cleanType();
        }
    }
}
