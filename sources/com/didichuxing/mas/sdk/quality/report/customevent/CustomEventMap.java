package com.didichuxing.mas.sdk.quality.report.customevent;

import android.text.TextUtils;
import com.didichuxing.mas.sdk.quality.report.customevent.CustomKeys;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class CustomEventMap {
    public static final String PUB_BIZ = "pub";
    private final Map<String, BizKeyInfo> bizPrefixMap = new HashMap();
    private final ConcurrentHashMap<String, CustomEvent> customEventMap = new ConcurrentHashMap<>();
    private int maxValueByteSize = 1024;

    static class BizKeyInfo {
        private final List<String> bizKeys = new CopyOnWriteArrayList();
        private int maxBizKeyNum = 10;

        public void addBizKey(String str) {
            if (this.bizKeys.size() < this.maxBizKeyNum && !this.bizKeys.contains(str)) {
                this.bizKeys.add(str);
            }
        }

        public void removeBizKey(String str) {
            this.bizKeys.remove(str);
        }

        public boolean isHasKey(String str) {
            return this.bizKeys.contains(str);
        }

        public BizKeyInfo(int i) {
            this.maxBizKeyNum = i;
        }

        public BizKeyInfo() {
        }
    }

    public CustomEventMap(CustomKeys customKeys, int i) {
        List<CustomKeys.CustomKey> keys;
        this.maxValueByteSize = i;
        if (customKeys != null && (keys = customKeys.getKeys()) != null) {
            for (CustomKeys.CustomKey next : keys) {
                if (next != null && !TextUtils.isEmpty(next.getKey())) {
                    this.bizPrefixMap.put(next.getKey(), new BizKeyInfo(next.getNum()));
                }
            }
        }
    }

    public ConcurrentHashMap<String, CustomEvent> getCustomEventMap() {
        return this.customEventMap;
    }

    private String generateBizKey(String str, String str2) {
        return (str + "_" + str2).trim();
    }

    public void addCustomEvent(String str, String str2, String str3, boolean z) {
        int i;
        if (this.bizPrefixMap.containsKey(str) && str2 != null) {
            BizKeyInfo bizKeyInfo = this.bizPrefixMap.get(str);
            String generateBizKey = generateBizKey(str, str2);
            if (str3 != null && str3.getBytes().length > (i = this.maxValueByteSize)) {
                str3 = str3.substring(0, i);
            }
            CustomEvent customEvent = this.customEventMap.get(generateBizKey);
            if (customEvent != null) {
                if (z) {
                    customEvent.addValue(str3);
                } else {
                    customEvent.setValue(str3);
                }
            }
            if (!bizKeyInfo.isHasKey(generateBizKey)) {
                bizKeyInfo.addBizKey(generateBizKey);
                this.customEventMap.put(generateBizKey, new CustomEvent(generateBizKey, str3));
            }
        }
    }

    public void removeCustomEvent(String str, String str2) {
        BizKeyInfo bizKeyInfo;
        String generateBizKey = generateBizKey(str, str2);
        if (this.bizPrefixMap.containsKey(str) && this.customEventMap.containsKey(generateBizKey) && (bizKeyInfo = this.bizPrefixMap.get(str)) != null) {
            bizKeyInfo.removeBizKey(generateBizKey);
            this.customEventMap.remove(generateBizKey);
        }
    }
}
