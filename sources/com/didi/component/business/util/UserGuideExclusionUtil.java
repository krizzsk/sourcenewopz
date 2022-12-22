package com.didi.component.business.util;

public class UserGuideExclusionUtil {

    /* renamed from: a */
    private static volatile UserGuideExclusionUtil f11401a;

    /* renamed from: b */
    private int f11402b;

    private UserGuideExclusionUtil() {
    }

    public static UserGuideExclusionUtil getInstance() {
        if (f11401a == null) {
            synchronized (UserGuideExclusionUtil.class) {
                if (f11401a == null) {
                    f11401a = new UserGuideExclusionUtil();
                }
            }
        }
        return f11401a;
    }

    public int getUserPayingGuideStatus() {
        return this.f11402b;
    }

    public void setUserPayingGuideStatus(int i) {
        this.f11402b = i;
    }
}
