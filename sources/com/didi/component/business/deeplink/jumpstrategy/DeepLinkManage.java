package com.didi.component.business.deeplink.jumpstrategy;

import android.util.ArrayMap;
import java.util.Map;

public class DeepLinkManage {
    public static final String PATH_CHANGE_PASSWORD = "/modifypassword";
    public static final String PATH_MANAGER_CONTACTS = "/managerContacts";
    public static final String PATH_SAFE_CENTER = "/safeceter";
    public static final String PATH_SAHRE_BY_SMS = "/shareBySMS";
    public static final String PATH_SELF_CENTER = "/editprofile";
    public static final String PATH_SOS = "/sos";

    /* renamed from: a */
    private static final String f11298a = "one";

    /* renamed from: b */
    private Map<String, INewActivityDeepLink> f11299b;

    public DeepLinkManage() {
        ArrayMap arrayMap = new ArrayMap();
        this.f11299b = arrayMap;
        arrayMap.put(PATH_SOS, new C4630f());
        this.f11299b.put(PATH_SAFE_CENTER, new C4627c());
        this.f11299b.put(PATH_SAHRE_BY_SMS, new C4629e());
        this.f11299b.put(PATH_MANAGER_CONTACTS, new C4625a());
        this.f11299b.put(PATH_SELF_CENTER, new C4628d());
        this.f11299b.put(PATH_CHANGE_PASSWORD, new C4626b());
    }

    public INewActivityDeepLink query(String str) {
        INewActivityDeepLink iNewActivityDeepLink = this.f11299b.get(str);
        return iNewActivityDeepLink != null ? iNewActivityDeepLink : INewActivityDeepLink.DEFAULT;
    }

    public boolean filterHost(String str) {
        return "one".equalsIgnoreCase(str);
    }

    public boolean filterPath(String str) {
        return this.f11299b.containsKey(str);
    }
}
