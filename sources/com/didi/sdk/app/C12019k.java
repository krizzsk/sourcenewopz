package com.didi.sdk.app;

import android.os.Bundle;
import com.didi.sdk.nation.NationComponentData;
import com.didi.sdk.nation.NationTypeUtil;
import com.didichuxing.swarm.toolkit.UserService;

/* renamed from: com.didi.sdk.app.k */
/* compiled from: UserServiceImpl */
class C12019k implements UserService {

    /* renamed from: a */
    private static String f35235a = "UserServiceImpl";

    C12019k() {
    }

    public Bundle getAuthData() {
        Bundle bundle = new Bundle();
        NationComponentData.LoginInfo loginInfo = NationTypeUtil.getNationComponentData().getLoginInfo();
        bundle.putString("phone", loginInfo.getPhone());
        bundle.putString("uid", loginInfo.getUid());
        bundle.putString("token", loginInfo.getToken());
        bundle.putString("phonecountrycode", loginInfo.getPhoneCountryCode());
        bundle.putString("kdtoken", loginInfo.getKDToken());
        return bundle;
    }
}
