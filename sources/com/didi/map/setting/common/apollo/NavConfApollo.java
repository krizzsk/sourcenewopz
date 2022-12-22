package com.didi.map.setting.common.apollo;

import android.text.TextUtils;
import com.didi.map.setting.common.conf.DefaultConfProvider;
import com.didi.map.setting.common.conf.INavSettingConf;
import com.didichuxing.apollo.sdk.IExperiment;
import com.example.compapollovisitor.BaseApollo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NavConfApollo extends BaseApollo implements INavSettingConf {

    /* renamed from: a */
    private List<String> f28931a;

    /* renamed from: b */
    private boolean f28932b = false;

    /* renamed from: c */
    private int f28933c = 0;

    /* renamed from: d */
    private boolean f28934d = true;

    /* renamed from: e */
    private int f28935e = 0;

    /* renamed from: f */
    private boolean f28936f = false;

    /* access modifiers changed from: protected */
    public String getKey() {
        return "global_map_driver_navsetting_toggle";
    }

    /* access modifiers changed from: protected */
    public boolean reAllow() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void initParams(IExperiment iExperiment) {
        this.f28931a = new ArrayList();
        String str = (String) iExperiment.getParam("map_nav_remember_list", "");
        boolean z = false;
        if (!TextUtils.isEmpty(str)) {
            for (String navPkgNameByType : str.split(",")) {
                String navPkgNameByType2 = DefaultConfProvider.getNavPkgNameByType(navPkgNameByType);
                if (!TextUtils.isEmpty(navPkgNameByType2)) {
                    this.f28931a.add(navPkgNameByType2);
                }
            }
        }
        int intValue = ((Integer) iExperiment.getParam("map_nav_open_delay", Integer.valueOf(this.f28933c))).intValue();
        this.f28933c = intValue;
        boolean z2 = intValue >= 0 && intValue < 10;
        this.f28932b = z2;
        if (!z2) {
            this.f28933c = 0;
        }
        this.f28934d = ((Integer) iExperiment.getParam("map_nav_voice_play", 1)).intValue() == 1;
        this.f28935e = ((Integer) iExperiment.getParam("map_nav_day_night_style", Integer.valueOf(this.f28935e))).intValue();
        if (((Integer) iExperiment.getParam("map_nav_double_click_remember", 0)).intValue() == 1) {
            z = true;
        }
        this.f28936f = z;
    }

    public List<String> getNavPkgList() {
        List<String> list = this.f28931a;
        return list == null ? Collections.emptyList() : list;
    }

    public boolean isAutoStart() {
        return this.f28932b;
    }

    public int getAutoStartDelaySecond() {
        return this.f28933c;
    }

    public boolean isOpenVoice() {
        return this.f28934d;
    }

    public int getDayNightMode() {
        int i = this.f28935e;
        if (i == 1) {
            return 1;
        }
        return i == 2 ? 2 : 0;
    }

    public boolean isDoubleClickRemember() {
        return this.f28936f;
    }
}
