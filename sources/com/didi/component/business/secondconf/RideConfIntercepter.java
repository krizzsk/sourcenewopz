package com.didi.component.business.secondconf;

import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.util.GlobalApolloUtils;
import com.didichuxing.bigdata.p173dp.locsdk.EvilTransform;

public class RideConfIntercepter {

    /* renamed from: a */
    private Address f11338a;

    /* renamed from: b */
    private int f11339b = ((Integer) GlobalApolloUtils.getParamByStatus("refresh_product_conf_distance_filter", "rideMenu", 200, true)).intValue();

    public boolean interceptAddress(Address address) {
        if (address == null) {
            return false;
        }
        Address address2 = this.f11338a;
        if (address2 == null) {
            this.f11338a = address;
        } else if (EvilTransform.calcdistance(address2.longitude, this.f11338a.latitude, address.longitude, address.latitude) > ((double) this.f11339b)) {
            this.f11338a = address;
            return true;
        } else if (this.f11338a.cityId != address.cityId) {
            this.f11338a = address;
            return true;
        }
        return false;
    }
}
