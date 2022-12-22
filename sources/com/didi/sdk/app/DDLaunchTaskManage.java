package com.didi.sdk.app;

import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;

public class DDLaunchTaskManage {

    /* renamed from: a */
    private static DDLaunchTaskManage f35158a;

    /* renamed from: c */
    private static Boolean f35159c;

    /* renamed from: b */
    private ApplicationDelegateManager f35160b;

    public static DDLaunchTaskManage getInstance() {
        if (f35158a == null) {
            f35158a = new DDLaunchTaskManage();
        }
        return f35158a;
    }

    public void setDelegateMge(ApplicationDelegateManager applicationDelegateManager) {
        this.f35160b = applicationDelegateManager;
    }

    public void notifyLoadForground() {
        ApplicationDelegateManager applicationDelegateManager;
        SystemUtils.log(4, "DDTaskManage", "notifyLoadForground: " + this.f35160b, (Throwable) null, "com.didi.sdk.app.DDLaunchTaskManage", 25);
        if (isAllowed() && (applicationDelegateManager = this.f35160b) != null) {
            applicationDelegateManager.notifyLoadForground();
        }
    }

    public static boolean isAllowed() {
        Boolean bool = f35159c;
        if (bool != null) {
            return bool.booleanValue();
        }
        IToggle toggle = Apollo.getToggle("psg_anr_fresco_task_init_at_activity");
        Boolean valueOf = Boolean.valueOf(toggle != null && toggle.allow());
        f35159c = valueOf;
        return valueOf.booleanValue();
    }
}
