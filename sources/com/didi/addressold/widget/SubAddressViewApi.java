package com.didi.addressold.widget;

import com.sdk.poibase.model.RpcPoi;
import java.util.ArrayList;

public interface SubAddressViewApi {

    public interface OnItemClickListener {
        void onItemClick(RpcPoi rpcPoi, int i);
    }

    void fillData(ArrayList<RpcPoi> arrayList);

    void setOnItemClickLister(OnItemClickListener onItemClickListener);
}
