package com.didi.addressnew.widget;

import com.sdk.poibase.model.RpcPoi;
import com.sdk.poibase.model.recsug.RpcRecSug;
import java.util.ArrayList;

public interface SubAddressViewApi {

    public interface OnItemClickListener {
        void onItemClick(RpcPoi rpcPoi, int i);
    }

    void fillData(RpcPoi rpcPoi, ArrayList<RpcPoi> arrayList, boolean z, RpcRecSug.TrackParameterForChild trackParameterForChild);

    void setOnItemClickLister(OnItemClickListener onItemClickListener);

    void setVisble(boolean z);
}
