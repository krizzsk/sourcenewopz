package com.didi.thirdpartylogin.base;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public class ThirdPartyLoginManager {

    /* renamed from: a */
    private static List<AbsThirdPartyLoginBase> f27170a;

    /* renamed from: b */
    private static ThirdPartyLoginLogListener f27171b;

    public static void log(String str) {
        if (f27171b != null && !TextUtils.isEmpty(str)) {
            f27171b.addLogWithTab(str);
        }
    }

    public static void setLogListener(ThirdPartyLoginLogListener thirdPartyLoginLogListener) {
        if (thirdPartyLoginLogListener != null) {
            f27171b = thirdPartyLoginLogListener;
        }
    }

    public static List<AbsThirdPartyLoginBase> getThirdPartyLogins() {
        return f27170a;
    }

    public static void addThirdPartyLogin(AbsThirdPartyLoginBase absThirdPartyLoginBase) {
        if (absThirdPartyLoginBase != null) {
            if (f27170a == null) {
                f27170a = new ArrayList();
            }
            f27170a.add(absThirdPartyLoginBase);
        }
    }

    public static void removeThirdPartyLogin(AbsThirdPartyLoginBase absThirdPartyLoginBase) {
        List<AbsThirdPartyLoginBase> list = f27170a;
        if (list != null) {
            list.remove(absThirdPartyLoginBase);
        }
    }

    public static void filterUnsupported() {
        List<AbsThirdPartyLoginBase> list = f27170a;
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (AbsThirdPartyLoginBase next : getThirdPartyLogins()) {
                if (next.isSupport()) {
                    arrayList.add(next);
                }
            }
            f27170a = arrayList;
        }
    }

    public static AbsThirdPartyLoginBase getImpByChannel(String str) {
        List<AbsThirdPartyLoginBase> list;
        if (!TextUtils.isEmpty(str) && (list = f27170a) != null) {
            for (AbsThirdPartyLoginBase next : list) {
                if (str.equals(next.getChannel()) && next.isSupport()) {
                    return next;
                }
            }
        }
        return null;
    }

    public static boolean isSupportThirdLogin() {
        List<AbsThirdPartyLoginBase> list = f27170a;
        if (list == null) {
            return false;
        }
        for (AbsThirdPartyLoginBase isSupport : list) {
            if (isSupport.isSupport()) {
                return true;
            }
        }
        return false;
    }
}
