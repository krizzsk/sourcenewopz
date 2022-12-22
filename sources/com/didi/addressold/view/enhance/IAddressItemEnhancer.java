package com.didi.addressold.view.enhance;

import android.view.View;
import com.sdk.poibase.model.RpcPoi;

public interface IAddressItemEnhancer {
    void enhance(View view, int i, RpcPoi rpcPoi);
}
