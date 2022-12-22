package com.didi.component.business.util;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.common.util.GLog;
import com.didi.sdk.nation.MapType;
import com.didi.sdk.nation.NationComponentData;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.view.dialog.AlertController;
import com.didi.sdk.view.dialog.AlertDialogFragment;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didi.unifylogin.listener.LoginListeners;
import com.didi.usercenter.api.UserCenterFacade;
import com.didi.usercenter.entity.UserInfo;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.taxis99.R;

public class NationComponentDataUtil {
    public static String getProductId() {
        String str;
        if (CarOrderHelper.getOrder() == null || CarOrderHelper.getOrder().productid <= 0) {
            str = String.valueOf(FormStore.getInstance().Bid);
        } else {
            str = String.valueOf(CarOrderHelper.getOrder().productid);
        }
        GLog.m7964d("ProductId:" + str);
        return str;
    }

    public static String getPhone() {
        return NationTypeUtil.getNationComponentData().getLoginInfo().getPhone();
    }

    public static String getToken() {
        return NationTypeUtil.getNationComponentData().getLoginInfo().getToken();
    }

    public static long getUid() {
        String uid = NationTypeUtil.getNationComponentData().getLoginInfo().getUid();
        if (!TextUtil.isEmpty(uid)) {
            return Long.parseLong(uid);
        }
        return 0;
    }

    public static String getUserPin(Context context) {
        UserInfo userInfo = UserCenterFacade.getIns().getUserInfo(context);
        if (userInfo == null) {
            return "";
        }
        return userInfo.getPin();
    }

    public static String getUserAvatarUrl(Context context) {
        UserInfo userInfo = UserCenterFacade.getIns().getUserInfo(context);
        if (userInfo == null) {
            return "";
        }
        return userInfo.getHead_url();
    }

    public static NationComponentData.LoginInfo getLoginInfo() {
        return NationTypeUtil.getNationComponentData().getLoginInfo();
    }

    public static boolean isLoginNow() {
        return NationTypeUtil.getNationComponentData().getLoginInfo().isLoginNow();
    }

    public static String getMapTypeString() {
        return NationTypeUtil.getNationComponentData().getMapTypeString();
    }

    @Deprecated
    public static int getMapTypeInt() {
        return NationTypeUtil.getNationComponentData().getMapTypeInt();
    }

    public static String getMapTypeStringForApi() {
        return MapType.MAPTYPE_WGS84.getMapTypeString();
    }

    public static int getMapTypeIntForApi() {
        return MapType.MAPTYPE_WGS84.getMapTypeInt();
    }

    public static String getPhoneCountryCode() {
        return NationTypeUtil.getNationComponentData().getLoginInfo().getPhoneCountryCode();
    }

    public static String getLocCityId() {
        return NationTypeUtil.getNationComponentData().getCityId();
    }

    public static String getLocCityName() {
        return NationTypeUtil.getNationComponentData().getCityName();
    }

    public static String getOriginID() {
        return NationTypeUtil.getNationComponentData().getOriginID();
    }

    public static boolean isPushConnected() {
        return NationTypeUtil.getNationComponentData().getPushConfig().isConnected();
    }

    public static DIDILocation getLastKnownLocation() {
        return NationTypeUtil.getNationComponentData().getDidiLocation();
    }

    public static void showLoginDialog(FragmentActivity fragmentActivity, String str) {
        if (!TextUtil.isEmpty(str)) {
            AlertDialogFragment.Builder alertDialogBuilder = UiHelper.getAlertDialogBuilder(fragmentActivity);
            alertDialogBuilder.setIcon(AlertController.IconType.INFO);
            alertDialogBuilder.setCloseVisible(true);
            alertDialogBuilder.setCancelable(true);
            alertDialogBuilder.setMessage(str);
            alertDialogBuilder.setPositiveButton((CharSequence) ResourcesHelper.getString(fragmentActivity, R.string.car_me_known), (AlertDialogFragment.OnClickListener) new AlertDialogFragment.OnClickListener() {
                public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                    alertDialogFragment.dismiss();
                    NationComponentDataUtil.showLogin();
                }
            });
            alertDialogBuilder.setPositiveButtonDefault();
            if (fragmentActivity != null && fragmentActivity.getSupportFragmentManager() != null) {
                alertDialogBuilder.create().show(fragmentActivity.getSupportFragmentManager(), "UiHelper");
            }
        }
    }

    public static void showLogin() {
        NationTypeUtil.getNationComponentData().getLoginAction().go2Login();
    }

    public static void goToLoginPageForResult(Fragment fragment, int i) {
        if (!isLoginNow()) {
            OneLoginFacade.getAction().go2LoginForResult(fragment, i);
        }
    }

    public static String getCurrentLan() {
        return NationTypeUtil.getNationComponentData().getGLang();
    }

    public static String getUserFirstName() {
        NationComponentData.LoginInfo loginInfo = NationTypeUtil.getNationComponentData().getLoginInfo();
        return loginInfo != null ? loginInfo.getFirstname() : "";
    }

    public static String getUserLastName() {
        NationComponentData.LoginInfo loginInfo = NationTypeUtil.getNationComponentData().getLoginInfo();
        return loginInfo != null ? loginInfo.getLastname() : "";
    }

    public static void addLoginlistener(LoginListeners.LoginListener loginListener) {
        OneLoginFacade.getFunction().addLoginListener(loginListener);
    }

    public static void removeLoginlistener(LoginListeners.LoginListener loginListener) {
        OneLoginFacade.getFunction().removeLoginListener(loginListener);
    }

    public static void addLoginOutlistener(LoginListeners.LoginOutListener loginOutListener) {
        OneLoginFacade.getFunction().addLoginOutListener(loginOutListener);
    }

    public static void removeLoginOutlistener(LoginListeners.LoginOutListener loginOutListener) {
        OneLoginFacade.getFunction().removeLoginOutListener(loginOutListener);
    }

    public static String getLocCountry() {
        return NationTypeUtil.getNationComponentData().getLocCountry();
    }
}
