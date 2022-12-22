package com.didi.map.setting.global.diversion;

import android.content.Context;
import android.text.TextUtils;
import com.didi.map.setting.common.IMapSettingPreferences;
import com.didi.map.setting.common.MapSettingFactory;
import com.didi.map.setting.common.apollo.MapSettingApolloUtil;
import com.didi.map.setting.common.diversion.INavDiversionPloy;
import com.didi.map.setting.common.diversion.INavDiversionProvider;
import com.didi.map.setting.common.diversion.NavDiversionApollo;
import com.didi.map.setting.common.diversion.impl.NavDiversionProviderImpl;
import com.didi.map.setting.common.utils.DLog;
import com.didi.map.setting.global.MapSettingNavUtils;
import java.util.List;

public class NavDiversionPloyImpl implements INavDiversionPloy {

    /* renamed from: a */
    private static final String f29016a = "NavDiversion ";

    /* renamed from: b */
    private INavDiversionProvider f29017b;

    /* renamed from: c */
    private IMapSettingPreferences f29018c;

    /* renamed from: d */
    private Context f29019d;

    public static INavDiversionPloy newInstance(Context context) {
        if (MapSettingApolloUtil.isAutoOpenNav() || !NavDiversionApollo.allow() || context == null) {
            DLog.m20371d("NavDiversion create empty INavDiversionPloy", new Object[0]);
            return new INavDiversionPloy() {
                public String getDiversionTarget(List<String> list) {
                    return null;
                }

                public boolean needDiversion() {
                    return false;
                }

                public void startNav(String str) {
                }
            };
        }
        DLog.m20371d("NavDiversion create NavDiversionPloyImpl", new Object[0]);
        return new NavDiversionPloyImpl(context);
    }

    private NavDiversionPloyImpl(Context context) {
        this.f29019d = context;
        this.f29017b = new NavDiversionProviderImpl(context);
        this.f29018c = MapSettingFactory.createMapPreferences(context);
    }

    public boolean needDiversion() {
        if (m20424a()) {
            DLog.m20371d("NavDiversion has SetUp DefaultNav return false", new Object[0]);
            return false;
        }
        List<String> navFromList = NavDiversionApollo.getNavFromList();
        if (navFromList.isEmpty()) {
            DLog.m20371d("NavDiversion apolloFromList is empty return false", new Object[0]);
            return false;
        } else if (TextUtils.isEmpty(getDiversionTarget(MapSettingNavUtils.getInstallNavTypeList(MapSettingNavUtils.getInstalledThirdNav(this.f29019d))))) {
            DLog.m20371d("NavDiversion targetType is empty return false", new Object[0]);
            return false;
        } else {
            if (!this.f29017b.hasStartedNav()) {
                DLog.m20371d(f29016a, "has not Started Nav");
                if (navFromList.contains(MapSettingNavUtils.getNavTypeByPkgName(this.f29018c.getNavSelectedPath()))) {
                    DLog.m20371d(f29016a, "clear remember nav return true");
                    this.f29018c.setNavRemember(false);
                    this.f29018c.setNavSelectedPath("");
                    return true;
                }
            }
            String a = m20423a(navFromList);
            DLog.m20371d("NavDiversion common use nav is = " + a, new Object[0]);
            return !TextUtils.isEmpty(a);
        }
    }

    public String getDiversionTarget(List<String> list) {
        if (list == null || list.isEmpty()) {
            DLog.m20371d("NavDiversion installNav is empty", new Object[0]);
            return null;
        }
        List<String> navToList = NavDiversionApollo.getNavToList();
        if (navToList.isEmpty()) {
            DLog.m20371d("NavDiversion targetList is empty", new Object[0]);
            return null;
        }
        for (String next : navToList) {
            if (list.contains(next)) {
                DLog.m20371d("NavDiversion getTarget is " + next, new Object[0]);
                return next;
            }
        }
        DLog.m20371d("NavDiversion getTarget is null", new Object[0]);
        return null;
    }

    public void startNav(String str) {
        if (m20424a()) {
            this.f29017b.clearNavRecord();
            DLog.m20371d("NavDiversion clean nav records", new Object[0]);
        } else {
            this.f29017b.appendNavRecord(str);
            DLog.m20371d("NavDiversion append nav record = " + str, new Object[0]);
        }
        this.f29017b.setHasStartedNav();
    }

    /* renamed from: a */
    private String m20423a(List<String> list) {
        if (list.isEmpty()) {
            DLog.m20371d("NavDiversion apolloFromList is empty return null", new Object[0]);
            return null;
        }
        List<String> navRecord = this.f29017b.getNavRecord();
        if (navRecord.isEmpty()) {
            DLog.m20371d("NavDiversion navRecords is empty return null", new Object[0]);
            return null;
        }
        int usageThreshold = NavDiversionApollo.getUsageThreshold();
        DLog.m20371d("NavDiversion usageCount is " + usageThreshold, new Object[0]);
        for (String next : list) {
            int i = 0;
            for (String equals : navRecord) {
                if (equals.equals(next)) {
                    i++;
                }
            }
            if (i >= usageThreshold) {
                return next;
            }
        }
        return null;
    }

    /* renamed from: a */
    private boolean m20424a() {
        if (!this.f29017b.hasStartedNav()) {
            return false;
        }
        boolean navRemember = this.f29018c.getNavRemember();
        String navSelectedPath = this.f29018c.getNavSelectedPath();
        if (!navRemember || TextUtils.isEmpty(navSelectedPath)) {
            return false;
        }
        return true;
    }
}
