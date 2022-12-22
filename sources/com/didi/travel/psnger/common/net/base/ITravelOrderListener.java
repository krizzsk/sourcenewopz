package com.didi.travel.psnger.common.net.base;

import com.didi.travel.psnger.core.model.response.ICarOrder;

public interface ITravelOrderListener {
    void onError(int i, String str);

    void onFail(int i, String str);

    void onSuccess(ICarOrder iCarOrder);

    void onTimeout(String str);
}
