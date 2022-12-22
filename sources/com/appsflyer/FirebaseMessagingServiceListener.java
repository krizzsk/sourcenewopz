package com.appsflyer;

import com.appsflyer.internal.C1677af;
import com.appsflyer.internal.C1692c;
import com.google.firebase.messaging.FirebaseMessagingService;

public class FirebaseMessagingServiceListener extends FirebaseMessagingService {
    public void onNewToken(String str) {
        super.onNewToken(str);
        long currentTimeMillis = System.currentTimeMillis();
        if (str != null) {
            AFLogger.afInfoLog("Firebase Refreshed Token = ".concat(String.valueOf(str)));
            C1692c.C1693a.C1694c r2 = C1692c.C1693a.C1694c.m1667(AppsFlyerProperties.getInstance().getString("afUninstallToken"));
            C1692c.C1693a.C1694c cVar = new C1692c.C1693a.C1694c(currentTimeMillis, str);
            if (r2.mo16137(cVar)) {
                C1677af.m1620(getApplicationContext(), cVar.f1963);
            }
        }
    }
}
