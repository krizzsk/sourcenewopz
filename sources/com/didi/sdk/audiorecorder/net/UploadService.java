package com.didi.sdk.audiorecorder.net;

import com.didi.sdk.audiorecorder.model.UploadResponse;
import java.util.Map;

public interface UploadService {

    public interface Callback {
        void onFailed();

        void onSuccess(UploadResponse uploadResponse);
    }

    void post(String str, Map<String, Object> map, Callback callback);
}
