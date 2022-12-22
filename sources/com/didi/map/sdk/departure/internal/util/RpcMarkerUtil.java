package com.didi.map.sdk.departure.internal.util;

import android.text.TextUtils;
import com.sdk.poibase.model.RpcPoi;

public class RpcMarkerUtil {
    public static boolean isExistDepartureInfo(RpcPoi rpcPoi) {
        return (rpcPoi == null || rpcPoi.extend_info == null || (TextUtils.isEmpty(rpcPoi.extend_info.bubbleDesc) && TextUtils.isEmpty(rpcPoi.extend_info.mainTitleDesc) && TextUtils.isEmpty(rpcPoi.extend_info.subTitleDesc))) ? false : true;
    }
}
