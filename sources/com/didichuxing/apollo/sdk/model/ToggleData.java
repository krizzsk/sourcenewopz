package com.didichuxing.apollo.sdk.model;

import com.didichuxing.apollo.sdk.IToggle;
import java.util.Map;

public class ToggleData {
    public String key = "";
    public Map<String, IToggle> toggleMap;

    public ToggleData(String str, Map<String, IToggle> map) {
        this.key = str;
        this.toggleMap = map;
    }
}
