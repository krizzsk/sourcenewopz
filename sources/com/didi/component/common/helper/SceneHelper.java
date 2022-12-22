package com.didi.component.common.helper;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.didi.component.business.tracker.GPageIdConstant;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.NationComponentDataUtil;
import com.didi.safetoolkit.business.monitor.ISMonitorConfigCallback;
import com.didichuxing.omega.sdk.init.OmegaSDK;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class SceneHelper {

    /* renamed from: a */
    private static volatile SceneHelper f11605a;

    /* renamed from: A */
    private Map<String, Object> f11606A;

    /* renamed from: B */
    private List<Integer> f11607B;

    /* renamed from: C */
    private String f11608C = "";

    /* renamed from: D */
    private boolean f11609D = false;

    /* renamed from: b */
    private boolean f11610b = true;

    /* renamed from: c */
    private boolean f11611c = true;

    /* renamed from: d */
    private boolean f11612d = false;

    /* renamed from: e */
    private boolean f11613e = false;

    /* renamed from: f */
    private boolean f11614f = false;
    public HashSet<String> finishSet = new HashSet<>();

    /* renamed from: g */
    private boolean f11615g = false;

    /* renamed from: h */
    private boolean f11616h = false;

    /* renamed from: i */
    private boolean f11617i = false;
    public boolean isClickDispatchFee = false;
    public boolean isDeepLinkFromGoogle = false;
    public boolean isFromBackStackEstimate = false;
    public boolean isRestart = true;

    /* renamed from: j */
    private boolean f11618j = false;

    /* renamed from: k */
    private boolean f11619k = false;

    /* renamed from: l */
    private boolean f11620l = false;

    /* renamed from: m */
    private boolean f11621m = false;
    public ISMonitorConfigCallback monitorConfigCallback;

    /* renamed from: n */
    private boolean f11622n = false;

    /* renamed from: o */
    private boolean f11623o = false;

    /* renamed from: p */
    private boolean f11624p = false;
    public HashSet<String> pickSet = new HashSet<>();
    public String pushId = "";

    /* renamed from: q */
    private boolean f11625q = false;

    /* renamed from: r */
    private boolean f11626r = false;

    /* renamed from: s */
    private boolean f11627s = false;
    public HashMap<String, Object> saMap;

    /* renamed from: t */
    private boolean f11628t = false;

    /* renamed from: u */
    private boolean f11629u = false;

    /* renamed from: v */
    private boolean f11630v = false;

    /* renamed from: w */
    private boolean f11631w = false;

    /* renamed from: x */
    private Map<String, Object> f11632x;

    /* renamed from: y */
    private Map<String, Object> f11633y;

    /* renamed from: z */
    private Map<String, Object> f11634z;

    private SceneHelper() {
    }

    public static SceneHelper getInstance() {
        if (f11605a == null) {
            synchronized (SceneHelper.class) {
                if (f11605a == null) {
                    f11605a = new SceneHelper();
                }
            }
        }
        return f11605a;
    }

    public void setFirstLaunchHome(boolean z) {
        this.f11610b = z;
    }

    public void setFirstLaunchGuess(boolean z) {
        this.f11611c = z;
    }

    public void setFromSA(boolean z, HashMap<String, Object> hashMap) {
        this.f11609D = z;
        this.saMap = hashMap;
    }

    public void setFromSA(boolean z) {
        this.f11609D = z;
    }

    public boolean isFromSA() {
        return this.f11609D;
    }

    public void setFromLoginHome(boolean z) {
        this.f11612d = z;
    }

    public void setFromBackStackHome(boolean z) {
        this.f11614f = z;
    }

    public void setFromBackStackGuess(boolean z) {
        this.f11615g = z;
    }

    public void setFromLoginGuess(boolean z) {
        this.f11613e = z;
    }

    public void setFromBackStackBubble(boolean z) {
        this.f11616h = z;
    }

    public void setFromPickupPoint(boolean z) {
        this.f11617i = z;
    }

    public void setOrderIntercepted(boolean z) {
        this.f11618j = z;
    }

    public void setFromPayMethod(boolean z) {
        this.f11619k = z;
    }

    public void setFromPriceDetail(boolean z) {
        this.f11620l = z;
    }

    public void setParamsAFA(Map<String, Object> map) {
        this.f11632x = map;
    }

    public void setParamsABA(Map<String, Object> map) {
        this.f11633y = map;
    }

    public void setParamsAMA(Map<String, Object> map) {
        this.f11634z = map;
    }

    public void setHomeOnResume(boolean z) {
        this.f11621m = z;
    }

    public boolean isHomeOnResume() {
        return this.f11621m;
    }

    public void setFromImHome(boolean z) {
        this.f11622n = z;
    }

    public void setFromSupageHome(boolean z) {
        this.f11623o = z;
    }

    public void setFromBubbleHome(boolean z) {
        this.f11624p = z;
    }

    public void setFromImGuess(boolean z) {
        this.f11625q = z;
    }

    public void setFromSupageGuess(boolean z) {
        this.f11626r = z;
    }

    public void setFromBubbleGuess(boolean z) {
        this.f11627s = z;
    }

    public void setParamsACMA(Map<String, Object> map) {
        this.f11606A = map;
    }

    public void setAppOnResume(boolean z) {
        this.f11629u = z;
    }

    public void setFromBackStackEta(boolean z) {
        this.f11630v = z;
    }

    public void setCarList(List<Integer> list) {
        this.f11607B = list;
    }

    public void setEtaExecute(boolean z) {
        this.f11631w = z;
    }

    public List<Integer> getCarList() {
        return this.f11607B;
    }

    public void setFromPickupPoARA(boolean z) {
        this.f11628t = z;
    }

    public boolean isFirstLaunchHome() {
        return this.f11610b;
    }

    public boolean isFirstLaunchGuess() {
        return this.f11611c;
    }

    public boolean isFromLoginHome() {
        return this.f11612d;
    }

    public boolean isFromLoginGuess() {
        return this.f11613e;
    }

    public boolean isFromBackStackHome() {
        return this.f11614f;
    }

    public boolean isFromBackStackGuess() {
        return this.f11615g;
    }

    public boolean isFromPickupPoint() {
        return this.f11617i;
    }

    public boolean isOrderIntercepted() {
        return this.f11618j;
    }

    public boolean isFromPayMethod() {
        return this.f11619k;
    }

    public boolean isFromPriceDetail() {
        return this.f11620l;
    }

    public boolean isFromBackStackBubble() {
        return this.f11616h;
    }

    public boolean isFromImHome() {
        return this.f11622n;
    }

    public boolean isFromSupageHome() {
        return this.f11623o;
    }

    public boolean isFromBubbleHome() {
        return this.f11624p;
    }

    public boolean isFromImGuess() {
        return this.f11625q;
    }

    public boolean isFormSupageGuess() {
        return this.f11626r;
    }

    public boolean isFromBubbleGuess() {
        return this.f11627s;
    }

    public boolean isFromBackStackEta() {
        return this.f11630v;
    }

    public boolean isAppOnResume() {
        return this.f11629u;
    }

    public boolean isEtaExecute() {
        return this.f11631w;
    }

    public boolean isFromPickupPoARA() {
        return this.f11628t;
    }

    public void traceAFAEventIfNeed() {
        Map<String, Object> map = this.f11632x;
        if (map != null) {
            map.put("scene", "AFA");
            GlobalOmegaUtils.trackEvent("pas_pickupconfirm_sw", this.f11632x);
        }
    }

    public void traceABAEventIfNeed() {
        Map<String, Object> map = this.f11633y;
        if (map != null) {
            map.put("scene", "ABA");
            GlobalOmegaUtils.trackEvent("pas_pickupconfirm_sw", this.f11633y);
        }
    }

    public void traceAMAEventIfNeed() {
        Map<String, Object> map = this.f11634z;
        if (map != null && this.f11621m) {
            map.put("scene", "AMA");
            GlobalOmegaUtils.trackEvent("pas_home_sw", this.f11634z);
        }
    }

    public void traceACMAEventIfNeed() {
        Map<String, Object> map = this.f11606A;
        if (map != null) {
            map.put("scene", "ACMA");
            GlobalOmegaUtils.trackEvent("gp_eyeballsEta_view_sw", this.f11606A);
        }
    }

    public void traceBubbleEventIfNeed(Context context, Map<String, Object> map) {
        if (GPageIdConstant.G_PAGE_ID_CONF.equals(OmegaSDK.getGlobalAttr("g_PageId"))) {
            map.put("is_login", Integer.valueOf(NationComponentDataUtil.isLoginNow() ? 1 : 0));
            GlobalOmegaUtils.trackEvent("pas_orderconfirm_sw", map);
        }
    }

    public boolean isTargetTopVisible(Context context, Class cls) {
        List<Fragment> fragments;
        int size;
        Fragment fragment = null;
        FragmentManager supportFragmentManager = context instanceof FragmentActivity ? ((FragmentActivity) context).getSupportFragmentManager() : null;
        if (supportFragmentManager == null || (size = fragments.size()) == 0) {
            return false;
        }
        int i = size - 1;
        while (true) {
            if (i < 0) {
                break;
            }
            Fragment fragment2 = (fragments = supportFragmentManager.getFragments()).get(i);
            if (fragment2.isVisible() && fragment2.getUserVisibleHint()) {
                fragment = fragment2;
                break;
            }
            i--;
        }
        if (!cls.isInstance(fragment)) {
            return false;
        }
        return true;
    }

    public void setLatestKey(String str) {
        this.f11608C = str;
    }

    public String getLatestKey() {
        return this.f11608C;
    }
}
