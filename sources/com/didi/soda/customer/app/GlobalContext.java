package com.didi.soda.customer.app;

import android.content.Context;
import com.didi.app.nova.skeleton.PageInstrument;
import com.didi.sdk.app.BusinessContext;
import com.didi.soda.customer.CustomerFragment;
import com.didi.soda.customer.map.OnMapInitCallback;

public class GlobalContext {

    /* renamed from: a */
    private static final String f40326a = "GlobalContext";

    /* renamed from: b */
    private static BusinessContext f40327b = null;

    /* renamed from: c */
    private static Context f40328c = null;

    /* renamed from: d */
    private static PageInstrument f40329d = null;

    /* renamed from: e */
    private static CustomerFragment f40330e = null;

    /* renamed from: f */
    private static boolean f40331f = true;

    /* renamed from: g */
    private static boolean f40332g = false;

    /* renamed from: h */
    private static TitleAndBizBarManager f40333h = new TitleAndBizBarManager();

    public static boolean isEmbed() {
        return true;
    }

    public static boolean mapViewReady() {
        return true;
    }

    public static void onMapDestroy() {
    }

    public static void onMapResume() {
    }

    public static BusinessContext getBusinessContext() {
        return f40327b;
    }

    public static void setBusinessContext(BusinessContext businessContext) {
        f40327b = businessContext;
        f40333h.attachBusinessContext(businessContext);
    }

    public static Context getContext() {
        return f40328c;
    }

    public static void setContext(Context context) {
        f40328c = context;
    }

    public static CustomerFragment getFragment() {
        return f40330e;
    }

    public static void setFragment(CustomerFragment customerFragment) {
        f40330e = customerFragment;
    }

    public static boolean isFragmentInited() {
        return getFragment().isFragmentInited();
    }

    public static void clear() {
        f40327b = null;
        f40328c = null;
        f40329d = null;
        f40330e = null;
    }

    public static void setInHome(boolean z) {
        f40331f = z;
    }

    public static boolean isInHome() {
        return f40331f;
    }

    public static void initMapView(OnMapInitCallback onMapInitCallback) {
        onMapInitCallback.onMapInitFinish(getBusinessContext().getMapFlowView().getMapView().getMap());
    }

    public static TitleAndBizBarManager getTitleAndBizBarManager() {
        return f40333h;
    }

    public static void fromSuperApp() {
        f40332g = true;
    }

    public static boolean isSuperApp() {
        return f40332g;
    }

    public static boolean isBrazil() {
        return "brazilEmbed".toLowerCase().contains("brazil");
    }

    public static void setPageInstrument(PageInstrument pageInstrument) {
        f40329d = pageInstrument;
    }

    public static PageInstrument getPageInstrument() {
        return f40329d;
    }

    public static boolean containsPage(Class cls) {
        PageInstrument pageInstrument = f40329d;
        if (pageInstrument == null) {
            return false;
        }
        return pageInstrument.containsPageInBackStack(cls);
    }

    public static boolean isInRoot() {
        PageInstrument pageInstrument = f40329d;
        if (pageInstrument != null && pageInstrument.getBackstackSize() == 1) {
            return true;
        }
        return false;
    }

    public static void popBackStack() {
        BusinessContext businessContext = f40327b;
        if (businessContext != null) {
            businessContext.getNavigation().popBackStack();
        }
    }
}
