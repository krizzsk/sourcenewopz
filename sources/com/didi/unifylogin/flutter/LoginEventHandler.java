package com.didi.unifylogin.flutter;

import android.app.Activity;
import android.content.Context;
import com.didi.unifylogin.base.net.pojo.response.CountryListResponse;
import com.didi.unifylogin.listener.ListenerManager;
import com.didi.unifylogin.listener.LoginListeners;
import com.didi.unifylogin.store.LoginStore;
import java.util.Iterator;

public class LoginEventHandler {

    /* renamed from: b */
    private static CountryCodeSelectListener f44773b;

    /* renamed from: a */
    private final Context f44774a;

    public interface CountryCodeSelectListener {
        void onCountrySelected(CountryListResponse.CountryRule countryRule);
    }

    public static void setCountryCodeSelectListener(CountryCodeSelectListener countryCodeSelectListener) {
        f44773b = countryCodeSelectListener;
    }

    public LoginEventHandler(Context context) {
        this.f44774a = context;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0056, code lost:
        r0 = com.didi.unifylogin.country.CountryManager.getIns();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onEvent(p242io.flutter.plugin.common.MethodCall r5, p242io.flutter.plugin.common.MethodChannel.Result r6) {
        /*
            r4 = this;
            java.lang.String r0 = "event"
            java.lang.Object r0 = r5.argument(r0)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r1 = "cpfSuccess"
            java.lang.Object r1 = r5.argument(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            java.lang.String r1 = "onCancel"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0030
            java.util.concurrent.ConcurrentLinkedQueue r5 = com.didi.unifylogin.listener.ListenerManager.getLoginListeners()
            java.util.Iterator r5 = r5.iterator()
        L_0x0020:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L_0x0093
            java.lang.Object r0 = r5.next()
            com.didi.unifylogin.listener.LoginListeners$LoginListener r0 = (com.didi.unifylogin.listener.LoginListeners.LoginListener) r0
            r0.onCancel()
            goto L_0x0020
        L_0x0030:
            java.lang.String r1 = "onSuccess"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x003c
            r4.m31797a()
            goto L_0x0093
        L_0x003c:
            java.lang.String r1 = "onCountrySelected"
            boolean r1 = r1.equals(r0)
            java.lang.String r2 = "country_id"
            java.lang.String r3 = "country"
            if (r1 == 0) goto L_0x0068
            java.lang.Object r5 = r5.argument(r3)
            java.util.Map r5 = (java.util.Map) r5
            java.lang.Object r5 = r5.get(r2)
            java.lang.Integer r5 = (java.lang.Integer) r5
            if (r5 == 0) goto L_0x0093
            com.didi.unifylogin.country.CountryManager r0 = com.didi.unifylogin.country.CountryManager.getIns()
            int r5 = r5.intValue()
            com.didi.unifylogin.base.net.pojo.response.CountryListResponse$CountryRule r5 = r0.getCountryById(r5)
            if (r5 == 0) goto L_0x0093
            r0.setCurrentCountry(r5)
            goto L_0x0093
        L_0x0068:
            java.lang.String r1 = "notifyCountrySelected"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0093
            java.lang.Object r5 = r5.argument(r3)
            java.util.Map r5 = (java.util.Map) r5
            java.lang.Object r5 = r5.get(r2)
            java.lang.Integer r5 = (java.lang.Integer) r5
            if (r5 == 0) goto L_0x0093
            com.didi.unifylogin.country.CountryManager r0 = com.didi.unifylogin.country.CountryManager.getIns()
            int r5 = r5.intValue()
            com.didi.unifylogin.base.net.pojo.response.CountryListResponse$CountryRule r5 = r0.getCountryById(r5)
            if (r5 == 0) goto L_0x0093
            com.didi.unifylogin.flutter.LoginEventHandler$CountryCodeSelectListener r0 = f44773b
            if (r0 == 0) goto L_0x0093
            r0.onCountrySelected(r5)
        L_0x0093:
            java.lang.String r5 = com.didi.unifylogin.flutter.Result.m31807ok()
            r6.success(r5)
            r5 = 1
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.unifylogin.flutter.LoginEventHandler.onEvent(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):boolean");
    }

    /* renamed from: a */
    private void m31797a() {
        if (this.f44774a != null) {
            Iterator<LoginListeners.LoginListener> it = ListenerManager.getLoginListeners().iterator();
            while (it.hasNext()) {
                it.next().onSuccess((Activity) this.f44774a, LoginStore.getInstance().getTemporaryToken());
            }
        }
    }
}
