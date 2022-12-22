package com.didi.addressnew.view.enhance;

import android.view.View;
import com.sdk.poibase.model.RpcPoi;

public class CommonItemEnhancer extends AddressItemEnhancerImpl {
    public CommonItemEnhancer(IAddressItemEnhancer iAddressItemEnhancer) {
        super(iAddressItemEnhancer);
        if (iAddressItemEnhancer != null && (iAddressItemEnhancer instanceof SugRecItemEnhancer)) {
            ((SugRecItemEnhancer) iAddressItemEnhancer).setSugSwitch(true);
        }
    }

    public void enhance(View view, int i, RpcPoi rpcPoi) {
        super.enhance(view, i, rpcPoi);
    }
}
