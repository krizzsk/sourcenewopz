package com.didi.map.global.component.line.data.route;

import android.content.Context;
import com.didi.map.global.component.line.data.IRouteSearchResultCallback;
import com.didi.map.global.component.line.data.param.BaseLineRequest;

public interface IRoute<T extends BaseLineRequest> {
    void create(Context context);

    void destroy();

    void start(T t, IRouteSearchResultCallback iRouteSearchResultCallback);
}
