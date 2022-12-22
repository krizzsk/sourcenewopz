package com.didi.addressnew.framework.fragmentmarket.map.fuzzymatch;

import com.sdk.poibase.model.RpcPoi;
import java.util.ArrayList;

public interface FuzzyMatchOperationCallback {
    void onDateLoading();

    void onSelectAddress(RpcPoi rpcPoi, boolean z, boolean z2);

    void onShowAllAddress(ArrayList<RpcPoi> arrayList);
}
