package com.didi.sdk.watcher;

import java.util.Map;

public interface ActionListener {
    void onAction(String str, Map<String, String> map);
}
