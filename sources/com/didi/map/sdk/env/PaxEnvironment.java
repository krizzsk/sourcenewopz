package com.didi.map.sdk.env;

import java.util.HashMap;

public class PaxEnvironment {

    /* renamed from: a */
    private static PaxEnvironment f28265a;

    /* renamed from: b */
    private IBizDataGetter f28266b = null;

    /* renamed from: c */
    private RoleType f28267c = RoleType.PASSENGER;

    /* renamed from: d */
    private Page f28268d = Page.OTHER_PAGE;

    /* renamed from: e */
    private Page f28269e = Page.OTHER_PAGE;

    /* renamed from: f */
    private PointType f28270f = PointType.OTHER;

    /* renamed from: g */
    private final HashMap<String, Object> f28271g = new HashMap<>();

    public static PaxEnvironment getInstance() {
        synchronized (PaxEnvironment.class) {
            if (f28265a == null) {
                f28265a = new PaxEnvironment();
            }
        }
        return f28265a;
    }

    public String getAppVersion() {
        IBizDataGetter iBizDataGetter = this.f28266b;
        if (iBizDataGetter == null) {
            return "";
        }
        return iBizDataGetter.getAppVersion();
    }

    public void setBizDataGetter(IBizDataGetter iBizDataGetter) {
        this.f28266b = iBizDataGetter;
    }

    public String getPhoneNumber() {
        IBizDataGetter iBizDataGetter = this.f28266b;
        if (iBizDataGetter == null) {
            return "";
        }
        return iBizDataGetter.getPhoneNumber();
    }

    public String getToken() {
        IBizDataGetter iBizDataGetter = this.f28266b;
        if (iBizDataGetter == null) {
            return "";
        }
        return iBizDataGetter.getToken();
    }

    public String getUid() {
        IBizDataGetter iBizDataGetter = this.f28266b;
        if (iBizDataGetter == null) {
            return "";
        }
        return iBizDataGetter.getUid();
    }

    public String getProductId() {
        IBizDataGetter iBizDataGetter = this.f28266b;
        if (iBizDataGetter == null) {
            return "30008";
        }
        return iBizDataGetter.getProductId();
    }

    public int getCityId() {
        IBizDataGetter iBizDataGetter = this.f28266b;
        if (iBizDataGetter == null) {
            return 0;
        }
        return iBizDataGetter.getCityId();
    }

    public String getCountryCode() {
        IBizDataGetter iBizDataGetter = this.f28266b;
        if (iBizDataGetter == null) {
            return "";
        }
        return iBizDataGetter.getCountryCode();
    }

    public RoleType getRoleType() {
        return this.f28267c;
    }

    public void setRoleTypeInternal(RoleType roleType) {
        this.f28267c = roleType;
    }

    public Page getPage() {
        return this.f28268d;
    }

    public void setPage(Page page) {
        Page page2 = this.f28268d;
        if (page2 != null) {
            this.f28269e = page2;
            this.f28268d = page;
        }
    }

    public Page getEntrance() {
        return this.f28269e;
    }

    public void setPointType(PointType pointType) {
        if (pointType != null) {
            this.f28270f = pointType;
        }
    }

    public PointType getPointType() {
        return this.f28270f;
    }

    public Object getCache(String str) {
        return this.f28271g.get(str);
    }

    public void setCache(String str, Object obj) {
        this.f28271g.put(str, obj);
    }
}
