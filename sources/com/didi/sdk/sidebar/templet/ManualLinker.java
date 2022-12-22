package com.didi.sdk.sidebar.templet;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.didi.address.FromType;
import com.didi.address.model.SugParams;
import com.didi.address.model.WayPoint;
import com.didi.app.router.PageRouter;
import com.didi.global.globaluikit.animation.GlobalUIKitAnimationFactory;
import com.didi.map.global.flow.scene.sug.ISubmitWayPointsCallback;
import com.didi.map.global.flow.scene.sug.ISugSceneCallback;
import com.didi.map.global.flow.scene.sug.ISugTransferAnimator;
import com.didi.map.global.flow.scene.sug.SettingSug;
import com.didi.map.global.flow.scene.sug.SugResult;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.app.BaseBusinessContext;
import com.didi.sdk.app.DIDIApplication;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.reversegeo.ReverseLocationStore;
import com.didi.sdk.sidebar.fragment.DiscountFragment;
import com.didi.sdk.sidebar.fragment.LocationServicesFragment;
import com.didi.sdk.util.GlobalOmegaUtils;
import com.didi.sdk.webview.WebActivity;
import com.didi.sdk.webview.WebViewModel;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didi.unifylogin.listener.LoginListeners;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.didiglobal.privacysdk.GlobalPrivacyListeners;
import com.didiglobal.privacysdk.GlobalPrivacySDK;
import com.sdk.poibase.model.AddressParam;
import java.util.HashMap;
import java.util.List;

public class ManualLinker {
    public void toAddress(BaseBusinessContext baseBusinessContext) {
        SugParams sugParams = new SugParams();
        sugParams.addressParam = new AddressParam();
        sugParams.addressParam.mapType = NationTypeUtil.getNationComponentData().getMapTypeString();
        AddressParam addressParam = sugParams.addressParam;
        addressParam.departure_time = System.currentTimeMillis() + "";
        sugParams.addressParam.addressType = 0;
        DIDILocation didiLocation = NationTypeUtil.getNationComponentData().getDidiLocation();
        if (didiLocation != null) {
            sugParams.addressParam.currentAddress = new Address();
            sugParams.addressParam.currentAddress.latitude = didiLocation.getLatitude();
            sugParams.addressParam.currentAddress.longitude = didiLocation.getLongitude();
            sugParams.addressParam.currentAddress.cityId = Integer.valueOf(ReverseLocationStore.getsInstance().getCityId()).intValue();
            sugParams.addressParam.currentAddress.cityName = ReverseLocationStore.getsInstance().getCityName();
        }
        sugParams.addressParam.targetAddress = sugParams.addressParam.currentAddress;
        sugParams.fromType = FromType.SETTING;
        final Activity activity = (Activity) baseBusinessContext.getContext();
        SettingSug.startSugActivity(activity, sugParams, new ISugSceneCallback() {
            public /* synthetic */ void onCancelButtonPressed() {
                ISugSceneCallback.CC.$default$onCancelButtonPressed(this);
            }

            public /* synthetic */ void onStartChoosen(Address address) {
                ISugSceneCallback.CC.$default$onStartChoosen(this, address);
            }

            public /* synthetic */ void onStartEndAddressChanged(Address address, Address address2) {
                ISugSceneCallback.CC.$default$onStartEndAddressChanged(this, address, address2);
            }

            public void onSubmitWayPoints(FragmentActivity fragmentActivity, List<WayPoint> list, List<WayPoint> list2, ISubmitWayPointsCallback iSubmitWayPointsCallback) {
            }

            public /* synthetic */ void onSugSessionClosed() {
                ISugSceneCallback.CC.$default$onSugSessionClosed(this);
            }

            public void setResult(SugResult sugResult) {
            }

            public ISugTransferAnimator getSwitchAnimator() {
                return new ISugTransferAnimator() {
                    public /* synthetic */ Animator getSecondaryPageEnterAnimator() {
                        return ISugTransferAnimator.CC.$default$getSecondaryPageEnterAnimator(this);
                    }

                    public /* synthetic */ Animator getSecondaryPageExitAnimator() {
                        return ISugTransferAnimator.CC.$default$getSecondaryPageExitAnimator(this);
                    }

                    public Animator getEnterAnimator() {
                        Point point = new Point();
                        if (activity != null) {
                            activity.getWindowManager().getDefaultDisplay().getSize(point);
                        }
                        int i = point.x;
                        int i2 = point.y;
                        ObjectAnimator objectAnimator = new ObjectAnimator();
                        objectAnimator.setPropertyName("translationX");
                        objectAnimator.setFloatValues(new float[]{(float) i, 0.0f});
                        objectAnimator.setDuration(500);
                        objectAnimator.setInterpolator(GlobalUIKitAnimationFactory.GlobalUIKitInterpolatorFactory.getInterpolator(GlobalUIKitAnimationFactory.InterpolatorType.CUBIC_OUT));
                        return objectAnimator;
                    }

                    public Animator getExitAnimator() {
                        Point point = new Point();
                        if (activity != null) {
                            activity.getWindowManager().getDefaultDisplay().getSize(point);
                        }
                        int i = point.x;
                        int i2 = point.y;
                        ObjectAnimator objectAnimator = new ObjectAnimator();
                        objectAnimator.setPropertyName("translationX");
                        objectAnimator.setFloatValues(new float[]{0.0f, (float) i});
                        objectAnimator.setDuration(500);
                        objectAnimator.setInterpolator(GlobalUIKitAnimationFactory.GlobalUIKitInterpolatorFactory.getInterpolator(GlobalUIKitAnimationFactory.InterpolatorType.CUBIC_OUT));
                        return objectAnimator;
                    }
                };
            }

            public void onOpenWebUrl(String str) {
                if (!TextUtils.isEmpty(str)) {
                    WebViewModel webViewModel = new WebViewModel();
                    webViewModel.url = str;
                    webViewModel.isSupportCache = false;
                    webViewModel.isPostBaseParams = false;
                    Intent intent = new Intent(activity, WebActivity.class);
                    intent.putExtra("web_view_model", webViewModel);
                    activity.startActivity(intent);
                }
            }
        });
    }

