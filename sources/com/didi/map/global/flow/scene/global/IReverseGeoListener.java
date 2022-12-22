package com.didi.map.global.flow.scene.global;

import com.sdk.poibase.model.reverse.ReverseGeoResult;
import java.io.IOException;

public interface IReverseGeoListener {
    void onFail(IOException iOException);

    void onSuccess(ReverseGeoResult reverseGeoResult);
}
