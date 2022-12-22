package com.yanzhenjie.permission.checker;

import android.content.Context;
import android.net.sip.SipManager;
import android.net.sip.SipProfile;
import com.didi.global.fintech.cashier.model.net.request.CashierAction;

/* renamed from: com.yanzhenjie.permission.checker.n */
/* compiled from: SipTest */
class C20702n implements PermissionTest {

    /* renamed from: a */
    private Context f56194a;

    C20702n(Context context) {
        this.f56194a = context;
    }

    /* renamed from: a */
    public boolean mo169065a() throws Throwable {
        SipManager newInstance;
        if (!SipManager.isApiSupported(this.f56194a) || (newInstance = SipManager.newInstance(this.f56194a)) == null) {
            return true;
        }
        SipProfile.Builder builder = new SipProfile.Builder("Permission", "127.0.0.1");
        builder.setPassword(CashierAction.ACTION_PASSWORD);
        SipProfile build = builder.build();
        newInstance.open(build);
        newInstance.close(build.getUriString());
        return true;
    }
}
