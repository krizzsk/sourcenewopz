package com.didi.global.globalgenerickit.config;

import androidx.fragment.app.FragmentActivity;
import org.json.JSONArray;
import org.json.JSONObject;

public interface IConfig {
    void show(FragmentActivity fragmentActivity, JSONArray jSONArray, GGKConfigCallbackAdapter gGKConfigCallbackAdapter);

    void show(FragmentActivity fragmentActivity, JSONObject jSONObject, GGKConfigCallbackAdapter gGKConfigCallbackAdapter);
}
