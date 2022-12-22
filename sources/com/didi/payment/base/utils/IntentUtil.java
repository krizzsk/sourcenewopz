package com.didi.payment.base.utils;

import android.content.Intent;
import android.os.Bundle;
import java.util.HashMap;
import java.util.Map;

public class IntentUtil {
    public static Map<String, Object> getIntent(Intent intent) {
        HashMap hashMap = null;
        if (!(intent == null || intent.getExtras() == null)) {
            Bundle extras = intent.getExtras();
            for (String str : extras.keySet()) {
                if (hashMap == null) {
                    hashMap = new HashMap();
                }
                hashMap.put(str, extras.get(str));
            }
        }
        return hashMap;
    }
}
