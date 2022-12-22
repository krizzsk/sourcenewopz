package com.didi.commoninterfacelib.web;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import java.util.HashMap;
import org.json.JSONObject;

public interface IPlatformWebPageProxy {

    public interface JsExeCallBack {
        void callback(String str, JSONObject jSONObject);
    }

    HashMap<String, JsExeCallBack> getJsFunctions();

    void onActivityResult(int i, int i2, Intent intent);

    void onAttach(Activity activity);

    void onCreate(Bundle bundle);

    void onDestroy();

    void onFinish();

    void onPause();

    void onReStart();

    void onResume();

    void onSaveInstanceState(Bundle bundle);

    void onStart();

    void onStop();
}
