package com.didi.addressold.view.enhance;

import android.view.View;
import com.sdk.poibase.model.RpcPoi;

public class AddressItemEnhancerImpl implements IAddressItemEnhancer {

    /* renamed from: a */
    private IAddressItemEnhancer f7969a;

    public AddressItemEnhancerImpl(IAddressItemEnhancer iAddressItemEnhancer) {
        this.f7969a = iAddressItemEnhancer;
    }

    public void enhance(View view, int i, RpcPoi rpcPoi) {
        IAddressItemEnhancer iAddressItemEnhancer = this.f7969a;
        if (iAddressItemEnhancer != null) {
            iAddressItemEnhancer.enhance(view, i, rpcPoi);
        }
    }
}
