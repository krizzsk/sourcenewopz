package com.didi.soda.customer;

import android.net.Uri;
import com.didi.soda.address.util.AddressUtil;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.rpc.entity.address.HomeAddressEntity;
import com.didi.soda.customer.foundation.util.GsonUtil;

public class CustomerFragmentB extends CustomerFragment {
    /* access modifiers changed from: protected */
    public boolean isDirectOpen() {
        boolean z;
        if (getArguments() == null) {
            return super.isDirectOpen();
        }
        boolean equals = "1".equals(getArguments().getString(Const.SABusiness.KEY_DIRECT_OPEN));
        try {
            HomeAddressEntity homeAddressEntity = (HomeAddressEntity) GsonUtil.fromJson(Uri.decode(getArguments().getString("addressInfo")), HomeAddressEntity.class);
            if (homeAddressEntity != null && AddressUtil.checkAddressValid(homeAddressEntity.address)) {
                z = true;
                if (equals || !z) {
                    return false;
                }
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        z = false;
        if (equals) {
        }
        return false;
    }

    public void onBackToHome() {
        super.onBackToHome();
    }
}
