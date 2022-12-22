package com.didi.foundation.sdk.swarm;

import android.os.Bundle;
import com.didi.foundation.sdk.service.AccountService;
import com.didichuxing.swarm.toolkit.UserService;

/* renamed from: com.didi.foundation.sdk.swarm.i */
/* compiled from: UserServiceImpl */
final class C8401i implements UserService {
    C8401i() {
    }

    public Bundle getAuthData() {
        Bundle bundle = new Bundle();
        bundle.putString("phone", AccountService.getInstance().getPhone());
        bundle.putString("uid", AccountService.getInstance().getUid());
        bundle.putString("token", AccountService.getInstance().getToken());
        bundle.putString("city_id", AccountService.getInstance().getCityId());
        bundle.putString("phonecountrycode", AccountService.getInstance().getCountryCode());
        bundle.putString("a3token", "");
        return bundle;
    }
}
