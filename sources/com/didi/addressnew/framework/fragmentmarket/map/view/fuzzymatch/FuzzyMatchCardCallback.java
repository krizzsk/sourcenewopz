package com.didi.addressnew.framework.fragmentmarket.map.view.fuzzymatch;

import com.sdk.poibase.model.RpcPoi;
import com.sdk.poibase.model.recsug.RpcRecSug;

public interface FuzzyMatchCardCallback {
    void onConfirmAddress(RpcPoi rpcPoi, RpcRecSug.TrackParameterForChild trackParameterForChild);

    void onSelectAddress(RpcPoi rpcPoi, RpcRecSug.TrackParameterForChild trackParameterForChild, int i, int i2);
}
