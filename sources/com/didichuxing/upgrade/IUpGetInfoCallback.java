package com.didichuxing.upgrade;

import com.didichuxing.bean.UpdateResponse;

public interface IUpGetInfoCallback {
    void onRequestFailed(int i);

    void onRequestSuccess(UpdateResponse updateResponse);
}
