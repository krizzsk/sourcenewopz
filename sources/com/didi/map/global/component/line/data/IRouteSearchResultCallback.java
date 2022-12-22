package com.didi.map.global.component.line.data;

import com.didi.map.global.component.line.data.param.LineDataResponse;

public interface IRouteSearchResultCallback {
    void onGetRouteResult(LineDataResponse lineDataResponse);

    void onGetRouteResultError(String str);
}
