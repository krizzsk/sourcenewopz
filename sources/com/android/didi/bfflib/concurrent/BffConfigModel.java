package com.android.didi.bfflib.concurrent;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

public class BffConfigModel {
    public List<String> interfaces;

    public void parseDate(String str) {
        JSONArray jSONArray;
        if (!TextUtils.isEmpty(str)) {
            try {
                jSONArray = new JSONArray(str);
            } catch (JSONException e) {
                e.printStackTrace();
                jSONArray = new JSONArray();
            }
            if (jSONArray.length() > 0) {
                this.interfaces = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    this.interfaces.add(jSONArray.optString(i));
                }
            }
        }
    }
}
