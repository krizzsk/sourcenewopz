package com.didi.soda.customer.flutter;

import android.os.Build;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.foundation.util.LoginUtil;
import com.didi.soda.router.DiRouter;
import com.didichuxing.omega.sdk.common.record.Event;
import com.didichuxing.omega.sdk.init.OmegaSDK;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.Map;
import org.osgi.framework.Constants;
import p242io.flutter.embedding.android.NSkeletonFlutter;

public class FlutterHelper {

    /* renamed from: a */
    private static final String f40899a = "tech_sailing_c_flutter_performance";

    public static String getOSType() {
        return "android";
    }

    public static boolean interceptCouponsCenter(String str) {
        return str != null && str.contains("/newCouponsCenter");
    }

    public static void openFlutterCouponCenter() {
        if (!LoginUtil.isLogin()) {
            LoginUtil.loginActivityAndTrack(GlobalContext.getContext(), 1);
        } else {
            DiRouter.request().path("flutterCommonPage").putString("path", FlutterCommons.FLUTTER_ROUTE_COUPON_CENTER).open();
        }
    }

    public static void trackFlutterPerformance(Map<String, Object> map) {
        try {
            Event newEvent = OmegaSDK.newEvent(f40899a);
            newEvent.putAttr("ostype", getOSType());
            newEvent.putAttr("manufacturer", getManufacturer());
            newEvent.putAttr("model", getModel());
            newEvent.putAttr(Constants.BUNDLE_NATIVECODE_OSVERSION, getOSVersion());
            newEvent.putAllAttrs(map);
            OmegaSDKAdapter.trackEvent(newEvent);
        } catch (Exception e) {
            NSkeletonFlutter.log((Object) null, e.toString());
        }
    }

    public static String getManufacturer() {
        return Build.MANUFACTURER;
    }

    public static String getModel() {
        return Build.MODEL;
    }

    public static String getOSVersion() {
        return Build.VERSION.RELEASE + ":" + Build.VERSION.SDK_INT;
    }
}
