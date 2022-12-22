package com.didiglobal.xbanner;

import com.google.gson.JsonObject;

public interface XBannerCallback {
    void onFail(Exception exc);

    void onSuccess(JsonObject jsonObject);
}
