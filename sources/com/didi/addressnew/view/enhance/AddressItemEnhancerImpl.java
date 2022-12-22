package com.didi.addressnew.view.enhance;

import android.view.View;
import com.sdk.poibase.model.RpcPoi;

public class AddressItemEnhancerImpl implements IAddressItemEnhancer {

    /* renamed from: a */
    private IAddressItemEnhancer f7589a;

    public AddressItemEnhancerImpl(IAddressItemEnhancer iAddressItemEnhancer) {
        this.f7589a = iAddressItemEnhancer;
    }

    public void enhance(View view, int i, RpcPoi rpcPoi) {
        IAddressItemEnhancer iAddressItemEnhancer = this.f7589a;
        if (iAddressItemEnhancer != null) {
            iAddressItemEnhancer.enhance(view, i, rpcPoi);
        }
    }
}
