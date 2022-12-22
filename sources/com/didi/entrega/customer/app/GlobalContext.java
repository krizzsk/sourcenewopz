package com.didi.entrega.customer.app;

import android.content.Context;
import android.text.TextUtils;
import com.didi.app.nova.skeleton.PageInstrument;
import com.didi.entrega.customer.CustomerFragment;
import com.didi.entrega.customer.map.OnMapInitCallback;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.util.NewUISwitchUtils;

public class GlobalContext {

    /* renamed from: a */
    private static final String f19785a = "GlobalContext";

    /* renamed from: b */
    private static TitleAndBizBarManager f19786b = new TitleAndBizBarManager();

    /* renamed from: c */
    private static BusinessContext f19787c;

    /* renamed from: d */
    private static Context f19788d;

    /* renamed from: e */
    private static PageInstrument f19789e;

    /* renamed from: f */
    private static CustomerFragment f19790f;

    /* renamed from: g */
    private static boolean f19791g = true;

    /* renamed from: h */
    private static boolean f19792h = false;

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
        return f19787c;
    }

    public static void setBusinessContext(BusinessContext businessContext) {
        f19787c = businessContext;
        f19786b.attachBusinessContext(businessContext);
    }

    public static void fromSuperApp() {
        f19792h = true;
    }

    public static boolean isSuperApp() {
        return f19792h;
    }

    public static Context getContext() {
        return f19788d;
    }

    public static void setContext(Context context) {
        f19788d = context;
    }

    public static CustomerFragment getFragment() {
        return f19790f;
    }

    public static void setFragment(CustomerFragment customerFragment) {
        f19790f = customerFragment;
    }

    public static boolean isFragmentInited() {
        return getFragment().isFragmentInited();
    }

    public static void popBackStack() {
        BusinessContext businessContext = f19787c;
        if (businessContext != null) {
            businessContext.getNavigation().popBackStack();
        }
    }

    public static void clear() {
        f19787c = null;
        f19788d = null;
        f19789e = null;
        f19790f = null;
    }

    public static void setInHome(boolean z) {
        f19791g = z;
    }

    public static boolean isInHome() {
        return f19791g;
    }

    public static void initMapView(OnMapInitCallback onMapInitCallback) {
        onMapInitCallback.onMapInitFinish(getBusinessContext().getMapFlowView().getMapView().getMap());
    }

    public static TitleAndBizBarManager getTitleAndBizBarManager() {
        return f19786b;
    }

    public static boolean isEmbedHomeNewUi() {
        return NewUISwitchUtils.isHomeNewUI();
    }

    public static int getBrand() {
        String lowerCase = "brazilEmbed".toLowerCase();
        return (TextUtils.isEmpty(lowerCase) || !lowerCase.contains("brazil")) ? 1 : 2;
    }

    public static void setPageInstrument(PageInstrument pageInstrument) {
        f19789e = pageInstrument;
    }

    public static PageInstrument getPageInstrument() {
        return f19789e;
    }

    public static boolean containsPage(Class cls) {
        PageInstrument pageInstrument = f19789e;
        if (pageInstrument == null) {
            return false;
        }
        return pageInstrument.containsPageInBackStack(cls);
    }

    public static boolean isBrazil() {
        return "brazilEmbed".toLowerCase().contains("brazil");
    }

    public static boolean isInRoot() {
        PageInstrument pageInstrument = f19789e;
        if (pageInstrument != null && pageInstrument.getBackstackSize() == 1) {
            return true;
        }
        return false;
    }
}
