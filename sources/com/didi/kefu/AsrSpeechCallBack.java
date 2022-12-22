package com.didi.kefu;

import org.json.JSONObject;

public interface AsrSpeechCallBack {
    void getPartialResults(String str);

    void voiceLocalFinish(JSONObject jSONObject);

    void voiceUploadFinish(JSONObject jSONObject);
}
