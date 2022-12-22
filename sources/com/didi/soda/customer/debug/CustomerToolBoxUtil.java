package com.didi.soda.customer.debug;

import android.app.Application;
import com.didi.common.map.model.LatLng;
import com.didi.soda.customer.foundation.rpc.net.SFRpcResult;
import com.didi.unifylogin.base.net.LoginEnvironment;
import com.didichuxing.foundation.spi.ServiceLoader;
import java.lang.reflect.Method;

public final class CustomerToolBoxUtil {
    public static final String CONST_DEBUG = "debug";
    public static final String CONST_RELEASE = "release";
    public static final boolean DEBUG = false;

    /* renamed from: a */
    private static final String f40875a = "debug";

    /* renamed from: b */
    private static final String f40876b = "pre_release";

    /* renamed from: c */
    private static final String f40877c = "release";

    /* renamed from: d */
    private static ServiceLoader<IToolBox> f40878d = ServiceLoader.load(IToolBox.class, 0 != 0 ? "debug" : "release");

    /* renamed from: e */
    private static IToolBox f40879e;

    private CustomerToolBoxUtil() {
    }

    public static void initToolBox(Application application) {
        IToolBox a = m29045a();
        if (a != null) {
            a.initToolBox(application);
        }
    }

    public static String getHostApi() {
        IToolBox a = m29045a();
        return a != null ? a.getMockHostApi() : "https://c.didi-food.com";
    }

    public static LoginEnvironment getLoginMode() {
        String str;
        IToolBox a = m29045a();
        if (a != null) {
            str = a.getLoginMode();
        } else {
            str = "release";
        }
        LoginEnvironment loginEnvironment = LoginEnvironment.RELEASE;
        if ("debug".equals(str)) {
            return LoginEnvironment.DEBUG;
        }
        if ("release".equals(str)) {
            return LoginEnvironment.RELEASE;
        }
        return f40876b.equals(str) ? LoginEnvironment.PRE_RELEASE : loginEnvironment;
    }

    public static LatLng getCurrentLatLng() {
        IToolBox a = m29045a();
        if (a != null) {
            return a.getCurrentLatLng();
        }
        return new LatLng(0.0d, 0.0d);
    }

    public static double getPoiLat() {
        IToolBox a = m29045a();
        if (a != null) {
            return a.getPoiLat();
        }
        return 0.0d;
    }

    public static double getPoiLng() {
        IToolBox a = m29045a();
        if (a != null) {
            return a.getPoiLng();
        }
        return 0.0d;
    }

    public static int getPoiCityId() {
        IToolBox a = m29045a();
        if (a != null) {
            return a.getPoiCityId();
        }
        return 0;
    }

    public static long getPoiCountyId() {
        IToolBox a = m29045a();
        if (a != null) {
            return a.getPoiCountyId();
        }
        return 0;
    }

    public static long getPoiCountyGroupId() {
        IToolBox a = m29045a();
        if (a != null) {
            return a.getPoiCountyGroupId();
        }
        return 0;
    }

    public static double getLat() {
        IToolBox a = m29045a();
        if (a != null) {
            return a.getLat();
        }
        return 0.0d;
    }

    public static double getLng() {
        IToolBox a = m29045a();
        if (a != null) {
            return a.getLng();
        }
        return 0.0d;
    }

    public static int getCityId() {
        IToolBox a = m29045a();
        if (a != null) {
            return a.getCityId();
        }
        return 0;
    }

    public static long getCountyId() {
        IToolBox a = m29045a();
        if (a != null) {
            return a.getCountyId();
        }
        return 0;
    }

    public static long getCountyGroupId() {
        IToolBox a = m29045a();
        if (a != null) {
            return a.getCountyGroupId();
        }
        return 0;
    }

    public static void setUserToken(String str) {
        IToolBox a = m29045a();
        if (a != null) {
            a.setUserToken(str);
        }
    }

    public static void initExternalParams() {
        IToolBox a = m29045a();
        if (a != null) {
            a.initExternalParams();
        }
    }

    public static void openMockLocation() {
        IToolBox a = m29045a();
        if (a != null) {
            a.openMockLocation();
        }
    }

    public static String getTransApolloName() {
        IToolBox a = m29045a();
        return a != null ? a.getTransApolloName() : "";
    }

    public static boolean shouldMockApi() {
        IToolBox a = m29045a();
        if (a != null) {
            return a.shouldMockApi();
        }
        return false;
    }

    public static SFRpcResult getLocalMockData(Method method) {
        IToolBox a = m29045a();
        if (a != null) {
            return a.getLocalMockData(method);
        }
        return null;
    }

    public static boolean getIsSkipGoogle() {
        IToolBox a = m29045a();
        if (a != null) {
            return a.getIsSkipGoogle();
        }
        return false;
    }

    public static boolean getIsBlockDebugOn() {
        IToolBox a = m29045a();
        if (a != null) {
            return a.getIsBlockDebugOn();
        }
        return false;
    }

    /* renamed from: a */
    private static IToolBox m29045a() {
        if (f40879e == null) {
            f40879e = f40878d.get();
        }
        return f40879e;
    }
}
