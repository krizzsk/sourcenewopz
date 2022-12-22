package com.didi.addressnew.view.enhance;

import android.view.View;
import com.sdk.poibase.model.RpcPoi;

public class StartItemEnhancer extends AddressItemEnhancerImpl {
    public StartItemEnhancer(IAddressItemEnhancer iAddressItemEnhancer) {
        super(iAddressItemEnhancer);
        if (iAddressItemEnhancer != null && (iAddressItemEnhancer instanceof SugRecItemEnhancer)) {
            SugRecItemEnhancer sugRecItemEnhancer = (SugRecItemEnhancer) iAddressItemEnhancer;
            sugRecItemEnhancer.setRecSwitch(true);
            sugRecItemEnhancer.setSugSwitch(true);
        }
    }

    public void enhance(View view, int i, RpcPoi rpcPoi) {
        super.enhance(view, i, rpcPoi);
    }
}