    public void toPrivacy(final BaseBusinessContext baseBusinessContext) {
        GlobalPrivacySDK.setOnItemClickedListener(new GlobalPrivacyListeners.OnItemClickedListener() {
            public void onDeleteAccountItemClicked(Activity activity) {
                HashMap hashMap = new HashMap();
                hashMap.put("city_id", NationTypeUtil.getNationComponentData().getCityId());
                hashMap.put("country_code", NationTypeUtil.getNationComponentData().getLocCountry());
                OmegaSDKAdapter.trackEvent("pas_profile_account_ck");
                OneLoginFacade.getAction().go2DeleteAccount(DIDIApplication.getAppContext(), new LoginListeners.CancelAccFinishListener() {
                    public void onCancel() {
                    }

                    public void onSuccess(Activity activity) {
                        baseBusinessContext.getNavigation().popBackStack(2);
                        Intent intent = new Intent();
                        intent.putExtra("logout_key_cancellation_account", true);
                        PageRouter.getInstance().startMainActivity(activity, intent);
                    }
                });
            }
        });
        GlobalPrivacySDK.go2PrivacyActivity(DIDIApplication.getAppContext());
    }

    @LinkUri(uris = {"GlobalOneTravel://one/location", "GuaranaOneTravel://one/location"})
    public void toLocationServices(BaseBusinessContext baseBusinessContext) {
        HashMap hashMap = new HashMap();
        if (!(NationTypeUtil.getNationComponentData() == null || NationTypeUtil.getNationComponentData().getLoginInfo() == null)) {
            hashMap.put("passenger_id", NationTypeUtil.getNationComponentData().getLoginInfo().getUid());
        }
        OmegaSDKAdapter.trackEvent("gd_profile_setting_location_sevice_entrance_ck", (String) null, hashMap);
        baseBusinessContext.getNavigation().transition(baseBusinessContext, new Intent(baseBusinessContext.getContext(), LocationServicesFragment.class));
    }

    @LinkUri(uris = {"GlobalOneTravel://one/discount", "GuaranaOneTravel://one/discount"})
    public void toDiscountPage(BaseBusinessContext baseBusinessContext) {
        GlobalOmegaUtils.sendClickDiscountEntrance();
        baseBusinessContext.getNavigation().transition(baseBusinessContext, new Intent(baseBusinessContext.getContext(), DiscountFragment.class));
    }
}
