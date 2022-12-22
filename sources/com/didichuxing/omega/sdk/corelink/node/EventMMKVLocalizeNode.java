package com.didichuxing.omega.sdk.corelink.node;

import com.didichuxing.omega.sdk.analysis.Security;
import com.didichuxing.omega.sdk.common.record.Event;
import com.tencent.mmkv.MMKV;

public class EventMMKVLocalizeNode {
    private static MMKV mmkv;

    static void create(String str) {
        mmkv = MMKV.mmkvWithID(str, EventRecordPathNode.getRecordDataPath());
    }

    static void save(Event event) {
        mmkv.encode(String.valueOf(event.getSeq()), EventSecurityNode.encrypt(Security.getKey(), event.toJson()));
    }

    static void close() {
        mmkv.close();
        mmkv = null;
    }

    static boolean isValid() {
        return mmkv != null;
    }
}
