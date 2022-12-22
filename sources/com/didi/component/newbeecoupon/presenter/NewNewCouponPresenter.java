package com.didi.component.newbeecoupon.presenter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.NationComponentDataUtil;
import com.didi.component.business.web.GlobalWebUrl;
import com.didi.component.common.GlobalWebActivity;
import com.didi.component.common.model.HomeNewCouponModel;
import com.didi.component.core.Animations;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.drainage.DrainageData;
import com.didi.component.drainage.DrainageGuider;
import com.didi.component.grade.HomeImageDialog;
import com.didi.component.grade.model.GradeUpdateModel;
import com.didi.component.homepop.manager.HomePopNewManager;
import com.didi.component.newbeecoupon.view.INewbeeCouponView;
import com.didi.sdk.app.ActivityLifecycleManager;
import com.didi.sdk.app.BaseMainActivity;
import com.didi.sdk.home.bizbar.HomeBizNavBarFragment;
import com.didi.sdk.home.view.HomeNewTitleBarFragment;
import com.didi.sdk.publicservice.PublicServiceUtil;
import com.didi.sdk.util.SaApolloUtil;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didichuxing.publicservice.resourcecontrol.utils.ResourceManager;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.taxis99.R;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NewNewCouponPresenter extends AbsNewbeeCouponPresenter {

    /* renamed from: b */
    private static boolean f14678b = true;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public HomeImageDialog f14679a;

    /* renamed from: c */
    private Activity f14680c;

    /* renamed from: d */
    private BaseEventPublisher.OnEventListener f14681d = new BaseEventPublisher.OnEventListener<HomeNewCouponModel>() {
        public void onEvent(String str, HomeNewCouponModel homeNewCouponModel) {
            if (!BaseEventKeys.Service.EVENT_SHOW_NEW_USER_COUPON.equals(str)) {
                return;
            }
            if (homeNewCouponModel == null) {
                ((INewbeeCouponView) NewNewCouponPresenter.this.mView).dismiss();
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("discount", homeNewCouponModel.topText);
            hashMap.put("discount_text", homeNewCouponModel.couponInfos == null ? "" : homeNewCouponModel.couponInfos.get(0).couponText);
            GlobalOmegaUtils.trackEvent("pas_home_registrationCouponMaskNew_sw", (Map<String, Object>) hashMap);
            ((INewbeeCouponView) NewNewCouponPresenter.this.mView).show();
            ((INewbeeCouponView) NewNewCouponPresenter.this.mView).setButtonText(homeNewCouponModel.buttonText);
            ((INewbeeCouponView) NewNewCouponPresenter.this.mView).setListData(homeNewCouponModel);
        }
    };

    /* renamed from: e */
    private BaseEventPublisher.OnEventListener f14682e = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (BaseEventKeys.Service.EVENT_HIDEN_NEW_USER_COUPON.equals(str) && NewNewCouponPresenter.this.mView != null) {
                ((INewbeeCouponView) NewNewCouponPresenter.this.mView).dismiss();
            }
        }
    };

    /* renamed from: f */
    private BaseEventPublisher.OnEventListener<DrainageData> f14683f = new BaseEventPublisher.OnEventListener<DrainageData>() {
        public void onEvent(String str, DrainageData drainageData) {
            if ("event_drainage_guide".equals(str)) {
                Activity currentActivity = ActivityLifecycleManager.getInstance().getCurrentActivity();
                if (!(currentActivity instanceof BaseMainActivity)) {
                    return;
                }
                if (DrainageGuider.business_credit.equals(drainageData.getBusiness_type())) {
                    Fragment titleBarFragment = ((BaseMainActivity) currentActivity).getTitleBarFragment();
                    if (titleBarFragment instanceof HomeNewTitleBarFragment) {
                        View drawImg = ((HomeNewTitleBarFragment) titleBarFragment).getDrawImg();
                        List asList = Arrays.asList(new String[]{DrainageGuider.business_credit});
                        new DrainageGuider(NewNewCouponPresenter.this.mContext, Arrays.asList(new View[]{drawImg}), asList, drainageData).showGuides();
                    }
                } else if (!TextUtils.isEmpty(drainageData.getBusiness_type())) {
                    Fragment homeBizNarFragment = ((BaseMainActivity) currentActivity).getHomeBizNarFragment();
                    if (homeBizNarFragment instanceof HomeBizNavBarFragment) {
                        View itemByGroupType = ((HomeBizNavBarFragment) homeBizNarFragment).getItemByGroupType(drainageData.getBusiness_type());
                        List asList2 = Arrays.asList(new String[]{drainageData.getBusiness_type()});
                        new DrainageGuider(NewNewCouponPresenter.this.mContext, Arrays.asList(new View[]{itemByGroupType}), asList2, drainageData).showGuides();
                    }
                }
            }
        }
    };

    /* renamed from: g */
    private BaseEventPublisher.OnEventListener f14684g = new BaseEventPublisher.OnEventListener<GradeUpdateModel>() {
        public void onEvent(String str, final GradeUpdateModel gradeUpdateModel) {
            HomeImageDialog unused = NewNewCouponPresenter.this.f14679a = new HomeImageDialog();
            NewNewCouponPresenter.this.f14679a.build().image(gradeUpdateModel.bgImg).actions(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (!ResourceManager.isFastClick() && !TextUtils.isEmpty(gradeUpdateModel.jumpLink)) {
                        GlobalOmegaUtils.trackEvent("gp_mement4_ck");
                        Intent intent = new Intent(NewNewCouponPresenter.this.mContext, GlobalWebActivity.class);
                        intent.putExtra("web_view_model", GlobalWebUrl.buildWebViewModel(gradeUpdateModel.jumpLink));
                        NewNewCouponPresenter.this.startActivity(intent);
                        if (NewNewCouponPresenter.this.f14679a != null) {
                            NewNewCouponPresenter.this.f14679a.dismiss();
                        }
                    }
                }
            }).promptText(gradeUpdateModel.levelPrompt).show(NewNewCouponPresenter.this.getHost().getFragmentManager(), "grade_update_dialog");
        }
    };

    /* renamed from: h */
    private BaseEventPublisher.OnEventListener f14685h = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (NewNewCouponPresenter.this.f14679a != null) {
                NewNewCouponPresenter.this.f14679a.dismiss();
            }
        }
    };

    public NewNewCouponPresenter(ComponentParams componentParams) {
        super(componentParams);
        this.f14680c = componentParams.getActivity();
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        subscribe(BaseEventKeys.Service.EVENT_SHOW_NEW_USER_COUPON, this.f14681d);
        subscribe(BaseEventKeys.Service.EVENT_HIDEN_NEW_USER_COUPON, this.f14682e);
        subscribe(BaseEventKeys.Home.SHOW_GRADE_UPDATE_DIALOG, this.f14684g);
        subscribe(BaseEventKeys.Home.HIDE_GRADE_UPDATE_DIALOG, this.f14685h);
        subscribe("event_drainage_guide", this.f14683f);
        if (f14678b && SaApolloUtil.INSTANCE.getSaState()) {
            PublicServiceUtil.initSDK(this.f14680c);
        }
    }

    /* access modifiers changed from: protected */
    public void onPageResume() {
        super.onPageResume();
        if (f14678b) {
            f14678b = false;
            new HomePopNewManager().doRequest(getHost().getActivity());
        }
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        unsubscribe(BaseEventKeys.Service.EVENT_SHOW_NEW_USER_COUPON, this.f14681d);
        unsubscribe(BaseEventKeys.Service.EVENT_HIDEN_NEW_USER_COUPON, this.f14682e);
        unsubscribe(BaseEventKeys.Home.SHOW_GRADE_UPDATE_DIALOG, this.f14684g);
        unsubscribe(BaseEventKeys.Home.HIDE_GRADE_UPDATE_DIALOG, this.f14685h);
        unsubscribe("event_drainage_guide", this.f14683f);
    }

    public void onMaskClicked() {
        OmegaSDKAdapter.trackEvent("pas_home_registrationCouponMask_close_ck");
        ((INewbeeCouponView) this.mView).dismiss();
        doPublish(BaseEventKeys.XPanel.EVENT_REQUEST_SHOW);
    }

    public void onOpenSugClick() {
        if (NationComponentDataUtil.getLastKnownLocation() != null || NationComponentDataUtil.isLoginNow()) {
            ((INewbeeCouponView) this.mView).dismiss();
            doPublish("event_show_new_sug_page", 1);
            return;
        }
        OneLoginFacade.getAction().go2Login(this.mContext);
    }

    /* renamed from: b */
    private Animations m10466b() {
        return new Animations(R.anim.bottom_in, 0, R.anim.bottom_out, 0);
    }
}
